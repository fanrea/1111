package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.os.Process;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.extends, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cextends {
    public static final String a = Cfinally.a(Cfinally.b);
    public static final String b = Cfinally.a(Cfinally.c);
    public static final String c = Cfinally.a(Cfinally.d);
    public static final String d = Cfinally.a(Cfinally.e);
    public static final String e = Cfinally.a(Cfinally.f);
    public static long f = 0;
    public static final String[] g = {"^/data/user/\\d+$", "^/data/data$"};

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.extends$do, reason: invalid class name */
    public static class Cdo {
        public final boolean a;
        public final String b;

        public Cdo(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            java.lang.String r2 = "_"
            r1.append(r2)
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            r3 = 0
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo(r5, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1b
            java.lang.String r4 = r4.sourceDir     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L1b
            goto L1c
        L1b:
            r4 = r0
        L1c:
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L31
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L31
            java.util.List r5 = com.tencent.turingfd.sdk.ams.au.Virgo.a(r5)     // Catch: java.lang.Throwable -> L31
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch: java.lang.Throwable -> L31
            java.lang.Object r5 = r5.get(r3)     // Catch: java.lang.Throwable -> L31
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L31
            r1.append(r5)     // Catch: java.lang.Throwable -> L31
            goto L34
        L31:
            r1.append(r0)
        L34:
            r1.append(r2)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L4d
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            boolean r4 = r5.exists()
            if (r4 == 0) goto L4d
            long r4 = r5.length()
            goto L4f
        L4d:
            r4 = -1
        L4f:
            r1.append(r4)
            r1.append(r2)
            int r4 = android.os.Process.myUid()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Cextends.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String b(Context context) {
        Method method;
        try {
            Class<?> cls = Class.forName("android.os.UserManager");
            Field field = context.getClass().getField("USER_SERVICE");
            field.setAccessible(true);
            Object systemService = context.getSystemService((String) field.get(context));
            if (systemService == null || (method = cls.getMethod("getUserName", new Class[0])) == null) {
                return "";
            }
            method.setAccessible(true);
            return (String) method.invoke(systemService, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        try {
            return 999 == Process.myUid() / KSTubeParamInner.FREE_ALL;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0199, code lost:
    
        r13 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03f5 A[LOOP:0: B:180:0x03ef->B:182:0x03f5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01be  */
    /* JADX WARN: Type inference failed for: r0v52, types: [com.tencent.turingfd.sdk.ams.au.extends$do] */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r0v65 */
    /* JADX WARN: Type inference failed for: r7v14, types: [com.tencent.turingfd.sdk.ams.au.extends$do] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x032c -> B:162:0x032d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r17) {
        /*
            Method dump skipped, instructions count: 1056
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Cextends.a(android.content.Context):java.lang.String");
    }
}
