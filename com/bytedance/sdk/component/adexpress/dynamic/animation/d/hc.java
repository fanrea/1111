package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u {
    List<c> d = new ArrayList();

    public hc(View view, List<com.bytedance.sdk.component.adexpress.dynamic.b.d> list) {
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.b.d> it = list.iterator();
        while (it.hasNext()) {
            c cVarD = b.d().d(view, it.next());
            if (cVarD != null) {
                this.d.add(cVarD);
            }
        }
    }

    public void d() {
        Iterator<c> it = this.d.iterator();
        while (it.hasNext()) {
            try {
                it.next().b();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public void hc() {
        Iterator<c> it = this.d.iterator();
        while (it.hasNext()) {
            try {
                it.next().hc();
            } catch (Exception unused) {
            }
        }
    }
}
