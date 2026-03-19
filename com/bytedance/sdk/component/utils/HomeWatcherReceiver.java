package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {
    private d d;

    public interface d {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            mq.d("HomeReceiver", "onReceive: action: ".concat(String.valueOf(action)));
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra("reason");
                mq.d("HomeReceiver", "reason: ".concat(String.valueOf(stringExtra)));
                if ("homekey".equals(stringExtra)) {
                    mq.d("HomeReceiver", "homekey");
                } else if ("recentapps".equals(stringExtra)) {
                    mq.d("HomeReceiver", "long press home key or activity switch");
                } else if ("assist".equals(stringExtra)) {
                    mq.d("HomeReceiver", "assist");
                }
            }
        } catch (Throwable unused) {
            mq.c("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }
}
