package com.kwad.components.ct.detail.photo.f;

import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static boolean aY(AdTemplate adTemplate) {
        AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo;
        return (!(d.ew(adTemplate) instanceof AdStyleInfo.PlayDetailInfo.PatchEcInfo) || (patchEcInfo = (AdStyleInfo.PlayDetailInfo.PatchEcInfo) d.ew(adTemplate)) == null || "".equals(patchEcInfo.strongStyleUserCommAmountSharing) || "0".equals(patchEcInfo.strongStyleUserCommAmountSharing) || patchEcInfo.strongStyleUserCommAmountSharing == null) ? false : true;
    }
}
