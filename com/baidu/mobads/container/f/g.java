package com.baidu.mobads.container.f;

import android.view.View;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.by;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements ab.b {
    final /* synthetic */ com.baidu.mobads.container.adrequest.j a;
    final /* synthetic */ View b;
    final /* synthetic */ int c;
    final /* synthetic */ b d;

    g(b bVar, com.baidu.mobads.container.adrequest.j jVar, View view, int i) {
        this.d = bVar;
        this.a = jVar;
        this.b = view;
        this.c = i;
    }

    @Override // com.baidu.mobads.container.util.ab.b
    public void a(boolean z) throws JSONException {
        if (z) {
            this.a.setActionOnlyWifi(com.baidu.mobads.container.util.e.a.i(this.d.mAppContext).booleanValue());
            this.d.a(this.b, this.a, this.c, false);
        }
        by.a.a(this.d.mAppContext).a(1046).a(this.d.mAdContainerCxt.z()).a(this.a).b(this.d.mAdContainerCxt.l()).a("msg", z ? "confirmed" : "cancel").a(com.baidu.mobads.container.components.command.j.F, z ? 0L : 1L).a("prod", "feed").a("dl_type", "ac_feed").a("confirmPolicy", this.d.mAdContainerCxt.w().optInt("appConfirmPolicy", 1)).f();
    }
}
