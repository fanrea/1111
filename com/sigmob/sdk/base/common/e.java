package com.sigmob.sdk.base.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.czhj.sdk.common.mta.PointEntitySuper;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.AppInfo;
import com.sigmob.sdk.base.models.rtb.Ad;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.windad.WindAdError;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e {
    private static Boolean a;

    public static String[] a() {
        Context contextE = com.sigmob.sdk.b.e();
        if (contextE == null) {
            return null;
        }
        try {
            return contextE.getPackageManager().getPackageInfo(contextE.getPackageName(), 4096).requestedPermissions;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static WindAdError b() {
        Context contextE = com.sigmob.sdk.b.e();
        try {
            SigmobLog.d("checkActivity: " + AdActivity.class.getName());
            contextE.getPackageManager().getActivityInfo(new ComponentName(contextE, (Class<?>) AdActivity.class), 128);
        } catch (PackageManager.NameNotFoundException e) {
            SigmobLog.e("checkActivity: " + e.getMessage());
            return WindAdError.ERROR_LOAD_FILTER_FOR_ACTIVITY_ERROR;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (!Ad.class.getName().endsWith("base.models.rtb.Ad")) {
                SigmobLog.e("checkProguard Ad: " + Ad.class.getName());
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (!MaterialMeta.class.getName().endsWith("base.models.rtb.MaterialMeta")) {
                SigmobLog.e("checkProguard Strategy: " + MaterialMeta.class.getName());
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (!AppInfo.class.getName().endsWith("base.models.AppInfo")) {
                SigmobLog.e("checkProguard AppInfo: " + AppInfo.class.getName());
                return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
            }
            if (PointEntitySuper.class.getName().endsWith("common.mta.PointEntitySuper")) {
                return null;
            }
            SigmobLog.e("checkProguard PointCategory: " + PointEntitySuper.class.getName());
            return WindAdError.ERROR_LOAD_FILTER_FOR_PROGUARD_ERROR;
        } catch (Throwable th2) {
            SigmobLog.e("checkProguard: " + th2.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008f, code lost:
    
        r3 = com.sigmob.sdk.b.e().getPackageManager().getProviderInfo(new android.content.ComponentName(com.sigmob.sdk.b.e(), r7.name), 128).metaData;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
    
        if (r3 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
    
        r3 = r3.getInt("android.support.FILE_PROVIDER_PATHS");
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4 A[Catch: all -> 0x0143, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:21:0x0049, B:24:0x0050, B:26:0x006a, B:28:0x0070, B:30:0x0076, B:32:0x008f, B:34:0x00ac, B:41:0x00d4, B:38:0x00b7, B:56:0x013b, B:20:0x002f, B:11:0x0010, B:13:0x001c, B:15:0x0020), top: B:63:0x0003, inners: #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean c() {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.common.e.c():boolean");
    }

    public static boolean d() {
        String[] strArrA = a();
        if (strArrA == null) {
            return false;
        }
        for (String str : strArrA) {
            if (str.equals("android.permission.QUERY_ALL_PACKAGES")) {
                return true;
            }
        }
        return false;
    }
}
