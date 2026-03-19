package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.content.Context;
import com.kwad.sdk.utils.ak;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private ak KG;
    private ak KH;
    private ak KI;
    private ak KJ;
    private ak KK;
    private ak KL;
    private float Kw = 1.0f;
    private int KM = 34;
    private int KN = 19;
    private int KO = 8;
    private int KP = 12;

    public static c ng() {
        c cVar = new c();
        cVar.KG = ak.b(278, 0, 0, 0, 0, 0);
        cVar.KH = ak.b(53, 53, 0, 0, 0, 0);
        cVar.KI = ak.b(0, 43, 0, 11, 0, 0);
        cVar.KJ = ak.b(278, 274, 0, 8, 0, 0);
        cVar.KK = ak.b(0, 0, 0, 8, 0, 0);
        cVar.KL = ak.b(0, 0, 0, 10, 0, 0);
        return cVar;
    }

    public static c d(float f) {
        c cVar = new c();
        cVar.KG = ak.b(174, 0, 0, 0, 0, 0);
        cVar.KH = ak.b(33, 33, 0, 0, 0, 0);
        cVar.KI = ak.b(0, 26, 0, 11, 0, 0);
        cVar.KJ = ak.b(174, 171, 0, 6, 0, 0);
        cVar.KK = ak.b(0, 0, 0, 6, 0, 0);
        cVar.KL = ak.b(0, 0, 0, 7, 0, 0);
        cVar.KM = 21;
        cVar.KN = 12;
        cVar.KO = 6;
        cVar.Kw = f;
        cVar.KP = 8;
        return cVar;
    }

    public final ak W(Context context) {
        return this.KG.c(context, this.Kw);
    }

    public final ak X(Context context) {
        return this.KH.c(context, this.Kw);
    }

    public final ak Y(Context context) {
        return this.KI.c(context, this.Kw);
    }

    public final ak Z(Context context) {
        return this.KJ.c(context, this.Kw);
    }

    public final ak aa(Context context) {
        return this.KK.c(context, this.Kw);
    }

    public final ak ab(Context context) {
        return this.KL.c(context, this.Kw);
    }

    public final int ac(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.KM) * this.Kw);
    }

    public final int ad(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.KN) * this.Kw);
    }

    public final int ae(Context context) {
        return (int) (com.kwad.sdk.c.a.a.b(context, this.KO) * this.Kw);
    }

    public final int nh() {
        return this.KP;
    }
}
