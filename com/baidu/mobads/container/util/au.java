package com.baidu.mobads.container.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class au {
    private static final int a = 32768;

    public static File a(File file) {
        File[] fileArrListFiles;
        try {
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    File fileA = a(file2);
                    if (fileA != null) {
                        return fileA;
                    }
                }
            }
            if (file.delete()) {
                return null;
            }
            return file;
        } catch (Exception e) {
            if (file.delete()) {
                return null;
            }
            return file;
        }
    }

    public static void b(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " is not directory!");
            }
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    public static List<File> c(File file) {
        LinkedList linkedList = new LinkedList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            List<File> listAsList = Arrays.asList(fileArrListFiles);
            Collections.sort(listAsList, new a());
            return listAsList;
        }
        return linkedList;
    }

    public static void d(File file) throws IOException {
        if (file.exists() && !file.setLastModified(System.currentTimeMillis())) {
            e(file);
            file.lastModified();
        }
    }

    static void e(File file) throws IOException {
        try {
            long length = file.length();
            if (length == 0) {
                j(file);
                return;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
            long j = length - 1;
            randomAccessFile.seek(j);
            byte b = randomAccessFile.readByte();
            randomAccessFile.seek(j);
            randomAccessFile.write(b);
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    private static void j(File file) throws IOException {
        if (!file.delete() || !file.createNewFile()) {
            throw new IOException("Error recreate zero-size file " + file);
        }
    }

    private static final class a implements Comparator<File> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }

        private int a(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }
    }

    public static File a(String str) {
        return a(new File(str));
    }

    public static boolean a(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (!file.exists()) {
                return false;
            }
            return file.renameTo(file2);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(String str, File file, boolean z) {
        try {
            return a(str.getBytes(StandardCharsets.UTF_8), file, z);
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean a(byte[] bArr, File file) {
        return a(bArr, file, false);
    }

    public static boolean a(byte[] bArr, File file, boolean z) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
            try {
                bufferedOutputStream.write(bArr);
                fileOutputStream2.flush();
                bufferedOutputStream.flush();
                return a(fileOutputStream2) & a(bufferedOutputStream);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                a(fileOutputStream);
                a(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    public static boolean a(InputStream inputStream, File file) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream3 = new FileOutputStream(file);
            try {
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream3);
                try {
                    byte[] bArr = new byte[32768];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i > 0) {
                            bufferedOutputStream2.write(bArr, 0, i);
                        } else {
                            fileOutputStream3.flush();
                            bufferedOutputStream2.flush();
                            return a(inputStream) & a(bufferedOutputStream2) & a(fileOutputStream3);
                        }
                    }
                } catch (Throwable th) {
                    fileOutputStream = fileOutputStream3;
                    bufferedOutputStream = bufferedOutputStream2;
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    a(fileOutputStream2);
                    a(bufferedOutputStream);
                    a(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream3;
                bufferedOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    public static boolean a(Bitmap bitmap, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            return a(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            a(fileOutputStream2);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static byte[] f(File file) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            try {
                if (!file.exists()) {
                    throw new FileNotFoundException();
                }
                fileInputStream = new FileInputStream((File) file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (IOException e) {
                    e = e;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    file = 0;
                    a((Closeable) file);
                    a(fileInputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[32768];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            a(byteArrayOutputStream);
                            a(fileInputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                } catch (IOException e2) {
                    e = e2;
                    bq.a().a("Failed to read file", e);
                    a(byteArrayOutputStream);
                    a(fileInputStream);
                    return null;
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = null;
                fileInputStream = null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                file = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static String g(File file) {
        try {
            return new String(f(file), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean h(File file) throws IOException {
        if (file == null || !file.exists()) {
            return false;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(new byte[0]);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            bq.a().c("Failed to clear file", e);
            return false;
        }
    }

    public static boolean a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
                return true;
            } catch (IOException e) {
                bq.a().c("Failed to close the target", e);
                return false;
            }
        }
        return true;
    }

    public static void a(InputStream inputStream, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i);
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            fileOutputStream.close();
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static void a(Context context, String str, String str2) throws Throwable {
        try {
            a(context.getAssets().open(str), str2);
        } catch (Exception e) {
            bq.a().a(e);
        }
    }

    public static boolean i(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    return file.length() > 0;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public static boolean b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                return file.length() > 0;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean b(String str, String str2) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            try {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str).exists()) {
                    return false;
                }
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        byte[] bArr = new byte[1048576];
                        while (true) {
                            int i = fileInputStream2.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        }
                        fileInputStream2.close();
                        fileOutputStream.close();
                        try {
                            fileInputStream2.close();
                        } catch (Exception e) {
                        }
                        try {
                            fileOutputStream.close();
                            return true;
                        } catch (Exception e2) {
                            return true;
                        }
                    } catch (FileNotFoundException e3) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (IOException e5) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e7) {
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return false;
                    }
                } catch (FileNotFoundException e8) {
                    fileOutputStream = null;
                } catch (IOException e9) {
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    fileOutputStream = null;
                }
            } catch (FileNotFoundException e10) {
                fileOutputStream = null;
            } catch (IOException e11) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                fileOutputStream = null;
            }
        } catch (Exception e12) {
            return false;
        }
    }

    public static String c(String str) {
        try {
            String path = new URI(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1, path.length());
        } catch (URISyntaxException e) {
            return "";
        }
    }
}
