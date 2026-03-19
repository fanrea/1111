package com.kwad.components.ct.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.mobstat.forbes.Config;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.refreshview.KsAdHotRefreshView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.widget.swipe.HorizontalSwipeLayout;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class i extends com.kwad.components.core.proxy.h {
    private static WeakReference<KsContentPage.KsShareListener> aGV;
    private static WeakReference<KsContentPage.ExternalViewControlListener> aGW;
    private static WeakReference<KsContentPage.KsEcBtnClickListener> aGX;
    private static WeakReference<KsContentPage.KsVideoBtnClickListener> aGY;
    private com.kwad.components.core.widget.a.b aFs;
    private int aGL;
    private f aGP;
    private c aGZ;
    private KsAdHotRefreshView aHa;
    private String aHc;
    public KsContentPage.KsVideoBtnClickListener aHd;
    private com.kwad.components.ct.api.a.a.b aHe;
    protected int aHi;
    private boolean aHj;
    private String alR;
    public KsContentPage.KsShareListener alT;
    public KsContentPage.ExternalViewControlListener alU;
    public KsContentPage.KsEcBtnClickListener alV;
    private HorizontalSwipeLayout aoP;
    protected SlidePlayViewPager aok;
    private com.kwad.components.ct.api.a.a.c ayi;
    private Presenter mPresenter;
    protected SceneImpl mSceneImpl;
    private final l aGR = new l();
    private String aHb = "unknown";
    private com.kwad.components.ct.g.a aoI = new com.kwad.components.ct.g.a();
    protected boolean aGJ = false;
    private boolean aHf = false;
    protected boolean aHg = false;
    protected boolean aGK = false;
    protected boolean aHh = true;

    protected boolean Fr() {
        return false;
    }

    protected boolean a(Bundle bundle) {
        return false;
    }

    protected boolean a(f fVar) {
        return false;
    }

    protected void b(j jVar) {
    }

    protected boolean b(Presenter presenter) {
        return false;
    }

    public i() {
        WeakReference<KsContentPage.KsShareListener> weakReference = aGV;
        if (weakReference != null && weakReference.get() != null) {
            setShareListener(aGV.get());
        }
        WeakReference<KsContentPage.ExternalViewControlListener> weakReference2 = aGW;
        if (weakReference2 != null && weakReference2.get() != null) {
            setExternalViewControlListener(aGW.get());
        }
        WeakReference<KsContentPage.KsEcBtnClickListener> weakReference3 = aGX;
        if (weakReference3 != null && weakReference3.get() != null) {
            setEcBtnClickListener(aGX.get());
        }
        WeakReference<KsContentPage.KsVideoBtnClickListener> weakReference4 = aGY;
        if (weakReference4 == null || weakReference4.get() == null) {
            return;
        }
        setVideoBtnClickListener(aGY.get());
    }

    public static i c(SceneImpl sceneImpl) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_AdScene", sceneImpl);
        iVar.setArguments(bundle);
        return iVar;
    }

    public static void a(KsContentPage.KsShareListener ksShareListener) {
        aGV = new WeakReference<>(ksShareListener);
    }

    public static void a(KsContentPage.ExternalViewControlListener externalViewControlListener) {
        aGW = new WeakReference<>(externalViewControlListener);
    }

    public static void a(KsContentPage.KsEcBtnClickListener ksEcBtnClickListener) {
        aGX = new WeakReference<>(ksEcBtnClickListener);
    }

    public static void a(KsContentPage.KsVideoBtnClickListener ksVideoBtnClickListener) {
        aGY = new WeakReference<>(ksVideoBtnClickListener);
    }

    public final void setShareListener(KsContentPage.KsShareListener ksShareListener) {
        this.alT = ksShareListener;
    }

    private void setExternalViewControlListener(KsContentPage.ExternalViewControlListener externalViewControlListener) {
        this.alU = externalViewControlListener;
    }

    public final void setEcBtnClickListener(KsContentPage.KsEcBtnClickListener ksEcBtnClickListener) {
        this.alV = ksEcBtnClickListener;
    }

    public final void setVideoBtnClickListener(KsContentPage.KsVideoBtnClickListener ksVideoBtnClickListener) {
        this.aHd = ksVideoBtnClickListener;
    }

    public final void refreshBySchema(String str) {
        SlidePlayViewPager slidePlayViewPager;
        if (this.ayi == null || (slidePlayViewPager = this.aok) == null || slidePlayViewPager.getSourceType() != 0) {
            return;
        }
        if (this.aHa.GQ()) {
            this.aHa.setRefreshing(false);
        }
        if (bq.isNullString(str)) {
            return;
        }
        this.aHc = str;
        com.kwad.sdk.core.d.c.d("HomeFragment", "refreshBySchema schema=" + str);
        com.kwad.sdk.o.a aVar = new com.kwad.sdk.o.a(str);
        if (com.kwad.sdk.o.b.b(aVar)) {
            this.aHb = Config.PUSH;
            this.aGK = com.kwad.components.ct.home.config.b.FE();
        } else {
            if (!com.kwad.sdk.o.b.c(aVar)) {
                return;
            }
            this.aHb = "message_share";
            this.aGK = false;
        }
        a(this.alT);
        com.kwad.sdk.core.scene.b.abP().b(this.aHb, this.mSceneImpl);
        this.aGJ = com.kwad.components.ct.home.config.b.FC();
        this.ayi.a(aVar);
    }

    public final void tryToRefresh() {
        SlidePlayViewPager slidePlayViewPager;
        if (this.ayi == null || (slidePlayViewPager = this.aok) == null || slidePlayViewPager.getSourceType() != 0) {
            return;
        }
        if (com.kwad.components.ct.home.config.b.FD()) {
            if (!this.aHa.GQ()) {
                this.ayi.refresh(2);
                return;
            } else {
                com.kwad.sdk.core.d.c.d("HomeFragment", "tryToRefresh is mRefreshLayout isRefreshViewShowing");
                return;
            }
        }
        com.kwad.sdk.core.d.c.i("HomeFragment", "tryToRefresh is disable");
    }

    public final SlidePlayViewPager Fn() {
        return this.aok;
    }

    public final SceneImpl getScene() {
        return this.mSceneImpl;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Fo()) {
            return;
        }
        com.kwad.sdk.core.d.c.e("HomeFragment", "handleHomeParam fail");
        iE();
    }

    public final void D(List<KsContentPage.SubShowItem> list) {
        this.aoI.P(list);
    }

    public final void c(com.kwad.components.ct.api.a.a.b bVar) {
        this.aHe = bVar;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_content_alliance_home_fragment;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(View view, Bundle bundle) {
        Activity activity;
        Window window;
        super.onViewCreated(view, bundle);
        this.aoP = (HorizontalSwipeLayout) this.pQ.findViewById(R.id.ksad_swipe);
        this.aok = (SlidePlayViewPager) this.pQ.findViewById(R.id.ksad_slide_play_view_pager);
        this.aHa = (KsAdHotRefreshView) this.pQ.findViewById(R.id.ksad_refresh_layout);
        if (com.kwad.components.core.u.e.e(getActivity())) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aHa.getLayoutParams();
            marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.getStatusBarHeight(getActivity()) + this.aGL;
            this.aHa.setLayoutParams(marginLayoutParams);
        }
        this.pQ.post(new bh() { // from class: com.kwad.components.ct.home.i.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                n.b.fr(i.this.pQ.getWidth());
                n.b.fs(i.this.pQ.getHeight());
            }
        });
        if (this.alU != null && (activity = getActivity()) != null && (window = activity.getWindow()) != null) {
            this.alU.addView((ViewGroup) window.getDecorView());
        }
        this.aGP = Fq();
        Presenter presenterOnCreatePresenter = onCreatePresenter();
        this.mPresenter = presenterOnCreatePresenter;
        presenterOnCreatePresenter.ak(this.pQ);
        this.mPresenter.K(this.aGP);
        this.aGZ = new c(this);
    }

    private boolean Fo() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("key_AdScene");
        if (!(serializable instanceof SceneImpl)) {
            return false;
        }
        this.mSceneImpl = SceneImpl.covert((SceneImpl) serializable);
        this.alR = arguments.getString("KEY_PushLINK");
        this.aHc = arguments.getString("KEY_SHARE_VIDEO_INFO");
        this.aHf = arguments.getBoolean("KEY_INSERTAD_ENABLE");
        this.aGL = arguments.getInt("KEY_HOME_ACTIONBAR_HEIGHT");
        if (!a(arguments)) {
            this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 1));
            this.aHg = com.kwad.components.ct.home.config.b.FG();
            com.kwad.components.ct.api.b bVar = (com.kwad.components.ct.api.b) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.b.class);
            com.kwad.components.ct.response.model.cached.a aVarWY = bVar != null ? bVar.wY() : null;
            if (aVarWY != null) {
                this.aHb = "entry";
                com.kwad.sdk.core.scene.b.abP().a(this.aHb, aVarWY.aCR.entryId, this.mSceneImpl);
                this.aGJ = com.kwad.components.ct.home.config.b.FC();
                this.aGK = com.kwad.components.ct.home.config.b.FE();
            } else if (!bq.isNullString(this.alR)) {
                this.aHb = Config.PUSH;
                com.kwad.sdk.core.scene.b.abP().c(this.aHb, this.mSceneImpl);
                this.aGJ = com.kwad.components.ct.home.config.b.FC();
                this.aGK = com.kwad.components.ct.home.config.b.FE();
            } else if (!bq.isNullString(this.aHc)) {
                this.aHb = "message_share";
                com.kwad.sdk.core.scene.b.abP().c(this.aHb, this.mSceneImpl);
                this.aGJ = com.kwad.components.ct.home.config.b.FC();
                this.aGK = false;
            } else {
                this.aGJ = false;
                this.aGK = false;
            }
        }
        return true;
    }

    private static f Fp() {
        return new f();
    }

    private f Fq() {
        f fVarFp = Fp();
        fVarFp.aGE = this;
        fVarFp.aok = this.aok;
        fVarFp.aGF = this.aoI;
        fVarFp.mSceneImpl = this.mSceneImpl;
        fVarFp.aGJ = this.aGJ;
        fVarFp.aGK = this.aGK;
        fVarFp.aGL = this.aGL;
        fVarFp.aGR = this.aGR;
        fVarFp.aGQ = new h();
        if (!a(fVarFp)) {
            com.kwad.components.ct.home.b.c cVar = new com.kwad.components.ct.home.b.c(this.mSceneImpl);
            cVar.bT(this.alR);
            cVar.bU(this.aHc);
            cVar.bP(this.aHf);
            fVarFp.ayi = new com.kwad.components.ct.home.b.h(cVar);
            fVarFp.azS = true;
            com.kwad.components.ct.api.b bVar = (com.kwad.components.ct.api.b) com.kwad.sdk.components.d.g(com.kwad.components.ct.api.b.class);
            com.kwad.components.ct.response.model.cached.a aVarWY = bVar != null ? bVar.wY() : null;
            if (aVarWY != null) {
                fVarFp.aGI = aVarWY.aUZ;
            } else {
                fVarFp.aGI = 0;
            }
        }
        this.ayi = fVarFp.ayi;
        com.kwad.sdk.widget.swipe.c cVar2 = new com.kwad.sdk.widget.swipe.c(this.pQ.getContext());
        cVar2.dx(this.aGJ);
        this.aoP.setTouchDetector(cVar2);
        com.kwad.components.core.widget.a.b bVar2 = new com.kwad.components.core.widget.a.b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        j jVar = new j();
        jVar.aFo = this;
        jVar.aFs = this.aFs;
        jVar.alT = this.alT;
        jVar.alV = this.alV;
        jVar.aHd = this.aHd;
        jVar.avG = cVar2;
        jVar.ayi = fVarFp.ayi;
        jVar.aGJ = this.aGJ;
        jVar.aHg = this.aHg;
        jVar.aHh = this.aHh;
        jVar.mSceneImpl = this.mSceneImpl;
        jVar.aGL = this.aGL;
        jVar.aHi = this.aHi;
        jVar.aGQ = fVarFp.aGQ;
        b(jVar);
        fVarFp.aol = jVar;
        if (this.aHe != null) {
            fVarFp.ayi.a(this.aHe);
        }
        return fVarFp;
    }

    private Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        if (!b(presenter)) {
            if (Config.PUSH.equals(this.aHb)) {
                if (this.aGK && !com.kwad.components.ct.home.config.b.FO()) {
                    presenter.d(new com.kwad.components.ct.home.c.g());
                }
            } else if ("entry".equals(this.aHb)) {
                if (com.kwad.components.ct.a.a.amo.getValue().booleanValue()) {
                    presenter.d(new com.kwad.components.ct.home.c.b());
                }
                presenter.d(new com.kwad.components.ct.home.c.c());
                if (this.aGK && !com.kwad.components.ct.home.config.b.FO()) {
                    presenter.d(new com.kwad.components.ct.home.c.g());
                }
            } else if (com.kwad.components.ct.home.config.b.FL() && !Fr()) {
                presenter.d(new com.kwad.components.ct.coupon.c());
            }
            presenter.d(new com.kwad.components.ct.home.c.i());
            if (!Fr()) {
                presenter.d(new com.kwad.components.ct.home.c.h());
            }
            if (com.kwad.components.ct.a.b.T(this.mSceneImpl.posId)) {
                presenter.d(new com.kwad.components.ct.home.c.e());
            }
            if (com.kwad.components.ct.home.config.b.FO()) {
                presenter.d(new com.kwad.components.ct.home.c.l());
            }
        }
        if (com.kwad.components.core.u.d.tu()) {
            presenter.d(new com.kwad.components.ct.home.c.a());
        }
        presenter.d(new com.kwad.components.ct.home.c.k());
        if (com.kwad.components.ct.home.config.b.FF() && NetworkMonitor.getInstance().WU()) {
            presenter.d(new com.kwad.components.ct.home.c.j());
        }
        presenter.d(new com.kwad.components.ct.home.c.n());
        if (!Fr() && com.kwad.components.ct.home.config.b.FH()) {
            presenter.d(new com.kwad.components.ct.home.c.d());
        }
        presenter.d(new com.kwad.components.ct.home.c.m());
        presenter.d(new com.kwad.components.ct.home.c.f());
        return presenter;
    }

    public final boolean onPageLeaveIntercept(KsContentPage.KsPageLeaveClickListener ksPageLeaveClickListener) {
        this.aGR.a(ksPageLeaveClickListener);
        boolean zFu = this.aGR.Fu();
        com.kwad.sdk.core.d.c.i("HomeFragment", "onPageLeaveIntercept:" + zFu);
        return zFu;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.m.a.b
    public final boolean onBackPressed() {
        if (this.aHj) {
            this.aHj = false;
            return false;
        }
        boolean zOnBackPressed = super.onBackPressed();
        com.kwad.sdk.core.d.c.i("HomeFragment", "onBackPressed:" + zOnBackPressed);
        return zOnBackPressed;
    }

    public final boolean Fs() {
        boolean zOnBackPressed = super.onBackPressed();
        if (!zOnBackPressed) {
            this.aHj = true;
        }
        com.kwad.sdk.core.d.c.i("HomeFragment", "onBackPressedByKeyDown:" + zOnBackPressed);
        return zOnBackPressed;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        Activity activity;
        Window window;
        super.onDestroyView();
        com.kwad.sdk.core.d.c.i("HomeFragment", "onDestroyView");
        c cVar = this.aGZ;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.sdk.core.report.g.abi().abb();
        com.kwad.sdk.core.video.a.a.a.acK().abb();
        f fVar = this.aGP;
        if (fVar != null) {
            fVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
        this.aoP.setTouchDetector(null);
        this.aoP.aqV();
        com.kwad.components.core.e.c.b.pf();
        if (this.alU == null || (activity = getActivity()) == null || (window = activity.getWindow()) == null) {
            return;
        }
        this.alU.removeView((ViewGroup) window.getDecorView());
        this.alU = null;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        com.kwad.sdk.core.d.c.i("HomeFragment", "onDestroy");
        l lVar = this.aGR;
        if (lVar != null) {
            lVar.clear();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.IFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.kwad.sdk.core.d.c.i("HomeFragment", "setUserVisibleHint isVisibleToUser: " + z);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        com.kwad.sdk.core.d.c.i("HomeFragment", "onHiddenChanged hidden: " + z);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        com.kwad.sdk.core.d.c.i("HomeFragment", "onResume");
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        com.kwad.sdk.core.d.c.i("HomeFragment", "onPause");
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.wP();
        }
    }
}
