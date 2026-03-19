package com.sigmob.sdk.nativead;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.af;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g implements af {
    public static final String a = "NativeAdViewAbilitySessionManager";
    private final HashSet<f> b;
    private BaseAdUnit c = null;

    public g() {
        HashSet<f> hashSet = new HashSet<>();
        this.b = hashSet;
        hashSet.add(new f());
    }

    @Override // com.sigmob.sdk.base.common.af
    public void a() {
        if (this.c == null) {
            SigmobLog.e("endDisplaySession() called mAdUnit is null");
            return;
        }
        Iterator<f> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b(this.c);
        }
        this.c.setSessionManager(null);
        this.c.destroy();
        this.c = null;
    }

    @Override // com.sigmob.sdk.base.common.af
    public void a(BaseAdUnit adUnit) {
        if (adUnit == null) {
            SigmobLog.e("createDisplaySession() called mAdUnit is null");
            return;
        }
        Iterator<f> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(adUnit);
        }
        this.c = adUnit;
        adUnit.setSessionManager(this);
    }

    @Override // com.sigmob.sdk.base.common.af
    public void a(String event, int currentPosition) {
        SigmobLog.d("NativeAdViewAbilitySessionManager#recordDisplayEvent: event = " + event + ", currentPosition = " + currentPosition);
        if (this.c == null) {
            SigmobLog.e("createDisplaySession() called mAdUnit is null");
            return;
        }
        Iterator<f> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this.c, event, currentPosition);
        }
    }
}
