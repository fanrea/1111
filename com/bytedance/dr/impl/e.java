package com.bytedance.dr.impl;

import android.content.Context;
import com.bytedance.bdtracker.f5;
import com.bytedance.bdtracker.t4;
import com.bytedance.dr.OaidApi;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class e implements OaidApi {
    public static final f5<Boolean> b = new a();
    public String a;

    public static class a extends f5<Boolean> {
        @Override // com.bytedance.bdtracker.f5
        public Boolean a(Object[] objArr) {
            Context context = (Context) objArr[0];
            return Boolean.valueOf((t4.a(context, "com.huawei.hwid") || t4.a(context, "com.huawei.hwid.tv")) ? true : t4.a(context, "com.huawei.hms"));
        }
    }

    public static class b extends OaidApi.a {
        public long c = 0;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return b.b(context).booleanValue();
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Huawei";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    @Override // com.bytedance.dr.OaidApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.dr.OaidApi.a getOaid(android.content.Context r8) {
        /*
            r7 = this;
            com.bytedance.dr.impl.e$b r0 = new com.bytedance.dr.impl.e$b
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 0
            r4 = 24
            if (r1 < r4) goto L43
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L37
            java.lang.String r4 = "pps_oaid"
            java.lang.String r1 = android.provider.Settings.Global.getString(r1, r4)     // Catch: java.lang.Throwable -> L37
            android.content.ContentResolver r4 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L37
            java.lang.String r5 = "pps_track_limit"
            java.lang.String r4 = android.provider.Settings.Global.getString(r4, r5)     // Catch: java.lang.Throwable -> L37
            boolean r5 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L37
            if (r5 != 0) goto L43
            r0.a = r1     // Catch: java.lang.Throwable -> L37
            boolean r1 = java.lang.Boolean.parseBoolean(r4)     // Catch: java.lang.Throwable -> L37
            r0.b = r1     // Catch: java.lang.Throwable -> L37
            r4 = 202003021704(0x2f08517f88, double:9.980275338E-313)
            r0.c = r4     // Catch: java.lang.Throwable -> L37
            goto L96
        L37:
            r1 = move-exception
            com.bytedance.applog.log.IAppLogLogger r4 = com.bytedance.applog.log.LoggerImpl.global()
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.String r6 = "getOaid failed"
            r4.error(r2, r6, r1, r5)
        L43:
            java.lang.String r1 = r7.a
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L4d
            r1 = 0
            goto L6a
        L4d:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r4 = "com.uodis.opendevice.OPENIDS_SERVICE"
            r1.<init>(r4)
            java.lang.String r4 = r7.a
            android.content.Intent r1 = r1.setPackage(r4)
            com.bytedance.bdtracker.n5 r4 = new com.bytedance.bdtracker.n5
            com.bytedance.dr.impl.f r5 = new com.bytedance.dr.impl.f
            r5.<init>(r7)
            r4.<init>(r8, r1, r5)
            java.lang.Object r1 = r4.a()
            android.util.Pair r1 = (android.util.Pair) r1
        L6a:
            if (r1 == 0) goto L96
            java.lang.Object r4 = r1.first
            java.lang.String r4 = (java.lang.String) r4
            r0.a = r4
            java.lang.Object r1 = r1.second
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0.b = r1
            java.lang.String r1 = r7.a
            android.content.pm.PackageInfo r8 = com.bytedance.bdtracker.t4.a(r8, r1, r3)     // Catch: java.lang.Throwable -> L87
            if (r8 == 0) goto L93
            int r3 = r8.versionCode     // Catch: java.lang.Throwable -> L87
            goto L93
        L87:
            r8 = move-exception
            com.bytedance.applog.log.IAppLogLogger r1 = com.bytedance.applog.log.LoggerImpl.global()
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.String r5 = "getHwIdVersionCode failed"
            r1.error(r2, r5, r8, r4)
        L93:
            long r1 = (long) r3
            r0.c = r1
        L96:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.dr.impl.e.getOaid(android.content.Context):com.bytedance.dr.OaidApi$a");
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        String str = "com.huawei.hwid";
        if (!t4.a(context, "com.huawei.hwid")) {
            str = "com.huawei.hwid.tv";
            if (!t4.a(context, "com.huawei.hwid.tv")) {
                this.a = "com.huawei.hms";
                return t4.a(context, "com.huawei.hms");
            }
        }
        this.a = str;
        return true;
    }
}
