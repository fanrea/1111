package com.kwad.components.ct.tube.channel.detail;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.response.model.tube.TubeInfo;
import com.kwad.components.ct.tube.channel.detail.c.d;
import com.kwad.components.ct.tube.channel.detail.c.e;
import com.kwad.components.ct.tube.channel.detail.request.ChannelDetailResultData;
import com.kwad.sdk.R;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.lib.a.c<ChannelDetailResultData, TubeInfo> {
    private com.kwad.components.core.widget.a.b aFs;
    private ChannelDetailParam aVU;
    private com.kwad.components.ct.tube.channel.detail.b.b aVW;
    private SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.LayoutManager h(Object obj) {
        return Ki();
    }

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.ItemDecoration i(Object obj) {
        return Kh();
    }

    public static c a(ChannelDetailParam channelDetailParam) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_CHANNEL_DETAIL_PARAM", channelDetailParam);
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final int rN() {
        return R.id.ksad_channel_detail_recycler_view;
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
        return R.layout.ksad_tube_channel_detail_fragment;
    }

    private boolean ES() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_CHANNEL_DETAIL_PARAM");
        if (!(serializable instanceof ChannelDetailParam)) {
            return false;
        }
        this.aVU = (ChannelDetailParam) serializable;
        this.mSceneImpl = new SceneImpl(this.aVU.mEntryScene);
        URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 27);
        uRLPackage.putParams("channelId", this.aVU.mChannelInfo.channelId);
        this.mSceneImpl.setUrlPackage(uRLPackage);
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
        com.kwad.components.ct.tube.channel.detail.b.b bVar = this.aVW;
        if (bVar != null) {
            bVar.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.a.c
    /* renamed from: Kg, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.ct.tube.channel.detail.b.b ET() {
        com.kwad.components.ct.tube.channel.detail.b.b bVar = new com.kwad.components.ct.tube.channel.detail.b.b();
        this.aVW = bVar;
        bVar.aGE = this;
        com.kwad.components.core.widget.a.b bVar2 = new com.kwad.components.core.widget.a.b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        this.aVW.aFs = this.aFs;
        this.aVW.aVU = this.aVU;
        this.aVW.mSceneImpl = this.mSceneImpl;
        this.aVW.aFU = this.aFU;
        this.aVW.Wj = this.Wj;
        return this.aVW;
    }

    private RecyclerView.ItemDecoration Kh() {
        return new com.kwad.sdk.lib.widget.a.b(3, com.kwad.sdk.c.a.a.a(this.mContext, 8.0f), 0);
    }

    private RecyclerView.LayoutManager Ki() {
        return new GridLayoutManager(this.mContext, 3);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.b.c<ChannelDetailResultData, TubeInfo> EW() {
        return new com.kwad.components.ct.tube.channel.detail.request.a(this.mSceneImpl, this.aVU.mChannelInfo.channelId);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.widget.a.c<TubeInfo, ?> EX() {
        return new b(this, this.Wj, this.aVW);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final void c(Presenter presenter) {
        presenter.d(new com.kwad.components.ct.tube.channel.detail.c.b());
        presenter.d(new e());
        presenter.d(new com.kwad.components.ct.tube.channel.detail.c.c());
        presenter.d(new com.kwad.components.ct.tube.channel.detail.c.a());
        presenter.d(new d());
    }
}
