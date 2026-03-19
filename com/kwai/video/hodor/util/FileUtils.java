package com.kwai.video.hodor.util;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FileUtils {
    public static boolean isValidDir(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (!file.mkdirs()) {
                file.mkdir();
            }
            if (file.exists()) {
                if (file.canWrite()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return file.exists() && file.canWrite();
        }
    }

    public static File getDefaultCacheDir(Context context, boolean z) {
        String absolutePath = ILogConst.CACHE_PLAY_REASON_NULL;
        if (z) {
            File filesDir = context.getFilesDir();
            if (isValidDir(filesDir)) {
                Timber.d("[getDefaultCacheDir] getFilesDir:%s is valid", filesDir.getAbsolutePath());
                return filesDir;
            }
            Object[] objArr = new Object[1];
            objArr[0] = filesDir == null ? ILogConst.CACHE_PLAY_REASON_NULL : filesDir.getAbsolutePath();
            Timber.w("[getDefaultCacheDir] getFilesDir:%s is not valid", objArr);
        }
        File externalFilesDir = context.getApplicationContext().getExternalFilesDir(null);
        if (isValidDir(externalFilesDir)) {
            Timber.d("[getDefaultCacheDir] getExternalFilesDir:%s is valid", externalFilesDir.getAbsolutePath());
            return externalFilesDir;
        }
        Object[] objArr2 = new Object[1];
        objArr2[0] = externalFilesDir == null ? ILogConst.CACHE_PLAY_REASON_NULL : externalFilesDir.getAbsolutePath();
        Timber.w("[getDefaultCacheDir] getExternalFilesDir:%s is not valid", objArr2);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (isValidDir(externalStorageDirectory)) {
            Timber.d("[getDefaultCacheDir] externalStorageDir:%s is valid", externalStorageDirectory.getAbsolutePath());
            return externalStorageDirectory;
        }
        Object[] objArr3 = new Object[1];
        objArr3[0] = externalStorageDirectory == null ? ILogConst.CACHE_PLAY_REASON_NULL : externalStorageDirectory.getAbsolutePath();
        Timber.w("[getDefaultCacheDir] externalStorageDir:%s is not valid", objArr3);
        File dir = context.getDir("gdata", 0);
        if (isValidDir(dir)) {
            Timber.d("[getDefaultCacheDir] getDir(gdata):%s is valid", dir.getAbsolutePath());
            return dir;
        }
        Object[] objArr4 = new Object[1];
        if (dir != null) {
            absolutePath = dir.getAbsolutePath();
        }
        objArr4[0] = absolutePath;
        Timber.e("[getDefaultCacheDir]AwesomeCache getDir(gdata) fail, Hodor won't work due to no valid cache dir path", objArr4);
        return null;
    }

    public static long getAvailableBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            long availableBytes = statFs.getAvailableBytes();
            Timber.d("[getAvailableBytes] avilabeBytes new way:%dMB, path:%s", Long.valueOf(availableBytes / 1048576), str);
            return availableBytes;
        }
        long blockSize = statFs.getBlockSize() * statFs.getAvailableBlocks();
        Timber.d("[getAvailableBytes] avilabeBytes old way:%dMB, path:%s", Long.valueOf(blockSize / 1048576), str);
        return blockSize;
    }
}
