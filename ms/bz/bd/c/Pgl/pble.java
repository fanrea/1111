package ms.bz.bd.c.Pgl;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.ArrayMap;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pble {
    private static volatile int d = -1;
    private static volatile String hc = "";

    public static int d(Context context) {
        if (d <= 0) {
            try {
                d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Throwable unused) {
            }
        }
        return d;
    }

    public static Activity d() throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "41fbe3", new byte[]{36, 61, 17, 4, 85, 45, com.sigmob.sdk.archives.tar.e.f789K, 94, com.sigmob.sdk.archives.tar.e.N, 34, com.sigmob.sdk.archives.tar.e.M, 125, com.sigmob.sdk.archives.tar.e.L, 21, 78, 45, 33, 25, 35, 43, 17, 59, 7, 19, 91, 32}));
            Object objInvoke = cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "16e3d0", new byte[]{35, 33, 4, 85, 94, 41, 38, com.sigmob.sdk.archives.tar.e.N, com.sigmob.sdk.archives.tar.e.O, 119, 41, 34, 31, com.sigmob.sdk.archives.tar.e.Q, 66, 19, 58, 5, com.sigmob.sdk.archives.tar.e.I, 98, 36}), new Class[0]).invoke(null, new Object[0]);
            if (objInvoke == null) {
                int i = Build.VERSION.SDK_INT;
            }
            Field declaredField = cls.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b1b05a", new byte[]{126, 18, 18, 80, 3, 96, 104, 4, 58, 101, 96}));
            declaredField.setAccessible(true);
            Map map = Build.VERSION.SDK_INT < 19 ? (HashMap) declaredField.get(objInvoke) : (ArrayMap) declaredField.get(objInvoke);
            if (map.size() <= 0) {
                return null;
            }
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "604944", new byte[]{com.sigmob.sdk.archives.tar.e.O, com.sigmob.sdk.archives.tar.e.f789K, 82, 94, 14, 39}));
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e96982", new byte[]{117, 56, 81, 68, 17, 44, 114, 1}));
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
            return null;
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "422625", new byte[]{36, 57, 126, 69});
            return null;
        }
    }

    public static String hc(Context context) {
        try {
            if (hc == "") {
                hc = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Throwable unused) {
        }
        return hc;
    }
}
