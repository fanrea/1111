package com.bytedance.d.hc.u.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class c {
    private int d;

    c(Context context) {
        try {
            d(context);
        } catch (Throwable unused) {
        }
    }

    private void d(Context context) {
        context.registerReceiver(new d(), new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    public int d() {
        return this.d;
    }

    private class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                    c.this.d = (int) ((intent.getIntExtra("level", 0) * 100.0f) / intent.getIntExtra("scale", 100));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
