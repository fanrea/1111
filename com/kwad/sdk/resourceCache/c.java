package com.kwad.sdk.resourceCache;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.resourceCache.model.WarmUpReportMessage;
import com.kwad.sdk.resourceCache.model.WarmUpResponse;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    public static void a(final WarmUpResponse.ResourceItem resourceItem, final int i) {
        h.execute(new bh() { // from class: com.kwad.sdk.resourceCache.c.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.b(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.cre, new WarmUpReportMessage().setDownloadStatus(1).setResourceType(i).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url));
            }
        });
    }

    public static void b(final WarmUpResponse.ResourceItem resourceItem, final int i) {
        h.execute(new bh() { // from class: com.kwad.sdk.resourceCache.c.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.b(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.cre, new WarmUpReportMessage().setDownloadStatus(4).setResourceType(i).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url));
            }
        });
    }

    public static void c(final WarmUpResponse.ResourceItem resourceItem, final int i) {
        h.execute(new bh() { // from class: com.kwad.sdk.resourceCache.c.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.b(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.cre, new WarmUpReportMessage().setDownloadStatus(2).setResourceType(i).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url));
            }
        });
    }

    public static void a(final WarmUpResponse.ResourceItem resourceItem, final int i, int i2, final String str) {
        final int i3 = 0;
        h.execute(new bh() { // from class: com.kwad.sdk.resourceCache.c.4
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.b(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.cre, new WarmUpReportMessage().setDownloadStatus(3).setResourceType(i).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url).setErrorCode(i3).setErrorMsg(str));
            }
        });
    }

    public static void a(final List<WarmUpResponse.ResourceItem> list, final List<WarmUpResponse.ResourceItem> list2, final int i) {
        h.execute(new bh() { // from class: com.kwad.sdk.resourceCache.c.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                try {
                    com.kwad.sdk.commercial.b.c(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.cre, new WarmUpReportMessage().setFreeDisk(i).setConfigItems(aa.aL(new ArrayList(list)).toString()).setLocalItems(aa.aL(new ArrayList(list2)).toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
