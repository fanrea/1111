package com.kwad.components.ct.profile.home;

import android.os.Bundle;
import android.view.View;
import com.kwad.components.ct.profile.home.c.e;
import com.kwad.components.ct.profile.home.c.f;
import com.kwad.components.ct.profile.home.c.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.lib.a.a;
import com.kwad.sdk.lib.a.d;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends d implements a.InterfaceC0618a {
    private com.kwad.components.core.widget.a.b aFs;
    private ProfileHomeParam aRb;
    private com.kwad.components.ct.profile.home.b.b aRf;
    private com.kwad.sdk.lib.a.a aRg;
    private SceneImpl mSceneImpl;

    public static c a(ProfileHomeParam profileHomeParam) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("KEY_PROFILE_HOME_PARAM", profileHomeParam);
        c cVar = new c();
        cVar.setArguments(bundle);
        return cVar;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_profile_fragment_home;
    }

    @Override // com.kwad.sdk.lib.a.d
    public final int IJ() {
        return R.id.ksad_tab_strip;
    }

    @Override // com.kwad.sdk.lib.a.d
    public final int IK() {
        return R.id.ksad_profile_view_pager;
    }

    @Override // com.kwad.sdk.lib.a.d
    public final List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> IL() {
        return new ArrayList();
    }

    @Override // com.kwad.sdk.lib.a.d, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(View view, Bundle bundle) {
        if (!ES() && getActivity() != null) {
            getActivity().finish();
            return;
        }
        super.onViewCreated(view, bundle);
        this.aRf = Jh();
        if (this.aRg == null) {
            this.aRg = new com.kwad.sdk.lib.a.a(this, this);
        }
        this.aRg.J(this.aRf);
    }

    private boolean ES() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        Serializable serializable = arguments.getSerializable("KEY_PROFILE_HOME_PARAM");
        if (!(serializable instanceof ProfileHomeParam)) {
            return false;
        }
        ProfileHomeParam profileHomeParam = (ProfileHomeParam) serializable;
        this.aRb = profileHomeParam;
        this.mSceneImpl = profileHomeParam.mAdTemplate.mAdScene;
        URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 3);
        uRLPackage.putParams(URLPackage.KEY_AUTHOR_ID, com.kwad.components.ct.response.a.a.bb(this.aRb.mAdTemplate));
        this.mSceneImpl.setUrlPackage(uRLPackage);
        return true;
    }

    @Override // com.kwad.sdk.lib.a.a.InterfaceC0618a
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.d(new e());
        presenter.d(new com.kwad.components.ct.profile.home.c.d());
        presenter.d(new g());
        presenter.d(new com.kwad.components.ct.profile.home.c.c());
        presenter.d(new f());
        presenter.d(new com.kwad.components.ct.profile.home.c.a());
        presenter.d(new com.kwad.components.ct.profile.home.c.b());
        return presenter;
    }

    private com.kwad.components.ct.profile.home.b.b Jh() {
        com.kwad.components.ct.profile.home.b.b bVar = new com.kwad.components.ct.profile.home.b.b();
        bVar.aRh = this;
        bVar.mSceneImpl = this.mSceneImpl;
        bVar.aRi = this.aRi;
        com.kwad.components.core.widget.a.b bVar2 = new com.kwad.components.core.widget.a.b(this, this.pQ, 70);
        this.aFs = bVar2;
        bVar2.wK();
        bVar.aFs = this.aFs;
        bVar.aRb = this.aRb;
        return bVar;
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
        com.kwad.components.ct.profile.home.b.b bVar = this.aRf;
        if (bVar != null) {
            bVar.release();
        }
    }
}
