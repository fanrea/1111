package com.baidu.mobads.container.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ah {
    public static String a(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return "";
        }
    }

    public static Bitmap a(String str) {
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONArray a(double[] dArr) throws JSONException {
        JSONArray jSONArray = null;
        if (dArr == null) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (double d : dArr) {
                try {
                    jSONArray2.put(d);
                } catch (Exception e) {
                    e = e;
                    jSONArray = jSONArray2;
                    bq.a().a(e);
                    return jSONArray;
                }
            }
            return jSONArray2;
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static JSONArray a(List<String[]> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < list.get(i).length; i2++) {
                    jSONArray2.put(list.get(i)[i2]);
                }
                jSONArray.put(jSONArray2);
            } catch (Exception e) {
                bq.a().a(e);
            }
        }
        return jSONArray;
    }

    public static HashMap<String, String> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, String> map = new HashMap<>();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                map.put(next, jSONObject.optString(next));
            } catch (Exception e) {
                bq.a().a("json2HashMap error");
            }
        }
        return map;
    }

    public static JSONObject a(HashMap<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(map);
        } catch (Exception e) {
            bq.a().a("hashMap2Json error");
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject.put(next, jSONObject2.opt(next));
        }
        return jSONObject;
    }

    public static Object a(JSONObject jSONObject, String str) {
        if (jSONObject == null || !jSONObject.has(str)) {
            return "";
        }
        return jSONObject.opt(str);
    }

    public static String a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null && !TextUtils.isEmpty(str) && jSONObject.has(str)) {
            try {
                Object objOpt = jSONObject.opt(str);
                if (objOpt instanceof String) {
                    String str3 = (String) objOpt;
                    jSONObject.remove(str);
                    return str3;
                }
            } catch (Exception e) {
            }
        }
        return str2;
    }

    public static int a(JSONObject jSONObject, String str, int i) {
        if (jSONObject != null && !TextUtils.isEmpty(str) && jSONObject.has(str)) {
            try {
                if (jSONObject.opt(str) instanceof Integer) {
                    int iIntValue = ((Integer) jSONObject.opt(str)).intValue();
                    jSONObject.remove(str);
                    return iIntValue;
                }
            } catch (Exception e) {
            }
        }
        return i;
    }

    public static void a(List<Integer> list, JSONArray jSONArray, int i) {
        if (list != null && jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    list.add(Integer.valueOf(((Integer) jSONArray.get(i2)).intValue()));
                } catch (Exception e) {
                    list.add(Integer.valueOf(i));
                }
            }
        }
    }

    public static void a(List<String> list, JSONArray jSONArray, String str) {
        String strOptString;
        if (list == null || jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                if (TextUtils.isEmpty(str)) {
                    strOptString = (String) jSONArray.get(i);
                } else {
                    strOptString = ((JSONObject) jSONArray.get(i)).optString(str, "");
                }
                if (!TextUtils.isEmpty(strOptString)) {
                    list.add(o.a(strOptString, false));
                }
            } catch (Exception e) {
            }
        }
    }

    public static String a(JSONObject jSONObject, String str, String str2, boolean z) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            return o.a(jSONObject.optString(str, str2), z);
        }
        return str2;
    }
}
