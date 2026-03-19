package com.component.lottie.e;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
final class y extends j {
    final transient byte[][] f;
    final transient int[] g;

    y(e eVar, int i) {
        super(null);
        k.a(eVar.c, 0L, i);
        w wVar = eVar.b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (wVar.e == wVar.d) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += wVar.e - wVar.d;
            i4++;
            wVar = wVar.h;
        }
        this.f = new byte[i4][];
        this.g = new int[i4 * 2];
        w wVar2 = eVar.b;
        int i5 = 0;
        while (i2 < i) {
            this.f[i5] = wVar2.c;
            i2 += wVar2.e - wVar2.d;
            if (i2 > i) {
                i2 = i;
            }
            this.g[i5] = i2;
            this.g[this.f.length + i5] = wVar2.d;
            wVar2.f = true;
            i5++;
            wVar2 = wVar2.h;
        }
    }

    @Override // com.component.lottie.e.j
    public String a() {
        return o().a();
    }

    @Override // com.component.lottie.e.j
    public String a(Charset charset) {
        return o().a(charset);
    }

    @Override // com.component.lottie.e.j
    public String b() {
        return o().b();
    }

    @Override // com.component.lottie.e.j
    public String h() {
        return o().h();
    }

    @Override // com.component.lottie.e.j
    public j i() {
        return o().i();
    }

    @Override // com.component.lottie.e.j
    public j j() {
        return o().j();
    }

    @Override // com.component.lottie.e.j
    public j c() {
        return o().c();
    }

    @Override // com.component.lottie.e.j
    public j d() {
        return o().d();
    }

    @Override // com.component.lottie.e.j
    public j e() {
        return o().e();
    }

    @Override // com.component.lottie.e.j
    public j a(j jVar) {
        return o().a(jVar);
    }

    @Override // com.component.lottie.e.j
    public j b(j jVar) {
        return o().b(jVar);
    }

    @Override // com.component.lottie.e.j
    public String g() {
        return o().g();
    }

    @Override // com.component.lottie.e.j
    public j a(int i) {
        return o().a(i);
    }

    @Override // com.component.lottie.e.j
    public j a(int i, int i2) {
        return o().a(i, i2);
    }

    @Override // com.component.lottie.e.j
    public byte b(int i) {
        k.a(this.g[this.f.length - 1], i, 1L);
        int iC = c(i);
        return this.f[iC][(i - (iC == 0 ? 0 : this.g[iC - 1])) + this.g[this.f.length + iC]];
    }

    private int c(int i) {
        int iBinarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : iBinarySearch ^ (-1);
    }

    @Override // com.component.lottie.e.j
    public int k() {
        return this.g[this.f.length - 1];
    }

    @Override // com.component.lottie.e.j
    public byte[] l() {
        byte[] bArr = new byte[this.g[this.f.length - 1]];
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            System.arraycopy(this.f[i], i3, bArr, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr;
    }

    @Override // com.component.lottie.e.j
    public ByteBuffer n() {
        return ByteBuffer.wrap(l()).asReadOnlyBuffer();
    }

    @Override // com.component.lottie.e.j
    public void a(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            outputStream.write(this.f[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // com.component.lottie.e.j
    void a(e eVar) {
        int length = this.f.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = this.g[length + i];
            int i4 = this.g[i];
            w wVar = new w(this.f[i], i3, (i3 + i4) - i2, true, false);
            if (eVar.b == null) {
                wVar.i = wVar;
                wVar.h = wVar;
                eVar.b = wVar;
            } else {
                eVar.b.i.a(wVar);
            }
            i++;
            i2 = i4;
        }
        eVar.c += i2;
    }

    @Override // com.component.lottie.e.j
    public boolean a(int i, j jVar, int i2, int i3) {
        if (i < 0 || i > k() - i3) {
            return false;
        }
        int iC = c(i);
        while (i3 > 0) {
            int i4 = iC == 0 ? 0 : this.g[iC - 1];
            int iMin = Math.min(i3, ((this.g[iC] - i4) + i4) - i);
            if (!jVar.a(i2, this.f[iC], (i - i4) + this.g[this.f.length + iC], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iC++;
        }
        return true;
    }

    @Override // com.component.lottie.e.j
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > k() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iC = c(i);
        while (i3 > 0) {
            int i4 = iC == 0 ? 0 : this.g[iC - 1];
            int iMin = Math.min(i3, ((this.g[iC] - i4) + i4) - i);
            if (!k.a(this.f[iC], (i - i4) + this.g[this.f.length + iC], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iC++;
        }
        return true;
    }

    @Override // com.component.lottie.e.j
    public int a(byte[] bArr, int i) {
        return o().a(bArr, i);
    }

    @Override // com.component.lottie.e.j
    public int b(byte[] bArr, int i) {
        return o().b(bArr, i);
    }

    private j o() {
        return new j(l());
    }

    @Override // com.component.lottie.e.j
    byte[] m() {
        return l();
    }

    @Override // com.component.lottie.e.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (jVar.k() == k() && a(0, jVar, 0, k())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.component.lottie.e.j
    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int length = this.f.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f[i2];
            int i5 = this.g[length + i2];
            int i6 = this.g[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.d = i4;
        return i4;
    }

    @Override // com.component.lottie.e.j
    public String toString() {
        return o().toString();
    }

    private Object p() {
        return o();
    }
}
