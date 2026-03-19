package com.kwad.sdk.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ak extends bn {
    private int cmq;
    private int cmr;
    private int cms;
    private int cmt;

    public static ak b(int i, int i2, int i3, int i4, int i5, int i6) {
        ak akVar = new ak(i, i2);
        akVar.hx(0);
        akVar.hy(0);
        akVar.hv(i4);
        akVar.hw(0);
        return akVar;
    }

    public final ak c(Context context, float f) {
        ak akVar = new ak(com.kwad.sdk.c.a.a.a(context, this.mWidth * f), com.kwad.sdk.c.a.a.a(context, this.mHeight * f));
        akVar.cms = com.kwad.sdk.c.a.a.a(context, this.cms * f);
        akVar.cmr = com.kwad.sdk.c.a.a.a(context, this.cmr * f);
        akVar.cmt = com.kwad.sdk.c.a.a.a(context, this.cmt * f);
        akVar.cmq = com.kwad.sdk.c.a.a.a(context, this.cmq * f);
        return akVar;
    }

    public ak(int i, int i2) {
        super(i, i2);
    }

    private int aoX() {
        return this.cmq;
    }

    public final void hv(int i) {
        this.cmq = i;
    }

    private int aoY() {
        return this.cmr;
    }

    private void hw(int i) {
        this.cmr = i;
    }

    private int aoZ() {
        return this.cms;
    }

    public final void hx(int i) {
        this.cms = i;
    }

    private int apa() {
        return this.cmt;
    }

    public final void hy(int i) {
        this.cmt = i;
    }

    public static void a(View view, ak akVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (akVar.getHeight() > 0) {
            layoutParams.height = akVar.getHeight();
        }
        if (akVar.getWidth() > 0) {
            layoutParams.width = akVar.getWidth();
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (akVar.aoZ() > 0) {
                marginLayoutParams.leftMargin = akVar.aoZ();
            }
            if (akVar.aoY() > 0) {
                marginLayoutParams.bottomMargin = akVar.aoY();
            }
            if (akVar.apa() > 0) {
                marginLayoutParams.rightMargin = akVar.apa();
            }
            if (akVar.aoX() > 0) {
                marginLayoutParams.topMargin = akVar.aoX();
            }
        }
        view.setLayoutParams(layoutParams);
    }
}
