package com.kwad.components.ct.horizontal.feed;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.refreshview.RefreshLayout;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.lib.a.c<CtAdResultData, CtAdTemplate> {
    private static WeakReference<KsContentPage.VideoListener> aLM;
    private static WeakReference<KsContentPage.ExternalViewControlListener> aLN;
    private com.kwad.components.core.widget.a.b aFs;
    private com.kwad.components.ct.horizontal.feed.a.b aLO;
    private boolean aLP;
    public KsContentPage.VideoListener alN;
    public KsContentPage.ExternalViewControlListener alU;
    private SceneImpl mSceneImpl;

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

    public static void b(KsContentPage.VideoListener videoListener) {
        aLM = new WeakReference<>(videoListener);
    }

    public static void a(KsContentPage.ExternalViewControlListener externalViewControlListener) {
        aLN = new WeakReference<>(externalViewControlListener);
    }

    private void c(KsContentPage.VideoListener videoListener) {
        this.alN = videoListener;
    }

    private void b(KsContentPage.ExternalViewControlListener externalViewControlListener) {
        this.alU = externalViewControlListener;
    }

    public c() {
        WeakReference<KsContentPage.VideoListener> weakReference = aLM;
        if (weakReference != null) {
            c(weakReference.get());
        }
        WeakReference<KsContentPage.ExternalViewControlListener> weakReference2 = aLN;
        if (weakReference2 != null) {
            b(weakReference2.get());
        }
    }

    public static c a(SceneImpl sceneImpl, boolean z, boolean z2) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_KS_SCENE", sceneImpl);
        bundle.putBoolean("KEY_IS_NEWS_FEED", z);
        bundle.putBoolean("KEY_IS_AUTO_PLAY", z2);
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

    @Override // com.kwad.sdk.lib.a.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        Activity activity;
        Window window;
        super.onViewCreated(view, bundle);
        if (this.alU == null || (activity = getActivity()) == null || (window = activity.getWindow()) == null) {
            return;
        }
        this.alU.addView((ViewGroup) window.getDecorView());
    }

    private boolean ES() {
        URLPackage uRLPackage;
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_KS_SCENE");
        if (!(serializable instanceof SceneImpl)) {
            return false;
        }
        this.mSceneImpl = SceneImpl.covert((SceneImpl) serializable);
        boolean z = arguments.getBoolean("KEY_IS_NEWS_FEED", false);
        this.aLP = arguments.getBoolean("KEY_IS_AUTO_PLAY", false);
        if (z) {
            uRLPackage = new URLPackage(String.valueOf(hashCode()), 23);
        } else {
            uRLPackage = new URLPackage(String.valueOf(hashCode()), 21);
        }
        this.mSceneImpl.setUrlPackage(uRLPackage);
        return true;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_horizontal_feed_home_layout;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final int rN() {
        return R.id.ksad_recycler_view;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final RefreshLayout Hs() {
        return (RefreshLayout) findViewById(R.id.ksad_horizontal_feed_refresh_layout);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.a.a.b<CtAdResultData, CtAdTemplate> ET() {
        com.kwad.components.ct.horizontal.feed.a.b bVar = new com.kwad.components.ct.horizontal.feed.a.b();
        this.aLO = bVar;
        bVar.mSceneImpl = this.mSceneImpl;
        com.kwad.components.core.widget.a.b bVar2 = new com.kwad.components.core.widget.a.b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        this.aLO.aLP = this.aLP;
        this.aLO.aFs = this.aFs;
        KsContentPage.VideoListener videoListener = this.alN;
        if (videoListener != null) {
            this.aLO.a(videoListener);
        }
        return this.aLO;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final void c(Presenter presenter) {
        presenter.d(new com.kwad.components.ct.horizontal.feed.b.d());
        presenter.d(new com.kwad.components.ct.horizontal.feed.b.a());
        if (this.aLP) {
            presenter.d(new com.kwad.components.ct.horizontal.feed.b.c());
        }
        if (com.kwad.components.ct.horizontal.a.b.Gm()) {
            presenter.d(new com.kwad.components.ct.horizontal.feed.b.b());
        }
    }

    private RecyclerView.ItemDecoration Ht() {
        if (this.mSceneImpl.getPageScene() == 23) {
            com.kwad.components.ct.horizontal.widget.a aVar = new com.kwad.components.ct.horizontal.widget.a(1, false, false);
            aVar.setDrawable(this.mContext.getResources().getDrawable(R.drawable.ksad_horizontal_feed_news_divider_bg));
            return aVar;
        }
        com.kwad.components.ct.horizontal.widget.a aVar2 = new com.kwad.components.ct.horizontal.widget.a(1, true, false);
        aVar2.setDrawable(this.mContext.getResources().getDrawable(R.drawable.ksad_horizontal_detail_video_feed_divider_bg));
        return aVar2;
    }

    private RecyclerView.LayoutManager Hu() {
        return new LinearLayoutManager(this.mContext);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.b.c<CtAdResultData, CtAdTemplate> EW() {
        return new d(this.mSceneImpl);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.widget.a.c<CtAdTemplate, ?> EX() {
        return new b(this, this.Wj, this.aLO);
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
        Activity activity;
        Window window;
        super.onDestroyView();
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.release();
        }
        com.kwad.components.ct.horizontal.feed.a.b bVar2 = this.aLO;
        if (bVar2 != null) {
            bVar2.release();
        }
        if (this.alU == null || (activity = getActivity()) == null || (window = activity.getWindow()) == null) {
            return;
        }
        this.alU.removeView((ViewGroup) window.getDecorView());
        this.alU = null;
    }
}
