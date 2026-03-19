package com.alliance.ssp.ad.d0;

import android.app.Activity;
import com.alliance.ssp.ad.api.ISAAllianceAdManager;
import com.alliance.ssp.ad.api.SAAllianceAd;

/* compiled from: SAAllianceAdManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h implements ISAAllianceAdManager {
    @Override // com.alliance.ssp.ad.api.ISAAllianceAdManager
    public SAAllianceAd createSAAllianceAd(Activity activity) {
        return new g(activity);
    }
}
