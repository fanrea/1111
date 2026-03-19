package com.kwad.components.ct.horizontal.feed.item.presenter.play;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.o;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.widget.KsAdFrameLayout;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.cb;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.horizontal.feed.item.a.b implements cb.a {
    private static boolean axI = false;
    private TextView Pc;
    private ImageView Pd;
    private TextView aEI;
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
    private com.kwad.components.core.widget.a.b amL;
    private KsAdFrameLayout ave;
    private bw ayY;
    private bw ayZ;
    private volatile long azl;
    private cb dC;
    private CtAdTemplate mAdTemplate;
    private DetailVideoView mDetailVideoView;
    private GestureDetector mGestureDetector;
    private View mRootView;
    private int mVideoHeight;
    private l zg;
    private final int aMu = R.drawable.ksad_horizontal_feed_video_pause_img;
    private final int aMv = R.drawable.ksad_horizontal_feed_video_play_img;
    private boolean aML = false;
    private boolean aMM = false;
    private long aMN = 0;
    private boolean aMO = false;
    private boolean axL = false;
    private boolean aMP = false;
    private boolean om = false;
    private boolean azi = false;
    private boolean aMQ = false;
    private boolean aMR = false;
    private boolean azk = true;
    private boolean aza = false;
    private int aMS = 0;
    private g aMo = new g() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.1
        @Override // com.kwad.components.ct.horizontal.feed.item.presenter.play.g
        public final void start(boolean z) {
            if (f.this.aLG == null || ((!f.this.axL && !z) || f.this.om)) {
                try {
                    f.this.HG();
                    return;
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    return;
                }
            }
            if (f.this.aLG.isPlaying()) {
                return;
            }
            f.this.aLG.resume();
        }

        @Override // com.kwad.components.ct.horizontal.feed.item.presenter.play.g
        public final void bW(boolean z) {
            if (f.this.aLG != null && f.this.aLG.isPlaying()) {
                f.this.aLG.pause();
            }
            if (z) {
                if (f.this.aLG != null && f.this.aLG.isPreparing()) {
                    f.this.aLG.release();
                    f.this.Fj();
                }
                f.this.aMB.setVisibility(0);
                f.this.aEI.setVisibility(0);
                f.this.cB(0);
                f.this.cC(0);
                f.this.i(0, true);
                f.this.HH();
                f.this.HE();
            }
        }

        @Override // com.kwad.components.ct.horizontal.feed.item.presenter.play.g
        public final void cA(int i) {
            long jAqq = f.this.ayY.aqq();
            long jAqq2 = f.this.ayZ.aqq();
            f.this.HH();
            f.this.b(jAqq, jAqq2, i);
        }
    };
    private o aMT = new o() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.6
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPrepared() {
            super.onMediaPrepared();
            com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", "onVideoPrepared ");
            f.this.Fj();
            f.this.aLG.start();
            f.this.aMH.setVisibility(8);
            f.this.cB(2);
            f.this.HE();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            f.this.aMK = j;
            int i = (int) (((j2 * 1.0f) * 100.0f) / j);
            if (!f.this.aMM) {
                f.this.o(j2, j);
                f fVar = f.this;
                fVar.A(i, fVar.aLG.getBufferPercentage());
            }
            if (j2 == j) {
                f.this.aML = false;
                f.this.aMH.setVisibility(0);
                f.this.i(0, true);
                f.this.Cd();
                f.this.cB(0);
                f.b(f.this, true);
                if (!f.this.aMQ) {
                    f.this.HD();
                }
                f.this.HL();
            }
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            f.this.aML = true;
            com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", "onVideoPlayStart ");
            f.this.aMA.setImageDrawable(f.this.getContext().getResources().getDrawable(f.this.aMu));
            f.this.aMH.setVisibility(8);
            f.this.HE();
            f.this.cC(0);
            f.this.Ca();
            f.this.aEI.setVisibility(8);
            f.this.aMB.setVisibility(8);
            f.this.i(8, false);
            if (f.this.ayZ.AI()) {
                f.this.ayZ.AG();
            }
            f.this.azk = false;
            f.this.azl = SystemClock.elapsedRealtime();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            f.this.aML = true;
            f.this.cD(8);
            f.this.HE();
            f.this.aEI.setVisibility(8);
            f.this.aMB.setVisibility(8);
            f.this.Fj();
            f.this.Cc();
            f.this.CE();
            f.this.Cz();
            f.this.azl = SystemClock.elapsedRealtime();
            if (f.this.azi && f.this.azk) {
                com.kwad.components.ct.e.b.JK().d(f.this.mAdTemplate, ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).aLK.aLP ? 1 : 0, com.kwad.components.core.video.c.ub().ue());
            }
            if (f.this.ayZ.AI()) {
                f.this.ayZ.AG();
                if (f.axI) {
                    com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", " onVideoPlaying resumeTiming playDuration: " + f.this.ayZ.getTime());
                }
            } else {
                f.this.ayZ.startTiming();
                if (f.axI) {
                    com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", " onVideoPlaying startTiming playDuration: " + f.this.ayZ.getTime());
                }
            }
            f.this.zg.uC();
            f.this.i(8, false);
            f.this.azk = false;
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", "onVideoPlayPaused ");
            f.this.Fj();
            f.this.aMH.setVisibility(8);
            f.this.HE();
            if (!f.this.aMM) {
                f.this.aMA.setImageDrawable(f.this.getContext().getResources().getDrawable(f.this.aMv));
            }
            f.this.i(0, true);
            if (!f.this.azk) {
                f.this.Cb();
            }
            f.this.azk = true;
            if (f.this.azi) {
                com.kwad.components.ct.e.b.JK().a(((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).aLK.mSceneImpl, f.this.mAdTemplate, f.this.azl > 0 ? SystemClock.elapsedRealtime() - f.this.azl : -1L, ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).aLK.aLP ? 1 : 0, com.kwad.components.core.video.c.ub().ue());
            }
            f.this.ayZ.AH();
            if (f.axI) {
                com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", " onVideoPlayPaused playDuration: " + f.this.ayZ.getTime());
            }
            f.this.zg.uC();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", "onVideoPlayCompleted ");
            f.this.Fj();
            f.this.aML = false;
            f.this.dC.removeMessages(6666);
            f.this.aMH.setVisibility(0);
            f.this.HD();
            f.b(f.this, true);
            f.this.i(0, true);
            f.this.cB(0);
            f.this.Cd();
            f.this.ayZ.AH();
            if (f.axI) {
                com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", " onVideoPlayCompleted playDuration: " + f.this.ayZ.getTime());
            }
            f.b(f.this, true);
            f.this.zg.uC();
            f.this.HL();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayError(int i, int i2) {
            com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", "onVideoPlayError ");
            super.onMediaPlayError(i, i2);
            f.this.Fj();
            f.this.aML = false;
            f.this.cC(1);
            f.this.cB(0);
            f.this.HE();
            f.this.v(i, i2);
            f.this.ayZ.AH();
            f.this.zg.uC();
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPlaying() {
            super.onVideoPlayBufferingPlaying();
            com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", "onVideoPlayBufferingPlaying ");
            f.this.Fi();
            f.this.HE();
            f.this.zg.uB();
            com.kwad.components.ct.e.b bVarJK = com.kwad.components.ct.e.b.JK();
            CtAdTemplate ctAdTemplate = f.this.mAdTemplate;
            boolean z = ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).aLK.aLP;
            bVarJK.e(ctAdTemplate, z ? 1 : 0, com.kwad.components.core.video.c.ub().ue());
        }

        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.n
        public final void onVideoPlayBufferingPaused() {
            super.onVideoPlayBufferingPaused();
            com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", "onVideoPlayBufferingPaused ");
            f.this.Fj();
            f.this.HE();
            f.this.zg.uB();
            com.kwad.components.ct.e.b bVarJK = com.kwad.components.ct.e.b.JK();
            CtAdTemplate ctAdTemplate = f.this.mAdTemplate;
            boolean z = ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).aLK.aLP;
            bVarJK.e(ctAdTemplate, z ? 1 : 0, com.kwad.components.core.video.c.ub().ue());
        }
    };
    private Runnable aMU = new Runnable() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.7
        @Override // java.lang.Runnable
        public final void run() {
            f.this.Pc.setVisibility(8);
            f.this.aMG.setVisibility(8);
        }
    };
    private SeekBar.OnSeekBarChangeListener aMV = new SeekBar.OnSeekBarChangeListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.8
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                f fVar = f.this;
                fVar.o((long) (((i * 1.0f) * f.this.aMK) / 100.0f), fVar.aMK);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar seekBar) {
            f.this.aMM = true;
            if (f.this.aLG != null) {
                f.this.HJ();
            }
            f.this.dC.removeMessages(6666);
            f.this.aMN = (long) (((seekBar.getProgress() * 1.0f) * f.this.aMK) / 100.0f);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar seekBar) {
            f.this.aMM = false;
            if (f.this.aLG != null) {
                long progress = (long) (((seekBar.getProgress() * 1.0f) * f.this.aMK) / 100.0f);
                f.this.aMA.setImageDrawable(f.this.getContext().getResources().getDrawable(f.this.aMu));
                f.this.HI();
                f.this.aLG.seekTo(progress);
                f fVar = f.this;
                fVar.o(progress, fVar.aMK);
                f fVar2 = f.this;
                fVar2.p(fVar2.aMN, progress);
                f.this.aMN = 0L;
            }
            f.this.dC.sendEmptyMessageDelayed(6666, 5000L);
        }
    };
    private GestureDetector.SimpleOnGestureListener avg = new GestureDetector.SimpleOnGestureListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            if (f.this.aML) {
                if (f.this.aLG.isPlaying()) {
                    f.this.HJ();
                    f.this.aMA.setImageDrawable(f.this.getContext().getResources().getDrawable(f.this.aMv));
                } else {
                    f.this.HI();
                    f.this.aMA.setImageDrawable(f.this.getContext().getResources().getDrawable(f.this.aMu));
                }
                return super.onDoubleTap(motionEvent);
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            if (f.this.aML) {
                if (f.this.aMB.getVisibility() != 0) {
                    if (f.this.aMz.getVisibility() == 8) {
                        if (f.this.aLG.isPlaying()) {
                            f.this.aMA.setImageDrawable(f.this.getContext().getResources().getDrawable(f.this.aMu));
                        } else {
                            f.this.aMA.setImageDrawable(f.this.getContext().getResources().getDrawable(f.this.aMv));
                        }
                        f.this.cB(1);
                    } else if (f.this.aLG.isPlaying()) {
                        f.this.i(8, true);
                        f.this.cB(2);
                    }
                    return super.onSingleTapUp(motionEvent);
                }
                return super.onSingleTapUp(motionEvent);
            }
            return super.onSingleTapUp(motionEvent);
        }
    };
    private com.kwad.sdk.core.j.c gZ = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.10
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bz() {
            if (f.this.aLG != null && f.this.aLG.isPlaying()) {
                f.this.HJ();
                f.this.aMO = true;
            }
            f.this.ayY.AH();
        }

        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void by() {
            super.by();
            if (f.this.aMO && f.this.aLG != null) {
                f.this.HI();
                f.this.aMO = false;
                f.this.aMA.setImageDrawable(f.this.getContext().getResources().getDrawable(f.this.aMu));
            }
            if (f.this.ayY.AI()) {
                f.this.ayY.AG();
            } else {
                f.this.ayY.startTiming();
            }
        }
    };

    static /* synthetic */ int ad(f fVar) {
        int i = fVar.aMS;
        fVar.aMS = i + 1;
        return i;
    }

    static /* synthetic */ boolean b(f fVar, boolean z) {
        fVar.om = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cy() {
        this.azi = false;
        this.aMR = false;
        this.azk = false;
        this.om = false;
        this.aMQ = false;
        this.azl = 0L;
        l lVar = this.zg;
        if (lVar != null) {
            lVar.reset();
        }
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
        this.aEI = (TextView) findViewById(R.id.ksad_horizontal_feed_item_video_time);
        this.Pc = (TextView) findViewById(R.id.ksad_horizontal_feed_item_title);
        this.aMJ = (TextView) findViewById(R.id.ksad_horizontal_detail_video_replay_btn);
        this.aMB = (ImageView) findViewById(R.id.ksad_horizontal_video_center_play);
        this.aMG = findViewById(R.id.ksad_horizontal_detail_top_bg);
        this.aMH = findViewById(R.id.ksad_horizontal_detail_bottom_bg);
        this.mRootView = findViewById(R.id.ksad_horizontal_video_player_view);
        this.aMI = findViewById(R.id.ksad_horizontal_detail_total_bg);
        KsAdFrameLayout ksAdFrameLayout = (KsAdFrameLayout) findViewById(R.id.ksad_horizontal_video_container);
        this.ave = ksAdFrameLayout;
        ksAdFrameLayout.setClickable(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.dC = new cb(this);
        this.mVideoHeight = (com.kwad.sdk.c.a.a.getScreenWidth(getContext()) * 9) / 16;
        initView();
        this.ayY = new bw();
        this.ayZ = new bw();
        this.zg = new l();
        A((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM);
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMX.put(Integer.valueOf(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mCurrentPosition), this.cdN);
        com.kwad.components.core.widget.a.b bVar = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aFs;
        this.amL = bVar;
        if (bVar != null) {
            bVar.a(this.gZ);
        }
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLT = this.aMo;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ct.horizontal.video.b bVar = this.aLG;
        if (bVar != null) {
            if (bVar.isPlaying()) {
                this.aLG.pause();
            }
            this.aLG.d(this.aMT);
            this.aLG.release();
        }
        Fj();
        this.dC.removeMessages(6666);
        this.ave.b(this.mGestureDetector);
        com.kwad.components.core.widget.a.b bVar2 = this.amL;
        if (bVar2 != null) {
            bVar2.b(this.gZ);
        }
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMX.remove(Integer.valueOf(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mCurrentPosition));
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLT = null;
        this.ayY.aqq();
        this.ayZ.aqq();
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        com.kwad.components.ct.horizontal.video.b bVar;
        if (message.what == 6666 && (bVar = this.aLG) != null && bVar.isPlaying()) {
            cB(2);
        }
    }

    private void A(CtAdTemplate ctAdTemplate) {
        this.mAdTemplate = ctAdTemplate;
        B(ctAdTemplate);
        this.axL = false;
        this.aMP = false;
        this.aMN = 0L;
        this.aMS = 0;
        this.aMO = false;
        this.aMM = false;
        this.aza = false;
        HC();
        Cy();
        if (this.ayY.AI()) {
            this.ayY.AG();
            if (axI) {
                com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", " onPageVisible resumeTiming stayDuration: " + this.ayY.getTime());
                return;
            }
            return;
        }
        this.ayY.startTiming();
        if (axI) {
            com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", " onPageVisible startTiming stayDuration: " + this.ayY.getTime());
        }
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

    /* JADX WARN: Multi-variable type inference failed */
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
        this.aMA.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (f.this.aLG.isPlaying()) {
                    f.this.HJ();
                    f.this.aMA.setImageDrawable(f.this.getContext().getResources().getDrawable(f.this.aMv));
                } else {
                    f.this.HI();
                    f.this.aMA.setImageDrawable(f.this.getContext().getResources().getDrawable(f.this.aMu));
                }
            }
        });
        this.aMw.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
            }
        });
        rC();
        this.aEI.setText(bv.bN(com.kwad.components.ct.response.a.c.f((PhotoInfo) com.kwad.components.ct.response.a.a.ay((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM)).longValue()));
        this.Pc.setText(com.kwad.components.ct.response.a.a.aN((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM));
        i(0, true);
        this.aMJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                com.kwad.components.ct.e.b.JK().q(f.this.mAdTemplate, 1);
                f.ad(f.this);
                f.this.HC();
                f.this.HI();
                f.this.Cy();
            }
        });
    }

    private void rC() {
        ImageView imageView = (ImageView) findViewById(R.id.ksad_horizontal_back_btn);
        this.Pd = imageView;
        imageView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC() {
        cB(0);
        this.dC.removeMessages(6666);
        HH();
        HF();
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
            i(0, true);
            this.dC.sendEmptyMessageDelayed(6666, 5000L);
            i(8, false);
        } else if (i == 2) {
            this.aMz.setVisibility(8);
            this.aMA.setVisibility(8);
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
    /* JADX WARN: Multi-variable type inference failed */
    public void cC(int i) {
        if (i == 0) {
            this.aMw.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.aMw.setVisibility(0);
            this.aMx.setText("播放器出了点问题，请重试");
            this.aMy.setText("点击重试");
            this.aEI.setVisibility(8);
            i(8, true);
            Fj();
            this.aMy.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (ao.isNetworkConnected(f.this.getContext())) {
                        f.this.HC();
                        f.this.HI();
                    } else {
                        ac.dm(f.this.getContext());
                    }
                }
            });
            return;
        }
        if (i != 2) {
            return;
        }
        com.kwad.components.ct.e.b.JK().j((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM, ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP ? 1 : 0);
        this.aMw.setVisibility(0);
        this.aMx.setText("当前在移动网络下，可能会产生流量费用");
        this.aMy.setText("继续播放");
        this.aEI.setVisibility(8);
        i(8, true);
        Fj();
        this.aMy.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.Fi();
                f.this.aMB.setVisibility(8);
                f.this.cC(0);
                ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).aLK.aNa = true;
                f.this.HI();
                com.kwad.components.ct.e.b.JK().i((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).cdM, ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).aLK.aLP ? 1 : 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i, boolean z) {
        this.Pc.removeCallbacks(this.aMU);
        if (i != 8) {
            this.Pc.setVisibility(i);
            this.aMG.setVisibility(i);
        } else if (z) {
            this.Pc.setVisibility(8);
            this.aMG.setVisibility(8);
        } else {
            this.Pc.postDelayed(this.aMU, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD() {
        if (HK()) {
            this.aMJ.setVisibility(8);
            this.aMI.setVisibility(8);
        } else {
            this.aMJ.setVisibility(0);
            this.aMI.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HE() {
        this.aMJ.setVisibility(8);
        this.aMI.setVisibility(8);
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
        if (!this.aGt.isAnimating()) {
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
            this.aLG.release();
        }
        this.mDetailVideoView.setVideoInfo(this.mAdTemplate.photoInfo.videoInfo);
        this.mDetailVideoView.setHorizontalVideo(true);
        if (!ao.isNetworkConnected(getContext())) {
            cC(1);
            this.aMB.setVisibility(8);
            cB(0);
        } else if (com.kwad.components.ct.horizontal.b.a.Is() && !ao.isWifiConnected(getContext())) {
            this.aMB.setVisibility(0);
            cC(0);
        } else {
            cC(0);
            this.aMB.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HG() {
        Cy();
        com.kwad.components.ct.horizontal.video.b bVar = this.aLG;
        if (bVar != null) {
            if (bVar.isPlaying()) {
                this.aLG.pause();
            }
            this.aLG.release();
        }
        this.aLG = new com.kwad.components.ct.horizontal.video.b(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aoy, this.mDetailVideoView, this.mAdTemplate);
        ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLG = this.aLG;
        this.aLG.c(this.aMT);
        Fi();
        this.aMB.setVisibility(8);
        com.kwad.components.ct.horizontal.video.b bVar2 = this.aLG;
        if (bVar2 != null) {
            bVar2.bY(false);
            this.mAdTemplate.mMediaPlayerType = this.aLG.getMediaPlayerType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HH() {
        if (this.mAdTemplate == null) {
            return;
        }
        cD(0);
        String url = com.kwad.components.ct.response.a.a.aD(this.mAdTemplate).getUrl();
        if (TextUtils.isEmpty(url)) {
            url = com.kwad.components.ct.response.a.a.aT(this.mAdTemplate);
        }
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aoy).hh(com.kwad.components.ct.response.a.a.be(this.mAdTemplate)).d(new ColorDrawable(Color.parseColor("#000000"))).f(new ColorDrawable(Color.parseColor("#000000"))).b(this.aFB);
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aoy).hh(url).a(new com.kwad.components.ct.b.a(url, this.mAdTemplate)).d(new ColorDrawable(Color.parseColor("#000000"))).f(new ColorDrawable(Color.parseColor("#000000"))).b(this.aFw);
        this.aFw.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.aMB.setVisibility(8);
                if (!ao.isNetworkConnected(f.this.getContext())) {
                    f.this.cC(1);
                    f.this.cB(0);
                } else if (ao.isWifiConnected(f.this.getContext())) {
                    f.this.cC(0);
                    ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).aLK.aNa = true;
                    f.this.HI();
                } else if (com.kwad.components.ct.horizontal.b.a.Is()) {
                    f.this.cC(2);
                    f.this.cB(0);
                    f.this.aMB.setVisibility(8);
                    return;
                } else {
                    f.this.cC(0);
                    f.this.cB(0);
                    f.this.HI();
                    ac.ae(f.this.getContext(), "当前处在非WiFi状态下 请注意流量消耗哦~");
                    com.kwad.components.ct.e.b.JK().k((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).cdM, ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).aLK.aLP ? 1 : 0);
                }
                f.this.By();
            }
        });
        this.aMB.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.horizontal.feed.item.presenter.play.f.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.aMB.setVisibility(8);
                if (!ao.isNetworkConnected(f.this.getContext())) {
                    f.this.cC(1);
                    f.this.cB(0);
                    return;
                }
                if (ao.isWifiConnected(f.this.getContext())) {
                    f.this.cC(0);
                    ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).aLK.aNa = true;
                    f.this.HI();
                } else if (com.kwad.components.ct.horizontal.b.a.Is()) {
                    f.this.cC(2);
                    f.this.cB(0);
                    f.this.aMB.setVisibility(8);
                } else {
                    f.this.cC(0);
                    f.this.cB(0);
                    f.this.HI();
                    ac.ae(f.this.getContext(), "当前处在非WiFi状态下 请注意流量消耗哦~");
                    com.kwad.components.ct.e.b.JK().k((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).cdM, ((com.kwad.components.ct.horizontal.feed.item.a.a) f.this.cdN).aLK.aLP ? 1 : 0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HI() {
        if (((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMY != null) {
            ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMY.start(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mCurrentPosition);
        }
        if (ao.isNetworkConnected(getContext())) {
            com.kwad.components.ct.horizontal.b.a.Ir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HJ() {
        if (((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMY != null) {
            ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMY.pause(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mCurrentPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ca() {
        KsContentPage.VideoListener next;
        Iterator<KsContentPage.VideoListener> it = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.Hq().iterator();
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
        Iterator<KsContentPage.VideoListener> it = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.Hq().iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            next.onVideoPlayPaused(this.aLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cc() {
        KsContentPage.VideoListener next;
        if (this.axL) {
            Iterator<KsContentPage.VideoListener> it = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.Hq().iterator();
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
        Iterator<KsContentPage.VideoListener> it = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.Hq().iterator();
        while (it.hasNext()) {
            it.next().onVideoPlayCompleted(this.aLE);
        }
        if (((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMY != null) {
            ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aMY.cy(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).mCurrentPosition);
        }
        this.aMP = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i, int i2) {
        Iterator<KsContentPage.VideoListener> it = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.Hq().iterator();
        while (it.hasNext()) {
            it.next().onVideoPlayError(this.aLE, i, i2);
        }
    }

    private boolean HK() {
        if (!com.kwad.components.ct.horizontal.a.b.Hp() || this.cdN == 0 || ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK == null || ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.ant) {
            return false;
        }
        return ao.isNetworkConnected(getContext()) || ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aNa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(long j, long j2) {
        int i = j < j2 ? 2 : 1;
        com.kwad.components.ct.e.b.JK().a(this.mAdTemplate, i, Math.abs(j2 - j) / 1000, j, ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void By() {
        com.kwad.components.ct.e.b.JK().b((CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM, 1, ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2, int i) {
        long jLongValue;
        this.aMR = true;
        if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            jLongValue = com.kwad.sdk.core.response.b.a.M(com.kwad.components.ct.response.a.a.eP(this.mAdTemplate)) * 1000;
        } else {
            jLongValue = com.kwad.components.ct.response.a.c.f((PhotoInfo) com.kwad.components.ct.response.a.a.ay(this.mAdTemplate)).longValue();
        }
        if (axI) {
            com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", " reportPlayFinish videoDuration: " + jLongValue + " stayDuration: " + j + " playDuration " + j2 + "  leaveType:" + i + " position:" + this.mAdTemplate.getShowPosition());
        }
        int i2 = this.om ? 1 : 2;
        l.a aVarUE = this.zg.uE();
        com.kwad.components.ct.e.b.JK().a(((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.mSceneImpl, this.mAdTemplate, j2, i, j, aVarUE.uH(), aVarUE.uG(), i2, ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP ? 1 : 0, com.kwad.components.ct.horizontal.a.b.Hp() ? 1 : 2, this.aMS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CE() {
        if (this.azi || this.mAdTemplate == null) {
            return;
        }
        this.azi = true;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.aLG.Iu();
        String currentPlayingUrl = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLG != null ? ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLG.getCurrentPlayingUrl() : "";
        String str = com.kwad.components.ct.response.a.a.ay(this.mAdTemplate).videoInfo.width + "*" + com.kwad.components.ct.response.a.a.ay(this.mAdTemplate).videoInfo.height;
        if (axI) {
            com.kwad.sdk.core.d.c.d("FeedPlayVideoItemPlayer", "reportPlayStart  startPlayDuration:" + jElapsedRealtime + "  p:" + str);
        }
        com.kwad.components.ct.e.b.JK().a(this.mAdTemplate, jElapsedRealtime, currentPlayingUrl, str, ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP ? 1 : 0, com.kwad.components.core.video.c.ub().ue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void Cz() {
        if (this.aza) {
            return;
        }
        this.aza = true;
        com.kwad.components.ct.e.b bVarJK = com.kwad.components.ct.e.b.JK();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).cdM;
        boolean z = ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP;
        bVarJK.a(ctAdTemplate, 0, z ? 1 : 0, com.kwad.components.core.video.c.ub().ue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL() {
        if (this.aMQ || this.mAdTemplate == null) {
            return;
        }
        this.aMQ = true;
        com.kwad.components.ct.e.b.JK().n(this.mAdTemplate, ((com.kwad.components.ct.horizontal.feed.item.a.a) this.cdN).aLK.aLP ? 1 : 0);
    }
}
