package com.baidu.mobads.container.x.a;

import com.component.player.AdVideoViewListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements AdVideoViewListener.a {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    @Override // com.component.player.AdVideoViewListener.a
    public void a() {
        try {
            if (this.a.c != null) {
                com.component.player.c cVar = this.a.c;
                cVar.getLayoutParams().width = 1;
                cVar.getLayoutParams().height = 1;
            }
            if (this.a.e != null) {
                this.a.e.setVisibility(8);
            }
            if (this.a.imageBaidu != null) {
                this.a.imageBaidu.setVisibility(8);
            }
            if (this.a.imageAd != null) {
                this.a.imageAd.setVisibility(8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
