package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayDeque;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class CoalescingBufferQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ArrayDeque<Object> bufAndListenerPairs = new ArrayDeque<>();
    private final Channel channel;
    private int readableBytes;

    public CoalescingBufferQueue(Channel channel) {
        this.channel = (Channel) ObjectUtil.checkNotNull(channel, "channel");
    }

    public final void add(ByteBuf byteBuf) {
        add(byteBuf, (ChannelFutureListener) null);
    }

    public final void add(ByteBuf byteBuf, ChannelPromise channelPromise) {
        ObjectUtil.checkNotNull(channelPromise, "promise");
        add(byteBuf, channelPromise.isVoid() ? null : new ChannelPromiseNotifier(channelPromise));
    }

    public final void add(ByteBuf byteBuf, ChannelFutureListener channelFutureListener) {
        ObjectUtil.checkNotNull(byteBuf, "buf");
        if (this.readableBytes > Integer.MAX_VALUE - byteBuf.readableBytes()) {
            throw new IllegalStateException("buffer queue length overflow: " + this.readableBytes + " + " + byteBuf.readableBytes());
        }
        this.bufAndListenerPairs.add(byteBuf);
        if (channelFutureListener != null) {
            this.bufAndListenerPairs.add(channelFutureListener);
        }
        this.readableBytes += byteBuf.readableBytes();
    }

    public final ByteBuf remove(int i, ChannelPromise channelPromise) {
        if (i < 0) {
            throw new IllegalArgumentException("bytes (expected >= 0): " + i);
        }
        ObjectUtil.checkNotNull(channelPromise, "aggregatePromise");
        if (this.bufAndListenerPairs.isEmpty()) {
            return Unpooled.EMPTY_BUFFER;
        }
        int iMin = Math.min(i, this.readableBytes);
        ByteBuf byteBufCompose = null;
        int i2 = iMin;
        while (true) {
            Object objPoll = this.bufAndListenerPairs.poll();
            if (objPoll == null) {
                break;
            }
            if (objPoll instanceof ChannelFutureListener) {
                channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) objPoll);
            } else {
                ByteBuf byteBuf = (ByteBuf) objPoll;
                if (byteBuf.readableBytes() > i2) {
                    this.bufAndListenerPairs.addFirst(byteBuf);
                    if (i2 > 0) {
                        byteBufCompose = compose(byteBufCompose, byteBuf.readSlice(i2).retain());
                        i2 = 0;
                    }
                } else {
                    byteBufCompose = compose(byteBufCompose, byteBuf);
                    i2 -= byteBuf.readableBytes();
                }
            }
        }
        this.readableBytes -= iMin - i2;
        return byteBufCompose;
    }

    private ByteBuf compose(ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (byteBuf == null) {
            return byteBuf2;
        }
        if (byteBuf instanceof CompositeByteBuf) {
            CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
            compositeByteBuf.addComponent(byteBuf2);
            compositeByteBuf.writerIndex(compositeByteBuf.writerIndex() + byteBuf2.readableBytes());
            return compositeByteBuf;
        }
        CompositeByteBuf compositeByteBufCompositeBuffer = this.channel.alloc().compositeBuffer(this.bufAndListenerPairs.size() + 2);
        compositeByteBufCompositeBuffer.addComponent(byteBuf);
        compositeByteBufCompositeBuffer.addComponent(byteBuf2);
        return compositeByteBufCompositeBuffer.writerIndex(byteBuf.readableBytes() + byteBuf2.readableBytes());
    }

    public final int readableBytes() {
        return this.readableBytes;
    }

    public final boolean isEmpty() {
        return this.bufAndListenerPairs.isEmpty();
    }

    public final void releaseAndFailAll(Throwable th) {
        releaseAndCompleteAll(this.channel.newFailedFuture(th));
    }

    private void releaseAndCompleteAll(ChannelFuture channelFuture) {
        this.readableBytes = 0;
        Throwable th = null;
        while (true) {
            Object objPoll = this.bufAndListenerPairs.poll();
            if (objPoll == null) {
                break;
            }
            try {
                if (objPoll instanceof ByteBuf) {
                    ReferenceCountUtil.safeRelease(objPoll);
                } else {
                    ((ChannelFutureListener) objPoll).operationComplete(channelFuture);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (th != null) {
            throw new IllegalStateException(th);
        }
    }

    public final void copyTo(CoalescingBufferQueue coalescingBufferQueue) {
        coalescingBufferQueue.bufAndListenerPairs.addAll(this.bufAndListenerPairs);
        coalescingBufferQueue.readableBytes += this.readableBytes;
    }
}
