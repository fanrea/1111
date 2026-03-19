package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.m;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.cb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, cb.a {
    private static final String[] As = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
    private TextView Ao;
    private ImageView Ap;
    private View Aq;
    private cb dC;
    private TextView lM;
    private boolean lO;
    private long lP;
    private AdInfo mAdInfo;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean Ar = false;
    private boolean At = false;
    private boolean Au = false;
    private final o lv = new o() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) throws Resources.NotFoundException {
            long jA = g.a(j, a.this.mAdInfo);
            a.this.lP = j2;
            a.this.a(jA, j2);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.j
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.lO) {
                return;
            }
            a.this.dC.sendEmptyMessageDelayed(1, 500L);
        }
    };
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.2
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            a.a(a.this, true);
            a.this.Ao.setText(a.As[2]);
        }
    };

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.At = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lM = (TextView) findViewById(R.id.ksad_video_count_down);
        this.Ap = (ImageView) findViewById(R.id.ksad_detail_reward_icon);
        this.Ao = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down);
        this.Aq = findViewById(R.id.ksad_detail_reward_deep_task_view);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.dC = new cb(this);
        dr();
        if (this.vb.tu.la()) {
            G((int) (com.kwad.sdk.core.response.b.a.ai(this.mAdInfo) / 1000.0f));
        }
    }

    private void dr() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
        this.mApkDownloadHelper = this.vb.mApkDownloadHelper;
        long jA = g.a(com.kwad.sdk.core.response.b.a.N(this.mAdInfo), this.mAdInfo) / 1000;
        if (g.Q(this.mAdTemplate)) {
            this.Aq.setVisibility(0);
            this.Aq.setOnClickListener(this);
            this.Ao.setText(String.format(As[0], Long.valueOf(jA)));
            this.lM.setVisibility(8);
        } else {
            this.Aq.setVisibility(8);
            this.lM.setText(String.valueOf(jA));
            this.lM.setVisibility(0);
            this.lM.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.b.gp().a(this.mRewardVerifyListener);
        this.vb.tu.a(this.lv);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.gp().b(this.mRewardVerifyListener);
        this.vb.tu.b(this.lv);
        this.Ap.setVisibility(8);
        this.Aq.setVisibility(8);
        this.Ar = false;
        this.At = false;
        this.lO = false;
    }

    public final void a(long j, long j2) throws Resources.NotFoundException {
        int iAO;
        if (com.kwad.sdk.core.response.b.a.aS(this.mAdInfo) && com.kwad.components.core.s.a.sX().sY() == 0) {
            iAO = com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
        } else {
            iAO = com.kwad.sdk.core.response.b.a.aO(this.mAdInfo);
        }
        long j3 = iAO * (this.vb.tL ? 1000 : 0);
        m.b(this.vb, j2, j, j3);
        if (!this.Au) {
            this.Au = k.a(this.vb, j2, j, j3);
        }
        a(j2, j, j3);
    }

    private void a(long j, long j2, long j3) throws Resources.NotFoundException {
        if (j < (j2 - 800) - j3) {
            int iFloor = (int) Math.floor((j2 - j) / 1000.0f);
            int i = iFloor > 0 ? iFloor : 1;
            G(i);
            if (this.vb.tU != null) {
                this.vb.tU.ah(i);
                return;
            }
            return;
        }
        this.vb.tO = true;
        if (g.Q(this.mAdTemplate)) {
            if (g.O(this.mAdTemplate) && this.vb.uc != null) {
                if (!this.vb.uc.kP()) {
                    this.vb.uc.kO();
                }
            } else if (g.P(this.mAdTemplate) && this.vb.ud != null && !this.vb.ud.kP()) {
                this.vb.ud.kO();
            }
            if (this.At) {
                return;
            }
            this.Ao.setText(As[1]);
            jA();
            return;
        }
        notifyRewardVerify();
        jz();
        if (this.vb.tU != null) {
            this.vb.tU.ah(0);
        }
    }

    private void G(int i) {
        this.vb.ue = i;
        if (g.Q(this.mAdTemplate)) {
            if (this.At) {
                return;
            }
            this.Ao.setText(String.format(As[0], Integer.valueOf(i)));
            return;
        }
        this.lM.setText(String.valueOf(i));
    }

    private void jz() {
        if (this.Ar) {
            return;
        }
        this.Ar = true;
        this.Ap.setAlpha(0.0f);
        this.Ap.setVisibility(0);
        this.Ap.setOnClickListener(this);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.lM.setVisibility(8);
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.lM.setAlpha(1.0f - fFloatValue);
                a.this.Ap.setAlpha(fFloatValue);
            }
        });
        valueAnimatorOfFloat.start();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.Ap || view == this.Aq) {
            com.kwad.components.core.e.d.a.a(new a.C0469a(view.getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(2).A(this.vb.tu.getPlayDuration()).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    private void notifyRewardVerify() {
        this.vb.tt.onRewardVerify();
    }

    private void jA() {
        if (this.vb.mAdRewardStepListener != null) {
            this.vb.mAdRewardStepListener.gu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "playTopBar-style1", new com.kwad.sdk.core.adlog.c.b().f(this.vb.mRootContainer.getTouchCoords()).eP(41), this.vb.mReportExtData);
        this.vb.tt.db();
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) throws Resources.NotFoundException {
        if (message.what == 1) {
            if (this.vb.gZ() || this.vb.gY()) {
                this.dC.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.lP += 500;
            a(com.kwad.sdk.core.response.b.a.ai(this.mAdInfo), this.lP);
            this.dC.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
