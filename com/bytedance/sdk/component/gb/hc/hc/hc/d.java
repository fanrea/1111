package com.bytedance.sdk.component.gb.hc.hc.hc;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.gb.d.h;
import com.bytedance.sdk.component.gb.d.tt;
import com.bytedance.sdk.component.gb.d.u;
import com.bytedance.sdk.component.gb.hc.d.d.b;
import com.bytedance.sdk.component.gb.hc.d.d.c;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private u b;
    private tt c;
    private String d;
    private Context hc;

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

    public d(String str) {
        this.d = str;
        h hVarB = com.bytedance.sdk.component.gb.hc.d.b(str);
        this.b = hVarB.b();
        this.c = hVarB.c();
    }

    private u hc() {
        if (this.b == null) {
            this.b = com.bytedance.sdk.component.gb.hc.d.b(this.d).b();
        }
        return this.b;
    }

    private tt b() {
        if (this.c == null) {
            this.c = com.bytedance.sdk.component.gb.hc.d.b(this.d).c();
        }
        return this.c;
    }

    private static ContentResolver hc(u uVar) {
        try {
            if (uVar.getContext() != null) {
                return uVar.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(u uVar) {
        if (uVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverHc = hc(uVar);
            if (contentResolverHc != null) {
                contentResolverHc.getType(Uri.parse(b(uVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void d(com.bytedance.sdk.component.gb.d.hc hcVar, u uVar) {
        if (hcVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverHc = hc(uVar);
            if (contentResolverHc != null) {
                contentResolverHc.getType(Uri.parse(b(uVar) + "adLogDispatch?event=" + b.d(hcVar.an())));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gb.hc.b.b.b("dispatch event Throwable:" + th.toString(), uVar);
        }
    }

    public static void d(String str, List<String> list, boolean z, u uVar, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(b.d(it.next())).append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(b.d(sb.toString())) + "&replace=" + String.valueOf(z) + "&extraMate=" + b.d(jSONObject.toString());
            ContentResolver contentResolverHc = hc(uVar);
            if (contentResolverHc != null) {
                contentResolverHc.getType(Uri.parse(b(uVar) + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void d(String str, u uVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverHc = hc(uVar);
            if (contentResolverHc != null) {
                contentResolverHc.getType(Uri.parse(b(uVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    private static String b(u uVar) {
        return c.d(uVar) + "/" + ("csj_mediation".equals(uVar.u()) ? "gromore_ad_log_event" : "ad_log_event") + "/";
    }

    public void d(Context context) {
        this.hc = context;
    }

    public String d() {
        return "csj_mediation".equals(this.d) ? "gromore_ad_log_event" : "ad_log_event";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getType(android.net.Uri r14) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.gb.hc.hc.hc.d.getType(android.net.Uri):java.lang.String");
    }
}
