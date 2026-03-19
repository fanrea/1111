package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.netease.htprotect.p010Ooo.p014o0o0.O8oO888;
import java.io.InputStream;
import java.util.zip.ZipFile;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.volatile, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cvolatile {
    public static String a(Context context, String str) {
        ZipFile zipFile;
        InputStream inputStream;
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        InputStream inputStream2 = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
        } catch (Throwable unused) {
        }
        String nodeValue = (packageManager == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0)) == null) ? null : packageArchiveInfo.packageName;
        if (nodeValue != null) {
            return nodeValue;
        }
        try {
            try {
                zipFile = new ZipFile(str);
                try {
                    inputStream = zipFile.getInputStream(zipFile.getEntry(O8oO888.f344Ooo));
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                zipFile = null;
            }
        } catch (Throwable unused4) {
        }
        try {
            nodeValue = new Creturn().a(inputStream).getChildNodes().item(0).getAttributes().getNamedItem("package").getNodeValue();
            Auriga.a(inputStream);
            if (Cdefault.b() >= 19) {
                Auriga.a(zipFile);
            } else {
                zipFile.close();
            }
        } catch (Throwable unused5) {
            inputStream2 = inputStream;
            Auriga.a(inputStream2);
            if (Cdefault.b() >= 19) {
                Auriga.a(zipFile);
            } else {
                zipFile.close();
            }
            return nodeValue;
        }
        return nodeValue;
    }
}
