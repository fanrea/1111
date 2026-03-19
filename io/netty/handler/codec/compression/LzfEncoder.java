package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkEncoder;
import com.ning.compress.lzf.LZFEncoder;
import com.ning.compress.lzf.util.ChunkEncoderFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LzfEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int MIN_BLOCK_TO_COMPRESS = 16;
    private final ChunkEncoder encoder;
    private final BufferRecycler recycler;

    public LzfEncoder() {
        this(false, 65535);
    }

    public LzfEncoder(boolean z) {
        this(z, 65535);
    }

    public LzfEncoder(int i) {
        this(false, i);
    }

    public LzfEncoder(boolean z, int i) {
        super(false);
        if (i < 16 || i > 65535) {
            throw new IllegalArgumentException("totalLength: " + i + " (expected: 16" + SignatureImpl.SEP + "65535)");
        }
        this.encoder = z ? ChunkEncoderFactory.safeNonAllocatingInstance(i) : ChunkEncoderFactory.optimalNonAllocatingInstance(i);
        this.recycler = BufferRecycler.instance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        byte[] bArrAllocInputBuffer;
        int i = byteBuf.readableBytes();
        int i2 = byteBuf.readerIndex();
        int iArrayOffset = 0;
        if (byteBuf.hasArray()) {
            bArrAllocInputBuffer = byteBuf.array();
            iArrayOffset = byteBuf.arrayOffset() + i2;
        } else {
            bArrAllocInputBuffer = this.recycler.allocInputBuffer(i);
            byteBuf.getBytes(i2, bArrAllocInputBuffer, 0, i);
        }
        byte[] bArr = bArrAllocInputBuffer;
        byteBuf2.ensureWritable(LZFEncoder.estimateMaxWorkspaceSize(i));
        byte[] bArrArray = byteBuf2.array();
        int iArrayOffset2 = byteBuf2.arrayOffset() + byteBuf2.writerIndex();
        byteBuf2.writerIndex(byteBuf2.writerIndex() + (LZFEncoder.appendEncoded(this.encoder, bArr, iArrayOffset, i, bArrArray, iArrayOffset2) - iArrayOffset2));
        byteBuf.skipBytes(i);
        if (byteBuf.hasArray()) {
            return;
        }
        this.recycler.releaseInputBuffer(bArr);
    }
}
