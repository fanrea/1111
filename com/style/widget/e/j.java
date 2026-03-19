package com.style.widget.e;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j implements IOAdEventListener {
    final /* synthetic */ f a;

    j(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null && com.baidu.mobads.container.components.k.b.F.equals(iOAdEvent.getType())) {
            this.a.a(com.component.a.g.b.b.d);
        }
    }
}
