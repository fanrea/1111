package com.android.gdt.qone.j;

import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c {
    public static volatile c g;
    public Boolean e;
    public a f;
    public final b a = new b("udid");
    public final b b = new b("oaid");
    public final b d = new b("vaid");
    public final b c = new b("aaid");

    public static d a(Cursor cursor) {
        d dVar = new d();
        if (cursor == null) {
            b("parseValue fail, cursor is null.");
        } else if (cursor.isClosed()) {
            b("parseValue fail, cursor is closed.");
        } else {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(com.alipay.sdk.m.p0.b.d);
            if (columnIndex >= 0) {
                dVar.c = cursor.getString(columnIndex);
            } else {
                b("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                dVar.a = cursor.getInt(columnIndex2);
            } else {
                b("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                dVar.b = cursor.getLong(columnIndex3);
            } else {
                b("parseExpired fail, index < 0.");
            }
        }
        return dVar;
    }

    public static void b(String str) {
        com.android.gdt.qone.af.b.c("MzOpenIdManager " + str);
    }

    public final String a(Context context, b bVar) throws Throwable {
        Cursor cursorQuery;
        if (bVar.b > System.currentTimeMillis()) {
            return bVar.d;
        }
        b("queryId : ".concat(bVar.c));
        Cursor cursor = null;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{bVar.c}, null);
        } catch (Exception unused) {
            cursorQuery = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cursorQuery == null) {
                try {
                    a(context, false);
                    b("forceQuery isSupported : " + a(context, true));
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                } catch (Exception unused2) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            }
            try {
                d dVarA = a(cursorQuery);
                String str = dVarA.c;
                try {
                    bVar.d = str;
                    bVar.b = dVarA.b;
                    bVar.a = dVarA.a;
                    b(bVar.c + " errorCode : " + bVar.a);
                    if (dVarA.a == 1000) {
                        cursorQuery.close();
                        return str;
                    }
                    a(context);
                    if (a(context, false)) {
                        cursorQuery.close();
                        return str;
                    }
                    b("not support, forceQuery isSupported: " + a(context, true));
                    cursorQuery.close();
                    return str;
                } catch (Exception unused3) {
                    cursorQuery.close();
                    return null;
                }
            } catch (Exception unused4) {
                cursorQuery.close();
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0084 A[PHI: r1
  0x0084: PHI (r1v7 android.database.Cursor) = (r1v5 android.database.Cursor), (r1v8 android.database.Cursor) binds: [B:34:0x0082, B:28:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.content.Context r10, boolean r11) {
        /*
            r9 = this;
            java.lang.String r0 = "querySupport, result : "
            java.lang.Boolean r1 = r9.e
            if (r1 == 0) goto Le
            if (r11 != 0) goto Le
            boolean r10 = r1.booleanValue()
            goto L88
        Le:
            r11 = 0
            if (r10 != 0) goto L12
            goto L27
        L12:
            android.content.pm.PackageManager r1 = r10.getPackageManager()
            r2 = 1
            if (r1 != 0) goto L1b
            r3 = 0
            goto L1c
        L1b:
            r3 = 1
        L1c:
            java.lang.String r4 = "com.meizu.flyme.openidsdk"
            android.content.pm.ProviderInfo r1 = r1.resolveContentProvider(r4, r11)
            if (r1 != 0) goto L25
            goto L27
        L25:
            if (r3 != 0) goto L32
        L27:
            java.lang.String r10 = "is not Supported, for isLegalProvider : false"
            b(r10)
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            r9.e = r10
        L30:
            r10 = 0
            goto L88
        L32:
            java.lang.String r1 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r4 = android.net.Uri.parse(r1)
            r1 = 0
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L82
            r5 = 0
            r6 = 0
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L82
            java.lang.String r10 = "supported"
            r7[r11] = r10     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L82
            r8 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L82
            if (r1 != 0) goto L50
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L82
            r9.e = r10     // Catch: java.lang.Throwable -> L7b java.lang.Exception -> L82
        L50:
            com.android.gdt.qone.j.d r10 = a(r1)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L7b
            java.lang.String r10 = r10.c     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L7b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L7b
            r2.<init>(r0)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L7b
            r2.append(r10)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L7b
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L7b
            b(r0)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L7b
            java.lang.String r0 = "0"
            boolean r10 = r0.equals(r10)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L7b
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r10)     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L7b
            r9.e = r0     // Catch: java.lang.Exception -> L77 java.lang.Throwable -> L7b
            if (r1 == 0) goto L76
            r1.close()
        L76:
            return r10
        L77:
            if (r1 == 0) goto L30
            goto L84
        L7b:
            r10 = move-exception
            if (r1 == 0) goto L81
            r1.close()
        L81:
            throw r10
        L82:
            if (r1 == 0) goto L30
        L84:
            r1.close()
            goto L30
        L88:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.gdt.qone.j.c.a(android.content.Context, boolean):boolean");
    }

    public final void a(Context context) {
        synchronized (this) {
            if (this.f == null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
                a aVar = new a();
                this.f = aVar;
                if (Build.VERSION.SDK_INT < 33) {
                    context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
                } else {
                    context.registerReceiver(aVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null, 2);
                }
            }
        }
    }

    public static final c a() {
        if (g == null) {
            synchronized (c.class) {
                g = new c();
            }
        }
        return g;
    }

    public final b a(String str) {
        if ("oaid".equals(str)) {
            return this.b;
        }
        if ("vaid".equals(str)) {
            return this.d;
        }
        if ("aaid".equals(str)) {
            return this.c;
        }
        if ("udid".equals(str)) {
            return this.a;
        }
        return null;
    }
}
