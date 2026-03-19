package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.embedapplog.ic;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class hg implements ic {
    private gv<Boolean> d = new gv<Boolean>() { // from class: com.bytedance.embedapplog.hg.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.gv
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean d(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return Boolean.FALSE;
        }
    };

    hg() {
    }

    @Override // com.bytedance.embedapplog.ic
    public boolean d(Context context) {
        if (context == null) {
            return false;
        }
        return this.d.hc(context).booleanValue();
    }

    @Override // com.bytedance.embedapplog.ic
    public ic.d hc(Context context) {
        Cursor cursorQuery;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                ic.d dVar = new ic.d();
                dVar.hc = d(cursorQuery);
                return dVar;
            } catch (Throwable th) {
                th = th;
                try {
                    um.d(th);
                    return null;
                } finally {
                    fv.d(cursorQuery);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    private String d(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(com.alipay.sdk.m.p0.b.d);
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }
}
