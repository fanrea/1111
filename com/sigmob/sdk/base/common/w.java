package com.sigmob.sdk.base.common;

import android.os.Bundle;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class w extends n {
    protected n.b a;
    protected BaseAdUnit b;
    private EventForwardingBroadcastReceiver c;

    protected w(n.b customEventInterstitialListener) {
        this.a = customEventInterstitialListener;
    }

    protected abstract void a(n.b customEventInterstitialListener);

    public void a(BaseAdUnit baseAdUnit, Bundle option) {
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = new EventForwardingBroadcastReceiver(baseAdUnit, this.a, baseAdUnit.getUuid());
        this.c = eventForwardingBroadcastReceiver;
        eventForwardingBroadcastReceiver.a(eventForwardingBroadcastReceiver);
    }

    public void a(Map<String, Object> localExtras, BaseAdUnit adUnit) {
        this.b = adUnit;
        a(this.a);
    }

    protected abstract boolean a(BaseAdUnit adUnit);

    public void b(BaseAdUnit baseAdUnit) {
        if (baseAdUnit != null) {
            g.b(baseAdUnit);
            baseAdUnit.destroy();
        }
        this.b = null;
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = this.c;
        if (eventForwardingBroadcastReceiver != null) {
            eventForwardingBroadcastReceiver.b(eventForwardingBroadcastReceiver);
        }
    }
}
