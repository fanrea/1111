package com.qq.e.comm.plugin;

import android.provider.Settings;
import com.qq.e.comm.managers.setting.GlobalSetting;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class na {
    private static final String a = "na";

    /* compiled from: A */
    private static final class a {
        static final String a = na.d();
    }

    public static String b() {
        if (GlobalSetting.isAgreePrivacyStrategy() && c()) {
            return a.a;
        }
        return null;
    }

    public static boolean c() {
        return (r1.d().f().a("adidon", 1) == 1) && (GlobalSetting.isAgreeReadAndroidId() && !pa.b("android_id"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d() {
        try {
            return Settings.Secure.getString(r1.d().a().getContentResolver(), "android_id");
        } catch (Throwable th) {
            th.getMessage();
            return "";
        }
    }
}
