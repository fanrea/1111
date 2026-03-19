package com.kwad.components.ct.home.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.h;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.bf;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.b.f;
import com.kwad.components.core.webview.tachikoma.b.g;
import com.kwad.components.core.webview.tachikoma.c.l;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private WebView UO;
    private ViewGroup Vu;
    private c aIF;
    private com.kwad.components.ct.home.a.a aIG;
    private KSFrameLayout aIH;
    private FrameLayout aII;
    private int aIJ;
    private KSFrameLayout aIK;
    private b aIL;
    private a aIM;
    private List<Integer> dX;
    private com.kwad.sdk.core.video.videoview.a ed;
    private a.InterfaceC0593a em;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;
    private ViewGroup.MarginLayoutParams kB;
    private bf kp;
    protected AdInfo mAdInfo;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private int Vt = -1;
    private volatile boolean mIsReleased = false;
    private final KsAdVideoPlayConfig dG = new KsAdVideoPlayConfig.Builder().videoSoundEnable(true).dataFlowAutoStart(com.kwad.sdk.core.config.e.Ym()).build();
    private final am.b gG = new am.b() { // from class: com.kwad.components.ct.home.a.e.1
        @Override // com.kwad.components.core.webview.jshandler.am.b
        public final void a(am.a aVar) {
            com.kwad.sdk.core.d.c.d("[IAd]WebCard", "onAdFrameValid=" + aVar);
            if (e.this.UO != null) {
                e.this.UO.setTranslationY(aVar.height + aVar.bottomMargin);
            }
        }
    };
    private final com.kwad.sdk.core.webview.d.a.a gF = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ct.home.a.e.8
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (e.this.aIM.aIS) {
                e.this.cp(0);
            }
        }
    };
    private final at.b gI = new at.b() { // from class: com.kwad.components.ct.home.a.e.9
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            e.this.Vt = aVar.status;
            if (e.this.aIF != null) {
                e.this.aIF.aV(aVar.status);
            }
        }
    };
    private final al.b gH = new al.b() { // from class: com.kwad.components.ct.home.a.e.10
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            e.this.cp(aVar.type);
        }
    };
    private final a.InterfaceC0488a abz = new a.InterfaceC0488a() { // from class: com.kwad.components.ct.home.a.e.15
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
                i2 = 121;
            } else {
                i2 = 83;
                i3 = 1;
                z = true;
            }
            com.kwad.components.core.e.d.a.a(new a.C0469a(e.this.aIK.getContext()).aC(e.this.mAdTemplate).b(e.this.mApkDownloadHelper).aG(i3).aq(z).as(true).aF(i2).aH(e.this.aIM.aIQ).d(aVar).a(new a.b() { // from class: com.kwad.components.ct.home.a.e.15.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (e.this.aIM.aIS) {
                        e.this.cp(0);
                    }
                }
            }));
        }
    };

    static /* synthetic */ int a(e eVar, WebCardVideoPositionHandler.VideoPosition videoPosition, int i) {
        return b(videoPosition, i);
    }

    static /* synthetic */ int b(e eVar, WebCardVideoPositionHandler.VideoPosition videoPosition, int i) {
        return a(videoPosition, i);
    }

    static /* synthetic */ int c(e eVar, WebCardVideoPositionHandler.VideoPosition videoPosition, int i) {
        return c(videoPosition, i);
    }

    public final void a(a aVar) {
        this.aIM = aVar;
        CtAdTemplate ctAdTemplate = aVar.mAdTemplate;
        this.mAdTemplate = ctAdTemplate;
        AdInfo adInfoEP = com.kwad.components.ct.response.a.a.eP(ctAdTemplate);
        this.mAdInfo = adInfoEP;
        if (com.kwad.sdk.core.response.b.a.aJ(adInfoEP)) {
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        this.Vu = aVar.lz;
        this.aIJ = aVar.aIQ;
        this.aIG = new com.kwad.components.ct.home.a.a();
        View viewA = m.a(this.Vu.getContext(), R.layout.ksad_content_interstitial_ad_layout, this.Vu, false);
        j(viewA);
        this.Vu.removeAllViews();
        this.Vu.addView(viewA);
        bh();
        bj();
    }

    public final void a(c cVar) {
        this.aIF = cVar;
    }

    public final void a(b bVar) {
        this.aIL = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Go() {
        ImageView imageView = new ImageView(this.aIH.getContext());
        String url = com.kwad.sdk.core.response.b.a.bA(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            return;
        }
        imageView.setImageDrawable(null);
        KSImageLoader.loadImage(imageView, url, this.mAdTemplate);
        imageView.setVisibility(0);
        this.aIK.addView(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.home.a.e.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.this.fh();
                if (e.this.aIM.aIS) {
                    e.this.cp(0);
                }
            }
        });
    }

    public final void a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        boolean zIsVideoSoundEnable = ksAdVideoPlayConfig.isVideoSoundEnable();
        this.dX = com.kwad.sdk.core.response.b.a.bv(this.mAdInfo);
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.aIH.getContext());
        this.ed = aVar;
        aVar.setTag(this.dX);
        String strL = com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
        if (TextUtils.isEmpty(strL)) {
            return;
        }
        this.ed.a(new b.a(this.mAdTemplate).ew(strL).ex(com.kwad.components.ct.response.a.c.e((PhotoInfo) com.kwad.components.ct.response.a.a.ay(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.a.a.a(this.mAdTemplate, System.currentTimeMillis())).WR(), null);
        a.InterfaceC0593a interfaceC0593a = new a.InterfaceC0593a() { // from class: com.kwad.components.ct.home.a.e.12
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0593a
            public final com.kwad.sdk.core.video.a.c aw() {
                int i = Build.VERSION.SDK_INT;
                return null;
            }
        };
        this.em = interfaceC0593a;
        this.ed.setExternalPlayerListener(interfaceC0593a);
        this.ed.setVideoSoundEnable(zIsVideoSoundEnable);
        h hVar = new h(this.ed.getContext(), this.mAdTemplate, this.ed);
        hVar.aY(true);
        hVar.setDataAutoStart(Gu());
        hVar.setVideoPlayCallback(Gq());
        hVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        hVar.setAdClickListener(this.abz);
        hVar.aU(false);
        this.ed.setController(hVar);
        this.aIK.setVisibility(0);
        if (this.aIK.getTag() != null) {
            this.aIK.removeView((View) this.aIH.getTag());
            this.aIK.setTag(null);
        }
        this.aIK.addView(this.ed);
        this.aIK.setTag(this.ed);
        this.aIK.setClickable(true);
        this.ed.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.home.a.e.13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (e.this.ed.isIdle()) {
                    e.this.Gp();
                } else {
                    e.this.fh();
                }
                if (e.this.aIM.aIS) {
                    e.this.cp(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gp() {
        CtAdTemplate ctAdTemplate;
        if (this.ed == null || (ctAdTemplate = this.mAdTemplate) == null) {
            return;
        }
        n.fl(ctAdTemplate);
        this.ed.setKsPlayLogParam(com.kwad.sdk.contentalliance.a.a.a.cf(this.mAdTemplate));
        this.ed.start();
    }

    private a.c Gq() {
        return new a.c() { // from class: com.kwad.components.ct.home.a.e.14
            private boolean gq = false;

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                e.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.cm(e.this.mAdTemplate);
                e.this.kp.bn(3);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void au() {
                if (this.gq) {
                    return;
                }
                this.gq = true;
                com.kwad.components.ct.e.b.JK().a((AdTemplate) e.this.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void av() {
                com.kwad.sdk.core.adlog.c.cn(e.this.mAdTemplate);
                e.this.kp.bn(9);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fh() {
        com.kwad.components.core.e.d.a.a(new a.C0469a(this.aIH.getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(2).aF(121).d(this.aIH.getTouchCoords()).aH(this.aIM.aIQ).as(true).aq(false));
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

    private void j(View view) {
        this.aIH = (KSFrameLayout) view.findViewById(R.id.ksad_interstitial_video_container);
        this.aII = (FrameLayout) view.findViewById(R.id.ksad_interstitial_container);
        this.UO = (WebView) view.findViewById(R.id.ksad_home_interstitial_ad_web_view);
        this.aIK = (KSFrameLayout) view.findViewById(R.id.ksad_video_layout);
        this.UO.setBackgroundColor(0);
        this.UO.setVisibility(0);
        this.Vu.setVisibility(4);
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.gC.mScreenOrientation = 0;
        this.gC.Vu = this.Vu;
        this.gC.UO = this.UO;
    }

    private void bj() {
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.UO);
        this.gB = aVar;
        a(aVar);
        this.UO.addJavascriptInterface(this.gB, "KwaiAd");
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        com.kwad.sdk.core.d.c.d("[IAd]WebCard", "registerWebCardHandler");
        this.kp = new bf();
        aVar.a(new ac(this.gC, this.mApkDownloadHelper, this.gF, (byte) 0));
        aVar.a(new z(this.gC, this.mApkDownloadHelper, this.gF));
        aVar.a(new ag(this.gC));
        aVar.a(new com.kwad.components.core.webview.jshandler.aj(this.gC));
        aVar.a(Gs());
        aVar.a(Gt());
        aVar.a(new am(this.gC, this.gG));
        aVar.a(new at(this.gI, com.kwad.sdk.core.response.b.b.dH(this.mAdTemplate)));
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new bd(this.gC, this.mApkDownloadHelper));
        aVar.a(new al(this.gH));
        aVar.a(new an(this.gC));
        aVar.b(new o(this.gC));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.gC));
        aVar.a(new f());
        aVar.a(eK());
        aVar.a(Gr());
        aVar.a(new ar(new ar.a() { // from class: com.kwad.components.ct.home.a.e.2
            @Override // com.kwad.components.core.webview.jshandler.ar.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(e.this.UO.getContext(), new AdWebViewActivityProxy.a.C0479a().aE(bVar.title).aF(bVar.url).aG(true).aE(e.this.mAdTemplate).rk());
            }
        }));
    }

    private WebCardVideoPositionHandler Gr() {
        return new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ct.home.a.e.3
            @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
            public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                if (e.this.mAdInfo != null && com.kwad.sdk.core.response.b.a.bi(e.this.mAdInfo)) {
                    e eVar = e.this;
                    eVar.kB = (ViewGroup.MarginLayoutParams) eVar.aIH.getLayoutParams();
                    int i = e.this.aIH.getResources().getDisplayMetrics().heightPixels;
                    int i2 = e.this.aIH.getResources().getDisplayMetrics().widthPixels;
                    e.this.kB.topMargin = e.a(e.this, videoPosition, i);
                    e.this.kB.leftMargin = e.b(e.this, videoPosition, i2);
                    int iC = e.c(e.this, videoPosition, i2);
                    e.this.kB.width = iC;
                    int iB = e.this.b(videoPosition);
                    e.this.kB.height = iB;
                    e.this.aIH.setLayoutParams(e.this.kB);
                    if (e.this.aIJ == 4) {
                        e.this.aIH.setRadius(com.kwad.sdk.c.a.a.a(e.this.aIH.getContext(), 8.0f));
                    } else {
                        e.this.bN(iC < iB);
                    }
                    e.this.aIH.setVisibility(0);
                }
                if (e.this.aIJ == 1) {
                    e.this.Go();
                } else {
                    e eVar2 = e.this;
                    eVar2.a(eVar2.dG);
                }
            }
        });
    }

    private static int a(WebCardVideoPositionHandler.VideoPosition videoPosition, int i) {
        return videoPosition.leftMargin > 0 ? videoPosition.leftMargin : (int) Math.round(videoPosition.leftMarginRation * i);
    }

    private static int b(WebCardVideoPositionHandler.VideoPosition videoPosition, int i) {
        return videoPosition.topMargin > 0 ? videoPosition.topMargin : (int) Math.round(videoPosition.topMarginRation * i);
    }

    private static int c(WebCardVideoPositionHandler.VideoPosition videoPosition, int i) {
        return videoPosition.width > 0 ? videoPosition.width : (int) Math.ceil(i * videoPosition.widthRation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(WebCardVideoPositionHandler.VideoPosition videoPosition) {
        return videoPosition.height > 0 ? videoPosition.height : (int) Math.round(this.kB.width * videoPosition.heightWidthRation);
    }

    private g eK() {
        l lVar = new l();
        lVar.ajc = this.aIJ;
        return new g(lVar);
    }

    private ae Gs() {
        ae aeVar = new ae(this.gC);
        aeVar.a(new ae.b() { // from class: com.kwad.components.ct.home.a.e.4
            @Override // com.kwad.components.core.webview.jshandler.ae.b
            public final void c(ae.a aVar) {
                aVar.height = e.this.UO.getResources().getDisplayMetrics().heightPixels;
                aVar.width = e.this.UO.getResources().getDisplayMetrics().widthPixels;
            }
        });
        return aeVar;
    }

    private af Gt() {
        af afVar = new af(this.gC);
        afVar.a(new ae.b() { // from class: com.kwad.components.ct.home.a.e.5
            @Override // com.kwad.components.core.webview.jshandler.ae.b
            public final void c(ae.a aVar) {
                aVar.width = e.this.UO.getWidth();
                int statusBarHeight = e.this.aIM.aIR;
                if (statusBarHeight > 0 && (aVar instanceof af.a)) {
                    int[] iArr = new int[2];
                    e.this.Vu.getLocationInWindow(iArr);
                    com.kwad.sdk.core.d.c.d("[IAd]WebCard", "WebCardGetContainerPureLimitHandler locations: [" + iArr[0] + " , " + iArr[1] + "]");
                    if (iArr[1] > 0) {
                        Context context = e.this.Vu.getContext();
                        if (context instanceof Activity) {
                            com.kwad.components.core.u.e.e((Activity) context);
                            statusBarHeight -= com.kwad.sdk.c.a.a.getStatusBarHeight(context);
                            com.kwad.sdk.core.d.c.d("[IAd]WebCard", "WebCardGetContainerPureLimitHandler cut status bar height, adapterTopHeight: " + statusBarHeight);
                        }
                    }
                    ((af.a) aVar).aeT = statusBarHeight;
                }
                aVar.height = e.this.UO.getHeight() - statusBarHeight;
                com.kwad.sdk.core.d.c.d("[IAd]WebCard", "WebCardGetContainerPureLimitHandler containerLimit: " + aVar.toJson() + " , mWebView.getWidth(): " + e.this.UO.getWidth() + " , mWebView.getHeight(): " + e.this.UO.getHeight() + " , mAdConfig.mAdapterTopHeight: " + e.this.aIM.aIR);
            }
        });
        return afVar;
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    public final void pj() {
        this.Vt = -1;
        this.UO.loadUrl(com.kwad.sdk.core.response.b.b.dH(this.mAdTemplate));
    }

    public final boolean yb() {
        if (this.Vt == 1) {
            bm();
            return true;
        }
        br();
        return false;
    }

    public final boolean yc() {
        return this.Vt == 1;
    }

    public final void release() {
        if (this.mIsReleased) {
            return;
        }
        this.mIsReleased = true;
        this.Vt = -1;
        bk();
        this.Vu.setVisibility(8);
        com.kwad.components.ct.home.a.a aVar = this.aIG;
        if (aVar != null) {
            aVar.Gh();
        }
    }

    private void br() {
        int i = this.Vt;
        com.kwad.sdk.core.d.c.w("[IAd]WebCard", "show webCard fail, reason: " + (i == -1 ? "timeout" : i != 1 ? "h5error" : ILogConst.DRAW_ENTER_TYPE_OTHER));
        com.kwad.sdk.core.adlog.c.cr(this.mAdTemplate);
    }

    private void bm() {
        com.kwad.components.ct.home.a.a aVar = this.aIG;
        if (aVar != null) {
            aVar.a(this.aII, new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.home.a.e.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                    e.this.Vu.setVisibility(0);
                    if (e.this.gE != null) {
                        e.this.gE.ve();
                    }
                    if (e.this.aIL != null) {
                        e.this.aIL.Al();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cp(final int i) {
        com.kwad.sdk.core.d.c.d("[IAd]WebCard", "hide hideType=" + i);
        com.kwad.components.ct.home.a.a aVar = this.aIG;
        if (aVar != null) {
            aVar.b(this.aII, new AnimatorListenerAdapter() { // from class: com.kwad.components.ct.home.a.e.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    e.this.Vu.setVisibility(8);
                    if (e.this.ed != null) {
                        e.this.ed.release();
                    }
                    if (e.this.aIL != null) {
                        e.this.aIL.co(i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(boolean z) {
        Integer value = com.kwad.sdk.core.config.c.bxX.getValue();
        if (value == null) {
            return;
        }
        int iA = com.kwad.sdk.c.a.a.a(this.aIH.getContext(), 8.0f);
        if ((z && value.intValue() == 1) || (!z && value.intValue() == 3)) {
            float f = iA;
            this.aIH.setRadius(f, f, 0.0f, 0.0f);
        } else if (z) {
            if (value.intValue() == 3 || value.intValue() == 4 || value.intValue() == 2) {
                float f2 = iA;
                this.aIH.setRadius(f2, 0.0f, 0.0f, f2);
            }
        }
    }

    private static boolean Gu() {
        return com.kwad.sdk.core.config.c.bxP.getValue() != null && com.kwad.sdk.core.config.c.bxP.getValue().intValue() == 1;
    }

    public static class a {
        private int aIQ;
        private int aIR;
        private boolean aIS;
        private ViewGroup lz;
        private final CtAdTemplate mAdTemplate;

        public a(CtAdTemplate ctAdTemplate) {
            this.mAdTemplate = ctAdTemplate;
        }

        public final a n(ViewGroup viewGroup) {
            this.lz = viewGroup;
            return this;
        }

        public final a cq(int i) {
            this.aIQ = i;
            return this;
        }

        public final a cr(int i) {
            this.aIR = i;
            return this;
        }

        public final a bO(boolean z) {
            this.aIS = true;
            return this;
        }
    }
}
