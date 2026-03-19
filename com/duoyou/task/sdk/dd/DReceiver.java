package com.duoyou.task.sdk.dd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.duoyou.task.pro.c.a;
import com.duoyou.task.pro.c.b;
import com.duoyou.task.pro.c.c;
import com.duoyou.task.pro.g.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            Log.i("json", "download status = " + action);
            if ("com.duoyou.action.NOTIFICATION_CLICK".equals(action)) {
                String stringExtra = intent.getStringExtra("downloadUrl");
                String stringExtra2 = intent.getStringExtra("packageName");
                int intExtra = intent.getIntExtra("downloadStatus", 0);
                Log.i("json", "download downloadUrl = " + stringExtra);
                Log.i("json", "download downloadStatus = " + intExtra);
                b bVarA = b.a(stringExtra, stringExtra2);
                if (intExtra != 2) {
                    if (intExtra == 3 || intExtra == 4) {
                        a.a().a(context, bVarA, (c) null);
                        return;
                    }
                    return;
                }
                if (com.duoyou.task.pro.g.b.f(context, stringExtra2)) {
                    m.b(context, "应用已经安装成功");
                    return;
                }
                String strA = a.a().a(context, bVarA);
                if (com.duoyou.task.pro.g.b.e(context, strA)) {
                    com.duoyou.task.pro.g.b.a(context, strA, stringExtra2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
