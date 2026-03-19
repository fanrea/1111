package com.bytedance.msdk.core.mq;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import com.kuaishou.weapon.p0.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static final String d = "hc";

    public static boolean d(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return hc(context, str);
        }
        return b(context, str);
    }

    private static boolean hc(Context context, String str) {
        String lowerCase;
        String str2 = d;
        com.bytedance.msdk.d.u.b.c(str2, "checkPermissinKITKATNew，permission：".concat(String.valueOf(str)));
        char c = 65535;
        boolean z = false;
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != -1888586689) {
                if (iHashCode != -63024214) {
                    if (iHashCode == -5573545 && str.equals("android.permission.READ_PHONE_STATE")) {
                        c = 2;
                    }
                } else if (str.equals(g.h)) {
                    c = 0;
                }
            } else if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                c = 1;
            }
            if (c == 0) {
                lowerCase = "android:coarse_location";
            } else if (c != 1) {
                lowerCase = c != 2 ? str.replaceFirst("android.permission.", "android:").toLowerCase() : "android:read_phone_state";
            } else {
                lowerCase = "android:fine_location";
            }
            int iCheckOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(lowerCase, Binder.getCallingUid(), context.getPackageName());
            com.bytedance.msdk.d.u.b.c(str2, "checkPermissinKITKATNew，locationOp,permission：" + iCheckOp + "," + lowerCase);
            if (iCheckOp == 0) {
                return true;
            }
            try {
                com.bytedance.msdk.d.u.b.c(str2, "checkPermissinKITKATNew，false,permission：".concat(String.valueOf(lowerCase)));
                return false;
            } catch (Exception e) {
                e = e;
                com.bytedance.msdk.d.u.b.c(d, "权限检查出错时默认返回有权限，异常代码：".concat(String.valueOf(e)));
                return z;
            }
        } catch (Exception e2) {
            e = e2;
            z = true;
        }
    }

    private static boolean b(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
