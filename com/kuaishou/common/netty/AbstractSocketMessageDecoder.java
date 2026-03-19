package com.kuaishou.common.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import java.util.Arrays;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class AbstractSocketMessageDecoder extends ByteToMessageDecoder {
    public abstract Object parseFrom(byte[] bArr);

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (byteBuf.readableBytes() < Constants.HEADER_LENGTH) {
            return;
        }
        byteBuf.markReaderIndex();
        byte b = byteBuf.readByte();
        if (b != 1) {
            byteBuf.clear();
            throw new CorruptedFrameException("bad version: " + ((int) b));
        }
        byte[] bArr = new byte[Constants.MAGIC_BYTES.length];
        byteBuf.readBytes(bArr);
        if (!Arrays.equals(Constants.MAGIC_BYTES, bArr)) {
            byteBuf.clear();
            throw new CorruptedFrameException("Bad magic bytes:" + Arrays.toString(bArr));
        }
        byteBuf.readBytes(new byte[8]);
        int i = byteBuf.readInt();
        if (i <= 0 || i > 131072) {
            byteBuf.clear();
            throw new CorruptedFrameException("Bad length:" + i);
        }
        if (byteBuf.readableBytes() < i) {
            byteBuf.resetReaderIndex();
            return;
        }
        byte[] bArr2 = new byte[i];
        byteBuf.readBytes(bArr2);
        list.add(parseFrom(bArr2));
    }
}
