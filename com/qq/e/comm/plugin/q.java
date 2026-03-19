package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import java.io.File;
import java.io.FileFilter;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class q {
    public static String a(Context context, String str) {
        return (String) pro.getobjresult(541, 1, context, str);
    }

    public static String a(String str) {
        return str;
    }

    public static boolean c(ApkDownloadTask apkDownloadTask) {
        File fileB = gu.b(a(apkDownloadTask.r()) + ".apk_0");
        return fileB != null && fileB.exists() && fileB.length() > 0;
    }

    public static boolean d(ApkDownloadTask apkDownloadTask) {
        File fileB = b(apkDownloadTask);
        return fileB != null && fileB.exists();
    }

    /* compiled from: A */
    class a implements FileFilter {
        final /* synthetic */ File a;

        a(File file) {
            this.a = file;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getAbsolutePath().startsWith(this.a.getAbsolutePath());
        }
    }

    public static boolean b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return n3.b() ? context.getPackageManager().getPackageInfo(str, 256) != null : ct.b(context, str) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Pair<Integer, String> b(File file, String str, Context context) {
        if (file != null && file.exists()) {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            if (packageArchiveInfo == null) {
                String str2 = str + "，" + file.length() + "，" + gp.a(file);
                if (!gu.c(file)) {
                    return new Pair<>(1, "Not Apk：" + str2);
                }
                return new Pair<>(2, "Apk packageInfo is null：" + str2);
            }
            if (!packageArchiveInfo.packageName.equals(str)) {
                return new Pair<>(8, "Package name is not  inconsistent:" + packageArchiveInfo.packageName + "，" + str);
            }
            return new Pair<>(0, "");
        }
        return new Pair<>(4, "Apk file not exist");
    }

    public static File b(ApkDownloadTask apkDownloadTask) {
        return gu.b(a(apkDownloadTask.r()) + ".apk");
    }

    public static boolean a(File file, String str, Context context) {
        return ((Integer) b(file, str, context).first).intValue() == 0;
    }

    public static boolean a(ApkDownloadTask apkDownloadTask) {
        File[] fileArrListFiles;
        try {
            File fileA = gu.a();
            if (fileA != null && (fileArrListFiles = fileA.listFiles(new a(b(apkDownloadTask)))) != null && fileArrListFiles.length != 0) {
                for (File file : fileArrListFiles) {
                    file.delete();
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
