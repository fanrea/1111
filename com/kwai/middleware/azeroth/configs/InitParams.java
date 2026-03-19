package com.kwai.middleware.azeroth.configs;

import com.kwai.middleware.azeroth.network.InitApiRequesterParams;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class InitParams {
    public abstract InitCommonParams getCommonParams();

    public long sdkConfigRequestBkgIntervalMs() {
        return TimeUnit.SECONDS.toMillis(30L);
    }

    public InitApiRequesterParams getApiRequesterParams() {
        return new InitApiRequesterParams() { // from class: com.kwai.middleware.azeroth.configs.InitParams.1
        };
    }
}
