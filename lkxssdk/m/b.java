package lkxssdk.m;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r7) throws java.lang.Throwable {
        /*
            java.io.File r7 = lkxssdk.m.c.a(r7)
            int r0 = lkxssdk.m.c.a
            r0 = 0
            if (r7 != 0) goto Lb
            r1 = r0
            goto L1b
        Lb:
            boolean r1 = r7.exists()
            if (r1 == 0) goto L13
            r1 = 1
            goto L1b
        L13:
            java.lang.String r1 = r7.getAbsolutePath()
            boolean r1 = lkxssdk.m.c.c(r1)
        L1b:
            r2 = 0
            if (r1 != 0) goto L21
        L1e:
            r7 = r2
            goto L8b
        L21:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.io.FileNotFoundException -> L86
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L86
            r3.<init>(r7)     // Catch: java.io.FileNotFoundException -> L86
            r7 = 524288(0x80000, float:7.34684E-40)
            r1.<init>(r3, r7)     // Catch: java.io.FileNotFoundException -> L86
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5b
            r3.<init>()     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5b
            byte[] r4 = new byte[r7]     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
        L34:
            int r5 = r1.read(r4, r0, r7)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            r6 = -1
            if (r5 == r6) goto L3f
            r3.write(r4, r0, r5)     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            goto L34
        L3f:
            byte[] r7 = r3.toByteArray()     // Catch: java.lang.Throwable -> L54 java.io.IOException -> L56
            r1.close()     // Catch: java.io.IOException -> L47
            goto L4b
        L47:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.io.FileNotFoundException -> L86
        L4b:
            r3.close()     // Catch: java.io.IOException -> L4f
            goto L8b
        L4f:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.io.FileNotFoundException -> L86
            goto L8b
        L54:
            r7 = move-exception
            goto L73
        L56:
            r7 = move-exception
            goto L5d
        L58:
            r7 = move-exception
            r3 = r2
            goto L73
        L5b:
            r7 = move-exception
            r3 = r2
        L5d:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L54
            r1.close()     // Catch: java.io.IOException -> L64
            goto L68
        L64:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.io.FileNotFoundException -> L86
        L68:
            if (r3 == 0) goto L1e
            r3.close()     // Catch: java.io.IOException -> L6e
            goto L1e
        L6e:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.io.FileNotFoundException -> L86
            goto L1e
        L73:
            r1.close()     // Catch: java.io.IOException -> L77
            goto L7b
        L77:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.io.FileNotFoundException -> L86
        L7b:
            if (r3 == 0) goto L85
            r3.close()     // Catch: java.io.IOException -> L81
            goto L85
        L81:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.io.FileNotFoundException -> L86
        L85:
            throw r7     // Catch: java.io.FileNotFoundException -> L86
        L86:
            r7 = move-exception
            r7.printStackTrace()
            goto L1e
        L8b:
            if (r7 != 0) goto L8e
            goto La7
        L8e:
            boolean r0 = lkxssdk.m.c.d(r2)
            if (r0 == 0) goto L9a
            java.lang.String r2 = new java.lang.String
            r2.<init>(r7)
            goto La7
        L9a:
            java.lang.String r0 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> La1
            r0.<init>(r7, r2)     // Catch: java.io.UnsupportedEncodingException -> La1
            r2 = r0
            goto La7
        La1:
            r7 = move-exception
            r7.printStackTrace()
            java.lang.String r2 = ""
        La7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.m.b.a(java.lang.String):java.lang.String");
    }

    public static boolean a(File file, String str, boolean z) throws Throwable {
        boolean zCreateNewFile;
        if (file == null || str == null) {
            return false;
        }
        int i = c.a;
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
            Log.e("FileIOUtils", "create file <" + file + "> failed.");
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
}
