package com.baidu.mobads.container.util.f;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class p extends com.baidu.mobads.container.d.a {
    final /* synthetic */ Context a;

    p(Context context) {
        this.a = context;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        String string;
        try {
            z.a(this.a, "meizu-start", "");
            Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery == null) {
                string = null;
            } else {
                cursorQuery.moveToFirst();
                int columnIndex = cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.d);
                if (columnIndex <= 0) {
                    string = null;
                } else {
                    string = cursorQuery.getString(columnIndex);
                }
                cursorQuery.close();
            }
            if (TextUtils.isEmpty(string)) {
                z.a(this.a, "meizu-empty", "");
            } else {
                z.a(string);
                z.a(2592000000L, string);
            }
        } catch (Throwable th) {
        }
        return null;
    }
}
