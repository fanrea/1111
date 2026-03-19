package com.tencent.gatherer.core.internal.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class c {
    public static String a(Context context, b bVar) {
        boolean zB;
        boolean zA;
        PackageInfo packageInfo;
        String str;
        if (bVar != null) {
            try {
                zB = bVar.b();
                zA = bVar.a();
            } catch (Throwable th) {
                d.a("WebViewFactory failed!", th);
            }
        } else {
            zB = true;
            zA = true;
        }
        d.a("getChromeInfoVersion visitSystem = " + zB + " visitDexOrODex = " + zA);
        if (!zB) {
            return "unknow";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = a();
        d.a("getPackageInfo, package name: " + strA);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(strA, 1152);
            str = packageInfo.versionName;
            d.a("getPackageInfo, ver: " + str);
        } catch (PackageManager.NameNotFoundException e) {
            d.a("get webview application info failed! ", e);
        } catch (Throwable th2) {
            d.a("other fail:", th2);
        }
        if (strA.equals("com.google.android.webview")) {
            d.a("getPackageInfo, chrome ver: " + str + "web cost:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return str;
        }
        if (strA.equals("com.android.webview") && !TextUtils.isEmpty(str) && (str.contains("-arm64") || packageInfo.versionName.indexOf(".") < 0)) {
            String str2 = str.substring(0, 2) + ".0.0.0";
            d.a("getPackageInfo, chrom ver: " + str2);
            return str2;
        }
        if (strA.equals("com.android.webview") && com.tencent.gatherer.core.internal.util.dex.c.a(packageInfo.versionName)) {
            d.a("16TH chrom ver: " + packageInfo.versionName);
            return packageInfo.versionName;
        }
        if (!zA) {
            return "unknow";
        }
        if (packageInfo.applicationInfo != null) {
            d.a("sourceDire: " + packageInfo.applicationInfo.sourceDir);
            String str3 = packageInfo.applicationInfo.sourceDir;
            if (!TextUtils.isEmpty(str3)) {
                ByteBuffer byteBufferA = a(str3);
                if (byteBufferA == null) {
                    String strA2 = a(b(str3));
                    d.a("odex web ver:" + strA2 + " web cost:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    return strA2;
                }
                d.a("readDexFile cost:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                String strA3 = new com.tencent.gatherer.core.internal.util.dex.c(byteBufferA).a();
                d.a("web ver:" + strA3 + "DexParser cost:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                return strA3;
            }
        } else {
            d.a("applicationInfo is null ");
        }
        return "unknow";
    }

    private static String b() {
        try {
            d.a("getWebViewPackageName4Lollipop ");
            return (String) f.a("android.webkit.WebViewFactory", "getWebViewPackageName", null, new Object[0]);
        } catch (Throwable th) {
            d.a("getWebViewPackageName4Lollipop failed!", th);
            return "com.google.android.webview";
        }
    }

    private static String c() {
        try {
            d.a("getWebViewPackageName4More ");
            return ((Context) f.a("android.webkit.WebViewFactory", "getWebViewContextAndSetProvider", null, new Object[0])).getApplicationInfo().packageName;
        } catch (Throwable th) {
            d.a("getWebViewPackageName4N failed!", th);
            return "com.google.android.webview";
        }
    }

    public static byte[] b(String str) {
        for (File file : new File(new File(str).getParent() + "/oat/arm").listFiles()) {
            if (file.isFile() && file.getName().endsWith(".odex")) {
                String absolutePath = file.getAbsolutePath();
                byte[] bArrC = c(absolutePath);
                if (bArrC != null) {
                    d.a("find odex file:" + absolutePath + ", odexData-len:" + bArrC.length);
                    byte[] bArrA = com.tencent.gatherer.core.internal.util.odex.a.a(bArrC).a().a();
                    StringBuilder sb = new StringBuilder("rodata-len ");
                    sb.append(bArrA.length);
                    d.a(sb.toString());
                    return bArrA;
                }
                d.a("read " + absolutePath + " failed!");
            }
        }
        return null;
    }

    private static byte[] c(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            if (fileInputStream.available() > 10485760) {
                fileInputStream.close();
                return null;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(fileInputStream.available());
            byte[] bArr = new byte[4096];
            int i = 0;
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 != -1) {
                    byteBufferAllocate.put(bArr, 0, i2);
                    i += i2;
                } else {
                    fileInputStream.close();
                    d.a("read " + str + " ret:" + i);
                    return byteBufferAllocate.array();
                }
            }
        } catch (Throwable th) {
            d.a("readDexFile got Exception:", th);
            return null;
        }
    }

    private static String a() {
        int iA = a.a();
        if (iA <= 20) {
            d.a("sdk  = " + iA);
            return "com.google.android.webview";
        }
        switch (iA) {
            case 21:
            case 22:
            case 23:
                return b();
            default:
                return c();
        }
    }

    public static ByteBuffer a(String str) {
        ZipFile zipFile;
        InputStream inputStream;
        int iAvailable;
        d.a("apkpath: " + str);
        ByteBuffer byteBufferAllocate = null;
        try {
            zipFile = new ZipFile(str);
            ZipEntry entry = zipFile.getEntry("classes.dex");
            if (entry == null) {
                d.a("zip not found classes.dex ");
            }
            d.a("zip entry: " + entry.toString());
            inputStream = zipFile.getInputStream(entry);
            iAvailable = inputStream.available();
        } catch (Throwable th) {
            d.a("readDexFile got Throwable:", th);
        }
        if (iAvailable > 10485760) {
            inputStream.close();
            zipFile.close();
            return null;
        }
        byteBufferAllocate = ByteBuffer.allocate(iAvailable);
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                break;
            }
            byteBufferAllocate.put(bArr, 0, i);
        }
        inputStream.close();
        zipFile.close();
        return byteBufferAllocate;
    }

    private static String a(byte[] bArr) {
        String str;
        Throwable th;
        String str2 = "";
        if (bArr == null) {
            return "";
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (i > 50000) {
                d.b("findVersionFromData strCount > 20000");
                return str2;
            }
            if (bArr[i3] == 0) {
                int i4 = i3 - i2;
                if (i4 < 8 || i4 > 20) {
                    i2 = i3 + 1;
                } else {
                    try {
                        byte[] bArr2 = new byte[i4];
                        System.arraycopy(bArr, i2, bArr2, 0, i4);
                        i2 = i3 + 1;
                        int i5 = i4 - 1;
                        if ((bArr2[0] & 255) == i5) {
                            byte[] bArr3 = new byte[i5];
                            System.arraycopy(bArr2, 1, bArr3, 0, i5);
                            bArr2 = bArr3;
                        }
                        if (com.tencent.gatherer.core.internal.util.dex.c.a(bArr2)) {
                            str = new String(bArr2, "UTF-8");
                            try {
                                d.a(str + ", strcount:" + i);
                                return str;
                            } catch (Throwable th2) {
                                th = th2;
                                d.a("findVersionFromData got Exception:", th);
                                str2 = str;
                            }
                        } else {
                            i++;
                        }
                    } catch (Throwable th3) {
                        str = str2;
                        th = th3;
                    }
                }
            }
        }
        return str2;
    }
}
