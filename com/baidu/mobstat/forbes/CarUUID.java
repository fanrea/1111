package com.baidu.mobstat.forbes;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class CarUUID {
    private static final Pattern a = Pattern.compile("(\\w{32})");

    public static String optUUID(Context context) {
        String strB = b(context);
        if (strB != null) {
            return strB;
        }
        String strC = c(context);
        if (strC != null) {
            a(context, strC);
            return strC;
        }
        String strA = a(context);
        if (strA != null) {
            a(context, strA);
            return strA;
        }
        return "";
    }

    private static String a(Context context) {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private static String b(Context context) {
        return a(context.getFileStreamPath("libdueros_uuid.so"));
    }

    private static String c(Context context) {
        String strA;
        List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        for (ApplicationInfo applicationInfo2 : installedApplications) {
            if (!applicationInfo.packageName.equals(applicationInfo2.packageName) && (strA = a(new File(new File(applicationInfo2.dataDir, "files"), "libdueros_uuid.so"))) != null) {
                return strA;
            }
        }
        return null;
    }

    private static boolean a(Context context, String str) {
        boolean z = false;
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            fileOutputStreamOpenFileOutput = context.openFileOutput("libdueros_uuid.so", Build.VERSION.SDK_INT >= 21 ? 0 : 1);
            if (a(fileOutputStreamOpenFileOutput, str)) {
                if (Build.VERSION.SDK_INT < 21) {
                    ao.a(fileOutputStreamOpenFileOutput);
                    return true;
                }
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                File fileStreamPath = context.getFileStreamPath("libdueros_uuid.so");
                if (a(new File(applicationInfo.dataDir), 457)) {
                    if (a(fileStreamPath, 484)) {
                        z = true;
                    }
                }
                ao.a(fileOutputStreamOpenFileOutput);
                return z;
            }
        } catch (Exception e) {
        } catch (Throwable th) {
            ao.a(fileOutputStreamOpenFileOutput);
            throw th;
        }
        ao.a(fileOutputStreamOpenFileOutput);
        return false;
    }

    private static String a(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    String str = new String(bArr, 0, fileInputStream.read(bArr));
                    String str2 = a.matcher(str).matches() ? str : null;
                    ao.a(fileInputStream);
                    return str2;
                } catch (Exception e) {
                    ao.a(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    ao.a(fileInputStream2);
                    throw th;
                }
            } catch (Exception e2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    private static boolean a(FileOutputStream fileOutputStream, String str) throws IOException {
        try {
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean a(File file, int i) throws ErrnoException {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        try {
            Os.chmod(file.getAbsolutePath(), i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
