package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bq;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class p {
    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String strCa = com.kwad.sdk.core.response.b.a.ca(adInfo);
        com.kwad.sdk.core.d.c.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + strCa);
        if (bq.isNullString(strCa)) {
            return;
        }
        com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.components.ad.reward.p.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.core.network.c cVarDoGet = com.kwad.sdk.g.ST().doGet(strCa, null);
                    if (cVarDoGet == null) {
                        M("Network Error: url invalid");
                        return;
                    }
                    if (cVarDoGet.code == 200) {
                        a aVar = new a(cVarDoGet.bCs);
                        if (aVar.isValid()) {
                            hC();
                            return;
                        } else {
                            M(aVar.errorMsg);
                            return;
                        }
                    }
                    M("Network Error: " + cVarDoGet.bCs);
                } catch (Throwable th) {
                    M("Request Error: " + th.getMessage());
                }
            }

            private void hC() {
                com.kwad.components.core.q.a.ss().g(adTemplate, 0, "success");
            }

            private void M(String str) {
                com.kwad.components.core.q.a.ss().g(adTemplate, 1, str);
            }
        });
    }

    static class a {
        private String errorMsg;
        private boolean vf;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.vf = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        public final boolean isValid() {
            return this.vf;
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.vf = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }
    }
}
