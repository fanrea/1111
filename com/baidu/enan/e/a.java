package com.baidu.enan.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.enan.f.b;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            System.currentTimeMillis();
            jSONObject.put("m1", d(context));
            System.currentTimeMillis();
            jSONObject.put("m2", b(context));
            System.currentTimeMillis();
            jSONObject.put("m3", c(context));
            System.currentTimeMillis();
            return jSONObject.toString();
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    private static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            System.currentTimeMillis();
            jSONObject.put("7", com.baidu.enan.e.a.i.a.a(context));
            jSONObject.put(PointType.SIGMOB_APP, com.baidu.enan.e.a.a.a.a(context));
            jSONObject.put("12", com.baidu.enan.e.a.c.a.a());
            jSONObject.put(PointType.DOWNLOAD_TRACKING, com.baidu.enan.e.a.d.a.a(context));
            jSONObject.put("31", com.baidu.enan.e.a.e.a.a(context));
            System.currentTimeMillis();
            jSONObject.put("33", com.baidu.enan.e.a.f.a.a(context));
            System.currentTimeMillis();
            jSONObject.put("57", com.baidu.enan.e.a.g.a.a());
            jSONObject.put("60", com.baidu.enan.e.a.h.a.a(context));
            jSONObject.put("93", com.baidu.enan.e.a.j.a.a(context));
            jSONObject.put("108", com.baidu.enan.e.a.b.a.a(context));
            return jSONObject;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return new JSONObject();
        }
    }

    private static JSONObject c(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String strA = b.a("a2VybmVsX3FlbXU=");
            String strA2 = b.a("bmV0d29yaw==");
            String strA3 = b.a("cHJvY2Vzc19saXN0");
            String strA4 = b.a("cm91dGU=");
            String strA5 = b.a("dW5peA==");
            String strA6 = b.a("aGFyZHdhcmU=");
            String strA7 = com.baidu.enan.e.c.a.a.a();
            if (TextUtils.isEmpty(strA7)) {
                strA7 = "";
            }
            jSONObject.put(strA, strA7);
            jSONObject.put(strA2, com.baidu.enan.e.c.b.a.a(context));
            jSONObject.put(strA3, com.baidu.enan.e.c.c.a.a());
            jSONObject.put(strA4, com.baidu.enan.e.c.d.a.a());
            jSONObject.put(strA5, com.baidu.enan.e.c.e.a.a());
            jSONObject.put(strA6, Build.HARDWARE);
            return jSONObject;
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return new JSONObject();
        }
    }

    private static JSONObject d(Context context) {
        try {
            return com.baidu.enan.e.b.a.a(context);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return new JSONObject();
        }
    }
}
