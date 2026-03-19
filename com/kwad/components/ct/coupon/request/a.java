package com.kwad.components.ct.coupon.request;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.aa;
import java.util.Iterator;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends d {
    public a(b bVar) {
        addHeader("user-agent", p.getUserAgent());
        JSONArray jSONArray = new JSONArray();
        Iterator<ImpInfo> it = bVar.anZ.iterator();
        while (it.hasNext()) {
            aa.a(jSONArray, it.next().toJson());
        }
        putBody("impInfo", jSONArray);
        if (bVar.activityInfo != null) {
            putBody("activityInfo", bVar.activityInfo);
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.Ty();
    }
}
