package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.widget.j;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ad.splashscreen.presenter.e implements View.OnClickListener, com.kwad.sdk.widget.e {
    private CloseCountDownView Kb;
    private ViewGroup Kc;
    private ViewGroup Kd;
    private ImageView Ke;
    private TextView Kf;
    private TextView Kg;
    private SplashEndLandView Kh;
    private CloseCountDownView.a Ki = new CloseCountDownView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.c.1
        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void em() {
            a.C0576a c0576a = new a.C0576a();
            com.kwad.components.ad.splashscreen.monitor.a.mb().ai(c.this.HX.mAdTemplate);
            if (c.this.HX.mTimerHelper != null) {
                c0576a.duration = c.this.HX.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.HX.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().eQ(1).b(c0576a).eY(6), (JSONObject) null);
            c.this.HX.lW();
        }

        @Override // com.kwad.components.ad.splashscreen.widget.CloseCountDownView.a
        public final void mj() {
            a.C0576a c0576a = new a.C0576a();
            if (c.this.HX.mTimerHelper != null) {
                c0576a.duration = c.this.HX.mTimerHelper.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(c.this.HX.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().eQ(14).b(c0576a).eY(6), (JSONObject) null);
            c.this.HX.ma();
        }
    };

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.Kh == null) {
            SplashEndLandView splashEndLandView = (SplashEndLandView) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
            this.Kh = splashEndLandView;
            this.Kb = splashEndLandView.getCloseView();
            this.Kc = this.Kh.getGiftBoxView();
            this.Kd = this.Kh.getActionBarView();
            this.Ke = this.Kh.getAppIcon();
            this.Kf = this.Kh.getAppName();
            this.Kg = this.Kh.getAppDesc();
        }
        this.Kb.setOnViewClickListener(this.Ki);
        this.Kd.setOnClickListener(this);
        new j(this.Kd.getContext(), this.Kd, this);
        if (com.kwad.sdk.core.response.b.b.dN(com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate))) {
            this.Kc.setOnClickListener(this);
            this.Ke.setOnClickListener(this);
            this.Kf.setOnClickListener(this);
            this.Kg.setOnClickListener(this);
            new j(this.Kd.getContext(), this.Kc, this);
            new j(this.Kd.getContext(), this.Ke, this);
            new j(this.Kd.getContext(), this.Kf, this);
            new j(this.Kd.getContext(), this.Kg, this);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        w(view);
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        w(view);
    }

    private void w(View view) {
        if (view == this.Kc) {
            this.HX.c(2, view.getContext(), 104, 2);
            return;
        }
        if (view == this.Kd) {
            this.HX.c(2, view.getContext(), 26, 1);
            return;
        }
        if (view == this.Ke) {
            this.HX.c(2, view.getContext(), 15, 2);
        } else if (view == this.Kf) {
            this.HX.c(2, view.getContext(), 16, 2);
        } else if (view == this.Kg) {
            this.HX.c(2, view.getContext(), 17, 2);
        }
    }
}
