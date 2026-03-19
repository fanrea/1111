package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.os.Build;
import com.alipay.sdk.m.c0.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class a {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        d.a(context.getFilesDir().getAbsolutePath() + "/log/ap", new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log", b(context, str, str2, str3).toString());
    }

    public static synchronized void a(String str) {
        d.a(str);
    }

    public static synchronized void a(Throwable th) {
        d.a(th);
    }

    public static com.alipay.sdk.m.c0.a b(Context context, String str, String str2, String str3) {
        String packageName;
        try {
            packageName = context.getPackageName();
        } catch (Throwable unused) {
            packageName = "";
        }
        return new com.alipay.sdk.m.c0.a(Build.MODEL, packageName, "APPSecuritySDK-ALIPAYSDK", "3.4.0.202311031119", str, str2, str3);
    }
}
