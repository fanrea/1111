package com.qq.e.comm.plugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ln {
    public static boolean b(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() <= 0;
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() <= 0;
    }

    public static JSONObject b(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        return a(jSONObject, jSONObject2, true);
    }

    public static List<Object> c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object objOpt = jSONArray.opt(i);
            if (objOpt != null) {
                if (objOpt instanceof JSONObject) {
                    arrayList.add(c((JSONObject) objOpt));
                } else if (objOpt instanceof JSONArray) {
                    arrayList.add(c((JSONArray) objOpt));
                } else {
                    arrayList.add(objOpt);
                }
            }
        }
        return arrayList;
    }

    public static JSONArray b(JSONArray jSONArray, JSONArray jSONArray2) {
        int length;
        int length2;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return jSONArray2;
        }
        if (jSONArray2 == null || (length2 = jSONArray2.length()) == 0) {
            return jSONArray;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < length; i++) {
            hashSet.add(jSONArray.opt(i));
        }
        for (int i2 = 0; i2 < length2; i2++) {
            hashSet.add(jSONArray2.opt(i2));
        }
        return new JSONArray((Collection) hashSet);
    }

    public static JSONArray a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object objOpt = jSONArray.opt(i);
            if (objOpt instanceof JSONObject) {
                objOpt = a((JSONObject) objOpt);
            } else if (objOpt instanceof JSONArray) {
                objOpt = a((JSONArray) objOpt);
            }
            jSONArray2.put(objOpt);
        }
        return jSONArray2;
    }

    public static Map<String, Object> c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys != null && itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt != null) {
                if (objOpt instanceof JSONObject) {
                    map.put(next, c((JSONObject) objOpt));
                } else if (objOpt instanceof JSONArray) {
                    map.put(next, c((JSONArray) objOpt));
                } else {
                    map.put(next, objOpt);
                }
            }
        }
        return map;
    }

    public static JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        jn jnVar = new jn();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (objOpt instanceof JSONObject) {
                objOpt = a((JSONObject) objOpt);
            } else if (objOpt instanceof JSONArray) {
                objOpt = a((JSONArray) objOpt);
            }
            jnVar.a(next, objOpt);
        }
        return jnVar.a();
    }

    private static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2, boolean z) throws JSONException {
        if (b(jSONObject)) {
            return jSONObject2;
        }
        if (!b(jSONObject2)) {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                Object objOpt2 = jSONObject2.opt(next);
                if (objOpt == null) {
                    jSONObject.put(next, objOpt2);
                } else if ((objOpt instanceof JSONObject) && (objOpt2 instanceof JSONObject)) {
                    a((JSONObject) objOpt, (JSONObject) objOpt2, z);
                } else if ((objOpt instanceof JSONArray) && (objOpt2 instanceof JSONArray)) {
                    a((JSONArray) objOpt, (JSONArray) objOpt2);
                } else if (z && (objOpt2 instanceof Number) && (objOpt instanceof Number)) {
                    jSONObject.put(next, objOpt2);
                } else if (z && objOpt.getClass().isInstance(objOpt2)) {
                    jSONObject.put(next, objOpt2);
                }
            }
        }
        return jSONObject;
    }

    public static JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        if (b(jSONArray)) {
            return jSONArray2;
        }
        if (!b(jSONArray2)) {
            for (int i = 0; i < jSONArray2.length(); i++) {
                jSONArray.put(jSONArray2.get(i));
            }
        }
        return jSONArray;
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        return a(jSONObject, jSONObject2, false);
    }
}
