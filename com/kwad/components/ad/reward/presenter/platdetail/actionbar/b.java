package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.n.h;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.video.o;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private ValueAnimator gJ;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private RewardActionBarControl tw;
    private KsLogoView xE;
    private ActionBarAppLandscape zF;
    private ActionBarAppPortrait zG;
    private ActionBarH5 zH;
    private boolean zJ;
    private ViewGroup zK;
    private ViewGroup zL;
    private ViewGroup zM;
    private h zN;
    private boolean zO;
    private boolean zI = false;
    private final o xI = new o() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.j
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.zO = true;
            if (!com.kwad.sdk.core.response.b.a.df(b.this.mAdInfo) || b.this.zM == null) {
                return;
            }
            b.this.zM.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.zO = false;
            if (!com.kwad.sdk.core.response.b.a.df(b.this.mAdInfo) || b.this.zM == null) {
                return;
            }
            b.this.zM.setVisibility(0);
        }
    };
    private RewardActionBarControl.b zP = new RewardActionBarControl.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z, a aVar) {
            b.this.zJ = true;
            b.this.a(z, aVar);
        }
    };
    private g zQ = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            b.this.zJ = false;
            b.this.M(false);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.xE = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
        this.zH = (ActionBarH5) findViewById(R.id.ksad_video_play_bar_h5);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.vb.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.vb.tu.a(this.xI);
        dr();
    }

    private void dr() {
        if (com.kwad.sdk.core.response.b.a.cZ(this.mAdInfo)) {
            this.zK = (ViewGroup) findViewById(R.id.ksad_reward_jinniu_root);
        }
        this.xE.aQ(this.mAdTemplate);
        this.mApkDownloadHelper = this.vb.mApkDownloadHelper;
        RewardActionBarControl rewardActionBarControl = this.vb.tw;
        this.tw = rewardActionBarControl;
        rewardActionBarControl.a(this.zP);
        this.vb.b(this.zQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.tw;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.b) null);
        }
        this.vb.tu.b(this.xI);
        this.vb.c(this.zQ);
        bq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, a aVar) {
        ViewGroup viewGroup;
        if (this.zI) {
            return;
        }
        this.zI = true;
        this.xE.setVisibility(com.kwad.sdk.core.response.b.a.df(this.mAdInfo) ? 8 : 0);
        getContext();
        final boolean z2 = !aq.apb();
        if (com.kwad.sdk.core.response.b.a.bj(this.mAdInfo)) {
            if (this.zN == null) {
                h hVar = new h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
                    @Override // com.kwad.components.ad.reward.n.h
                    public final int jn() {
                        if (z2) {
                            return R.id.ksad_common_app_card_land_stub;
                        }
                        return super.jn();
                    }
                };
                this.zN = hVar;
                hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jo() {
                        b.this.vb.a(1, b.this.getContext(), 29, 1);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jp() {
                        b.this.vb.a(1, b.this.getContext(), 30, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jq() {
                        b.this.vb.a(1, b.this.getContext(), 31, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jr() {
                        b.this.vb.a(1, b.this.getContext(), 32, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void js() {
                        b.this.vb.a(1, b.this.getContext(), 84, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jt() {
                        b.this.vb.a(1, b.this.getContext(), 53, 2);
                    }
                });
                this.zN.f((ViewGroup) getRootView());
                this.zN.b(r.a(this.mAdTemplate, this.mApkDownloadHelper));
            }
            this.zN.show();
            RewardActionBarControl.a(aVar, this.zN.hT(), RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cr(this.mAdInfo) == 1 && (viewGroup = this.zK) != null) {
            viewGroup.setVisibility(0);
            RewardActionBarControl.a(aVar, this.zK, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_JINNIU);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.df(this.mAdInfo)) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.ksad_reward_origin_live_root);
            this.zM = viewGroup2;
            if (viewGroup2 != null) {
                if (!this.zO) {
                    viewGroup2.setVisibility(0);
                }
                RewardActionBarControl.a(aVar, this.zM, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORIGIN_LIVE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.b.a.cE(this.mAdTemplate)) {
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.ksad_reward_live_subscribe_root);
            this.zL = viewGroup3;
            if (viewGroup3 != null) {
                Resources resources = viewGroup3.getResources();
                f(this.zL, (int) (resources.getDimension(R.dimen.ksad_live_subscribe_card_full_height) + resources.getDimension(R.dimen.ksad_live_subscribe_card_margin)));
                RewardActionBarControl.a(aVar, this.zL, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_LIVE_SUBSCRIBE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            if (this.vb.mScreenOrientation == 1) {
                b(z, aVar);
                return;
            } else {
                c(z, aVar);
                return;
            }
        }
        d(z, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(boolean z) {
        if (this.zI) {
            this.zI = false;
            this.xE.setVisibility(8);
            ViewGroup viewGroup = this.zK;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.zM;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            if (!com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
                if (z) {
                    h(this.zH, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
                    return;
                } else {
                    this.zH.setVisibility(8);
                    return;
                }
            }
            if (this.vb.mScreenOrientation == 1) {
                if (z) {
                    jl();
                    return;
                } else {
                    jm();
                    return;
                }
            }
            if (z) {
                ActionBarAppPortrait actionBarAppPortrait = this.zG;
                if (actionBarAppPortrait != null) {
                    h(actionBarAppPortrait, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
                    return;
                }
                return;
            }
            ActionBarAppPortrait actionBarAppPortrait2 = this.zG;
            if (actionBarAppPortrait2 != null) {
                actionBarAppPortrait2.setVisibility(8);
            }
        }
    }

    private void b(boolean z, a aVar) {
        jj();
        this.zF.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
            public final void O(boolean z2) {
                b.this.N(z2);
            }
        });
        if (z) {
            g(this.zF, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.zF.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.zF, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void c(boolean z, a aVar) {
        jk();
        this.zG.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
            public final void O(boolean z2) {
                b.this.N(z2);
            }
        });
        if (z) {
            g(this.zG, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.zG.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.zG, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void jj() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar_landscape);
        if (viewStub != null) {
            this.zF = (ActionBarAppLandscape) viewStub.inflate();
        } else {
            this.zF = (ActionBarAppLandscape) findViewById(R.id.ksad_video_play_bar_app_landscape);
        }
    }

    private void jk() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar);
        if (viewStub != null) {
            this.zG = (ActionBarAppPortrait) viewStub.inflate();
        } else {
            this.zG = (ActionBarAppPortrait) findViewById(R.id.ksad_video_play_bar_app_portrait);
        }
    }

    private void d(boolean z, a aVar) {
        this.zH.a(this.mAdTemplate, new ActionBarH5.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
            public final void O(boolean z2) {
                b.this.N(z2);
            }
        });
        if (z) {
            g(this.zH, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.zH.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.zH, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void f(final View view, int i) {
        bq();
        view.setVisibility(0);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ValueAnimator valueAnimatorC = com.kwad.components.core.u.r.c(view, i, 0);
        this.gJ = valueAnimatorC;
        valueAnimatorC.setInterpolator(interpolatorCreate);
        this.gJ.setDuration(500L);
        this.gJ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.gJ.start();
    }

    @Deprecated
    private void g(final View view, int i) {
        bq();
        view.setVisibility(0);
        ValueAnimator valueAnimatorB = com.kwad.components.core.u.r.b(view, 0, i);
        this.gJ = valueAnimatorB;
        valueAnimatorB.setInterpolator(new DecelerateInterpolator(2.0f));
        this.gJ.setDuration(500L);
        this.gJ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.gJ.start();
    }

    private void h(final View view, int i) {
        bq();
        view.setVisibility(0);
        ValueAnimator valueAnimatorB = com.kwad.components.core.u.r.b(view, i, 0);
        this.gJ = valueAnimatorB;
        valueAnimatorB.setInterpolator(new DecelerateInterpolator(2.0f));
        this.gJ.setDuration(300L);
        this.gJ.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        this.gJ.start();
    }

    private void jl() {
        jk();
        g(this.zG, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
    }

    private void jm() {
        ActionBarAppPortrait actionBarAppPortrait = this.zG;
        if (actionBarAppPortrait != null) {
            actionBarAppPortrait.setVisibility(8);
        }
    }

    private void bq() {
        ValueAnimator valueAnimator = this.gJ;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.gJ.cancel();
        }
    }

    protected final void N(boolean z) {
        com.kwad.components.ad.reward.j.b.a(this.vb.mAdTemplate, "native_id", (String) null, new com.kwad.sdk.core.adlog.c.b().f(this.vb.mRootContainer.getTouchCoords()).eP(z ? 1 : 153), this.vb.mReportExtData);
        this.vb.tt.db();
    }
}
