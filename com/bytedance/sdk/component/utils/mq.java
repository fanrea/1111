package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mq {
    private static com.bytedance.sdk.component.d b = null;
    private static String c = "";
    private static boolean d = false;
    private static int hc = 4;

    public static void d(com.bytedance.sdk.component.d dVar) {
        b = dVar;
    }

    public static void d(int i) {
        hc = i;
    }

    public static boolean d() {
        return hc <= 3;
    }

    public static void hc() {
        d = true;
        d(3);
    }

    public static boolean b() {
        return d;
    }

    public static void d(String str) {
        if (d) {
            d("Logger", str);
        }
    }

    public static void d(String str, String str2) {
        com.bytedance.sdk.component.d dVar = b;
        if (dVar != null) {
            dVar.d(c(str), str2);
        }
        if (d && str2 != null && hc <= 4) {
            Log.i(c(str), str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.d dVar = b;
        if (dVar != null) {
            dVar.d(c(str), str2 + Log.getStackTraceString(th));
        }
        if (d) {
            if (!(str2 == null && th == null) && hc <= 4) {
                Log.i(c(str), str2, th);
            }
        }
    }

    public static void d(String str, Object... objArr) {
        com.bytedance.sdk.component.d dVar = b;
        if (dVar != null) {
            dVar.d(c(str), d(objArr));
        }
        if (d && objArr != null && hc <= 4) {
            Log.i(c(str), d(objArr));
        }
    }

    public static void hc(String str) {
        if (d) {
            hc("Logger", str);
        }
    }

    public static void hc(String str, String str2) {
        com.bytedance.sdk.component.d dVar = b;
        if (dVar != null) {
            dVar.hc(c(str), str2);
        }
        if (d && str2 != null && hc <= 5) {
            Log.w(c(str), str2);
        }
    }

    public static void hc(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.d dVar = b;
        if (dVar != null) {
            dVar.d(c(str), str2, th);
        }
        if (d) {
            if (!(str2 == null && th == null) && hc <= 5) {
                Log.w(c(str), str2, th);
            }
        }
    }

    public static void hc(String str, Object... objArr) {
        com.bytedance.sdk.component.d dVar = b;
        if (dVar != null) {
            dVar.hc(c(str), d(objArr));
        }
        if (d && objArr != null && hc <= 5) {
            Log.w(c(str), d(objArr));
        }
    }

    public static void b(String str, String str2) {
        com.bytedance.sdk.component.d dVar = b;
        if (dVar != null) {
            dVar.d(c(str), str2);
        }
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = "Logger";
        }
        Log.i(c(str), str2);
    }

    public static void b(String str) {
        if (d) {
            c("Logger", str);
        }
    }

    public static void c(String str, String str2) {
        com.bytedance.sdk.component.d dVar = b;
        if (dVar != null) {
            dVar.b(c(str), str2);
        }
        if (d && str2 != null && hc <= 6) {
            Log.e(c(str), str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        com.bytedance.sdk.component.d dVar = b;
        if (dVar != null) {
            dVar.hc(c(str), str2, th);
        }
        if (d) {
            if (!(str2 == null && th == null) && hc <= 6) {
                Log.e(c(str), str2, th);
            }
        }
    }

    public static void b(String str, Object... objArr) {
        com.bytedance.sdk.component.d dVar = b;
        if (dVar != null) {
            dVar.b(c(str), d(objArr));
        }
        if (d && objArr != null && hc <= 6) {
            Log.e(c(str), d(objArr));
        }
    }

    private static String d(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String c(String str) {
        return TextUtils.isEmpty(c) ? str : d("[" + c + "]-[" + str + "]");
    }

    public static void d(Throwable th) {
        hc(c, "", th);
    }

    public static void d(int i, String str, String str2) {
        d(str, str2);
    }
}
