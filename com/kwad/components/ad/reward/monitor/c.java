package com.kwad.components.ad.reward.monitor;

import android.os.SystemClock;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bh;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(long j) {
        return j == -1;
    }

    public static void a(final boolean z, final long j) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(1).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.crg);
            }
        });
    }

    public static void b(final boolean z, final long j) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.12
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(5).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.crg);
            }
        });
    }

    public static void c(final boolean z, final long j) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.23
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(6).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.crg);
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final int i, final long j) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.26
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                c.b(z, adTemplate, i, j);
            }
        });
    }

    public static void b(boolean z, AdTemplate adTemplate, int i, long j) {
        long loadDataTime = (j <= 0 || adTemplate.getLoadDataTime() <= 0) ? -1L : adTemplate.getLoadDataTime() - j;
        long j2 = a(loadDataTime) ? -1L : loadDataTime;
        AdInfo adInfoEP = e.eP(adTemplate);
        com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i).setLoadDataDuration(j2).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.crg);
    }

    public static void d(final boolean z, final AdTemplate adTemplate) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.27
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(7).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.crg);
            }
        });
    }

    public static void c(final boolean z, final AdTemplate adTemplate, final int i, final long j) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.28
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                c.d(z, adTemplate, i, j);
            }
        });
    }

    public static void d(boolean z, AdTemplate adTemplate, int i, long j) {
        adTemplate.setDownloadFinishTime(SystemClock.elapsedRealtime());
        AdInfo adInfoEP = e.eP(adTemplate);
        long loadDataTime = adTemplate.getLoadDataTime() - j;
        long downloadFinishTime = adTemplate.getDownloadFinishTime() - adTemplate.getLoadDataTime();
        long downloadFinishTime2 = adTemplate.getDownloadFinishTime() - j;
        if (a(loadDataTime, downloadFinishTime, downloadFinishTime2)) {
            loadDataTime = -1;
            downloadFinishTime = -1;
            downloadFinishTime2 = -1;
        }
        com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdCount(i).setLoadDataDuration(loadDataTime).setDownloadDuration(downloadFinishTime).setTotalDuration(downloadFinishTime2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setAdTemplate(adTemplate), com.kwai.adclient.kscommerciallogger.model.a.crg);
    }

    public static void a(final boolean z, final int i, final String str, final long j) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.29
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.a(z, new RewardMonitorInfo().setLoadStatus(4).setErrorCode(i).setErrorMsg(str).setPosId(j), com.kwai.adclient.kscommerciallogger.model.a.crc);
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final String str) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.30
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.b(z, new RewardMonitorInfo().setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setErrorMsg(str).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final long j) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.31
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                c.a(z, adTemplate, j, (AdGlobalConfigInfo) null);
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final long j, final AdGlobalConfigInfo adGlobalConfigInfo) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.2
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                c.b(z, adTemplate, j, adGlobalConfigInfo);
            }
        });
    }

    public static void b(boolean z, AdTemplate adTemplate, long j, AdGlobalConfigInfo adGlobalConfigInfo) {
        long loadDataTime = adTemplate.getLoadDataTime();
        long downloadFinishTime = adTemplate.getDownloadFinishTime();
        long j2 = loadDataTime > 0 ? j - loadDataTime : 0L;
        long j3 = downloadFinishTime > 0 ? j - downloadFinishTime : 0L;
        int i = (adGlobalConfigInfo == null || adGlobalConfigInfo.neoPageType == 1) ? 3 : 0;
        AdInfo adInfoEP = e.eP(adTemplate);
        com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(1).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setAdSceneType(i).setDataLoadInterval(j2).setDataDownloadInterval(j3).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setAdTemplate(adTemplate));
    }

    public static void e(final boolean z, final AdTemplate adTemplate) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.3
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(6).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setAdTemplate(adTemplate));
            }
        });
    }

    public static void f(final boolean z, final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.4
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(5).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setAdTemplate(adTemplate));
            }
        });
    }

    public static void U(final AdTemplate adTemplate) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.5
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(7).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setAdTemplate(adTemplate));
            }
        });
    }

    public static void V(final AdTemplate adTemplate) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.6
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(8).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setAdTemplate(adTemplate));
            }
        });
    }

    public static void c(final AdTemplate adTemplate, final int i, final String str) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.7
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.c(true, (com.kwad.sdk.commercial.c.a) new RewardMonitorInfo().setPageStatus(9).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
            }
        });
    }

    public static void g(final boolean z, final AdTemplate adTemplate) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.8
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.g(new RewardWebViewInfo().setEvent("ad_show").setSceneId(z ? "ad_reward" : "ad_fullscreen").setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final boolean z, final String str) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.9
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_init").setSceneId(z ? "ad_reward" : "ad_fullscreen"));
            }
        });
    }

    public static void a(final AdTemplate adTemplate, final boolean z, final String str, final String str2) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.10
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_url").setSceneId(z ? "ad_reward" : "ad_fullscreen").setUrl(str2).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final AdTemplate adTemplate, final boolean z, final String str, final String str2, final long j, final int i) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.11
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_timeout").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setTimeType(i).setUrl(str2).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final boolean z, final String str, final String str2, final long j) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.13
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.g(new RewardWebViewInfo().setPageType(str).setEvent("webview_load_finish").setSceneId(z ? "ad_reward" : "ad_fullscreen").setDurationMs(j).setUrl(str2));
            }
        });
    }

    public static void b(final boolean z, final AdTemplate adTemplate, final long j) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.14
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                long j2 = -1;
                if (!c.o(j)) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
                    if (!c.a(jElapsedRealtime)) {
                        j2 = jElapsedRealtime;
                    }
                }
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(2).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setRenderDuration(j2).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setAdTemplate(adTemplate));
            }
        });
    }

    public static void h(final boolean z, final AdTemplate adTemplate) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.15
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(3).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setAdTemplate(adTemplate));
            }
        });
    }

    public static void b(final boolean z, final AdTemplate adTemplate, final String str) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.16
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(4).setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setInterceptReason(str).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final a aVar, final long j, com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        final com.kwad.sdk.g.a aVar3 = null;
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.17
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                RewardMonitorInfo posId = new RewardMonitorInfo().setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate).setPosId(j);
                com.kwad.sdk.g.a aVar4 = aVar3;
                if (aVar4 != null) {
                    aVar4.accept(posId);
                }
                com.kwad.sdk.commercial.b.e(z, posId);
            }
        });
    }

    public static void a(final boolean z, final a aVar, final AdTemplate adTemplate, final com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.18
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                c.b(z, aVar, adTemplate, (com.kwad.sdk.g.a<RewardMonitorInfo>) aVar2);
            }
        });
    }

    public static void b(boolean z, a aVar, AdTemplate adTemplate, com.kwad.sdk.g.a<RewardMonitorInfo> aVar2) {
        if (adTemplate == null) {
            return;
        }
        RewardMonitorInfo adTemplate2 = new RewardMonitorInfo().setMaterialType(com.kwad.sdk.core.response.b.a.bk(e.eP(adTemplate))).setCallbackType(aVar.getTypeValue()).setAdTemplate(adTemplate);
        if (aVar2 != null) {
            aVar2.accept(adTemplate2);
        }
        com.kwad.sdk.commercial.b.d(z, adTemplate2);
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final long j, final int i, final long j2) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.19
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.f(z, new RewardMonitorInfo().setLoadType(adTemplate.isLoadFromCache() ? 2 : 1).setCurrentDuration(j).setErrorCode(i).setErrorMsg(String.valueOf(j2)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setVideoDuration(com.kwad.sdk.core.response.b.a.N(adInfoEP)).setAdTemplate(adTemplate));
            }
        });
    }

    public static void i(final boolean z, final AdTemplate adTemplate) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.20
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                c.j(z, adTemplate);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void j(boolean r3, com.kwad.sdk.core.response.model.AdTemplate r4) {
        /*
            if (r4 == 0) goto L18
            java.lang.String r0 = r4.mDataCacheTraceElement
            boolean r0 = com.kwad.components.core.u.g.aM(r0)
            if (r0 == 0) goto Ld
            java.lang.String r0 = "data_cache"
            goto L1a
        Ld:
            java.lang.String r0 = r4.mDataLoadTraceElement
            boolean r0 = com.kwad.components.core.u.g.aM(r0)
            if (r0 == 0) goto L18
            java.lang.String r0 = "data_load"
            goto L1a
        L18:
            java.lang.String r0 = "unknown"
        L1a:
            com.kwad.components.ad.reward.monitor.RewardMonitorInfo r1 = new com.kwad.components.ad.reward.monitor.RewardMonitorInfo
            r1.<init>()
            r2 = 101(0x65, float:1.42E-43)
            com.kwad.components.ad.reward.monitor.RewardMonitorInfo r1 = r1.setPageStatus(r2)
            com.kwad.components.ad.reward.monitor.RewardMonitorInfo r0 = r1.setLaunchFrom(r0)
            com.kwad.components.core.proxy.PageCreateStage r1 = com.kwad.components.core.proxy.PageCreateStage.START_LAUNCH
            java.lang.String r1 = r1.getStage()
            com.kwad.components.ad.reward.monitor.RewardMonitorInfo r0 = r0.setSubStage(r1)
            com.kwad.components.ad.reward.monitor.RewardMonitorInfo r4 = r0.setAdTemplate(r4)
            com.kwad.sdk.commercial.b.c(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.monitor.c.j(boolean, com.kwad.sdk.core.response.model.AdTemplate):void");
    }

    public static void c(final boolean z, final AdTemplate adTemplate, final String str) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.21
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final boolean z, final AdTemplate adTemplate, final String str, final String str2) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.22
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                com.kwad.sdk.commercial.b.c(z, new RewardMonitorInfo().setPageStatus(101).setSubStage(str).setErrorMsg(str2).setAdTemplate(adTemplate));
            }
        });
    }

    public static void a(final AdTemplate adTemplate, final int i, final int i2, final boolean z) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.24
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.h(new RewardMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setRewardType(!z ? 1 : 0).setTaskType(i).setTaskStep(i2).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setVideoDuration(com.kwad.sdk.core.response.b.a.M(adInfoEP) * 1000).setAdTemplate(adTemplate));
            }
        });
    }

    public static void d(final AdTemplate adTemplate, final int i, final int i2) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.components.ad.reward.monitor.c.25
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                AdInfo adInfoEP = e.eP(adTemplate);
                com.kwad.sdk.commercial.b.i(new RewardMonitorInfo().setPageStatus(10).setFraudVerifyType(i).setFraudVerifyCode(i2).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setVideoUrl(com.kwad.sdk.core.response.b.a.L(adInfoEP)).setAdTemplate(adTemplate));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(long... jArr) {
        for (long j : jArr) {
            if (j >= 60000) {
                return true;
            }
        }
        return false;
    }
}
