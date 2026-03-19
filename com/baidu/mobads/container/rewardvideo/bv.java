package com.baidu.mobads.container.rewardvideo;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bv implements View.OnClickListener {
    final /* synthetic */ RemoteRewardActivity a;

    bv(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.O) {
            switch (this.a.as) {
                case 0:
                    if (!this.a.ae) {
                        this.a.a(4);
                        this.a.v();
                        break;
                    } else {
                        this.a.C();
                        break;
                    }
                case 1:
                    this.a.C();
                    break;
                case 2:
                    this.a.B();
                    break;
                default:
                    if (this.a.ae || !this.a.L) {
                        this.a.C();
                        break;
                    } else {
                        this.a.a(4);
                        this.a.v();
                        break;
                    }
                    break;
            }
        }
        this.a.B();
    }
}
