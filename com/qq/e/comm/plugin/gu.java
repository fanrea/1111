package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.zip.ZipFile;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class gu {
    public static File f(String str) {
        return new File(i() + File.separator + str);
    }

    public static File g(String str) {
        return new File(j().getAbsolutePath() + File.separator + str);
    }

    public static File h() {
        File file = new File(j(), "tpl4native");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File i() {
        return new File(j().getAbsolutePath() + File.separator + "preload2");
    }

    public static File j() {
        return r1.d().a().getDir("adnet", 0);
    }

    public static File k() {
        return new File(m().getAbsolutePath() + File.separator + "report_cgi");
    }

    public static File l() {
        File file = new File(r1.d().a().getCacheDir(), "resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File m() {
        File file = new File(j().getAbsolutePath() + File.separator + "retry");
        file.mkdirs();
        return file;
    }

    public static File n() {
        File file = new File(j(), "dynamic");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File o() {
        File file = new File(e(), "video");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File p() {
        File file = new File(e(), "wxapkg");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File f() {
        File file = new File(j(), "eascript");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File g() {
        File fileE = e();
        if (fileE == null) {
            return null;
        }
        File file = new File(fileE, "icon");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean a(File file, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        if (file != null && !TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file, true);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str.getBytes(Charset.forName("UTF-8")));
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
                return true;
            } catch (Exception unused3) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
        return false;
    }

    public static byte[] e(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return bArr;
                } catch (IOException unused2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused5) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    public static File e(String str) {
        return new File(g(str).getAbsolutePath() + File.separator + "preload");
    }

    public static File e() {
        File file = new File(d(), "com_qq_e_download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static String c(String str) {
        return gp.a(str);
    }

    public static boolean c(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return c(file, str.getBytes(d6.a));
    }

    public static File b(String str) {
        try {
            File fileA = a();
            if (!TextUtils.isEmpty(str) && fileA != null && fileA.exists()) {
                File file = new File(fileA, str);
                if (file.exists()) {
                    file.setLastModified(System.currentTimeMillis());
                }
                return file;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static boolean c(File file, byte[] bArr) throws IOException {
        if (file != null && bArr != null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                fileOutputStream.close();
                return true;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public static File c() {
        File file = new File(j(), "other");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean c(File file) throws IOException {
        try {
            new ZipFile(file).close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long b(File file) {
        long length;
        long j = 0;
        if (file != null && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = b(file2);
                } else {
                    length = file2.length();
                }
                j += length;
            }
        }
        return j;
    }

    public static String d(String str) {
        return gp.a(str);
    }

    public static String a(String str) {
        return a(str, r1.d().b().f());
    }

    public static void b(File file, String str) throws Exception {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        a(file, str.getBytes(d6.a));
    }

    public static String d(File file) throws Throwable {
        byte[] bArrE = e(file);
        if (bArrE != null) {
            return new String(bArrE, d6.a);
        }
        return null;
    }

    public static File d() {
        File externalCacheDir = r1.d().a().getApplicationContext().getExternalCacheDir();
        return externalCacheDir != null ? externalCacheDir : r1.d().a().getApplicationContext().getCacheDir();
    }

    private static void b(File file, InputStream inputStream) throws Exception {
        BufferedOutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    bufferedOutputStream.write(bArr, 0, i);
                } else {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    private static void b(File file, byte[] bArr) throws Exception {
        BufferedOutputStream bufferedOutputStream;
        if (file == null || bArr == null || bArr.length == 0) {
            return;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
        }
        try {
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Throwable th2) {
            th = th2;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        String str3 = Config.replace;
        boolean zEndsWith = str2.endsWith(Config.replace);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (zEndsWith) {
            str3 = "";
        }
        sb.append(str3);
        sb.append(gp.a(str2));
        return sb.toString();
    }

    public static boolean b(File file, File file2) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            return a(new FileInputStream(file), file2);
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    public static File b() {
        return new File(r1.d().a().getCacheDir(), "GDTDOWNLOAD/image");
    }

    public static boolean a(File file, File file2) {
        if (file != null && file.exists()) {
            try {
                a(new FileInputStream(file), file2);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(InputStream inputStream, File file) throws IOException {
        if (inputStream == null || file == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                return false;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i > 0) {
                        fileOutputStream2.write(bArr, 0, i);
                    } else {
                        a(inputStream);
                        a(fileOutputStream2);
                        return true;
                    }
                }
            } catch (Throwable unused) {
                fileOutputStream = fileOutputStream2;
                try {
                    String.format("Exception while copy from InputStream to File %s", file.getAbsolutePath());
                    return false;
                } finally {
                    a(inputStream);
                    a(fileOutputStream);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void a(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        a(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static String a(hw hwVar, File file) throws Throwable {
        InputStream inputStreamB;
        MessageDigest messageDigest;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            inputStreamB = hwVar.b();
            try {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamB = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamB.read(bArr);
                if (i > 0) {
                    messageDigest.update(bArr, 0, i);
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    a(inputStreamB);
                    a(fileOutputStream);
                    String strA = gp.a(messageDigest.digest());
                    a(inputStreamB);
                    a(fileOutputStream);
                    return strA;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            a(inputStreamB);
            a(fileOutputStream2);
            throw th;
        }
    }

    public static File a(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "gdtadmobwebdatabase");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void a(File file, InputStream inputStream) throws Exception {
        if (file == null || inputStream == null || inputStream.available() <= 0) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            File file2 = new File(parentFile, file.getName() + "_tmp_" + Thread.currentThread().getName() + Config.replace + System.nanoTime());
            b(file2, inputStream);
            file2.renameTo(file);
            return;
        }
        b(file, inputStream);
    }

    public static void a(File file, byte[] bArr) throws Exception {
        if (file == null || bArr == null || bArr.length == 0) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            File file2 = new File(parentFile, file.getName() + "_tmp_" + Thread.currentThread().getName() + Config.replace + System.nanoTime());
            b(file2, bArr);
            file2.renameTo(file);
            return;
        }
        b(file, bArr);
    }

    public static void a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static File a() {
        File fileE = e();
        if (fileE == null) {
            return null;
        }
        File file = new File(fileE, "apk");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
