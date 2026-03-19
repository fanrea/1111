package com.qq.e.comm.plugin;

import android.util.Base64;
import java.io.File;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class s60 {
    public static long a(File file) throws Throwable {
        return pro.getJresult(296, 1, file);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(byte[] r6) throws java.lang.Throwable {
        /*
            if (r6 == 0) goto L6d
            int r0 = r6.length
            if (r0 != 0) goto L7
            goto L6d
        L7:
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r6)
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream
            r6.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]
            r2 = 0
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
        L1b:
            int r4 = r3.read(r1)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r5 = -1
            if (r4 == r5) goto L27
            r5 = 0
            r6.write(r1, r5, r4)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            goto L1b
        L27:
            r6.flush()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            byte[] r2 = r6.toByteArray()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r3.close()     // Catch: java.lang.Exception -> L38
            r0.close()     // Catch: java.lang.Exception -> L38
            r6.close()     // Catch: java.lang.Exception -> L38
            goto L58
        L38:
            r6 = move-exception
            r6.printStackTrace()
            goto L58
        L3d:
            r1 = move-exception
            goto L5c
        L3f:
            r1 = move-exception
            goto L45
        L41:
            r1 = move-exception
            goto L5b
        L43:
            r1 = move-exception
            r3 = r2
        L45:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L59
            if (r3 == 0) goto L4d
            r3.close()     // Catch: java.lang.Exception -> L54
        L4d:
            r0.close()     // Catch: java.lang.Exception -> L54
            r6.close()     // Catch: java.lang.Exception -> L54
            goto L58
        L54:
            r6 = move-exception
            r6.printStackTrace()
        L58:
            return r2
        L59:
            r1 = move-exception
            r2 = r3
        L5b:
            r3 = r2
        L5c:
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.lang.Exception -> L68
        L61:
            r0.close()     // Catch: java.lang.Exception -> L68
            r6.close()     // Catch: java.lang.Exception -> L68
            goto L6c
        L68:
            r6 = move-exception
            r6.printStackTrace()
        L6c:
            throw r1
        L6d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.s60.b(byte[]):byte[]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.OutputStream, java.util.zip.GZIPOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(byte[] r3) throws java.lang.Throwable {
        /*
            if (r3 == 0) goto L51
            int r0 = r3.length
            if (r0 != 0) goto L6
            goto L51
        L6:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
            r2.write(r3)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r2.finish()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            byte[] r1 = r0.toByteArray()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            r2.close()     // Catch: java.lang.Exception -> L22
            r0.close()     // Catch: java.lang.Exception -> L22
            goto L3f
        L22:
            r3 = move-exception
            r3.printStackTrace()
            goto L3f
        L27:
            r3 = move-exception
            goto L43
        L29:
            r3 = move-exception
            goto L2f
        L2b:
            r3 = move-exception
            goto L42
        L2d:
            r3 = move-exception
            r2 = r1
        L2f:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L37
            r2.close()     // Catch: java.lang.Exception -> L3b
        L37:
            r0.close()     // Catch: java.lang.Exception -> L3b
            goto L3f
        L3b:
            r3 = move-exception
            r3.printStackTrace()
        L3f:
            return r1
        L40:
            r3 = move-exception
            r1 = r2
        L42:
            r2 = r1
        L43:
            if (r2 == 0) goto L48
            r2.close()     // Catch: java.lang.Exception -> L4c
        L48:
            r0.close()     // Catch: java.lang.Exception -> L4c
            goto L50
        L4c:
            r0 = move-exception
            r0.printStackTrace()
        L50:
            throw r3
        L51:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.s60.a(byte[]):byte[]");
    }

    private static void b(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                b(file2);
            }
        }
        file.delete();
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return Base64.encodeToString(a(str.getBytes(d6.a)), 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream, java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 0
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            r3.<init>(r6)     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            r6.<init>(r7)     // Catch: java.lang.Throwable -> La4 java.lang.Exception -> La6
            boolean r1 = r6.exists()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            if (r1 != 0) goto L1a
            r6.mkdirs()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
        L1a:
            java.util.zip.ZipEntry r1 = r2.getNextEntry()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r3 = 1
            if (r1 == 0) goto L98
            java.lang.String r4 = r1.getName()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            java.lang.String r5 = "../"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            if (r5 != 0) goto L90
            boolean r1 = r1.isDirectory()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            if (r1 == 0) goto L59
            int r1 = r4.length()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            int r1 = r1 - r3
            java.lang.String r1 = r4.substring(r0, r1)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r4.<init>()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r4.append(r7)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r4.append(r5)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r4.append(r1)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r3.<init>(r1)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r3.mkdirs()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            goto L1a
        L59:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r3.<init>()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r3.append(r7)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r3.append(r5)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r3.append(r4)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r1.<init>(r3)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r1.createNewFile()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r3.<init>(r1)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
        L7e:
            int r4 = r2.read(r1)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r5 = -1
            if (r4 == r5) goto L8c
            r3.write(r1, r0, r4)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            r3.flush()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            goto L7e
        L8c:
            r3.close()     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            goto L1a
        L90:
            java.lang.Exception r7 = new java.lang.Exception     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            java.lang.String r1 = "unsafe zipfile!"
            r7.<init>(r1)     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
            throw r7     // Catch: java.lang.Exception -> La1 java.lang.Throwable -> La4
        L98:
            r2.close()     // Catch: java.lang.Exception -> L9c
            goto La0
        L9c:
            r6 = move-exception
            r6.printStackTrace()
        La0:
            return r3
        La1:
            r7 = move-exception
            r1 = r6
            goto Lad
        La4:
            r6 = move-exception
            goto Lc9
        La6:
            r6 = move-exception
            r7 = r6
            goto Lad
        La9:
            r6 = move-exception
            goto Lc8
        Lab:
            r7 = move-exception
            r2 = r1
        Lad:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> Lc6
            if (r1 == 0) goto Lbb
            boolean r6 = r1.exists()     // Catch: java.lang.Throwable -> Lc6
            if (r6 == 0) goto Lbb
            b(r1)     // Catch: java.lang.Throwable -> Lc6
        Lbb:
            if (r2 == 0) goto Lc5
            r2.close()     // Catch: java.lang.Exception -> Lc1
            goto Lc5
        Lc1:
            r6 = move-exception
            r6.printStackTrace()
        Lc5:
            return r0
        Lc6:
            r6 = move-exception
            r1 = r2
        Lc8:
            r2 = r1
        Lc9:
            if (r2 == 0) goto Ld3
            r2.close()     // Catch: java.lang.Exception -> Lcf
            goto Ld3
        Lcf:
            r7 = move-exception
            r7.printStackTrace()
        Ld3:
            goto Ld5
        Ld4:
            throw r6
        Ld5:
            goto Ld4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.s60.a(java.lang.String, java.lang.String):boolean");
    }
}
