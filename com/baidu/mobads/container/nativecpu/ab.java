package com.baidu.mobads.container.nativecpu;

import android.widget.RelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ab implements Runnable {
    final /* synthetic */ t a;

    ab(t tVar) {
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.a.m != null) {
                if (this.a.d.booleanValue()) {
                    com.component.a.i.s.a(this.a.m, 1);
                } else {
                    com.component.a.i.s.a(this.a.m, 0);
                }
            }
            if (this.a.n != null) {
                if (this.a.d.booleanValue()) {
                    com.component.a.i.s.a(this.a.n, 1);
                } else {
                    com.component.a.i.s.a(this.a.n, 0);
                }
            }
            if (this.a.e != null) {
                RelativeLayout relativeLayout = (RelativeLayout) this.a.e.findViewById(1);
                if (relativeLayout != null) {
                    relativeLayout.setBackgroundColor(218103808);
                }
                this.a.g();
            }
            if (this.a.b != null) {
                this.a.f();
                this.a.d();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
