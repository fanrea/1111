package com.baidu.mobads.container.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.mobads.container.activity.o;
import com.baidu.mobads.sdk.api.IActivityImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ay implements Runnable {
    final /* synthetic */ o.a a;
    final /* synthetic */ Context b;
    final /* synthetic */ l c;

    ay(l lVar, o.a aVar, Context context) {
        this.c = lVar;
        this.a = aVar;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Class<?> clsA = com.baidu.mobads.container.util.bo.a(com.baidu.mobads.container.util.ay.c);
            this.c.d = new com.baidu.mobads.container.activity.o(this.c.e, this.a);
            com.baidu.mobads.container.util.bo.a(clsA, "setActivityImp", new Class[]{IActivityImpl.class}, new Object[]{this.c.d});
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this.b, com.baidu.mobads.container.util.bo.a(com.baidu.mobads.container.util.ay.c));
        if (!(this.b instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.b.startActivity(intent);
    }
}
