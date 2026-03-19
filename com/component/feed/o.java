package com.component.feed;

import android.view.View;
import com.baidu.mobads.container.util.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class o implements View.OnClickListener {
    final /* synthetic */ m a;

    o(m mVar) {
        this.a = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.a.ay || !(this.a.r instanceof com.baidu.mobads.container.nativecpu.a)) {
            if (this.a.ah) {
                bq.a().a(m.a, "onClick: 播放中 ---》 暂停");
                this.a.d(m.aa);
                return;
            }
            if (this.a.T) {
                this.a.ag.setVisibility(8);
                com.component.b.a.a().a(this.a.ag, "ic_video_play");
                this.a.an.setVisibility(8);
                bq.a().a(m.a, "onClick: 重播");
                this.a.u();
                k.a().a(this.a, m.ae);
                this.a.T = false;
                return;
            }
            bq.a().a(m.a, "onClick: 用户播放/续播");
            k.a().a(this.a, m.af);
            return;
        }
        ((com.baidu.mobads.container.nativecpu.a) this.a.r).handleClick(view);
    }
}
