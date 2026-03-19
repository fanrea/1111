package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class Recycler<T> {
    private static final int DEFAULT_INITIAL_MAX_CAPACITY = 262144;
    private static final int DEFAULT_MAX_CAPACITY;
    private static final FastThreadLocal<Map<Stack<?>, WeakOrderQueue>> DELAYED_RECYCLED;
    private static final AtomicInteger ID_GENERATOR;
    private static final int INITIAL_CAPACITY;
    private static final int OWN_THREAD_ID;
    private final int maxCapacity;
    private final FastThreadLocal<Stack<T>> threadLocal;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Recycler.class);
    private static final Handle NOOP_HANDLE = new Handle() { // from class: io.netty.util.Recycler.1
        @Override // io.netty.util.Recycler.Handle
        public final void recycle(Object obj) {
        }
    };

    public interface Handle<T> {
        void recycle(T t);
    }

    protected abstract T newObject(Handle<T> handle);

    static {
        AtomicInteger atomicInteger = new AtomicInteger(Integer.MIN_VALUE);
        ID_GENERATOR = atomicInteger;
        OWN_THREAD_ID = atomicInteger.getAndIncrement();
        int i = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 262144);
        DEFAULT_MAX_CAPACITY = i > 0 ? i : 262144;
        if (logger.isDebugEnabled()) {
            int i2 = DEFAULT_MAX_CAPACITY;
            if (i2 == 0) {
                logger.debug("-Dio.netty.recycler.maxCapacity.maxCapacity: disabled");
            } else {
                logger.debug("-Dio.netty.recycler.maxCapacity.maxCapacity: {}", Integer.valueOf(i2));
            }
        }
        INITIAL_CAPACITY = Math.min(DEFAULT_MAX_CAPACITY, 256);
        DELAYED_RECYCLED = new FastThreadLocal<Map<Stack<?>, WeakOrderQueue>>() { // from class: io.netty.util.Recycler.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public final Map<Stack<?>, WeakOrderQueue> initialValue() {
                return new WeakHashMap();
            }
        };
    }

    protected Recycler() {
        this(DEFAULT_MAX_CAPACITY);
    }

    protected Recycler(int i) {
        this.threadLocal = new FastThreadLocal<Stack<T>>() { // from class: io.netty.util.Recycler.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public Stack<T> initialValue() {
                return new Stack<>(Recycler.this, Thread.currentThread(), Recycler.this.maxCapacity);
            }
        };
        this.maxCapacity = Math.max(0, i);
    }

    public final T get() {
        if (this.maxCapacity == 0) {
            return newObject(NOOP_HANDLE);
        }
        Stack<T> stack = this.threadLocal.get();
        DefaultHandle<T> defaultHandlePop = stack.pop();
        if (defaultHandlePop == null) {
            defaultHandlePop = stack.newHandle();
            ((DefaultHandle) defaultHandlePop).value = newObject(defaultHandlePop);
        }
        return (T) ((DefaultHandle) defaultHandlePop).value;
    }

    public final boolean recycle(T t, Handle<T> handle) {
        if (handle == NOOP_HANDLE) {
            return false;
        }
        DefaultHandle defaultHandle = (DefaultHandle) handle;
        if (defaultHandle.stack.parent != this) {
            return false;
        }
        defaultHandle.recycle(t);
        return true;
    }

    final int threadLocalCapacity() {
        return ((Stack) this.threadLocal.get()).elements.length;
    }

    final int threadLocalSize() {
        return ((Stack) this.threadLocal.get()).size;
    }

    static final class DefaultHandle<T> implements Handle<T> {
        private int lastRecycledId;
        private int recycleId;
        private Stack<?> stack;
        private Object value;

        DefaultHandle(Stack<?> stack) {
            this.stack = stack;
        }

        @Override // io.netty.util.Recycler.Handle
        public final void recycle(Object obj) {
            if (obj != this.value) {
                throw new IllegalArgumentException("object does not belong to handle");
            }
            Thread threadCurrentThread = Thread.currentThread();
            if (threadCurrentThread != this.stack.thread) {
                Map map = (Map) Recycler.DELAYED_RECYCLED.get();
                WeakOrderQueue weakOrderQueue = (WeakOrderQueue) map.get(this.stack);
                if (weakOrderQueue == null) {
                    Stack<?> stack = this.stack;
                    WeakOrderQueue weakOrderQueue2 = new WeakOrderQueue(stack, threadCurrentThread);
                    map.put(stack, weakOrderQueue2);
                    weakOrderQueue = weakOrderQueue2;
                }
                weakOrderQueue.add(this);
                return;
            }
            this.stack.push(this);
        }
    }

    static final class WeakOrderQueue {
        private static final int LINK_CAPACITY = 16;
        private Link head;
        private final int id = Recycler.ID_GENERATOR.getAndIncrement();
        private WeakOrderQueue next;
        private final WeakReference<Thread> owner;
        private Link tail;

        static final class Link extends AtomicInteger {
            private final DefaultHandle<?>[] elements;
            private Link next;
            private int readIndex;

            private Link() {
                this.elements = new DefaultHandle[16];
            }
        }

        WeakOrderQueue(Stack<?> stack, Thread thread) {
            Link link = new Link();
            this.tail = link;
            this.head = link;
            this.owner = new WeakReference<>(thread);
            synchronized (stack) {
                this.next = ((Stack) stack).head;
                ((Stack) stack).head = this;
            }
        }

        final void add(DefaultHandle<?> defaultHandle) {
            ((DefaultHandle) defaultHandle).lastRecycledId = this.id;
            Link link = this.tail;
            int i = link.get();
            if (i == 16) {
                link = link.next = new Link();
                this.tail = link;
                i = link.get();
            }
            link.elements[i] = defaultHandle;
            ((DefaultHandle) defaultHandle).stack = null;
            link.lazySet(i + 1);
        }

        final boolean hasFinalData() {
            return this.tail.readIndex != this.tail.get();
        }

        final boolean transfer(Stack<?> stack) {
            Link link = this.head;
            if (link == null) {
                return false;
            }
            if (link.readIndex == 16) {
                if (link.next == null) {
                    return false;
                }
                link = link.next;
                this.head = link;
            }
            int i = link.readIndex;
            int iMin = link.get();
            int i2 = iMin - i;
            if (i2 == 0) {
                return false;
            }
            int i3 = ((Stack) stack).size;
            int i4 = i2 + i3;
            if (i4 > ((Stack) stack).elements.length) {
                iMin = Math.min((stack.increaseCapacity(i4) + i) - i3, iMin);
            }
            if (i == iMin) {
                return false;
            }
            DefaultHandle[] defaultHandleArr = link.elements;
            DefaultHandle[] defaultHandleArr2 = ((Stack) stack).elements;
            while (i < iMin) {
                DefaultHandle defaultHandle = defaultHandleArr[i];
                if (defaultHandle.recycleId == 0) {
                    defaultHandle.recycleId = defaultHandle.lastRecycledId;
                } else if (defaultHandle.recycleId != defaultHandle.lastRecycledId) {
                    throw new IllegalStateException("recycled already");
                }
                defaultHandle.stack = stack;
                defaultHandleArr2[i3] = defaultHandle;
                defaultHandleArr[i] = null;
                i++;
                i3++;
            }
            ((Stack) stack).size = i3;
            if (iMin == 16 && link.next != null) {
                this.head = link.next;
            }
            link.readIndex = iMin;
            return true;
        }
    }

    static final class Stack<T> {
        private WeakOrderQueue cursor;
        private DefaultHandle<?>[] elements;
        private volatile WeakOrderQueue head;
        private final int maxCapacity;
        final Recycler<T> parent;
        private WeakOrderQueue prev;
        private int size;
        final Thread thread;

        Stack(Recycler<T> recycler, Thread thread, int i) {
            this.parent = recycler;
            this.thread = thread;
            this.maxCapacity = i;
            this.elements = new DefaultHandle[Math.min(Recycler.INITIAL_CAPACITY, i)];
        }

        final int increaseCapacity(int i) {
            int length = this.elements.length;
            int i2 = this.maxCapacity;
            do {
                length <<= 1;
                if (length >= i) {
                    break;
                }
            } while (length < i2);
            int iMin = Math.min(length, i2);
            DefaultHandle<?>[] defaultHandleArr = this.elements;
            if (iMin != defaultHandleArr.length) {
                this.elements = (DefaultHandle[]) Arrays.copyOf(defaultHandleArr, iMin);
            }
            return iMin;
        }

        final DefaultHandle<T> pop() {
            int i = this.size;
            if (i == 0) {
                if (!scavenge()) {
                    return null;
                }
                i = this.size;
            }
            int i2 = i - 1;
            DefaultHandle<T> defaultHandle = (DefaultHandle<T>) this.elements[i2];
            if (((DefaultHandle) defaultHandle).lastRecycledId == ((DefaultHandle) defaultHandle).recycleId) {
                ((DefaultHandle) defaultHandle).recycleId = 0;
                ((DefaultHandle) defaultHandle).lastRecycledId = 0;
                this.size = i2;
                return defaultHandle;
            }
            throw new IllegalStateException("recycled multiple times");
        }

        final boolean scavenge() {
            if (scavengeSome()) {
                return true;
            }
            this.prev = null;
            this.cursor = this.head;
            return false;
        }

        final boolean scavengeSome() {
            WeakOrderQueue weakOrderQueue = this.cursor;
            boolean z = false;
            if (weakOrderQueue == null && (weakOrderQueue = this.head) == null) {
                return false;
            }
            WeakOrderQueue weakOrderQueue2 = this.prev;
            while (!weakOrderQueue.transfer(this)) {
                WeakOrderQueue weakOrderQueue3 = weakOrderQueue.next;
                if (weakOrderQueue.owner.get() == null) {
                    if (weakOrderQueue.hasFinalData()) {
                        while (weakOrderQueue.transfer(this)) {
                            z = true;
                        }
                    }
                    if (weakOrderQueue2 != null) {
                        weakOrderQueue2.next = weakOrderQueue3;
                    }
                } else {
                    weakOrderQueue2 = weakOrderQueue;
                }
                if (weakOrderQueue3 == null || z) {
                    weakOrderQueue = weakOrderQueue3;
                    break;
                }
                weakOrderQueue = weakOrderQueue3;
            }
            z = true;
            this.prev = weakOrderQueue2;
            this.cursor = weakOrderQueue;
            return z;
        }

        final void push(DefaultHandle<?> defaultHandle) {
            if ((((DefaultHandle) defaultHandle).recycleId | ((DefaultHandle) defaultHandle).lastRecycledId) == 0) {
                ((DefaultHandle) defaultHandle).recycleId = ((DefaultHandle) defaultHandle).lastRecycledId = Recycler.OWN_THREAD_ID;
                int i = this.size;
                int i2 = this.maxCapacity;
                if (i >= i2) {
                    return;
                }
                DefaultHandle<?>[] defaultHandleArr = this.elements;
                if (i == defaultHandleArr.length) {
                    this.elements = (DefaultHandle[]) Arrays.copyOf(defaultHandleArr, Math.min(i << 1, i2));
                }
                this.elements[i] = defaultHandle;
                this.size = i + 1;
                return;
            }
            throw new IllegalStateException("recycled already");
        }

        final DefaultHandle<T> newHandle() {
            return new DefaultHandle<>(this);
        }
    }
}
