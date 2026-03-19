package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.forbes.Config;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.widget.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class ar {
    private static Handler cbB = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.config.d cmA;

    static final class a {
        private static final ar cmE = new ar();
    }

    public static ar apc() {
        return a.cmE;
    }

    private com.kwad.sdk.core.config.d apd() {
        if (this.cmA == null) {
            this.cmA = new com.kwad.sdk.core.config.d();
        }
        return this.cmA;
    }

    public final void ape() {
        try {
            com.kwad.sdk.core.c.b.aaf();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.utils.ar.1
                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* renamed from: onActivityStopped */
                public final void e(Activity activity) {
                    super.e(activity);
                    com.kwad.sdk.core.d.c.d("PackageInstallHelper", "onActivityStopped:" + activity);
                    if (ar.cbB != null) {
                        ar.cbB.removeCallbacksAndMessages(null);
                    }
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                    com.kwad.sdk.core.d.c.d("PackageInstallHelper", "onBackToBackground:");
                    if (ar.cbB != null) {
                        ar.cbB.removeCallbacksAndMessages(null);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private static boolean apf() {
        return j.anQ() || j.anR();
    }

    public final void x(final Activity activity) {
        com.kwad.sdk.core.config.d dVarApd = apd();
        if (dVarApd == null || dVarApd.bAp == 0) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "config is null or enableDialog is false");
            return;
        }
        int i = dVarApd.bAq;
        if (i < 0) {
            return;
        }
        if (!apf()) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "not support");
            return;
        }
        if (a(dVarApd)) {
            return;
        }
        if (apj() >= dVarApd.bAs) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "show times is over max");
            return;
        }
        if (y(activity)) {
            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "has install permission");
            return;
        }
        Handler handler = cbB;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            cbB.postDelayed(new Runnable() { // from class: com.kwad.sdk.utils.ar.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        final Activity activity2 = (Activity) com.kwad.sdk.p.m.wrapContextIfNeed(activity);
                        if (activity2.isFinishing()) {
                            return;
                        }
                        if (Build.VERSION.SDK_INT < 17 || !activity2.isDestroyed()) {
                            com.kwad.sdk.core.d.c.d("PackageInstallHelper", "show dialog");
                            f.a aVar = new f.a(activity2);
                            aVar.jf("去授权").jg("残忍拒绝").je("需要授予安装其他应用权限");
                            aVar.a(new f.b() { // from class: com.kwad.sdk.utils.ar.2.1
                                @Override // com.kwad.sdk.widget.f.b
                                public final void a(DialogInterface dialogInterface) {
                                    bx.e(dialogInterface);
                                    j.cY(activity2);
                                }

                                @Override // com.kwad.sdk.widget.f.b
                                public final void b(DialogInterface dialogInterface) {
                                    bx.e(dialogInterface);
                                }

                                @Override // com.kwad.sdk.widget.f.b
                                public final void c(DialogInterface dialogInterface) {
                                    bx.e(dialogInterface);
                                }
                            });
                            try {
                                aVar.aqR().show();
                                ar arVar = ar.this;
                                ar.aph();
                                ar arVar2 = ar.this;
                                ar.api();
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception e) {
                        ServiceProvider.reportSdkCaughtException(e);
                    }
                }
            }, i);
        }
    }

    private boolean a(com.kwad.sdk.core.config.d dVar) {
        int iApg = apg();
        if (iApg <= dVar.bAr) {
            return false;
        }
        com.kwad.sdk.core.d.c.d("PackageInstallHelper", "todayShow:" + iApg + " > showTimesPerDay:" + dVar.bAr);
        return true;
    }

    private static boolean y(Activity activity) {
        boolean zCanRequestPackageInstalls;
        if (Build.VERSION.SDK_INT >= 26) {
            zCanRequestPackageInstalls = activity.getPackageManager().canRequestPackageInstalls();
        } else {
            zCanRequestPackageInstalls = Settings.Secure.getInt(activity.getContentResolver(), "install_non_market_apps", 0) == 1;
        }
        return zCanRequestPackageInstalls;
    }

    private static int apg() {
        String strH = ag.h("ksadsdk_perf", "install_permission_times_per_day", "");
        if (TextUtils.isEmpty(strH)) {
            return 0;
        }
        String[] strArrSplit = strH.split(Config.replace);
        try {
            if (strArrSplit[0].equals(apk())) {
                return Integer.parseInt(strArrSplit[1]);
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aph() {
        try {
            String strH = ag.h("ksadsdk_perf", "install_permission_times_per_day", "");
            if (TextUtils.isEmpty(strH)) {
                ag.g("ksadsdk_perf", "install_permission_times_per_day", apk() + "_1");
                return;
            }
            String[] strArrSplit = strH.split(Config.replace);
            if (strArrSplit[0].equals(apk())) {
                ag.g("ksadsdk_perf", "install_permission_times_per_day", apk() + Config.replace + (Integer.parseInt(strArrSplit[1]) + 1));
            } else {
                ag.g("ksadsdk_perf", "install_permission_times_per_day", apk() + "_1");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void api() {
        try {
            ag.b("ksadsdk_perf", "install_permission_times", ag.c("ksadsdk_perf", "install_permission_times", 0) + 1);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("PackageInstallHelper", Log.getStackTraceString(e));
        }
    }

    private static int apj() {
        try {
            return ag.c("ksadsdk_perf", "install_permission_times", 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String apk() {
        return new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
    }
}
