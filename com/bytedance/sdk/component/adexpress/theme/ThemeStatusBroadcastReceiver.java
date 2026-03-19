package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<d> d;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<d> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().b_(intExtra);
    }

    public void d(d dVar) {
        this.d = new WeakReference<>(dVar);
    }
}
