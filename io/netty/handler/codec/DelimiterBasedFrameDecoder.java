package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class DelimiterBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteBuf[] delimiters;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private final LineBasedFrameDecoder lineBasedDecoder;
    private final int maxFrameLength;
    private final boolean stripDelimiter;
    private int tooLongFrameLength;

    public DelimiterBasedFrameDecoder(int i, ByteBuf byteBuf) {
        this(i, true, byteBuf);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, ByteBuf byteBuf) {
        this(i, z, true, byteBuf);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, boolean z2, ByteBuf byteBuf) {
        this(i, z, z2, byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes()));
    }

    public DelimiterBasedFrameDecoder(int i, ByteBuf... byteBufArr) {
        this(i, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, ByteBuf... byteBufArr) {
        this(i, z, true, byteBufArr);
    }

    public DelimiterBasedFrameDecoder(int i, boolean z, boolean z2, ByteBuf... byteBufArr) {
        validateMaxFrameLength(i);
        if (byteBufArr == null) {
            throw new NullPointerException("delimiters");
        }
        if (byteBufArr.length == 0) {
            throw new IllegalArgumentException("empty delimiters");
        }
        if (isLineBased(byteBufArr) && !isSubclass()) {
            this.lineBasedDecoder = new LineBasedFrameDecoder(i, z, z2);
            this.delimiters = null;
        } else {
            this.delimiters = new ByteBuf[byteBufArr.length];
            for (int i2 = 0; i2 < byteBufArr.length; i2++) {
                ByteBuf byteBuf = byteBufArr[i2];
                validateDelimiter(byteBuf);
                this.delimiters[i2] = byteBuf.slice(byteBuf.readerIndex(), byteBuf.readableBytes());
            }
            this.lineBasedDecoder = null;
        }
        this.maxFrameLength = i;
        this.stripDelimiter = z;
        this.failFast = z2;
    }

    private static boolean isLineBased(ByteBuf[] byteBufArr) {
        if (byteBufArr.length != 2) {
            return false;
        }
        ByteBuf byteBuf = byteBufArr[0];
        ByteBuf byteBuf2 = byteBufArr[1];
        if (byteBuf.capacity() < byteBuf2.capacity()) {
            byteBuf = byteBufArr[1];
            byteBuf2 = byteBufArr[0];
        }
        return byteBuf.capacity() == 2 && byteBuf2.capacity() == 1 && byteBuf.getByte(0) == 13 && byteBuf.getByte(1) == 10 && byteBuf2.getByte(0) == 10;
    }

    private boolean isSubclass() {
        return getClass() != DelimiterBasedFrameDecoder.class;
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
        LineBasedFrameDecoder lineBasedFrameDecoder = this.lineBasedDecoder;
        if (lineBasedFrameDecoder != null) {
            return lineBasedFrameDecoder.decode(channelHandlerContext, byteBuf);
        }
        ByteBuf byteBuf2 = null;
        int i = Integer.MAX_VALUE;
        for (ByteBuf byteBuf3 : this.delimiters) {
            int iIndexOf = indexOf(byteBuf, byteBuf3);
            if (iIndexOf >= 0 && iIndexOf < i) {
                byteBuf2 = byteBuf3;
                i = iIndexOf;
            }
        }
        if (byteBuf2 != null) {
            int iCapacity = byteBuf2.capacity();
            if (this.discardingTooLongFrame) {
                this.discardingTooLongFrame = false;
                byteBuf.skipBytes(i + iCapacity);
                int i2 = this.tooLongFrameLength;
                this.tooLongFrameLength = 0;
                if (!this.failFast) {
                    fail(i2);
                }
                return null;
            }
            if (i > this.maxFrameLength) {
                byteBuf.skipBytes(iCapacity + i);
                fail(i);
                return null;
            }
            if (this.stripDelimiter) {
                slice = byteBuf.readSlice(i);
                byteBuf.skipBytes(iCapacity);
            } else {
                slice = byteBuf.readSlice(i + iCapacity);
            }
            return slice.retain();
        }
        if (!this.discardingTooLongFrame) {
            if (byteBuf.readableBytes() > this.maxFrameLength) {
                this.tooLongFrameLength = byteBuf.readableBytes();
                byteBuf.skipBytes(byteBuf.readableBytes());
                this.discardingTooLongFrame = true;
                if (this.failFast) {
                    fail(this.tooLongFrameLength);
                }
            }
        } else {
            this.tooLongFrameLength += byteBuf.readableBytes();
            byteBuf.skipBytes(byteBuf.readableBytes());
        }
        return null;
    }

    private void fail(long j) {
        if (j > 0) {
            throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + ": " + j + " - discarded");
        }
        throw new TooLongFrameException("frame length exceeds " + this.maxFrameLength + " - discarding");
    }

    private static int indexOf(ByteBuf byteBuf, ByteBuf byteBuf2) {
        for (int i = byteBuf.readerIndex(); i < byteBuf.writerIndex(); i++) {
            int i2 = 0;
            int i3 = i;
            while (i2 < byteBuf2.capacity() && byteBuf.getByte(i3) == byteBuf2.getByte(i2)) {
                i3++;
                if (i3 == byteBuf.writerIndex() && i2 != byteBuf2.capacity() - 1) {
                    return -1;
                }
                i2++;
            }
            if (i2 == byteBuf2.capacity()) {
                return i - byteBuf.readerIndex();
            }
        }
        return -1;
    }

    private static void validateDelimiter(ByteBuf byteBuf) {
        if (byteBuf == null) {
            throw new NullPointerException("delimiter");
        }
        if (!byteBuf.isReadable()) {
            throw new IllegalArgumentException("empty delimiter");
        }
    }

    private static void validateMaxFrameLength(int i) {
        if (i > 0) {
            return;
        }
        throw new IllegalArgumentException("maxFrameLength must be a positive integer: " + i);
    }
}
