package com.baidu.mobads.container.util.f;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ab extends com.baidu.mobads.container.d.a {
    final /* synthetic */ Context a;

    ab(Context context) {
        this.a = context;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        String string;
        try {
            z.a(this.a, "vivo-start", "");
            Cursor cursorQuery = this.a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursorQuery == null) {
                string = null;
            } else {
                if (!cursorQuery.moveToNext()) {
                    string = null;
                } else {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.d));
                }
                cursorQuery.close();
            }
            if (!TextUtils.isEmpty(string)) {
                z.a(string);
                z.a(this.a, "vivo-valid", string);
                z.a(2592000000L, string);
            } else {
                z.a(this.a, "vivo-empty", "");
            }
            if (!"vivo".equalsIgnoreCase(com.baidu.mobads.container.util.x.a(this.a).e())) {
                z.a(this.a, "vivo");
            }
        } catch (Throwable th) {
        }
        return null;
    }
}
