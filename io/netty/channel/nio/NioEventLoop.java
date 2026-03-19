package io.netty.channel.nio;

import io.netty.channel.ChannelException;
import io.netty.channel.EventLoopException;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class NioEventLoop extends SingleThreadEventLoop {
    private static final int CLEANUP_INTERVAL = 256;
    private static final int MIN_PREMATURE_SELECTOR_RETURNS = 3;
    private static final int SELECTOR_AUTO_REBUILD_THRESHOLD;
    private int cancelledKeys;
    private volatile int ioRatio;
    private boolean needsToSelectAgain;
    private final SelectorProvider provider;
    private SelectedSelectionKeySet selectedKeys;
    Selector selector;
    private final AtomicBoolean wakenUp;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NioEventLoop.class);
    private static final boolean DISABLE_KEYSET_OPTIMIZATION = SystemPropertyUtil.getBoolean("io.netty.noKeySetOptimization", false);

    static {
        try {
            if (SystemPropertyUtil.get("sun.nio.ch.bugLevel") == null) {
                System.setProperty("sun.nio.ch.bugLevel", "");
            }
        } catch (SecurityException e) {
            if (logger.isDebugEnabled()) {
                logger.debug("Unable to get/set System Property: {}", "sun.nio.ch.bugLevel", e);
            }
        }
        int i = SystemPropertyUtil.getInt("io.netty.selectorAutoRebuildThreshold", 512);
        SELECTOR_AUTO_REBUILD_THRESHOLD = i >= 3 ? i : 0;
        if (logger.isDebugEnabled()) {
            logger.debug("-Dio.netty.noKeySetOptimization: {}", Boolean.valueOf(DISABLE_KEYSET_OPTIMIZATION));
            logger.debug("-Dio.netty.selectorAutoRebuildThreshold: {}", Integer.valueOf(SELECTOR_AUTO_REBUILD_THRESHOLD));
        }
    }

    NioEventLoop(NioEventLoopGroup nioEventLoopGroup, Executor executor, SelectorProvider selectorProvider) {
        super((EventLoopGroup) nioEventLoopGroup, executor, false);
        this.wakenUp = new AtomicBoolean();
        this.ioRatio = 50;
        if (selectorProvider == null) {
            throw new NullPointerException("selectorProvider");
        }
        this.provider = selectorProvider;
        this.selector = openSelector();
    }

    private Selector openSelector() throws IOException {
        SelectedSelectionKeySet selectedSelectionKeySet;
        Class<?> cls;
        try {
            AbstractSelector abstractSelectorOpenSelector = this.provider.openSelector();
            if (DISABLE_KEYSET_OPTIMIZATION) {
                return abstractSelectorOpenSelector;
            }
            try {
                selectedSelectionKeySet = new SelectedSelectionKeySet();
                cls = Class.forName("sun.nio.ch.SelectorImpl", false, PlatformDependent.getSystemClassLoader());
            } catch (Throwable th) {
                this.selectedKeys = null;
                logger.trace("Failed to instrument an optimized java.util.Set into: {}", abstractSelectorOpenSelector, th);
            }
            if (!cls.isAssignableFrom(abstractSelectorOpenSelector.getClass())) {
                return abstractSelectorOpenSelector;
            }
            Field declaredField = cls.getDeclaredField("selectedKeys");
            Field declaredField2 = cls.getDeclaredField("publicSelectedKeys");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            declaredField.set(abstractSelectorOpenSelector, selectedSelectionKeySet);
            declaredField2.set(abstractSelectorOpenSelector, selectedSelectionKeySet);
            this.selectedKeys = selectedSelectionKeySet;
            logger.trace("Instrumented an optimized java.util.Set into: {}", abstractSelectorOpenSelector);
            return abstractSelectorOpenSelector;
        } catch (IOException e) {
            throw new ChannelException("failed to open a new selector", e);
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public final Queue<Runnable> newTaskQueue() {
        return PlatformDependent.newMpscQueue();
    }

    public final void register(SelectableChannel selectableChannel, int i, NioTask<?> nioTask) throws ClosedChannelException {
        if (selectableChannel == null) {
            throw new NullPointerException("ch");
        }
        if (i == 0) {
            throw new IllegalArgumentException("interestOps must be non-zero.");
        }
        if (((selectableChannel.validOps() ^ (-1)) & i) != 0) {
            throw new IllegalArgumentException("invalid interestOps: " + i + "(validOps: " + selectableChannel.validOps() + ')');
        }
        if (nioTask == null) {
            throw new NullPointerException("task");
        }
        if (isShutdown()) {
            throw new IllegalStateException("event loop shut down");
        }
        try {
            selectableChannel.register(this.selector, i, nioTask);
        } catch (Exception e) {
            throw new EventLoopException("failed to register a channel", e);
        }
    }

    public final int getIoRatio() {
        return this.ioRatio;
    }

    public final void setIoRatio(int i) {
        if (i <= 0 || i > 100) {
            throw new IllegalArgumentException("ioRatio: " + i + " (expected: 0 < ioRatio <= 100)");
        }
        this.ioRatio = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:?, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void rebuildSelector() {
        /*
            r9 = this;
            boolean r0 = r9.inEventLoop()
            if (r0 != 0) goto Lf
            io.netty.channel.nio.NioEventLoop$1 r0 = new io.netty.channel.nio.NioEventLoop$1
            r0.<init>()
            r9.execute(r0)
            return
        Lf:
            java.nio.channels.Selector r0 = r9.selector
            if (r0 != 0) goto L14
            return
        L14:
            java.nio.channels.Selector r1 = r9.openSelector()     // Catch: java.lang.Exception -> Lb0
            r2 = 0
        L19:
            java.util.Set r3 = r0.keys()     // Catch: java.util.ConcurrentModificationException -> L19
            java.util.Iterator r3 = r3.iterator()     // Catch: java.util.ConcurrentModificationException -> L19
        L21:
            boolean r4 = r3.hasNext()     // Catch: java.util.ConcurrentModificationException -> L19
            if (r4 == 0) goto L81
            java.lang.Object r4 = r3.next()     // Catch: java.util.ConcurrentModificationException -> L19
            java.nio.channels.SelectionKey r4 = (java.nio.channels.SelectionKey) r4     // Catch: java.util.ConcurrentModificationException -> L19
            java.lang.Object r5 = r4.attachment()     // Catch: java.util.ConcurrentModificationException -> L19
            boolean r6 = r4.isValid()     // Catch: java.util.ConcurrentModificationException -> L19 java.lang.Exception -> L5d
            if (r6 == 0) goto L21
            java.nio.channels.SelectableChannel r6 = r4.channel()     // Catch: java.util.ConcurrentModificationException -> L19 java.lang.Exception -> L5d
            java.nio.channels.SelectionKey r6 = r6.keyFor(r1)     // Catch: java.util.ConcurrentModificationException -> L19 java.lang.Exception -> L5d
            if (r6 == 0) goto L42
            goto L21
        L42:
            int r6 = r4.interestOps()     // Catch: java.util.ConcurrentModificationException -> L19 java.lang.Exception -> L5d
            r4.cancel()     // Catch: java.util.ConcurrentModificationException -> L19 java.lang.Exception -> L5d
            java.nio.channels.SelectableChannel r7 = r4.channel()     // Catch: java.util.ConcurrentModificationException -> L19 java.lang.Exception -> L5d
            java.nio.channels.SelectionKey r6 = r7.register(r1, r6, r5)     // Catch: java.util.ConcurrentModificationException -> L19 java.lang.Exception -> L5d
            boolean r7 = r5 instanceof io.netty.channel.nio.AbstractNioChannel     // Catch: java.util.ConcurrentModificationException -> L19 java.lang.Exception -> L5d
            if (r7 == 0) goto L5a
            r7 = r5
            io.netty.channel.nio.AbstractNioChannel r7 = (io.netty.channel.nio.AbstractNioChannel) r7     // Catch: java.util.ConcurrentModificationException -> L19 java.lang.Exception -> L5d
            r7.selectionKey = r6     // Catch: java.util.ConcurrentModificationException -> L19 java.lang.Exception -> L5d
        L5a:
            int r2 = r2 + 1
            goto L21
        L5d:
            r6 = move-exception
            io.netty.util.internal.logging.InternalLogger r7 = io.netty.channel.nio.NioEventLoop.logger     // Catch: java.util.ConcurrentModificationException -> L19
            java.lang.String r8 = "Failed to re-register a Channel to the new Selector."
            r7.warn(r8, r6)     // Catch: java.util.ConcurrentModificationException -> L19
            boolean r7 = r5 instanceof io.netty.channel.nio.AbstractNioChannel     // Catch: java.util.ConcurrentModificationException -> L19
            if (r7 == 0) goto L7b
            io.netty.channel.nio.AbstractNioChannel r5 = (io.netty.channel.nio.AbstractNioChannel) r5     // Catch: java.util.ConcurrentModificationException -> L19
            io.netty.channel.nio.AbstractNioChannel$NioUnsafe r4 = r5.unsafe()     // Catch: java.util.ConcurrentModificationException -> L19
            io.netty.channel.nio.AbstractNioChannel$NioUnsafe r5 = r5.unsafe()     // Catch: java.util.ConcurrentModificationException -> L19
            io.netty.channel.ChannelPromise r5 = r5.voidPromise()     // Catch: java.util.ConcurrentModificationException -> L19
            r4.close(r5)     // Catch: java.util.ConcurrentModificationException -> L19
            goto L21
        L7b:
            io.netty.channel.nio.NioTask r5 = (io.netty.channel.nio.NioTask) r5     // Catch: java.util.ConcurrentModificationException -> L19
            invokeChannelUnregistered(r5, r4, r6)     // Catch: java.util.ConcurrentModificationException -> L19
            goto L21
        L81:
            r9.selector = r1
            r0.close()     // Catch: java.lang.Throwable -> L87
            goto L97
        L87:
            r0 = move-exception
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.nio.NioEventLoop.logger
            boolean r1 = r1.isWarnEnabled()
            if (r1 == 0) goto L97
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.nio.NioEventLoop.logger
            java.lang.String r3 = "Failed to close the old Selector."
            r1.warn(r3, r0)
        L97:
            io.netty.util.internal.logging.InternalLogger r0 = io.netty.channel.nio.NioEventLoop.logger
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Migrated "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r2 = " channel(s) to the new Selector."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.info(r1)
            return
        Lb0:
            r0 = move-exception
            io.netty.util.internal.logging.InternalLogger r1 = io.netty.channel.nio.NioEventLoop.logger
            java.lang.String r2 = "Failed to create a new Selector."
            r1.warn(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.NioEventLoop.rebuildSelector():void");
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public final void run() throws InterruptedException {
        while (true) {
            boolean andSet = this.wakenUp.getAndSet(false);
            try {
                if (hasTasks()) {
                    selectNow();
                } else {
                    select(andSet);
                    if (this.wakenUp.get()) {
                        this.selector.wakeup();
                    }
                }
                this.cancelledKeys = 0;
                this.needsToSelectAgain = false;
                int i = this.ioRatio;
                if (i == 100) {
                    processSelectedKeys();
                    runAllTasks();
                } else {
                    long jNanoTime = System.nanoTime();
                    processSelectedKeys();
                    runAllTasks(((System.nanoTime() - jNanoTime) * (100 - i)) / i);
                }
                if (isShuttingDown()) {
                    closeAll();
                    if (confirmShutdown()) {
                        return;
                    }
                } else {
                    continue;
                }
            } catch (Throwable th) {
                logger.warn("Unexpected exception in the selector loop.", th);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private void processSelectedKeys() {
        SelectedSelectionKeySet selectedSelectionKeySet = this.selectedKeys;
        if (selectedSelectionKeySet != null) {
            processSelectedKeysOptimized(selectedSelectionKeySet.flip());
        } else {
            processSelectedKeysPlain(this.selector.selectedKeys());
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public final void cleanup() throws IOException {
        try {
            this.selector.close();
        } catch (IOException e) {
            logger.warn("Failed to close a selector.", (Throwable) e);
        }
    }

    final void cancel(SelectionKey selectionKey) {
        selectionKey.cancel();
        this.cancelledKeys++;
        if (this.cancelledKeys >= 256) {
            this.cancelledKeys = 0;
            this.needsToSelectAgain = true;
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public final Runnable pollTask() {
        Runnable runnablePollTask = super.pollTask();
        if (this.needsToSelectAgain) {
            selectAgain();
        }
        return runnablePollTask;
    }

    private void processSelectedKeysPlain(Set<SelectionKey> set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator<SelectionKey> it = set.iterator();
        while (true) {
            SelectionKey next = it.next();
            Object objAttachment = next.attachment();
            it.remove();
            if (objAttachment instanceof AbstractNioChannel) {
                processSelectedKey(next, (AbstractNioChannel) objAttachment);
            } else {
                processSelectedKey(next, (NioTask<SelectableChannel>) objAttachment);
            }
            if (!it.hasNext()) {
                return;
            }
            if (this.needsToSelectAgain) {
                selectAgain();
                Set<SelectionKey> setSelectedKeys = this.selector.selectedKeys();
                if (setSelectedKeys.isEmpty()) {
                    return;
                } else {
                    it = setSelectedKeys.iterator();
                }
            }
        }
    }

    private void processSelectedKeysOptimized(SelectionKey[] selectionKeyArr) {
        int i = 0;
        while (true) {
            SelectionKey selectionKey = selectionKeyArr[i];
            if (selectionKey == null) {
                return;
            }
            selectionKeyArr[i] = null;
            Object objAttachment = selectionKey.attachment();
            if (objAttachment instanceof AbstractNioChannel) {
                processSelectedKey(selectionKey, (AbstractNioChannel) objAttachment);
            } else {
                processSelectedKey(selectionKey, (NioTask<SelectableChannel>) objAttachment);
            }
            if (this.needsToSelectAgain) {
                while (true) {
                    i++;
                    if (selectionKeyArr[i] == null) {
                        break;
                    } else {
                        selectionKeyArr[i] = null;
                    }
                }
                selectAgain();
                selectionKeyArr = this.selectedKeys.flip();
                i = -1;
            }
            i++;
        }
    }

    private static void processSelectedKey(SelectionKey selectionKey, AbstractNioChannel abstractNioChannel) {
        AbstractNioChannel.NioUnsafe nioUnsafeUnsafe = abstractNioChannel.unsafe();
        if (!selectionKey.isValid()) {
            nioUnsafeUnsafe.close(nioUnsafeUnsafe.voidPromise());
            return;
        }
        try {
            int i = selectionKey.readyOps();
            if ((i & 17) != 0 || i == 0) {
                nioUnsafeUnsafe.read();
                if (!abstractNioChannel.isOpen()) {
                    return;
                }
            }
            if ((i & 4) != 0) {
                abstractNioChannel.unsafe().forceFlush();
            }
            if ((i & 8) != 0) {
                selectionKey.interestOps(selectionKey.interestOps() & (-9));
                nioUnsafeUnsafe.finishConnect();
            }
        } catch (CancelledKeyException unused) {
            nioUnsafeUnsafe.close(nioUnsafeUnsafe.voidPromise());
        }
    }

    private static void processSelectedKey(SelectionKey selectionKey, NioTask<SelectableChannel> nioTask) {
        try {
            try {
                nioTask.channelReady(selectionKey.channel(), selectionKey);
                if (selectionKey.isValid()) {
                    return;
                }
                invokeChannelUnregistered(nioTask, selectionKey, null);
            } catch (Exception e) {
                selectionKey.cancel();
                invokeChannelUnregistered(nioTask, selectionKey, e);
            }
        } catch (Throwable th) {
            selectionKey.cancel();
            invokeChannelUnregistered(nioTask, selectionKey, null);
            throw th;
        }
    }

    private void closeAll() {
        selectAgain();
        Set<SelectionKey> setKeys = this.selector.keys();
        ArrayList<AbstractNioChannel> arrayList = new ArrayList(setKeys.size());
        for (SelectionKey selectionKey : setKeys) {
            Object objAttachment = selectionKey.attachment();
            if (objAttachment instanceof AbstractNioChannel) {
                arrayList.add((AbstractNioChannel) objAttachment);
            } else {
                selectionKey.cancel();
                invokeChannelUnregistered((NioTask) objAttachment, selectionKey, null);
            }
        }
        for (AbstractNioChannel abstractNioChannel : arrayList) {
            abstractNioChannel.unsafe().close(abstractNioChannel.unsafe().voidPromise());
        }
    }

    private static void invokeChannelUnregistered(NioTask<SelectableChannel> nioTask, SelectionKey selectionKey, Throwable th) {
        try {
            nioTask.channelUnregistered(selectionKey.channel(), th);
        } catch (Exception e) {
            logger.warn("Unexpected exception while running NioTask.channelUnregistered()", (Throwable) e);
        }
    }

    @Override // io.netty.util.concurrent.SingleThreadEventExecutor
    public final void wakeup(boolean z) {
        if (z || !this.wakenUp.compareAndSet(false, true)) {
            return;
        }
        this.selector.wakeup();
    }

    final void selectNow() {
        try {
            this.selector.selectNow();
        } finally {
            if (this.wakenUp.get()) {
                this.selector.wakeup();
            }
        }
    }

    private void select(boolean z) throws IOException {
        Selector selector = this.selector;
        int i = 0;
        try {
            long jNanoTime = System.nanoTime();
            long jDelayNanos = delayNanos(jNanoTime) + jNanoTime;
            while (true) {
                long j = ((jDelayNanos - jNanoTime) + 500000) / 1000000;
                if (j > 0) {
                    i++;
                    if (selector.select(j) != 0 || z || this.wakenUp.get() || hasTasks() || hasScheduledTasks()) {
                        break;
                    }
                    if (Thread.interrupted()) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop.");
                        }
                    } else {
                        long jNanoTime2 = System.nanoTime();
                        if (jNanoTime2 - TimeUnit.MILLISECONDS.toNanos(j) < jNanoTime) {
                            if (SELECTOR_AUTO_REBUILD_THRESHOLD > 0 && i >= SELECTOR_AUTO_REBUILD_THRESHOLD) {
                                logger.warn("Selector.select() returned prematurely {} times in a row; rebuilding selector.", Integer.valueOf(i));
                                rebuildSelector();
                                this.selector.selectNow();
                                break;
                            }
                        } else {
                            i = 1;
                        }
                        jNanoTime = jNanoTime2;
                    }
                } else if (i == 0) {
                    selector.selectNow();
                }
            }
            i = 1;
            if (i <= 3 || !logger.isDebugEnabled()) {
                return;
            }
            logger.debug("Selector.select() returned prematurely {} times in a row.", Integer.valueOf(i - 1));
        } catch (CancelledKeyException e) {
            if (logger.isDebugEnabled()) {
                logger.debug(CancelledKeyException.class.getSimpleName() + " raised by a Selector - JDK bug?", (Throwable) e);
            }
        }
    }

    private void selectAgain() {
        this.needsToSelectAgain = false;
        try {
            this.selector.selectNow();
        } catch (Throwable th) {
            logger.warn("Failed to update SelectionKeys.", th);
        }
    }
}
