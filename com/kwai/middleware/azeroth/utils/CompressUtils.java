package com.kwai.middleware.azeroth.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class CompressUtils {
    private static final int KEEP_LAST_PATH_NAME = -1;
    private static final int KEEP_ORIGIN_PATH_NAME = 0;
    private static final int ZIP_BUFFER_SIZE = 4096;

    public static byte[] gzipCompress(byte[] bArr) throws IOException {
        byte[] byteArray = null;
        if (bArr != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.flush();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArray;
    }

    public static void zip(File file, File file2) throws Throwable {
        zip(file, file2, -1);
    }

    public static void zip(File file, File file2, int i) throws Throwable {
        if (file.isFile()) {
            zip(new File[]{file}, file2.getAbsolutePath(), i);
        } else if (file.isDirectory()) {
            ArrayList arrayList = new ArrayList();
            buildSrcFileList(file, arrayList);
            zip((File[]) arrayList.toArray(new File[0]), file2.getAbsolutePath(), i);
        }
    }

    public static void zip(File[] fileArr, String str) throws Throwable {
        zip(fileArr, str, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.util.zip.ZipOutputStream] */
    public static void zip(File[] fileArr, String str, int i) throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedInputStream bufferedInputStream;
        ZipEntry zipEntry;
        BufferedInputStream bufferedInputStream2 = null;
        bufferedInputStream = null;
        bufferedInputStream = null;
        BufferedInputStream bufferedInputStream3 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream((String) str);
                try {
                    str = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                    try {
                        byte[] bArr = new byte[4096];
                        BufferedInputStream bufferedInputStream4 = null;
                        ?? r0 = 0;
                        while (r0 < fileArr.length) {
                            try {
                                bufferedInputStream = new BufferedInputStream(new FileInputStream(fileArr[r0]), 4096);
                                try {
                                    String absolutePath = fileArr[r0].getAbsolutePath();
                                    if (i == -1) {
                                        zipEntry = new ZipEntry(absolutePath.substring(absolutePath.lastIndexOf("/") + 1));
                                    } else if (i == 0) {
                                        zipEntry = new ZipEntry(absolutePath);
                                    } else {
                                        zipEntry = new ZipEntry(absolutePath.substring(i));
                                    }
                                    str.putNextEntry(zipEntry);
                                    while (true) {
                                        int i2 = bufferedInputStream.read(bArr, 0, 4096);
                                        if (i2 == -1) {
                                            break;
                                        } else {
                                            str.write(bArr, 0, i2);
                                        }
                                    }
                                    bufferedInputStream.close();
                                    bufferedInputStream4 = bufferedInputStream;
                                    r0++;
                                } catch (Exception e) {
                                    e = e;
                                    bufferedInputStream3 = bufferedInputStream;
                                    e.printStackTrace();
                                    CloseableUtils.closeQuietly(bufferedInputStream3);
                                    bufferedInputStream2 = bufferedInputStream3;
                                    str = str;
                                    CloseableUtils.closeQuietly(str);
                                    CloseableUtils.closeQuietly(fileOutputStream);
                                } catch (Throwable th) {
                                    th = th;
                                    CloseableUtils.closeQuietly(bufferedInputStream);
                                    CloseableUtils.closeQuietly(str);
                                    CloseableUtils.closeQuietly(fileOutputStream);
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                bufferedInputStream3 = bufferedInputStream4;
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedInputStream = bufferedInputStream4;
                            }
                        }
                        CloseableUtils.closeQuietly(bufferedInputStream4);
                        bufferedInputStream2 = r0;
                        str = str;
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    str = 0;
                } catch (Throwable th3) {
                    th = th3;
                    str = 0;
                    bufferedInputStream = null;
                }
            } catch (Exception e5) {
                e = e5;
                str = 0;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                str = 0;
                fileOutputStream = null;
                bufferedInputStream = null;
            }
            CloseableUtils.closeQuietly(str);
            CloseableUtils.closeQuietly(fileOutputStream);
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = bufferedInputStream2;
        }
    }

    private static void buildSrcFileList(File file, List<File> list) {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                buildSrcFileList(file2, list);
            } else if (file2.isFile()) {
                list.add(file2);
            }
        }
    }
}
