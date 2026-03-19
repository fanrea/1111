package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class ByteToMessageDecoder extends ChannelInboundHandlerAdapter {
    ByteBuf cumulation;
    private boolean decodeWasNull;
    private boolean first;
    private int numReads;
    private boolean singleDecode;
    public static final Cumulator MERGE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.1
        @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public final ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            if (byteBuf.writerIndex() > byteBuf.maxCapacity() - byteBuf2.readableBytes() || byteBuf.refCnt() > 1) {
                byteBuf = ByteToMessageDecoder.expandCumulation(byteBufAllocator, byteBuf, byteBuf2.readableBytes());
            }
            byteBuf.writeBytes(byteBuf2);
            byteBuf2.release();
            return byteBuf;
        }
    };
    public static final Cumulator COMPOSITE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.2
        @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public final ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            CompositeByteBuf compositeByteBufCompositeBuffer;
            if (byteBuf.refCnt() > 1) {
                ByteBuf byteBufExpandCumulation = ByteToMessageDecoder.expandCumulation(byteBufAllocator, byteBuf, byteBuf2.readableBytes());
                byteBufExpandCumulation.writeBytes(byteBuf2);
                byteBuf2.release();
                return byteBufExpandCumulation;
            }
            if (byteBuf instanceof CompositeByteBuf) {
                compositeByteBufCompositeBuffer = (CompositeByteBuf) byteBuf;
            } else {
                int i = byteBuf.readableBytes();
                compositeByteBufCompositeBuffer = byteBufAllocator.compositeBuffer();
                compositeByteBufCompositeBuffer.addComponent(byteBuf).writerIndex(i);
            }
            compositeByteBufCompositeBuffer.addComponent(byteBuf2).writerIndex(compositeByteBufCompositeBuffer.writerIndex() + byteBuf2.readableBytes());
            return compositeByteBufCompositeBuffer;
        }
    };
    private Cumulator cumulator = MERGE_CUMULATOR;
    private int discardAfterReads = 16;

    public interface Cumulator {
        ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);
    }

    protected abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list);

    protected void handlerRemoved0(ChannelHandlerContext channelHandlerContext) {
    }

    protected ByteToMessageDecoder() {
        CodecUtil.ensureNotSharable(this);
    }

    public void setSingleDecode(boolean z) {
        this.singleDecode = z;
    }

    public boolean isSingleDecode() {
        return this.singleDecode;
    }

    public void setCumulator(Cumulator cumulator) {
        if (cumulator == null) {
            throw new NullPointerException("cumulator");
        }
        this.cumulator = cumulator;
    }

    public void setDiscardAfterReads(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("discardAfterReads must be > 0");
        }
        this.discardAfterReads = i;
    }

    protected int actualReadableBytes() {
        return internalBuffer().readableBytes();
    }

    protected ByteBuf internalBuffer() {
        ByteBuf byteBuf = this.cumulation;
        return byteBuf != null ? byteBuf : Unpooled.EMPTY_BUFFER;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public final void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBufInternalBuffer = internalBuffer();
        int i = byteBufInternalBuffer.readableBytes();
        if (i > 0) {
            ByteBuf bytes = byteBufInternalBuffer.readBytes(i);
            byteBufInternalBuffer.release();
            channelHandlerContext.fireChannelRead(bytes);
        } else {
            byteBufInternalBuffer.release();
        }
        this.cumulation = null;
        this.numReads = 0;
        channelHandlerContext.fireChannelReadComplete();
        handlerRemoved0(channelHandlerContext);
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        if (obj instanceof ByteBuf) {
            RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance();
            try {
                try {
                    ByteBuf byteBuf = (ByteBuf) obj;
                    this.first = this.cumulation == null;
                    if (this.first) {
                        this.cumulation = byteBuf;
                    } else {
                        this.cumulation = this.cumulator.cumulate(channelHandlerContext.alloc(), this.cumulation, byteBuf);
                    }
                    callDecode(channelHandlerContext, this.cumulation, recyclableArrayListNewInstance);
                    ByteBuf byteBuf2 = this.cumulation;
                    if (byteBuf2 != null && !byteBuf2.isReadable()) {
                        this.numReads = 0;
                        this.cumulation.release();
                        this.cumulation = null;
                    } else {
                        int i = this.numReads + 1;
                        this.numReads = i;
                        if (i >= this.discardAfterReads) {
                            this.numReads = 0;
                            discardSomeReadBytes();
                        }
                    }
                    int size = recyclableArrayListNewInstance.size();
                    this.decodeWasNull = !recyclableArrayListNewInstance.insertSinceRecycled();
                    fireChannelRead(channelHandlerContext, recyclableArrayListNewInstance, size);
                    recyclableArrayListNewInstance.recycle();
                    return;
                } catch (DecoderException e) {
                    throw e;
                } catch (Throwable th) {
                    throw new DecoderException(th);
                }
            } catch (Throwable th2) {
                ByteBuf byteBuf3 = this.cumulation;
                if (byteBuf3 != null && !byteBuf3.isReadable()) {
                    this.numReads = 0;
                    this.cumulation.release();
                    this.cumulation = null;
                } else {
                    int i2 = this.numReads + 1;
                    this.numReads = i2;
                    if (i2 >= this.discardAfterReads) {
                        this.numReads = 0;
                        discardSomeReadBytes();
                    }
                }
                int size2 = recyclableArrayListNewInstance.size();
                this.decodeWasNull = true ^ recyclableArrayListNewInstance.insertSinceRecycled();
                fireChannelRead(channelHandlerContext, recyclableArrayListNewInstance, size2);
                recyclableArrayListNewInstance.recycle();
                throw th2;
            }
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    static void fireChannelRead(ChannelHandlerContext channelHandlerContext, List<Object> list, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            channelHandlerContext.fireChannelRead(list.get(i2));
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) {
        this.numReads = 0;
        discardSomeReadBytes();
        if (this.decodeWasNull) {
            this.decodeWasNull = false;
            if (!channelHandlerContext.channel().config().isAutoRead()) {
                channelHandlerContext.read();
            }
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    protected final void discardSomeReadBytes() {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf == null || this.first || byteBuf.refCnt() != 1) {
            return;
        }
        this.cumulation.discardSomeReadBytes();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance();
        try {
            try {
                if (this.cumulation != null) {
                    callDecode(channelHandlerContext, this.cumulation, recyclableArrayListNewInstance);
                    decodeLast(channelHandlerContext, this.cumulation, recyclableArrayListNewInstance);
                } else {
                    decodeLast(channelHandlerContext, Unpooled.EMPTY_BUFFER, recyclableArrayListNewInstance);
                }
                try {
                    if (this.cumulation != null) {
                        this.cumulation.release();
                        this.cumulation = null;
                    }
                    int size = recyclableArrayListNewInstance.size();
                    fireChannelRead(channelHandlerContext, recyclableArrayListNewInstance, size);
                    if (size > 0) {
                        channelHandlerContext.fireChannelReadComplete();
                    }
                    channelHandlerContext.fireChannelInactive();
                } finally {
                }
            } catch (DecoderException e) {
                throw e;
            } catch (Exception e2) {
                throw new DecoderException(e2);
            }
        } catch (Throwable th) {
            try {
                if (this.cumulation != null) {
                    this.cumulation.release();
                    this.cumulation = null;
                }
                int size2 = recyclableArrayListNewInstance.size();
                fireChannelRead(channelHandlerContext, recyclableArrayListNewInstance, size2);
                if (size2 > 0) {
                    channelHandlerContext.fireChannelReadComplete();
                }
                channelHandlerContext.fireChannelInactive();
                throw th;
            } finally {
            }
        }
    }

    protected void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        while (byteBuf.isReadable()) {
            try {
                int size = list.size();
                if (size > 0) {
                    fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    if (channelHandlerContext.isRemoved()) {
                        return;
                    } else {
                        size = 0;
                    }
                }
                int i = byteBuf.readableBytes();
                decode(channelHandlerContext, byteBuf, list);
                if (channelHandlerContext.isRemoved()) {
                    return;
                }
                if (size == list.size()) {
                    if (i == byteBuf.readableBytes()) {
                        return;
                    }
                } else {
                    if (i == byteBuf.readableBytes()) {
                        throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() did not read anything but decoded a message.");
                    }
                    if (isSingleDecode()) {
                        return;
                    }
                }
            } catch (DecoderException e) {
                throw e;
            } catch (Throwable th) {
                throw new DecoderException(th);
            }
        }
    }

    protected void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        decode(channelHandlerContext, byteBuf, list);
    }

    static ByteBuf expandCumulation(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int i) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(byteBuf.readableBytes() + i);
        byteBufBuffer.writeBytes(byteBuf);
        byteBuf.release();
        return byteBufBuffer;
    }
}
