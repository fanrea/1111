package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
class dc implements ViewTreeObserver.OnWindowFocusChangeListener {
    final /* synthetic */ RelativeLayout a;
    final /* synthetic */ cy b;

    dc(cy cyVar, RelativeLayout relativeLayout) {
        this.b = cyVar;
        this.a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        if (z) {
            HashMap<String, Object> map = new HashMap<>();
            map.put(com.baidu.mobads.container.n.f.Q, (Activity) this.b.i);
            map.put(com.baidu.mobads.container.n.f.S, this.a);
            map.put("entry", Integer.valueOf(this.b.G));
            map.put("channelId", Integer.valueOf(this.b.H));
            map.put("novel_id", this.b.I);
            map.put(com.baidu.mobads.container.n.f.U, Boolean.valueOf(this.b.x()));
            this.b.a("request_bookstore_bottom_view", map);
        }
    }
}
