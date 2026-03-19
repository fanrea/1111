package com.sigmob.sdk.base.views.gif;

import com.czhj.sdk.logger.SigmobLog;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class d {
    private static final String a = "GifHeaderParser";
    private static final int b = 2;
    private static final int c = 10;
    private static final int d = 256;
    private final byte[] e = new byte[256];
    private int f = 0;
    private c g;
    private ByteBuffer h;

    d() {
    }

    private int[] a(int ncolors) {
        byte[] bArr = new byte[ncolors * 3];
        int[] iArr = null;
        try {
            this.h.get(bArr);
            iArr = new int[256];
            int i = 0;
            int i2 = 0;
            while (i < ncolors) {
                int i3 = i2 + 1;
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i + 1;
                iArr[i] = ((bArr[i2] & 255) << 16) | (-16777216) | ((bArr[i3] & 255) << 8) | (bArr[i4] & 255);
                i2 = i5;
                i = i6;
            }
        } catch (BufferUnderflowException e) {
            SigmobLog.d("Format Error Reading Color Table", e);
            this.g.l = 1;
        }
        return iArr;
    }

    private void b(int maxFrames) {
        boolean z = false;
        while (!z && !d() && this.g.d <= maxFrames) {
            int iE = e();
            if (iE == 33) {
                int iE2 = e();
                if (iE2 != 1) {
                    if (iE2 == 249) {
                        this.g.c = new b();
                        i();
                    } else if (iE2 != 254 && iE2 == 255) {
                        g();
                        String str = "";
                        for (int i = 0; i < 11; i++) {
                            str = str + ((char) this.e[i]);
                        }
                        if (str.equals("NETSCAPE2.0")) {
                            l();
                        }
                    }
                }
                o();
            } else if (iE == 44) {
                if (this.g.c == null) {
                    this.g.c = new b();
                }
                f();
            } else if (iE != 59) {
                this.g.l = 1;
            } else {
                z = true;
            }
        }
    }

    private boolean d() {
        return this.g.l != 0;
    }

    private int e() {
        try {
            return this.h.get() & 255;
        } catch (Exception unused) {
            this.g.l = 1;
            return 0;
        }
    }

    private void f() {
        this.g.c.e = m();
        this.g.c.f = m();
        this.g.c.g = m();
        this.g.c.h = m();
        int iE = e();
        boolean z = (iE & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iE & 7) + 1);
        this.g.c.d = (iE & 64) != 0;
        b bVar = this.g.c;
        if (z) {
            bVar.i = a(iPow);
        } else {
            bVar.i = null;
        }
        this.g.c.a = this.h.position();
        p();
        if (d()) {
            return;
        }
        this.g.d++;
        this.g.e.add(this.g.c);
    }

    private int g() {
        int iE = e();
        this.f = iE;
        int i = 0;
        if (iE > 0) {
            while (true) {
                try {
                    int i2 = this.f;
                    if (i >= i2) {
                        break;
                    }
                    int i3 = i2 - i;
                    this.h.get(this.e, i, i3);
                    i += i3;
                } catch (Exception unused) {
                    this.g.l = 1;
                }
            }
        }
        return i;
    }

    private void h() {
        b(Integer.MAX_VALUE);
    }

    private void i() {
        e();
        int iE = e();
        this.g.c.c = (iE & 28) >> 2;
        if (this.g.c.c == 0) {
            this.g.c.c = 1;
        }
        this.g.c.k = (iE & 1) != 0;
        int iM = m();
        if (iM < 2) {
            iM = 10;
        }
        this.g.c.b = iM * 10;
        this.g.c.j = e();
        e();
    }

    private void j() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) e());
        }
        if (!str.startsWith("GIF")) {
            this.g.l = 1;
            return;
        }
        k();
        if (!this.g.g || d()) {
            return;
        }
        c cVar = this.g;
        cVar.f = a(cVar.h);
        c cVar2 = this.g;
        cVar2.a = cVar2.f[this.g.b];
    }

    private void k() {
        this.g.m = m();
        this.g.i = m();
        int iE = e();
        this.g.g = (iE & 128) != 0;
        this.g.h = 2 << (iE & 7);
        this.g.b = e();
        this.g.k = e();
    }

    private void l() {
        do {
            g();
            byte[] bArr = this.e;
            if (bArr[0] == 1) {
                this.g.j = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
                if (this.g.j == 0) {
                    this.g.j = -1;
                }
            }
            if (this.f <= 0) {
                return;
            }
        } while (!d());
    }

    private int m() {
        return this.h.getShort();
    }

    private void n() {
        this.h = null;
        Arrays.fill(this.e, (byte) 0);
        this.g = new c();
        this.f = 0;
    }

    private void o() {
        int iE;
        do {
            try {
                iE = e();
                ByteBuffer byteBuffer = this.h;
                byteBuffer.position(byteBuffer.position() + iE);
            } catch (IllegalArgumentException unused) {
                return;
            }
        } while (iE > 0);
    }

    private void p() {
        e();
        o();
    }

    public d a(ByteBuffer data) {
        n();
        ByteBuffer byteBufferAsReadOnlyBuffer = data.asReadOnlyBuffer();
        this.h = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.h.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public d a(byte[] data) {
        if (data != null) {
            a(ByteBuffer.wrap(data));
        } else {
            this.h = null;
            this.g.l = 2;
        }
        return this;
    }

    public void a() {
        this.h = null;
        this.g = null;
    }

    public boolean b() {
        j();
        if (!d()) {
            b(2);
        }
        return this.g.d > 1;
    }

    c c() {
        if (this.h == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (d()) {
            return this.g;
        }
        j();
        if (!d()) {
            h();
            if (this.g.d < 0) {
                this.g.l = 1;
            }
        }
        return this.g;
    }
}
