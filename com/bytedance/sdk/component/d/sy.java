package com.bytedance.sdk.component.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.d.mk;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class sy {
    private final mk.d b;
    private final String c;
    private final LruCache<String, b> hc;
    private final Map<String, List<hc>> d = new ConcurrentHashMap();
    private volatile boolean u = false;

    static final class b {
        v d = v.PUBLIC;
        Set<String> hc = new HashSet();
        Set<String> b = new HashSet();

        b() {
        }
    }

    sy(String str, int i, mk.d dVar, final Executor executor, JSONObject jSONObject) throws JSONException {
        this.c = str;
        if (i <= 0) {
            this.hc = new LruCache<>(16);
        } else {
            this.hc = new LruCache<>(i);
        }
        this.b = dVar;
        if (jSONObject == null) {
            c(str);
            new Object() { // from class: com.bytedance.sdk.component.d.sy.1
            };
        } else {
            update(jSONObject);
        }
    }

    void update(JSONObject jSONObject) throws JSONException {
        d(jSONObject);
        c(this.c);
    }

    b d(String str, Set<String> set) {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String string = new Uri.Builder().scheme(scheme).authority(authority).path(uri.getPath()).toString();
        b bVar = new b();
        if (authority == null || authority.isEmpty()) {
            bVar.d = v.PUBLIC;
            return bVar;
        }
        for (String str2 : set) {
            if (authority.equals(str2) || authority.endsWith(".".concat(String.valueOf(str2)))) {
                bVar.d = v.PRIVATE;
                return bVar;
            }
        }
        b bVar2 = this.hc.get(string);
        return bVar2 != null ? bVar2 : d(string);
    }

    private void d(JSONObject jSONObject) throws JSONException {
        this.d.clear();
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONArray jSONArray = jSONObject2.getJSONArray(next);
                LinkedList linkedList = new LinkedList();
                this.d.put(next, linkedList);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.add(hc(jSONArray.getJSONObject(i)));
                }
            }
        } catch (JSONException e) {
            tt.hc("Parse configurations failed, response: " + jSONObject.toString(), e);
        }
        this.u = true;
    }

    private b d(String str) throws d {
        b bVar = new b();
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        String strHc = hc(authority);
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(authority) || strHc == null) {
            bVar.d = v.PUBLIC;
            return bVar;
        }
        List<hc> listB = b(strHc);
        if (listB == null) {
            return bVar;
        }
        for (hc hcVar : listB) {
            if (hcVar.d.matcher(str).find()) {
                if (hcVar.hc.compareTo(bVar.d) >= 0) {
                    bVar.d = hcVar.hc;
                }
                bVar.hc.addAll(hcVar.b);
                bVar.b.addAll(hcVar.c);
            }
        }
        this.hc.put(str, bVar);
        return bVar;
    }

    static class d extends IllegalStateException {
        d(String str) {
            super(str);
        }
    }

    private static String hc(String str) {
        String[] strArrSplit;
        int length;
        if (str != null && (length = (strArrSplit = str.split("[.]")).length) >= 2) {
            return length == 2 ? str : strArrSplit[length - 2] + "." + strArrSplit[length - 1];
        }
        return null;
    }

    private List<hc> b(String str) throws d {
        if (!this.u) {
            throw new d("Permission config is outdated!");
        }
        return this.d.get(str);
    }

    private static hc hc(JSONObject jSONObject) throws JSONException {
        hc hcVar = new hc();
        hcVar.d = Pattern.compile(jSONObject.getString("pattern"));
        hcVar.hc = v.d(jSONObject.getString("group"));
        hcVar.b = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("included_methods");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                hcVar.b.add(jSONArrayOptJSONArray.getString(i));
            }
        }
        hcVar.c = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("excluded_methods");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                hcVar.c.add(jSONArrayOptJSONArray2.getString(i2));
            }
        }
        return hcVar;
    }

    private static String c(String str) {
        return "com.bytedance.ies.web.jsbridge2.PermissionConfig.".concat(String.valueOf(str));
    }

    private static final class hc {
        List<String> b;
        List<String> c;
        Pattern d;
        v hc;

        private hc() {
        }
    }
}
