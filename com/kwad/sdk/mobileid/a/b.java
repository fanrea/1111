package com.kwad.sdk.mobileid.a;

import com.kwad.sdk.core.network.d;
import com.kwad.sdk.h;
import com.kwad.sdk.utils.al;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b extends d {
    private static String cgd;

    private static String alZ() {
        return "300012755841";
    }

    private static String ama() {
        return "CB607A51A7A639E532D288AB8C963DB6";
    }

    @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return h.TG();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        try {
            cgd = alX();
            String strAlY = alY();
            String strAs = as(strAlY, cgd);
            putBody(com.alipay.sdk.m.t.a.k, strAlY);
            putBody("sign", strAs);
            putBody("traceId", cgd);
            putBody("appId", alZ());
            putBody("interfaceVersion", "2.0");
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        return this.mBodyParams;
    }

    private static String alX() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private static String as(String str, String str2) {
        return al.md5(alZ() + str + str2 + "2.0" + ama());
    }

    private static String alY() {
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
    }
}
