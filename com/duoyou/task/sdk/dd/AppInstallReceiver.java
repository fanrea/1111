package com.duoyou.task.sdk.dd;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.duoyou.task.pro.c.a;
import com.duoyou.task.pro.g.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AppInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Log.i("json", "getAction = " + intent.getAction());
            if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                String strReplace = (intent.getDataString() + "").replace("package:", "");
                a.a().a(context, strReplace);
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                int iIntValue = ((Integer) a.a().b().get(strReplace)).intValue();
                a.a().b().remove(Integer.valueOf(iIntValue));
                notificationManager.cancel(iIntValue);
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()) && h.i().E != null) {
                h.i().E.onAppUninstalled((intent.getDataString() + "").replace("package:", ""));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
