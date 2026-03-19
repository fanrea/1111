package com.baidu.enan.e.a.d;

import android.content.Context;
import android.os.Binder;
import android.text.TextUtils;
import com.baidu.enan.f.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a(Context context) {
        try {
            return String.valueOf(b(context));
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    private static int b(Context context) {
        String strC;
        String[] strArr;
        int callingUid;
        int length;
        try {
            strC = c(context);
            strArr = new String[2];
            try {
                callingUid = Binder.getCallingUid();
            } catch (Throwable th) {
                b.a(th);
                callingUid = 0;
            }
            length = String.valueOf(callingUid).length();
        } catch (Throwable th2) {
            b.a(th2);
        }
        if (a(strArr) && a(strC) && length < 6) {
            return 1;
        }
        if (!(a(strArr) && a(strC)) && length >= 6) {
            return 2;
        }
        if (a(strArr)) {
            if (a(strC) && length >= 6) {
                return 3;
            }
        }
        return 0;
    }

    private static String c(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass(b.a("YW5kcm9pZC5vcy5TZXJ2aWNlTWFuYWdlcg=="));
            if (clsLoadClass == null) {
                return null;
            }
            return clsLoadClass.getMethod(b.a("Z2V0U2VydmljZQ=="), String.class).invoke(clsLoadClass.newInstance(), b.a("cGhvbmU=")).getClass().getCanonicalName();
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    private static boolean a(String str) {
        try {
        } catch (Throwable th) {
            b.a(th);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !b.a("YW5kcm9pZC5vcy5CaW5kZXJQcm94eQ==").equals(str);
    }

    private static boolean a(String[] strArr) {
        String strA;
        String strA2;
        if (strArr == null) {
            return false;
        }
        try {
            strA = b.a("YW5kcm9pZC5hcHAuSW5zdHJ1bWVudGF0aW9u");
            strA2 = b.a("YW5kcm9pZC5hcHAuQWN0aXZpdHlNYW5hZ2VyUHJveHk=");
        } catch (Throwable th) {
            b.a(th);
        }
        if (strArr[0] != null && !strA.equals(strArr[0])) {
            return true;
        }
        if (strArr[1] != null) {
            if (!strA2.equals(strArr[1])) {
                return true;
            }
        }
        return false;
    }
}
