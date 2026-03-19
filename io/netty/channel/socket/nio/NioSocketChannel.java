package io.netty.channel.socket.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioByteChannel;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.socket.DefaultSocketChannelConfig;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.OneTimeTask;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class NioSocketChannel extends AbstractNioByteChannel implements SocketChannel {
    private final SocketChannelConfig config;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final SelectorProvider DEFAULT_SELECTOR_PROVIDER = SelectorProvider.provider();

    private static java.nio.channels.SocketChannel newSocket(SelectorProvider selectorProvider) {
        try {
            return selectorProvider.openSocketChannel();
        } catch (IOException e) {
            throw new ChannelException("Failed to open a socket.", e);
        }
    }

    public NioSocketChannel() {
        this(DEFAULT_SELECTOR_PROVIDER);
    }

    public NioSocketChannel(SelectorProvider selectorProvider) {
        this(newSocket(selectorProvider));
    }

    public NioSocketChannel(java.nio.channels.SocketChannel socketChannel) {
        this(null, socketChannel);
    }

    public NioSocketChannel(Channel channel, java.nio.channels.SocketChannel socketChannel) {
        super(channel, socketChannel);
        this.config = new NioSocketChannelConfig(this, socketChannel.socket());
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public ServerSocketChannel parent() {
        return (ServerSocketChannel) super.parent();
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.Channel
    public SocketChannelConfig config() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.nio.AbstractNioChannel
    public java.nio.channels.SocketChannel javaChannel() {
        return (java.nio.channels.SocketChannel) super.javaChannel();
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        java.nio.channels.SocketChannel socketChannelJavaChannel = javaChannel();
        return socketChannelJavaChannel.isOpen() && socketChannelJavaChannel.isConnected();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.socket.SocketChannel
    public boolean isInputShutdown() {
        return super.isInputShutdown();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return (InetSocketAddress) super.remoteAddress();
    }

    @Override // io.netty.channel.socket.SocketChannel
    public boolean isOutputShutdown() {
        return javaChannel().socket().isOutputShutdown() || !isActive();
    }

    @Override // io.netty.channel.socket.SocketChannel
    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    @Override // io.netty.channel.socket.SocketChannel
    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        Executor executorPrepareToClose = ((NioSocketChannelUnsafe) unsafe()).prepareToClose();
        if (executorPrepareToClose != null) {
            executorPrepareToClose.execute(new OneTimeTask() { // from class: io.netty.channel.socket.nio.NioSocketChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    NioSocketChannel.this.shutdownOutput0(channelPromise);
                }
            });
        } else {
            NioEventLoop nioEventLoopEventLoop = eventLoop();
            if (nioEventLoopEventLoop.inEventLoop()) {
                shutdownOutput0(channelPromise);
            } else {
                nioEventLoopEventLoop.execute(new OneTimeTask() { // from class: io.netty.channel.socket.nio.NioSocketChannel.2
                    @Override // java.lang.Runnable
                    public void run() {
                        NioSocketChannel.this.shutdownOutput0(channelPromise);
                    }
                });
            }
        }
        return channelPromise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownOutput0(ChannelPromise channelPromise) {
        try {
            javaChannel().socket().shutdownOutput();
            channelPromise.setSuccess();
        } catch (Throwable th) {
            channelPromise.setFailure(th);
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public SocketAddress localAddress0() {
        return javaChannel().socket().getLocalSocketAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    public SocketAddress remoteAddress0() {
        return javaChannel().socket().getRemoteSocketAddress();
    }

    @Override // io.netty.channel.AbstractChannel
    public void doBind(SocketAddress socketAddress) throws IOException {
        javaChannel().socket().bind(socketAddress);
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    public boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws IOException {
        if (socketAddress2 != null) {
            javaChannel().socket().bind(socketAddress2);
        }
        try {
            boolean zConnect = javaChannel().connect(socketAddress);
            if (!zConnect) {
                selectionKey().interestOps(8);
            }
            return zConnect;
        } catch (Throwable th) {
            doClose();
            throw th;
        }
    }

    @Override // io.netty.channel.nio.AbstractNioChannel
    public void doFinishConnect() {
        if (!javaChannel().finishConnect()) {
            throw new Error();
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public void doDisconnect() {
        doClose();
    }

    @Override // io.netty.channel.nio.AbstractNioChannel, io.netty.channel.AbstractChannel
    public void doClose() {
        super.doClose();
        javaChannel().close();
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    public int doReadBytes(ByteBuf byteBuf) {
        RecvByteBufAllocator.Handle handleRecvBufAllocHandle = unsafe().recvBufAllocHandle();
        handleRecvBufAllocHandle.attemptedBytesRead(byteBuf.writableBytes());
        return byteBuf.writeBytes(javaChannel(), handleRecvBufAllocHandle.attemptedBytesRead());
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    public int doWriteBytes(ByteBuf byteBuf) {
        return byteBuf.readBytes(javaChannel(), byteBuf.readableBytes());
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel
    public long doWriteFileRegion(FileRegion fileRegion) {
        return fileRegion.transferTo(javaChannel(), fileRegion.transfered());
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel, io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Throwable {
        long j;
        ChannelOutboundBuffer channelOutboundBuffer2;
        while (channelOutboundBuffer.size() != 0) {
            ByteBuffer[] byteBufferArrNioBuffers = channelOutboundBuffer.nioBuffers();
            int iNioBufferCount = channelOutboundBuffer.nioBufferCount();
            long jNioBufferSize = channelOutboundBuffer.nioBufferSize();
            java.nio.channels.SocketChannel socketChannelJavaChannel = javaChannel();
            if (iNioBufferCount == 0) {
                super.doWrite(channelOutboundBuffer);
                return;
            }
            boolean z = false;
            boolean z2 = true;
            if (iNioBufferCount == 1) {
                ByteBuffer byteBuffer = byteBufferArrNioBuffers[0];
                j = 0;
                for (int writeSpinCount = config().getWriteSpinCount() - 1; writeSpinCount >= 0; writeSpinCount--) {
                    int iWrite = socketChannelJavaChannel.write(byteBuffer);
                    if (iWrite == 0) {
                        channelOutboundBuffer2 = channelOutboundBuffer;
                        break;
                    }
                    long j2 = iWrite;
                    jNioBufferSize -= j2;
                    j += j2;
                    if (jNioBufferSize == 0) {
                        channelOutboundBuffer2 = channelOutboundBuffer;
                        z = true;
                        break;
                    }
                }
                channelOutboundBuffer2 = channelOutboundBuffer;
                z2 = false;
            } else {
                j = 0;
                for (int writeSpinCount2 = config().getWriteSpinCount() - 1; writeSpinCount2 >= 0; writeSpinCount2--) {
                    long jWrite = socketChannelJavaChannel.write(byteBufferArrNioBuffers, 0, iNioBufferCount);
                    if (jWrite == 0) {
                        channelOutboundBuffer2 = channelOutboundBuffer;
                        break;
                    }
                    jNioBufferSize -= jWrite;
                    j += jWrite;
                    if (jNioBufferSize == 0) {
                        channelOutboundBuffer2 = channelOutboundBuffer;
                        z = true;
                        break;
                    }
                }
                channelOutboundBuffer2 = channelOutboundBuffer;
                z2 = false;
            }
            channelOutboundBuffer2.removeBytes(j);
            if (!z) {
                incompleteWrite(z2);
                return;
            }
        }
        clearOpWrite();
    }

    @Override // io.netty.channel.nio.AbstractNioByteChannel, io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioSocketChannelUnsafe();
    }

    final class NioSocketChannelUnsafe extends AbstractNioByteChannel.NioByteUnsafe {
        private NioSocketChannelUnsafe() {
            super();
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        public final Executor prepareToClose() {
            try {
                if (!NioSocketChannel.this.javaChannel().isOpen() || NioSocketChannel.this.config().getSoLinger() <= 0) {
                    return null;
                }
                NioSocketChannel.this.doDeregister();
                return GlobalEventExecutor.INSTANCE;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    final class NioSocketChannelConfig extends DefaultSocketChannelConfig {
        private NioSocketChannelConfig(NioSocketChannel nioSocketChannel, Socket socket) {
            super(nioSocketChannel, socket);
        }

        @Override // io.netty.channel.DefaultChannelConfig
        public final void autoReadCleared() {
            NioSocketChannel.this.setReadPending(false);
        }
    }
}
