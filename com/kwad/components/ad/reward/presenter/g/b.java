package com.kwad.components.ad.reward.presenter.g;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.c;
import com.kwad.components.ad.reward.n.f;
import com.kwad.components.ad.reward.n.q;
import com.kwad.sdk.R;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.e;
import com.kwad.sdk.widget.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements c.a, com.kwad.sdk.app.a, com.kwad.sdk.core.webview.d.a.a, e {
    private static float Cb = 0.4548105f;
    private ViewGroup BU;
    private q BV;
    private ViewGroup BW;
    private com.kwad.components.ad.reward.n.e BX;
    private c BY;
    private c BZ;
    private AdInfo mAdInfo;
    private com.kwad.components.ad.reward.l.b.a uc;
    private int Cc = 15;
    private long Cd = -1;
    private boolean Ce = false;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.g.b.3
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (b.this.BY != null && g.Q(b.this.vb.mAdTemplate)) {
                b.this.BY.le();
            }
            if (b.this.BZ != null) {
                b.this.BZ.le();
            }
        }
    };
    private com.kwad.sdk.core.c.c Cf = new d() { // from class: com.kwad.components.ad.reward.presenter.g.b.4
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            b.this.X(true);
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            b.this.X(false);
        }
    };

    @Override // com.kwad.sdk.app.a
    public final void X(String str) {
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() throws Resources.NotFoundException {
        super.ay();
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onBind");
        if (g.O(this.vb.mAdTemplate)) {
            this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.vb.mAdTemplate);
            this.Cc = com.kwad.components.ad.reward.a.b.hF();
            com.kwad.sdk.core.c.b.aaf();
            com.kwad.sdk.core.c.b.a(this.Cf);
            com.kwad.components.ad.reward.b.gp().a(this.mRewardVerifyListener);
            this.uc = com.kwad.components.ad.reward.l.d.kM();
            this.vb.uc = this.uc;
            com.kwad.components.ad.reward.l.b.a.a(this.uc, getContext(), this.vb.mAdTemplate);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_activity_apk_info_area_native);
            this.BU = viewGroup;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                c cVar = new c(this.BU);
                this.BZ = cVar;
                cVar.a(this.vb.mApkDownloadHelper);
                this.BZ.a(this);
                this.BZ.c(this.vb.mAdTemplate, false);
                ((KSFrameLayout) findViewById(R.id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                q qVar = new q((KsAdWebView) findViewById(R.id.ksad_right_area_webview), this.BU, this.vb.mApkDownloadHelper, this);
                this.BV = qVar;
                qVar.a(this.vb.mAdTemplate, adBaseFrameLayout);
            }
            com.kwad.sdk.app.b.Wd().a(this);
            a(adBaseFrameLayout);
        }
    }

    private void a(AdBaseFrameLayout adBaseFrameLayout) throws Resources.NotFoundException {
        getContext();
        if (!aq.apb()) {
            com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(R.id.ksad_reward_apk_info_stub)).inflate();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        this.BW = viewGroup;
        viewGroup.setClickable(true);
        new j(this.BW, this);
        final KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(R.id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        final float dimension = getContext().getResources().getDimension(R.dimen.ksad_reward_apk_info_card_height);
        kSFrameLayout.post(new bh() { // from class: com.kwad.components.ad.reward.presenter.g.b.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                kSFrameLayout.getHeight();
            }
        });
        this.BW = (ViewGroup) findViewById(R.id.ksad_reward_apk_info_card_native_container);
        c cVar = new c(this.BW);
        this.BY = cVar;
        cVar.a(this.vb.mApkDownloadHelper);
        this.BY.a(this);
        this.BY.c(this.vb.mAdTemplate, false);
        com.kwad.components.ad.reward.n.e eVar = new com.kwad.components.ad.reward.n.e((KsAdWebView) findViewById(R.id.ksad_reward_apk_info_card_h5), this.BW, this.vb.mApkDownloadHelper, this);
        this.BX = eVar;
        eVar.a(new f() { // from class: com.kwad.components.ad.reward.presenter.g.b.2
            @Override // com.kwad.components.ad.reward.n.f
            public final void i(String str, int i) {
                com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onUpdateDownloadProgress downloadStatus: " + com.kwad.sdk.core.response.b.e.eP(b.this.vb.mAdTemplate).status);
                b.this.BY.j(str, i);
            }
        });
        this.BX.a(this.vb.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "onUnbind");
        com.kwad.sdk.core.c.b.aaf();
        com.kwad.sdk.core.c.b.b(this.Cf);
        com.kwad.components.ad.reward.b.gp().b(this.mRewardVerifyListener);
        com.kwad.sdk.app.b.Wd().b(this);
        com.kwad.components.ad.reward.n.e eVar = this.BX;
        if (eVar != null) {
            eVar.lg();
            this.BX = null;
        }
        c cVar = this.BZ;
        if (cVar != null) {
            cVar.ld();
        }
        this.vb.uc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(boolean z) {
        com.kwad.components.ad.reward.l.b.a aVar;
        com.kwad.components.ad.reward.l.b.a.a(this.uc, getContext(), this.vb.mAdTemplate);
        if (!this.uc.kU()) {
            if (z) {
                Y(false);
            }
        } else {
            if (z) {
                boolean zKr = kr();
                if (zKr && (aVar = this.uc) != null) {
                    aVar.kT();
                    com.kwad.components.ad.reward.b.gp().notifyRewardVerify();
                    this.vb.tt.onRewardVerify();
                }
                Y(zKr);
                return;
            }
            this.Cd = System.currentTimeMillis();
        }
    }

    private void Y(boolean z) {
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "showTaskToast hasShowCompletedToast: " + this.Ce + " completed: " + z);
        if (this.Ce) {
            return;
        }
        ac.d(getContext(), z ? "恭喜！任务达标啦，成功获取奖励~" : "哎呀，差一点就达标啦，再试一次~", 0);
        if (z) {
            this.Ce = true;
        }
    }

    private boolean kr() {
        com.kwad.sdk.core.d.c.d("LaunchAppTaskPresenter", "checkUseAppTime appBackgroundTimestamp: " + this.Cd);
        return this.Cd >= 0 && System.currentTimeMillis() - this.Cd > ((long) (this.Cc * 1000));
    }

    @Override // com.kwad.components.ad.reward.n.c.a
    public final void d(boolean z, int i) {
        this.vb.b(1, getContext(), z ? 1 : 153, 1);
    }

    @Override // com.kwad.sdk.app.a
    public final void W(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.b.a.aB(this.mAdInfo), str) && this.vb.uc != null && g.O(this.vb.mAdTemplate)) {
            this.vb.uc.kR();
            com.kwad.sdk.core.c.b.aaf();
            if (com.kwad.sdk.core.c.b.isAppOnForeground()) {
                return;
            }
            this.Cd = System.currentTimeMillis();
        }
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        Z(true);
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eE(this.vb.mAdTemplate)) {
            Z(false);
        }
    }

    private void Z(boolean z) {
        this.vb.a(1, getContext(), z ? 1 : 153, 1);
    }
}
