package com.kwad.components.offline.c;

import android.content.Context;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a implements com.kwad.components.core.p.a.d.a {
    private final IObiwanOfflineCompo bbF;

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    public a(IObiwanOfflineCompo iObiwanOfflineCompo) {
        this.bbF = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.bbF.priority();
    }

    public final void updateConfigs() {
        this.bbF.updateConfigs();
    }

    public final IObiwanLogcat getLog() {
        return this.bbF.getLog();
    }
}
