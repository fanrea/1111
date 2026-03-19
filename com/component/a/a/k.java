package com.component.a.a;

import android.os.Handler;
import android.os.Message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class k implements Handler.Callback {
    final /* synthetic */ f a;

    k(f fVar) {
        this.a = fVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    this.a.G();
                    return true;
                case 1:
                    if (message.obj instanceof com.component.lottie.t) {
                        if (message.obj != this.a.c()) {
                            this.a.a((com.component.lottie.t) message.obj);
                        }
                        this.a.G();
                        this.a.m = 1;
                        return true;
                    }
                    return false;
                case 2:
                    this.a.u();
                    return true;
                default:
                    return false;
            }
        } catch (Throwable th) {
            com.component.lottie.g.c.c("Error handling msg.", th);
            return false;
        }
    }
}
