package com.kwad.components.ad.feed.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ad.feed.d;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.l.a;
import com.kwad.components.core.liveEnd.AdLiveEndCommonResultData;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveMessageListener;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.au;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
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
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.widget.KSRelativeLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class r extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements View.OnClickListener, com.kwad.sdk.widget.e {
    private static final HashMap<Long, Double> kt = new HashMap<>(8);
    private KsAdVideoPlayConfig dG;
    private List<Integer> dX;
    private boolean ec;
    private com.kwad.sdk.core.video.videoview.a ed;
    private a.InterfaceC0593a em;
    private OfflineOnAudioConflictListener eo;
    private final AdLivePlayStateListener fU;
    private int gD;
    private IAdLiveOfflineView hb;
    private com.kwad.components.core.p.a.b.a hc;
    private a.b ho;
    private View hq;
    private d.InterfaceC0409d iZ;
    private boolean isNative;
    private KSRelativeLayout jE;
    private ImageView jF;
    private com.kwad.components.core.video.f jG;
    private d jH;
    private final a.InterfaceC0488a jJ;
    private IAdLivePlayModule jK;
    private boolean jL;
    private long jm;
    private float jn;
    private float jo;
    private a kA;
    private ViewGroup.MarginLayoutParams kB;
    private e kC;
    private au kD;
    private boolean kE;
    private boolean kF;
    private com.kwad.components.core.webview.b kG;
    private com.kwad.components.core.webview.c kH;
    private b.a kI;
    private IAdLiveEndRequest kJ;
    private RatioFrameLayout kl;
    private double km;
    private LinearLayout kn;
    private TextView ko;
    private bf kp;
    private ba kq;
    private WebCardRegisterLiveMessageListener kr;
    private WebCardRegisterLiveShopListener ks;
    private boolean ku;
    private String kv;
    private bb.b kw;
    private bb.a kx;
    private com.kwad.components.core.widget.b ky;
    private boolean kz;
    private KsAdWebView mAdWebView;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private Handler mHandler;
    private boolean mIsAudioEnable;
    private final com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData> mNetworking;
    private int mWidth;

    public interface a {
        void d(int i, String str);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
    }

    static /* synthetic */ boolean a(r rVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    static /* synthetic */ boolean a(r rVar, boolean z) {
        rVar.ec = false;
        return false;
    }

    static /* synthetic */ boolean d(r rVar, boolean z) {
        rVar.kE = true;
        return true;
    }

    public r(Context context) {
        super(context);
        this.gD = -1;
        this.mIsAudioEnable = false;
        this.isNative = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.kE = false;
        this.kF = false;
        this.eo = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.feed.widget.r.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                r.a(r.this, false);
                if (r.this.ed != null) {
                    r.this.ed.setVideoSoundEnable(false);
                }
                if (r.this.jK != null) {
                    r.this.jK.setAudioEnabled(false, false);
                }
            }
        };
        this.kH = new AnonymousClass12();
        this.kI = new b.a() { // from class: com.kwad.components.ad.feed.widget.r.14
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (r.this.akg != null) {
                    r.this.akg.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (r.this.akg != null && r.this.isNative) {
                    r.this.akg.onAdShow();
                }
                if (r.this.isNative) {
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0576a c0576a = new a.C0576a();
                    FeedType feedTypeFromInt = FeedType.fromInt(r.this.mAdTemplate.type, r.this.mAdTemplate.defaultType);
                    if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c0576a.templateId = String.valueOf(feedTypeFromInt.getType());
                    bVar.b(c0576a);
                    bVar.G((int) Math.ceil(r.this.km), r.this.mWidth);
                    com.kwad.components.core.u.b.tq().a(r.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.c(r.this.mAdTemplate, 1, 2);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (r.this.akg != null) {
                    r.this.akg.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (r.this.akg != null) {
                    r.this.akg.onDownloadTipsDialogShow();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (r.this.akg != null) {
                    r.this.akg.onDownloadTipsDialogDismiss();
                }
            }
        };
        this.mNetworking = new com.kwad.sdk.core.network.l<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.widget.r.16
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
                return new com.kwad.components.core.liveEnd.a(r.this.kJ);
            }
        };
        this.fU = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.r.17
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                super.onLivePrepared();
                r.this.jK.setAudioEnabled(false, false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(long j) {
                super.onLivePlayProgress(j);
                r.this.c(j);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                super.onLivePlayEnd();
                String strBn = com.kwad.sdk.core.response.b.a.bn(r.this.mAdInfo);
                if (TextUtils.isEmpty(strBn)) {
                    return;
                }
                com.kwad.components.core.p.a.b.a aVar = (com.kwad.components.core.p.a.b.a) com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.b.a.class);
                if (aVar != null) {
                    r.this.kJ = aVar.getAdLiveEndRequest(strBn);
                }
                r.this.mNetworking.request(new com.kwad.sdk.core.network.o<com.kwad.components.core.liveEnd.a, AdLiveEndCommonResultData>() { // from class: com.kwad.components.ad.feed.widget.r.17.1
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
                        if (r.this.kw != null) {
                            r.this.kw.a(aVar3);
                        } else {
                            r.this.kx = aVar3;
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
                com.kwad.components.core.l.a.qD().a(r.this.getCurrentVoiceItem());
                super.onLivePlayStart();
                IAdLivePlayModule iAdLivePlayModule = r.this.jK;
                r rVar = r.this;
                iAdLivePlayModule.setAudioEnabled(rVar.h(rVar.mIsAudioEnable), false);
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                com.kwad.components.core.l.a.qD().a(r.this.getCurrentVoiceItem());
                super.onLivePlayResume();
                IAdLivePlayModule iAdLivePlayModule = r.this.jK;
                r rVar = r.this;
                iAdLivePlayModule.setAudioEnabled(rVar.h(rVar.mIsAudioEnable), false);
            }
        };
        this.jJ = new a.InterfaceC0488a() { // from class: com.kwad.components.ad.feed.widget.r.11
            @Override // com.kwad.components.core.video.a.InterfaceC0488a
            public final void a(int i, aj.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 13;
                } else if (i == 2) {
                    i2 = 82;
                } else if (i != 3) {
                    i2 = 108;
                } else {
                    i2 = 83;
                    i3 = 1;
                    z = true;
                }
                r.this.cL();
                com.kwad.components.core.e.d.a.a(new a.C0469a(r.this.getContext()).aC(r.this.mAdTemplate).b(r.this.mApkDownloadHelper).aG(i3).aq(z).as(true).aF(i2).d(aVar).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.r.11.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        r.this.wx();
                    }
                }));
            }
        };
    }

    public final void setWidth(int i) {
        if (i <= 0) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.f fVar;
        IAdLivePlayModule iAdLivePlayModule;
        this.dG = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                this.mIsAudioEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                if (this.mAdTemplate != 0) {
                    this.mAdTemplate.mIsAudioEnable = this.mIsAudioEnable;
                }
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
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (fVar = this.jG) == null) {
                return;
            }
            fVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (!com.kwad.sdk.core.config.e.Yz() || !com.kwad.sdk.core.response.b.d.eE(this.mAdTemplate)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (com.kwad.sdk.core.response.b.b.cI(this.mAdTemplate) == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        b(motionEvent);
        if ((action == 2 || action == 3) && this.mAdWebView != null && !this.isNative && Math.abs(motionEvent.getX() - this.jn) > 0.0f) {
            this.mAdWebView.requestDisallowInterceptTouchEvent(true);
            double dAbs = Math.abs(motionEvent.getX() - this.jn);
            double dAbs2 = Math.abs(motionEvent.getY() - this.jo);
            if (Math.tan(r1.maxRange) * dAbs < dAbs2 || Math.tan(r1.minRange) * dAbs < dAbs2) {
                this.mAdWebView.requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return;
        }
        this.jn = motionEvent.getX();
        this.jo = motionEvent.getY();
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

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_webview;
    }

    @Override // com.kwad.components.core.widget.b
    public final void bB() {
        com.kwad.components.ad.feed.monitor.b.cn();
        this.kl = (RatioFrameLayout) findViewById(R.id.ksad_container);
        this.jE = (KSRelativeLayout) findViewById(R.id.ksad_feed_ad_video_container);
        this.kn = (LinearLayout) findViewById(R.id.ksad_video_immerse_text_container);
        this.ko = (TextView) findViewById(R.id.ksad_video_immerse_text);
        this.jF = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.hq = findViewById(R.id.ksad_live_end_bg_mantle);
    }

    private void q(AdTemplate adTemplate) {
        if (this.kF) {
            return;
        }
        if (com.kwad.sdk.core.response.b.a.df(com.kwad.sdk.core.response.b.e.eP(adTemplate))) {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_bottom_card_webView);
        } else {
            this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_web_default_bottom_card_webView);
        }
        this.kF = true;
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(AdResultData adResultData) throws NumberFormatException {
        AdTemplate adTemplateS = com.kwad.sdk.core.response.b.c.s(adResultData);
        q(adTemplateS);
        adTemplateS.realShowType = 2;
        super.d((r) adResultData);
        if (this.ku) {
            com.kwad.components.core.widget.b bVar = this.ky;
            if (bVar != null) {
                bVar.d(adResultData);
                com.kwad.components.core.widget.b bVar2 = this.ky;
                if (bVar2 instanceof c) {
                    ((c) bVar2).b(this.dG);
                    return;
                }
                return;
            }
            return;
        }
        if (!com.kwad.sdk.core.response.b.b.dz(this.mAdTemplate)) {
            a("0", 0, 1);
            return;
        }
        if (!cM()) {
            s(this.mAdTemplate);
        }
        try {
            String str = this.kv;
            if (str == null || !str.equals(adTemplateS.mOriginJString)) {
                if (cM()) {
                    this.mAdWebView.reload();
                } else {
                    this.gD = -2;
                    bi();
                }
            }
        } catch (Throwable unused) {
            a("0", 0, 2);
        }
        this.kv = adTemplateS.mOriginJString;
    }

    @Override // com.kwad.components.core.widget.b
    public final void cv() throws NumberFormatException {
        super.cv();
        if (this.gD == 1 || this.ku) {
            return;
        }
        this.mAdWebView.stopLoading();
        this.mAdWebView.setVisibility(8);
        a("0", 1, 3);
    }

    public final void setPreloadListener(a aVar) {
        a aVar2 = this.kA;
        if (aVar2 != null) {
            aVar2.d(this.gD == 1 ? 2 : 1, "");
        }
        this.kA = aVar;
    }

    private static float r(AdTemplate adTemplate) {
        int i = adTemplate.type;
        if (i == 1) {
            return 0.6013f;
        }
        return (i == 2 || i == 3) ? 0.283f : 0.968f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void s(AdTemplate adTemplate) {
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
        if (kt.get(Long.valueOf(this.mAdTemplate.posId)) != null) {
            this.kl.setRatio(r5.floatValue());
        } else if (com.kwad.sdk.core.response.b.b.dy(this.mAdTemplate) > 0.0d) {
            this.kl.setRatio(com.kwad.sdk.core.response.b.b.dy(this.mAdTemplate));
        } else if (this.kl.getRatio() == 0.0d) {
            this.kl.setRatio(r(this.mAdTemplate));
        }
        com.kwad.components.core.p.a.b.a aVar = (com.kwad.components.core.p.a.b.a) com.kwad.sdk.components.d.g(com.kwad.components.core.p.a.b.a.class);
        this.hc = aVar;
        if (aVar != null && aVar.qI() && com.kwad.sdk.core.response.b.a.df(this.mAdInfo)) {
            this.jL = true;
        }
    }

    private void bi() {
        com.kwad.components.core.webview.b bVar = this.kG;
        if (bVar != null) {
            bVar.kD();
        }
        this.mAdWebView.setVisibility(4);
        this.mAdWebView.setBackgroundColor(0);
        this.kG = new com.kwad.components.core.webview.b();
        this.kG.a(new b.a().aN(this.mAdTemplate).aX(com.kwad.sdk.core.response.b.b.dq(this.mAdTemplate)).d(this.mAdWebView).k(this.kl).f(this.mApkDownloadHelper).a(this.kH));
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.b.b.dq(this.mAdTemplate));
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, com.kwad.sdk.core.response.b.b.dq(this.mAdTemplate));
        cJ();
    }

    /* renamed from: com.kwad.components.ad.feed.widget.r$12, reason: invalid class name */
    final class AnonymousClass12 extends com.kwad.components.core.webview.c {
        AnonymousClass12() {
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            bVar.bLx = false;
            aVar.a(new com.kwad.components.core.webview.jshandler.h(r.this.mAdTemplate.loadType));
            r.this.kp = new bf();
            aVar.a(r.this.kp);
            aVar.a(new ar(r.this.getOpenNewPageListener()));
            aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.feed.widget.r.12.1
                @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
                public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                    if (r.this.mAdInfo != null) {
                        if (com.kwad.sdk.core.response.b.a.bi(r.this.mAdInfo) || r.this.jL) {
                            r.this.kB = (ViewGroup.MarginLayoutParams) r.this.jE.getLayoutParams();
                            int iCeil = (int) Math.ceil(r.this.km);
                            int i = r.this.mWidth;
                            if (videoPosition.widthRation == 0.0d) {
                                videoPosition.widthRation = 0.9200000166893005d;
                                videoPosition.leftMarginRation = 0.03999999910593033d;
                            }
                            r.this.kB.topMargin = (int) (videoPosition.topMarginRation * iCeil);
                            double d = i;
                            r.this.kB.leftMargin = (int) (videoPosition.leftMarginRation * d);
                            r.this.kB.width = (int) (d * videoPosition.widthRation);
                            r.this.kB.height = (int) (r.this.kB.width * videoPosition.heightWidthRation);
                            r.this.jE.setRadius(videoPosition.borderRadius);
                            r.this.jE.setLayoutParams(r.this.kB);
                            r.this.jE.setVisibility(0);
                            if ((r.this.dG instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) r.this.dG).getVideoSoundValue() != 0) {
                                r.this.mIsAudioEnable = r.this.dG.isVideoSoundEnable();
                            } else {
                                r.this.mIsAudioEnable = com.kwad.sdk.core.response.b.a.cj(r.this.mAdInfo);
                            }
                            r.this.mAdTemplate.mIsAudioEnable = r.this.mIsAudioEnable;
                            r.this.dX = com.kwad.sdk.core.response.b.a.bv(r.this.mAdInfo);
                            if (!r.this.jL) {
                                r.this.b(r.this.dG);
                            } else if (r.this.jK != null) {
                                r.this.jK.setAudioEnabled(r.this.h(r.this.mIsAudioEnable), false);
                            }
                        }
                    }
                }
            }));
            aVar.a(new ad(bVar, new ad.a() { // from class: com.kwad.components.ad.feed.widget.r.12.2
                @Override // com.kwad.components.core.webview.jshandler.ad.a
                public final void cP() {
                    r.this.mHandler.post(new bh() { // from class: com.kwad.components.ad.feed.widget.r.12.2.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            r.this.wy();
                        }
                    });
                }
            }));
            aVar.a(new bc(new bc.a() { // from class: com.kwad.components.ad.feed.widget.r.12.3
                @Override // com.kwad.components.core.webview.jshandler.bc.a
                public final void cQ() {
                    r.d(r.this, true);
                    r.this.cK();
                }
            }));
            r.this.kD = new au();
            aVar.a(r.this.kD);
            if (r.this.jL) {
                aVar.a(new com.kwad.components.core.webview.jshandler.g(1, 1));
                r.this.ks = new WebCardRegisterLiveShopListener();
                r.this.kr = new WebCardRegisterLiveMessageListener();
                aVar.a(r.this.ks);
                aVar.a(r.this.kr);
                aVar.a(new bb(r.this.getRegisterLiveListener()));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(ba baVar) {
            r.this.kq = baVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void onAdShow() {
            super.onAdShow();
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ad.feed.widget.r.12.4
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    if (r.this.akg == null || r.this.isNative) {
                        return;
                    }
                    r.this.akg.onAdShow();
                    com.kwad.components.ad.feed.monitor.b.c(r.this.mAdTemplate, 2, 2);
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(am.a aVar) {
            if (r.this.isNative) {
                return;
            }
            r.this.mAdWebView.setVisibility(0);
            if (r.this.km == 0.0d) {
                r.this.km = aVar.height;
                r.this.kl.setRatio((float) r0);
                r.kt.put(Long.valueOf(r.this.mAdTemplate.posId), Double.valueOf(aVar.height / r.this.mWidth));
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void b(ae.a aVar) {
            aVar.height = 0;
            aVar.width = r.this.mWidth;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            r.this.cL();
            int i = aVar.afF;
            if (aVar.QI) {
                i = aVar.afD ? 1 : 2;
            }
            com.kwad.components.core.e.d.a.a(new a.C0469a(r.this.getContext()).aC(r.this.mAdTemplate).b(r.this.mApkDownloadHelper).aq(r.a(r.this, aVar)).aG(i).aF(aVar.oz).ar((aVar.afG == null || TextUtils.isEmpty(aVar.afG.QX)) ? "" : aVar.afG.QX).aE(5).aw(aVar.QI).au(com.kwad.sdk.core.response.b.a.bi(r.this.mAdInfo)).A(r.this.jK == null ? 0L : r.this.jK.getPlayDuration()).as(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.r.12.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (r.this.akg != null) {
                        r.this.akg.onAdClicked();
                    }
                }
            }));
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(at.a aVar) throws NumberFormatException {
            if (r.this.ku) {
                return;
            }
            r.this.gD = aVar.status;
            if (r.this.gD != 1) {
                r.this.a("3", 3, 4);
                return;
            }
            r.this.mHandler.removeCallbacksAndMessages(null);
            if (r.this.ky != null) {
                r.this.ky.setVisibility(8);
            }
            r.this.mAdWebView.setVisibility(0);
            com.kwad.components.core.q.a.ss().aJ(r.this.mAdTemplate);
            if (r.this.kA != null) {
                r.this.kA.d(2, "");
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void h(int i, String str) throws NumberFormatException {
            r.this.a("1", 2, 5);
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, com.kwad.sdk.core.response.b.b.dq(r.this.mAdTemplate), System.currentTimeMillis() - r.this.mAdWebView.getLoadTime());
        }
    }

    private void cJ() {
        this.mHandler.postDelayed(new bh() { // from class: com.kwad.components.ad.feed.widget.r.13
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() throws NumberFormatException {
                r.this.mAdWebView.stopLoading();
                r.this.mAdWebView.setVisibility(8);
                r.this.a("0", 1, 6);
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2) throws NumberFormatException {
        int i3;
        com.kwad.sdk.core.d.c.d("FeedWebView", "handleWebViewError " + str);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ku) {
            return;
        }
        this.ku = true;
        if (this.mAdWebView != null) {
            com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, com.kwad.sdk.core.response.b.b.dq(this.mAdTemplate), System.currentTimeMillis() - this.mAdWebView.getLoadTime(), i);
        }
        com.kwad.components.core.q.a.ss().b(this.mAdTemplate, com.kwad.sdk.core.response.b.b.dq(this.mAdTemplate), str);
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            com.kwad.sdk.core.d.c.d("FeedWebView", "handleWebViewError errorCode exception" + str);
            i3 = 0;
        }
        com.kwad.components.ad.feed.monitor.b.a(i3, com.kwad.sdk.core.response.b.a.bk(this.mAdInfo), this.mAdTemplate, i2);
        a aVar = this.kA;
        if (aVar != null) {
            aVar.d(1, str);
        }
        this.kA = null;
        if (this.ky == null) {
            this.isNative = true;
            c((ViewGroup) this);
            int iBk = com.kwad.sdk.core.response.b.a.bk(this.mAdInfo);
            IAdLivePlayModule iAdLivePlayModule = this.jK;
            if (iAdLivePlayModule != null) {
                iAdLivePlayModule.setAudioEnabled(false, false);
                this.jK.onDestroy();
                this.jK = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = this.hb;
            if (iAdLiveOfflineView != null) {
                iAdLiveOfflineView.onDestroy();
                this.hb = null;
            }
            com.kwad.components.core.widget.b bVarA = com.kwad.components.ad.feed.b.a(this.mContext, FeedType.fromInt(this.mAdTemplate.type, this.mAdTemplate.defaultType), iBk);
            this.ky = bVarA;
            if (bVarA != null) {
                this.ky.setMargin(com.kwad.sdk.c.a.a.a(this.mContext, 16.0f));
                this.kl.removeAllViews();
                this.kl.setRatio(0.0d);
                KsAdWebView ksAdWebView = this.mAdWebView;
                if (ksAdWebView != null) {
                    ksAdWebView.setVisibility(8);
                }
                this.jE.setVisibility(8);
                this.ky.setInnerAdInteractionListener(this.kI);
                this.kl.addView(this.ky);
                this.ky.d(this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.ky;
                if (bVar instanceof c) {
                    ((c) bVar).b(this.dG);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bb.c getRegisterLiveListener() {
        return new bb.c() { // from class: com.kwad.components.ad.feed.widget.r.15
            @Override // com.kwad.components.core.webview.jshandler.bb.c
            public final void a(bb.b bVar) {
                r.this.kw = bVar;
                if (r.this.kx != null) {
                    r.this.kw.a(r.this.kx);
                    r.this.kx = null;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK() {
        float fDv = com.kwad.sdk.core.response.b.b.dv(this.mAdTemplate);
        this.iZ = new d.InterfaceC0409d() { // from class: com.kwad.components.ad.feed.widget.r.18
            @Override // com.kwad.components.ad.feed.d.InterfaceC0409d
            public final boolean e(final double d) {
                if (!ca.v(r.this.kl, (int) (com.kwad.sdk.core.config.e.Yu() * 100.0f)) || !r.this.fv()) {
                    return false;
                }
                com.kwad.components.core.e.d.a.a(new a.C0469a(r.this.getContext()).aC(r.this.mAdTemplate).b(r.this.mApkDownloadHelper).aG(2).aq(false).as(false).aF(157).aE(5).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.r.18.1
                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.d.c.d("FeedWebView", "convertEnable End" + com.kwad.sdk.core.response.b.e.eV(r.this.mAdTemplate));
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.o(d);
                        bVar.eP(157);
                        r.this.c(bVar);
                    }
                }));
                return true;
            }
        };
        com.kwad.components.ad.feed.d.a(fDv, this.mContext, this.iZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ar.a getOpenNewPageListener() {
        return new ar.a() { // from class: com.kwad.components.ad.feed.widget.r.19
            @Override // com.kwad.components.core.webview.jshandler.ar.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(r.this.mContext, new AdWebViewActivityProxy.a.C0479a().aE(bVar.title).aF(bVar.url).aG(true).aE(r.this.mAdTemplate).rk());
            }
        };
    }

    @Override // com.kwad.components.core.widget.b
    public final void aa() {
        ba baVar;
        if (!this.mAdTemplate.mPvReported && this.akg != null && this.isNative) {
            this.akg.onAdShow();
            com.kwad.components.ad.feed.monitor.b.c(this.mAdTemplate, 1, 2);
        }
        if (this.isNative || (baVar = this.kq) == null) {
            return;
        }
        baVar.ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL() {
        if (this.kz) {
            return;
        }
        this.kz = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 2, getStayTime());
    }

    private boolean cM() {
        return this.gD == 1;
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void by() {
        super.by();
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

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.ho == null) {
            this.ho = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.widget.r.2
                @Override // com.kwad.components.core.l.a.c
                public final void bK() {
                    if (r.this.jL) {
                        if (r.this.jK == null) {
                            r rVar = r.this;
                            rVar.jK = rVar.cz();
                        }
                        IAdLivePlayModule iAdLivePlayModule = r.this.jK;
                        r rVar2 = r.this;
                        iAdLivePlayModule.setAudioEnabled(rVar2.h(rVar2.mIsAudioEnable), false);
                        return;
                    }
                    if (r.this.ed != null) {
                        com.kwad.sdk.core.video.videoview.a aVar = r.this.ed;
                        r rVar3 = r.this;
                        aVar.setVideoSoundEnable(rVar3.h(rVar3.mIsAudioEnable));
                    }
                }
            });
        }
        return this.ho;
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
        if (this.jE.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.jE;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.jE.setTag(null);
        }
        this.jE.addView(view);
        this.jE.setTag(view);
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.feed.widget.r.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                r.this.d(view);
            }
        });
        cN();
        if (this.mIsAudioEnable) {
            com.kwad.components.core.u.a.aC(this.mContext).a(this.eo);
        }
        return adLivePlayModule;
    }

    private void cN() {
        this.hb.registerLiveMessageListener(new AdLiveMessageListener() { // from class: com.kwad.components.ad.feed.widget.r.4
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveMessageListener
            public final void handleAdLiveMessage(List<AdLiveMessageInfo> list) {
                if (r.this.kr != null) {
                    r.this.kr.q(list);
                }
            }
        });
        this.hb.registerLiveShopListener(new AdLiveShopListener() { // from class: com.kwad.components.ad.feed.widget.r.5
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveShopListener
            public final void handleAdLiveShop(AdLiveShopInfo adLiveShopInfo) {
                if (r.this.ks != null) {
                    r.this.ks.a(adLiveShopInfo);
                }
            }
        });
    }

    private void cA() {
        String url = com.kwad.sdk.core.response.b.a.bA(this.mAdInfo).getUrl();
        this.jF.setVisibility(0);
        this.hq.setVisibility(0);
        if (!TextUtils.isEmpty(url)) {
            this.jF.setImageDrawable(null);
            KSImageLoader.loadImage(this.jF, url, this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.widget.r.6
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

    public final void b(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        String strGa;
        String url = com.kwad.sdk.core.response.b.a.bA(this.mAdInfo).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.jF.setImageDrawable(null);
            KSImageLoader.loadImage(this.jF, url, this.mAdTemplate);
            this.jF.setVisibility(0);
        } else {
            this.jF.setVisibility(8);
        }
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.ed = aVar;
        aVar.setTag(this.dX);
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
        this.ed.a(new b.a(this.mAdTemplate).ew(strL).ex(com.kwad.sdk.core.response.b.h.e(com.kwad.sdk.core.response.b.e.eQ(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).WR(), null);
        a.InterfaceC0593a interfaceC0593a = new a.InterfaceC0593a() { // from class: com.kwad.components.ad.feed.widget.r.7
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0593a
            public final com.kwad.sdk.core.video.a.c aw() {
                int i = Build.VERSION.SDK_INT;
                return null;
            }
        };
        this.em = interfaceC0593a;
        this.ed.setExternalPlayerListener(interfaceC0593a);
        this.ed.setVideoSoundEnable(h(this.mIsAudioEnable));
        this.jG = new com.kwad.components.core.video.f(this.mContext, this.mAdTemplate, this.ed, ksAdVideoPlayConfig);
        this.jm = SystemClock.elapsedRealtime();
        this.jG.setVideoPlayCallback(getVideoPlayCallback());
        this.jG.setAdClickListener(this.jJ);
        this.ed.setController(this.jG);
        if (this.jE.getTag() != null) {
            KSRelativeLayout kSRelativeLayout = this.jE;
            kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
            this.jE.setTag(null);
        }
        this.jE.addView(this.ed, 1);
        this.jE.setTag(this.ed);
        this.jE.setClickable(true);
        new com.kwad.sdk.widget.j(this.jE, this);
        if (this.mIsAudioEnable) {
            com.kwad.components.core.u.a.aC(this.mContext).a(this.eo);
        }
        if (this.mAdTemplate.type == 1 || this.mAdTemplate.type == 19) {
            this.kn.setVisibility(0);
            this.ko.setVisibility(0);
            this.ko.setText(com.kwad.components.ad.feed.f.m(this.mAdTemplate));
            new com.kwad.sdk.widget.j(this.ko, this);
        }
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        if (view == this.jE) {
            if (this.ed.isIdle()) {
                com.kwad.sdk.utils.n.fl(this.mAdTemplate);
                this.ed.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate));
                this.ed.start();
                return;
            }
            a(this.ed, 100);
            return;
        }
        if (view == this.ko) {
            a(this.ed, 25);
        }
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eE(this.mAdTemplate)) {
            if (view == this.jE || view == this.ko) {
                a(this.ed, 153);
            }
        }
    }

    private a.b getVideoPlayCallback() {
        return new a.b() { // from class: com.kwad.components.ad.feed.widget.r.8
            private boolean gq = false;

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                r.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.components.core.l.a.qD().a(r.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.L(r.this.mAdInfo), null, SystemClock.elapsedRealtime() - r.this.jm);
                com.kwad.sdk.core.adlog.c.cm(r.this.mAdTemplate);
                r.this.kp.bn(3);
                if (r.this.jH != null && (r.this.jH.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) r.this.jH.getParent()).removeView(r.this.jH);
                    r.this.jH.cE();
                    r.this.jH = null;
                }
                if (r.this.kC == null && com.kwad.sdk.core.response.b.b.dt(r.this.mAdTemplate) && r.this.kE) {
                    r.this.kC = new e(r.this.mContext);
                    r.this.jE.addView(r.this.kC, new FrameLayout.LayoutParams(-1, -1));
                    r.this.kC.setOnViewEventListener(new com.kwad.sdk.widget.e() { // from class: com.kwad.components.ad.feed.widget.r.8.1
                        @Override // com.kwad.sdk.widget.e
                        public final void a(View view) {
                            if (com.kwad.sdk.core.response.b.b.du(r.this.mAdTemplate)) {
                                return;
                            }
                            r.this.E(158);
                        }

                        @Override // com.kwad.sdk.widget.e
                        public final void b(View view) {
                            if (com.kwad.sdk.core.response.b.b.du(r.this.mAdTemplate) || !com.kwad.sdk.core.response.b.d.eE(r.this.mAdTemplate)) {
                                return;
                            }
                            r.this.E(153);
                        }
                    });
                    r.this.kC.a(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.widget.r.8.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            super.onAnimationEnd(animator);
                            r.this.kD.bm(1);
                            r.this.jE.removeView(r.this.kC);
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void au() {
                if (!this.gq) {
                    this.gq = true;
                    com.kwad.components.core.q.a.ss().a(r.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                com.kwad.sdk.core.video.videoview.a aVar = r.this.ed;
                r rVar = r.this;
                aVar.setVideoSoundEnable(rVar.h(rVar.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void av() {
                com.kwad.sdk.core.adlog.c.cn(r.this.mAdTemplate);
                r.this.kp.bn(9);
                r.this.jE.setVisibility(8);
                if (com.kwad.components.ad.feed.a.b.ck() && r.this.jH == null && !r.this.kE) {
                    r.this.jH = new d(r.this.mContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    r rVar = r.this;
                    rVar.addView(rVar.jH, layoutParams);
                    r.this.jH.cD();
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.L(r.this.mAdInfo), i + " " + i2, SystemClock.elapsedRealtime() - r.this.jm);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final int i) {
        cL();
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(1).aq(true).aF(i).aE(5).as(false).au(true).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.r.9
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                r.this.bg(i);
            }
        }));
    }

    private void a(com.kwad.sdk.core.video.videoview.a aVar, final int i) {
        if (aVar != null) {
            String strL = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
            this.jG.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().a(strL, this.ed);
            FeedType.fromInt(this.mAdTemplate.type, this.mAdTemplate.defaultType);
            cL();
            com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(2).au(com.kwad.sdk.core.response.b.a.bi(this.mAdInfo)).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.r.10
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    r.this.bg(i);
                }
            }));
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

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        IAdLivePlayModule iAdLivePlayModule;
        ViewGroup viewGroup;
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
                if (aVar != null && (viewGroup = (ViewGroup) aVar.getParent()) != this.jE) {
                    viewGroup.removeView(this.ed);
                    if (this.jE.getTag() != null) {
                        KSRelativeLayout kSRelativeLayout = this.jE;
                        kSRelativeLayout.removeView((View) kSRelativeLayout.getTag());
                        this.jE.setTag(null);
                    }
                    this.jE.addView(this.ed);
                    this.jE.setTag(this.ed);
                    this.ed.setVideoSoundEnable(this.mIsAudioEnable);
                    this.jG.setVideoPlayCallback(getVideoPlayCallback());
                    this.jG.setAdClickListener(this.jJ);
                    this.jG.getAdTemplate().mAdWebVideoPageShowing = false;
                    this.jG.us();
                    this.jG.setAutoRelease(true);
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
        if (iAdLiveOfflineView == null || iAdLiveOfflineView.getView() == null || this.jK == null) {
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
            this.jK.setAudioEnabled(h(this.mIsAudioEnable), false);
            IAdLivePlayModule adLivePlayModule = this.hc.getAdLivePlayModule(this.hb, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.b.a.cD(this.mAdInfo)), com.kwad.sdk.core.response.b.a.cE(this.mAdInfo), com.kwad.sdk.core.response.b.a.cF(this.mAdInfo));
            this.jK = adLivePlayModule;
            adLivePlayModule.registerAdLivePlayStateListener(this.fU);
        }
        this.jK.onResume();
        return true;
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        if (aVar.QI) {
            return aVar.afD;
        }
        return aVar.afF == 1;
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        if (this.iZ != null) {
            com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.b.b.dv(this.mAdTemplate), this.mContext, this.iZ);
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        this.mHandler.removeCallbacksAndMessages(null);
        com.kwad.sdk.utils.n.fk(this.mAdTemplate);
        d.InterfaceC0409d interfaceC0409d = this.iZ;
        if (interfaceC0409d != null) {
            com.kwad.components.ad.feed.d.a(interfaceC0409d);
        }
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
        this.kw = null;
        this.kx = null;
    }
}
