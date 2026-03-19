package com.kwad.sdk.live.audience.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveCDNUrl {
    private static final String CDN = "cdn";
    private static final String URL = "url";
    private static final String URL_PATTERN = "urlPattern";
    public String mCdn;
    public String mUrl;
    public String mUrlPattern;

    public static KSLiveCDNUrl parseFromJson(JSONObject jSONObject) {
        KSLiveCDNUrl kSLiveCDNUrl = new KSLiveCDNUrl();
        kSLiveCDNUrl.mUrl = jSONObject.optString("url");
        kSLiveCDNUrl.mCdn = jSONObject.optString("cdn");
        kSLiveCDNUrl.mUrlPattern = jSONObject.optString(URL_PATTERN);
        return kSLiveCDNUrl;
    }

    public static List<KSLiveCDNUrl> parseFromJson(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(parseFromJson(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }
}
