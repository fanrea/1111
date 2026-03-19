package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.Build;
import android.os.Vibrator;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class z30 {
    public static void a() {
        Vibrator vibrator;
        Context contextA = r1.d().a();
        if ((Build.VERSION.SDK_INT < 23 || contextA.checkSelfPermission("android.permission.VIBRATE") == 0) && (vibrator = (Vibrator) contextA.getSystemService("vibrator")) != null) {
            try {
                vibrator.vibrate(200L);
            } catch (Throwable unused) {
            }
        }
    }
}
