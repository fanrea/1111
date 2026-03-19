package com.bytedance.sdk.component.widget.recycler;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class uo {
    final hc d;
    d hc = new d();

    interface hc {
        int d();

        int d(View view);

        View d(int i);

        int hc();

        int hc(View view);
    }

    uo(hc hcVar) {
        this.d = hcVar;
    }

    View d(int i, int i2, int i3, int i4) {
        int iD = this.d.d();
        int iHc = this.d.hc();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewD = this.d.d(i);
            this.hc.d(iD, iHc, this.d.d(viewD), this.d.hc(viewD));
            if (i3 != 0) {
                this.hc.d();
                this.hc.d(i3);
                if (this.hc.hc()) {
                    return viewD;
                }
            }
            if (i4 != 0) {
                this.hc.d();
                this.hc.d(i4);
                if (this.hc.hc()) {
                    view = viewD;
                }
            }
            i += i5;
        }
        return view;
    }

    static class d {
        int b;
        int c;
        int d = 0;
        int hc;
        int u;

        int d(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        d() {
        }

        void d(int i, int i2, int i3, int i4) {
            this.hc = i;
            this.b = i2;
            this.c = i3;
            this.u = i4;
        }

        void d(int i) {
            this.d = i | this.d;
        }

        void d() {
            this.d = 0;
        }

        boolean hc() {
            int i = this.d;
            if ((i & 7) != 0 && (i & (d(this.c, this.hc) << 0)) == 0) {
                return false;
            }
            int i2 = this.d;
            if ((i2 & 112) != 0 && (i2 & (d(this.c, this.b) << 4)) == 0) {
                return false;
            }
            int i3 = this.d;
            if ((i3 & 1792) != 0 && (i3 & (d(this.u, this.hc) << 8)) == 0) {
                return false;
            }
            int i4 = this.d;
            return (i4 & 28672) == 0 || (i4 & (d(this.u, this.b) << 12)) != 0;
        }
    }
}
