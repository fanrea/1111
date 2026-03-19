package com.netease.htprotect.p008O;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.m.p0.b;
import com.alipay.sdk.m.p0.c;
import java.io.IOException;

/* renamed from: com.netease.htprotect.〇O.O〇8O08OOo, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8O08OOo {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m668O8oO888(Context context) throws IOException {
        if (!"1".equals(o8o0.m672O8oO888(c.c, "0"))) {
            return null;
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(b.d));
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
            } else if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable unused2) {
        }
        return null;
    }
}
