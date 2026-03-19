package com.bytedance.adsdk.ugeno.u;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.u.an;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq {
    public static an.d d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        an.d dVar = new an.d();
        String strD = com.bytedance.adsdk.ugeno.c.hc.d(str, jSONObject);
        Uri uri = Uri.parse(strD);
        if (uri == null) {
            return null;
        }
        dVar.b(strD);
        if (!TextUtils.isEmpty(uri.getScheme())) {
            dVar.d(uri.getScheme());
        }
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = uri.getPath();
        }
        dVar.hc(authority);
        dVar.c(dVar.d() + "://" + dVar.hc());
        HashMap map = new HashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                map.put(str2, com.bytedance.adsdk.ugeno.c.hc.d(uri.getQueryParameter(str2), jSONObject));
            }
        }
        dVar.d(map);
        return dVar;
    }
}
