package com.qq.e.comm.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class pf extends BroadcastReceiver {
    private static final String a = r1.d().a().getPackageName() + ".GDT_ACTION";

    /* compiled from: A */
    private static class a {
        private static final pf a = new pf();
    }

    private void a(String str) {
        pro.getVresult(377, 0, this, str);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        a(extras.getString("action"));
    }

    public static void a() {
        if (r1.d().f().a("lbme", 0) == 0) {
            return;
        }
        po.a(a.a, new IntentFilter(a));
    }
}
