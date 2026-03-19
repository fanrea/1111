package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class wo implements la {
    private String a = "";

    wo() {
    }

    @Override // com.qq.e.comm.plugin.la
    public String b(Context context) {
        if (TextUtils.isEmpty(this.a)) {
            String strA = a(context);
            if (!TextUtils.isEmpty(strA)) {
                this.a = gp.a(strA.toLowerCase());
            }
        }
        return this.a;
    }
}
