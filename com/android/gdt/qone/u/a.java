package com.android.gdt.qone.u;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class a {
    public static void a(String str, String str2, Bundle bundle) {
        Context contextA = com.android.gdt.qone.ar.d.h().a();
        if (contextA == null) {
            return;
        }
        Intent intent = new Intent(str);
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        contextA.sendBroadcast(intent);
    }
}
