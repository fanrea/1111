package com.kwad.components.ct.wallpaper;

import android.os.Bundle;
import com.kwad.components.ct.api.model.wallpaper.WallpaperParam;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.core.AbstractKsContentWallpaperPage;
import com.kwad.sdk.api.core.fragment.KsFragment;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends AbstractKsContentWallpaperPage {
    private KsScene aZF;
    private WeakReference<com.kwad.components.ct.wallpaper.b.b> alL;

    public d(KsScene ksScene) {
        this.aZF = ksScene;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsContentWallpaperPage
    public final KsFragment getFragment2() {
        WallpaperParam wallpaperParam = new WallpaperParam();
        wallpaperParam.mWallpaperSourceType = 1;
        com.kwad.components.ct.wallpaper.b.b bVarB = com.kwad.components.ct.wallpaper.b.b.b(this.aZF, wallpaperParam);
        this.alL = new WeakReference<>(bVarB);
        if (bVarB.getArguments() == null) {
            bVarB.setArguments(new Bundle());
        }
        return bVarB;
    }

    @Override // com.kwad.sdk.api.KsContentWallpaperPage
    public final boolean onBackPressed() {
        com.kwad.components.ct.wallpaper.b.b bVar;
        WeakReference<com.kwad.components.ct.wallpaper.b.b> weakReference = this.alL;
        return (weakReference == null || (bVar = weakReference.get()) == null || !bVar.onBackPressed()) ? false : true;
    }

    @Override // com.kwad.sdk.api.KsContentWallpaperPage
    public final void tryToRefresh() {
        com.kwad.components.ct.wallpaper.b.b bVar;
        WeakReference<com.kwad.components.ct.wallpaper.b.b> weakReference = this.alL;
        if (weakReference == null || (bVar = weakReference.get()) == null) {
            return;
        }
        bVar.tryToRefresh();
    }
}
