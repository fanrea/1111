package com.netease.htprotect.p020oO.p021O8oO888;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.netease.htprotect.p020oO.p021O8oO888.O8;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.netease.htprotect.〇oO.O8〇oO8〇88.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 implements O8.O8oO888 {

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static final int f538O8oO888 = 5;

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static final int f539Ooo = 4096;

    /* renamed from: com.netease.htprotect.〇oO.O8〇oO8〇88.O8〇oO8〇88$O8〇oO8〇88, reason: invalid class name and collision with other inner class name */
    private static class C0682O8oO888 {

        /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
        public ZipFile f540O8oO888;

        /* renamed from: 〇Ooo, reason: contains not printable characters */
        public ZipEntry f541Ooo;

        public C0682O8oO888(ZipFile zipFile, ZipEntry zipEntry) {
            this.f540O8oO888 = zipFile;
            this.f541Ooo = zipEntry;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static long m1093O8oO888(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += i;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static C0682O8oO888 m1094O8oO888(Context context, String[] strArr, String str) throws IOException {
        String[] strArrM1096O8oO888 = m1096O8oO888(context);
        int length = strArrM1096O8oO888.length;
        int i = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i >= length) {
                return null;
            }
            String str2 = strArrM1096O8oO888[i];
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i2 = i3;
                }
            }
            if (zipFile != null) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 < 5) {
                        for (String str3 : strArr) {
                            String str4 = "lib" + File.separatorChar + str3 + File.separatorChar + str;
                            o0o0.m1131O8oO888("Looking for %s in APK %s...", str4, str2);
                            ZipEntry entry = zipFile.getEntry(str4);
                            if (entry != null) {
                                return new C0682O8oO888(zipFile, entry);
                            }
                        }
                        i4 = i5;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i++;
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m1095O8oO888(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String[] m1096O8oO888(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (Build.VERSION.SDK_INT < 21 || applicationInfo.splitSourceDirs == null || applicationInfo.splitSourceDirs.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr = new String[applicationInfo.splitSourceDirs.length + 1];
        strArr[0] = applicationInfo.sourceDir;
        System.arraycopy(applicationInfo.splitSourceDirs, 0, strArr, 1, applicationInfo.splitSourceDirs.length);
        return strArr;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String[] m1097O8oO888(Context context, String str) {
        Pattern patternCompile = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
        HashSet hashSet = new HashSet();
        for (String str2 : m1096O8oO888(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str2), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    @Override // com.netease.htprotect.p020oO.p021O8oO888.O8.O8oO888
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public final void mo1098O8oO888(Context context, String[] strArr, String str, File file) throws Throwable {
        String[] strArrM1097O8oO888;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        long jM1093O8oO888;
        C0682O8oO888 c0682O8oO888 = null;
        InputStream inputStream2 = null;
        try {
            C0682O8oO888 c0682O8oO888M1094O8oO888 = m1094O8oO888(context, strArr, str);
            try {
                if (c0682O8oO888M1094O8oO888 == null) {
                    try {
                        strArrM1097O8oO888 = m1097O8oO888(context, str);
                    } catch (Exception e) {
                        strArrM1097O8oO888 = new String[]{e.toString()};
                    }
                    throw new Ooo(str, strArr, strArrM1097O8oO888);
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i >= 5) {
                        if (c0682O8oO888M1094O8oO888 != null) {
                            try {
                                if (c0682O8oO888M1094O8oO888.f540O8oO888 != null) {
                                    c0682O8oO888M1094O8oO888.f540O8oO888.close();
                                    return;
                                }
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    }
                    o0o0.m1131O8oO888("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = c0682O8oO888M1094O8oO888.f540O8oO888.getInputStream(c0682O8oO888M1094O8oO888.f541Ooo);
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        jM1093O8oO888 = m1093O8oO888(inputStream, fileOutputStream);
                                        fileOutputStream.getFD().sync();
                                    } catch (FileNotFoundException unused2) {
                                        m1095O8oO888(inputStream);
                                        m1095O8oO888(fileOutputStream);
                                        i = i2;
                                    } catch (IOException unused3) {
                                        m1095O8oO888(inputStream);
                                        m1095O8oO888(fileOutputStream);
                                        i = i2;
                                    } catch (Throwable th) {
                                        th = th;
                                        inputStream2 = inputStream;
                                        m1095O8oO888(inputStream2);
                                        m1095O8oO888(fileOutputStream);
                                        throw th;
                                    }
                                } catch (FileNotFoundException unused4) {
                                    fileOutputStream = null;
                                } catch (IOException unused5) {
                                    fileOutputStream = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileOutputStream = null;
                                }
                            } catch (FileNotFoundException unused6) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (IOException unused7) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = null;
                            }
                            if (jM1093O8oO888 == file.length()) {
                                m1095O8oO888(inputStream);
                                m1095O8oO888(fileOutputStream);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                if (c0682O8oO888M1094O8oO888 != null) {
                                    try {
                                        if (c0682O8oO888M1094O8oO888.f540O8oO888 != null) {
                                            c0682O8oO888M1094O8oO888.f540O8oO888.close();
                                            return;
                                        }
                                        return;
                                    } catch (IOException unused8) {
                                        return;
                                    }
                                }
                                return;
                            }
                            m1095O8oO888(inputStream);
                            m1095O8oO888(fileOutputStream);
                        }
                    } catch (IOException unused9) {
                    }
                    i = i2;
                }
            } catch (Throwable th4) {
                th = th4;
                c0682O8oO888 = c0682O8oO888M1094O8oO888;
                if (c0682O8oO888 != null) {
                    try {
                        if (c0682O8oO888.f540O8oO888 != null) {
                            c0682O8oO888.f540O8oO888.close();
                        }
                    } catch (IOException unused10) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
