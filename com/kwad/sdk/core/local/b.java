package com.kwad.sdk.core.local;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.au;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static LocalWriteResult a(Context context, String str, byte[] bArr, String str2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return b(context, str, bArr, str2);
        }
        return a(context, bArr, str2 + "." + MimeTypeMap.getSingleton().getExtensionFromMimeType(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private static LocalWriteResult a(Context context, byte[] bArr, String str) throws Throwable {
        Throwable th;
        FileOutputStream fileOutputStream;
        Exception e;
        LocalWriteResult localWriteResult;
        if (au.aI(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            try {
                try {
                    fileOutputStream = new FileOutputStream(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), (String) str));
                } catch (Exception e2) {
                    fileOutputStream = null;
                    e = e2;
                } catch (Throwable th2) {
                    str = 0;
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                    throw th;
                }
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    localWriteResult = LocalWriteResult.SUCCESS;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    str = fileOutputStream;
                } catch (Exception e3) {
                    e = e3;
                    LocalWriteResult localWriteResult2 = LocalWriteResult.FAIL;
                    c.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    localWriteResult = localWriteResult2;
                    str = fileOutputStream;
                    return localWriteResult;
                }
                return localWriteResult;
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) str);
                throw th;
            }
        }
        return LocalWriteResult.PERMISSION_DENIED;
    }

    private static LocalWriteResult b(Context context, String str, byte[] bArr, String str2) throws Throwable {
        OutputStream outputStreamOpenOutputStream;
        LocalWriteResult localWriteResult = LocalWriteResult.FAIL;
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = context.getContentResolver();
        contentValues.put("_display_name", str2);
        contentValues.put("mime_type", str);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
        contentValues.put("is_pending", (Integer) 1);
        Uri uriInsert = contentResolver.insert(uri, contentValues);
        if (uriInsert == null) {
            return localWriteResult;
        }
        OutputStream outputStream = null;
        try {
            outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
        } catch (Exception e) {
            e = e;
            outputStreamOpenOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
        try {
            try {
                outputStreamOpenOutputStream.write(bArr);
                outputStreamOpenOutputStream.flush();
                outputStreamOpenOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                outputStream = outputStreamOpenOutputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            c.printStackTraceOnly(e);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamOpenOutputStream);
            contentValues.clear();
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(uriInsert, contentValues, null, null);
            return LocalWriteResult.SUCCESS;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStreamOpenOutputStream);
        contentValues.clear();
        contentValues.put("is_pending", (Integer) 0);
        contentResolver.update(uriInsert, contentValues, null, null);
        return LocalWriteResult.SUCCESS;
    }
}
