package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.CompositeByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.util.ReferenceCountUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class MessageAggregator<I, S, C extends ByteBufHolder, O extends ByteBufHolder> extends MessageToMessageDecoder<I> {
    private static final int DEFAULT_MAX_COMPOSITEBUFFER_COMPONENTS = 1024;
    private ChannelFutureListener continueResponseWriteListener;
    private ChannelHandlerContext ctx;
    private O currentMessage;
    private boolean handlingOversizedMessage;
    private final int maxContentLength;
    private int maxCumulationBufferComponents;

    protected void aggregate(O o, C c) {
    }

    protected abstract O beginAggregation(S s, ByteBuf byteBuf);

    protected abstract boolean closeAfterContinueResponse(Object obj);

    protected void finishAggregation(O o) {
    }

    protected abstract boolean ignoreContentAfterContinueResponse(Object obj);

    protected abstract boolean isAggregated(I i);

    protected abstract boolean isContentLengthInvalid(S s, int i);

    protected abstract boolean isContentMessage(I i);

    protected abstract boolean isLastContentMessage(C c);

    protected abstract boolean isStartMessage(I i);

    protected abstract Object newContinueResponse(S s, int i, ChannelPipeline channelPipeline);

    protected MessageAggregator(int i) {
        this.maxCumulationBufferComponents = 1024;
        validateMaxContentLength(i);
        this.maxContentLength = i;
    }

    protected MessageAggregator(int i, Class<? extends I> cls) {
        super(cls);
        this.maxCumulationBufferComponents = 1024;
        validateMaxContentLength(i);
        this.maxContentLength = i;
    }

    private static void validateMaxContentLength(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException("maxContentLength: " + i + " (expected: >= 0)");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object obj) {
        if (super.acceptInboundMessage(obj)) {
            return (isContentMessage(obj) || isStartMessage(obj)) && !isAggregated(obj);
        }
        return false;
    }

    public final int maxContentLength() {
        return this.maxContentLength;
    }

    public final int maxCumulationBufferComponents() {
        return this.maxCumulationBufferComponents;
    }

    public final void setMaxCumulationBufferComponents(int i) {
        if (i < 2) {
            throw new IllegalArgumentException("maxCumulationBufferComponents: " + i + " (expected: >= 2)");
        }
        if (this.ctx == null) {
            this.maxCumulationBufferComponents = i;
            return;
        }
        throw new IllegalStateException("decoder properties cannot be changed once the decoder is added to a pipeline.");
    }

    public final boolean isHandlingOversizedMessage() {
        return this.handlingOversizedMessage;
    }

    protected final ChannelHandlerContext ctx() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return channelHandlerContext;
        }
        throw new IllegalStateException("not added to a pipeline yet");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(final io.netty.channel.ChannelHandlerContext r9, I r10, java.util.List<java.lang.Object> r11) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.MessageAggregator.decode(io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List):void");
    }

    private static void appendPartialContent(CompositeByteBuf compositeByteBuf, ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            byteBuf.retain();
            compositeByteBuf.addComponent(byteBuf);
            compositeByteBuf.writerIndex(compositeByteBuf.writerIndex() + byteBuf.readableBytes());
        }
    }

    private void invokeHandleOversizedMessage(ChannelHandlerContext channelHandlerContext, S s) {
        this.handlingOversizedMessage = true;
        this.currentMessage = null;
        try {
            handleOversizedMessage(channelHandlerContext, s);
        } finally {
            ReferenceCountUtil.release(s);
        }
    }

    protected void handleOversizedMessage(ChannelHandlerContext channelHandlerContext, S s) {
        channelHandlerContext.fireExceptionCaught(new TooLongFrameException("content length exceeded " + maxContentLength() + " bytes."));
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) {
        O o = this.currentMessage;
        if (o != null) {
            o.release();
            this.currentMessage = null;
        }
        super.channelInactive(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        super.handlerRemoved(channelHandlerContext);
        O o = this.currentMessage;
        if (o != null) {
            o.release();
            this.currentMessage = null;
        }
    }
}
