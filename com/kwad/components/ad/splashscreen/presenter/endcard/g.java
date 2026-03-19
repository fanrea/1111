package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.content.Context;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ak;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g {
    private float Kw;
    private Context mContext;

    public g(Context context, float f) {
        this.mContext = context;
        this.Kw = f;
    }

    public final ak mN() {
        return new ak(g(this.mContext, R.dimen.ksad_splash_endcard_title_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_title_iconh_land));
    }

    public final ak mO() {
        return new ak(g(this.mContext, R.dimen.ksad_splash_endcard_gift_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_gift_iconh_land));
    }

    public final ak mP() {
        int iG = g(this.mContext, R.dimen.ksad_splash_endcard_app_iconw_land);
        int iG2 = g(this.mContext, R.dimen.ksad_splash_endcard_app_iconh_land);
        int iG3 = g(this.mContext, R.dimen.ksad_splash_endcard_app_margin_top_land);
        ak akVar = new ak(iG, iG2);
        akVar.hv(iG3);
        return akVar;
    }

    public final int mQ() {
        return com.kwad.sdk.c.a.a.px2dip(this.mContext, (int) (g(this.mContext, R.dimen.ksad_splash_endcard_app_iconw_land) * 0.24f));
    }

    public final ak mR() {
        return new ak(g(this.mContext, R.dimen.ksad_splash_endcard_actionbar_iconw_land), g(this.mContext, R.dimen.ksad_splash_endcard_actionbar_iconh_land));
    }

    public final ak mS() {
        int iG = g(this.mContext, R.dimen.ksad_splash_endcard_appname_h_land);
        int iG2 = g(this.mContext, R.dimen.ksad_splash_endcard_appname_margin_top_land);
        ak akVar = new ak(0, iG);
        akVar.hv(iG2);
        return akVar;
    }

    public final ak mT() {
        return new ak(0, g(this.mContext, R.dimen.ksad_splash_endcard_appver_h_land));
    }

    public final ak mU() {
        int iG = g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_h_land);
        int iG2 = g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_margin_top_land);
        ak akVar = new ak(0, iG);
        akVar.hv(iG2);
        return akVar;
    }

    public final ak mV() {
        int iG = g(this.mContext, R.dimen.ksad_splash_endcard_close_root_h_land);
        int iG2 = g(this.mContext, R.dimen.ksad_splash_endcard_close_root_margin_top_land);
        ak akVar = new ak(0, iG);
        akVar.hv(iG2);
        return akVar;
    }

    public final int mW() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appname_text_sp_land);
    }

    public final int mX() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appver_text_sp_land);
    }

    public final int mY() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_appdesc_text_sp_land);
    }

    public final int mZ() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_ab_title_text_sp_land);
    }

    public final int na() {
        return g(this.mContext, R.dimen.ksad_splash_endcard_ab_subtitle_text_sp_land);
    }

    private int g(Context context, int i) {
        return (int) (com.kwad.sdk.c.a.a.j(context, i) * this.Kw);
    }
}
