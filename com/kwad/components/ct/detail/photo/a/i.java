package com.kwad.components.ct.detail.photo.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.u.r;
import com.kwad.components.core.u.s;
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
import com.kwad.sdk.widget.WrapChildLinearLayout;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i extends com.kwad.components.ct.detail.b implements View.OnClickListener {
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
    protected CtAdTemplate arn;
    protected CtAdTemplate aro;
    protected AdStyleInfo.PlayDetailInfo.PatchAdInfo arq;
    private KsAppDownloadListener fJ;
    protected FrameLayout gO;

    /* renamed from: if, reason: not valid java name */
    protected AdBaseFrameLayout f15if;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private boolean ari = false;
    protected boolean arw = false;
    private boolean arx = false;
    private boolean ary = false;
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.a.i.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            i.this.ari = true;
            i.this.zu();
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            i.this.ari = false;
            i.this.reset();
        }
    };
    private Runnable arr = new Runnable() { // from class: com.kwad.components.ct.detail.photo.a.i.3
        @Override // java.lang.Runnable
        public final void run() {
            int i = -i.this.aqJ.getWidth();
            i.this.aqJ.setTranslationX(i);
            i.this.aqJ.setVisibility(0);
            i.this.clearAnimation();
            i iVar = i.this;
            iVar.arg = r.d(iVar.aqJ, i, 0);
            i.this.arg.start();
            i.this.zE();
            i.this.aqJ.setOnClickListener(i.this);
        }
    };
    private Runnable ars = new s(this.arr);
    private Runnable art = new Runnable() { // from class: com.kwad.components.ct.detail.photo.a.i.5
        @Override // java.lang.Runnable
        public final void run() {
            if (i.this.arx || i.this.arf == null || i.this.zD()) {
                return;
            }
            i.this.arf.yb();
        }
    };
    private Runnable aru = new s(this.art);

    static /* synthetic */ boolean b(i iVar, boolean z) {
        iVar.ary = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f15if = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.app = (ViewGroup) findViewById(R.id.ksad_bottom_content_container);
        this.gO = (FrameLayout) findViewById(R.id.ksad_web_card_container);
        this.aoT = (KSApiWebView) findViewById(R.id.ksad_actionbar_web_card);
        this.aqY = (ViewStub) findViewById(R.id.ksad_patch_ad_view_stub);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.arn = this.aop.mAdTemplate;
        if (zC()) {
            this.arj = true;
            this.aop.aoq.add(this.aoQ);
        } else {
            this.arj = false;
        }
    }

    private boolean zC() {
        return com.kwad.components.ct.response.a.c.bd(this.arn);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (this.arj) {
            this.aop.aoq.remove(this.aoQ);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.arw = false;
        this.arx = false;
        this.ary = false;
        ViewGroup viewGroup = this.aqJ;
        if (viewGroup != null) {
            viewGroup.removeCallbacks(this.ars);
            this.aqJ.setVisibility(8);
        }
        this.app.setTranslationX(0.0f);
        this.gO.setVisibility(8);
        this.gO.removeCallbacks(this.aru);
        d dVar = this.arf;
        if (dVar != null) {
            dVar.release();
            this.arf = null;
        }
        clearAnimation();
        zz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zu() {
        if (this.arw) {
            return;
        }
        this.arw = true;
        CtAdTemplate ctAdTemplate = (CtAdTemplate) this.arn.getLocalParams("tag_patchad_data_template");
        if (ctAdTemplate == null) {
            ImpInfo impInfo = new ImpInfo(this.arn.mAdScene);
            impInfo.pageScene = r0.getPageScene();
            impInfo.subPageScene = 101L;
            impInfo.sdkExtraData = com.kwad.components.ct.response.a.a.aZ(this.arn);
            CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.arn);
            long j = com.kwad.components.ct.response.a.c.j((PhotoInfo) ctPhotoInfoAy);
            com.kwad.components.core.request.model.c cVar = new com.kwad.components.core.request.model.c();
            cVar.photoId = j;
            cVar.authorId = com.kwad.components.ct.response.a.c.e(ctPhotoInfoAy);
            a(j, impInfo, cVar);
            return;
        }
        d(ctAdTemplate);
    }

    private void a(final long j, ImpInfo impInfo, com.kwad.components.core.request.model.c cVar) {
        com.kwad.components.ct.request.i.a(j, impInfo, cVar, new i.a() { // from class: com.kwad.components.ct.detail.photo.a.i.2
            @Override // com.kwad.components.ct.request.i.a
            public final void zH() {
                i.this.arw = false;
            }

            @Override // com.kwad.components.ct.request.i.a
            public final void b(long j2, CtAdTemplate ctAdTemplate) {
                if (ctAdTemplate == null || j2 != j) {
                    return;
                }
                i.this.arn.putLocalParams("tag_patchad_data_template", ctAdTemplate);
                i.this.d(ctAdTemplate);
            }
        });
    }

    protected final void d(CtAdTemplate ctAdTemplate) {
        if (this.ari) {
            this.aro = ctAdTemplate;
            ctAdTemplate.mIsFromContent = true;
            this.arq = com.kwad.sdk.core.response.b.d.ew(this.aro);
            dx();
            zx();
            this.arf = zA();
            zs();
            zt();
        }
    }

    private void zs() {
        this.aqJ.removeCallbacks(this.ars);
        long j = this.arq.weakStyleAppearTime;
        if (j <= 0) {
            j = 0;
        }
        this.aqJ.postDelayed(this.ars, j);
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

    private void jm() {
        if (ca.a(this.aqJ, 50, false)) {
            ValueAnimator valueAnimatorD = r.d(this.aqJ, 0, -this.aqJ.getWidth());
            this.arh = valueAnimatorD;
            valueAnimatorD.start();
            this.are.setOnClickListener(null);
            this.aqJ.setOnClickListener(null);
            zz();
        }
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
        AdInfo adInfoEP = com.kwad.components.ct.response.a.a.eP(this.aro);
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

    private void zz() {
        KsAppDownloadListener ksAppDownloadListener;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.fJ) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    private KsAppDownloadListener F(final AdInfo adInfo) {
        com.kwad.sdk.core.download.a.a aVar = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.detail.photo.a.i.4
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                i iVar = i.this;
                iVar.x(iVar.arq.weakStyleTitle, "");
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                i iVar = i.this;
                iVar.x(iVar.arq.weakStyleDownloadingTitle, "正在下载 " + i + "%");
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                i iVar = i.this;
                iVar.x(iVar.arq.weakStyleDownloadingTitle, com.kwad.sdk.core.response.b.a.cB(i.this.aro));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                i iVar = i.this;
                iVar.x(iVar.arq.weakStyleTitle, "");
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                i iVar = i.this;
                iVar.x(iVar.arq.weakStyleDownloadingTitle, "继续下载 " + i + "%");
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                i iVar = i.this;
                iVar.x(iVar.arq.weakStyleDownloadingTitle, com.kwad.sdk.core.response.b.a.ae(adInfo));
            }
        };
        this.fJ = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, String str2) {
        int screenWidth = ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) - com.kwad.sdk.c.a.a.a(getContext(), 12.0f)) - com.kwad.sdk.c.a.a.a(getContext(), 93.0f)) - (com.kwad.sdk.c.a.a.a(getContext(), 8.0f) * 2);
        if (!TextUtils.isEmpty(this.arq.weakStyleIcon)) {
            screenWidth -= com.kwad.sdk.c.a.a.a(getContext(), 22.0f);
        }
        if (!TextUtils.isEmpty(this.arq.weakStyleAdMark)) {
            screenWidth -= com.kwad.sdk.c.a.a.a(getContext(), 20.0f);
        }
        if (this.arq.weakStyleEnableClose) {
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

    private d zB() {
        if (bq.isNullString(this.arq.strongStyleCardUrl)) {
            return null;
        }
        e eVar = new e();
        eVar.a(this.app, this.aqJ, this.gO, this.aoT, this.f15if, this.aro, this.mApkDownloadHelper);
        eVar.bi();
        return eVar;
    }

    protected final boolean zD() {
        if (com.kwad.components.ct.home.config.b.FB()) {
            return false;
        }
        if (this.ary) {
            return true;
        }
        AdInfo adInfoEP = com.kwad.components.ct.response.a.a.eP(this.aro);
        return (!com.kwad.sdk.core.response.b.a.aJ(adInfoEP) || adInfoEP.status == 0 || adInfoEP.status == 7) ? false : true;
    }

    private void zt() {
        if (zD()) {
            return;
        }
        this.gO.removeCallbacks(this.aru);
        long j = this.arq.strongStyleAppearTime;
        if (j <= 0) {
            j = 5000;
        }
        this.gO.postDelayed(this.aru, j);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.are) {
            jm();
            this.arx = true;
            this.gO.removeCallbacks(this.aru);
            zG();
            return;
        }
        if (view == this.aqJ) {
            if (!ao.isNetworkConnected(view.getContext())) {
                ac.ae(view.getContext(), "网络错误");
            }
            com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.aro).b(this.mApkDownloadHelper).aG(2).aq(true).a(new a.b() { // from class: com.kwad.components.ct.detail.photo.a.i.6
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    i.b(i.this, true);
                    i.this.zF();
                }
            }));
        }
    }

    protected final void zE() {
        com.kwad.components.core.u.b.tq().a(this.aro, null, null);
    }

    protected final void zF() {
        CtAdTemplate ctAdTemplate = this.aro;
        AdBaseFrameLayout adBaseFrameLayout = this.f15if;
        com.kwad.sdk.core.adlog.c.a(ctAdTemplate, 51, adBaseFrameLayout == null ? null : adBaseFrameLayout.getTouchCoords());
    }

    private void zG() {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.eQ(9);
        com.kwad.sdk.core.adlog.c.b(this.aro, bVar, (JSONObject) null);
    }

    private d zA() {
        return zB();
    }
}
