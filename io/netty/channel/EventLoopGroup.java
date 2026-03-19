package io.netty.channel;

import io.netty.util.concurrent.EventExecutorGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface EventLoopGroup extends EventExecutorGroup {
    EventLoop next();

    ChannelFuture register(Channel channel);

    ChannelFuture register(Channel channel, ChannelPromise channelPromise);
}
