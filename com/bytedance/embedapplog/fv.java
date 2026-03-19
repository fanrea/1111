package com.bytedance.embedapplog;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.fendasz.moku.planet.utils.thirdparty.codec.CharEncoding;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class fv {
    private static String d = ":push";

    public static boolean d(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean d(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null) {
            return jSONObject.toString().equals(jSONObject2.toString());
        }
        return d((Object) jSONObject, (Object) jSONObject2);
    }

    public static String d(Context context) {
        h hVarS;
        gb gbVarMq = d.mq();
        return (gbVarMq == null || (hVarS = gbVarMq.s()) == null) ? "" : hVarS.d(context);
    }

    public static boolean d() {
        gb gbVarMq = d.mq();
        if (gbVarMq != null) {
            return gbVarMq.he();
        }
        return true;
    }

    public static boolean hc() {
        h hVarS;
        gb gbVarMq = d.mq();
        if (gbVarMq == null || (hVarS = gbVarMq.s()) == null) {
            return false;
        }
        return hVarS.b();
    }

    public static String b() {
        h hVarS;
        gb gbVarMq = d.mq();
        return (gbVarMq == null || (hVarS = gbVarMq.s()) == null) ? "" : hVarS.hc();
    }

    public static boolean c() {
        h hVarS;
        gb gbVarMq = d.mq();
        if (gbVarMq == null || (hVarS = gbVarMq.s()) == null) {
            return false;
        }
        return hVarS.c();
    }

    public static JSONObject d(JSONObject jSONObject) {
        h hVarS;
        gb gbVarMq = d.mq();
        return (gbVarMq == null || (hVarS = gbVarMq.s()) == null) ? jSONObject : hVarS.d(jSONObject);
    }

    public static Looper d(fs fsVar) {
        gb gbVarWl;
        h hVarS;
        if (fsVar == null || (gbVarWl = fsVar.wl()) == null || (hVarS = gbVarWl.s()) == null) {
            return null;
        }
        return hVarS.u();
    }

    public static Looper hc(fs fsVar) {
        gb gbVarWl;
        h hVarS;
        if (fsVar == null || (gbVarWl = fsVar.wl()) == null || (hVarS = gbVarWl.s()) == null) {
            return null;
        }
        return hVarS.an();
    }

    public static boolean hc(Context context) {
        String strD = d(context);
        return strD != null && strD.endsWith(d);
    }

    public static JSONObject hc(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e) {
            um.hc(e);
        }
        return jSONObject;
    }

    public static String d(String str, HashMap<String, String> map, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : map.keySet()) {
            String strD = d(str3, str2);
            String str4 = map.get(str3);
            String strD2 = str4 != null ? d(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append(a.n);
            }
            sb.append(strD).append("=").append(strD2);
        }
        return sb.toString();
    }

    private static String d(String str, String str2) {
        if (str2 == null) {
            str2 = CharEncoding.ISO_8859_1;
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static void d(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                um.d(th);
            }
        }
    }

    public static void d(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                um.hc(th);
            }
        }
    }

    public static String d(String str) {
        h hVarS;
        gb gbVarMq = d.mq();
        return (gbVarMq == null || (hVarS = gbVarMq.s()) == null) ? "" : hVarS.d(str);
    }

    public static JSONObject hc(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        hc(jSONObject2, jSONObject);
        try {
            String strD = f.d(jSONObject2.optJSONObject("oaid"));
            if (TextUtils.isEmpty(strD)) {
                return jSONObject2;
            }
            jSONObject2.put("oaid", strD);
            return jSONObject2;
        } catch (Exception e) {
            um.hc(e);
            return jSONObject2;
        }
    }
}
