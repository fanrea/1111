package com.kuaishou.common.netty.client;

import com.kuaishou.common.netty.function.Supplier;
import com.kuaishou.socket.nano.SocketMessages;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.internal.SystemPropertyUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ConnectionBootstrap {
    private static final int DEFAULT_EVENT_LOOP_THREADS_NUMBER = Math.min(8, Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", Runtime.getRuntime().availableProcessors() * 2)));
    private static final int MAX_USE_EVENT_LOOP_THREAD_NUMBER = 8;
    private static final int TIMEOUT = 5000;
    private Bootstrap bootstrap;
    private EventLoopGroup group;

    public void bootstrap() {
        bootstrap(null);
    }

    public void bootstrap(Supplier<SimpleChannelInboundHandler<SocketMessages.SocketMessage>> supplier) {
        ChannelInitializer channelInitializer;
        this.group = new NioEventLoopGroup(DEFAULT_EVENT_LOOP_THREADS_NUMBER);
        this.bootstrap = new Bootstrap();
        if (supplier != null) {
            channelInitializer = new ChannelInitializer(supplier);
        } else {
            channelInitializer = new ChannelInitializer();
        }
        this.bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000).option(ChannelOption.SO_TIMEOUT, 5000).group(this.group).channel(NioSocketChannel.class).handler(channelInitializer);
    }

    public void shutdownGracefully() {
        this.group.shutdownGracefully();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [io.netty.channel.ChannelFuture] */
    public ConnectionClient connect(String str, int i) {
        try {
            return new ConnectionClient(this, this.bootstrap.connect(str, i).sync().channel());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
