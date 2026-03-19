package com.baidu.mobstat.forbes;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class EventAnalysis {
    private Map<String, a> a = new HashMap();

    public void onEvent(Context context, long j, String str, String str2, int i, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        if (!ap.a().f()) {
            return;
        }
        a(context, j, str, str2, i, j2, 0L, extraInfo, map, z);
    }

    public void onEvent(Context context, long j, String str, String str2, int i, long j2, String str3, String str4, int i2, boolean z) {
        if (!ap.a().f()) {
            return;
        }
        a(context, j, str, str2, i, j2, 0L, str3, str4, i2);
    }

    public void onEvent(Context context, long j, String str, String str2, int i, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        if (!ap.a().f()) {
            return;
        }
        flushEvent(context, j, str, str2, i, j2, jSONArray, jSONArray2, str3, str4, str5, map, z);
    }

    public void onEventStart(Context context, String str, String str2, long j) {
        if (!ap.a().f()) {
            return;
        }
        a aVar = new a();
        aVar.c = j;
        aVar.a = str;
        aVar.b = str2;
        String strA = a(str, str2);
        if (this.a.containsKey(strA)) {
            v.c().b("[WARNING] eventId: " + str + ", with label: " + str2 + " is duplicated, older is removed");
        }
        this.a.put(strA, aVar);
    }

    public void onEventEnd(Context context, long j, String str, String str2, long j2, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        String strA = a(str, str2);
        if (!ap.a().f()) {
            this.a.remove(strA);
            return;
        }
        a aVar = this.a.get(strA);
        if (aVar == null) {
            v.c().b("[WARNING] eventId: " + str + ", with label: " + str2 + " is not started or alread ended");
            return;
        }
        if ((str != null && !str.equals(aVar.a)) || (str2 != null && !str2.equals(aVar.b))) {
            v.c().b("[WARNING] eventId/label pair not match");
            return;
        }
        this.a.remove(strA);
        long j3 = j2 - aVar.c;
        if (j3 < 0) {
            v.c().b("[WARNING] onEventEnd must be invoked after onEventStart");
        }
        onEventDuration(context, j, str, str2, aVar.c, j3, extraInfo, map, z);
    }

    public void onEventDuration(Context context, long j, String str, String str2, long j2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        if (!ap.a().f() || j3 <= 0) {
            return;
        }
        a(context, j, str, str2, 1, j2, j3, extraInfo, map, z);
    }

    private void a(Context context, long j, String str, String str2, int i, long j2, long j3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        if (!ap.a().f()) {
            return;
        }
        DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i, j2, j3, "", "", 0, 0, extraInfo, map, z));
        DataCore.instance().flush(context);
    }

    private void a(Context context, long j, String str, String str2, int i, long j2, long j3, String str3, String str4, int i2) {
        DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i, j2, j3, str3, str4, i2, 1, null, null, false));
        DataCore.instance().flush(context);
    }

    public void flushEvent(Context context, long j, String str, String str2, int i, long j2, JSONArray jSONArray, JSONArray jSONArray2, String str3, String str4, String str5, Map<String, String> map, boolean z) {
        if (!ap.a().f()) {
            return;
        }
        DataCore.instance().putEvent(context, getEvent(context, j, str, str2, i, j2, 0L, "", jSONArray, jSONArray2, str3, str4, str5, Config.EventViewType.EDIT.getValue(), 2, null, map, "", "", z));
        DataCore.instance().flush(context);
    }

    private String a(String str, String str2) {
        return "__sdk_" + str + "$|$" + str2;
    }

    static class a {
        String a;
        String b;
        long c;

        private a() {
        }
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, int i, long j2, long j3, String str3, String str4, int i2, int i3, ExtraInfo extraInfo, Map<String, String> map, boolean z) {
        return getEvent(context, j, str, str2, i, j2, j3, str3, null, null, str4, null, null, i2, i3, extraInfo, map, "", "", z);
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, int i, long j2, long j3, String str3, JSONArray jSONArray, JSONArray jSONArray2, String str4, String str5, String str6, int i2, int i3, ExtraInfo extraInfo, Map<String, String> map, String str7, String str8, boolean z) {
        return getEvent(context, j, str, str2, "", i, j2, j3, str3, jSONArray, jSONArray2, str4, str5, str6, i2, i3, extraInfo, map, str7, str8, z, null, "", null);
    }

    public static JSONObject getEvent(Context context, long j, String str, String str2, String str3, int i, long j2, long j3, String str4, JSONArray jSONArray, JSONArray jSONArray2, String str5, String str6, String str7, int i2, int i3, ExtraInfo extraInfo, Map<String, String> map, String str8, String str9, boolean z, JSONObject jSONObject, String str10, JSONArray jSONArray3) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ss", j);
            jSONObject2.put("i", str);
            jSONObject2.put("l", str2);
            jSONObject2.put("c", i);
            jSONObject2.put("t", j2);
            jSONObject2.put("d", j3);
            jSONObject2.put("h", str4);
            if (i3 != 3) {
                jSONObject2.put(Config.EVENT_NATIVE_VIEW_HIERARCHY, jSONArray);
                jSONObject2.put(Config.EVENT_H5_VIEW_HIERARCHY, jSONArray2);
            } else {
                jSONObject2.put(Config.EVENT_NATIVE_VIEW_HIERARCHY, str8);
                jSONObject2.put(Config.EVENT_H5_VIEW_HIERARCHY, str9);
                jSONObject2.put("content", str3);
                jSONObject2.put(Config.PY, DataCore.instance().getEventPy());
            }
            jSONObject2.put("p", str5);
            jSONObject2.put(Config.EVENT_H5_PAGE, str6);
            jSONObject2.put(Config.EVENT_VIEW_RES_NAME, str7);
            jSONObject2.put("v", i2);
            jSONObject2.put("at", i3);
            jSONObject2.put("h5", z ? 1 : 0);
            if (extraInfo != null && extraInfo.dumpToJson().length() != 0) {
                jSONObject2.put("ext", extraInfo.dumpToJson());
            }
            if (map != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value) && !a(value, 1024)) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("k", key);
                        jSONObject3.put("v", value);
                        jSONArray4.put(jSONObject3);
                    }
                }
                if (jSONArray4.length() != 0) {
                    jSONObject2.put(Config.EVENT_ATTR, jSONArray4);
                }
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                JSONArray jSONArray5 = new JSONArray();
                jSONArray5.put(jSONObject);
                jSONObject2.put(Config.EVENT_HEAT_POINT, jSONArray5);
            }
            Object obj = "";
            jSONObject2.put("sign", TextUtils.isEmpty(str10) ? "" : str10);
            if (jSONArray3 != null && jSONArray3.length() != 0) {
                obj = jSONArray3;
            }
            jSONObject2.put("v5", obj);
        } catch (Exception e) {
        }
        return jSONObject2;
    }

    private static boolean a(String str, int i) {
        int length;
        if (str == null) {
            return false;
        }
        try {
            length = str.getBytes().length;
        } catch (Exception e) {
            length = 0;
        }
        return length > i;
    }

    private static boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str) || new JSONObject().toString().equals(str)) {
            return (TextUtils.isEmpty(str2) || new JSONArray().toString().equals(str2)) ? false : true;
        }
        return true;
    }

    public static void doEventMerge(JSONArray jSONArray, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        String strOptString;
        String strOptString2;
        JSONArray jSONArray2;
        int i;
        Config.EventViewType.EDIT.getValue();
        try {
            String strOptString3 = jSONObject.optString(Config.PY);
            long jOptLong = jSONObject.optLong("ss");
            String string = jSONObject.getString("i");
            String string2 = jSONObject.getString("l");
            long j = jSONObject.getLong("t") / 3600000;
            String strOptString4 = jSONObject.optString("s");
            int iOptInt = jSONObject.optInt("at");
            String strOptString5 = jSONObject.optString("h");
            if (iOptInt != 3) {
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                strOptString = "";
                strOptString2 = strOptString;
                jSONArrayOptJSONArray = jSONObject.optJSONArray(Config.EVENT_H5_VIEW_HIERARCHY);
                jSONArray2 = jSONArrayOptJSONArray2;
            } else {
                jSONArrayOptJSONArray = null;
                strOptString = jSONObject.optString(Config.EVENT_NATIVE_VIEW_HIERARCHY);
                strOptString2 = jSONObject.optString(Config.EVENT_H5_VIEW_HIERARCHY);
                jSONArray2 = null;
            }
            String strOptString6 = jSONObject.optString("p");
            String strOptString7 = jSONObject.optString(Config.EVENT_H5_PAGE);
            String strOptString8 = jSONObject.optString(Config.EVENT_VIEW_RES_NAME);
            int iOptInt2 = jSONObject.optInt("v");
            String strOptString9 = jSONObject.optString("ext");
            String strOptString10 = jSONObject.optString(Config.EVENT_ATTR);
            int iOptInt3 = jSONObject.optInt("h5");
            String strOptString11 = jSONObject.optString("sign");
            try {
                i = jSONObject.getInt("d");
            } catch (JSONException e) {
                i = 0;
            }
            if (i == 0 && !b(strOptString9, strOptString10)) {
                a(jSONArray, jSONObject, jOptLong, string, string2, strOptString4, j, strOptString5, jSONArray2, jSONArrayOptJSONArray, strOptString6, strOptString7, strOptString8, iOptInt2, iOptInt, strOptString, strOptString2, iOptInt3, strOptString11, strOptString3);
                return;
            }
            int length = jSONArray.length();
            try {
                jSONObject.put("s", "0");
                jSONArray.put(length, jSONObject);
            } catch (JSONException e2) {
            }
        } catch (JSONException e3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(org.json.JSONArray r31, org.json.JSONObject r32, long r33, java.lang.String r35, java.lang.String r36, java.lang.String r37, long r38, java.lang.String r40, org.json.JSONArray r41, org.json.JSONArray r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, int r46, int r47, java.lang.String r48, java.lang.String r49, int r50, java.lang.String r51, java.lang.String r52) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 891
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.EventAnalysis.a(org.json.JSONArray, org.json.JSONObject, long, java.lang.String, java.lang.String, java.lang.String, long, java.lang.String, org.json.JSONArray, org.json.JSONArray, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String):void");
    }

    private static void a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(Config.EVENT_HEAT_POINT);
        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() != 0) {
            for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                try {
                    jSONArray.put(jSONArrayOptJSONArray2.getJSONObject(i));
                } catch (Exception e) {
                }
            }
        }
        if (jSONArray.length() < 10 && (jSONArrayOptJSONArray = jSONObject2.optJSONArray(Config.EVENT_HEAT_POINT)) != null && jSONArrayOptJSONArray.length() != 0) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                try {
                    jSONArray.put(jSONArrayOptJSONArray.getJSONObject(i2));
                } catch (Exception e2) {
                }
            }
        }
        if (jSONArray.length() != 0) {
            try {
                jSONObject.put(Config.EVENT_HEAT_POINT, jSONArray);
            } catch (Exception e3) {
            }
        }
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray != null && jSONArray2 != null && jSONArray.toString().equals(jSONArray2.toString())) {
            return true;
        }
        return false;
    }
}
