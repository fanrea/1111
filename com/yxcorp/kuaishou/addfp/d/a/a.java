package com.yxcorp.kuaishou.addfp.d.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a() {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.d.a.a.a():java.lang.String");
    }

    public static String a(int i, String str) {
        String strA;
        Context paramContext = KWEGIDDFP.instance().getParamContext();
        if (paramContext == null) {
            return "";
        }
        String[] strArrSplit = new String(Base64.decode("U3lzdGVtQFNlY3VyZUBHbG9iYWw=", 0)).split("@");
        StringBuilder sb = new StringBuilder();
        sb.append(strArrSplit[0]);
        sb.append(strArrSplit[1]);
        sb.append(strArrSplit[2]);
        if (i == 0) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, strArrSplit[0], str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.System.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 1) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, strArrSplit[1], str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.Secure.getString(paramContext.getContentResolver(), str);
            }
        } else if (i == 2) {
            strA = com.yxcorp.kuaishou.addfp.android.b.a.a(paramContext, strArrSplit[2], str);
            if (TextUtils.isEmpty(strA)) {
                strA = Settings.Global.getString(paramContext.getContentResolver(), str);
            }
        } else {
            strA = "";
        }
        return strA == null ? "" : strA;
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2) throws ClassNotFoundException {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008d A[Catch: all -> 0x00e2, TryCatch #0 {all -> 0x00e2, blocks: (B:3:0x0004, B:6:0x0019, B:8:0x0023, B:10:0x002f, B:23:0x0070, B:25:0x0076, B:28:0x007d, B:30:0x0087, B:34:0x0097, B:36:0x009d, B:37:0x00b3, B:45:0x00d5, B:47:0x00db, B:32:0x008d, B:15:0x0048, B:17:0x0052, B:19:0x005e, B:21:0x006c), top: B:55:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5 A[Catch: all -> 0x00b3, TRY_LEAVE, TryCatch #1 {all -> 0x00b3, blocks: (B:41:0x00bd, B:43:0x00c5), top: B:57:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db A[Catch: all -> 0x00e2, TRY_LEAVE, TryCatch #0 {all -> 0x00e2, blocks: (B:3:0x0004, B:6:0x0019, B:8:0x0023, B:10:0x002f, B:23:0x0070, B:25:0x0076, B:28:0x007d, B:30:0x0087, B:34:0x0097, B:36:0x009d, B:37:0x00b3, B:45:0x00d5, B:47:0x00db, B:32:0x008d, B:15:0x0048, B:17:0x0052, B:19:0x005e, B:21:0x006c), top: B:55:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r11) {
        /*
            java.lang.String r0 = "k_w_o_d_out_dtt"
            java.lang.String r1 = "KWE_N"
            java.lang.String r2 = a(r11, r0)     // Catch: java.lang.Throwable -> Le2
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Le2
            java.lang.String r4 = "Lm91a2R0ZnQ="
            java.lang.String r5 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String r6 = "android.permission.READ_EXTERNAL_STORAGE"
            r7 = 2
            r8 = 1
            r9 = 0
            java.lang.String r10 = ""
            if (r3 == 0) goto L48
            com.yxcorp.kuaishou.addfp.android.a.d r3 = com.yxcorp.kuaishou.addfp.android.a.d.a(r11)     // Catch: java.lang.Throwable -> Le2
            boolean r3 = r3.b()     // Catch: java.lang.Throwable -> Le2
            if (r3 != 0) goto L6f
            java.lang.String[] r3 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> Le2
            r3[r9] = r6     // Catch: java.lang.Throwable -> Le2
            r3[r8] = r5     // Catch: java.lang.Throwable -> Le2
            boolean r3 = com.yxcorp.kuaishou.addfp.android.b.f.a(r11, r3)     // Catch: java.lang.Throwable -> Le2
            if (r3 == 0) goto L45
            com.yxcorp.kuaishou.addfp.android.a.d r3 = com.yxcorp.kuaishou.addfp.android.a.d.a(r11)     // Catch: java.lang.Throwable -> Le2
            java.lang.String r10 = r3.a(r4)     // Catch: java.lang.Throwable -> Le2
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Le2
            if (r3 != 0) goto L6f
            android.content.ContentResolver r3 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L6f
            android.provider.Settings.System.putString(r3, r0, r10)     // Catch: java.lang.Throwable -> L6f
            goto L6f
        L45:
            java.lang.String r0 = "KWE_PN"
            goto L70
        L48:
            com.yxcorp.kuaishou.addfp.android.a.d r0 = com.yxcorp.kuaishou.addfp.android.a.d.a(r11)     // Catch: java.lang.Throwable -> Le2
            boolean r0 = r0.b()     // Catch: java.lang.Throwable -> Le2
            if (r0 != 0) goto L6f
            java.lang.String[] r0 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> Le2
            r0[r9] = r6     // Catch: java.lang.Throwable -> Le2
            r0[r8] = r5     // Catch: java.lang.Throwable -> Le2
            boolean r0 = com.yxcorp.kuaishou.addfp.android.b.f.a(r11, r0)     // Catch: java.lang.Throwable -> Le2
            if (r0 == 0) goto L6f
            com.yxcorp.kuaishou.addfp.android.a.d r0 = com.yxcorp.kuaishou.addfp.android.a.d.a(r11)     // Catch: java.lang.Throwable -> Le2
            java.lang.String r10 = r0.a(r4)     // Catch: java.lang.Throwable -> Le2
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Le2
            if (r0 == 0) goto L6f
            com.yxcorp.kuaishou.addfp.android.a.d.a(r11, r2)     // Catch: java.lang.Throwable -> Le2
        L6f:
            r0 = r1
        L70:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Le2
            if (r3 == 0) goto L7d
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch: java.lang.Throwable -> Le2
            if (r3 == 0) goto L7d
            goto Le8
        L7d:
            com.yxcorp.kuaishou.addfp.android.a.d r1 = com.yxcorp.kuaishou.addfp.android.a.d.a(r11)     // Catch: java.lang.Throwable -> Le2
            java.util.LinkedHashMap r1 = r1.b(r2)     // Catch: java.lang.Throwable -> Le2
            if (r1 == 0) goto L8d
            int r2 = r1.size()     // Catch: java.lang.Throwable -> Le2
            if (r2 != 0) goto L95
        L8d:
            com.yxcorp.kuaishou.addfp.android.a.d r11 = com.yxcorp.kuaishou.addfp.android.a.d.a(r11)     // Catch: java.lang.Throwable -> Le2
            java.util.LinkedHashMap r1 = r11.b(r10)     // Catch: java.lang.Throwable -> Le2
        L95:
            if (r1 == 0) goto Le0
            int r11 = r1.size()     // Catch: java.lang.Throwable -> Le2
            if (r11 <= 0) goto Le0
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Le2
            java.util.Set r2 = r1.entrySet()     // Catch: java.lang.Throwable -> Le2
            r11.<init>(r2)     // Catch: java.lang.Throwable -> Le2
            int r1 = r1.size()     // Catch: java.lang.Throwable -> Le2
            java.util.ListIterator r11 = r11.listIterator(r1)     // Catch: java.lang.Throwable -> Le2
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Le2
            r1.<init>()     // Catch: java.lang.Throwable -> Le2
        Lb3:
            boolean r2 = r11.hasPrevious()     // Catch: java.lang.Throwable -> Le2
            if (r2 == 0) goto Ld5
            r2 = 10
            if (r9 >= r2) goto Ld5
            java.lang.Object r2 = r11.previous()     // Catch: java.lang.Throwable -> Lb3
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto Ld2
            java.lang.Object r3 = r2.getKey()     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> Lb3
            java.lang.Object r2 = r2.getValue()     // Catch: java.lang.Throwable -> Lb3
            r1.put(r3, r2)     // Catch: java.lang.Throwable -> Lb3
        Ld2:
            int r9 = r9 + 1
            goto Lb3
        Ld5:
            int r11 = r1.length()     // Catch: java.lang.Throwable -> Le2
            if (r11 <= 0) goto Le0
            java.lang.String r11 = r1.toString()     // Catch: java.lang.Throwable -> Le2
            return r11
        Le0:
            r1 = r0
            goto Le8
        Le2:
            r11 = move-exception
            r11.printStackTrace()
            java.lang.String r1 = "KWE_PE"
        Le8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yxcorp.kuaishou.addfp.d.a.a.a(android.content.Context):java.lang.String");
    }
}
