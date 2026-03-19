package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.api.core.KsAdSdkApi;
import com.kwad.sdk.api.model.AdExposureFailedReason;

@KsAdSdkApi
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KsFeedAd extends BaseKSAd {

    @KsAdSdkApi
    public interface AdInteractionListener {
        @KsAdSdkApi
        void onAdClicked();

        @KsAdSdkApi
        void onAdShow();

        @KsAdSdkApi
        void onDislikeClicked();

        @KsAdSdkApi
        void onDownloadTipsDialogDismiss();

        @KsAdSdkApi
        void onDownloadTipsDialogShow();
    }

    @KsAdSdkApi
    public interface AdRenderListener {
        @KsAdSdkApi
        void onAdRenderFailed(int i, String str);

        @KsAdSdkApi
        void onAdRenderSuccess(View view);
    }

    @KsAdSdkApi
    int getECPM();

    @KsAdSdkApi
    View getFeedView(Context context);

    @KsAdSdkApi
    int getInteractionType();

    @KsAdSdkApi
    int getMaterialType();

    @KsAdSdkApi
    void render(AdRenderListener adRenderListener);

    @KsAdSdkApi
    void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason);

    @KsAdSdkApi
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @KsAdSdkApi
    @Deprecated
    void setBidEcpm(int i);

    @KsAdSdkApi
    void setBidEcpm(long j, long j2);

    @KsAdSdkApi
    void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig);

    @KsAdSdkApi
    void setVideoSoundEnable(boolean z);
}
