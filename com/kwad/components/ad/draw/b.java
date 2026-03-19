package com.kwad.components.ad.draw;

import android.view.View;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.ca;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.core.widget.a.c {
    private View mRootView;

    public b(View view) {
        super(view, aL());
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.c, com.kwad.components.core.widget.a.a
    public final boolean ai() {
        return ca.a(this.mRootView, 70, true);
    }

    private static int aL() {
        int iYv;
        try {
            iYv = ((int) e.Yv()) * 100;
        } catch (Throwable unused) {
        }
        if (iYv < 0 || iYv > 100) {
            return 70;
        }
        return iYv;
    }
}
