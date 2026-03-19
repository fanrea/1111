package com.kwad.components.offline.a;

import android.content.Context;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a implements com.kwad.components.core.p.a.b.a {
    private final IAdLiveOfflineCompo bbb;

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    public a(IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        this.bbb = iAdLiveOfflineCompo;
    }

    @Override // com.kwad.components.core.p.a.b.a
    public final boolean qI() {
        return this.bbb.getState() == IAdLiveOfflineCompo.AdLiveState.READY;
    }

    @Override // com.kwad.components.core.p.a.b.a
    public final IAdLiveOfflineView getView(Context context, int i) {
        return this.bbb.getView(context, i);
    }

    @Override // com.kwad.components.core.p.a.b.a
    public final IAdLiveEndRequest getAdLiveEndRequest(String str) {
        return this.bbb.getAdLiveEndRequest(str);
    }

    @Override // com.kwad.components.core.p.a.b.a
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j) {
        return this.bbb.getAdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j);
    }

    @Override // com.kwad.sdk.components.b
    public final Class<a> getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.bbb.priority();
    }
}
