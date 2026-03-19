package com.baidu.mobads.container.bridge;

import android.content.Context;
import com.baidu.mobads.container.util.bk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class o extends com.baidu.mobads.container.d.a {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;

    o(i iVar, Context context, String str) {
        this.c = iVar;
        this.a = context;
        this.b = str;
    }

    @Override // com.baidu.mobads.container.d.a
    public Object a() {
        try {
            this.c.b(this.b, bk.d(this.a).toString());
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
