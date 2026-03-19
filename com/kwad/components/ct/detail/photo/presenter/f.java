package com.kwad.components.ct.detail.photo.presenter;

import android.content.res.Resources;
import android.widget.FrameLayout;
import com.kwad.components.ct.detail.photo.view.WaterMarkView;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.ct.detail.b {
    private WaterMarkView avK;
    private boolean avL;
    private long avM;
    private boolean avN;
    private int mPageScene;
    private final com.kwad.components.ct.hotspot.e aqP = new com.kwad.components.ct.hotspot.f() { // from class: com.kwad.components.ct.detail.photo.presenter.f.1
        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void zp() {
            f.this.avK.setVisibility(4);
        }

        @Override // com.kwad.components.ct.hotspot.f, com.kwad.components.ct.hotspot.e
        public final void bB(int i) {
            if (!f.this.avL || f.this.avN) {
                return;
            }
            f.this.avK.setVisibility(0);
        }
    };
    private final com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.photo.presenter.f.2
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            super.qy();
            if (f.this.avM > 0) {
                bx.runOnUiThreadDelay(f.this.avO, f.this.avM);
            }
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            super.qz();
            bx.d(f.this.avO);
        }
    };
    private final Runnable avO = new Runnable() { // from class: com.kwad.components.ct.detail.photo.presenter.f.3
        @Override // java.lang.Runnable
        public final void run() {
            f.a(f.this, true);
            f.this.avK.setVisibility(8);
        }
    };

    private static boolean bI(int i) {
        return i == 1;
    }

    static /* synthetic */ boolean a(f fVar, boolean z) {
        fVar.avN = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.avK = (WaterMarkView) findViewById(R.id.ksad_video_water_mark);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() throws Resources.NotFoundException {
        super.ay();
        this.avN = false;
        if (this.aop.aol != null) {
            this.mPageScene = this.aop.aol.mSceneImpl.getPageScene();
        }
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.aop.mAdTemplate);
        boolean z = ctPhotoInfoAy.baseInfo.waterMarkPosition != 0;
        this.avL = z;
        if (!z) {
            this.avK.setVisibility(8);
            return;
        }
        long j = ctPhotoInfoAy.baseInfo.waterMarkShowDuration;
        this.avM = j;
        if (j != -1 && j <= 0) {
            this.avK.setVisibility(8);
        } else {
            this.avK.setVisibility(0);
        }
        int iR = com.kwad.components.ct.response.a.c.r((PhotoInfo) ctPhotoInfoAy);
        this.avK.setAuthorInfo(ctPhotoInfoAy.authorInfo);
        this.avK.setAlignment(bI(iR) ? 1 : 0);
        bJ(iR);
        if (com.kwad.components.ct.response.a.a.aV(this.aop.mAdTemplate)) {
            this.aop.a(this.aqP);
        }
        this.aop.aoq.add(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.b(this.aqP);
        this.aop.aoq.remove(this.aoQ);
        bx.d(this.avO);
    }

    private void bJ(int i) {
        int iJ;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.avK.getLayoutParams();
        if (i == 2) {
            layoutParams.gravity = 3;
            layoutParams.leftMargin = com.kwad.sdk.c.a.a.a(getContext(), 12.0f);
        } else {
            layoutParams.gravity = 5;
            layoutParams.rightMargin = com.kwad.sdk.c.a.a.a(getContext(), 12.0f);
        }
        int statusBarHeight = com.kwad.components.core.u.e.e(getActivity()) ? 0 + com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0;
        if (this.mPageScene != 10) {
            statusBarHeight += this.aop.aol.aGL;
        }
        if (com.kwad.components.ct.response.a.a.aV(this.aop.mAdTemplate)) {
            statusBarHeight += com.kwad.sdk.c.a.a.a(getContext(), 50.0f);
        }
        if (com.kwad.sdk.core.scene.a.fw(this.mPageScene)) {
            iJ = com.kwad.sdk.c.a.a.a(getContext(), 10.0f);
        } else {
            iJ = com.kwad.sdk.c.a.a.j(getContext(), R.dimen.ksad_video_water_mark_margin_top);
        }
        layoutParams.topMargin = statusBarHeight + iJ;
        this.avK.setLayoutParams(layoutParams);
    }
}
