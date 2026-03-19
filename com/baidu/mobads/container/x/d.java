package com.baidu.mobads.container.x;

import android.os.Handler;
import android.os.Message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d implements Handler.Callback {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 12) {
            this.a.a();
            return false;
        }
        return false;
    }
}
