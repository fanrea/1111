package com.kwad.components.ad.fullscreen.c.a;

import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView lV;
    private i.a lW = new i.a() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1
        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            if (c.this.lV == null || com.kwad.components.ad.reward.a.b.hG()) {
                return;
            }
            c.this.lV.post(new bh() { // from class: com.kwad.components.ad.fullscreen.c.a.c.1.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    c.this.lV.setSelected(false);
                    c.this.vb.tu.setAudioEnabled(false, false);
                }
            });
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        ImageView imageView = (ImageView) findViewById(R.id.ksad_video_sound_switch);
        this.lV = imageView;
        imageView.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        dr();
    }

    private void dr() {
        this.lV.setVisibility(0);
        KsVideoPlayConfig ksVideoPlayConfig = this.vb.mVideoPlayConfig;
        if (!this.vb.ts && com.kwad.components.core.u.a.aC(getContext()).to()) {
            this.lV.setSelected(false);
            this.vb.d(false, false);
        } else if (ksVideoPlayConfig != null) {
            this.lV.setSelected(ksVideoPlayConfig.isVideoSoundEnable());
            this.vb.d(ksVideoPlayConfig.isVideoSoundEnable(), ksVideoPlayConfig.isVideoSoundEnable());
        } else {
            this.lV.setSelected(true);
            this.vb.d(true, true);
        }
        this.vb.tu.a(this.lW);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.tu.b(this.lW);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.lV) {
            this.vb.tu.setAudioEnabled(!this.lV.isSelected(), true);
            this.lV.setSelected(!r3.isSelected());
        }
    }
}
