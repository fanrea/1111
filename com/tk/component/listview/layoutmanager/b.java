package com.tk.component.listview.layoutmanager;

import android.content.Context;
import android.support.v7.widget.ad;
import android.support.v7.widget.al;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    private int Tx;
    private boolean Ty;
    private int uW = -1;

    public final void bC(int i) {
        this.Tx = i;
    }

    public final void setDuration(int i) {
        this.uW = i;
    }

    public final void gO() {
        this.Ty = true;
    }

    public final a f(al alVar, int i) {
        a aVar = new a(alVar.getContext());
        aVar.bC(this.Tx);
        aVar.ad(this.Ty);
        aVar.setDuration(this.uW);
        this.Tx = 0;
        this.Ty = false;
        this.uW = -1;
        aVar.aR(i);
        return aVar;
    }

    public static class a extends ad {
        private int Tx;
        private boolean Ty;
        private int uW;

        public a(Context context) {
            super(context);
        }

        public final int dG() {
            return this.Ty ? 10000 : -1;
        }

        public final int dF() {
            return this.Ty ? 10000 : -1;
        }

        public final void bC(int i) {
            this.Tx = i;
        }

        public final void ad(boolean z) {
            this.Ty = z;
        }

        public final void setDuration(int i) {
            this.uW = i;
        }

        public final int c(int i, int i2, int i3, int i4, int i5) {
            if (i5 == 10000) {
                return ((i3 + ((i4 - i3) / 2)) - (i + ((i2 - i) / 2))) + this.Tx;
            }
            return super.c(i, i2, i3, i4, i5) + this.Tx;
        }

        public final int au(int i) {
            int i2 = this.uW;
            return i2 > 0 ? i2 : super.au(i);
        }
    }
}
