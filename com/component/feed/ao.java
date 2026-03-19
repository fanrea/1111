package com.component.feed;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ao implements IOAdEventListener {
    final /* synthetic */ an a;

    ao(an anVar) {
        this.a = anVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null && "native_shake".equals(iOAdEvent.getType())) {
            String message = iOAdEvent.getMessage();
            if ("resume".equals(message)) {
                this.a.e();
            } else if ("pause".equals(message)) {
                this.a.d();
            } else if ("destroy".equals(message)) {
                this.a.f();
            }
        }
    }
}
