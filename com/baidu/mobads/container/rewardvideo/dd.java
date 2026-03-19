package com.baidu.mobads.container.rewardvideo;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class dd implements View.OnClickListener {
    final /* synthetic */ cw a;

    dd(cw cwVar) {
        this.a = cwVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (this.a.af) {
            case 0:
                double d = this.a.L;
                double d2 = this.a.f740K;
                Double.isNaN(d2);
                if (d >= d2 * 0.9d) {
                    this.a.n();
                    break;
                } else {
                    this.a.o = true;
                    this.a.v();
                    break;
                }
            case 1:
            case 2:
                this.a.n();
                break;
            default:
                double d3 = this.a.L;
                double d4 = this.a.f740K;
                Double.isNaN(d4);
                if (d3 >= d4 * 0.9d) {
                    this.a.n();
                    break;
                } else {
                    this.a.v();
                    break;
                }
        }
    }
}
