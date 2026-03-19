package com.kwad.components.ad.splashscreen.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.bx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends e implements com.kwad.sdk.core.j.c {
    private TextView HP;
    private com.kwad.components.ad.splashscreen.widget.b HQ;
    private AdInfo.AdPreloadInfo HR;
    private boolean HS = false;
    private View HT;
    private AdInfo xq;

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onBind");
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate);
        this.xq = adInfoEP;
        t(adInfoEP);
        v(this.xq);
        if (u(this.xq)) {
            this.HQ = (com.kwad.components.ad.splashscreen.widget.b) findViewById(com.kwad.components.ad.splashscreen.e.c.z(this.xq) ? R.id.ksad_splash_skip_right_view : R.id.ksad_splash_skip_left_view);
        } else {
            this.HQ = (com.kwad.components.ad.splashscreen.widget.b) findViewById(com.kwad.components.ad.splashscreen.e.c.z(this.xq) ? R.id.ksad_splash_circle_skip_right_view : R.id.ksad_splash_circle_skip_left_view);
        }
        this.HQ.a(me(), this.xq);
        this.HQ.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.c.1
            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void mi() throws JSONException {
                c.this.mf();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void mj() {
                c.this.mg();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void am(int i) {
                c.this.HX.al(i);
            }
        });
        w(this.xq);
        this.HX.Hk.a(this);
    }

    private void t(AdInfo adInfo) {
        findViewById(com.kwad.components.ad.splashscreen.e.c.z(adInfo) ? R.id.ksad_splash_right_top_root : R.id.ksad_splash_left_top_root).setVisibility(0);
    }

    private SplashSkipViewModel me() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        int i = this.xq.adSplashInfo.imageDisplaySecond <= 0 ? 5 : this.xq.adSplashInfo.imageDisplaySecond;
        int iMin = Math.min(this.xq.adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.b.a.M(this.xq));
        if (com.kwad.sdk.core.response.b.a.bi(this.xq)) {
            i = iMin;
        }
        splashSkipViewModel.skipSecond = i;
        return splashSkipViewModel;
    }

    private static boolean u(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.b.a.cP(adInfo);
    }

    private void v(AdInfo adInfo) {
        int i;
        if (com.kwad.components.ad.splashscreen.e.c.z(adInfo)) {
            i = R.id.ksad_splash_preload_right_tips;
        } else {
            i = R.id.ksad_splash_preload_left_tips;
        }
        this.HP = (TextView) findViewById(i);
        AdInfo.AdPreloadInfo adPreloadInfo = adInfo.adPreloadInfo;
        this.HR = adPreloadInfo;
        if (adPreloadInfo != null && !bq.isNullString(adPreloadInfo.preloadTips)) {
            this.HP.setVisibility(0);
            this.HP.setText(this.HR.preloadTips);
        } else {
            this.HP.setVisibility(8);
        }
    }

    private void w(AdInfo adInfo) {
        this.HT = findViewById(R.id.ksad_skip_view_area);
        if (com.kwad.sdk.core.response.b.a.cQ(adInfo) && adInfo.adSplashInfo.skipButtonPosition == 0) {
            this.HT.setVisibility(0);
            this.HT.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.c.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws JSONException {
                    c.this.mf();
                }
            });
            this.HT.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    ((View) c.this.HQ).post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            int iAo = c.this.HQ.ao(35);
                            ViewGroup.LayoutParams layoutParams = c.this.HT.getLayoutParams();
                            layoutParams.width = iAo + com.kwad.sdk.c.a.a.a(c.this.HX.mRootContainer.getContext(), 66.0f);
                            c.this.HT.setLayoutParams(layoutParams);
                        }
                    });
                }
            });
            return;
        }
        this.HT.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mf() throws JSONException {
        com.kwad.components.ad.splashscreen.monitor.a.mb().ai(this.HX.mAdTemplate);
        this.HX.lW();
        JSONObject jSONObject = new JSONObject();
        if (this.HX.Hi != null) {
            try {
                jSONObject.put("duration", this.HX.Hi.getCurrentPosition());
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        a.C0576a c0576a = new a.C0576a();
        if (this.HX.mTimerHelper != null) {
            c0576a.duration = this.HX.mTimerHelper.getTime();
        }
        com.kwad.sdk.core.adlog.c.b(this.HX.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().eQ(1).eY(22).b(c0576a), jSONObject);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.HX.Hk.b(this);
        bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.HQ != null) {
                    c.this.HQ.cv();
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageVisible");
        this.HQ.B(this.xq);
        mh();
    }

    public final void mg() {
        this.HX.mRootContainer.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.c.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.pe()) {
                    c.this.HX.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.HX.lU();
                }
            }
        });
    }

    private synchronized void mh() {
        if (!this.HS && this.HQ != null) {
            if (com.kwad.sdk.core.response.b.a.cR(this.xq) && com.kwad.sdk.core.response.b.a.cS(this.xq)) {
                com.kwad.sdk.core.adlog.c.b(this.HX.mAdTemplate, 124, (JSONObject) null);
                this.HS = true;
            }
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageInvisible");
        this.HQ.A(this.xq);
    }
}
