package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView AE;
    private ImageView lV;
    private i.a lW = new i.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1
        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (d.this.lV == null || com.kwad.components.ad.reward.a.b.hG()) {
                return;
            }
            d.this.lV.post(new bh() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.1.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    d.this.lV.setSelected(false);
                    d.this.vb.tu.setAudioEnabled(false, false);
                }
            });
        }
    };
    private com.kwad.components.ad.reward.m.c AF = new com.kwad.components.ad.reward.m.c() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.d.2
        @Override // com.kwad.components.ad.reward.m.c
        public final void jF() {
            d.this.jD();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lV = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.AE = (ImageView) findViewById(R.id.ksad_reward_deep_task_sound_switch);
        jE();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.vb.a(this.AF);
        this.vb.tu.a(this.lW);
        dr();
    }

    private void dr() {
        ImageView imageView;
        int i = 0;
        if (iF()) {
            this.lV.setVisibility(8);
            imageView = this.AE;
        } else {
            this.lV.setVisibility(g.Q(this.mAdTemplate) ? 8 : 0);
            imageView = this.AE;
            if (!g.Q(this.mAdTemplate)) {
            }
            imageView.setVisibility(i);
        }
        i = 8;
        imageView.setVisibility(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jD() {
        KsVideoPlayConfig ksVideoPlayConfig = this.vb.mVideoPlayConfig;
        boolean zIsVideoSoundEnable = true;
        if (!this.vb.ts && com.kwad.components.core.u.a.aC(getContext()).to()) {
            this.AE.setSelected(true);
            this.vb.d(false, false);
            zIsVideoSoundEnable = false;
        } else if (ksVideoPlayConfig != null) {
            zIsVideoSoundEnable = ksVideoPlayConfig.isVideoSoundEnable();
            this.AE.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.vb.d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.AE.setSelected(true);
            this.vb.d(true, true);
        }
        this.lV.setSelected(zIsVideoSoundEnable);
        this.vb.tu.setAudioEnabled(zIsVideoSoundEnable, false);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.tu.b(this.lW);
        this.vb.b(this.AF);
    }

    private void jE() {
        this.lV.setOnClickListener(this);
        this.AE.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.lV) {
            this.vb.tu.setAudioEnabled(!this.lV.isSelected(), true);
            this.lV.setSelected(!r3.isSelected());
        } else if (view == this.AE) {
            this.vb.tu.setAudioEnabled(!this.AE.isSelected(), true);
            this.AE.setSelected(!r3.isSelected());
        }
    }
}
