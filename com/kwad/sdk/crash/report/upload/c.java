package com.kwad.sdk.crash.report.upload;

import com.pandora.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c extends com.kwad.sdk.core.network.b {
    public final Map<String, String> bOJ;

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public c(String str, String str2, String str3) {
        HashMap map = new HashMap();
        this.bOJ = map;
        map.put(Constants.APPLog.DEVICE_ID, str);
        map.put(com.baidu.mobads.container.components.h.b.e.a, str2);
        map.put("fileExtend", str3);
        map.put("bizType", "5");
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return "https://" + com.kwad.sdk.core.network.idc.a.aaw().ad("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/token";
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final Map<String, String> getBodyMap() {
        return this.bOJ;
    }
}
