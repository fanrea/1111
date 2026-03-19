package com.baidu.enan.e.b.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    /* JADX WARN: Multi-variable type inference failed */
    public static JSONObject a(Context context) {
        JSONObject jSONObject;
        PackageInfo packageInfo = null;
        try {
            jSONObject = new JSONObject();
        } catch (Throwable th) {
            th = th;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            String strA = com.baidu.enan.f.b.a("Y29tLnRlbmNlbnQubW0=");
            if (!(Build.VERSION.SDK_INT >= 30 && context.getApplicationInfo().targetSdkVersion >= 30) || com.baidu.enan.f.b.a(context, new String[]{"android.permission.QUERY_ALL_PACKAGES"})) {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(strA, 0);
                } catch (Throwable th2) {
                    com.baidu.enan.f.b.a(th2);
                }
                if (packageInfo != null) {
                    jSONObject2.put("0", 0);
                    jSONObject2.put("1", packageInfo.versionName);
                    jSONObject2.put("2", packageInfo.firstInstallTime);
                    jSONObject2.put("3", packageInfo.lastUpdateTime);
                } else {
                    jSONObject2.put("0", -1);
                    jSONObject2.put("1", "");
                    jSONObject2.put("2", 0);
                    jSONObject2.put("3", 0);
                }
            } else {
                jSONObject2 = new JSONObject();
            }
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            String strA2 = com.baidu.enan.f.b.a("L3NkY2FyZC8=");
            String strA3 = com.baidu.enan.f.b.a("L2RhdGEvc3lzdGVtLw==");
            String strA4 = com.baidu.enan.f.b.a("L3NkY2FyZC9iYWNrdXBz");
            String strA5 = com.baidu.enan.f.b.a("L3NkY2FyZC9iYWlkdQ==");
            String strA6 = com.baidu.enan.f.b.a("L3NkY2FyZC9UZW5jZW50");
            String[] strArrA = a.a(strA2);
            jSONObject4.put("0", strArrA[0]);
            jSONObject4.put("1", strArrA[1]);
            jSONObject4.put("2", strArrA[2]);
            jSONObject4.put("3", strArrA[3]);
            JSONObject jSONObject5 = new JSONObject();
            String[] strArrA2 = a.a(strA3);
            jSONObject5.put("0", strArrA2[0]);
            jSONObject5.put("1", strArrA2[1]);
            jSONObject5.put("2", strArrA2[2]);
            jSONObject5.put("3", strArrA2[3]);
            JSONObject jSONObject6 = new JSONObject();
            String[] strArrA3 = a.a(strA4);
            jSONObject6.put("0", strArrA3[0]);
            jSONObject6.put("1", strArrA3[1]);
            jSONObject6.put("2", strArrA3[2]);
            jSONObject6.put("3", strArrA3[3]);
            JSONObject jSONObject7 = new JSONObject();
            String[] strArrA4 = a.a(strA5);
            jSONObject7.put("0", strArrA4[0]);
            jSONObject7.put("1", strArrA4[1]);
            jSONObject7.put("2", strArrA4[2]);
            jSONObject7.put("3", strArrA4[3]);
            JSONObject jSONObject8 = new JSONObject();
            String[] strArrA5 = a.a(strA6);
            jSONObject8.put("0", strArrA5[0]);
            jSONObject8.put("1", strArrA5[1]);
            jSONObject8.put("2", strArrA5[2]);
            jSONObject8.put("3", strArrA5[3]);
            jSONObject3.put("3", jSONObject4);
            jSONObject3.put("7", jSONObject5);
            jSONObject3.put("35", jSONObject6);
            jSONObject3.put("66", jSONObject7);
            jSONObject3.put("67", jSONObject8);
            jSONObject.put("21", new JSONObject().put("1", jSONObject2));
            jSONObject.put("56", jSONObject3);
            return jSONObject;
        } catch (Throwable th3) {
            th = th3;
            packageInfo = jSONObject;
            com.baidu.enan.f.a.a(th);
            return packageInfo;
        }
    }
}
