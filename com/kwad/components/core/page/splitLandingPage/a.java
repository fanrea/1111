package com.kwad.components.core.page.splitLandingPage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.c.b;
import com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView;
import com.kwad.components.core.page.splitLandingPage.view.a;
import com.kwad.components.core.proxy.h;
import com.kwad.components.core.u.r;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bh;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends h {
    private FeedVideoView UP;
    private LinearLayout UQ;
    private SplitScrollWebView WQ;
    private Presenter WR;
    private com.kwad.components.core.page.splitLandingPage.view.a WS;
    private com.kwad.components.core.page.c.a WT;
    private boolean WU;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.WU = false;
        return false;
    }

    public static a aF(AdTemplate adTemplate) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    private void z(View view) {
        this.UQ = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        TextView textView = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ((ImageView) view.findViewById(R.id.ksad_web_tip_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.UQ.setVisibility(8);
            }
        });
        AdInfo adInfoEP = e.eP(this.mAdTemplate);
        boolean zBI = com.kwad.sdk.core.response.b.a.bI(adInfoEP);
        String strBE = com.kwad.sdk.core.response.b.a.bE(adInfoEP);
        if (zBI) {
            this.UQ.setVisibility(0);
            textView.setText(strBE);
            textView.setSelected(true);
            return;
        }
        this.UQ.setVisibility(8);
    }

    public final void setApkDownloadHelper(c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.m.a.b
    public final boolean onBackPressed() {
        SplitScrollWebView splitScrollWebView = this.WQ;
        if (splitScrollWebView != null && splitScrollWebView.canGoBack()) {
            this.WQ.goBack();
            return true;
        }
        if (rU()) {
            return true;
        }
        FeedVideoView feedVideoView = this.UP;
        if (feedVideoView != null) {
            return feedVideoView.wE();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rU() {
        SplitScrollWebView splitScrollWebView = this.WQ;
        if (splitScrollWebView == null || splitScrollWebView.getTranslationY() != 0.0f || this.WU) {
            return false;
        }
        this.WQ.setDisableAnimation(false);
        this.WU = true;
        SplitScrollWebView splitScrollWebView2 = this.WQ;
        Animator animatorA = r.a((View) splitScrollWebView2, (Interpolator) null, 0.0f, splitScrollWebView2.getTranslationY() + this.UP.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        if (com.kwad.sdk.core.config.e.Xz() == 2 && this.WS.isVisible()) {
            this.WS.rW();
            animatorSet.playSequentially(this.WS.aL(false), animatorA);
        } else {
            animatorSet.play(animatorA);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.rV();
                a.this.UP.sa();
                a.a(a.this, false);
            }
        });
        animatorSet.start();
        return true;
    }

    private void j(ViewGroup viewGroup) {
        Presenter presenter = new Presenter();
        this.WR = presenter;
        presenter.ak(viewGroup);
        b bVar = new b();
        bVar.ak(this.WQ);
        com.kwad.components.core.page.c.a aVar = new com.kwad.components.core.page.c.a();
        this.WT = aVar;
        aVar.ak(this.UP);
        this.WR.d(bVar);
        this.WR.d(this.WT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rV() {
        this.WT.nC();
        this.WT.ak(this.UP);
        this.WT.K(new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null));
    }

    public final void rW() {
        this.UP.rW();
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_split_land_page;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.UP = (FeedVideoView) findViewById(R.id.ksad_split_land_ad_feed_video);
        this.WQ = (SplitScrollWebView) findViewById(R.id.ksad_video_webView);
        z(view);
        j(this.pQ);
        initView();
    }

    private void initView() {
        com.kwad.components.core.page.recycle.e eVar = new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null);
        this.WR.K(eVar);
        com.kwad.components.core.page.splitLandingPage.view.a aVar = new com.kwad.components.core.page.splitLandingPage.view.a(this.mContext, new com.kwad.components.core.page.splitLandingPage.a.a(eVar.adTemplate, eVar.QQ));
        this.WS = aVar;
        aVar.a(new a.InterfaceC0482a() { // from class: com.kwad.components.core.page.splitLandingPage.a.3
            @Override // com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC0482a
            public final boolean rX() {
                return a.this.rU();
            }
        });
        this.UP.post(new bh() { // from class: com.kwad.components.core.page.splitLandingPage.a.4
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                a.this.WQ.setTranslationY(a.this.WQ.getTranslationY() + a.this.UP.getHeight());
            }
        });
        this.WQ.setSplitScrollWebViewListener(new SplitScrollWebView.a() { // from class: com.kwad.components.core.page.splitLandingPage.a.5
            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final boolean rY() {
                if (!a.this.WS.rZ() && com.kwad.sdk.core.config.e.Xz() == 2) {
                    return false;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                Animator animatorA = r.a(a.this.WQ, (Interpolator) null, a.this.WQ.getTranslationY(), 0.0f);
                if (com.kwad.sdk.core.config.e.Xz() == 2) {
                    if (!a.this.UP.isComplete()) {
                        animatorSet.playSequentially(animatorA, a.this.WS.aL(true));
                    } else {
                        animatorSet.playTogether(animatorA);
                    }
                } else if (com.kwad.sdk.core.config.e.Xz() == 1) {
                    animatorSet.playTogether(animatorA);
                }
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.UP.rW();
                        if (com.kwad.sdk.core.config.e.Xz() != 2 || a.this.UP.isComplete()) {
                            return;
                        }
                        a.this.WS.sa();
                    }
                });
                animatorSet.start();
                return true;
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final void f(float f) {
                a.this.WQ.setTranslationY(a.this.WQ.getTranslationY() - f);
            }
        });
    }
}
