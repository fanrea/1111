package com.ss.android.socialbase.appdownloader.an;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.appdownloader.h;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private static final HashMap<String, h.d> d = new HashMap<>();

    public static boolean d(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && str.equals(jSONObjectOptJSONObject.optString("type")) && d(jSONObjectOptJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return hc(jSONObject) && d(jSONObject.optJSONArray("device_requirements")) && b(jSONObject);
    }

    public static boolean hc(JSONObject jSONObject) throws NumberFormatException {
        if (jSONObject == null) {
            return true;
        }
        int i = Build.VERSION.SDK_INT;
        String strOptString = jSONObject.optString("allow_os_api_range");
        int iOptInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(strOptString)) {
            return iOptInt <= 0 || i >= iOptInt;
        }
        try {
            String[] strArrSplit = strOptString.split("[-,]");
            for (int i2 = 0; i2 < strArrSplit.length; i2 += 2) {
                int i3 = Integer.parseInt(strArrSplit[i2]);
                int i4 = Integer.parseInt(strArrSplit[i2 + 1]);
                if (i >= i3 && i <= i4) {
                    return true;
                }
            }
        } catch (Exception e) {
            mq.d(e);
        }
        return false;
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject == null || an.d() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean d(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean zD = false;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("package_names");
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("version_allow");
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("version_block");
                String strOptString2 = jSONObjectOptJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(strOptString)) {
                    return false;
                }
                for (String strTc : strOptString.split(",")) {
                    if ("market".equals(strTc)) {
                        strTc = u.tc();
                    }
                    h.d dVarHc = hc(strTc);
                    if (dVarHc != null && !(zD = d(jSONArrayOptJSONArray, jSONArrayOptJSONArray2, strOptString2, dVarHc))) {
                        return false;
                    }
                }
            }
        }
        return zD;
    }

    private static boolean d(JSONArray jSONArray, JSONArray jSONArray2, String str, h.d dVar) throws NumberFormatException {
        String strH = dVar.h();
        int iAn = dVar.an();
        String str2 = iAn + Config.replace + strH;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split("[-,]");
                for (int i = 0; i < strArrSplit.length; i += 2) {
                    int i2 = Integer.parseInt(strArrSplit[i]);
                    int i3 = Integer.parseInt(strArrSplit[i + 1]);
                    if (iAn >= i2 && iAn <= i3) {
                        return true;
                    }
                }
            } catch (Exception e) {
                mq.d(e);
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (hc(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !hc(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    private static boolean hc(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static h.d hc(String str) {
        HashMap<String, h.d> map = d;
        if (map.containsKey(str)) {
            h.d dVar = map.get(str);
            if (dVar != null) {
                return dVar;
            }
            return null;
        }
        h.d dVarHc = h.hc(str);
        map.put(str, dVarHc);
        if (dVarHc != null) {
            return dVarHc;
        }
        return null;
    }

    public static h.d d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                h.d dVarHc = hc(str);
                if (dVarHc != null) {
                    return dVarHc;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean d(JSONObject jSONObject, Context context, String str) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("s");
            try {
                String strD = b.d(jSONObject.optString("az"), strOptString);
                String strD2 = b.d(jSONObject.optString("ba"), strOptString);
                Field declaredField = ContextWrapper.class.getDeclaredField(strD);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(strD2);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
