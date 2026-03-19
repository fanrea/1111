package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.zv;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class kr implements zv.e {
    private static final String a = new jn(r1.d().f().b("snuidl", "")).a().optString("task_id");

    @Override // com.qq.e.comm.plugin.zv.e
    public boolean a(h4 h4Var, String str) {
        String str2 = a;
        return (TextUtils.isEmpty(str2) || !str2.equals(str) || h4Var.o1()) ? false : true;
    }
}
