package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class AbstractOioByteChannel extends AbstractOioChannel {
    private volatile boolean inputShutdown;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';

    protected abstract int available();

    protected abstract int doReadBytes(ByteBuf byteBuf);

    protected abstract void doWriteBytes(ByteBuf byteBuf);

    protected abstract void doWriteFileRegion(FileRegion fileRegion);

    protected AbstractOioByteChannel(Channel channel) {
        super(channel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isInputShutdown() {
        return this.inputShutdown;
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    protected boolean checkInputShutdown() throws InterruptedException {
        if (!this.inputShutdown) {
            return false;
        }
        try {
            Thread.sleep(1000L);
            return true;
        } catch (InterruptedException unused) {
            return true;
        }
    }

    void setInputShutdown() {
        this.inputShutdown = true;
    }

    private void closeOnRead(ChannelPipeline channelPipeline) {
        setInputShutdown();
        if (isOpen()) {
            if (Boolean.TRUE.equals(config().getOption(ChannelOption.ALLOW_HALF_CLOSURE))) {
                channelPipeline.fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
            } else {
                unsafe().close(unsafe().voidPromise());
            }
        }
    }

    private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, RecvByteBufAllocator.Handle handle) {
        if (byteBuf != null) {
            if (byteBuf.isReadable()) {
                setReadPending(false);
                channelPipeline.fireChannelRead(byteBuf);
            } else {
                byteBuf.release();
            }
        }
        handle.readComplete();
        channelPipeline.fireChannelReadComplete();
        channelPipeline.fireExceptionCaught(th);
        if (z || (th instanceof IOException)) {
            closeOnRead(channelPipeline);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[LOOP:0: B:68:0x0036->B:77:?, LOOP_END, SYNTHETIC] */
    @Override // io.netty.channel.oio.AbstractOioChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void doRead() {
        /*
            r10 = this;
            io.netty.channel.ChannelConfig r0 = r10.config()
            boolean r1 = r10.isInputShutdown()
            if (r1 != 0) goto Ldd
            boolean r1 = r0.isAutoRead()
            if (r1 != 0) goto L18
            boolean r1 = r10.isReadPending()
            if (r1 != 0) goto L18
            goto Ldd
        L18:
            r1 = 0
            r10.setReadPending(r1)
            io.netty.channel.ChannelPipeline r3 = r10.pipeline()
            io.netty.buffer.ByteBufAllocator r2 = r0.getAllocator()
            io.netty.channel.Channel$Unsafe r4 = r10.unsafe()
            io.netty.channel.RecvByteBufAllocator$Handle r8 = r4.recvBufAllocHandle()
            r8.reset(r0)
            r0 = 1
            r4 = 0
            io.netty.buffer.ByteBuf r5 = r8.allocate(r2)     // Catch: java.lang.Throwable -> Lac
            r6 = 0
        L36:
            int r7 = r10.doReadBytes(r5)     // Catch: java.lang.Throwable -> La9
            r8.lastBytesRead(r7)     // Catch: java.lang.Throwable -> La9
            int r7 = r8.lastBytesRead()     // Catch: java.lang.Throwable -> La9
            if (r7 > 0) goto L4a
            if (r6 != 0) goto L83
            r5.release()     // Catch: java.lang.Throwable -> La9
            r5 = r4
            goto L83
        L4a:
            int r6 = r10.available()     // Catch: java.lang.Throwable -> La9
            if (r6 <= 0) goto L82
            boolean r7 = r5.isWritable()     // Catch: java.lang.Throwable -> La9
            if (r7 != 0) goto L7a
            int r7 = r5.capacity()     // Catch: java.lang.Throwable -> La9
            int r9 = r5.maxCapacity()     // Catch: java.lang.Throwable -> La9
            if (r7 != r9) goto L6c
            r8.incMessagesRead(r0)     // Catch: java.lang.Throwable -> La9
            r3.fireChannelRead(r5)     // Catch: java.lang.Throwable -> La9
            io.netty.buffer.ByteBuf r5 = r8.allocate(r2)     // Catch: java.lang.Throwable -> La9
            r6 = 0
            goto L7b
        L6c:
            int r7 = r5.writerIndex()     // Catch: java.lang.Throwable -> La9
            int r7 = r7 + r6
            if (r7 <= r9) goto L77
            r5.capacity(r9)     // Catch: java.lang.Throwable -> La9
            goto L7a
        L77:
            r5.ensureWritable(r6)     // Catch: java.lang.Throwable -> La9
        L7a:
            r6 = 1
        L7b:
            boolean r7 = r8.continueReading()     // Catch: java.lang.Throwable -> La9
            if (r7 != 0) goto L36
            goto L83
        L82:
            r6 = 1
        L83:
            if (r6 == 0) goto L89
            r3.fireChannelRead(r5)     // Catch: java.lang.Throwable -> La9
            goto L8a
        L89:
            r4 = r5
        L8a:
            r8.readComplete()     // Catch: java.lang.Throwable -> Lac
            r3.fireChannelReadComplete()     // Catch: java.lang.Throwable -> Lac
            int r2 = r8.lastBytesRead()     // Catch: java.lang.Throwable -> Lac
            if (r2 >= 0) goto L99
            r10.closeOnRead(r3)     // Catch: java.lang.Throwable -> Lac
        L99:
            int r0 = r8.lastBytesRead()
            if (r0 != 0) goto Lcb
            boolean r0 = r10.isActive()
            if (r0 == 0) goto Lcb
            r10.read()
            return
        La9:
            r2 = move-exception
            r4 = r5
            goto Lad
        Lac:
            r2 = move-exception
        Lad:
            r5 = r2
            int r2 = r8.lastBytesRead()     // Catch: java.lang.Throwable -> Lcc
            if (r2 >= 0) goto Lb6
            r6 = 1
            goto Lb7
        Lb6:
            r6 = 0
        Lb7:
            r2 = r10
            r7 = r8
            r2.handleReadException(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lcc
            int r0 = r8.lastBytesRead()
            if (r0 != 0) goto Lcb
            boolean r0 = r10.isActive()
            if (r0 == 0) goto Lcb
            r10.read()
        Lcb:
            return
        Lcc:
            r0 = move-exception
            int r1 = r8.lastBytesRead()
            if (r1 != 0) goto Ldc
            boolean r1 = r10.isActive()
            if (r1 == 0) goto Ldc
            r10.read()
        Ldc:
            throw r0
        Ldd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.oio.AbstractOioByteChannel.doRead():void");
    }

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) {
        while (true) {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                return;
            }
            if (objCurrent instanceof ByteBuf) {
                ByteBuf byteBuf = (ByteBuf) objCurrent;
                int i = byteBuf.readableBytes();
                while (i > 0) {
                    doWriteBytes(byteBuf);
                    int i2 = byteBuf.readableBytes();
                    channelOutboundBuffer.progress(i - i2);
                    i = i2;
                }
                channelOutboundBuffer.remove();
            } else if (objCurrent instanceof FileRegion) {
                FileRegion fileRegion = (FileRegion) objCurrent;
                long jTransfered = fileRegion.transfered();
                doWriteFileRegion(fileRegion);
                channelOutboundBuffer.progress(fileRegion.transfered() - jTransfered);
                channelOutboundBuffer.remove();
            } else {
                channelOutboundBuffer.remove(new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(objCurrent)));
            }
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public final Object filterOutboundMessage(Object obj) {
        if ((obj instanceof ByteBuf) || (obj instanceof FileRegion)) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }
}
