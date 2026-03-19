package com.baidu.mobads.container.x;

import android.os.Handler;
import android.os.Message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class o implements Handler.Callback {
    final /* synthetic */ k a;

    o(k kVar) {
        this.a = kVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 10) {
            this.a.k();
            return false;
        }
        return false;
    }
}
