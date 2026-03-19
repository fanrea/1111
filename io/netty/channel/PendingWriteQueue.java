package io.netty.channel;

import io.netty.channel.MessageSizeEstimator;
import io.netty.util.Recycler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class PendingWriteQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) PendingWriteQueue.class);
    private final ChannelOutboundBuffer buffer;
    private final ChannelHandlerContext ctx;
    private final MessageSizeEstimator.Handle estimatorHandle;
    private PendingWrite head;
    private int size;
    private PendingWrite tail;

    private void assertEmpty() {
    }

    public PendingWriteQueue(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext == null) {
            throw new NullPointerException("ctx");
        }
        this.ctx = channelHandlerContext;
        this.buffer = channelHandlerContext.channel().unsafe().outboundBuffer();
        this.estimatorHandle = channelHandlerContext.channel().config().getMessageSizeEstimator().newHandle();
    }

    public final boolean isEmpty() {
        return this.head == null;
    }

    public final int size() {
        return this.size;
    }

    public final void add(Object obj, ChannelPromise channelPromise) {
        if (obj == null) {
            throw new NullPointerException("msg");
        }
        if (channelPromise == null) {
            throw new NullPointerException("promise");
        }
        int size = this.estimatorHandle.size(obj);
        if (size < 0) {
            size = 0;
        }
        PendingWrite pendingWriteNewInstance = PendingWrite.newInstance(obj, size, channelPromise);
        PendingWrite pendingWrite = this.tail;
        if (pendingWrite == null) {
            this.head = pendingWriteNewInstance;
            this.tail = pendingWriteNewInstance;
        } else {
            pendingWrite.next = pendingWriteNewInstance;
            this.tail = pendingWriteNewInstance;
        }
        this.size++;
        ChannelOutboundBuffer channelOutboundBuffer = this.buffer;
        if (channelOutboundBuffer != null) {
            channelOutboundBuffer.incrementPendingOutboundBytes(pendingWriteNewInstance.size);
        }
    }

    public final void removeAndFailAll(Throwable th) {
        if (th == null) {
            throw new NullPointerException("cause");
        }
        PendingWrite pendingWrite = this.head;
        this.tail = null;
        this.head = null;
        this.size = 0;
        while (pendingWrite != null) {
            PendingWrite pendingWrite2 = pendingWrite.next;
            ReferenceCountUtil.safeRelease(pendingWrite.msg);
            ChannelPromise channelPromise = pendingWrite.promise;
            recycle(pendingWrite, false);
            safeFail(channelPromise, th);
            pendingWrite = pendingWrite2;
        }
        assertEmpty();
    }

    public final void removeAndFail(Throwable th) {
        if (th == null) {
            throw new NullPointerException("cause");
        }
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return;
        }
        ReferenceCountUtil.safeRelease(pendingWrite.msg);
        safeFail(pendingWrite.promise, th);
        recycle(pendingWrite, true);
    }

    public final ChannelFuture removeAndWriteAll() {
        if (this.size == 1) {
            return removeAndWrite();
        }
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        this.tail = null;
        this.head = null;
        this.size = 0;
        ChannelPromise channelPromiseNewPromise = this.ctx.newPromise();
        ChannelPromiseAggregator channelPromiseAggregator = new ChannelPromiseAggregator(channelPromiseNewPromise);
        while (pendingWrite != null) {
            PendingWrite pendingWrite2 = pendingWrite.next;
            Object obj = pendingWrite.msg;
            ChannelPromise channelPromise = pendingWrite.promise;
            recycle(pendingWrite, false);
            this.ctx.write(obj, channelPromise);
            channelPromiseAggregator.add(channelPromise);
            pendingWrite = pendingWrite2;
        }
        assertEmpty();
        return channelPromiseNewPromise;
    }

    public final ChannelFuture removeAndWrite() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        Object obj = pendingWrite.msg;
        ChannelPromise channelPromise = pendingWrite.promise;
        recycle(pendingWrite, true);
        return this.ctx.write(obj, channelPromise);
    }

    public final ChannelPromise remove() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        ChannelPromise channelPromise = pendingWrite.promise;
        ReferenceCountUtil.safeRelease(pendingWrite.msg);
        recycle(pendingWrite, true);
        return channelPromise;
    }

    public final Object current() {
        PendingWrite pendingWrite = this.head;
        if (pendingWrite == null) {
            return null;
        }
        return pendingWrite.msg;
    }

    private void recycle(PendingWrite pendingWrite, boolean z) {
        PendingWrite pendingWrite2 = pendingWrite.next;
        long j = pendingWrite.size;
        if (z) {
            if (pendingWrite2 == null) {
                this.tail = null;
                this.head = null;
                this.size = 0;
            } else {
                this.head = pendingWrite2;
                this.size--;
            }
        }
        pendingWrite.recycle();
        ChannelOutboundBuffer channelOutboundBuffer = this.buffer;
        if (channelOutboundBuffer != null) {
            channelOutboundBuffer.decrementPendingOutboundBytes(j);
        }
    }

    private static void safeFail(ChannelPromise channelPromise, Throwable th) {
        if ((channelPromise instanceof VoidChannelPromise) || channelPromise.tryFailure(th)) {
            return;
        }
        logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, th);
    }

    static final class PendingWrite {
        private static final Recycler<PendingWrite> RECYCLER = new Recycler<PendingWrite>() { // from class: io.netty.channel.PendingWriteQueue.PendingWrite.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.Recycler
            /* renamed from: newObject */
            public final PendingWrite newObject2(Recycler.Handle<PendingWrite> handle) {
                return new PendingWrite(handle);
            }
        };
        private final Recycler.Handle handle;
        private Object msg;
        private PendingWrite next;
        private ChannelPromise promise;
        private long size;

        private PendingWrite(Recycler.Handle handle) {
            this.handle = handle;
        }

        static PendingWrite newInstance(Object obj, int i, ChannelPromise channelPromise) {
            PendingWrite pendingWrite = RECYCLER.get();
            pendingWrite.size = i;
            pendingWrite.msg = obj;
            pendingWrite.promise = channelPromise;
            return pendingWrite;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recycle() {
            this.size = 0L;
            this.next = null;
            this.msg = null;
            this.promise = null;
            RECYCLER.recycle(this, this.handle);
        }
    }
}
