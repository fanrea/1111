package com.kwad.components.ct.horizontal.video.b;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.horizontal.video.e;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.lib.a.c<CtAdResultData, CtAdTemplate> {
    private com.kwad.components.core.widget.a.b aFs;
    public e aLD;
    private com.kwad.components.ct.horizontal.video.b.b.b aPc;
    private a aPd;
    private CtAdTemplate mAdTemplate;

    @Override // com.kwad.sdk.lib.a.c
    public final boolean EU() {
        return true;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final int EV() {
        return 6;
    }

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.LayoutManager h(Object obj) {
        return Hu();
    }

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.ItemDecoration i(Object obj) {
        return Ht();
    }

    public static c H(CtAdTemplate ctAdTemplate) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_KS_AD_TEMPLATE", ctAdTemplate);
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
        Serializable serializable = arguments.getSerializable("KEY_KS_AD_TEMPLATE");
        if (!(serializable instanceof CtAdTemplate)) {
            return false;
        }
        CtAdTemplate ctAdTemplate = (CtAdTemplate) serializable;
        this.mAdTemplate = ctAdTemplate;
        ctAdTemplate.mAdScene.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 22));
        return true;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_horizontal_detail_video_related_layout;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.a.a.b<CtAdResultData, CtAdTemplate> ET() {
        com.kwad.components.ct.horizontal.video.b.b.b bVar = new com.kwad.components.ct.horizontal.video.b.b.b();
        this.aPc = bVar;
        bVar.mAdTemplate = this.mAdTemplate;
        this.aPc.aLD = this.aLD;
        com.kwad.components.core.widget.a.b bVar2 = new com.kwad.components.core.widget.a.b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        this.aPc.aFs = this.aFs;
        return this.aPc;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final int rN() {
        return R.id.ksad_horizontal_detail_video_related_recycler_view;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final void c(Presenter presenter) {
        presenter.d(new com.kwad.components.ct.horizontal.video.b.c.b());
        presenter.d(new com.kwad.components.ct.horizontal.video.b.c.a());
    }

    private RecyclerView.ItemDecoration Ht() {
        com.kwad.components.ct.horizontal.widget.a aVar = new com.kwad.components.ct.horizontal.widget.a(1, false, false);
        aVar.setDrawable(this.mContext.getResources().getDrawable(R.drawable.ksad_horizontal_detail_video_related_divider_bg));
        return aVar;
    }

    private RecyclerView.LayoutManager Hu() {
        return new LinearLayoutManager(this.mContext);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.b.c<CtAdResultData, CtAdTemplate> EW() {
        a aVar = new a(this.mAdTemplate);
        this.aPd = aVar;
        return aVar;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.widget.a.c<CtAdTemplate, ?> EX() {
        return new b(this, this.Wj, this.aPc);
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
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.release();
        }
    }

    public final void c(e eVar) {
        this.aLD = eVar;
    }

    public final void A(CtAdTemplate ctAdTemplate) {
        a aVar;
        if (ctAdTemplate == null || (aVar = this.aPd) == null) {
            return;
        }
        aVar.G(ctAdTemplate);
        this.aPd.refresh();
    }
}
