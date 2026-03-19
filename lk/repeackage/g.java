package lk.repeackage;

import android.content.Context;
import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class g {
    public static d a;

    public static String a(String str, String str2) throws ClassNotFoundException {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            f.a("System property invoke error: " + e);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0025 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r3, java.lang.String r4) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            java.lang.String r0 = "ApkUtil"
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            r2 = 0
            if (r1 == 0) goto La
            goto L21
        La:
            if (r3 == 0) goto L21
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch: java.lang.Exception -> L19 android.content.pm.PackageManager.NameNotFoundException -> L1c
            if (r3 == 0) goto L21
            r1 = 128(0x80, float:1.8E-43)
            android.content.pm.PackageInfo r2 = r3.getPackageInfo(r4, r1)     // Catch: java.lang.Exception -> L19 android.content.pm.PackageManager.NameNotFoundException -> L1c
            goto L21
        L19:
            java.lang.String r3 = "getPackageInfo Exception"
            goto L1e
        L1c:
            java.lang.String r3 = "getPackageInfo NameNotFoundException"
        L1e:
            android.util.Log.w(r0, r3)
        L21:
            if (r2 == 0) goto L25
            r3 = 1
            goto L26
        L25:
            r3 = 0
        L26:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: lk.repeackage.g.a(android.content.Context, java.lang.String):boolean");
    }

    public static d b(Context context) {
        if (!Build.BRAND.equalsIgnoreCase("HONOR")) {
            return null;
        }
        m mVar = new m(context);
        if (mVar.a()) {
            return mVar;
        }
        return null;
    }

    public static String c(Context context) {
        return a(context, "com.huawei.hwid") ? "com.huawei.hwid" : a(context, "com.huawei.hms") ? "com.huawei.hms" : a(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static lk.repeackage.d a(android.content.Context r7) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 682
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lk.repeackage.g.a(android.content.Context):lk.repeackage.d");
    }
}
