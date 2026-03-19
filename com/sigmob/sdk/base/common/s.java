package com.sigmob.sdk.base.common;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class s implements af {
    public static final String a = "ExternalViewAbilitySessionManager";
    private final Set<r> b;
    private BaseAdUnit c;

    public s() {
        HashSet hashSet = new HashSet();
        this.b = hashSet;
        hashSet.add(new ad());
    }

    @Override // com.sigmob.sdk.base.common.af
    public void a() {
        SigmobLog.d("endDisplaySession() called");
        if (this.c == null) {
            SigmobLog.e("endDisplaySession() called mAdUnit is null");
            return;
        }
        Iterator<r> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b(this.c);
        }
        this.c.setSessionManager(null);
        this.c.destroy();
        this.c = null;
    }

    public void a(int duration, int endTime) {
        if (this.c == null) {
            SigmobLog.e("onVideoPrepared() called mAdUnit is null");
            return;
        }
        Iterator<r> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this.c, duration, endTime);
        }
    }

    @Override // com.sigmob.sdk.base.common.af
    public void a(BaseAdUnit adUnit) {
        if (adUnit == null) {
            SigmobLog.e("createDisplaySession() called adUnit is null");
            return;
        }
        this.c = adUnit;
        adUnit.setSessionManager(this);
        Iterator<r> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(adUnit);
        }
    }

    @Override // com.sigmob.sdk.base.common.af
    public void a(String event, int currentPosition) {
        SigmobLog.d("ExternalViewAbilitySessionManager#recordDisplayEvent: event = " + event + ", currentPosition = " + currentPosition);
        if (this.c == null) {
            SigmobLog.e("recordDisplayEvent() called mAdUnit is null");
            return;
        }
        Iterator<r> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this.c, event, currentPosition);
        }
    }

    public void a(boolean isForceShow, int currentPosition) {
        if (this.c == null) {
            SigmobLog.e("onVideoShowSkip() called mAdUnit is null");
            return;
        }
        Iterator<r> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this.c, isForceShow, currentPosition);
        }
    }
}
