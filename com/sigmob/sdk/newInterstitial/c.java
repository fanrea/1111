package com.sigmob.sdk.newInterstitial;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.af;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c implements af {
    public static final String a = "InterstitialAdViewAbilitySessionManager";
    private final HashSet<b> b;
    private BaseAdUnit c = null;

    public c() {
        HashSet<b> hashSet = new HashSet<>();
        this.b = hashSet;
        hashSet.add(new b());
    }

    @Override // com.sigmob.sdk.base.common.af
    public void a() {
        if (this.c == null) {
            SigmobLog.e("endDisplaySession() called mAdUnit is null");
            return;
        }
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b(this.c);
        }
        this.c.setSessionManager(null);
        this.c.destroy();
        com.sigmob.sdk.base.common.g.b(this.c);
        this.c = null;
    }

    @Override // com.sigmob.sdk.base.common.af
    public void a(BaseAdUnit adUnit) {
        if (adUnit == null) {
            SigmobLog.e("createDisplaySession() called mAdUnit is null");
            return;
        }
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(adUnit);
        }
        this.c = adUnit;
        adUnit.setSessionManager(this);
    }

    @Override // com.sigmob.sdk.base.common.af
    public void a(String event, int currentPosition) {
        SigmobLog.d("InterstitialAdViewAbilitySessionManager#recordDisplayEvent: event = " + event + ", currentPosition = " + currentPosition);
        if (this.c == null) {
            SigmobLog.e("createDisplaySession() called mAdUnit is null");
            return;
        }
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this.c, event, currentPosition);
        }
    }
}
