package com.kwad.tachikoma.t;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.offline.api.OfflineHostProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h {
    public static boolean N(String str) {
        Uri uri = Uri.parse(str);
        return uri.getLastPathSegment() != null && uri.getLastPathSegment().endsWith(".zip");
    }

    public static boolean a(File file, String str) throws Throwable {
        boolean zUnZip;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    zUnZip = OfflineHostProvider.getApi().zipper().unZip(fileInputStream2, str);
                    a.a(fileInputStream2);
                } catch (IOException e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    com.kwad.tachikoma.e.log().printStackTraceOnly(e);
                    a.a(fileInputStream);
                    zUnZip = false;
                    return zUnZip;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    a.a(fileInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            return zUnZip;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static File a(Context context, String str, String str2) {
        String tkJsFileDir = com.kwad.tachikoma.e.hP().hQ().getTkJsFileDir(context, str);
        if (TextUtils.isEmpty(tkJsFileDir)) {
            return null;
        }
        File file = new File(tkJsFileDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(tkJsFileDir, str2);
    }

    public static boolean b(File file) throws Throwable {
        if (file == null || !file.exists()) {
            return false;
        }
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        a(file, file2);
        return c(file2);
    }

    private static boolean a(File file, File file2) throws Throwable {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            b(file, file2);
            try {
                file.delete();
            } catch (Exception e) {
                com.kwad.tachikoma.e.log().printStackTraceOnly(e);
            }
            return true;
        } catch (Exception e2) {
            com.kwad.tachikoma.e.log().printStackTraceOnly(e2);
            return false;
        }
    }

    private static void b(File file, File file2) throws Throwable {
        a(file, file2, true);
    }

    private static void a(File file, File file2, boolean z) throws Throwable {
        f.b(file, "Source");
        f.b(file2, "Destination");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (file2.exists() && !file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' exists but is read-only");
        }
        b(file, file2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable, java.io.FileOutputStream] */
    private static void b(File file, File file2, boolean z) throws Throwable {
        FileInputStream fileInputStream;
        ?? fileOutputStream;
        FileChannel channel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel channel2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            fileOutputStream = 0;
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                channel = fileInputStream.getChannel();
            } catch (Throwable th2) {
                th = th2;
                channel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = 0;
            channel = fileOutputStream;
            a.a(channel2);
            a.a(fileOutputStream);
            a.a(channel);
            a.a(fileInputStream);
            throw th;
        }
        try {
            channel2 = fileOutputStream.getChannel();
            long size = channel.size();
            long jTransferFrom = 0;
            while (jTransferFrom < size) {
                long j = size - jTransferFrom;
                jTransferFrom += channel2.transferFrom(channel, jTransferFrom, j > 31457280 ? 31457280L : j);
            }
            a.a(channel2);
            a.a(fileOutputStream);
            a.a(channel);
            a.a(fileInputStream);
            if (file.length() == file2.length()) {
                if (z) {
                    file2.setLastModified(file.lastModified());
                }
            } else {
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
            }
        } catch (Throwable th4) {
            th = th4;
            a.a(channel2);
            a.a(fileOutputStream);
            a.a(channel);
            a.a(fileInputStream);
            throw th;
        }
    }

    private static boolean c(File file) {
        try {
            if (file.isDirectory()) {
                d(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    private static void d(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        IOException e = null;
        for (File file2 : fileArrListFiles) {
            try {
                e(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    private static void e(File file) throws IOException {
        if (file.isDirectory()) {
            f(file);
            return;
        }
        boolean zExists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!zExists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    private static void f(File file) throws IOException {
        if (file.exists()) {
            d(file);
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static String g(File file) {
        try {
            return a(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            com.kwad.tachikoma.e.log().printStackTraceOnly(e);
            return null;
        }
    }

    private static String a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    } else {
                        return new String(byteArrayOutputStream.toByteArray());
                    }
                } catch (IOException e) {
                    com.kwad.tachikoma.e.log().printStackTraceOnly(e);
                    a.a(inputStream);
                    a.a(byteArrayOutputStream);
                    return null;
                }
            } finally {
                a.a(inputStream);
                a.a(byteArrayOutputStream);
            }
        }
    }

    public static boolean a(String str, int i, File file) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            byte[] bytes = str.getBytes();
            fileOutputStream.write(bytes, i, bytes.length);
            a.a(fileOutputStream);
            return true;
        } catch (Throwable th2) {
            th = th2;
            try {
                com.kwad.tachikoma.e.log().printStackTraceOnly(th);
                a.a(fileOutputStream);
                return false;
            } catch (Throwable th3) {
                a.a(fileOutputStream);
                throw th3;
            }
        }
    }

    public static String b(InputStream inputStream) throws Throwable {
        InputStreamReader inputStreamReader;
        char[] cArr = new char[1024];
        StringBuilder sb = new StringBuilder();
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            while (true) {
                try {
                    int i = inputStreamReader.read(cArr, 0, 1024);
                    if (i >= 0) {
                        sb.append(cArr, 0, i);
                    } else {
                        a.a(inputStreamReader);
                        return sb.toString();
                    }
                } catch (Exception unused) {
                    a.a(inputStreamReader);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader2 = inputStreamReader;
                    a.a(inputStreamReader2);
                    throw th;
                }
            }
        } catch (Exception unused2) {
            inputStreamReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean h(File file) {
        return file.exists() && file.length() > 0;
    }
}
