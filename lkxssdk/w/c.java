package lkxssdk.w;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class c extends RandomAccessFile {
    public boolean a;
    public long b;
    public long c;
    public long d;
    public byte[] e;
    public long f;
    public boolean g;
    public long h;

    public c(String str, String str2, int i) {
        super(str, str2);
        a(i);
    }

    public final void a() throws IOException {
        if (this.a) {
            long j = this.h;
            long j2 = this.c;
            if (j != j2) {
                super.seek(j2);
            }
            super.write(this.e, 0, (int) (this.b - this.c));
            this.h = this.b;
            this.a = false;
        }
    }

    public final void a(int i) {
        this.a = false;
        this.d = 0L;
        this.b = 0L;
        this.c = 0L;
        this.e = i > 65536 ? new byte[i] : new byte[65536];
        this.f = 65536L;
        this.g = false;
        this.h = 0L;
    }

    @Override // java.io.RandomAccessFile, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a();
        this.e = null;
        super.close();
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() {
        return this.b;
    }

    @Override // java.io.RandomAccessFile
    public long length() {
        return Math.max(this.b, super.length());
    }

    @Override // java.io.RandomAccessFile
    public int read() throws IOException {
        long j = this.b;
        if (j >= this.d) {
            if (this.g) {
                return -1;
            }
            seek(j);
            if (this.b == this.d) {
                return -1;
            }
        }
        byte[] bArr = this.e;
        long j2 = this.b;
        byte b = bArr[(int) (j2 - this.c)];
        this.b = j2 + 1;
        return b & 255;
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.b;
        if (j >= this.d) {
            if (this.g) {
                return -1;
            }
            seek(j);
            if (this.b == this.d) {
                return -1;
            }
        }
        int iMin = Math.min(i2, (int) (this.d - this.b));
        System.arraycopy(this.e, (int) (this.b - this.c), bArr, i, iMin);
        this.b += iMin;
        return iMin;
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j) throws IOException {
        if (j >= this.d || j < this.c) {
            a();
            long j2 = (-65536) & j;
            this.c = j2;
            this.f = this.e.length + j2;
            if (this.h != j2) {
                super.seek(j2);
                this.h = this.c;
            }
            int length = this.e.length;
            int i = 0;
            while (length > 0) {
                int i2 = super.read(this.e, i, length);
                if (i2 < 0) {
                    break;
                }
                i += i2;
                length -= i2;
            }
            if (i < 0) {
                byte[] bArr = this.e;
                boolean z = i < bArr.length;
                this.g = z;
                if (z) {
                    Arrays.fill(bArr, i, bArr.length, (byte) -1);
                }
            }
            long j3 = i;
            this.h += j3;
            this.d = this.c + j3;
        } else if (j < this.b) {
            a();
        }
        this.b = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020 A[PHI: r2
  0x0020: PHI (r2v2 long) = (r2v1 long), (r2v0 long) binds: [B:10:0x001e, B:7:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.io.RandomAccessFile, java.io.DataOutput
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(int r10) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.b
            long r2 = r9.d
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r5 = 1
            if (r4 < 0) goto L23
            boolean r4 = r9.g
            if (r4 == 0) goto L15
            long r7 = r9.f
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 >= 0) goto L15
            goto L20
        L15:
            r9.seek(r0)
            long r0 = r9.b
            long r2 = r9.d
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L23
        L20:
            long r2 = r2 + r5
            r9.d = r2
        L23:
            byte[] r0 = r9.e
            long r1 = r9.b
            long r3 = r9.c
            long r3 = r1 - r3
            int r3 = (int) r3
            byte r10 = (byte) r10
            r0[r3] = r10
            long r1 = r1 + r5
            r9.b = r1
            r10 = 1
            r9.a = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.w.c.write(int):void");
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    @Override // java.io.RandomAccessFile, java.io.DataOutput
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(byte[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
        L0:
            if (r9 <= 0) goto L47
            long r0 = r6.b
            long r2 = r6.d
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L26
            boolean r4 = r6.g
            if (r4 == 0) goto L17
            long r4 = r6.f
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L17
            r6.d = r4
            goto L26
        L17:
            r6.seek(r0)
            long r0 = r6.b
            long r2 = r6.d
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L26
            long r0 = r6.f
            r6.d = r0
        L26:
            long r0 = r6.d
            long r2 = r6.b
            long r0 = r0 - r2
            int r0 = (int) r0
            int r0 = java.lang.Math.min(r9, r0)
            long r1 = r6.b
            long r3 = r6.c
            long r1 = r1 - r3
            int r1 = (int) r1
            byte[] r2 = r6.e
            java.lang.System.arraycopy(r7, r8, r2, r1, r0)
            long r1 = r6.b
            long r3 = (long) r0
            long r1 = r1 + r3
            r6.b = r1
            int r8 = r8 + r0
            int r9 = r9 - r0
            r0 = 1
            r6.a = r0
            goto L0
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.w.c.write(byte[], int, int):void");
    }
}
