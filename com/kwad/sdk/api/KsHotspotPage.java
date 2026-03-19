package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KsHotspotPage {
    @KsAdSdkApi
    View getHotspotEntryView(Context context);

    @KsAdSdkApi
    void refresh();

    @KsAdSdkApi
    void setPageListener(KsContentPage.PageListener pageListener);

    @KsAdSdkApi
    void setShareListener(KsContentPage.KsShareListener ksShareListener);

    @KsAdSdkApi
    void setVideoListener(KsContentPage.VideoListener videoListener);
}
