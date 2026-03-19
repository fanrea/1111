package com.bytedance.common.utility.io;

import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.common.utility.reflect.JavaCalls;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.zip.ZipFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class IOUtils {
    private IOUtils() {
    }

    public static void deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    public static boolean exists(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean mkdir(String str) {
        return new File(str).mkdirs();
    }

    public static boolean copyFile(File file, File file2) throws IOException {
        if (!file.exists() || !file.isFile() || file2.isDirectory()) {
            return false;
        }
        if (file2.exists()) {
            file2.delete();
        }
        try {
            byte[] bArr = new byte[2048];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            while (true) {
                int i = bufferedInputStream.read(bArr);
                if (i != -1) {
                    bufferedOutputStream.write(bArr, 0, i);
                } else {
                    bufferedInputStream.close();
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean copyFile(String str, String str2) {
        return copyFile(new File(str), new File(str2));
    }

    public static String readFileFirstLine(String str) throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
            try {
                String line = bufferedReader2.readLine();
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return line;
            } catch (Exception unused) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return "";
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void deletePath(String str) {
        String str2;
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str3 : list) {
                if (str3 != null) {
                    if (str.endsWith(File.separator)) {
                        str2 = str + str3;
                    } else {
                        str2 = str + File.separator + str3;
                    }
                    File file2 = new File(str2);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        deletePath(str2);
                    }
                }
            }
            file.delete();
        }
    }

    public static void clearPath(String str) {
        String str2;
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            for (String str3 : file.list()) {
                if (str.endsWith(File.separator)) {
                    str2 = str + str3;
                } else {
                    str2 = str + File.separator + str3;
                }
                File file2 = new File(str2);
                if (file2.isFile()) {
                    file2.delete();
                }
                if (file2.isDirectory()) {
                    deletePath(str2);
                }
            }
        }
    }

    public static long getFileSize(String str) {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                try {
                    length += getFileSize(file2.getAbsolutePath());
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    return 0L;
                } catch (StackOverflowError e2) {
                    e2.printStackTrace();
                    return 0L;
                }
            }
        }
        return length;
    }

    public static String getFileName(String str) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        int iLastIndexOf = str.lastIndexOf("/");
        return (iLastIndexOf <= 0 || iLastIndexOf >= str.length() + (-1)) ? str : str.substring(iLastIndexOf + 1);
    }

    public static String getParentFilePath(String str) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        int iLastIndexOf = str.lastIndexOf("/");
        if (iLastIndexOf >= 0) {
            return str.substring(0, iLastIndexOf);
        }
        return null;
    }

    public static String getFileNameWithoutExtension(String str) {
        int iLastIndexOf;
        String fileName = getFileName(str);
        return (fileName == null || fileName.length() <= 0 || (iLastIndexOf = fileName.lastIndexOf(46)) <= 0) ? fileName : fileName.substring(0, iLastIndexOf);
    }

    public static String getFileExtension(String str) {
        int iLastIndexOf = str.lastIndexOf(".");
        return (iLastIndexOf < 0 || iLastIndexOf >= str.length() + (-1)) ? "" : str.substring(iLastIndexOf + 1).toUpperCase(Locale.getDefault());
    }

    public static boolean renameFile(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists()) {
            return file.renameTo(file2);
        }
        return false;
    }

    public static long getAvailableBytes(String str) {
        try {
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                return 0L;
            }
            StatFs statFs = new StatFs(str);
            return statFs.getBlockSize() * statFs.getAvailableBlocks();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long getAllBytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                StatFs statFs = new StatFs(str);
                return statFs.getBlockSize() * statFs.getBlockCount();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0L;
    }

    public static boolean canWrite(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        File file2 = new File(file, "." + System.currentTimeMillis());
        boolean zMkdir = file2.mkdir();
        return zMkdir ? file2.delete() : zMkdir;
    }

    public static void setPermissions(String str, int i) {
        JavaCalls.callStaticMethod("android.os.FileUtils", str, Integer.valueOf(i), -1, -1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        if (r0 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        if (r0 == null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void write(java.lang.String r3, java.lang.String r4, boolean r5) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L32
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L32
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L32
            if (r2 != 0) goto L16
            java.io.File r2 = r1.getParentFile()     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L32
            r2.mkdirs()     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L32
            r1.createNewFile()     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L32
        L16:
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L32
            r1.<init>(r3, r5)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L32
            r1.write(r4)     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
            r1.close()     // Catch: java.lang.Exception -> L39
            goto L39
        L22:
            r3 = move-exception
            r0 = r1
            goto L29
        L25:
            r3 = move-exception
            r0 = r1
            goto L33
        L28:
            r3 = move-exception
        L29:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L39
        L2e:
            r0.close()     // Catch: java.lang.Exception -> L39
            goto L39
        L32:
            r3 = move-exception
        L33:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L39
            goto L2e
        L39:
            return
        L3a:
            r3 = move-exception
            if (r0 == 0) goto L40
            r0.close()     // Catch: java.lang.Exception -> L40
        L40:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.utility.io.IOUtils.write(java.lang.String, java.lang.String, boolean):void");
    }

    public static void close(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void close(ZipFile zipFile) throws IOException {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (IOException unused) {
        }
    }
}
