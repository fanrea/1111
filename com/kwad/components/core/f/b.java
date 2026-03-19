package com.kwad.components.core.f;

import android.content.Context;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.a.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements e {
    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return -200;
    }

    @Override // com.kwad.sdk.core.a.e
    public final String getResponseData(String str) {
        return d.getResponseData(str);
    }

    @Override // com.kwad.sdk.core.a.e
    public final String ax(String str) {
        return d.ax(str);
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return e.class;
    }
}
