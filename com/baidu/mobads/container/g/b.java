package com.baidu.mobads.container.g;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentTransaction;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b extends Thread {
    private static final int P = 4096;
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = -1;
    private int A;
    private int B;
    private int C;
    private int D;
    private Bitmap E;
    private Bitmap F;
    private c G;
    private boolean H;
    private byte[] I;
    private int J;

    /* renamed from: K, reason: collision with root package name */
    private int f731K;
    private int L;
    private boolean M;
    private int N;
    private int O;
    private short[] Q;
    private byte[] R;
    private byte[] S;
    private byte[] T;
    private c U;
    private int V;
    private a W;
    private byte[] X;
    private float Y;
    private int Z;
    private int aa;
    public int e;
    public int f;
    private InputStream g;
    private int h;
    private String i;
    private boolean j;
    private int k;
    private int l;
    private int[] m;
    private int[] n;
    private int[] o;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public b(byte[] bArr, a aVar) {
        this.l = 1;
        this.G = null;
        this.H = false;
        this.I = new byte[256];
        this.J = 0;
        this.f731K = 0;
        this.L = 0;
        this.M = false;
        this.N = 0;
        this.W = null;
        this.X = null;
        this.Y = 1.0f;
        this.Z = 0;
        this.aa = 0;
        this.X = bArr;
        this.W = aVar;
    }

    public b(InputStream inputStream, a aVar) {
        this.l = 1;
        this.G = null;
        this.H = false;
        this.I = new byte[256];
        this.J = 0;
        this.f731K = 0;
        this.L = 0;
        this.M = false;
        this.N = 0;
        this.W = null;
        this.X = null;
        this.Y = 1.0f;
        this.Z = 0;
        this.aa = 0;
        this.g = inputStream;
        this.W = aVar;
    }

    public b(InputStream inputStream, a aVar, int i, int i2) {
        this.l = 1;
        this.G = null;
        this.H = false;
        this.I = new byte[256];
        this.J = 0;
        this.f731K = 0;
        this.L = 0;
        this.M = false;
        this.N = 0;
        this.W = null;
        this.X = null;
        this.Y = 1.0f;
        this.Z = 0;
        this.aa = 0;
        this.g = inputStream;
        this.W = aVar;
        this.Z = i;
        this.aa = i2;
    }

    public b(InputStream inputStream, a aVar, float f) {
        this.l = 1;
        this.G = null;
        this.H = false;
        this.I = new byte[256];
        this.J = 0;
        this.f731K = 0;
        this.L = 0;
        this.M = false;
        this.N = 0;
        this.W = null;
        this.X = null;
        this.Y = 1.0f;
        this.Z = 0;
        this.aa = 0;
        this.g = inputStream;
        this.W = aVar;
        this.Y = Math.max(1.0f, 1.0f / f);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (this.g != null) {
                o();
            } else if (this.X != null) {
                m();
            }
        } catch (Exception e) {
        }
    }

    public void a() throws IOException {
        c cVar = this.U;
        while (cVar != null) {
            cVar.a = null;
            this.U = this.U.c;
            cVar = this.U;
        }
        if (this.g != null) {
            try {
                this.g.close();
            } catch (Exception e) {
            }
            this.g = null;
        }
        this.X = null;
    }

    public int b() {
        return this.h;
    }

    public String c() {
        return this.i;
    }

    public boolean d() {
        return this.h == -1;
    }

    public int a(int i) {
        c cVarC;
        this.N = -1;
        if (i >= 0 && i < this.V && (cVarC = c(i)) != null) {
            this.N = cVarC.b;
        }
        return this.N;
    }

    public int[] e() {
        c cVar = this.U;
        int[] iArr = new int[this.V];
        for (int i = 0; cVar != null && i < this.V; i++) {
            iArr[i] = cVar.b;
            cVar = cVar.c;
        }
        return iArr;
    }

    public int f() {
        return this.V;
    }

    public Bitmap g() {
        Bitmap bitmapB = b(0);
        if (this.Y == 1.0f) {
            return bitmapB;
        }
        return com.baidu.mobads.container.util.d.d.a(bitmapB, this.Y);
    }

    public int h() {
        return this.l;
    }

    private void l() {
        int i;
        int i2;
        int[] iArr = new int[this.e * this.f];
        int i3 = 0;
        if (this.L > 0) {
            if (this.L == 3) {
                int i4 = this.V - 2;
                if (i4 > 0) {
                    this.F = b(i4 - 1);
                } else {
                    this.F = null;
                }
            }
            if (this.F != null) {
                this.F.getPixels(iArr, 0, this.e, 0, 0, this.e, this.f);
                if (this.L == 2) {
                    if (this.M) {
                        i2 = 0;
                    } else {
                        i2 = this.r;
                    }
                    for (int i5 = 0; i5 < this.D; i5++) {
                        int i6 = ((this.B + i5) * this.e) + this.A;
                        int i7 = this.C + i6;
                        while (i6 < i7) {
                            iArr[i6] = i2;
                            i6++;
                        }
                    }
                }
            }
        }
        int i8 = 8;
        int i9 = 0;
        int i10 = 1;
        while (i3 < this.z) {
            if (!this.u) {
                i = i9;
                i9 = i3;
            } else {
                if (i9 >= this.z) {
                    i10++;
                    switch (i10) {
                        case 2:
                            i9 = 4;
                            break;
                        case 3:
                            i8 = 4;
                            i9 = 2;
                            break;
                        case 4:
                            i8 = 2;
                            i9 = 1;
                            break;
                    }
                }
                i = i9 + i8;
            }
            int i11 = i9 + this.x;
            if (i11 < this.f) {
                int i12 = i11 * this.e;
                int i13 = this.w + i12;
                int i14 = this.y + i13;
                if (this.e + i12 < i14) {
                    i14 = this.e + i12;
                }
                int i15 = this.y * i3;
                while (i13 < i14) {
                    int i16 = i15 + 1;
                    int i17 = this.o[this.T[i15] & 255];
                    if (i17 != 0) {
                        iArr[i13] = i17;
                    }
                    i13++;
                    i15 = i16;
                }
            }
            i3++;
            i9 = i;
        }
        try {
            this.E = Bitmap.createBitmap(iArr, this.e, this.f, Bitmap.Config.ARGB_4444);
        } catch (OutOfMemoryError e) {
        }
    }

    public Bitmap b(int i) {
        c cVarC = c(i);
        if (cVarC == null) {
            return null;
        }
        return cVarC.a;
    }

    public c i() {
        return this.G;
    }

    public c c(int i) {
        c cVar = this.U;
        int i2 = 0;
        while (cVar != null) {
            if (i2 == i) {
                return cVar;
            }
            cVar = cVar.c;
            i2++;
        }
        return null;
    }

    public void j() {
        this.G = this.U;
    }

    public c k() {
        if (!this.H) {
            this.H = true;
            return this.U;
        }
        if (this.h == 0) {
            if (this.G.c != null) {
                this.G = this.G.c;
            }
        } else {
            this.G = this.G.c;
            if (this.G == null) {
                this.G = this.U;
            }
        }
        return this.G;
    }

    private int m() {
        this.g = new ByteArrayInputStream(this.X);
        this.X = null;
        return o();
    }

    private void n() {
        if (this.e > 0 && this.f > 0 && this.Z > 0 && this.aa > 0) {
            this.Y = Math.max(1.0f, Math.min(this.e / this.Z, this.f / this.aa) * 0.8f);
        }
    }

    private int o() throws IOException {
        r();
        if (this.g != null) {
            w();
            n();
            if (!q()) {
                u();
                if (this.V <= 0) {
                    this.h = 1;
                    this.W.a(false, -1);
                } else {
                    this.h = -1;
                    this.W.a(true, -1);
                }
            } else {
                this.i = "File format error";
                this.W.a(false, -1);
            }
            try {
                this.g.close();
            } catch (Exception e) {
            }
        } else {
            this.h = 2;
            this.i = "InputStream is null";
            this.W.a(false, -1);
        }
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v25, types: [short] */
    /* JADX WARN: Type inference failed for: r2v27 */
    private void p() throws IOException {
        int i;
        int i2;
        short s;
        int i3 = this.y * this.z;
        if (this.T == null || this.T.length < i3) {
            this.T = new byte[i3];
        }
        if (this.Q == null) {
            this.Q = new short[4096];
        }
        if (this.R == null) {
            this.R = new byte[4096];
        }
        if (this.S == null) {
            this.S = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int iS = s();
        int i4 = 1 << iS;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = iS + 1;
        int i8 = (1 << i7) - 1;
        for (int i9 = 0; i9 < i4; i9++) {
            this.Q[i9] = 0;
            this.R[i9] = (byte) i9;
        }
        int i10 = i7;
        int i11 = i6;
        int i12 = i8;
        int i13 = -1;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int iT = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        while (i14 < i3) {
            if (i15 != 0) {
                i = i7;
                i2 = i4;
            } else if (i16 < i10) {
                if (iT == 0) {
                    iT = t();
                    if (iT <= 0) {
                        break;
                    } else {
                        i18 = 0;
                    }
                }
                i17 += (this.I[i18] & 255) << i16;
                i16 += 8;
                i18++;
                iT--;
            } else {
                int i21 = i17 & i12;
                i17 >>= i10;
                i16 -= i10;
                if (i21 > i11 || i21 == i5) {
                    break;
                }
                if (i21 == i4) {
                    i10 = i7;
                    i11 = i6;
                    i12 = i8;
                    i13 = -1;
                } else if (i13 == -1) {
                    this.S[i15] = this.R[i21];
                    i15++;
                    i13 = i21;
                    i19 = i13;
                    i7 = i7;
                } else {
                    i = i7;
                    if (i21 != i11) {
                        s = i21;
                    } else {
                        this.S[i15] = (byte) i19;
                        s = i13;
                        i15++;
                    }
                    while (s > i4) {
                        this.S[i15] = this.R[s];
                        s = this.Q[s];
                        i15++;
                        i4 = i4;
                    }
                    i2 = i4;
                    int i22 = this.R[s] & 255;
                    if (i11 >= 4096) {
                        break;
                    }
                    int i23 = i15 + 1;
                    byte b2 = (byte) i22;
                    this.S[i15] = b2;
                    this.Q[i11] = (short) i13;
                    this.R[i11] = b2;
                    i11++;
                    if ((i11 & i12) == 0 && i11 < 4096) {
                        i10++;
                        i12 += i11;
                    }
                    i13 = i21;
                    i15 = i23;
                    i19 = i22;
                }
            }
            i15--;
            this.T[i20] = this.S[i15];
            i14++;
            i20++;
            i7 = i;
            i4 = i2;
        }
        for (int i24 = i20; i24 < i3; i24++) {
            this.T[i24] = 0;
        }
    }

    private boolean q() {
        return this.h != 0;
    }

    private void r() {
        this.h = 0;
        this.V = 0;
        this.U = null;
        this.m = null;
        this.n = null;
    }

    private int s() {
        try {
            return this.g.read();
        } catch (Exception e) {
            this.h = 1;
            return 0;
        }
    }

    private int t() throws IOException {
        this.J = s();
        int i = 0;
        if (this.J > 0) {
            while (i < this.J) {
                try {
                    int i2 = this.g.read(this.I, i, this.J - i);
                    if (i2 == -1) {
                        break;
                    }
                    i += i2;
                } catch (Exception e) {
                }
            }
            if (i < this.J) {
                this.h = 1;
            }
        }
        return i;
    }

    private int[] d(int i) throws IOException {
        int i2;
        int i3 = i * 3;
        byte[] bArr = new byte[i3];
        try {
            i2 = this.g.read(bArr);
        } catch (Exception e) {
            i2 = 0;
        }
        if (i2 < i3) {
            this.h = 1;
            return null;
        }
        int[] iArr = new int[256];
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = i4 + 1;
            int i7 = i6 + 1;
            iArr[i5] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
            i4 = i7 + 1;
        }
        return iArr;
    }

    private void u() throws IOException {
        boolean z = false;
        while (!z && !q()) {
            switch (s()) {
                case 0:
                    break;
                case 33:
                    switch (s()) {
                        case 249:
                            v();
                            break;
                        case 255:
                            t();
                            String str = "";
                            for (int i = 0; i < 11; i++) {
                                str = str + ((char) this.I[i]);
                            }
                            if (str.equals("NETSCAPE2.0")) {
                                z();
                                break;
                            } else {
                                C();
                                break;
                            }
                        default:
                            C();
                            break;
                    }
                case 44:
                    x();
                    break;
                case 59:
                    z = true;
                    break;
                default:
                    this.h = 1;
                    break;
            }
        }
    }

    private void v() {
        s();
        int iS = s();
        this.f731K = (iS & 28) >> 2;
        if (this.f731K == 0) {
            this.f731K = 1;
        }
        this.M = (iS & 1) != 0;
        this.N = A() * 10;
        this.O = s();
        s();
    }

    private void w() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + ((char) s());
        }
        if (!str.startsWith("GIF")) {
            this.h = 1;
            return;
        }
        y();
        if (this.j && !q()) {
            this.m = d(this.k);
            this.q = this.m[this.p];
        }
    }

    private void x() throws IOException {
        this.w = A();
        this.x = A();
        this.y = A();
        this.z = A();
        int iS = s();
        int i = 0;
        this.t = (iS & 128) != 0;
        this.u = (iS & 64) != 0;
        this.v = 2 << (iS & 7);
        if (this.t) {
            this.n = d(this.v);
            this.o = this.n;
        } else {
            this.o = this.m;
            if (this.p == this.O) {
                this.q = 0;
            }
        }
        if (this.y * this.z > 2592000) {
            this.h = 1;
            this.i = "Oversize gif w:" + this.y + ",h:" + this.z;
        }
        if (this.M) {
            int i2 = this.o[this.O];
            this.o[this.O] = 0;
            i = i2;
        }
        if (this.o == null) {
            this.h = 1;
        }
        if (q()) {
            return;
        }
        p();
        C();
        if (q()) {
            return;
        }
        this.V++;
        this.E = Bitmap.createBitmap(this.e, this.f, Bitmap.Config.ARGB_4444);
        l();
        if (this.U == null) {
            this.U = new c(this.E, this.N, this.Y);
            this.G = this.U;
        } else {
            c cVar = this.U;
            while (cVar.c != null) {
                cVar = cVar.c;
            }
            cVar.c = new c(this.E, this.N, this.Y);
        }
        if (this.M && this.o != null) {
            this.o[this.O] = i;
        }
        B();
        this.W.a(true, this.V);
    }

    private void y() {
        this.e = A();
        this.f = A();
        int iS = s();
        this.j = (iS & 128) != 0;
        this.k = 2 << (iS & 7);
        this.p = s();
        this.s = s();
    }

    private void z() throws IOException {
        do {
            t();
            if (this.I[0] == 1) {
                this.l = (this.I[1] & 255) | ((this.I[2] & 255) << 8);
            }
            if (this.J <= 0) {
                return;
            }
        } while (!q());
    }

    private int A() {
        return s() | (s() << 8);
    }

    private void B() {
        this.L = this.f731K;
        this.A = this.w;
        this.B = this.x;
        this.C = this.y;
        this.D = this.z;
        this.F = this.E;
        this.r = this.q;
        this.f731K = 0;
        this.M = false;
        this.N = 0;
        this.n = null;
    }

    private void C() throws IOException {
        do {
            t();
            if (this.J <= 0) {
                return;
            }
        } while (!q());
    }
}
