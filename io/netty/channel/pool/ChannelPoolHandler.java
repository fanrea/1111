package io.netty.channel.pool;

import io.netty.channel.Channel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface ChannelPoolHandler {
    void channelAcquired(Channel channel);

    void channelCreated(Channel channel);

    void channelReleased(Channel channel);
}
