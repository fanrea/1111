package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private static final String[] Bj = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    private ViewGroup Bf;
    private ImageView Bg;
    private ViewGroup Bh;
    private TextView Bi;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (g.Q(d.this.vb.mAdTemplate)) {
                d.this.jV();
            }
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Bf = (ViewGroup) findViewById(R.id.ksad_end_reward_icon_layout);
        this.Bg = (ImageView) findViewById(R.id.ksad_end_reward_icon);
        this.Bh = (ViewGroup) findViewById(R.id.ksad_detail_reward_deep_task_view_playend);
        this.Bi = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down_playend);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        dr();
    }

    private void dr() {
        com.kwad.components.ad.reward.b.gp().a(this.mRewardVerifyListener);
        this.Bf.setVisibility(0);
        this.Bh.setVisibility(g.Q(this.vb.mAdTemplate) ? 0 : 8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.gp().b(this.mRewardVerifyListener);
        this.Bf.setVisibility(8);
        this.Bg.setVisibility(8);
        this.Bh.setVisibility(8);
    }

    private void jU() {
        ImageView imageView = this.Bg;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.Bg.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.Bf;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.Bf.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jV() {
        this.Bi.setText(Bj[2]);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.Bg || view == this.Bf) {
            com.kwad.components.core.e.d.a.a(new a.C0469a(view.getContext()).aC(this.vb.mAdTemplate).b(this.vb.mApkDownloadHelper).aq(false).aG(2).a(new a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    d.this.notifyAdClick();
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.components.ad.reward.j.b.a(this.vb.mAdTemplate, (String) null, (String) null, new com.kwad.sdk.core.adlog.c.b().f(this.vb.mRootContainer.getTouchCoords()).eP(41), this.vb.mReportExtData);
        this.vb.tt.db();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void jS() {
        if (this.vb.tV) {
            if (com.kwad.sdk.core.response.b.a.au(e.eP(this.vb.mAdTemplate))) {
                this.Bh.setVisibility(8);
            }
        } else if (g.O(this.vb.mAdTemplate) || g.P(this.vb.mAdTemplate)) {
            if (this.vb.ha()) {
                return;
            }
            this.Bi.setText(this.vb.tO ? Bj[1] : Bj[0]);
        } else if (this.vb.ha()) {
            jU();
        }
    }
}
