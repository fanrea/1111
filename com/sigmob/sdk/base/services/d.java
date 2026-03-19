package com.sigmob.sdk.base.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.sigmob.sdk.base.common.t;
import com.sigmob.sdk.base.services.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d implements f.a {
    c a;
    g b = g.STOP;

    public d() {
        if (this.a == null) {
            this.a = new c();
        }
    }

    public void a(Context context) {
        t.a(context, (BroadcastReceiver) this.a, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), true);
    }

    public void b(Context context) {
        context.unregisterReceiver(this.a);
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public boolean e() {
        a(com.sigmob.sdk.b.e());
        this.b = g.RUNNING;
        return false;
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public g f() {
        return null;
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public void g() {
        b(com.sigmob.sdk.b.e());
        this.b = g.STOP;
    }

    @Override // com.sigmob.sdk.base.services.f.a
    public Error h() {
        return null;
    }
}
