package com.kwad.components.ct.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.kwad.components.ct.f.b;
import java.lang.ref.SoftReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f<T extends b> extends BroadcastReceiver {
    private SoftReference<b> aVq;

    public f(b bVar) {
        this.aVq = null;
        this.aVq = new SoftReference<>(bVar);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("ks_sdk_theme_mode_change".equals(intent.getAction())) {
            cK(intent.getIntExtra("themeModeType", 0));
        }
    }

    private void cK(int i) {
        SoftReference<b> softReference = this.aVq;
        if (softReference == null || softReference.get() == null) {
            return;
        }
        try {
            this.aVq.get().cg(i);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
