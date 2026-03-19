package com.android.gdt.qone.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        c.b("shouldUpdateId, notifyFlag : " + intExtra);
        boolean zContains = true;
        if (intExtra != 1) {
            if (intExtra == 2) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                if (stringArrayListExtra == null) {
                    return;
                }
                zContains = stringArrayListExtra.contains(context.getPackageName());
                if (zContains) {
                    b bVarA = c.a().a(intent.getStringExtra("openIdType"));
                    if (bVarA != null) {
                        bVarA.b = 0L;
                        return;
                    }
                    return;
                }
            }
            if (intExtra == 0 && zContains) {
                b bVarA2 = c.a().a(intent.getStringExtra("openIdType"));
                if (bVarA2 != null) {
                    bVarA2.b = 0L;
                    return;
                }
                return;
            }
            if (!zContains) {
                return;
            }
        } else if (!TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
            return;
        }
        b bVarA3 = c.a().a(intent.getStringExtra("openIdType"));
        if (bVarA3 != null) {
            bVarA3.b = 0L;
        }
    }
}
