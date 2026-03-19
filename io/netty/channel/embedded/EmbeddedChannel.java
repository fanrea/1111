package io.netty.channel.embedded;

import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.RecyclableArrayList;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class EmbeddedChannel extends AbstractChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ChannelConfig config;
    private Queue<Object> inboundMessages;
    private Throwable lastException;
    private final EmbeddedEventLoop loop;
    private final ChannelMetadata metadata;
    private Queue<Object> outboundMessages;
    private State state;
    private static final SocketAddress LOCAL_ADDRESS = new EmbeddedSocketAddress();
    private static final SocketAddress REMOTE_ADDRESS = new EmbeddedSocketAddress();
    private static final ChannelHandler[] EMPTY_HANDLERS = new ChannelHandler[0];
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) EmbeddedChannel.class);
    private static final ChannelMetadata METADATA_NO_DISCONNECT = new ChannelMetadata(false);
    private static final ChannelMetadata METADATA_DISCONNECT = new ChannelMetadata(true);

    enum State {
        OPEN,
        ACTIVE,
        CLOSED
    }

    @Override // io.netty.channel.AbstractChannel
    public void doBeginRead() {
    }

    @Override // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress) {
    }

    public EmbeddedChannel() {
        this(EMPTY_HANDLERS);
    }

    public EmbeddedChannel(ChannelId channelId) {
        this(channelId, EMPTY_HANDLERS);
    }

    public EmbeddedChannel(ChannelHandler... channelHandlerArr) {
        this(EmbeddedChannelId.INSTANCE, channelHandlerArr);
    }

    public EmbeddedChannel(boolean z, ChannelHandler... channelHandlerArr) {
        this(EmbeddedChannelId.INSTANCE, z, channelHandlerArr);
    }

    public EmbeddedChannel(ChannelId channelId, ChannelHandler... channelHandlerArr) {
        this(channelId, false, channelHandlerArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddedChannel(ChannelId channelId, boolean z, final ChannelHandler... channelHandlerArr) {
        super(null, channelId);
        this.loop = new EmbeddedEventLoop();
        ObjectUtil.checkNotNull(channelHandlerArr, "handlers");
        this.metadata = z ? METADATA_DISCONNECT : METADATA_NO_DISCONNECT;
        this.config = new DefaultChannelConfig(this);
        ChannelPipeline channelPipelinePipeline = pipeline();
        channelPipelinePipeline.addLast(new ChannelInitializer<Channel>() { // from class: io.netty.channel.embedded.EmbeddedChannel.1
            @Override // io.netty.channel.ChannelInitializer
            public void initChannel(Channel channel) {
                ChannelPipeline channelPipelinePipeline2 = channel.pipeline();
                for (ChannelHandler channelHandler : channelHandlerArr) {
                    if (channelHandler == null) {
                        return;
                    }
                    channelPipelinePipeline2.addLast(channelHandler);
                }
            }
        });
        this.loop.register(this);
        channelPipelinePipeline.addLast(new LastInboundHandler());
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return this.metadata;
    }

    @Override // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.state != State.CLOSED;
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public Queue<Object> inboundMessages() {
        if (this.inboundMessages == null) {
            this.inboundMessages = new ArrayDeque();
        }
        return this.inboundMessages;
    }

    @Deprecated
    public Queue<Object> lastInboundBuffer() {
        return inboundMessages();
    }

    public Queue<Object> outboundMessages() {
        if (this.outboundMessages == null) {
            this.outboundMessages = new ArrayDeque();
        }
        return this.outboundMessages;
    }

    @Deprecated
    public Queue<Object> lastOutboundBuffer() {
        return outboundMessages();
    }

    public <T> T readInbound() {
        return (T) poll(this.inboundMessages);
    }

    public <T> T readOutbound() {
        return (T) poll(this.outboundMessages);
    }

    public boolean writeInbound(Object... objArr) throws Throwable {
        ensureOpen();
        if (objArr.length == 0) {
            return isNotEmpty(this.inboundMessages);
        }
        ChannelPipeline channelPipelinePipeline = pipeline();
        for (Object obj : objArr) {
            channelPipelinePipeline.fireChannelRead(obj);
        }
        channelPipelinePipeline.fireChannelReadComplete();
        runPendingTasks();
        checkException();
        return isNotEmpty(this.inboundMessages);
    }

    public boolean writeOutbound(Object... objArr) throws Throwable {
        ensureOpen();
        if (objArr.length == 0) {
            return isNotEmpty(this.outboundMessages);
        }
        RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance(objArr.length);
        try {
            for (Object obj : objArr) {
                if (obj == null) {
                    break;
                }
                recyclableArrayListNewInstance.add(write(obj));
            }
            flush();
            int size = recyclableArrayListNewInstance.size();
            for (int i = 0; i < size; i++) {
                ChannelFuture channelFuture = (ChannelFuture) recyclableArrayListNewInstance.get(i);
                if (channelFuture.cause() != null) {
                    recordException(channelFuture.cause());
                }
            }
            runPendingTasks();
            checkException();
            return isNotEmpty(this.outboundMessages);
        } finally {
            recyclableArrayListNewInstance.recycle();
        }
    }

    public boolean finish() throws Throwable {
        close();
        checkException();
        return isNotEmpty(this.inboundMessages) || isNotEmpty(this.outboundMessages);
    }

    private void finishPendingTasks(boolean z) {
        runPendingTasks();
        if (z) {
            this.loop.cancelScheduledTasks();
        }
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public final ChannelFuture close() {
        return close(newPromise());
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public final ChannelFuture disconnect() {
        return disconnect(newPromise());
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public final ChannelFuture close(ChannelPromise channelPromise) {
        ChannelFuture channelFutureClose = super.close(channelPromise);
        finishPendingTasks(true);
        return channelFutureClose;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public final ChannelFuture disconnect(ChannelPromise channelPromise) {
        ChannelFuture channelFutureDisconnect = super.disconnect(channelPromise);
        finishPendingTasks(!this.metadata.hasDisconnect());
        return channelFutureDisconnect;
    }

    private static boolean isNotEmpty(Queue<Object> queue) {
        return (queue == null || queue.isEmpty()) ? false : true;
    }

    private static Object poll(Queue<Object> queue) {
        if (queue != null) {
            return queue.poll();
        }
        return null;
    }

    public void runPendingTasks() {
        try {
            this.loop.runTasks();
        } catch (Exception e) {
            recordException(e);
        }
        try {
            this.loop.runScheduledTasks();
        } catch (Exception e2) {
            recordException(e2);
        }
    }

    public long runScheduledPendingTasks() {
        try {
            return this.loop.runScheduledTasks();
        } catch (Exception e) {
            recordException(e);
            return this.loop.nextScheduledTask();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordException(Throwable th) {
        if (this.lastException == null) {
            this.lastException = th;
        } else {
            logger.warn("More than one exception was raised. Will report only the first one and log others.", th);
        }
    }

    public void checkException() throws Throwable {
        Throwable th = this.lastException;
        if (th == null) {
            return;
        }
        this.lastException = null;
        PlatformDependent.throwException(th);
    }

    protected final void ensureOpen() throws Throwable {
        if (isOpen()) {
            return;
        }
        recordException(new ClosedChannelException());
        checkException();
    }

    @Override // io.netty.channel.AbstractChannel
    public boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof EmbeddedEventLoop;
    }

    @Override // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        if (isActive()) {
            return LOCAL_ADDRESS;
        }
        return null;
    }

    @Override // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        if (isActive()) {
            return REMOTE_ADDRESS;
        }
        return null;
    }

    @Override // io.netty.channel.AbstractChannel
    public void doRegister() {
        this.state = State.ACTIVE;
    }

    @Override // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        if (this.metadata.hasDisconnect()) {
            return;
        }
        doClose();
    }

    @Override // io.netty.channel.AbstractChannel
    public void doClose() {
        this.state = State.CLOSED;
    }

    @Override // io.netty.channel.AbstractChannel
    public AbstractChannel.AbstractUnsafe newUnsafe() {
        return new DefaultUnsafe();
    }

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) {
        while (true) {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                return;
            }
            ReferenceCountUtil.retain(objCurrent);
            outboundMessages().add(objCurrent);
            channelOutboundBuffer.remove();
        }
    }

    class DefaultUnsafe extends AbstractChannel.AbstractUnsafe {
        private DefaultUnsafe() {
            super();
        }

        @Override // io.netty.channel.Channel.Unsafe
        public void connect(SocketAddress socketAddress, SocketAddress socketAddress2, ChannelPromise channelPromise) {
            safeSetSuccess(channelPromise);
        }
    }

    final class LastInboundHandler extends ChannelInboundHandlerAdapter {
        private LastInboundHandler() {
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public final void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            EmbeddedChannel.this.inboundMessages().add(obj);
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public final void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
            EmbeddedChannel.this.recordException(th);
        }
    }
}
