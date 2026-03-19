package com.apm.insight.runtime.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import com.apm.insight.runtime.q;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class d {
    private volatile int a;
    private volatile long b = -1;

    d(Context context) {
    }

    private int a(long j) {
        Context contextF = com.apm.insight.g.f();
        if (contextF == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            BatteryManager batteryManager = (BatteryManager) contextF.getSystemService("batterymanager");
            this.b = j;
            return batteryManager.getIntProperty(4);
        }
        Intent intentRegisterReceiver = contextF.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), null, q.b().a());
        if (intentRegisterReceiver != null) {
            int intExtra = intentRegisterReceiver.getIntExtra("level", 0);
            int intExtra2 = intentRegisterReceiver.getIntExtra("scale", 100);
            this.b = j;
            return (int) ((intExtra * 100.0f) / intExtra2);
        }
        return 0;
    }

    public int a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.b < 60000) {
            return this.a;
        }
        this.a = a(jCurrentTimeMillis);
        return this.a;
    }
}
