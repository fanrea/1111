package com.ss.ttm.player;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.sigmob.sdk.archives.tar.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class TTCrashUtil {
    public static void deleteCrashFile(Context context, String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean existsCrashFile(Context context, String str) {
        if (context == null && str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static final String existsCrashFilePath(Context context) {
        if (TTPlayerConfiger.getValue(18, 1) == 1) {
            String appCrashFilePath = TTPlayerConfiger.getAppCrashFilePath(context);
            if (appCrashFilePath == null || !new File(appCrashFilePath).exists()) {
                return null;
            }
            return appCrashFilePath;
        }
        String appCrashFilePath2 = TTPlayerConfiger.getAppCrashFilePath2(context);
        if (appCrashFilePath2 != null && new File(appCrashFilePath2).exists()) {
            return appCrashFilePath2;
        }
        String plugerCrashFilePath = TTPlayerConfiger.getPlugerCrashFilePath(context);
        if (plugerCrashFilePath != null && new File(plugerCrashFilePath).exists()) {
            return plugerCrashFilePath;
        }
        String externalStorageDirectoryCrashFilePath = TTPlayerConfiger.getExternalStorageDirectoryCrashFilePath(context);
        if (externalStorageDirectoryCrashFilePath == null || new File(externalStorageDirectoryCrashFilePath).exists()) {
            return externalStorageDirectoryCrashFilePath;
        }
        return null;
    }

    public static String getBase64SampleCrash(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static String getCrashFileContext(Context context, String str, StringBuilder sb) throws IOException {
        FileInputStream fileInputStream;
        if (context == null && str == null) {
            sb.append("context or path is null.\r\n");
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            sb.append("file not exist.path:").append(str).append("\r\n");
            return null;
        }
        if (file.length() == 0) {
            sb.append("file size is zore.").append("\r\n");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                compress(fileInputStream, byteArrayOutputStream);
                fileInputStream.close();
                String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                byteArrayOutputStream.close();
                return strEncodeToString;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                sb.append("gzip file is error.error:").append(e.getMessage());
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        }
    }

    public static void compress(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[d.b];
        while (true) {
            int i = inputStream.read(bArr, 0, d.b);
            if (i != -1) {
                gZIPOutputStream.write(bArr, 0, i);
            } else {
                gZIPOutputStream.flush();
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0082 A[Catch: IOException -> 0x007e, TRY_LEAVE, TryCatch #12 {IOException -> 0x007e, blocks: (B:43:0x007a, B:47:0x0082), top: B:79:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean copyFile(java.lang.String r4, java.lang.String r5, boolean r6, boolean r7) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            boolean r5 = r0.exists()
            r1 = 0
            if (r5 != 0) goto Ld
            return r1
        Ld:
            boolean r5 = r0.isFile()
            if (r5 != 0) goto L14
            return r1
        L14:
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            boolean r2 = r5.exists()
            if (r2 == 0) goto L2a
            if (r6 == 0) goto L3f
            java.io.File r6 = new java.io.File
            r6.<init>(r4)
            r6.delete()
            goto L3f
        L2a:
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.exists()
            if (r4 != 0) goto L3f
            java.io.File r4 = r5.getParentFile()
            boolean r4 = r4.mkdirs()
            if (r4 != 0) goto L3f
            return r1
        L3f:
            r4 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L8a java.io.FileNotFoundException -> L9d
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L74 java.io.IOException -> L8a java.io.FileNotFoundException -> L9d
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L8b java.io.FileNotFoundException -> L9e
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L71 java.io.IOException -> L8b java.io.FileNotFoundException -> L9e
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d java.io.FileNotFoundException -> L6f
        L4e:
            int r5 = r6.read(r4)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d java.io.FileNotFoundException -> L6f
            r3 = -1
            if (r5 == r3) goto L59
            r2.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d java.io.FileNotFoundException -> L6f
            goto L4e
        L59:
            if (r7 == 0) goto L5e
            r0.delete()     // Catch: java.lang.Throwable -> L6b java.io.IOException -> L6d java.io.FileNotFoundException -> L6f
        L5e:
            r4 = 1
            r2.close()     // Catch: java.io.IOException -> L66
            r6.close()     // Catch: java.io.IOException -> L66
            goto L6a
        L66:
            r5 = move-exception
            r5.printStackTrace()
        L6a:
            return r4
        L6b:
            r4 = move-exception
            goto L78
        L6d:
            r4 = r2
            goto L8b
        L6f:
            r4 = r2
            goto L9e
        L71:
            r5 = move-exception
            r2 = r4
            goto L77
        L74:
            r5 = move-exception
            r6 = r4
            r2 = r6
        L77:
            r4 = r5
        L78:
            if (r2 == 0) goto L80
            r2.close()     // Catch: java.io.IOException -> L7e
            goto L80
        L7e:
            r5 = move-exception
            goto L86
        L80:
            if (r6 == 0) goto L89
            r6.close()     // Catch: java.io.IOException -> L7e
            goto L89
        L86:
            r5.printStackTrace()
        L89:
            throw r4
        L8a:
            r6 = r4
        L8b:
            if (r4 == 0) goto L93
            r4.close()     // Catch: java.io.IOException -> L91
            goto L93
        L91:
            r4 = move-exception
            goto L99
        L93:
            if (r6 == 0) goto L9c
            r6.close()     // Catch: java.io.IOException -> L91
            goto L9c
        L99:
            r4.printStackTrace()
        L9c:
            return r1
        L9d:
            r6 = r4
        L9e:
            if (r4 == 0) goto La6
            r4.close()     // Catch: java.io.IOException -> La4
            goto La6
        La4:
            r4 = move-exception
            goto Lac
        La6:
            if (r6 == 0) goto Laf
            r6.close()     // Catch: java.io.IOException -> La4
            goto Laf
        Lac:
            r4.printStackTrace()
        Laf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTCrashUtil.copyFile(java.lang.String, java.lang.String, boolean, boolean):boolean");
    }

    public static final boolean moveFile(String str, String str2, boolean z) {
        return copyFile(str, str2, z, true);
    }

    public static final void saveException(Throwable th, String str) throws Throwable {
        FileOutputStream fileOutputStream;
        PrintStream printStream;
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        PrintStream printStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    printStream = new PrintStream(fileOutputStream);
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused2) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            try {
                printStream.write("EXCE".getBytes());
                th.printStackTrace(printStream);
                printStream.close();
                fileOutputStream.close();
            } catch (Exception unused3) {
                printStream2 = printStream;
                if (printStream2 != null) {
                    printStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th4) {
                th = th4;
                printStream2 = printStream;
                if (printStream2 != null) {
                    printStream2.close();
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x003f -> B:32:0x0042). Please report as a decompilation issue!!! */
    public static void saveLowMemoryInfo(int i, String str) throws Throwable {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        FileWriter fileWriter = null;
        FileWriter fileWriter2 = null;
        fileWriter = null;
        try {
        } catch (IOException e) {
            e.printStackTrace();
            fileWriter = fileWriter;
        }
        try {
            try {
                FileWriter fileWriter3 = new FileWriter(file);
                try {
                    StringBuilder sbAppend = new StringBuilder().append("LOWM\r\nrecv low memory warring info.level:");
                    fileWriter3.write(sbAppend.append(i).toString());
                    fileWriter3.close();
                    fileWriter = sbAppend;
                } catch (IOException e2) {
                    e = e2;
                    fileWriter2 = fileWriter3;
                    e.printStackTrace();
                    fileWriter = fileWriter2;
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                        fileWriter = fileWriter2;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter3;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0053 -> B:30:0x0056). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void saveStopInfo(java.lang.String r2, java.lang.String r3) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 == 0) goto Lc
            return
        Lc:
            r2 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L46
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L57
            r2.<init>()     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L57
            java.lang.String r0 = "STOP recv stop info:"
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L57
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L57
            java.lang.String r3 = ".time:"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L57
            java.lang.String r3 = com.ss.ttm.utils.AVTime.getFormatNow()     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L57
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L57
            java.lang.String r3 = "\r\n"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L57
            java.lang.String r2 = r2.toString()     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L57
            r1.write(r2)     // Catch: java.io.IOException -> L40 java.lang.Throwable -> L57
            r1.close()     // Catch: java.io.IOException -> L52
            goto L56
        L40:
            r2 = move-exception
            goto L49
        L42:
            r3 = move-exception
            r1 = r2
            r2 = r3
            goto L58
        L46:
            r3 = move-exception
            r1 = r2
            r2 = r3
        L49:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r2 = move-exception
            r2.printStackTrace()
        L56:
            return
        L57:
            r2 = move-exception
        L58:
            if (r1 == 0) goto L62
            r1.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r3 = move-exception
            r3.printStackTrace()
        L62:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTCrashUtil.saveStopInfo(java.lang.String, java.lang.String):void");
    }

    private static void appendTrackInfo(String str, boolean z, String str2) throws Throwable {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(str, z);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(str2);
                fileWriter.close();
            } catch (Exception unused2) {
                fileWriter2 = fileWriter;
                fileWriter2.close();
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                try {
                    fileWriter2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void addTrackInfo(long j, String str, String str2) throws Throwable {
        appendTrackInfo(getTrackFilePath(j, str), true, str2);
    }

    public static void addTrackInfo(long j, String str, String str2, boolean z) throws Throwable {
        appendTrackInfo(getTrackFilePath(j, str), z, str2);
    }

    public static void addDebugTrackInfo(long j, String str, String str2, boolean z) throws Throwable {
        appendTrackInfo(getDebugTrackFilePath(j, str), z, str2);
    }

    private static boolean getTrackFileInfos(File file, StringBuilder sb) {
        int i;
        FileReader fileReader = null;
        try {
            if (!file.exists()) {
                return false;
            }
            char[] cArr = new char[1024];
            FileReader fileReader2 = new FileReader(file);
            do {
                try {
                    i = fileReader2.read(cArr);
                    if (i <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, i);
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception unused) {
                        }
                    }
                    sb.append("track message:").append(th.getMessage()).append("\r\n");
                    return true;
                }
            } while (i >= 1024);
            fileReader2.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean getTrackFileInfos(String str, StringBuilder sb) {
        int i;
        FileReader fileReader = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                sb.append("path").append(str).append(" not exists.\r\n");
                return false;
            }
            char[] cArr = new char[1024];
            FileReader fileReader2 = new FileReader(file);
            do {
                try {
                    i = fileReader2.read(cArr);
                    if (i <= 0) {
                        break;
                    }
                    sb.append(cArr, 0, i);
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception unused) {
                        }
                    }
                    sb.append("track message:").append(th.getMessage()).append("\r\n");
                    return true;
                }
            } while (i >= 1024);
            fileReader2.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean readTrackInfos(long j, String str, StringBuilder sb) {
        return getTrackFileInfos(getTrackFilePath(j, str), sb);
    }

    public static boolean readDebugTrackInfos(long j, String str, StringBuilder sb) {
        return getTrackFileInfos(getDebugTrackFilePath(j, str), sb);
    }

    private static String getDebugTrackFilePath(long j, String str) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d_d.log", str, Long.valueOf(j));
    }

    public static String getTrackFilePath(long j, String str) {
        return String.format(Locale.US, "%s/ttplayer_logs/%d.log", str, Long.valueOf(j));
    }

    private static void deleteTrackFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void deleteDebugTrackFile(long j, String str) {
        deleteTrackFile(getDebugTrackFilePath(j, str));
    }

    public static void deleteTrackFile(long j, String str) {
        deleteTrackFile(getTrackFilePath(j, str));
    }

    public static boolean existsTrackFile(long j, String str) {
        return new File(getTrackFilePath(j, str)).exists();
    }

    public static boolean moveTrackFile(long j, long j2, String str) {
        return new File(getTrackFilePath(j, str)).renameTo(new File(getTrackFilePath(j2, str)));
    }

    public static void checkTrackDir(String str) {
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    public static boolean existLogsFile(long j, String str) {
        File[] fileArrListFiles;
        String strValueOf = String.valueOf(j);
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            String name = file2.getName();
            Log.i("ttmp", "<TTCrashUtils,existLogsFile,375>file:" + name + ",pname:" + strValueOf);
            if (name != null && !name.startsWith(strValueOf)) {
                return true;
            }
        }
        return false;
    }

    public static boolean readLogsInfo(long j, String str, StringBuilder sb) {
        File[] fileArrListFiles;
        String strValueOf = String.valueOf(j);
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            String name = file2.getName();
            if (name != null && !name.startsWith(strValueOf) && getTrackFileInfos(file2, sb)) {
                boolean zDelete = file2.delete();
                if (!zDelete) {
                    Log.d("ttmp", "delete file:" + file2.getName() + "," + zDelete);
                }
                return zDelete;
            }
        }
        return false;
    }

    public static void checkLogDir(String str) {
        File file = new File(String.format("%s/ttplayer_logs", str));
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        boolean zDelete = file2.delete();
                        if (!zDelete) {
                            Log.d("ttmp", "delete file:" + file2.getName() + "," + zDelete);
                        }
                    }
                }
                boolean zDelete2 = file.delete();
                if (zDelete2) {
                    return;
                }
                Log.d("ttmp", "delete dir file:" + file.getName() + "," + zDelete2);
                return;
            }
            return;
        }
        boolean zMkdir = file.mkdir();
        if (zMkdir) {
            return;
        }
        Log.d("ttmp", "mkdir:" + file.getName() + "," + zMkdir);
    }
}
