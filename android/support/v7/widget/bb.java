package android.support.v7.widget;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class bb {
    final b wF;
    a wG = new a();

    interface b {
        int S(View view);

        int T(View view);

        int dP();

        int dQ();

        View getChildAt(int i);
    }

    /* renamed from: android.support.v7.widget.bb$1, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            bb.this.H(false);
        }
    }

    /* renamed from: android.support.v7.widget.bb$2, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            bb.this.hide();
        }
    }

    bb(b bVar) {
        this.wF = bVar;
    }

    static class a {
        int wH = 0;
        int wI;
        int wJ;
        int wK;
        int wL;

        private static int compare(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        a() {
        }

        final void setBounds(int i, int i2, int i3, int i4) {
            this.wI = i;
            this.wJ = i2;
            this.wK = i3;
            this.wL = i4;
        }

        final void addFlags(int i) {
            this.wH = i | this.wH;
        }

        final void fF() {
            this.wH = 0;
        }

        final boolean fG() {
            int i = this.wH;
            if ((i & 7) != 0 && (i & (compare(this.wK, this.wI) << 0)) == 0) {
                return false;
            }
            int i2 = this.wH;
            if ((i2 & 112) != 0 && (i2 & (compare(this.wK, this.wJ) << 4)) == 0) {
                return false;
            }
            int i3 = this.wH;
            if ((i3 & 1792) != 0 && (i3 & (compare(this.wL, this.wI) << 8)) == 0) {
                return false;
            }
            int i4 = this.wH;
            return (i4 & 28672) == 0 || (i4 & (compare(this.wL, this.wJ) << 12)) != 0;
        }
    }

    final View e(int i, int i2, int i3, int i4) {
        int iDP = this.wF.dP();
        int iDQ = this.wF.dQ();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = this.wF.getChildAt(i);
            this.wG.setBounds(iDP, iDQ, this.wF.S(childAt), this.wF.T(childAt));
            if (i3 != 0) {
                this.wG.fF();
                this.wG.addFlags(i3);
                if (this.wG.fG()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                this.wG.fF();
                this.wG.addFlags(i4);
                if (this.wG.fG()) {
                    view = childAt;
                }
            }
            i += i5;
        }
        return view;
    }

    final boolean j(View view, int i) {
        this.wG.setBounds(this.wF.dP(), this.wF.dQ(), this.wF.S(view), this.wF.T(view));
        this.wG.fF();
        this.wG.addFlags(24579);
        return this.wG.fG();
    }
}
