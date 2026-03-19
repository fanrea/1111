package com.kwad.components.ct.horizontal.news.c;

import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.at;
import com.kwad.components.core.webview.jshandler.ba;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsHorizontalFeedPage;
import com.kwad.sdk.core.webview.KSApiWebView;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.m;
import java.math.BigDecimal;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends com.kwad.components.ct.horizontal.news.b.a implements View.OnClickListener {
    private ViewGroup JF;
    private RecyclerView Wj;
    private KsContentPage.ContentItem aLE;
    private KsHorizontalFeedPage.NewsPageListener aNA;
    private View aOi;
    private KSFrameLayout aOj;
    private TextView aOk;
    private boolean aOl;
    private int aOm;
    private int aOn;
    private long aOo;
    private int aOp;
    private KSApiWebView aoT;
    private long aww;
    private com.kwad.components.core.webview.a gB;
    private com.kwad.sdk.core.webview.b gC;
    private ba gE;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean aOq = false;
    private boolean aOr = false;
    private int gD = -1;
    private int aOs = 0;
    private int aOt = -1;
    private final KSPageLoadingView.a asf = new KSPageLoadingView.a() { // from class: com.kwad.components.ct.horizontal.news.c.e.1
        @Override // com.kwad.components.ct.widget.KSPageLoadingView.a
        public final void zP() {
            e.this.Ie();
        }
    };
    private final RecyclerView.OnScrollListener asg = new RecyclerView.OnScrollListener() { // from class: com.kwad.components.ct.horizontal.news.c.e.6
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            e.a(e.this, i2);
        }
    };
    private final com.kwad.sdk.m.a.b ayk = new com.kwad.sdk.m.a.b() { // from class: com.kwad.components.ct.horizontal.news.c.e.7
        @Override // com.kwad.sdk.m.a.b
        public final boolean onBackPressed() {
            com.kwad.components.ct.horizontal.news.d.HU().d(e.this.aww, e.this.aOp);
            com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "onBackPressed scrollHeight" + e.this.aOp);
            return false;
        }
    };
    private final am.b gG = new am.b() { // from class: com.kwad.components.ct.horizontal.news.c.e.10
        @Override // com.kwad.components.core.webview.jshandler.am.b
        public final void a(am.a aVar) {
            e.this.aOm = aVar.height;
            com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "initKsAdFrame height=" + e.this.aOm);
        }
    };
    private final at.b gI = new at.b() { // from class: com.kwad.components.ct.horizontal.news.c.e.11
        @Override // com.kwad.components.core.webview.jshandler.at.b
        public final void a(at.a aVar) {
            com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "pageStatus status=" + aVar);
            e.this.gD = aVar.status;
            e.a(e.this, true);
            if (e.this.gD == 1) {
                e.this.If();
            } else {
                e.this.Im();
            }
        }
    };
    private final com.kwad.sdk.lib.b.f awa = new com.kwad.sdk.lib.b.g() { // from class: com.kwad.components.ct.horizontal.news.c.e.12
        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void m(boolean z, boolean z2) {
            super.m(z, z2);
            if (z) {
                e.this.aOq = false;
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void n(boolean z, boolean z2) {
            super.n(z, z2);
            if (z) {
                e.this.aOq = true;
                e.this.If();
            }
        }

        @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
        public final void a(boolean z, int i, String str) {
            super.a(z, i, str);
            if (z) {
                e.this.aOq = true;
            }
        }
    };
    private final WebViewClient aOu = new WebViewClient() { // from class: com.kwad.components.ct.horizontal.news.c.e.13
        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "onReceivedError");
            if (e.this.gD != 1) {
                e.this.Im();
            }
        }
    };

    static /* synthetic */ int a(e eVar, int i) {
        int i2 = eVar.aOp + i;
        eVar.aOp = i2;
        return i2;
    }

    static /* synthetic */ boolean a(e eVar, boolean z) {
        eVar.aOr = true;
        return true;
    }

    static /* synthetic */ boolean c(e eVar, boolean z) {
        eVar.aOl = true;
        return true;
    }

    static /* synthetic */ int e(e eVar, int i) {
        int i2 = eVar.aOs + i;
        eVar.aOs = i2;
        return i2;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        View viewA = com.kwad.sdk.c.a.a.a((ViewGroup) getRootView(), R.layout.ksad_news_header_webview_layout, false);
        this.aOi = viewA;
        this.JF = (ViewGroup) viewA.findViewById(R.id.ksad_web_view_container);
        this.aoT = (KSApiWebView) this.aOi.findViewById(R.id.ksad_news_web_view);
        this.aOj = (KSFrameLayout) this.aOi.findViewById(R.id.ksad_news_expand_container);
        this.aOk = (TextView) this.aOi.findViewById(R.id.ksad_news_expand_btn);
    }

    @Override // com.kwad.components.ct.horizontal.news.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = this.aNz.mEntryAdTemplate;
        this.aLE = this.aNz.aLE;
        this.aNA = this.aNz.aNA;
        this.Wj = this.aNz.Wj;
        this.aNz.aFW.addHeaderView(this.aOi);
        this.Wj.addOnScrollListener(this.asg);
        this.aNz.aGE.addBackPressable(this.ayk);
        this.aNz.aNL.add(this.asf);
        this.aNz.avY.a(this.awa);
        this.aww = com.kwad.components.ct.response.a.a.bg(this.mAdTemplate);
        this.aOl = false;
        fy();
        rK();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Wj.removeOnScrollListener(this.asg);
        this.aNz.aGE.removeBackPressable(this.ayk);
        this.aNz.aNL.remove(this.asf);
        this.aNz.avY.b(this.awa);
        bk();
        this.gD = -1;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        In();
    }

    private void fy() {
        this.aoT.setWebViewClient(this.aOu);
        bh();
        bj();
        Ie();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ie() {
        this.gD = -1;
        String strC = com.kwad.components.ct.response.a.d.c(com.kwad.components.ct.response.a.a.az(this.mAdTemplate));
        if (!TextUtils.isEmpty(strC)) {
            this.aoT.loadUrl(strC);
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.horizontal.news.c.e.8
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    e.this.Ik();
                }
            });
        } else {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.ct.horizontal.news.c.e.9
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    e.this.Im();
                }
            });
        }
    }

    private void bj() {
        bk();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.aoT);
        this.gB = aVar;
        a(aVar);
        this.aoT.addJavascriptInterface(this.gB, "KwaiAd");
    }

    private void bk() {
        com.kwad.components.core.webview.a aVar = this.gB;
        if (aVar != null) {
            aVar.destroy();
            this.gB = null;
        }
    }

    private void bh() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.gC = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        this.gC.mScreenOrientation = 0;
        this.gC.UO = this.aoT;
        this.gC.Vu = this.JF;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(this.mAdTemplate))) {
            this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        }
        aVar.a(new ac(this.gC, this.mApkDownloadHelper, null, (byte) 0));
        aVar.a(new z(this.gC, this.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) null));
        aVar.a(new ag(this.gC));
        aVar.a(new aj(this.gC));
        aVar.a(new am(this.gC, this.gG, false));
        aVar.a(new at(this.gI, com.kwad.components.ct.response.a.d.c(com.kwad.components.ct.response.a.a.az(this.mAdTemplate))));
        ba baVar = new ba();
        this.gE = baVar;
        aVar.a(baVar);
        aVar.a(new bd(this.gC, this.mApkDownloadHelper));
        aVar.a(new an(this.gC));
        aVar.b(new o(this.gC));
        aVar.b(new n(this.gC));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If() {
        com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "mWebViewLoadFinish " + this.aOr + "-mPageListLoadFinish=" + this.aOq);
        if (this.aOr && this.aOq) {
            this.gE.vd();
            Ig();
            Ij();
            this.aOo = SystemClock.elapsedRealtime();
            Cz();
            Il();
            this.gE.ve();
        }
    }

    private void Ig() {
        if (this.aOm == 0) {
            this.aOm = (int) (this.aoT.getContentHeight() * getContext().getResources().getDisplayMetrics().density);
            com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "initExpandView mWebViewContentHeight=" + this.aOm + " , mWebView.getScale(): " + this.aoT.getScale());
        }
        com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "initExpandView mWebViewContentHeight=" + this.aOm + "-getContentHeight=" + ((int) (this.aoT.getContentHeight() * getContext().getResources().getDisplayMetrics().density)) + "-getHeight=" + this.aoT.getHeight() + "-getMeasuredHeight=" + this.aoT.getMeasuredHeight());
        if (this.aOm == 0) {
            return;
        }
        if (this.aOt < 0) {
            if (this.JF.getHeight() > 0) {
                this.aOt = this.JF.getTop();
                com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "initExpandView mWebViewContainerTop=" + this.aOt);
            } else {
                this.JF.post(new bh() { // from class: com.kwad.components.ct.horizontal.news.c.e.2
                    @Override // com.kwad.sdk.utils.bh
                    public final void doTask() {
                        e eVar = e.this;
                        eVar.aOt = eVar.JF.getTop();
                        com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "initExpandView post mWebViewContainerTop=" + e.this.aOt);
                    }
                });
            }
        }
        double dHm = com.kwad.components.ct.horizontal.a.b.Hm();
        if (com.kwad.components.ct.horizontal.news.d.HU().ak(this.aww) || dHm <= 0.0d) {
            Ih();
            cF(this.aOm);
            return;
        }
        int height = this.aNz.aGE.getView().getHeight();
        if (height == 0) {
            height = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        }
        int i = (int) (dHm * height);
        int i2 = this.aOm;
        if (i2 <= i) {
            Ih();
            cF(this.aOm);
        } else {
            cE((int) (((i2 - i) / (i2 * 1.0f)) * 100.0f));
            cF(i);
        }
    }

    private void cE(int i) {
        this.aOk.setText(getContext().getString(R.string.ksad_news_expand_tip, Integer.valueOf(i)));
        this.aOk.setOnClickListener(this);
        this.aOj.setViewVisibleListener(new m() { // from class: com.kwad.components.ct.horizontal.news.c.e.3
            @Override // com.kwad.sdk.widget.m
            public final void E(View view) {
                if (e.this.aOl) {
                    return;
                }
                e.c(e.this, true);
                com.kwad.components.ct.e.b.JK().af(e.this.mAdTemplate);
            }
        });
        this.aOj.setVisibility(0);
    }

    private void Ih() {
        this.aOj.setVisibility(8);
    }

    private void cF(int i) {
        this.aOn = i;
        ViewGroup.LayoutParams layoutParams = this.JF.getLayoutParams();
        layoutParams.height = i;
        this.JF.setLayoutParams(layoutParams);
        this.JF.post(new bh() { // from class: com.kwad.components.ct.horizontal.news.c.e.4
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                e.this.Ii();
            }
        });
    }

    private void rK() {
        RecyclerView recyclerView = this.aNz.Wj;
        if (recyclerView == null) {
            return;
        }
        this.aOs = 0;
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kwad.components.ct.horizontal.news.c.e.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView2, int i, int i2) {
                super.onScrolled(recyclerView2, i, i2);
                e.e(e.this, i2);
                e.this.Ii();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii() {
        int i;
        Rect rect = new Rect();
        this.aoT.getGlobalVisibleRect(rect);
        int iMax = Math.max(this.aOs - this.aOt, 0);
        int iMin = Math.min(rect.height() + iMax, this.aoT.getHeight());
        if (com.kwad.components.core.a.qr.booleanValue()) {
            com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "updateNewsPageScrollListener mWebViewContentHeight: " + this.aOm + " , mWebView.getHeight: " + this.aoT.getHeight() + " , current: " + iMin + " , visibleHeight: " + rect.height() + " , mRecyclerView.ScrollByY: " + this.aOs + " , mWebView.ScrollByY: " + iMax + " , mWebViewContainerTop: " + this.aOt);
        }
        KsHorizontalFeedPage.NewsPageListener newsPageListener = this.aNA;
        if (newsPageListener == null || (i = this.aOm) <= 0) {
            return;
        }
        newsPageListener.onNewsPageScrollListener(this.aLE, i, iMin);
    }

    private void Ij() {
        int iAi;
        if (!com.kwad.components.ct.horizontal.a.b.Hn() || this.aOm == 0 || (iAi = com.kwad.components.ct.horizontal.news.d.HU().ai(this.aww)) == 0) {
            return;
        }
        int statusBarHeight = com.kwad.components.core.u.e.e(getActivity()) ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) + 0 : 0;
        int itemCount = this.aNz.aFU.getItemCount();
        com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "initLastPos itemCount=" + itemCount + "-mWebViewShowHeight=" + this.aOn);
        if (itemCount == 0) {
            return;
        }
        int dimensionPixelOffset = statusBarHeight + getContext().getResources().getDimensionPixelOffset(R.dimen.ksad_content_actionbar_height);
        View view = this.aNz.aFW.akV().cdr.get(0);
        int height = view != null ? view.getHeight() : 0;
        int i = (this.aOn + height) - dimensionPixelOffset;
        int iMin = Math.min(iAi, i);
        com.kwad.sdk.core.d.c.d("NewsDetailHeaderWebViewPresenter", "initLastPos lastScrollHeight=" + iAi + "-authorInfoHeight=" + height + "-maxScrollHeight=" + i + "-scrollHeight=" + iMin);
        this.Wj.scrollBy(0, iMin);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.aOk) {
            cF(this.aOm);
            com.kwad.components.ct.horizontal.news.d.HU().aj(this.aww);
            this.aOj.setVisibility(8);
            com.kwad.components.ct.e.b.JK().ag(this.mAdTemplate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ik() {
        Iterator<com.kwad.components.ct.horizontal.news.f> it = this.aNz.aNK.iterator();
        while (it.hasNext()) {
            it.next().HV();
        }
    }

    private void Il() {
        Iterator<com.kwad.components.ct.horizontal.news.f> it = this.aNz.aNK.iterator();
        while (it.hasNext()) {
            it.next().aN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Im() {
        Iterator<com.kwad.components.ct.horizontal.news.f> it = this.aNz.aNK.iterator();
        while (it.hasNext()) {
            it.next().HW();
        }
    }

    private void Cz() {
        com.kwad.components.ct.e.b.JK().a(this.aNz.mEntryAdTemplate, 0, com.kwad.components.core.video.c.ub().ue());
    }

    private void In() {
        if (this.aOo == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.aOo;
        float fFloatValue = 0.0f;
        int i = this.aOm;
        if (i != 0) {
            fFloatValue = this.aOp >= i ? 1.0f : BigDecimal.valueOf((r2 * 1.0f) / i).setScale(6, 4).floatValue();
        }
        com.kwad.components.ct.e.b.JK().a(this.aNz.mEntryAdTemplate, jElapsedRealtime, fFloatValue);
    }
}
