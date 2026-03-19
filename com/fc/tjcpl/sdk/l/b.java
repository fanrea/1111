package com.fc.tjcpl.sdk.l;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b {
    public static boolean a(File file, String str, boolean z) throws Throwable {
        boolean zCreateNewFile;
        if (file == null || str == null) {
            return false;
        }
        if (file.exists()) {
            zCreateNewFile = file.isFile();
        } else {
            File parentFile = file.getParentFile();
            if (parentFile != null && (!parentFile.exists() ? !parentFile.mkdirs() : !parentFile.isDirectory())) {
                try {
                    zCreateNewFile = file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                zCreateNewFile = false;
            }
        }
        if (!zCreateNewFile) {
            return false;
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, z));
                try {
                    bufferedWriter2.write(str);
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return true;
                } catch (IOException e3) {
                    e = e3;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e6) {
            e = e6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cf A[Catch: IOException -> 0x00cb, TRY_LEAVE, TryCatch #7 {IOException -> 0x00cb, blocks: (B:62:0x00c7, B:66:0x00cf), top: B:79:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r6, java.util.List<java.lang.String> r7) throws java.lang.Throwable {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            r1 = 0
            r2 = 0
            boolean r3 = r0.exists()     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
            if (r3 != 0) goto L10
            r0.createNewFile()     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
        L10:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
            r0.<init>(r6)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
            java.nio.channels.FileChannel r6 = r0.getChannel()     // Catch: java.io.IOException -> La6 java.lang.Throwable -> Lc3
            java.util.LinkedList r2 = new java.util.LinkedList     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r2.<init>()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
        L22:
            boolean r3 = r7.hasNext()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            if (r3 == 0) goto L67
            java.lang.Object r3 = r7.next()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r4.<init>(r3)     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            boolean r4 = r4.exists()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            if (r4 != 0) goto L5e
            java.util.Iterator r7 = r2.iterator()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
        L3d:
            boolean r3 = r7.hasNext()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            if (r3 == 0) goto L4d
            java.lang.Object r3 = r7.next()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            java.io.FileInputStream r3 = (java.io.FileInputStream) r3     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r3.close()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            goto L3d
        L4d:
            r2.clear()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            if (r6 == 0) goto L55
            r6.close()     // Catch: java.io.IOException -> L59
        L55:
            r0.close()     // Catch: java.io.IOException -> L59
            goto L5d
        L59:
            r6 = move-exception
            r6.printStackTrace()
        L5d:
            return r1
        L5e:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r4.<init>(r3)     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r2.add(r4)     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            goto L22
        L67:
            java.util.Enumeration r7 = java.util.Collections.enumeration(r2)     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            java.io.SequenceInputStream r2 = new java.io.SequenceInputStream     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r2.<init>(r7)     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            java.nio.channels.ReadableByteChannel r7 = java.nio.channels.Channels.newChannel(r2)     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r3 = 8196(0x2004, float:1.1485E-41)
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
        L7a:
            int r4 = r7.read(r3)     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r5 = -1
            if (r4 == r5) goto L8b
            r3.flip()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r6.write(r3)     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r3.compact()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            goto L7a
        L8b:
            r7.close()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r2.close()     // Catch: java.lang.Throwable -> La0 java.io.IOException -> La3
            r7 = 1
            if (r6 == 0) goto L97
            r6.close()     // Catch: java.io.IOException -> L9b
        L97:
            r0.close()     // Catch: java.io.IOException -> L9b
            goto L9f
        L9b:
            r6 = move-exception
            r6.printStackTrace()
        L9f:
            return r7
        La0:
            r7 = move-exception
            r2 = r6
            goto Lc4
        La3:
            r7 = move-exception
            r2 = r6
            goto Lae
        La6:
            r7 = move-exception
            goto Lae
        La8:
            r6 = move-exception
            r0 = r2
            goto Lc5
        Lab:
            r6 = move-exception
            r7 = r6
            r0 = r2
        Lae:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> Lc3
            if (r2 == 0) goto Lb9
            r2.close()     // Catch: java.io.IOException -> Lb7
            goto Lb9
        Lb7:
            r6 = move-exception
            goto Lbf
        Lb9:
            if (r0 == 0) goto Lc2
            r0.close()     // Catch: java.io.IOException -> Lb7
            goto Lc2
        Lbf:
            r6.printStackTrace()
        Lc2:
            return r1
        Lc3:
            r7 = move-exception
        Lc4:
            r6 = r7
        Lc5:
            if (r2 == 0) goto Lcd
            r2.close()     // Catch: java.io.IOException -> Lcb
            goto Lcd
        Lcb:
            r7 = move-exception
            goto Ld3
        Lcd:
            if (r0 == 0) goto Ld6
            r0.close()     // Catch: java.io.IOException -> Lcb
            goto Ld6
        Ld3:
            r7.printStackTrace()
        Ld6:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.l.b.a(java.lang.String, java.util.List):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.io.InputStream r8) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L34
            r1.<init>()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L34
            r2 = 8192(0x2000, float:1.148E-41)
            byte[] r3 = new byte[r2]     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
        La:
            r4 = 0
            int r5 = r8.read(r3, r4, r2)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r6 = -1
            if (r5 == r6) goto L16
            r1.write(r3, r4, r5)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            goto La
        L16:
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            r8.close()     // Catch: java.io.IOException -> L1e
            goto L22
        L1e:
            r8 = move-exception
            r8.printStackTrace()
        L22:
            r1.close()     // Catch: java.io.IOException -> L26
            goto L2a
        L26:
            r8 = move-exception
            r8.printStackTrace()
        L2a:
            return r0
        L2b:
            r0 = move-exception
            goto L4d
        L2d:
            r2 = move-exception
            goto L37
        L2f:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L4d
        L34:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L37:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2b
            r8.close()     // Catch: java.io.IOException -> L3e
            goto L42
        L3e:
            r8 = move-exception
            r8.printStackTrace()
        L42:
            if (r1 == 0) goto L4c
            r1.close()     // Catch: java.io.IOException -> L48
            goto L4c
        L48:
            r8 = move-exception
            r8.printStackTrace()
        L4c:
            return r0
        L4d:
            r8.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r8 = move-exception
            r8.printStackTrace()
        L55:
            if (r1 == 0) goto L5f
            r1.close()     // Catch: java.io.IOException -> L5b
            goto L5f
        L5b:
            r8 = move-exception
            r8.printStackTrace()
        L5f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.l.b.a(java.io.InputStream):byte[]");
    }
}
