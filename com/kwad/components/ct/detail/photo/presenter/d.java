package com.kwad.components.ct.detail.photo.presenter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.components.core.u.s;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.utils.bv;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.detail.b {
    private ScaleAnimSeekBar akC;
    private com.kwad.components.ct.detail.e.a aoz;
    private ViewGroup aqG;
    private ImageView avr;
    private ViewGroup avs;
    private TextView avt;
    private TextView avu;
    private boolean avv;
    private long avw;
    private boolean avx = false;
    private Runnable avy = new Runnable() { // from class: com.kwad.components.ct.detail.photo.presenter.d.1
        @Override // java.lang.Runnable
        public final void run() {
            if (d.this.avx) {
                return;
            }
            d.this.AW();
        }
    };
    private Runnable avz = new s(this.avy);
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.presenter.d.2
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qz();
            d.this.AS();
            d.this.AT();
        }
    };
    private com.kwad.sdk.widget.swipe.a aqH = new com.kwad.sdk.widget.swipe.b() { // from class: com.kwad.components.ct.detail.photo.presenter.d.3
        @Override // com.kwad.sdk.widget.swipe.b, com.kwad.sdk.widget.swipe.a
        public final void j(float f) {
            d.this.i(f);
        }
    };
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.photo.presenter.d.4
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            if (j != 0) {
                d.this.avw = j;
                int i = (int) (((j2 * 1.0f) * 10000.0f) / j);
                if (d.this.avx || !d.this.akC.isFinished()) {
                    return;
                }
                d.this.akC.setProgress(i);
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            d.this.avx = false;
            d.this.AU();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            d.this.avx = true;
            if (d.this.avr.getVisibility() == 0) {
                d.this.AX();
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            d.this.avx = false;
            d.this.AU();
            d.this.AY();
        }
    };
    private ScaleAnimSeekBar.a avA = new ScaleAnimSeekBar.a() { // from class: com.kwad.components.ct.detail.photo.presenter.d.5
        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
            if (z) {
                d.this.AR();
            }
        }

        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public final void wF() {
            d.this.aqG.setVisibility(8);
            d.this.AR();
            d.this.AX();
        }

        @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
        public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
            d.this.aqG.setVisibility(0);
            d.this.AS();
            d.this.AV();
            d.this.AY();
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.avr = (ImageView) findViewById(R.id.ksad_video_control_button);
        this.aqG = (ViewGroup) findViewById(R.id.ksad_video_bottom_container);
        this.avs = (ViewGroup) findViewById(R.id.ksad_video_seek_tip_layout);
        this.avt = (TextView) findViewById(R.id.ksad_video_seek_progress);
        this.avu = (TextView) findViewById(R.id.ksad_video_seek_duration);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_video_seek_bar);
        this.akC = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(10000);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = this.aop.mAdTemplate;
        long jLongValue = com.kwad.components.ct.response.a.c.f((PhotoInfo) com.kwad.components.ct.response.a.a.ay(ctAdTemplate)).longValue();
        this.avw = jLongValue;
        if (jLongValue < 30000 || com.kwad.components.ct.response.a.c.F(ctAdTemplate.photoInfo) || (com.kwad.components.ct.response.a.a.aW(ctAdTemplate) && this.aop.aol.mKSTubeParam.hideDetailPlaySeekbar)) {
            AS();
            AT();
            return;
        }
        this.avv = true;
        this.aoz = this.aop.aoz;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.akC.getLayoutParams();
        marginLayoutParams.bottomMargin = this.aop.aol.aHi;
        this.akC.setLayoutParams(marginLayoutParams);
        AS();
        AT();
        i(this.aop.aok.getSourceType() == 0 ? 1.0f : 0.0f);
        this.akC.setOnSeekBarChangeListener(this.avA);
        this.aop.aoq.add(this.aoQ);
        this.aoz.c(this.mVideoPlayStateListener);
        this.aop.aot.add(this.aqH);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.avv) {
            this.akC.removeCallbacks(this.avz);
            this.akC.setOnSeekBarChangeListener(null);
            this.akC.setVisibility(8);
            this.aop.aoq.remove(this.aoQ);
            this.aoz.d(this.mVideoPlayStateListener);
            this.aop.aot.remove(this.aqH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(float f) {
        this.akC.setAlpha(f);
        this.akC.setThumbEnable(f == 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AR() {
        this.avt.setText(bv.aP((this.avw * this.akC.getProgress()) / ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT));
        if (this.avs.getVisibility() == 0) {
            return;
        }
        this.avu.setText(bv.aP(this.avw));
        this.avs.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS() {
        this.avs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AT() {
        this.akC.setProgress(0);
        this.akC.setVisibility(8);
        AW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AU() {
        if (this.akC.getVisibility() == 0) {
            return;
        }
        this.akC.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AV() {
        this.aoz.seekTo((this.avw * this.akC.getProgress()) / ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AW() {
        AZ();
        this.akC.cC(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AX() {
        AZ();
        this.akC.cC(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AY() {
        AZ();
        this.akC.postDelayed(this.avz, 4000L);
    }

    private void AZ() {
        this.akC.removeCallbacks(this.avz);
    }
}
