package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import ms.bz.bd.c.Pgl.e1;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class pbld implements e1.pgla {

    private static class pgla {
        public ZipFile d;
        public ZipEntry hc;

        public pgla(ZipFile zipFile, ZipEntry zipEntry) {
            this.d = zipFile;
            this.hc = zipEntry;
        }
    }

    private static pgla d(Context context, String[] strArr, String str, g1 g1Var) throws IOException {
        String[] strArr2;
        String[] strArr3;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = 0;
        if (Build.VERSION.SDK_INT < 21 || (strArr3 = applicationInfo.splitSourceDirs) == null || strArr3.length == 0) {
            strArr2 = new String[]{applicationInfo.sourceDir};
        } else {
            strArr2 = new String[strArr3.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr3, 0, strArr2, 1, strArr3.length);
        }
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i2 >= length) {
                return null;
            }
            String str2 = strArr2[i2];
            int i3 = i;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile != null) {
                int i5 = i;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < 5) {
                        int length2 = strArr.length;
                        int i7 = i;
                        while (i7 < length2) {
                            String str3 = "lib" + File.separatorChar + strArr[i7] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[i] = str3;
                            objArr[1] = str2;
                            g1Var.getClass();
                            String.format(Locale.US, "Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new pgla(zipFile, entry);
                            }
                            i7++;
                            i = 0;
                        }
                        i5 = i6;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i2++;
            i = 0;
        }
    }

    private static void d(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static String[] d(Context context, String str) throws IOException {
        String[] strArr;
        String[] strArr2;
        Pattern patternCompile = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
        HashSet hashSet = new HashSet();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || (strArr2 = applicationInfo.splitSourceDirs) == null || strArr2.length == 0) {
            strArr = new String[]{applicationInfo.sourceDir};
        } else {
            strArr = new String[strArr2.length + 1];
            strArr[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr2, 0, strArr, 1, strArr2.length);
        }
        ZipFile zipFile = null;
        for (String str2 : strArr) {
            try {
                ZipFile zipFile2 = new ZipFile(new File(str2), 1);
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
                zipFile = zipFile2;
            } catch (IOException unused) {
            }
        }
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final void d(Context context, String[] strArr, String str, File file, g1 g1Var) {
        pgla pglaVarD;
        String[] strArrD;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        long j;
        pgla pglaVar = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            pglaVarD = d(context, strArr, str, g1Var);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (pglaVarD == null) {
                try {
                    strArrD = d(context, str);
                } catch (Exception e) {
                    strArrD = new String[]{e.toString()};
                }
                throw new y0(str, strArr, strArrD);
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 5) {
                    g1Var.getClass();
                    try {
                        ZipFile zipFile = pglaVarD.d;
                        if (zipFile != null) {
                            zipFile.close();
                            return;
                        }
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
                g1Var.getClass();
                String.format(Locale.US, "Found %s! Extracting...", str);
                try {
                    if (file.exists() || file.createNewFile()) {
                        try {
                            inputStream = pglaVarD.d.getInputStream(pglaVarD.hc);
                        } catch (FileNotFoundException | IOException unused2) {
                            inputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                        }
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            j = 0;
                        } catch (FileNotFoundException | IOException unused3) {
                            fileOutputStream = null;
                            d(inputStream);
                            d(fileOutputStream);
                            i = i2;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        try {
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int i3 = inputStream.read(bArr);
                                    if (i3 == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i3);
                                    j += i3;
                                }
                                fileOutputStream.flush();
                                fileOutputStream.getFD().sync();
                                if (j == file.length()) {
                                    d(inputStream);
                                    d(fileOutputStream);
                                    file.setReadable(true, false);
                                    file.setExecutable(true, false);
                                    file.setWritable(true);
                                    try {
                                        ZipFile zipFile2 = pglaVarD.d;
                                        if (zipFile2 != null) {
                                            zipFile2.close();
                                            return;
                                        }
                                        return;
                                    } catch (IOException unused4) {
                                        return;
                                    }
                                }
                                d(inputStream);
                                d(fileOutputStream);
                            } catch (Throwable th5) {
                                th = th5;
                                fileOutputStream2 = fileOutputStream;
                                d(inputStream);
                                d(fileOutputStream2);
                                throw th;
                            }
                        } catch (FileNotFoundException | IOException unused5) {
                            d(inputStream);
                            d(fileOutputStream);
                            i = i2;
                        }
                    }
                } catch (IOException unused6) {
                }
                i = i2;
            }
        } catch (Throwable th6) {
            th = th6;
            pglaVar = pglaVarD;
            if (pglaVar != null) {
                try {
                    ZipFile zipFile3 = pglaVar.d;
                    if (zipFile3 != null) {
                        zipFile3.close();
                    }
                } catch (IOException unused7) {
                }
            }
            throw th;
        }
    }
}
