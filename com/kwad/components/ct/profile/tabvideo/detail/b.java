package com.kwad.components.ct.profile.tabvideo.detail;

import android.os.Bundle;
import com.kwad.components.ct.home.b.e;
import com.kwad.components.ct.home.b.h;
import com.kwad.components.ct.home.f;
import com.kwad.components.ct.home.i;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends i {
    private ProfileVideoDetailParam aJl;

    public static b a(KsScene ksScene, ProfileVideoDetailParam profileVideoDetailParam) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_AdScene", ksScene);
        bundle.putSerializable("KEY_PROFILE_VIDEO_DETAIL_PARAM", profileVideoDetailParam);
        bVar.setArguments(bundle);
        return bVar;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean a(Bundle bundle) {
        Serializable serializable = bundle.getSerializable("KEY_PROFILE_VIDEO_DETAIL_PARAM");
        if (serializable instanceof ProfileVideoDetailParam) {
            this.aJl = (ProfileVideoDetailParam) serializable;
        }
        if (this.aJl == null) {
            return false;
        }
        URLPackage uRLPackage = new URLPackage(String.valueOf(hashCode()), 4);
        uRLPackage.putParams(URLPackage.KEY_AUTHOR_ID, this.aJl.mAuthorId);
        this.mSceneImpl.setUrlPackage(uRLPackage);
        this.aGJ = false;
        this.aHg = false;
        this.aGK = false;
        this.aHh = false;
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean a(f fVar) {
        if (this.aJl == null) {
            return false;
        }
        fVar.ayi = new h(new e(this.mSceneImpl, this.aJl));
        fVar.azS = false;
        fVar.aGI = this.aJl.mSelectedPosition;
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean b(Presenter presenter) {
        if (4 != this.mSceneImpl.getPageScene()) {
            return false;
        }
        presenter.d(new com.kwad.components.ct.profile.tabvideo.detail.a.a());
        presenter.d(new com.kwad.components.ct.home.c.i());
        return true;
    }
}
