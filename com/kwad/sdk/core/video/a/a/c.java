package com.kwad.sdk.core.video.a.a;

import com.baidu.mobads.container.adrequest.g;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.utils.aa;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c extends e implements com.kwad.sdk.core.b {
    private long OY;
    private String bIG;
    private String bIH;
    private String sessionId;
    private long timestamp;

    public c(String str, String str2) {
        this.actionId = UUID.randomUUID().toString();
        this.timestamp = System.currentTimeMillis();
        this.sessionId = t.abs();
        this.OY = t.abu();
        this.bIG = str;
        this.bIH = str2;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.timestamp = jSONObject.optLong(com.alipay.sdk.m.t.a.k);
            if (jSONObject.has("actionId")) {
                this.actionId = jSONObject.optString("actionId");
            }
            if (jSONObject.has("sessionId")) {
                this.sessionId = jSONObject.optString("sessionId");
            }
            this.OY = jSONObject.optLong(g.ag);
            if (jSONObject.has("mediaPlayerAction")) {
                this.bIG = jSONObject.optString("mediaPlayerAction");
            }
            if (jSONObject.has("mediaPlayerMsg")) {
                this.bIH = jSONObject.optString("mediaPlayerMsg");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "actionId", this.actionId);
        aa.putValue(jSONObject, com.alipay.sdk.m.t.a.k, this.timestamp);
        aa.putValue(jSONObject, "sessionId", this.sessionId);
        aa.putValue(jSONObject, g.ag, this.OY);
        aa.putValue(jSONObject, "mediaPlayerAction", this.bIG);
        aa.putValue(jSONObject, "mediaPlayerMsg", this.bIH);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public final String toString() {
        return "MediaPlayerReportAction{actionId='" + this.actionId + "', timestamp=" + this.timestamp + ", sessionId='" + this.sessionId + "', seq=" + this.OY + ", mediaPlayerAction='" + this.bIG + "', mediaPlayerMsg='" + this.bIH + "'}";
    }
}
