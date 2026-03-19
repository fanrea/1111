package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class aa {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static <T> List<T> ip(String str) {
        return ab.ip(str);
    }

    public static <T> List<T> h(JSONArray jSONArray) {
        return ab.h(jSONArray);
    }

    public static void putValue(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, str2);
    }

    public static void putValue(JSONObject jSONObject, String str, double d) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, d);
    }

    public static void putValue(JSONObject jSONObject, String str, int i) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, i);
    }

    public static void putValue(JSONObject jSONObject, String str, float f) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, f);
    }

    public static void putValue(JSONObject jSONObject, String str, byte b) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, b);
    }

    public static void putValue(JSONObject jSONObject, String str, long j) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, j);
    }

    public static void putValue(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, z);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, jSONObject2);
    }

    public static void putValue(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject == null) {
            return;
        }
        ab.putValue(jSONObject, str, jSONArray);
    }

    public static void a(JSONObject jSONObject, String str, com.kwad.sdk.core.b bVar) {
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put(str, bVar.toJson());
        } catch (JSONException unused) {
        }
    }

    public static void putValue(JSONObject jSONObject, String str, List<?> list) {
        if (jSONObject == null || list == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            boolean z = false;
            for (Object obj : list) {
                if (obj instanceof com.kwad.sdk.core.b) {
                    a(jSONArray, ((com.kwad.sdk.core.b) obj).toJson());
                } else if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof JSONObject) || (obj instanceof JSONArray) || (obj instanceof Double) || (obj instanceof Boolean)) {
                    jSONArray.put(obj);
                } else if (!(obj instanceof Float)) {
                    break;
                } else {
                    try {
                        jSONArray.put(((Float) obj).floatValue());
                    } catch (JSONException unused) {
                    }
                }
                z = true;
            }
            if (z) {
                putValue(jSONObject, str, jSONArray);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static JSONArray a(JSONArray jSONArray, JSONObject jSONObject) {
        try {
            jSONArray.put(jSONObject);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return jSONArray;
    }

    public static JSONArray toJsonArray(List<String> list) {
        return ab.toJsonArray(list);
    }

    public static <T> JSONArray aL(List<T> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (T t : list) {
                        if (t != null) {
                            if (t instanceof JSONObject) {
                                jSONArray.put(t);
                            } else if (t instanceof com.kwad.sdk.core.b) {
                                jSONArray.put(((com.kwad.sdk.core.b) t).toJson());
                            } else if (t instanceof String) {
                                jSONArray.put(t);
                            } else {
                                throw new IllegalArgumentException("<T> now suppprt type: " + t.getClass().getName());
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return jSONArray;
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        try {
            ab.a(jSONObject, jSONObject2, z);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static Map<String, String> parseJSON2MapString(String str) {
        return ab.parseJSON2MapString(str);
    }

    public static JSONObject parseMap2JSON(Map<String, String> map) {
        return ab.parseMap2JSON(map);
    }

    public static <T extends com.kwad.sdk.core.b> List<T> a(String str, com.kwad.sdk.core.c<T> cVar) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                com.kwad.sdk.core.b bVarLe = cVar.Le();
                bVarLe.parseJson(jSONObject);
                arrayList.add(bVarLe);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return arrayList;
    }

    public static <T extends com.kwad.sdk.core.b> T b(String str, com.kwad.sdk.core.c<T> cVar) {
        T t = (T) cVar.Le();
        try {
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        if (TextUtils.isEmpty(str)) {
            return t;
        }
        try {
            t.parseJson(new JSONObject(str));
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
        return t;
    }
}
