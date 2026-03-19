package com.kwai.middleware.azeroth.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class FileUtils {
    private FileUtils() {
    }

    public static List<String> readLines(File file) {
        return readLines(file, Charset.defaultCharset());
    }

    public static List<String> readLines(File file, Charset charset) throws Throwable {
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, charset);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            List<String> lines = readLines(inputStreamReader);
            CloseableUtils.closeQuietly(inputStreamReader);
            CloseableUtils.closeQuietly(fileInputStream);
            return lines;
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader2 = inputStreamReader;
            CloseableUtils.closeQuietly(inputStreamReader2);
            CloseableUtils.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static String readFirstLine(File file) {
        return readFirstLine(file, Charset.defaultCharset());
    }

    public static String readFirstLine(File file, Charset charset) throws Throwable {
        InputStreamReader inputStreamReader;
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                inputStreamReader2 = new InputStreamReader(fileInputStream, charset);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader2);
                } catch (Throwable th) {
                    inputStreamReader = inputStreamReader2;
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
            try {
                String strEmptyIfNull = TextUtils.emptyIfNull(bufferedReader.readLine());
                CloseableUtils.closeQuietly(bufferedReader);
                CloseableUtils.closeQuietly(inputStreamReader2);
                CloseableUtils.closeQuietly(fileInputStream);
                return strEmptyIfNull;
            } catch (Throwable th3) {
                inputStreamReader = inputStreamReader2;
                th = th3;
                bufferedReader2 = bufferedReader;
                CloseableUtils.closeQuietly(bufferedReader2);
                CloseableUtils.closeQuietly(inputStreamReader);
                CloseableUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
            fileInputStream = null;
        }
    }

    public static List<String> readLines(Reader reader) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader);
            ArrayList arrayList = new ArrayList();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                arrayList.add(TextUtils.emptyIfNull(line));
            }
            return arrayList;
        } finally {
            CloseableUtils.closeQuietly(bufferedReader);
        }
    }

    public static void write(File file, CharSequence charSequence) throws Throwable {
        write(file, charSequence, Charset.defaultCharset(), false);
    }

    public static void write(File file, CharSequence charSequence, boolean z) throws Throwable {
        write(file, charSequence, Charset.defaultCharset(), z);
    }

    public static void write(File file, CharSequence charSequence, Charset charset) throws Throwable {
        write(file, charSequence, charset, false);
    }

    public static void write(File file, CharSequence charSequence, Charset charset, boolean z) throws Throwable {
        writeStringToFile(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    public static void writeStringToFile(File file, String str, Charset charset, boolean z) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            if (str != null) {
                try {
                    fileOutputStream2.write(str.getBytes(charset));
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    CloseableUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            }
            CloseableUtils.closeQuietly(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void copyFile(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (IOException e) {
                e = e;
                fileOutputStream = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i);
                }
            }
            CloseableUtils.closeQuietly(fileInputStream);
        } catch (IOException e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            try {
                e.printStackTrace();
                CloseableUtils.closeQuietly(fileInputStream2);
                CloseableUtils.closeQuietly(fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                CloseableUtils.closeQuietly(fileInputStream);
                CloseableUtils.closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            CloseableUtils.closeQuietly(fileInputStream);
            CloseableUtils.closeQuietly(fileOutputStream);
            throw th;
        }
        CloseableUtils.closeQuietly(fileOutputStream);
    }
}
