package com.kwad.components.ct.wallpaper;

import android.content.Context;
import com.kwad.components.ct.api.h;
import com.kwad.components.ct.api.model.wallpaper.WallpaperParam;
import com.kwad.sdk.api.KsContentWallpaperPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsWallpaperFeedPage;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.proxy.VideoWallpaperService;
import com.kwad.sdk.components.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends e implements h {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    public static void init() {
        try {
            com.kwad.sdk.service.c.g(VideoWallpaperService.class, com.kwad.components.ct.wallpaper.d.a.class);
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return h.class;
    }

    @Override // com.kwad.components.ct.api.h
    public final KsContentWallpaperPage loadContentWallpaperPage(KsScene ksScene) {
        return b.loadContentWallpaperPage(ksScene);
    }

    @Override // com.kwad.components.ct.api.h
    public final KsWallpaperFeedPage loadWallpaperFeedPage(KsScene ksScene) {
        return b.loadWallpaperFeedPage(ksScene);
    }

    @Override // com.kwad.components.ct.api.h
    public final KsFragment xb() {
        return new com.kwad.components.ct.wallpaper.b.a();
    }

    @Override // com.kwad.components.ct.api.h
    public final KsFragment a(KsScene ksScene, WallpaperParam wallpaperParam) {
        return com.kwad.components.ct.wallpaper.b.b.b(ksScene, wallpaperParam);
    }

    @Override // com.kwad.components.ct.api.h
    public final boolean b(KsFragment ksFragment) {
        return ksFragment instanceof com.kwad.components.ct.wallpaper.b.a;
    }
}
