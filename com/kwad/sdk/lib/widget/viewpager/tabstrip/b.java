package com.kwad.sdk.lib.widget.viewpager.tabstrip;

import android.os.Bundle;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b<T extends KsFragment> {
    private Class<T> cdT;
    private Bundle cdU;
    private PagerSlidingTabStrip.c cdV;

    public b() {
    }

    public b(PagerSlidingTabStrip.c cVar, Class<T> cls, Bundle bundle) {
        this.cdV = cVar;
        this.cdT = cls;
        this.cdU = bundle;
    }

    public final PagerSlidingTabStrip.c alh() {
        return this.cdV;
    }

    public final Class<T> ali() {
        return this.cdT;
    }

    public final Bundle alj() {
        return this.cdU;
    }
}
