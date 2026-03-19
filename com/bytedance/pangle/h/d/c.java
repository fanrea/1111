package com.bytedance.pangle.h.d;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.h;
import com.netease.htprotect.p010Ooo.p014o0o0.O8oO888;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static String d(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static u d(File file) {
        ZipFile zipFile;
        d dVar;
        int iHc;
        int i;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                h.d((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry(O8oO888.f344Ooo);
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    h.d(zipFile2);
                    return null;
                }
                dVar = new d();
                try {
                    dVar.d(zipFile2.getInputStream(entry));
                    do {
                        iHc = dVar.hc();
                        if (iHc == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                dVar.d();
                            } catch (Throwable unused) {
                            }
                            h.d(zipFile2);
                            return null;
                        }
                    } while (iHc != 2);
                    int iB = dVar.b();
                    String strD = null;
                    String strD2 = null;
                    for (int i2 = 0; i2 != iB; i2++) {
                        if ("versionCode".equals(dVar.d(i2))) {
                            strD = d(dVar, i2);
                        } else if ("package".equals(dVar.d(i2))) {
                            strD2 = d(dVar, i2);
                        }
                    }
                    try {
                        i = Integer.parseInt(strD);
                    } catch (Throwable unused2) {
                        i = -1;
                    }
                    if (i == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(strD)));
                        try {
                            dVar.d();
                        } catch (Throwable unused3) {
                        }
                        h.d(zipFile2);
                        return null;
                    }
                    u uVar = new u(strD2, i);
                    try {
                        dVar.d();
                    } catch (Throwable unused4) {
                    }
                    h.d(zipFile2);
                    return uVar;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zipFile = zipFile2;
                    th = th2;
                    try {
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            return null;
                        }
                        u uVar2 = new u(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (dVar != null) {
                            try {
                                dVar.d();
                            } catch (Throwable unused5) {
                            }
                        }
                        h.d(zipFile);
                        return uVar2;
                    } finally {
                        if (dVar != null) {
                            try {
                                dVar.d();
                            } catch (Throwable unused6) {
                            }
                        }
                        h.d(zipFile);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                dVar = null;
            }
        } catch (Throwable th4) {
            th = th4;
            zipFile = null;
            dVar = null;
        }
    }

    private static String d(d dVar, int i) {
        int iHc = dVar.hc(i);
        int iB = dVar.b(i);
        if (iHc == 3) {
            return dVar.c(i);
        }
        return iHc == 2 ? String.format("?%s%08X", d(iB), Integer.valueOf(iB)) : (iHc < 16 || iHc > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(iB), Integer.valueOf(iHc)) : String.valueOf(iB);
    }
}
