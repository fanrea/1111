package com.kwad.components.ad.interstitial.b;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static boolean dM() {
        return a.nJ.getValue().booleanValue();
    }

    public static boolean dN() {
        return a.nD.getValue().intValue() == 1;
    }

    public static int dO() {
        return a.nE.getValue().intValue();
    }

    public static boolean dP() {
        return a.nF.getValue().intValue() == 1;
    }

    public static boolean dQ() {
        return a.nG.getValue().intValue() == 1;
    }

    public static int b(AdInfo adInfo) {
        int iIntValue = a.nH.getValue().intValue();
        if (com.kwad.sdk.core.response.b.a.bi(adInfo)) {
            int iM = com.kwad.sdk.core.response.b.a.M(adInfo);
            return iIntValue == 0 ? iM : Math.min(iIntValue, iM);
        }
        if (iIntValue > 60 || iIntValue <= 0) {
            return 60;
        }
        return iIntValue;
    }

    public static boolean dR() {
        return a.nI.getValue().intValue() == 1;
    }

    public static boolean dS() {
        return a.nK.getValue().intValue() == 1;
    }
}
