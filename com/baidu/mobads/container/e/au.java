package com.baidu.mobads.container.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class au implements com.component.player.o {
    final /* synthetic */ l a;

    au(l lVar) {
        this.a = lVar;
    }

    @Override // com.component.player.o
    public void a(int i, float f) {
        try {
            if (this.a.y != null && this.a.b != null && this.a.I > 0) {
                double d = this.a.I - i;
                Double.isNaN(d);
                if (Math.max(0.0d, d / 1000.0d) > 0.0d || this.a.y.getVisibility() != 0) {
                    if (this.a.y.getVisibility() == 0 && this.a.z != null) {
                        this.a.z.a(this.a.I - i);
                    }
                } else {
                    this.a.y.setVisibility(8);
                }
                if (this.a.C != null && this.a.C.getVisibility() == 8 && i >= this.a.I && this.a.I != 0) {
                    com.baidu.mobads.container.util.h.a(new av(this));
                }
                if (this.a.E != null && this.a.E.getVisibility() == 8 && i >= this.a.I && this.a.I != 0) {
                    this.a.E.setVisibility(0);
                }
                if (i + 100 > this.a.I && this.a.y.getVisibility() == 0) {
                    this.a.y.setVisibility(8);
                }
            }
            if (this.a.aM != null && this.a.aM.i()) {
                this.a.aM.b(i);
            }
            if (this.a.aN != null && this.a.aN.i()) {
                this.a.aN.b(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
