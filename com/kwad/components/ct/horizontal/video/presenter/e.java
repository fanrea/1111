package com.kwad.components.ct.horizontal.video.presenter;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.widget.KsAdFrameLayout;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.cb;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.horizontal.video.a.a implements cb.a {
    private ImageView Pd;
    private ImageView aFB;
    private ImageView aFw;
    private LottieAnimationView aGt;
    private KsContentPage.ContentItem aLE;
    private com.kwad.components.ct.horizontal.video.b aLG;
    private ImageView aMA;
    private ImageView aMB;
    private TextView aMC;
    private TextView aMD;
    private SeekBar aME;
    private SeekBar aMF;
    private View aMG;
    private View aMH;
    private View aMI;
    private TextView aMJ;
    private long aMK;
    private View aMw;
    private TextView aMx;
    private TextView aMy;
    private View aMz;
    private TextView aOW;
    private com.kwad.components.core.widget.a.b amL;
    private KsAdFrameLayout ave;
    private cb dC;
    private CtAdTemplate mAdTemplate;
    private DetailVideoView mDetailVideoView;
    public long mEnterPlayPosition;
    private GestureDetector mGestureDetector;
    private View mRootView;
    private int mVideoHeight;
    private final int aMu = R.drawable.ksad_horizontal_detail_video_pause_img;
    private final int aMv = R.drawable.ksad_horizontal_detail_video_play_img;
    private boolean aML = false;
    private boolean aMM = false;
    private long aMN = 0;
    private boolean aMO = false;
    private boolean axL = false;
    private boolean aMP = false;
    private o aMT = new o() { // from class: com.kwad.components.ct.horizontal.video.presenter.e.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPrepared() {
            super.onMediaPrepared();
            com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerPresenter", "onVideoPrepared ");
            e.this.Fj();
            e.this.aLG.start();
            e.this.Pd.setVisibility(8);
            e.this.aMJ.setVisibility(8);
            e.this.aMI.setVisibility(8);
            e.this.aMH.setVisibility(8);
            e.this.aMG.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            e.this.aMK = j;
            int i = (int) (((j2 * 1.0f) * 100.0f) / j);
            if (!e.this.aMM) {
                e.this.o(j2, j);
                e eVar = e.this;
                eVar.A(i, eVar.aLG.getBufferPercentage());
            }
            if (j2 == j) {
                e.this.aML = false;
                e.this.Pd.setVisibility(0);
                e.this.aMJ.setVisibility(0);
                e.this.aMI.setVisibility(0);
                e.this.aMH.setVisibility(0);
                e.this.aMG.setVisibility(0);
                e.this.Cd();
                e.this.cB(0);
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() throws Resources.NotFoundException {
            super.onMediaPlayStart();
            e.this.aML = true;
            com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerPresenter", "onVideoPlayStart ");
            e.this.aMA.setImageDrawable(e.this.getContext().getResources().getDrawable(e.this.aMu));
            e.this.aMJ.setVisibility(8);
            e.this.aMI.setVisibility(8);
            e.this.aMH.setVisibility(8);
            e.this.IA();
            e.this.Ca();
            if (e.this.mEnterPlayPosition == 0 || e.this.aLG == null) {
                return;
            }
            e.this.aLG.seekTo(e.this.mEnterPlayPosition);
            e.this.mEnterPlayPosition = 0L;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() throws Resources.NotFoundException {
            super.onMediaPlaying();
            e.this.cD(8);
            e.this.Fj();
            e.this.IA();
            e.this.Cc();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerPresenter", "onVideoPlayPaused ");
            e.this.Fj();
            e.this.aMJ.setVisibility(8);
            e.this.aMI.setVisibility(8);
            e.this.aMH.setVisibility(8);
            if (!e.this.aMM) {
                e.this.aMA.setImageDrawable(e.this.getContext().getResources().getDrawable(e.this.aMv));
            }
            e.this.Cb();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerPresenter", "onVideoPlayCompleted ");
            e.this.Fj();
            e.this.aML = false;
            e.this.dC.removeMessages(6666);
            e.this.Pd.setVisibility(0);
            e.this.aMJ.setVisibility(0);
            e.this.aMI.setVisibility(0);
            e.this.aMH.setVisibility(0);
            e.this.aMG.setVisibility(0);
            e.this.cB(0);
            e.this.Cd();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerPresenter", "onVideoPlayError ");
            super.onMediaPlayError(i, i2);
            e.this.Fj();
            e.this.aML = false;
            e.this.cC(1);
            e.this.cB(0);
            e.this.aMJ.setVisibility(8);
            e.this.aMI.setVisibility(8);
            e.this.v(i, i2);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerPresenter", "onVideoPlayBufferingPlaying ");
            e.this.Fi();
            e.this.aMJ.setVisibility(8);
            e.this.aMI.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            com.kwad.sdk.core.d.c.d("HorizontalVideoPlayerPresenter", "onVideoPlayBufferingPaused ");
            e.this.Fj();
            e.this.aMJ.setVisibility(8);
            e.this.aMI.setVisibility(8);
        }
    };
    private SeekBar.OnSeekBarChangeListener aMV = new SeekBar.OnSeekBarChangeListener() { // from class: com.kwad.components.ct.horizontal.video.presenter.e.4
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                e eVar = e.this;
                eVar.o((long) (((i * 1.0f) * e.this.aMK) / 100.0f), eVar.aMK);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar seekBar) {
            e.this.aMM = true;
            if (e.this.aLG != null) {
                e.this.aLG.pause();
            }
            e.this.dC.removeMessages(6666);
            e.this.aMN = (long) (((seekBar.getProgress() * 1.0f) * e.this.aMK) / 100.0f);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar seekBar) {
            e.this.aMM = false;
            if (e.this.aLG != null) {
                e.this.aLG.resume();
                long progress = (long) (((seekBar.getProgress() * 1.0f) * e.this.aMK) / 100.0f);
                e.this.aMA.setImageDrawable(e.this.getContext().getResources().getDrawable(e.this.aMu));
                e.this.aLG.seekTo(progress);
                e eVar = e.this;
                eVar.o(progress, eVar.aMK);
                e eVar2 = e.this;
                eVar2.p(eVar2.aMN, progress);
                e.this.aMN = 0L;
            }
            e.this.dC.sendEmptyMessageDelayed(6666, 5000L);
        }
    };
    private GestureDetector.SimpleOnGestureListener avg = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.components.ct.horizontal.video.presenter.e.5
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            if (e.this.aML) {
                if (e.this.aLG.isPlaying()) {
                    e.this.aLG.pause();
                    e.this.aMA.setImageDrawable(e.this.getContext().getResources().getDrawable(e.this.aMv));
                } else {
                    e.this.aLG.resume();
                    e.this.aMA.setImageDrawable(e.this.getContext().getResources().getDrawable(e.this.aMu));
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            if (e.this.aML) {
                if (e.this.aMz.getVisibility() == 8) {
                    e.this.cB(1);
                } else {
                    e.this.cB(2);
                }
                return super.onSingleTapUp(motionEvent);
            }
            return super.onSingleTapUp(motionEvent);
        }
    };
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ct.horizontal.video.presenter.e.6
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bz() {
            if (e.this.aLG == null || !e.this.aLG.isPlaying()) {
                return;
            }
            e.this.aLG.pause();
            e.this.aMO = true;
        }

        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void by() {
            super.by();
            if (!e.this.aMO || e.this.aLG == null) {
                return;
            }
            e.this.aLG.resume();
            e.this.aMO = false;
            e.this.aMA.setImageDrawable(e.this.getContext().getResources().getDrawable(e.this.aMu));
        }
    };

    public e() {
        d(new a());
        d(new d());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFB = (ImageView) findViewById(R.id.ksad_horizontal_video_first_frame_bg_img);
        this.aFw = (ImageView) findViewById(R.id.ksad_horizontal_video_first_frame);
        this.mDetailVideoView = (DetailVideoView) findViewById(R.id.ksad_horizontal_video_player);
        this.aMw = findViewById(R.id.ksad_horizontal_detail_video_error_layout);
        this.aMx = (TextView) findViewById(R.id.ksad_horizontal_detail_video_error_content);
        this.aMy = (TextView) findViewById(R.id.ksad_horizontal_detail_video_error_btn);
        this.aMz = findViewById(R.id.ksad_horizontal_detail_video_bottom_controller);
        this.aMA = (ImageView) findViewById(R.id.ksad_horizontal_detail_video_bottom_controller_play);
        this.aMD = (TextView) findViewById(R.id.ksad_horizontal_detail_video_bottom_controller_total_time);
        this.aMC = (TextView) findViewById(R.id.ksad_horizontal_detail_video_bottom_controller_play_time);
        this.aME = (SeekBar) findViewById(R.id.ksad_horizontal_detail_video_bottom_controller_progress);
        this.aMF = (SeekBar) findViewById(R.id.ksad_horizontal_detail_video_bottom_progress);
        this.aGt = (LottieAnimationView) findViewById(R.id.ksad_center_loading_anim);
        this.aMB = (ImageView) findViewById(R.id.ksad_horizontal_video_center_play);
        this.ave = (KsAdFrameLayout) findViewById(R.id.ksad_horizontal_video_container);
        this.aMJ = (TextView) findViewById(R.id.ksad_horizontal_detail_video_replay_btn);
        this.aMG = findViewById(R.id.ksad_horizontal_detail_top_bg);
        this.aMH = findViewById(R.id.ksad_horizontal_detail_bottom_bg);
        this.mRootView = findViewById(R.id.ksad_horizontal_video_player_view);
        this.aMI = findViewById(R.id.ksad_horizontal_detail_total_bg);
        this.aOW = (TextView) findViewById(R.id.ksad_horizontal_detail_video_water_mark);
        this.ave.setClickable(true);
    }

    @Override // com.kwad.components.ct.horizontal.video.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.dC = new cb(this);
        this.mVideoHeight = (com.kwad.sdk.c.a.a.getScreenWidth(getContext()) * 9) / 16;
        this.mEnterPlayPosition = this.aOD.mEnterPlayPosition;
        initView();
        A(this.aOD.mAdTemplate);
        if (this.aOD.aLD != null) {
            this.aOD.aLD.a(this);
        }
        com.kwad.components.core.widget.a.b bVar = this.aOD.aFs;
        this.amL = bVar;
        if (bVar != null) {
            bVar.a(this.gZ);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.aOD.aLD != null) {
            this.aOD.aLD.b(this);
        }
        com.kwad.components.ct.horizontal.video.b bVar = this.aLG;
        if (bVar != null) {
            bVar.d(this.aMT);
        }
        Fj();
        this.dC.removeMessages(6666);
        this.ave.b(this.mGestureDetector);
        com.kwad.components.core.widget.a.b bVar2 = this.amL;
        if (bVar2 != null) {
            bVar2.b(this.gZ);
        }
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        if (message.what == 6666) {
            cB(2);
        }
    }

    @Override // com.kwad.components.ct.horizontal.video.c
    public final void A(CtAdTemplate ctAdTemplate) {
        this.mAdTemplate = ctAdTemplate;
        this.axL = false;
        this.aMP = false;
        this.aMN = 0L;
        this.aMO = false;
        this.aMM = false;
        HC();
    }

    private void B(CtAdTemplate ctAdTemplate) {
        KsContentPage.ContentItem contentItem = new KsContentPage.ContentItem();
        this.aLE = contentItem;
        contentItem.id = al.md5(String.valueOf(com.kwad.components.ct.response.a.a.bg(ctAdTemplate)));
        try {
            this.aLE.videoDuration = com.kwad.components.ct.response.a.a.aB(ctAdTemplate);
            this.aLE.position = ctAdTemplate.getShowPosition();
        } catch (Throwable unused) {
        }
        if (com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
            this.aLE.materialType = 1;
            return;
        }
        if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            this.aLE.materialType = 2;
        } else if (com.kwad.components.ct.response.a.a.au(ctAdTemplate)) {
            this.aLE.materialType = 3;
        } else {
            this.aLE.materialType = 0;
        }
    }

    private void initView() {
        View view;
        if (this.mVideoHeight > 0 && (view = this.mRootView) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.mVideoHeight;
            layoutParams.width = -1;
            this.mRootView.setLayoutParams(layoutParams);
        }
        this.aGt.setRepeatMode(1);
        this.aGt.setRepeatCount(-1);
        com.kwad.components.ct.d.a.Jd().b(this.aGt, false);
        GestureDetector gestureDetector = new GestureDetector(getContext(), this.avg);
        this.mGestureDetector = gestureDetector;
        this.ave.b(gestureDetector);
        this.ave.a(this.mGestureDetector);
        this.aMA.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.video.presenter.e.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (e.this.aLG.isPlaying()) {
                    e.this.aLG.pause();
                    e.this.aMA.setImageDrawable(e.this.getContext().getResources().getDrawable(e.this.aMv));
                } else {
                    e.this.aLG.resume();
                    e.this.aMA.setImageDrawable(e.this.getContext().getResources().getDrawable(e.this.aMu));
                }
            }
        });
        this.aMJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.video.presenter.e.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.this.aOD.aLI = null;
                e.this.aOD.aLH = false;
                com.kwad.components.ct.e.b.JK().q(e.this.mAdTemplate, 1);
                e.this.HC();
            }
        });
        rC();
        this.aMw.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.video.presenter.e.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
            }
        });
    }

    private void rC() {
        ImageView imageView = (ImageView) findViewById(R.id.ksad_horizontal_back_btn);
        this.Pd = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.video.presenter.e.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.getActivity() != null) {
                    e.this.getActivity().onBackPressed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC() {
        cC(0);
        cB(0);
        this.Pd.setVisibility(8);
        this.dC.removeMessages(6666);
        HH();
        HF();
        if (this.aOD.aLD != null && this.aOD.aLD.aOH != null) {
            this.aOD.aLD.aOH.update();
        }
        o(0L, com.kwad.components.ct.response.a.c.f((PhotoInfo) com.kwad.components.ct.response.a.a.ay(this.mAdTemplate)).longValue());
        A(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(int i) {
        if (i == 0) {
            this.aMz.setVisibility(8);
            this.aMA.setVisibility(8);
            this.aMF.setVisibility(8);
        } else if (i == 1) {
            this.aMz.setVisibility(0);
            this.aMA.setVisibility(0);
            this.aMF.setVisibility(8);
            this.Pd.setVisibility(0);
            this.aMG.setVisibility(0);
            this.dC.sendEmptyMessageDelayed(6666, 5000L);
        } else if (i == 2) {
            this.aMz.setVisibility(8);
            this.aMA.setVisibility(8);
            this.Pd.setVisibility(8);
            this.aMG.setVisibility(8);
            this.aMF.setVisibility(0);
        }
        this.aME.setOnSeekBarChangeListener(this.aMV);
        this.aMF.setOnSeekBarChangeListener(this.aMV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(long j, long j2) {
        this.aMC.setText(bv.bN(j));
        this.aMD.setText(bv.bN(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(int i, int i2) {
        this.aMF.setProgress(i);
        this.aMF.setSecondaryProgress(i2);
        this.aME.setProgress(i);
        this.aME.setSecondaryProgress(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(int i) {
        if (i == 0) {
            this.aMw.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.aMw.setVisibility(0);
            this.aMx.setText("播放器出了点问题，请重试");
            this.aMy.setText("点击重试");
            Fj();
            this.aMy.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.video.presenter.e.11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (ao.isNetworkConnected(e.this.getContext())) {
                        e.this.HC();
                    } else {
                        ac.dm(e.this.getContext());
                    }
                }
            });
            return;
        }
        if (i != 2) {
            return;
        }
        com.kwad.components.ct.e.b.JK().j(this.aOD.mAdTemplate, 0);
        this.aMw.setVisibility(0);
        this.aMx.setText("当前在移动网络下，可能会产生流量费用");
        this.aMy.setText("继续播放");
        Fj();
        this.aMy.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.video.presenter.e.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.Fi();
                e.this.cC(0);
                com.kwad.components.ct.horizontal.b.a.Ir();
                if (e.this.aLG != null) {
                    e.this.aLG.bY(false);
                }
                com.kwad.components.ct.e.b.JK().i(e.this.aOD.mAdTemplate, 0);
            }
        });
    }

    public final void Fi() {
        this.aGt.setVisibility(0);
        if (this.aGt.isAnimating()) {
            return;
        }
        this.aGt.PZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj() {
        if (this.aGt.isAnimating()) {
            this.aGt.Qa();
        }
        this.aGt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(int i) {
        this.aFB.setVisibility(i);
        this.aFw.setVisibility(i);
    }

    private void HF() {
        this.aMK = 0L;
        if (this.mAdTemplate == null) {
            return;
        }
        com.kwad.components.ct.horizontal.video.b bVar = this.aLG;
        if (bVar != null) {
            if (bVar.isPlaying()) {
                this.aLG.pause();
            }
            this.aLG.bZ(true);
        }
        B(this.mAdTemplate);
        this.mDetailVideoView.setVideoInfo(this.mAdTemplate.photoInfo.videoInfo);
        this.mDetailVideoView.setHorizontalVideo(true);
        this.aLG = new com.kwad.components.ct.horizontal.video.b(this.aOD.aoy, this.mDetailVideoView, this.mAdTemplate);
        this.aOD.aLG = this.aLG;
        this.aLG.c(this.aMT);
        if (!ao.isNetworkConnected(getContext())) {
            cC(1);
            cB(0);
            return;
        }
        if (com.kwad.components.ct.horizontal.b.a.Is() && !ao.isWifiConnected(getContext())) {
            this.aMB.setVisibility(0);
            return;
        }
        cC(0);
        Fi();
        com.kwad.components.ct.horizontal.video.b bVar2 = this.aLG;
        if (bVar2 != null) {
            bVar2.bY(false);
            this.mAdTemplate.mMediaPlayerType = this.aLG.getMediaPlayerType();
        }
    }

    private void HH() {
        if (this.mAdTemplate == null) {
            return;
        }
        if (ao.isWifiConnected(getContext())) {
            this.aFw.setBackgroundColor(-16777216);
            this.aFB.setBackgroundColor(-16777216);
            cD(0);
            IB();
            return;
        }
        cD(0);
        IB();
        String url = com.kwad.components.ct.response.a.a.aD(this.mAdTemplate).getUrl();
        if (TextUtils.isEmpty(url)) {
            url = com.kwad.components.ct.response.a.a.aT(this.mAdTemplate);
        }
        com.kwad.sdk.glide.c.h(this.aOD.aoy).hh(com.kwad.components.ct.response.a.a.be(this.mAdTemplate)).d(new ColorDrawable(Color.parseColor("#000000"))).f(new ColorDrawable(Color.parseColor("#000000"))).b(this.aFB);
        com.kwad.sdk.glide.c.h(this.aOD.aoy).hh(url).a(new com.kwad.components.ct.b.a(url, this.mAdTemplate)).d(new ColorDrawable(Color.parseColor("#000000"))).f(new ColorDrawable(Color.parseColor("#000000"))).b(this.aFw);
        if (!ao.isWifiConnected(getContext())) {
            this.aFw.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.video.presenter.e.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.this.aMB.setVisibility(8);
                    if (!com.kwad.components.ct.horizontal.b.a.Is() || ao.isWifiConnected(e.this.getContext())) {
                        e.this.cC(0);
                        com.kwad.components.ct.horizontal.b.a.Ir();
                        if (e.this.aLG == null || e.this.aLG.isPreparing()) {
                            return;
                        }
                        e.this.aLG.bY(false);
                        e.this.mAdTemplate.mMediaPlayerType = e.this.aLG.getMediaPlayerType();
                        return;
                    }
                    e.this.cC(2);
                    e.this.cB(0);
                }
            });
        } else {
            this.aFw.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IA() throws Resources.NotFoundException {
        Drawable drawable;
        if (this.aOW == null) {
            return;
        }
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.mAdTemplate);
        int i = ctPhotoInfoAy.baseInfo.contentSourceType;
        if (i == 0) {
            drawable = getContext().getResources().getDrawable(R.drawable.ksad_water_logo);
            this.aOW.setTextSize(14.0f);
        } else if (i != 6) {
            drawable = null;
        } else {
            drawable = getContext().getResources().getDrawable(R.drawable.ksad_horizontal_detail_kuaikandian_water_mark);
            this.aOW.setTextSize(11.0f);
        }
        if (drawable == null) {
            this.aOW.setVisibility(8);
            return;
        }
        CtPhotoInfo.AuthorInfo authorInfo = ctPhotoInfoAy.authorInfo;
        String string = authorInfo.kwaiId;
        if (TextUtils.isEmpty(string)) {
            string = authorInfo.authorId == 0 ? null : new StringBuilder().append(authorInfo.authorId).toString();
        }
        if (TextUtils.isEmpty(string)) {
            this.aOW.setVisibility(8);
            return;
        }
        this.aOW.setVisibility(0);
        this.aOW.setText(String.format("＠%s", string));
        this.aOW.setCompoundDrawablePadding(com.kwad.sdk.c.a.a.a(getContext(), 2.0f));
        this.aOW.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private void IB() {
        TextView textView = this.aOW;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ca() {
        KsContentPage.VideoListener next;
        Iterator<KsContentPage.VideoListener> it = this.aOD.Hq().iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            next.onVideoPlayStart(this.aLE);
        }
        this.axL = false;
        this.aMP = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cb() {
        KsContentPage.VideoListener next;
        this.axL = true;
        Iterator<KsContentPage.VideoListener> it = this.aOD.Hq().iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            next.onVideoPlayPaused(this.aLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cc() {
        KsContentPage.VideoListener next;
        if (this.axL) {
            Iterator<KsContentPage.VideoListener> it = this.aOD.Hq().iterator();
            while (it.hasNext() && (next = it.next()) != null) {
                next.onVideoPlayResume(this.aLE);
            }
        }
        this.axL = false;
        this.aMP = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cd() {
        if (this.aMP) {
            return;
        }
        Iterator<KsContentPage.VideoListener> it = this.aOD.Hq().iterator();
        while (it.hasNext()) {
            it.next().onVideoPlayCompleted(this.aLE);
        }
        this.aMP = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, int i2) {
        Iterator<KsContentPage.VideoListener> it = this.aOD.Hq().iterator();
        while (it.hasNext()) {
            it.next().onVideoPlayError(this.aLE, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, long j2) {
        int i = j < j2 ? 2 : 1;
        com.kwad.components.ct.e.b.JK().a(this.mAdTemplate, i, Math.abs(j2 - j) / 1000, j, 0);
    }
}
