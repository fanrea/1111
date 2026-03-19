package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class cf {
    public static void zipFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(".zip") || !zip(file, new File(absolutePath + ".zip"))) {
            return;
        }
        file.delete();
    }

    private static boolean a(File[] fileArr, File file) {
        if (file == null) {
            return false;
        }
        a aVar = null;
        try {
            byte[] bArr = new byte[4096];
            a aVar2 = new a(new BufferedOutputStream(new FileOutputStream(file, false)));
            for (int i = 0; i <= 0; i++) {
                try {
                    a(aVar2, fileArr[0], null, bArr);
                } catch (Throwable th) {
                    th = th;
                    aVar = aVar2;
                    try {
                        com.kwad.sdk.core.d.c.e("ZipUtils", "error zip", th);
                        return false;
                    } finally {
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    }
                }
            }
            aVar2.flush();
            aVar2.closeEntry();
            com.kwad.sdk.crash.utils.b.closeQuietly(aVar2);
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean zip(File file, File file2) {
        return a(new File[]{file}, file2);
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) throws IOException {
        File[] fileArrListFiles;
        if (zipOutputStream != null && file != null) {
            if (!file.exists()) {
                com.kwad.sdk.core.d.c.e("ZipUtils", file.toString(), new FileNotFoundException("(doZip:142)Target File is missing"));
                return;
            }
            BufferedInputStream bufferedInputStream = null;
            String strIW = TextUtils.isEmpty(str) ? iW(file.getName()) : str + File.separator + iW(file.getName());
            if (file.isFile()) {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(strIW));
                        while (true) {
                            int i = bufferedInputStream2.read(bArr, 0, bArr.length);
                            if (-1 != i) {
                                zipOutputStream.write(bArr, 0, i);
                            } else {
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                                return;
                            }
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        com.kwad.sdk.core.d.c.e("ZipUtils", "error doZip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        throw e;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } else {
                if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
                    return;
                }
                for (File file2 : fileArrListFiles) {
                    a(zipOutputStream, file2, strIW, bArr);
                }
            }
        } else {
            com.kwad.sdk.core.d.c.e("ZipUtils", "", new IOException("(dozip:179) I/O Object got NullPointerException"));
        }
    }

    private static String iW(String str) {
        return ((!TextUtils.isEmpty(str) || str.length() <= 1) && !TextUtils.isEmpty(str) && str.charAt(0) == '.') ? str.substring(1) : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static boolean unZip(InputStream inputStream, String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Closeable closeable;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipInputStream zipInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                try {
                    ZipInputStream zipInputStream2 = new ZipInputStream(bufferedInputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            ZipEntry nextEntry = zipInputStream2.getNextEntry();
                            if (nextEntry != null) {
                                String name = nextEntry.getName();
                                if (!name.contains("../")) {
                                    if (nextEntry.isDirectory()) {
                                        new File(str + "/" + name).mkdirs();
                                    } else {
                                        File file2 = new File(str + "/" + name);
                                        if (!file2.getParentFile().exists()) {
                                            file2.getParentFile().mkdirs();
                                        }
                                        try {
                                            fileOutputStream = new FileOutputStream(file2);
                                            while (true) {
                                                try {
                                                    try {
                                                        int i = zipInputStream2.read(bArr);
                                                        if (i == -1) {
                                                            break;
                                                        }
                                                        fileOutputStream.write(bArr, 0, i);
                                                    } catch (IOException e) {
                                                        e = e;
                                                        com.kwad.sdk.core.d.c.e("ZipUtils", "error unZip when write", e);
                                                        closeable = fileOutputStream;
                                                        com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                                        zipInputStream2.closeEntry();
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipInputStream = fileOutputStream;
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                                                    throw th;
                                                }
                                            }
                                            fileOutputStream.flush();
                                            fileOutputStream.getFD().sync();
                                            closeable = fileOutputStream;
                                        } catch (IOException e2) {
                                            e = e2;
                                            fileOutputStream = 0;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                        com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                        zipInputStream2.closeEntry();
                                    }
                                }
                            } else {
                                com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                return true;
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        zipInputStream = zipInputStream2;
                        com.kwad.sdk.core.d.c.e("ZipUtils", "error unZip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        zipInputStream = zipInputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
        }
    }

    public static class a extends ZipOutputStream {
        private Map<String, Integer> cos;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.cos = new HashMap();
        }

        @Override // java.util.zip.ZipOutputStream
        public final void putNextEntry(ZipEntry zipEntry) throws IOException {
            ZipEntry zipEntry2;
            Integer numValueOf;
            String name = zipEntry.getName();
            Integer num = this.cos.get(name);
            if (num != null && num.intValue() > 0) {
                zipEntry2 = new ZipEntry(zipEntry.getName().replaceFirst("\\.", "(" + num + ")."));
                numValueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                zipEntry2 = zipEntry;
                numValueOf = 1;
            }
            this.cos.put(name, numValueOf);
            super.putNextEntry(zipEntry2);
        }
    }
}
