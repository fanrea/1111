package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KsSplashScreenAd extends BaseKSAd {

    @KsAdSdkApi
    public interface SplashScreenAdInteractionListener {
        @KsAdSdkApi
        void onAdClicked();

        @KsAdSdkApi
        void onAdShowEnd();

        @KsAdSdkApi
        void onAdShowError(int i, String str);

        @KsAdSdkApi
        void onAdShowStart();

        @KsAdSdkApi
        void onDownloadTipsDialogCancel();

        @KsAdSdkApi
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        void onDownloadTipsDialogShow();

        @KsAdSdkApi
        void onSkippedAd();
    }

    @KsAdSdkApi
    int getECPM();

    @KsAdSdkApi
    int getInteractionType();

    @KsAdSdkApi
    KSAdInfoData getKSAdInfoData();

    @KsAdSdkApi
    int getMaterialType();

    @KsAdSdkApi
    View getView(Context context, SplashScreenAdInteractionListener splashScreenAdInteractionListener);

    @KsAdSdkApi
    boolean isAdEnable();

    @KsAdSdkApi
    @Deprecated
    boolean isVideo();

    @KsAdSdkApi
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    @Deprecated
    void setBidEcpm(int i);

    @KsAdSdkApi
    void setBidEcpm(long j, long j2);
}
