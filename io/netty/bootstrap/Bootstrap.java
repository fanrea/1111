package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.resolver.AddressResolver;
import io.netty.resolver.AddressResolverGroup;
import io.netty.resolver.DefaultAddressResolverGroup;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.OneTimeTask;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Bootstrap extends AbstractBootstrap<Bootstrap, Channel> {
    private volatile SocketAddress remoteAddress;
    private volatile AddressResolverGroup<SocketAddress> resolver;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Bootstrap.class);
    private static final AddressResolverGroup<?> DEFAULT_RESOLVER = DefaultAddressResolverGroup.INSTANCE;

    public Bootstrap() {
        this.resolver = DEFAULT_RESOLVER;
    }

    private Bootstrap(Bootstrap bootstrap) {
        super(bootstrap);
        this.resolver = DEFAULT_RESOLVER;
        this.resolver = bootstrap.resolver;
        this.remoteAddress = bootstrap.remoteAddress;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Bootstrap resolver(AddressResolverGroup<?> addressResolverGroup) {
        if (addressResolverGroup == 0) {
            throw new NullPointerException("resolver");
        }
        this.resolver = addressResolverGroup;
        return this;
    }

    public Bootstrap remoteAddress(SocketAddress socketAddress) {
        this.remoteAddress = socketAddress;
        return this;
    }

    public Bootstrap remoteAddress(String str, int i) {
        this.remoteAddress = InetSocketAddress.createUnresolved(str, i);
        return this;
    }

    public Bootstrap remoteAddress(InetAddress inetAddress, int i) {
        this.remoteAddress = new InetSocketAddress(inetAddress, i);
        return this;
    }

    public ChannelFuture connect() {
        validate();
        SocketAddress socketAddress = this.remoteAddress;
        if (socketAddress == null) {
            throw new IllegalStateException("remoteAddress not set");
        }
        return doResolveAndConnect(socketAddress, localAddress());
    }

    public ChannelFuture connect(String str, int i) {
        return connect(InetSocketAddress.createUnresolved(str, i));
    }

    public ChannelFuture connect(InetAddress inetAddress, int i) {
        return connect(new InetSocketAddress(inetAddress, i));
    }

    public ChannelFuture connect(SocketAddress socketAddress) {
        if (socketAddress == null) {
            throw new NullPointerException("remoteAddress");
        }
        validate();
        return doResolveAndConnect(socketAddress, localAddress());
    }

    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        if (socketAddress == null) {
            throw new NullPointerException("remoteAddress");
        }
        validate();
        return doResolveAndConnect(socketAddress, socketAddress2);
    }

    private ChannelFuture doResolveAndConnect(SocketAddress socketAddress, final SocketAddress socketAddress2) {
        final ChannelFuture channelFutureInitAndRegister = initAndRegister();
        if (channelFutureInitAndRegister.cause() != null) {
            return channelFutureInitAndRegister;
        }
        final Channel channel = channelFutureInitAndRegister.channel();
        AddressResolver<T> resolver = this.resolver.getResolver(channel.eventLoop());
        if (!resolver.isSupported(socketAddress) || resolver.isResolved(socketAddress)) {
            return doConnect(socketAddress, socketAddress2, channelFutureInitAndRegister, channel.newPromise());
        }
        Future futureResolve = resolver.resolve(socketAddress);
        Throwable thCause = futureResolve.cause();
        if (thCause != null) {
            channel.close();
            return channel.newFailedFuture(thCause);
        }
        if (futureResolve.isDone()) {
            return doConnect((SocketAddress) futureResolve.getNow(), socketAddress2, channelFutureInitAndRegister, channel.newPromise());
        }
        final ChannelPromise channelPromiseNewPromise = channel.newPromise();
        futureResolve.addListener(new FutureListener<SocketAddress>() { // from class: io.netty.bootstrap.Bootstrap.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<SocketAddress> future) {
                if (future.cause() == null) {
                    Bootstrap.doConnect(future.getNow(), socketAddress2, channelFutureInitAndRegister, channelPromiseNewPromise);
                } else {
                    channel.close();
                    channelPromiseNewPromise.setFailure(future.cause());
                }
            }
        });
        return channelPromiseNewPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ChannelFuture doConnect(final SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        if (channelFuture.isDone()) {
            doConnect0(socketAddress, socketAddress2, channelFuture, channelPromise);
        } else {
            channelFuture.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.Bootstrap.2
                @Override // io.netty.util.concurrent.GenericFutureListener
                public final void operationComplete(ChannelFuture channelFuture2) {
                    Bootstrap.doConnect0(socketAddress, socketAddress2, channelFuture, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doConnect0(final SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        final Channel channel = channelPromise.channel();
        channel.eventLoop().execute(new OneTimeTask() { // from class: io.netty.bootstrap.Bootstrap.3
            @Override // java.lang.Runnable
            public final void run() {
                if (channelFuture.isSuccess()) {
                    SocketAddress socketAddress3 = socketAddress2;
                    if (socketAddress3 == null) {
                        channel.connect(socketAddress, channelPromise);
                    } else {
                        channel.connect(socketAddress, socketAddress3, channelPromise);
                    }
                    channelPromise.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
                    return;
                }
                channelPromise.setFailure(channelFuture.cause());
            }
        });
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    void init(Channel channel) {
        channel.pipeline().addLast(handler());
        Map<ChannelOption<?>, Object> mapOptions = options();
        synchronized (mapOptions) {
            for (Map.Entry<ChannelOption<?>, Object> entry : mapOptions.entrySet()) {
                try {
                    if (!channel.config().setOption(entry.getKey(), entry.getValue())) {
                        logger.warn("Unknown channel option: " + entry);
                    }
                } catch (Throwable th) {
                    logger.warn("Failed to set a channel option: " + channel, th);
                }
            }
        }
        Map<AttributeKey<?>, Object> mapAttrs = attrs();
        synchronized (mapAttrs) {
            for (Map.Entry<AttributeKey<?>, Object> entry2 : mapAttrs.entrySet()) {
                channel.attr(entry2.getKey()).set(entry2.getValue());
            }
        }
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public Bootstrap validate() {
        super.validate();
        if (handler() != null) {
            return this;
        }
        throw new IllegalStateException("handler not set");
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    /* renamed from: clone */
    public Bootstrap mo1516clone() {
        return new Bootstrap(this);
    }

    public Bootstrap clone(EventLoopGroup eventLoopGroup) {
        Bootstrap bootstrap = new Bootstrap(this);
        bootstrap.group = eventLoopGroup;
        return bootstrap;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public String toString() {
        if (this.remoteAddress == null) {
            return super.toString();
        }
        StringBuilder sb = new StringBuilder(super.toString());
        sb.setLength(sb.length() - 1);
        sb.append(", remoteAddress: ");
        sb.append(this.remoteAddress);
        sb.append(')');
        return sb.toString();
    }
}
