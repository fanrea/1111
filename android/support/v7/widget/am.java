package android.support.v7.widget;

import android.os.Bundle;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class am {
    private int sx = 0;
    private int sy = 0;
    private int sz = Integer.MIN_VALUE;
    private int bY = Integer.MIN_VALUE;
    private int sA = 0;
    private int sB = 0;
    private boolean sC = false;
    private boolean sD = false;

    am() {
    }

    public final int getLeft() {
        return this.sx;
    }

    public final int getRight() {
        return this.sy;
    }

    public final int getStart() {
        return this.sC ? this.sy : this.sx;
    }

    public final int getEnd() {
        return this.sC ? this.sx : this.sy;
    }

    public final void M(int i, int i2) {
        this.sz = i;
        this.bY = i2;
        this.sD = true;
        if (this.sC) {
            if (i2 != Integer.MIN_VALUE) {
                this.sx = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.sy = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.sx = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.sy = i2;
        }
    }

    public final void N(int i, int i2) {
        this.sD = false;
        if (i != Integer.MIN_VALUE) {
            this.sA = i;
            this.sx = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.sB = i2;
            this.sy = i2;
        }
    }

    public final void A(boolean z) {
        if (z == this.sC) {
            return;
        }
        this.sC = z;
        if (!this.sD) {
            this.sx = this.sA;
            this.sy = this.sB;
            return;
        }
        if (z) {
            int i = this.bY;
            if (i == Integer.MIN_VALUE) {
                i = this.sA;
            }
            this.sx = i;
            int i2 = this.sz;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.sB;
            }
            this.sy = i2;
            return;
        }
        int i3 = this.sz;
        if (i3 == Integer.MIN_VALUE) {
            i3 = this.sA;
        }
        this.sx = i3;
        int i4 = this.bY;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.sB;
        }
        this.sy = i4;
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    public static class a extends android.support.v4.e.b {
        final am vM;

        public a(am amVar) {
            this.vM = amVar;
        }

        @Override // android.support.v4.e.b
        public final void a(View view, android.support.v4.e.a.b bVar) {
            super.a(view, bVar);
            if (this.vM.ft() || this.vM.pD.getLayoutManager() == null) {
                return;
            }
            this.vM.pD.getLayoutManager().b(view, bVar);
        }

        @Override // android.support.v4.e.b
        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.vM.ft() || this.vM.pD.getLayoutManager() == null) {
                return false;
            }
            return this.vM.pD.getLayoutManager().a(view, i, bundle);
        }
    }
}
