package com.apm.insight.runtime;

import android.content.Context;
import com.apm.insight.ICommonParams;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    private Context a;
    private ICommonParams b;
    private ICommonParams c;

    public d(Context context, ICommonParams iCommonParams) {
        this(context, iCommonParams, null);
    }

    public d(Context context, ICommonParams iCommonParams, d dVar) {
        this.a = context;
        this.b = iCommonParams;
        this.c = dVar == null ? null : dVar.b;
    }

    public static String a(Map<String, Object> map, String str) {
        Object obj;
        if (map == null || (obj = map.get(str)) == null) {
            return null;
        }
        return String.valueOf(obj);
    }

    public static boolean a(Map<String, Object> map) {
        return map == null || map.isEmpty() || !((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code"));
    }

    public Map<String, Object> a() {
        Map<String, Object> mapB = b();
        if (a(mapB, "aid") == null) {
            mapB.put("aid", 4444);
        }
        return mapB;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.Object> b() {
        /*
            r8 = this;
            java.lang.String r0 = "version_name"
            java.lang.String r1 = "update_version_code"
            java.lang.String r2 = "version_code"
            r3 = 0
            com.apm.insight.ICommonParams r4 = r8.c     // Catch: java.lang.Throwable -> L28
            if (r4 == 0) goto L13
            java.util.Map r4 = r4.getCommonParams()     // Catch: java.lang.Throwable -> L28
            goto L18
        L13:
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> L28
            r4.<init>()     // Catch: java.lang.Throwable -> L28
        L18:
            com.apm.insight.ICommonParams r5 = r8.b     // Catch: java.lang.Throwable -> L23
            java.util.Map r5 = r5.getCommonParams()     // Catch: java.lang.Throwable -> L23
            r4.putAll(r5)     // Catch: java.lang.Throwable -> L23
            r5 = r3
            goto L2d
        L23:
            r5 = move-exception
            r7 = r5
            r5 = r4
            r4 = r7
            goto L2a
        L28:
            r4 = move-exception
            r5 = r3
        L2a:
            r7 = r5
            r5 = r4
            r4 = r7
        L2d:
            if (r4 != 0) goto L40
            java.util.HashMap r4 = new java.util.HashMap
            r6 = 4
            r4.<init>(r6)
            if (r5 == 0) goto L40
            java.lang.String r6 = "err_info"
            java.lang.String r5 = com.apm.insight.o.v.a(r5)     // Catch: java.lang.Throwable -> L40
            r4.put(r6, r5)     // Catch: java.lang.Throwable -> L40
        L40:
            boolean r5 = a(r4)
            if (r5 == 0) goto La2
            android.content.Context r5 = r8.a     // Catch: java.lang.Throwable -> L7e
            java.lang.String r6 = r5.getPackageName()     // Catch: java.lang.Throwable -> L7e
            android.content.pm.PackageInfo r5 = com.bytedance.apm.common.utility.PackageUtils.getPackageInfo(r5, r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r6 = r5.versionName     // Catch: java.lang.Throwable -> L7e
            r4.put(r0, r6)     // Catch: java.lang.Throwable -> L7e
            int r6 = r5.versionCode     // Catch: java.lang.Throwable -> L7e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L7e
            r4.put(r2, r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r6 = r4.get(r1)     // Catch: java.lang.Throwable -> L7e
            if (r6 != 0) goto Lde
            android.content.pm.ApplicationInfo r6 = r5.applicationInfo     // Catch: java.lang.Throwable -> L7e
            android.os.Bundle r6 = r6.metaData     // Catch: java.lang.Throwable -> L7e
            if (r6 == 0) goto L74
            android.content.pm.ApplicationInfo r3 = r5.applicationInfo     // Catch: java.lang.Throwable -> L7e
            android.os.Bundle r3 = r3.metaData     // Catch: java.lang.Throwable -> L7e
            java.lang.String r5 = "UPDATE_VERSION_CODE"
            java.lang.Object r3 = r3.get(r5)     // Catch: java.lang.Throwable -> L7e
        L74:
            if (r3 != 0) goto L7a
            java.lang.Object r3 = r4.get(r2)     // Catch: java.lang.Throwable -> L7e
        L7a:
            r4.put(r1, r3)     // Catch: java.lang.Throwable -> L7e
            goto Lde
        L7e:
            android.content.Context r3 = r8.a
            java.lang.String r3 = com.apm.insight.o.a.d(r3)
            r4.put(r0, r3)
            android.content.Context r0 = r8.a
            int r0 = com.apm.insight.o.a.e(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4.put(r2, r0)
            java.lang.Object r0 = r4.get(r1)
            if (r0 != 0) goto Lde
            java.lang.Object r0 = r4.get(r2)
            r4.put(r1, r0)
            goto Lde
        La2:
            android.content.Context r0 = r8.a     // Catch: java.lang.Throwable -> Lde
            java.lang.String r0 = com.bytedance.apm.common.utility.PackageUtils.getVersionName(r0)     // Catch: java.lang.Throwable -> Lde
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lde
            r1.<init>()     // Catch: java.lang.Throwable -> Lde
            android.content.Context r2 = r8.a     // Catch: java.lang.Throwable -> Lde
            java.lang.String r2 = r2.getPackageName()     // Catch: java.lang.Throwable -> Lde
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r2 = ".BuildConfig"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lde
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r2 = "VERSION_NAME"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch: java.lang.Throwable -> Lde
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> Lde
            if (r0 == 0) goto Lde
            boolean r1 = r0.equals(r1)     // Catch: java.lang.Throwable -> Lde
            if (r1 != 0) goto Lde
            java.lang.String r1 = "manifest_version"
            r4.put(r1, r0)     // Catch: java.lang.Throwable -> Lde
        Lde:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.runtime.d.b():java.util.Map");
    }

    public ICommonParams c() {
        return this.b;
    }

    public String d() {
        try {
            return this.b.getDeviceId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String e() {
        try {
            return String.valueOf(this.b.getCommonParams().get("aid"));
        } catch (Throwable unused) {
            return "4444";
        }
    }

    public long f() {
        try {
            return this.b.getUserId();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
