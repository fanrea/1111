package com.kwad.sdk.init;

import android.content.Context;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.live.audience.api.KSLiveHttpConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveRequestConfigImpl implements KSLiveHttpConfig {
    private String mAppId;
    private Context mContext;

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getAcceptLanguage() {
        return "zh-cn";
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getCountryIso() {
        return "cn";
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getEGid() {
        return null;
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getUserToken() {
        return "";
    }

    public KSLiveRequestConfigImpl(Context context, String str) {
        this.mAppId = str;
        this.mContext = context;
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getAppVersion() {
        return OfflineHostProvider.getApi().env().getAppVersion();
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getVersion() {
        return OfflineHostProvider.getApi().env().getSdkVersion();
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getLatitude() {
        return String.valueOf(OfflineHostProvider.getApi().env().getLatitude(this.mContext));
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getLongitude() {
        return String.valueOf(OfflineHostProvider.getApi().env().getLongitude(this.mContext));
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getSystemVersion() {
        return String.valueOf(OfflineHostProvider.getApi().env().getOsVersion());
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getKpn() {
        return OfflineHostProvider.getApi().env().getKpn();
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getKpf() {
        return OfflineHostProvider.getApi().env().getKpf();
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getDeviceID() {
        return OfflineHostProvider.getApi().env().getDeviceId();
    }

    @Override // com.kwad.sdk.live.audience.api.KSLiveHttpConfig
    public String getBiz() {
        return OfflineHostProvider.getApi().env().getBiz();
    }
}
