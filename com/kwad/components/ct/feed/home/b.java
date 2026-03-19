package com.kwad.components.ct.feed.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.lib.a.c<CtAdResultData, CtAdTemplate> {
    private com.kwad.components.ct.feed.home.b.b aFr;
    private com.kwad.components.core.widget.a.b aFs;
    private SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.lib.a.c
    public final boolean EU() {
        return true;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final int EV() {
        return 6;
    }

    public static b a(SceneImpl sceneImpl, int i) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_KS_SCENE", sceneImpl);
        bundle.putInt("KEY_PAGE_SCENE", i);
        bVar.setArguments(bundle);
        return bVar;
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
        Serializable serializable = arguments.getSerializable("KEY_KS_SCENE");
        if (!(serializable instanceof SceneImpl)) {
            return false;
        }
        this.mSceneImpl = SceneImpl.covert((SceneImpl) serializable);
        this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), arguments.getInt("KEY_PAGE_SCENE", 11)));
        return true;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_content_feed_home_layout;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final int rN() {
        return R.id.ksad_recycler_view;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.a.a.b<CtAdResultData, CtAdTemplate> ET() {
        com.kwad.components.ct.feed.home.b.b bVar = new com.kwad.components.ct.feed.home.b.b();
        this.aFr = bVar;
        bVar.mSceneImpl = this.mSceneImpl;
        com.kwad.components.core.widget.a.b bVar2 = new com.kwad.components.core.widget.a.b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        this.aFr.aFs = this.aFs;
        return this.aFr;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final void c(Presenter presenter) {
        presenter.d(new com.kwad.components.ct.feed.home.c.a());
        presenter.d(new com.kwad.components.ct.feed.home.c.c());
        presenter.d(new com.kwad.components.ct.feed.home.c.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public RecyclerView.ItemDecoration i(CtAdResultData ctAdResultData) {
        RecyclerView.ItemDecoration bVar;
        RecyclerView.ItemDecoration dVar;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Wj.getLayoutParams();
        int i = ctAdResultData.pageInfo.pageType;
        if (i == 2) {
            int iJ = com.kwad.sdk.c.a.a.j(this.mContext, R.dimen.ksad_content_feed_item_single_small_horizontal_padding);
            int iJ2 = com.kwad.sdk.c.a.a.j(this.mContext, R.dimen.ksad_content_feed_item_single_small_vertical_padding);
            bVar = new com.kwad.sdk.lib.widget.a.b(1, iJ, iJ2);
            marginLayoutParams.topMargin = iJ2;
            marginLayoutParams.leftMargin = iJ;
            marginLayoutParams.rightMargin = iJ;
        } else if (i == 3) {
            int iJ3 = com.kwad.sdk.c.a.a.j(this.mContext, R.dimen.ksad_content_feed_item_single_larger_horizontal_padding);
            int iJ4 = com.kwad.sdk.c.a.a.j(this.mContext, R.dimen.ksad_content_feed_item_single_larger_vertical_padding);
            bVar = new com.kwad.sdk.lib.widget.a.b(1, iJ3, iJ4);
            marginLayoutParams.topMargin = iJ4;
            marginLayoutParams.leftMargin = iJ3;
            marginLayoutParams.rightMargin = iJ3;
        } else if (i == 4) {
            int iJ5 = com.kwad.sdk.c.a.a.j(this.mContext, R.dimen.ksad_content_wallpaper_feed_item_double_h_padding);
            int iJ6 = com.kwad.sdk.c.a.a.j(this.mContext, R.dimen.ksad_content_wallpaper_feed_item_double_v_padding);
            bVar = new com.kwad.components.ct.detail.photo.related.d(2, iJ5);
            marginLayoutParams.topMargin = iJ6;
            marginLayoutParams.leftMargin = iJ5;
            marginLayoutParams.rightMargin = iJ5;
        } else if (i == 5) {
            int iJ7 = com.kwad.sdk.c.a.a.j(this.mContext, R.dimen.ksad_content_feed_item_no_padding);
            int iJ8 = com.kwad.sdk.c.a.a.j(this.mContext, R.dimen.ksad_content_feed_item_no_padding);
            bVar = new com.kwad.components.ct.detail.photo.related.d(2, iJ7);
            marginLayoutParams.topMargin = iJ8;
            marginLayoutParams.leftMargin = iJ7;
            marginLayoutParams.rightMargin = iJ7;
        } else {
            int iJ9 = com.kwad.sdk.c.a.a.j(this.mContext, R.dimen.ksad_content_feed_item_double_padding);
            dVar = new com.kwad.components.ct.detail.photo.related.d(2, iJ9);
            marginLayoutParams.topMargin = iJ9;
            marginLayoutParams.leftMargin = iJ9;
            marginLayoutParams.rightMargin = iJ9;
            this.Wj.setLayoutParams(marginLayoutParams);
            return dVar;
        }
        dVar = bVar;
        this.Wj.setLayoutParams(marginLayoutParams);
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.lib.a.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public RecyclerView.LayoutManager h(CtAdResultData ctAdResultData) {
        int i = ctAdResultData.pageInfo.pageType;
        if (i == 2 || i == 3) {
            return new LinearLayoutManager(this.mContext);
        }
        return new StaggeredGridLayoutManager(2, 1);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.b.c<CtAdResultData, CtAdTemplate> EW() {
        return new c(this.mSceneImpl);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.widget.a.c<CtAdTemplate, ?> EX() {
        return new a(this, this.Wj, this.aFr);
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
        com.kwad.components.ct.feed.b.EL().EN();
    }
}
