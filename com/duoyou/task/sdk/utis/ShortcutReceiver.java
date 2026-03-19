package com.duoyou.task.sdk.utis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ShortcutReceiver extends BroadcastReceiver {
    public static boolean a = false;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.duoyou.action.SHORTCUT_RECEIVER".equals(intent.getAction())) {
            a = true;
        }
        Log.i("json", "ShortcutReceiver = ");
    }
}
