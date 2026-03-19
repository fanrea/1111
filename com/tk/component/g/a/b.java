package com.tk.component.g.a;

import android.view.View;
import com.tk.component.scroll.b.b.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements h.g {
    private List<com.tk.component.g.a.a.a> XK;
    private com.tk.component.g.a.a.b XL;

    public b(Map<Float, com.tk.component.g.a.a.b> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        if (arrayList.size() >= 2) {
            this.XK = new ArrayList();
            for (int i = 1; i < arrayList.size(); i++) {
                com.tk.component.g.a.a.a aVar = new com.tk.component.g.a.a.a();
                aVar.XM = ((Float) arrayList.get(i - 1)).floatValue();
                aVar.XN = ((Float) arrayList.get(i)).floatValue();
                aVar.XO = map.get(Float.valueOf(aVar.XM));
                aVar.XP = a(map.get(Float.valueOf(aVar.XN)), aVar.XO);
                this.XK.add(aVar);
            }
        }
    }

    private static com.tk.component.g.a.a.b a(com.tk.component.g.a.a.b bVar, com.tk.component.g.a.a.b bVar2) {
        com.tk.component.g.a.a.b bVar3 = new com.tk.component.g.a.a.b();
        bVar3.XQ = c.a(bVar.XQ, bVar2.XQ, 1.0f);
        bVar3.XR = c.a(bVar.XR, bVar2.XR, 1.0f);
        bVar3.XS = c.a(bVar.XS, bVar2.XS, 0.0f);
        bVar3.XT = c.a(bVar.XT, bVar2.XT, 0.0f);
        bVar3.XU = c.a(bVar.XU, bVar2.XU, 0.0f);
        bVar3.XV = c.a(bVar.XV, bVar2.XV, 0.0f);
        bVar3.XW = c.a(bVar.XW, bVar2.XW, 0.0f);
        bVar3.XX = c.a(bVar.XX, bVar2.XX, 0.0f);
        bVar3.XY = c.a(bVar.XY, bVar2.XY, 0.0f);
        bVar3.XZ = c.a(bVar.XZ, bVar2.XZ, 0.0f);
        bVar3.Ya = c.a(bVar.Ya, bVar2.Ya, 1.0f);
        return bVar3;
    }

    @Override // com.tk.component.scroll.b.b.h.g
    public final void c(View view, float f) {
        List<com.tk.component.g.a.a.a> list = this.XK;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.XK.size(); i++) {
            com.tk.component.g.a.a.a aVar = this.XK.get(i);
            if (aVar.t(f)) {
                if (this.XL == null) {
                    this.XL = new com.tk.component.g.a.a.b();
                }
                com.tk.component.g.a.a.b bVarA = aVar.a(this.XL, f);
                if (bVarA == null) {
                    return;
                }
                c.a(view, bVarA);
                return;
            }
        }
    }
}
