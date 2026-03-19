package com.baidu.mobads.container.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        bq.a().a("APKInstallReceiver", "action Receiver :" + action + ", pkg:" + intent.getStringExtra("package"));
        if ((!"android.intent.action.PACKAGE_ADDED".equals(action) && !"android.intent.action.PACKAGE_REPLACED".equals(action) && !"android.intent.action.PACKAGE_REMOVED".equals(action)) || TextUtils.isEmpty(intent.getDataString())) {
            return;
        }
        bq.a().a("APKInstallReceiver", "updateStateByBroadCast:" + intent.getAction() + ", package:" + intent.getDataString());
        String strSubstring = intent.getDataString().substring(8);
        b.a().a(context, strSubstring, b.b);
        if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
            if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                com.baidu.mobads.container.o.d.a().a(context, strSubstring, 1, false, false, "", "", "");
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                com.baidu.mobads.container.o.d.a().a(context, strSubstring, 3, false, false, "", "", "");
            }
        }
    }
}
