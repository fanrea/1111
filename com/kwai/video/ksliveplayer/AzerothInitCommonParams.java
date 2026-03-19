package com.kwai.video.ksliveplayer;

import android.app.Application;
import com.kwai.middleware.azeroth.configs.DefaultInitCommonParams;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AzerothInitCommonParams extends DefaultInitCommonParams {
    private String mAppId;
    private Application mContext;
    private String mDeviceId;
    private String mKpn;

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getChannel() {
        return "";
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getGlobalId() {
        return "";
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getPassportPassToken() {
        return "";
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getPassportServiceID() {
        return "";
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getPassportServiceSecurity() {
        return "";
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getPassportServiceToken() {
        return "";
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getUserId() {
        return "";
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public boolean isLogined() {
        return false;
    }

    public AzerothInitCommonParams(Application application, String str, String str2, String str3) {
        this.mContext = application;
        this.mDeviceId = str2;
        this.mAppId = str;
        this.mKpn = str3;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public Application getContext() {
        return this.mContext;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getProductName() {
        return this.mKpn;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitCommonParams
    public String getDeviceId() {
        return this.mDeviceId;
    }
}
