package com.kwad.components.ct.wallpaper.b;

import android.os.Bundle;
import com.kwad.components.ct.api.model.wallpaper.WallpaperParam;
import com.kwad.components.ct.home.b.c;
import com.kwad.components.ct.home.b.h;
import com.kwad.components.ct.home.c.e;
import com.kwad.components.ct.home.f;
import com.kwad.components.ct.home.i;
import com.kwad.components.ct.home.j;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends i {
    private WallpaperParam aHr;

    public static b b(KsScene ksScene, WallpaperParam wallpaperParam) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_AdScene", ksScene);
        bundle.putSerializable("KEY_WALL_PAPER_PARAM", wallpaperParam);
        bVar.setArguments(bundle);
        return bVar;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean a(Bundle bundle) {
        Serializable serializable = bundle.getSerializable("KEY_WALL_PAPER_PARAM");
        if (serializable instanceof WallpaperParam) {
            this.aHr = (WallpaperParam) serializable;
        }
        if (this.aHr == null) {
            return false;
        }
        this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 16));
        this.aGJ = false;
        this.aHg = false;
        this.aGK = false;
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean Fr() {
        WallpaperParam wallpaperParam = this.aHr;
        return (wallpaperParam == null || wallpaperParam.mWallpaperSourceType == -1) ? false : true;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean a(f fVar) {
        if (this.aHr == null) {
            return false;
        }
        fVar.ayi = new h(new c(this.mSceneImpl));
        fVar.azS = true;
        fVar.aGI = this.aHr.mSelectedPosition;
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final void b(j jVar) {
        jVar.aHr = this.aHr;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean b(Presenter presenter) {
        if (16 != this.mSceneImpl.getPageScene()) {
            return false;
        }
        presenter.d(new com.kwad.components.ct.feed.a.a.a());
        presenter.d(new com.kwad.components.ct.home.c.i());
        if (!com.kwad.components.ct.a.b.T(this.mSceneImpl.posId)) {
            return true;
        }
        presenter.d(new e());
        return true;
    }
}
