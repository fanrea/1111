package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.nio.AbstractNioChannel;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';
    private Runnable flushTask;

    protected abstract int doReadBytes(ByteBuf byteBuf);

    protected abstract int doWriteBytes(ByteBuf byteBuf);

    protected abstract long doWriteFileRegion(FileRegion fileRegion);

    protected AbstractNioByteChannel(Channel channel, SelectableChannel selectableChannel) {
        super(channel, selectableChannel, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioByteUnsafe();
    }

    public class NioByteUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        protected NioByteUnsafe() {
            super();
        }

        private void closeOnRead(ChannelPipeline channelPipeline) {
            SelectionKey selectionKey = AbstractNioByteChannel.this.selectionKey();
            AbstractNioByteChannel.this.setInputShutdown();
            if (AbstractNioByteChannel.this.isOpen()) {
                if (Boolean.TRUE.equals(AbstractNioByteChannel.this.config().getOption(ChannelOption.ALLOW_HALF_CLOSURE))) {
                    selectionKey.interestOps(selectionKey.interestOps() & (AbstractNioByteChannel.this.readInterestOp ^ (-1)));
                    channelPipeline.fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
                } else {
                    close(voidPromise());
                }
            }
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th, boolean z, RecvByteBufAllocator.Handle handle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    AbstractNioByteChannel.this.setReadPending(false);
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

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        
            r8.release();
         */
        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void read() {
            /*
                r10 = this;
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelConfig r0 = r0.config()
                boolean r1 = r0.isAutoRead()
                if (r1 != 0) goto L18
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r1 = r1.isReadPending()
                if (r1 != 0) goto L18
                r10.removeReadOp()
                return
            L18:
                io.netty.channel.nio.AbstractNioByteChannel r1 = io.netty.channel.nio.AbstractNioByteChannel.this
                io.netty.channel.ChannelPipeline r3 = r1.pipeline()
                io.netty.buffer.ByteBufAllocator r1 = r0.getAllocator()
                io.netty.channel.RecvByteBufAllocator$Handle r7 = r10.recvBufAllocHandle()
                r7.reset(r0)
                r2 = 1
                r4 = 1
            L2b:
                r5 = 0
                r6 = 0
                io.netty.buffer.ByteBuf r8 = r7.allocate(r1)     // Catch: java.lang.Throwable -> L7c
                io.netty.channel.nio.AbstractNioByteChannel r9 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L79
                int r9 = r9.doReadBytes(r8)     // Catch: java.lang.Throwable -> L79
                r7.lastBytesRead(r9)     // Catch: java.lang.Throwable -> L79
                int r9 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L79
                if (r9 > 0) goto L44
                r8.release()     // Catch: java.lang.Throwable -> L79
                goto L58
            L44:
                r7.incMessagesRead(r2)     // Catch: java.lang.Throwable -> L79
                if (r4 == 0) goto L4f
                io.netty.channel.nio.AbstractNioByteChannel r4 = io.netty.channel.nio.AbstractNioByteChannel.this     // Catch: java.lang.Throwable -> L79
                r4.setReadPending(r5)     // Catch: java.lang.Throwable -> L79
                r4 = 0
            L4f:
                r3.fireChannelRead(r8)     // Catch: java.lang.Throwable -> L79
                boolean r8 = r7.continueReading()     // Catch: java.lang.Throwable -> L7c
                if (r8 != 0) goto L2b
            L58:
                r7.readComplete()     // Catch: java.lang.Throwable -> L7c
                r3.fireChannelReadComplete()     // Catch: java.lang.Throwable -> L7c
                int r1 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L7c
                if (r1 >= 0) goto L67
                r10.closeOnRead(r3)     // Catch: java.lang.Throwable -> L7c
            L67:
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L9d
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r0 = r0.isReadPending()
                if (r0 != 0) goto L9d
                r10.removeReadOp()
                return
            L79:
                r1 = move-exception
                r4 = r8
                goto L7e
            L7c:
                r1 = move-exception
                r4 = r6
            L7e:
                int r6 = r7.lastBytesRead()     // Catch: java.lang.Throwable -> L9e
                if (r6 >= 0) goto L86
                r6 = 1
                goto L87
            L86:
                r6 = 0
            L87:
                r2 = r10
                r5 = r1
                r2.handleReadException(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9e
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto L9d
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r0 = r0.isReadPending()
                if (r0 != 0) goto L9d
                r10.removeReadOp()
            L9d:
                return
            L9e:
                r1 = move-exception
                boolean r0 = r0.isAutoRead()
                if (r0 != 0) goto Lb0
                io.netty.channel.nio.AbstractNioByteChannel r0 = io.netty.channel.nio.AbstractNioByteChannel.this
                boolean r0 = r0.isReadPending()
                if (r0 != 0) goto Lb0
                r10.removeReadOp()
            Lb0:
                goto Lb2
            Lb1:
                throw r1
            Lb2:
                goto Lb1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.netty.channel.nio.AbstractNioByteChannel.NioByteUnsafe.read():void");
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) {
        int writeSpinCount = -1;
        boolean z = false;
        while (true) {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                clearOpWrite();
                return;
            }
            long j = 0;
            boolean z2 = true;
            if (objCurrent instanceof ByteBuf) {
                ByteBuf byteBuf = (ByteBuf) objCurrent;
                if (byteBuf.readableBytes() == 0) {
                    channelOutboundBuffer.remove();
                } else {
                    if (writeSpinCount == -1) {
                        writeSpinCount = config().getWriteSpinCount();
                    }
                    int i = writeSpinCount - 1;
                    while (true) {
                        if (i < 0) {
                            break;
                        }
                        int iDoWriteBytes = doWriteBytes(byteBuf);
                        if (iDoWriteBytes == 0) {
                            z = true;
                            break;
                        }
                        j += iDoWriteBytes;
                        if (!byteBuf.isReadable()) {
                            break;
                        } else {
                            i--;
                        }
                    }
                    z2 = false;
                    channelOutboundBuffer.progress(j);
                    if (!z2) {
                        break;
                    } else {
                        channelOutboundBuffer.remove();
                    }
                }
            } else if (objCurrent instanceof FileRegion) {
                FileRegion fileRegion = (FileRegion) objCurrent;
                boolean z3 = fileRegion.transfered() >= fileRegion.count();
                if (!z3) {
                    if (writeSpinCount == -1) {
                        writeSpinCount = config().getWriteSpinCount();
                    }
                    int i2 = writeSpinCount - 1;
                    long j2 = 0;
                    while (true) {
                        if (i2 < 0) {
                            break;
                        }
                        long jDoWriteFileRegion = doWriteFileRegion(fileRegion);
                        if (jDoWriteFileRegion == 0) {
                            z = true;
                            break;
                        }
                        j2 += jDoWriteFileRegion;
                        if (fileRegion.transfered() >= fileRegion.count()) {
                            z3 = true;
                            break;
                        }
                        i2--;
                    }
                    channelOutboundBuffer.progress(j2);
                }
                if (!z3) {
                    break;
                } else {
                    channelOutboundBuffer.remove();
                }
            } else {
                throw new Error();
            }
        }
        incompleteWrite(z);
    }

    @Override // io.netty.channel.AbstractChannel
    public final Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return byteBuf.isDirect() ? obj : newDirectBuffer(byteBuf);
        }
        if (obj instanceof FileRegion) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    protected final void incompleteWrite(boolean z) {
        if (z) {
            setOpWrite();
            return;
        }
        Runnable runnable = this.flushTask;
        if (runnable == null) {
            runnable = new Runnable() { // from class: io.netty.channel.nio.AbstractNioByteChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractNioByteChannel.this.flush();
                }
            };
            this.flushTask = runnable;
        }
        eventLoop().execute(runnable);
    }

    protected final void setOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int iInterestOps = selectionKey.interestOps();
            if ((iInterestOps & 4) == 0) {
                selectionKey.interestOps(iInterestOps | 4);
            }
        }
    }

    protected final void clearOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int iInterestOps = selectionKey.interestOps();
            if ((iInterestOps & 4) != 0) {
                selectionKey.interestOps(iInterestOps & (-5));
            }
        }
    }
}
