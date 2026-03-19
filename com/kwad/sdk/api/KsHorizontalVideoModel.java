package com.kwad.sdk.api;

import android.content.Context;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KsHorizontalVideoModel {
    @KsAdSdkApi
    String getAuthorIcon();

    @KsAdSdkApi
    String getAuthorName();

    @KsAdSdkApi
    String getContentDesc();

    @KsAdSdkApi
    long getContentLikeCount();

    @KsAdSdkApi
    String getCoverUrl();

    @KsAdSdkApi
    long getPublishTime();

    @KsAdSdkApi
    String getTitle();

    @KsAdSdkApi
    long getVideoDuration();

    @KsAdSdkApi
    long getWatchCount();

    @KsAdSdkApi
    void handleClick(Context context);

    @KsAdSdkApi
    void setExternalViewControlListener(KsContentPage.ExternalViewControlListener externalViewControlListener);

    @KsAdSdkApi
    void setPageListener(KsContentPage.PageListener pageListener);

    @KsAdSdkApi
    void setVideoListener(KsContentPage.VideoListener videoListener);
}
