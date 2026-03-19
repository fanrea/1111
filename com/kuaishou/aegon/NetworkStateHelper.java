package com.kuaishou.aegon;

import android.content.Context;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
class NetworkStateHelper extends PhoneStateListener {
    private Context a;
    private TelephonyManager b = null;

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnCreated();

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSignalStrengthChanged();

    private void performKwaiConnectionTypeUpdate(int i) {
    }

    NetworkStateHelper(Context context) {
        this.a = context;
        com.kuaishou.aegon.a.a.b(f.a(this));
    }

    @Override // android.telephony.PhoneStateListener
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        com.kuaishou.aegon.a.a.b(g.a(this));
    }

    private void performSignalStrengthMetricsUpdate() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                a();
            } catch (Exception unused) {
            }
        }
    }
}
