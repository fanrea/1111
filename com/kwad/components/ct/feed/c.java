package com.kwad.components.ct.feed;

import com.kwad.components.core.u.p;
import com.kwad.components.ct.feed.home.d;
import com.kwad.sdk.api.KsFeedPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    public static KsFeedPage loadFeedPage(KsScene ksScene) {
        SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        p.tH().b(sceneImplCovert, "loadFeedPage");
        if (ksScene == null) {
            return null;
        }
        return new d(sceneImplCovert);
    }
}
