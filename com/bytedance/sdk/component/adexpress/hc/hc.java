package com.bytedance.sdk.component.adexpress.hc;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.hc.tc;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements tc {
    private int an;
    private ThemeStatusBroadcastReceiver b;
    private gb c;
    private Context d;
    private com.bytedance.sdk.component.adexpress.dynamic.d.d hc;
    private uo u;

    public hc(Context context, uo uoVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.c.gb gbVar, gb gbVar2, com.bytedance.sdk.component.adexpress.dynamic.u.d dVar) {
        this(context, uoVar, themeStatusBroadcastReceiver, z, gbVar, gbVar2, dVar, null);
    }

    public hc(Context context, uo uoVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.c.gb gbVar, gb gbVar2, com.bytedance.sdk.component.adexpress.dynamic.u.d dVar, com.bytedance.sdk.component.adexpress.dynamic.d.d dVar2) {
        this.d = context;
        this.u = uoVar;
        this.b = themeStatusBroadcastReceiver;
        this.c = gbVar2;
        if (dVar2 != null) {
            this.hc = dVar2;
        } else {
            this.hc = new com.bytedance.sdk.component.adexpress.dynamic.d.d(this.d, this.b, z, gbVar, this.u, dVar);
        }
        this.hc.d(this.c);
        if (gbVar instanceof com.bytedance.sdk.component.adexpress.dynamic.c.h) {
            this.an = 3;
        } else {
            this.an = 2;
        }
    }

    public void d(boolean z) {
        this.hc.hc(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc
    public boolean d(final tc.d dVar) {
        this.u.h().d(this.an);
        this.hc.d(new h() { // from class: com.bytedance.sdk.component.adexpress.hc.hc.1
            @Override // com.bytedance.sdk.component.adexpress.hc.h
            public void d(View view, k kVar) {
                if (dVar.b()) {
                    return;
                }
                hc.this.u.h().u(hc.this.an);
                hc.this.u.h().an(hc.this.an);
                hc.this.u.h().uo();
                e eVarHc = dVar.hc();
                if (eVarHc == null) {
                    return;
                }
                eVarHc.d(hc.this.hc, kVar);
                dVar.d(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.hc.h
            public void d(int i, String str) {
                hc.this.u.h().d(hc.this.an, i, str, dVar.hc(hc.this));
                if (dVar.hc(hc.this)) {
                    dVar.d(hc.this);
                    return;
                }
                e eVarHc = dVar.hc();
                if (eVarHc == null) {
                    return;
                }
                eVarHc.a_(i);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.tc
    public void d() {
        com.bytedance.sdk.component.adexpress.dynamic.d.d dVar = this.hc;
        if (dVar != null) {
            dVar.hc();
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.c hc() {
        com.bytedance.sdk.component.adexpress.dynamic.d.d dVar = this.hc;
        if (dVar != null) {
            return dVar.an();
        }
        return null;
    }
}
