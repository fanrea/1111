package com.android.gdt.qone.e;

import android.os.Bundle;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class f extends a {
    public final /* synthetic */ g a;

    public f(g gVar) {
        this.a = gVar;
    }

    @Override // com.android.gdt.qone.e.b
    public final void a(Bundle bundle) {
        if (bundle == null) {
            com.android.gdt.qone.af.b.a("honor get oaid_limit_state,bundle is null");
        } else {
            boolean z = bundle.getBoolean("oa_id_limit_state");
            this.a.b.b = z;
            com.android.gdt.qone.af.b.b("honor got oaid_limit_state is " + z);
        }
        this.a.a.countDown();
    }
}
