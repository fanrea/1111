package ca.da.da;

import android.content.Context;
import android.content.pm.PackageManager;

/* compiled from: MeizuOaidImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class k implements n {
    public b<Boolean> a = new a(this);

    /* compiled from: MeizuOaidImpl.java */
    public class a extends b<Boolean> {
        public a(k kVar) {
        }

        @Override // ca.da.da.b
        public Boolean a(Object[] objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    @Override // ca.da.da.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ca.da.da.n.a a(android.content.Context r8) {
        /*
            r7 = this;
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            android.content.ContentResolver r1 = r8.getContentResolver()
            r8 = 0
            java.lang.String r0 = "oaid"
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L45
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L45
            if (r0 != 0) goto L20
            if (r0 == 0) goto L1f
            r0.close()
        L1f:
            return r8
        L20:
            ca.da.da.n$a r1 = new ca.da.da.n$a     // Catch: java.lang.Throwable -> L43
            r1.<init>()     // Catch: java.lang.Throwable -> L43
            boolean r2 = r0.isClosed()     // Catch: java.lang.Throwable -> L43
            if (r2 == 0) goto L2d
        L2b:
            r2 = r8
            goto L3d
        L2d:
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L43
            java.lang.String r2 = "value"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L43
            if (r2 < 0) goto L2b
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L43
        L3d:
            r1.a = r2     // Catch: java.lang.Throwable -> L43
            r0.close()
            return r1
        L43:
            r1 = move-exception
            goto L47
        L45:
            r1 = move-exception
            r0 = r8
        L47:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L4f
            r0.close()
        L4f:
            return r8
        L50:
            r8 = move-exception
            if (r0 == 0) goto L56
            r0.close()
        L56:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.da.k.a(android.content.Context):ca.da.da.n$a");
    }

    @Override // ca.da.da.n
    public boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return this.a.b(context).booleanValue();
    }
}
