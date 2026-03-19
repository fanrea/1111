package com.baidu.mobads.container.x.a;

import com.baidu.mobads.container.util.cm;
import com.component.player.AdVideoViewListener;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements AdVideoViewListener.b {
    final /* synthetic */ a a;

    h(a aVar) {
        this.a = aVar;
    }

    @Override // com.component.player.AdVideoViewListener.b
    public void a() {
        HashMap<String, Object> map = new HashMap<>();
        try {
            map.put("rsplash_video_duration", Integer.valueOf(this.a.c.h()));
            this.a.mAdContainerCxt.s().dispatchEvent(new cm("onrsplashadtypeready", map));
        } catch (Exception e) {
            map.put("rsplash_video_duration", 0);
            map.put(cm.V, "视频准备失败");
            this.a.processAdError(map);
        }
        this.a.i();
    }
}
