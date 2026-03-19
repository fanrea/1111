package com.baidu.mobads.container.nativecpu;

import android.view.View;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ t b;

    ag(t tVar, a aVar) {
        this.b = tVar;
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.handleClick(view, false);
        HashMap<String, Object> map = new HashMap<>();
        map.put("isStartRewardAdTimer", true);
        if (this.b.h != null) {
            this.b.h.a(map);
        }
    }
}
