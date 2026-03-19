package com.sigmob.sdk.splash;

import android.content.Context;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.common.utils.TouchLocation;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.SplashAdSetting;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends com.sigmob.sdk.base.common.h {
    private int l = 3;
    private boolean m;

    public static a f(BaseAdUnit adUnit) {
        a aVar = new a();
        aVar.b(adUnit);
        return aVar;
    }

    @Override // com.sigmob.sdk.base.common.h
    public void a(Context context, TouchLocation down, TouchLocation up, com.sigmob.sdk.base.a clickUIType, BaseAdUnit adUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        com.sigmob.sdk.base.network.g.a(adUnit, "click");
    }

    @Override // com.sigmob.sdk.base.common.h
    public void b(Context context, int contentPlayHead, BaseAdUnit adUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ac.b("close", null, adUnit);
        com.sigmob.sdk.base.network.g.a(adUnit, "ad_close");
    }

    @Override // com.sigmob.sdk.base.common.h
    public void b(BaseAdUnit adUnit) {
        super.b(adUnit);
        SplashAdSetting splashAdSetting = adUnit.getSplashAdSetting();
        if (splashAdSetting == null) {
            return;
        }
        this.l = splashAdSetting.show_duration.intValue();
        this.m = splashAdSetting.enable_close_on_click.booleanValue();
    }

    @Override // com.sigmob.sdk.base.common.h
    public void c(Context context, int contentPlayHead, BaseAdUnit adUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
        ac.b("skip", null, adUnit);
        com.sigmob.sdk.base.network.g.a(adUnit, "skip");
    }

    public int l() {
        return this.l;
    }

    public boolean m() {
        return this.m;
    }
}
