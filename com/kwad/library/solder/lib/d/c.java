package com.kwad.library.solder.lib.d;

import com.kwad.sdk.utils.w;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.BufferedInputStream, java.io.Closeable, java.io.InputStream] */
    public static Set<String> b(File file, File file2) throws Throwable {
        ZipFile zipFile;
        OutputStream outputStream;
        ZipFile zipFile2;
        ZipFile zipFile3;
        ?? bufferedInputStream;
        if (file == null || !file.exists()) {
            throw new IOException("Apk file not found.");
        }
        HashSet hashSet = new HashSet(4);
        w.ai(file2);
        new StringBuilder("copy so file to ").append(file2.getAbsolutePath()).append(", apk = ").append(file.getName());
        ZipFile zipFile4 = null;
        try {
            zipFile = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                outputStream = null;
                while (enumerationEntries.hasMoreElements()) {
                    try {
                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        String name = zipEntryNextElement.getName();
                        if (name != null && !name.contains("../") && name.startsWith("lib" + File.separator)) {
                            if (zipEntryNextElement.isDirectory()) {
                                File file3 = new File(file2, name);
                                new StringBuilder("create dir ").append(file3.getAbsolutePath());
                                w.ai(file3);
                            } else {
                                File file4 = new File(file2, name);
                                new StringBuilder("unzip soLib file ").append(file4.getAbsolutePath());
                                w.aj(file4);
                                byte[] bArr = new byte[4096];
                                FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                try {
                                    FileDescriptor fd = fileOutputStream.getFD();
                                    OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                    try {
                                        bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntryNextElement));
                                        while (true) {
                                            try {
                                                int i = bufferedInputStream.read(bArr);
                                                if (i == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, i);
                                            } catch (IOException e) {
                                                e = e;
                                                zipFile4 = zipFile;
                                                outputStream = bufferedOutputStream;
                                                zipFile2 = bufferedInputStream;
                                                try {
                                                    com.kwad.library.solder.lib.a.e("plugin.so", e);
                                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipFile = zipFile4;
                                                    zipFile4 = zipFile2;
                                                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) zipFile4);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                zipFile4 = bufferedInputStream;
                                                outputStream = bufferedOutputStream;
                                                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) zipFile4);
                                                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                                                com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                                                throw th;
                                            }
                                        }
                                        bufferedOutputStream.flush();
                                        fd.sync();
                                        com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) bufferedInputStream);
                                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                                        hashSet.add(file4.getName());
                                        zipFile4 = bufferedInputStream;
                                        outputStream = bufferedOutputStream;
                                    } catch (IOException e2) {
                                        e = e2;
                                        bufferedInputStream = zipFile4;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    outputStream = fileOutputStream;
                                    zipFile3 = zipFile4;
                                    zipFile4 = zipFile;
                                    zipFile2 = zipFile3;
                                    com.kwad.library.solder.lib.a.e("plugin.so", e);
                                    throw new IOException("Unzip soLibs fail:" + e.getMessage(), e);
                                } catch (Throwable th4) {
                                    th = th4;
                                    outputStream = fileOutputStream;
                                }
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) zipFile4);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(zipFile);
                return hashSet;
            } catch (IOException e5) {
                e = e5;
                outputStream = null;
                zipFile3 = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
            }
        } catch (IOException e6) {
            e = e6;
            outputStream = null;
            zipFile2 = null;
        } catch (Throwable th7) {
            th = th7;
            zipFile = null;
            outputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File a(java.io.File r3, java.lang.String r4, java.io.File r5) throws java.io.IOException {
        /*
            java.lang.String r0 = com.kwad.library.solder.lib.d.a.PV()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L6e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Try install soLib, supported abi = "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "lib"
            r1.<init>(r2)
            java.lang.String r2 = java.io.File.separator
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = java.io.File.separator
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r3, r0)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L6e
            java.io.File r3 = new java.io.File
            r3.<init>(r5, r4)
            boolean r5 = r1.renameTo(r3)
            if (r5 == 0) goto L66
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "Rename soLib, from = "
            r5.<init>(r0)
            java.lang.String r0 = r1.getAbsolutePath()
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.String r0 = ", to = "
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.String r0 = r3.getAbsolutePath()
            r5.append(r0)
            goto L6f
        L66:
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r4 = "Rename soLib fail."
            r3.<init>(r4)
            throw r3
        L6e:
            r3 = 0
        L6f:
            if (r3 != 0) goto L81
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "Can not install "
            r5.<init>(r0)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r5 = ", NO_MATCHING_ABIS"
            r4.append(r5)
        L81:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.library.solder.lib.d.c.a(java.io.File, java.lang.String, java.io.File):java.io.File");
    }
}
