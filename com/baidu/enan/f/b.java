package com.baidu.enan.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.enan.e.b.a.g;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private static String a = "";

    public static void a(Throwable th) {
    }

    public static boolean a(Context context, String[] strArr) {
        if (strArr == null) {
            return true;
        }
        try {
            for (String str : strArr) {
                if (context.checkPermission(str, Process.myPid(), Process.myUid()) == -1) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            a.a(th);
            return false;
        }
    }

    public static File b(Context context) {
        try {
            return context.getFilesDir();
        } catch (Throwable th) {
            a.a(th);
            return null;
        }
    }

    public static String c(Context context) {
        String[] strArr;
        String[] strArr2;
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            String strD = d(context);
            a = strD;
            if (!TextUtils.isEmpty(strD)) {
                return a;
            }
        }
        if (TextUtils.isEmpty(a)) {
            String str = Build.CPU_ABI;
            a = str;
            if (!TextUtils.isEmpty(str)) {
                return a;
            }
        }
        if (i < 21 || !TextUtils.isEmpty(a)) {
            return "";
        }
        boolean zB = g.b();
        if (zB && (strArr2 = Build.SUPPORTED_64_BIT_ABIS) != null && strArr2.length > 0) {
            a = strArr2[0];
        } else if (!zB && (strArr = Build.SUPPORTED_32_BIT_ABIS) != null && strArr.length > 0) {
            a = strArr[0];
        }
        return !TextUtils.isEmpty(a) ? a : "";
    }

    private static String d(Context context) {
        ApplicationInfo applicationInfo;
        try {
            if (Build.VERSION.SDK_INT < 21 || (applicationInfo = context.getApplicationInfo()) == null) {
                return "";
            }
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            return (String) declaredField.get(applicationInfo);
        } catch (Throwable th) {
            a.a(th);
            return "";
        }
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }

    public static String a() {
        try {
            int iNextInt = new SecureRandom().nextInt();
            if (iNextInt > 0) {
                return "-" + iNextInt;
            }
            return String.valueOf(iNextInt);
        } catch (Throwable th) {
            a.a(th);
            return "-1";
        }
    }

    public static boolean a(File file) {
        File[] fileArrListFiles;
        if (file != null && file.exists()) {
            try {
                if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                    for (File file2 : fileArrListFiles) {
                        if (!a(file2)) {
                            return false;
                        }
                    }
                }
                return file.delete();
            } catch (Throwable th) {
                a.a(th);
            }
        }
        return false;
    }

    public static String a(String str) {
        try {
            return new String(Base64.decode(str, 0), StandardCharsets.UTF_8);
        } catch (Throwable th) {
            a(th);
            return "";
        }
    }
}
