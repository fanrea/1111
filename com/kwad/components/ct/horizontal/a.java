package com.kwad.components.ct.horizontal;

import android.content.Context;
import com.kwad.sdk.api.KsHorizontalFeedPage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e implements com.kwad.components.ct.api.e {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ct.api.e.class;
    }

    @Override // com.kwad.components.ct.api.e
    public final KsHorizontalFeedPage loadHorizontalFeedPage(KsScene ksScene) {
        return b.loadHorizontalFeedPage(ksScene);
    }

    @Override // com.kwad.components.ct.api.e
    public final KsHorizontalFeedPage loadHorizontalNewsFeedPage(KsScene ksScene) {
        return b.loadHorizontalNewsFeedPage(ksScene);
    }

    @Override // com.kwad.components.ct.api.e
    public final KsHorizontalFeedPage loadHorizontalPlayFeedPage(KsScene ksScene) {
        return b.loadHorizontalPlayFeedPage(ksScene);
    }

    @Override // com.kwad.components.ct.api.e
    public final void loadHorizontalVideoData(KsScene ksScene, KsLoadManager.KsHorizontalVideoDataListener ksHorizontalVideoDataListener) {
        b.loadHorizontalVideoData(ksScene, ksHorizontalVideoDataListener);
    }
}
