package com.kwad.components.ct.tube.channel.home;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.refreshview.RefreshLayout;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.home.d.d;
import com.kwad.components.ct.tube.channel.home.d.e;
import com.kwad.components.ct.tube.channel.home.d.f;
import com.kwad.components.ct.tube.channel.home.d.g;
import com.kwad.components.ct.tube.channel.home.request.TubeChannelResultData;
import com.kwad.sdk.R;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.lib.a.c<TubeChannelResultData, TubeInfo> {
    private com.kwad.components.core.widget.a.b aFs;
    private TubeChannelParam aWo;
    private com.kwad.components.ct.tube.channel.home.c.b aWq;
    private SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.LayoutManager h(Object obj) {
        return Km();
    }

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.ItemDecoration i(Object obj) {
        return Kl();
    }

    public static c a(TubeChannelParam tubeChannelParam) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_TUBE_PROFILE_PARAM", tubeChannelParam);
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(Bundle bundle) {
        Activity activity;
        if (!ES() && (activity = getActivity()) != null) {
            activity.finish();
        } else {
            super.onCreate(bundle);
        }
    }

    private boolean ES() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_TUBE_PROFILE_PARAM");
        if (!(serializable instanceof TubeChannelParam)) {
            return false;
        }
        this.aWo = (TubeChannelParam) serializable;
        this.mSceneImpl = new SceneImpl(this.aWo.mEntryScene);
        this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), this.aWo.mPageScene));
        return true;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_tube_channel_fragment;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final int rN() {
        return R.id.ksad_tube_profile_recycler_view;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final RefreshLayout Hs() {
        return (RefreshLayout) findViewById(R.id.ksad_tube_profile_refresh_layout);
    }

    private RecyclerView.ItemDecoration Kl() {
        return new com.kwad.sdk.lib.widget.a.b(3, com.kwad.sdk.c.a.a.a(this.mContext, 8.0f), com.kwad.sdk.c.a.a.a(this.mContext, 10.0f), com.kwad.sdk.c.a.a.a(this.mContext, 16.0f));
    }

    private RecyclerView.LayoutManager Km() {
        return new GridLayoutManager(this.mContext, 3);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.b.c<TubeChannelResultData, TubeInfo> EW() {
        return new com.kwad.components.ct.tube.channel.home.request.a(this.mSceneImpl, this.aWo.mTubeParam);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.widget.a.c<TubeInfo, ?> EX() {
        return new b(this, this.Wj, this.aWq);
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
        com.kwad.components.ct.tube.channel.home.c.b bVar = this.aWq;
        if (bVar != null) {
            bVar.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.a.c
    /* renamed from: Kn, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.ct.tube.channel.home.c.b ET() {
        com.kwad.components.ct.tube.channel.home.c.b bVar = new com.kwad.components.ct.tube.channel.home.c.b();
        this.aWq = bVar;
        bVar.aGE = this;
        com.kwad.components.core.widget.a.b bVar2 = new com.kwad.components.core.widget.a.b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        this.aWq.aFs = this.aFs;
        this.aWq.aWo = this.aWo;
        this.aWq.mSceneImpl = this.mSceneImpl;
        this.aWq.Wj = this.Wj;
        this.aWq.aFU = this.aFU;
        return this.aWq;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final void c(Presenter presenter) {
        presenter.d(new d());
        presenter.d(new com.kwad.components.ct.tube.channel.home.d.c());
        presenter.d(new e());
        presenter.d(new f());
        presenter.d(new com.kwad.components.ct.tube.channel.home.d.a());
        presenter.d(new com.kwad.components.ct.tube.channel.home.d.b());
        presenter.d(new g());
    }
}
