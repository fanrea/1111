package com.kwad.sdk.init;

import android.content.Context;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveLongConnectionConfigImpl implements KSLiveLongConnectionConfig {
    private String appid;
    private String deviceId;
    private Context mContext;

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public int getAppType() {
        return 21;
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public int getClientId() {
        return 2;
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public int getLiveStreamStartPlaySourceType() {
        return 60;
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public String getToken() {
        return "";
    }

    public KSLiveLongConnectionConfigImpl(String str, Context context, String str2) {
        this.deviceId = str;
        this.mContext = context;
        this.appid = str2;
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public String getKpn() {
        return OfflineHostProvider.getApi().env().getKpn();
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public String getKpf() {
        return OfflineHostProvider.getApi().env().getKpf();
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public String getDeviceId() {
        return this.deviceId;
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public String getAppVersion() {
        return OfflineHostProvider.getApi().env().getAppVersion();
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public String getOperator() {
        return OfflineHostProvider.getApi().env().getOperator(this.mContext);
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public double getLatitude() {
        return OfflineHostProvider.getApi().env().getLatitude(this.mContext);
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public double getLongitude() {
        return OfflineHostProvider.getApi().env().getLongitude(this.mContext);
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public String getAppId() {
        return this.appid;
    }

    @Override // com.kwad.sdk.live.audience.longconnection.KSLiveLongConnectionConfig
    public String getBiz() {
        return OfflineHostProvider.getApi().env().getBiz();
    }
}
