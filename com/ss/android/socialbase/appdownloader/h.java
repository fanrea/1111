package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.alipay.sdk.m.u.i;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class h {
    public static int d(String str) throws PackageManager.NameNotFoundException {
        if (b(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.b.tr().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.ss.android.socialbase.downloader.an.d.u("AppUtils", "getAppVersionCode:" + e.getMessage());
            return -1;
        }
    }

    public static d hc(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.b.tr().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return d(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            com.ss.android.socialbase.downloader.an.d.u("AppUtils", "getAppInfo:" + e.getMessage());
            return null;
        }
    }

    private static d d(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawableLoadIcon = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String string = (applicationInfo == null || applicationInfo.loadLabel(packageManager) == null) ? "" : applicationInfo.loadLabel(packageManager).toString();
        try {
            drawableLoadIcon = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new d(str, string, drawableLoadIcon, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    public static class d {
        private int an;
        private Drawable b;
        private String c;
        private String d;
        private boolean h;
        private String hc;
        private String u;

        public Drawable d() {
            return this.b;
        }

        public void d(Drawable drawable) {
            this.b = drawable;
        }

        public boolean hc() {
            return this.h;
        }

        public void d(boolean z) {
            this.h = z;
        }

        public String b() {
            return this.d;
        }

        public void d(String str) {
            this.d = str;
        }

        public String c() {
            return this.hc;
        }

        public void hc(String str) {
            this.hc = str;
        }

        public String u() {
            return this.c;
        }

        public void b(String str) {
            this.c = str;
        }

        public int an() {
            return this.an;
        }

        public void d(int i) {
            this.an = i;
        }

        public String h() {
            return this.u;
        }

        public void c(String str) {
            this.u = str;
        }

        public d(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            hc(str2);
            d(drawable);
            d(str);
            b(str3);
            c(str4);
            d(i);
            d(z);
        }

        public String toString() {
            return "{\n  pkg name: " + b() + "\n  app icon: " + d() + "\n  app name: " + c() + "\n  app path: " + u() + "\n  app v name: " + h() + "\n  app v code: " + an() + "\n  is system: " + hc() + i.d;
        }
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
