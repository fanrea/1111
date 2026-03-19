package com.bytedance.msdk.gb;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.c.a;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class vv {
    private static final CharSequence b = "sony";
    private static final CharSequence c = "amigo";
    private static final CharSequence u = "funtouch";
    private static final ExecutorService an = com.bytedance.msdk.d.u.an.d("romutils", 2, new RejectedExecutionHandler() { // from class: com.bytedance.msdk.gb.vv.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });
    public static boolean d = false;
    public static boolean hc = false;

    public static String d() {
        if (e()) {
            return cb();
        }
        if (u()) {
            return mq();
        }
        if (hc()) {
            return w();
        }
        if (yo()) {
            return rf();
        }
        String strUo = uo();
        if (!TextUtils.isEmpty(strUo)) {
            return strUo;
        }
        if (h()) {
            return an();
        }
        if (gb()) {
            return tt();
        }
        if (c()) {
            return b();
        }
        String strTc = tc();
        return !TextUtils.isEmpty(strTc) ? strTc : Build.DISPLAY;
    }

    public static boolean hc() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String b() {
        return b("ro.build.uiversion") + Config.replace + Build.DISPLAY;
    }

    public static boolean c() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean u() {
        if (!hc) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    d = true;
                    hc = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            hc = true;
        }
        return d;
    }

    public static String an() {
        return b("ro.vivo.os.build.display.id") + Config.replace + b("ro.vivo.product.version");
    }

    public static boolean h() {
        String strB = b("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strB) && strB.toLowerCase().contains(u);
    }

    public static boolean gb() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(c);
    }

    public static String tt() {
        return Build.DISPLAY + Config.replace + b("ro.gn.sv.version");
    }

    public static String tc() {
        return mk() ? "eui_" + b("ro.letv.release.version") + Config.replace + Build.DISPLAY : "";
    }

    public static boolean mk() {
        return !TextUtils.isEmpty(b("ro.letv.release.version"));
    }

    public static String mq() {
        return u() ? "miui_" + b("ro.miui.ui.version.name") + Config.replace + Build.VERSION.INCREMENTAL : "";
    }

    public static String uo() {
        String strK = k();
        return (strK == null || !strK.toLowerCase().contains("emotionui")) ? "" : strK + Config.replace + Build.DISPLAY;
    }

    public static String k() {
        return b(a.a);
    }

    public static boolean e() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String cb() {
        if (e()) {
            try {
                return "smartisan_".concat(String.valueOf(b("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String w() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean yo() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static String rf() {
        return yo() ? "coloros_" + b("ro.build.version.opporom") + Config.replace + Build.DISPLAY : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hc(String str) {
        com.bytedance.sdk.component.c.u uVar = (com.bytedance.sdk.component.c.u) AutoService.d(com.bytedance.sdk.component.c.u.class);
        return uVar != null ? uVar.d(str) : "";
    }

    private static String b(String str) {
        String strJh;
        try {
            strJh = jh();
            try {
                if (TextUtils.isEmpty(strJh)) {
                    FutureTask futureTask = new FutureTask(new d(str));
                    an.execute(futureTask);
                    strJh = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strJh = "";
        }
        return strJh == null ? "" : strJh;
    }

    public static class d implements Callable<String> {
        private final String d;

        public d(String str) {
            this.d = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strHc = vv.hc(this.d);
            com.bytedance.msdk.d.u.b.d("RomUtils", "property:" + strHc + ",getSystemProperty use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (!TextUtils.isEmpty(strHc)) {
                try {
                    com.bytedance.msdk.d.u.b.b("RomUtils", "SP-getPropertyFromSP:".concat(String.valueOf(strHc)));
                    zw.d("rom_info", com.bytedance.msdk.core.hc.getContext()).d("rom_property_info", strHc);
                } catch (Throwable unused) {
                }
            }
            return strHc;
        }
    }

    private static String jh() {
        try {
            String strHc = zw.d("rom_info", com.bytedance.msdk.core.hc.getContext()).hc("rom_property_info", "");
            com.bytedance.msdk.d.u.b.hc("RomUtils", "get Property From SP...=".concat(String.valueOf(strHc)));
            return strHc;
        } catch (Throwable unused) {
            return "";
        }
    }
}
