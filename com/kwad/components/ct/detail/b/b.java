package com.kwad.components.ct.detail.b;

import android.view.View;
import com.kwad.components.ct.profile.home.ProfileHomeParam;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.widget.swipe.HorizontalSwipeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b {
    private View aoO;
    private HorizontalSwipeLayout aoP;
    private com.kwad.components.core.k.a aoQ = new com.kwad.components.core.k.b() { // from class: com.kwad.components.ct.detail.b.b.1
        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qy() {
            b.this.aoP.a(b.this.aoR);
        }

        @Override // com.kwad.components.core.k.b, com.kwad.components.core.k.a
        public final void qz() {
            if (b.this.aoP.b(b.this.aoR)) {
                b.this.aoP.c(b.this.aoR);
            }
        }
    };
    private HorizontalSwipeLayout.a aoR = new HorizontalSwipeLayout.a() { // from class: com.kwad.components.ct.detail.b.b.2
        @Override // com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.a
        public final void yo() {
        }

        @Override // com.kwad.sdk.widget.swipe.HorizontalSwipeLayout.a
        public final void yp() {
            b.this.AF();
        }
    };
    private CtAdTemplate mAdTemplate;

    private void c(KsFragment ksFragment) {
        if (this.aoO != null) {
            return;
        }
        View view = ksFragment.getParentFragment().getView();
        this.aoO = view;
        this.aoP = (HorizontalSwipeLayout) view.findViewById(R.id.ksad_swipe);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        c(this.aop.aoy);
        this.mAdTemplate = this.aop.mAdTemplate;
        this.aop.aoq.add(this.aoQ);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        this.aop.aoq.remove(this.aoQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AF() {
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(this.mAdTemplate);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl != null) {
            BV();
            ProfileHomeParam profileHomeParam = new ProfileHomeParam();
            profileHomeParam.mEntryScene = sceneImpl.entryScene;
            profileHomeParam.mCurrentPhotoId = com.kwad.components.ct.response.a.c.j((PhotoInfo) ctPhotoInfoAy);
            profileHomeParam.mAdTemplate = this.mAdTemplate;
            com.kwad.components.ct.profile.home.a.a(getContext(), profileHomeParam);
            this.mAdTemplate.mIsNotNeedAvatarGuider = true;
        }
    }

    private void BV() {
        com.kwad.components.ct.e.b.JK().Y(this.mAdTemplate);
    }
}
