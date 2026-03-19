package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.OneTimeTask;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ServerBootstrap extends AbstractBootstrap<ServerBootstrap, ServerChannel> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ServerBootstrap.class);
    private final Map<AttributeKey<?>, Object> childAttrs;
    private volatile EventLoopGroup childGroup;
    private volatile ChannelHandler childHandler;
    private final Map<ChannelOption<?>, Object> childOptions;

    public ServerBootstrap() {
        this.childOptions = new LinkedHashMap();
        this.childAttrs = new LinkedHashMap();
    }

    private ServerBootstrap(ServerBootstrap serverBootstrap) {
        super(serverBootstrap);
        this.childOptions = new LinkedHashMap();
        this.childAttrs = new LinkedHashMap();
        this.childGroup = serverBootstrap.childGroup;
        this.childHandler = serverBootstrap.childHandler;
        synchronized (serverBootstrap.childOptions) {
            this.childOptions.putAll(serverBootstrap.childOptions);
        }
        synchronized (serverBootstrap.childAttrs) {
            this.childAttrs.putAll(serverBootstrap.childAttrs);
        }
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public ServerBootstrap group(EventLoopGroup eventLoopGroup) {
        return group(eventLoopGroup, eventLoopGroup);
    }

    public ServerBootstrap group(EventLoopGroup eventLoopGroup, EventLoopGroup eventLoopGroup2) {
        super.group(eventLoopGroup);
        if (eventLoopGroup2 == null) {
            throw new NullPointerException("childGroup");
        }
        if (this.childGroup != null) {
            throw new IllegalStateException("childGroup set already");
        }
        this.childGroup = eventLoopGroup2;
        return this;
    }

    public <T> ServerBootstrap childOption(ChannelOption<T> channelOption, T t) {
        if (channelOption == null) {
            throw new NullPointerException("childOption");
        }
        if (t == null) {
            synchronized (this.childOptions) {
                this.childOptions.remove(channelOption);
            }
        } else {
            synchronized (this.childOptions) {
                this.childOptions.put(channelOption, t);
            }
        }
        return this;
    }

    public <T> ServerBootstrap childAttr(AttributeKey<T> attributeKey, T t) {
        if (attributeKey == null) {
            throw new NullPointerException("childKey");
        }
        if (t == null) {
            this.childAttrs.remove(attributeKey);
        } else {
            this.childAttrs.put(attributeKey, t);
        }
        return this;
    }

    public ServerBootstrap childHandler(ChannelHandler channelHandler) {
        if (channelHandler == null) {
            throw new NullPointerException("childHandler");
        }
        this.childHandler = channelHandler;
        return this;
    }

    public EventLoopGroup childGroup() {
        return this.childGroup;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    void init(Channel channel) {
        final Map.Entry[] entryArr;
        final Map.Entry[] entryArr2;
        Map<ChannelOption<?>, ?> mapOptions = options();
        synchronized (mapOptions) {
            channel.config().setOptions(mapOptions);
        }
        Map<AttributeKey<?>, Object> mapAttrs = attrs();
        synchronized (mapAttrs) {
            for (Map.Entry<AttributeKey<?>, Object> entry : mapAttrs.entrySet()) {
                channel.attr(entry.getKey()).set(entry.getValue());
            }
        }
        ChannelPipeline channelPipelinePipeline = channel.pipeline();
        final EventLoopGroup eventLoopGroup = this.childGroup;
        final ChannelHandler channelHandler = this.childHandler;
        synchronized (this.childOptions) {
            entryArr = (Map.Entry[]) this.childOptions.entrySet().toArray(newOptionArray(this.childOptions.size()));
        }
        synchronized (this.childAttrs) {
            entryArr2 = (Map.Entry[]) this.childAttrs.entrySet().toArray(newAttrArray(this.childAttrs.size()));
        }
        channelPipelinePipeline.addLast(new ChannelInitializer<Channel>() { // from class: io.netty.bootstrap.ServerBootstrap.1
            @Override // io.netty.channel.ChannelInitializer
            public void initChannel(Channel channel2) {
                ChannelPipeline channelPipelinePipeline2 = channel2.pipeline();
                ChannelHandler channelHandlerHandler = ServerBootstrap.this.handler();
                if (channelHandlerHandler != null) {
                    channelPipelinePipeline2.addLast(channelHandlerHandler);
                }
                channelPipelinePipeline2.addLast(new ServerBootstrapAcceptor(eventLoopGroup, channelHandler, entryArr, entryArr2));
            }
        });
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public ServerBootstrap validate() {
        super.validate();
        if (this.childHandler == null) {
            throw new IllegalStateException("childHandler not set");
        }
        if (this.childGroup == null) {
            logger.warn("childGroup is not set. Using parentGroup instead.");
            this.childGroup = group();
        }
        return this;
    }

    private static Map.Entry<ChannelOption<?>, Object>[] newOptionArray(int i) {
        return new Map.Entry[i];
    }

    private static Map.Entry<AttributeKey<?>, Object>[] newAttrArray(int i) {
        return new Map.Entry[i];
    }

    static class ServerBootstrapAcceptor extends ChannelInboundHandlerAdapter {
        private final Map.Entry<AttributeKey<?>, Object>[] childAttrs;
        private final EventLoopGroup childGroup;
        private final ChannelHandler childHandler;
        private final Map.Entry<ChannelOption<?>, Object>[] childOptions;

        ServerBootstrapAcceptor(EventLoopGroup eventLoopGroup, ChannelHandler channelHandler, Map.Entry<ChannelOption<?>, Object>[] entryArr, Map.Entry<AttributeKey<?>, Object>[] entryArr2) {
            this.childGroup = eventLoopGroup;
            this.childHandler = channelHandler;
            this.childOptions = entryArr;
            this.childAttrs = entryArr2;
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            final Channel channel = (Channel) obj;
            channel.pipeline().addLast(this.childHandler);
            for (Map.Entry<ChannelOption<?>, Object> entry : this.childOptions) {
                try {
                    if (!channel.config().setOption(entry.getKey(), entry.getValue())) {
                        ServerBootstrap.logger.warn("Unknown channel option: " + entry);
                    }
                } catch (Throwable th) {
                    ServerBootstrap.logger.warn("Failed to set a channel option: " + channel, th);
                }
            }
            for (Map.Entry<AttributeKey<?>, Object> entry2 : this.childAttrs) {
                channel.attr(entry2.getKey()).set(entry2.getValue());
            }
            try {
                this.childGroup.register(channel).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.ServerBootstrap.ServerBootstrapAcceptor.1
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) {
                        if (channelFuture.isSuccess()) {
                            return;
                        }
                        ServerBootstrapAcceptor.forceClose(channel, channelFuture.cause());
                    }
                });
            } catch (Throwable th2) {
                forceClose(channel, th2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void forceClose(Channel channel, Throwable th) {
            channel.unsafe().closeForcibly();
            ServerBootstrap.logger.warn("Failed to register an accepted channel: " + channel, th);
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            final ChannelConfig channelConfigConfig = channelHandlerContext.channel().config();
            if (channelConfigConfig.isAutoRead()) {
                channelConfigConfig.setAutoRead(false);
                channelHandlerContext.channel().eventLoop().schedule((Runnable) new OneTimeTask() { // from class: io.netty.bootstrap.ServerBootstrap.ServerBootstrapAcceptor.2
                    @Override // java.lang.Runnable
                    public void run() {
                        channelConfigConfig.setAutoRead(true);
                    }
                }, 1L, TimeUnit.SECONDS);
            }
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    /* renamed from: clone */
    public ServerBootstrap mo1516clone() {
        return new ServerBootstrap(this);
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.setLength(sb.length() - 1);
        sb.append(", ");
        if (this.childGroup != null) {
            sb.append("childGroup: ");
            sb.append(StringUtil.simpleClassName(this.childGroup));
            sb.append(", ");
        }
        synchronized (this.childOptions) {
            if (!this.childOptions.isEmpty()) {
                sb.append("childOptions: ");
                sb.append(this.childOptions);
                sb.append(", ");
            }
        }
        synchronized (this.childAttrs) {
            if (!this.childAttrs.isEmpty()) {
                sb.append("childAttrs: ");
                sb.append(this.childAttrs);
                sb.append(", ");
            }
        }
        if (this.childHandler != null) {
            sb.append("childHandler: ");
            sb.append(this.childHandler);
            sb.append(", ");
        }
        if (sb.charAt(sb.length() - 1) == '(') {
            sb.append(')');
        } else {
            sb.setCharAt(sb.length() - 2, ')');
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
