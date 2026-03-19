package com.kwad.components.ct.wallpaper;

import com.kwad.components.core.u.p;
import com.kwad.sdk.api.KsContentWallpaperPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsWallpaperFeedPage;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static KsContentWallpaperPage loadContentWallpaperPage(KsScene ksScene) {
        if (ksScene == null) {
            return null;
        }
        SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        p.tH().b(sceneImplCovert, "KsContentWallpaperPage");
        return new d(sceneImplCovert);
    }

    public static KsWallpaperFeedPage loadWallpaperFeedPage(KsScene ksScene) {
        if (ksScene == null) {
            return null;
        }
        SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        p.tH().b(sceneImplCovert, "loadWallpaperFeedPage");
        return new c(sceneImplCovert);
    }
}
