package com.alipay.sdk.m.i0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f {
    public static volatile f g = null;
    public static boolean h = false;
    public BroadcastReceiver f;
    public a a = new a("udid");
    public a b = new a("oaid");
    public a d = new a("vaid");
    public a c = new a("aaid");
    public c e = new c();

    public static d a(Cursor cursor) {
        String str;
        d dVar = new d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(com.alipay.sdk.m.p0.b.d);
                if (columnIndex >= 0) {
                    dVar.a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    dVar.b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    dVar.c = cursor.getLong(columnIndex3);
                } else {
                    a("parseExpired fail, index < 0.");
                }
                return dVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return dVar;
    }

    public static final f a() {
        if (g == null) {
            synchronized (f.class) {
                if (g == null) {
                    g = new f();
                }
            }
        }
        return g;
    }

    public static String a(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    public static void a(String str) {
        if (h) {
            Log.d("OpenIdManager", str);
        }
    }

    public static void a(boolean z) {
        h = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r3 = 0
            r4 = 0
            java.lang.String r8 = "supported"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r7 == 0) goto L3d
            com.alipay.sdk.m.i0.d r8 = a(r7)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r8.b     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r1 != r2) goto L36
            java.lang.String r1 = "0"
            java.lang.String r8 = r8.a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            boolean r8 = r1.equals(r8)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r8 == 0) goto L37
        L36:
            r0 = 1
        L37:
            if (r7 == 0) goto L3c
            r7.close()
        L3c:
            return r0
        L3d:
            if (r7 == 0) goto L5f
            goto L5c
        L40:
            r8 = move-exception
            goto L60
        L42:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L40
            java.lang.StringBuilder r8 = r1.append(r8)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L40
            a(r8)     // Catch: java.lang.Throwable -> L40
            if (r7 == 0) goto L5f
        L5c:
            r7.close()
        L5f:
            return r0
        L60:
            if (r7 == 0) goto L65
            r7.close()
        L65:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.i0.f.a(android.content.Context):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.content.Context r10, com.alipay.sdk.m.i0.a r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.c
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            a(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            r3 = 0
            r4 = 0
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            java.lang.String r6 = r11.c     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            r8 = 0
            r5[r8] = r6     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La0
            if (r1 == 0) goto L80
            com.alipay.sdk.m.i0.d r2 = a(r1)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String r0 = r2.a     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            r11.a(r0)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            long r3 = r2.c     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            r11.a(r3)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            int r3 = r2.b     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            r11.a(r3)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            r3.<init>()     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String r4 = r11.c     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String r4 = " errorCode : "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            int r11 = r11.d     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.StringBuilder r11 = r3.append(r11)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            a(r11)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            int r11 = r2.b     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L94
            r9.b(r10)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            boolean r11 = r9.a(r10, r8)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            if (r11 != 0) goto L94
            boolean r10 = r9.a(r10, r7)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String r11 = "not support, forceQuery isSupported: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
        L7b:
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            goto L91
        L80:
            boolean r11 = r9.a(r10, r8)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            if (r11 == 0) goto L94
            boolean r10 = r9.a(r10, r7)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            java.lang.String r11 = "forceQuery isSupported : "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
            goto L7b
        L91:
            a(r10)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L9a
        L94:
            if (r1 == 0) goto Lc2
            goto Lbd
        L97:
            r10 = move-exception
            r0 = r1
            goto Lc3
        L9a:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto La2
        L9e:
            r10 = move-exception
            goto Lc3
        La0:
            r10 = move-exception
            r11 = r0
        La2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L9e
            java.lang.StringBuilder r10 = r1.append(r10)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L9e
            a(r10)     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto Lc1
            r1 = r0
            r0 = r11
        Lbd:
            r1.close()
            goto Lc2
        Lc1:
            r0 = r11
        Lc2:
            return r0
        Lc3:
            if (r0 == 0) goto Lc8
            r0.close()
        Lc8:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.i0.f.b(android.content.Context, com.alipay.sdk.m.i0.a):java.lang.String");
    }

    public static String b(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            a("getAppVersion, Exception : " + e.getMessage());
            return null;
        }
    }

    private synchronized void b(Context context) {
        if (this.f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        e eVar = new e();
        this.f = eVar;
        context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    public final String a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else {
            if (aVar.a()) {
                return aVar.b;
            }
            if (a(context, true)) {
                return b(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    public final boolean a(Context context, boolean z) throws PackageManager.NameNotFoundException {
        if (this.e.a() && !z) {
            return this.e.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strA = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String strB = b(packageManager, strA);
        if (this.e.a() && this.e.a(strB)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(strB)));
            return this.e.b();
        }
        this.e.b(strB);
        boolean zA = a(context);
        a("query support, result : ".concat(String.valueOf(zA)));
        this.e.a(zA);
        return zA;
    }
}
