package com.kwad.components.ct.api;

import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsTubePage;
import com.kwad.sdk.api.tube.KSTubeDetailParam;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface g extends com.kwad.sdk.components.b {
    KsTubePage a(KsScene ksScene, KSTubeParamInner kSTubeParamInner);

    void a(com.kwad.components.ct.api.tube.a aVar);

    void a(KsContentPage.ContentItem contentItem, CtPhotoInfo ctPhotoInfo);

    void a(Presenter presenter);

    void b(com.kwad.components.ct.api.tube.a aVar);

    KsContentPage loadTubeContentPage(KSTubeDetailParam kSTubeDetailParam);
}
