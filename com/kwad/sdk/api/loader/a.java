package com.kwad.sdk.api.loader;

import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    static class C0569a {
        int brQ;
        String brR;
        transient File brS;
        long interval;
        String md5;
        String sdkVersion;

        C0569a() {
        }

        public final String toString() {
            return "Data{dynamicType=" + this.brQ + ", dynamicUrl='" + this.brR + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.brS + '}';
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.brQ = jSONObject.optInt("dynamicType");
            this.brR = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
            this.interval = jSONObject.optLong(MetricsSQLiteCacheKt.METRICS_INTERVAL);
            this.sdkVersion = jSONObject.optString("sdkVersion");
        }

        public final boolean VP() {
            return this.brQ == 1;
        }

        public final boolean VQ() {
            return this.brQ == -1;
        }
    }

    static class b {
        C0569a brT;
        String errorMsg;
        long result;

        b() {
        }

        public final void parseJson(JSONObject jSONObject) {
            this.result = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString("errorMsg");
            C0569a c0569a = new C0569a();
            this.brT = c0569a;
            c0569a.parseJson(jSONObject.optJSONObject("data"));
        }

        public final String toString() {
            return "UpdateData{result=" + this.result + ", errorMsg='" + this.errorMsg + "', data=" + this.brT + '}';
        }

        final boolean isLegal() {
            return this.result == 1 && this.brT != null;
        }
    }
}
