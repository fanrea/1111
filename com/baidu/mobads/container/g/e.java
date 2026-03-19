package com.baidu.mobads.container.g;

import android.os.Handler;
import android.os.Message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e extends Handler {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String strC;
        int i;
        this.a.invalidate();
        if (this.a.m != null) {
            if (this.a.b != null) {
                strC = this.a.b.c();
            } else {
                strC = "";
            }
            if (message == null) {
                i = 0;
            } else {
                i = message.what;
            }
            this.a.m.a(i, strC);
        }
    }
}
