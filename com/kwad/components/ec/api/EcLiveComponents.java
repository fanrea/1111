package com.kwad.components.ec.api;

import com.kwad.components.ct.request.live.a;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.components.b;
import com.kwad.sdk.mvp.Presenter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface EcLiveComponents extends b {
    KsFragment LG();

    boolean LH();

    com.kwad.sdk.core.webview.c.a LI();

    com.kwad.sdk.core.webview.c.a LJ();

    Presenter LK();

    a.C0534a LL();

    Presenter LM();

    @KsAdSdkApi
    KsContentPage loadLivePage(KsScene ksScene);
}
