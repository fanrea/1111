package com.kwad.components.ct.tube.panel.choose;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends com.kwad.sdk.lib.a.c<CtAdResultData, CtAdTemplate> {
    private com.kwad.components.core.widget.a.b aFs;
    private TubeEpisodeChooseParam aXm;
    private com.kwad.components.ct.tube.panel.choose.b.b aXn;
    private SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.LayoutManager h(Object obj) {
        return Hu();
    }

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.ItemDecoration i(Object obj) {
        return Ht();
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(Bundle bundle) {
        if (!ES() && getActivity() != null) {
            getActivity().finish();
        } else {
            super.onCreate(bundle);
        }
    }

    private boolean ES() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_TUBE_EPISODE_CHOOSE_PARAM");
        if (!(serializable instanceof TubeEpisodeChooseParam)) {
            return false;
        }
        this.aXm = (TubeEpisodeChooseParam) serializable;
        this.mSceneImpl = new SceneImpl(this.aXm.mEntryScene);
        this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), this.aXm.mPageScene));
        return true;
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.wP();
        }
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        com.kwad.components.ct.tube.panel.choose.b.b bVar = this.aXn;
        if (bVar != null) {
            bVar.release();
        }
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_tube_panel_episode_choose_fragment;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final int rN() {
        return R.id.ksad_episode_choose_recycler_view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.a.c
    /* renamed from: KD, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.ct.tube.panel.choose.b.b ET() {
        com.kwad.components.ct.tube.panel.choose.b.b bVar = new com.kwad.components.ct.tube.panel.choose.b.b();
        this.aXn = bVar;
        bVar.aGE = this;
        com.kwad.components.core.widget.a.b bVar2 = new com.kwad.components.core.widget.a.b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        this.aXn.aFs = this.aFs;
        this.aXn.aXr = this.aXm;
        this.aXn.mSceneImpl = this.mSceneImpl;
        return this.aXn;
    }

    private RecyclerView.ItemDecoration Ht() {
        return new com.kwad.sdk.lib.widget.a.b(3, com.kwad.sdk.c.a.a.a(this.mContext, 8.0f), com.kwad.sdk.c.a.a.a(this.mContext, 10.0f));
    }

    private RecyclerView.LayoutManager Hu() {
        return new GridLayoutManager(this.mContext, 3);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.b.c<CtAdResultData, CtAdTemplate> EW() {
        return new c(this.mSceneImpl, this.aXm);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.widget.a.c<CtAdTemplate, ?> EX() {
        return new a(this, this.Wj, this.aXn);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final void c(Presenter presenter) {
        presenter.d(new com.kwad.components.ct.tube.panel.choose.c.a());
        presenter.d(new com.kwad.components.ct.tube.panel.choose.c.b());
    }
}
