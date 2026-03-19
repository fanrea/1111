package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class SplashEndLandView extends FrameLayout {
    private CloseCountDownView Kb;
    private ViewGroup Kc;
    private ViewGroup Kd;
    private ImageView Ke;
    private TextView Kf;
    private TextView Kg;
    private ImageView Kr;
    private TextView Ks;
    private TextView Kt;
    private TextView Ku;
    private int Kv;
    private KsLogoView ek;

    public SplashEndLandView(Context context) {
        super(context);
        this.Kv = 24;
    }

    public SplashEndLandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Kv = 24;
    }

    public SplashEndLandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Kv = 24;
    }

    public SplashEndLandView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Kv = 24;
    }

    public final void t(boolean z) {
        int i;
        if (z) {
            i = R.layout.ksad_splash_end_card_area_land;
        } else {
            i = R.layout.ksad_splash_end_card_area;
        }
        inflate(getContext(), i, this);
        this.Kr = (ImageView) findViewById(R.id.ksad_ad_endcard_title_view);
        this.Kc = (ViewGroup) findViewById(R.id.ksad_splash_end_card_giftbox_view);
        this.Ke = (ImageView) findViewById(R.id.ksad_ad_endcard_icon);
        this.Kf = (TextView) findViewById(R.id.ksad_ad_endcard_appname);
        this.Ks = (TextView) findViewById(R.id.ksad_ad_endcard_appversion);
        this.Kg = (TextView) findViewById(R.id.ksad_ad_endcard_appdesc);
        this.ek = (KsLogoView) findViewById(R.id.ksad_ad_endcard_logo);
        this.Kt = (TextView) findViewById(R.id.ksad_ad_btn_title);
        this.Ku = (TextView) findViewById(R.id.ksad_ad_btn_sub_title);
        this.Kb = (CloseCountDownView) findViewById(R.id.ksad_ad_endcard_close_root);
        this.Kd = (ViewGroup) findViewById(R.id.ksad_splash_endcard_actionbar);
    }

    public final void a(AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, float f) {
        a(new g(getContext(), f));
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.Ke.setImageResource(R.drawable.ksad_default_app_icon);
        com.kwad.sdk.core.d.c.d("SplashEndLandView", "bindView, appIconRadius: " + this.Kv);
        KSImageLoader.loadAppIcon(this.Ke, com.kwad.sdk.core.response.b.a.cC(adInfoEP), adTemplate, this.Kv);
        this.Kf.setText(com.kwad.sdk.core.response.b.a.cz(adInfoEP));
        this.Kg.setText(com.kwad.sdk.core.response.b.a.aw(adInfoEP));
        this.ek.aQ(adTemplate);
        if (!com.kwad.sdk.core.response.b.a.aJ(adInfoEP)) {
            this.Kt.setText("点击查看");
            this.Ku.setVisibility(0);
            this.Ku.setText("跳转详情页/第三方应用");
        } else {
            b(adTemplate, adInfoEP, cVar);
        }
        this.Kb.a(adInfoEP, f);
    }

    public final void by() {
        CloseCountDownView closeCountDownView = this.Kb;
        if (closeCountDownView != null) {
            closeCountDownView.by();
        }
    }

    public final void bz() {
        CloseCountDownView closeCountDownView = this.Kb;
        if (closeCountDownView != null) {
            closeCountDownView.bz();
        }
    }

    public final void mM() {
        CloseCountDownView closeCountDownView = this.Kb;
        if (closeCountDownView != null) {
            closeCountDownView.cv();
        }
    }

    public final void ad(String str) {
        TextView textView = this.Kt;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    public CloseCountDownView getCloseView() {
        return this.Kb;
    }

    public ViewGroup getGiftBoxView() {
        return this.Kc;
    }

    public ViewGroup getActionBarView() {
        return this.Kd;
    }

    public ImageView getAppIcon() {
        return this.Ke;
    }

    public TextView getAppName() {
        return this.Kf;
    }

    public TextView getAppDesc() {
        return this.Kg;
    }

    private void b(AdTemplate adTemplate, AdInfo adInfo, com.kwad.components.core.e.d.c cVar) {
        if (cVar == null) {
            return;
        }
        String strA = com.kwad.components.ad.splashscreen.d.a(adTemplate, adInfo, cVar.pK(), 0);
        if (!TextUtils.isEmpty(strA)) {
            this.Kt.setText(strA);
        } else {
            this.Kt.setText(com.kwad.sdk.core.response.b.a.aH(adInfo));
        }
    }

    private void a(g gVar) {
        ak.a(this.Kr, gVar.mN());
        ak.a(this.Kc, gVar.mO());
        ak.a(this.Ke, gVar.mP());
        ak.a(this.Kd, gVar.mR());
        ak.a(this.Kf, gVar.mS());
        ak.a(this.Ks, gVar.mT());
        ak.a(this.Kg, gVar.mU());
        ak.a(this.Kb, gVar.mV());
        TextView textView = this.Kf;
        if (textView != null) {
            textView.setTextSize(0, gVar.mW());
        }
        TextView textView2 = this.Ks;
        if (textView2 != null) {
            textView2.setTextSize(0, gVar.mX());
        }
        TextView textView3 = this.Kg;
        if (textView3 != null) {
            textView3.setTextSize(0, gVar.mY());
        }
        TextView textView4 = this.Kt;
        if (textView4 != null) {
            textView4.setTextSize(0, gVar.mZ());
        }
        TextView textView5 = this.Ku;
        if (textView5 != null) {
            textView5.setTextSize(0, gVar.na());
        }
        this.Kv = gVar.mQ();
    }
}
