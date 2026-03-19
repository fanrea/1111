package com.sigmob.sdk.splash;

import android.os.Bundle;
import android.text.TextUtils;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.common.w;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class d extends w {
    com.sigmob.sdk.splash.a c;
    private SplashAdBroadcastReceiver d;

    interface a extends n.b, n.c {
        void a_();

        void b_();

        void k();

        void l();
    }

    protected d(n.b customEventInterstitialListener) {
        super(customEventInterstitialListener);
    }

    public static boolean c(BaseAdUnit adUnit) {
        MaterialMeta material = adUnit.getMaterial();
        if (TextUtils.isEmpty(adUnit.getCrid())) {
            return false;
        }
        return (TextUtils.isEmpty(material.video_url) && TextUtils.isEmpty(material.image_src)) ? false : true;
    }

    @Override // com.sigmob.sdk.base.common.w
    protected void a(n.b customEventInterstitialListener) {
        this.a = customEventInterstitialListener;
    }

    @Override // com.sigmob.sdk.base.common.w
    public void a(BaseAdUnit baseAdUnit, Bundle options) {
        if (baseAdUnit == null) {
            baseAdUnit = this.b;
        }
        if (com.sigmob.sdk.base.utils.n.b(baseAdUnit)) {
            this.c = (com.sigmob.sdk.splash.a) baseAdUnit.getAdConfig();
        }
        super.a(baseAdUnit, options);
        if (this.a instanceof a) {
            SplashAdBroadcastReceiver splashAdBroadcastReceiver = new SplashAdBroadcastReceiver((a) this.a, baseAdUnit.getUuid());
            this.d = splashAdBroadcastReceiver;
            splashAdBroadcastReceiver.a(splashAdBroadcastReceiver);
        }
    }

    @Override // com.sigmob.sdk.base.common.w
    protected boolean a(BaseAdUnit adUnit) {
        return c(adUnit);
    }

    @Override // com.sigmob.sdk.base.common.w
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
        SplashAdBroadcastReceiver splashAdBroadcastReceiver = this.d;
        if (splashAdBroadcastReceiver == null) {
            return;
        }
        splashAdBroadcastReceiver.b(splashAdBroadcastReceiver);
        this.d = null;
    }
}
