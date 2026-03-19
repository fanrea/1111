package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;
import java.net.SocketAddress;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface ChannelHandlerInvoker {
    EventExecutor executor();

    void invokeBind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise);

    void invokeChannelActive(ChannelHandlerContext channelHandlerContext);

    void invokeChannelInactive(ChannelHandlerContext channelHandlerContext);

    void invokeChannelRead(ChannelHandlerContext channelHandlerContext, Object obj);

    void invokeChannelReadComplete(ChannelHandlerContext channelHandlerContext);

    void invokeChannelRegistered(ChannelHandlerContext channelHandlerContext);

    void invokeChannelUnregistered(ChannelHandlerContext channelHandlerContext);

    void invokeChannelWritabilityChanged(ChannelHandlerContext channelHandlerContext);

    void invokeClose(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    void invokeConnect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise);

    void invokeDeregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    void invokeDisconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise);

    void invokeExceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th);

    void invokeFlush(ChannelHandlerContext channelHandlerContext);

    void invokeRead(ChannelHandlerContext channelHandlerContext);

    void invokeUserEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj);

    void invokeWrite(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise);
}
