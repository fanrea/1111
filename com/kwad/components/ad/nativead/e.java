package com.kwad.components.ad.nativead;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kwad.components.ad.nativead.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.l.a;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.components.core.webview.jshandler.g;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener;
import com.kwad.components.offline.api.core.adlive.model.AdLiveMessageInfo;
import com.kwad.components.offline.api.core.adlive.model.AdLiveShopInfo;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.widget.KSRelativeLayout;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends KSRelativeLayout implements com.kwad.sdk.core.j.c {
    private List<Integer> dX;
    private boolean ec;
    private OfflineOnAudioConflictListener eo;
    private final AdLivePlayStateListener fU;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private int gD;
    private at.b gI;
    private com.kwad.components.core.widget.a.c gR;
    private IAdLiveOfflineView hb;
    private com.kwad.components.core.p.a.b.a hc;
    private a.b ho;
    private KSRelativeLayout jE;
    public IAdLivePlayModule jK;
    private IAdLiveEndRequest kJ;
    private bf kp;
    private ba kq;
    private WebCardRegisterLiveMessageListener kr;
    private WebCardRegisterLiveShopListener ks;
    private bb.b kw;
    private bb.a kx;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private Context mContext;
    private boolean mIsAudioEnable;
    private final l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private KsNativeAd.VideoPlayListener qH;
    private int qJ;
    private int qK;
    private d.a qN;
    private ImageView qZ;
    private RelativeLayout ra;
    private AdBasePvFrameLayout rb;
    private KSAdVideoPlayConfigImpl rc;

    public e(Context context) {
        super(context);
        this.qJ = 0;
        this.qK = 0;
        this.gI = new at.b() { // from class: com.kwad.components.ad.nativead.e.10
            @Override // com.kwad.components.core.webview.jshandler.at.b
            public final void a(at.a aVar) {
                e.this.gD = aVar.status;
                if (e.this.gD != 1) {
                    e.this.mAdWebView.setVisibility(8);
                } else {
                    e.this.mAdWebView.setVisibility(0);
                }
            }
        };
        this.mNetworking = new l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.nativead.e.12
            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return u(str);
            }

            private static AdLiveEndCommonResultData u(String str) {
                AdLiveEndCommonResultData adLiveEndCommonResultData = new AdLiveEndCommonResultData();
                adLiveEndCommonResultData.parseJson(new JSONObject(str));
                return adLiveEndCommonResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: cR, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.liveEnd.a createRequest() {
                return new com.kwad.components.core.liveEnd.a(e.this.kJ);
            }
        };
        this.fU = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.nativead.e.2
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                e.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                if (e.this.qH != null) {
                    e.this.qH.onVideoPlayComplete();
                }
                String strBn = com.kwad.sdk.core.response.b.a.bn(e.this.mAdInfo);
                if (TextUtils.isEmpty(strBn)) {
                    return;
                }
                com.kwad.components.core.p.a.b.a aVar = (com.kwad.components.core.p.a.b.a) com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.b.a.class);
                if (aVar != null) {
                    e.this.kJ = aVar.getAdLiveEndRequest(strBn);
                }
                e.this.mNetworking.request(new o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.nativead.e.2.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onStartRequest(com.kwad.components.core.liveEnd.a aVar2) {
                        super.onStartRequest(aVar2);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(com.kwad.components.core.liveEnd.a aVar2, AdLiveEndCommonResultData adLiveEndCommonResultData) {
                        super.onSuccess(aVar2, adLiveEndCommonResultData);
                        bb.a aVar3 = new bb.a();
                        aVar3.status = 9;
                        aVar3.totalWatchingDuration = adLiveEndCommonResultData.totalWatchingDuration;
                        aVar3.watchingUserCount = adLiveEndCommonResultData.watchingUserCount;
                        aVar3.displayWatchingUserCount = adLiveEndCommonResultData.displayWatchingUserCount;
                        aVar3.likeUserCount = adLiveEndCommonResultData.likeUserCount;
                        aVar3.displayLikeUserCount = adLiveEndCommonResultData.displayLikeUserCount;
                        aVar3.liveDuration = adLiveEndCommonResultData.liveDuration;
                        if (e.this.kw != null) {
                            e.this.kw.a(aVar3);
                        } else {
                            e.this.kx = aVar3;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onError(com.kwad.components.core.liveEnd.a aVar2, int i, String str) {
                        super.onError(aVar2, i, str);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                super.onLivePlayStart();
                com.kwad.components.core.l.a.qD().a(e.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = e.this.jK;
                e eVar = e.this;
                iAdLivePlayModule.setAudioEnabled(eVar.h(eVar.mIsAudioEnable), false);
                if (e.this.qH != null) {
                    e.this.qH.onVideoPlayStart();
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                super.onLivePlayResume();
                com.kwad.components.core.l.a.qD().a(e.this.getCurrentVoiceItem());
                IAdLivePlayModule iAdLivePlayModule = e.this.jK;
                e eVar = e.this;
                iAdLivePlayModule.setAudioEnabled(eVar.h(eVar.mIsAudioEnable), false);
                try {
                    e.this.qH.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                super.onLivePlayPause();
                try {
                    e.this.qH.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                com.kwad.components.core.l.a.qD().a(e.this.getCurrentVoiceItem());
                try {
                    e.this.qH.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
                if (e.this.jK != null) {
                    e.this.jK.setAudioEnabled(false, false);
                }
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                super.onLivePlayCompleted();
                if (e.this.qH != null) {
                    e.this.qH.onVideoPlayComplete();
                }
            }
        };
        this.eo = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.nativead.e.3
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                if (e.this.jK != null) {
                    e.this.jK.setAudioEnabled(false, false);
                }
            }
        };
        initView();
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_native_live_layout, this);
        AdBasePvFrameLayout adBasePvFrameLayout = (AdBasePvFrameLayout) findViewById(R.id.ksad_root_container);
        this.rb = adBasePvFrameLayout;
        this.qZ = (ImageView) adBasePvFrameLayout.findViewById(R.id.ksad_live_bg_img);
        this.jE = (KSRelativeLayout) this.rb.findViewById(R.id.ksad_live_container);
        this.ra = (RelativeLayout) this.rb.findViewById(R.id.ksad_live_video_container);
        KsAdWebView ksAdWebView = (KsAdWebView) this.rb.findViewById(R.id.ksad_web_card_webView);
        this.mAdWebView = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.hc = (com.kwad.components.core.p.a.b.a) com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.b.a.class);
    }

    public final void setInnerAdInteractionListener(d.a aVar) {
        this.qN = aVar;
    }

    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.qH = videoPlayListener;
    }

    public final void a(Context context, AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.mAdInfo = adInfoEP;
        this.mContext = context;
        this.rc = kSAdVideoPlayConfigImpl;
        this.mApkDownloadHelper = cVar;
        this.dX = com.kwad.sdk.core.response.b.a.bv(adInfoEP);
        this.gR = new com.kwad.components.core.widget.a.c(getParent() == null ? this : (View) getParent(), 30);
        if (this.rc.getVideoSoundValue() != 0) {
            this.mIsAudioEnable = this.rc.isVideoSoundEnable();
        } else {
            this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.cj(this.mAdInfo);
        }
        fu();
        fy();
    }

    private void fu() {
        try {
            this.qJ = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStatus;
            this.qK = this.mAdTemplate.mAdScene.nativeAdExtraData.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    private void fy() {
        this.mAdWebView.setVisibility(8);
        bh();
        if (cM()) {
            this.mAdWebView.reload();
        } else {
            bi();
        }
    }

    private void bi() {
        if (com.kwad.sdk.core.response.b.b.dD(this.mAdTemplate)) {
            fz();
        }
    }

    private void fz() {
        bk();
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().fj(this.mAdTemplate));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.gB = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.gB, "KwaiAd");
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.b.ds(this.mAdTemplate));
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.gC.mScreenOrientation = 0;
        this.gC.bLv = null;
        this.gC.Vu = this.rb;
        this.gC.UO = this.mAdWebView;
        this.gC.mReportExtData = null;
        this.gC.bLx = false;
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    private boolean cM() {
        return this.gD == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IAdLivePlayModule cz() {
        cA();
        IAdLiveOfflineView iAdLiveOfflineViewA = com.kwad.components.ad.j.c.a(this.hc, this.mContext, 3);
        this.hb = iAdLiveOfflineViewA;
        if (iAdLiveOfflineViewA == null) {
            return null;
        }
        IAdLivePlayModule adLivePlayModule = this.hc.getAdLivePlayModule(iAdLiveOfflineViewA, ServiceProvider.getSDKConfig().appId, String.valueOf(com.kwad.sdk.core.response.b.a.cD(this.mAdInfo)), com.kwad.sdk.core.response.b.a.cE(this.mAdInfo), com.kwad.sdk.core.response.b.a.cF(this.mAdInfo));
        adLivePlayModule.setAudioEnabled(h(this.mIsAudioEnable), false);
        adLivePlayModule.registerAdLivePlayStateListener(this.fU);
        final View view = this.hb.getView();
        this.ra.removeAllViews();
        this.ra.addView(view);
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.nativead.e.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                e.this.d(view);
            }
        });
        cN();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.u.a.aC(this.mContext).a(this.eo);
        }
        return adLivePlayModule;
    }

    private void cA() {
        String url = com.kwad.sdk.core.response.b.a.bA(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.qZ.setImageDrawable(null);
            KSImageLoader.loadImage(this.qZ, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.nativead.e.5
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            this.qZ.setVisibility(0);
            return;
        }
        this.qZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view) {
        int width = this.jE.getWidth();
        int height = this.jE.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (height * 0.5625f), height);
        layoutParams.addRule(13, -1);
        view.setLayoutParams(layoutParams);
    }

    private void cN() {
        this.hb.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.nativead.e.6
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (e.this.kr != null) {
                    e.this.kr.q(list);
                }
            }
        });
        this.hb.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.nativead.e.7
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (e.this.ks != null) {
                    e.this.ks.a(adLiveShopInfo);
                }
            }
        });
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        this.kp = new bf();
        ba baVar = new ba();
        this.kq = baVar;
        aVar.a(baVar);
        aVar.a(new ac(this.gC, this.mApkDownloadHelper, getClickListener(), (byte) 0));
        aVar.a(new z(this.gC, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new ag(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new ae(this.gC));
        aVar.a(new at(this.gI, com.kwad.sdk.core.response.b.b.dq(this.mAdTemplate)));
        aVar.a(new bd(this.gC, this.mApkDownloadHelper));
        aVar.a(new an(this.gC));
        aVar.b(new com.kwad.components.core.webview.jshandler.o(this.gC));
        aVar.b(new n(this.gC));
        aVar.a(this.kp);
        aVar.a(new ar(getOpenNewPageListener()));
        aVar.a(new g(this.qJ, this.qK));
        this.ks = new WebCardRegisterLiveShopListener();
        this.kr = new WebCardRegisterLiveMessageListener();
        aVar.a(this.ks);
        aVar.a(this.kr);
        aVar.a(new bb(getRegisterLiveListener()));
    }

    private bb.c getRegisterLiveListener() {
        return new bb.c() { // from class: com.kwad.components.ad.nativead.e.8
            @Override // com.kwad.components.core.webview.jshandler.bb.c
            public final void a(bb.b bVar) {
                e.this.kw = bVar;
                if (e.this.kx != null) {
                    e.this.kw.a(e.this.kx);
                    e.this.kx = null;
                }
            }
        };
    }

    private ar.a getOpenNewPageListener() {
        return new ar.a() { // from class: com.kwad.components.ad.nativead.e.9
            @Override // com.kwad.components.core.webview.jshandler.ar.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(e.this.mContext, new AdWebViewActivityProxy.a.C0479a().aE(bVar.title).aF(bVar.url).aE(e.this.mAdTemplate).rk());
            }
        };
    }

    private com.kwad.sdk.core.webview.d.a.a getClickListener() {
        return new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.nativead.e.11
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                int i = aVar.afF;
                if (aVar.QI) {
                    i = aVar.afD ? 1 : 2;
                }
                com.kwad.components.core.e.d.a.a(new a.C0469a(e.this.getContext()).aC(e.this.mAdTemplate).b(e.this.mApkDownloadHelper).aq(false).aG(i).aw(aVar.QI).au(com.kwad.sdk.core.response.b.a.bi(e.this.mAdInfo)).A(e.this.jK == null ? 0L : e.this.jK.getPlayDuration()).ar((aVar.afG == null || TextUtils.isEmpty(aVar.afG.QX)) ? "" : aVar.afG.QX).as(true).a(new a.b() { // from class: com.kwad.components.ad.nativead.e.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        if (e.this.qN != null) {
                            e.this.qN.m(e.this.mAdWebView);
                        }
                    }
                }));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z) {
        if (!z) {
            return false;
        }
        if (this.ho != null) {
            com.kwad.components.core.l.a.qD();
            if (!com.kwad.components.core.l.a.b(this.ho)) {
                return false;
            }
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
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void ae() {
        super.ae();
        this.gR.wK();
        this.gR.a(this);
    }

    @Override // com.kwad.sdk.widget.KSRelativeLayout
    public final void af() {
        super.af();
        this.gR.wK();
        this.gR.b(this);
        IAdLivePlayModule iAdLivePlayModule = this.jK;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onDestroy();
            this.jK = null;
        }
        com.kwad.components.core.l.a.qD().c(this.ho);
        this.kx = null;
        this.kw = null;
        IAdLiveOfflineView iAdLiveOfflineView = this.hb;
        if (iAdLiveOfflineView != null) {
            iAdLiveOfflineView.onDestroy();
            this.hb = null;
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        com.kwad.components.core.l.a.qD().a(getCurrentVoiceItem());
        IAdLivePlayModule iAdLivePlayModule = this.jK;
        if (iAdLivePlayModule == null) {
            this.jK = cz();
        } else {
            iAdLivePlayModule.onResume();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        IAdLivePlayModule iAdLivePlayModule = this.jK;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.onPause();
        }
        com.kwad.components.core.l.a.qD().c(this.ho);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.ho == null) {
            this.ho = new a.b(new a.c() { // from class: com.kwad.components.ad.nativead.e.4
                @Override // com.kwad.components.core.l.a.c
                public final void bK() {
                    if (e.this.jK == null) {
                        e eVar = e.this;
                        eVar.jK = eVar.cz();
                    }
                    if (e.this.jK != null) {
                        IAdLivePlayModule iAdLivePlayModule = e.this.jK;
                        e eVar2 = e.this;
                        iAdLivePlayModule.setAudioEnabled(eVar2.h(eVar2.mIsAudioEnable), false);
                    }
                }
            });
        }
        return this.ho;
    }
}
