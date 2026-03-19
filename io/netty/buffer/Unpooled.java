package io.netty.buffer;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Unpooled {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ByteBufAllocator ALLOC = UnpooledByteBufAllocator.DEFAULT;
    public static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    public static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    public static final ByteBuf EMPTY_BUFFER = ALLOC.buffer(0, 0);

    public static ByteBuf buffer() {
        return ALLOC.heapBuffer();
    }

    public static ByteBuf directBuffer() {
        return ALLOC.directBuffer();
    }

    public static ByteBuf buffer(int i) {
        return ALLOC.heapBuffer(i);
    }

    public static ByteBuf directBuffer(int i) {
        return ALLOC.directBuffer(i);
    }

    public static ByteBuf buffer(int i, int i2) {
        return ALLOC.heapBuffer(i, i2);
    }

    public static ByteBuf directBuffer(int i, int i2) {
        return ALLOC.directBuffer(i, i2);
    }

    public static ByteBuf wrappedBuffer(byte[] bArr) {
        if (bArr.length == 0) {
            return EMPTY_BUFFER;
        }
        return new UnpooledHeapByteBuf(ALLOC, bArr, bArr.length);
    }

    public static ByteBuf wrappedBuffer(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        if (i == 0 && i2 == bArr.length) {
            return wrappedBuffer(bArr);
        }
        return wrappedBuffer(bArr).slice(i, i2);
    }

    public static ByteBuf wrappedBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return EMPTY_BUFFER;
        }
        if (byteBuffer.hasArray()) {
            return wrappedBuffer(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()).order(byteBuffer.order());
        }
        if (PlatformDependent.hasUnsafe()) {
            if (byteBuffer.isReadOnly()) {
                if (byteBuffer.isDirect()) {
                    return new ReadOnlyUnsafeDirectByteBuf(ALLOC, byteBuffer);
                }
                return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
            }
            return new UnpooledUnsafeDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
        }
        if (byteBuffer.isReadOnly()) {
            return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
        }
        return new UnpooledDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
    }

    public static ByteBuf wrappedBuffer(ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            return byteBuf.slice();
        }
        byteBuf.release();
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(byte[]... bArr) {
        return wrappedBuffer(16, bArr);
    }

    public static ByteBuf wrappedBuffer(ByteBuf... byteBufArr) {
        return wrappedBuffer(16, byteBufArr);
    }

    public static ByteBuf wrappedBuffer(ByteBuffer... byteBufferArr) {
        return wrappedBuffer(16, byteBufferArr);
    }

    public static ByteBuf wrappedBuffer(int i, byte[]... bArr) {
        int length = bArr.length;
        if (length != 0) {
            if (length == 1) {
                if (bArr[0].length != 0) {
                    return wrappedBuffer(bArr[0]);
                }
            } else {
                ArrayList arrayList = new ArrayList(bArr.length);
                for (byte[] bArr2 : bArr) {
                    if (bArr2 == null) {
                        break;
                    }
                    if (bArr2.length > 0) {
                        arrayList.add(wrappedBuffer(bArr2));
                    }
                }
                if (!arrayList.isEmpty()) {
                    return new CompositeByteBuf(ALLOC, false, i, (Iterable<ByteBuf>) arrayList);
                }
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(int i, ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length != 0) {
            if (length == 1) {
                ByteBuf byteBuf = byteBufArr[0];
                if (byteBuf.isReadable()) {
                    return wrappedBuffer(byteBuf.order(BIG_ENDIAN));
                }
                byteBuf.release();
            } else {
                for (ByteBuf byteBuf2 : byteBufArr) {
                    if (byteBuf2.isReadable()) {
                        return new CompositeByteBuf(ALLOC, false, i, byteBufArr);
                    }
                    byteBuf2.release();
                }
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(int i, ByteBuffer... byteBufferArr) {
        int length = byteBufferArr.length;
        if (length != 0) {
            if (length == 1) {
                if (byteBufferArr[0].hasRemaining()) {
                    return wrappedBuffer(byteBufferArr[0].order(BIG_ENDIAN));
                }
            } else {
                ArrayList arrayList = new ArrayList(byteBufferArr.length);
                for (ByteBuffer byteBuffer : byteBufferArr) {
                    if (byteBuffer == null) {
                        break;
                    }
                    if (byteBuffer.remaining() > 0) {
                        arrayList.add(wrappedBuffer(byteBuffer.order(BIG_ENDIAN)));
                    }
                }
                if (!arrayList.isEmpty()) {
                    return new CompositeByteBuf(ALLOC, false, i, (Iterable<ByteBuf>) arrayList);
                }
            }
        }
        return EMPTY_BUFFER;
    }

    public static CompositeByteBuf compositeBuffer() {
        return compositeBuffer(16);
    }

    public static CompositeByteBuf compositeBuffer(int i) {
        return new CompositeByteBuf(ALLOC, false, i);
    }

    public static ByteBuf copiedBuffer(byte[] bArr) {
        if (bArr.length == 0) {
            return EMPTY_BUFFER;
        }
        return wrappedBuffer((byte[]) bArr.clone());
    }

    public static ByteBuf copiedBuffer(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return wrappedBuffer(bArr2);
    }

    public static ByteBuf copiedBuffer(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArr = new byte[iRemaining];
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.get(bArr);
        return wrappedBuffer(bArr).order(byteBufferDuplicate.order());
    }

    public static ByteBuf copiedBuffer(ByteBuf byteBuf) {
        int i = byteBuf.readableBytes();
        if (i > 0) {
            ByteBuf byteBufBuffer = buffer(i);
            byteBufBuffer.writeBytes(byteBuf, byteBuf.readerIndex(), i);
            return byteBufBuffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(byte[]... bArr) {
        int length = bArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length == 1) {
            if (bArr[0].length == 0) {
                return EMPTY_BUFFER;
            }
            return copiedBuffer(bArr[0]);
        }
        int length2 = 0;
        for (byte[] bArr2 : bArr) {
            if (Integer.MAX_VALUE - length2 < bArr2.length) {
                throw new IllegalArgumentException("The total length of the specified arrays is too big.");
            }
            length2 += bArr2.length;
        }
        if (length2 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArr3 = new byte[length2];
        int length3 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length3, bArr4.length);
            length3 += bArr4.length;
        }
        return wrappedBuffer(bArr3);
    }

    public static ByteBuf copiedBuffer(ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length == 1) {
            return copiedBuffer(byteBufArr[0]);
        }
        ByteOrder byteOrderOrder = null;
        int i = 0;
        for (ByteBuf byteBuf : byteBufArr) {
            int i2 = byteBuf.readableBytes();
            if (i2 > 0) {
                if (Integer.MAX_VALUE - i < i2) {
                    throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                }
                i += i2;
                if (byteOrderOrder != null) {
                    if (!byteOrderOrder.equals(byteBuf.order())) {
                        throw new IllegalArgumentException("inconsistent byte order");
                    }
                } else {
                    byteOrderOrder = byteBuf.order();
                }
            }
        }
        if (i == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArr = new byte[i];
        int i3 = 0;
        for (ByteBuf byteBuf2 : byteBufArr) {
            int i4 = byteBuf2.readableBytes();
            byteBuf2.getBytes(byteBuf2.readerIndex(), bArr, i3, i4);
            i3 += i4;
        }
        return wrappedBuffer(bArr).order(byteOrderOrder);
    }

    public static ByteBuf copiedBuffer(ByteBuffer... byteBufferArr) {
        int length = byteBufferArr.length;
        if (length == 0) {
            return EMPTY_BUFFER;
        }
        if (length == 1) {
            return copiedBuffer(byteBufferArr[0]);
        }
        ByteOrder byteOrderOrder = null;
        int i = 0;
        for (ByteBuffer byteBuffer : byteBufferArr) {
            int iRemaining = byteBuffer.remaining();
            if (iRemaining > 0) {
                if (Integer.MAX_VALUE - i < iRemaining) {
                    throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                }
                i += iRemaining;
                if (byteOrderOrder != null) {
                    if (!byteOrderOrder.equals(byteBuffer.order())) {
                        throw new IllegalArgumentException("inconsistent byte order");
                    }
                } else {
                    byteOrderOrder = byteBuffer.order();
                }
            }
        }
        if (i == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (ByteBuffer byteBuffer2 : byteBufferArr) {
            ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
            int iRemaining2 = byteBufferDuplicate.remaining();
            byteBufferDuplicate.get(bArr, i2, iRemaining2);
            i2 += iRemaining2;
        }
        return wrappedBuffer(bArr).order(byteOrderOrder);
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence, Charset charset) {
        if (charSequence == null) {
            throw new NullPointerException(TypedValues.Custom.S_STRING);
        }
        if (charSequence instanceof CharBuffer) {
            return copiedBuffer((CharBuffer) charSequence, charset);
        }
        return copiedBuffer(CharBuffer.wrap(charSequence), charset);
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence, int i, int i2, Charset charset) {
        if (charSequence == null) {
            throw new NullPointerException(TypedValues.Custom.S_STRING);
        }
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        if (charSequence instanceof CharBuffer) {
            CharBuffer charBuffer = (CharBuffer) charSequence;
            if (charBuffer.hasArray()) {
                return copiedBuffer(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + i, i2, charset);
            }
            CharBuffer charBufferSlice = charBuffer.slice();
            charBufferSlice.limit(i2);
            charBufferSlice.position(i);
            return copiedBuffer(charBufferSlice, charset);
        }
        return copiedBuffer(CharBuffer.wrap(charSequence, i, i2 + i), charset);
    }

    public static ByteBuf copiedBuffer(char[] cArr, Charset charset) {
        if (cArr == null) {
            throw new NullPointerException("array");
        }
        return copiedBuffer(cArr, 0, cArr.length, charset);
    }

    public static ByteBuf copiedBuffer(char[] cArr, int i, int i2, Charset charset) {
        if (cArr == null) {
            throw new NullPointerException("array");
        }
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        return copiedBuffer(CharBuffer.wrap(cArr, i, i2), charset);
    }

    private static ByteBuf copiedBuffer(CharBuffer charBuffer, Charset charset) {
        return ByteBufUtil.encodeString0(ALLOC, true, charBuffer, charset);
    }

    public static ByteBuf unmodifiableBuffer(ByteBuf byteBuf) {
        ByteOrder byteOrderOrder = byteBuf.order();
        ByteOrder byteOrder = BIG_ENDIAN;
        if (byteOrderOrder == byteOrder) {
            return new ReadOnlyByteBuf(byteBuf);
        }
        return new ReadOnlyByteBuf(byteBuf.order(byteOrder)).order(LITTLE_ENDIAN);
    }

    public static ByteBuf copyInt(int i) {
        ByteBuf byteBufBuffer = buffer(4);
        byteBufBuffer.writeInt(i);
        return byteBufBuffer;
    }

    public static ByteBuf copyInt(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf byteBufBuffer = buffer(iArr.length * 4);
        for (int i : iArr) {
            byteBufBuffer.writeInt(i);
        }
        return byteBufBuffer;
    }

    public static ByteBuf copyShort(int i) {
        ByteBuf byteBufBuffer = buffer(2);
        byteBufBuffer.writeShort(i);
        return byteBufBuffer;
    }

    public static ByteBuf copyShort(short... sArr) {
        if (sArr == null || sArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf byteBufBuffer = buffer(sArr.length * 2);
        for (short s : sArr) {
            byteBufBuffer.writeShort(s);
        }
        return byteBufBuffer;
    }

    public static ByteBuf copyShort(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf byteBufBuffer = buffer(iArr.length * 2);
        for (int i : iArr) {
            byteBufBuffer.writeShort(i);
        }
        return byteBufBuffer;
    }

    public static ByteBuf copyMedium(int i) {
        ByteBuf byteBufBuffer = buffer(3);
        byteBufBuffer.writeMedium(i);
        return byteBufBuffer;
    }

    public static ByteBuf copyMedium(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf byteBufBuffer = buffer(iArr.length * 3);
        for (int i : iArr) {
            byteBufBuffer.writeMedium(i);
        }
        return byteBufBuffer;
    }

    public static ByteBuf copyLong(long j) {
        ByteBuf byteBufBuffer = buffer(8);
        byteBufBuffer.writeLong(j);
        return byteBufBuffer;
    }

    public static ByteBuf copyLong(long... jArr) {
        if (jArr == null || jArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf byteBufBuffer = buffer(jArr.length * 8);
        for (long j : jArr) {
            byteBufBuffer.writeLong(j);
        }
        return byteBufBuffer;
    }

    public static ByteBuf copyBoolean(boolean z) {
        ByteBuf byteBufBuffer = buffer(1);
        byteBufBuffer.writeBoolean(z);
        return byteBufBuffer;
    }

    public static ByteBuf copyBoolean(boolean... zArr) {
        if (zArr == null || zArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf byteBufBuffer = buffer(zArr.length);
        for (boolean z : zArr) {
            byteBufBuffer.writeBoolean(z);
        }
        return byteBufBuffer;
    }

    public static ByteBuf copyFloat(float f) {
        ByteBuf byteBufBuffer = buffer(4);
        byteBufBuffer.writeFloat(f);
        return byteBufBuffer;
    }

    public static ByteBuf copyFloat(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf byteBufBuffer = buffer(fArr.length * 4);
        for (float f : fArr) {
            byteBufBuffer.writeFloat(f);
        }
        return byteBufBuffer;
    }

    public static ByteBuf copyDouble(double d) {
        ByteBuf byteBufBuffer = buffer(8);
        byteBufBuffer.writeDouble(d);
        return byteBufBuffer;
    }

    public static ByteBuf copyDouble(double... dArr) {
        if (dArr == null || dArr.length == 0) {
            return EMPTY_BUFFER;
        }
        ByteBuf byteBufBuffer = buffer(dArr.length * 8);
        for (double d : dArr) {
            byteBufBuffer.writeDouble(d);
        }
        return byteBufBuffer;
    }

    public static ByteBuf unreleasableBuffer(ByteBuf byteBuf) {
        return new UnreleasableByteBuf(byteBuf);
    }

    public static ByteBuf unmodifiableBuffer(ByteBuf... byteBufArr) {
        return new FixedCompositeByteBuf(ALLOC, byteBufArr);
    }

    private Unpooled() {
    }
}
