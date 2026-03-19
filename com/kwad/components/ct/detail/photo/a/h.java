package com.kwad.components.ct.detail.photo.a;

import android.animation.ValueAnimator;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kuaishou.socket.nano.SocketMessages;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.u.r;
import com.kwad.components.core.u.s;
import com.kwad.components.ct.detail.photo.a.e;
import com.kwad.components.ct.request.i;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KSApiWebView;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.ca;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.widget.WrapChildLinearLayout;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h extends com.kwad.components.ct.detail.b implements View.OnClickListener, cb.a {
    private KSApiWebView aoT;
    protected ViewGroup app;
    protected ViewGroup aqJ;
    private ViewStub aqY;
    private ImageView aqZ;
    private TextView ara;
    private View arb;
    private TextView arc;
    private ImageView ard;
    private ImageView are;
    protected d arf;
    private ValueAnimator arg;
    private ValueAnimator arh;
    private boolean arj;
    private int arm;
    protected CtAdTemplate arn;
    protected CtAdTemplate aro;
    protected CtAdTemplate arp;
    protected AdStyleInfo.PlayDetailInfo.PatchAdInfo arq;
    private cb dC;
    private KsAppDownloadListener fJ;
    protected FrameLayout gO;

    /* renamed from: if, reason: not valid java name */
    protected AdBaseFrameLayout f14if;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean ari = false;
    private boolean ark = false;
    private boolean arl = false;
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.a.h.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            h.this.ari = true;
            h.this.zu();
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            h.this.ari = false;
            h.this.zy();
            h.this.reset();
        }
    };
    private Runnable arr = new Runnable() { // from class: com.kwad.components.ct.detail.photo.a.h.2
        @Override // java.lang.Runnable
        public final void run() {
            int i = -h.this.aqJ.getWidth();
            h.this.aqJ.setTranslationX(i);
            h.this.aqJ.setVisibility(0);
            h.this.clearAnimation();
            h hVar = h.this;
            hVar.arg = r.d(hVar.aqJ, i, 0);
            h.this.arg.start();
            h.this.zE();
            h.this.aqJ.setOnClickListener(h.this);
        }
    };
    private Runnable ars = new s(this.arr);
    private Runnable art = new Runnable() { // from class: com.kwad.components.ct.detail.photo.a.h.3
        @Override // java.lang.Runnable
        public final void run() {
            if (h.this.ark || h.this.arf == null || h.this.zD() || h.this.arf.yb()) {
                return;
            }
            h.this.zy();
        }
    };
    private Runnable aru = new s(this.art);
    private e.a aqL = new e.a() { // from class: com.kwad.components.ct.detail.photo.a.h.4
        @Override // com.kwad.components.ct.detail.photo.a.e.a
        public final void zn() {
            h.b(h.this, true);
        }

        @Override // com.kwad.components.ct.detail.photo.a.e.a
        public final void zo() {
            h.c(h.this, true);
        }
    };

    static /* synthetic */ boolean b(h hVar, boolean z) {
        hVar.ark = true;
        return true;
    }

    static /* synthetic */ boolean c(h hVar, boolean z) {
        hVar.arl = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f14if = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.app = (ViewGroup) findViewById(R.id.ksad_bottom_content_container);
        this.gO = (FrameLayout) findViewById(R.id.ksad_web_card_container);
        this.aoT = (KSApiWebView) findViewById(R.id.ksad_actionbar_web_card);
        this.aqY = (ViewStub) findViewById(R.id.ksad_patch_ad_view_stub);
        this.dC = new cb(this);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.arn = this.aop.mAdTemplate;
        this.arm = com.kwad.components.ct.home.config.b.FS();
        if (zC()) {
            this.arj = true;
            this.aop.aoq.add(this.aoQ);
        } else {
            this.arj = false;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.arj) {
            this.aop.aoq.remove(this.aoQ);
            zy();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        KSApiWebView kSApiWebView = this.aoT;
        if (kSApiWebView != null) {
            kSApiWebView.release();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.are) {
            jm();
            this.ark = true;
            this.gO.removeCallbacks(this.aru);
            zG();
            return;
        }
        if (view == this.aqJ) {
            if (!ao.isNetworkConnected(view.getContext())) {
                ac.ae(view.getContext(), "网络错误");
            }
            if (this.aro == null) {
                return;
            }
            com.kwad.components.core.e.d.a.a(new a.C0469a(view.getContext()).aC(this.aro).b(this.mApkDownloadHelper).aq(true).a(new a.b() { // from class: com.kwad.components.ct.detail.photo.a.h.5
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    h.b(h.this, true);
                    h.this.zF();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.utils.cb.a
    public final void a(Message message) {
        if (message.what == 1234) {
            yH();
            zv();
            AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo = this.arq;
            if (patchAdInfo == null) {
                return;
            }
            long j = patchAdInfo.weakStyleShowTime;
            if (j <= 0) {
                j = 3500;
            }
            this.dC.sendEmptyMessageDelayed(5678, j);
            return;
        }
        if (message.what == 5678) {
            if (this.arq == null) {
                return;
            }
            zt();
            long j2 = this.arq.strongStyleShowTime;
            if (j2 <= 1000) {
                j2 = 4000;
            }
            this.dC.sendEmptyMessageDelayed(6868, j2);
            return;
        }
        if (message.what == 6868) {
            a(new i.a() { // from class: com.kwad.components.ct.detail.photo.a.h.6
                @Override // com.kwad.components.ct.request.i.a
                public final void zH() {
                }

                @Override // com.kwad.components.ct.request.i.a
                public final void b(long j3, CtAdTemplate ctAdTemplate) {
                    if (ctAdTemplate == null || h.this.zw()) {
                        return;
                    }
                    h.this.aro = ctAdTemplate;
                    h.this.arp = ctAdTemplate;
                    h.this.dC.sendEmptyMessageDelayed(SocketMessages.PayloadType.SC_LIVE_ACTIVITY_POPUP_ROUTE, 1000L);
                }
            });
        }
    }

    private void zs() {
        this.aqJ.removeCallbacks(this.ars);
        this.aqJ.post(this.ars);
    }

    private void zt() {
        if (zD()) {
            return;
        }
        this.gO.removeCallbacks(this.aru);
        this.gO.post(this.aru);
    }

    private void jm() {
        if (ca.a(this.aqJ, 50, false)) {
            ValueAnimator valueAnimatorD = r.d(this.aqJ, 0, -this.aqJ.getWidth());
            this.arh = valueAnimatorD;
            valueAnimatorD.start();
            this.are.setOnClickListener(null);
            this.aqJ.setOnClickListener(null);
            zz();
            zy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAnimation() {
        ValueAnimator valueAnimator = this.arg;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.arh;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zu() {
        a(new i.a() { // from class: com.kwad.components.ct.detail.photo.a.h.7
            @Override // com.kwad.components.ct.request.i.a
            public final void zH() {
            }

            @Override // com.kwad.components.ct.request.i.a
            public final void b(long j, CtAdTemplate ctAdTemplate) {
                if (ctAdTemplate == null || h.this.zw()) {
                    return;
                }
                h.this.aro = ctAdTemplate;
                h.this.arp = ctAdTemplate;
                h.this.dC.sendEmptyMessage(SocketMessages.PayloadType.SC_LIVE_ACTIVITY_POPUP_ROUTE);
            }
        });
    }

    private void a(i.a aVar) {
        if (zw()) {
            return;
        }
        ImpInfo impInfo = new ImpInfo(this.arn.mAdScene);
        impInfo.pageScene = r0.getPageScene();
        impInfo.subPageScene = 101L;
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.arn);
        long j = com.kwad.components.ct.response.a.c.j((PhotoInfo) ctPhotoInfoAy);
        com.kwad.components.core.request.model.c cVar = new com.kwad.components.core.request.model.c();
        cVar.photoId = j;
        cVar.authorId = com.kwad.components.ct.response.a.c.e(ctPhotoInfoAy);
        com.kwad.components.ct.request.i.a(j, impInfo, cVar, aVar);
    }

    private void zv() {
        CtAdTemplate ctAdTemplate;
        if (!this.ari || zw() || this.arp == null || (ctAdTemplate = this.aro) == null) {
            return;
        }
        this.arp = null;
        ctAdTemplate.mIsFromContent = true;
        this.arq = com.kwad.sdk.core.response.b.d.ew(this.aro);
        dx();
        zx();
        this.arf = zA();
        zs();
        this.arm--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zw() {
        return this.arm <= 0 || this.arl || this.ark;
    }

    private void dx() {
        if (this.aqY.getParent() != null) {
            this.aqJ = (ViewGroup) this.aqY.inflate();
        } else {
            this.aqJ = (ViewGroup) findViewById(R.id.ksad_actionbar_view);
        }
        this.aqJ.setVisibility(8);
        this.aqZ = (ImageView) findViewById(R.id.ksad_patch_icon);
        TextView textView = (TextView) findViewById(R.id.ksad_patch_ad_title);
        this.ara = textView;
        ViewGroup viewGroup = this.aqJ;
        if (viewGroup instanceof WrapChildLinearLayout) {
            ((WrapChildLinearLayout) viewGroup).setWrapChildView(textView);
        }
        this.arb = findViewById(R.id.ksad_patch_ad_mid_line);
        this.arc = (TextView) findViewById(R.id.ksad_patch_ad_app_status);
        this.ard = (ImageView) findViewById(R.id.ksad_patch_ad_mark);
        this.are = (ImageView) findViewById(R.id.ksad_patch_ad_close_btn);
    }

    private void zx() {
        CtAdTemplate ctAdTemplate = this.aro;
        if (ctAdTemplate == null || this.arq == null) {
            return;
        }
        AdInfo adInfoEP = com.kwad.components.ct.response.a.a.eP(ctAdTemplate);
        String str = this.arq.weakStyleIcon;
        if (bq.isNullString(str)) {
            this.aqZ.setVisibility(8);
        } else {
            loadImage(this.aqZ, str);
            this.aqZ.setVisibility(0);
        }
        if (com.kwad.sdk.core.response.b.a.aJ(adInfoEP)) {
            zz();
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.aro);
            this.mApkDownloadHelper = cVar;
            cVar.b(F(adInfoEP));
        } else {
            x(this.arq.weakStyleTitle, "");
        }
        String str2 = this.arq.weakStyleAdMark;
        if (bq.isNullString(str2)) {
            this.ard.setVisibility(8);
        } else {
            loadImage(this.ard, str2);
            this.ard.setVisibility(0);
        }
        if (this.arq.weakStyleEnableClose) {
            this.are.setOnClickListener(this);
            this.are.setVisibility(0);
        } else {
            this.are.setVisibility(8);
        }
        this.aqJ.setVisibility(4);
    }

    private void loadImage(ImageView imageView, String str) {
        KSImageLoader.loadImage(imageView, str, this.aro);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.ark = false;
        this.arl = false;
        this.aro = null;
        this.arp = null;
        this.arm = com.kwad.components.ct.home.config.b.FS();
        yH();
    }

    private void yH() {
        ViewGroup viewGroup = this.aqJ;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        this.app.setTranslationX(0.0f);
        this.gO.setVisibility(8);
        d dVar = this.arf;
        if (dVar != null) {
            dVar.release();
            this.arf = null;
        }
        clearAnimation();
        zz();
        zy();
    }

    protected final void zy() {
        this.dC.removeCallbacksAndMessages(null);
    }

    private void zz() {
        KsAppDownloadListener ksAppDownloadListener;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.fJ) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    private KsAppDownloadListener F(final AdInfo adInfo) {
        com.kwad.sdk.core.download.a.a aVar = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.detail.photo.a.h.8
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                if (h.this.arq != null) {
                    h hVar = h.this;
                    hVar.x(hVar.arq.weakStyleTitle, "");
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (h.this.arq != null) {
                    h hVar = h.this;
                    hVar.x(hVar.arq.weakStyleDownloadingTitle, "正在下载 " + i + "%");
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                if (h.this.arq != null) {
                    h hVar = h.this;
                    hVar.x(hVar.arq.weakStyleDownloadingTitle, com.kwad.sdk.core.response.b.a.cB(h.this.aro));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                if (h.this.arq != null) {
                    h hVar = h.this;
                    hVar.x(hVar.arq.weakStyleTitle, "");
                }
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                if (h.this.arq != null) {
                    h hVar = h.this;
                    hVar.x(hVar.arq.weakStyleDownloadingTitle, "继续下载 " + i + "%");
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                if (h.this.arq != null) {
                    h hVar = h.this;
                    hVar.x(hVar.arq.weakStyleDownloadingTitle, com.kwad.sdk.core.response.b.a.ae(adInfo));
                }
            }
        };
        this.fJ = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, String str2) {
        int screenWidth = ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) - com.kwad.sdk.c.a.a.a(getContext(), 12.0f)) - com.kwad.sdk.c.a.a.a(getContext(), 93.0f)) - (com.kwad.sdk.c.a.a.a(getContext(), 8.0f) * 2);
        AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo = this.arq;
        if (patchAdInfo != null && !TextUtils.isEmpty(patchAdInfo.weakStyleIcon)) {
            screenWidth -= com.kwad.sdk.c.a.a.a(getContext(), 22.0f);
        }
        AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo2 = this.arq;
        if (patchAdInfo2 != null && !TextUtils.isEmpty(patchAdInfo2.weakStyleAdMark)) {
            screenWidth -= com.kwad.sdk.c.a.a.a(getContext(), 20.0f);
        }
        AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo3 = this.arq;
        if (patchAdInfo3 != null && patchAdInfo3.weakStyleEnableClose) {
            screenWidth -= com.kwad.sdk.c.a.a.a(getContext(), 20.0f);
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            this.arb.setVisibility(8);
            this.arc.setVisibility(8);
        } else {
            if (!bq.isNullString(str)) {
                this.arc.setText(str2);
                screenWidth -= (int) (com.kwad.sdk.c.a.a.a(getContext(), 17.0f) + this.arc.getPaint().measureText(str2));
                int iMeasureText = (int) this.ara.getPaint().measureText(str);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.arb.getLayoutParams();
                if (iMeasureText > screenWidth) {
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
                    screenWidth += com.kwad.sdk.c.a.a.a(getContext(), 4.0f);
                } else {
                    marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(getContext(), 8.0f);
                }
            }
            this.arb.setVisibility(0);
            this.arc.setVisibility(0);
        }
        this.ara.setMaxWidth(screenWidth);
        this.ara.setText(str);
    }

    private d zA() {
        return zB();
    }

    private d zB() {
        AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo = this.arq;
        if (bq.isNullString(patchAdInfo != null ? patchAdInfo.strongStyleCardUrl : null)) {
            return null;
        }
        e eVar = new e();
        eVar.a(this.app, this.aqJ, this.gO, this.aoT, this.f14if, this.aro, this.mApkDownloadHelper);
        eVar.bi();
        eVar.a(this.aqL);
        return eVar;
    }

    private boolean zC() {
        return com.kwad.components.ct.response.a.c.bd(this.arn);
    }

    protected final boolean zD() {
        CtAdTemplate ctAdTemplate;
        if (com.kwad.components.ct.home.config.b.FB()) {
            return false;
        }
        if (this.arl || (ctAdTemplate = this.aro) == null) {
            return true;
        }
        AdInfo adInfoEP = com.kwad.components.ct.response.a.a.eP(ctAdTemplate);
        return (!com.kwad.sdk.core.response.b.a.aJ(adInfoEP) || adInfoEP.status == 0 || adInfoEP.status == 7) ? false : true;
    }

    protected final void zE() {
        if (this.aro == null) {
            return;
        }
        com.kwad.components.core.u.b.tq().a(this.aro, null, null);
    }

    protected final void zF() {
        CtAdTemplate ctAdTemplate = this.aro;
        if (ctAdTemplate == null) {
            return;
        }
        AdBaseFrameLayout adBaseFrameLayout = this.f14if;
        com.kwad.sdk.core.adlog.c.a(ctAdTemplate, 51, adBaseFrameLayout == null ? null : adBaseFrameLayout.getTouchCoords());
    }

    private void zG() {
        if (this.aro == null) {
            return;
        }
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.eQ(9);
        com.kwad.sdk.core.adlog.c.b(this.aro, bVar, (JSONObject) null);
    }
}
