package com.bytedance.msdk.gb;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.h.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class zw {
    private static final Map<String, zw> d = new HashMap();
    private com.bytedance.sdk.component.c.d.hc hc;

    public static zw d(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_mediation_sdk_sp";
        }
        Map<String, zw> map = d;
        zw zwVar = map.get(str);
        if (zwVar != null) {
            return zwVar;
        }
        zw zwVar2 = new zw(str, context);
        map.put(str, zwVar2);
        return zwVar2;
    }

    private zw(String str, Context context) {
        context = context == null ? com.bytedance.msdk.core.hc.getContext() : context;
        if (context != null) {
            this.hc = new c.d().d(str).d(context).d(1).d(com.bytedance.msdk.core.d.mk().uo()).d();
        }
    }

    public void d(String str) {
        d("any_door_id", str);
    }

    public String d() {
        return hc("any_door_id", "");
    }

    public void d(String str, String str2) {
        try {
            this.hc.d(str, str2);
        } catch (Throwable unused) {
        }
    }

    public String hc(String str) {
        try {
            return hc(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public String hc(String str, String str2) {
        try {
            return this.hc.hc(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void d(String str, int i) {
        try {
            this.hc.d(str, i);
        } catch (Throwable unused) {
        }
    }

    public int b(String str) {
        return hc(str, -1);
    }

    public int hc(String str, int i) {
        try {
            return this.hc.hc(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public void d(String str, long j) {
        try {
            this.hc.d(str, j);
        } catch (Throwable unused) {
        }
    }

    public long c(String str) {
        return hc(str, -1L);
    }

    public long hc(String str, long j) {
        try {
            return this.hc.hc(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public void d(String str, float f) {
        try {
            this.hc.d(str, f);
        } catch (Throwable unused) {
        }
    }

    public float hc(String str, float f) {
        try {
            return this.hc.hc(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    public void d(String str, boolean z) {
        try {
            this.hc.d(str, z);
        } catch (Throwable unused) {
        }
    }

    public boolean u(String str) {
        return hc(str, false);
    }

    public boolean hc(String str, boolean z) {
        try {
            return this.hc.hc(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public Map<String, ?> hc() {
        try {
            return this.hc.getAll();
        } catch (Throwable unused) {
            return new HashMap();
        }
    }

    public void an(String str) {
        try {
            this.hc.d(str);
        } catch (Throwable unused) {
        }
    }

    public void b() {
        try {
            this.hc.d();
        } catch (Throwable unused) {
        }
    }

    public static void d(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            String strHc = d("gm_v3_temp", com.bytedance.msdk.core.hc.getContext()).hc("gm_key_v3_bug");
            if (!TextUtils.isEmpty(strHc)) {
                jSONArray = new JSONArray(strHc);
            } else {
                jSONArray = new JSONArray();
            }
            if (jSONArray.length() >= 100) {
                jSONArray.put(99, jSONObject);
            } else {
                jSONArray.put(jSONObject);
            }
            d("gm_v3_temp", com.bytedance.msdk.core.hc.getContext()).d("gm_key_v3_bug", jSONArray.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONArray c() {
        try {
            String strHc = d("gm_v3_temp", com.bytedance.msdk.core.hc.getContext()).hc("gm_key_v3_bug");
            if (TextUtils.isEmpty(strHc)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(strHc);
            d("gm_v3_temp", com.bytedance.msdk.core.hc.getContext()).an("gm_key_v3_bug");
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(boolean z, int i, String str, long j, String str2) {
        JSONObject jSONObject;
        try {
            String strHc = d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).hc("v3");
            if (TextUtils.isEmpty(strHc)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strHc);
            }
            int i2 = 1;
            if (z) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObject.put("success", jSONObjectOptJSONObject);
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("times", -1);
                int i3 = iOptInt == -1 ? 1 : iOptInt + 1;
                jSONObjectOptJSONObject.put("times", i3);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("upload_size", -1);
                jSONObjectOptJSONObject.put("upload_size", iOptInt2 == -1 ? i : iOptInt2 + i);
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("reason");
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                    jSONObjectOptJSONObject.put("reason", jSONObjectOptJSONObject2);
                }
                int iOptInt3 = jSONObjectOptJSONObject2.optInt(str, -1);
                if (iOptInt3 != -1) {
                    i2 = 1 + iOptInt3;
                }
                jSONObjectOptJSONObject2.put(str, i2);
                if (j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    long jOptInt = jSONObjectOptJSONObject.optInt("avg_req_duration", -1);
                    jSONObjectOptJSONObject.put("avg_req_duration", jOptInt == -1 ? j : ((jOptInt * (i3 - 1)) + j) / i3);
                }
            } else {
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("fail");
                if (jSONObjectOptJSONObject3 == null) {
                    jSONObjectOptJSONObject3 = new JSONObject();
                    jSONObject.put("fail", jSONObjectOptJSONObject3);
                }
                int iOptInt4 = jSONObjectOptJSONObject3.optInt("times", -1);
                jSONObjectOptJSONObject3.put("times", iOptInt4 == -1 ? 1 : iOptInt4 + 1);
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("error_code");
                if (jSONObjectOptJSONObject4 == null) {
                    jSONObjectOptJSONObject4 = new JSONObject();
                    jSONObjectOptJSONObject3.put("error_code", jSONObjectOptJSONObject4);
                }
                int iOptInt5 = jSONObjectOptJSONObject4.optInt(str2, -1);
                if (iOptInt5 != -1) {
                    i2 = 1 + iOptInt5;
                }
                jSONObjectOptJSONObject4.put(str2, i2);
            }
            d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).d("v3", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static void d(String str, boolean z, long j, String str2) {
        JSONObject jSONObject;
        try {
            String strHc = d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).hc(str);
            if (TextUtils.isEmpty(strHc)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strHc);
            }
            int i = 1;
            if (z) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    jSONObject.put("success", jSONObjectOptJSONObject);
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("times", -1);
                if (iOptInt != -1) {
                    i = 1 + iOptInt;
                }
                jSONObjectOptJSONObject.put("times", i);
                if (j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    long jOptInt = jSONObjectOptJSONObject.optInt("avg_req_duration", -1);
                    if (jOptInt != -1) {
                        j = ((jOptInt * (i - 1)) + j) / i;
                    }
                    jSONObjectOptJSONObject.put("avg_req_duration", j);
                }
            } else {
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("fail");
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                    jSONObject.put("fail", jSONObjectOptJSONObject2);
                }
                int iOptInt2 = jSONObjectOptJSONObject2.optInt("times", -1);
                jSONObjectOptJSONObject2.put("times", iOptInt2 == -1 ? 1 : iOptInt2 + 1);
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("error_code");
                if (jSONObjectOptJSONObject3 == null) {
                    jSONObjectOptJSONObject3 = new JSONObject();
                    jSONObjectOptJSONObject2.put("error_code", jSONObjectOptJSONObject3);
                }
                int iOptInt3 = jSONObjectOptJSONObject3.optInt(str2, -1);
                if (iOptInt3 != -1) {
                    i = 1 + iOptInt3;
                }
                jSONObjectOptJSONObject3.put(str2, i);
            }
            d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).d(str, jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONObject h(String str) {
        try {
            String strHc = d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).hc(str);
            if (TextUtils.isEmpty(strHc)) {
                return null;
            }
            d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).an(str);
            return new JSONObject(strHc);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b(String str, long j) {
        JSONObject jSONObject;
        try {
            String strHc = d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).hc("init_time");
            if (TextUtils.isEmpty(strHc)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(strHc);
            }
            jSONObject.put(str, j);
            d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).d("init_time", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONObject u() {
        try {
            String strHc = d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).hc("init_time");
            if (TextUtils.isEmpty(strHc)) {
                return null;
            }
            d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).an("init_time");
            return new JSONObject(strHc);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(int i, int i2) {
        try {
            int iHc = d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).hc("low_m_cnt", 0);
            int iHc2 = d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).hc("clean_invalid_cnt", 0) + i;
            int iHc3 = d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).hc("force_clean_cnt", 0) + i2;
            d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).d("low_m_cnt", iHc + 1);
            d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).d("clean_invalid_cnt", iHc2);
            d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).d("force_clean_cnt", iHc3);
        } catch (Throwable unused) {
        }
    }

    public static void d(Map<String, Object> map) {
        try {
            int iHc = d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).hc("low_m_cnt", 0);
            int iHc2 = d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).hc("clean_invalid_cnt", 0);
            int iHc3 = d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).hc("force_clean_cnt", 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("low_m_cnt", iHc);
            jSONObject.put("invalid_cnt", iHc2);
            jSONObject.put("force_cnt", iHc3);
            map.put("low_m_clean", jSONObject);
            d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).d("low_m_cnt", 0);
            d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).d("clean_invalid_cnt", 0);
            d("evt_upload_info", com.bytedance.msdk.core.hc.getContext()).d("force_clean_cnt", 0);
        } catch (Throwable unused) {
        }
    }

    public static void hc(Map<String, Object> map) {
        try {
            Context context = com.bytedance.msdk.core.hc.getContext();
            SharedPreferences sharedPreferencesHc = com.bytedance.sdk.openadsdk.api.plugin.hc.hc((Context) com.bytedance.msdk.d.u.d.d(context), "cb_test", 0);
            String string = sharedPreferencesHc.getString("ks", "");
            String string2 = sharedPreferencesHc.getString("gdt", "");
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                sharedPreferencesHc = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context, "cb_test", 0);
                string = sharedPreferencesHc.getString("ks", "");
                string2 = sharedPreferencesHc.getString("gdt", "");
            }
            if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(string)) {
                jSONObject.put("ks", string);
            }
            if (!TextUtils.isEmpty(string2)) {
                jSONObject.put("gdt", string2);
            }
            map.put("cb_stacktrace", jSONObject);
            sharedPreferencesHc.edit().clear().apply();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
        }
    }
}
