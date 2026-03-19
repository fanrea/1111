package com.kwad.components.core.widget.a;

import android.view.View;
import com.kwad.sdk.utils.ca;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c extends a {
    private View mRootView;

    public c(View view, int i) {
        super(view, i);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public boolean ai() {
        return ca.a(this.mRootView, 70, true);
    }
}
