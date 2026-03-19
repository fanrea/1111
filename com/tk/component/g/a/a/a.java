package com.tk.component.g.a.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    public float XM;
    public float XN;
    public b XO;
    public b XP;

    public final boolean t(float f) {
        return f >= this.XM && f <= this.XN;
    }

    public final b a(b bVar, float f) {
        float f2 = this.XN;
        float f3 = this.XM;
        if (f2 == f3) {
            return null;
        }
        return a(bVar, this.XP, this.XO, (f - f3) / (f2 - f3));
    }

    private static b a(b bVar, b bVar2, b bVar3, float f) {
        bVar.reset();
        Float f2 = bVar2.XQ;
        if (f2 != null) {
            bVar.XQ = Float.valueOf((bVar3.XQ != null ? bVar3.XQ.floatValue() : 1.0f) + (f2.floatValue() * f));
        }
        Float f3 = bVar2.XR;
        if (f3 != null) {
            bVar.XR = Float.valueOf((bVar3.XR != null ? bVar3.XR.floatValue() : 1.0f) + (f3.floatValue() * f));
        }
        Float f4 = bVar2.XS;
        if (f4 != null) {
            bVar.XS = Float.valueOf((bVar3.XS != null ? bVar3.XS.floatValue() : 0.0f) + (f4.floatValue() * f));
        }
        Float f5 = bVar2.XT;
        if (f5 != null) {
            bVar.XT = Float.valueOf((bVar3.XT != null ? bVar3.XT.floatValue() : 0.0f) + (f5.floatValue() * f));
        }
        Float f6 = bVar2.XU;
        if (f6 != null) {
            bVar.XU = Float.valueOf((bVar3.XU != null ? bVar3.XU.floatValue() : 0.0f) + (f6.floatValue() * f));
        }
        Float f7 = bVar2.XV;
        if (f7 != null) {
            bVar.XV = Float.valueOf((bVar3.XV != null ? bVar3.XV.floatValue() : 0.0f) + (f7.floatValue() * f));
        }
        Float f8 = bVar2.XW;
        if (f8 != null) {
            bVar.XW = Float.valueOf((bVar3.XW != null ? bVar3.XW.floatValue() : 0.0f) + (f8.floatValue() * f));
        }
        Float f9 = bVar2.XX;
        if (f9 != null) {
            bVar.XX = Float.valueOf((bVar3.XX != null ? bVar3.XX.floatValue() : 0.0f) + (f9.floatValue() * f));
        }
        Float f10 = bVar2.XY;
        if (f10 != null) {
            bVar.XY = Float.valueOf((bVar3.XY != null ? bVar3.XY.floatValue() : 0.0f) + (f10.floatValue() * f));
        }
        Float f11 = bVar2.XZ;
        if (f11 != null) {
            bVar.XZ = Float.valueOf((bVar3.XZ != null ? bVar3.XZ.floatValue() : 0.0f) + (f11.floatValue() * f));
        }
        Float f12 = bVar2.Ya;
        if (f12 != null) {
            bVar.Ya = Float.valueOf((bVar3.Ya != null ? bVar3.Ya.floatValue() : 0.0f) + (f12.floatValue() * f));
        }
        return bVar;
    }
}
