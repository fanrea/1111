package com.kwad.components.ct.detail.photo.newui.d;

import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.ct.detail.photo.newui.d.e;
import com.kwad.components.ct.profile.home.ProfileHomeParam;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ec.api.EcLiveComponents;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bq;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.detail.photo.e.a<View> {
    protected ImageView EZ;
    protected Handler aeI = new Handler(Looper.getMainLooper());
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.newui.d.d.2
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            d.this.ari = true;
            com.kwad.sdk.core.d.c.d("PhotoAuthorIconPresenter", "becomesAttachedOnPageSelected");
            if (c.Aw().AB() && com.kwad.components.ct.response.a.a.as(d.this.mAdTemplate)) {
                d.this.AC();
            }
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            d.this.ari = false;
            com.kwad.sdk.core.d.c.d("PhotoAuthorIconPresenter", "becomesDetachedOnPageSelected");
            d.this.release();
        }
    };
    protected boolean ari;
    protected View auA;
    protected View auB;
    protected ImageView auC;
    protected AnimatorSet auD;
    private boolean auE;
    private a auF;
    private e auG;

    /* renamed from: if, reason: not valid java name */
    protected AdBaseFrameLayout f16if;
    protected CtAdTemplate mAdTemplate;

    @Override // com.kwad.components.ct.detail.photo.e.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f16if = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.auA = findViewById(R.id.ksad_author_button_container);
        this.auB = findViewById(R.id.ksad_author_icon_container);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_author_icon);
        this.EZ = imageView;
        imageView.setImageResource(R.drawable.ksad_photo_default_author_icon_2);
        this.auC = (ImageView) findViewById(R.id.ksad_author_guide_icon);
        this.auE = com.kwad.components.ct.detail.a.b.yO();
    }

    @Override // com.kwad.components.ct.detail.photo.e.d
    public final View Ag() {
        return LayoutInflater.from(getContext()).inflate(R.layout.ksad_photo_newui_author_icon_view, (ViewGroup) this.aul, false);
    }

    @Override // com.kwad.components.ct.detail.photo.e.a, com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aop.aoB = true;
        this.mAdTemplate = this.aop.mAdTemplate;
        this.auA.setOnClickListener(this);
        this.aop.aoq.add(this.aoQ);
        if (this.mAdTemplate.mAdScene != null && this.mAdTemplate.mAdScene.getPageScene() != 16 && this.mAdTemplate.mAdScene.getPageScene() != 4) {
            e eVar = new e(new e.a() { // from class: com.kwad.components.ct.detail.photo.newui.d.d.1
                @Override // com.kwad.components.ct.detail.photo.newui.d.e.a
                public final void l(long j, long j2) {
                    com.kwad.sdk.core.d.c.d("PhotoAuthorIconPresenter", "PlayRateListener onAchieved() videoDuration=" + j + " playTimeLength=" + j2 + " playTimeLength/videoDuration=" + (j / j2));
                    if (!c.Aw().Az() || d.this.mAdTemplate.mIsNotNeedAvatarGuider || d.this.aop.aow || d.this.auF == null) {
                        return;
                    }
                    d.this.auF.start(c.Aw().AA());
                }
            });
            this.auG = eVar;
            eVar.b(this.aop.aoz);
        }
        bF(-1);
        AD();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.aoq.remove(this.aoQ);
        e eVar = this.auG;
        if (eVar != null) {
            eVar.a(this.aop.aoz);
        }
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AC() {
        this.auF = new a(this.EZ, this.aeI, new b() { // from class: com.kwad.components.ct.detail.photo.newui.d.d.3
            @Override // com.kwad.components.ct.detail.photo.newui.d.b
            public final void onStart() {
                d.this.mAdTemplate.mIsNotNeedAvatarGuider = true;
                c.Aw().Ay();
                d.this.bF(-65437);
            }

            @Override // com.kwad.components.ct.detail.photo.newui.d.b
            public final void onStop() {
                d.this.bF(-1);
            }
        });
    }

    protected final void release() {
        if (this.auD != null) {
            this.auB.clearAnimation();
            this.auD.cancel();
        }
        a aVar = this.auF;
        if (aVar != null) {
            aVar.stop();
        }
        this.aop.aox = null;
        this.aop.aow = false;
        this.aeI.removeCallbacksAndMessages(null);
    }

    public final void bF(int i) {
        int i2;
        if (this.EZ == null) {
            return;
        }
        String strBf = com.kwad.components.ct.response.a.a.bf(this.mAdTemplate);
        if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            i2 = R.drawable.ksad_default_ad_author_icon;
        } else {
            i2 = R.drawable.ksad_photo_default_author_icon;
        }
        ImageView imageView = this.EZ;
        KSImageLoader.loadCircleIcon(imageView, strBf, imageView.getResources().getDrawable(i2), i);
    }

    private void AD() {
        String strAG = com.kwad.components.ct.response.a.a.aG(this.mAdTemplate);
        if (bq.isNullString(strAG) || com.kwad.components.ct.response.a.c.G(com.kwad.components.ct.response.a.a.ay(this.mAdTemplate))) {
            this.auC.setVisibility(8);
            return;
        }
        if (com.kwad.components.ct.response.a.a.as(this.mAdTemplate)) {
            if (!this.auE) {
                this.auC.setVisibility(8);
                return;
            }
        } else if (com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(this.mAdTemplate)) && !com.kwad.components.ct.detail.a.b.yU()) {
            this.auC.setVisibility(8);
            return;
        }
        KSImageLoader.loadImage(this.auC, strAG, this.mAdTemplate);
        this.auC.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (com.kwad.sdk.c.a.a.Wl()) {
                return;
            }
            if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
                if (!com.kwad.sdk.core.response.b.a.aJ(com.kwad.components.ct.response.a.a.eP(this.mAdTemplate)) || com.kwad.components.ct.detail.a.b.yU()) {
                    handleAdClick();
                }
                bG(0);
            } else if (this.aop.aow) {
                AE();
            } else {
                AF();
            }
            if (this.aop.aol.aHd != null) {
                this.aop.aol.aHd.onAvatarClick(com.kwad.components.ct.response.a.a.ax(this.aop.mAdTemplate));
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void AE() {
        if (this.aop.mAdTemplate.mAdScene == null || this.aop.aox == null || !this.aop.aow) {
            return;
        }
        bG(9);
        if (((EcLiveComponents) com.kwad.sdk.components.d.g(EcLiveComponents.class)) != null) {
            getContext();
        }
    }

    private void AF() {
        if (this.auE && !com.kwad.components.ct.response.a.c.G(com.kwad.components.ct.response.a.a.ay(this.mAdTemplate))) {
            CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.mAdTemplate);
            SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
            if (sceneImpl != null) {
                bG(3);
                ProfileHomeParam profileHomeParam = new ProfileHomeParam();
                profileHomeParam.mEntryScene = sceneImpl.entryScene;
                profileHomeParam.mCurrentPhotoId = com.kwad.components.ct.response.a.c.j((PhotoInfo) ctPhotoInfoAy);
                profileHomeParam.mAdTemplate = this.mAdTemplate;
                com.kwad.components.ct.profile.home.a.a(this.aop.aoy, 1001, profileHomeParam);
                this.mAdTemplate.mIsNotNeedAvatarGuider = true;
                a aVar = this.auF;
                if (aVar != null) {
                    aVar.stop();
                }
            }
        }
    }

    private void bG(int i) {
        com.kwad.components.ct.e.b.JK().c(this.mAdTemplate, 5, i);
        new HashMap().put("elementType", 22);
        com.kwad.sdk.components.d.g(com.kwad.components.ec.api.a.class);
    }

    private void handleAdClick() {
        if ((this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
            com.kwad.components.ct.e.b.JK().b(this.aop.mAdTemplate, 1);
        }
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.aop.mApkDownloadHelper).aG(2).aF(13).d(this.f16if.getTouchCoords()).as(true));
    }
}
