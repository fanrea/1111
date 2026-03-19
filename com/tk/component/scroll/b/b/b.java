package com.tk.component.scroll.b.b;

import com.tk.component.scroll.b.b.h;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
final class b extends h.e {
    private final List<h.e> Wb = new ArrayList(3);

    b(int i) {
    }

    final void a(h.e eVar) {
        this.Wb.add(eVar);
    }

    @Override // com.tk.component.scroll.b.b.h.e
    public final void a(int i, float f, int i2) {
        try {
            Iterator<h.e> it = this.Wb.iterator();
            while (it.hasNext()) {
                it.next().a(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    @Override // com.tk.component.scroll.b.b.h.e
    public final void di(int i) {
        try {
            Iterator<h.e> it = this.Wb.iterator();
            while (it.hasNext()) {
                it.next().di(i);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    @Override // com.tk.component.scroll.b.b.h.e
    public final void dj(int i) {
        try {
            Iterator<h.e> it = this.Wb.iterator();
            while (it.hasNext()) {
                it.next().dj(i);
            }
        } catch (ConcurrentModificationException e) {
            a(e);
        }
    }

    private static void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
