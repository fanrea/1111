package com.ss.android.socialbase.downloader.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class gb extends Handler {
    private final WeakReference<d> d;

    public interface d {
        void d(Message message);
    }

    public gb(Looper looper, d dVar) {
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
