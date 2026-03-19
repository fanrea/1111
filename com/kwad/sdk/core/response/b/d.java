package com.kwad.sdk.core.response.b;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class d {
    public static AdStyleInfo.PlayDetailInfo.PatchAdInfo ew(AdTemplate adTemplate) {
        return eF(adTemplate).playDetailInfo.patchAdInfo;
    }

    public static long ex(AdTemplate adTemplate) {
        long j = adTemplate != null ? eF(adTemplate).playDetailInfo.actionBarInfo.translateBtnShowTime : 0L;
        return j > 0 ? j : com.alipay.sdk.m.u.b.a;
    }

    public static long ey(AdTemplate adTemplate) {
        long j = adTemplate != null ? eF(adTemplate).playDetailInfo.actionBarInfo.lightBtnShowTime : 0L;
        if (j > 0) {
            return j;
        }
        return 6000L;
    }

    public static long ez(AdTemplate adTemplate) {
        long j = adTemplate != null ? eF(adTemplate).playDetailInfo.actionBarInfo.cardShowTime : 0L;
        if (j > 0) {
            return j;
        }
        return 9000L;
    }

    public static long eA(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return eF(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String eB(AdTemplate adTemplate) {
        return adTemplate == null ? "" : eF(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String eC(AdTemplate adTemplate) {
        return adTemplate == null ? "" : eF(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean eD(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return false;
        }
        return eF(adTemplate).playDetailInfo.drawAdInfo.forcedWatch;
    }

    public static boolean eE(AdTemplate adTemplate) {
        if (adTemplate != null && e.eH(adTemplate)) {
            return eF(adTemplate).slideClick;
        }
        return false;
    }

    private static AdStyleInfo eF(AdTemplate adTemplate) {
        return e.eP(adTemplate).adStyleInfo;
    }

    public static List<String> eG(AdTemplate adTemplate) {
        AdStyleInfo adStyleInfoEF = eF(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<AdStyleInfo.ExposeTagInfo> it = adStyleInfoEF.extraDisplayInfo.exposeTagInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
