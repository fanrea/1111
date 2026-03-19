package com.sigmob.sdk.base.views.gif;

import android.graphics.Bitmap;
import androidx.fragment.app.FragmentTransaction;
import com.czhj.sdk.logger.SigmobLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class a {
    static final int a = 0;
    static final int b = 1;
    static final int c = 2;
    static final int d = 3;
    static final int e = -1;
    private static final String f = "a";
    private static final int g = 4096;
    private static final int h = 0;
    private static final int i = 1;
    private static final int j = 2;
    private static final int k = 3;
    private static final int l = -1;
    private static final int m = -1;
    private static final int n = 4;
    private static final int o = 16384;
    private d A;
    private final int[] B;
    private byte[] C;
    private short[] D;
    private Bitmap E;
    private ByteBuffer F;
    private int G;
    private boolean H;
    private int I;
    private byte[] J;

    /* renamed from: K, reason: collision with root package name */
    private byte[] f793K;
    private int L;
    private int M;
    private int[] p;
    private final InterfaceC0730a q;
    private byte[] r;
    private int s;
    private int t;
    private int u;
    private c v;
    private boolean w;
    private int x;
    private byte[] y;
    private int[] z;

    /* renamed from: com.sigmob.sdk.base.views.gif.a$a, reason: collision with other inner class name */
    interface InterfaceC0730a {
        Bitmap a(int width, int height, Bitmap.Config config);

        void a(Bitmap bitmap);

        void a(byte[] bytes);

        void a(int[] array);

        byte[] a(int size);

        int[] b(int size);
    }

    a() {
        this(new f());
    }

    a(InterfaceC0730a provider) {
        this.B = new int[256];
        this.L = 0;
        this.M = 0;
        this.q = provider;
        this.v = new c();
    }

    a(InterfaceC0730a provider, c gifHeader, ByteBuffer rawData) {
        this(provider, gifHeader, rawData, 1);
    }

    a(InterfaceC0730a provider, c gifHeader, ByteBuffer rawData, int sampleSize) {
        this(provider);
        a(gifHeader, rawData, sampleSize);
    }

    private int a(int positionInMainPixels, int maxPositionInMainPixels, int currentFrameIw) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = positionInMainPixels; i7 < this.G + positionInMainPixels; i7++) {
            byte[] bArr = this.y;
            if (i7 >= bArr.length || i7 >= maxPositionInMainPixels) {
                break;
            }
            int i8 = this.p[bArr[i7] & 255];
            if (i8 != 0) {
                i2 += (i8 >> 24) & 255;
                i3 += (i8 >> 16) & 255;
                i4 += (i8 >> 8) & 255;
                i5 += i8 & 255;
                i6++;
            }
        }
        int i9 = positionInMainPixels + currentFrameIw;
        for (int i10 = i9; i10 < this.G + i9; i10++) {
            byte[] bArr2 = this.y;
            if (i10 >= bArr2.length || i10 >= maxPositionInMainPixels) {
                break;
            }
            int i11 = this.p[bArr2[i10] & 255];
            if (i11 != 0) {
                i2 += (i11 >> 24) & 255;
                i3 += (i11 >> 16) & 255;
                i4 += (i11 >> 8) & 255;
                i5 += i11 & 255;
                i6++;
            }
        }
        if (i6 == 0) {
            return 0;
        }
        return ((i2 / i6) << 24) | ((i3 / i6) << 16) | ((i4 / i6) << 8) | (i5 / i6);
    }

    private Bitmap a(b currentFrame, b previousFrame) {
        int i2;
        int i3;
        int[] iArr = this.z;
        int i4 = 0;
        if (previousFrame == null) {
            Arrays.fill(iArr, 0);
        }
        int i5 = 3;
        int i6 = 2;
        int i7 = 1;
        if (previousFrame != null && previousFrame.c > 0) {
            if (previousFrame.c == 2) {
                if (!currentFrame.k) {
                    i3 = this.v.a;
                    if (currentFrame.i != null && this.v.b == currentFrame.j) {
                    }
                    a(iArr, previousFrame, i3);
                } else if (this.u == 0) {
                    this.w = true;
                }
                i3 = 0;
                a(iArr, previousFrame, i3);
            } else if (previousFrame.c == 3) {
                if (this.E == null) {
                    a(iArr, previousFrame, 0);
                } else {
                    int i8 = previousFrame.h / this.G;
                    int i9 = previousFrame.f / this.G;
                    int i10 = previousFrame.g / this.G;
                    int i11 = previousFrame.e / this.G;
                    int i12 = this.t;
                    this.E.getPixels(iArr, (i9 * i12) + i11, i12, i11, i9, i10, i8);
                }
            }
        }
        a(currentFrame);
        int i13 = currentFrame.h / this.G;
        int i14 = currentFrame.f / this.G;
        int i15 = currentFrame.g / this.G;
        int i16 = currentFrame.e / this.G;
        int i17 = 8;
        boolean z = this.u == 0;
        int i18 = 0;
        int i19 = 1;
        while (i4 < i13) {
            if (currentFrame.d) {
                if (i18 >= i13) {
                    i19++;
                    if (i19 == i6) {
                        i18 = 4;
                    } else if (i19 == i5) {
                        i18 = i6;
                        i17 = 4;
                    } else if (i19 == 4) {
                        i17 = i6;
                        i18 = i7;
                    }
                }
                i2 = i18 + i17;
            } else {
                i2 = i18;
                i18 = i4;
            }
            int i20 = i18 + i14;
            if (i20 < this.s) {
                int i21 = this.t;
                int i22 = i20 * i21;
                int i23 = i22 + i16;
                int i24 = i23 + i15;
                if (i22 + i21 < i24) {
                    i24 = i22 + i21;
                }
                int i25 = this.G * i4 * currentFrame.g;
                int i26 = ((i24 - i23) * this.G) + i25;
                int i27 = i23;
                while (i27 < i24) {
                    int i28 = i13;
                    int i29 = i14;
                    int iA = this.G == 1 ? this.p[this.y[i25] & 255] : a(i25, i26, currentFrame.g);
                    if (iA != 0) {
                        iArr[i27] = iA;
                    } else if (!this.w && z) {
                        this.w = true;
                    }
                    i25 += this.G;
                    i27++;
                    i13 = i28;
                    i14 = i29;
                }
            }
            i4++;
            i13 = i13;
            i18 = i2;
            i14 = i14;
            i5 = 3;
            i6 = 2;
            i7 = 1;
        }
        if (this.H && (currentFrame.c == 0 || currentFrame.c == 1)) {
            if (this.E == null) {
                this.E = q();
            }
            Bitmap bitmap = this.E;
            int i30 = this.t;
            bitmap.setPixels(iArr, 0, i30, 0, 0, i30, this.s);
        }
        Bitmap bitmapQ = q();
        int i31 = this.t;
        bitmapQ.setPixels(iArr, 0, i31, 0, 0, i31, this.s);
        return bitmapQ;
    }

    private static void a(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v23, types: [short] */
    /* JADX WARN: Type inference failed for: r3v25 */
    private void a(b frame) {
        int i2;
        short s;
        this.M = 0;
        this.L = 0;
        if (frame != null) {
            this.F.position(frame.a);
        }
        int i3 = frame == null ? this.v.m * this.v.i : frame.h * frame.g;
        byte[] bArr = this.y;
        if (bArr == null || bArr.length < i3) {
            this.y = this.q.a(i3);
        }
        if (this.D == null) {
            this.D = new short[4096];
        }
        if (this.J == null) {
            this.J = new byte[4096];
        }
        if (this.C == null) {
            this.C = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int iS = s();
        int i4 = 1;
        int i5 = 1 << iS;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = iS + 1;
        int i9 = (1 << i8) - 1;
        for (int i10 = 0; i10 < i5; i10++) {
            this.D[i10] = 0;
            this.J[i10] = (byte) i10;
        }
        int i11 = -1;
        int i12 = 0;
        int iR = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = i8;
        int i20 = i7;
        int i21 = i9;
        int i22 = -1;
        while (true) {
            if (i12 >= i3) {
                break;
            }
            int i23 = 3;
            if (iR == 0) {
                iR = r();
                if (iR <= 0) {
                    this.I = 3;
                    break;
                }
                i13 = 0;
            }
            i15 += (this.r[i13] & 255) << i14;
            i14 += 8;
            i13 += i4;
            iR += i11;
            int i24 = i20;
            int i25 = i19;
            int i26 = i22;
            int i27 = i17;
            while (i14 >= i25) {
                int i28 = i15 & i21;
                i15 >>= i25;
                i14 -= i25;
                if (i28 != i5) {
                    if (i28 > i24) {
                        this.I = i23;
                    } else if (i28 != i6) {
                        int i29 = i8;
                        int i30 = i26;
                        if (i30 == -1) {
                            this.C[i18] = this.J[i28];
                            i26 = i28;
                            i27 = i26;
                            i8 = i29;
                            i18++;
                            i23 = 3;
                            i11 = -1;
                        } else {
                            if (i28 >= i24) {
                                i2 = i6;
                                this.C[i18] = (byte) i27;
                                s = i30;
                                i18++;
                            } else {
                                i2 = i6;
                                s = i28;
                            }
                            while (s >= i5) {
                                this.C[i18] = this.J[s];
                                s = this.D[s];
                                i18++;
                                i5 = i5;
                            }
                            int i31 = i5;
                            byte[] bArr2 = this.J;
                            int i32 = bArr2[s] & 255;
                            int i33 = i18 + 1;
                            int i34 = i7;
                            byte b2 = (byte) i32;
                            this.C[i18] = b2;
                            if (i24 < 4096) {
                                this.D[i24] = (short) i30;
                                bArr2[i24] = b2;
                                i24++;
                                if ((i24 & i21) == 0 && i24 < 4096) {
                                    i25++;
                                    i21 += i24;
                                }
                            }
                            i18 = i33;
                            while (i18 > 0) {
                                i18--;
                                this.y[i16] = this.C[i18];
                                i12++;
                                i16++;
                            }
                            i26 = i28;
                            i5 = i31;
                            i6 = i2;
                            i7 = i34;
                            i23 = 3;
                            i11 = -1;
                            i27 = i32;
                            i8 = i29;
                        }
                    }
                    i20 = i24;
                    i19 = i25;
                    i22 = i26;
                    i17 = i27;
                    i4 = 1;
                    i11 = -1;
                    break;
                }
                i25 = i8;
                i24 = i7;
                i21 = i9;
                i11 = -1;
                i26 = -1;
            }
            i22 = i26;
            i20 = i24;
            i19 = i25;
            i17 = i27;
            i6 = i6;
            i4 = 1;
        }
        for (int i35 = i16; i35 < i3; i35++) {
            this.y[i35] = 0;
        }
    }

    private void a(int[] dest, b frame, int bgColor) {
        int i2 = frame.h / this.G;
        int i3 = frame.f / this.G;
        int i4 = frame.g / this.G;
        int i5 = frame.e / this.G;
        int i6 = this.t;
        int i7 = (i3 * i6) + i5;
        int i8 = (i2 * i6) + i7;
        while (i7 < i8) {
            int i9 = i7 + i4;
            for (int i10 = i7; i10 < i9; i10++) {
                dest[i10] = bgColor;
            }
            i7 += this.t;
        }
    }

    private d p() {
        if (this.A == null) {
            this.A = new d();
        }
        return this.A;
    }

    private Bitmap q() {
        Bitmap bitmapA = this.q.a(this.t, this.s, this.w ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        a(bitmapA);
        return bitmapA;
    }

    private int r() {
        int iS = s();
        if (iS > 0) {
            try {
                if (this.r == null) {
                    this.r = this.q.a(255);
                }
                int i2 = this.M;
                int i3 = this.L;
                int i4 = i2 - i3;
                if (i4 >= iS) {
                    System.arraycopy(this.f793K, i3, this.r, 0, iS);
                    this.L += iS;
                } else if (this.F.remaining() + i4 >= iS) {
                    System.arraycopy(this.f793K, this.L, this.r, 0, i4);
                    this.L = this.M;
                    t();
                    int i5 = iS - i4;
                    System.arraycopy(this.f793K, 0, this.r, i4, i5);
                    this.L += i5;
                } else {
                    this.I = 1;
                }
            } catch (Exception e2) {
                SigmobLog.d("Error Reading Block", e2);
                this.I = 1;
            }
        }
        return iS;
    }

    private int s() {
        try {
            t();
            byte[] bArr = this.f793K;
            int i2 = this.L;
            this.L = i2 + 1;
            return bArr[i2] & 255;
        } catch (Exception unused) {
            this.I = 1;
            return 0;
        }
    }

    private void t() {
        if (this.M > this.L) {
            return;
        }
        if (this.f793K == null) {
            this.f793K = this.q.a(16384);
        }
        this.L = 0;
        int iMin = Math.min(this.F.remaining(), 16384);
        this.M = iMin;
        this.F.get(this.f793K, 0, iMin);
    }

    int a(int n2) {
        if (n2 < 0 || n2 >= this.v.d) {
            return -1;
        }
        return this.v.e.get(n2).b;
    }

    int a(InputStream is, int contentLength) throws IOException {
        if (is != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(contentLength > 0 ? contentLength + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i2 = is.read(bArr, 0, 16384);
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                }
                byteArrayOutputStream.flush();
                a(byteArrayOutputStream.toByteArray());
            } catch (IOException e2) {
                SigmobLog.d("Error reading data from stream", e2);
            }
        } else {
            this.I = 2;
        }
        if (is != null) {
            try {
                is.close();
            } catch (IOException e3) {
                SigmobLog.d("Error closing stream", e3);
            }
        }
        return this.I;
    }

    synchronized int a(byte[] data) {
        c cVarC = p().a(data).c();
        this.v = cVarC;
        if (data != null) {
            a(cVarC, data);
        }
        return this.I;
    }

    synchronized void a(c header, ByteBuffer buffer) {
        a(header, buffer, 1);
    }

    synchronized void a(c header, ByteBuffer buffer, int sampleSize) {
        if (sampleSize <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + sampleSize);
        }
        int iHighestOneBit = Integer.highestOneBit(sampleSize);
        this.I = 0;
        this.v = header;
        this.w = false;
        this.u = -1;
        o();
        ByteBuffer byteBufferAsReadOnlyBuffer = buffer.asReadOnlyBuffer();
        this.F = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.F.order(ByteOrder.LITTLE_ENDIAN);
        this.H = false;
        Iterator<b> it = header.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().c == 3) {
                this.H = true;
                break;
            }
        }
        this.G = iHighestOneBit;
        this.t = header.m / iHighestOneBit;
        this.s = header.i / iHighestOneBit;
        this.y = this.q.a(header.m * header.i);
        this.z = this.q.b(this.t * this.s);
    }

    synchronized void a(c header, byte[] data) {
        a(header, ByteBuffer.wrap(data));
    }

    boolean a() {
        if (this.v.d <= 0) {
            return false;
        }
        if (this.u == f() - 1) {
            this.x++;
        }
        if (this.v.j != -1 && this.x > this.v.j) {
            return false;
        }
        this.u = (this.u + 1) % this.v.d;
        return true;
    }

    void b() {
        this.v = null;
        byte[] bArr = this.y;
        if (bArr != null) {
            this.q.a(bArr);
        }
        int[] iArr = this.z;
        if (iArr != null) {
            this.q.a(iArr);
        }
        Bitmap bitmap = this.E;
        if (bitmap != null) {
            this.q.a(bitmap);
        }
        this.E = null;
        this.F = null;
        this.w = false;
        byte[] bArr2 = this.r;
        if (bArr2 != null) {
            this.q.a(bArr2);
        }
        byte[] bArr3 = this.f793K;
        if (bArr3 != null) {
            this.q.a(bArr3);
        }
    }

    boolean b(int frame) {
        if (frame < -1 || frame >= f()) {
            return false;
        }
        this.u = frame;
        return true;
    }

    int c() {
        return this.F.limit() + this.y.length + (this.z.length * 4);
    }

    int d() {
        return this.u;
    }

    ByteBuffer e() {
        return this.F;
    }

    int f() {
        return this.v.d;
    }

    int g() {
        return this.v.i;
    }

    int h() {
        return this.v.j;
    }

    int i() {
        return this.x;
    }

    int j() {
        int i2;
        if (this.v.d <= 0 || (i2 = this.u) < 0) {
            return 0;
        }
        return a(i2);
    }

    synchronized Bitmap k() {
        if (this.v.d <= 0 || this.u < 0) {
            SigmobLog.d("unable to decode frame, frameCount=" + this.v.d + " framePointer=" + this.u);
            this.I = 1;
        }
        int i2 = this.I;
        if (i2 != 1 && i2 != 2) {
            this.I = 0;
            b bVar = this.v.e.get(this.u);
            int i3 = this.u - 1;
            b bVar2 = i3 >= 0 ? this.v.e.get(i3) : null;
            int[] iArr = bVar.i != null ? bVar.i : this.v.f;
            this.p = iArr;
            if (iArr == null) {
                SigmobLog.d("No Valid Color Table for frame #" + this.u);
                this.I = 1;
                return null;
            }
            if (bVar.k) {
                int[] iArr2 = this.p;
                System.arraycopy(iArr2, 0, this.B, 0, iArr2.length);
                int[] iArr3 = this.B;
                this.p = iArr3;
                iArr3[bVar.j] = 0;
            }
            return a(bVar, bVar2);
        }
        SigmobLog.d("Unable to decode frame, status=" + this.I);
        return null;
    }

    int l() {
        return this.I;
    }

    int m() {
        return this.v.m;
    }

    void n() {
        this.u = -1;
    }

    void o() {
        this.x = 0;
    }
}
