package com.bytedance.adsdk.ugeno.an;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt extends Handler {
    private final WeakReference<d> d;

    public interface d {
        void d(Message message);
    }

    public tt(Looper looper, d dVar) {
        super(looper);
        this.d = new WeakReference<>(dVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        d dVar = this.d.get();
        if (dVar == null || message == null) {
            return;
        }
        dVar.d(message);
    }
}
