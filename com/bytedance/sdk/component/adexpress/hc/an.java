package com.bytedance.sdk.component.adexpress.hc;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.hc.tc;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements tc {
    private uo b;
    private Context d;
    private d hc;

    @Override // com.bytedance.sdk.component.adexpress.hc.tc
    public void d() {
    }

    public an(Context context, uo uoVar, d dVar) {
        this.d = context;
        this.hc = dVar;
        this.b = uoVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc
    public boolean d(final tc.d dVar) {
        this.b.h().tt();
        this.hc.d(new h() { // from class: com.bytedance.sdk.component.adexpress.hc.an.1
            @Override // com.bytedance.sdk.component.adexpress.hc.h
            public void d(View view, k kVar) {
                if (dVar.b()) {
                    return;
                }
                e eVarHc = dVar.hc();
                if (eVarHc != null) {
                    eVarHc.d(an.this.hc, kVar);
                }
                dVar.d(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.hc.h
            public void d(int i, String str) {
                e eVarHc = dVar.hc();
                if (eVarHc != null) {
                    eVarHc.a_(i);
                }
            }
        });
        return true;
    }

    public void d(b bVar) {
        this.hc.d(bVar);
    }
}
