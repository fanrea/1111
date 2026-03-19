package io.netty.channel;

import io.netty.buffer.ByteBufAllocator;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.ResourceLeakHint;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
abstract class AbstractChannelHandlerContext implements ChannelHandlerContext, ResourceLeakHint {
    private final boolean inbound;
    volatile Runnable invokeChannelReadCompleteTask;
    volatile Runnable invokeChannelWritableStateChangedTask;
    volatile Runnable invokeFlushTask;
    volatile Runnable invokeReadTask;
    final ChannelHandlerInvoker invoker;
    private final String name;
    volatile AbstractChannelHandlerContext next;
    private final boolean outbound;
    private final DefaultChannelPipeline pipeline;
    volatile AbstractChannelHandlerContext prev;
    private boolean removed;
    private ChannelFuture succeededFuture;

    AbstractChannelHandlerContext(DefaultChannelPipeline defaultChannelPipeline, ChannelHandlerInvoker channelHandlerInvoker, String str, boolean z, boolean z2) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        this.pipeline = defaultChannelPipeline;
        this.name = str;
        this.invoker = channelHandlerInvoker;
        this.inbound = z;
        this.outbound = z2;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public Channel channel() {
        return this.pipeline.channel();
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ByteBufAllocator alloc() {
        return channel().config().getAllocator();
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public EventExecutor executor() {
        return invoker().executor();
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerInvoker invoker() {
        ChannelHandlerInvoker channelHandlerInvoker = this.invoker;
        return channelHandlerInvoker == null ? channel().unsafe().invoker() : channelHandlerInvoker;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public String name() {
        return this.name;
    }

    @Override // io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        return channel().attr(attributeKey);
    }

    @Override // io.netty.util.AttributeMap
    public <T> boolean hasAttr(AttributeKey<T> attributeKey) {
        return channel().hasAttr(attributeKey);
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelRegistered() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextInbound = findContextInbound();
        abstractChannelHandlerContextFindContextInbound.invoker().invokeChannelRegistered(abstractChannelHandlerContextFindContextInbound);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelUnregistered() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextInbound = findContextInbound();
        abstractChannelHandlerContextFindContextInbound.invoker().invokeChannelUnregistered(abstractChannelHandlerContextFindContextInbound);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelActive() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextInbound = findContextInbound();
        abstractChannelHandlerContextFindContextInbound.invoker().invokeChannelActive(abstractChannelHandlerContextFindContextInbound);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelInactive() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextInbound = findContextInbound();
        abstractChannelHandlerContextFindContextInbound.invoker().invokeChannelInactive(abstractChannelHandlerContextFindContextInbound);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireExceptionCaught(Throwable th) {
        ChannelHandlerContext channelHandlerContext = this.next;
        channelHandlerContext.invoker().invokeExceptionCaught(channelHandlerContext, th);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireUserEventTriggered(Object obj) {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextInbound = findContextInbound();
        abstractChannelHandlerContextFindContextInbound.invoker().invokeUserEventTriggered(abstractChannelHandlerContextFindContextInbound, obj);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelRead(Object obj) {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextInbound = findContextInbound();
        abstractChannelHandlerContextFindContextInbound.invoker().invokeChannelRead(abstractChannelHandlerContextFindContextInbound, this.pipeline.touch(obj, abstractChannelHandlerContextFindContextInbound));
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelReadComplete() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextInbound = findContextInbound();
        abstractChannelHandlerContextFindContextInbound.invoker().invokeChannelReadComplete(abstractChannelHandlerContextFindContextInbound);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext fireChannelWritabilityChanged() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextInbound = findContextInbound();
        abstractChannelHandlerContextFindContextInbound.invoker().invokeChannelWritabilityChanged(abstractChannelHandlerContextFindContextInbound);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture bind(SocketAddress socketAddress) {
        return bind(socketAddress, newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture connect(SocketAddress socketAddress) {
        return connect(socketAddress, newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2) {
        return connect(socketAddress, socketAddress2, newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture disconnect() {
        return disconnect(newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture close() {
        return close(newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture deregister() {
        return deregister(newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture bind(SocketAddress socketAddress, ChannelPromise channelPromise) {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound();
        abstractChannelHandlerContextFindContextOutbound.invoker().invokeBind(abstractChannelHandlerContextFindContextOutbound, socketAddress, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture connect(SocketAddress socketAddress, ChannelPromise channelPromise) {
        return connect(socketAddress, null, channelPromise);
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound();
        abstractChannelHandlerContextFindContextOutbound.invoker().invokeConnect(abstractChannelHandlerContextFindContextOutbound, socketAddress, socketAddress2, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture disconnect(ChannelPromise channelPromise) {
        if (!channel().metadata().hasDisconnect()) {
            return close(channelPromise);
        }
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound();
        abstractChannelHandlerContextFindContextOutbound.invoker().invokeDisconnect(abstractChannelHandlerContextFindContextOutbound, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture close(ChannelPromise channelPromise) {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound();
        abstractChannelHandlerContextFindContextOutbound.invoker().invokeClose(abstractChannelHandlerContextFindContextOutbound, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture deregister(ChannelPromise channelPromise) {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound();
        abstractChannelHandlerContextFindContextOutbound.invoker().invokeDeregister(abstractChannelHandlerContextFindContextOutbound, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext read() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound();
        abstractChannelHandlerContextFindContextOutbound.invoker().invokeRead(abstractChannelHandlerContextFindContextOutbound);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture write(Object obj) {
        return write(obj, newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture write(Object obj, ChannelPromise channelPromise) {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound();
        abstractChannelHandlerContextFindContextOutbound.invoker().invokeWrite(abstractChannelHandlerContextFindContextOutbound, this.pipeline.touch(obj, abstractChannelHandlerContextFindContextOutbound), channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelHandlerContext flush() {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound();
        abstractChannelHandlerContextFindContextOutbound.invoker().invokeFlush(abstractChannelHandlerContextFindContextOutbound);
        return this;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture writeAndFlush(Object obj, ChannelPromise channelPromise) {
        AbstractChannelHandlerContext abstractChannelHandlerContextFindContextOutbound = findContextOutbound();
        ChannelHandlerInvoker channelHandlerInvokerInvoker = abstractChannelHandlerContextFindContextOutbound.invoker();
        channelHandlerInvokerInvoker.invokeWrite(abstractChannelHandlerContextFindContextOutbound, this.pipeline.touch(obj, abstractChannelHandlerContextFindContextOutbound), channelPromise);
        channelHandlerInvokerInvoker.invokeFlush(abstractChannelHandlerContextFindContextOutbound);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture writeAndFlush(Object obj) {
        return writeAndFlush(obj, newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelPromise newPromise() {
        return new DefaultChannelPromise(channel(), executor());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(channel(), executor());
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture newSucceededFuture() {
        ChannelFuture channelFuture = this.succeededFuture;
        if (channelFuture != null) {
            return channelFuture;
        }
        SucceededChannelFuture succeededChannelFuture = new SucceededChannelFuture(channel(), executor());
        this.succeededFuture = succeededChannelFuture;
        return succeededChannelFuture;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelFuture newFailedFuture(Throwable th) {
        return new FailedChannelFuture(channel(), executor(), th);
    }

    private AbstractChannelHandlerContext findContextInbound() {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this;
        do {
            abstractChannelHandlerContext = abstractChannelHandlerContext.next;
        } while (!abstractChannelHandlerContext.inbound);
        return abstractChannelHandlerContext;
    }

    private AbstractChannelHandlerContext findContextOutbound() {
        AbstractChannelHandlerContext abstractChannelHandlerContext = this;
        do {
            abstractChannelHandlerContext = abstractChannelHandlerContext.prev;
        } while (!abstractChannelHandlerContext.outbound);
        return abstractChannelHandlerContext;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public ChannelPromise voidPromise() {
        return channel().voidPromise();
    }

    void setRemoved() {
        this.removed = true;
    }

    @Override // io.netty.channel.ChannelHandlerContext
    public boolean isRemoved() {
        return this.removed;
    }

    @Override // io.netty.util.ResourceLeakHint
    public String toHintString() {
        return "'" + this.name + "' will handle the message from this point.";
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ChannelHandlerContext.class) + '(' + this.name + ", " + channel() + ')';
    }
}
