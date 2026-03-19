package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import com.kuaishou.weapon.p0.t;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.Sink;
import okio.Timeout;
import okio.Util;
import okio.buffer;

/* compiled from: RealBufferedSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\u0080\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\u0080\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\u0080\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\u0080\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\u0080\b¨\u00068"}, d2 = {"commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", t.l, "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", TypedValues.CycleType.S_WAVE_OFFSET, "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class RealBufferedSourceKt {
    public static final long commonRead(buffer bufferVar, Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonRead");
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
            return -1L;
        }
        return bufferVar.bufferField.read(buffer, Math.min(j, bufferVar.bufferField.size()));
    }

    public static final boolean commonExhausted(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonExhausted");
        if (!bufferVar.closed) {
            return bufferVar.bufferField.exhausted() && bufferVar.source.read(bufferVar.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonRequire(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonRequire");
        if (!bufferVar.request(j)) {
            throw new EOFException();
        }
    }

    public static final boolean commonRequest(buffer bufferVar, long j) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonRequest");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (bufferVar.bufferField.size() < j) {
            if (bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final byte commonReadByte(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadByte");
        bufferVar.require(1L);
        return bufferVar.bufferField.readByte();
    }

    public static final ByteString commonReadByteString(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadByteString");
        bufferVar.require(j);
        return bufferVar.bufferField.readByteString(j);
    }

    public static final int commonSelect(buffer bufferVar, Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonSelect");
        Intrinsics.checkNotNullParameter(options, "options");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int iSelectPrefix = BufferKt.selectPrefix(bufferVar.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    return -1;
                }
                bufferVar.bufferField.skip(options.getByteStrings()[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (bufferVar.source.read(bufferVar.bufferField, 8192) != -1);
        return -1;
    }

    public static final byte[] commonReadByteArray(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadByteArray");
        bufferVar.require(j);
        return bufferVar.bufferField.readByteArray(j);
    }

    public static final void commonReadFully(buffer bufferVar, byte[] bArr) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        try {
            bufferVar.require(bArr.length);
            bufferVar.bufferField.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (bufferVar.bufferField.size() > 0) {
                int i2 = bufferVar.bufferField.read(bArr, i, (int) bufferVar.bufferField.size());
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
            throw e;
        }
    }

    public static final int commonRead(buffer bufferVar, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonRead");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        long j = i2;
        Util.checkOffsetAndCount(bArr.length, i, j);
        if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
            return -1;
        }
        return bufferVar.bufferField.read(bArr, i, (int) Math.min(j, bufferVar.bufferField.size()));
    }

    public static final void commonReadFully(buffer bufferVar, Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(buffer, "sink");
        try {
            bufferVar.require(j);
            bufferVar.bufferField.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(bufferVar.bufferField);
            throw e;
        }
    }

    public static final long commonReadAll(buffer bufferVar, Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadAll");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = 0;
        while (bufferVar.source.read(bufferVar.bufferField, 8192) != -1) {
            long jCompleteSegmentByteCount = bufferVar.bufferField.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j += jCompleteSegmentByteCount;
                sink.write(bufferVar.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (bufferVar.bufferField.size() <= 0) {
            return j;
        }
        long size = j + bufferVar.bufferField.size();
        sink.write(bufferVar.bufferField, bufferVar.bufferField.size());
        return size;
    }

    public static final String commonReadUtf8(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadUtf8");
        bufferVar.require(j);
        return bufferVar.bufferField.readUtf8(j);
    }

    public static final String commonReadUtf8Line(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadUtf8Line");
        long jIndexOf = bufferVar.indexOf((byte) 10);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(bufferVar.bufferField, jIndexOf);
        }
        if (bufferVar.bufferField.size() != 0) {
            return bufferVar.readUtf8(bufferVar.bufferField.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadUtf8LineStrict");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j).toString());
        }
        long j2 = j == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : j + 1;
        byte b = (byte) 10;
        long jIndexOf = bufferVar.indexOf(b, 0L, j2);
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(bufferVar.bufferField, jIndexOf);
        }
        if (j2 < LocationRequestCompat.PASSIVE_INTERVAL && bufferVar.request(j2) && bufferVar.bufferField.getByte(j2 - 1) == ((byte) 13) && bufferVar.request(1 + j2) && bufferVar.bufferField.getByte(j2) == b) {
            return BufferKt.readUtf8Line(bufferVar.bufferField, j2);
        }
        Buffer buffer = new Buffer();
        bufferVar.bufferField.copyTo(buffer, 0L, Math.min(32, bufferVar.bufferField.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(bufferVar.bufferField.size(), j) + " content=" + buffer.readByteString().hex() + "…");
    }

    public static final int commonReadUtf8CodePoint(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadUtf8CodePoint");
        bufferVar.require(1L);
        byte b = bufferVar.bufferField.getByte(0L);
        if ((b & 224) == 192) {
            bufferVar.require(2L);
        } else if ((b & 240) == 224) {
            bufferVar.require(3L);
        } else if ((b & 248) == 240) {
            bufferVar.require(4L);
        }
        return bufferVar.bufferField.readUtf8CodePoint();
    }

    public static final short commonReadShort(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadShort");
        bufferVar.require(2L);
        return bufferVar.bufferField.readShort();
    }

    public static final short commonReadShortLe(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadShortLe");
        bufferVar.require(2L);
        return bufferVar.bufferField.readShortLe();
    }

    public static final int commonReadInt(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadInt");
        bufferVar.require(4L);
        return bufferVar.bufferField.readInt();
    }

    public static final int commonReadIntLe(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadIntLe");
        bufferVar.require(4L);
        return bufferVar.bufferField.readIntLe();
    }

    public static final long commonReadLong(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadLong");
        bufferVar.require(8L);
        return bufferVar.bufferField.readLong();
    }

    public static final long commonReadLongLe(buffer bufferVar) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadLongLe");
        bufferVar.require(8L);
        return bufferVar.bufferField.readLongLe();
    }

    public static final long commonReadDecimalLong(buffer bufferVar) throws EOFException {
        byte b;
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadDecimalLong");
        bufferVar.require(1L);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            if (!bufferVar.request(j2)) {
                break;
            }
            b = bufferVar.bufferField.getByte(j);
            if ((b < ((byte) 48) || b > ((byte) 57)) && !(j == 0 && b == ((byte) 45))) {
                break;
            }
            j = j2;
        }
        if (j == 0) {
            StringBuilder sbAppend = new StringBuilder().append("Expected leading [0-9] or '-' character but was 0x");
            String string = Integer.toString(b, CharsKt.checkRadix(CharsKt.checkRadix(16)));
            Intrinsics.checkNotNullExpressionValue(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException(sbAppend.append(string).toString());
        }
        return bufferVar.bufferField.readDecimalLong();
    }

    public static final long commonReadHexadecimalUnsignedLong(buffer bufferVar) throws EOFException {
        byte b;
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadHexadecimalUnsignedLong");
        bufferVar.require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!bufferVar.request(i2)) {
                break;
            }
            b = bufferVar.bufferField.getByte(i);
            if ((b < ((byte) 48) || b > ((byte) 57)) && ((b < ((byte) 97) || b > ((byte) 102)) && (b < ((byte) 65) || b > ((byte) 70)))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            StringBuilder sbAppend = new StringBuilder().append("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(b, CharsKt.checkRadix(CharsKt.checkRadix(16)));
            Intrinsics.checkNotNullExpressionValue(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException(sbAppend.append(string).toString());
        }
        return bufferVar.bufferField.readHexadecimalUnsignedLong();
    }

    public static final void commonSkip(buffer bufferVar, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonSkip");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            if (bufferVar.bufferField.size() == 0 && bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, bufferVar.bufferField.size());
            bufferVar.bufferField.skip(jMin);
            j -= jMin;
        }
    }

    public static final long commonIndexOf(buffer bufferVar, byte b, long j, long j2) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonIndexOf");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long jIndexOf = bufferVar.bufferField.indexOf(b, j, j2);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = bufferVar.bufferField.size();
            if (size >= j2 || bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
                break;
            }
            j = Math.max(j, size);
        }
        return -1L;
    }

    public static final long commonIndexOf(buffer bufferVar, ByteString byteString, long j) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonIndexOf");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOf = bufferVar.bufferField.indexOf(byteString, j);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = bufferVar.bufferField.size();
            if (bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, (size - byteString.size()) + 1);
        }
    }

    public static final long commonIndexOfElement(buffer bufferVar, ByteString byteString, long j) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonIndexOfElement");
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long jIndexOfElement = bufferVar.bufferField.indexOfElement(byteString, j);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = bufferVar.bufferField.size();
            if (bufferVar.source.read(bufferVar.bufferField, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
    }

    public static final boolean commonRangeEquals(buffer bufferVar, long j, ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!bufferVar.request(1 + j2) || bufferVar.bufferField.getByte(j2) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public static final BufferedSource commonPeek(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonPeek");
        return Okio.buffer(new PeekSource(bufferVar));
    }

    public static final void commonClose(buffer bufferVar) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonClose");
        if (bufferVar.closed) {
            return;
        }
        bufferVar.closed = true;
        bufferVar.source.close();
        bufferVar.bufferField.clear();
    }

    public static final Timeout commonTimeout(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonTimeout");
        return bufferVar.source.getTimeout();
    }

    public static final String commonToString(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonToString");
        return "buffer(" + bufferVar.source + ')';
    }

    public static final ByteString commonReadByteString(buffer bufferVar) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadByteString");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readByteString();
    }

    public static final byte[] commonReadByteArray(buffer bufferVar) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadByteArray");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readByteArray();
    }

    public static final String commonReadUtf8(buffer bufferVar) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonReadUtf8");
        bufferVar.bufferField.writeAll(bufferVar.source);
        return bufferVar.bufferField.readUtf8();
    }
}
