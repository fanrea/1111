package com.kwad.sdk.live.audience.api;

import android.text.TextUtils;
import com.kwad.sdk.live.audience.KSLiveInitModule;
import com.kwad.sdk.live.audience.test.KSLiveLogger;
import com.kwad.sdk.live.audience.test.KSLiveTestConfig;
import com.kwad.sdk.live.sercurity.KSLiveSignatureUtil;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveRequest {
    private static final String DEFAULT_HOST = "live.kuaishou.com";
    private static final String HTTP = "http://";
    private static final String HTTPS = "https://";
    public final Map<String, String> mBodyParam;
    public final Map<String, String> mHeaderParam;
    public final String mUrl;
    public final Map<String, String> mUrlParam;

    public KSLiveRequest(String str, Map<String, String> map, long j, String str2) {
        this.mUrl = generateUrl() + str;
        this.mUrlParam = KSLiveRequestHelper.buildRequestUrlParams(j);
        this.mHeaderParam = KSLiveRequestHelper.buildRequestHeader(str2, j);
        this.mBodyParam = map;
        KSLiveSignatureUtil.sigLiveRequest(str, this.mUrlParam, map);
    }

    private String generateUrl() {
        KSLiveTestConfig testConfig = KSLiveInitModule.getInstance().getTestConfig();
        String str = (testConfig == null || !testConfig.enableHttpTest()) ? "https://" : "http://";
        String liveTestHost = (testConfig == null || TextUtils.isEmpty(testConfig.getLiveTestHost())) ? DEFAULT_HOST : testConfig.getLiveTestHost();
        KSLiveLogger.i("generateUrl", "url", str + liveTestHost);
        return str + liveTestHost;
    }
}
