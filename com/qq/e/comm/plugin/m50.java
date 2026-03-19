package com.qq.e.comm.plugin;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class m50 extends Handler {
    final WeakReference<Handler.Callback> a;

    public m50(Handler.Callback callback, Looper looper) {
        super(looper);
        this.a = new WeakReference<>(callback);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        Handler.Callback callback = this.a.get();
        if (callback == null || message == null) {
            return;
        }
        callback.handleMessage(message);
    }
}
