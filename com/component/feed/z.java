package com.component.feed;

import android.os.Handler;
import android.os.Message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class z implements Handler.Callback {
    final /* synthetic */ m a;

    z(m mVar) {
        this.a = mVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message != null && message.what == 23 && this.a.r != null && this.a.aw != null && this.a.au != null) {
            this.a.au.postDelayed(new aa(this, this.a.O()), 510L);
        }
        if (this.a.au != null) {
            this.a.au.sendEmptyMessageDelayed(23, 800L);
            return false;
        }
        return false;
    }
}
