package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class oc {
    static boolean d(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 128) != null;
    }

    static boolean d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
            if (packageManager.getPackageInfo("com.huawei.hms", 0) != null) {
                return true;
            }
            return false;
        }
        return true;
    }

    static void d(String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new com.bytedance.sdk.component.tc.c.b(new d(runnable, str), str).start();
    }

    static class d implements Runnable {
        private final String b = Log.getStackTraceString(new RuntimeException("origin stacktrace"));
        private final Runnable d;
        private final String hc;

        d(Runnable runnable, String str) {
            this.d = runnable;
            this.hc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.d.run();
            } catch (Exception e) {
                um.b("Thread:" + this.hc + " exception\n" + this.b, e);
            }
        }
    }
}
