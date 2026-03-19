package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import ms.bz.bd.c.Pgl.pblk;
import okio.Utf8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class x0 {
    private final Context d;

    public x0(Context context) {
        this.d = context;
    }

    private static String d(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6b5a83", new byte[]{com.sigmob.sdk.archives.tar.e.I, 97, 74, 0, 2}));
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0298fd", new byte[]{34, Utf8.REPLACEMENT_BYTE, 78, 73}));
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6d5397", new byte[]{34, 126, 86, 78, 20, 37, com.sigmob.sdk.archives.tar.e.I}));
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }

    public final void d(pblk.pblb pblbVar) throws PackageManager.NameNotFoundException {
        try {
            this.d.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ab4aa7", new byte[]{115, 111, 74, 91, com.sigmob.sdk.archives.tar.e.Q, 37, 107, 89, 112, 127, 118, 108, 94, 24, 91, 110, 109, com.sigmob.sdk.archives.tar.e.Q, 96, Utf8.REPLACEMENT_BYTE, 121, 100, 84, 17, 85}), 0);
        } catch (Exception unused) {
        }
        Uri uri = Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "829381", new byte[]{42, Utf8.REPLACEMENT_BYTE, 68, com.sigmob.sdk.archives.tar.e.Q, 2, 40, 47, 73, 39, 44, 42, Utf8.REPLACEMENT_BYTE, 71, 9, 10, 35, com.sigmob.sdk.archives.tar.e.J, 9, 125, 45, 47, 60, com.sigmob.sdk.archives.tar.e.Q, 74, 2, 104, com.sigmob.sdk.archives.tar.e.L, 3, 109, 109, 32, com.sigmob.sdk.archives.tar.e.L, 89, 67, 12, 105}));
        Cursor cursorQuery = null;
        try {
            cursorQuery = this.d.getContentResolver().query(uri, null, null, new String[]{(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0f7560", new byte[]{46, 101, 77, 69})}, null);
            String strD = d(cursorQuery);
            if (pblbVar != null) {
                pblbVar.d(strD);
            }
            if (cursorQuery == null) {
                return;
            }
        } catch (Throwable unused2) {
            if (cursorQuery == null) {
                return;
            }
        }
        cursorQuery.close();
    }
}
