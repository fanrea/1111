package com.alliance.ssp.ad.w;

import android.app.Activity;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.interstitial.SAInterstitialAdLoadListener;
import java.lang.ref.WeakReference;

/* compiled from: BaseInterstitialAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends com.alliance.ssp.ad.t.a<SAInterstitialAdLoadListener> {
    public int C0;

    public a(int i, WeakReference<Activity> weakReference, String str, String str2, SAAllianceAdParams sAAllianceAdParams, SAInterstitialAdLoadListener sAInterstitialAdLoadListener, com.alliance.ssp.ad.d0.c cVar, com.alliance.ssp.ad.d0.g gVar) {
        super(weakReference, str, str2, sAAllianceAdParams, sAInterstitialAdLoadListener, null, gVar, "5", "0", -1);
        this.C0 = i;
    }
}
