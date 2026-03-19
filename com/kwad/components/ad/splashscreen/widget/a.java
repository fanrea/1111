package com.kwad.components.ad.splashscreen.widget;

import android.content.Context;
import com.kwad.sdk.utils.ak;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private float Kw;
    private int LJ;
    private int LK;
    private int LL;
    private int LM;
    private int LN;
    private int LO;
    private Context mContext;

    public static a ai(Context context) {
        return new a(context);
    }

    public static a aj(Context context) {
        return new a(context, 17, 10, 12, 8, 4, 3);
    }

    private a(Context context) {
        this.LJ = 24;
        this.LK = 12;
        this.LL = 16;
        this.LM = 12;
        this.LN = 6;
        this.LO = 4;
        this.Kw = 1.0f;
        this.mContext = context;
    }

    private a(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        this.Kw = 1.0f;
        this.mContext = context;
        this.LJ = 17;
        this.LK = 10;
        this.LL = 12;
        this.LM = 8;
        this.LN = 4;
        this.LO = 3;
    }

    public final void setScale(float f) {
        this.Kw = f;
    }

    public final int ns() {
        return (int) (((this.LJ - this.LL) / 2) * this.Kw);
    }

    public final int nt() {
        return (int) (this.LM * this.Kw);
    }

    public final ak mV() {
        return new ak(0, (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.LJ) * this.Kw));
    }

    public final ak nu() {
        int iA = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.LN) * this.Kw);
        int iA2 = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.LO) * this.Kw);
        ak akVar = new ak(0, 0);
        akVar.hx(iA);
        akVar.hy(iA2);
        return akVar;
    }

    public final int nv() {
        return (int) (com.kwad.sdk.c.a.a.b(this.mContext, this.LK) * this.Kw);
    }

    public final float nw() {
        return (com.kwad.sdk.c.a.a.a(this.mContext, this.LJ) * this.Kw) / 2.0f;
    }

    public final ak nx() {
        int iA = (int) (com.kwad.sdk.c.a.a.a(this.mContext, this.LL) * this.Kw);
        return new ak(iA, iA);
    }
}
