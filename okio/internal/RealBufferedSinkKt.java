package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.base.n;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import okio.buffer;

/* compiled from: RealBufferedSink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\t\u001a\u00020\n*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u0016\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0015H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010#\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\nH\u0080\b\u001a%\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010(\u001a\u00020\u0004*\u00020\u00022\u0006\u0010)\u001a\u00020\u000fH\u0080\b¨\u0006*"}, d2 = {"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", n.l, "", TypedValues.CycleType.S_WAVE_OFFSET, "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", t.l, "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", "s", "commonWriteShortLe", "commonWriteUtf8", TypedValues.Custom.S_STRING, "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class RealBufferedSinkKt {
    public static final void commonWrite(buffer bufferVar, Buffer buffer, long j) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(buffer, n.l);
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.write(buffer, j);
        bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(buffer bufferVar, ByteString byteString) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.write(byteString);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(buffer bufferVar, ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.write(byteString, i, i2);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(buffer bufferVar, String str) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteUtf8");
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeUtf8(str);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8(buffer bufferVar, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteUtf8");
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeUtf8(str, i, i2);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteUtf8CodePoint(buffer bufferVar, int i) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteUtf8CodePoint");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeUtf8CodePoint(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(buffer bufferVar, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(bArr, n.l);
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.write(bArr);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWrite(buffer bufferVar, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(bArr, n.l);
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.write(bArr, i, i2);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteByte(buffer bufferVar, int i) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteByte");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeByte(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShort(buffer bufferVar, int i) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteShort");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeShort(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteShortLe(buffer bufferVar, int i) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteShortLe");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeShortLe(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteInt(buffer bufferVar, int i) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteInt");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeInt(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteIntLe(buffer bufferVar, int i) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteIntLe");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeIntLe(i);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLong(buffer bufferVar, long j) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteLong");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeLong(j);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteLongLe(buffer bufferVar, long j) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteLongLe");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeLongLe(j);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteDecimalLong(buffer bufferVar, long j) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteDecimalLong");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeDecimalLong(j);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonWriteHexadecimalUnsignedLong(buffer bufferVar, long j) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteHexadecimalUnsignedLong");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        bufferVar.bufferField.writeHexadecimalUnsignedLong(j);
        return bufferVar.emitCompleteSegments();
    }

    public static final BufferedSink commonEmitCompleteSegments(buffer bufferVar) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonEmitCompleteSegments");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long jCompleteSegmentByteCount = bufferVar.bufferField.completeSegmentByteCount();
        if (jCompleteSegmentByteCount > 0) {
            bufferVar.sink.write(bufferVar.bufferField, jCompleteSegmentByteCount);
        }
        return bufferVar;
    }

    public static final BufferedSink commonEmit(buffer bufferVar) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonEmit");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = bufferVar.bufferField.size();
        if (size > 0) {
            bufferVar.sink.write(bufferVar.bufferField, size);
        }
        return bufferVar;
    }

    public static final void commonFlush(buffer bufferVar) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonFlush");
        if (!(!bufferVar.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (bufferVar.bufferField.size() > 0) {
            bufferVar.sink.write(bufferVar.bufferField, bufferVar.bufferField.size());
        }
        bufferVar.sink.flush();
    }

    public static final void commonClose(buffer bufferVar) throws Throwable {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonClose");
        if (bufferVar.closed) {
            return;
        }
        Throwable th = null;
        try {
            if (bufferVar.bufferField.size() > 0) {
                bufferVar.sink.write(bufferVar.bufferField, bufferVar.bufferField.size());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferVar.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        bufferVar.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public static final Timeout commonTimeout(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonTimeout");
        return bufferVar.sink.getTimeout();
    }

    public static final String commonToString(buffer bufferVar) {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonToString");
        return "buffer(" + bufferVar.sink + ')';
    }

    public static final long commonWriteAll(buffer bufferVar, Source source) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWriteAll");
        Intrinsics.checkNotNullParameter(source, n.l);
        long j = 0;
        while (true) {
            long j2 = source.read(bufferVar.bufferField, 8192);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            bufferVar.emitCompleteSegments();
        }
    }

    public static final BufferedSink commonWrite(buffer bufferVar, Source source, long j) throws IOException {
        Intrinsics.checkNotNullParameter(bufferVar, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, n.l);
        while (j > 0) {
            long j2 = source.read(bufferVar.bufferField, j);
            if (j2 == -1) {
                throw new EOFException();
            }
            j -= j2;
            bufferVar.emitCompleteSegments();
        }
        return bufferVar;
    }
}
