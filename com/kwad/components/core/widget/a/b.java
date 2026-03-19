package com.kwad.components.core.widget.a;

import android.view.View;
import com.kwad.sdk.api.core.fragment.KsFragment;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends a {
    private final AtomicBoolean alB;
    private KsFragment alG;
    private String alH;

    public b(KsFragment ksFragment, View view, int i) {
        super(view, 70);
        this.alB = new AtomicBoolean(false);
        this.alG = ksFragment;
    }

    @Override // com.kwad.components.core.widget.a.a
    public final boolean ai() {
        KsFragment ksFragment = this.alG;
        if (ksFragment == null) {
            return false;
        }
        if (a(ksFragment)) {
            this.alH = "message fragment";
            return false;
        }
        this.alH = "message view";
        return wM();
    }

    private static boolean a(KsFragment ksFragment) {
        return (ksFragment.isResumed() && !ksFragment.isAllFragmentIsHidden() && ksFragment.isVisible()) ? false : true;
    }

    public final void wP() {
        com.kwad.sdk.core.d.c.i("FragmentPageVisibleHelper", "onFragmentPause");
        this.alH = "onFragmentPause";
        wN();
    }

    @Override // com.kwad.components.core.widget.a.a, com.kwad.sdk.core.j.a
    public final void release() {
        super.release();
        this.alG = null;
    }
}
