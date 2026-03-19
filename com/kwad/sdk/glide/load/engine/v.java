package com.kwad.sdk.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class v {
    private boolean bUs;
    private final Handler handler = new Handler(Looper.getMainLooper(), new a());

    v() {
    }

    final synchronized void h(s<?> sVar) {
        if (this.bUs) {
            this.handler.obtainMessage(1, sVar).sendToTarget();
            return;
        }
        this.bUs = true;
        sVar.recycle();
        this.bUs = false;
    }

    static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((s) message.obj).recycle();
            return true;
        }
    }
}
