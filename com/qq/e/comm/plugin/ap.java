package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ap {
    private static volatile b a;

    public static long a() {
        return 15L;
    }

    public static String[] c() {
        if (a == null) {
            d();
        }
        if (a == null) {
            return null;
        }
        return a.b;
    }

    private static synchronized void d() {
        byte[] bArrDecode;
        if (a != null) {
            return;
        }
        String strC = r1.d().f().c("smfs");
        if (TextUtils.isEmpty(strC) && (bArrDecode = Base64.decode("W3sibSI6MSwibiI6IkhVQVdFSSIsInAiOiJjb20uaHVhd2VpLmFwcG1hcmtldCJ9LHsibSI6NCwibiI6Ik9QUE8iLCJwIjoiY29tLm9wcG8ubWFya2V0LGNvbS5oZXl0YXAubWFya2V0In0seyJtIjo4LCJuIjoiVklWTyIsInAiOiJjb20uYmJrLmFwcHN0b3JlIn0seyJtIjoxNiwibiI6IkhPTk9SIiwicCI6ImNvbS5oaWhvbm9yLmFwcG1hcmtldCxjb20uaHVhd2VpLmFwcG1hcmtldCJ9LHsibSI6MzIsIm4iOiJTQU1TVU5HIiwicCI6ImNvbS5zZWMuYW5kcm9pZC5hcHAuc2Ftc3VuZ2FwcHMiLCJ1Ijoic2Ftc3VuZ2FwcHM6Ly9Qcm9kdWN0RGV0YWlsLyVzIn0seyJtIjo2NCwibiI6Ik1FSVpVIiwicCI6ImNvbS5tZWl6dS5tc3RvcmUifSx7Im0iOjEyOCwibiI6IlpURSIsInAiOiJ6dGUuY29tLm1hcmtldCJ9LHsibSI6NTEyLCJuIjoiTlVCSUEiLCJwIjoiY29tLm51YmlhLm5lb3N0b3JlIn0seyJtIjoxMDI0LCJuIjoiUkVBTE1FIiwicCI6ImNvbS5vcHBvLm1hcmtldCxjb20uaGV5dGFwLm1hcmtldCJ9LHsibSI6MjA0OCwibiI6Ik9ORVBMVVMiLCJwIjoiY29tLm9wcG8ubWFya2V0LGNvbS5oZXl0YXAubWFya2V0In0seyJtIjo0MDk2LCJuIjoiMzYwIiwicCI6ImNvbS5xaWhvby5hcHBzdG9yZSxjb20ubWFya2V0LmNoZW54aWFuZyJ9XQ==", 0)) != null) {
            strC = new String(bArrDecode, d6.a);
        }
        try {
            JSONArray jSONArray = new JSONArray(strC);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    b bVar = new b();
                    bVar.a = jSONObjectOptJSONObject.optString("n");
                    String strOptString = jSONObjectOptJSONObject.optString("p");
                    if (strOptString != null) {
                        bVar.b = strOptString.split(",");
                    }
                    bVar.c = jSONObjectOptJSONObject.optString(com.kuaishou.weapon.p0.t.i, "market://details?id=%s");
                    bVar.d = jSONObjectOptJSONObject.optLong("m");
                    if (TextUtils.isEmpty(bVar.a)) {
                        continue;
                    } else {
                        String[] strArrSplit = bVar.a.split(",");
                        if (strArrSplit.length > 0) {
                            for (String str : strArrSplit) {
                                if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(Build.MANUFACTURER)) {
                                    a = bVar;
                                    return;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.getMessage();
        }
    }

    public static Intent a(Context context, bp bpVar, String str, long j) {
        String strA;
        String[] strArrC;
        if (bpVar != null && bpVar.d()) {
            strArrC = bpVar.c();
            strA = bpVar.a();
        } else if (TextUtils.isEmpty(str) || !a(j)) {
            strA = null;
            strArrC = null;
        } else {
            String[] strArr = a.b;
            if (TextUtils.isEmpty(a.c)) {
                strArrC = strArr;
                strA = null;
            } else {
                Object[] objArr = {str};
                strArrC = strArr;
                strA = String.format(a.c, objArr);
            }
        }
        if (strArrC != null && strArrC.length != 0 && !TextUtils.isEmpty(strA)) {
            for (String str2 : strArrC) {
                if (!TextUtils.isEmpty(str2)) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strA));
                    intent.setPackage(str2);
                    intent.addFlags(268435456);
                    Intent intentA = a(context, intent);
                    if (intentA != null) {
                        return intentA;
                    }
                }
            }
        }
        return null;
    }

    public static boolean e() {
        return b(8L);
    }

    private static boolean b(long j) {
        if (j <= 0) {
            return false;
        }
        if (a == null) {
            d();
        }
        return a != null && a.d == j;
    }

    public static long b() {
        if (a == null) {
            d();
        }
        if (a == null) {
            return 0L;
        }
        return a.d;
    }

    /* compiled from: A */
    private static class b {
        public String a;
        public String[] b;
        public String c;
        public long d;

        private b() {
        }
    }

    public static String a(bp bpVar, String str) {
        if (bpVar != null && bpVar.d()) {
            return bpVar.a();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (a == null) {
            d();
        }
        if (a == null || TextUtils.isEmpty(a.c)) {
            return null;
        }
        return String.format(a.c, str);
    }

    public static boolean a(long j) {
        if (j <= 0) {
            return false;
        }
        if (a == null) {
            d();
        }
        return a != null && (j & a.d) > 0;
    }

    public static boolean a(bp bpVar, long j) {
        return (bpVar != null && bpVar.d()) || a(j);
    }

    public static boolean a(bp bpVar) {
        return bpVar != null && bpVar.d() && (((long) bpVar.b()) == 2 || ((long) bpVar.b()) == 256);
    }

    private static Intent a(Context context, Intent intent) {
        if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
            return intent;
        }
        return null;
    }
}
