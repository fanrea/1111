package com.kwai.middleware.azeroth.network.interceptor;

import android.net.Uri;
import android.util.Pair;
import com.kwai.middleware.azeroth.network.AzerothApiParams;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ParamsInterceptor {
    private static final String NAME = "name=\"";
    private final AzerothApiParams mConfig;

    public ParamsInterceptor(AzerothApiParams azerothApiParams) {
        this.mConfig = azerothApiParams;
    }

    public Pair<Uri.Builder, Map<String, String>> intercept(Uri uri, String str, Map<String, String> map, Map<String, String> map2) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        HashMap map3 = new HashMap();
        boolean zEquals = "GET".equals(str);
        if (map != null && !map.isEmpty()) {
            map3.putAll(map);
        }
        if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
            for (String str2 : queryParameterNames) {
                map3.put(str2, uri.getQueryParameter(str2));
            }
        }
        Map<String, String> urlParams = this.mConfig.getUrlParams();
        urlParams.putAll(map3);
        Map<String, String> postParams = this.mConfig.getPostParams();
        if ("POST".equals(str) && map2 != null && !map2.isEmpty()) {
            postParams.putAll(map3);
        }
        escapeParams(urlParams, postParams);
        this.mConfig.processSignature(str, uri.getEncodedPath(), urlParams, postParams);
        if (zEquals) {
            urlParams.putAll(postParams);
            postParams.clear();
        }
        return new Pair<>(buildUrl(uri, urlParams), postParams);
    }

    private void escapeParams(Map<String, String> map, Map<String, String> map2) {
        if (map != null) {
            for (String str : map.keySet()) {
                if (map.get(str) == null) {
                    map.put(str, "");
                }
            }
        }
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                if (map2.get(str2) == null) {
                    map2.put(str2, "");
                }
            }
        }
    }

    private Uri.Builder buildUrl(Uri uri, Map<String, String> map) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        if (map != null && !map.isEmpty()) {
            builderBuildUpon.clearQuery();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return builderBuildUpon;
    }
}
