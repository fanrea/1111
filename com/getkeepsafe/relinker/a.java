package com.getkeepsafe.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.getkeepsafe.relinker.b;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a implements b.a {
    private static String[] l(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || applicationInfo.splitSourceDirs == null || applicationInfo.splitSourceDirs.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr = new String[applicationInfo.splitSourceDirs.length + 1];
        strArr[0] = applicationInfo.sourceDir;
        System.arraycopy(applicationInfo.splitSourceDirs, 0, strArr, 1, applicationInfo.splitSourceDirs.length);
        return strArr;
    }

    /* renamed from: com.getkeepsafe.relinker.a$a, reason: collision with other inner class name */
    static class C0387a {
        public ZipFile xd;
        public ZipEntry xe;

        public C0387a(ZipFile zipFile, ZipEntry zipEntry) {
            this.xd = zipFile;
            this.xe = zipEntry;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.getkeepsafe.relinker.a.C0387a a(android.content.Context r17, java.lang.String[] r18, java.lang.String r19, com.getkeepsafe.relinker.c r20) {
        /*
            r16 = this;
            r0 = r18
            java.lang.String[] r1 = l(r17)
            int r2 = r1.length
            r3 = 0
            r4 = 0
            r6 = r3
            r5 = 0
        Lb:
            if (r5 >= r2) goto L7c
            r7 = r1[r5]
            r8 = 0
        L10:
            int r9 = r8 + 1
            r10 = 5
            r11 = 1
            if (r8 >= r10) goto L24
            java.util.zip.ZipFile r8 = new java.util.zip.ZipFile     // Catch: java.io.IOException -> L22
            java.io.File r12 = new java.io.File     // Catch: java.io.IOException -> L22
            r12.<init>(r7)     // Catch: java.io.IOException -> L22
            r8.<init>(r12, r11)     // Catch: java.io.IOException -> L22
            r6 = r8
            goto L24
        L22:
            r8 = r9
            goto L10
        L24:
            if (r6 == 0) goto L74
            r8 = 0
        L27:
            int r9 = r8 + 1
            if (r8 >= r10) goto L74
            int r8 = r0.length
            r12 = 0
        L2d:
            if (r12 >= r8) goto L6d
            r13 = r0[r12]
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r15 = "lib"
            r14.<init>(r15)
            char r15 = java.io.File.separatorChar
            r14.append(r15)
            r14.append(r13)
            char r13 = java.io.File.separatorChar
            r14.append(r13)
            r13 = r19
            r14.append(r13)
            java.lang.String r14 = r14.toString()
            r15 = 2
            java.lang.Object[] r15 = new java.lang.Object[r15]
            r15[r4] = r14
            r15[r11] = r7
            java.lang.String r4 = "Looking for %s in APK %s..."
            r10 = r20
            r10.a(r4, r15)
            java.util.zip.ZipEntry r4 = r6.getEntry(r14)
            if (r4 == 0) goto L68
            com.getkeepsafe.relinker.a$a r0 = new com.getkeepsafe.relinker.a$a
            r0.<init>(r6, r4)
            return r0
        L68:
            int r12 = r12 + 1
            r4 = 0
            r10 = 5
            goto L2d
        L6d:
            r13 = r19
            r10 = r20
            r8 = r9
            r10 = 5
            goto L27
        L74:
            r13 = r19
            r10 = r20
            int r5 = r5 + 1
            r4 = 0
            goto Lb
        L7c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getkeepsafe.relinker.a.a(android.content.Context, java.lang.String[], java.lang.String, com.getkeepsafe.relinker.c):com.getkeepsafe.relinker.a$a");
    }

    @Override // com.getkeepsafe.relinker.b.a
    public final void a(Context context, String[] strArr, String str, File file, c cVar) throws Throwable {
        C0387a c0387aA;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        long jCopy;
        FileOutputStream fileOutputStream2 = null;
        try {
            c0387aA = a(context, strArr, str, cVar);
        } catch (Throwable th) {
            th = th;
            c0387aA = null;
        }
        try {
            if (c0387aA == null) {
                throw new MissingLibraryException(str);
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 5) {
                    if (c0387aA != null) {
                        try {
                            if (c0387aA.xd != null) {
                                c0387aA.xd.close();
                                return;
                            }
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    return;
                }
                cVar.a("Found %s! Extracting...", str);
                try {
                    if (file.exists() || file.createNewFile()) {
                        try {
                            inputStream = c0387aA.xd.getInputStream(c0387aA.xe);
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    jCopy = copy(inputStream, fileOutputStream);
                                    fileOutputStream.getFD().sync();
                                } catch (FileNotFoundException unused2) {
                                    a(inputStream);
                                    a(fileOutputStream);
                                    i = i2;
                                } catch (IOException unused3) {
                                    a(inputStream);
                                    a(fileOutputStream);
                                    i = i2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream2 = fileOutputStream;
                                    a(inputStream);
                                    a(fileOutputStream2);
                                    throw th;
                                }
                            } catch (FileNotFoundException unused4) {
                                fileOutputStream = null;
                            } catch (IOException unused5) {
                                fileOutputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (FileNotFoundException unused6) {
                            inputStream = null;
                            fileOutputStream = null;
                        } catch (IOException unused7) {
                            inputStream = null;
                            fileOutputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = null;
                        }
                        if (jCopy == file.length()) {
                            a(inputStream);
                            a(fileOutputStream);
                            file.setReadable(true, false);
                            file.setExecutable(true, false);
                            file.setWritable(true);
                            if (c0387aA != null) {
                                try {
                                    if (c0387aA.xd != null) {
                                        c0387aA.xd.close();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused8) {
                                    return;
                                }
                            }
                            return;
                        }
                        a(inputStream);
                        a(fileOutputStream);
                    }
                } catch (IOException unused9) {
                }
                i = i2;
            }
        } catch (Throwable th5) {
            th = th5;
            if (c0387aA != null) {
                try {
                    if (c0387aA.xd != null) {
                        c0387aA.xd.close();
                    }
                } catch (IOException unused10) {
                }
            }
            throw th;
        }
    }

    private static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                outputStream.write(bArr, 0, i);
                j += i;
            } else {
                outputStream.flush();
                return j;
            }
        }
    }

    private static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
