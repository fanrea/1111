package com.kwad.components.ct.tube.panel.choose.a.b;

import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.components.ct.f.d;
import com.kwad.components.ct.f.f;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.widget.KSRelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.tube.panel.choose.a.a.a implements com.kwad.components.ct.f.b {
    private f<b> aDL;
    private RoundAngleImageView aXA;
    private RoundAngleImageView aXB;
    private LottieAnimationView aXC;
    private RoundAngleImageView aXu;
    private FrameLayout aXv;
    private TextView aXw;
    private RoundAngleImageView aXx;
    private KSRelativeLayout aXy;
    private int aXz;
    private TubeEpisode mTubeEpisode;

    private static com.kwad.components.ct.tube.c.a Kj() {
        return ((com.kwad.components.ct.tube.c.b) d.Kb().a(com.kwad.components.ct.tube.c.b.class)).Lc();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KSRelativeLayout kSRelativeLayout = (KSRelativeLayout) getRootView();
        kSRelativeLayout.setRatio(1.34f);
        kSRelativeLayout.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 6.0f));
        this.aXC = (LottieAnimationView) findViewById(R.id.ksad_tube_episode_playing_anim);
        this.aXy = (KSRelativeLayout) findViewById(R.id.ksad_tube_episode_playing_base);
        this.aXv = (FrameLayout) findViewById(R.id.ksad_tube_episode_lock_base);
        this.aXx = (RoundAngleImageView) findViewById(R.id.ksad_tube_episode_lock);
        this.aXw = (TextView) findViewById(R.id.ksad_tube_panel_episode_number);
        this.aXu = (RoundAngleImageView) findViewById(R.id.ksad_tube_episode_cover);
        this.aXA = (RoundAngleImageView) findViewById(R.id.ksad_tube_episode_bottom_cover);
        this.aXB = (RoundAngleImageView) findViewById(R.id.ksad_tube_episode_lock_cover);
        this.aDL = new f<>(this);
        this.aXC.setAnimation(R.raw.ksad_tube_playingdraw);
        this.aXC.setRepeatMode(1);
        this.aXC.setRepeatCount(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.tube.panel.choose.a.a.b) this.cdN).cdM;
        this.mTubeEpisode = com.kwad.components.ct.response.a.c.p(com.kwad.components.ct.response.a.a.ay(ctAdTemplate));
        this.aXz = ((com.kwad.components.ct.tube.panel.choose.a.a.b) this.cdN).aXl.aXr.mPlayingTubeEpisode.episodeNumber;
        d.Kb().a(this.aDL);
        if (this.mTubeEpisode.locked) {
            this.aXx.setVisibility(0);
            this.aXv.setVisibility(0);
            this.aXy.setVisibility(8);
            this.aXC.setVisibility(8);
            this.aXC.Qa();
            this.aXA.setVisibility(8);
        } else if (this.mTubeEpisode.episodeNumber == this.aXz) {
            this.aXy.setVisibility(0);
            this.aXv.setVisibility(0);
            this.aXC.setVisibility(0);
            this.aXC.PZ();
            this.aXx.setVisibility(8);
            this.aXA.setVisibility(8);
        } else {
            this.aXC.setVisibility(8);
            this.aXC.Qa();
            this.aXv.setVisibility(8);
            this.aXA.setVisibility(0);
        }
        this.aXw.setText(com.kwad.components.ct.tube.d.b.b(this.mTubeEpisode));
        KSImageLoader.loadImage(this.aXu, com.kwad.components.ct.response.a.a.aE(ctAdTemplate), com.kwad.components.ct.tube.channel.detail.a.b.b.aWd);
        this.aXu.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 4.0f));
        Ke();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        LottieAnimationView lottieAnimationView = this.aXC;
        if (lottieAnimationView != null) {
            lottieAnimationView.Qa();
        }
        d.Kb().b(this.aDL);
        super.onUnbind();
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        Ke();
    }

    private void Ke() {
        if (this.mTubeEpisode.episodeNumber == this.aXz) {
            g.c(getRootView(), Kj().aZh);
        } else {
            g.c(getRootView(), Kj().aZg);
        }
    }
}
