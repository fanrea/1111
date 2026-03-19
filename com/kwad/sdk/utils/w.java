package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class w {
    public static final BigInteger clJ;
    public static final BigInteger clK;
    public static final BigInteger clL;
    public static final BigInteger clM;
    public static final BigInteger clN;
    public static final BigInteger clO;
    public static final char clP;
    public static final BigInteger clQ;
    public static final BigInteger clR;
    public static final File[] clS;
    public static final String clT;
    private static final char clU;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(1024L);
        clJ = bigIntegerValueOf;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf);
        clK = bigIntegerMultiply;
        BigInteger bigIntegerMultiply2 = bigIntegerValueOf.multiply(bigIntegerMultiply);
        clL = bigIntegerMultiply2;
        BigInteger bigIntegerMultiply3 = bigIntegerValueOf.multiply(bigIntegerMultiply2);
        clM = bigIntegerMultiply3;
        BigInteger bigIntegerMultiply4 = bigIntegerValueOf.multiply(bigIntegerMultiply3);
        clN = bigIntegerMultiply4;
        clO = bigIntegerValueOf.multiply(bigIntegerMultiply4);
        BigInteger bigIntegerMultiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(LockFreeTaskQueueCore.FROZEN_MASK));
        clQ = bigIntegerMultiply5;
        clR = bigIntegerValueOf.multiply(bigIntegerMultiply5);
        clS = new File[0];
        clT = Character.toString('.');
        clU = File.separatorChar;
        if (aog()) {
            clP = '/';
        } else {
            clP = '\\';
        }
    }

    public static BufferedInputStream ik(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        return new BufferedInputStream(fileInputStream);
    }

    public static boolean il(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean im(String str) {
        return !TextUtils.isEmpty(str) && Y(new File(str));
    }

    public static boolean Y(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static boolean Z(File file) {
        return file.exists();
    }

    private static boolean e(File file, File file2) throws Throwable {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            f(file, file2);
            try {
                file.delete();
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
            return false;
        }
    }

    private static FileInputStream aa(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (!file.canRead()) {
                throw new IOException("File '" + file + "' cannot be read");
            }
            return new FileInputStream(file);
        }
        throw new FileNotFoundException("File '" + file + "' does not exist");
    }

    private static FileOutputStream ab(File file) {
        return a(file, false);
    }

    public static FileOutputStream a(File file, boolean z) throws IOException {
        ac(file);
        return new FileOutputStream(file, z);
    }

    public static void ac(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
            file.createNewFile();
            return;
        }
        throw new IOException("Could not find parent directory");
    }

    private static void s(File file) throws IOException {
        if (!file.exists()) {
            com.kwad.sdk.crash.utils.b.closeQuietly(ab(file));
        }
        if (!file.setLastModified(System.currentTimeMillis())) {
            throw new IOException("Unable to set the last modification time for " + file);
        }
    }

    public static void f(File file, File file2) throws Throwable {
        b(file, file2, true);
    }

    private static void b(File file, File file2, boolean z) throws Throwable {
        ax.f(file, "Source");
        ax.f(file2, "Destination");
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
        c(file, file2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable, java.io.FileOutputStream] */
    private static void c(File file, File file2, boolean z) throws Throwable {
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
            com.kwad.sdk.crash.utils.b.closeQuietly(channel2);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(channel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
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
            com.kwad.sdk.crash.utils.b.closeQuietly(channel2);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(channel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            if (file.length() != file2.length()) {
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
            }
            if (z) {
                file2.setLastModified(file.lastModified());
            }
        } catch (Throwable th4) {
            th = th4;
            com.kwad.sdk.crash.utils.b.closeQuietly(channel2);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) fileOutputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(channel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static void g(File file, File file2) throws Throwable {
        d(file, file2, true);
    }

    private static void d(File file, File file2, boolean z) throws Throwable {
        a(file, file2, (FileFilter) null, true);
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z) throws Throwable {
        ArrayList arrayList;
        File[] fileArrListFiles;
        ax.f(file, "Source");
        ax.f(file2, "Destination");
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath()) || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(fileArrListFiles.length);
            for (File file3 : fileArrListFiles) {
                arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
            }
        }
        a(file, file2, null, z, arrayList);
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) throws Throwable {
        File[] fileArrListFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (fileArrListFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : fileArrListFiles) {
            File file4 = new File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    a(file3, file4, fileFilter, z, list);
                } else {
                    c(file3, file4, z);
                }
            }
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    private static void c(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStreamAb;
        try {
            fileOutputStreamAb = ab(file);
            try {
                com.kwad.sdk.crash.utils.h.e(inputStream, fileOutputStreamAb);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStreamAb);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStreamAb);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStreamAb = null;
        }
    }

    public static void a(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Asset path is empty.");
        }
        InputStream inputStreamOpen = null;
        try {
            inputStreamOpen = context.getAssets().open(str);
            c(inputStreamOpen, file);
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamOpen);
        }
    }

    private static void W(File file) throws IOException {
        if (file.exists()) {
            if (!ak(file)) {
                X(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    public static boolean delete(String str) {
        return ad(new File(str));
    }

    public static boolean ad(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                X(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean ae(File file) {
        return ad(file);
    }

    public static void X(File file) throws IOException {
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
                ah(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static String a(File file, Charset charset) throws Throwable {
        FileInputStream fileInputStreamAa;
        try {
            fileInputStreamAa = aa(file);
        } catch (Throwable th) {
            th = th;
            fileInputStreamAa = null;
        }
        try {
            String strA = com.kwad.sdk.crash.utils.h.a(fileInputStreamAa, com.kwad.sdk.crash.utils.a.a(charset));
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStreamAa);
            return strA;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStreamAa);
            throw th;
        }
    }

    public static byte[] af(File file) {
        return ag(file).getBytes();
    }

    public static String ag(File file) {
        return a(file, Charset.defaultCharset());
    }

    public static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStreamA;
        try {
            fileOutputStreamA = a(file, false);
        } catch (Throwable th) {
            th = th;
            fileOutputStreamA = null;
        }
        try {
            com.kwad.sdk.crash.utils.h.a(str, fileOutputStreamA, charset);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStreamA);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStreamA);
            throw th;
        }
    }

    private static void ah(File file) throws IOException {
        if (file.isDirectory()) {
            W(file);
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

    public static void ai(File file) throws IOException {
        if (file == null) {
            throw new IOException("Dir is null.");
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            if (!ad(file)) {
                throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
            }
            file.mkdir();
        } else {
            file.mkdirs();
        }
        if (!file.exists() || !file.isDirectory()) {
            throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
        }
    }

    public static void aj(File file) throws IOException {
        ad(file);
        s(file);
        if (!file.exists()) {
            throw new IOException("Create file fail");
        }
    }

    private static boolean ak(File file) {
        ax.checkNotNull(file);
        if (aog()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    private static boolean aog() {
        return clU == '\\';
    }

    private static int in(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    private static int io(String str) {
        int iLastIndexOf;
        if (str != null && in(str) <= (iLastIndexOf = str.lastIndexOf(46))) {
            return iLastIndexOf;
        }
        return -1;
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int iIo = io(str);
        return iIo == -1 ? "" : str.substring(iIo + 1);
    }

    public static void deleteContents(File file) {
        File[] fileArrListFiles;
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                file2.delete();
            }
        }
    }

    public static void a(File file, List<String> list, List<String> list2) {
        File[] fileArrListFiles;
        if (!file.exists() || a(file, list) || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                a(file2, list, list2);
            }
            if (!a(file2, list) && !file2.delete()) {
                list2.add(file2.getPath());
            }
        }
    }

    private static boolean a(File file, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (file.getPath().contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean al(File file) throws Throwable {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        e(file, file2);
        return ad(file2);
    }

    public static String ad(Context context, String str) {
        return "/data/data/" + context.getPackageName() + "/" + str + "/";
    }
}
