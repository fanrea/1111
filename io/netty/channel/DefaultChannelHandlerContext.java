package io.netty.channel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class DefaultChannelHandlerContext extends AbstractChannelHandlerContext {
    private final ChannelHandler handler;

    DefaultChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline, ChannelHandlerInvoker channelHandlerInvoker, String str, ChannelHandler channelHandler) {
        super(defaultChannelPipeline, channelHandlerInvoker, str, isInbound(channelHandler), isOutbound(channelHandler));
        if (channelHandler == null) {
            throw new NullPointerException("handler");
        }
        this.handler = channelHandler;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public final ChannelHandler handler() {
        return this.handler;
    }

    private static boolean isInbound(ChannelHandler channelHandler) {
        return channelHandler instanceof ChannelInboundHandler;
    }

    private static boolean isOutbound(ChannelHandler channelHandler) {
        return channelHandler instanceof ChannelOutboundHandler;
    }
}
