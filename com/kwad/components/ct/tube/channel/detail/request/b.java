package com.kwad.components.ct.tube.channel.detail.request;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.aa;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends d {
    public b(a aVar) {
        JSONArray jSONArray = new JSONArray();
        if (aVar.Tk != null) {
            aa.a(jSONArray, aVar.Tk.toJson());
        }
        JSONArray jSONArray2 = new JSONArray();
        if (aVar.aWn != null) {
            Iterator<Long> it = aVar.aWn.iterator();
            while (it.hasNext()) {
                jSONArray2.put(it.next().longValue());
            }
        }
        putBody("impressedTube", jSONArray2);
        putBody("impInfo", jSONArray);
        putBody("channelId", aVar.channelId);
        putBody("contentInfo", new com.kwad.components.ct.request.a.a());
        putBody("count", 15);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.To();
    }

    public static class a {
        public ImpInfo Tk;
        public List<Long> aWn;
        public int channelId;

        public a(ImpInfo impInfo, int i, List<Long> list) {
            this.channelId = i;
            this.Tk = impInfo;
            this.aWn = list;
        }
    }
}
