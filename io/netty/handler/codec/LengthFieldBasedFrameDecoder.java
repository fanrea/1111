package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import java.nio.ByteOrder;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LengthFieldBasedFrameDecoder extends ByteToMessageDecoder {
    private final ByteOrder byteOrder;
    private long bytesToDiscard;
    private boolean discardingTooLongFrame;
    private final boolean failFast;
    private final int initialBytesToStrip;
    private final int lengthAdjustment;
    private final int lengthFieldEndOffset;
    private final int lengthFieldLength;
    private final int lengthFieldOffset;
    private final int maxFrameLength;
    private long tooLongFrameLength;

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0);
    }

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, i4, i5, true);
    }

    public LengthFieldBasedFrameDecoder(int i, int i2, int i3, int i4, int i5, boolean z) {
        this(ByteOrder.BIG_ENDIAN, i, i2, i3, i4, i5, z);
    }

    public LengthFieldBasedFrameDecoder(ByteOrder byteOrder, int i, int i2, int i3, int i4, int i5, boolean z) {
        if (byteOrder == null) {
            throw new NullPointerException("byteOrder");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("maxFrameLength must be a positive integer: " + i);
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("lengthFieldOffset must be a non-negative integer: " + i2);
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("initialBytesToStrip must be a non-negative integer: " + i5);
        }
        if (i2 > i - i3) {
            throw new IllegalArgumentException("maxFrameLength (" + i + ") must be equal to or greater than lengthFieldOffset (" + i2 + ") + lengthFieldLength (" + i3 + ").");
        }
        this.byteOrder = byteOrder;
        this.maxFrameLength = i;
        this.lengthFieldOffset = i2;
        this.lengthFieldLength = i3;
        this.lengthAdjustment = i4;
        this.lengthFieldEndOffset = i2 + i3;
        this.initialBytesToStrip = i5;
        this.failFast = z;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected final void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        Object objDecode = decode(channelHandlerContext, byteBuf);
        if (objDecode != null) {
            list.add(objDecode);
        }
    }

    protected Object decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        if (this.discardingTooLongFrame) {
            long j = this.bytesToDiscard;
            int iMin = (int) Math.min(j, byteBuf.readableBytes());
            byteBuf.skipBytes(iMin);
            this.bytesToDiscard = j - iMin;
            failIfNecessary(false);
        }
        if (byteBuf.readableBytes() < this.lengthFieldEndOffset) {
            return null;
        }
        long unadjustedFrameLength = getUnadjustedFrameLength(byteBuf, byteBuf.readerIndex() + this.lengthFieldOffset, this.lengthFieldLength, this.byteOrder);
        if (unadjustedFrameLength < 0) {
            byteBuf.skipBytes(this.lengthFieldEndOffset);
            throw new CorruptedFrameException("negative pre-adjustment length field: " + unadjustedFrameLength);
        }
        int i = this.lengthAdjustment;
        int i2 = this.lengthFieldEndOffset;
        long j2 = unadjustedFrameLength + i + i2;
        if (j2 < i2) {
            byteBuf.skipBytes(i2);
            throw new CorruptedFrameException("Adjusted frame length (" + j2 + ") is less than lengthFieldEndOffset: " + this.lengthFieldEndOffset);
        }
        if (j2 > this.maxFrameLength) {
            long j3 = j2 - byteBuf.readableBytes();
            this.tooLongFrameLength = j2;
            if (j3 < 0) {
                byteBuf.skipBytes((int) j2);
            } else {
                this.discardingTooLongFrame = true;
                this.bytesToDiscard = j3;
                byteBuf.skipBytes(byteBuf.readableBytes());
            }
            failIfNecessary(true);
            return null;
        }
        int i3 = (int) j2;
        if (byteBuf.readableBytes() < i3) {
            return null;
        }
        int i4 = this.initialBytesToStrip;
        if (i4 > i3) {
            byteBuf.skipBytes(i3);
            throw new CorruptedFrameException("Adjusted frame length (" + j2 + ") is less than initialBytesToStrip: " + this.initialBytesToStrip);
        }
        byteBuf.skipBytes(i4);
        int i5 = byteBuf.readerIndex();
        int i6 = i3 - this.initialBytesToStrip;
        ByteBuf byteBufExtractFrame = extractFrame(channelHandlerContext, byteBuf, i5, i6);
        byteBuf.readerIndex(i5 + i6);
        return byteBufExtractFrame;
    }

    protected long getUnadjustedFrameLength(ByteBuf byteBuf, int i, int i2, ByteOrder byteOrder) {
        int unsignedByte;
        ByteBuf byteBufOrder = byteBuf.order(byteOrder);
        if (i2 == 1) {
            unsignedByte = byteBufOrder.getUnsignedByte(i);
        } else if (i2 == 2) {
            unsignedByte = byteBufOrder.getUnsignedShort(i);
        } else {
            if (i2 != 3) {
                if (i2 == 4) {
                    return byteBufOrder.getUnsignedInt(i);
                }
                if (i2 == 8) {
                    return byteBufOrder.getLong(i);
                }
                throw new DecoderException("unsupported lengthFieldLength: " + this.lengthFieldLength + " (expected: 1, 2, 3, 4, or 8)");
            }
            unsignedByte = byteBufOrder.getUnsignedMedium(i);
        }
        return unsignedByte;
    }

    private void failIfNecessary(boolean z) {
        if (this.bytesToDiscard == 0) {
            long j = this.tooLongFrameLength;
            this.tooLongFrameLength = 0L;
            this.discardingTooLongFrame = false;
            boolean z2 = this.failFast;
            if (!z2 || (z2 && z)) {
                fail(j);
                return;
            }
            return;
        }
        if (this.failFast && z) {
            fail(this.tooLongFrameLength);
        }
    }

    protected ByteBuf extractFrame(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i, int i2) {
        return byteBuf.slice(i, i2).retain();
    }

    private void fail(long j) {
        if (j > 0) {
            throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + ": " + j + " - discarded");
        }
        throw new TooLongFrameException("Adjusted frame length exceeds " + this.maxFrameLength + " - discarding");
    }
}
