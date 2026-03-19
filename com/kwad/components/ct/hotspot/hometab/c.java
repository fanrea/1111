package com.kwad.components.ct.hotspot.hometab;

import android.os.Bundle;
import com.kwad.components.ct.api.model.hotspot.HotspotListParam;
import com.kwad.components.ct.home.b.h;
import com.kwad.components.ct.home.f;
import com.kwad.components.ct.home.i;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.mvp.Presenter;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c extends i {
    private HotspotListParam mHotspotListParam;

    @Override // com.kwad.components.ct.home.i
    public final boolean a(Bundle bundle) {
        Serializable serializable = bundle.getSerializable("KEY_HOTSPOT_LIST");
        if (serializable instanceof HotspotListParam) {
            this.mHotspotListParam = (HotspotListParam) serializable;
        }
        if (!HotspotListParam.isValid(this.mHotspotListParam)) {
            return false;
        }
        this.mSceneImpl.setUrlPackage(new URLPackage(String.valueOf(hashCode()), 14));
        this.aGJ = false;
        this.aHg = false;
        this.aGK = false;
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean a(f fVar) {
        if (!HotspotListParam.isValid(this.mHotspotListParam)) {
            return false;
        }
        fVar.ayi = new h(new com.kwad.components.ct.hotspot.b(this.mSceneImpl, this.mHotspotListParam.mHotspotListData.trends, this.mHotspotListParam.mEntryHotspotInfo));
        fVar.azS = false;
        fVar.aGI = 0;
        fVar.aGG = this.mHotspotListParam.mHotspotListData.trends;
        fVar.mEntryHotspotInfo = this.mHotspotListParam.mEntryHotspotInfo;
        fVar.aAc = true;
        return true;
    }

    @Override // com.kwad.components.ct.home.i
    public final boolean b(Presenter presenter) {
        if (14 != this.mSceneImpl.getPageScene()) {
            return false;
        }
        presenter.d(new com.kwad.components.ct.hotspot.a.c());
        presenter.d(new com.kwad.components.ct.hotspot.a.a());
        presenter.d(new com.kwad.components.ct.hotspot.a.b());
        presenter.d(new com.kwad.components.ct.home.c.i());
        return true;
    }
}
