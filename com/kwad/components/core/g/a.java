package com.kwad.components.core.g;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static int RS;
    public static AtomicInteger RT = new AtomicInteger(0);

    public static void a(final BusinessType businessType) {
        GlobalThreadPools.acm().execute(new Runnable() { // from class: com.kwad.components.core.g.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    String strZe = e.Ze();
                    if (strZe == null) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(strZe);
                    boolean zOptBoolean = jSONObject.optBoolean("isCheatUser", false);
                    boolean zOptBoolean2 = jSONObject.optBoolean("enableAdClientCheaterReport", false);
                    a.RS = jSONObject.optInt("maxCollectCount", 0);
                    if (zOptBoolean2 && a.RT.incrementAndGet() <= a.RS) {
                        com.kwad.sdk.commercial.b.d(c.Wz().dW(ILoggerReporter.Category.APM_LOG).l(1.0d).b(businessType).V("ad_sdk_feature_info_collect", "default_type").l(b.qr().aE(zOptBoolean).aN(a.RS).toJson()));
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
