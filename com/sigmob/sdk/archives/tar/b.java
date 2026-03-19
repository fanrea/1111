package com.sigmob.sdk.archives.tar;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends com.sigmob.sdk.archives.c {
    private static final int b = 256;
    private static final int c = 8192;
    protected final d a;
    private boolean d;
    private long e;
    private long f;
    private byte[] g;
    private a h;

    public b(InputStream is) {
        this(is, d.b, 512);
    }

    public b(InputStream is, int blockSize) {
        this(is, blockSize, 512);
    }

    public b(InputStream is, int blockSize, int recordSize) {
        this.a = new d(is, blockSize, recordSize);
        this.g = null;
        this.d = false;
    }

    public static boolean a(byte[] signature, int length) {
        if (length < 265) {
            return false;
        }
        if (com.sigmob.sdk.archives.utils.a.a("ustar\u0000", signature, 257, 6) && com.sigmob.sdk.archives.utils.a.a("00", signature, 263, 2)) {
            return true;
        }
        if (com.sigmob.sdk.archives.utils.a.a(e.W, signature, 257, 6) && (com.sigmob.sdk.archives.utils.a.a(e.X, signature, 263, 2) || com.sigmob.sdk.archives.utils.a.a(e.Y, signature, 263, 2))) {
            return true;
        }
        return com.sigmob.sdk.archives.utils.a.a("ustar\u0000", signature, 257, 6) && com.sigmob.sdk.archives.utils.a.a(e.aa, signature, 263, 2);
    }

    private byte[] h() throws IOException {
        if (this.d) {
            return null;
        }
        byte[] bArrD = this.a.d();
        if (bArrD == null || this.a.a(bArrD)) {
            this.d = true;
        }
        if (this.d) {
            return null;
        }
        return bArrD;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if (r7 == (-1)) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        if (r7 != 61) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        r5 = r5.toString();
        r4 = r4 - r3;
        r3 = new char[r4];
        r8 = r0.read(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (r8 != r4) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        r1.put(r5, new java.lang.String(r3, 0, r4 - 1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0067, code lost:
    
        throw new java.io.IOException("Failed to read Paxheader. Expected " + r4 + " chars, read " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0068, code lost:
    
        r5.append((char) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006d, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        r5 = new java.lang.StringBuffer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        r7 = r0.read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.archives.tar.b.i():void");
    }

    private void j() throws IOException {
        byte[] bArrH;
        if (this.h.m()) {
            do {
                bArrH = h();
                if (this.d) {
                    this.h = null;
                    return;
                }
            } while (new c(bArrH).a());
        }
    }

    @Override // com.sigmob.sdk.archives.c
    public com.sigmob.sdk.archives.a a() throws IOException {
        return e();
    }

    protected final void a(a e) {
        this.h = e;
    }

    protected final void a(boolean b2) {
        this.d = b2;
    }

    @Override // com.sigmob.sdk.archives.c
    public boolean a(com.sigmob.sdk.archives.a ae) {
        if (ae instanceof a) {
            return !((a) ae).o();
        }
        return false;
    }

    @Override // java.io.InputStream
    public int available() {
        long j = this.e;
        long j2 = this.f;
        if (j - j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (j - j2);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.h();
    }

    public int d() {
        return this.a.b();
    }

    public a e() throws IOException {
        if (this.d) {
            return null;
        }
        if (this.h != null) {
            long j = this.e;
            long jSkip = this.f;
            do {
                j -= jSkip;
                if (j > 0) {
                    jSkip = skip(j);
                } else {
                    this.g = null;
                }
            } while (jSkip > 0);
            throw new RuntimeException("failed to skip current tar entry");
        }
        byte[] bArrH = h();
        if (this.d) {
            this.h = null;
            return null;
        }
        a aVar = new a(bArrH);
        this.h = aVar;
        this.f = 0L;
        this.e = aVar.b();
        if (this.h.p()) {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = new byte[256];
            while (true) {
                int i = read(bArr);
                if (i < 0) {
                    break;
                }
                stringBuffer.append(new String(bArr, 0, i));
            }
            a();
            if (this.h == null) {
                return null;
            }
            if (stringBuffer.length() > 0 && stringBuffer.charAt(stringBuffer.length() - 1) == 0) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            this.h.a(stringBuffer.toString());
        }
        if (this.h.q()) {
            i();
        }
        if (this.h.o()) {
            j();
        }
        return this.h;
    }

    protected final a f() {
        return this.h;
    }

    protected final boolean g() {
        return this.d;
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int offset, int numToRead) throws IOException {
        int i;
        long j = this.f;
        long j2 = this.e;
        if (j >= j2) {
            return -1;
        }
        if (numToRead + j > j2) {
            numToRead = (int) (j2 - j);
        }
        byte[] bArr = this.g;
        if (bArr != null) {
            int length = numToRead > bArr.length ? bArr.length : numToRead;
            System.arraycopy(bArr, 0, buf, offset, length);
            byte[] bArr2 = this.g;
            if (length >= bArr2.length) {
                this.g = null;
            } else {
                int length2 = bArr2.length - length;
                byte[] bArr3 = new byte[length2];
                System.arraycopy(bArr2, length, bArr3, 0, length2);
                this.g = bArr3;
            }
            i = length + 0;
            numToRead -= length;
            offset += length;
        } else {
            i = 0;
        }
        while (numToRead > 0) {
            byte[] bArrD = this.a.d();
            if (bArrD == null) {
                throw new IOException("unexpected EOF with " + numToRead + " bytes unread. Occured at byte: " + c());
            }
            a(bArrD.length);
            int length3 = bArrD.length;
            if (length3 > numToRead) {
                System.arraycopy(bArrD, 0, buf, offset, numToRead);
                int i2 = length3 - numToRead;
                byte[] bArr4 = new byte[i2];
                this.g = bArr4;
                System.arraycopy(bArrD, numToRead, bArr4, 0, i2);
                length3 = numToRead;
            } else {
                System.arraycopy(bArrD, 0, buf, offset, length3);
            }
            i += length3;
            numToRead -= length3;
            offset += length3;
        }
        this.f += i;
        return i;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    @Override // java.io.InputStream
    public long skip(long numToSkip) throws IOException {
        byte[] bArr = new byte[8192];
        long j = numToSkip;
        while (j > 0) {
            long j2 = 8192;
            if (j <= j2) {
                j2 = j;
            }
            int i = read(bArr, 0, (int) j2);
            if (i == -1) {
                break;
            }
            j -= i;
        }
        return numToSkip - j;
    }
}
