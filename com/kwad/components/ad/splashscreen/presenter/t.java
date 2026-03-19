package com.kwad.components.ad.splashscreen.presenter;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class t extends e implements com.kwad.sdk.core.j.c {
    private SkipView JM;
    private ImageView lV;
    private AdInfo mAdInfo;
    private volatile boolean JJ = false;
    private boolean JK = false;
    private boolean JL = false;
    private i.a lW = new i.a() { // from class: com.kwad.components.ad.splashscreen.presenter.t.1
        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeReleased() {
        }

        @Override // com.kwad.sdk.utils.i.a
        public final void onAudioBeOccupied() {
            t.this.JJ = false;
            if (t.this.lV != null) {
                t.this.lV.post(new bh() { // from class: com.kwad.components.ad.splashscreen.presenter.t.1.1
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        if (t.this.HX.Hi != null) {
                            t.this.HX.Hi.setAudioEnabled(t.this.JJ, false);
                        }
                        if (t.this.HX != null) {
                            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(t.this.HX.mAdTemplate);
                            String str = t.this.JJ ? adInfoEP.adSplashInfo.speakerIconUrl : adInfoEP.adSplashInfo.speakerMuteIconUrl;
                            if (!TextUtils.isEmpty(str)) {
                                KSImageLoader.loadImage(t.this.lV, str, t.this.HX.mAdTemplate);
                            } else {
                                t.this.lV.setImageDrawable(t.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                            }
                            t.this.lV.setSelected(false);
                        }
                    }
                });
            }
        }
    };
    private com.kwad.components.core.video.n JN = new com.kwad.components.core.video.o() { // from class: com.kwad.components.ad.splashscreen.presenter.t.2
        private boolean JQ = false;
        private String JR = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.HF);

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPaused() {
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPlaying() {
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, final long j2) {
            t.this.HX.al(((int) j2) / 1000);
            final int iMin = Math.min(t.this.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j) / 1000);
            final String str = this.JR;
            t tVar = t.this;
            if (t.a(tVar, tVar.mAdInfo)) {
                t.this.JM.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.t.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = (int) (((iMin * 1000) - j2) / 1000);
                        if (i <= 0) {
                            i = 1;
                        }
                        t.this.JM.ae(str + i);
                    }
                });
            }
            float f = j2 / 1000.0f;
            if (iMin <= 0 || f + 0.5d <= iMin - 1 || this.JQ) {
                return;
            }
            t tVar2 = t.this;
            if (t.a(tVar2, tVar2.mAdInfo)) {
                t.this.HX.lU();
                this.JQ = true;
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            if (t.this.HX.Hi != null) {
                t.this.HX.Hi.setAudioEnabled(t.this.JJ, false);
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            if (t.this.JK) {
                return;
            }
            t.this.HX.af(false);
            if (t.this.HX.Hi != null) {
                t.this.HX.Hi.ag(true);
                t.this.HX.Hi.setAudioEnabled(t.this.JJ, true);
            }
            t.b(t.this, true);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            if (this.JQ) {
                return;
            }
            t.this.HX.lU();
            this.JQ = true;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            if (t.this.HX != null && t.this.HX.Hi != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                com.kwad.components.ad.splashscreen.monitor.b.md();
                com.kwad.components.ad.splashscreen.monitor.b.b(t.this.HX.mAdTemplate, 1, t.this.HX.Hi.Id, 2, jElapsedRealtime - t.this.HX.Hi.Le, jElapsedRealtime - t.this.HX.mAdTemplate.showTime);
            }
            if (t.this.JL || t.this.HX == null) {
                return;
            }
            t.this.HX.c(0, "onMediaPlayError");
        }
    };

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
    }

    static /* synthetic */ boolean a(t tVar, AdInfo adInfo) {
        return u(adInfo);
    }

    static /* synthetic */ boolean b(t tVar, boolean z) {
        tVar.JK = true;
        return true;
    }

    private void a(final DetailVideoView detailVideoView) {
        final View viewFindViewById = findViewById(R.id.splash_play_card_view);
        viewFindViewById.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.t.3
            @Override // java.lang.Runnable
            public final void run() {
                float width = viewFindViewById.getWidth();
                float height = viewFindViewById.getHeight();
                if (width <= 0.0f || height <= 0.0f) {
                    return;
                }
                if (com.kwad.sdk.core.response.b.a.aZ(t.this.mAdInfo).videoWidth > 0) {
                    com.kwad.sdk.c.a.a.b(detailVideoView, r0.width, r0.height);
                }
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        int i;
        super.ay();
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate);
        DetailVideoView detailVideoView = (DetailVideoView) this.HX.mRootContainer.findViewById(R.id.ksad_splash_video_player);
        detailVideoView.setVisibility(0);
        if (com.kwad.sdk.core.response.b.a.dB(this.mAdInfo)) {
            a(detailVideoView);
        }
        if (this.HX.Hi != null) {
            this.HX.Hi.b(this.JN);
        }
        this.HX.Hk.a(this);
        AdBaseFrameLayout adBaseFrameLayout = this.HX.mRootContainer;
        if (com.kwad.components.ad.splashscreen.e.c.z(this.mAdInfo)) {
            i = R.id.ksad_splash_skip_right_view;
        } else {
            i = R.id.ksad_splash_skip_left_view;
        }
        this.JM = (SkipView) adBaseFrameLayout.findViewById(i);
        if (u(this.mAdInfo)) {
            a(this.JM, this.mAdInfo);
        }
        int i2 = this.mAdInfo.adSplashInfo.mute;
        if (i2 == 2) {
            this.JJ = true;
        } else if (i2 == 3) {
            this.JJ = com.kwad.sdk.utils.m.df(this.HX.mRootContainer.getContext()) > 0;
        } else {
            this.JJ = false;
        }
        if (com.kwad.components.core.u.a.aC(getContext()).to()) {
            this.JJ = false;
        }
        if (this.HX.Hi != null) {
            this.HX.Hi.setAudioEnabled(this.JJ, false);
            this.HX.Hi.a(this.lW);
        }
        this.lV = (ImageView) this.HX.mRootContainer.findViewById(R.id.ksad_splash_sound);
        if (com.kwad.components.ad.splashscreen.e.c.z(this.mAdInfo)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.lV.getLayoutParams();
            layoutParams.gravity = 51;
            this.lV.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.lV.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(this.lV.getContext(), 32.0f);
                marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(this.lV.getContext(), 16.0f);
            }
        }
        this.lV.setVisibility(0);
        String str = this.JJ ? this.mAdInfo.adSplashInfo.speakerIconUrl : this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
        if (!TextUtils.isEmpty(str)) {
            KSImageLoader.loadImage(this.lV, str, this.HX.mAdTemplate);
        } else {
            this.lV.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
        }
        this.lV.setSelected(this.JJ);
        this.lV.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.t.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.this.JJ = !r4.JJ;
                String str2 = t.this.JJ ? t.this.mAdInfo.adSplashInfo.speakerIconUrl : t.this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                if (!TextUtils.isEmpty(str2)) {
                    KSImageLoader.loadImage(t.this.lV, str2, t.this.HX.mAdTemplate);
                } else {
                    t.this.lV.setImageDrawable(t.this.getContext().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                }
                t.this.lV.setSelected(t.this.JJ);
                t.this.HX.Hi.setAudioEnabled(t.this.JJ, true);
            }
        });
    }

    private static boolean u(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.b.a.cP(adInfo);
    }

    private static void a(SkipView skipView, AdInfo adInfo) {
        skipView.setTimerBtnVisible(com.kwad.sdk.core.response.b.a.cS(adInfo));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.HX.Hi != null) {
            this.HX.Hi.a(this.JN);
            this.HX.Hi.b(this.lW);
        }
        if (this.JM.getHandler() != null) {
            this.JM.getHandler().removeCallbacksAndMessages(null);
        }
        this.HX.Hk.b(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.JL = true;
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        if (this.HX.Hi != null) {
            this.HX.Hi.pause();
        }
    }
}
