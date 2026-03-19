package com.bytedance.dr.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import com.bytedance.bdtracker.f5;
import com.bytedance.dr.OaidApi;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class h implements OaidApi {
    public final f5<Boolean> a = new a(this);

    public class a extends f5<Boolean> {
        public a(h hVar) {
        }

        @Override // com.bytedance.bdtracker.f5
        public Boolean a(Object[] objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Throwable unused) {
            }
            return false;
        }
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Meizu";
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    @Override // com.bytedance.dr.OaidApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.dr.OaidApi.a getOaid(android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            android.content.ContentResolver r1 = r8.getContentResolver()
            r8 = 0
            java.lang.String r0 = "oaid"
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L42
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L42
            if (r0 != 0) goto L1e
            com.bytedance.bdtracker.l0.b.a(r0)
            return r8
        L1e:
            com.bytedance.dr.OaidApi$a r1 = new com.bytedance.dr.OaidApi$a     // Catch: java.lang.Throwable -> L40
            r1.<init>()     // Catch: java.lang.Throwable -> L40
            boolean r2 = r0.isClosed()     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L2b
        L29:
            r2 = r8
            goto L3a
        L2b:
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = "value"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L40
            if (r2 < 0) goto L29
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L40
        L3a:
            r1.a = r2     // Catch: java.lang.Throwable -> L40
            com.bytedance.bdtracker.l0.b.a(r0)
            return r1
        L40:
            r1 = move-exception
            goto L44
        L42:
            r1 = move-exception
            r0 = r8
        L44:
            com.bytedance.applog.log.IAppLogLogger r2 = com.bytedance.applog.log.LoggerImpl.global()     // Catch: java.lang.Throwable -> L55
            r3 = 1
            java.lang.String r4 = "getOaid failed"
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L55
            r2.error(r3, r4, r1, r5)     // Catch: java.lang.Throwable -> L55
            com.bytedance.bdtracker.l0.b.a(r0)
            return r8
        L55:
            r8 = move-exception
            com.bytedance.bdtracker.l0.b.a(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.dr.impl.h.getOaid(android.content.Context):com.bytedance.dr.OaidApi$a");
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        return this.a.b(context).booleanValue();
    }
}
