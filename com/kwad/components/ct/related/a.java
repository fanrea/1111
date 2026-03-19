package com.kwad.components.ct.related;

import android.os.Bundle;
import com.kwad.components.ct.home.b.h;
import com.kwad.components.ct.home.f;
import com.kwad.components.ct.home.i;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends i {
    private RelatedVideoDetailParam aTr;

    public static a a(KsScene ksScene, RelatedVideoDetailParam relatedVideoDetailParam) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_AdScene", ksScene);
        bundle.putSerializable("KEY_RELATED_VIDEO_DETAIL_PARAM", relatedVideoDetailParam);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean a(Bundle bundle) {
        Serializable serializable = bundle.getSerializable("KEY_RELATED_VIDEO_DETAIL_PARAM");
        if (serializable instanceof RelatedVideoDetailParam) {
            this.aTr = (RelatedVideoDetailParam) serializable;
        }
        if (this.aTr == null) {
            return false;
        }
        this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 10));
        this.aGJ = false;
        this.aHg = false;
        this.aGK = false;
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean a(f fVar) {
        if (this.aTr == null) {
            return false;
        }
        fVar.ayi = new h(new com.kwad.components.ct.home.b.f(this.mSceneImpl, this.aTr));
        fVar.azS = false;
        fVar.aGI = this.aTr.mSelectedPosition;
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean b(Presenter presenter) {
        if (10 != this.mSceneImpl.getPageScene()) {
            return false;
        }
        presenter.d(new com.kwad.components.ct.related.a.a());
        presenter.d(new com.kwad.components.ct.home.c.i());
        return true;
    }
}
