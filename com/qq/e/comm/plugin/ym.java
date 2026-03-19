package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.permissionx.guolindev.request.RequestInstallPackagesPermission;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ym {
    private static Boolean a;

    private static boolean b(Context context) throws PackageManager.NameNotFoundException {
        String[] strArr;
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            strArr = packageInfo != null ? packageInfo.requestedPermissions : null;
        } catch (Exception unused) {
            a = Boolean.TRUE;
        }
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (RequestInstallPackagesPermission.REQUEST_INSTALL_PACKAGES.equals(str)) {
                    a = Boolean.TRUE;
                    return true;
                }
            }
            a = Boolean.FALSE;
            return a.booleanValue();
        }
        a = Boolean.TRUE;
        return true;
    }

    public static boolean c() {
        int iA = a();
        return iA == 1 || iA == 3;
    }

    public static boolean b() {
        return a() == 1;
    }

    private static boolean a(Context context) {
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Exception unused) {
            return false;
        }
    }

    public static final int a() {
        Context contextA = r1.d().a();
        if (Build.VERSION.SDK_INT < 26) {
            return 1;
        }
        if (b(contextA)) {
            return a(contextA) ? 1 : 2;
        }
        return 3;
    }
}
