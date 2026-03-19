package com.kwai.middleware.azeroth.network;

import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.utils.ArrayUtils;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class InitApiRequesterParams {
    public boolean useHttps() {
        return true;
    }

    public List<String> getHosts() {
        if (Azeroth.get().getCommonParams().isTestMode()) {
            return ArrayUtils.asArrayList("zt.test.gifshow.com");
        }
        return ArrayUtils.asArrayList("open.kuaishouzt.com", "open.kwaizt.com");
    }

    public boolean useStandardSSLSocketFactory() {
        return (Azeroth.get().isTest() || Azeroth.get().isDebugMode()) ? false : true;
    }

    public BaseApiParams getApiParams() {
        return new BaseApiParams();
    }
}
