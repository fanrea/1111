package io.netty.handler.codec.compression;

import com.ss.ttm.utils.AVLogger;
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
import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.xxhash.XXHashFactory;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Lz4FrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private byte[] buffer;
    private Checksum checksum;
    private final int compressedBlockSize;
    private final int compressionLevel;
    private LZ4Compressor compressor;
    private volatile ChannelHandlerContext ctx;
    private int currentBlockLength;
    private volatile boolean finished;

    public Lz4FrameEncoder() {
        this(false);
    }

    public Lz4FrameEncoder(boolean z) {
        this(LZ4Factory.fastestInstance(), z, 65536, XXHashFactory.fastestInstance().newStreamingHash32(-1756908916).asChecksum());
    }

    public Lz4FrameEncoder(LZ4Factory lZ4Factory, boolean z, int i, Checksum checksum) {
        super(false);
        if (lZ4Factory == null) {
            throw new NullPointerException("factory");
        }
        if (checksum == null) {
            throw new NullPointerException("checksum");
        }
        this.compressor = z ? lZ4Factory.highCompressor() : lZ4Factory.fastCompressor();
        this.checksum = checksum;
        this.compressionLevel = compressionLevel(i);
        this.buffer = new byte[i];
        this.currentBlockLength = 0;
        this.compressedBlockSize = this.compressor.maxCompressedLength(i) + 21;
        this.finished = false;
    }

    private static int compressionLevel(int i) {
        if (i < 64 || i > 33554432) {
            throw new IllegalArgumentException(String.format("blockSize: %d (expected: %d-%d)", Integer.valueOf(i), 64, Integer.valueOf(AVLogger.LEVEL_LOG_INFO)));
        }
        return Math.max(0, (32 - Integer.numberOfLeadingZeros(i - 1)) - 10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (this.finished) {
            byteBuf2.writeBytes(byteBuf);
            return;
        }
        int i = byteBuf.readableBytes();
        byte[] bArr = this.buffer;
        int length = bArr.length;
        while (true) {
            int i2 = this.currentBlockLength;
            if (i2 + i >= length) {
                int i3 = length - i2;
                byteBuf.getBytes(byteBuf.readerIndex(), bArr, this.currentBlockLength, i3);
                this.currentBlockLength = length;
                flushBufferedData(byteBuf2);
                byteBuf.skipBytes(i3);
                i -= i3;
            } else {
                byteBuf.readBytes(bArr, i2, i);
                this.currentBlockLength += i;
                return;
            }
        }
    }

    private void flushBufferedData(ByteBuf byteBuf) {
        int i;
        int i2;
        int i3 = this.currentBlockLength;
        if (i3 == 0) {
            return;
        }
        this.checksum.reset();
        this.checksum.update(this.buffer, 0, i3);
        int value = (int) this.checksum.getValue();
        byteBuf.ensureWritable(this.compressedBlockSize);
        int iWriterIndex = byteBuf.writerIndex();
        byte[] bArrArray = byteBuf.array();
        int iArrayOffset = byteBuf.arrayOffset() + iWriterIndex;
        try {
            int i4 = iArrayOffset + 21;
            int iCompress = this.compressor.compress(this.buffer, 0, i3, bArrArray, i4);
            if (iCompress >= i3) {
                i2 = 16;
                System.arraycopy(this.buffer, 0, bArrArray, i4, i3);
                i = i3;
            } else {
                i = iCompress;
                i2 = 32;
            }
            byteBuf.setLong(iWriterIndex, 5501767354678207339L);
            bArrArray[iArrayOffset + 8] = (byte) (i2 | this.compressionLevel);
            writeIntLE(i, bArrArray, iArrayOffset + 9);
            writeIntLE(i3, bArrArray, iArrayOffset + 13);
            writeIntLE(value, bArrArray, iArrayOffset + 17);
            byteBuf.writerIndex(iWriterIndex + 21 + i);
            this.currentBlockLength = 0;
        } catch (LZ4Exception e) {
            throw new CompressionException((Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelFuture finishEncode(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.finished) {
            channelPromise.setSuccess();
            return channelPromise;
        }
        this.finished = true;
        ByteBuf byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer(this.compressor.maxCompressedLength(this.currentBlockLength) + 21);
        flushBufferedData(byteBufHeapBuffer);
        int iWriterIndex = byteBufHeapBuffer.writerIndex();
        byte[] bArrArray = byteBufHeapBuffer.array();
        int iArrayOffset = byteBufHeapBuffer.arrayOffset() + iWriterIndex;
        byteBufHeapBuffer.setLong(iWriterIndex, 5501767354678207339L);
        bArrArray[iArrayOffset + 8] = (byte) (this.compressionLevel | 16);
        writeIntLE(0, bArrArray, iArrayOffset + 9);
        writeIntLE(0, bArrArray, iArrayOffset + 13);
        writeIntLE(0, bArrArray, iArrayOffset + 17);
        byteBufHeapBuffer.writerIndex(iWriterIndex + 21);
        this.compressor = null;
        this.checksum = null;
        this.buffer = null;
        return channelHandlerContext.writeAndFlush(byteBufHeapBuffer, channelPromise);
    }

    private static void writeIntLE(int i, byte[] bArr, int i2) {
        int i3 = i2 + 1;
        bArr[i2] = (byte) i;
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i >>> 8);
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
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
        eventExecutorExecutor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.Lz4FrameEncoder.1
            @Override // java.lang.Runnable
            public void run() {
                Lz4FrameEncoder lz4FrameEncoder = Lz4FrameEncoder.this;
                lz4FrameEncoder.finishEncode(lz4FrameEncoder.ctx(), channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(channelPromise));
            }
        });
        return channelPromise;
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) {
        ChannelFuture channelFutureFinishEncode = finishEncode(channelHandlerContext, channelHandlerContext.newPromise());
        channelFutureFinishEncode.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.Lz4FrameEncoder.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                channelHandlerContext.close(channelPromise);
            }
        });
        if (channelFutureFinishEncode.isDone()) {
            return;
        }
        channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.compression.Lz4FrameEncoder.3
            @Override // java.lang.Runnable
            public void run() {
                channelHandlerContext.close(channelPromise);
            }
        }, 10L, TimeUnit.SECONDS);
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
