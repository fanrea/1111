package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.dhylive.app.utils.JumpParam;
import com.ss.android.socialbase.appdownloader.b.mk;
import com.ss.android.socialbase.appdownloader.b.tc;
import com.ss.android.socialbase.downloader.c.s;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b {
    private static int d;
    private static NotificationChannel hc;

    private static String d(long j, long j2, String str, boolean z) {
        double d2 = j;
        if (j2 > 1) {
            d2 /= j2;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d2) + " " + str;
        }
        return new DecimalFormat("#").format(d2) + " " + str;
    }

    public static String d(long j) {
        return d(j, true);
    }

    public static String d(long j, boolean z) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return d(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    private static String d(long j, long j2, String str) {
        double d2 = j;
        if (j2 > 1) {
            d2 /= j2;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d2) + str;
        }
        return new DecimalFormat("#.##").format(d2) + str;
    }

    public static String hc(long j) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return d(j, j2, strArr[i]);
            }
        }
        return null;
    }

    public static int d(final Context context, final int i, final boolean z) {
        mk mkVarGb = c.mk().gb();
        if (mkVarGb == null) {
            return c(context, i, z);
        }
        com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(context).gb(i);
        d = 1;
        mkVarGb.d(bVarGb, new tc() { // from class: com.ss.android.socialbase.appdownloader.b.1
            @Override // com.ss.android.socialbase.appdownloader.b.tc
            public void d() {
                int unused = b.d = b.c(context, i, z);
            }
        });
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(Context context, int i, boolean z) {
        if (com.ss.android.socialbase.downloader.uo.d.d(i).hc("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.hc.d().an(i);
        }
        d((Activity) gb.d().hc());
        if (com.ss.android.socialbase.downloader.uo.d.d(i).d("install_queue_enable", 0) == 1) {
            return gb.d().d(context, i, z);
        }
        return hc(context, i, z);
    }

    public static int hc(final Context context, final int i, final boolean z) throws JSONException {
        final com.ss.android.socialbase.downloader.h.b bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(context).gb(i);
        if (bVarGb != null && "application/vnd.android.package-archive".equals(bVarGb.hg()) && !TextUtils.isEmpty(bVarGb.mk()) && !TextUtils.isEmpty(bVarGb.gb())) {
            final File file = new File(bVarGb.mk(), bVarGb.gb());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.b.hc(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.b.2
                    @Override // java.lang.Runnable
                    public void run() throws JSONException {
                        c.mk().mq();
                        int iD = b.d(context, i, z, bVarGb, file);
                        if (iD == 1 && c.mk().yo() != null) {
                            c.mk().yo().d(bVarGb, null);
                        }
                        b.hc(bVarGb, z, iD);
                    }
                });
                return 1;
            }
        }
        hc(bVarGb, z, 2);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(com.ss.android.socialbase.downloader.h.b bVar, boolean z, int i) throws JSONException {
        if (bVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put("real_package_name", bVar.z());
        } catch (Exception e) {
            mq.d(e);
        }
        com.ss.android.socialbase.downloader.downloader.b.y().d(bVar.h(), "install_view_result", jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d A[DONT_GENERATE, PHI: r0
  0x003d: PHI (r0v13 java.lang.Process) = (r0v12 java.lang.Process), (r0v17 java.lang.Process) binds: [B:13:0x003b, B:6:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r5, int r6, boolean r7, com.ss.android.socialbase.downloader.h.b r8, java.io.File r9) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.d(android.content.Context, int, boolean, com.ss.android.socialbase.downloader.h.b, java.io.File):int");
    }

    public static int d(Context context, Intent intent) {
        try {
            if (c.mk().w() != null) {
                if (c.mk().w().d(intent)) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean d(Context context, com.ss.android.socialbase.downloader.h.b bVar, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(bVar.us())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.b.u uVarB = c.mk().b();
        if (uVarB != null) {
            uVarB.d(bVar.h(), 8, bVar.us(), packageInfo.packageName, "");
            if (uVarB.d()) {
                return true;
            }
        }
        s sVarTt = com.ss.android.socialbase.downloader.downloader.h.hc(context).tt(bVar.h());
        if (sVarTt == null) {
            return false;
        }
        sVarTt.d(8, bVar, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.b.c cVarHc = c.mk().hc();
        return (cVarHc instanceof com.ss.android.socialbase.appdownloader.b.d) && ((com.ss.android.socialbase.appdownloader.b.d) cVarHc).hc();
    }

    public static boolean d(Context context, int i, File file) {
        if (com.ss.android.socialbase.downloader.uo.d.d(i).d("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.an.u.uo() || com.ss.android.socialbase.appdownloader.an.u.k()) && com.ss.android.socialbase.downloader.e.tc.d(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt(JumpParam.USER_ID, 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                mq.d(e);
            }
        }
        return false;
    }

    public static int d() {
        return c.mk().h() ? 16384 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri d(int r1, com.ss.android.socialbase.downloader.c.sy r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.d(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.c r2 = com.ss.android.socialbase.appdownloader.c.mk()
            com.ss.android.socialbase.appdownloader.b.h r2 = r2.an()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.d(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L3b
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L37
            r0 = 24
            if (r2 < r0) goto L32
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L37
            if (r2 != 0) goto L32
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L32:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L37:
            r2 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r2)
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.d(int, com.ss.android.socialbase.downloader.c.sy, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent d(Context context, com.ss.android.socialbase.downloader.h.b bVar, File file, boolean z, int[] iArr) {
        Uri uriD = d(bVar.h(), com.ss.android.socialbase.downloader.downloader.h.hc(context).mq(bVar.h()), context, c.mk().u(), file);
        if (uriD == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(uriD, "application/vnd.android.package-archive");
        com.ss.android.socialbase.appdownloader.b.u uVarB = c.mk().b();
        int iD = uVarB != null ? uVarB.d(bVar.h(), z) : 0;
        s sVarTt = com.ss.android.socialbase.downloader.downloader.h.hc(context).tt(bVar.h());
        int iD2 = iD;
        if (sVarTt != null) {
            iD2 = sVarTt.d(z);
        }
        iArr[0] = iD2;
        if (iD2 != 0) {
            return null;
        }
        return intent;
    }

    public static boolean d(com.ss.android.socialbase.downloader.h.b bVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.us()) || !str.equals(bVar.us())) {
            return !TextUtils.isEmpty(bVar.gb()) && d(com.ss.android.socialbase.downloader.downloader.b.tr(), bVar, str);
        }
        return true;
    }

    public static boolean d(Context context, com.ss.android.socialbase.downloader.h.b bVar, String str) throws PackageManager.NameNotFoundException {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(bVar.mk(), bVar.gb());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                mq.c("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + bVar.gb() + " apkFileSize：" + file.length() + " fileUrl：" + bVar.tc());
                PackageInfo packageInfoD = d(bVar, file);
                if (packageInfoD == null || !packageInfoD.packageName.equals(str)) {
                    return false;
                }
                int i = packageInfoD.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, d());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("install_callback_error")) {
                    return false;
                }
                String strD = com.ss.android.socialbase.downloader.e.an.d(bVar.a().get("extra_apk_package_name"), (String) null);
                int iD = com.ss.android.socialbase.downloader.e.an.d(bVar.a().get("extra_apk_version_code"), 0);
                if (strD == null || TextUtils.isEmpty(strD) || !strD.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, d());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || iD != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            mq.d(e);
            return false;
        }
    }

    public static boolean hc(Context context, com.ss.android.socialbase.downloader.h.b bVar, PackageInfo packageInfo) {
        return d(context, bVar, packageInfo, false);
    }

    public static boolean d(Context context, com.ss.android.socialbase.downloader.h.b bVar, PackageInfo packageInfo, boolean z) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (bVar != null) {
            bVar.gb(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, d());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        return z ? i < i2 : (bVar == null || com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("install_with_same_version_code", 0) != 1) ? i <= i2 : i < i2;
    }

    public static boolean d(Context context, com.ss.android.socialbase.downloader.h.b bVar) {
        return d(context, bVar, true);
    }

    public static boolean d(Context context, com.ss.android.socialbase.downloader.h.b bVar, boolean z) throws PackageManager.NameNotFoundException {
        if (bVar == null) {
            return false;
        }
        String strUs = bVar.us();
        int iEd = bVar.ed();
        if (iEd > 0 || !z) {
            PackageInfo packageInfo = null;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(strUs, d());
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (packageInfo == null) {
                return false;
            }
            return com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("install_with_same_version_code", 0) == 1 ? iEd < packageInfo.versionCode : iEd <= packageInfo.versionCode;
        }
        return b(context, bVar);
    }

    public static int hc(Context context, com.ss.android.socialbase.downloader.h.b bVar) {
        if (context != null && bVar != null && !TextUtils.isEmpty(bVar.mk()) && !TextUtils.isEmpty(bVar.gb())) {
            int iEd = bVar.ed();
            if (iEd > 0) {
                return iEd;
            }
            try {
                PackageInfo packageInfoD = d(context, bVar, bVar.mk(), bVar.gb());
                if (packageInfoD != null) {
                    int i = packageInfoD.versionCode;
                    bVar.gb(i);
                    return i;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static boolean b(Context context, com.ss.android.socialbase.downloader.h.b bVar) {
        if (context == null || bVar == null || TextUtils.isEmpty(bVar.mk()) || TextUtils.isEmpty(bVar.gb())) {
            return false;
        }
        return hc(context, bVar, d(context, bVar, bVar.mk(), bVar.gb()));
    }

    public static PackageInfo d(Context context, com.ss.android.socialbase.downloader.h.b bVar, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        mq.c("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return d(bVar, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r0 = "default.apk"
            java.lang.String r2 = ".."
            if (r6 == 0) goto L34
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L5a
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = r4.contains(r2)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            goto L5a
        L32:
            r4 = r0
            goto L5a
        L34:
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L4c
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L4c
            java.lang.String r1 = r3.getLastPathSegment()
        L4c:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L59
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L32
            goto L5a
        L59:
            r4 = r1
        L5a:
            boolean r3 = b(r5)
            if (r3 == 0) goto L79
            java.lang.String r3 = ".apk"
            boolean r5 = r4.endsWith(r3)
            if (r5 != 0) goto L79
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r4 = r3.toString()
        L79:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.d(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static String hc() {
        return com.ss.android.socialbase.downloader.e.an.u();
    }

    public static String d(String str, com.ss.android.socialbase.downloader.uo.d dVar) {
        JSONObject jSONObjectC;
        String str2;
        if (dVar == null || (jSONObjectC = dVar.c("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectC.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e) {
            mq.d(e);
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static boolean hc(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            mq.d(e);
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    public static int d(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (com.ss.android.socialbase.downloader.hc.an.hc(i) || i == 11) {
            return 1;
        }
        return com.ss.android.socialbase.downloader.hc.an.d(i) ? 3 : 0;
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    public static boolean d(Context context) {
        int color;
        if (Build.VERSION.SDK_INT > 20 && context != null) {
            TypedArray typedArrayObtainStyledAttributes = null;
            try {
                color = context.getResources().getColor(u.hc());
                typedArrayObtainStyledAttributes = context.obtainStyledAttributes(u.u(), new int[]{u.b(), u.c()});
            } catch (Throwable unused) {
                if (typedArrayObtainStyledAttributes != null) {
                }
            }
            if (color == typedArrayObtainStyledAttributes.getColor(0, 0)) {
                if (typedArrayObtainStyledAttributes != null) {
                    try {
                        typedArrayObtainStyledAttributes.recycle();
                    } catch (Throwable unused2) {
                    }
                }
                return true;
            }
            if (typedArrayObtainStyledAttributes != null) {
                try {
                    typedArrayObtainStyledAttributes.recycle();
                } catch (Throwable unused3) {
                }
            }
        }
        return false;
    }

    public static String hc(Context context) {
        try {
            if (hc == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                hc = notificationChannel;
                notificationChannel.setSound(null, null);
                hc.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(hc);
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        return "111111";
    }

    public static List<String> b() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static void d(com.ss.android.socialbase.downloader.h.b bVar, boolean z, boolean z2) {
        c.mk().d(new an(com.ss.android.socialbase.downloader.downloader.b.tr(), bVar.tc()).d(bVar.tt()).hc(bVar.gb()).b(bVar.mk()).d(bVar.ox()).hc(bVar.p()).b(bVar.np() || z2).u(bVar.s()).an(bVar.hg()).d(bVar.mt()).u(true).hc(bVar.hv()).b(bVar.bc()).hc(bVar.uq()).c(bVar.vs()).u(bVar.dr()).an(z).c(bVar.gu()).h(bVar.us()).gb(bVar.fs()).d(bVar.ba()).tt(bVar.e()).tc(bVar.qy()).mq(bVar.nf()).d(bVar.yo()).k(bVar.fv()).uo(bVar.fy()).h(bVar.ho()).tt(bVar.ic()).d(c(bVar.ru())).mk(bVar.lv()).an(bVar.zg()).cb(bVar.hr()));
    }

    private static JSONObject c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e) {
                mq.d(e);
            }
        }
    }

    public static PackageInfo d(com.ss.android.socialbase.downloader.h.b bVar, File file) {
        if (bVar == null) {
            return com.ss.android.socialbase.appdownloader.an.d.u.d(com.ss.android.socialbase.downloader.downloader.b.tr(), file, d());
        }
        PackageInfo packageInfoJi = bVar.ji();
        if (packageInfoJi != null) {
            return packageInfoJi;
        }
        PackageInfo packageInfoD = com.ss.android.socialbase.appdownloader.an.d.u.d(com.ss.android.socialbase.downloader.downloader.b.tr(), file, d());
        bVar.d(packageInfoD);
        return packageInfoD;
    }

    public static int d(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
