package io.netty.channel.nio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.AbstractNioChannel;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class AbstractNioMessageChannel extends AbstractNioChannel {
    protected boolean continueOnWriteError() {
        return false;
    }

    protected abstract int doReadMessages(List<Object> list);

    protected abstract boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer);

    protected AbstractNioMessageChannel(Channel channel, SelectableChannel selectableChannel, int i) {
        super(channel, selectableChannel, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioMessageUnsafe();
    }

    final class NioMessageUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Object> readBuf;

        private NioMessageUnsafe() {
            super();
            this.readBuf = new ArrayList();
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void read() {
            int i;
            boolean z;
            boolean zIsReadPending;
            ChannelConfig channelConfigConfig = AbstractNioMessageChannel.this.config();
            if (!zIsAutoRead) {
                if (!zIsReadPending) {
                    return;
                }
            }
            ChannelPipeline channelPipelinePipeline = AbstractNioMessageChannel.this.pipeline();
            RecvByteBufAllocator.Handle handleRecvBufAllocHandle = AbstractNioMessageChannel.this.unsafe().recvBufAllocHandle();
            handleRecvBufAllocHandle.reset(channelConfigConfig);
            Throwable th = null;
            boolean z2 = true;
            do {
                try {
                    int iDoReadMessages = AbstractNioMessageChannel.this.doReadMessages(this.readBuf);
                    if (iDoReadMessages == 0) {
                        break;
                    }
                    if (iDoReadMessages < 0) {
                        z = true;
                        break;
                    }
                    handleRecvBufAllocHandle.incMessagesRead(iDoReadMessages);
                    if (z2) {
                        AbstractNioMessageChannel.this.setReadPending(false);
                        z2 = false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (handleRecvBufAllocHandle.continueReading());
            z = false;
            try {
                int size = this.readBuf.size();
                for (i = 0; i < size; i++) {
                    channelPipelinePipeline.fireChannelRead(this.readBuf.get(i));
                }
                this.readBuf.clear();
                handleRecvBufAllocHandle.readComplete();
                channelPipelinePipeline.fireChannelReadComplete();
                if (th != null) {
                    if ((th instanceof IOException) && !(th instanceof PortUnreachableException)) {
                        z = !(AbstractNioMessageChannel.this instanceof ServerChannel);
                    }
                    channelPipelinePipeline.fireExceptionCaught(th);
                }
                if (z) {
                    AbstractNioMessageChannel.this.setInputShutdown();
                    if (AbstractNioMessageChannel.this.isOpen()) {
                        close(voidPromise());
                    }
                }
                if (channelConfigConfig.isAutoRead() || AbstractNioMessageChannel.this.isReadPending()) {
                    return;
                }
                removeReadOp();
            } finally {
                if (!channelConfigConfig.isAutoRead() && !AbstractNioMessageChannel.this.isReadPending()) {
                    removeReadOp();
                }
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws IOException {
        SelectionKey selectionKey = selectionKey();
        int iInterestOps = selectionKey.interestOps();
        while (true) {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                if ((iInterestOps & 4) != 0) {
                    selectionKey.interestOps(iInterestOps & (-5));
                    return;
                }
                return;
            }
            boolean z = false;
            try {
                int writeSpinCount = config().getWriteSpinCount() - 1;
                while (true) {
                    if (writeSpinCount < 0) {
                        break;
                    }
                    if (doWriteMessage(objCurrent, channelOutboundBuffer)) {
                        z = true;
                        break;
                    }
                    writeSpinCount--;
                }
            } catch (IOException e) {
                if (!continueOnWriteError()) {
                    throw e;
                }
                channelOutboundBuffer.remove(e);
            }
            if (!z) {
                if ((iInterestOps & 4) == 0) {
                    selectionKey.interestOps(iInterestOps | 4);
                    return;
                }
                return;
            }
            channelOutboundBuffer.remove();
        }
    }
}
