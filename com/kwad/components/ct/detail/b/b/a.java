package com.kwad.components.ct.detail.b.b;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.components.core.u.s;
import com.kwad.components.core.video.n;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.detail.b;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends b {
    private LottieAnimationView ayS;
    private ViewGroup ayT;
    private TextView ayU;
    private Handler mHandler;
    private boolean ayh = false;
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.b.b.a.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            if (ao.isNetworkConnected(a.this.getContext()) || a.this.aop.aoz.isPlaying()) {
                a.this.ayT.setVisibility(8);
            } else {
                a.this.Cw();
            }
            if (a.this.aop.aoz.isPreparing() && !a.this.ayh) {
                a.this.Cx();
            }
            a.this.ayh = true;
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            a.this.Cv();
            a.this.ayh = false;
        }
    };
    private Runnable ayV = new Runnable() { // from class: com.kwad.components.ct.detail.b.b.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a.this.Cv();
        }
    };
    private Runnable ayW = new s(this.ayV);
    private n mVideoPlayStateListener = new o() { // from class: com.kwad.components.ct.detail.b.b.a.4
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            c.d("DetailLoadingPresenter", "onVideoPlayStart");
            a.this.mHandler.removeCallbacks(a.this.ayW);
            a.this.ayT.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPreparing() {
            super.onMediaPreparing();
            c.d("DetailLoadingPresenter", "onVideoPreparing");
            a.this.Cx();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            c.d("DetailLoadingPresenter", "onVideoPlayBufferingPaused");
            a.this.Cu();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            c.d("DetailLoadingPresenter", "onVideoPlayBufferingPlaying");
            a.this.Cu();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            a.this.mHandler.removeCallbacks(a.this.ayW);
            c.d("DetailLoadingPresenter", "onVideoPlaying");
            a.this.Cv();
            a.this.ayT.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            c.d("DetailLoadingPresenter", "onVideoPlayError");
            a.this.Cv();
            ac.ae(a.this.getContext(), "网络错误");
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.Cv();
            c.d("DetailLoadingPresenter", "onVideoPlayCompleted");
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mHandler = new Handler();
        this.ayT = (ViewGroup) findViewById(R.id.ksad_error_container);
        this.ayU = (TextView) findViewById(R.id.ksad_retry_btn);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_center_loading_animation_view);
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) findViewById(R.id.ksad_bottom_loading_animation_view);
        int i = R.raw.ksad_detail_loading_amin_bottom;
        lottieAnimationView.setVisibility(8);
        lottieAnimationView2.setVisibility(0);
        this.ayS = lottieAnimationView2;
        lottieAnimationView2.setRepeatMode(1);
        this.ayS.setRepeatCount(-1);
        this.ayS.setAnimation(i);
        this.ayS.setRepeatMode(1);
        this.ayS.setRepeatCount(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cu() {
        if (!ao.isNetworkConnected(getContext())) {
            Cv();
            this.ayT.setVisibility(0);
        } else {
            if (this.ayS.getVisibility() == 0 && this.ayS.isAnimating()) {
                return;
            }
            this.ayS.setVisibility(0);
            if (!this.ayS.isAnimating()) {
                this.ayS.PZ();
            }
            this.ayT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cv() {
        LottieAnimationView lottieAnimationView = this.ayS;
        if (lottieAnimationView == null) {
            return;
        }
        if (lottieAnimationView.isAnimating()) {
            this.ayS.Qa();
        }
        this.ayS.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cw() {
        this.ayS.Qa();
        this.ayS.setVisibility(8);
        ac.ae(getContext(), "网络错误");
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        c.d("DetailLoadingPresenter", "onBind");
        this.ayU.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.detail.b.b.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!ao.isNetworkConnected(a.this.getContext())) {
                    ac.ae(a.this.getContext(), "网络错误");
                } else {
                    if (a.this.aop.aoz.isPlaying()) {
                        return;
                    }
                    a.this.aop.aoz.CJ();
                }
            }
        });
        this.aop.aoq.add(this.aoQ);
        this.aop.aoz.c(this.mVideoPlayStateListener);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.aop.aoq.remove(this.aoQ);
        if (this.aop.aoz != null) {
            this.aop.aoz.d(this.mVideoPlayStateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cx() {
        if (ao.isNetworkConnected(getContext())) {
            Cu();
        } else {
            Cv();
        }
        this.mHandler.removeCallbacks(this.ayW);
        this.mHandler.postDelayed(this.ayW, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }
}
