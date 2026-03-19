package io.netty.bootstrap;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ReflectiveChannelFactory;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.OneTimeTask;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class AbstractBootstrap<B extends AbstractBootstrap<B, C>, C extends Channel> implements Cloneable {
    private volatile ChannelFactory<? extends C> channelFactory;
    volatile EventLoopGroup group;
    private volatile ChannelHandler handler;
    private volatile SocketAddress localAddress;
    private final Map<ChannelOption<?>, Object> options = new LinkedHashMap();
    private final Map<AttributeKey<?>, Object> attrs = new LinkedHashMap();

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public abstract B mo1516clone();

    abstract void init(Channel channel);

    AbstractBootstrap() {
    }

    AbstractBootstrap(AbstractBootstrap<B, C> abstractBootstrap) {
        this.group = abstractBootstrap.group;
        this.channelFactory = abstractBootstrap.channelFactory;
        this.handler = abstractBootstrap.handler;
        this.localAddress = abstractBootstrap.localAddress;
        synchronized (abstractBootstrap.options) {
            this.options.putAll(abstractBootstrap.options);
        }
        synchronized (abstractBootstrap.attrs) {
            this.attrs.putAll(abstractBootstrap.attrs);
        }
    }

    public B group(EventLoopGroup eventLoopGroup) {
        if (eventLoopGroup == null) {
            throw new NullPointerException("group");
        }
        if (this.group != null) {
            throw new IllegalStateException("group set already");
        }
        this.group = eventLoopGroup;
        return this;
    }

    public B channel(Class<? extends C> cls) {
        if (cls == null) {
            throw new NullPointerException("channelClass");
        }
        return (B) channelFactory((io.netty.channel.ChannelFactory) new ReflectiveChannelFactory(cls));
    }

    @Deprecated
    public B channelFactory(ChannelFactory<? extends C> channelFactory) {
        if (channelFactory == null) {
            throw new NullPointerException("channelFactory");
        }
        if (this.channelFactory != null) {
            throw new IllegalStateException("channelFactory set already");
        }
        this.channelFactory = channelFactory;
        return this;
    }

    public B channelFactory(io.netty.channel.ChannelFactory<? extends C> channelFactory) {
        return (B) channelFactory((ChannelFactory) channelFactory);
    }

    public B localAddress(SocketAddress socketAddress) {
        this.localAddress = socketAddress;
        return this;
    }

    public B localAddress(int i) {
        return (B) localAddress(new InetSocketAddress(i));
    }

    public B localAddress(String str, int i) {
        return (B) localAddress(new InetSocketAddress(str, i));
    }

    public B localAddress(InetAddress inetAddress, int i) {
        return (B) localAddress(new InetSocketAddress(inetAddress, i));
    }

    public <T> B option(ChannelOption<T> channelOption, T t) {
        if (channelOption == null) {
            throw new NullPointerException("option");
        }
        if (t == null) {
            synchronized (this.options) {
                this.options.remove(channelOption);
            }
        } else {
            synchronized (this.options) {
                this.options.put(channelOption, t);
            }
        }
        return this;
    }

    public <T> B attr(AttributeKey<T> attributeKey, T t) {
        if (attributeKey == null) {
            throw new NullPointerException("key");
        }
        if (t == null) {
            synchronized (this.attrs) {
                this.attrs.remove(attributeKey);
            }
        } else {
            synchronized (this.attrs) {
                this.attrs.put(attributeKey, t);
            }
        }
        return this;
    }

    public B validate() {
        if (this.group == null) {
            throw new IllegalStateException("group not set");
        }
        if (this.channelFactory != null) {
            return this;
        }
        throw new IllegalStateException("channel or channelFactory not set");
    }

    public ChannelFuture register() {
        validate();
        return initAndRegister();
    }

    public ChannelFuture bind() {
        validate();
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress == null) {
            throw new IllegalStateException("localAddress not set");
        }
        return doBind(socketAddress);
    }

    public ChannelFuture bind(int i) {
        return bind(new InetSocketAddress(i));
    }

    public ChannelFuture bind(String str, int i) {
        return bind(new InetSocketAddress(str, i));
    }

    public ChannelFuture bind(InetAddress inetAddress, int i) {
        return bind(new InetSocketAddress(inetAddress, i));
    }

    public ChannelFuture bind(SocketAddress socketAddress) {
        validate();
        if (socketAddress == null) {
            throw new NullPointerException("localAddress");
        }
        return doBind(socketAddress);
    }

    private ChannelFuture doBind(final SocketAddress socketAddress) {
        final ChannelFuture channelFutureInitAndRegister = initAndRegister();
        final Channel channel = channelFutureInitAndRegister.channel();
        if (channelFutureInitAndRegister.cause() != null) {
            return channelFutureInitAndRegister;
        }
        if (channelFutureInitAndRegister.isDone()) {
            ChannelPromise channelPromiseNewPromise = channel.newPromise();
            doBind0(channelFutureInitAndRegister, channel, socketAddress, channelPromiseNewPromise);
            return channelPromiseNewPromise;
        }
        final PendingRegistrationPromise pendingRegistrationPromise = new PendingRegistrationPromise(channel);
        channelFutureInitAndRegister.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.AbstractBootstrap.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                Throwable thCause = channelFuture.cause();
                if (thCause != null) {
                    pendingRegistrationPromise.setFailure(thCause);
                } else {
                    pendingRegistrationPromise.executor = channel.eventLoop();
                }
                AbstractBootstrap.doBind0(channelFutureInitAndRegister, channel, socketAddress, pendingRegistrationPromise);
            }
        });
        return pendingRegistrationPromise;
    }

    final ChannelFuture initAndRegister() {
        Channel channelNewChannel = channelFactory().newChannel();
        try {
            init(channelNewChannel);
            ChannelFuture channelFutureRegister = group().register(channelNewChannel);
            if (channelFutureRegister.cause() != null) {
                if (channelNewChannel.isRegistered()) {
                    channelNewChannel.close();
                } else {
                    channelNewChannel.unsafe().closeForcibly();
                }
            }
            return channelFutureRegister;
        } catch (Throwable th) {
            channelNewChannel.unsafe().closeForcibly();
            return new DefaultChannelPromise(channelNewChannel, GlobalEventExecutor.INSTANCE).setFailure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doBind0(final ChannelFuture channelFuture, final Channel channel, final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        channel.eventLoop().execute(new OneTimeTask() { // from class: io.netty.bootstrap.AbstractBootstrap.2
            @Override // java.lang.Runnable
            public final void run() {
                if (channelFuture.isSuccess()) {
                    channel.bind(socketAddress, channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE_ON_FAILURE);
                } else {
                    channelPromise.setFailure(channelFuture.cause());
                }
            }
        });
    }

    public B handler(ChannelHandler channelHandler) {
        if (channelHandler == null) {
            throw new NullPointerException("handler");
        }
        this.handler = channelHandler;
        return this;
    }

    final SocketAddress localAddress() {
        return this.localAddress;
    }

    final ChannelFactory<? extends C> channelFactory() {
        return this.channelFactory;
    }

    final ChannelHandler handler() {
        return this.handler;
    }

    public EventLoopGroup group() {
        return this.group;
    }

    final Map<ChannelOption<?>, Object> options() {
        return this.options;
    }

    final Map<AttributeKey<?>, Object> attrs() {
        return this.attrs;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        if (this.group != null) {
            sb.append("group: ");
            sb.append(StringUtil.simpleClassName(this.group));
            sb.append(", ");
        }
        if (this.channelFactory != null) {
            sb.append("channelFactory: ");
            sb.append(this.channelFactory);
            sb.append(", ");
        }
        if (this.localAddress != null) {
            sb.append("localAddress: ");
            sb.append(this.localAddress);
            sb.append(", ");
        }
        synchronized (this.options) {
            if (!this.options.isEmpty()) {
                sb.append("options: ");
                sb.append(this.options);
                sb.append(", ");
            }
        }
        synchronized (this.attrs) {
            if (!this.attrs.isEmpty()) {
                sb.append("attrs: ");
                sb.append(this.attrs);
                sb.append(", ");
            }
        }
        if (this.handler != null) {
            sb.append("handler: ");
            sb.append(this.handler);
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

    static final class PendingRegistrationPromise extends DefaultChannelPromise {
        private volatile EventExecutor executor;

        private PendingRegistrationPromise(Channel channel) {
            super(channel);
        }

        @Override // io.netty.channel.DefaultChannelPromise, io.netty.util.concurrent.DefaultPromise
        public final EventExecutor executor() {
            EventExecutor eventExecutor = this.executor;
            return eventExecutor != null ? eventExecutor : GlobalEventExecutor.INSTANCE;
        }
    }
}
