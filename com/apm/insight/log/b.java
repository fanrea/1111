package com.apm.insight.log;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.apm.insight.log.a;
import com.apm.insight.log.a.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
final class b extends Handler {
    b(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            f.b();
        } else {
            if (message.obj == null || !(message.obj instanceof a.C0110a)) {
                return;
            }
            a.a((a.C0110a) message.obj);
        }
    }
}
