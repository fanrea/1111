package io.netty.channel.embedded;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.channel.ChannelHandlerInvokerUtil;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import java.net.SocketAddress;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class EmbeddedEventLoop extends AbstractScheduledEventExecutor implements ChannelHandlerInvoker, EventLoop {
    private final Queue<Runnable> tasks = new ArrayDeque(2);

    @Override // io.netty.channel.EventLoop
    public final ChannelHandlerInvoker asInvoker() {
        return this;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return false;
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final EventExecutor executor() {
        return this;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor
    public final boolean inEventLoop() {
        return true;
    }

    @Override // io.netty.util.concurrent.EventExecutor
    public final boolean inEventLoop(Thread thread) {
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return false;
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public final boolean isShuttingDown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return false;
    }

    EmbeddedEventLoop() {
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.channel.EventLoop
    public final EventLoopGroup parent() {
        return (EventLoopGroup) super.parent();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutor, io.netty.util.concurrent.EventExecutorGroup, io.netty.channel.EventLoopGroup
    public final EventLoop next() {
        return (EventLoop) super.next();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("command");
        }
        this.tasks.add(runnable);
    }

    final void runTasks() {
        while (true) {
            Runnable runnablePoll = this.tasks.poll();
            if (runnablePoll == null) {
                return;
            } else {
                runnablePoll.run();
            }
        }
    }

    final long runScheduledTasks() {
        long jNanoTime = AbstractScheduledEventExecutor.nanoTime();
        while (true) {
            Runnable runnablePollScheduledTask = pollScheduledTask(jNanoTime);
            if (runnablePollScheduledTask == null) {
                return nextScheduledTaskNano();
            }
            runnablePollScheduledTask.run();
        }
    }

    final long nextScheduledTask() {
        return nextScheduledTaskNano();
    }

    @Override // io.netty.util.concurrent.AbstractScheduledEventExecutor
    public final void cancelScheduledTasks() {
        super.cancelScheduledTasks();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public final Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.util.concurrent.EventExecutorGroup
    public final Future<?> terminationFuture() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.EventLoopGroup
    public final ChannelFuture register(Channel channel) {
        return register(channel, new DefaultChannelPromise(channel, this));
    }

    @Override // io.netty.channel.EventLoopGroup
    public final ChannelFuture register(Channel channel, ChannelPromise channelPromise) {
        channel.unsafe().register(this, channelPromise);
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeChannelRegistered(ChannelHandlerContext channelHandlerContext) {
        ChannelHandlerInvokerUtil.invokeChannelRegisteredNow(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeChannelUnregistered(ChannelHandlerContext channelHandlerContext) {
        ChannelHandlerInvokerUtil.invokeChannelUnregisteredNow(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeChannelActive(ChannelHandlerContext channelHandlerContext) {
        ChannelHandlerInvokerUtil.invokeChannelActiveNow(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeChannelInactive(ChannelHandlerContext channelHandlerContext) {
        ChannelHandlerInvokerUtil.invokeChannelInactiveNow(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeExceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        ChannelHandlerInvokerUtil.invokeExceptionCaughtNow(channelHandlerContext, th);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeUserEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) {
        ChannelHandlerInvokerUtil.invokeUserEventTriggeredNow(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeChannelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        ChannelHandlerInvokerUtil.invokeChannelReadNow(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeChannelReadComplete(ChannelHandlerContext channelHandlerContext) {
        ChannelHandlerInvokerUtil.invokeChannelReadCompleteNow(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeChannelWritabilityChanged(ChannelHandlerContext channelHandlerContext) {
        ChannelHandlerInvokerUtil.invokeChannelWritabilityChangedNow(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeBind(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, ChannelPromise channelPromise) {
        ChannelHandlerInvokerUtil.invokeBindNow(channelHandlerContext, socketAddress, channelPromise);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeConnect(ChannelHandlerContext channelHandlerContext, SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
        ChannelHandlerInvokerUtil.invokeConnectNow(channelHandlerContext, socketAddress, socketAddress2, channelPromise);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeDisconnect(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        ChannelHandlerInvokerUtil.invokeDisconnectNow(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeClose(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        ChannelHandlerInvokerUtil.invokeCloseNow(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeDeregister(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        ChannelHandlerInvokerUtil.invokeDeregisterNow(channelHandlerContext, channelPromise);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeRead(ChannelHandlerContext channelHandlerContext) {
        ChannelHandlerInvokerUtil.invokeReadNow(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeWrite(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        ChannelHandlerInvokerUtil.invokeWriteNow(channelHandlerContext, obj, channelPromise);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public final void invokeFlush(ChannelHandlerContext channelHandlerContext) {
        ChannelHandlerInvokerUtil.invokeFlushNow(channelHandlerContext);
    }
}
