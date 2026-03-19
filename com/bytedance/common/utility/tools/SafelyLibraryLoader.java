package com.bytedance.common.utility.tools;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.common.utility.io.IOUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SafelyLibraryLoader {
    private static final String LIB_DIR = "libso";
    private static List<String> sLoadedLibs = new ArrayList();

    public static synchronized boolean loadLibrary(Context context, String str) {
        if (sLoadedLibs.contains(str)) {
            return true;
        }
        try {
            System.loadLibrary(str);
            sLoadedLibs.add(str);
        } catch (UnsatisfiedLinkError e) {
            File libraryFile = getLibraryFile(context, str);
            if (libraryFile == null) {
                return false;
            }
            if (libraryFile.exists()) {
                libraryFile.delete();
            }
            String strUnpackLibrary = unpackLibrary(context, str, libraryFile);
            if (strUnpackLibrary != null) {
                Log.e("loadLibrary", e.getMessage() + "[" + strUnpackLibrary + "]");
                return false;
            }
            try {
                System.load(libraryFile.getAbsolutePath());
                sLoadedLibs.add(str);
            } catch (Throwable unused) {
                return false;
            }
        } catch (Throwable unused2) {
            return false;
        }
        return true;
    }

    private static File getLibraryFolder(Context context) {
        if (context == null || context.getFilesDir() == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), LIB_DIR);
        if (!file.exists()) {
            IOUtils.mkdir(file.getAbsolutePath());
        }
        return file;
    }

    private static File getLibraryFile(Context context, String str) {
        String strMapLibraryName = System.mapLibraryName(str);
        File libraryFolder = getLibraryFolder(context);
        if (libraryFolder != null) {
            return new File(libraryFolder, strMapLibraryName);
        }
        return null;
    }

    private static String unpackLibrary(Context context, String str, File file) throws IOException {
        InputStream inputStream;
        ZipFile zipFile;
        String message;
        ZipEntry entry;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            try {
                entry = zipFile.getEntry("lib/" + Build.CPU_ABI + "/" + System.mapLibraryName(str));
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
            String str2 = Build.CPU_ABI;
            if (iIndexOf <= 0) {
                iIndexOf = Build.CPU_ABI.length();
            }
            String string = sbAppend.append(str2.substring(0, iIndexOf)).append("/").append(System.mapLibraryName(str)).toString();
            ZipEntry entry2 = zipFile.getEntry(string);
            if (entry2 == null) {
                message = "Library entry not found:" + string;
                IOUtils.close((Closeable) null);
                IOUtils.close((Closeable) null);
                IOUtils.close(zipFile);
                return message;
            }
            entry = entry2;
        }
        file.createNewFile();
        InputStream inputStream2 = zipFile.getInputStream(entry);
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th3) {
            inputStream = inputStream2;
            th = th3;
        }
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream2.read(bArr);
                if (i <= 0) {
                    IOUtils.setPermissions(file.getAbsolutePath(), 493);
                    IOUtils.close(fileOutputStream);
                    IOUtils.close(inputStream2);
                    IOUtils.close(zipFile);
                    return null;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th4) {
            fileOutputStream2 = fileOutputStream;
            inputStream = inputStream2;
            th = th4;
            try {
                message = th.getMessage();
                IOUtils.close(fileOutputStream2);
                IOUtils.close(inputStream);
                IOUtils.close(zipFile);
                return message;
            } catch (Throwable th5) {
                IOUtils.close(fileOutputStream2);
                IOUtils.close(inputStream);
                IOUtils.close(zipFile);
                throw th5;
            }
        }
    }
}
