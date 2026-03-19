package com.kwad.components.ct.horizontal.video;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.proxy.h;
import com.kwad.components.ct.horizontal.detail.HorizontalFeedParam;
import com.kwad.components.ct.horizontal.video.presenter.f;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.al;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends h {
    private static WeakReference<KsContentPage.VideoListener> aLM;
    private static WeakReference<KsContentPage.ExternalViewControlListener> aLN;
    private static WeakReference<KsContentPage.PageListener> aNy;
    private com.kwad.components.core.widget.a.b aFs;
    private HorizontalFeedParam aLB;
    private com.kwad.components.ct.horizontal.video.b.c aOC;
    private com.kwad.components.ct.horizontal.detail.b aOD;
    private c aOE = new c() { // from class: com.kwad.components.ct.horizontal.video.a.1
        @Override // com.kwad.components.ct.horizontal.video.c
        public final void A(CtAdTemplate ctAdTemplate) {
            ctAdTemplate.mAdScene = a.this.mSceneImpl;
            if (a.this.aLB != null) {
                a.this.aLB.mAdTemplate = ctAdTemplate;
                if (a.this.aOC != null) {
                    a.this.aOC.A(a.this.aLB.mAdTemplate);
                }
            }
        }
    };
    public KsContentPage.PageListener alM;
    public KsContentPage.VideoListener alN;
    public KsContentPage.ExternalViewControlListener alU;
    private Presenter mPresenter;
    private SceneImpl mSceneImpl;

    public a() {
        WeakReference<KsContentPage.VideoListener> weakReference = aLM;
        if (weakReference != null) {
            c(weakReference.get());
        }
        WeakReference<KsContentPage.ExternalViewControlListener> weakReference2 = aLN;
        if (weakReference2 != null) {
            b(weakReference2.get());
        }
        WeakReference<KsContentPage.PageListener> weakReference3 = aNy;
        if (weakReference3 != null) {
            b(weakReference3.get());
        }
    }

    public static a a(SceneImpl sceneImpl, HorizontalFeedParam horizontalFeedParam) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_AdScene", sceneImpl);
        bundle.putSerializable("KEY_HORIZONTAL_PARAM", horizontalFeedParam);
        aVar.setArguments(bundle);
        return aVar;
    }

    public static void b(KsContentPage.VideoListener videoListener) {
        aLM = new WeakReference<>(videoListener);
    }

    public static void a(KsContentPage.ExternalViewControlListener externalViewControlListener) {
        aLN = new WeakReference<>(externalViewControlListener);
    }

    public static void a(KsContentPage.PageListener pageListener) {
        aNy = new WeakReference<>(pageListener);
    }

    private void c(KsContentPage.VideoListener videoListener) {
        this.alN = videoListener;
    }

    private void b(KsContentPage.ExternalViewControlListener externalViewControlListener) {
        this.alU = externalViewControlListener;
    }

    private void b(KsContentPage.PageListener pageListener) {
        this.alM = pageListener;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_horizontal_detail_video_fragment;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        if (!Fo()) {
            com.kwad.sdk.core.d.c.e("HorizontalVideoFragment", "handleHomeParam fail");
            if (getActivity() != null) {
                getActivity().finish();
                return;
            }
        }
        if (com.kwad.components.core.u.e.e(getActivity())) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.pQ.getLayoutParams();
            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity());
            this.pQ.setLayoutParams(marginLayoutParams);
        }
        this.aOD = It();
        EP();
        if (this.mPresenter == null) {
            Presenter presenterOnCreatePresenter = onCreatePresenter();
            this.mPresenter = presenterOnCreatePresenter;
            presenterOnCreatePresenter.ak(this.pQ);
        }
        this.mPresenter.K(this.aOD);
        if (this.alU == null || getActivity() == null || getActivity().getWindow() == null) {
            return;
        }
        this.alU.addView((ViewGroup) getActivity().getWindow().getDecorView());
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onPause() {
        super.onPause();
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.wP();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroyView() {
        super.onDestroyView();
        com.kwad.sdk.core.d.c.i("HorizontalVideoFragment", "onDestroyView");
        g.abi().abb();
        com.kwad.sdk.core.video.a.a.a.acK().abb();
        com.kwad.components.ct.horizontal.detail.b bVar = this.aOD;
        if (bVar != null) {
            bVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
        com.kwad.components.core.widget.a.b bVar2 = this.aFs;
        if (bVar2 != null) {
            bVar2.release();
        }
        if (this.alU == null || getActivity() == null || getActivity().getWindow() == null) {
            return;
        }
        this.alU.removeView((ViewGroup) getActivity().getWindow().getDecorView());
        this.alU = null;
    }

    private boolean Fo() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("key_AdScene");
        if (!(serializable instanceof KsScene)) {
            return false;
        }
        this.mSceneImpl = SceneImpl.covert((SceneImpl) serializable);
        Serializable serializable2 = arguments.getSerializable("KEY_HORIZONTAL_PARAM");
        if (serializable2 instanceof HorizontalFeedParam) {
            this.aLB = (HorizontalFeedParam) serializable2;
        }
        this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 22));
        HorizontalFeedParam horizontalFeedParam = this.aLB;
        if (horizontalFeedParam == null || horizontalFeedParam.mAdTemplate == null) {
            return true;
        }
        this.aLB.mAdTemplate.mAdScene = this.mSceneImpl;
        return true;
    }

    private com.kwad.components.ct.horizontal.detail.b It() {
        com.kwad.components.ct.horizontal.detail.b bVar = new com.kwad.components.ct.horizontal.detail.b();
        bVar.aLD = new e();
        bVar.aLD.a(this.aOE);
        bVar.aoy = this;
        com.kwad.components.core.widget.a.b bVar2 = new com.kwad.components.core.widget.a.b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        KsContentPage.VideoListener videoListener = this.alN;
        if (videoListener != null) {
            bVar.a(videoListener);
        }
        bVar.aFs = this.aFs;
        bVar.mSceneImpl = this.mSceneImpl;
        bVar.mAdTemplate = this.aLB.mAdTemplate;
        bVar.mEnterPlayPosition = this.aLB.mEnterPlayPosition;
        KsContentPage.ContentItem contentItem = new KsContentPage.ContentItem();
        contentItem.id = al.md5(String.valueOf(com.kwad.components.ct.response.a.a.bg(bVar.mAdTemplate)));
        bVar.aLE = contentItem;
        bVar.alM = this.alM;
        bVar.aLF = getLifecycle();
        return bVar;
    }

    private static Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.d(new com.kwad.components.ct.horizontal.video.presenter.c());
        presenter.d(new f());
        presenter.d(new com.kwad.components.ct.horizontal.video.presenter.e());
        presenter.d(new com.kwad.components.ct.horizontal.video.presenter.b());
        return presenter;
    }

    private void EP() {
        com.kwad.components.ct.horizontal.video.b.c cVarH = com.kwad.components.ct.horizontal.video.b.c.H(this.aOD.mAdTemplate);
        this.aOC = cVarH;
        cVarH.c(this.aOD.aLD);
        getFragmentManager().beginTransaction().replace(R.id.ksad_horizontal_video_related_fragment_container, this.aOC).commitAllowingStateLoss();
    }
}
