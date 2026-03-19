package com.bytedance.sdk.component.gb.hc.hc.hc;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.gb.d.tt;
import com.bytedance.sdk.component.gb.d.u;
import com.bytedance.sdk.component.gb.hc.b;
import com.bytedance.sdk.component.gb.hc.d.d.c;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static b d;
    private u b;
    private tt c;
    private String hc;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private u d() {
        if (this.b == null) {
            this.b = com.bytedance.sdk.component.gb.hc.d.b(this.hc).b();
        }
        return this.b;
    }

    private tt hc() {
        if (this.c == null) {
            this.c = com.bytedance.sdk.component.gb.hc.d.b(this.hc).c();
        }
        return this.c;
    }

    public static b d(u uVar) {
        try {
            if (d == null) {
                d = uVar.c().mk();
            }
        } catch (Exception unused) {
        }
        return d;
    }

    public static void hc(u uVar) {
        if (uVar == null) {
            return;
        }
        try {
            b bVarD = d(uVar);
            if (bVarD != null) {
                bVarD.getType(Uri.parse(b(uVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void d(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar) {
        if (hcVar == null || uVar == null) {
            return;
        }
        try {
            b bVarD = d(uVar);
            if (bVarD != null) {
                bVarD.getType(Uri.parse(b(uVar) + "adLogDispatch?event=" + com.bytedance.sdk.component.gb.hc.d.d.b.d(hcVar.an())));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gb.hc.b.b.b("dispatch event Throwable:" + th.toString(), uVar);
        }
    }

    public static void d(String str, List<String> list, boolean z, u uVar) {
        if (list == null || list.isEmpty() || uVar == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.bytedance.sdk.component.gb.hc.d.d.b.d(it.next())).append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.component.gb.hc.d.d.b.d(sb.toString())) + "&replace=" + String.valueOf(z);
            b bVarD = d(uVar);
            if (bVarD != null) {
                bVarD.getType(Uri.parse(b(uVar) + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void d(String str, u uVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return;
        }
        try {
            b bVarD = d(uVar);
            if (bVarD != null) {
                bVarD.getType(Uri.parse(b(uVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    private static String b(u uVar) {
        return c.d(uVar) + "/ad_log_event/";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getType(android.net.Uri r14) {
        /*
            r13 = this;
            r13.d()
            com.bytedance.sdk.component.gb.d.tt r0 = r13.hc()
            r1 = 0
            if (r0 != 0) goto Lb
            return r1
        Lb:
            java.lang.String r2 = r14.getPath()
            java.lang.String r3 = "/"
            java.lang.String[] r2 = r2.split(r3)
            r3 = 2
            r2 = r2[r3]
            r2.hashCode()
            r4 = -1
            int r5 = r2.hashCode()
            r6 = 0
            switch(r5) {
                case -482705237: goto L50;
                case -171493183: goto L45;
                case 964299715: goto L3c;
                case 1025736635: goto L31;
                case 1131732929: goto L26;
                default: goto L24;
            }
        L24:
            r3 = r4
            goto L5a
        L26:
            java.lang.String r3 = "trackAdUrl"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L2f
            goto L24
        L2f:
            r3 = 4
            goto L5a
        L31:
            java.lang.String r3 = "adLogDispatch"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L3a
            goto L24
        L3a:
            r3 = 3
            goto L5a
        L3c:
            java.lang.String r5 = "adLogStop"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L5a
            goto L24
        L45:
            java.lang.String r3 = "adLogStart"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L4e
            goto L24
        L4e:
            r3 = 1
            goto L5a
        L50:
            java.lang.String r3 = "trackAdFailed"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L59
            goto L24
        L59:
            r3 = r6
        L5a:
            java.lang.String r2 = "did"
            switch(r3) {
                case 0: goto Le1;
                case 1: goto Lda;
                case 2: goto Ld6;
                case 3: goto Lb5;
                case 4: goto L61;
                default: goto L5f;
            }
        L5f:
            goto Lf0
        L61:
            r13.d()
            java.lang.String r8 = r14.getQueryParameter(r2)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = "replace"
            java.lang.String r0 = r14.getQueryParameter(r0)     // Catch: java.lang.Throwable -> Lf0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> Lf0
            boolean r10 = r0.booleanValue()     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = "track"
            java.lang.String r14 = r14.getQueryParameter(r0)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r14 = com.bytedance.sdk.component.gb.hc.d.d.b.hc(r14)     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r0 = ","
            java.lang.String[] r14 = r14.split(r0)     // Catch: java.lang.Throwable -> Lf0
            int r0 = r14.length     // Catch: java.lang.Throwable -> Lf0
            if (r0 <= 0) goto Lf0
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lf0
            r9.<init>()     // Catch: java.lang.Throwable -> Lf0
            int r0 = r14.length     // Catch: java.lang.Throwable -> Lf0
        L8f:
            if (r6 >= r0) goto La3
            r2 = r14[r6]     // Catch: java.lang.Throwable -> Lf0
            java.lang.String r2 = com.bytedance.sdk.component.gb.hc.d.d.b.hc(r2)     // Catch: java.lang.Throwable -> Lf0
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lf0
            if (r3 != 0) goto La0
            r9.add(r2)     // Catch: java.lang.Throwable -> Lf0
        La0:
            int r6 = r6 + 1
            goto L8f
        La3:
            com.bytedance.sdk.component.gb.d.u r14 = r13.d()     // Catch: java.lang.Throwable -> Lf0
            com.bytedance.sdk.component.gb.hc.an.hc r7 = com.bytedance.sdk.component.gb.hc.an.d.d(r14)     // Catch: java.lang.Throwable -> Lf0
            r11 = 0
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lf0
            r12.<init>()     // Catch: java.lang.Throwable -> Lf0
            r7.d(r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> Lf0
            goto Lf0
        Lb5:
            r13.d()
            java.lang.String r0 = "event"
            java.lang.String r14 = r14.getQueryParameter(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto Lf0
            java.lang.String r14 = com.bytedance.sdk.component.gb.hc.d.d.b.hc(r14)
            com.bytedance.sdk.component.gb.d.hc r14 = com.bytedance.sdk.component.gb.hc.c.d.d.c(r14)
            if (r14 == 0) goto Lf0
            com.bytedance.sdk.component.gb.d.tt r0 = r13.hc()
            r0.d(r14)
            goto Lf0
        Ld6:
            r13.d()
            goto Lf0
        Lda:
            r13.d()
            r0.d()
            goto Lf0
        Le1:
            java.lang.String r14 = r14.getQueryParameter(r2)
            com.bytedance.sdk.component.gb.d.u r0 = r13.d()
            com.bytedance.sdk.component.gb.hc.an.hc r0 = com.bytedance.sdk.component.gb.hc.an.d.d(r0)
            r0.d(r14)
        Lf0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.gb.hc.hc.hc.hc.getType(android.net.Uri):java.lang.String");
    }
}
