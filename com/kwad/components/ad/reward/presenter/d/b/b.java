package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private View Bb;
    private boolean Bc;
    private final Runnable Bd = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.d.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            if (b.this.getActivity() == null || b.this.getActivity().isFinishing()) {
                return;
            }
            b.this.jT();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View viewFindViewById = findViewById(R.id.ksad_end_close_btn);
        this.Bb = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Bc = com.kwad.sdk.core.response.b.b.ez(e.eP(this.vb.mAdTemplate));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Bb.setVisibility(8);
        bx.d(this.Bd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jT() {
        com.kwad.sdk.core.d.c.d("RewardPlayEndCloseBtn", "showPageCloseBtn mPlayEndH5ShowSuccess: " + this.vb.um + ", needHideCloseButton: " + this.Bc);
        if (this.vb.um && this.Bc) {
            return;
        }
        this.Bb.setVisibility(0);
        this.Bb.setAlpha(0.0f);
        this.Bb.animate().alpha(1.0f).setDuration(500L).start();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.Bb) {
            PlayableSource playableSourceGT = this.vb.gT();
            if (playableSourceGT != null && (playableSourceGT.equals(PlayableSource.PENDANT_CLICK_NOT_AUTO) || playableSourceGT.equals(PlayableSource.PENDANT_CLICK_AUTO) || playableSourceGT.equals(PlayableSource.PENDANT_AUTO) || playableSourceGT.equals(PlayableSource.ACTIONBAR_CLICK))) {
                com.kwad.components.ad.reward.a.gl().gm();
            } else {
                f.v(this.vb);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void jS() {
        if (this.vb.tV) {
            return;
        }
        long j = this.vb.ug;
        if (j == 0) {
            this.Bd.run();
        } else {
            bx.runOnUiThreadDelay(this.Bd, j);
        }
    }
}
