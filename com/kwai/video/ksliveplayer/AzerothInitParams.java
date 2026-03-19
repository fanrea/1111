package com.kwai.video.ksliveplayer;

import android.app.Application;
import com.kwai.middleware.azeroth.configs.InitCommonParams;
import com.kwai.middleware.azeroth.configs.InitParams;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class AzerothInitParams extends InitParams {
    private String mAppId;
    private Application mContext;
    private String mDeviceId;
    private String mKpn;

    public AzerothInitParams(Application application, String str, String str2, String str3) {
        this.mContext = application;
        this.mDeviceId = str2;
        this.mAppId = str;
        this.mKpn = str3;
    }

    @Override // com.kwai.middleware.azeroth.configs.InitParams
    public InitCommonParams getCommonParams() {
        return new AzerothInitCommonParams(this.mContext, this.mAppId, this.mDeviceId, this.mKpn);
    }
}
