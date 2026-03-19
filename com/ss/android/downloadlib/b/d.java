package com.ss.android.downloadlib.b;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.socialbase.downloader.c.k;
import java.io.File;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements k {
    @Override // com.ss.android.socialbase.downloader.c.k
    public void d(com.ss.android.socialbase.downloader.h.b bVar) throws com.ss.android.socialbase.downloader.u.d {
        if (bVar == null || !b(bVar)) {
            return;
        }
        d(mq.getContext(), bVar);
    }

    @Override // com.ss.android.socialbase.downloader.c.k
    public boolean hc(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar != null) {
            return com.ss.android.downloadlib.h.u.hc(com.ss.android.socialbase.downloader.uo.d.d(bVar.h()));
        }
        return false;
    }

    private boolean b(com.ss.android.socialbase.downloader.h.b bVar) throws JSONException {
        String str = bVar.mk() + File.separator + bVar.gb();
        File file = new File(str);
        String strD = com.ss.android.socialbase.appdownloader.an.d.u.d(mq.getContext(), com.ss.android.socialbase.appdownloader.b.d(bVar, file), str);
        boolean zRenameTo = false;
        if (!TextUtils.isEmpty(strD)) {
            String str2 = strD + ".apk";
            if (str2.equals(bVar.gb())) {
                return true;
            }
            try {
                zRenameTo = file.renameTo(new File(bVar.mk() + File.separator + str2));
                if (zRenameTo) {
                    bVar.an(str2);
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        return zRenameTo;
    }

    private void d(Context context, final com.ss.android.socialbase.downloader.h.b bVar) {
        String str = bVar.mk() + File.separator + bVar.gb();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            bVar.d("file_content_uri", (Object) ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.b.d.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        bVar.d("file_content_uri", (Object) uri.toString());
                        com.ss.android.socialbase.downloader.downloader.b.np().d(bVar);
                    }
                }
            });
        }
        com.ss.android.socialbase.downloader.e.an.d(cursorQuery);
    }
}
