package com.kwad.components.ct.feed;

import android.content.Context;
import com.kwad.sdk.api.KsFeedPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e implements com.kwad.components.ct.api.c {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ct.api.c.class;
    }

    @Override // com.kwad.components.ct.api.c
    public final KsFeedPage loadFeedPage(KsScene ksScene) {
        return c.loadFeedPage(ksScene);
    }
}
