package com.bytedance.pangle.an;

import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedOutputStream;
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
public class h {
    public static void d(File file, String str, int i) throws Throwable {
        ZipFile zipFile;
        String str2 = ".dex";
        String str3 = "classes";
        if (!file.exists() || str == null) {
            throw new IOException("Could not check apk info " + file.getAbsolutePath());
        }
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            ArrayList arrayList = new ArrayList();
            File file2 = new File(com.bytedance.pangle.u.b.tt(str, i));
            d(file2);
            int i2 = 1;
            int i3 = 1;
            while (true) {
                Object objValueOf = "";
                ZipEntry entry = zipFile.getEntry(str3 + (i3 == i2 ? "" : Integer.valueOf(i3)) + str2);
                if (entry != null) {
                    StringBuilder sbAppend = new StringBuilder().append(str3);
                    if (i3 != i2) {
                        objValueOf = Integer.valueOf(i3);
                    }
                    d dVar = new d(file2, sbAppend.append(objValueOf).append(str2).toString());
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < 3 && i5 == 0) {
                        try {
                            d(zipFile, entry, dVar, str3);
                            i5 = i2;
                        } catch (IOException e) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to extract entry from " + dVar.getAbsolutePath(), e);
                        }
                        i4++;
                        String str4 = str2;
                        String str5 = str3;
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Extraction " + (i5 != 0 ? "succeeded" : com.alipay.sdk.m.u.h.i) + " '" + dVar.getAbsolutePath() + "': length " + dVar.length());
                        if (i5 == 0) {
                            dVar.delete();
                            if (dVar.exists()) {
                                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete corrupted secondary dex '" + dVar.getPath() + "'");
                            }
                        }
                        str2 = str4;
                        str3 = str5;
                        i2 = 1;
                    }
                    String str6 = str2;
                    String str7 = str3;
                    if (i5 == 0) {
                        throw new IOException("Could not create zip file " + dVar.getAbsolutePath() + " for secondary dex (" + i3 + ")");
                    }
                    arrayList.add(dVar);
                    i3++;
                    str2 = str6;
                    str3 = str7;
                    i2 = 1;
                } else {
                    d(str, i, file.getName(), arrayList);
                    com.bytedance.pangle.util.h.d(zipFile);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            com.bytedance.pangle.util.h.d(zipFile2);
            throw th;
        }
    }

    public static String d(String str, int i) {
        String str2;
        int iHc = hc(str, i);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 1; i2 <= iHc; i2++) {
            if (i2 == 1) {
                str2 = "classes.dex";
            } else {
                str2 = "classes" + i2 + ".dex";
            }
            sb.append(new d(new File(com.bytedance.pangle.u.b.tt(str, i)), str2).getAbsolutePath()).append(":");
        }
        if (sb.length() != 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    private static void d(ZipFile zipFile, ZipEntry zipEntry, d dVar, String str) throws IOException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File fileCreateTempFile = File.createTempFile("tmp-".concat(String.valueOf(str)), ".dex", dVar.getParentFile());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileCreateTempFile));
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                if (!fileCreateTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + fileCreateTempFile.getAbsolutePath() + "\" (tmp of \"" + dVar.getAbsolutePath() + "\")");
                }
                if (!fileCreateTempFile.renameTo(dVar)) {
                    throw new IOException("Failed to rename \"" + fileCreateTempFile.getAbsolutePath() + "\" to \"" + dVar.getAbsolutePath() + "\"");
                }
            } catch (Throwable th) {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                throw th;
            }
        } finally {
            d(inputStream);
            fileCreateTempFile.delete();
        }
    }

    private static void d(Closeable closeable) throws IOException {
        try {
            closeable.close();
        } catch (IOException e) {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to close resource", e);
        }
    }

    private static void d(File file) {
        File[] fileArrListFiles;
        if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Trying to delete old file " + file2.getPath() + " of size " + file2.length());
            if (!file2.delete()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "Plugin-MultiDex Failed to delete old file " + file2.getPath());
            }
        }
    }

    private static void d(String str, int i, String str2, List<d> list) {
        String str3 = str + "-" + i;
        SharedPreferences.Editor editorEdit = d().edit();
        editorEdit.putInt(str3 + ".dex.number", list.size());
        editorEdit.commit();
    }

    private static SharedPreferences d() {
        return Zeus.getAppApplication().getSharedPreferences("plugin-multidex.version", 0);
    }

    private static int hc(String str, int i) {
        return d((str + "-" + i) + ".dex.number");
    }

    private static int d(String str) {
        return d().getInt(str, 0);
    }

    private static class d extends File {
        public d(File file, String str) {
            super(file, str);
        }
    }
}
