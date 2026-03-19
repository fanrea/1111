package io.netty.channel;

import io.netty.util.concurrent.GenericFutureListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface ChannelFutureListener extends GenericFutureListener<ChannelFuture> {
    public static final ChannelFutureListener CLOSE = new ChannelFutureListener() { // from class: io.netty.channel.ChannelFutureListener.1
        @Override // io.netty.util.concurrent.GenericFutureListener
        public final void operationComplete(ChannelFuture channelFuture) {
            channelFuture.channel().close();
        }
    };
    public static final ChannelFutureListener CLOSE_ON_FAILURE = new ChannelFutureListener() { // from class: io.netty.channel.ChannelFutureListener.2
        @Override // io.netty.util.concurrent.GenericFutureListener
        public final void operationComplete(ChannelFuture channelFuture) {
            if (channelFuture.isSuccess()) {
                return;
            }
            channelFuture.channel().close();
        }
    };
    public static final ChannelFutureListener FIRE_EXCEPTION_ON_FAILURE = new ChannelFutureListener() { // from class: io.netty.channel.ChannelFutureListener.3
        @Override // io.netty.util.concurrent.GenericFutureListener
        public final void operationComplete(ChannelFuture channelFuture) {
            if (channelFuture.isSuccess()) {
                return;
            }
            channelFuture.channel().pipeline().fireExceptionCaught(channelFuture.cause());
        }
    };
}
