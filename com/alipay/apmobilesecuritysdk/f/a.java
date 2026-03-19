package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import com.alipay.sdk.m.b0.e;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        if (context == null || com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2)) {
            return null;
        }
        try {
            String strA = e.a(context, str, str2, "");
            if (com.alipay.sdk.m.z.a.a(strA)) {
                return null;
            }
            return com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), strA);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str, String str2) {
        synchronized (a.class) {
            if (com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2)) {
                return null;
            }
            try {
                String strA = com.alipay.sdk.m.b0.b.a(str);
                if (com.alipay.sdk.m.z.a.a(strA)) {
                    return null;
                }
                String string = new JSONObject(strA).getString(str2);
                if (com.alipay.sdk.m.z.a.a(string)) {
                    return null;
                }
                return com.alipay.sdk.m.y.c.b(com.alipay.sdk.m.y.c.a(), string);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2) || context == null) {
            return;
        }
        try {
            String strA = com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str3);
            HashMap map = new HashMap();
            map.put(str2, strA);
            e.a(context, str, map);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (com.alipay.sdk.m.z.a.a(str) || com.alipay.sdk.m.z.a.a(str2)) {
                return;
            }
            try {
                String strA = com.alipay.sdk.m.b0.b.a(str);
                JSONObject jSONObject = new JSONObject();
                if (com.alipay.sdk.m.z.a.b(strA)) {
                    try {
                        jSONObject = new JSONObject(strA);
                    } catch (Exception unused) {
                        jSONObject = new JSONObject();
                    }
                }
                jSONObject.put(str2, com.alipay.sdk.m.y.c.a(com.alipay.sdk.m.y.c.a(), str3));
                jSONObject.toString();
                try {
                    System.clearProperty(str);
                } catch (Throwable unused2) {
                }
                if (com.alipay.sdk.m.b0.c.a()) {
                    String str4 = ".SystemConfig" + File.separator + str;
                    if (com.alipay.sdk.m.b0.c.a()) {
                        File file = new File(Environment.getExternalStorageDirectory(), str4);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
