package io.netty.channel;

import androidx.core.app.NotificationCompat;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.Recycler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.internal.OneTimeTask;
import io.netty.util.internal.RecyclableMpscLinkedQueueNode;
import io.netty.util.internal.SystemPropertyUtil;
import java.net.SocketAddress;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DefaultChannelHandlerInvoker implements ChannelHandlerInvoker {
    private final EventExecutor executor;

    public DefaultChannelHandlerInvoker(EventExecutor eventExecutor) {
        if (eventExecutor == null) {
            throw new NullPointerException("executor");
        }
        this.executor = eventExecutor;
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public EventExecutor executor() {
        return this.executor;
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeChannelRegistered(final ChannelHandlerContext channelHandlerContext) {
        if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeChannelRegisteredNow(channelHandlerContext);
        } else {
            this.executor.execute(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.1
                @Override // java.lang.Runnable
                public void run() {
                    ChannelHandlerInvokerUtil.invokeChannelRegisteredNow(channelHandlerContext);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeChannelUnregistered(final ChannelHandlerContext channelHandlerContext) {
        if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeChannelUnregisteredNow(channelHandlerContext);
        } else {
            this.executor.execute(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.2
                @Override // java.lang.Runnable
                public void run() {
                    ChannelHandlerInvokerUtil.invokeChannelUnregisteredNow(channelHandlerContext);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeChannelActive(final ChannelHandlerContext channelHandlerContext) {
        if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeChannelActiveNow(channelHandlerContext);
        } else {
            this.executor.execute(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.3
                @Override // java.lang.Runnable
                public void run() {
                    ChannelHandlerInvokerUtil.invokeChannelActiveNow(channelHandlerContext);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeChannelInactive(final ChannelHandlerContext channelHandlerContext) {
        if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeChannelInactiveNow(channelHandlerContext);
        } else {
            this.executor.execute(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.4
                @Override // java.lang.Runnable
                public void run() {
                    ChannelHandlerInvokerUtil.invokeChannelInactiveNow(channelHandlerContext);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeExceptionCaught(final ChannelHandlerContext channelHandlerContext, final Throwable th) {
        if (th == null) {
            throw new NullPointerException("cause");
        }
        if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeExceptionCaughtNow(channelHandlerContext, th);
            return;
        }
        try {
            this.executor.execute(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.5
                @Override // java.lang.Runnable
                public void run() {
                    ChannelHandlerInvokerUtil.invokeExceptionCaughtNow(channelHandlerContext, th);
                }
            });
        } catch (Throwable th2) {
            if (DefaultChannelPipeline.logger.isWarnEnabled()) {
                DefaultChannelPipeline.logger.warn("Failed to submit an exceptionCaught() event.", th2);
                DefaultChannelPipeline.logger.warn("The exceptionCaught() event that was failed to submit was:", th);
            }
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeUserEventTriggered(final ChannelHandlerContext channelHandlerContext, final Object obj) {
        if (obj == null) {
            throw new NullPointerException(NotificationCompat.CATEGORY_EVENT);
        }
        if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeUserEventTriggeredNow(channelHandlerContext, obj);
        } else {
            safeExecuteInbound(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.6
                @Override // java.lang.Runnable
                public void run() {
                    ChannelHandlerInvokerUtil.invokeUserEventTriggeredNow(channelHandlerContext, obj);
                }
            }, obj);
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeChannelRead(final ChannelHandlerContext channelHandlerContext, final Object obj) {
        if (obj == null) {
            throw new NullPointerException("msg");
        }
        if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeChannelReadNow(channelHandlerContext, obj);
        } else {
            safeExecuteInbound(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.7
                @Override // java.lang.Runnable
                public void run() {
                    ChannelHandlerInvokerUtil.invokeChannelReadNow(channelHandlerContext, obj);
                }
            }, obj);
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeChannelReadComplete(final ChannelHandlerContext channelHandlerContext) {
        if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeChannelReadCompleteNow(channelHandlerContext);
            return;
        }
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) channelHandlerContext;
        Runnable runnable = abstractChannelHandlerContext.invokeChannelReadCompleteTask;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.8
                @Override // java.lang.Runnable
                public void run() {
                    ChannelHandlerInvokerUtil.invokeChannelReadCompleteNow(channelHandlerContext);
                }
            };
            abstractChannelHandlerContext.invokeChannelReadCompleteTask = runnable;
        }
        this.executor.execute(runnable);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeChannelWritabilityChanged(final ChannelHandlerContext channelHandlerContext) {
        if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeChannelWritabilityChangedNow(channelHandlerContext);
            return;
        }
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) channelHandlerContext;
        Runnable runnable = abstractChannelHandlerContext.invokeChannelWritableStateChangedTask;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.9
                @Override // java.lang.Runnable
                public void run() {
                    ChannelHandlerInvokerUtil.invokeChannelWritabilityChangedNow(channelHandlerContext);
                }
            };
            abstractChannelHandlerContext.invokeChannelWritableStateChangedTask = runnable;
        }
        this.executor.execute(runnable);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeBind(final ChannelHandlerContext channelHandlerContext, final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        if (socketAddress == null) {
            throw new NullPointerException("localAddress");
        }
        if (ChannelHandlerInvokerUtil.validatePromise(channelHandlerContext, channelPromise, false)) {
            if (this.executor.inEventLoop()) {
                ChannelHandlerInvokerUtil.invokeBindNow(channelHandlerContext, socketAddress, channelPromise);
            } else {
                safeExecuteOutbound(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.10
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelHandlerInvokerUtil.invokeBindNow(channelHandlerContext, socketAddress, channelPromise);
                    }
                }, channelPromise);
            }
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeConnect(final ChannelHandlerContext channelHandlerContext, final SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        if (socketAddress == null) {
            throw new NullPointerException("remoteAddress");
        }
        if (ChannelHandlerInvokerUtil.validatePromise(channelHandlerContext, channelPromise, false)) {
            if (this.executor.inEventLoop()) {
                ChannelHandlerInvokerUtil.invokeConnectNow(channelHandlerContext, socketAddress, socketAddress2, channelPromise);
            } else {
                safeExecuteOutbound(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.11
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelHandlerInvokerUtil.invokeConnectNow(channelHandlerContext, socketAddress, socketAddress2, channelPromise);
                    }
                }, channelPromise);
            }
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeDisconnect(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) {
        if (ChannelHandlerInvokerUtil.validatePromise(channelHandlerContext, channelPromise, false)) {
            if (this.executor.inEventLoop()) {
                ChannelHandlerInvokerUtil.invokeDisconnectNow(channelHandlerContext, channelPromise);
            } else {
                safeExecuteOutbound(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.12
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelHandlerInvokerUtil.invokeDisconnectNow(channelHandlerContext, channelPromise);
                    }
                }, channelPromise);
            }
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeClose(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) {
        if (ChannelHandlerInvokerUtil.validatePromise(channelHandlerContext, channelPromise, false)) {
            if (this.executor.inEventLoop()) {
                ChannelHandlerInvokerUtil.invokeCloseNow(channelHandlerContext, channelPromise);
            } else {
                safeExecuteOutbound(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.13
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelHandlerInvokerUtil.invokeCloseNow(channelHandlerContext, channelPromise);
                    }
                }, channelPromise);
            }
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeDeregister(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) {
        if (ChannelHandlerInvokerUtil.validatePromise(channelHandlerContext, channelPromise, false)) {
            if (this.executor.inEventLoop()) {
                ChannelHandlerInvokerUtil.invokeDeregisterNow(channelHandlerContext, channelPromise);
            } else {
                safeExecuteOutbound(new OneTimeTask() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.14
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelHandlerInvokerUtil.invokeDeregisterNow(channelHandlerContext, channelPromise);
                    }
                }, channelPromise);
            }
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeRead(final ChannelHandlerContext channelHandlerContext) {
        if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeReadNow(channelHandlerContext);
            return;
        }
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) channelHandlerContext;
        Runnable runnable = abstractChannelHandlerContext.invokeReadTask;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.15
                @Override // java.lang.Runnable
                public void run() {
                    ChannelHandlerInvokerUtil.invokeReadNow(channelHandlerContext);
                }
            };
            abstractChannelHandlerContext.invokeReadTask = runnable;
        }
        this.executor.execute(runnable);
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeWrite(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        if (obj == null) {
            throw new NullPointerException("msg");
        }
        if (!ChannelHandlerInvokerUtil.validatePromise(channelHandlerContext, channelPromise, true)) {
            ReferenceCountUtil.release(obj);
        } else if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeWriteNow(channelHandlerContext, obj, channelPromise);
        } else {
            safeExecuteOutbound(WriteTask.newInstance(channelHandlerContext, obj, channelPromise), channelPromise, obj);
        }
    }

    @Override // io.netty.channel.ChannelHandlerInvoker
    public void invokeFlush(final ChannelHandlerContext channelHandlerContext) {
        if (this.executor.inEventLoop()) {
            ChannelHandlerInvokerUtil.invokeFlushNow(channelHandlerContext);
            return;
        }
        AbstractChannelHandlerContext abstractChannelHandlerContext = (AbstractChannelHandlerContext) channelHandlerContext;
        Runnable runnable = abstractChannelHandlerContext.invokeFlushTask;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.16
                @Override // java.lang.Runnable
                public void run() {
                    ChannelHandlerInvokerUtil.invokeFlushNow(channelHandlerContext);
                }
            };
            abstractChannelHandlerContext.invokeFlushTask = runnable;
        }
        this.executor.execute(runnable);
    }

    private void safeExecuteInbound(Runnable runnable, Object obj) {
        try {
            this.executor.execute(runnable);
        } catch (Throwable th) {
            ReferenceCountUtil.release(obj);
            throw th;
        }
    }

    private void safeExecuteOutbound(Runnable runnable, ChannelPromise channelPromise) {
        try {
            this.executor.execute(runnable);
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    private void safeExecuteOutbound(Runnable runnable, ChannelPromise channelPromise, Object obj) {
        try {
            this.executor.execute(runnable);
        } catch (Throwable th) {
            try {
                channelPromise.setFailure(th);
            } finally {
                ReferenceCountUtil.release(obj);
            }
        }
    }

    static final class WriteTask extends RecyclableMpscLinkedQueueNode<SingleThreadEventLoop.NonWakeupRunnable> implements SingleThreadEventLoop.NonWakeupRunnable {
        private ChannelHandlerContext ctx;
        private Object msg;
        private ChannelPromise promise;
        private int size;
        private static final boolean ESTIMATE_TASK_SIZE_ON_SUBMIT = SystemPropertyUtil.getBoolean("io.netty.transport.estimateSizeOnSubmit", true);
        private static final int WRITE_TASK_OVERHEAD = SystemPropertyUtil.getInt("io.netty.transport.writeTaskSizeOverhead", 48);
        private static final Recycler<WriteTask> RECYCLER = new Recycler<WriteTask>() { // from class: io.netty.channel.DefaultChannelHandlerInvoker.WriteTask.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            /* renamed from: newObject */
            public final WriteTask newObject2(Recycler.Handle<WriteTask> handle) {
                return new WriteTask(handle);
            }
        };

        @Override // io.netty.util.internal.MpscLinkedQueueNode
        public final SingleThreadEventLoop.NonWakeupRunnable value() {
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static WriteTask newInstance(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
            ChannelOutboundBuffer channelOutboundBufferOutboundBuffer;
            WriteTask writeTask = RECYCLER.get();
            writeTask.ctx = channelHandlerContext;
            writeTask.msg = obj;
            writeTask.promise = channelPromise;
            if (ESTIMATE_TASK_SIZE_ON_SUBMIT && (channelOutboundBufferOutboundBuffer = channelHandlerContext.channel().unsafe().outboundBuffer()) != null) {
                writeTask.size = ((AbstractChannel) channelHandlerContext.channel()).estimatorHandle().size(obj) + WRITE_TASK_OVERHEAD;
                channelOutboundBufferOutboundBuffer.incrementPendingOutboundBytes(writeTask.size);
            } else {
                writeTask.size = 0;
            }
            return writeTask;
        }

        private WriteTask(Recycler.Handle<WriteTask> handle) {
            super(handle);
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                ChannelOutboundBuffer channelOutboundBufferOutboundBuffer = this.ctx.channel().unsafe().outboundBuffer();
                if (ESTIMATE_TASK_SIZE_ON_SUBMIT && channelOutboundBufferOutboundBuffer != null) {
                    channelOutboundBufferOutboundBuffer.decrementPendingOutboundBytes(this.size);
                }
                ChannelHandlerInvokerUtil.invokeWriteNow(this.ctx, this.msg, this.promise);
            } finally {
                this.ctx = null;
                this.msg = null;
                this.promise = null;
            }
        }
    }
}
