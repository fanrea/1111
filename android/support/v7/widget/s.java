package android.support.v7.widget;

import android.support.v7.widget.aj;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class s {
    final b nx;
    final a ny = new a();
    final List<View> nz = new ArrayList();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    interface b {
        void I(View view);

        void J(View view);

        void addView(View view, int i);

        void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        aj.x getChildViewHolder(View view);

        int indexOfChild(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    s(b bVar) {
        this.nx = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    void C(View view) {
        this.nz.add(view);
        this.nx.I(view);
    }

    private boolean D(View view) {
        if (!this.nz.remove(view)) {
            return false;
        }
        this.nx.J(view);
        return true;
    }

    final void a(View view, boolean z) {
        a(view, -1, true);
    }

    final void a(View view, int i, boolean z) {
        int iAd;
        if (i < 0) {
            iAd = this.nx.getChildCount();
        } else {
            iAd = ad(i);
        }
        this.ny.b(iAd, z);
        if (z) {
            C(view);
        }
        this.nx.addView(view, iAd);
    }

    private int ad(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.nx.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int iAh = i - (i2 - this.ny.ah(i2));
            if (iAh == 0) {
                while (this.ny.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iAh;
        }
        return -1;
    }

    final void removeView(View view) {
        int iIndexOfChild = this.nx.indexOfChild(view);
        if (iIndexOfChild < 0) {
            return;
        }
        if (this.ny.ag(iIndexOfChild)) {
            D(view);
        }
        this.nx.removeViewAt(iIndexOfChild);
    }

    final void removeViewAt(int i) {
        int iAd = ad(i);
        View childAt = this.nx.getChildAt(iAd);
        if (childAt == null) {
            return;
        }
        if (this.ny.ag(iAd)) {
            D(childAt);
        }
        this.nx.removeViewAt(iAd);
    }

    final View getChildAt(int i) {
        return this.nx.getChildAt(ad(i));
    }

    final void cU() {
        this.ny.reset();
        for (int size = this.nz.size() - 1; size >= 0; size--) {
            this.nx.J(this.nz.get(size));
            this.nz.remove(size);
        }
        this.nx.removeAllViews();
    }

    final View ae(int i) {
        int size = this.nz.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.nz.get(i2);
            aj.x childViewHolder = this.nx.getChildViewHolder(view);
            if (childViewHolder.getLayoutPosition() == i && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    final void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iAd;
        if (i < 0) {
            iAd = this.nx.getChildCount();
        } else {
            iAd = ad(i);
        }
        this.ny.b(iAd, z);
        if (z) {
            C(view);
        }
        this.nx.attachViewToParent(view, iAd, layoutParams);
    }

    final int getChildCount() {
        return this.nx.getChildCount() - this.nz.size();
    }

    final int cV() {
        return this.nx.getChildCount();
    }

    final View af(int i) {
        return this.nx.getChildAt(i);
    }

    final void detachViewFromParent(int i) {
        int iAd = ad(i);
        this.ny.ag(iAd);
        this.nx.detachViewFromParent(iAd);
    }

    final int indexOfChild(View view) {
        int iIndexOfChild = this.nx.indexOfChild(view);
        if (iIndexOfChild == -1 || this.ny.get(iIndexOfChild)) {
            return -1;
        }
        return iIndexOfChild - this.ny.ah(iIndexOfChild);
    }

    final boolean E(View view) {
        return this.nz.contains(view);
    }

    final void F(View view) {
        int iIndexOfChild = this.nx.indexOfChild(view);
        if (iIndexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.ny.set(iIndexOfChild);
        C(view);
    }

    final void G(View view) {
        int iIndexOfChild = this.nx.indexOfChild(view);
        if (iIndexOfChild < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.ny.get(iIndexOfChild)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.ny.clear(iIndexOfChild);
        D(view);
    }

    public final String toString() {
        return this.ny.toString() + ", hidden list:" + this.nz.size();
    }

    final boolean H(View view) {
        int iIndexOfChild = this.nx.indexOfChild(view);
        if (iIndexOfChild == -1) {
            D(view);
            return true;
        }
        if (!this.ny.get(iIndexOfChild)) {
            return false;
        }
        this.ny.ag(iIndexOfChild);
        D(view);
        this.nx.removeViewAt(iIndexOfChild);
        return true;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a {
        long nA = 0;
        a nB;

        a() {
        }

        final void set(int i) {
            if (i >= 64) {
                cW();
                this.nB.set(i - 64);
            } else {
                this.nA |= 1 << i;
            }
        }

        private void cW() {
            if (this.nB == null) {
                this.nB = new a();
            }
        }

        final void clear(int i) {
            if (i >= 64) {
                a aVar = this.nB;
                if (aVar != null) {
                    aVar.clear(i - 64);
                    return;
                }
                return;
            }
            this.nA &= (1 << i) ^ (-1);
        }

        final boolean get(int i) {
            a aVar = this;
            while (i >= 64) {
                aVar.cW();
                aVar = aVar.nB;
                i -= 64;
            }
            return (aVar.nA & (1 << i)) != 0;
        }

        final void reset() {
            a aVar = this;
            do {
                aVar.nA = 0L;
                aVar = aVar.nB;
            } while (aVar != null);
        }

        final void b(int i, boolean z) {
            boolean z2 = z;
            a aVar = this;
            while (i < 64) {
                boolean z3 = (aVar.nA & Long.MIN_VALUE) != 0;
                long j = (1 << i) - 1;
                long j2 = aVar.nA;
                aVar.nA = ((j2 & (j ^ (-1))) << 1) | (j2 & j);
                if (z2) {
                    aVar.set(i);
                } else {
                    aVar.clear(i);
                }
                if (!z3 && aVar.nB == null) {
                    return;
                }
                aVar.cW();
                aVar = aVar.nB;
                z2 = z3;
                i = 0;
            }
            aVar.cW();
            aVar.nB.b(i - 64, z2);
        }

        final boolean ag(int i) {
            a aVar = this;
            while (i >= 64) {
                aVar.cW();
                aVar = aVar.nB;
                i -= 64;
            }
            long j = 1 << i;
            boolean z = (aVar.nA & j) != 0;
            aVar.nA &= j ^ (-1);
            long j2 = j - 1;
            long j3 = aVar.nA;
            aVar.nA = Long.rotateRight(j3 & (j2 ^ (-1)), 1) | (j3 & j2);
            a aVar2 = aVar.nB;
            if (aVar2 != null) {
                if (aVar2.get(0)) {
                    aVar.set(63);
                }
                aVar.nB.ag(0);
            }
            return z;
        }

        final int ah(int i) {
            a aVar = this.nB;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.nA);
                }
                return Long.bitCount(this.nA & ((1 << i) - 1));
            }
            if (i < 64) {
                return Long.bitCount(this.nA & ((1 << i) - 1));
            }
            return aVar.ah(i - 64) + Long.bitCount(this.nA);
        }

        public final String toString() {
            if (this.nB == null) {
                return Long.toBinaryString(this.nA);
            }
            return this.nB.toString() + "xx" + Long.toBinaryString(this.nA);
        }
    }
}
