package io.netty.util.concurrent;

import io.netty.util.internal.StringUtil;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolId = new AtomicInteger();
    private final boolean daemon;
    private final AtomicInteger nextId;
    private final String prefix;
    private final int priority;

    public DefaultThreadFactory(Class<?> cls) {
        this(cls, false, 5);
    }

    public DefaultThreadFactory(String str) {
        this(str, false, 5);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z) {
        this(cls, z, 5);
    }

    public DefaultThreadFactory(String str, boolean z) {
        this(str, z, 5);
    }

    public DefaultThreadFactory(Class<?> cls, int i) {
        this(cls, false, i);
    }

    public DefaultThreadFactory(String str, int i) {
        this(str, false, i);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z, int i) {
        this(toPoolName(cls), z, i);
    }

    private static String toPoolName(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException("poolType");
        }
        String strSimpleClassName = StringUtil.simpleClassName(cls);
        int length = strSimpleClassName.length();
        if (length == 0) {
            return "unknown";
        }
        if (length == 1) {
            return strSimpleClassName.toLowerCase(Locale.US);
        }
        if (!Character.isUpperCase(strSimpleClassName.charAt(0)) || !Character.isLowerCase(strSimpleClassName.charAt(1))) {
            return strSimpleClassName;
        }
        return Character.toLowerCase(strSimpleClassName.charAt(0)) + strSimpleClassName.substring(1);
    }

    public DefaultThreadFactory(String str, boolean z, int i) {
        this.nextId = new AtomicInteger();
        if (str == null) {
            throw new NullPointerException("poolName");
        }
        if (i <= 0 || i > 10) {
            throw new IllegalArgumentException("priority: " + i + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
        }
        this.prefix = str + SignatureImpl.SEP + poolId.incrementAndGet() + SignatureImpl.SEP;
        this.daemon = z;
        this.priority = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = newThread(new DefaultRunnableDecorator(runnable), this.prefix + this.nextId.incrementAndGet());
        try {
            if (threadNewThread.isDaemon()) {
                if (!this.daemon) {
                    threadNewThread.setDaemon(false);
                }
            } else if (this.daemon) {
                threadNewThread.setDaemon(true);
            }
            if (threadNewThread.getPriority() != this.priority) {
                threadNewThread.setPriority(this.priority);
            }
        } catch (Exception unused) {
        }
        return threadNewThread;
    }

    protected Thread newThread(Runnable runnable, String str) {
        return new FastThreadLocalThread(runnable, str);
    }

    static final class DefaultRunnableDecorator implements Runnable {
        private final Runnable r;

        DefaultRunnableDecorator(Runnable runnable) {
            this.r = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.r.run();
            } finally {
                FastThreadLocal.removeAll();
            }
        }
    }
}
