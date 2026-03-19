package com.fendasz.moku.planet.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.mobads.container.components.j.a;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectMimeType;
import com.sigmob.sdk.archives.d;
import com.sigmob.sdk.base.n;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ContentUtil {
    public static final String DOCUMENTS_DIR = "documents";
    private static final String[][] MIME_MapTable = {new String[]{"3gp", "video/3gpp"}, new String[]{"apk", "application/vnd.android.package-archive"}, new String[]{"asf", "video/x-ms-asf"}, new String[]{"avi", "video/x-msvideo"}, new String[]{"bin", MediaTypeUtils.APPLICATION_OCTET_STREAM}, new String[]{"bmp", "image/bmp"}, new String[]{"c", "text/plain"}, new String[]{"class", MediaTypeUtils.APPLICATION_OCTET_STREAM}, new String[]{"conf", "text/plain"}, new String[]{"cpp", "text/plain"}, new String[]{"doc", "application/msword"}, new String[]{"exe", MediaTypeUtils.APPLICATION_OCTET_STREAM}, new String[]{"gif", "image/gif"}, new String[]{"gtar", "application/x-gtar"}, new String[]{"gz", "application/x-gzip"}, new String[]{"h", "text/plain"}, new String[]{"htm", "text/html"}, new String[]{"html", "text/html"}, new String[]{d.d, "application/java-archive"}, new String[]{"java", "text/plain"}, new String[]{"jpeg", "image/jpeg"}, new String[]{"jpg", "image/jpeg"}, new String[]{"js", "application/x-javascript"}, new String[]{a.b, "text/plain"}, new String[]{"m3u", "audio/x-mpegurl"}, new String[]{"m4a", "audio/mp4a-latm"}, new String[]{"m4b", "audio/mp4a-latm"}, new String[]{"m4p", "audio/mp4a-latm"}, new String[]{"m4u", "video/vnd.mpegurl"}, new String[]{"m4v", "video/x-m4v"}, new String[]{"mov", "video/quicktime"}, new String[]{"mp2", "audio/x-mpeg"}, new String[]{"mp3", "audio/x-mpeg"}, new String[]{"mp4", "video/mp4"}, new String[]{"mpc", "application/vnd.mpohun.certificate"}, new String[]{"mpe", "video/mpeg"}, new String[]{"mpeg", "video/mpeg"}, new String[]{"mpg", "video/mpeg"}, new String[]{"mpg4", "video/mp4"}, new String[]{"mpga", "audio/mpeg"}, new String[]{"msg", "application/vnd.ms-outlook"}, new String[]{"ogg", "audio/ogg"}, new String[]{"pdf", "application/pdf"}, new String[]{"png", PictureMimeType.PNG_Q}, new String[]{"pps", "application/vnd.ms-powerpoint"}, new String[]{"ppt", "application/vnd.ms-powerpoint"}, new String[]{"prop", "text/plain"}, new String[]{"rar", "application/x-rar-compressed"}, new String[]{"rc", "text/plain"}, new String[]{"rmvb", "audio/x-pn-realaudio"}, new String[]{"rtf", "application/rtf"}, new String[]{"sh", "text/plain"}, new String[]{"tar", "application/x-tar"}, new String[]{"tgz", "application/x-compressed"}, new String[]{"txt", "text/plain"}, new String[]{"wav", PictureMimeType.WAV_Q}, new String[]{"wma", "audio/x-ms-wma"}, new String[]{"wmv", "audio/x-ms-wmv"}, new String[]{"wps", "application/vnd.ms-works"}, new String[]{"webp", SelectMimeType.SYSTEM_IMAGE}, new String[]{"xml", "text/plain"}, new String[]{"z", "application/x-compress"}, new String[]{d.e, "application/zip"}, new String[]{"", "*/*"}};
    private static final String TAG = "ContentUtil==>";

    public static String getFilePathByUri(Context context, Uri uri) throws Throwable {
        int columnIndexOrThrow;
        if (n.z.equals(uri.getScheme())) {
            return uri.getPath();
        }
        Uri uri2 = null;
        string = null;
        string = null;
        String string = null;
        if ("content".equals(uri.getScheme()) & (!uri.toString().contains("com."))) {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst() && (columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data")) > -1) {
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
                cursorQuery.close();
            }
            return string;
        }
        if ("content".equals(uri.getScheme()) && Build.VERSION.SDK_INT >= 19) {
            if (DocumentsContract.isDocumentUri(context, uri)) {
                if (isExternalStorageDocument(uri)) {
                    String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                    String str = strArrSplit[0];
                    if ("primary".equalsIgnoreCase(str)) {
                        return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                    }
                    return "/storage/" + str + "/" + strArrSplit[1];
                }
                if (isDownloadsDocument(uri)) {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (isMediaDocument(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str2 = strArrSplit2[0];
                    if ("image".equals(str2)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str2)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str2)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            } else {
                String dataColumn = getDataColumn(context, uri, null, null);
                if (dataColumn != null) {
                    return dataColumn;
                }
                Toast.makeText(context, "获取文件失败", 0).show();
            }
        }
        return null;
    }

    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static String getFilePathFromURI(Context context, Uri uri) throws Throwable {
        String filePathByUri = getFilePathByUri(context, uri);
        LogUtils.logI(TAG, "filepath" + filePathByUri);
        return filePathByUri;
    }

    public static String getFileName(Uri uri) {
        String path;
        int iLastIndexOf;
        if (uri == null || (iLastIndexOf = (path = uri.getPath()).lastIndexOf(47)) == -1) {
            return null;
        }
        return path.substring(iLastIndexOf + 1);
    }

    public static void copyFile(Context context, Uri uri, File file) throws IOException {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            copyStream(inputStreamOpenInputStream, fileOutputStream);
            inputStreamOpenInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int copyStream(InputStream inputStream, OutputStream outputStream) throws Exception {
        byte[] bArr = new byte[2048];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 2048);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, 2048);
        int i = 0;
        while (true) {
            try {
                int i2 = bufferedInputStream.read(bArr, 0, 2048);
                if (i2 == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, i2);
                i += i2;
            } finally {
            }
        }
        bufferedOutputStream.flush();
        try {
            bufferedOutputStream.close();
        } catch (IOException unused) {
        }
        try {
            bufferedInputStream.close();
        } catch (IOException unused2) {
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x005f A[Catch: IOException -> 0x005b, TRY_LEAVE, TryCatch #7 {IOException -> 0x005b, blocks: (B:40:0x0057, B:44:0x005f), top: B:51:0x0057 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void saveFileFromUri(android.content.Context r3, android.net.Uri r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            java.io.InputStream r3 = r3.openInputStream(r4)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3d
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            r2 = 0
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L36
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r3.read(r5)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
        L1b:
            r4.write(r5)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            int r0 = r3.read(r5)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30
            r1 = -1
            if (r0 != r1) goto L1b
            if (r3 == 0) goto L2a
            r3.close()     // Catch: java.io.IOException -> L48
        L2a:
            r4.close()     // Catch: java.io.IOException -> L48
            goto L53
        L2e:
            r5 = move-exception
            goto L34
        L30:
            r5 = move-exception
            goto L38
        L32:
            r5 = move-exception
            r4 = r0
        L34:
            r0 = r3
            goto L55
        L36:
            r5 = move-exception
            r4 = r0
        L38:
            r0 = r3
            goto L3f
        L3a:
            r5 = move-exception
            r4 = r0
            goto L55
        L3d:
            r5 = move-exception
            r4 = r0
        L3f:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L54
            if (r0 == 0) goto L4a
            r0.close()     // Catch: java.io.IOException -> L48
            goto L4a
        L48:
            r3 = move-exception
            goto L50
        L4a:
            if (r4 == 0) goto L53
            r4.close()     // Catch: java.io.IOException -> L48
            goto L53
        L50:
            r3.printStackTrace()
        L53:
            return
        L54:
            r5 = move-exception
        L55:
            if (r0 == 0) goto L5d
            r0.close()     // Catch: java.io.IOException -> L5b
            goto L5d
        L5b:
            r3 = move-exception
            goto L63
        L5d:
            if (r4 == 0) goto L66
            r4.close()     // Catch: java.io.IOException -> L5b
            goto L66
        L63:
            r3.printStackTrace()
        L66:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.utils.ContentUtil.saveFileFromUri(android.content.Context, android.net.Uri, java.lang.String):void");
    }

    public static File getDocumentCacheDir(Context context) {
        File file = new File(context.getCacheDir(), DOCUMENTS_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File generateFileName(String str, File file) {
        String strSubstring;
        if (str == null) {
            return null;
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            int iLastIndexOf = str.lastIndexOf(46);
            int i = 0;
            if (iLastIndexOf > 0) {
                String strSubstring2 = str.substring(0, iLastIndexOf);
                strSubstring = str.substring(iLastIndexOf);
                str = strSubstring2;
            } else {
                strSubstring = "";
            }
            while (file2.exists()) {
                i++;
                file2 = new File(file, str + '(' + i + ')' + strSubstring);
            }
        }
        try {
            if (file2.createNewFile()) {
                return file2;
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    public static String getFileTypeSurifx(String str) {
        int iLastIndexOf;
        return (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(46)) > -1) ? str.substring(iLastIndexOf + 1) : "";
    }

    public static String getMIMEType(String str) {
        int i = 0;
        while (true) {
            String[][] strArr = MIME_MapTable;
            if (i >= strArr.length) {
                return "";
            }
            if (strArr[i][0].equals(str)) {
                return strArr[i][1];
            }
            i++;
        }
    }

    public static boolean isFileExists(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }
}
