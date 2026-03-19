package com.kwad.tachikoma.l;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private IOfflineCompoCallBackFunction CP;

    public a(IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.CP = iOfflineCompoCallBackFunction;
    }

    public final void onError(int i, String str) {
        String string = new d(-1, str).toJson().toString();
        IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction = this.CP;
        if (iOfflineCompoCallBackFunction != null) {
            iOfflineCompoCallBackFunction.onError(string);
        }
    }
}
