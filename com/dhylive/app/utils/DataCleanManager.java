package com.dhylive.app.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.component.c.c;
import java.io.File;
import java.math.BigDecimal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DataCleanManager {
    private static final String TAG = "DataCleanManager";

    public static String getTotalCacheSize(Context context) throws Exception {
        long folderSize = getFolderSize(context.getCacheDir());
        if (Environment.getExternalStorageState().equals(c.a)) {
            folderSize += getFolderSize(context.getExternalCacheDir());
        }
        return getFormatSize(folderSize);
    }

    public static void clearAllCache(Context context) {
        deleteDir(context.getCacheDir());
        if (Environment.getExternalStorageState().equals(c.a)) {
            deleteDir(context.getExternalCacheDir());
        }
    }

    private static boolean deleteDir(File file) {
        if (file != null && file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static long getFolderSize(File file) throws Exception {
        long length;
        long j = 0;
        try {
            File[] fileArrListFiles = file.listFiles();
            for (int i = 0; i < fileArrListFiles.length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    length = getFolderSize(fileArrListFiles[i]);
                } else {
                    length = fileArrListFiles[i].length();
                }
                j += length;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    public static String getFormatSize(long j) {
        Log.v(TAG, "size==" + j);
        long j2 = j / 1024;
        double d = j2;
        if (d < 1.0d) {
            return j2 + "KB";
        }
        double d2 = d / 1024.0d;
        if (d2 < 1.0d) {
            return new BigDecimal(Double.toString(d)).setScale(1, 4).toPlainString() + "KB";
        }
        double d3 = d2 / 1024.0d;
        if (d3 < 1.0d) {
            return new BigDecimal(Double.toString(d2)).setScale(1, 4).toPlainString() + "MB";
        }
        double d4 = d3 / 1024.0d;
        if (d4 < 1.0d) {
            return new BigDecimal(Double.toString(d3)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d4).setScale(2, 4).toPlainString() + "TB";
    }
}
