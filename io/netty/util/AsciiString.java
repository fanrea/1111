package io.netty.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class AsciiString implements CharSequence, Comparable<CharSequence> {
    public static final int INDEX_NOT_FOUND = -1;
    private static final char MAX_CHAR_VALUE = 255;
    private int hash;
    private final int length;
    private final int offset;
    private String string;
    private final byte[] value;
    public static final AsciiString EMPTY_STRING = new AsciiString("");
    public static final HashingStrategy<CharSequence> CASE_INSENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.1
        @Override // io.netty.util.HashingStrategy
        public final int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }

        @Override // io.netty.util.HashingStrategy
        public final boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEqualsIgnoreCase(charSequence, charSequence2);
        }
    };
    public static final HashingStrategy<CharSequence> CASE_SENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.2
        @Override // io.netty.util.HashingStrategy
        public final int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }

        @Override // io.netty.util.HashingStrategy
        public final boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEquals(charSequence, charSequence2);
        }
    };

    interface CharEqualityComparator {
        boolean equals(char c, char c2);
    }

    public static char b2c(byte b) {
        return (char) (b & 255);
    }

    public static byte c2b(char c) {
        if (c > 255) {
            c = '?';
        }
        return (byte) c;
    }

    private static boolean isLowerCase(byte b) {
        return b >= 97 && b <= 122;
    }

    public static boolean isUpperCase(byte b) {
        return b >= 65 && b <= 90;
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public AsciiString(byte[] bArr) {
        this(bArr, true);
    }

    public AsciiString(byte[] bArr, boolean z) {
        this(bArr, 0, bArr.length, z);
    }

    public AsciiString(byte[] bArr, int i, int i2, boolean z) {
        if (z) {
            this.value = Arrays.copyOfRange(bArr, i, i + i2);
            this.offset = 0;
        } else {
            if (MathUtil.isOutOfBounds(i, i2, bArr.length)) {
                throw new IndexOutOfBoundsException("expected: 0 <= start(" + i + ") <= start + length(" + i2 + ") <= value.length(" + bArr.length + ')');
            }
            this.value = bArr;
            this.offset = i;
        }
        this.length = i2;
    }

    public AsciiString(ByteBuffer byteBuffer) {
        this(byteBuffer, true);
    }

    public AsciiString(ByteBuffer byteBuffer, boolean z) {
        this(byteBuffer, byteBuffer.position(), byteBuffer.remaining(), z);
    }

    public AsciiString(ByteBuffer byteBuffer, int i, int i2, boolean z) {
        if (MathUtil.isOutOfBounds(i, i2, byteBuffer.capacity())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + i + ") <= start + length(" + i2 + ") <= value.capacity(" + byteBuffer.capacity() + ')');
        }
        if (!byteBuffer.hasArray()) {
            this.value = new byte[i2];
            int iPosition = byteBuffer.position();
            byteBuffer.get(this.value, 0, i2);
            byteBuffer.position(iPosition);
            this.offset = 0;
        } else if (z) {
            int iArrayOffset = byteBuffer.arrayOffset() + i;
            this.value = Arrays.copyOfRange(byteBuffer.array(), iArrayOffset, iArrayOffset + i2);
            this.offset = 0;
        } else {
            this.value = byteBuffer.array();
            this.offset = i;
        }
        this.length = i2;
    }

    public AsciiString(char[] cArr) {
        this(cArr, 0, cArr.length);
    }

    public AsciiString(char[] cArr, int i, int i2) {
        if (MathUtil.isOutOfBounds(i, i2, cArr.length)) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + i + ") <= start + length(" + i2 + ") <= value.length(" + cArr.length + ')');
        }
        this.value = new byte[i2];
        int i3 = i;
        int i4 = 0;
        while (i4 < i2) {
            this.value[i4] = c2b(cArr[i3]);
            i4++;
            i3++;
        }
        this.offset = 0;
        this.length = i2;
    }

    public AsciiString(char[] cArr, Charset charset) {
        this(cArr, charset, 0, cArr.length);
    }

    public AsciiString(char[] cArr, Charset charset, int i, int i2) {
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr, i, i2);
        CharsetEncoder encoder = CharsetUtil.getEncoder(charset);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) (encoder.maxBytesPerChar() * i2));
        encoder.encode(charBufferWrap, byteBufferAllocate, true);
        int iArrayOffset = byteBufferAllocate.arrayOffset();
        this.value = Arrays.copyOfRange(byteBufferAllocate.array(), iArrayOffset, byteBufferAllocate.position() + iArrayOffset);
        this.offset = 0;
        this.length = this.value.length;
    }

    public AsciiString(CharSequence charSequence) {
        this(charSequence, 0, charSequence.length());
    }

    public AsciiString(CharSequence charSequence, int i, int i2) {
        if (MathUtil.isOutOfBounds(i, i2, charSequence.length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + i + ") <= start + length(" + i2 + ") <= value.length(" + charSequence.length() + ')');
        }
        this.value = new byte[i2];
        int i3 = i;
        int i4 = 0;
        while (i4 < i2) {
            this.value[i4] = c2b(charSequence.charAt(i3));
            i4++;
            i3++;
        }
        this.offset = 0;
        this.length = i2;
    }

    public AsciiString(CharSequence charSequence, Charset charset) {
        this(charSequence, charset, 0, charSequence.length());
    }

    public AsciiString(CharSequence charSequence, Charset charset, int i, int i2) {
        CharBuffer charBufferWrap = CharBuffer.wrap(charSequence, i, i + i2);
        CharsetEncoder encoder = CharsetUtil.getEncoder(charset);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) (encoder.maxBytesPerChar() * i2));
        encoder.encode(charBufferWrap, byteBufferAllocate, true);
        int iArrayOffset = byteBufferAllocate.arrayOffset();
        this.value = Arrays.copyOfRange(byteBufferAllocate.array(), iArrayOffset, byteBufferAllocate.position() + iArrayOffset);
        this.offset = 0;
        this.length = this.value.length;
    }

    public final int forEachByte(ByteProcessor byteProcessor) {
        return forEachByte0(0, length(), byteProcessor);
    }

    public final int forEachByte(int i, int i2, ByteProcessor byteProcessor) {
        if (MathUtil.isOutOfBounds(i, i2, length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= index(" + i + ") <= start + length(" + i2 + ") <= length(" + length() + ')');
        }
        return forEachByte0(i, i2, byteProcessor);
    }

    private int forEachByte0(int i, int i2, ByteProcessor byteProcessor) {
        int i3 = this.offset;
        int i4 = i3 + i + i2;
        for (int i5 = i3 + i; i5 < i4; i5++) {
            if (!byteProcessor.process(this.value[i5])) {
                return i5 - this.offset;
            }
        }
        return -1;
    }

    public final int forEachByteDesc(ByteProcessor byteProcessor) {
        return forEachByteDesc0(0, length(), byteProcessor);
    }

    public final int forEachByteDesc(int i, int i2, ByteProcessor byteProcessor) {
        if (MathUtil.isOutOfBounds(i, i2, length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= index(" + i + ") <= start + length(" + i2 + ") <= length(" + length() + ')');
        }
        return forEachByteDesc0(i, i2, byteProcessor);
    }

    private int forEachByteDesc0(int i, int i2, ByteProcessor byteProcessor) {
        int i3 = this.offset;
        int i4 = i3 + i;
        for (int i5 = ((i3 + i) + i2) - 1; i5 >= i4; i5--) {
            if (!byteProcessor.process(this.value[i5])) {
                return i5 - this.offset;
            }
        }
        return -1;
    }

    public final byte byteAt(int i) {
        if (i < 0 || i >= this.length) {
            throw new IndexOutOfBoundsException("index: " + i + " must be in the range [0," + this.length + ")");
        }
        if (PlatformDependent.hasUnsafe()) {
            return PlatformDependent.getByte(this.value, i + this.offset);
        }
        return this.value[i + this.offset];
    }

    public final boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.length;
    }

    public final void arrayChanged() {
        this.string = null;
        this.hash = 0;
    }

    public final byte[] array() {
        return this.value;
    }

    public final int arrayOffset() {
        return this.offset;
    }

    public final boolean isEntireArrayUsed() {
        return this.offset == 0 && this.length == this.value.length;
    }

    public final byte[] toByteArray() {
        return toByteArray(0, length());
    }

    public final byte[] toByteArray(int i, int i2) {
        byte[] bArr = this.value;
        int i3 = this.offset;
        return Arrays.copyOfRange(bArr, i + i3, i2 + i3);
    }

    public final void copy(int i, byte[] bArr, int i2, int i3) {
        if (MathUtil.isOutOfBounds(i, i3, length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i + ") <= srcIdx + length(" + i3 + ") <= srcLen(" + length() + ')');
        }
        System.arraycopy(this.value, i + this.offset, ObjectUtil.checkNotNull(bArr, "dst"), i2, i3);
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return b2c(byteAt(i));
    }

    public final boolean contains(CharSequence charSequence) {
        return indexOf(charSequence) >= 0;
    }

    @Override // java.lang.Comparable
    public final int compareTo(CharSequence charSequence) {
        int i = 0;
        if (this == charSequence) {
            return 0;
        }
        int length = length();
        int length2 = charSequence.length();
        int iMin = Math.min(length, length2);
        int iArrayOffset = arrayOffset();
        while (i < iMin) {
            int iB2c = b2c(this.value[iArrayOffset]) - charSequence.charAt(i);
            if (iB2c != 0) {
                return iB2c;
            }
            i++;
            iArrayOffset++;
        }
        return length - length2;
    }

    public final AsciiString concat(CharSequence charSequence) {
        int length = length();
        int length2 = charSequence.length();
        if (length2 == 0) {
            return this;
        }
        if (charSequence.getClass() == AsciiString.class) {
            AsciiString asciiString = (AsciiString) charSequence;
            if (isEmpty()) {
                return asciiString;
            }
            byte[] bArr = new byte[length + length2];
            System.arraycopy(this.value, arrayOffset(), bArr, 0, length);
            System.arraycopy(asciiString.value, asciiString.arrayOffset(), bArr, length, length2);
            return new AsciiString(bArr, false);
        }
        if (isEmpty()) {
            return new AsciiString(charSequence);
        }
        byte[] bArr2 = new byte[length2 + length];
        System.arraycopy(this.value, arrayOffset(), bArr2, 0, length);
        int i = 0;
        while (length < bArr2.length) {
            bArr2[length] = c2b(charSequence.charAt(i));
            length++;
            i++;
        }
        return new AsciiString(bArr2, false);
    }

    public final boolean endsWith(CharSequence charSequence) {
        int length = charSequence.length();
        return regionMatches(length() - length, charSequence, 0, length);
    }

    public final boolean contentEqualsIgnoreCase(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (charSequence.getClass() == AsciiString.class) {
            AsciiString asciiString = (AsciiString) charSequence;
            int iArrayOffset = arrayOffset();
            int iArrayOffset2 = asciiString.arrayOffset();
            while (iArrayOffset < length()) {
                if (!equalsIgnoreCase(this.value[iArrayOffset], asciiString.value[iArrayOffset2])) {
                    return false;
                }
                iArrayOffset++;
                iArrayOffset2++;
            }
            return true;
        }
        int iArrayOffset3 = arrayOffset();
        int i = 0;
        while (iArrayOffset3 < length()) {
            if (!equalsIgnoreCase(b2c(this.value[iArrayOffset3]), charSequence.charAt(i))) {
                return false;
            }
            iArrayOffset3++;
            i++;
        }
        return true;
    }

    public final char[] toCharArray() {
        return toCharArray(0, length());
    }

    public final char[] toCharArray(int i, int i2) {
        int i3 = i2 - i;
        if (i3 == 0) {
            return EmptyArrays.EMPTY_CHARS;
        }
        if (MathUtil.isOutOfBounds(i, i3, length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + i + ") <= srcIdx + length(" + i3 + ") <= srcLen(" + length() + ')');
        }
        char[] cArr = new char[i3];
        int i4 = 0;
        int iArrayOffset = i + arrayOffset();
        while (i4 < i3) {
            cArr[i4] = b2c(this.value[iArrayOffset]);
            i4++;
            iArrayOffset++;
        }
        return cArr;
    }

    public final void copy(int i, char[] cArr, int i2, int i3) {
        if (cArr == null) {
            throw new NullPointerException("dst");
        }
        if (MathUtil.isOutOfBounds(i, i3, length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i + ") <= srcIdx + length(" + i3 + ") <= srcLen(" + length() + ')');
        }
        int i4 = i3 + i2;
        int iArrayOffset = i + arrayOffset();
        while (i2 < i4) {
            cArr[i2] = b2c(this.value[iArrayOffset]);
            i2++;
            iArrayOffset++;
        }
    }

    public final AsciiString subSequence(int i) {
        return subSequence(i, length());
    }

    @Override // java.lang.CharSequence
    public final AsciiString subSequence(int i, int i2) {
        return subSequence(i, i2, true);
    }

    public final AsciiString subSequence(int i, int i2, boolean z) {
        int i3 = i2 - i;
        if (MathUtil.isOutOfBounds(i, i3, length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + i + ") <= end (" + i2 + ") <= length(" + length() + ')');
        }
        if (i == 0 && i2 == length()) {
            return this;
        }
        if (i2 == i) {
            return EMPTY_STRING;
        }
        return new AsciiString(this.value, i + this.offset, i3, z);
    }

    public final int indexOf(CharSequence charSequence) {
        return indexOf(charSequence, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int indexOf(java.lang.CharSequence r10, int r11) throws java.lang.Throwable {
        /*
            r9 = this;
            r0 = 0
            if (r11 >= 0) goto L4
            r11 = 0
        L4:
            int r1 = r9.length()
            int r2 = r10.length()
            if (r2 > 0) goto L12
            if (r11 >= r1) goto L11
            return r11
        L11:
            return r1
        L12:
            int r3 = r1 - r11
            r4 = -1
            if (r2 <= r3) goto L18
            return r4
        L18:
            char r3 = r10.charAt(r0)
            r5 = 255(0xff, float:3.57E-43)
            if (r3 <= r5) goto L21
            return r4
        L21:
            io.netty.util.ByteProcessor$IndexOfProcessor r5 = new io.netty.util.ByteProcessor$IndexOfProcessor
            byte r3 = (byte) r3
            r5.<init>(r3)
        L27:
            int r3 = r1 - r11
            int r11 = r9.forEachByte(r11, r3, r5)     // Catch: java.lang.Exception -> L56
            if (r11 == r4) goto L55
            int r3 = r2 + r11
            if (r3 <= r1) goto L34
            goto L55
        L34:
            r6 = r11
            r3 = 0
        L36:
            int r3 = r3 + 1
            if (r3 >= r2) goto L4f
            byte[] r7 = r9.value     // Catch: java.lang.Exception -> L56
            int r6 = r6 + 1
            int r8 = r9.arrayOffset()     // Catch: java.lang.Exception -> L56
            int r8 = r8 + r6
            r7 = r7[r8]     // Catch: java.lang.Exception -> L56
            char r7 = b2c(r7)     // Catch: java.lang.Exception -> L56
            char r8 = r10.charAt(r3)     // Catch: java.lang.Exception -> L56
            if (r7 == r8) goto L36
        L4f:
            if (r3 != r2) goto L52
            return r11
        L52:
            int r11 = r11 + 1
            goto L27
        L55:
            return r4
        L56:
            r10 = move-exception
            io.netty.util.internal.PlatformDependent.throwException(r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.AsciiString.indexOf(java.lang.CharSequence, int):int");
    }

    public final int lastIndexOf(CharSequence charSequence) {
        return lastIndexOf(charSequence, length());
    }

    public final int lastIndexOf(CharSequence charSequence, int i) throws Throwable {
        int length = length();
        int length2 = charSequence.length();
        if (length2 <= length && i >= 0) {
            if (length2 <= 0) {
                return i < length ? i : length;
            }
            int iMin = Math.min(i, length - length2);
            char cCharAt = charSequence.charAt(0);
            if (cCharAt > 255) {
                return -1;
            }
            ByteProcessor.IndexOfProcessor indexOfProcessor = new ByteProcessor.IndexOfProcessor((byte) cCharAt);
            while (true) {
                try {
                    int iForEachByteDesc = forEachByteDesc(iMin, length - iMin, indexOfProcessor);
                    if (iForEachByteDesc == -1) {
                        return -1;
                    }
                    int i2 = iForEachByteDesc;
                    int i3 = 0;
                    do {
                        i3++;
                        if (i3 >= length2) {
                            break;
                        }
                        i2++;
                    } while (b2c(this.value[arrayOffset() + i2]) == charSequence.charAt(i3));
                    if (i3 == length2) {
                        return iForEachByteDesc;
                    }
                    iMin = iForEachByteDesc - 1;
                } catch (Exception e) {
                    PlatformDependent.throwException(e);
                }
            }
        }
        return -1;
    }

    public final boolean regionMatches(int i, CharSequence charSequence, int i2, int i3) {
        if (charSequence == null) {
            throw new NullPointerException(TypedValues.Custom.S_STRING);
        }
        if (i2 >= 0 && charSequence.length() - i2 >= i3) {
            int length = length();
            if (i >= 0 && length - i >= i3) {
                if (i3 <= 0) {
                    return true;
                }
                int i4 = i3 + i2;
                int iArrayOffset = i + arrayOffset();
                while (i2 < i4) {
                    if (b2c(this.value[iArrayOffset]) != charSequence.charAt(i2)) {
                        return false;
                    }
                    i2++;
                    iArrayOffset++;
                }
                return true;
            }
        }
        return false;
    }

    public final boolean regionMatches(boolean z, int i, CharSequence charSequence, int i2, int i3) {
        if (!z) {
            return regionMatches(i, charSequence, i2, i3);
        }
        if (charSequence == null) {
            throw new NullPointerException(TypedValues.Custom.S_STRING);
        }
        int length = length();
        if (i < 0 || i3 > length - i || i2 < 0 || i3 > charSequence.length() - i2) {
            return false;
        }
        int iArrayOffset = i + arrayOffset();
        int i4 = i3 + iArrayOffset;
        while (iArrayOffset < i4) {
            int i5 = iArrayOffset + 1;
            char cB2c = b2c(this.value[iArrayOffset]);
            int i6 = i2 + 1;
            if (!equalsIgnoreCase(cB2c, charSequence.charAt(i2))) {
                return false;
            }
            i2 = i6;
            iArrayOffset = i5;
        }
        return true;
    }

    public final AsciiString replace(char c, char c2) throws Throwable {
        if (c > 255) {
            return this;
        }
        byte bC2b = c2b(c);
        try {
            if (forEachByte(new ByteProcessor.IndexOfProcessor(bC2b)) == -1) {
                return this;
            }
            byte bC2b2 = c2b(c2);
            byte[] bArr = new byte[length()];
            int iArrayOffset = arrayOffset();
            int i = 0;
            while (i < bArr.length) {
                byte b = this.value[iArrayOffset];
                if (b == bC2b) {
                    b = bC2b2;
                }
                bArr[i] = b;
                i++;
                iArrayOffset++;
            }
            return new AsciiString(bArr, false);
        } catch (Exception e) {
            PlatformDependent.throwException(e);
            return this;
        }
    }

    public final boolean startsWith(CharSequence charSequence) {
        return startsWith(charSequence, 0);
    }

    public final boolean startsWith(CharSequence charSequence, int i) {
        return regionMatches(i, charSequence, 0, charSequence.length());
    }

    public final AsciiString toLowerCase() {
        boolean z;
        int length = length() + arrayOffset();
        int iArrayOffset = arrayOffset();
        while (true) {
            if (iArrayOffset >= length) {
                z = true;
                break;
            }
            byte b = this.value[iArrayOffset];
            if (b >= 65 && b <= 90) {
                z = false;
                break;
            }
            iArrayOffset++;
        }
        if (z) {
            return this;
        }
        byte[] bArr = new byte[length()];
        int iArrayOffset2 = arrayOffset();
        int i = 0;
        while (i < bArr.length) {
            bArr[i] = toLowerCase(this.value[iArrayOffset2]);
            i++;
            iArrayOffset2++;
        }
        return new AsciiString(bArr, false);
    }

    public final AsciiString toUpperCase() {
        boolean z;
        int length = length() + arrayOffset();
        int iArrayOffset = arrayOffset();
        while (true) {
            if (iArrayOffset >= length) {
                z = true;
                break;
            }
            byte b = this.value[iArrayOffset];
            if (b >= 97 && b <= 122) {
                z = false;
                break;
            }
            iArrayOffset++;
        }
        if (z) {
            return this;
        }
        byte[] bArr = new byte[length()];
        int iArrayOffset2 = arrayOffset();
        int i = 0;
        while (i < bArr.length) {
            bArr[i] = toUpperCase(this.value[iArrayOffset2]);
            i++;
            iArrayOffset2++;
        }
        return new AsciiString(bArr, false);
    }

    public final AsciiString trim() {
        int iArrayOffset = arrayOffset();
        int iArrayOffset2 = (arrayOffset() + length()) - 1;
        while (iArrayOffset <= iArrayOffset2 && this.value[iArrayOffset] <= 32) {
            iArrayOffset++;
        }
        int i = iArrayOffset2;
        while (i >= iArrayOffset && this.value[i] <= 32) {
            i--;
        }
        return (iArrayOffset == 0 && i == iArrayOffset2) ? this : new AsciiString(this.value, iArrayOffset, (i - iArrayOffset) + 1, false);
    }

    public final boolean contentEquals(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (charSequence.getClass() == AsciiString.class) {
            return equals(charSequence);
        }
        int iArrayOffset = arrayOffset();
        for (int i = 0; i < charSequence.length(); i++) {
            if (b2c(this.value[iArrayOffset]) != charSequence.charAt(i)) {
                return false;
            }
            iArrayOffset++;
        }
        return true;
    }

    public final boolean matches(String str) {
        return Pattern.matches(str, this);
    }

    public final AsciiString[] split(String str, int i) {
        return toAsciiStringArray(Pattern.compile(str).split(this, i));
    }

    public final AsciiString[] split(char c) {
        ArrayList arrayList = new ArrayList();
        int length = length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (charAt(i2) == c) {
                if (i == i2) {
                    arrayList.add(EMPTY_STRING);
                } else {
                    arrayList.add(new AsciiString(this.value, arrayOffset() + i, i2 - i, false));
                }
                i = i2 + 1;
            }
        }
        if (i == 0) {
            arrayList.add(this);
        } else if (i != length) {
            arrayList.add(new AsciiString(this.value, arrayOffset() + i, length - i, false));
        } else {
            for (int size = arrayList.size() - 1; size >= 0 && ((AsciiString) arrayList.get(size)).isEmpty(); size--) {
                arrayList.remove(size);
            }
        }
        return (AsciiString[]) arrayList.toArray(new AsciiString[arrayList.size()]);
    }

    public final int hashCode() {
        if (this.hash == 0) {
            this.hash = PlatformDependent.hashCodeAscii(this.value, this.offset, this.length);
        }
        return this.hash;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == AsciiString.class) {
            if (this == obj) {
                return true;
            }
            AsciiString asciiString = (AsciiString) obj;
            if (length() == asciiString.length() && hashCode() == asciiString.hashCode() && PlatformDependent.equals(array(), arrayOffset(), asciiString.array(), asciiString.arrayOffset(), length())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        String str = this.string;
        if (str != null) {
            return str;
        }
        this.string = toString(0);
        return this.string;
    }

    public final String toString(int i) {
        return toString(i, length());
    }

    public final String toString(int i, int i2) {
        int i3 = i2 - i;
        if (i3 == 0) {
            return "";
        }
        if (MathUtil.isOutOfBounds(i, i3, length())) {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + i + ") <= srcIdx + length(" + i3 + ") <= srcLen(" + length() + ')');
        }
        return new String(this.value, 0, i + this.offset, i3);
    }

    public final boolean parseBoolean() {
        return this.length > 0 && this.value[this.offset] != 0;
    }

    public final char parseChar() {
        return parseChar(0);
    }

    public final char parseChar(int i) {
        if (i + 1 >= length()) {
            throw new IndexOutOfBoundsException("2 bytes required to convert to character. index " + i + " would go out of bounds.");
        }
        int i2 = i + this.offset;
        return (char) (b2c(this.value[i2 + 1]) | (b2c(this.value[i2]) << '\b'));
    }

    public final short parseShort() {
        return parseShort(0, length(), 10);
    }

    public final short parseShort(int i) {
        return parseShort(0, length(), i);
    }

    public final short parseShort(int i, int i2) {
        return parseShort(i, i2, 10);
    }

    public final short parseShort(int i, int i2, int i3) {
        int i4 = parseInt(i, i2, i3);
        short s = (short) i4;
        if (s == i4) {
            return s;
        }
        throw new NumberFormatException(subSequence(i, i2, false).toString());
    }

    public final int parseInt() {
        return parseInt(0, length(), 10);
    }

    public final int parseInt(int i) {
        return parseInt(0, length(), i);
    }

    public final int parseInt(int i, int i2) {
        return parseInt(i, i2, 10);
    }

    public final int parseInt(int i, int i2, int i3) {
        if (i3 < 2 || i3 > 36) {
            throw new NumberFormatException();
        }
        if (i == i2) {
            throw new NumberFormatException();
        }
        boolean z = byteAt(i) == 45;
        if (z) {
            int i4 = i + 1;
            if (i4 == i2) {
                throw new NumberFormatException(subSequence(i, i2, false).toString());
            }
            i = i4;
        }
        return parseInt(i, i2, i3, z);
    }

    private int parseInt(int i, int i2, int i3, boolean z) {
        int i4 = Integer.MIN_VALUE / i3;
        int i5 = i;
        int i6 = 0;
        while (i5 < i2) {
            int i7 = i5 + 1;
            int iDigit = Character.digit((char) (this.value[i5 + this.offset] & 255), i3);
            if (iDigit == -1) {
                throw new NumberFormatException(subSequence(i, i2, false).toString());
            }
            if (i4 > i6) {
                throw new NumberFormatException(subSequence(i, i2, false).toString());
            }
            int i8 = (i6 * i3) - iDigit;
            if (i8 > i6) {
                throw new NumberFormatException(subSequence(i, i2, false).toString());
            }
            i6 = i8;
            i5 = i7;
        }
        if (z || (i6 = -i6) >= 0) {
            return i6;
        }
        throw new NumberFormatException(subSequence(i, i2, false).toString());
    }

    public final long parseLong() {
        return parseLong(0, length(), 10);
    }

    public final long parseLong(int i) {
        return parseLong(0, length(), i);
    }

    public final long parseLong(int i, int i2) {
        return parseLong(i, i2, 10);
    }

    public final long parseLong(int i, int i2, int i3) {
        if (i3 < 2 || i3 > 36) {
            throw new NumberFormatException();
        }
        if (i == i2) {
            throw new NumberFormatException();
        }
        boolean z = byteAt(i) == 45;
        if (z) {
            int i4 = i + 1;
            if (i4 == i2) {
                throw new NumberFormatException(subSequence(i, i2, false).toString());
            }
            i = i4;
        }
        return parseLong(i, i2, i3, z);
    }

    private long parseLong(int i, int i2, int i3, boolean z) {
        long j = i3;
        long j2 = Long.MIN_VALUE / j;
        int i4 = i;
        long j3 = 0;
        while (i4 < i2) {
            int i5 = i4 + 1;
            int iDigit = Character.digit((char) (this.value[i4 + this.offset] & 255), i3);
            if (iDigit == -1) {
                throw new NumberFormatException(subSequence(i, i2, false).toString());
            }
            if (j2 > j3) {
                throw new NumberFormatException(subSequence(i, i2, false).toString());
            }
            long j4 = (j3 * j) - iDigit;
            if (j4 > j3) {
                throw new NumberFormatException(subSequence(i, i2, false).toString());
            }
            j3 = j4;
            i4 = i5;
        }
        if (!z) {
            j3 = -j3;
            if (j3 < 0) {
                throw new NumberFormatException(subSequence(i, i2, false).toString());
            }
        }
        return j3;
    }

    public final float parseFloat() {
        return parseFloat(0, length());
    }

    public final float parseFloat(int i, int i2) {
        return Float.parseFloat(toString(i, i2));
    }

    public final double parseDouble() {
        return parseDouble(0, length());
    }

    public final double parseDouble(int i, int i2) {
        return Double.parseDouble(toString(i, i2));
    }

    public static AsciiString of(CharSequence charSequence) {
        return charSequence.getClass() == AsciiString.class ? (AsciiString) charSequence : new AsciiString(charSequence);
    }

    public static int hashCode(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        if (charSequence.getClass() == AsciiString.class) {
            return ((AsciiString) charSequence).hashCode();
        }
        return PlatformDependent.hashCodeAscii(charSequence);
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, DefaultCharEqualityComparator.INSTANCE);
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, AsciiCaseInsensitiveCharEqualityComparator.INSTANCE);
    }

    public static boolean contentEqualsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence.getClass() != AsciiString.class) {
            if (charSequence2.getClass() == AsciiString.class) {
                return ((AsciiString) charSequence2).contentEqualsIgnoreCase(charSequence);
            }
            if (charSequence.length() != charSequence2.length()) {
                return false;
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequence.length()) {
                if (!equalsIgnoreCase(charSequence.charAt(i), charSequence2.charAt(i2))) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        }
        return ((AsciiString) charSequence).contentEqualsIgnoreCase(charSequence2);
    }

    public static boolean containsContentEqualsIgnoreCase(Collection<CharSequence> collection, CharSequence charSequence) {
        Iterator<CharSequence> it = collection.iterator();
        while (it.hasNext()) {
            if (contentEqualsIgnoreCase(charSequence, it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsAllContentEqualsIgnoreCase(Collection<CharSequence> collection, Collection<CharSequence> collection2) {
        Iterator<CharSequence> it = collection2.iterator();
        while (it.hasNext()) {
            if (!containsContentEqualsIgnoreCase(collection, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean contentEquals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence.getClass() != AsciiString.class) {
            if (charSequence2.getClass() == AsciiString.class) {
                return ((AsciiString) charSequence2).contentEquals(charSequence);
            }
            if (charSequence.length() != charSequence2.length()) {
                return false;
            }
            for (int i = 0; i < charSequence.length(); i++) {
                if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return ((AsciiString) charSequence).contentEquals(charSequence2);
    }

    private static AsciiString[] toAsciiStringArray(String[] strArr) {
        AsciiString[] asciiStringArr = new AsciiString[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            asciiStringArr[i] = new AsciiString(strArr[i]);
        }
        return asciiStringArr;
    }

    static final class DefaultCharEqualityComparator implements CharEqualityComparator {
        static final DefaultCharEqualityComparator INSTANCE = new DefaultCharEqualityComparator();

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public final boolean equals(char c, char c2) {
            return c == c2;
        }

        private DefaultCharEqualityComparator() {
        }
    }

    static final class AsciiCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final AsciiCaseInsensitiveCharEqualityComparator INSTANCE = new AsciiCaseInsensitiveCharEqualityComparator();

        private AsciiCaseInsensitiveCharEqualityComparator() {
        }

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public final boolean equals(char c, char c2) {
            return AsciiString.equalsIgnoreCase(c, c2);
        }
    }

    static final class GeneralCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final GeneralCaseInsensitiveCharEqualityComparator INSTANCE = new GeneralCaseInsensitiveCharEqualityComparator();

        private GeneralCaseInsensitiveCharEqualityComparator() {
        }

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public final boolean equals(char c, char c2) {
            return Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
        }
    }

    private static boolean contains(CharSequence charSequence, CharSequence charSequence2, CharEqualityComparator charEqualityComparator) {
        if (charSequence != null && charSequence2 != null && charSequence.length() >= charSequence2.length()) {
            if (charSequence2.length() == 0) {
                return true;
            }
            int i = 0;
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                if (charEqualityComparator.equals(charSequence2.charAt(i), charSequence.charAt(i2))) {
                    i++;
                    if (i == charSequence2.length()) {
                        return true;
                    }
                } else {
                    if (charSequence.length() - i2 < charSequence2.length()) {
                        return false;
                    }
                    i = 0;
                }
            }
        }
        return false;
    }

    private static boolean regionMatchesCharSequences(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, CharEqualityComparator charEqualityComparator) {
        if (i < 0 || i3 > charSequence.length() - i || i2 < 0 || i3 > charSequence2.length() - i2) {
            return false;
        }
        int i4 = i3 + i;
        while (i < i4) {
            int i5 = i + 1;
            int i6 = i2 + 1;
            if (!charEqualityComparator.equals(charSequence.charAt(i), charSequence2.charAt(i2))) {
                return false;
            }
            i = i5;
            i2 = i6;
        }
        return true;
    }

    public static boolean regionMatches(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z, i, (String) charSequence2, i2, i3);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).regionMatches(z, i, charSequence2, i2, i3);
        }
        return regionMatchesCharSequences(charSequence, i, charSequence2, i2, i3, z ? GeneralCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    public static boolean regionMatchesAscii(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(false, i, (String) charSequence2, i2, i3);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).regionMatches(z, i, charSequence2, i2, i3);
        }
        return regionMatchesCharSequences(charSequence, i, charSequence2, i2, i3, z ? AsciiCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence != null && charSequence2 != null) {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence2.length();
            int length2 = (charSequence.length() - length) + 1;
            if (i > length2) {
                return -1;
            }
            if (length == 0) {
                return i;
            }
            while (i < length2) {
                if (regionMatches(charSequence, true, i, charSequence2, 0, length)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public static int indexOfIgnoreCaseAscii(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence != null && charSequence2 != null) {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence2.length();
            int length2 = (charSequence.length() - length) + 1;
            if (i > length2) {
                return -1;
            }
            if (length == 0) {
                return i;
            }
            while (i < length2) {
                if (regionMatchesAscii(charSequence, true, i, charSequence2, 0, length)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    private static boolean equalsIgnoreCase(byte b, byte b2) {
        return b == b2 || toLowerCase(b) == toLowerCase(b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalsIgnoreCase(char c, char c2) {
        return c == c2 || toLowerCase(c) == toLowerCase(c2);
    }

    private static byte toLowerCase(byte b) {
        return isUpperCase(b) ? (byte) (b + 32) : b;
    }

    private static char toLowerCase(char c) {
        return isUpperCase(c) ? (char) (c + ' ') : c;
    }

    private static byte toUpperCase(byte b) {
        return isLowerCase(b) ? (byte) (b - 32) : b;
    }
}
