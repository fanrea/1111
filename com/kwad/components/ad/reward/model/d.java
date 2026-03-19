package com.kwad.components.ad.reward.model;

import com.bytedance.android.live.base.api.push.ILivePush;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    public static String m(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.a.df(adInfo) ? ILivePush.ClickType.LIVE : com.kwad.sdk.core.response.b.a.bj(adInfo) ? "image" : com.kwad.sdk.core.response.b.a.cp(adInfo) ? "reward_preview" : "video";
    }
}
