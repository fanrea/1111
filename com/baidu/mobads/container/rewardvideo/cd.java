package com.baidu.mobads.container.rewardvideo;

import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class cd implements Runnable {
    final /* synthetic */ RemoteRewardActivity a;

    cd(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        int iRound;
        if (this.a.u != null && this.a.B != null) {
            int iG = this.a.u.g();
            if (this.a.E > 0 && iG <= this.a.E && iG >= 0) {
                double d = this.a.E - iG;
                Double.isNaN(d);
                iRound = (int) Math.round(d / 1000.0d);
            } else {
                iRound = 0;
            }
            int iMin = Math.min(iG, this.a.E);
            if (this.a.B instanceof com.baidu.mobads.container.components.a) {
                ((com.baidu.mobads.container.components.a) this.a.B).a(this.a.E, iMin);
                ((com.baidu.mobads.container.components.a) this.a.B).setText(String.valueOf(iRound));
            } else if (this.a.B instanceof com.baidu.mobads.container.util.bs) {
                double dMin = Math.min(30000, this.a.E) - iMin;
                Double.isNaN(dMin);
                int iMax = Math.max(0, (int) Math.round(dMin / 1000.0d));
                if (iMax > 0 || this.a.B.getVisibility() != 0) {
                    if (this.a.B.getVisibility() == 0) {
                        ((com.baidu.mobads.container.util.bs) this.a.B).setText(String.format(Locale.getDefault(), "%ds后可领取奖励", Integer.valueOf(iMax)));
                    }
                } else {
                    this.a.B.setVisibility(8);
                }
            }
            if (iMin < this.a.E) {
                this.a.C.postDelayed(this.a.aw, 100L);
            }
            if (this.a.E > 0) {
                this.a.N = (iMin * 1.0f) / this.a.E;
            }
            if (this.a.E >= 30000 && iMin >= 27000 && iMin <= 30000) {
                this.a.rewardVerify();
            } else if (this.a.N > 0.9d && this.a.N < 0.95d) {
                this.a.rewardVerify();
            }
            if (!this.a.ad && this.a.x() && iMin >= this.a.ab * 1000) {
                this.a.a("跳过");
                if (this.a.af) {
                    this.a.M();
                } else {
                    this.a.N();
                }
                this.a.ad = true;
            }
            float fA = com.baidu.mobads.container.util.ab.a(this.a.N);
            if (fA >= 0.0f) {
                this.a.N = fA;
            }
        }
    }
}
