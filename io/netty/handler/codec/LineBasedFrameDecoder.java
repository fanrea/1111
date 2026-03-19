package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LineBasedFrameDecoder extends ByteToMessageDecoder {
    private int discardedBytes;
    private boolean discarding;
    private final boolean failFast;
    private final int maxLength;
    private final boolean stripDelimiter;

    public LineBasedFrameDecoder(int i) {
        this(i, true, false);
    }

    public LineBasedFrameDecoder(int i, boolean z, boolean z2) {
        this.maxLength = i;
        this.failFast = z2;
        this.stripDelimiter = z;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        Object objDecode = decode(channelHandlerContext, byteBuf);
        if (objDecode != null) {
            list.add(objDecode);
        }
    }

    protected Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        ByteBuf slice;
        int iFindEndOfLine = findEndOfLine(byteBuf);
        if (this.discarding) {
            if (iFindEndOfLine >= 0) {
                int i = (this.discardedBytes + iFindEndOfLine) - byteBuf.readerIndex();
                byteBuf.readerIndex(iFindEndOfLine + (byteBuf.getByte(iFindEndOfLine) != 13 ? 1 : 2));
                this.discardedBytes = 0;
                this.discarding = false;
                if (!this.failFast) {
                    fail(channelHandlerContext, i);
                }
            } else {
                this.discardedBytes += byteBuf.readableBytes();
                byteBuf.readerIndex(byteBuf.writerIndex());
            }
            return null;
        }
        if (iFindEndOfLine >= 0) {
            int i2 = iFindEndOfLine - byteBuf.readerIndex();
            int i3 = byteBuf.getByte(iFindEndOfLine) != 13 ? 1 : 2;
            if (i2 > this.maxLength) {
                byteBuf.readerIndex(iFindEndOfLine + i3);
                fail(channelHandlerContext, i2);
                return null;
            }
            if (this.stripDelimiter) {
                slice = byteBuf.readSlice(i2);
                byteBuf.skipBytes(i3);
            } else {
                slice = byteBuf.readSlice(i2 + i3);
            }
            return slice.retain();
        }
        int i4 = byteBuf.readableBytes();
        if (i4 > this.maxLength) {
            this.discardedBytes = i4;
            byteBuf.readerIndex(byteBuf.writerIndex());
            this.discarding = true;
            if (this.failFast) {
                fail(channelHandlerContext, "over " + this.discardedBytes);
            }
        }
        return null;
    }

    private void fail(ChannelHandlerContext channelHandlerContext, int i) {
        fail(channelHandlerContext, String.valueOf(i));
    }

    private void fail(ChannelHandlerContext channelHandlerContext, String str) {
        channelHandlerContext.fireExceptionCaught(new TooLongFrameException("frame length (" + str + ") exceeds the allowed maximum (" + this.maxLength + ')'));
    }

    private static int findEndOfLine(ByteBuf byteBuf) {
        int iWriterIndex = byteBuf.writerIndex();
        for (int i = byteBuf.readerIndex(); i < iWriterIndex; i++) {
            byte b = byteBuf.getByte(i);
            if (b == 10) {
                return i;
            }
            if (b == 13 && i < iWriterIndex - 1 && byteBuf.getByte(i + 1) == 10) {
                return i;
            }
        }
        return -1;
    }
}
