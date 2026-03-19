package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

@ChannelHandler.Sharable
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class ChannelInitializer<C extends Channel> extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChannelInitializer.class);

    protected abstract void initChannel(C c);

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public final void channelRegistered(ChannelHandlerContext channelHandlerContext) {
        initChannel(channelHandlerContext.channel());
        channelHandlerContext.pipeline().remove(this);
        channelHandlerContext.fireChannelRegistered();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        logger.warn("Failed to initialize a channel. Closing: " + channelHandlerContext.channel(), th);
        try {
            ChannelPipeline channelPipelinePipeline = channelHandlerContext.pipeline();
            if (channelPipelinePipeline.context(this) != null) {
                channelPipelinePipeline.remove(this);
            }
        } finally {
            channelHandlerContext.close();
        }
    }
}
