package com.kwad.components.offline.b;

import android.content.Context;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a implements com.kwad.components.core.p.a.a.a {
    private final IAdWaynePlayerOfflineCompo bbn;

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    public a(IAdWaynePlayerOfflineCompo iAdWaynePlayerOfflineCompo) {
        this.bbn = iAdWaynePlayerOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final Class<a> getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.bbn.priority();
    }

    @Override // com.kwad.components.core.p.a.a.a
    public final boolean qH() {
        return this.bbn.getState() == IAdWaynePlayerOfflineCompo.AdWaynePlayerState.READY;
    }
}
