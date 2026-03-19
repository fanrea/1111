package com.baidu.mobads.container.rewardvideo;

import java.math.BigDecimal;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class df implements Runnable {
    final /* synthetic */ cw a;

    df(cw cwVar) {
        this.a = cwVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.P != null) {
            double d = this.a.f740K - this.a.L;
            Double.isNaN(d);
            double dMax = Math.max(0.0d, d / 1000.0d);
            if (dMax > 0.0d || this.a.P.getVisibility() != 0) {
                if (this.a.P.getVisibility() == 0) {
                    ((com.baidu.mobads.container.util.bs) this.a.P).setText(String.format(Locale.getDefault(), "%ds后可领取奖励", Integer.valueOf((int) dMax)));
                }
            } else {
                this.a.P.setVisibility(4);
                this.a.p();
                dp.a(this.a.L / 1000, this.a.M / 1000, this.a.n, this.a.r);
            }
            if (this.a.L > 0) {
                this.a.q = (this.a.L * 1.0f) / this.a.f740K;
            }
            if (this.a.q > 0.9d) {
                this.a.c();
            }
            if (!this.a.A && this.a.L >= this.a.z * 1000) {
                this.a.k();
                this.a.t();
                this.a.A = true;
            }
            this.a.q = new BigDecimal(String.valueOf(this.a.q)).setScale(2, 4).floatValue();
            if (this.a.L + 100 <= this.a.f740K) {
                cw.a(this.a, 100);
                this.a.m.postDelayed(this.a.aj, 100L);
            }
        }
    }
}
