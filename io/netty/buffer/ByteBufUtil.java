package io.netty.buffer;

import com.baidu.mobads.container.adrequest.g;
import com.kwai.video.player.KsMediaMeta;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.Recycler;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ByteBufUtil {
    static final ByteBufAllocator DEFAULT_ALLOCATOR;
    private static final int MAX_CHAR_BUFFER_SIZE;
    private static final int THREAD_LOCAL_BUFFER_SIZE;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ByteBufUtil.class);
    private static final FastThreadLocal<CharBuffer> CHAR_BUFFERS = new FastThreadLocal<CharBuffer>() { // from class: io.netty.buffer.ByteBufUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public final CharBuffer initialValue() {
            return CharBuffer.allocate(1024);
        }
    };

    public static int swapMedium(int i) {
        int i2 = ((i >>> 16) & 255) | ((i << 16) & 16711680) | (65280 & i);
        return (8388608 & i2) != 0 ? i2 | (-16777216) : i2;
    }

    static {
        ByteBufAllocator byteBufAllocator;
        String strTrim = SystemPropertyUtil.get("io.netty.allocator.type", PlatformDependent.isAndroid() ? "unpooled" : "pooled").toLowerCase(Locale.US).trim();
        if ("unpooled".equals(strTrim)) {
            byteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
            logger.debug("-Dio.netty.allocator.type: {}", strTrim);
        } else if ("pooled".equals(strTrim)) {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            logger.debug("-Dio.netty.allocator.type: {}", strTrim);
        } else {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            logger.debug("-Dio.netty.allocator.type: pooled (unknown: {})", strTrim);
        }
        DEFAULT_ALLOCATOR = byteBufAllocator;
        THREAD_LOCAL_BUFFER_SIZE = SystemPropertyUtil.getInt("io.netty.threadLocalDirectBufferSize", 65536);
        logger.debug("-Dio.netty.threadLocalDirectBufferSize: {}", Integer.valueOf(THREAD_LOCAL_BUFFER_SIZE));
        MAX_CHAR_BUFFER_SIZE = SystemPropertyUtil.getInt("io.netty.maxThreadLocalCharBufferSize", 16384);
        logger.debug("-Dio.netty.maxThreadLocalCharBufferSize: {}", Integer.valueOf(MAX_CHAR_BUFFER_SIZE));
    }

    public static String hexDump(ByteBuf byteBuf) {
        return hexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static String hexDump(ByteBuf byteBuf, int i, int i2) {
        return HexUtil.hexDump(byteBuf, i, i2);
    }

    public static String hexDump(byte[] bArr) {
        return hexDump(bArr, 0, bArr.length);
    }

    public static String hexDump(byte[] bArr, int i, int i2) {
        return HexUtil.hexDump(bArr, i, i2);
    }

    public static int hashCode(ByteBuf byteBuf) {
        int i;
        int iSwapInt;
        int i2 = byteBuf.readableBytes();
        int i3 = i2 >>> 2;
        int i4 = i2 & 3;
        int i5 = byteBuf.readerIndex();
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            i = i5;
            iSwapInt = 1;
            while (i3 > 0) {
                iSwapInt = (iSwapInt * 31) + byteBuf.getInt(i);
                i += 4;
                i3--;
            }
        } else {
            i = i5;
            iSwapInt = 1;
            while (i3 > 0) {
                iSwapInt = (iSwapInt * 31) + swapInt(byteBuf.getInt(i));
                i += 4;
                i3--;
            }
        }
        while (i4 > 0) {
            iSwapInt = (iSwapInt * 31) + byteBuf.getByte(i);
            i4--;
            i++;
        }
        if (iSwapInt == 0) {
            return 1;
        }
        return iSwapInt;
    }

    public static boolean equals(ByteBuf byteBuf, int i, ByteBuf byteBuf2, int i2, int i3) {
        if (i < 0 || i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("All indexes and lengths must be non-negative");
        }
        if (byteBuf.writerIndex() - i3 < i || byteBuf2.writerIndex() - i3 < i2) {
            return false;
        }
        int i4 = i3 >>> 3;
        if (byteBuf.order() == byteBuf2.order()) {
            while (i4 > 0) {
                if (byteBuf.getLong(i) != byteBuf2.getLong(i2)) {
                    return false;
                }
                i += 8;
                i2 += 8;
                i4--;
            }
        } else {
            while (i4 > 0) {
                if (byteBuf.getLong(i) != swapLong(byteBuf2.getLong(i2))) {
                    return false;
                }
                i += 8;
                i2 += 8;
                i4--;
            }
        }
        for (int i5 = i3 & 7; i5 > 0; i5--) {
            if (byteBuf.getByte(i) != byteBuf2.getByte(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static boolean equals(ByteBuf byteBuf, ByteBuf byteBuf2) {
        int i = byteBuf.readableBytes();
        if (i != byteBuf2.readableBytes()) {
            return false;
        }
        return equals(byteBuf, byteBuf.readerIndex(), byteBuf2, byteBuf2.readerIndex(), i);
    }

    public static int compare(ByteBuf byteBuf, ByteBuf byteBuf2) {
        int i = byteBuf.readableBytes();
        int i2 = byteBuf2.readableBytes();
        int iMin = Math.min(i, i2);
        int i3 = iMin >>> 2;
        int i4 = byteBuf.readerIndex();
        int i5 = byteBuf2.readerIndex();
        if (byteBuf.order() == byteBuf2.order()) {
            while (i3 > 0) {
                long unsignedInt = byteBuf.getUnsignedInt(i4);
                long unsignedInt2 = byteBuf2.getUnsignedInt(i5);
                if (unsignedInt > unsignedInt2) {
                    return 1;
                }
                if (unsignedInt < unsignedInt2) {
                    return -1;
                }
                i4 += 4;
                i5 += 4;
                i3--;
            }
        } else {
            while (i3 > 0) {
                long unsignedInt3 = byteBuf.getUnsignedInt(i4);
                long jSwapInt = swapInt(byteBuf2.getInt(i5)) & C00oOOo.f362O8oO888;
                if (unsignedInt3 > jSwapInt) {
                    return 1;
                }
                if (unsignedInt3 < jSwapInt) {
                    return -1;
                }
                i4 += 4;
                i5 += 4;
                i3--;
            }
        }
        for (int i6 = iMin & 3; i6 > 0; i6--) {
            short unsignedByte = byteBuf.getUnsignedByte(i4);
            short unsignedByte2 = byteBuf2.getUnsignedByte(i5);
            if (unsignedByte > unsignedByte2) {
                return 1;
            }
            if (unsignedByte < unsignedByte2) {
                return -1;
            }
            i4++;
            i5++;
        }
        return i - i2;
    }

    public static int indexOf(ByteBuf byteBuf, int i, int i2, byte b) {
        if (i <= i2) {
            return firstIndexOf(byteBuf, i, i2, b);
        }
        return lastIndexOf(byteBuf, i, i2, b);
    }

    public static short swapShort(short s) {
        return Short.reverseBytes(s);
    }

    public static int swapInt(int i) {
        return Integer.reverseBytes(i);
    }

    public static long swapLong(long j) {
        return Long.reverseBytes(j);
    }

    public static ByteBuf readBytes(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int i) {
        ByteBuf byteBufBuffer = byteBufAllocator.buffer(i);
        try {
            byteBuf.readBytes(byteBufBuffer);
            return byteBufBuffer;
        } catch (Throwable th) {
            byteBufBuffer.release();
            throw th;
        }
    }

    private static int firstIndexOf(ByteBuf byteBuf, int i, int i2, byte b) {
        int iMax = Math.max(i, 0);
        if (iMax >= i2 || byteBuf.capacity() == 0) {
            return -1;
        }
        return byteBuf.forEachByte(iMax, i2 - iMax, new ByteProcessor.IndexOfProcessor(b));
    }

    private static int lastIndexOf(ByteBuf byteBuf, int i, int i2, byte b) {
        int iMin = Math.min(i, byteBuf.capacity());
        if (iMin < 0 || byteBuf.capacity() == 0) {
            return -1;
        }
        return byteBuf.forEachByteDesc(i2, iMin - i2, new ByteProcessor.IndexOfProcessor(b));
    }

    public static int writeUtf8(ByteBuf byteBuf, CharSequence charSequence) {
        if (byteBuf == null) {
            throw new NullPointerException("buf");
        }
        if (charSequence == null) {
            throw new NullPointerException(g.ag);
        }
        int length = charSequence.length();
        byteBuf.ensureWritable(length * 3);
        while (!(byteBuf instanceof AbstractByteBuf)) {
            if (byteBuf instanceof WrappedByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                byte[] bytes = charSequence.toString().getBytes(CharsetUtil.UTF_8);
                byteBuf.writeBytes(bytes);
                return bytes.length;
            }
        }
        return writeUtf8((AbstractByteBuf) byteBuf, charSequence, length);
    }

    private static int writeUtf8(AbstractByteBuf abstractByteBuf, CharSequence charSequence, int i) {
        int i2 = abstractByteBuf.writerIndex;
        int i3 = 0;
        int i4 = i2;
        while (i3 < i) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt < 128) {
                abstractByteBuf._setByte(i4, (byte) cCharAt);
                i4++;
            } else if (cCharAt < 2048) {
                int i5 = i4 + 1;
                abstractByteBuf._setByte(i4, (byte) ((cCharAt >> 6) | 192));
                i4 = i5 + 1;
                abstractByteBuf._setByte(i5, (byte) ((cCharAt & '?') | 128));
            } else if (StringUtil.isSurrogate(cCharAt)) {
                if (!Character.isHighSurrogate(cCharAt)) {
                    throw new IllegalArgumentException("Invalid encoding. Expected high (leading) surrogate at index " + i3 + " but got " + cCharAt);
                }
                i3++;
                try {
                    char cCharAt2 = charSequence.charAt(i3);
                    if (!Character.isLowSurrogate(cCharAt2)) {
                        throw new IllegalArgumentException("Invalid encoding. Expected low (trailing) surrogate at index " + i3 + " but got " + cCharAt2);
                    }
                    int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                    int i6 = i4 + 1;
                    abstractByteBuf._setByte(i4, (byte) ((codePoint >> 18) | 240));
                    int i7 = i6 + 1;
                    abstractByteBuf._setByte(i6, (byte) (((codePoint >> 12) & 63) | 128));
                    int i8 = i7 + 1;
                    abstractByteBuf._setByte(i7, (byte) (((codePoint >> 6) & 63) | 128));
                    i4 = i8 + 1;
                    abstractByteBuf._setByte(i8, (byte) ((codePoint & 63) | 128));
                } catch (IndexOutOfBoundsException e) {
                    throw new IllegalArgumentException("Underflow. Expected low (trailing) surrogate at index " + i3 + " but no more characters found.", e);
                }
            } else {
                int i9 = i4 + 1;
                abstractByteBuf._setByte(i4, (byte) ((cCharAt >> '\f') | 224));
                int i10 = i9 + 1;
                abstractByteBuf._setByte(i9, (byte) (((cCharAt >> 6) & 63) | 128));
                abstractByteBuf._setByte(i10, (byte) ((cCharAt & '?') | 128));
                i4 = i10 + 1;
            }
            i3++;
        }
        abstractByteBuf.writerIndex = i4;
        return i4 - i2;
    }

    public static int writeAscii(ByteBuf byteBuf, CharSequence charSequence) {
        if (byteBuf == null) {
            throw new NullPointerException("buf");
        }
        if (charSequence == null) {
            throw new NullPointerException(g.ag);
        }
        int length = charSequence.length();
        byteBuf.ensureWritable(length);
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            byteBuf.writeBytes(asciiString.array(), asciiString.arrayOffset(), asciiString.length());
        } else {
            while (!(byteBuf instanceof AbstractByteBuf)) {
                if (byteBuf instanceof WrappedByteBuf) {
                    byteBuf = byteBuf.unwrap();
                } else {
                    byteBuf.writeBytes(charSequence.toString().getBytes(CharsetUtil.US_ASCII));
                }
            }
            writeAscii((AbstractByteBuf) byteBuf, charSequence, length);
        }
        return length;
    }

    private static void writeAscii(AbstractByteBuf abstractByteBuf, CharSequence charSequence, int i) {
        int i2 = abstractByteBuf.writerIndex;
        int i3 = 0;
        while (i3 < i) {
            abstractByteBuf._setByte(i2, (byte) charSequence.charAt(i3));
            i3++;
            i2++;
        }
        abstractByteBuf.writerIndex = i2;
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset) {
        return encodeString0(byteBufAllocator, false, charBuffer, charset);
    }

    static ByteBuf encodeString0(ByteBufAllocator byteBufAllocator, boolean z, CharBuffer charBuffer, Charset charset) {
        ByteBuf byteBufBuffer;
        CharsetEncoder encoder = CharsetUtil.getEncoder(charset);
        double dRemaining = charBuffer.remaining();
        double dMaxBytesPerChar = encoder.maxBytesPerChar();
        Double.isNaN(dRemaining);
        Double.isNaN(dMaxBytesPerChar);
        int i = (int) (dRemaining * dMaxBytesPerChar);
        if (z) {
            byteBufBuffer = byteBufAllocator.heapBuffer(i);
        } else {
            byteBufBuffer = byteBufAllocator.buffer(i);
        }
        try {
            try {
                ByteBuffer byteBufferInternalNioBuffer = byteBufBuffer.internalNioBuffer(0, i);
                int iPosition = byteBufferInternalNioBuffer.position();
                CoderResult coderResultEncode = encoder.encode(charBuffer, byteBufferInternalNioBuffer, true);
                if (!coderResultEncode.isUnderflow()) {
                    coderResultEncode.throwException();
                }
                CoderResult coderResultFlush = encoder.flush(byteBufferInternalNioBuffer);
                if (!coderResultFlush.isUnderflow()) {
                    coderResultFlush.throwException();
                }
                byteBufBuffer.writerIndex((byteBufBuffer.writerIndex() + byteBufferInternalNioBuffer.position()) - iPosition);
                return byteBufBuffer;
            } catch (CharacterCodingException e) {
                throw new IllegalStateException(e);
            }
        } catch (Throwable th) {
            byteBufBuffer.release();
            throw th;
        }
    }

    static String decodeString(ByteBuf byteBuf, int i, int i2, Charset charset) throws Throwable {
        if (i2 == 0) {
            return "";
        }
        CharsetDecoder decoder = CharsetUtil.getDecoder(charset);
        double d = i2;
        double dMaxCharsPerByte = decoder.maxCharsPerByte();
        Double.isNaN(d);
        Double.isNaN(dMaxCharsPerByte);
        int i3 = (int) (d * dMaxCharsPerByte);
        CharBuffer charBufferAllocate = CHAR_BUFFERS.get();
        if (charBufferAllocate.length() < i3) {
            charBufferAllocate = CharBuffer.allocate(i3);
            if (i3 <= MAX_CHAR_BUFFER_SIZE) {
                CHAR_BUFFERS.set(charBufferAllocate);
            }
        } else {
            charBufferAllocate.clear();
        }
        if (byteBuf.nioBufferCount() == 1) {
            decodeString(decoder, byteBuf.internalNioBuffer(i, i2), charBufferAllocate);
        } else {
            ByteBuf byteBufHeapBuffer = byteBuf.alloc().heapBuffer(i2);
            try {
                byteBufHeapBuffer.writeBytes(byteBuf, i, i2);
                decodeString(decoder, byteBufHeapBuffer.internalNioBuffer(0, i2), charBufferAllocate);
            } finally {
                byteBufHeapBuffer.release();
            }
        }
        return charBufferAllocate.flip().toString();
    }

    private static void decodeString(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) throws CharacterCodingException {
        try {
            CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!coderResultDecode.isUnderflow()) {
                coderResultDecode.throwException();
            }
            CoderResult coderResultFlush = charsetDecoder.flush(charBuffer);
            if (coderResultFlush.isUnderflow()) {
                return;
            }
            coderResultFlush.throwException();
        } catch (CharacterCodingException e) {
            throw new IllegalStateException(e);
        }
    }

    public static ByteBuf threadLocalDirectBuffer() {
        if (THREAD_LOCAL_BUFFER_SIZE <= 0) {
            return null;
        }
        if (PlatformDependent.hasUnsafe()) {
            return ThreadLocalUnsafeDirectByteBuf.newInstance();
        }
        return ThreadLocalDirectByteBuf.newInstance();
    }

    public static byte[] getBytes(ByteBuf byteBuf) {
        return getBytes(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i, int i2) {
        return getBytes(byteBuf, i, i2, true);
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i, int i2, boolean z) {
        if (MathUtil.isOutOfBounds(i, i2, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + i + ") <= start + length(" + i2 + ") <= buf.capacity(" + byteBuf.capacity() + ')');
        }
        if (byteBuf.hasArray()) {
            if (z || i != 0 || i2 != byteBuf.capacity()) {
                int iArrayOffset = byteBuf.arrayOffset() + i;
                return Arrays.copyOfRange(byteBuf.array(), iArrayOffset, i2 + iArrayOffset);
            }
            return byteBuf.array();
        }
        byte[] bArr = new byte[i2];
        byteBuf.getBytes(i, bArr);
        return bArr;
    }

    public static void copy(AsciiString asciiString, int i, ByteBuf byteBuf, int i2, int i3) {
        if (MathUtil.isOutOfBounds(i, i3, asciiString.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i + ") <= srcIdx + length(" + i3 + ") <= srcLen(" + asciiString.length() + ')');
        }
        ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).setBytes(i2, asciiString.array(), i + asciiString.arrayOffset(), i3);
    }

    public static void copy(AsciiString asciiString, int i, ByteBuf byteBuf, int i2) {
        if (MathUtil.isOutOfBounds(i, i2, asciiString.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i + ") <= srcIdx + length(" + i2 + ") <= srcLen(" + asciiString.length() + ')');
        }
        ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).writeBytes(asciiString.array(), i + asciiString.arrayOffset(), i2);
    }

    public static String prettyHexDump(ByteBuf byteBuf) {
        return prettyHexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static String prettyHexDump(ByteBuf byteBuf, int i, int i2) {
        return HexUtil.prettyHexDump(byteBuf, i, i2);
    }

    public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf) {
        appendPrettyHexDump(sb, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf, int i, int i2) {
        HexUtil.appendPrettyHexDump(sb, byteBuf, i, i2);
    }

    static final class HexUtil {
        private static final char[] BYTE2CHAR = new char[256];
        private static final char[] HEXDUMP_TABLE = new char[1024];
        private static final String[] HEXPADDING = new String[16];
        private static final String[] HEXDUMP_ROWPREFIXES = new String[4096];
        private static final String[] BYTE2HEX = new String[256];
        private static final String[] BYTEPADDING = new String[16];

        private HexUtil() {
        }

        static {
            char[] charArray = "0123456789abcdef".toCharArray();
            int i = 0;
            for (int i2 = 0; i2 < 256; i2++) {
                char[] cArr = HEXDUMP_TABLE;
                int i3 = i2 << 1;
                cArr[i3] = charArray[(i2 >>> 4) & 15];
                cArr[i3 + 1] = charArray[i2 & 15];
            }
            int i4 = 0;
            while (true) {
                String[] strArr = HEXPADDING;
                if (i4 >= strArr.length) {
                    break;
                }
                int length = strArr.length - i4;
                StringBuilder sb = new StringBuilder(length * 3);
                for (int i5 = 0; i5 < length; i5++) {
                    sb.append("   ");
                }
                HEXPADDING[i4] = sb.toString();
                i4++;
            }
            for (int i6 = 0; i6 < HEXDUMP_ROWPREFIXES.length; i6++) {
                StringBuilder sb2 = new StringBuilder(12);
                sb2.append(StringUtil.NEWLINE);
                sb2.append(Long.toHexString(((i6 << 4) & C00oOOo.f362O8oO888) | KsMediaMeta.AV_CH_WIDE_RIGHT));
                sb2.setCharAt(sb2.length() - 9, '|');
                sb2.append('|');
                HEXDUMP_ROWPREFIXES[i6] = sb2.toString();
            }
            int i7 = 0;
            while (true) {
                String[] strArr2 = BYTE2HEX;
                if (i7 >= strArr2.length) {
                    break;
                }
                strArr2[i7] = " " + StringUtil.byteToHexStringPadded(i7);
                i7++;
            }
            int i8 = 0;
            while (true) {
                String[] strArr3 = BYTEPADDING;
                if (i8 >= strArr3.length) {
                    break;
                }
                int length2 = strArr3.length - i8;
                StringBuilder sb3 = new StringBuilder(length2);
                for (int i9 = 0; i9 < length2; i9++) {
                    sb3.append(' ');
                }
                BYTEPADDING[i8] = sb3.toString();
                i8++;
            }
            while (true) {
                char[] cArr2 = BYTE2CHAR;
                if (i >= cArr2.length) {
                    return;
                }
                if (i <= 31 || i >= 127) {
                    BYTE2CHAR[i] = '.';
                } else {
                    cArr2[i] = (char) i;
                }
                i++;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(ByteBuf byteBuf, int i, int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("length: " + i2);
            }
            if (i2 == 0) {
                return "";
            }
            int i3 = i + i2;
            char[] cArr = new char[i2 << 1];
            int i4 = 0;
            while (i < i3) {
                System.arraycopy(HEXDUMP_TABLE, byteBuf.getUnsignedByte(i) << 1, cArr, i4, 2);
                i++;
                i4 += 2;
            }
            return new String(cArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(byte[] bArr, int i, int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("length: " + i2);
            }
            if (i2 == 0) {
                return "";
            }
            int i3 = i + i2;
            char[] cArr = new char[i2 << 1];
            int i4 = 0;
            while (i < i3) {
                System.arraycopy(HEXDUMP_TABLE, (bArr[i] & 255) << 1, cArr, i4, 2);
                i++;
                i4 += 2;
            }
            return new String(cArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String prettyHexDump(ByteBuf byteBuf, int i, int i2) {
            if (i2 == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(((i2 / 16) + (i2 % 15 == 0 ? 0 : 1) + 4) * 80);
            appendPrettyHexDump(sb, byteBuf, i, i2);
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf, int i, int i2) {
            if (MathUtil.isOutOfBounds(i, i2, byteBuf.capacity())) {
                throw new IndexOutOfBoundsException("expected: 0 <= offset(" + i + ") <= offset + length(" + i2 + ") <= buf.capacity(" + byteBuf.capacity() + ')');
            }
            if (i2 == 0) {
                return;
            }
            sb.append("         +-------------------------------------------------+" + StringUtil.NEWLINE + "         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |" + StringUtil.NEWLINE + "+--------+-------------------------------------------------+----------------+");
            int i3 = i2 >>> 4;
            int i4 = i2 & 15;
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = (i5 << 4) + i;
                appendHexDumpRowPrefix(sb, i5, i6);
                int i7 = i6 + 16;
                for (int i8 = i6; i8 < i7; i8++) {
                    sb.append(BYTE2HEX[byteBuf.getUnsignedByte(i8)]);
                }
                sb.append(" |");
                while (i6 < i7) {
                    sb.append(BYTE2CHAR[byteBuf.getUnsignedByte(i6)]);
                    i6++;
                }
                sb.append('|');
            }
            if (i4 != 0) {
                int i9 = (i3 << 4) + i;
                appendHexDumpRowPrefix(sb, i3, i9);
                int i10 = i9 + i4;
                for (int i11 = i9; i11 < i10; i11++) {
                    sb.append(BYTE2HEX[byteBuf.getUnsignedByte(i11)]);
                }
                sb.append(HEXPADDING[i4]);
                sb.append(" |");
                while (i9 < i10) {
                    sb.append(BYTE2CHAR[byteBuf.getUnsignedByte(i9)]);
                    i9++;
                }
                sb.append(BYTEPADDING[i4]);
                sb.append('|');
            }
            sb.append(StringUtil.NEWLINE + "+--------+-------------------------------------------------+----------------+");
        }

        private static void appendHexDumpRowPrefix(StringBuilder sb, int i, int i2) {
            String[] strArr = HEXDUMP_ROWPREFIXES;
            if (i < strArr.length) {
                sb.append(strArr[i]);
                return;
            }
            sb.append(StringUtil.NEWLINE);
            sb.append(Long.toHexString((i2 & C00oOOo.f362O8oO888) | KsMediaMeta.AV_CH_WIDE_RIGHT));
            sb.setCharAt(sb.length() - 9, '|');
            sb.append('|');
        }
    }

    static final class ThreadLocalUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        private static final Recycler<ThreadLocalUnsafeDirectByteBuf> RECYCLER = new Recycler<ThreadLocalUnsafeDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalUnsafeDirectByteBuf.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.Recycler
            /* renamed from: newObject */
            public final ThreadLocalUnsafeDirectByteBuf newObject2(Recycler.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
                return new ThreadLocalUnsafeDirectByteBuf(handle);
            }
        };
        private final Recycler.Handle handle;

        static ThreadLocalUnsafeDirectByteBuf newInstance() {
            ThreadLocalUnsafeDirectByteBuf threadLocalUnsafeDirectByteBuf = RECYCLER.get();
            threadLocalUnsafeDirectByteBuf.setRefCnt(1);
            return threadLocalUnsafeDirectByteBuf;
        }

        private ThreadLocalUnsafeDirectByteBuf(Recycler.Handle handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle;
        }

        @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        protected final void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
            } else {
                clear();
                RECYCLER.recycle(this, this.handle);
            }
        }
    }

    static final class ThreadLocalDirectByteBuf extends UnpooledDirectByteBuf {
        private static final Recycler<ThreadLocalDirectByteBuf> RECYCLER = new Recycler<ThreadLocalDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalDirectByteBuf.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.Recycler
            /* renamed from: newObject */
            public final ThreadLocalDirectByteBuf newObject2(Recycler.Handle<ThreadLocalDirectByteBuf> handle) {
                return new ThreadLocalDirectByteBuf(handle);
            }
        };
        private final Recycler.Handle handle;

        static ThreadLocalDirectByteBuf newInstance() {
            ThreadLocalDirectByteBuf threadLocalDirectByteBuf = RECYCLER.get();
            threadLocalDirectByteBuf.setRefCnt(1);
            return threadLocalDirectByteBuf;
        }

        private ThreadLocalDirectByteBuf(Recycler.Handle handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        protected final void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
            } else {
                clear();
                RECYCLER.recycle(this, this.handle);
            }
        }
    }

    private ByteBufUtil() {
    }
}
