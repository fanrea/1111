package com.bytedance.sdk.djx.net.req.k;

import com.bytedance.sdk.djx.net.k3.Response;
import com.bytedance.sdk.djx.net.k3.ResponseBody;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class OkConvertUtils {
    private OkConvertUtils() {
    }

    public static Map<String, String> parseHeaders(Response response) {
        if (response == null || response.headers() == null) {
            return null;
        }
        HashMap map = new HashMap();
        int size = response.headers().size();
        for (int i = 0; i < size; i++) {
            map.put(response.headers().name(i), response.headers().value(i));
        }
        return map;
    }

    public static String convert2String(ResponseBody responseBody) {
        if (responseBody == null) {
            return null;
        }
        try {
            return responseBody.string();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject convert2JsonObject(ResponseBody responseBody) {
        if (responseBody == null) {
            return null;
        }
        try {
            return new JSONObject(convert2String(responseBody));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray convert2JsonArray(ResponseBody responseBody) {
        if (responseBody == null) {
            return null;
        }
        try {
            return new JSONArray(convert2String(responseBody));
        } catch (Throwable unused) {
            return null;
        }
    }
}
