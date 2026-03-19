package io.netty.channel.oio;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.RecvByteBufAllocator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class AbstractOioMessageChannel extends AbstractOioChannel {
    private final List<Object> readBuf;

    protected abstract int doReadMessages(List<Object> list);

    protected AbstractOioMessageChannel(Channel channel) {
        super(channel);
        this.readBuf = new ArrayList();
    }

    @Override // io.netty.channel.oio.AbstractOioChannel
    protected void doRead() {
        boolean z;
        ChannelConfig channelConfigConfig = config();
        if (channelConfigConfig.isAutoRead() || isReadPending()) {
            setReadPending(false);
            ChannelPipeline channelPipelinePipeline = pipeline();
            RecvByteBufAllocator.Handle handleRecvBufAllocHandle = unsafe().recvBufAllocHandle();
            handleRecvBufAllocHandle.reset(channelConfigConfig);
            Throwable th = null;
            do {
                try {
                    int iDoReadMessages = doReadMessages(this.readBuf);
                    if (iDoReadMessages == 0) {
                        break;
                    }
                    if (iDoReadMessages < 0) {
                        z = true;
                        break;
                    }
                    handleRecvBufAllocHandle.incMessagesRead(iDoReadMessages);
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (handleRecvBufAllocHandle.continueReading());
            z = false;
            int size = this.readBuf.size();
            for (int i = 0; i < size; i++) {
                channelPipelinePipeline.fireChannelRead(this.readBuf.get(i));
            }
            this.readBuf.clear();
            handleRecvBufAllocHandle.readComplete();
            channelPipelinePipeline.fireChannelReadComplete();
            if (th != null) {
                if (th instanceof IOException) {
                    z = true;
                }
                channelPipelinePipeline.fireExceptionCaught(th);
            }
            if (z) {
                if (isOpen()) {
                    unsafe().close(unsafe().voidPromise());
                }
            } else if (handleRecvBufAllocHandle.lastBytesRead() == 0 && isActive()) {
                read();
            }
        }
    }
}
