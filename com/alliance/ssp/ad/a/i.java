package com.alliance.ssp.ad.a;

import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.alliance.ssp.ad.video.VideoController;

/* compiled from: NMRewardVideoActivity.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class i implements VideoController.h {
    public i(NMRewardVideoActivity nMRewardVideoActivity) {
    }

    @Override // com.alliance.ssp.ad.video.VideoController.h
    public void a(boolean z) {
        com.alliance.ssp.ad.impl.reward.a aVar = NMRewardVideoActivity.v0;
        if (aVar != null) {
            if (z) {
                aVar.o("", "", aVar.h);
            } else {
                aVar.j("", "", aVar.h);
            }
        }
    }
}
