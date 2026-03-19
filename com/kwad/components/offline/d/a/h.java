package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.s;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class h implements IOfflineTKRenderListener {
    private final s bcp;

    public h(s sVar) {
        this.bcp = sVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onSuccess() {
        s sVar = this.bcp;
        if (sVar != null) {
            sVar.onSuccess();
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th) {
        s sVar = this.bcp;
        if (sVar != null) {
            sVar.onFailed(th);
        }
    }
}
