package com.kwad.components.ct.tube;

import android.content.Context;
import com.kwad.components.ct.api.g;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.api.tube.TubeEpisodeHomeParam;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsTubePage;
import com.kwad.sdk.api.tube.KSTubeDetailParam;
import com.kwad.sdk.components.e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e implements g {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class<g> getComponentsType() {
        return g.class;
    }

    @Override // com.kwad.components.ct.api.g
    public final KsTubePage a(KsScene ksScene, KSTubeParamInner kSTubeParamInner) {
        return new c(SceneImpl.covert(ksScene), kSTubeParamInner);
    }

    @Override // com.kwad.components.ct.api.g
    public final KsContentPage loadTubeContentPage(KSTubeDetailParam kSTubeDetailParam) {
        TubeEpisodeHomeParam tubeEpisodeHomeParamA = com.kwad.components.ct.tube.d.b.a(kSTubeDetailParam);
        if (tubeEpisodeHomeParamA != null) {
            return new b(tubeEpisodeHomeParamA, null);
        }
        return null;
    }

    @Override // com.kwad.components.ct.api.g
    public final void a(com.kwad.components.ct.api.tube.a aVar) {
        com.kwad.components.ct.tube.panel.a.a.KH().a(aVar);
    }

    @Override // com.kwad.components.ct.api.g
    public final void b(com.kwad.components.ct.api.tube.a aVar) {
        com.kwad.components.ct.tube.panel.a.a.KH().b(aVar);
    }

    @Override // com.kwad.components.ct.api.g
    public final void a(KsContentPage.ContentItem contentItem, CtPhotoInfo ctPhotoInfo) {
        try {
            contentItem.tubeData = com.kwad.components.ct.tube.d.b.L(ctPhotoInfo);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ct.api.g
    public final void a(Presenter presenter) {
        presenter.d(new com.kwad.components.ct.tube.slide.detail.a.a());
        presenter.d(new com.kwad.components.ct.tube.slide.detail.a.c());
        presenter.d(new com.kwad.components.ct.tube.slide.detail.a.b());
    }
}
