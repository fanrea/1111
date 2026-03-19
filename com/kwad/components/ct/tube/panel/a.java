package com.kwad.components.ct.tube.panel;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import com.kwad.components.core.widget.a.b;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.tube.TubeEpisode;
import com.kwad.components.ct.tube.panel.a.c;
import com.kwad.components.ct.tube.panel.c.e;
import com.kwad.components.ct.tube.panel.choose.TubeEpisodeChooseParam;
import com.kwad.sdk.R;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.lib.a.d;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends d {
    private b aFs;
    private TubePanelTabParam aXi;
    private com.kwad.components.ct.tube.panel.b.b aXj;
    private Presenter mPresenter;
    private SceneImpl mSceneImpl;
    private final List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> aPS = new ArrayList();
    private final com.kwad.components.ct.api.tube.a aBy = new com.kwad.components.ct.api.tube.a() { // from class: com.kwad.components.ct.tube.panel.a.1
        @Override // com.kwad.components.ct.api.tube.a
        public final void a(List<CtAdTemplate> list, TubeEpisode tubeEpisode) {
            c.KJ().g(a.this);
        }
    };

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Ky();
        com.kwad.components.ct.tube.panel.a.a.KH().a(this.aBy);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onPause() {
        super.onPause();
        b bVar = this.aFs;
        if (bVar != null) {
            bVar.wP();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroyView() {
        super.onDestroyView();
        com.kwad.components.ct.tube.panel.b.b bVar = this.aXj;
        if (bVar != null) {
            bVar.release();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            getActivity().getWindow().setNavigationBarColor(-16777216);
        }
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        com.kwad.components.ct.tube.panel.a.a.KH().b(this.aBy);
        super.onDestroy();
    }

    private void Ky() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        Serializable serializable = arguments.getSerializable("KEY_TUBE_PANEL_TAB_PARAM");
        if (serializable instanceof TubePanelTabParam) {
            this.aXi = (TubePanelTabParam) serializable;
            this.mSceneImpl = new SceneImpl(this.aXi.mEntryScene);
            this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), this.aXi.mPageScene));
            Kz();
        }
    }

    private void Kz() {
        int iG = com.kwad.components.ct.tube.d.b.g(this.aXi.mTubeEpisode);
        int iF = com.kwad.components.ct.tube.d.b.f(this.aXi.mTubeEpisode);
        int i = 0;
        while (i < iG) {
            PagerSlidingTabStrip.c cVar = new PagerSlidingTabStrip.c(String.valueOf(i), String.format("%d-%d", Integer.valueOf((i * 30) + 1), Integer.valueOf(i == iG + (-1) ? iF : (i + 1) * 30)));
            TubeEpisodeChooseParam tubeEpisodeChooseParam = new TubeEpisodeChooseParam();
            tubeEpisodeChooseParam.mEntryScene = this.mSceneImpl.entryScene;
            tubeEpisodeChooseParam.mPageScene = this.mSceneImpl.getPageScene();
            tubeEpisodeChooseParam.mPlayingTubeEpisode = this.aXi.mTubeEpisode;
            tubeEpisodeChooseParam.mKSTubeParam = this.aXi.mKSTubeParam;
            tubeEpisodeChooseParam.mNextTubeLockEpisodeNum = this.aXi.mNextTubeLockEpisodeNum;
            i++;
            tubeEpisodeChooseParam.mPcursor = i;
            Bundle bundle = new Bundle();
            bundle.putSerializable("KEY_TUBE_EPISODE_CHOOSE_PARAM", tubeEpisodeChooseParam);
            this.aPS.add(new com.kwad.sdk.lib.widget.viewpager.tabstrip.b(cVar, com.kwad.components.ct.tube.panel.choose.b.class, bundle));
        }
    }

    @Override // com.kwad.sdk.lib.a.d, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.aXj = KA();
        Presenter presenterOnCreatePresenter = onCreatePresenter();
        this.mPresenter = presenterOnCreatePresenter;
        presenterOnCreatePresenter.ak(this.pQ);
        this.mPresenter.K(this.aXj);
        if (Build.VERSION.SDK_INT >= 21) {
            getActivity().getWindow().setNavigationBarColor(-1);
        }
    }

    private static Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ct.tube.panel.c.d());
        presenter.d(new com.kwad.components.ct.tube.panel.c.a());
        presenter.d(new com.kwad.components.ct.tube.panel.c.b());
        presenter.d(new com.kwad.components.ct.tube.panel.c.c());
        presenter.d(new e());
        return presenter;
    }

    private com.kwad.components.ct.tube.panel.b.b KA() {
        com.kwad.components.ct.tube.panel.b.b bVar = new com.kwad.components.ct.tube.panel.b.b();
        bVar.alG = this;
        bVar.aXQ = this.aXi;
        b bVar2 = new b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        bVar.aFs = this.aFs;
        bVar.aXR = this.aXR;
        bVar.aPS = this.aPS;
        bVar.mSceneImpl = this.mSceneImpl;
        return bVar;
    }

    @Override // com.kwad.sdk.lib.a.d
    public final String KB() {
        return String.valueOf(this.aXi.mTubeEpisode.pcursor - 1);
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_tube_panel_episode_tab_frgament;
    }

    @Override // com.kwad.sdk.lib.a.d
    public final int IJ() {
        return R.id.ksad_tube_pannel_tab_strip;
    }

    @Override // com.kwad.sdk.lib.a.d
    public final int IK() {
        return R.id.ksad_tube_pannel_view_pager;
    }

    @Override // com.kwad.sdk.lib.a.d
    public final List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> IL() {
        return this.aPS;
    }
}
