package com.kwad.components.core.widget;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.u.s;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.view.ScaleAnimSeekBar;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FeedVideoView extends b<AdResultData, AdTemplate> implements NestedScrollingChild {
    private NestedScrollingChildHelper WK;
    private com.kwad.components.core.video.f Xb;
    private KSCornerImageView akA;
    private TextView akB;
    private ScaleAnimSeekBar akC;
    private ImageView akD;
    private ImageView akE;
    private ImageView akF;
    private ViewGroup akG;
    private ViewGroup akH;
    private TextView akI;
    private ViewGroup akJ;
    private ViewGroup akK;
    private boolean akL;
    private boolean akM;
    private long akN;
    private boolean akO;
    private KsAdVideoPlayConfig akP;
    private a akQ;
    private View akR;
    private boolean akS;
    private Runnable akT;
    private s akU;
    private RatioFrameLayout akv;
    private TextView akw;
    private TextView akx;
    private TextView aky;
    private View akz;
    private List<Integer> dX;
    private com.kwad.sdk.core.video.videoview.a ed;
    private a.InterfaceC0593a em;
    private KsAppDownloadListener fJ;
    private View.OnClickListener hy;
    private ImageView jF;
    private TextView jt;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int mCurrentMode;

    public interface a {
        void rp();

        void rq();
    }

    static /* synthetic */ boolean a(FeedVideoView feedVideoView, boolean z) {
        feedVideoView.akS = true;
        return true;
    }

    public FeedVideoView(Context context) {
        super(context);
        this.mCurrentMode = 100;
        this.akT = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.akG.setVisibility(8);
                FeedVideoView.this.akF.setVisibility(8);
                if (FeedVideoView.this.Xb != null) {
                    FeedVideoView.this.Xb.aU(true);
                }
            }
        };
        this.akU = new s(this.akT);
    }

    public FeedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentMode = 100;
        this.akT = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.akG.setVisibility(8);
                FeedVideoView.this.akF.setVisibility(8);
                if (FeedVideoView.this.Xb != null) {
                    FeedVideoView.this.Xb.aU(true);
                }
            }
        };
        this.akU = new s(this.akT);
    }

    public FeedVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentMode = 100;
        this.akT = new Runnable() { // from class: com.kwad.components.core.widget.FeedVideoView.7
            @Override // java.lang.Runnable
            public final void run() {
                FeedVideoView.this.akG.setVisibility(8);
                FeedVideoView.this.akF.setVisibility(8);
                if (FeedVideoView.this.Xb != null) {
                    FeedVideoView.this.Xb.aU(true);
                }
            }
        };
        this.akU = new s(this.akT);
    }

    public void setWindowFullScreenListener(a aVar) {
        this.akQ = aVar;
    }

    @Override // com.kwad.components.core.widget.b
    protected final void bB() {
        this.WK = new NestedScrollingChildHelper(this);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_video_container);
        this.akv = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.jF = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.jt = (TextView) findViewById(R.id.ksad_video_text_below);
        ScaleAnimSeekBar scaleAnimSeekBar = (ScaleAnimSeekBar) findViewById(R.id.ksad_web_video_seek_bar);
        this.akC = scaleAnimSeekBar;
        scaleAnimSeekBar.setMaxProgress(100);
        this.akC.setMinProgress(0);
        this.aky = (TextView) findViewById(R.id.ksad_video_text_below_action_bar);
        this.akz = findViewById(R.id.ksad_video_text_below_action_icon_layout);
        this.akB = (TextView) findViewById(R.id.ksad_video_text_below_action_title);
        this.akA = (KSCornerImageView) findViewById(R.id.ksad_video_text_below_action_icon);
        this.akw = (TextView) findViewById(R.id.ksad_video_control_play_total);
        this.akx = (TextView) findViewById(R.id.ksad_video_control_play_duration);
        this.akD = (ImageView) findViewById(R.id.ksad_video_control_play_button);
        this.akF = (ImageView) findViewById(R.id.ksad_video_control_play_status);
        this.akE = (ImageView) findViewById(R.id.ksad_video_control_fullscreen);
        this.akG = (ViewGroup) findViewById(R.id.ksad_video_control_container);
        this.akJ = (ViewGroup) findViewById(R.id.ksad_feed_video_container);
        this.akH = (ViewGroup) findViewById(R.id.ksad_video_control_fullscreen_container);
        this.akI = (TextView) findViewById(R.id.ksad_video_control_fullscreen_title);
    }

    @Override // com.kwad.components.core.widget.b
    protected int getLayoutId() {
        return R.layout.ksad_feed_video;
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d((FeedVideoView) adResultData);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.fJ == null) {
            this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.widget.FeedVideoView.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    FeedVideoView.this.aky.setText(com.kwad.sdk.core.response.b.a.aH(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    FeedVideoView.this.aky.setText(com.kwad.sdk.core.response.b.a.ft(i));
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    FeedVideoView.this.aky.setText(com.kwad.sdk.core.response.b.a.fv(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    FeedVideoView.this.aky.setText(com.kwad.sdk.core.response.b.a.cB(FeedVideoView.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    FeedVideoView.this.aky.setText(com.kwad.sdk.core.response.b.a.aH(FeedVideoView.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    FeedVideoView.this.aky.setText(com.kwad.sdk.core.response.b.a.ae(FeedVideoView.this.mAdInfo));
                }
            };
        }
        return this.fJ;
    }

    public final void a(KsAdVideoPlayConfig ksAdVideoPlayConfig, com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
        this.akS = false;
        com.kwad.sdk.core.response.model.b bVarBA = com.kwad.sdk.core.response.b.a.bA(this.mAdInfo);
        this.akP = ksAdVideoPlayConfig;
        String url = bVarBA.getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.jF.setImageDrawable(null);
            KSImageLoader.loadImage(this.jF, url, this.mAdTemplate);
            this.jF.setVisibility(0);
        } else {
            this.jF.setVisibility(8);
        }
        this.dX = com.kwad.sdk.core.response.b.a.bv(this.mAdInfo);
        String strL = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        this.ed = AdVideoPlayerViewCache.getInstance().fW(strL);
        if (com.kwad.sdk.core.response.b.a.as(this.mAdInfo)) {
            this.jt.setVisibility(8);
            View view = this.akz;
            if (view != null) {
                view.setVisibility(0);
                this.aky.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
                this.akB.setText(com.kwad.sdk.core.response.b.a.cz(this.mAdInfo));
                KSImageLoader.loadAppIcon(this.akA, com.kwad.sdk.core.response.b.a.cC(this.mAdInfo), this.mAdTemplate, 4);
                com.kwad.components.core.e.d.c cVar2 = this.mApkDownloadHelper;
                if (cVar2 != null) {
                    cVar2.b(getAppDownloadListener());
                }
                this.aky.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        if (FeedVideoView.this.hy != null) {
                            FeedVideoView.this.hy.onClick(view2);
                        }
                    }
                });
            }
        } else {
            View view2 = this.akz;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.jt.setVisibility(0);
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.ed;
        if (aVar == null) {
            this.ed = new com.kwad.sdk.core.video.videoview.a(getContext());
            com.kwad.sdk.core.response.b.a.ad(this.mAdInfo);
            this.ed.a(new b.a(this.mAdTemplate).a(this.mAdTemplate.mVideoPlayerStatus).ew(com.kwad.sdk.core.response.b.e.eR(this.mAdTemplate)).ex(com.kwad.sdk.core.response.b.h.e(com.kwad.sdk.core.response.b.e.eQ(this.mAdTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).WR(), null);
            a.InterfaceC0593a interfaceC0593a = new a.InterfaceC0593a() { // from class: com.kwad.components.core.widget.FeedVideoView.6
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0593a
                public final com.kwad.sdk.core.video.a.c aw() {
                    int i = Build.VERSION.SDK_INT;
                    return null;
                }
            };
            this.em = interfaceC0593a;
            this.ed.setExternalPlayerListener(interfaceC0593a);
            com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.ed, ksAdVideoPlayConfig);
            this.Xb = fVar;
            fVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.ed.setController(this.Xb);
            this.Xb.setAutoRelease(false);
            if (com.kwad.sdk.core.config.e.Xz() == 2) {
                AdVideoPlayerViewCache.getInstance().a(strL, this.ed);
            }
        } else {
            if (aVar.getTag() != null) {
                try {
                    this.dX = (List) this.ed.getTag();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            com.kwad.components.core.video.f fVar2 = (com.kwad.components.core.video.f) this.ed.getController();
            this.Xb = fVar2;
            fVar2.setAutoRelease(false);
            this.Xb.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.ed.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.ed.getParent() != null) {
            ((ViewGroup) this.ed.getParent()).removeView(this.ed);
            this.Xb.uo();
        }
        if (this.akv.getTag() != null) {
            RatioFrameLayout ratioFrameLayout = this.akv;
            ratioFrameLayout.removeView((View) ratioFrameLayout.getTag());
            this.akv.setTag(null);
        }
        this.akv.addView(this.ed);
        this.akv.setTag(this.ed);
        this.akG.setVisibility(8);
        this.akF.setVisibility(8);
        if (this.mAdInfo.adConversionInfo.h5Type == 1) {
            this.jt.setVisibility(8);
        } else {
            this.jt.setVisibility(0);
            this.jt.setText(this.mAdInfo.adBaseInfo.adDescription);
        }
        a(this.Xb, this.ed);
    }

    private void a(com.kwad.components.core.video.a aVar, final com.kwad.sdk.core.video.videoview.a aVar2) {
        this.akJ.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.akG.getVisibility() == 8) {
                    if (!FeedVideoView.this.ed.isCompleted()) {
                        FeedVideoView.this.akG.setVisibility(0);
                        FeedVideoView.this.akF.setVisibility(0);
                        if (FeedVideoView.this.Xb != null) {
                            FeedVideoView.this.Xb.aU(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.akT);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.akU, 5000L);
                            return;
                        }
                        return;
                    }
                    if (FeedVideoView.this.mCurrentMode == 101) {
                        FeedVideoView.this.akG.setVisibility(0);
                        FeedVideoView.this.akF.setVisibility(8);
                        if (FeedVideoView.this.Xb != null) {
                            FeedVideoView.this.Xb.aU(false);
                        }
                        if (FeedVideoView.this.getHandler() != null) {
                            FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.akT);
                            FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.akU, 5000L);
                            return;
                        }
                        return;
                    }
                    if (FeedVideoView.this.hy != null) {
                        FeedVideoView.this.hy.onClick(view);
                        return;
                    }
                    return;
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.akT);
                    if (FeedVideoView.this.akO) {
                        return;
                    }
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.akU, 1000L);
                }
            }
        });
        aVar.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.widget.FeedVideoView.9
            private boolean gq = false;

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                FeedVideoView.this.c(j);
                float duration = (j * 100.0f) / aVar2.getDuration();
                if (!FeedVideoView.this.akO) {
                    FeedVideoView.this.akC.setProgress((int) duration);
                    FeedVideoView.this.akx.setText(bv.aP(j));
                }
                FeedVideoView.this.akw.setText(bv.aP(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                if (!FeedVideoView.this.akS) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.ed.setVideoSoundEnable(true ^ com.kwad.sdk.core.response.b.a.ar(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.ed.setLooping(com.kwad.sdk.core.response.b.a.aq(FeedVideoView.this.mAdInfo));
                    }
                }
                com.kwad.sdk.core.adlog.c.cm(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.akw.setText(bv.aP(aVar2.getDuration()));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void au() {
                if (!FeedVideoView.this.akS) {
                    FeedVideoView.a(FeedVideoView.this, true);
                    if (com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.ed.setVideoSoundEnable(!com.kwad.sdk.core.response.b.a.ar(FeedVideoView.this.mAdInfo));
                    }
                    if (com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo) != 0) {
                        FeedVideoView.this.ed.setLooping(com.kwad.sdk.core.response.b.a.aq(FeedVideoView.this.mAdInfo));
                    }
                }
                if (this.gq) {
                    return;
                }
                this.gq = true;
                com.kwad.components.core.q.a.ss().a(FeedVideoView.this.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void av() {
                com.kwad.sdk.core.adlog.c.cn(FeedVideoView.this.mAdTemplate);
                FeedVideoView.this.akG.setVisibility(8);
                FeedVideoView.this.akF.setVisibility(8);
                FeedVideoView.this.akC.setProgress(100);
                FeedVideoView.this.akx.setText(bv.aP(aVar2.getDuration()));
            }
        });
        this.Xb.setAdClickListener(new a.InterfaceC0488a() { // from class: com.kwad.components.core.widget.FeedVideoView.10
            @Override // com.kwad.components.core.video.a.InterfaceC0488a
            public final void a(int i, aj.a aVar3) {
                int i2 = 171;
                int i3 = 2;
                boolean z = false;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            i2 = com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo) != 0 ? 50 : 83;
                            i3 = 1;
                            z = true;
                        } else if (com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo) == 0) {
                            i2 = 108;
                        }
                    } else if (com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo) == 0) {
                        i2 = 82;
                    }
                } else if (com.kwad.sdk.core.response.b.a.ap(FeedVideoView.this.mAdInfo) == 0) {
                    i2 = 13;
                }
                com.kwad.components.core.e.d.a.a(new a.C0469a(FeedVideoView.this.getContext()).aC(FeedVideoView.this.mAdTemplate).av(true).b(FeedVideoView.this.mApkDownloadHelper).aG(i3).aq(z).as(true).aF(i2).d(aVar3).a(new a.b() { // from class: com.kwad.components.core.widget.FeedVideoView.10.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        FeedVideoView.this.wx();
                    }
                }));
            }
        });
        this.akC.setOnSeekBarChangeListener(new ScaleAnimSeekBar.a() { // from class: com.kwad.components.core.widget.FeedVideoView.11
            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar, boolean z) {
                if (z) {
                    FeedVideoView.this.akC.cC(true);
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.akU);
                    FeedVideoView.this.akO = true;
                    FeedVideoView.this.akx.setText(bv.aP((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress())));
                }
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void wF() {
                FeedVideoView.this.akC.cC(true);
                FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.akU);
                FeedVideoView.this.akO = true;
            }

            @Override // com.kwad.sdk.core.view.ScaleAnimSeekBar.a
            public final void a(ScaleAnimSeekBar scaleAnimSeekBar) {
                FeedVideoView.this.akC.cC(false);
                aVar2.seekTo((int) ((aVar2.getDuration() * scaleAnimSeekBar.getProgress()) / scaleAnimSeekBar.getMaxProgress()));
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.akU);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.akU, 5000L);
                }
                FeedVideoView.this.akO = false;
            }
        });
        this.akD.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (aVar2.isPaused() || aVar2.isIdle()) {
                    FeedVideoView.this.Xb.ur();
                    FeedVideoView.this.akD.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
                    FeedVideoView.this.akF.setImageDrawable(FeedVideoView.this.getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
                } else if (aVar2.isPlaying()) {
                    FeedVideoView.this.Xb.uq();
                    FeedVideoView.this.akF.setVisibility(0);
                    FeedVideoView.this.akF.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
                    FeedVideoView.this.akD.setImageDrawable(FeedVideoView.this.getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.akU);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.akU, 5000L);
                }
            }
        });
        this.akF.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!FeedVideoView.this.ed.isPaused() && !FeedVideoView.this.ed.isIdle()) {
                    if (FeedVideoView.this.ed.isPlaying()) {
                        FeedVideoView.this.tQ();
                    }
                } else {
                    FeedVideoView.this.sa();
                }
                if (FeedVideoView.this.getHandler() != null) {
                    FeedVideoView.this.getHandler().removeCallbacks(FeedVideoView.this.akU);
                    FeedVideoView.this.getHandler().postDelayed(FeedVideoView.this.akU, 5000L);
                }
            }
        });
        this.akH.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedVideoView.this.wD();
            }
        });
        this.akE.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.widget.FeedVideoView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (FeedVideoView.this.mCurrentMode == 100) {
                    FeedVideoView.this.wC();
                } else if (FeedVideoView.this.mCurrentMode == 101) {
                    FeedVideoView.this.wD();
                }
            }
        });
    }

    public final void sa() {
        this.Xb.ur();
        this.Xb.setVisibility(0);
        this.Xb.setAlpha(1.0f);
        this.akD.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_btn));
        this.akF.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_pause_center));
    }

    public final void tQ() {
        this.Xb.uq();
        this.akF.setVisibility(0);
        this.akF.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_play_176));
        this.akD.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_play_btn));
    }

    public final void rW() {
        this.Xb.uo();
    }

    public final boolean isComplete() {
        com.kwad.sdk.core.video.videoview.a aVar = this.ed;
        if (aVar != null) {
            return aVar.isCompleted();
        }
        return true;
    }

    private boolean wB() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.akN;
        if (j > 888) {
            this.akN = jElapsedRealtime;
        }
        return j > 888;
    }

    protected void setUIWithStateAndMode(int i) {
        if (i == 101) {
            this.akE.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_exit_fullscreen_btn));
        } else {
            this.akE.setImageDrawable(getContext().getResources().getDrawable(R.drawable.ksad_video_player_fullscreen_btn));
        }
        this.mCurrentMode = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wC() {
        a aVar = this.akQ;
        if (aVar != null) {
            aVar.rp();
        }
        if ((this.mCurrentMode == 100) && wB()) {
            this.akH.setVisibility(0);
            this.akI.setText(this.mAdInfo.adBaseInfo.adDescription);
            boolean z = com.kwad.sdk.core.response.b.a.S(this.mAdInfo) > com.kwad.sdk.core.response.b.a.R(this.mAdInfo);
            this.akL = aq.dY(getContext());
            getContext();
            this.akM = aq.apb();
            if (!z) {
                aq.ea(getContext());
            } else {
                aq.eb(getContext());
            }
            ViewGroup viewGroup = (ViewGroup) this.akJ.getParent();
            this.akK = viewGroup;
            if (viewGroup != null) {
                viewGroup.removeView(this.akJ);
                View view = new View(this.akJ.getContext());
                this.akR = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(this.akJ.getWidth(), this.akJ.getHeight()));
                viewGroup.addView(this.akR);
            }
            aq.d(getContext(), false);
            Activity activityFb = m.fb(getContext());
            if (activityFb != null) {
                ViewGroup viewGroup2 = (ViewGroup) activityFb.getWindow().getDecorView();
                this.akJ.setLayoutParams(new ViewGroup.LayoutParams(viewGroup2.getWidth(), viewGroup2.getHeight()));
                if (z && viewGroup2.getWidth() != 0) {
                    this.akv.setRatio(viewGroup2.getHeight() / viewGroup2.getWidth());
                }
                viewGroup2.addView(this.akJ, new FrameLayout.LayoutParams(-1, -1));
                setUIWithStateAndMode(101);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wD() {
        if ((this.mCurrentMode == 101) & wB()) {
            this.akH.setVisibility(8);
            if (this.akL) {
                aq.dY(getContext());
            } else {
                aq.dZ(getContext());
            }
            if (this.akM) {
                aq.eb(getContext());
            } else {
                aq.ea(getContext());
            }
            aq.d(getContext(), true);
            ViewGroup viewGroup = (ViewGroup) this.akJ.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.akJ);
            }
            this.akJ.setLayoutParams(new ViewGroup.LayoutParams(this.akK.getWidth(), this.akK.getHeight()));
            this.akv.setRatio(0.5600000023841858d);
            View view = this.akR;
            if (view != null) {
                this.akK.removeView(view);
                this.akR = null;
            }
            this.akK.addView(this.akJ, new FrameLayout.LayoutParams(-1, -2));
            this.akJ.requestLayout();
            setUIWithStateAndMode(100);
        }
        a aVar = this.akQ;
        if (aVar != null) {
            aVar.rq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.dX;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.dX.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a((AdTemplate) this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    public final void release() {
        com.kwad.components.core.video.f fVar = this.Xb;
        if (fVar != null) {
            fVar.release();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.WK.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.WK.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.WK.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.WK.stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.WK.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.WK.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.WK.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.WK.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.WK.dispatchNestedPreFling(f, f2);
    }

    public final boolean wE() {
        if (this.mCurrentMode != 101) {
            return false;
        }
        wD();
        return true;
    }

    public void setOnEndBtnClickListener(View.OnClickListener onClickListener) {
        this.hy = onClickListener;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.m
    public final void E(View view) {
        super.E(view);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bz() {
        super.bz();
        if (this.ed != null) {
            tQ();
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.akU);
                getHandler().postDelayed(this.akU, 5000L);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void by() {
        super.by();
        com.kwad.sdk.core.video.videoview.a aVar = this.ed;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        sa();
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.akU);
            getHandler().postDelayed(this.akU, 5000L);
        }
    }
}
