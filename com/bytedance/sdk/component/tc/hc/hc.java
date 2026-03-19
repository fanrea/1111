package com.bytedance.sdk.component.tc.hc;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.zw;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends zw implements b {
    private final HandlerThread hc;

    hc(HandlerThread handlerThread, zw.d dVar) {
        super(handlerThread.getLooper(), dVar);
        this.hc = handlerThread;
    }

    @Override // com.bytedance.sdk.component.tc.hc.b
    public void d() {
        removeCallbacksAndMessages(null);
        if (this.d != null) {
            this.d.clear();
            this.d = null;
        }
    }

    public void d(zw.d dVar) {
        this.d = new WeakReference<>(dVar);
    }

    public void hc() {
        HandlerThread handlerThread = this.hc;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }
}
