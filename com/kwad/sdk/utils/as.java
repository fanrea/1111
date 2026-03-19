package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class as {

    public interface a {
        void g(Throwable th);

        void qa();
    }

    public static boolean aE(Context context, String str) {
        try {
            PackageInfo packageInfo = y.getPackageInfo(context, str, 0);
            if (packageInfo != null && packageInfo.applicationInfo != null) {
                if (packageInfo.applicationInfo.enabled) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean aF(Context context, String str) {
        try {
            PackageInfo packageInfoNoCache = y.getPackageInfoNoCache(context, str, 0);
            if (packageInfoNoCache != null && packageInfoNoCache.applicationInfo != null) {
                if (packageInfoNoCache.applicationInfo.enabled) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int aG(Context context, String str) {
        if (context == null || str == null || d.cP(context)) {
            return -1;
        }
        try {
            if (context.getApplicationInfo().targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33) {
                return -1;
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") != 0) {
                return -1;
            }
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str);
            return (file.exists() && file.isDirectory()) ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static boolean aH(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            com.kwad.sdk.core.d.c.d("PackageUtil", "openApp context: " + context);
            launchIntentForPackage.setFlags(337641472);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean ix(String str) {
        return a(str, null);
    }

    public static boolean a(String str, a aVar) {
        Uri uriFromFile;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ar.apc().ape();
            Context context = ServiceProvider.getContext();
            File file = new File(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.addFlags(3);
            if (Build.VERSION.SDK_INT >= 24) {
                uriFromFile = getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
            } else {
                uriFromFile = Uri.fromFile(file);
            }
            intent.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
            Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                context.grantUriPermission(it.next().activityInfo.packageName, uriFromFile, 3);
            }
            context.startActivity(intent);
            com.kwad.sdk.core.c.b.aaf();
            ar.apc().x(com.kwad.sdk.core.c.b.getCurrentActivity());
            if (aVar == null) {
                return true;
            }
            aVar.qa();
            return true;
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.g(th);
            }
            return false;
        }
    }

    private static Uri getUriForFile(Context context, String str, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        try {
            return FileProvider.getUriForFile(context, str, file);
        } catch (IllegalArgumentException unused) {
            if (Build.VERSION.SDK_INT < 24) {
                com.kwad.sdk.core.d.c.w("PackageUtil", "Returning Uri.fromFile to avoid Huawei 'external-files-path' bug for pre-N devices");
                return Uri.fromFile(file);
            }
            com.kwad.sdk.core.d.c.w("PackageUtil", "ANR Risk -- Copying the file the location cache to avoid Huawei 'external-files-path' bug for N+ devices");
            File file2 = new File(context.getCacheDir(), "ksadsdk");
            w.ae(file2);
            file2.mkdirs();
            File file3 = new File(file2, file.getName());
            try {
                file3.createNewFile();
            } catch (Exception unused2) {
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file3);
                } catch (IOException e) {
                    e = e;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i != -1) {
                            fileOutputStream.write(bArr, 0, i);
                        } else {
                            com.kwad.sdk.core.d.c.i("PackageUtil", "Completed Android N+ Huawei file copy. Attempting to return the cached file");
                            Uri uriForFile = FileProvider.getUriForFile(context, str, file3);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                            return uriForFile;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        com.kwad.sdk.core.d.c.e("PackageUtil", "Failed to copy the Huawei file. Re-throwing exception", e);
                        throw new IllegalArgumentException("Huawei devices are unsupported for Android N", e);
                    } catch (Throwable th2) {
                        th = th2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = fileInputStream2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        }
    }

    public static void aB(String str, String str2) {
        com.kwad.sdk.core.d.c.w("PackageUtil", "saveDownloadFile " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot save package, has no download apk info.");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot save package, download apk is not exists.");
            return;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        ag.f(context, str2, file.length());
        try {
            ag.g(context, str2, com.kwad.sdk.utils.a.getFileMD5(file));
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public static String iy(String str) {
        PackageInfo packageArchiveInfo;
        if (!new File(str).exists()) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot save package, download apk is not exists.");
            return null;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.applicationInfo.packageName;
    }

    public static int aC(String str, String str2) {
        com.kwad.sdk.core.d.c.w("PackageUtil", "isPackageChanged " + str + " packageName " + str2);
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 0;
        }
        long jAk = ag.ak(context, str);
        String strAl = ag.al(context, str);
        if (TextUtils.isEmpty(strAl) || jAk <= 0) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, has no download apk info.");
            return 0;
        }
        PackageInfo packageInfoNoCache = y.getPackageInfoNoCache(context, str2, 0);
        if (packageInfoNoCache == null) {
            return 0;
        }
        if (TextUtils.isEmpty(str2) || packageInfoNoCache == null || packageInfoNoCache.applicationInfo == null || TextUtils.isEmpty(packageInfoNoCache.applicationInfo.publicSourceDir)) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, cannot get installed apk info.");
            return 0;
        }
        File file = new File(packageInfoNoCache.applicationInfo.publicSourceDir);
        if (!file.exists()) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, insgtalled apk is not exists.");
            return 0;
        }
        if (jAk != file.length()) {
            return 1;
        }
        if (TextUtils.isEmpty(strAl)) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, cannot calculate md5 of download file.");
            return 0;
        }
        String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
        if (!TextUtils.isEmpty(fileMD5)) {
            return strAl.equalsIgnoreCase(fileMD5) ? 2 : 1;
        }
        com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, cannot calculate md5 of installed file.");
        return 0;
    }
}
