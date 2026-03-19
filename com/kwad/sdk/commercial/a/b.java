package com.kwad.sdk.commercial.a;

import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public String bub;
    public String buc;
    public String bud;
    public long bue;
    public long bug;
    public int buh;
    public int bui;
    public String downloadId;
    public long downloadTime;
    public int status;
    public String url;

    public static b WA() {
        return new b();
    }

    public final b eh(int i) {
        this.status = i;
        return this;
    }

    public final b aQ(long j) {
        this.downloadTime = j;
        return this;
    }

    public final b ei(int i) {
        this.buh = i;
        return this;
    }

    public final b ej(int i) {
        this.bui = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* renamed from: bC, reason: merged with bridge method [inline-methods] */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        AdInfo adInfoEP = e.eP(adTemplate);
        this.url = e.eS(adTemplate);
        try {
            this.bub = new URL(this.url).getHost();
        } catch (Throwable unused) {
        }
        this.downloadId = adInfoEP.downloadId;
        this.buc = adInfoEP.adBaseInfo.appPackageName;
        this.bud = adInfoEP.adBaseInfo.appName;
        this.bue = adInfoEP.totalBytes;
        this.bug = adInfoEP.soFarBytes;
        return this;
    }
}
