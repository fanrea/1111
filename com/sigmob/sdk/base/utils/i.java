package com.sigmob.sdk.base.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bu;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i {
    public static String a = "SigHtmlResource";
    public static String b = "SigHtmlPrivacy";
    public static String c = "SigZipResource";
    public static String d = "SigCrashResource";
    private static String e;
    private static String f;
    private static File g;
    private static String h;

    public static File a(Context context) {
        try {
            if (g == null) {
                File file = new File(d(), "SigDownload");
                g = file;
                if (!file.exists()) {
                    g.mkdirs();
                }
            }
        } catch (Throwable unused) {
        }
        return g;
    }

    public static File a(File parentPath, String child) {
        if (parentPath == null || child == null) {
            return null;
        }
        return new File(parentPath, child);
    }

    public static File a(String parentPath, String child) {
        if (parentPath == null || child == null) {
            return null;
        }
        return new File(parentPath, child);
    }

    public static String a() {
        if (e == null) {
            File cacheDir = com.sigmob.sdk.b.e().getCacheDir();
            if (cacheDir != null && h != null) {
                File file = new File(cacheDir, h);
                if (!file.exists()) {
                    file.mkdirs();
                }
                cacheDir = file;
            }
            e = cacheDir.getAbsolutePath();
        }
        return e;
    }

    public static String a(String fileName) {
        int iLastIndexOf = fileName.lastIndexOf(".");
        return iLastIndexOf != -1 ? fileName.substring(iLastIndexOf) : "";
    }

    public static void a(Context context, String folderName) {
        h = folderName;
    }

    public static File[] a(File[] files, int count) {
        if (files == null || files.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(files));
        for (File file : files) {
            if (arrayList.size() <= count) {
                break;
            }
            if (file.exists()) {
                file.delete();
                arrayList.remove(file);
                SigmobLog.d("file delete " + file.getName());
            }
        }
        return (File[]) arrayList.toArray(new File[0]);
    }

    public static File b(String data, String fileName) {
        try {
            File fileA = a(d(), a);
            if (!fileA.exists()) {
                fileA.mkdirs();
            }
            File file = new File(fileA, fileName);
            SigmobLog.d("SigHtmlResource: " + file.getAbsolutePath());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
            return file;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String b() {
        String str = a() + File.separator + "videoAd";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String b(String fileName) {
        int iLastIndexOf = fileName.lastIndexOf(".");
        return iLastIndexOf != -1 ? fileName.substring(0, iLastIndexOf) : fileName;
    }

    public static String c() {
        String str = a() + File.separator + "webCache";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static synchronized String c(String placementId) {
        return a() + File.separator + "splashAdUnit" + File.separator + placementId;
    }

    public static File d(String fileDir) {
        try {
            File fileA = a(d(), fileDir);
            if (fileA != null && !fileA.exists()) {
                fileA.mkdirs();
            }
            return fileA;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d() {
        if (f == null) {
            boolean zEquals = Environment.getExternalStorageState().equals(com.component.c.c.a);
            boolean zIsExternalStorageRemovable = Environment.isExternalStorageRemovable();
            File cacheDir = null;
            if (zEquals && !zIsExternalStorageRemovable) {
                cacheDir = com.sigmob.sdk.b.e().getExternalCacheDir();
            }
            if (cacheDir == null) {
                cacheDir = com.sigmob.sdk.b.e().getCacheDir();
            }
            if (cacheDir != null && h != null) {
                File file = new File(cacheDir, h);
                if (!file.exists()) {
                    file.mkdirs();
                }
                f = file.getAbsolutePath();
            }
        }
        return f;
    }

    public static File e(String parentPath) {
        if (parentPath == null) {
            return null;
        }
        return new File(parentPath);
    }

    public static String e() {
        String str = a() + File.separator + "splashAd";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static File f(String fileDir) {
        try {
            File fileA = a(d(), fileDir);
            if (fileA != null && !fileA.exists()) {
                fileA.mkdirs();
            }
            return fileA;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String f() {
        String str = a() + File.separator + "nativeAd";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String g() {
        String str = a() + File.separator + "downloadAPKLog";
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public static synchronized String h() {
        return a() + File.separator + bu.a + File.separator + "sdkLog.log";
    }

    public static void i() {
        if (TextUtils.isEmpty(e)) {
            return;
        }
        try {
            File file = new File(e);
            if (file.exists()) {
                FileUtil.deleteDirectory(e);
            }
            if (!file.exists() || file.isFile()) {
                file.mkdirs();
            }
        } catch (Throwable unused) {
        }
    }

    public static File j() {
        try {
            File fileA = a(d(), d);
            if (!fileA.exists()) {
                fileA.mkdirs();
            }
            return a(fileA, String.format(Locale.getDefault(), "%d.log", Long.valueOf(System.currentTimeMillis() / 1000)));
        } catch (Throwable th) {
            SigmobLog.d("createCrash fail", th);
            return null;
        }
    }

    public static File[] k() {
        try {
            File fileA = a(d(), d);
            if (fileA.exists()) {
                return FileUtil.orderByDate(fileA.getAbsolutePath());
            }
            fileA.mkdirs();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
