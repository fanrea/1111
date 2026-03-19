package io.netty.buffer;

import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class UnsafeByteBufUtil {
    private static final boolean UNALIGNED = PlatformDependent.isUnaligned();

    static byte getByte(long j) {
        return PlatformDependent.getByte(j);
    }

    static short getShort(long j) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(j + 1) & 255) | (PlatformDependent.getByte(j) << 8));
        }
        short s = PlatformDependent.getShort(j);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s : Short.reverseBytes(s);
    }

    static short getShortLE(long j) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(j + 1) << 8) | (PlatformDependent.getByte(j) & 255));
        }
        short s = PlatformDependent.getShort(j);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s) : s;
    }

    static int getUnsignedMedium(long j) {
        int iReverseBytes;
        byte b;
        int i;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                iReverseBytes = PlatformDependent.getByte(j) & 255;
                i = (PlatformDependent.getShort(j + 1) & 65535) << 8;
                return i | iReverseBytes;
            }
            iReverseBytes = (Short.reverseBytes(PlatformDependent.getShort(j)) & 65535) << 8;
            b = PlatformDependent.getByte(j + 2);
        } else {
            iReverseBytes = ((PlatformDependent.getByte(j) & 255) << 16) | ((PlatformDependent.getByte(1 + j) & 255) << 8);
            b = PlatformDependent.getByte(j + 2);
        }
        i = b & 255;
        return i | iReverseBytes;
    }

    static int getUnsignedMediumLE(long j) {
        int iReverseBytes;
        int i;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                iReverseBytes = (Short.reverseBytes(PlatformDependent.getShort(j)) & 65535) << 8;
                i = PlatformDependent.getByte(j + 2) & 255;
            } else {
                iReverseBytes = PlatformDependent.getByte(j) & 255;
                i = (PlatformDependent.getShort(j + 1) & 65535) << 8;
            }
        } else {
            int i2 = PlatformDependent.getByte(j) & 255;
            long j2 = j + 1;
            iReverseBytes = i2 | ((PlatformDependent.getByte(j2) & 255) << 8);
            i = (PlatformDependent.getByte(j2) & 255) << 16;
        }
        return i | iReverseBytes;
    }

    static int getInt(long j) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j + 3) & 255) | (PlatformDependent.getByte(j) << 24) | ((PlatformDependent.getByte(1 + j) & 255) << 16) | ((PlatformDependent.getByte(2 + j) & 255) << 8);
        }
        int i = PlatformDependent.getInt(j);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i : Integer.reverseBytes(i);
    }

    static int getIntLE(long j) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j + 3) << 24) | (PlatformDependent.getByte(j) & 255) | ((PlatformDependent.getByte(1 + j) & 255) << 8) | ((PlatformDependent.getByte(2 + j) & 255) << 16);
        }
        int i = PlatformDependent.getInt(j);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i) : i;
    }

    static long getLong(long j) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j + 7) & 255) | (PlatformDependent.getByte(j) << 56) | ((PlatformDependent.getByte(1 + j) & 255) << 48) | ((PlatformDependent.getByte(2 + j) & 255) << 40) | ((PlatformDependent.getByte(3 + j) & 255) << 32) | ((PlatformDependent.getByte(4 + j) & 255) << 24) | ((PlatformDependent.getByte(5 + j) & 255) << 16) | ((PlatformDependent.getByte(6 + j) & 255) << 8);
        }
        long j2 = PlatformDependent.getLong(j);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j2 : Long.reverseBytes(j2);
    }

    static long getLongLE(long j) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(j + 7) << 56) | (PlatformDependent.getByte(j) & 255) | ((PlatformDependent.getByte(1 + j) & 255) << 8) | ((PlatformDependent.getByte(2 + j) & 255) << 16) | ((PlatformDependent.getByte(3 + j) & 255) << 24) | ((PlatformDependent.getByte(4 + j) & 255) << 32) | ((PlatformDependent.getByte(5 + j) & 255) << 40) | ((255 & PlatformDependent.getByte(6 + j)) << 48);
        }
        long j2 = PlatformDependent.getLong(j);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j2) : j2;
    }

    static void setByte(long j, int i) {
        PlatformDependent.putByte(j, (byte) i);
    }

    static void setShort(long j, int i) {
        if (UNALIGNED) {
            short sReverseBytes = (short) i;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = Short.reverseBytes(sReverseBytes);
            }
            PlatformDependent.putShort(j, sReverseBytes);
            return;
        }
        PlatformDependent.putByte(j, (byte) (i >>> 8));
        PlatformDependent.putByte(j + 1, (byte) i);
    }

    static void setShortLE(long j, int i) {
        if (UNALIGNED) {
            short sReverseBytes = (short) i;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = Short.reverseBytes(sReverseBytes);
            }
            PlatformDependent.putShort(j, sReverseBytes);
            return;
        }
        PlatformDependent.putByte(j, (byte) i);
        PlatformDependent.putByte(j + 1, (byte) (i >>> 8));
    }

    static void setMedium(long j, int i) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putByte(j, (byte) i);
                PlatformDependent.putShort(j + 1, (short) (i >>> 8));
                return;
            } else {
                PlatformDependent.putShort(j, Short.reverseBytes((short) (i >>> 8)));
                PlatformDependent.putByte(j + 2, (byte) i);
                return;
            }
        }
        PlatformDependent.putByte(j, (byte) (i >>> 16));
        PlatformDependent.putByte(1 + j, (byte) (i >>> 8));
        PlatformDependent.putByte(j + 2, (byte) i);
    }

    static void setMediumLE(long j, int i) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putShort(j, Short.reverseBytes((short) (i >>> 8)));
                PlatformDependent.putByte(j + 2, (byte) i);
                return;
            } else {
                PlatformDependent.putByte(j, (byte) i);
                PlatformDependent.putShort(j + 1, (short) (i >>> 8));
                return;
            }
        }
        PlatformDependent.putByte(j, (byte) i);
        PlatformDependent.putByte(1 + j, (byte) (i >>> 8));
        PlatformDependent.putByte(j + 2, (byte) (i >>> 16));
    }

    static void setInt(long j, int i) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i = Integer.reverseBytes(i);
            }
            PlatformDependent.putInt(j, i);
        } else {
            PlatformDependent.putByte(j, (byte) (i >>> 24));
            PlatformDependent.putByte(1 + j, (byte) (i >>> 16));
            PlatformDependent.putByte(2 + j, (byte) (i >>> 8));
            PlatformDependent.putByte(j + 3, (byte) i);
        }
    }

    static void setIntLE(long j, int i) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i = Integer.reverseBytes(i);
            }
            PlatformDependent.putInt(j, i);
        } else {
            PlatformDependent.putByte(j, (byte) i);
            PlatformDependent.putByte(1 + j, (byte) (i >>> 8));
            PlatformDependent.putByte(2 + j, (byte) (i >>> 16));
            PlatformDependent.putByte(j + 3, (byte) (i >>> 24));
        }
    }

    static void setLong(long j, long j2) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j2 = Long.reverseBytes(j2);
            }
            PlatformDependent.putLong(j, j2);
            return;
        }
        PlatformDependent.putByte(j, (byte) (j2 >>> 56));
        PlatformDependent.putByte(1 + j, (byte) (j2 >>> 48));
        PlatformDependent.putByte(2 + j, (byte) (j2 >>> 40));
        PlatformDependent.putByte(3 + j, (byte) (j2 >>> 32));
        PlatformDependent.putByte(4 + j, (byte) (j2 >>> 24));
        PlatformDependent.putByte(5 + j, (byte) (j2 >>> 16));
        PlatformDependent.putByte(6 + j, (byte) (j2 >>> 8));
        PlatformDependent.putByte(j + 7, (byte) j2);
    }

    static void setLongLE(long j, long j2) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j2 = Long.reverseBytes(j2);
            }
            PlatformDependent.putLong(j, j2);
            return;
        }
        PlatformDependent.putByte(j, (byte) j2);
        PlatformDependent.putByte(1 + j, (byte) (j2 >>> 8));
        PlatformDependent.putByte(2 + j, (byte) (j2 >>> 16));
        PlatformDependent.putByte(3 + j, (byte) (j2 >>> 24));
        PlatformDependent.putByte(4 + j, (byte) (j2 >>> 32));
        PlatformDependent.putByte(5 + j, (byte) (j2 >>> 40));
        PlatformDependent.putByte(6 + j, (byte) (j2 >>> 48));
        PlatformDependent.putByte(j + 7, (byte) (j2 >>> 56));
    }

    static byte getByte(byte[] bArr, int i) {
        return PlatformDependent.getByte(bArr, i);
    }

    static short getShort(byte[] bArr, int i) {
        if (UNALIGNED) {
            short s = PlatformDependent.getShort(bArr, i);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s : Short.reverseBytes(s);
        }
        return (short) ((PlatformDependent.getByte(i) << 8) | (PlatformDependent.getByte(i + 1) & 255));
    }

    static short getShortLE(byte[] bArr, int i) {
        if (UNALIGNED) {
            short s = PlatformDependent.getShort(bArr, i);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s) : s;
        }
        return (short) ((PlatformDependent.getByte(i) & 255) | (PlatformDependent.getByte(i + 1) << 8));
    }

    static int getUnsignedMedium(byte[] bArr, int i) {
        int iReverseBytes;
        byte b;
        int i2;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                iReverseBytes = PlatformDependent.getByte(bArr, i) & 255;
                i2 = (PlatformDependent.getShort(bArr, i + 1) & 65535) << 8;
                return i2 | iReverseBytes;
            }
            iReverseBytes = (Short.reverseBytes(PlatformDependent.getShort(bArr, i)) & 65535) << 8;
            b = PlatformDependent.getByte(bArr, i + 2);
        } else {
            iReverseBytes = ((PlatformDependent.getByte(bArr, i) & 255) << 16) | ((PlatformDependent.getByte(bArr, i + 1) & 255) << 8);
            b = PlatformDependent.getByte(bArr, i + 2);
        }
        i2 = b & 255;
        return i2 | iReverseBytes;
    }

    static int getUnsignedMediumLE(byte[] bArr, int i) {
        int iReverseBytes;
        int i2;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                iReverseBytes = (Short.reverseBytes(PlatformDependent.getShort(bArr, i)) & 65535) << 8;
                i2 = PlatformDependent.getByte(bArr, i + 2) & 255;
            } else {
                iReverseBytes = PlatformDependent.getByte(bArr, i) & 255;
                i2 = (PlatformDependent.getShort(bArr, i + 1) & 65535) << 8;
            }
        } else {
            iReverseBytes = (PlatformDependent.getByte(bArr, i) & 255) | ((PlatformDependent.getByte(bArr, i + 1) & 255) << 8);
            i2 = (PlatformDependent.getByte(bArr, i + 2) & 255) << 16;
        }
        return i2 | iReverseBytes;
    }

    static int getInt(byte[] bArr, int i) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(bArr, i + 3) & 255) | (PlatformDependent.getByte(bArr, i) << 24) | ((PlatformDependent.getByte(bArr, i + 1) & 255) << 16) | ((PlatformDependent.getByte(bArr, i + 2) & 255) << 8);
        }
        int i2 = PlatformDependent.getInt(bArr, i);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i2 : Integer.reverseBytes(i2);
    }

    static int getIntLE(byte[] bArr, int i) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(bArr, i + 3) << 24) | (PlatformDependent.getByte(bArr, i) & 255) | ((PlatformDependent.getByte(bArr, i + 1) & 255) << 8) | ((PlatformDependent.getByte(bArr, i + 2) & 255) << 16);
        }
        int i2 = PlatformDependent.getInt(bArr, i);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i2) : i2;
    }

    static long getLong(byte[] bArr, int i) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(bArr, i + 7) & 255) | (PlatformDependent.getByte(bArr, i) << 56) | ((PlatformDependent.getByte(bArr, i + 1) & 255) << 48) | ((PlatformDependent.getByte(bArr, i + 2) & 255) << 40) | ((PlatformDependent.getByte(bArr, i + 3) & 255) << 32) | ((PlatformDependent.getByte(bArr, i + 4) & 255) << 24) | ((PlatformDependent.getByte(bArr, i + 5) & 255) << 16) | ((PlatformDependent.getByte(bArr, i + 6) & 255) << 8);
        }
        long j = PlatformDependent.getLong(bArr, i);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j : Long.reverseBytes(j);
    }

    static long getLongLE(byte[] bArr, int i) {
        if (!UNALIGNED) {
            return (PlatformDependent.getByte(bArr, i + 7) << 56) | (PlatformDependent.getByte(bArr, i) & 255) | ((PlatformDependent.getByte(bArr, i + 1) & 255) << 8) | ((PlatformDependent.getByte(bArr, i + 2) & 255) << 16) | ((PlatformDependent.getByte(bArr, i + 3) & 255) << 24) | ((PlatformDependent.getByte(bArr, i + 4) & 255) << 32) | ((PlatformDependent.getByte(bArr, i + 5) & 255) << 40) | ((255 & PlatformDependent.getByte(bArr, i + 6)) << 48);
        }
        long j = PlatformDependent.getLong(bArr, i);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j) : j;
    }

    static void setByte(byte[] bArr, int i, int i2) {
        PlatformDependent.putByte(bArr, i, (byte) i2);
    }

    static void setShort(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            short sReverseBytes = (short) i2;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = Short.reverseBytes(sReverseBytes);
            }
            PlatformDependent.putShort(bArr, i, sReverseBytes);
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) (i2 >>> 8));
        PlatformDependent.putByte(bArr, i + 1, (byte) i2);
    }

    static void setShortLE(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            short sReverseBytes = (short) i2;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                sReverseBytes = Short.reverseBytes(sReverseBytes);
            }
            PlatformDependent.putShort(bArr, i, sReverseBytes);
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) i2);
        PlatformDependent.putByte(bArr, i + 1, (byte) (i2 >>> 8));
    }

    static void setMedium(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putByte(bArr, i, (byte) i2);
                PlatformDependent.putShort(bArr, i + 1, (short) (i2 >>> 8));
                return;
            } else {
                PlatformDependent.putShort(bArr, i, Short.reverseBytes((short) (i2 >>> 8)));
                PlatformDependent.putByte(bArr, i + 2, (byte) i2);
                return;
            }
        }
        PlatformDependent.putByte(bArr, i, (byte) (i2 >>> 16));
        PlatformDependent.putByte(bArr, i + 1, (byte) (i2 >>> 8));
        PlatformDependent.putByte(bArr, i + 2, (byte) i2);
    }

    static void setMediumLE(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putShort(bArr, i, Short.reverseBytes((short) (i2 >>> 8)));
                PlatformDependent.putByte(bArr, i + 2, (byte) i2);
                return;
            } else {
                PlatformDependent.putByte(bArr, i, (byte) i2);
                PlatformDependent.putShort(bArr, i + 1, (short) (i2 >>> 8));
                return;
            }
        }
        PlatformDependent.putByte(bArr, i, (byte) i2);
        PlatformDependent.putByte(bArr, i + 1, (byte) (i2 >>> 8));
        PlatformDependent.putByte(bArr, i + 2, (byte) (i2 >>> 16));
    }

    static void setInt(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i2 = Integer.reverseBytes(i2);
            }
            PlatformDependent.putInt(bArr, i, i2);
        } else {
            PlatformDependent.putByte(bArr, i, (byte) (i2 >>> 24));
            PlatformDependent.putByte(bArr, i + 1, (byte) (i2 >>> 16));
            PlatformDependent.putByte(bArr, i + 2, (byte) (i2 >>> 8));
            PlatformDependent.putByte(bArr, i + 3, (byte) i2);
        }
    }

    static void setIntLE(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i2 = Integer.reverseBytes(i2);
            }
            PlatformDependent.putInt(bArr, i, i2);
        } else {
            PlatformDependent.putByte(bArr, i, (byte) i2);
            PlatformDependent.putByte(bArr, i + 1, (byte) (i2 >>> 8));
            PlatformDependent.putByte(bArr, i + 2, (byte) (i2 >>> 16));
            PlatformDependent.putByte(bArr, i + 3, (byte) (i2 >>> 24));
        }
    }

    static void setLong(byte[] bArr, int i, long j) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j = Long.reverseBytes(j);
            }
            PlatformDependent.putLong(bArr, i, j);
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) (j >>> 56));
        PlatformDependent.putByte(bArr, i + 1, (byte) (j >>> 48));
        PlatformDependent.putByte(bArr, i + 2, (byte) (j >>> 40));
        PlatformDependent.putByte(bArr, i + 3, (byte) (j >>> 32));
        PlatformDependent.putByte(bArr, i + 4, (byte) (j >>> 24));
        PlatformDependent.putByte(bArr, i + 5, (byte) (j >>> 16));
        PlatformDependent.putByte(bArr, i + 6, (byte) (j >>> 8));
        PlatformDependent.putByte(bArr, i + 7, (byte) j);
    }

    static void setLongLE(byte[] bArr, int i, long j) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j = Long.reverseBytes(j);
            }
            PlatformDependent.putLong(bArr, i, j);
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) j);
        PlatformDependent.putByte(bArr, i + 1, (byte) (j >>> 8));
        PlatformDependent.putByte(bArr, i + 2, (byte) (j >>> 16));
        PlatformDependent.putByte(bArr, i + 3, (byte) (j >>> 24));
        PlatformDependent.putByte(bArr, i + 4, (byte) (j >>> 32));
        PlatformDependent.putByte(bArr, i + 5, (byte) (j >>> 40));
        PlatformDependent.putByte(bArr, i + 6, (byte) (j >>> 48));
        PlatformDependent.putByte(bArr, i + 7, (byte) (j >>> 56));
    }

    static ByteBuf copy(AbstractByteBuf abstractByteBuf, long j, int i, int i2) {
        abstractByteBuf.checkIndex(i, i2);
        ByteBuf byteBufDirectBuffer = abstractByteBuf.alloc().directBuffer(i2, abstractByteBuf.maxCapacity());
        if (i2 != 0) {
            if (byteBufDirectBuffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(j, byteBufDirectBuffer.memoryAddress(), i2);
                byteBufDirectBuffer.setIndex(0, i2);
            } else {
                byteBufDirectBuffer.writeBytes(abstractByteBuf, i, i2);
            }
        }
        return byteBufDirectBuffer;
    }

    static int setBytes(AbstractByteBuf abstractByteBuf, long j, int i, InputStream inputStream, int i2) {
        abstractByteBuf.checkIndex(i, i2);
        ByteBuf byteBufHeapBuffer = abstractByteBuf.alloc().heapBuffer(i2);
        try {
            byte[] bArrArray = byteBufHeapBuffer.array();
            int iArrayOffset = byteBufHeapBuffer.arrayOffset();
            int i3 = inputStream.read(bArrArray, iArrayOffset, i2);
            if (i3 > 0) {
                PlatformDependent.copyMemory(bArrArray, iArrayOffset, j, i3);
            }
            return i3;
        } finally {
            byteBufHeapBuffer.release();
        }
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long j, int i, ByteBuf byteBuf, int i2, int i3) {
        abstractByteBuf.checkIndex(i, i3);
        ObjectUtil.checkNotNull(byteBuf, "dst");
        if (MathUtil.isOutOfBounds(i2, i3, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException("dstIndex: " + i2);
        }
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(j, byteBuf.memoryAddress() + i2, i3);
        } else if (byteBuf.hasArray()) {
            PlatformDependent.copyMemory(j, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
        } else {
            byteBuf.setBytes(i2, abstractByteBuf, i, i3);
        }
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long j, int i, byte[] bArr, int i2, int i3) {
        abstractByteBuf.checkIndex(i, i3);
        ObjectUtil.checkNotNull(bArr, "dst");
        if (MathUtil.isOutOfBounds(i2, i3, bArr.length)) {
            throw new IndexOutOfBoundsException("dstIndex: " + i2);
        }
        if (i3 != 0) {
            PlatformDependent.copyMemory(j, bArr, i2, i3);
        }
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long j, int i, ByteBuffer byteBuffer) {
        abstractByteBuf.checkIndex(i);
        int iMin = Math.min(abstractByteBuf.capacity() - i, byteBuffer.remaining());
        if (iMin == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            if (byteBuffer.isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            PlatformDependent.copyMemory(j, PlatformDependent.directBufferAddress(byteBuffer) + byteBuffer.position(), iMin);
            byteBuffer.position(byteBuffer.position() + iMin);
            return;
        }
        if (byteBuffer.hasArray()) {
            PlatformDependent.copyMemory(j, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), iMin);
            byteBuffer.position(byteBuffer.position() + iMin);
        } else {
            byteBuffer.put(abstractByteBuf.nioBuffer());
        }
    }

    static void setBytes(AbstractByteBuf abstractByteBuf, long j, int i, ByteBuf byteBuf, int i2, int i3) {
        abstractByteBuf.checkIndex(i, i3);
        ObjectUtil.checkNotNull(byteBuf, "src");
        if (MathUtil.isOutOfBounds(i2, i3, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException("srcIndex: " + i2);
        }
        if (i3 != 0) {
            if (byteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(byteBuf.memoryAddress() + i2, j, i3);
            } else if (byteBuf.hasArray()) {
                PlatformDependent.copyMemory(byteBuf.array(), byteBuf.arrayOffset() + i2, j, i3);
            } else {
                byteBuf.getBytes(i2, abstractByteBuf, i, i3);
            }
        }
    }

    static void setBytes(AbstractByteBuf abstractByteBuf, long j, int i, byte[] bArr, int i2, int i3) {
        abstractByteBuf.checkIndex(i, i3);
        if (i3 != 0) {
            PlatformDependent.copyMemory(bArr, i2, j, i3);
        }
    }

    static void setBytes(AbstractByteBuf abstractByteBuf, long j, int i, ByteBuffer byteBuffer) {
        abstractByteBuf.checkIndex(i, byteBuffer.remaining());
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + byteBuffer.position(), j, byteBuffer.remaining());
            byteBuffer.position(byteBuffer.position() + iRemaining);
        } else {
            if (byteBuffer.hasArray()) {
                PlatformDependent.copyMemory(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), j, iRemaining);
                byteBuffer.position(byteBuffer.position() + iRemaining);
                return;
            }
            ByteBuf byteBufHeapBuffer = abstractByteBuf.alloc().heapBuffer(iRemaining);
            try {
                byte[] bArrArray = byteBufHeapBuffer.array();
                byteBuffer.get(bArrArray, byteBufHeapBuffer.arrayOffset(), iRemaining);
                PlatformDependent.copyMemory(bArrArray, 0, j, iRemaining);
            } finally {
                byteBufHeapBuffer.release();
            }
        }
    }

    static void getBytes(AbstractByteBuf abstractByteBuf, long j, int i, OutputStream outputStream, int i2) {
        abstractByteBuf.checkIndex(i, i2);
        if (i2 != 0) {
            ByteBuf byteBufHeapBuffer = abstractByteBuf.alloc().heapBuffer(i2);
            try {
                byte[] bArrArray = byteBufHeapBuffer.array();
                int iArrayOffset = byteBufHeapBuffer.arrayOffset();
                PlatformDependent.copyMemory(j, bArrArray, iArrayOffset, i2);
                outputStream.write(bArrArray, iArrayOffset, i2);
            } finally {
                byteBufHeapBuffer.release();
            }
        }
    }

    private UnsafeByteBufUtil() {
    }
}
