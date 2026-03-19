package com.luck.picture.lib.manager;

import android.content.Context;
import android.os.Environment;
import com.luck.picture.lib.basic.PictureMediaScannerConnection;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.interfaces.OnCallbackListener;
import com.luck.picture.lib.thread.PictureThreadUtils;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PictureCacheManager {
    public static void deleteCacheDirFile(String str) {
        deleteCacheDirFile(str, (OnCallbackListener<String>) null);
    }

    public static void deleteCacheDirFile(String str, OnCallbackListener<String> onCallbackListener) {
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isFile() && file.delete() && onCallbackListener != null) {
                    onCallbackListener.onCall(file.getAbsolutePath());
                }
            }
        }
    }

    public static void deleteCacheRefreshDirFile(Context context, int i) {
        deleteCacheDirFile(context, i, true, null);
    }

    public static void deleteCacheDirFile(Context context, int i) {
        deleteCacheDirFile(context, i, false, null);
    }

    public static void deleteCacheDirFile(Context context, int i, OnCallbackListener<String> onCallbackListener) {
        deleteCacheDirFile(context, i, false, onCallbackListener);
    }

    private static void deleteCacheDirFile(final Context context, int i, boolean z, OnCallbackListener<String> onCallbackListener) {
        File[] fileArrListFiles;
        File externalFilesDir = context.getExternalFilesDir(i == SelectMimeType.ofImage() ? Environment.DIRECTORY_PICTURES : Environment.DIRECTORY_MOVIES);
        if (externalFilesDir == null || (fileArrListFiles = externalFilesDir.listFiles()) == null) {
            return;
        }
        for (final File file : fileArrListFiles) {
            if (file.isFile() && file.delete()) {
                if (z) {
                    PictureThreadUtils.runOnUiThread(new Runnable() { // from class: com.luck.picture.lib.manager.PictureCacheManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            new PictureMediaScannerConnection(context, file.getAbsolutePath());
                        }
                    });
                } else if (onCallbackListener != null) {
                    onCallbackListener.onCall(file.getAbsolutePath());
                }
            }
        }
    }

    public static void deleteAllCacheDirFile(Context context) {
        deleteAllCacheDirFile(context, false, null);
    }

    public static void deleteAllCacheDirFile(Context context, OnCallbackListener<String> onCallbackListener) {
        deleteAllCacheDirFile(context, false, onCallbackListener);
    }

    public static void deleteAllCacheDirRefreshFile(Context context) {
        deleteAllCacheDirFile(context, true, null);
    }

    private static void deleteAllCacheDirFile(final Context context, boolean z, OnCallbackListener<String> onCallbackListener) {
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        File[] fileArrListFiles3;
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if (externalFilesDir != null && (fileArrListFiles3 = externalFilesDir.listFiles()) != null) {
            for (final File file : fileArrListFiles3) {
                if (file.isFile() && file.delete()) {
                    if (z) {
                        PictureThreadUtils.runOnUiThread(new Runnable() { // from class: com.luck.picture.lib.manager.PictureCacheManager.2
                            @Override // java.lang.Runnable
                            public void run() {
                                new PictureMediaScannerConnection(context, file.getAbsolutePath());
                            }
                        });
                    } else if (onCallbackListener != null) {
                        onCallbackListener.onCall(file.getAbsolutePath());
                    }
                }
            }
        }
        File externalFilesDir2 = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (externalFilesDir2 != null && (fileArrListFiles2 = externalFilesDir2.listFiles()) != null) {
            for (final File file2 : fileArrListFiles2) {
                if (file2.isFile() && file2.delete()) {
                    if (z) {
                        PictureThreadUtils.runOnUiThread(new Runnable() { // from class: com.luck.picture.lib.manager.PictureCacheManager.3
                            @Override // java.lang.Runnable
                            public void run() {
                                new PictureMediaScannerConnection(context, file2.getAbsolutePath());
                            }
                        });
                    } else if (onCallbackListener != null) {
                        onCallbackListener.onCall(file2.getAbsolutePath());
                    }
                }
            }
        }
        File externalFilesDir3 = context.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        if (externalFilesDir3 == null || (fileArrListFiles = externalFilesDir3.listFiles()) == null) {
            return;
        }
        for (final File file3 : fileArrListFiles) {
            if (file3.isFile() && file3.delete()) {
                if (z) {
                    PictureThreadUtils.runOnUiThread(new Runnable() { // from class: com.luck.picture.lib.manager.PictureCacheManager.4
                        @Override // java.lang.Runnable
                        public void run() {
                            new PictureMediaScannerConnection(context, file3.getAbsolutePath());
                        }
                    });
                } else if (onCallbackListener != null) {
                    onCallbackListener.onCall(file3.getAbsolutePath());
                }
            }
        }
    }
}
