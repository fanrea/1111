package com.bytedance.sdk.component.panglearmor.d.hc;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements hc {
    private final long b;
    private final FileChannel d;
    private final long hc;

    public c(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j2)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        this.d = fileChannel;
        this.hc = j;
        this.b = j2;
    }

    @Override // com.bytedance.sdk.component.panglearmor.d.hc.hc
    public long d() {
        long j = this.b;
        if (j != -1) {
            return j;
        }
        try {
            return this.d.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.panglearmor.d.hc.hc
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public c d(long j, long j2) {
        long jD = d();
        d(j, j2, jD);
        return (j == 0 && j2 == jD) ? this : new c(this.d, this.hc + j, j2);
    }

    public void d(long j, int i, ByteBuffer byteBuffer) throws IOException {
        int i2;
        d(j, i, d());
        if (i == 0) {
            return;
        }
        if (i > byteBuffer.remaining()) {
            throw new BufferOverflowException();
        }
        long j2 = this.hc + j;
        int iLimit = byteBuffer.limit();
        try {
            byteBuffer.limit(byteBuffer.position() + i);
            while (i > 0) {
                synchronized (this.d) {
                    this.d.position(j2);
                    i2 = this.d.read(byteBuffer);
                }
                j2 += i2;
                i -= i2;
            }
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    @Override // com.bytedance.sdk.component.panglearmor.d.hc.hc
    public ByteBuffer d(long j, int i) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        d(j, i, byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static void d(long j, long j2, long j3) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        if (j > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") > source size (" + j3 + ")");
        }
        long j4 = j + j2;
        if (j4 < j) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") overflow");
        }
        if (j4 > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + j3 + ")");
        }
    }
}
