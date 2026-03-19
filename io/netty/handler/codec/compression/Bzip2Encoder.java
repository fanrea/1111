package io.netty.handler.codec.compression;

import com.kwad.components.ct.api.tube.KSTubeParamInner;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Bzip2Encoder extends MessageToByteEncoder<ByteBuf> {
    private Bzip2BlockCompressor blockCompressor;
    private volatile ChannelHandlerContext ctx;
    private State currentState;
    private volatile boolean finished;
    private final int streamBlockSize;
    private int streamCRC;
    private final Bzip2BitWriter writer;

    enum State {
        INIT,
        INIT_BLOCK,
        WRITE_DATA,
        CLOSE_BLOCK
    }

    public Bzip2Encoder() {
        this(9);
    }

    public Bzip2Encoder(int i) {
        this.currentState = State.INIT;
        this.writer = new Bzip2BitWriter();
        if (i <= 0 || i > 9) {
            throw new IllegalArgumentException("blockSizeMultiplier: " + i + " (expected: 1-9)");
        }
        this.streamBlockSize = i * KSTubeParamInner.FREE_ALL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0053 A[SYNTHETIC] */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void encode(io.netty.channel.ChannelHandlerContext r5, io.netty.buffer.ByteBuf r6, io.netty.buffer.ByteBuf r7) {
        /*
            r4 = this;
            boolean r5 = r4.finished
            if (r5 == 0) goto L8
            r7.writeBytes(r6)
            return
        L8:
            int[] r5 = io.netty.handler.codec.compression.Bzip2Encoder.AnonymousClass4.$SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State
            io.netty.handler.codec.compression.Bzip2Encoder$State r0 = r4.currentState
            int r0 = r0.ordinal()
            r5 = r5[r0]
            r0 = 1
            r1 = 4
            if (r5 == r0) goto L26
            r0 = 2
            if (r5 == r0) goto L3e
            r0 = 3
            if (r5 == r0) goto L4d
            if (r5 != r1) goto L20
            goto L9f
        L20:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            r5.<init>()
            throw r5
        L26:
            r7.ensureWritable(r1)
            r5 = 4348520(0x425a68, float:6.093574E-39)
            r7.writeMedium(r5)
            int r5 = r4.streamBlockSize
            r0 = 100000(0x186a0, float:1.4013E-40)
            int r5 = r5 / r0
            int r5 = r5 + 48
            r7.writeByte(r5)
            io.netty.handler.codec.compression.Bzip2Encoder$State r5 = io.netty.handler.codec.compression.Bzip2Encoder.State.INIT_BLOCK
            r4.currentState = r5
        L3e:
            io.netty.handler.codec.compression.Bzip2BlockCompressor r5 = new io.netty.handler.codec.compression.Bzip2BlockCompressor
            io.netty.handler.codec.compression.Bzip2BitWriter r0 = r4.writer
            int r1 = r4.streamBlockSize
            r5.<init>(r0, r1)
            r4.blockCompressor = r5
            io.netty.handler.codec.compression.Bzip2Encoder$State r5 = io.netty.handler.codec.compression.Bzip2Encoder.State.WRITE_DATA
            r4.currentState = r5
        L4d:
            boolean r5 = r6.isReadable()
            if (r5 != 0) goto L54
            return
        L54:
            io.netty.handler.codec.compression.Bzip2BlockCompressor r5 = r4.blockCompressor
            int r0 = r6.readableBytes()
            int r1 = r5.availableSize()
            if (r0 >= r1) goto L65
            int r0 = r6.readableBytes()
            goto L69
        L65:
            int r0 = r5.availableSize()
        L69:
            boolean r1 = r6.hasArray()
            if (r1 == 0) goto L7d
            byte[] r1 = r6.array()
            int r2 = r6.arrayOffset()
            int r3 = r6.readerIndex()
            int r2 = r2 + r3
            goto L87
        L7d:
            byte[] r1 = new byte[r0]
            int r2 = r6.readerIndex()
            r6.getBytes(r2, r1)
            r2 = 0
        L87:
            int r0 = r5.write(r1, r2, r0)
            r6.skipBytes(r0)
            boolean r5 = r5.isFull()
            if (r5 != 0) goto L9b
            boolean r5 = r6.isReadable()
            if (r5 != 0) goto L8
            return
        L9b:
            io.netty.handler.codec.compression.Bzip2Encoder$State r5 = io.netty.handler.codec.compression.Bzip2Encoder.State.CLOSE_BLOCK
            r4.currentState = r5
        L9f:
            r4.closeBlock(r7)
            io.netty.handler.codec.compression.Bzip2Encoder$State r5 = io.netty.handler.codec.compression.Bzip2Encoder.State.INIT_BLOCK
            r4.currentState = r5
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2Encoder.encode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):void");
    }

    /* renamed from: io.netty.handler.codec.compression.Bzip2Encoder$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State = new int[State.values().length];

        static {
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.INIT_BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.WRITE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.CLOSE_BLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void closeBlock(ByteBuf byteBuf) {
        Bzip2BlockCompressor bzip2BlockCompressor = this.blockCompressor;
        if (bzip2BlockCompressor.isEmpty()) {
            return;
        }
        bzip2BlockCompressor.close(byteBuf);
        int iCrc = bzip2BlockCompressor.crc();
        int i = this.streamCRC;
        this.streamCRC = iCrc ^ ((i >>> 31) | (i << 1));
    }

    public boolean isClosed() {
        return this.finished;
    }

    public ChannelFuture close() {
        return close(ctx().newPromise());
    }

    public ChannelFuture close(final ChannelPromise channelPromise) {
        ChannelHandlerContext channelHandlerContextCtx = ctx();
        EventExecutor eventExecutorExecutor = channelHandlerContextCtx.executor();
        if (eventExecutorExecutor.inEventLoop()) {
            return finishEncode(channelHandlerContextCtx, channelPromise);
        }
        eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.1
            @Override // java.lang.Runnable
            public void run() {
                Bzip2Encoder bzip2Encoder = Bzip2Encoder.this;
                bzip2Encoder.finishEncode(bzip2Encoder.ctx(), channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(channelPromise));
            }
        });
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) {
        ChannelFuture channelFutureFinishEncode = finishEncode(channelHandlerContext, channelHandlerContext.newPromise());
        channelFutureFinishEncode.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                channelHandlerContext.close(channelPromise);
            }
        });
        if (channelFutureFinishEncode.isDone()) {
            return;
        }
        channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.3
            @Override // java.lang.Runnable
            public void run() {
                channelHandlerContext.close(channelPromise);
            }
        }, 10L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelFuture finishEncode(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.finished) {
            channelPromise.setSuccess();
            return channelPromise;
        }
        this.finished = true;
        ByteBuf byteBufBuffer = channelHandlerContext.alloc().buffer();
        closeBlock(byteBufBuffer);
        int i = this.streamCRC;
        Bzip2BitWriter bzip2BitWriter = this.writer;
        try {
            bzip2BitWriter.writeBits(byteBufBuffer, 24, 1536581L);
            bzip2BitWriter.writeBits(byteBufBuffer, 24, 3690640L);
            bzip2BitWriter.writeInt(byteBufBuffer, i);
            bzip2BitWriter.flush(byteBufBuffer);
            this.blockCompressor = null;
            return channelHandlerContext.writeAndFlush(byteBufBuffer, channelPromise);
        } catch (Throwable th) {
            this.blockCompressor = null;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelHandlerContext ctx() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return channelHandlerContext;
        }
        throw new IllegalStateException("not added to a pipeline");
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        this.ctx = channelHandlerContext;
    }
}
