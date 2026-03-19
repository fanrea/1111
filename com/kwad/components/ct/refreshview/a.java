package com.kwad.components.ct.refreshview;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements b {
    private final float aKC;

    public a(Context context) {
        this.aKC = com.kwad.sdk.c.a.a.getScreenHeight(context);
    }

    @Override // com.kwad.components.ct.refreshview.b
    public final float w(float f) {
        float f2 = this.aKC;
        return f2 - (((f2 * f2) * 2.0f) / (f + (2.0f * f2)));
    }
}
