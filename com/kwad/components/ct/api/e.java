package com.kwad.components.ct.api;

import com.kwad.sdk.api.KsHorizontalFeedPage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface e extends com.kwad.sdk.components.b {
    KsHorizontalFeedPage loadHorizontalFeedPage(KsScene ksScene);

    KsHorizontalFeedPage loadHorizontalNewsFeedPage(KsScene ksScene);

    KsHorizontalFeedPage loadHorizontalPlayFeedPage(KsScene ksScene);

    void loadHorizontalVideoData(KsScene ksScene, KsLoadManager.KsHorizontalVideoDataListener ksHorizontalVideoDataListener);
}
