package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.q;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g implements IOfflineTKCallHandler {
    private final q bco;

    public g(q qVar) {
        this.bco = qVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        q qVar = this.bco;
        if (qVar != null) {
            qVar.callJS(str);
        }
    }
}
