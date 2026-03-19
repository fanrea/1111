package com.kuaishou.security.kste.logic.util;

import com.kuaishou.security.kste.logic.report.KVSecurityUtility;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Utils {
    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
    
        r2.createNewFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
    
        if (r2.exists() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
    
        r7 = r7.getAssets().open("kste_res/" + r8);
        r9 = new byte[8192];
        r3 = new java.io.FileOutputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        r5 = r7.read(r9, 0, 8192);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
    
        if (r5 == (-1)) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
    
        r3.write(r9, 0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        r0 = getFileMd5(r2);
        r3.close();
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0069, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        r7 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0072, code lost:
    
        r7.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        r2 = new java.io.File(r7.getCacheDir(), r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0027, code lost:
    
        if (r2.exists() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        r2.delete();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.util.Pair getFileFromAssets(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            android.content.res.AssetManager r2 = r7.getAssets()     // Catch: java.lang.Exception -> L71
            java.lang.String r3 = "kste_res"
            java.lang.String[] r2 = r2.list(r3)     // Catch: java.lang.Exception -> L71
            int r3 = r2.length     // Catch: java.lang.Exception -> L71
            r4 = 0
            r5 = 0
        L10:
            if (r5 >= r3) goto L75
            r6 = r2[r5]     // Catch: java.lang.Exception -> L71
            boolean r6 = r6.equals(r8)     // Catch: java.lang.Exception -> L71
            if (r6 == 0) goto L6e
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> L71
            java.io.File r3 = r7.getCacheDir()     // Catch: java.lang.Exception -> L71
            r2.<init>(r3, r9)     // Catch: java.lang.Exception -> L71
            boolean r9 = r2.exists()     // Catch: java.lang.Exception -> L71
            if (r9 == 0) goto L2c
            r2.delete()     // Catch: java.lang.Exception -> L71
        L2c:
            r2.createNewFile()     // Catch: java.lang.Exception -> L71
            boolean r9 = r2.exists()     // Catch: java.lang.Exception -> L71
            if (r9 == 0) goto L75
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch: java.lang.Exception -> L71
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L71
            java.lang.String r3 = "kste_res/"
            r9.<init>(r3)     // Catch: java.lang.Exception -> L71
            r9.append(r8)     // Catch: java.lang.Exception -> L71
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Exception -> L71
            java.io.InputStream r7 = r7.open(r8)     // Catch: java.lang.Exception -> L71
            r8 = 8192(0x2000, float:1.148E-41)
            byte[] r9 = new byte[r8]     // Catch: java.lang.Exception -> L71
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L71
            r3.<init>(r2)     // Catch: java.lang.Exception -> L71
        L54:
            int r5 = r7.read(r9, r4, r8)     // Catch: java.lang.Exception -> L71
            r6 = -1
            if (r5 == r6) goto L5f
            r3.write(r9, r4, r5)     // Catch: java.lang.Exception -> L71
            goto L54
        L5f:
            java.lang.String r0 = getFileMd5(r2)     // Catch: java.lang.Exception -> L6b
            r3.close()     // Catch: java.lang.Exception -> L6b
            r7.close()     // Catch: java.lang.Exception -> L6b
            r1 = r2
            goto L75
        L6b:
            r7 = move-exception
            r1 = r2
            goto L72
        L6e:
            int r5 = r5 + 1
            goto L10
        L71:
            r7 = move-exception
        L72:
            r7.printStackTrace()
        L75:
            android.util.Pair r7 = new android.util.Pair
            r7.<init>(r1, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.security.kste.logic.util.Utils.getFileFromAssets(android.content.Context, java.lang.String, java.lang.String):android.util.Pair");
    }

    public static String getFileMd5(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            try {
                byte[] bArr = new byte[8192];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream2 = new FileInputStream(file);
                while (true) {
                    try {
                        int i = fileInputStream2.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                    } catch (IOException e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                        }
                        return "";
                    } catch (NoSuchAlgorithmException e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        return "";
                    } catch (Throwable unused) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream == null) {
                            return "";
                        }
                        return "";
                    }
                }
                String strByteArrayToHexString = KVSecurityUtility.byteArrayToHexString(messageDigest.digest());
                try {
                    fileInputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return strByteArrayToHexString;
            } catch (IOException e4) {
                e = e4;
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
            } catch (Throwable unused2) {
            }
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(2:(3:16|4|(1:6)(0))|20) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String processMaps() throws java.io.IOException {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L37
            java.lang.String r2 = "/proc/"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L37
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L37
            r1.append(r2)     // Catch: java.lang.Throwable -> L37
            java.lang.String r2 = "/maps"
            r1.append(r2)     // Catch: java.lang.Throwable -> L37
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L37
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L37
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L37
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L37
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L37
        L26:
            java.lang.String r1 = r2.readLine()     // Catch: java.lang.Throwable -> L35
            if (r1 == 0) goto L3c
            r0.append(r1)     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = "\r\n"
            r0.append(r1)     // Catch: java.lang.Throwable -> L35
            goto L26
        L35:
            goto L39
        L37:
            r1 = 0
            r2 = r1
        L39:
            if (r2 != 0) goto L3c
            goto L3f
        L3c:
            r2.close()     // Catch: java.io.IOException -> L3f
        L3f:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.security.kste.logic.util.Utils.processMaps():java.lang.String");
    }
}
