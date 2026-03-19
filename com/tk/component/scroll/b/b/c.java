package com.tk.component.scroll.b.b;

import android.view.View;
import com.tk.component.scroll.b.b.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c implements h.g {
    private final List<h.g> Wc = new ArrayList();

    public final void a(h.g gVar) {
        this.Wc.add(gVar);
    }

    public final void b(h.g gVar) {
        this.Wc.remove(gVar);
    }

    @Override // com.tk.component.scroll.b.b.h.g
    public final void c(View view, float f) {
        Iterator<h.g> it = this.Wc.iterator();
        while (it.hasNext()) {
            it.next().c(view, f);
        }
    }
}
