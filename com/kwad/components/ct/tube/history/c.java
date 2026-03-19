package com.kwad.components.ct.tube.history;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.detail.request.ChannelDetailResultData;
import com.kwad.components.ct.tube.history.c.d;
import com.kwad.components.ct.tube.history.c.e;
import com.kwad.components.ct.tube.history.c.f;
import com.kwad.sdk.R;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.lib.a.c<ChannelDetailResultData, TubeInfo> {
    private com.kwad.components.core.widget.a.b aFs;
    private TubeHistoryDetailParam aWO;
    private com.kwad.components.ct.tube.history.b.b aWQ;
    private SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.lib.a.b
    public final /* bridge */ /* synthetic */ RecyclerView.ItemDecoration i(Object obj) {
        return null;
    }

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.LayoutManager h(Object obj) {
        return Ki();
    }

    public static c a(TubeHistoryDetailParam tubeHistoryDetailParam) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_CHANNEL_DETAIL_PARAM", tubeHistoryDetailParam);
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final int rN() {
        return R.id.ksad_history_detail_recycler_view;
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(Bundle bundle) {
        if (!ES() && getActivity() != null) {
            getActivity().finish();
        } else {
            super.onCreate(bundle);
        }
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_tube_history_detail_fragment;
    }

    private boolean ES() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_CHANNEL_DETAIL_PARAM");
        if (!(serializable instanceof TubeHistoryDetailParam)) {
            return false;
        }
        this.aWO = (TubeHistoryDetailParam) serializable;
        this.mSceneImpl = new SceneImpl(this.aWO.mEntryScene);
        this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 33));
        return true;
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onPause() {
        super.onPause();
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.wP();
        }
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroyView() {
        super.onDestroyView();
        com.kwad.components.ct.tube.history.b.b bVar = this.aWQ;
        if (bVar != null) {
            bVar.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.a.c
    /* renamed from: Kt, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.ct.tube.history.b.b ET() {
        com.kwad.components.ct.tube.history.b.b bVar = new com.kwad.components.ct.tube.history.b.b();
        this.aWQ = bVar;
        bVar.aGE = this;
        com.kwad.components.core.widget.a.b bVar2 = new com.kwad.components.core.widget.a.b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        this.aWQ.aFs = this.aFs;
        this.aWQ.aWO = this.aWO;
        this.aWQ.mSceneImpl = this.mSceneImpl;
        this.aWQ.aFU = this.aFU;
        this.aWQ.Wj = this.Wj;
        return this.aWQ;
    }

    private RecyclerView.LayoutManager Ki() {
        return new LinearLayoutManager(this.mContext, 1, false);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.b.c<ChannelDetailResultData, TubeInfo> EW() {
        return new com.kwad.components.ct.tube.history.d.a(this.mSceneImpl, this.aWO);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.widget.a.c<TubeInfo, ?> EX() {
        return new b(this, this.Wj, this.aWQ);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final void c(Presenter presenter) {
        presenter.d(new com.kwad.components.ct.tube.history.c.b());
        presenter.d(new e());
        presenter.d(new com.kwad.components.ct.tube.history.c.c());
        presenter.d(new com.kwad.components.ct.tube.history.c.a());
        presenter.d(new d());
        presenter.d(new f());
    }
}
