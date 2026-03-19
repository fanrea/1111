package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class EventForwardingBroadcastReceiver extends BaseBroadcastReceiver {
    public static final String a = "EventForwardingBroadcastReceiver";
    private static IntentFilter c;
    public BaseAdUnit b;
    private n.b d;

    public EventForwardingBroadcastReceiver(BaseAdUnit adUnit, n.b listener, String broadcastIdentifier) {
        super(broadcastIdentifier);
        this.b = adUnit;
        this.d = listener;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (c == null) {
            IntentFilter intentFilter = new IntentFilter();
            c = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_INTERSTITIAL_FAIL);
            c.addAction(IntentActions.ACTION_INTERSTITIAL_SHOW);
            c.addAction(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            c.addAction(IntentActions.ACTION_INTERSTITIAL_CLICK);
            c.addAction(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        }
        return c;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.d = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.d == null || this.b == null || !a(intent)) {
        }
        String requestId = this.b.getRequestId();
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        SigmobLog.d(a + "#onReceive: action = " + action + ", requestId = " + requestId);
        action.hashCode();
        switch (action) {
            case "action.interstitial.dismiss":
                this.d.d(this.b);
                b(this);
                this.b = null;
                break;
            case "action.interstitial.click":
                this.d.c(this.b);
                break;
            case "action.interstitial.vopen":
                this.d.e(this.b);
                break;
            case "action.interstitial.fail":
                this.d.b(this.b, intent.getStringExtra("error"));
                break;
            case "action.interstitial.show":
                this.d.b(this.b);
                break;
        }
    }
}
