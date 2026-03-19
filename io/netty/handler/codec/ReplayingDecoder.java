package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Signal;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class ReplayingDecoder<S> extends ByteToMessageDecoder {
    static final Signal REPLAY = Signal.valueOf(ReplayingDecoder.class, "REPLAY");
    private int checkpoint;
    private final ReplayingDecoderByteBuf replayable;
    private S state;

    protected ReplayingDecoder() {
        this(null);
    }

    protected ReplayingDecoder(S s) {
        this.replayable = new ReplayingDecoderByteBuf();
        this.checkpoint = -1;
        this.state = s;
    }

    protected void checkpoint() {
        this.checkpoint = internalBuffer().readerIndex();
    }

    protected void checkpoint(S s) {
        checkpoint();
        state(s);
    }

    protected S state() {
        return this.state;
    }

    protected S state(S s) {
        S s2 = this.state;
        this.state = s;
        return s2;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance();
        try {
            try {
                try {
                    this.replayable.terminate();
                    callDecode(channelHandlerContext, internalBuffer(), recyclableArrayListNewInstance);
                    decodeLast(channelHandlerContext, this.replayable, recyclableArrayListNewInstance);
                } catch (DecoderException e) {
                    throw e;
                } catch (Signal e2) {
                    e2.expect(REPLAY);
                    try {
                        if (this.cumulation != null) {
                            this.cumulation.release();
                            this.cumulation = null;
                        }
                        int size = recyclableArrayListNewInstance.size();
                        if (size > 0) {
                            fireChannelRead(channelHandlerContext, recyclableArrayListNewInstance, size);
                            channelHandlerContext.fireChannelReadComplete();
                        }
                        channelHandlerContext.fireChannelInactive();
                    } finally {
                    }
                }
                try {
                    if (this.cumulation != null) {
                        this.cumulation.release();
                        this.cumulation = null;
                    }
                    int size2 = recyclableArrayListNewInstance.size();
                    if (size2 > 0) {
                        fireChannelRead(channelHandlerContext, recyclableArrayListNewInstance, size2);
                        channelHandlerContext.fireChannelReadComplete();
                    }
                    channelHandlerContext.fireChannelInactive();
                } finally {
                }
            } catch (Exception e3) {
                throw new DecoderException(e3);
            }
        } catch (Throwable th) {
            try {
                if (this.cumulation != null) {
                    this.cumulation.release();
                    this.cumulation = null;
                }
                int size3 = recyclableArrayListNewInstance.size();
                if (size3 > 0) {
                    fireChannelRead(channelHandlerContext, recyclableArrayListNewInstance, size3);
                    channelHandlerContext.fireChannelReadComplete();
                }
                channelHandlerContext.fireChannelInactive();
                throw th;
            } finally {
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int i;
        this.replayable.setCumulation(byteBuf);
        while (byteBuf.isReadable()) {
            try {
                int i2 = byteBuf.readerIndex();
                this.checkpoint = i2;
                int size = list.size();
                if (size > 0) {
                    fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    size = 0;
                }
                S s = this.state;
                int i3 = byteBuf.readableBytes();
                try {
                    decode(channelHandlerContext, this.replayable, list);
                    if (channelHandlerContext.isRemoved()) {
                        return;
                    }
                    if (size == list.size()) {
                        if (i3 == byteBuf.readableBytes() && s == this.state) {
                            throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() must consume the inbound data or change its state if it did not decode anything.");
                        }
                    } else {
                        if (i2 == byteBuf.readerIndex() && s == this.state) {
                            throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() method must consume the inbound data or change its state if it decoded something.");
                        }
                        if (isSingleDecode()) {
                            return;
                        }
                    }
                } catch (Signal e) {
                    e.expect(REPLAY);
                    if (channelHandlerContext.isRemoved() || (i = this.checkpoint) < 0) {
                        return;
                    }
                    byteBuf.readerIndex(i);
                    return;
                }
            } catch (DecoderException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new DecoderException(th);
            }
        }
    }
}
