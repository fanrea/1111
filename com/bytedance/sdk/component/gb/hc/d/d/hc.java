package com.bytedance.sdk.component.gb.hc.d.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.gb.d.u;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static void insert(Context context, String str, ContentValues contentValues, u uVar) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            d.d(context).d().insert(uVar, str, (String) null, contentValues);
        } catch (Throwable unused) {
        }
    }

    public static void insert(Context context, String str, List<com.bytedance.sdk.component.gb.d.hc> list, u uVar) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            d.d(context).d().insert(uVar, str, (String) null, list);
        } catch (Throwable unused) {
        }
    }

    public static int delete(Context context, String str, String str2, String[] strArr, u uVar) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return d.d(context).d().delete(uVar, str, str2, strArr);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int update(Context context, String str, ContentValues contentValues, String str2, String[] strArr, u uVar) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            try {
                return d.d(context).d().update(uVar, str, contentValues, str2, strArr);
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static Cursor query(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, u uVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return d.d(context).d().query(uVar, str, strArr, str2, strArr2, null, null, str5);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d(Context context, String str, u uVar) {
        if (TextUtils.isEmpty(str)) {
            return "sql is null";
        }
        try {
            d.d(context).d().d(uVar, Uri.decode(str));
            return "execSql ok";
        } catch (Throwable th) {
            return "exec sql exception:" + th.getMessage();
        }
    }
}
