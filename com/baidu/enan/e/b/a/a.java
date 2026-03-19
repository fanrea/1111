package com.baidu.enan.e.b.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a(Context context) {
        try {
            String stringExtra = c(context).getStringExtra("technology");
            return TextUtils.isEmpty(stringExtra) ? "unknown" : stringExtra;
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            try {
                return Math.round(((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getAveragePower", String.class).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), "battery.capacity")).doubleValue()) + "mAh";
            } catch (Throwable th) {
                com.baidu.enan.f.b.a(th);
                return null;
            }
        } catch (Throwable th2) {
            com.baidu.enan.f.b.a(th2);
            return null;
        }
    }

    private static Intent c(Context context) {
        try {
            return context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return null;
        }
    }
}
