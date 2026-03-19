package com.bykv.vk.openvk.component.video.api.an;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static String b = "";
    private static boolean d = false;
    private static int hc = 4;

    public static void d(int i) {
        hc = i;
    }

    public static void d() {
        d = true;
        d(3);
    }

    public static boolean hc() {
        return d;
    }

    public static void d(String str) {
        if (d) {
            d("Logger", str);
        }
    }

    public static void d(String str, String str2) {
        if (d && str2 != null && hc <= 4) {
            mq.d(b(str), str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (d) {
            if (!(str2 == null && th == null) && hc <= 4) {
                mq.d(b(str), str2, th);
            }
        }
    }

    public static void d(String str, Object... objArr) {
        if (d && objArr != null && hc <= 4) {
            b(str);
            d(objArr);
        }
    }

    public static void hc(String str, String str2) {
        if (d && str2 != null && hc <= 5) {
            mq.hc(b(str), str2);
        }
    }

    public static void hc(String str, String str2, Throwable th) {
        if (d) {
            if (!(str2 == null && th == null) && hc <= 5) {
                mq.hc(b(str), str2, th);
            }
        }
    }

    public static void hc(String str, Object... objArr) {
        if (d && objArr != null && hc <= 5) {
            b(str);
            d(objArr);
        }
    }

    public static void hc(String str) {
        if (d) {
            b("Logger", str);
        }
    }

    public static void b(String str, String str2) {
        if (d && str2 != null && hc <= 6) {
            mq.c(b(str), str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (d) {
            if (!(str2 == null && th == null) && hc <= 6) {
                mq.b(b(str), str2, th);
            }
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

    private static String b(String str) {
        return TextUtils.isEmpty(b) ? str : d("[" + b + "]-[" + str + "]");
    }
}
