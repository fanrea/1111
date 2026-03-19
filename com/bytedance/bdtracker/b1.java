package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b1 {
    public HashSet<String> a;
    public HashMap<String, HashSet<String>> b;

    public b1(HashSet<String> hashSet, HashMap<String, HashSet<String>> map) {
        this.a = hashSet;
        this.b = map;
    }

    public static b1 a(Context context, String str, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        try {
            SharedPreferences.Editor editorEdit = f4.a(context, str, 0).edit();
            editorEdit.clear().apply();
            if (jSONObject == null || !jSONObject.has("event_list") || (jSONObjectOptJSONObject = jSONObject.optJSONObject("event_list")) == null) {
                return null;
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("is_block", 0);
            editorEdit.putInt("is_block", iOptInt);
            HashSet hashSet = new HashSet();
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("events");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        hashSet.add(strOptString);
                    }
                }
            }
            if (hashSet.size() > 0) {
                editorEdit.putStringSet("events", hashSet);
            }
            HashMap map = new HashMap();
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("params");
            if (jSONObjectOptJSONObject2 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!TextUtils.isEmpty(next)) {
                        HashSet hashSet2 = new HashSet();
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray(next);
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                String strOptString2 = jSONArrayOptJSONArray2.optString(i2);
                                if (!TextUtils.isEmpty(strOptString2)) {
                                    hashSet2.add(strOptString2);
                                }
                            }
                        }
                        if (hashSet2.size() > 0) {
                            map.put(next, hashSet2);
                        }
                    }
                }
            }
            if (map.size() > 0) {
                for (Map.Entry entry : map.entrySet()) {
                    editorEdit.putStringSet((String) entry.getKey(), (Set) entry.getValue());
                }
            }
            editorEdit.apply();
            return iOptInt > 0 ? new d1(hashSet, map) : new c1(hashSet, map);
        } catch (Throwable unused) {
            return null;
        }
    }

    public abstract boolean a(String str);

    public final boolean a(String str, String str2) {
        HashMap<String, HashSet<String>> map;
        HashSet<String> hashSet;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HashSet<String> hashSet2 = this.a;
        if (hashSet2 != null && hashSet2.size() > 0) {
            if (a(str)) {
                return false;
            }
            if (TextUtils.isEmpty(str2)) {
                return true;
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException unused) {
            }
            if (jSONObject != null && (map = this.b) != null && map.size() > 0 && this.b.containsKey(str) && (hashSet = this.b.get(str)) != null && hashSet.size() > 0) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    if (a(hashSet, itKeys.next())) {
                        try {
                            itKeys.remove();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        }
        return true;
    }

    public abstract boolean a(HashSet<String> hashSet, String str);
}
