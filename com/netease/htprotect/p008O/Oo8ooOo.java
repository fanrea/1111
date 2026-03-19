package com.netease.htprotect.p008O;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.m.p0.b;

/* renamed from: com.netease.htprotect.〇O.O〇o8ooOo〇, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class Oo8ooOo {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m669O8oO888(Context context) {
        Cursor cursorQuery;
        try {
            context.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
        } catch (Throwable unused) {
        }
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            return null;
        }
        int columnIndex = cursorQuery.getColumnIndex(b.d);
        String string = columnIndex > 0 ? cursorQuery.getString(columnIndex) : null;
        cursorQuery.close();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }
}
