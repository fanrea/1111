package com.kwad.components.core.p.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.sdk.components.d;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements ILive {
    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i) {
        com.kwad.components.core.p.a.b.a aVar = (com.kwad.components.core.p.a.b.a) d.g(com.kwad.components.core.p.a.b.a.class);
        if (aVar != null && aVar.qI()) {
            try {
                return aVar.getView(context, i);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return null;
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j) {
        com.kwad.components.core.p.a.b.a aVar = (com.kwad.components.core.p.a.b.a) d.g(com.kwad.components.core.p.a.b.a.class);
        if (aVar == null || !aVar.qI()) {
            return null;
        }
        return aVar.getAdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j);
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveEndRequest mIAdLiveEndRequest(String str) {
        com.kwad.components.core.p.a.b.a aVar;
        if (TextUtils.isEmpty(str) || (aVar = (com.kwad.components.core.p.a.b.a) d.g(com.kwad.components.core.p.a.b.a.class)) == null || !aVar.qI()) {
            return null;
        }
        return aVar.getAdLiveEndRequest(str);
    }
}
