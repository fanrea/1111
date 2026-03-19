package com.netease.htprotect.p024.p025O8oO888;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* renamed from: com.netease.htprotect.〇〇.O8〇oO8〇88.〇o0〇o0, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class o0o0 implements O8 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final int f634O8oO888 = 1048576;

    /* renamed from: 〇O8, reason: contains not printable characters */
    private final long f635O8;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private final FileChannel f636Ooo;

    /* renamed from: 〇o0〇o0, reason: contains not printable characters */
    private final long f637o0o0;

    private o0o0(FileChannel fileChannel) {
        this.f636Ooo = fileChannel;
        this.f635O8 = 0L;
        this.f637o0o0 = -1L;
    }

    public o0o0(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j2)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        this.f636Ooo = fileChannel;
        this.f635O8 = j;
        this.f637o0o0 = j2;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m1206O8oO888(long j, long j2, long j3) {
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

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private o0o0 m1207Ooo(long j, long j2) {
        long jMo1197O8oO888 = mo1197O8oO888();
        m1206O8oO888(j, j2, jMo1197O8oO888);
        return (j == 0 && j2 == jMo1197O8oO888) ? this : new o0o0(this.f636Ooo, this.f635O8 + j, j2);
    }

    @Override // com.netease.htprotect.p024.p025O8oO888.O8
    /* renamed from: O8〇oO8〇88 */
    public final long mo1197O8oO888() {
        long j = this.f637o0o0;
        if (j != -1) {
            return j;
        }
        try {
            return this.f636Ooo.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    @Override // com.netease.htprotect.p024.p025O8oO888.O8
    /* renamed from: O8〇oO8〇88 */
    public final /* synthetic */ O8 mo1198O8oO888(long j, long j2) {
        long jMo1197O8oO888 = mo1197O8oO888();
        m1206O8oO888(j, j2, jMo1197O8oO888);
        return (j == 0 && j2 == jMo1197O8oO888) ? this : new o0o0(this.f636Ooo, this.f635O8 + j, j2);
    }

    @Override // com.netease.htprotect.p024.p025O8oO888.O8
    /* renamed from: O8〇oO8〇88 */
    public final ByteBuffer mo1199O8oO888(long j, int i) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        mo1200O8oO888(j, i, byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    @Override // com.netease.htprotect.p024.p025O8oO888.O8
    /* renamed from: O8〇oO8〇88 */
    public final void mo1200O8oO888(long j, int i, ByteBuffer byteBuffer) throws IOException {
        int i2;
        m1206O8oO888(j, i, mo1197O8oO888());
        if (i == 0) {
            return;
        }
        if (i > byteBuffer.remaining()) {
            throw new BufferOverflowException();
        }
        long j2 = this.f635O8 + j;
        int iLimit = byteBuffer.limit();
        try {
            byteBuffer.limit(byteBuffer.position() + i);
            while (i > 0) {
                synchronized (this.f636Ooo) {
                    this.f636Ooo.position(j2);
                    i2 = this.f636Ooo.read(byteBuffer);
                }
                j2 += i2;
                i -= i2;
            }
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    @Override // com.netease.htprotect.p024.p025O8oO888.O8
    /* renamed from: O8〇oO8〇88 */
    public final void mo1201O8oO888(long j, long j2, Ooo ooo) throws IOException {
        m1206O8oO888(j, j2, mo1197O8oO888());
        if (j2 == 0) {
            return;
        }
        long j3 = this.f635O8 + j;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect((int) Math.min(j2, 1048576L));
        while (j2 > 0) {
            int iMin = (int) Math.min(j2, byteBufferAllocateDirect.capacity());
            byteBufferAllocateDirect.limit(iMin);
            synchronized (this.f636Ooo) {
                this.f636Ooo.position(j3);
                int i = iMin;
                while (i > 0) {
                    int i2 = this.f636Ooo.read(byteBufferAllocateDirect);
                    if (i2 < 0) {
                        throw new IOException("Unexpected EOF encountered");
                    }
                    i -= i2;
                }
            }
            byteBufferAllocateDirect.flip();
            ooo.mo1195O8oO888(byteBufferAllocateDirect);
            byteBufferAllocateDirect.clear();
            long j4 = iMin;
            j3 += j4;
            j2 -= j4;
        }
    }
}
