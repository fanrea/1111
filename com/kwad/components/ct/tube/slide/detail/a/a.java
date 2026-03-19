package com.kwad.components.ct.tube.slide.detail.a;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.components.ct.tube.panel.TubePanelTabParam;
import com.kwad.sdk.R;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.components.ct.detail.b implements View.OnClickListener {
    private FrameLayout aYp;
    private TextView aYq;
    private TextView aYr;
    private CtAdTemplate mAdTemplate;
    private final AtomicBoolean aYs = new AtomicBoolean(false);
    private final com.kwad.sdk.core.j.c gZ = new d() { // from class: com.kwad.components.ct.tube.slide.detail.a.a.1
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void by() {
            if (a.this.aYs.getAndSet(true)) {
                return;
            }
            boolean zO = com.kwad.components.ct.response.a.c.o(com.kwad.components.ct.response.a.a.ay(a.this.mAdTemplate));
            com.kwad.sdk.core.d.c.d("PhotoTubeEnterPresenter", ">> isShowTubeEnter() isShowTubeEnter =" + zO);
            if (zO) {
                com.kwad.components.ct.e.b.JK().T(a.this.mAdTemplate);
            }
        }
    };
    private final com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.tube.slide.detail.a.a.2
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            a.this.aYs.set(false);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aYp = (FrameLayout) findViewById(R.id.ksad_tube_enter_container);
        this.aYq = (TextView) findViewById(R.id.ksad_tube_enter_tube_name);
        this.aYr = (TextView) findViewById(R.id.ksad_tube_enter_episode_num);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = this.aop.mAdTemplate;
        this.mAdTemplate = ctAdTemplate;
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
        if (com.kwad.components.ct.response.a.c.o(ctPhotoInfoAy) && !this.aop.aol.mKSTubeParam.disableShowTubePanelEntry) {
            TubeEpisode tubeEpisodeP = com.kwad.components.ct.response.a.c.p(ctPhotoInfoAy);
            this.aYr.setText("共" + com.kwad.components.ct.tube.d.b.f(tubeEpisodeP) + "集");
            this.aYq.setText(tubeEpisodeP.tubeInfo.name);
            this.aYp.setOnClickListener(this);
            this.aYp.setVisibility(0);
        } else {
            this.aYp.setVisibility(8);
        }
        if (this.aop.aoz != null) {
            this.aop.aoz.c(this.gZ);
        }
        this.aop.aoq.add(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.aop.aoq.remove(this.aoQ);
        if (this.aop.aoz != null) {
            this.aop.aoz.d(this.gZ);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ct.e.b.JK().U(this.mAdTemplate);
        TubeEpisode tubeEpisodeP = com.kwad.components.ct.response.a.c.p(com.kwad.components.ct.response.a.a.ay(this.mAdTemplate));
        SceneImpl sceneImpl = this.aop.mAdTemplate.mAdScene;
        TubePanelTabParam tubePanelTabParam = new TubePanelTabParam();
        tubePanelTabParam.mEntryScene = sceneImpl.entryScene;
        tubePanelTabParam.mPageScene = sceneImpl.getPageScene();
        tubePanelTabParam.mTubeEpisode = tubeEpisodeP;
        tubePanelTabParam.mKSTubeParam = this.aop.aol.mKSTubeParam;
        tubePanelTabParam.mNextTubeLockEpisodeNum = this.aop.aol.mNextTubeLockEpisodeNum;
        com.kwad.components.ct.tube.panel.a aVar = new com.kwad.components.ct.tube.panel.a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_TUBE_PANEL_TAB_PARAM", tubePanelTabParam);
        aVar.setArguments(bundle);
        if (this.aop.aoy.getParentFragment() != null) {
            this.aop.aol.aFo.getChildFragmentManager().beginTransaction().add(R.id.ksad_tube_pannel_container, aVar, "TubePanelTabFragment").commitAllowingStateLoss();
        }
    }
}
