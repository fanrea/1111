package com.apm.insight.i;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.apm.insight.o.j;
import com.apm.insight.o.l;
import com.baidu.mobstat.forbes.Config;
import dalvik.system.BaseDexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c {
    private static List<String> a = new ArrayList();

    public static String a(Context context, String str, File file) throws IOException {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String strA = a(applicationInfo.sourceDir, str, file);
        if (strA == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 21) {
            return Config.EXCEPTION_MEMORY_LOW;
        }
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            for (String str2 : strArr) {
                strA = a(str2, str, file);
                if (strA == null) {
                    return null;
                }
            }
        }
        try {
            ClassLoader classLoader = c.class.getClassLoader();
            while (!(classLoader instanceof BaseDexClassLoader) && classLoader.getParent() != null) {
                classLoader = classLoader.getParent();
            }
            if (!(classLoader instanceof BaseDexClassLoader)) {
                return strA;
            }
            Field declaredField = BaseDexClassLoader.class.getDeclaredField("pathList");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(classLoader);
            Field declaredField2 = obj.getClass().getDeclaredField("nativeLibraryDirectories");
            declaredField2.setAccessible(true);
            for (String str3 : (String[]) declaredField2.get(obj)) {
                File file2 = new File(str3, System.mapLibraryName(str));
                if (file2.exists()) {
                    j.a(file2, file);
                    l.a(file.getAbsolutePath(), 493);
                    return null;
                }
            }
            return "not_found";
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public static String a(String str, String str2, File file) throws IOException {
        InputStream inputStream;
        ZipFile zipFile;
        String message;
        ZipEntry entry;
        FileOutputStream fileOutputStream = null;
        try {
            zipFile = new ZipFile(new File(str), 1);
            try {
                entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str2));
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            zipFile = null;
        }
        if (entry == null) {
            int iIndexOf = Build.CPU_ABI.indexOf(45);
            StringBuilder sbAppend = new StringBuilder().append("lib/");
            String str3 = Build.CPU_ABI;
            if (iIndexOf <= 0) {
                iIndexOf = Build.CPU_ABI.length();
            }
            String string = sbAppend.append(str3.substring(0, iIndexOf)).append("/").append(System.mapLibraryName(str2)).toString();
            ZipEntry entry2 = zipFile.getEntry(string);
            if (entry2 == null) {
                message = "Library entry not found:" + string;
                l.a((Closeable) null);
                l.a((Closeable) null);
                l.a(zipFile);
                return message;
            }
            entry = entry2;
        }
        file.createNewFile();
        InputStream inputStream2 = zipFile.getInputStream(entry);
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStream2.read(bArr);
                    if (i <= 0) {
                        l.a(file.getAbsolutePath(), 493);
                        l.a(fileOutputStream2);
                        l.a(inputStream2);
                        l.a(zipFile);
                        return null;
                    }
                    fileOutputStream2.write(bArr, 0, i);
                }
            } catch (Throwable th3) {
                fileOutputStream = fileOutputStream2;
                inputStream = inputStream2;
                th = th3;
                try {
                    message = th.getMessage();
                    l.a(fileOutputStream);
                    l.a(inputStream);
                    l.a(zipFile);
                    return message;
                } catch (Throwable th4) {
                    l.a(fileOutputStream);
                    l.a(inputStream);
                    l.a(zipFile);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            inputStream = inputStream2;
            th = th5;
        }
    }
}
