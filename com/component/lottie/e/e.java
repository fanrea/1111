package com.component.lottie.e;

import androidx.core.location.LocationRequestCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.common.utility.StringEncryptUtils;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.connection.RealConnection;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class e implements h, i, Cloneable, ByteChannel {
    static final int a = 65533;
    private static final byte[] d = {com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.I, com.sigmob.sdk.archives.tar.e.J, com.sigmob.sdk.archives.tar.e.f789K, com.sigmob.sdk.archives.tar.e.L, com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.N, com.sigmob.sdk.archives.tar.e.O, 56, 57, 97, 98, 99, 100, 101, 102};
    w b;
    long c;

    public final long b() {
        return this.c;
    }

    @Override // com.component.lottie.e.h, com.component.lottie.e.i
    public e c() {
        return this;
    }

    @Override // com.component.lottie.e.i
    public e d() {
        return this;
    }

    @Override // com.component.lottie.e.h
    public OutputStream e() {
        return new f(this);
    }

    @Override // com.component.lottie.e.h
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public e K() {
        return this;
    }

    @Override // com.component.lottie.e.h
    public h g() {
        return this;
    }

    @Override // com.component.lottie.e.i
    public boolean h() {
        return this.c == 0;
    }

    @Override // com.component.lottie.e.i
    public void a(long j) throws EOFException {
        if (this.c < j) {
            throw new EOFException();
        }
    }

    @Override // com.component.lottie.e.i
    public boolean b(long j) {
        return this.c >= j;
    }

    @Override // com.component.lottie.e.i
    public i i() {
        return l.a(new r(this));
    }

    @Override // com.component.lottie.e.i
    public InputStream j() {
        return new g(this);
    }

    public final e a(OutputStream outputStream) {
        return a(outputStream, 0L, this.c);
    }

    public final e a(OutputStream outputStream, long j, long j2) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        k.a(this.c, j, j2);
        if (j2 == 0) {
            return this;
        }
        w wVar = this.b;
        while (j >= wVar.e - wVar.d) {
            j -= wVar.e - wVar.d;
            wVar = wVar.h;
        }
        while (j2 > 0) {
            int iMin = (int) Math.min(wVar.e - r8, j2);
            outputStream.write(wVar.c, (int) (wVar.d + j), iMin);
            j2 -= iMin;
            wVar = wVar.h;
            j = 0;
        }
        return this;
    }

    public final e a(e eVar, long j, long j2) {
        if (eVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        k.a(this.c, j, j2);
        if (j2 == 0) {
            return this;
        }
        eVar.c += j2;
        w wVar = this.b;
        while (j >= wVar.e - wVar.d) {
            j -= wVar.e - wVar.d;
            wVar = wVar.h;
        }
        while (j2 > 0) {
            w wVarA = wVar.a();
            wVarA.d = (int) (wVarA.d + j);
            wVarA.e = Math.min(wVarA.d + ((int) j2), wVarA.e);
            if (eVar.b == null) {
                wVarA.i = wVarA;
                wVarA.h = wVarA;
                eVar.b = wVarA;
            } else {
                eVar.b.i.a(wVarA);
            }
            j2 -= wVarA.e - wVarA.d;
            wVar = wVar.h;
            j = 0;
        }
        return this;
    }

    public final e b(OutputStream outputStream) {
        return a(outputStream, this.c);
    }

    public final e a(OutputStream outputStream, long j) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        k.a(this.c, 0L, j);
        w wVar = this.b;
        while (j > 0) {
            int iMin = (int) Math.min(j, wVar.e - wVar.d);
            outputStream.write(wVar.c, wVar.d, iMin);
            wVar.d += iMin;
            long j2 = iMin;
            this.c -= j2;
            j -= j2;
            if (wVar.d == wVar.e) {
                w wVarC = wVar.c();
                this.b = wVarC;
                x.a(wVar);
                wVar = wVarC;
            }
        }
        return this;
    }

    public final e a(InputStream inputStream) throws IOException {
        a(inputStream, LocationRequestCompat.PASSIVE_INTERVAL, true);
        return this;
    }

    public final e a(InputStream inputStream, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        a(inputStream, j, false);
        return this;
    }

    private void a(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (true) {
            if (j > 0 || z) {
                w wVarG = g(1);
                int i = inputStream.read(wVarG.c, wVarG.e, (int) Math.min(j, 8192 - wVarG.e));
                if (i == -1) {
                    if (z) {
                        return;
                    } else {
                        throw new EOFException();
                    }
                } else {
                    wVarG.e += i;
                    long j2 = i;
                    this.c += j2;
                    j -= j2;
                }
            } else {
                return;
            }
        }
    }

    public final long k() {
        long j = this.c;
        if (j == 0) {
            return 0L;
        }
        w wVar = this.b.i;
        if (wVar.e < 8192 && wVar.g) {
            return j - (wVar.e - wVar.d);
        }
        return j;
    }

    @Override // com.component.lottie.e.i
    public byte l() {
        if (this.c == 0) {
            throw new IllegalStateException("size == 0");
        }
        w wVar = this.b;
        int i = wVar.d;
        int i2 = wVar.e;
        int i3 = i + 1;
        byte b = wVar.c[i];
        this.c--;
        if (i3 == i2) {
            this.b = wVar.c();
            x.a(wVar);
        } else {
            wVar.d = i3;
        }
        return b;
    }

    public final byte c(long j) {
        k.a(this.c, j, 1L);
        if (this.c - j > j) {
            w wVar = this.b;
            while (true) {
                long j2 = wVar.e - wVar.d;
                if (j < j2) {
                    return wVar.c[wVar.d + ((int) j)];
                }
                j -= j2;
                wVar = wVar.h;
            }
        } else {
            long j3 = j - this.c;
            w wVar2 = this.b;
            do {
                wVar2 = wVar2.i;
                j3 += wVar2.e - wVar2.d;
            } while (j3 < 0);
            return wVar2.c[wVar2.d + ((int) j3)];
        }
    }

    @Override // com.component.lottie.e.i
    public short m() {
        if (this.c < 2) {
            throw new IllegalStateException("size < 2: " + this.c);
        }
        w wVar = this.b;
        int i = wVar.d;
        int i2 = wVar.e;
        if (i2 - i < 2) {
            return (short) (((l() & 255) << 8) | (l() & 255));
        }
        byte[] bArr = wVar.c;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.c -= 2;
        if (i4 == i2) {
            this.b = wVar.c();
            x.a(wVar);
        } else {
            wVar.d = i4;
        }
        return (short) i5;
    }

    @Override // com.component.lottie.e.i
    public int n() {
        if (this.c < 4) {
            throw new IllegalStateException("size < 4: " + this.c);
        }
        w wVar = this.b;
        int i = wVar.d;
        int i2 = wVar.e;
        if (i2 - i < 4) {
            return ((l() & 255) << 24) | ((l() & 255) << 16) | ((l() & 255) << 8) | (l() & 255);
        }
        byte[] bArr = wVar.c;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.c -= 4;
        if (i8 == i2) {
            this.b = wVar.c();
            x.a(wVar);
        } else {
            wVar.d = i8;
        }
        return i9;
    }

    @Override // com.component.lottie.e.i
    public long o() {
        if (this.c < 8) {
            throw new IllegalStateException("size < 8: " + this.c);
        }
        w wVar = this.b;
        int i = wVar.d;
        int i2 = wVar.e;
        if (i2 - i < 8) {
            return ((n() & C00oOOo.f362O8oO888) << 32) | (C00oOOo.f362O8oO888 & n());
        }
        byte[] bArr = wVar.c;
        long j = (bArr[i] & 255) << 56;
        long j2 = j | ((bArr[r8] & 255) << 48);
        long j3 = j2 | ((bArr[r1] & 255) << 40);
        long j4 = j3 | ((bArr[r8] & 255) << 32) | ((bArr[r1] & 255) << 24);
        long j5 = j4 | ((bArr[r6] & 255) << 16);
        long j6 = ((bArr[r1] & 255) << 8) | j5;
        int i3 = i + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
        long j7 = (bArr[r6] & 255) | j6;
        this.c -= 8;
        if (i3 == i2) {
            this.b = wVar.c();
            x.a(wVar);
        } else {
            wVar.d = i3;
        }
        return j7;
    }

    @Override // com.component.lottie.e.i
    public short p() {
        return k.a(m());
    }

    @Override // com.component.lottie.e.i
    public int q() {
        return k.a(n());
    }

    @Override // com.component.lottie.e.i
    public long r() {
        return k.a(o());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bc A[EDGE_INSN: B:50:0x00bc->B:39:0x00bc BREAK  A[LOOP:0: B:5:0x0016->B:52:?], SYNTHETIC] */
    @Override // com.component.lottie.e.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long s() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.c
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto Lc7
        Lf:
            r1 = 0
            r5 = -7
            r6 = r5
            r2 = 0
            r4 = r3
            r3 = 0
        L16:
            com.component.lottie.e.w r8 = r0.b
            byte[] r9 = r8.c
            int r10 = r8.d
            int r11 = r8.e
        L1e:
            if (r10 >= r11) goto La8
            r12 = r9[r10]
            r13 = 48
            if (r12 < r13) goto L75
            r13 = 57
            if (r12 > r13) goto L75
            int r13 = 48 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 < 0) goto L46
            int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r16 != 0) goto L3f
            long r14 = (long) r13
            int r16 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r16 >= 0) goto L3f
            goto L46
        L3f:
            r14 = 10
            long r4 = r4 * r14
            long r12 = (long) r13
            long r4 = r4 + r12
            goto L81
        L46:
            com.component.lottie.e.e r1 = new com.component.lottie.e.e
            r1.<init>()
            com.component.lottie.e.e r1 = r1.o(r4)
            com.component.lottie.e.e r1 = r1.m(r12)
            if (r2 != 0) goto L58
            r1.l()
        L58:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Number too large: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r1 = r1.v()
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L75:
            r13 = 45
            r14 = 1
            if (r12 != r13) goto L86
            if (r1 != 0) goto L86
        L7d:
            r12 = 1
            long r6 = r6 - r12
            r2 = 1
        L81:
            int r10 = r10 + 1
            int r1 = r1 + 1
            goto L1e
        L86:
            if (r1 == 0) goto L8b
        L89:
            r3 = 1
            goto La8
        L8b:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r12)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        La8:
            if (r10 != r11) goto Lb4
            com.component.lottie.e.w r9 = r8.c()
            r0.b = r9
            com.component.lottie.e.x.a(r8)
            goto Lb6
        Lb4:
            r8.d = r10
        Lb6:
            if (r3 != 0) goto Lbc
            com.component.lottie.e.w r8 = r0.b
            if (r8 != 0) goto L16
        Lbc:
            long r6 = r0.c
            long r8 = (long) r1
            long r6 = r6 - r8
            r0.c = r6
            if (r2 == 0) goto Lc5
            goto Lc6
        Lc5:
            long r4 = -r4
        Lc6:
            return r4
        Lc7:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            goto Ld0
        Lcf:
            throw r1
        Ld0:
            goto Lcf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.e.e.s():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ad A[EDGE_INSN: B:44:0x00ad->B:37:0x00ad BREAK  A[LOOP:0: B:5:0x000d->B:46:?], SYNTHETIC] */
    @Override // com.component.lottie.e.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long t() {
        /*
            r15 = this;
            long r0 = r15.c
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lb4
        La:
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            com.component.lottie.e.w r6 = r15.b
            byte[] r7 = r6.c
            int r8 = r6.d
            int r9 = r6.e
        L15:
            if (r8 >= r9) goto L99
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L24
            r11 = 57
            if (r10 > r11) goto L24
            int r11 = r10 + (-48)
            goto L3d
        L24:
            r11 = 97
            if (r10 < r11) goto L31
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L31
            int r11 = r10 + (-97)
            int r11 = r11 + 10
            goto L3d
        L31:
            r11 = 65
            if (r10 < r11) goto L77
            r11 = 70
            if (r10 > r11) goto L77
            int r11 = r10 + (-65)
            int r11 = r11 + 10
        L3d:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4d
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L15
        L4d:
            com.component.lottie.e.e r0 = new com.component.lottie.e.e
            r0.<init>()
            com.component.lottie.e.e r0 = r0.n(r4)
            com.component.lottie.e.e r0 = r0.m(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r0 = r0.v()
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L77:
            if (r0 == 0) goto L7c
        L7a:
            r1 = 1
            goto L99
        L7c:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L99:
            if (r8 != r9) goto La5
            com.component.lottie.e.w r7 = r6.c()
            r15.b = r7
            com.component.lottie.e.x.a(r6)
            goto La7
        La5:
            r6.d = r8
        La7:
            if (r1 != 0) goto Lad
            com.component.lottie.e.w r6 = r15.b
            if (r6 != 0) goto Ld
        Lad:
            long r1 = r15.c
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.c = r1
            return r4
        Lb4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lbd
        Lbc:
            throw r0
        Lbd:
            goto Lbc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.e.e.t():long");
    }

    @Override // com.component.lottie.e.i
    public j u() {
        return new j(z());
    }

    @Override // com.component.lottie.e.i
    public j d(long j) {
        return new j(h(j));
    }

    @Override // com.component.lottie.e.i
    public int a(q qVar) {
        int iA = a(qVar, false);
        if (iA == -1) {
            return -1;
        }
        try {
            i(qVar.a[iA].k());
            return iA;
        } catch (EOFException e) {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        if (r19 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005b, code lost:
    
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int a(com.component.lottie.e.q r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 168
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.e.e.a(com.component.lottie.e.q, boolean):int");
    }

    @Override // com.component.lottie.e.i
    public void b(e eVar, long j) throws EOFException {
        if (this.c < j) {
            eVar.a_(this, this.c);
            throw new EOFException();
        }
        eVar.a_(this, j);
    }

    @Override // com.component.lottie.e.i
    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iA = a(bArr, i, bArr.length - i);
            if (iA == -1) {
                throw new EOFException();
            }
            i += iA;
        }
    }

    @Override // com.component.lottie.e.i
    public long a(z zVar) {
        long j = this.c;
        if (j > 0) {
            zVar.a_(this, j);
        }
        return j;
    }

    @Override // com.component.lottie.e.i
    public String v() {
        try {
            return a(this.c, k.a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.component.lottie.e.i
    public String e(long j) {
        return a(j, k.a);
    }

    @Override // com.component.lottie.e.i
    public String a(Charset charset) {
        try {
            return a(this.c, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.component.lottie.e.i
    public String a(long j, Charset charset) {
        k.a(this.c, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        w wVar = this.b;
        if (wVar.d + j > wVar.e) {
            return new String(h(j), charset);
        }
        String str = new String(wVar.c, wVar.d, (int) j, charset);
        wVar.d = (int) (wVar.d + j);
        this.c -= j;
        if (wVar.d == wVar.e) {
            this.b = wVar.c();
            x.a(wVar);
        }
        return str;
    }

    @Override // com.component.lottie.e.i
    public String w() {
        long jA = a((byte) 10);
        if (jA != -1) {
            return f(jA);
        }
        if (this.c != 0) {
            return e(this.c);
        }
        return null;
    }

    String f(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (c(j2) == 13) {
                String strE = e(j2);
                i(2L);
                return strE;
            }
        }
        String strE2 = e(j);
        i(1L);
        return strE2;
    }

    @Override // com.component.lottie.e.i
    public String x() {
        return g(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // com.component.lottie.e.i
    public String g(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            j2 = j + 1;
        }
        long jA = a((byte) 10, 0L, j2);
        if (jA != -1) {
            return f(jA);
        }
        if (j2 < b() && c(j2 - 1) == 13 && c(j2) == 10) {
            return f(j2);
        }
        e eVar = new e();
        a(eVar, 0L, Math.min(32L, b()));
        throw new EOFException("\\n not found: limit=" + Math.min(b(), j) + " content=" + eVar.u().h() + (char) 8230);
    }

    @Override // com.component.lottie.e.i
    public int y() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.c == 0) {
            throw new EOFException();
        }
        byte bC = c(0L);
        if ((bC & 128) == 0) {
            i = bC & 127;
            i2 = 1;
            i3 = 0;
        } else if ((bC & 224) == 192) {
            i = bC & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bC & 240) == 224) {
            i = bC & 15;
            i2 = 3;
            i3 = 2048;
        } else if ((bC & 248) == 240) {
            i = bC & 7;
            i2 = 4;
            i3 = 65536;
        } else {
            i(1L);
            return 65533;
        }
        long j = i2;
        if (this.c < j) {
            throw new EOFException("size < " + i2 + ": " + this.c + " (to read code point prefixed 0x" + Integer.toHexString(bC) + ")");
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bC2 = c(j2);
            if ((bC2 & 192) == 128) {
                i = (i << 6) | (bC2 & Utf8.REPLACEMENT_BYTE);
            } else {
                i(j2);
                return 65533;
            }
        }
        i(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((i < 55296 || i > 57343) && i >= i3) {
            return i;
        }
        return 65533;
    }

    @Override // com.component.lottie.e.i
    public byte[] z() {
        try {
            return h(this.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.component.lottie.e.i
    public byte[] h(long j) throws EOFException {
        k.a(this.c, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        byte[] bArr = new byte[(int) j];
        a(bArr);
        return bArr;
    }

    @Override // com.component.lottie.e.i
    public int b(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    @Override // com.component.lottie.e.i
    public int a(byte[] bArr, int i, int i2) {
        k.a(bArr.length, i, i2);
        w wVar = this.b;
        if (wVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, wVar.e - wVar.d);
        System.arraycopy(wVar.c, wVar.d, bArr, i, iMin);
        wVar.d += iMin;
        this.c -= iMin;
        if (wVar.d == wVar.e) {
            this.b = wVar.c();
            x.a(wVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        w wVar = this.b;
        if (wVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), wVar.e - wVar.d);
        byteBuffer.put(wVar.c, wVar.d, iMin);
        wVar.d += iMin;
        this.c -= iMin;
        if (wVar.d == wVar.e) {
            this.b = wVar.c();
            x.a(wVar);
        }
        return iMin;
    }

    @Override // com.component.lottie.e.aa
    public long a(e eVar, long j) {
        if (eVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.c == 0) {
            return -1L;
        }
        if (j > this.c) {
            j = this.c;
        }
        eVar.a_(this, j);
        return j;
    }

    public final void A() {
        try {
            i(this.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.component.lottie.e.i
    public void i(long j) throws EOFException {
        while (j > 0) {
            if (this.b == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, this.b.e - this.b.d);
            long j2 = iMin;
            this.c -= j2;
            j -= j2;
            this.b.d += iMin;
            if (this.b.d == this.b.e) {
                w wVar = this.b;
                this.b = wVar.c();
                x.a(wVar);
            }
        }
    }

    @Override // com.component.lottie.e.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e b(String str) {
        return b(str, 0, str.length());
    }

    @Override // com.component.lottie.e.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e b(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                w wVarG = g(1);
                byte[] bArr = wVarG.c;
                int i3 = wVarG.e - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt;
                while (i4 < iMin) {
                    char cCharAt2 = str.charAt(i4);
                    if (cCharAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) cCharAt2;
                    i4++;
                }
                int i5 = (i3 + i4) - wVarG.e;
                wVarG.e += i5;
                this.c += i5;
                i = i4;
            } else if (cCharAt < 2048) {
                m((cCharAt >> 6) | 192);
                m((cCharAt & '?') | 128);
                i++;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                m((cCharAt >> '\f') | 224);
                m(((cCharAt >> 6) & 63) | 128);
                m((cCharAt & '?') | 128);
                i++;
            } else {
                int i6 = i + 1;
                char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                if (cCharAt > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                    m(63);
                    i = i6;
                } else {
                    int i7 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                    m((i7 >> 18) | 240);
                    m(((i7 >> 12) & 63) | 128);
                    m(((i7 >> 6) & 63) | 128);
                    m((i7 & 63) | 128);
                    i += 2;
                }
            }
        }
        return this;
    }

    @Override // com.component.lottie.e.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e n(int i) {
        if (i < 128) {
            m(i);
        } else if (i < 2048) {
            m((i >> 6) | 192);
            m((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                m(63);
            } else {
                m((i >> 12) | 224);
                m(((i >> 6) & 63) | 128);
                m((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            m((i >> 18) | 240);
            m(((i >> 12) & 63) | 128);
            m(((i >> 6) & 63) | 128);
            m((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    @Override // com.component.lottie.e.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e b(String str, Charset charset) {
        return b(str, 0, str.length(), charset);
    }

    @Override // com.component.lottie.e.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e b(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(k.a)) {
            return b(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return c(bytes, 0, bytes.length);
    }

    @Override // com.component.lottie.e.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e g(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        jVar.a(this);
        return this;
    }

    @Override // com.component.lottie.e.h
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e d(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        return c(bArr, 0, bArr.length);
    }

    @Override // com.component.lottie.e.h
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e c(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        k.a(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            w wVarG = g(1);
            int iMin = Math.min(i3 - i, 8192 - wVarG.e);
            System.arraycopy(bArr, i, wVarG.c, wVarG.e, iMin);
            i += iMin;
            wVarG.e += iMin;
        }
        this.c += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            w wVarG = g(1);
            int iMin = Math.min(i, 8192 - wVarG.e);
            byteBuffer.get(wVarG.c, wVarG.e, iMin);
            i -= iMin;
            wVarG.e += iMin;
        }
        this.c += iRemaining;
        return iRemaining;
    }

    @Override // com.component.lottie.e.h
    public h a(aa aaVar, long j) throws EOFException {
        while (j > 0) {
            long jA = aaVar.a(this, j);
            if (jA == -1) {
                throw new EOFException();
            }
            j -= jA;
        }
        return this;
    }

    @Override // com.component.lottie.e.z
    public void a_(e eVar, long j) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (eVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        k.a(eVar.c, 0L, j);
        while (j > 0) {
            if (j < eVar.b.e - eVar.b.d) {
                w wVar = this.b != null ? this.b.i : null;
                if (wVar != null && wVar.g) {
                    if ((wVar.e + j) - (wVar.f ? 0 : wVar.d) <= 8192) {
                        eVar.b.a(wVar, (int) j);
                        eVar.c -= j;
                        this.c += j;
                        return;
                    }
                }
                eVar.b = eVar.b.a((int) j);
            }
            w wVar2 = eVar.b;
            long j2 = wVar2.e - wVar2.d;
            eVar.b = wVar2.c();
            if (this.b == null) {
                this.b = wVar2;
                w wVar3 = this.b;
                w wVar4 = this.b;
                w wVar5 = this.b;
                wVar4.i = wVar5;
                wVar3.h = wVar5;
            } else {
                this.b.i.a(wVar2).d();
            }
            eVar.c -= j2;
            this.c += j2;
            j -= j2;
        }
    }

    @Override // com.component.lottie.e.h
    public long a(aa aaVar) {
        if (aaVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jA = aaVar.a(this, 8192L);
            if (jA != -1) {
                j += jA;
            } else {
                return j;
            }
        }
    }

    @Override // com.component.lottie.e.h
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e m(int i) {
        w wVarG = g(1);
        byte[] bArr = wVarG.c;
        int i2 = wVarG.e;
        wVarG.e = i2 + 1;
        bArr[i2] = (byte) i;
        this.c++;
        return this;
    }

    @Override // com.component.lottie.e.h
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e l(int i) {
        w wVarG = g(2);
        byte[] bArr = wVarG.c;
        int i2 = wVarG.e;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        wVarG.e = i3 + 1;
        this.c += 2;
        return this;
    }

    @Override // com.component.lottie.e.h
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e k(int i) {
        return l((int) k.a((short) i));
    }

    @Override // com.component.lottie.e.h
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public e j(int i) {
        w wVarG = g(4);
        byte[] bArr = wVarG.c;
        int i2 = wVarG.e;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        wVarG.e = i5 + 1;
        this.c += 4;
        return this;
    }

    @Override // com.component.lottie.e.h
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public e i(int i) {
        return j(k.a(i));
    }

    @Override // com.component.lottie.e.h
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public e q(long j) {
        w wVarG = g(8);
        byte[] bArr = wVarG.c;
        int i = wVarG.e;
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 56) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 48) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j >>> 40) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j >>> 32) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j >>> 24) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j >>> 16) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j >>> 8) & 255);
        bArr[i8] = (byte) (j & 255);
        wVarG.e = i8 + 1;
        this.c += 8;
        return this;
    }

    @Override // com.component.lottie.e.h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public e p(long j) {
        return q(k.a(j));
    }

    @Override // com.component.lottie.e.h
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public e o(long j) {
        boolean z;
        if (j == 0) {
            return m(48);
        }
        int i = 1;
        if (j >= 0) {
            z = false;
        } else {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        w wVarG = g(i);
        byte[] bArr = wVarG.c;
        int i2 = wVarG.e + i;
        while (j != 0) {
            i2--;
            bArr[i2] = d[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        wVarG.e += i;
        this.c += i;
        return this;
    }

    @Override // com.component.lottie.e.h
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public e n(long j) {
        if (j == 0) {
            return m(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        w wVarG = g(iNumberOfTrailingZeros);
        byte[] bArr = wVarG.c;
        int i = wVarG.e;
        for (int i2 = (wVarG.e + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = d[(int) (15 & j)];
            j >>>= 4;
        }
        wVarG.e += iNumberOfTrailingZeros;
        this.c += iNumberOfTrailingZeros;
        return this;
    }

    w g(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        if (this.b == null) {
            this.b = x.a();
            w wVar = this.b;
            w wVar2 = this.b;
            w wVar3 = this.b;
            wVar2.i = wVar3;
            wVar.h = wVar3;
            return wVar3;
        }
        w wVar4 = this.b.i;
        if (wVar4.e + i > 8192 || !wVar4.g) {
            return wVar4.a(x.a());
        }
        return wVar4;
    }

    @Override // com.component.lottie.e.i
    public long a(byte b) {
        return a(b, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // com.component.lottie.e.i
    public long a(byte b, long j) {
        return a(b, j, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    @Override // com.component.lottie.e.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(byte r11, long r12, long r14) {
        /*
            r10 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 < 0) goto L7a
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 < 0) goto L7a
            long r2 = r10.c
            int r4 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r4 <= 0) goto L12
            long r14 = r10.c
        L12:
            r2 = -1
            int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r4 != 0) goto L19
            return r2
        L19:
            com.component.lottie.e.w r4 = r10.b
            if (r4 != 0) goto L1e
            return r2
        L1e:
            long r5 = r10.c
            long r5 = r5 - r12
            int r7 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r7 >= 0) goto L35
            long r0 = r10.c
        L27:
            int r5 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r5 <= 0) goto L45
            com.component.lottie.e.w r4 = r4.i
            int r5 = r4.e
            int r6 = r4.d
            int r5 = r5 - r6
            long r5 = (long) r5
            long r0 = r0 - r5
            goto L27
        L35:
        L36:
            int r5 = r4.e
            int r6 = r4.d
            int r5 = r5 - r6
            long r5 = (long) r5
            long r5 = r5 + r0
            int r7 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r7 >= 0) goto L45
            com.component.lottie.e.w r4 = r4.h
            r0 = r5
            goto L36
        L45:
            int r5 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r5 >= 0) goto L79
            byte[] r5 = r4.c
            int r6 = r4.e
            long r6 = (long) r6
            int r8 = r4.d
            long r8 = (long) r8
            long r8 = r8 + r14
            long r8 = r8 - r0
            long r6 = java.lang.Math.min(r6, r8)
            int r7 = (int) r6
            int r6 = r4.d
            long r8 = (long) r6
            long r8 = r8 + r12
            long r8 = r8 - r0
            int r12 = (int) r8
        L5e:
            if (r12 >= r7) goto L6d
            r13 = r5[r12]
            if (r13 != r11) goto L6a
            int r11 = r4.d
            int r12 = r12 - r11
            long r11 = (long) r12
            long r11 = r11 + r0
            return r11
        L6a:
            int r12 = r12 + 1
            goto L5e
        L6d:
            int r12 = r4.e
            int r13 = r4.d
            int r12 = r12 - r13
            long r12 = (long) r12
            long r0 = r0 + r12
            com.component.lottie.e.w r4 = r4.h
            r12 = r0
            goto L45
        L79:
            return r2
        L7a:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            long r0 = r10.c
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.Long r12 = java.lang.Long.valueOf(r12)
            java.lang.Long r13 = java.lang.Long.valueOf(r14)
            r14 = 3
            java.lang.Object[] r14 = new java.lang.Object[r14]
            r15 = 0
            r14[r15] = r0
            r15 = 1
            r14[r15] = r12
            r12 = 2
            r14[r12] = r13
            java.lang.String r12 = "size=%s fromIndex=%s toIndex=%s"
            java.lang.String r12 = java.lang.String.format(r12, r14)
            r11.<init>(r12)
            goto La1
        La0:
            throw r11
        La1:
            goto La0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.e.e.a(byte, long, long):long");
    }

    @Override // com.component.lottie.e.i
    public long b(j jVar) {
        return a(jVar, 0L);
    }

    @Override // com.component.lottie.e.i
    public long a(j jVar, long j) {
        byte[] bArr;
        w wVar;
        if (jVar.k() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        w wVar2 = this.b;
        if (wVar2 == null) {
            return -1L;
        }
        if (this.c - j >= j) {
            while (true) {
                long j3 = (wVar2.e - wVar2.d) + j2;
                if (j3 >= j) {
                    break;
                }
                wVar2 = wVar2.h;
                j2 = j3;
            }
        } else {
            j2 = this.c;
            while (j2 > j) {
                wVar2 = wVar2.i;
                j2 -= wVar2.e - wVar2.d;
            }
        }
        byte b = jVar.b(0);
        int iK = jVar.k();
        long j4 = 1 + (this.c - iK);
        long j5 = j2;
        w wVar3 = wVar2;
        long j6 = j;
        while (j5 < j4) {
            byte[] bArr2 = wVar3.c;
            int iMin = (int) Math.min(wVar3.e, (wVar3.d + j4) - j5);
            int i = (int) ((wVar3.d + j6) - j5);
            while (i < iMin) {
                if (bArr2[i] == b) {
                    bArr = bArr2;
                    wVar = wVar3;
                    if (a(wVar3, i + 1, jVar, 1, iK)) {
                        return (i - wVar.d) + j5;
                    }
                } else {
                    bArr = bArr2;
                    wVar = wVar3;
                }
                i++;
                wVar3 = wVar;
                bArr2 = bArr;
            }
            j5 += r6.e - r6.d;
            wVar3 = wVar3.h;
            j6 = j5;
        }
        return -1L;
    }

    @Override // com.component.lottie.e.i
    public long c(j jVar) {
        return b(jVar, 0L);
    }

    @Override // com.component.lottie.e.i
    public long b(j jVar, long j) {
        long j2 = 0;
        if (j < 0) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        w wVar = this.b;
        if (wVar == null) {
            return -1L;
        }
        if (this.c - j >= j) {
            while (true) {
                long j3 = (wVar.e - wVar.d) + j2;
                if (j3 >= j) {
                    break;
                }
                wVar = wVar.h;
                j2 = j3;
            }
        } else {
            j2 = this.c;
            while (j2 > j) {
                wVar = wVar.i;
                j2 -= wVar.e - wVar.d;
            }
        }
        if (jVar.k() == 2) {
            byte b = jVar.b(0);
            byte b2 = jVar.b(1);
            while (j2 < this.c) {
                byte[] bArr = wVar.c;
                int i = wVar.e;
                for (int i2 = (int) ((wVar.d + j) - j2); i2 < i; i2++) {
                    byte b3 = bArr[i2];
                    if (b3 == b || b3 == b2) {
                        return (i2 - wVar.d) + j2;
                    }
                }
                j2 += wVar.e - wVar.d;
                wVar = wVar.h;
                j = j2;
            }
        } else {
            byte[] bArrM = jVar.m();
            while (j2 < this.c) {
                byte[] bArr2 = wVar.c;
                int i3 = wVar.e;
                for (int i4 = (int) ((wVar.d + j) - j2); i4 < i3; i4++) {
                    byte b4 = bArr2[i4];
                    for (byte b5 : bArrM) {
                        if (b4 == b5) {
                            return (i4 - wVar.d) + j2;
                        }
                    }
                }
                j2 += wVar.e - wVar.d;
                wVar = wVar.h;
                j = j2;
            }
        }
        return -1L;
    }

    @Override // com.component.lottie.e.i
    public boolean a(long j, j jVar) {
        return a(j, jVar, 0, jVar.k());
    }

    @Override // com.component.lottie.e.i
    public boolean a(long j, j jVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.c - j < i2 || jVar.k() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (c(i3 + j) != jVar.b(i + i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean a(w wVar, int i, j jVar, int i2, int i3) {
        int i4 = wVar.e;
        byte[] bArr = wVar.c;
        while (i2 < i3) {
            if (i == i4) {
                wVar = wVar.h;
                byte[] bArr2 = wVar.c;
                bArr = bArr2;
                i = wVar.d;
                i4 = wVar.e;
            }
            if (bArr[i] != jVar.b(i2)) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.component.lottie.e.h, com.component.lottie.e.z, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.component.lottie.e.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.component.lottie.e.z
    public ab a() {
        return ab.c;
    }

    List<Integer> B() {
        if (this.b == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.b.e - this.b.d));
        w wVar = this.b;
        while (true) {
            wVar = wVar.h;
            if (wVar != this.b) {
                arrayList.add(Integer.valueOf(wVar.e - wVar.d));
            } else {
                return arrayList;
            }
        }
    }

    public final j C() {
        return c("MD5");
    }

    public final j D() {
        return c(StringEncryptUtils.SHA_1);
    }

    public final j E() {
        return c(StringEncryptUtils.SHA_256);
    }

    public final j F() {
        return c("SHA-512");
    }

    private j c(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (this.b != null) {
                messageDigest.update(this.b.c, this.b.d, this.b.e - this.b.d);
                for (w wVar = this.b.h; wVar != this.b; wVar = wVar.h) {
                    messageDigest.update(wVar.c, wVar.d, wVar.e - wVar.d);
                }
            }
            return j.a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public final j d(j jVar) {
        return a("HmacSHA1", jVar);
    }

    public final j e(j jVar) {
        return a("HmacSHA256", jVar);
    }

    public final j f(j jVar) {
        return a("HmacSHA512", jVar);
    }

    private j a(String str, j jVar) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(jVar.l(), str));
            if (this.b != null) {
                mac.update(this.b.c, this.b.d, this.b.e - this.b.d);
                for (w wVar = this.b.h; wVar != this.b; wVar = wVar.h) {
                    mac.update(wVar.c, wVar.d, wVar.e - wVar.d);
                }
            }
            return j.a(mac.doFinal());
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.c != eVar.c) {
            return false;
        }
        long j = 0;
        if (this.c == 0) {
            return true;
        }
        w wVar = this.b;
        w wVar2 = eVar.b;
        int i = wVar.d;
        int i2 = wVar2.d;
        while (j < this.c) {
            long jMin = Math.min(wVar.e - i, wVar2.e - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (wVar.c[i] != wVar2.c[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == wVar.e) {
                wVar = wVar.h;
                i = wVar.d;
            }
            if (i2 == wVar2.e) {
                wVar2 = wVar2.h;
                i2 = wVar2.d;
            }
            j += jMin;
        }
        return true;
    }

    public int hashCode() {
        w wVar = this.b;
        if (wVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = wVar.e;
            for (int i3 = wVar.d; i3 < i2; i3++) {
                i = (i * 31) + wVar.c[i3];
            }
            wVar = wVar.h;
        } while (wVar != this.b);
        return i;
    }

    public String toString() {
        return H().toString();
    }

    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public e clone() {
        e eVar = new e();
        if (this.c == 0) {
            return eVar;
        }
        eVar.b = this.b.a();
        w wVar = eVar.b;
        w wVar2 = eVar.b;
        w wVar3 = eVar.b;
        wVar2.i = wVar3;
        wVar.h = wVar3;
        w wVar4 = this.b;
        while (true) {
            wVar4 = wVar4.h;
            if (wVar4 != this.b) {
                eVar.b.i.a(wVar4.a());
            } else {
                eVar.c = this.c;
                return eVar;
            }
        }
    }

    public final j H() {
        if (this.c > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.c);
        }
        return h((int) this.c);
    }

    public final j h(int i) {
        if (i == 0) {
            return j.b;
        }
        return new y(this, i);
    }

    public final a I() {
        return a(new a());
    }

    public final a a(a aVar) {
        if (aVar.a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        aVar.a = this;
        aVar.b = false;
        return aVar;
    }

    public final a J() {
        return b(new a());
    }

    public final a b(a aVar) {
        if (aVar.a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        aVar.a = this;
        aVar.b = true;
        return aVar;
    }

    public static final class a implements Closeable {
        public e a;
        public boolean b;
        public byte[] d;
        private w g;
        public long c = -1;
        public int e = -1;
        public int f = -1;

        public final int a() {
            if (this.c == this.a.c) {
                throw new IllegalStateException();
            }
            if (this.c == -1) {
                return a(0L);
            }
            return a(this.c + (this.f - this.e));
        }

        public final int a(long j) {
            if (j < -1 || j > this.a.c) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.a.c)));
            }
            if (j == -1 || j == this.a.c) {
                this.g = null;
                this.c = j;
                this.d = null;
                this.e = -1;
                this.f = -1;
                return -1;
            }
            long j2 = this.a.c;
            w wVarA = this.a.b;
            w wVar = this.a.b;
            long j3 = 0;
            if (this.g != null) {
                long j4 = this.c - (this.e - this.g.d);
                if (j4 > j) {
                    wVar = this.g;
                    j2 = j4;
                } else {
                    wVarA = this.g;
                    j3 = j4;
                }
            }
            if (j2 - j > j - j3) {
                while (j >= (wVarA.e - wVarA.d) + j3) {
                    j3 += wVarA.e - wVarA.d;
                    wVarA = wVarA.h;
                }
            } else {
                while (j2 > j) {
                    wVar = wVar.i;
                    j2 -= wVar.e - wVar.d;
                }
                j3 = j2;
                wVarA = wVar;
            }
            if (this.b && wVarA.f) {
                w wVarB = wVarA.b();
                if (this.a.b == wVarA) {
                    this.a.b = wVarB;
                }
                wVarA = wVarA.a(wVarB);
                wVarA.i.c();
            }
            this.g = wVarA;
            this.c = j;
            this.d = wVarA.c;
            this.e = wVarA.d + ((int) (j - j3));
            this.f = wVarA.e;
            return this.f - this.e;
        }

        public final long b(long j) {
            if (this.a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.b) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
            long j2 = this.a.c;
            if (j <= j2) {
                if (j < 0) {
                    throw new IllegalArgumentException("newSize < 0: " + j);
                }
                long j3 = j2 - j;
                while (true) {
                    if (j3 <= 0) {
                        break;
                    }
                    w wVar = this.a.b.i;
                    long j4 = wVar.e - wVar.d;
                    if (j4 <= j3) {
                        this.a.b = wVar.c();
                        x.a(wVar);
                        j3 -= j4;
                    } else {
                        wVar.e = (int) (wVar.e - j3);
                        break;
                    }
                }
                this.g = null;
                this.c = j;
                this.d = null;
                this.e = -1;
                this.f = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z = true;
                while (j5 > 0) {
                    w wVarG = this.a.g(1);
                    int iMin = (int) Math.min(j5, 8192 - wVarG.e);
                    wVarG.e += iMin;
                    j5 -= iMin;
                    if (z) {
                        this.g = wVarG;
                        this.c = j2;
                        this.d = wVarG.c;
                        this.e = wVarG.e - iMin;
                        this.f = wVarG.e;
                        z = false;
                    }
                }
            }
            this.a.c = j;
            return j2;
        }

        public final long a(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: " + i);
            }
            if (i > 8192) {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: " + i);
            }
            if (this.a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            if (!this.b) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
            }
            long j = this.a.c;
            w wVarG = this.a.g(i);
            int i2 = 8192 - wVarG.e;
            wVarG.e = 8192;
            long j2 = i2;
            this.a.c = j + j2;
            this.g = wVarG;
            this.c = j;
            this.d = wVarG.c;
            this.e = 8192 - i2;
            this.f = 8192;
            return j2;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.a == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.a = null;
            this.g = null;
            this.c = -1L;
            this.d = null;
            this.e = -1;
            this.f = -1;
        }
    }
}
