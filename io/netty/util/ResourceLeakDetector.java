package io.netty.util;

import androidx.core.location.LocationRequestCompat;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ResourceLeakDetector<T> {
    private static final int DEFAULT_MAX_RECORDS = 4;
    private static final int DEFAULT_SAMPLING_INTERVAL = 128;
    private static final int MAX_RECORDS;
    private static final String PROP_LEVEL = "io.netty.leakDetection.level";
    private static final String PROP_LEVEL_OLD = "io.netty.leakDetectionLevel";
    private static final String PROP_MAX_RECORDS = "io.netty.leakDetection.maxRecords";
    private static final String[] STACK_TRACE_ELEMENT_EXCLUSIONS;
    private static Level level;
    private long active;
    private final ResourceLeakDetector<T>.DefaultResourceLeak head;
    private long leakCheckCnt;
    private final AtomicBoolean loggedTooManyActive;
    private final int mask;
    private final long maxActive;
    private final ReferenceQueue<Object> refQueue;
    private final ConcurrentMap<String, Boolean> reportedLeaks;
    private final String resourceType;
    private final int samplingInterval;
    private final ResourceLeakDetector<T>.DefaultResourceLeak tail;
    private static final Level DEFAULT_LEVEL = Level.SIMPLE;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ResourceLeakDetector.class);

    public enum Level {
        DISABLED,
        SIMPLE,
        ADVANCED,
        PARANOID
    }

    static /* synthetic */ long access$408(ResourceLeakDetector resourceLeakDetector) {
        long j = resourceLeakDetector.active;
        resourceLeakDetector.active = 1 + j;
        return j;
    }

    static /* synthetic */ long access$410(ResourceLeakDetector resourceLeakDetector) {
        long j = resourceLeakDetector.active;
        resourceLeakDetector.active = j - 1;
        return j;
    }

    static {
        boolean z;
        if (SystemPropertyUtil.get("io.netty.noResourceLeakDetection") != null) {
            z = SystemPropertyUtil.getBoolean("io.netty.noResourceLeakDetection", false);
            logger.debug("-Dio.netty.noResourceLeakDetection: {}", Boolean.valueOf(z));
            logger.warn("-Dio.netty.noResourceLeakDetection is deprecated. Use '-D{}={}' instead.", PROP_LEVEL, DEFAULT_LEVEL.name().toLowerCase());
        } else {
            z = false;
        }
        String upperCase = SystemPropertyUtil.get(PROP_LEVEL, SystemPropertyUtil.get(PROP_LEVEL_OLD, (z ? Level.DISABLED : DEFAULT_LEVEL).name()).trim().toUpperCase()).trim().toUpperCase();
        Level level2 = DEFAULT_LEVEL;
        Iterator it = EnumSet.allOf(Level.class).iterator();
        while (it.hasNext()) {
            Level level3 = (Level) it.next();
            if (upperCase.equals(level3.name()) || upperCase.equals(String.valueOf(level3.ordinal()))) {
                level2 = level3;
            }
        }
        MAX_RECORDS = SystemPropertyUtil.getInt(PROP_MAX_RECORDS, 4);
        level = level2;
        if (logger.isDebugEnabled()) {
            logger.debug("-D{}: {}", PROP_LEVEL, level2.name().toLowerCase());
            logger.debug("-D{}: {}", PROP_MAX_RECORDS, Integer.valueOf(MAX_RECORDS));
        }
        STACK_TRACE_ELEMENT_EXCLUSIONS = new String[]{"io.netty.util.ReferenceCountUtil.touch(", "io.netty.buffer.AdvancedLeakAwareByteBuf.touch(", "io.netty.buffer.AbstractByteBufAllocator.toLeakAwareBuffer(", "io.netty.buffer.AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation("};
    }

    @Deprecated
    public static void setEnabled(boolean z) {
        setLevel(z ? Level.SIMPLE : Level.DISABLED);
    }

    public static boolean isEnabled() {
        return getLevel().ordinal() > Level.DISABLED.ordinal();
    }

    public static void setLevel(Level level2) {
        if (level2 == null) {
            throw new NullPointerException("level");
        }
        level = level2;
    }

    public static Level getLevel() {
        return level;
    }

    public ResourceLeakDetector(Class<?> cls) {
        this(StringUtil.simpleClassName(cls));
    }

    public ResourceLeakDetector(String str) {
        this(str, 128, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public ResourceLeakDetector(Class<?> cls, int i, long j) {
        this(StringUtil.simpleClassName(cls), i, j);
    }

    public ResourceLeakDetector(String str, int i, long j) {
        this.head = new DefaultResourceLeak(null);
        this.tail = new DefaultResourceLeak(null);
        this.refQueue = new ReferenceQueue<>();
        this.reportedLeaks = PlatformDependent.newConcurrentHashMap();
        this.loggedTooManyActive = new AtomicBoolean();
        if (str == null) {
            throw new NullPointerException("resourceType");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("samplingInterval: " + i + " (expected: 1+)");
        }
        if (j <= 0) {
            throw new IllegalArgumentException("maxActive: " + j + " (expected: 1+)");
        }
        this.resourceType = str;
        this.samplingInterval = MathUtil.findNextPositivePowerOfTwo(i);
        this.mask = this.samplingInterval - 1;
        this.maxActive = j;
        ((DefaultResourceLeak) this.head).next = this.tail;
        ((DefaultResourceLeak) this.tail).prev = this.head;
    }

    public final ResourceLeak open(T t) {
        Level level2 = level;
        if (level2 == Level.DISABLED) {
            return null;
        }
        if (level2.ordinal() < Level.PARANOID.ordinal()) {
            long j = this.leakCheckCnt;
            this.leakCheckCnt = 1 + j;
            if ((j & this.mask) != 0) {
                return null;
            }
            reportLeak(level2);
            return new DefaultResourceLeak(t);
        }
        reportLeak(level2);
        return new DefaultResourceLeak(t);
    }

    private void reportLeak(Level level2) {
        if (logger.isErrorEnabled()) {
            if (this.active * (level2 == Level.PARANOID ? 1 : this.samplingInterval) > this.maxActive && this.loggedTooManyActive.compareAndSet(false, true)) {
                logger.error("LEAK: You are creating too many " + this.resourceType + " instances.  " + this.resourceType + " is a shared resource that must be reused across the JVM,so that only a few instances are created.");
            }
            while (true) {
                DefaultResourceLeak defaultResourceLeak = (DefaultResourceLeak) this.refQueue.poll();
                if (defaultResourceLeak == null) {
                    return;
                }
                defaultResourceLeak.clear();
                if (defaultResourceLeak.close()) {
                    String string = defaultResourceLeak.toString();
                    if (this.reportedLeaks.putIfAbsent(string, Boolean.TRUE) == null) {
                        if (string.isEmpty()) {
                            logger.error("LEAK: {}.release() was not called before it's garbage-collected. Enable advanced leak reporting to find out where the leak occurred. To enable advanced leak reporting, specify the JVM option '-D{}={}' or call {}.setLevel() See http://netty.io/wiki/reference-counted-objects.html for more information.", this.resourceType, PROP_LEVEL, Level.ADVANCED.name().toLowerCase(), StringUtil.simpleClassName(this));
                        } else {
                            logger.error("LEAK: {}.release() was not called before it's garbage-collected. See http://netty.io/wiki/reference-counted-objects.html for more information.{}", this.resourceType, string);
                        }
                    }
                }
            }
        } else {
            while (true) {
                DefaultResourceLeak defaultResourceLeak2 = (DefaultResourceLeak) this.refQueue.poll();
                if (defaultResourceLeak2 == null) {
                    return;
                } else {
                    defaultResourceLeak2.close();
                }
            }
        }
    }

    final class DefaultResourceLeak extends PhantomReference<Object> implements ResourceLeak {
        private final String creationRecord;
        private final AtomicBoolean freed;
        private final Deque<String> lastRecords;
        private ResourceLeakDetector<T>.DefaultResourceLeak next;
        private ResourceLeakDetector<T>.DefaultResourceLeak prev;

        DefaultResourceLeak(Object obj) {
            super(obj, obj != null ? ResourceLeakDetector.this.refQueue : null);
            this.lastRecords = new ArrayDeque();
            if (obj != null) {
                if (ResourceLeakDetector.getLevel().ordinal() >= Level.ADVANCED.ordinal()) {
                    this.creationRecord = ResourceLeakDetector.newRecord(null, 3);
                } else {
                    this.creationRecord = null;
                }
                synchronized (ResourceLeakDetector.this.head) {
                    this.prev = ResourceLeakDetector.this.head;
                    this.next = ResourceLeakDetector.this.head.next;
                    ResourceLeakDetector.this.head.next.prev = this;
                    ResourceLeakDetector.this.head.next = this;
                    ResourceLeakDetector.access$408(ResourceLeakDetector.this);
                }
                this.freed = new AtomicBoolean();
                return;
            }
            this.creationRecord = null;
            this.freed = new AtomicBoolean(true);
        }

        @Override // io.netty.util.ResourceLeak
        public final void record() {
            record0(null, 3);
        }

        @Override // io.netty.util.ResourceLeak
        public final void record(Object obj) {
            record0(obj, 3);
        }

        private void record0(Object obj, int i) {
            if (this.creationRecord != null) {
                String strNewRecord = ResourceLeakDetector.newRecord(obj, i);
                synchronized (this.lastRecords) {
                    int size = this.lastRecords.size();
                    if (size == 0 || !this.lastRecords.getLast().equals(strNewRecord)) {
                        this.lastRecords.add(strNewRecord);
                    }
                    if (size > ResourceLeakDetector.MAX_RECORDS) {
                        this.lastRecords.removeFirst();
                    }
                }
            }
        }

        @Override // io.netty.util.ResourceLeak
        public final boolean close() {
            if (!this.freed.compareAndSet(false, true)) {
                return false;
            }
            synchronized (ResourceLeakDetector.this.head) {
                ResourceLeakDetector.access$410(ResourceLeakDetector.this);
                this.prev.next = this.next;
                this.next.prev = this.prev;
                this.prev = null;
                this.next = null;
            }
            return true;
        }

        public final String toString() {
            Object[] array;
            if (this.creationRecord == null) {
                return "";
            }
            synchronized (this.lastRecords) {
                array = this.lastRecords.toArray();
            }
            StringBuilder sb = new StringBuilder(16384);
            sb.append(StringUtil.NEWLINE);
            sb.append("Recent access records: ");
            sb.append(array.length);
            sb.append(StringUtil.NEWLINE);
            if (array.length > 0) {
                for (int length = array.length - 1; length >= 0; length--) {
                    sb.append('#');
                    sb.append(length + 1);
                    sb.append(':');
                    sb.append(StringUtil.NEWLINE);
                    sb.append(array[length]);
                }
            }
            sb.append("Created at:");
            sb.append(StringUtil.NEWLINE);
            sb.append(this.creationRecord);
            sb.setLength(sb.length() - StringUtil.NEWLINE.length());
            return sb.toString();
        }
    }

    static String newRecord(Object obj, int i) {
        boolean z;
        StringBuilder sb = new StringBuilder(4096);
        if (obj != null) {
            sb.append("\tHint: ");
            if (obj instanceof ResourceLeakHint) {
                sb.append(((ResourceLeakHint) obj).toHintString());
            } else {
                sb.append(obj);
            }
            sb.append(StringUtil.NEWLINE);
        }
        int i2 = i;
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            if (i2 > 0) {
                i2--;
            } else {
                String string = stackTraceElement.toString();
                String[] strArr = STACK_TRACE_ELEMENT_EXCLUSIONS;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    if (string.startsWith(strArr[i3])) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                if (!z) {
                    sb.append('\t');
                    sb.append(string);
                    sb.append(StringUtil.NEWLINE);
                }
            }
        }
        return sb.toString();
    }
}
