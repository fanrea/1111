package com.component.feed;

import com.baidu.mobads.container.util.ce;
import com.component.player.AdVideoViewListener;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b implements AdVideoViewListener.b {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    @Override // com.component.player.AdVideoViewListener.b
    public void a() {
        try {
            List<String> thirdTrackers = this.a.r.getThirdTrackers("vreadyplay");
            int i = this.a.r.isAutoPlay() ? 0 : 1;
            double dG = this.a.x.g();
            Double.isNaN(dG);
            ce.a(dG / 1000.0d, this.a.f757K, thirdTrackers, i, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
