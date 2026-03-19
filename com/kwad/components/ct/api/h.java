package com.kwad.components.ct.api;

import com.kwad.components.ct.api.model.wallpaper.WallpaperParam;
import com.kwad.sdk.api.KsContentWallpaperPage;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsWallpaperFeedPage;
import com.kwad.sdk.api.core.fragment.KsFragment;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface h extends com.kwad.sdk.components.b {
    KsFragment a(KsScene ksScene, WallpaperParam wallpaperParam);

    boolean b(KsFragment ksFragment);

    KsContentWallpaperPage loadContentWallpaperPage(KsScene ksScene);

    KsWallpaperFeedPage loadWallpaperFeedPage(KsScene ksScene);

    KsFragment xb();
}
