package com.kwad.sdk.api;

import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KsFeedPage {
    @KsAdSdkApi
    Fragment getFragment();

    @KsAdSdkApi
    boolean onBackPressed();

    @KsAdSdkApi
    void setPageListener(KsContentPage.PageListener pageListener);

    @KsAdSdkApi
    void setShareListener(KsContentPage.KsShareListener ksShareListener);

    @KsAdSdkApi
    void setVideoListener(KsContentPage.VideoListener videoListener);
}
