package com.kwad.components.ct.feed.a;

import android.os.Bundle;
import com.kwad.components.ct.api.model.feed.FeedSlideParam;
import com.kwad.components.ct.home.b.c;
import com.kwad.components.ct.home.b.h;
import com.kwad.components.ct.home.c.e;
import com.kwad.components.ct.home.c.l;
import com.kwad.components.ct.home.f;
import com.kwad.components.ct.home.i;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends i {
    private FeedSlideParam aFp;

    public static b a(KsScene ksScene, FeedSlideParam feedSlideParam) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_AdScene", ksScene);
        bundle.putSerializable(FeedSlideParam.KEY_FEED_SLIDE_PARAM, feedSlideParam);
        bVar.setArguments(bundle);
        return bVar;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean a(Bundle bundle) {
        Serializable serializable = bundle.getSerializable(FeedSlideParam.KEY_FEED_SLIDE_PARAM);
        if (serializable instanceof FeedSlideParam) {
            this.aFp = (FeedSlideParam) serializable;
        }
        if (this.aFp == null) {
            return false;
        }
        this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 12));
        this.aGJ = com.kwad.components.ct.home.config.b.FC();
        this.aHg = com.kwad.components.ct.home.config.b.FG();
        this.aGK = false;
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean a(f fVar) {
        if (this.aFp == null) {
            return false;
        }
        fVar.ayi = new h(new c(this.mSceneImpl));
        fVar.azS = true;
        fVar.aGI = this.aFp.mSelectedPosition;
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean b(Presenter presenter) {
        if (12 != this.mSceneImpl.getPageScene()) {
            return false;
        }
        presenter.d(new com.kwad.components.ct.feed.a.a.a());
        presenter.d(new com.kwad.components.ct.home.c.i());
        if (com.kwad.components.ct.a.b.T(this.mSceneImpl.posId)) {
            presenter.d(new e());
        }
        if (!com.kwad.components.ct.home.config.b.FO()) {
            return true;
        }
        presenter.d(new l());
        return true;
    }
}
