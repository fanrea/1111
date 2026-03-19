package com.kwad.components.ct.detail.ad.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.detail.b {
    private SlidePlayViewPager aok;
    private View apc;
    private ComplianceTextView fv;
    private TextView lM;
    private CtAdTemplate mAdTemplate;
    private boolean apd = false;
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.ad.presenter.e.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            if (e.this.mAdTemplate.isDrawAdHasLook) {
                int iA = e.a(e.this, com.kwad.components.ct.home.config.b.ac(e.this.mAdTemplate.posId) * 1000, j2, j);
                if (iA <= 0) {
                    e.this.bp(false);
                } else {
                    e.this.G(iA);
                }
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            e.this.bp(false);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            e.this.bp(false);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPaused() {
            e.this.bp(false);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPlaying() {
            e.this.bp(false);
        }
    };
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ct.detail.ad.presenter.e.3
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void by() {
            if (e.this.mAdTemplate.isDrawAdHasLook || !com.kwad.sdk.core.response.b.a.bo(com.kwad.components.ct.response.a.a.eP(e.this.aop.mAdTemplate))) {
                return;
            }
            e.this.mAdTemplate.isDrawAdHasLook = true;
            com.kwad.sdk.core.adlog.c.b(e.this.mAdTemplate, 161, (JSONObject) null);
            e.this.bp(true);
            e eVar = e.this;
            eVar.G(com.kwad.components.ct.home.config.b.ac(eVar.mAdTemplate.posId));
        }
    };

    static /* synthetic */ int a(e eVar, long j, long j2, long j3) {
        return b(j, j2, j3);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.apc = findViewById(R.id.ksad_content_draw_ad_forcelook_title_info);
        this.lM = (TextView) findViewById(R.id.ksad_content_draw_forcelook_count_down);
        this.fv = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (com.kwad.sdk.core.response.b.a.aT(com.kwad.components.ct.response.a.a.eP(this.aop.mAdTemplate))) {
            this.fv.postDelayed(new Runnable() { // from class: com.kwad.components.ct.detail.ad.presenter.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    int iJ = com.kwad.sdk.c.a.a.j(e.this.getContext(), R.dimen.ksad_content_feed_force_look_padding);
                    e eVar = e.this;
                    eVar.bA(eVar.fv.getMeasuredHeight() + iJ);
                }
            }, 300L);
        } else {
            bA(0);
        }
        this.mAdTemplate = this.aop.mAdTemplate;
        this.aok = this.aop.aok;
        this.aop.aoz.c(this.mVideoPlayStateListener);
        this.aop.aoz.c(this.gZ);
    }

    private static int b(long j, long j2, long j3) {
        return (int) (((Math.min(j, j3) - j2) / 1000.0f) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(boolean z) {
        if (this.apd) {
            this.apc.setVisibility(z ? 0 : 8);
        }
        this.aok.h(!z, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(int i) {
        this.lM.setText(String.format(getContext().getString(R.string.ksad_draw_ad_force_look_count_down_format), new StringBuilder().append(i).toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(int i) {
        int statusBarHeight = this.aop.aol.aGL + 0;
        if (com.kwad.components.core.u.e.e(getActivity())) {
            statusBarHeight += com.kwad.sdk.c.a.a.getStatusBarHeight(getContext());
        }
        if (statusBarHeight >= 0) {
            int iJ = com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_content_detail_ad_margin_top);
            if (this.apc.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.apc.getLayoutParams();
                marginLayoutParams.topMargin = iJ + statusBarHeight + i;
                this.apc.setLayoutParams(marginLayoutParams);
                this.apc.setVisibility(0);
            }
        }
        this.apd = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aop.aoz != null) {
            this.aop.aoz.d(this.mVideoPlayStateListener);
            this.aop.aoz.d(this.gZ);
        }
    }
}
