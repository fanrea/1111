package com.baidu.mobads.container.landingpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class al extends BroadcastReceiver {
    private a a;

    public interface a {
        void a();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction()) && intent.getIntExtra("wifi_state", -1) == 1 && this.a != null) {
            this.a.a();
        }
    }

    public void a(a aVar) {
        this.a = aVar;
    }
}
