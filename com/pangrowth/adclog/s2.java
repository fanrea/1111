package com.pangrowth.adclog;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class s2 {
    public static final String a = "s2";

    public static File a(Context context) {
        File externalFilesDir = context.getExternalFilesDir("cloudMessage");
        if (externalFilesDir == null) {
            externalFilesDir = new File(context.getFilesDir(), "cloudMessage");
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdir();
        }
        return externalFilesDir;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.PrintStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable, java.io.FileInputStream, java.io.InputStream] */
    public static void a(File file, ZipOutputStream zipOutputStream, String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        if (file.isDirectory()) {
            String str2 = str + file.getName() + File.separator;
            if (file.exists()) {
                for (File file2 : file.listFiles()) {
                    a(file2, zipOutputStream, str2);
                }
                return;
            }
            return;
        }
        ?? r0 = System.out;
        ?? fileInputStream = "压缩：" + str + file.getName();
        r0.println(fileInputStream);
        if (!file.exists()) {
            return;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    BufferedInputStream bufferedInputStream3 = new BufferedInputStream(fileInputStream);
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i = bufferedInputStream3.read(bArr, 0, 8192);
                            if (i == -1) {
                                i.a(bufferedInputStream3);
                                i.a((Closeable) fileInputStream);
                                return;
                            }
                            zipOutputStream.write(bArr, 0, i);
                        }
                    } catch (Exception e) {
                        e = e;
                        throw new RuntimeException(e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream2 = bufferedInputStream3;
                        bufferedInputStream = bufferedInputStream2;
                        bufferedInputStream2 = fileInputStream;
                        i.a(bufferedInputStream);
                        i.a(bufferedInputStream2);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
                i.a(bufferedInputStream);
                i.a(bufferedInputStream2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable, java.io.OutputStream, java.util.zip.CheckedOutputStream] */
    public static void a(String str, String... strArr) throws Throwable {
        ?? r0;
        Closeable closeable;
        File file;
        Exception e;
        FileOutputStream fileOutputStream;
        ?? checkedOutputStream;
        ZipOutputStream zipOutputStream;
        File file2 = new File(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    checkedOutputStream = new CheckedOutputStream(fileOutputStream, new CRC32());
                } catch (Exception e2) {
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                    file = null;
                    closeable = null;
                }
            } catch (Exception e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                r0 = 0;
                closeable = null;
                i.a(closeable);
                i.a((Closeable) r0);
                i.a(fileOutputStream2);
                throw th;
            }
            try {
                zipOutputStream = new ZipOutputStream(checkedOutputStream);
            } catch (Exception e4) {
                e = e4;
                e = e;
                throw new RuntimeException(e);
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                file = checkedOutputStream;
                fileOutputStream2 = fileOutputStream;
                r0 = file;
                i.a(closeable);
                i.a((Closeable) r0);
                i.a(fileOutputStream2);
                throw th;
            }
            try {
                for (String str2 : strArr) {
                    File file3 = new File(str2);
                    if (!file3.exists()) {
                        throw new RuntimeException(str2 + "不存在！");
                    }
                    a(file3, zipOutputStream, "");
                }
                i.a(zipOutputStream);
                i.a((Closeable) checkedOutputStream);
                i.a(fileOutputStream);
            } catch (Exception e5) {
                e = e5;
                throw new RuntimeException(e);
            }
        } catch (Throwable th4) {
            th = th4;
            file = file2;
        }
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str) throws Throwable {
        FileInputStream fileInputStream;
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            zipOutputStream.putNextEntry(new ZipEntry(str + "/"));
            String str2 = str.length() == 0 ? "" : str + "/";
            for (int i = 0; i < fileArrListFiles.length; i++) {
                a(zipOutputStream, fileArrListFiles[i], str2 + fileArrListFiles[i].getName());
            }
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            System.out.println(str);
            while (true) {
                int i2 = fileInputStream.read();
                if (i2 == -1) {
                    i.a(fileInputStream);
                    return;
                }
                zipOutputStream.write(i2);
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            i.a(fileInputStream2);
            throw th;
        }
    }

    public static boolean a(InputStream inputStream, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs()) {
                    try {
                        inputStream.close();
                    } catch (Exception unused) {
                    }
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            fileOutputStream2.flush();
                            fileOutputStream2.close();
                            inputStream.close();
                            try {
                                inputStream.close();
                                return true;
                            } catch (Exception unused2) {
                                return true;
                            }
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    Log.d(a, "save inputstream error: " + e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused4) {
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused5) {
                        }
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (Exception unused6) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            boolean z = true;
            for (int i = 0; i < length; i++) {
                z = !fileArrListFiles[i].isDirectory() ? !(z && fileArrListFiles[i].delete()) : !(z && a(fileArrListFiles[i].getAbsolutePath()));
            }
            if (!z || !file.delete()) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str, String str2, String str3) throws Throwable {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    boolean zA = a(fileInputStream2, str2, str3);
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused) {
                    }
                    return zA;
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public static void b(String str, String str2) throws Throwable {
        Throwable th;
        ZipOutputStream zipOutputStream;
        File file = new File(str);
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream = null;
        }
        try {
            a(zipOutputStream, file, "");
            i.a(zipOutputStream);
        } catch (Throwable th3) {
            th = th3;
            i.a(zipOutputStream);
            throw th;
        }
    }

    public static String a(String str, String str2) {
        StringBuilder sb;
        Context context;
        File filesDir;
        File externalFilesDir;
        sb = new StringBuilder();
        f1.c().getClass();
        context = f1.f;
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "data_package":
                filesDir = context.getFilesDir();
                externalFilesDir = filesDir.getParentFile();
                return sb.append(externalFilesDir).append(str2).toString();
            case "sd_package_file":
                externalFilesDir = context.getExternalFilesDir(null);
                return sb.append(externalFilesDir).append(str2).toString();
            case "sd_package_cache":
                externalFilesDir = context.getExternalCacheDir();
                return sb.append(externalFilesDir).append(str2).toString();
            case "data_package_cache":
                externalFilesDir = context.getCacheDir();
                return sb.append(externalFilesDir).append(str2).toString();
            case "sd_package":
                filesDir = context.getExternalFilesDir(null);
                externalFilesDir = filesDir.getParentFile();
                return sb.append(externalFilesDir).append(str2).toString();
            case "data_package_file":
                externalFilesDir = context.getFilesDir();
                return sb.append(externalFilesDir).append(str2).toString();
            default:
                return null;
        }
    }
}
