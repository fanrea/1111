package com.kwad.sdk.collector.a;

import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.aa;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a extends d {
    private C0571a btx;

    public a(List<String> list) {
        C0571a c0571a = new C0571a(list);
        this.btx = c0571a;
        putBody("targetAppInfo", c0571a.toJson());
        putBody("sdkVersion", BuildConfig.VERSION_NAME);
        putBody("sdkVersionCode", BuildConfig.VERSION_CODE);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.Tw();
    }

    /* renamed from: com.kwad.sdk.collector.a.a$a, reason: collision with other inner class name */
    static class C0571a {
        private List<String> bty;

        public C0571a(List<String> list) {
            this.bty = list;
        }

        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            aa.putValue(jSONObject, "packageName", this.bty);
            return jSONObject;
        }
    }
}
