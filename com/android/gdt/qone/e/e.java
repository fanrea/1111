package com.android.gdt.qone.e;

import android.os.Bundle;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class e extends a {
    public final /* synthetic */ g a;

    public e(g gVar) {
        this.a = gVar;
    }

    @Override // com.android.gdt.qone.e.b
    public final void a(Bundle bundle) {
        if (bundle == null) {
            com.android.gdt.qone.af.b.a("honor get oaid,bundle is null");
        } else {
            String string = bundle.getString("oa_id_flag");
            this.a.b.a = string;
            com.android.gdt.qone.af.b.b("honor got oaid is " + string);
        }
        this.a.a.countDown();
    }
}
