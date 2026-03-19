package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class am {
    private static String cmu;
    private static boolean cmv;

    public static String dU(Context context) {
        if (!TextUtils.isEmpty(cmu) || cmv || !bc.apq()) {
            return cmu;
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
            cmu = i(cursorQuery);
        } catch (Throwable unused) {
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
        cmv = TextUtils.isEmpty(cmu);
        return cmu;
    }

    private static String i(Cursor cursor) {
        int columnIndex;
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "cursor is null");
            return "";
        }
        cursor.moveToFirst();
        int columnIndex2 = cursor.getColumnIndex("support");
        return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
    }

    public static boolean dV(Context context) {
        boolean zJ = false;
        if (!bc.apq()) {
            return false;
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
                zJ = j(cursorQuery);
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(cursorQuery);
            }
        } catch (Throwable unused) {
            com.kwad.sdk.core.d.c.e("MiMarketHelper", "isSupportMiMarket2 failed");
        }
        if (!zJ && bc.apq()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "is Miui but not support MiMarket2.0");
        }
        return zJ;
    }

    private static boolean j(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            com.kwad.sdk.core.d.c.i("MiMarketHelper", "isSupportMiMarket2: cursor is null");
            return false;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("support");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex).equals("true");
        }
        return false;
    }

    public static boolean is(String str) {
        return str.startsWith("market://details") || str.startsWith("mimarket://details");
    }
}
