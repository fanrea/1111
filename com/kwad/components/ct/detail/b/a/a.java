package com.kwad.components.ct.detail.b.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.ct.profile.home.ProfileHomeParam;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ec.api.EcLiveComponents;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.b implements View.OnClickListener {
    private boolean auE;
    private LinearLayout ayD;
    private TextView ayE;
    private TextView ayF;
    private TextView ayG;

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f9if;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f9if = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.ayD = (LinearLayout) findViewById(R.id.ksad_bottom_author_name_container);
        this.ayE = (TextView) findViewById(R.id.ksad_bottom_author_name);
        this.ayF = (TextView) findViewById(R.id.ksad_bottom_play_times);
        this.ayG = (TextView) findViewById(R.id.ksad_bottom_author_area);
        this.auE = com.kwad.components.ct.detail.a.b.yO();
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = this.aop.mAdTemplate;
        this.mApkDownloadHelper = this.aop.mApkDownloadHelper;
        String strAJ = com.kwad.components.ct.response.a.a.aJ(this.mAdTemplate);
        if (bq.isNullString(strAJ) && com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            strAJ = getContext().getString(R.string.ksad_ad_default_username);
        }
        if (bq.isNullString(strAJ) || (com.kwad.components.ct.response.a.a.aW(this.mAdTemplate) && this.aop.aol.mKSTubeParam.hideDetailBottomTitle)) {
            this.ayE.setVisibility(8);
        } else {
            this.ayE.setText(strAJ);
            this.ayE.setTextSize(com.kwad.components.ct.response.a.a.aK(this.mAdTemplate));
            this.ayE.setVisibility(0);
        }
        if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate) || com.kwad.components.ct.response.a.a.aW(this.mAdTemplate)) {
            this.ayF.setVisibility(8);
        } else {
            String strBM = bq.bM(com.kwad.components.ct.response.a.a.aU(this.mAdTemplate));
            if (bq.isNullString(strBM)) {
                this.ayF.setVisibility(8);
            } else {
                this.ayF.setText(strBM);
                this.ayF.setVisibility(0);
            }
        }
        String strJ = com.kwad.components.ct.response.a.c.j(com.kwad.components.ct.response.a.a.ay(this.mAdTemplate));
        if (!com.kwad.components.ct.response.a.a.eH(this.mAdTemplate) && !TextUtils.isEmpty(strJ)) {
            this.ayG.setText("发布于 " + strJ);
            this.ayG.setVisibility(0);
        } else {
            this.ayG.setVisibility(8);
        }
        this.ayD.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            handleAdClick();
        } else if (this.aop.aow) {
            AE();
        } else {
            AF();
        }
    }

    private void handleAdClick() {
        if ((this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
            com.kwad.components.ct.e.b.JK().b(this.aop.mAdTemplate, 1);
        }
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(2).aq(false).aF(24).d(this.f9if.getTouchCoords()).as(true));
    }

    private void AF() {
        if (this.auE) {
            CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.mAdTemplate);
            SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
            if (sceneImpl != null) {
                bG(3);
                ProfileHomeParam profileHomeParam = new ProfileHomeParam();
                profileHomeParam.mEntryScene = sceneImpl.entryScene;
                profileHomeParam.mCurrentPhotoId = com.kwad.components.ct.response.a.c.j((PhotoInfo) ctPhotoInfoAy);
                profileHomeParam.mAdTemplate = this.mAdTemplate;
                com.kwad.components.ct.profile.home.a.a(getContext(), profileHomeParam);
                this.mAdTemplate.mIsNotNeedAvatarGuider = true;
            }
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

    private void bG(int i) {
        com.kwad.components.ct.e.b.JK().e(this.mAdTemplate, i);
    }
}
