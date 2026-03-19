package com.bytedance.common.utility.io;

import android.os.Environment;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.component.c.c;
import com.sigmob.sdk.archives.tar.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class FileUtils {
    private static final byte[] GIF87A = {71, 73, 70, 56, e.O, 97};
    private static final byte[] GIF89A = {71, 73, 70, 56, 57, 97};
    private static final byte[] JPEG = {-1, -40, -1};
    private static final byte[] PNG = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final String TAG = "FileUtils";

    public enum ImageType {
        UNKNOWN,
        JPG,
        PNG,
        GIF
    }

    private FileUtils() {
    }

    public static InputStream getInputStream(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (Exception e) {
            try {
                e.printStackTrace();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static byte[] getByteArray(String str) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) fileInputStream.read();
            }
            fileInputStream.close();
            return bArr;
        } catch (Exception e) {
            try {
                e.printStackTrace();
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static boolean copyFile(String str, String str2, String str3) throws Throwable {
        if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2) || StringUtils.isEmpty(str3)) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    boolean zSaveInputStream = saveInputStream(fileInputStream2, str2, str3);
                    try {
                        fileInputStream2.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return zSaveInputStream;
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public static boolean saveInputStream(InputStream inputStream, String str, String str2) throws Throwable {
        if (inputStream == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (!file.exists() && !file.mkdirs()) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str2));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    inputStream.close();
                    if (inputStream == null) {
                        return true;
                    }
                    try {
                        inputStream.close();
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    Logger.d(TAG, "save inputstream error: " + e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    if (inputStream == null) {
                        throw th;
                    }
                    try {
                        inputStream.close();
                        throw th;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static ImageType getImageType(String str) {
        if (!StringUtils.isEmpty(str)) {
            return getImageType(new File(str));
        }
        return ImageType.UNKNOWN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0072 -> B:64:0x0075). Please report as a decompilation issue!!! */
    public static ImageType getImageType(File file) throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr;
        if (file == null || !file.exists()) {
            return ImageType.UNKNOWN;
        }
        ImageType imageType = ImageType.UNKNOWN;
        FileInputStream fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        fileInputStream2 = null;
        try {
        } catch (Exception e) {
            e.printStackTrace();
            fileInputStream2 = fileInputStream2;
        }
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    bArr = new byte[8];
                    fileInputStream.read(bArr);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream3 = fileInputStream;
                    e.printStackTrace();
                    fileInputStream2 = fileInputStream3;
                    if (fileInputStream3 != null) {
                        fileInputStream3.close();
                        fileInputStream2 = fileInputStream3;
                    }
                    return imageType;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
            if (!checkSignature(bArr, GIF89A) && !checkSignature(bArr, GIF87A)) {
                if (checkSignature(bArr, JPEG)) {
                    ImageType imageType2 = ImageType.JPG;
                    try {
                        fileInputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    return imageType2;
                }
                byte[] bArr2 = PNG;
                if (!checkSignature(bArr, bArr2)) {
                    fileInputStream.close();
                    fileInputStream2 = bArr2;
                    return imageType;
                }
                ImageType imageType3 = ImageType.PNG;
                try {
                    fileInputStream.close();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                return imageType3;
            }
            ImageType imageType4 = ImageType.GIF;
            try {
                fileInputStream.close();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            return imageType4;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isGif(File file) {
        return getImageType(file) == ImageType.GIF;
    }

    public static boolean exists(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    private static boolean checkSignature(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void chmod(String str, int i) {
        Method method;
        int iIntValue;
        try {
            Class<?> cls = Class.forName("android.os.FileUtils");
            if (cls == null || (method = cls.getMethod("setPermissions", String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE)) == null || (iIntValue = ((Integer) method.invoke(null, str, Integer.valueOf(i), -1, -1)).intValue()) == 0) {
                return;
            }
            Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() returned " + iIntValue + " for '" + str + "', probably didn't work.");
        } catch (ClassNotFoundException unused) {
            Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - ClassNotFoundException.");
        } catch (IllegalAccessException unused2) {
            Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - IllegalAccessException.");
        } catch (NoSuchMethodException unused3) {
            Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - NoSuchMethodException.");
        } catch (InvocationTargetException unused4) {
            Logger.d("NetHackDbg", "android.os.FileUtils.setPermissions() failed - InvocationTargetException.");
        } catch (Throwable unused5) {
        }
    }

    public static String getFileNameWithoutExtension(String str) {
        int iLastIndexOf;
        String name = new File(str).getName();
        return (StringUtils.isEmpty(name) || -1 == (iLastIndexOf = name.lastIndexOf("."))) ? "" : name.substring(0, iLastIndexOf);
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(".");
        return iLastIndexOf == -1 ? "" : str.substring(iLastIndexOf + 1);
    }

    public static void clearDir(String str) throws Exception {
        File file = new File(str);
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    removeDir(fileArrListFiles[i].getAbsolutePath());
                } else if (fileArrListFiles[i].isFile()) {
                    fileArrListFiles[i].delete();
                }
            }
        }
    }

    public static void removeDir(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    removeDir(fileArrListFiles[i].getAbsolutePath());
                } else {
                    fileArrListFiles[i].delete();
                }
            }
            file.delete();
        }
    }

    public static void clearDir(String str, Set<String> set) throws Exception {
        File file = new File(str);
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    removeDir(fileArrListFiles[i].getAbsolutePath(), set);
                } else if (fileArrListFiles[i].isFile()) {
                    String name = fileArrListFiles[i].getName();
                    if (set == null || !set.contains(name)) {
                        fileArrListFiles[i].delete();
                    }
                }
            }
        }
    }

    public static void removeDir(String str, Set<String> set) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            int length = fileArrListFiles.length;
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    removeDir(fileArrListFiles[i].getAbsolutePath(), set);
                } else {
                    String name = fileArrListFiles[i].getName();
                    if (set == null || !set.contains(name)) {
                        fileArrListFiles[i].delete();
                    }
                }
            }
        }
    }

    public static long getDirectorySize(File file, boolean z) {
        long length;
        long j = 0;
        if (!file.exists() && file.isDirectory()) {
            return 0L;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                length = getDirectorySize(file2, z);
            } else if (file2.isFile()) {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getCacheDirPath(android.content.Context r3) throws java.lang.NullPointerException {
        /*
            if (r3 == 0) goto L4b
            r0 = 0
            java.io.File r1 = r3.getCacheDir()     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L13
            java.io.File r3 = r3.getCacheDir()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L3c
        L11:
            r0 = r3
            goto L3c
        L13:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r1.<init>()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "/data/data/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = r3.getPackageName()     // Catch: java.lang.Throwable -> L3c
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "/cache/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L3c
            r2 = 0
            java.io.File r3 = r3.getDir(r1, r2)     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3c
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L3c
            goto L11
        L3c:
            boolean r3 = com.bytedance.common.utility.StringUtils.isEmpty(r0)
            if (r3 != 0) goto L43
            return r0
        L43:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r0 = "Cannot Create Cache Dir"
            r3.<init>(r0)
            throw r3
        L4b:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r0 = "Context is NUll"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.utility.io.FileUtils.getCacheDirPath(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFilesDirPath(android.content.Context r3) throws java.lang.NullPointerException {
        /*
            if (r3 == 0) goto L4b
            r0 = 0
            java.io.File r1 = r3.getFilesDir()     // Catch: java.lang.Throwable -> L3c
            if (r1 == 0) goto L13
            java.io.File r3 = r3.getFilesDir()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L3c
        L11:
            r0 = r3
            goto L3c
        L13:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            r1.<init>()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "/data/data/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = r3.getPackageName()     // Catch: java.lang.Throwable -> L3c
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "/files/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L3c
            r2 = 0
            java.io.File r3 = r3.getDir(r1, r2)     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L3c
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L3c
            goto L11
        L3c:
            boolean r3 = com.bytedance.common.utility.StringUtils.isEmpty(r0)
            if (r3 != 0) goto L43
            return r0
        L43:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r0 = "Cannot Create Files Dir"
            r3.<init>(r0)
            throw r3
        L4b:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r0 = "Context is NUll"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.common.utility.io.FileUtils.getFilesDirPath(android.content.Context):java.lang.String");
    }

    public static boolean isExternalStorageWritable() {
        return c.a.equals(Environment.getExternalStorageState());
    }

    public static boolean isExternalStorageReadable() {
        String externalStorageState = Environment.getExternalStorageState();
        return c.a.equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }
}
