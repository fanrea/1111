package com.kwad.components.ad.reward.presenter.d.a;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.k;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements at.b {
    private TailFrameView AP;
    private volatile boolean AQ;
    private boolean AR;
    private k AS;
    private Drawable AV;
    private com.kwad.components.ad.l.b fs;
    private AdInfo mAdInfo;
    private DetailVideoView mDetailVideoView;
    private boolean ye = false;
    private int AT = Integer.MIN_VALUE;
    private int AU = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            b.this.jL();
            if (b.this.AP == null || !g.Q(b.this.mAdTemplate)) {
                return;
            }
            b.this.AP.le();
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.2
        @Override // com.kwad.components.ad.reward.e.a, com.kwad.components.ad.reward.e.g
        public final int getPriority() {
            return -1;
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void dc() {
            if ((!e.eY(b.this.mAdTemplate) && b.this.ye && !b.this.vb.gU()) || b.this.vb.tV || b.this.vb.ub) {
                return;
            }
            b.this.AR = true;
            if (b.this.fs != null && b.this.fs.bb()) {
                b.this.AR = false;
            }
            b.this.vb.um = true ^ b.this.AR;
            if (b.this.AR) {
                if (b.this.vb.tx != null) {
                    com.kwad.components.ad.reward.monitor.c.a(b.this.vb.mAdTemplate, b.this.vb.tI, "end_card", com.kwad.sdk.core.response.b.b.dh(b.this.mAdTemplate), System.currentTimeMillis() - b.this.vb.tx.getLoadTime(), 1);
                }
                b.this.bs();
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.AP = (TailFrameView) findViewById(R.id.ksad_video_tail_frame);
        DetailVideoView detailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.vb.tv != null) {
            this.vb.tv.a(this);
        }
        this.mAdInfo = e.eP(this.mAdTemplate);
        this.fs = this.vb.tx;
        this.vb.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.gp().a(this.mRewardVerifyListener);
        this.AP.setCallerContext(this.vb);
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playend_native_jinniu);
        if (viewStub != null) {
            this.AS = new k(this.vb, viewStub);
        } else {
            this.AS = new k(this.vb, (ViewGroup) findViewById(R.id.ksad_reward_jinniu_end_card_root));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jL() {
        if (this.AQ) {
            return;
        }
        jM();
    }

    private void jM() {
        com.kwad.sdk.core.d.c.d("RewardPlayEndNativeCardPresenter", "initTailView");
        this.AP.a(getContext(), this.vb.mScreenOrientation == 0, jO());
        this.AQ = true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.vb.tv != null) {
            this.vb.tv.b(this);
        }
        com.kwad.components.ad.reward.b.gp().b(this.mRewardVerifyListener);
        jN();
        this.vb.c(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i = this.AU;
            if (i != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i);
            }
            com.kwad.sdk.core.d.c.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.AT);
            int i2 = this.AT;
            if (i2 != Integer.MIN_VALUE) {
                ad(i2);
            }
            Drawable drawable = this.AV;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
    }

    private void ad(int i) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    private void jN() {
        if (this.AR) {
            jL();
            this.AP.destroy();
            this.AP.setVisibility(8);
            this.AS.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs() {
        jL();
        this.AP.a(new com.kwad.components.ad.reward.widget.tailframe.b() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.3
            @Override // com.kwad.components.ad.reward.widget.tailframe.b
            public final void O(boolean z) {
                b.this.L(z);
            }
        });
        this.AP.setVisibility(0);
    }

    private boolean jO() {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBb = com.kwad.sdk.core.response.b.a.bb(this.mAdInfo);
        return materialFeatureBb.height > materialFeatureBb.width;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(boolean z) {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", (String) null, new com.kwad.sdk.core.adlog.c.b().f(this.vb.mRootContainer.getTouchCoords()).eP(z ? 2 : 153), this.vb.mReportExtData);
        this.vb.tt.db();
    }

    @Override // com.kwad.components.core.webview.jshandler.at.b
    public final void a(at.a aVar) {
        this.ye = aVar.isSuccess();
    }
}
