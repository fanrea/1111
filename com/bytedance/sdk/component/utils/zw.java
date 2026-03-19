package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class zw extends Handler {
    protected WeakReference<d> d;

    public interface d {
        void d(Message message);
    }

    public zw(Looper looper, d dVar) {
        super(looper);
        if (dVar != null) {
            this.d = new WeakReference<>(dVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        d dVar;
        WeakReference<d> weakReference = this.d;
        if (weakReference == null || (dVar = weakReference.get()) == null || message == null) {
            return;
        }
        dVar.d(message);
    }
}
