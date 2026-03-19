package com.kwad.sdk.glide.e;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static final AtomicReference<byte[]> cad = new AtomicReference<>();

    public static ByteBuffer V(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, t.k);
            try {
                channel = randomAccessFile.getChannel();
                MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                com.kwad.sdk.crash.utils.b.closeQuietly(channel);
                com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                return mappedByteBufferLoad;
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(channel);
                com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static void b(ByteBuffer byteBuffer, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            channel = randomAccessFile.getChannel();
            channel.write(byteBuffer);
            channel.force(false);
            com.kwad.sdk.crash.utils.b.closeQuietly(channel);
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(channel);
            com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
            throw th;
        }
    }

    public static byte[] g(ByteBuffer byteBuffer) {
        b bVarI = i(byteBuffer);
        if (bVarI != null && bVarI.offset == 0 && bVarI.limit == bVarI.data.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        byteBufferAsReadOnlyBuffer.position(0);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static InputStream h(ByteBuffer byteBuffer) {
        return new C0601a(byteBuffer);
    }

    private static b i(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    static final class b {
        final byte[] data;
        final int limit;
        final int offset;

        b(byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.offset = i;
            this.limit = i2;
        }
    }

    /* renamed from: com.kwad.sdk.glide.e.a$a, reason: collision with other inner class name */
    static class C0601a extends InputStream {
        private final ByteBuffer bVV;
        private int cae = -1;

        @Override // java.io.InputStream
        public final boolean markSupported() {
            return true;
        }

        C0601a(ByteBuffer byteBuffer) {
            this.bVV = byteBuffer;
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.bVV.remaining();
        }

        @Override // java.io.InputStream
        public final int read() {
            if (this.bVV.hasRemaining()) {
                return this.bVV.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public final synchronized void mark(int i) {
            this.cae = this.bVV.position();
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i, int i2) {
            if (!this.bVV.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i2, available());
            this.bVV.get(bArr, i, iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public final synchronized void reset() {
            int i = this.cae;
            if (i == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.bVV.position(i);
        }

        @Override // java.io.InputStream
        public final long skip(long j) {
            if (!this.bVV.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j, available());
            this.bVV.position((int) (r0.position() + jMin));
            return jMin;
        }
    }
}
