package com.kwad.components.ct.profile.tabvideo;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends com.kwad.sdk.lib.a.c<CtAdResultData, CtAdTemplate> {
    private ProfileTabVideoParam aRO;
    private SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.LayoutManager h(Object obj) {
        return Hu();
    }

    @Override // com.kwad.sdk.lib.a.b
    public final /* synthetic */ RecyclerView.ItemDecoration i(Object obj) {
        return Ht();
    }

    @Override // com.kwad.sdk.lib.a.c, com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(Bundle bundle) {
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
        Serializable serializable = arguments.getSerializable("KEY_PROFILE_TAB_VIDEO_PARAM");
        if (serializable instanceof ProfileTabVideoParam) {
            ProfileTabVideoParam profileTabVideoParam = (ProfileTabVideoParam) serializable;
            this.aRO = profileTabVideoParam;
            if (profileTabVideoParam.isValid()) {
                SceneImpl sceneImpl = new SceneImpl(this.aRO.mEntryScene);
                this.mSceneImpl = sceneImpl;
                sceneImpl.setUrlPackage(this.aRO.mURLPackage);
                return true;
            }
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rb() {
        return R.layout.ksad_profile_fragment_tab_video;
    }

    @Override // com.kwad.sdk.lib.a.c
    public final int rN() {
        return R.id.ksad_recycler_view;
    }

    private RecyclerView.ItemDecoration Ht() {
        return new com.kwad.sdk.lib.widget.a.b(3, com.kwad.sdk.c.a.a.a(this.mContext, 2.0f), com.kwad.sdk.c.a.a.a(this.mContext, 2.0f));
    }

    private static RecyclerView.LayoutManager Hu() {
        return new StaggeredGridLayoutManager(3, 1);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final void c(Presenter presenter) {
        presenter.d(new com.kwad.components.ct.profile.tabvideo.b.a());
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.b.c<CtAdResultData, CtAdTemplate> EW() {
        return new c(this.mSceneImpl, this.aRO);
    }

    @Override // com.kwad.sdk.lib.a.c
    public final com.kwad.sdk.lib.widget.a.c<CtAdTemplate, ?> EX() {
        return new a(this, this.Wj, this.aRO);
    }
}
