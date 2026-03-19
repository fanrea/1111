package com.lingku.xuanshang.xutils.common.util;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.baidu.mobstat.forbes.Config;
import com.component.c.c;
import com.lingku.xuanshang.xutils.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FileUtil {
    public static boolean copy(String str, String str2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str2);
        IOUtil.deleteFileOrDir(file2);
        File parentFile = file2.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
            }
            try {
                IOUtil.copy(fileInputStream, fileOutputStream);
                IOUtil.closeQuietly(fileInputStream);
                IOUtil.closeQuietly(fileOutputStream);
                return true;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                try {
                    LogUtil.d(th.getMessage(), th);
                    return false;
                } finally {
                    IOUtil.closeQuietly(fileInputStream);
                    IOUtil.closeQuietly(fileOutputStream2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static boolean deleteFileOrDir(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                deleteFileOrDir(file2);
            }
        }
        return file.delete();
    }

    public static Boolean existsSdcard() {
        return Boolean.valueOf(Environment.getExternalStorageState().equals(c.a));
    }

    public static File getCacheDir(String str) {
        File externalCacheDir;
        File file = (!isDiskAvailable() || (externalCacheDir = x.app().getExternalCacheDir()) == null) ? null : new File(externalCacheDir, str);
        if (file == null) {
            file = new File(x.app().getCacheDir(), str);
        }
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static long getDiskAvailableSize() {
        long blockSize;
        long availableBlocks;
        if (!existsSdcard().booleanValue()) {
            return 0L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
        if (Build.VERSION.SDK_INT >= 18) {
            blockSize = statFs.getBlockSizeLong();
            availableBlocks = statFs.getAvailableBlocksLong();
        } else {
            blockSize = statFs.getBlockSize();
            availableBlocks = statFs.getAvailableBlocks();
        }
        return availableBlocks * blockSize;
    }

    public static long getFileOrDirSize(File file) {
        long fileOrDirSize = 0;
        if (!file.exists()) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                fileOrDirSize += getFileOrDirSize(file2);
            }
        }
        return fileOrDirSize;
    }

    public static boolean isDiskAvailable() {
        return getDiskAvailableSize() > Config.FULL_TRACE_LOG_LIMIT;
    }
}
