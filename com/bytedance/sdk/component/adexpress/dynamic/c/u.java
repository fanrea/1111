package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.c.hc;
import com.bytedance.sdk.component.adexpress.hc.uo;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private com.bytedance.sdk.component.adexpress.dynamic.b.gb b;
    private d c;
    public com.bytedance.sdk.component.adexpress.dynamic.b.hc d;
    protected hc hc;

    static class d {
        float b;
        float d;
        float hc;

        d() {
        }
    }

    public u(double d2, int i, double d3, String str, uo uoVar) {
        this.hc = new hc(d2, i, d3, str, uoVar);
    }

    public void d(d dVar) {
        this.c = dVar;
    }

    public void d() {
        this.hc.d();
    }

    public void d(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar, float f, float f2) {
        if (gbVar != null) {
            this.b = gbVar;
        }
        com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar2 = this.b;
        float fGb = gbVar2.gb();
        float fTt = gbVar2.tt();
        float f3 = TextUtils.equals(gbVar2.tc().u().vv(), "fixed") ? fTt : 65536.0f;
        this.hc.d();
        this.hc.b(gbVar2, fGb, f3);
        hc.b bVarD = this.hc.d(gbVar2);
        com.bytedance.sdk.component.adexpress.dynamic.b.hc hcVar = new com.bytedance.sdk.component.adexpress.dynamic.b.hc();
        hcVar.d = f;
        hcVar.hc = f2;
        if (bVarD != null) {
            fGb = bVarD.d;
        }
        hcVar.b = fGb;
        if (bVarD != null) {
            fTt = bVarD.hc;
        }
        hcVar.c = fTt;
        hcVar.u = "root";
        hcVar.tt = 1280.0f;
        hcVar.an = gbVar2;
        hcVar.an.b(hcVar.d);
        hcVar.an.c(hcVar.hc);
        hcVar.an.u(hcVar.b);
        hcVar.an.an(hcVar.c);
        com.bytedance.sdk.component.adexpress.dynamic.b.hc hcVarD = d(hcVar, 0.0f);
        this.d = hcVarD;
        d(hcVarD);
    }

    public void d(com.bytedance.sdk.component.adexpress.dynamic.b.hc hcVar) {
        if (hcVar == null) {
            return;
        }
        hcVar.an.tc().getType();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.b.hc>> list = hcVar.h;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.b.hc> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.b.hc> it = list2.iterator();
                while (it.hasNext()) {
                    d(it.next());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.adexpress.dynamic.b.hc d(com.bytedance.sdk.component.adexpress.dynamic.b.hc r37, float r38) {
        /*
            Method dump skipped, instructions count: 1003
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.c.u.d(com.bytedance.sdk.component.adexpress.dynamic.b.hc, float):com.bytedance.sdk.component.adexpress.dynamic.b.hc");
    }

    private com.bytedance.sdk.component.adexpress.dynamic.b.tt d(com.bytedance.sdk.component.adexpress.dynamic.b.an anVar, hc.b bVar, hc.b bVar2) {
        float fQy = anVar.qy();
        float fGw = anVar.gw();
        float fNf = anVar.nf();
        float fFy = anVar.fy();
        boolean zNw = anVar.nw();
        boolean zDz = anVar.dz();
        boolean zNr = anVar.nr();
        boolean zI = anVar.i();
        if (!zNw) {
            if (zDz) {
                fQy = ((this.c.d != 0.0f ? Math.min(this.c.d, bVar.d) : bVar.d) - fNf) - bVar2.d;
            } else {
                fQy = 0.0f;
            }
        }
        if (!zNr) {
            if (zI) {
                fGw = ((this.c.hc != 0.0f ? this.c.hc : bVar.hc) - fFy) - bVar2.hc;
            } else {
                fGw = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.b.tt(fQy, fGw);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.b.tt d(com.bytedance.sdk.component.adexpress.dynamic.b.hc hcVar, com.bytedance.sdk.component.adexpress.dynamic.b.an anVar, float f, float f2) {
        float f3;
        float f4;
        float f5 = hcVar.d;
        float f6 = hcVar.hc;
        float fQy = anVar.qy();
        float fGw = anVar.gw();
        float fNf = anVar.nf();
        float fFy = anVar.fy();
        boolean zNw = anVar.nw();
        boolean zDz = anVar.dz();
        boolean zNr = anVar.nr();
        boolean zI = anVar.i();
        String strIa = anVar.ia();
        float f7 = hcVar.b;
        float f8 = hcVar.c;
        if (TextUtils.equals(strIa, "0")) {
            if (zNw) {
                f5 = hcVar.d + fQy;
            } else if (zDz) {
                f5 = ((hcVar.d + f7) - fNf) - f;
            }
            if (zNr) {
                f4 = hcVar.hc;
                f6 = f4 + fGw;
            } else if (zI) {
                f3 = hcVar.hc;
                f6 = ((f3 + f8) - fFy) - f2;
            }
        } else if (TextUtils.equals(strIa, "1")) {
            f5 = hcVar.d + ((f7 - f) / 2.0f);
            if (zNr) {
                f4 = hcVar.hc;
                f6 = f4 + fGw;
            } else if (zI) {
                f3 = hcVar.hc;
                f6 = ((f3 + f8) - fFy) - f2;
            }
        } else if (TextUtils.equals(strIa, "2")) {
            f6 = hcVar.hc + ((f8 - f2) / 2.0f);
            if (zNw) {
                f5 = hcVar.d + fQy;
            } else if (zDz) {
                f5 = ((hcVar.d + f7) - fNf) - f;
            }
        } else if (TextUtils.equals(strIa, "3")) {
            f5 = hcVar.d + ((f7 - f) / 2.0f);
            f6 = hcVar.hc + ((f8 - f2) / 2.0f);
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.b.tt(f5, f6);
    }
}
