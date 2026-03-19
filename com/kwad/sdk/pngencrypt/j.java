package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j extends DeflatedChunksSet {
    protected final e cgQ;
    protected byte[] chK;
    protected byte[] chL;
    protected final k chM;
    final p chN;
    protected int[] chO;

    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
    }

    private j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, (eVar != null ? eVar.amG() : kVar.chY) + 1, kVar.chY + 1, null, null);
        this.chO = new int[5];
        this.chM = kVar;
        this.cgQ = eVar;
        this.chN = new p(kVar, eVar);
    }

    private void amH() {
        gY(this.chN.ciu);
    }

    private void gY(int i) {
        byte[] bArr = this.chK;
        if (bArr == null || bArr.length < this.chj.length) {
            this.chK = new byte[this.chj.length];
            this.chL = new byte[this.chj.length];
        }
        if (this.chN.cir == 0) {
            Arrays.fill(this.chK, (byte) 0);
        }
        byte[] bArr2 = this.chK;
        this.chK = this.chL;
        this.chL = bArr2;
        byte b = this.chj[0];
        if (!FilterType.isValidStandard(b)) {
            throw new PngjException("Filter type " + ((int) b) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b);
        int[] iArr = this.chO;
        iArr[b] = iArr[b] + 1;
        this.chK[0] = this.chj[0];
        int i2 = AnonymousClass1.chP[byVal.ordinal()];
        if (i2 == 1) {
            ha(i);
            return;
        }
        if (i2 == 2) {
            hc(i);
            return;
        }
        if (i2 == 3) {
            hd(i);
        } else if (i2 == 4) {
            gZ(i);
        } else {
            if (i2 == 5) {
                hb(i);
                return;
            }
            throw new PngjException("Filter type " + ((int) b) + " not implemented");
        }
    }

    /* renamed from: com.kwad.sdk.pngencrypt.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] chP;

        static {
            int[] iArr = new int[FilterType.values().length];
            chP = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                chP[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                chP[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                chP[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                chP[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void gZ(int i) {
        int i2 = 1;
        int i3 = 1 - this.chM.chX;
        while (i2 <= i) {
            this.chK[i2] = (byte) (this.chj[i2] + (((i3 > 0 ? this.chK[i3] & 255 : 0) + (this.chL[i2] & 255)) / 2));
            i2++;
            i3++;
        }
    }

    private void ha(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.chK[i2] = this.chj[i2];
        }
    }

    private void hb(int i) {
        int i2 = 1;
        int i3 = 1 - this.chM.chX;
        while (i2 <= i) {
            int i4 = 0;
            int i5 = i3 > 0 ? this.chK[i3] & 255 : 0;
            if (i3 > 0) {
                i4 = this.chL[i3] & 255;
            }
            this.chK[i2] = (byte) (this.chj[i2] + n.e(i5, this.chL[i2] & 255, i4));
            i2++;
            i3++;
        }
    }

    private void hc(int i) {
        for (int i2 = 1; i2 <= this.chM.chX; i2++) {
            this.chK[i2] = this.chj[i2];
        }
        int i3 = this.chM.chX + 1;
        int i4 = 1;
        while (i3 <= i) {
            this.chK[i3] = (byte) (this.chj[i3] + this.chK[i4]);
            i3++;
            i4++;
        }
    }

    private void hd(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.chK[i2] = (byte) (this.chj[i2] + this.chL[i2]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final void amv() {
        super.amv();
        this.chN.update(amy());
        amH();
        p pVar = this.chN;
        pVar.j(this.chK, pVar.ciu + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    protected final int amw() {
        return amI();
    }

    private int amI() {
        int iAmG;
        e eVar = this.cgQ;
        int i = 0;
        if (eVar == null) {
            if (amy() < this.chM.chx - 1) {
                iAmG = this.chM.chY;
                i = iAmG + 1;
            }
        } else if (eVar.amz()) {
            iAmG = this.cgQ.amG();
            i = iAmG + 1;
        }
        if (!this.cgT) {
            gU(i);
        }
        return i;
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.chK = null;
        this.chL = null;
    }
}
