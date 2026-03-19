package com.kwad.components.ct.profile.home.b;

import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ct.profile.home.ProfileHomeParam;
import com.kwad.components.ct.profile.home.c;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.sdk.mvp.a {
    public com.kwad.components.core.widget.a.b aFs;
    public ProfileHomeParam aRb;
    public c aRh;
    public ViewPager aRi;
    public Set<com.kwad.components.ct.profile.home.a.a> aRj = new LinkedHashSet();
    public Set<com.kwad.components.ct.profile.home.a.b> aRk = new LinkedHashSet();
    public SceneImpl mSceneImpl;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.aRj.clear();
        com.kwad.components.core.widget.a.b bVar = this.aFs;
        if (bVar != null) {
            bVar.release();
        }
    }
}
