package com.baidu.mobads.container.landingpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ae extends BroadcastReceiver {
    public static final String a = "lp_close";
    public static final String b = "lp_cpu";
    private ad c;

    public ae(ad adVar) {
        this.c = adVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if ("lp_close".equals(action)) {
            if (this.c != null) {
                this.c.c();
            }
        } else if (b.equals(action) && this.c != null) {
            this.c.a(intent);
        }
    }
}
