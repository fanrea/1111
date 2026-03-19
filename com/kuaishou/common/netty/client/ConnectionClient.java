package com.kuaishou.common.netty.client;

import io.netty.channel.Channel;
import java.io.Closeable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ConnectionClient implements Closeable {
    private final ConnectionBootstrap bootstrap;
    private Channel channel;
    private ChannelHandler handler;

    ConnectionClient(ConnectionBootstrap connectionBootstrap, Channel channel) {
        this.channel = channel;
        this.bootstrap = connectionBootstrap;
        this.handler = (ChannelHandler) channel.pipeline().get(ChannelHandler.class);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.channel.close();
        this.bootstrap.shutdownGracefully();
    }

    public boolean isAlive() {
        return this.channel.isActive();
    }

    public ChannelHandler getChannelHandler() {
        return this.handler;
    }

    public Channel getChannel() {
        return this.channel;
    }
}
