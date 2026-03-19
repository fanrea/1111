package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.pangle.u.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BroadcastReceiverProxy extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (hc.d().d(hashCode())) {
            hc.d().d(context, intent);
        } else {
            u.b(new Runnable() { // from class: com.bytedance.pangle.receiver.BroadcastReceiverProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    hc.d().d(context, intent);
                }
            });
        }
    }
}
