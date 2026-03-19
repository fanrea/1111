package com.kwad.sdk.core.b.a;

import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class og implements com.kwad.sdk.core.d<WebViewLoadMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebViewLoadMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebViewLoadMsg) bVar, jSONObject);
    }

    private static void a(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webViewLoadMsg.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.url)) {
            webViewLoadMsg.url = "";
        }
        webViewLoadMsg.state = jSONObject.optInt("state");
        webViewLoadMsg.interval = jSONObject.optString(MetricsSQLiteCacheKt.METRICS_INTERVAL);
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.interval)) {
            webViewLoadMsg.interval = "";
        }
        webViewLoadMsg.failReason = jSONObject.optString("fail_reason");
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.failReason)) {
            webViewLoadMsg.failReason = "";
        }
        webViewLoadMsg.costTime = jSONObject.optString("cost_time");
        if (JSONObject.NULL.toString().equals(webViewLoadMsg.costTime)) {
            webViewLoadMsg.costTime = "";
        }
    }

    private static JSONObject b(WebViewLoadMsg webViewLoadMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (webViewLoadMsg.url != null && !webViewLoadMsg.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", webViewLoadMsg.url);
        }
        if (webViewLoadMsg.state != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "state", webViewLoadMsg.state);
        }
        if (webViewLoadMsg.interval != null && !webViewLoadMsg.interval.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, MetricsSQLiteCacheKt.METRICS_INTERVAL, webViewLoadMsg.interval);
        }
        if (webViewLoadMsg.failReason != null && !webViewLoadMsg.failReason.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "fail_reason", webViewLoadMsg.failReason);
        }
        if (webViewLoadMsg.costTime != null && !webViewLoadMsg.costTime.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "cost_time", webViewLoadMsg.costTime);
        }
        return jSONObject;
    }
}
