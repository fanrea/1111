package com.kwad.components.core.webview.a;

import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public String PD;
    public String adQ;
    public String adR;
    public int adS;

    public final AdInfo.SmallAppJumpInfo aZ(String str) {
        AdInfo.SmallAppJumpInfo smallAppJumpInfo = new AdInfo.SmallAppJumpInfo();
        smallAppJumpInfo.mediaSmallAppId = str;
        smallAppJumpInfo.originId = this.adQ;
        smallAppJumpInfo.smallAppJumpUrl = this.adR;
        return smallAppJumpInfo;
    }
}
