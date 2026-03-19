package com.kwad.sdk.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import com.kwad.sdk.glide.gifdecoder.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e implements a {
    private static final String TAG = "e";
    private byte[] bRe;
    private ByteBuffer bRf;
    private c bRg;
    private int[] bRi;
    private final int[] bRj;
    private final a.InterfaceC0603a bRk;
    private short[] bRl;
    private byte[] bRm;
    private byte[] bRn;
    private byte[] bRo;
    private int[] bRp;
    private int bRq;
    private Bitmap bRr;
    private boolean bRs;
    private int bRt;
    private int bRu;
    private int bRv;
    private Boolean bRw;
    private Bitmap.Config bRx;
    private int status;

    public e(a.InterfaceC0603a interfaceC0603a, c cVar, ByteBuffer byteBuffer, int i) {
        this(interfaceC0603a);
        a(cVar, byteBuffer, i);
    }

    private e(a.InterfaceC0603a interfaceC0603a) {
        this.bRj = new int[256];
        this.bRx = Bitmap.Config.ARGB_8888;
        this.bRk = interfaceC0603a;
        this.bRg = new c();
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final ByteBuffer getData() {
        return this.bRf;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final void advance() {
        this.bRq = (this.bRq + 1) % this.bRg.bQW;
    }

    private int ga(int i) {
        if (i < 0 || i >= this.bRg.bQW) {
            return -1;
        }
        return this.bRg.bQY.get(i).delay;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final int afx() {
        int i;
        if (this.bRg.bQW <= 0 || (i = this.bRq) < 0) {
            return 0;
        }
        return ga(i);
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final int getFrameCount() {
        return this.bRg.bQW;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final int afy() {
        return this.bRq;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final void afz() {
        this.bRq = -1;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final int getByteSize() {
        return this.bRf.limit() + this.bRo.length + (this.bRp.length * 4);
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final synchronized Bitmap afA() {
        if (this.bRg.bQW <= 0 || this.bRq < 0) {
            String str = TAG;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.bRg.bQW + ", framePointer=" + this.bRq);
            }
            this.status = 1;
        }
        int i = this.status;
        if (i != 1 && i != 2) {
            this.status = 0;
            if (this.bRe == null) {
                this.bRe = this.bRk.fW(255);
            }
            b bVar = this.bRg.bQY.get(this.bRq);
            int i2 = this.bRq - 1;
            b bVar2 = i2 >= 0 ? this.bRg.bQY.get(i2) : null;
            int[] iArr = bVar.bQU != null ? bVar.bQU : this.bRg.bQV;
            this.bRi = iArr;
            if (iArr == null) {
                String str2 = TAG;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.bRq);
                }
                this.status = 1;
                return null;
            }
            if (bVar.bQQ) {
                int[] iArr2 = this.bRi;
                System.arraycopy(iArr2, 0, this.bRj, 0, iArr2.length);
                int[] iArr3 = this.bRj;
                this.bRi = iArr3;
                iArr3[bVar.bQS] = 0;
            }
            return a(bVar, bVar2);
        }
        String str3 = TAG;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.status);
        }
        return null;
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final void clear() {
        this.bRg = null;
        byte[] bArr = this.bRo;
        if (bArr != null) {
            this.bRk.h(bArr);
        }
        int[] iArr = this.bRp;
        if (iArr != null) {
            this.bRk.b(iArr);
        }
        Bitmap bitmap = this.bRr;
        if (bitmap != null) {
            this.bRk.d(bitmap);
        }
        this.bRr = null;
        this.bRf = null;
        this.bRw = null;
        byte[] bArr2 = this.bRe;
        if (bArr2 != null) {
            this.bRk.h(bArr2);
        }
    }

    private synchronized void a(c cVar, ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int iHighestOneBit = Integer.highestOneBit(i);
        this.status = 0;
        this.bRg = cVar;
        this.bRq = -1;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.bRf = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.bRf.order(ByteOrder.LITTLE_ENDIAN);
        this.bRs = false;
        Iterator<b> it = cVar.bQY.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().bQR == 3) {
                this.bRs = true;
                break;
            }
        }
        this.bRt = iHighestOneBit;
        this.bRv = cVar.width / iHighestOneBit;
        this.bRu = cVar.height / iHighestOneBit;
        this.bRo = this.bRk.fW(cVar.width * cVar.height);
        this.bRp = this.bRk.fX(this.bRv * this.bRu);
    }

    @Override // com.kwad.sdk.glide.gifdecoder.a
    public final void a(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.bRx = config;
    }

    private Bitmap a(b bVar, b bVar2) {
        Bitmap bitmap;
        int[] iArr = this.bRp;
        int i = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.bRr;
            if (bitmap2 != null) {
                this.bRk.d(bitmap2);
            }
            this.bRr = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.bQR == 3 && this.bRr == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.bQR > 0) {
            if (bVar2.bQR == 2) {
                if (!bVar.bQQ) {
                    int i2 = this.bRg.bgColor;
                    if (bVar.bQU == null || this.bRg.bRb != bVar.bQS) {
                        i = i2;
                    }
                } else if (this.bRq == 0) {
                    this.bRw = Boolean.TRUE;
                }
                int i3 = bVar2.ih / this.bRt;
                int i4 = bVar2.iy / this.bRt;
                int i5 = bVar2.iw / this.bRt;
                int i6 = bVar2.ix / this.bRt;
                int i7 = this.bRv;
                int i8 = (i4 * i7) + i6;
                int i9 = (i3 * i7) + i8;
                while (i8 < i9) {
                    int i10 = i8 + i5;
                    for (int i11 = i8; i11 < i10; i11++) {
                        iArr[i11] = i;
                    }
                    i8 += this.bRv;
                }
            } else if (bVar2.bQR == 3 && (bitmap = this.bRr) != null) {
                int i12 = this.bRv;
                bitmap.getPixels(iArr, 0, i12, 0, 0, i12, this.bRu);
            }
        }
        c(bVar);
        if (bVar.bQP || this.bRt != 1) {
            b(bVar);
        } else {
            a(bVar);
        }
        if (this.bRs && (bVar.bQR == 0 || bVar.bQR == 1)) {
            if (this.bRr == null) {
                this.bRr = afQ();
            }
            Bitmap bitmap3 = this.bRr;
            int i13 = this.bRv;
            bitmap3.setPixels(iArr, 0, i13, 0, 0, i13, this.bRu);
        }
        Bitmap bitmapAfQ = afQ();
        int i14 = this.bRv;
        bitmapAfQ.setPixels(iArr, 0, i14, 0, 0, i14, this.bRu);
        return bitmapAfQ;
    }

    private void a(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.bRp;
        int i = bVar2.ih;
        int i2 = bVar2.iy;
        int i3 = bVar2.iw;
        int i4 = bVar2.ix;
        boolean z = this.bRq == 0;
        int i5 = this.bRv;
        byte[] bArr = this.bRo;
        int[] iArr2 = this.bRi;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = bVar2.iw * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                int i13 = i;
                int i14 = b2 & 255;
                if (i14 != b) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i12] = i15;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                i = i13;
            }
            i6++;
            bVar2 = bVar;
        }
        this.bRw = Boolean.valueOf(this.bRw == null && z && b != -1);
    }

    private void b(b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.bRp;
        int i6 = bVar.ih / this.bRt;
        int i7 = bVar.iy / this.bRt;
        int i8 = bVar.iw / this.bRt;
        int i9 = bVar.ix;
        int i10 = this.bRt;
        int i11 = i9 / i10;
        boolean z = this.bRq == 0;
        int i12 = this.bRv;
        int i13 = this.bRu;
        byte[] bArr = this.bRo;
        int[] iArr2 = this.bRi;
        Boolean bool = this.bRw;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i15 < i6) {
            Boolean bool2 = bool;
            if (bVar.bQP) {
                if (i16 >= i6) {
                    i = i6;
                    int i18 = i17 + 1;
                    if (i18 == 2) {
                        i17 = i18;
                        i16 = 4;
                    } else if (i18 == 3) {
                        i17 = i18;
                        i14 = 4;
                        i16 = 2;
                    } else if (i18 != 4) {
                        i17 = i18;
                    } else {
                        i17 = i18;
                        i16 = 1;
                        i14 = 2;
                    }
                } else {
                    i = i6;
                }
                i2 = i16 + i14;
            } else {
                i = i6;
                i2 = i16;
                i16 = i15;
            }
            int i19 = i16 + i7;
            boolean z2 = i10 == 1;
            if (i19 < i13) {
                int i20 = i19 * i12;
                int i21 = i20 + i11;
                int i22 = i21 + i8;
                int i23 = i20 + i12;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i2;
                int i24 = i15 * i10 * bVar.iw;
                if (z2) {
                    int i25 = i21;
                    while (i25 < i22) {
                        int i26 = i7;
                        int i27 = iArr2[bArr[i24] & 255];
                        if (i27 != 0) {
                            iArr[i25] = i27;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i24 += i10;
                        i25++;
                        i7 = i26;
                    }
                } else {
                    i5 = i7;
                    int i28 = ((i22 - i21) * i10) + i24;
                    int i29 = i21;
                    while (true) {
                        i4 = i8;
                        if (i29 < i22) {
                            int iC = c(i24, i28, bVar.iw);
                            if (iC != 0) {
                                iArr[i29] = iC;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i24 += i10;
                            i29++;
                            i8 = i4;
                        }
                    }
                    bool = bool2;
                    i15++;
                    i7 = i5;
                    i8 = i4;
                    i6 = i;
                    i16 = i3;
                }
            } else {
                i3 = i2;
            }
            i5 = i7;
            i4 = i8;
            bool = bool2;
            i15++;
            i7 = i5;
            i8 = i4;
            i6 = i;
            i16 = i3;
        }
        Boolean bool3 = bool;
        if (this.bRw == null) {
            this.bRw = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    private int c(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.bRt + i; i9++) {
            byte[] bArr = this.bRo;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.bRi[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.bRt + i11; i12++) {
            byte[] bArr2 = this.bRo;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.bRi[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void c(b bVar) {
        short s;
        e eVar = this;
        if (bVar != null) {
            eVar.bRf.position(bVar.bQT);
        }
        int i = bVar == null ? eVar.bRg.width * eVar.bRg.height : bVar.ih * bVar.iw;
        byte[] bArr = eVar.bRo;
        if (bArr == null || bArr.length < i) {
            eVar.bRo = eVar.bRk.fW(i);
        }
        byte[] bArr2 = eVar.bRo;
        if (eVar.bRl == null) {
            eVar.bRl = new short[4096];
        }
        short[] sArr = eVar.bRl;
        if (eVar.bRm == null) {
            eVar.bRm = new byte[4096];
        }
        byte[] bArr3 = eVar.bRm;
        if (eVar.bRn == null) {
            eVar.bRn = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr4 = eVar.bRn;
        int iAfO = afO();
        int i2 = 1 << iAfO;
        int i3 = i2 + 1;
        int i4 = i2 + 2;
        int i5 = iAfO + 1;
        int i6 = (1 << i5) - 1;
        int i7 = 0;
        for (int i8 = 0; i8 < i2; i8++) {
            sArr[i8] = 0;
            bArr3[i8] = (byte) i8;
        }
        byte[] bArr5 = eVar.bRe;
        int i9 = i5;
        int i10 = i4;
        int i11 = i6;
        int iAfP = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = -1;
        while (true) {
            if (i7 >= i) {
                break;
            }
            if (iAfP == 0) {
                iAfP = afP();
                if (iAfP <= 0) {
                    eVar.status = 3;
                    break;
                }
                i12 = 0;
            }
            i14 += (bArr5[i12] & 255) << i13;
            i12++;
            iAfP--;
            int i19 = i13 + 8;
            int i20 = i10;
            int i21 = i9;
            int i22 = i18;
            int i23 = i5;
            int i24 = i16;
            while (true) {
                if (i19 < i21) {
                    i18 = i22;
                    i10 = i20;
                    i13 = i19;
                    eVar = this;
                    i16 = i24;
                    i5 = i23;
                    break;
                }
                int i25 = i4;
                int i26 = i14 & i11;
                i14 >>= i21;
                i19 -= i21;
                if (i26 != i2) {
                    if (i26 == i3) {
                        i10 = i20;
                        i4 = i25;
                        i13 = i19;
                        i18 = i22;
                        i16 = i24;
                        i5 = i23;
                        eVar = this;
                        break;
                    }
                    if (i22 == -1) {
                        bArr2[i15] = bArr3[i26];
                        i15++;
                        i7++;
                        i22 = i26;
                        i24 = i22;
                        i4 = i25;
                        i19 = i19;
                    } else {
                        if (i26 >= i20) {
                            bArr4[i17] = (byte) i24;
                            i17++;
                            s = i22;
                        } else {
                            s = i26;
                        }
                        while (s >= i2) {
                            bArr4[i17] = bArr3[s];
                            i17++;
                            s = sArr[s];
                        }
                        i24 = bArr3[s] & 255;
                        byte b = (byte) i24;
                        bArr2[i15] = b;
                        while (true) {
                            i15++;
                            i7++;
                            if (i17 <= 0) {
                                break;
                            }
                            i17--;
                            bArr2[i15] = bArr4[i17];
                        }
                        byte[] bArr6 = bArr4;
                        if (i20 < 4096) {
                            sArr[i20] = (short) i22;
                            bArr3[i20] = b;
                            i20++;
                            if ((i20 & i11) == 0 && i20 < 4096) {
                                i21++;
                                i11 += i20;
                            }
                        }
                        i22 = i26;
                        i4 = i25;
                        i19 = i19;
                        bArr4 = bArr6;
                    }
                } else {
                    i11 = i6;
                    i21 = i23;
                    i20 = i25;
                    i4 = i20;
                    i22 = -1;
                }
            }
            i9 = i21;
        }
        Arrays.fill(bArr2, i15, i, (byte) 0);
    }

    private int afO() {
        return this.bRf.get() & 255;
    }

    private int afP() {
        int iAfO = afO();
        if (iAfO <= 0) {
            return iAfO;
        }
        ByteBuffer byteBuffer = this.bRf;
        byteBuffer.get(this.bRe, 0, Math.min(iAfO, byteBuffer.remaining()));
        return iAfO;
    }

    private Bitmap afQ() {
        Boolean bool = this.bRw;
        Bitmap bitmapA = this.bRk.a(this.bRv, this.bRu, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.bRx);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }
}
