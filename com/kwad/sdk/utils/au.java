package com.kwad.sdk.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import com.permissionx.guolindev.request.RequestInstallPackagesPermission;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class au {
    private static Map<String, Integer> cmF;
    private static Set<String> cmG;
    private static Method cmH;

    static {
        HashSet hashSet = new HashSet();
        cmG = hashSet;
        hashSet.add(RequestInstallPackagesPermission.REQUEST_INSTALL_PACKAGES);
        cmG.add("android.permission.WRITE_SETTINGS");
        cmG.add("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int aI(Context context, String str) throws NoSuchMethodException, SecurityException {
        int iAJ;
        if (cmF == null) {
            j(y.dl(context));
        }
        if (cmG.contains(str) && (iAJ = aJ(context, str)) != -2) {
            return iAJ;
        }
        int iAK = aK(context, str);
        if (iAK != -2) {
            return iAK;
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            return iAK;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int aJ(android.content.Context r3, java.lang.String r4) {
        /*
            r4.hashCode()
            int r0 = r4.hashCode()
            r1 = 0
            r2 = -1
            switch(r0) {
                case -2078357533: goto L24;
                case -1561629405: goto L19;
                case 1777263169: goto Le;
                default: goto Lc;
            }
        Lc:
            r4 = r2
            goto L2e
        Le:
            java.lang.String r0 = "android.permission.REQUEST_INSTALL_PACKAGES"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L17
            goto Lc
        L17:
            r4 = 2
            goto L2e
        L19:
            java.lang.String r0 = "android.permission.SYSTEM_ALERT_WINDOW"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L22
            goto Lc
        L22:
            r4 = 1
            goto L2e
        L24:
            java.lang.String r0 = "android.permission.WRITE_SETTINGS"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L2d
            goto Lc
        L2d:
            r4 = r1
        L2e:
            r0 = 23
            switch(r4) {
                case 0: goto L53;
                case 1: goto L43;
                case 2: goto L34;
                default: goto L33;
            }
        L33:
            goto L5e
        L34:
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r4 < r0) goto L5e
            boolean r3 = com.kwad.sdk.utils.y.dk(r3)
            if (r3 == 0) goto L41
            goto L5f
        L41:
            r1 = r2
            goto L5f
        L43:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r0) goto L5e
            boolean r3 = android.provider.Settings.canDrawOverlays(r3)     // Catch: java.lang.Throwable -> L4e
            if (r3 == 0) goto L41
            goto L5f
        L4e:
            r3 = move-exception
            com.kwad.sdk.core.d.c.printStackTraceOnly(r3)
            goto L5e
        L53:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r0) goto L5e
            boolean r3 = android.provider.Settings.System.canWrite(r3)     // Catch: java.lang.Throwable -> L5e
            if (r3 == 0) goto L41
            goto L5f
        L5e:
            r1 = -2
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.utils.au.aJ(android.content.Context, java.lang.String):int");
    }

    private static int aK(Context context, String str) throws NoSuchMethodException, SecurityException {
        if (cmF == null || str == null) {
            return -2;
        }
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        if (!cmF.containsKey(str)) {
            return -2;
        }
        try {
            Integer num = cmF.get(str);
            if (num == null) {
                return -2;
            }
            if (cmH == null) {
                Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class);
                cmH = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return ((Integer) cmH.invoke((AppOpsManager) context.getSystemService("appops"), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }

    private static void j(String[] strArr) {
        if (Build.VERSION.SDK_INT < 19 || strArr == null) {
            return;
        }
        cmF = new HashMap();
        for (String str : strArr) {
            try {
                int iIntValue = ((Integer) z.c(AppOpsManager.class, "OP_" + iz(str))).intValue();
                if (iIntValue >= 0) {
                    cmF.put(str, Integer.valueOf(iIntValue));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String iz(String str) {
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(iLastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean ec(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled");
        } catch (Throwable unused) {
            i = 0;
        }
        return i == 1;
    }
}
