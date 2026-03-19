package io.netty.channel;

import io.netty.util.concurrent.EventExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface EventLoop extends EventLoopGroup, EventExecutor {
    ChannelHandlerInvoker asInvoker();

    EventLoopGroup parent();
}
