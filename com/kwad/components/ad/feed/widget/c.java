package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.l.a;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.model.FeedType;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class c extends a implements View.OnClickListener, com.kwad.sdk.widget.e {
    private KsAdVideoPlayConfig dG;
    private List<Integer> dX;
    private boolean ec;
    private com.kwad.sdk.core.video.videoview.a ed;
    private a.InterfaceC0593a em;
    private a.b en;
    private OfflineOnAudioConflictListener eo;
    private TextView fR;
    private final AdLivePlayStateListener fU;
    private volatile boolean gq;
    private com.kwad.sdk.widget.n gr;
    private IAdLiveOfflineView hb;
    private com.kwad.components.core.p.a.b.a hc;
    private a.b ho;
    private View hq;
    private ImageView ik;
    private TextView it;
    private DownloadProgressView jA;
    private boolean jB;
    private int jC;
    protected KSRelativeLayout jE;
    private ImageView jF;
    private com.kwad.components.core.video.f jG;
    private d jH;
    private TextView jI;
    private final a.InterfaceC0488a jJ;
    private IAdLivePlayModule jK;
    private boolean jL;
    private TextView jt;
    private ImageView jv;
    private TextView jx;
    private TextView jy;
    private View jz;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean mIsAudioEnable;
    private KsLogoView mLogoView;

    static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.ec = false;
        return false;
    }

    public void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.f fVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dG = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.mIsAudioEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
            } else {
                this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.cj(this.mAdInfo);
            }
            this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
            IAdLiveOfflineView iAdLiveOfflineView = this.hb;
            if (iAdLiveOfflineView != null && iAdLiveOfflineView.getView() != null && (iAdLivePlayModule = this.jK) != null) {
                iAdLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
            } else {
                com.kwad.sdk.core.video.videoview.a aVar = this.ed;
                if (aVar != null) {
                    aVar.setVideoSoundEnable(h(this.mIsAudioEnable));
                }
            }
            if (this.mIsAudioEnable) {
                com.kwad.components.core.u.a.aC(this.mContext).a(this.eo);
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (fVar = this.jG) == null) {
                return;
            }
            fVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public c(Context context) {
        super(context);
        this.mIsAudioEnable = false;
        this.gq = false;
        this.jB = true;
        this.jC = 8;
        this.gr = new com.kwad.sdk.widget.n() { // from class: com.kwad.components.ad.feed.widget.c.1
            @Override // com.kwad.sdk.widget.n
            public final void aY() {
                com.kwad.sdk.utils.n.fm(c.this.mAdTemplate);
            }
        };
        this.jJ = new a.InterfaceC0488a() { // from class: com.kwad.components.ad.feed.widget.c.4
            @Override // com.kwad.components.core.video.a.InterfaceC0488a
            public final void a(int i, aj.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 15;
                } else if (i == 2) {
                    i2 = 16;
                } else if (i != 3) {
                    i2 = 35;
                } else {
                    i2 = 39;
                    i3 = 1;
                    z = true;
                }
                c.this.co();
                com.kwad.components.core.e.d.a.a(new a.C0469a(c.this.getContext()).aC(c.this.mAdTemplate).b(c.this.mApkDownloadHelper).aG(i3).aq(z).as(true).aE(5).aF(i2).d(aVar).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.c.4.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        c.this.wx();
                    }
                }));
            }
        };
        this.fU = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.c.8
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                c.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                c.this.jI.setVisibility(0);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                if (c.this.jK != null) {
                    com.kwad.components.core.l.a.qD().a(c.this.getCurrentVoiceItem());
                    IAdLivePlayModule iAdLivePlayModule = c.this.jK;
                    c cVar = c.this;
                    iAdLivePlayModule.setAudioEnabled(cVar.h(cVar.mIsAudioEnable), false);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                if (c.this.jK != null) {
                    com.kwad.components.core.l.a.qD().a(c.this.getCurrentVoiceItem());
                    IAdLivePlayModule iAdLivePlayModule = c.this.jK;
                    c cVar = c.this;
                    iAdLivePlayModule.setAudioEnabled(cVar.h(cVar.mIsAudioEnable), false);
                }
            }
        };
        this.eo = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.widget.c.10
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                c.b(c.this, false);
                if (c.this.ed != null) {
                    c.this.ed.setVideoSoundEnable(false);
                }
                if (c.this.jK != null) {
                    c.this.jK.setAudioEnabled(false, false);
                }
            }
        };
        this.en = new a.b() { // from class: com.kwad.components.ad.feed.widget.c.2
            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                c.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.l.a.qD().a(c.this.getCurrentVoiceItem());
                if (c.this.jH != null && (c.this.jH.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) c.this.jH.getParent()).removeView(c.this.jH);
                    c.this.jH.cE();
                    c.this.jH = null;
                }
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.L(c.this.mAdInfo), null, SystemClock.elapsedRealtime() - c.this.jm);
                com.kwad.sdk.core.adlog.c.cm(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void au() {
                com.kwad.sdk.core.video.videoview.a aVar = c.this.ed;
                c cVar = c.this;
                aVar.setVideoSoundEnable(cVar.h(cVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void av() {
                if (com.kwad.components.ad.feed.a.b.ck() && c.this.jH == null) {
                    c.this.jH = new d(c.this.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    c cVar = c.this;
                    cVar.addView(cVar.jH, layoutParams);
                    c.this.jH.cD();
                }
                if (c.this.jG.abw != null && c.this.cB()) {
                    ((ViewGroup) c.this.jG.abw.getParent()).removeView(c.this.jG.abw);
                    c.this.jE.addView(c.this.jG.abw);
                }
                com.kwad.sdk.core.adlog.c.cn(c.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                com.kwad.components.ad.feed.monitor.b.a(c.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.L(c.this.mAdInfo), i + " " + i2, SystemClock.elapsedRealtime() - c.this.jm);
            }
        };
    }

    @Override // com.kwad.components.core.widget.b
    public void bB() {
        this.jt = (TextView) findViewById(R.id.ksad_ad_desc);
        this.jE = (KSRelativeLayout) findViewById(R.id.ksad_feed_ad_video_container);
        cw();
        this.jv = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.jF = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.jA = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.jI = (TextView) findViewById(R.id.ksad_live_end_text);
        this.hq = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    protected void cw() {
        this.jE.setRatio(0.56f);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void by() {
        super.by();
        com.kwad.components.core.video.f fVar = this.jG;
        if (fVar != null) {
            fVar.setVideoPlayCallback(this.en);
        }
        com.kwad.components.core.l.a.qD().a(getCurrentVoiceItem());
        if (this.jL) {
            IAdLivePlayModule iAdLivePlayModule = this.jK;
            if (iAdLivePlayModule == null) {
                this.jK = cz();
            } else {
                iAdLivePlayModule.onResume();
            }
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bz() {
        super.bz();
        IAdLivePlayModule iAdLivePlayModule = this.jK;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.l.a.qD().c(this.ho);
    }

    @Override // com.kwad.components.core.widget.b
    public final void cv() {
        super.cv();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.jA.getAppDownloadListener());
        }
        if (this.mIsAudioEnable) {
            com.kwad.components.core.u.a.aC(this.mContext).b(this.eo);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) {
        super.d((c) adResultData);
        this.jt.setText(com.kwad.components.ad.feed.f.m(this.mAdTemplate));
        this.mLogoView.aQ(this.mAdTemplate);
        cx();
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo)) {
            findViewById(R.id.ksad_ad_download_container).setVisibility(0);
            findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
            cs();
            cC();
        } else {
            findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
            findViewById(R.id.ksad_ad_download_container).setVisibility(8);
            if (cB()) {
                cs();
            }
            cr();
        }
        this.jt.setOnClickListener(this);
        this.jE.setOnClickListener(this);
        this.jv.setOnClickListener(this);
        new com.kwad.sdk.widget.j(getContext(), this.jt, this);
        new com.kwad.sdk.widget.j(getContext(), this.jE, this);
        new com.kwad.sdk.widget.j(getContext(), this.jv, this);
        setOnClickListener(this);
    }

    private void cx() {
        com.kwad.components.core.p.a.b.a aVar = (com.kwad.components.core.p.a.b.a) com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.b.a.class);
        this.hc = aVar;
        if (aVar != null && aVar.qI() && com.kwad.sdk.core.response.b.a.df(this.mAdInfo)) {
            this.jL = true;
            cA();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onWindowFocusChanged(boolean z) {
        IAdLivePlayModule iAdLivePlayModule;
        try {
            if (this.mAdInfo == null) {
                return;
            }
            super.onWindowFocusChanged(z);
            if (z) {
                if (cy()) {
                    return;
                }
                com.kwad.sdk.core.video.videoview.a aVar = this.ed;
                if (aVar != null && this.jG != null) {
                    ViewGroup viewGroup = (ViewGroup) aVar.getParent();
                    if (this.ed.getParent() != this.jE) {
                        viewGroup.removeView(this.ed);
                        if (this.jE.getTag() != null) {
                            KSRelativeLayout kSRelativeLayout = this.jE;
                            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                            this.jE.setTag(null);
                        }
                        this.jE.addView(this.ed);
                        this.jE.setTag(this.ed);
                        this.ed.setVideoSoundEnable(this.mIsAudioEnable);
                        this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
                        this.jG.setAdClickListener(this.jJ);
                        this.jG.getAdTemplate().mAdWebVideoPageShowing = false;
                        this.jG.us();
                        this.jG.setAutoRelease(true);
                    }
                }
                if (this.mAdInfo != null) {
                    AdVideoPlayerViewCache.getInstance().remove(com.kwad.sdk.core.response.b.a.L(this.mAdInfo));
                    return;
                }
                return;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.hb;
            if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || (iAdLivePlayModule = this.jK) == null) {
                return;
            }
            iAdLivePlayModule.onPause();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private boolean cy() {
        IAdLiveOfflineView iAdLiveOfflineView = this.hb;
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || !this.jL) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) this.hb.getView().getParent();
        if (viewGroup != this.jE) {
            viewGroup.removeView(this.hb.getView());
            if (this.jE.getTag() != null) {
                KSRelativeLayout kSRelativeLayout = this.jE;
                kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                this.jE.setTag(null);
            }
            this.jE.addView(this.hb.getView());
            this.jE.setTag(this.hb.getView());
            IAdLivePlayModule adLivePlayModule = this.hc.getAdLivePlayModule(this.hb, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cD(this.mAdInfo)), com.kwad.sdk.core.response.b.a.cE(this.mAdInfo), com.kwad.sdk.core.response.b.a.cF(this.mAdInfo));
            this.jK = adLivePlayModule;
            adLivePlayModule.setAudioEnabled(this.mIsAudioEnable, false);
            this.jK.registerAdLivePlayStateListener(this.fU);
        }
        IAdLivePlayModule iAdLivePlayModule = this.jK;
        if (iAdLivePlayModule == null) {
            return true;
        }
        iAdLivePlayModule.onResume();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule cz() {
        IAdLiveOfflineView iAdLiveOfflineViewA = com.kwad.components.ad.j.c.a(this.hc, this.mContext, 3);
        this.hb = iAdLiveOfflineViewA;
        if (iAdLiveOfflineViewA == null) {
            return null;
        }
        IAdLivePlayModule adLivePlayModule = this.hc.getAdLivePlayModule(iAdLiveOfflineViewA, ServiceProvider.getSDKConfig().appId, String.valueOf(com.kwad.sdk.core.response.b.a.cD(this.mAdInfo)), com.kwad.sdk.core.response.b.a.cE(this.mAdInfo), com.kwad.sdk.core.response.b.a.cF(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.fU);
        final View view = this.hb.getView();
        if (this.jE.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.jE;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.jE.setTag(null);
        }
        this.jE.addView(view);
        this.jE.setTag(view);
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.feed.widget.c.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                c.this.d(view);
            }
        });
        if (this.mIsAudioEnable) {
            com.kwad.components.core.u.a.aC(this.mContext).a(this.eo);
        }
        return adLivePlayModule;
    }

    private void cA() {
        String url = com.kwad.sdk.core.response.b.a.bA(this.mAdInfo).getUrl();
        this.jF.setVisibility(0);
        this.hq.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.jF.setImageDrawable(null);
            KSImageLoader.loadImage(this.jF, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.widget.c.6
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
        } else {
            this.jF.setImageResource(R.drawable.ksad_ad_live_end);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final View view) {
        view.post(new bh() { // from class: com.kwad.components.ad.feed.widget.c.7
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                int width = c.this.jE.getWidth();
                int height = c.this.jE.getHeight();
                if (width == 0 || height == 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
                layoutParams.addRule(13, -1);
                view.setLayoutParams(layoutParams);
            }
        });
    }

    public final void b(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        String strGa;
        this.dG = ksAdVideoPlayConfig;
        if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() != 0) {
            this.mIsAudioEnable = ksAdVideoPlayConfig.isVideoSoundEnable();
        } else {
            this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.cj(this.mAdInfo);
        }
        this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
        this.dX = com.kwad.sdk.core.response.b.a.bv(this.mAdInfo);
        if (this.jL) {
            return;
        }
        String url = com.kwad.sdk.core.response.b.a.bA(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.jF.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.jF.setImageDrawable(null);
            KSImageLoader.loadImage(this.jF, url, this.mAdTemplate);
            this.jF.setVisibility(0);
        } else {
            this.jF.setVisibility(8);
        }
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.ed = aVar;
        aVar.setVisibleListener(this.gr);
        this.ed.setOnClickListener(this);
        new com.kwad.sdk.widget.j(getContext(), this.ed, this);
        this.ed.setTag(this.dX);
        int iUw = com.kwad.sdk.core.config.e.Uw();
        String strL = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        if (iUw < 0) {
            File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(strL);
            if (fileDw == null || !fileDw.exists()) {
                strL = null;
            } else {
                strGa = fileDw.getAbsolutePath();
                strL = strGa;
            }
        } else if (iUw != 0) {
            com.kwad.sdk.core.videocache.f fVarCh = com.kwad.sdk.core.videocache.c.a.ch(this.mContext);
            if (com.kwad.sdk.core.config.e.XC()) {
                int iUw2 = com.kwad.sdk.core.config.e.Uw();
                if (!fVarCh.gc(strL)) {
                    if (fVarCh.a(strL, iUw2 * 1024, new a.C0589a(), null)) {
                        strGa = fVarCh.ga(strL);
                    }
                } else {
                    strGa = fVarCh.ga(strL);
                }
                strL = strGa;
            } else {
                strL = fVarCh.ga(strL);
            }
        }
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        this.ed.a(new b.a(this.mAdTemplate).ew(strL).ex(com.kwad.sdk.core.response.b.h.e(com.kwad.sdk.core.response.b.e.eQ(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate)).WR(), null);
        a.InterfaceC0593a interfaceC0593a = new a.InterfaceC0593a() { // from class: com.kwad.components.ad.feed.widget.c.9
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0593a
            public final com.kwad.sdk.core.video.a.c aw() {
                int i = Build.VERSION.SDK_INT;
                return null;
            }
        };
        this.em = interfaceC0593a;
        this.ed.setExternalPlayerListener(interfaceC0593a);
        this.ed.setVideoSoundEnable(h(this.mIsAudioEnable));
        com.kwad.components.core.video.f fVar = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.ed, ksAdVideoPlayConfig);
        this.jG = fVar;
        fVar.setAdClickListener(this.jJ);
        this.jm = SystemClock.elapsedRealtime();
        this.jG.setVideoPlayCallback(this.en);
        this.ed.setController(this.jG);
        if (this.jE.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.jE;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.jE.setTag(null);
        }
        this.jE.addView(this.ed);
        this.jE.setTag(this.ed);
        if (cB()) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_feed_bottombar_container);
            ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
            this.jE.addView(viewGroup);
        }
        this.jE.setClickable(true);
        this.jE.setOnClickListener(this);
        new com.kwad.sdk.widget.j(getContext(), this.jE, this);
        if (this.mIsAudioEnable) {
            com.kwad.components.core.u.a.aC(this.mContext).a(this.eo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z) {
        if (!z) {
            return false;
        }
        if (!com.kwad.sdk.core.config.e.hG()) {
            if (com.kwad.components.core.u.a.aC(this.mContext).tp()) {
                return !com.kwad.components.core.u.a.aC(this.mContext).to();
            }
            return com.kwad.components.core.u.a.aC(this.mContext).aS(false);
        }
        if (!this.ec) {
            this.ec = com.kwad.components.core.u.a.aC(this.mContext).aS(true);
        }
        return this.ec;
    }

    protected final boolean cB() {
        if (FeedType.isNewVerticalType(com.kwad.sdk.core.response.b.e.fg(this.mAdTemplate))) {
            return com.kwad.sdk.core.response.b.e.fh(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_NOVEL_DEFAULT.getDefaultType() || com.kwad.sdk.core.response.b.e.fh(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_BISERIAL_DEFAULT.getDefaultType();
        }
        return false;
    }

    private void cr() {
        this.jy = (TextView) findViewById(R.id.ksad_h5_desc);
        this.it = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.jz = findViewById(R.id.ksad_h5_open_cover);
        this.jy.setText(com.kwad.components.ad.feed.f.m(this.mAdTemplate));
        this.it.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
        this.jz.setOnClickListener(this);
        this.jy.setOnClickListener(this);
        this.it.setOnClickListener(this);
        new com.kwad.sdk.widget.j(getContext(), this.jz, this);
        new com.kwad.sdk.widget.j(getContext(), this.jy, this);
        new com.kwad.sdk.widget.j(getContext(), this.it, this);
    }

    private void cs() {
        this.ik = (ImageView) findViewById(R.id.ksad_app_icon);
        this.fR = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.jx = textView;
        com.kwad.sdk.c.a.a.a(this, this.ik, this.fR, textView);
        new com.kwad.sdk.widget.j(getContext(), this.ik, this);
        new com.kwad.sdk.widget.j(getContext(), this.fR, this);
        new com.kwad.sdk.widget.j(getContext(), this.jx, this);
        if (cB()) {
            this.fR.setText(com.kwad.sdk.core.response.b.a.cz(this.mAdInfo));
        } else {
            this.fR.setText(com.kwad.sdk.core.response.b.a.ay(this.mAdInfo));
        }
        this.ik.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.ik, com.kwad.sdk.core.response.b.a.cC(this.mAdInfo), this.mAdTemplate, this.jC);
        this.jx.setText(com.kwad.components.ad.feed.f.m(this.mAdTemplate));
        if (this.jB) {
            cp();
        }
    }

    private void cC() {
        this.jA.au(this.mAdTemplate);
        this.jA.setOnClickListener(this);
        new com.kwad.sdk.widget.j(getContext(), this.jA, this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.jA.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.jA.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
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

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eE(this.mAdTemplate)) {
            a(this.ed, view == this.jA, 153);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onClick(android.view.View r5) {
        /*
            r4 = this;
            android.widget.ImageView r0 = r4.jv
            if (r5 != r0) goto L8
            r4.wy()
            return
        L8:
            com.kwad.sdk.widget.KSRelativeLayout r0 = r4.jE
            if (r5 != r0) goto L2c
            com.kwad.sdk.core.video.videoview.a r0 = r4.ed
            if (r0 == 0) goto L2c
            boolean r0 = r0.isIdle()
            if (r0 == 0) goto L2c
            R extends com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            com.kwad.sdk.utils.n.fl(r5)
            R extends com.kwad.sdk.core.response.model.AdTemplate r5 = r4.mAdTemplate
            com.kwad.sdk.contentalliance.a.a.a r5 = com.kwad.sdk.contentalliance.a.a.a.cf(r5)
            com.kwad.sdk.core.video.videoview.a r0 = r4.ed
            r0.setKsPlayLogParam(r5)
            com.kwad.sdk.core.video.videoview.a r5 = r4.ed
            r5.start()
            return
        L2c:
            r0 = 35
            android.widget.TextView r1 = r4.jt
            r2 = 1
            r3 = 100
            if (r5 != r1) goto L38
            r0 = 25
            goto L6b
        L38:
            com.kwad.sdk.widget.KSRelativeLayout r1 = r4.jE
            if (r5 != r1) goto L3e
        L3c:
            r0 = r3
            goto L6b
        L3e:
            com.kwad.components.ad.widget.DownloadProgressView r1 = r4.jA
            if (r5 == r1) goto L6a
            android.widget.TextView r1 = r4.it
            if (r5 == r1) goto L6a
            android.view.View r1 = r4.jz
            if (r5 != r1) goto L4b
            goto L6a
        L4b:
            android.widget.ImageView r1 = r4.ik
            if (r5 != r1) goto L52
            r0 = 13
            goto L6b
        L52:
            android.widget.TextView r1 = r4.fR
            if (r5 != r1) goto L59
            r0 = 14
            goto L6b
        L59:
            android.widget.TextView r1 = r4.jx
            if (r5 == r1) goto L67
            android.widget.TextView r1 = r4.jy
            if (r5 != r1) goto L62
            goto L67
        L62:
            com.kwad.sdk.core.video.videoview.a r1 = r4.ed
            if (r5 != r1) goto L6b
            goto L3c
        L67:
            r0 = 101(0x65, float:1.42E-43)
            goto L6b
        L6a:
            r0 = r2
        L6b:
            com.kwad.sdk.core.video.videoview.a r1 = r4.ed
            com.kwad.components.ad.widget.DownloadProgressView r3 = r4.jA
            if (r5 != r3) goto L72
            goto L73
        L72:
            r2 = 0
        L73:
            r4.a(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.feed.widget.c.onClick(android.view.View):void");
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, boolean z, final int i) {
        com.kwad.components.core.video.f fVar;
        if (aVar != null || this.jL) {
            String strL = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
            if (!this.jL && (fVar = this.jG) != null) {
                fVar.setAutoRelease(false);
            }
            int i2 = z ? 1 : 2;
            if (!this.jL) {
                AdVideoPlayerViewCache.getInstance().a(strL, this.ed);
            }
            co();
            a.C0469a c0469aAq = new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aq(z);
            IAdLivePlayModule iAdLivePlayModule = this.jK;
            com.kwad.components.core.e.d.a.a(c0469aAq.A(iAdLivePlayModule == null ? 0L : iAdLivePlayModule.getPlayDuration()).aG(i2).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.c.11
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    c.this.bg(i);
                }
            }));
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        DownloadProgressView downloadProgressView;
        super.ae();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (downloadProgressView = this.jA) == null) {
            return;
        }
        cVar.b(downloadProgressView.getAppDownloadListener());
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        com.kwad.sdk.utils.n.fk(this.mAdTemplate);
        IAdLivePlayModule iAdLivePlayModule = this.jK;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.jK = null;
        }
        IAdLiveOfflineView iAdLiveOfflineView = this.hb;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.hb = null;
        }
        com.kwad.components.core.l.a.qD().c(this.ho);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.ho == null) {
            this.ho = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.widget.c.3
                @Override // com.kwad.components.core.l.a.c
                public final void bK() {
                    if (c.this.jL) {
                        if (c.this.jK == null) {
                            c cVar = c.this;
                            cVar.jK = cVar.cz();
                        }
                        if (c.this.jK != null) {
                            IAdLivePlayModule iAdLivePlayModule = c.this.jK;
                            c cVar2 = c.this;
                            iAdLivePlayModule.setAudioEnabled(cVar2.h(cVar2.mIsAudioEnable), false);
                            return;
                        }
                        return;
                    }
                    if (c.this.ed != null) {
                        com.kwad.sdk.core.video.videoview.a aVar = c.this.ed;
                        c cVar3 = c.this;
                        aVar.setVideoSoundEnable(cVar3.h(cVar3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.ho;
    }

    public void setmIsShowComplianceView(boolean z) {
        this.jB = z;
    }

    public void setRadiusDp(int i) {
        this.jC = i;
    }
}
