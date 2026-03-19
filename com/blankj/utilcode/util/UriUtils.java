package com.blankj.utilcode.util;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.component.c.c;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class UriUtils {
    private UriUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Uri res2Uri(String str) {
        return Uri.parse("android.resource://" + Utils.getApp().getPackageName() + "/" + str);
    }

    public static Uri file2Uri(File file) {
        if (!UtilsBridge.isFileExists(file)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(Utils.getApp(), Utils.getApp().getPackageName() + ".utilcode.fileprovider", file);
        }
        return Uri.fromFile(file);
    }

    public static File uri2File(Uri uri) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException, InvocationTargetException {
        if (uri == null) {
            return null;
        }
        File fileUri2FileReal = uri2FileReal(uri);
        return fileUri2FileReal != null ? fileUri2FileReal : copyUri2Cache(uri);
    }

    public static File uri2FileNoCacheCopy(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri2FileReal(uri);
    }

    private static File uri2FileReal(Uri uri) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException, InvocationTargetException {
        Uri uri2;
        File fileFromUri;
        String str;
        File file;
        Log.d("UriUtils", uri.toString());
        String authority = uri.getAuthority();
        String scheme = uri.getScheme();
        String path = uri.getPath();
        if (Build.VERSION.SDK_INT >= 24 && path != null) {
            String[] strArr = {"/external/", "/external_path/"};
            for (int i = 0; i < 2; i++) {
                String str2 = strArr[i];
                if (path.startsWith(str2)) {
                    File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + path.replace(str2, "/"));
                    if (file2.exists()) {
                        Log.d("UriUtils", uri.toString() + " -> " + str2);
                        return file2;
                    }
                }
            }
            if (path.startsWith("/files_path/")) {
                file = new File(Utils.getApp().getFilesDir().getAbsolutePath() + path.replace("/files_path/", "/"));
            } else if (path.startsWith("/cache_path/")) {
                file = new File(Utils.getApp().getCacheDir().getAbsolutePath() + path.replace("/cache_path/", "/"));
            } else if (path.startsWith("/external_files_path/")) {
                file = new File(Utils.getApp().getExternalFilesDir(null).getAbsolutePath() + path.replace("/external_files_path/", "/"));
            } else {
                file = path.startsWith("/external_cache_path/") ? new File(Utils.getApp().getExternalCacheDir().getAbsolutePath() + path.replace("/external_cache_path/", "/")) : null;
            }
            if (file != null && file.exists()) {
                Log.d("UriUtils", uri.toString() + " -> " + path);
                return file;
            }
        }
        if (n.z.equals(scheme)) {
            if (path != null) {
                return new File(path);
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 0");
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(Utils.getApp(), uri)) {
            if ("com.android.externalstorage.documents".equals(authority)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                String str3 = strArrSplit[0];
                if ("primary".equalsIgnoreCase(str3)) {
                    return new File(Environment.getExternalStorageDirectory() + "/" + strArrSplit[1]);
                }
                StorageManager storageManager = (StorageManager) Utils.getApp().getSystemService("storage");
                try {
                    Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                    Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
                    Method method2 = cls.getMethod("getUuid", new Class[0]);
                    Method method3 = cls.getMethod("getState", new Class[0]);
                    Method method4 = cls.getMethod("getPath", new Class[0]);
                    Method method5 = cls.getMethod("isPrimary", new Class[0]);
                    Method method6 = cls.getMethod("isEmulated", new Class[0]);
                    Object objInvoke = method.invoke(storageManager, new Object[0]);
                    int length = Array.getLength(objInvoke);
                    int i2 = 0;
                    while (i2 < length) {
                        Object obj = Array.get(objInvoke, i2);
                        Object obj2 = objInvoke;
                        if ((c.a.equals(method3.invoke(obj, new Object[0])) || "mounted_ro".equals(method3.invoke(obj, new Object[0]))) && ((!((Boolean) method5.invoke(obj, new Object[0])).booleanValue() || !((Boolean) method6.invoke(obj, new Object[0])).booleanValue()) && (str = (String) method2.invoke(obj, new Object[0])) != null && str.equals(str3))) {
                            return new File(method4.invoke(obj, new Object[0]) + "/" + strArrSplit[1]);
                        }
                        i2++;
                        objInvoke = obj2;
                    }
                } catch (Exception e) {
                    Log.d("UriUtils", uri.toString() + " parse failed. " + e.toString() + " -> 1_0");
                }
                Log.d("UriUtils", uri.toString() + " parse failed. -> 1_0");
                return null;
            }
            if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (TextUtils.isEmpty(documentId)) {
                    Log.d("UriUtils", uri.toString() + " parse failed(id is null). -> 1_1");
                    return null;
                }
                if (documentId.startsWith("raw:")) {
                    return new File(documentId.substring(4));
                }
                if (documentId.startsWith("msf:")) {
                    documentId = documentId.split(":")[1];
                }
                try {
                    long j = Long.parseLong(documentId);
                    String[] strArr2 = {"content://downloads/public_downloads", "content://downloads/all_downloads", "content://downloads/my_downloads"};
                    for (int i3 = 0; i3 < 3; i3++) {
                        try {
                            fileFromUri = getFileFromUri(ContentUris.withAppendedId(Uri.parse(strArr2[i3]), j), "1_1");
                        } catch (Exception unused) {
                        }
                        if (fileFromUri != null) {
                            return fileFromUri;
                        }
                    }
                    Log.d("UriUtils", uri.toString() + " parse failed. -> 1_1");
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            }
            if ("com.android.providers.media.documents".equals(authority)) {
                String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                String str4 = strArrSplit2[0];
                if ("image".equals(str4)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str4)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str4)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                } else {
                    Log.d("UriUtils", uri.toString() + " parse failed. -> 1_2");
                    return null;
                }
                return getFileFromUri(uri2, "_id=?", new String[]{strArrSplit2[1]}, "1_2");
            }
            if ("content".equals(scheme)) {
                return getFileFromUri(uri, "1_3");
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 1_4");
            return null;
        }
        if ("content".equals(scheme)) {
            return getFileFromUri(uri, "2");
        }
        Log.d("UriUtils", uri.toString() + " parse failed. -> 3");
        return null;
    }

    private static File getFileFromUri(Uri uri, String str) {
        return getFileFromUri(uri, null, null, str);
    }

    private static File getFileFromUri(Uri uri, String str, String[] strArr, String str2) {
        if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
            if (!TextUtils.isEmpty(uri.getLastPathSegment())) {
                return new File(uri.getLastPathSegment());
            }
        } else if ("com.tencent.mtt.fileprovider".equals(uri.getAuthority())) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                return new File(Environment.getExternalStorageDirectory(), path.substring(10, path.length()));
            }
        } else if ("com.huawei.hidisk.fileprovider".equals(uri.getAuthority())) {
            String path2 = uri.getPath();
            if (!TextUtils.isEmpty(path2)) {
                return new File(path2.replace("/root", ""));
            }
        }
        Cursor cursorQuery = Utils.getApp().getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        try {
            if (cursorQuery == null) {
                Log.d("UriUtils", uri.toString() + " parse failed(cursor is null). -> " + str2);
                return null;
            }
            if (!cursorQuery.moveToFirst()) {
                Log.d("UriUtils", uri.toString() + " parse failed(moveToFirst return false). -> " + str2);
                return null;
            }
            int columnIndex = cursorQuery.getColumnIndex("_data");
            if (columnIndex > -1) {
                return new File(cursorQuery.getString(columnIndex));
            }
            Log.d("UriUtils", uri.toString() + " parse failed(columnIndex: " + columnIndex + " is wrong). -> " + str2);
            return null;
        } catch (Exception unused) {
            Log.d("UriUtils", uri.toString() + " parse failed. -> " + str2);
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.io.File copyUri2Cache(android.net.Uri r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "UriUtils"
            java.lang.String r1 = "copyUri2Cache() called"
            android.util.Log.d(r0, r1)
            r0 = 0
            android.app.Application r1 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.lang.Throwable -> L4c java.io.FileNotFoundException -> L51
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L4c java.io.FileNotFoundException -> L51
            java.io.InputStream r7 = r1.openInputStream(r7)     // Catch: java.lang.Throwable -> L4c java.io.FileNotFoundException -> L51
            java.io.File r1 = new java.io.File     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            android.app.Application r2 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            java.io.File r2 = r2.getCacheDir()     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            r3.<init>()     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            java.lang.String r4 = ""
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            java.lang.String r3 = r3.toString()     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            r1.<init>(r2, r3)     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            java.lang.String r2 = r1.getAbsolutePath()     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            com.blankj.utilcode.util.UtilsBridge.writeFileFromIS(r2, r7)     // Catch: java.io.FileNotFoundException -> L4a java.lang.Throwable -> L61
            if (r7 == 0) goto L49
            r7.close()     // Catch: java.io.IOException -> L45
            goto L49
        L45:
            r7 = move-exception
            r7.printStackTrace()
        L49:
            return r1
        L4a:
            r1 = move-exception
            goto L53
        L4c:
            r7 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L62
        L51:
            r1 = move-exception
            r7 = r0
        L53:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L61
            if (r7 == 0) goto L60
            r7.close()     // Catch: java.io.IOException -> L5c
            goto L60
        L5c:
            r7 = move-exception
            r7.printStackTrace()
        L60:
            return r0
        L61:
            r0 = move-exception
        L62:
            if (r7 == 0) goto L6c
            r7.close()     // Catch: java.io.IOException -> L68
            goto L6c
        L68:
            r7 = move-exception
            r7.printStackTrace()
        L6c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.UriUtils.copyUri2Cache(android.net.Uri):java.io.File");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] uri2Bytes(android.net.Uri r4) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            android.app.Application r1 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.lang.Throwable -> L21 java.io.FileNotFoundException -> L26
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L21 java.io.FileNotFoundException -> L26
            java.io.InputStream r4 = r1.openInputStream(r4)     // Catch: java.lang.Throwable -> L21 java.io.FileNotFoundException -> L26
            byte[] r0 = com.blankj.utilcode.util.UtilsBridge.inputStream2Bytes(r4)     // Catch: java.io.FileNotFoundException -> L1f java.lang.Throwable -> L3d
            if (r4 == 0) goto L1e
            r4.close()     // Catch: java.io.IOException -> L1a
            goto L1e
        L1a:
            r4 = move-exception
            r4.printStackTrace()
        L1e:
            return r0
        L1f:
            r1 = move-exception
            goto L28
        L21:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L3e
        L26:
            r1 = move-exception
            r4 = r0
        L28:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r1 = "UriUtils"
            java.lang.String r2 = "uri to bytes failed."
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L3d
            if (r4 == 0) goto L3c
            r4.close()     // Catch: java.io.IOException -> L38
            goto L3c
        L38:
            r4 = move-exception
            r4.printStackTrace()
        L3c:
            return r0
        L3d:
            r0 = move-exception
        L3e:
            if (r4 == 0) goto L48
            r4.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r4 = move-exception
            r4.printStackTrace()
        L48:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.UriUtils.uri2Bytes(android.net.Uri):byte[]");
    }
}
