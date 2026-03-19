package com.kwad.components.ct.horizontal.news;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.ct.horizontal.news.c.h;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsHorizontalFeedPage;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.al;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.sdk.lib.a.c<CtAdResultData, CtAdTemplate> {
    private static WeakReference<KsContentPage.ExternalViewControlListener> aLN;
    private static WeakReference<KsHorizontalFeedPage.NewsPageListener> aNy;
    private com.kwad.components.core.widget.a.b aFs;
    private KsHorizontalFeedPage.NewsPageListener aNA;
    private com.kwad.components.ct.horizontal.news.b.b aNz;
    private KsContentPage.ExternalViewControlListener alU;
    private CtAdTemplate mEntryAdTemplate;
    private SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.lib.a.c
    public final int EV() {
        return 6;
    }

    @Override // com.kwad.sdk.lib.a.b
    public final /* bridge */ /* synthetic */ RecyclerView.ItemDecoration i(Object obj) {
        return null;
    }

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.LayoutManager h(Object obj) {
        return Hu();
    }

    public static c a(NewsDetailParam newsDetailParam) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_NEWS_DETAIL_PARAM", newsDetailParam);
        cVar.setArguments(bundle);
        return cVar;
    }

    public static void a(KsHorizontalFeedPage.NewsPageListener newsPageListener) {
        aNy = new WeakReference<>(newsPageListener);
    }

    public static void a(KsContentPage.ExternalViewControlListener externalViewControlListener) {
        aLN = new WeakReference<>(externalViewControlListener);
    }

    public c() {
        WeakReference<KsHorizontalFeedPage.NewsPageListener> weakReference = aNy;
        if (weakReference != null) {
            b(weakReference.get());
        }
        WeakReference<KsContentPage.ExternalViewControlListener> weakReference2 = aLN;
        if (weakReference2 != null) {
            b(weakReference2.get());
        }
    }

    private void b(KsHorizontalFeedPage.NewsPageListener newsPageListener) {
        this.aNA = newsPageListener;
    }

    private void b(KsContentPage.ExternalViewControlListener externalViewControlListener) {
        this.alU = externalViewControlListener;
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
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_NEWS_DETAIL_PARAM");
        if (!(serializable instanceof NewsDetailParam)) {
            return false;
        }
        NewsDetailParam newsDetailParam = (NewsDetailParam) serializable;
        SceneImpl sceneImplCovert = SceneImpl.covert(newsDetailParam.mEntryScene);
        this.mSceneImpl = sceneImplCovert;
        sceneImplCovert.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 24));
        CtAdTemplate ctAdTemplate = newsDetailParam.mEntryAdTemplate;
        this.mEntryAdTemplate = ctAdTemplate;
        ctAdTemplate.mAdScene = this.mSceneImpl;
        return true;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_news_detail_fragment;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final int rN() {
        return R.id.ksad_recycler_view;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.a.a.b<CtAdResultData, CtAdTemplate> ET() {
        com.kwad.components.ct.horizontal.news.b.b bVar = new com.kwad.components.ct.horizontal.news.b.b();
        this.aNz = bVar;
        bVar.mSceneImpl = this.mSceneImpl;
        this.aNz.mEntryAdTemplate = this.mEntryAdTemplate;
        com.kwad.components.core.widget.a.b bVar2 = new com.kwad.components.core.widget.a.b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        this.aNz.aFs = this.aFs;
        KsContentPage.ContentItem contentItem = new KsContentPage.ContentItem();
        contentItem.id = al.md5(String.valueOf(com.kwad.components.ct.response.a.a.bg(this.mEntryAdTemplate)));
        this.aNz.aLE = contentItem;
        this.aNz.aNA = this.aNA;
        return this.aNz;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final void c(Presenter presenter) {
        presenter.d(new h());
        presenter.d(new com.kwad.components.ct.horizontal.news.c.f());
        presenter.d(new com.kwad.components.ct.horizontal.news.c.g());
        presenter.d(new com.kwad.components.ct.horizontal.news.c.a());
        presenter.d(new com.kwad.components.ct.horizontal.news.c.c());
        presenter.d(new com.kwad.components.ct.horizontal.news.c.e());
        presenter.d(new com.kwad.components.ct.horizontal.news.c.b());
        presenter.d(new com.kwad.components.ct.horizontal.news.c.d());
    }

    private RecyclerView.LayoutManager Hu() {
        return new LinearLayoutManager(this.mContext);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.b.c<CtAdResultData, CtAdTemplate> EW() {
        return new e(this.mSceneImpl, this.mEntryAdTemplate);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.widget.a.c<CtAdTemplate, ?> EX() {
        return new b(this, this.Wj, this.aNz);
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
        if (this.alU == null || (activity = getActivity()) == null || (window = activity.getWindow()) == null) {
            return;
        }
        this.alU.removeView((ViewGroup) window.getDecorView());
        this.alU = null;
    }
}
