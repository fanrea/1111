package com.kwad.components.ct.detail.listener;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface DetailPageListener {
    @KsAdSdkApi
    void onPageEnter(int i, CtAdTemplate ctAdTemplate);

    @KsAdSdkApi
    void onPageLeave(int i, CtAdTemplate ctAdTemplate);

    @KsAdSdkApi
    void onPagePause(int i, CtAdTemplate ctAdTemplate);

    @KsAdSdkApi
    void onPageResume(int i, CtAdTemplate ctAdTemplate);
}
