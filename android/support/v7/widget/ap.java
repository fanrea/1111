package android.support.v7.widget;

import android.support.v7.widget.aj;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class ap extends aj.f {
    boolean uf = true;

    public abstract boolean a(aj.x xVar);

    public abstract boolean a(aj.x xVar, int i, int i2, int i3, int i4);

    public abstract boolean a(aj.x xVar, aj.x xVar2, int i, int i2, int i3, int i4);

    public abstract boolean c(aj.x xVar);

    @Override // android.support.v7.widget.aj.f
    public final boolean canReuseUpdatedViewHolder(aj.x xVar) {
        return !this.uf || xVar.isInvalid();
    }

    @Override // android.support.v7.widget.aj.f
    public final boolean d(aj.x xVar, aj.f.b bVar, aj.f.b bVar2) {
        int i = bVar.left;
        int i2 = bVar.top;
        View view = xVar.itemView;
        int left = bVar2 == null ? view.getLeft() : bVar2.left;
        int top = bVar2 == null ? view.getTop() : bVar2.top;
        if (!xVar.isRemoved() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return a(xVar, i, i2, left, top);
        }
        return a(xVar);
    }

    @Override // android.support.v7.widget.aj.f
    public final boolean e(aj.x xVar, aj.f.b bVar, aj.f.b bVar2) {
        if (bVar != null && (bVar.left != bVar2.left || bVar.top != bVar2.top)) {
            return a(xVar, bVar.left, bVar.top, bVar2.left, bVar2.top);
        }
        return c(xVar);
    }

    @Override // android.support.v7.widget.aj.f
    public final boolean f(aj.x xVar, aj.f.b bVar, aj.f.b bVar2) {
        if (bVar.left != bVar2.left || bVar.top != bVar2.top) {
            return a(xVar, bVar.left, bVar.top, bVar2.left, bVar2.top);
        }
        w(xVar);
        return false;
    }

    @Override // android.support.v7.widget.aj.f
    public final boolean a(aj.x xVar, aj.x xVar2, aj.f.b bVar, aj.f.b bVar2) {
        int i;
        int i2;
        int i3 = bVar.left;
        int i4 = bVar.top;
        if (xVar2.shouldIgnore()) {
            int i5 = bVar.left;
            i2 = bVar.top;
            i = i5;
        } else {
            i = bVar2.left;
            i2 = bVar2.top;
        }
        return a(xVar, xVar2, i3, i4, i, i2);
    }

    public final void v(aj.x xVar) {
        k(xVar);
    }

    public final void w(aj.x xVar) {
        k(xVar);
    }

    public final void x(aj.x xVar) {
        k(xVar);
    }

    public final void b(aj.x xVar, boolean z) {
        k(xVar);
    }
}
