package com.ss.android.socialbase.appdownloader.an.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.baidu.mobads.container.util.cm;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u {
    private static String d(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
    
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.pm.PackageInfo d(java.io.File r13) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.an.d.u.d(java.io.File):android.content.pm.PackageInfo");
    }

    public static PackageInfo d(Context context, File file, int i) {
        if (com.ss.android.socialbase.downloader.e.d.d(268435456) && Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 26) {
            try {
                return d(file);
            } catch (Throwable th) {
                d("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
            }
        }
        return hc(context, file, i);
    }

    private static PackageInfo hc(Context context, File file, int i) throws JSONException {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            d("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            d("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    private static void d(String str, String str2) throws JSONException {
        if (com.ss.android.socialbase.downloader.downloader.b.an() == null) {
            return;
        }
        try {
            new JSONObject().put(cm.V, str2);
        } catch (JSONException unused) {
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

    public static String d(Context context, PackageInfo packageInfo, String str) throws JSONException {
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            d("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }
}
