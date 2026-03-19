package com.kwad.components.ad.c;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f extends com.kwad.components.core.widget.a.c {
    public f(View view, int i) {
        super(view, i);
    }

    @Override // com.kwad.components.core.widget.a.c, com.kwad.components.core.widget.a.a
    public final boolean ai() {
        com.kwad.sdk.core.c.b.aaf();
        if (com.kwad.sdk.core.c.b.isEnable()) {
            com.kwad.sdk.core.c.b.aaf();
            return com.kwad.sdk.core.c.b.isAppOnForeground() && super.ai();
        }
        return super.ai();
    }
}
