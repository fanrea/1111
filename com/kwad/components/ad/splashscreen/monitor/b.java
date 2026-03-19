package com.kwad.components.ad.splashscreen.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b {
    private static volatile b HL;

    public static b md() {
        if (HL == null) {
            synchronized (b.class) {
                if (HL == null) {
                    HL = new b();
                }
            }
        }
        return HL;
    }

    public static void u(long j) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(1).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.HI) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.bAd)).setVisibleCheckDelayTime(e.Zc()).setPosId(j));
    }

    public static void f(long j, long j2) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(11).setBeforeLoadDataTime(j2).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.HI) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.bAd)).setVisibleCheckDelayTime(e.Zc()).setPosId(j));
    }

    public static void e(AdTemplate adTemplate, long j) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setBeforeLoadDataTime(j).setLoadDataTime(adTemplate.loadDataTime).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.HI) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.bAd)).setVisibleCheckDelayTime(e.Zc()).setPreloadId(com.kwad.sdk.core.response.b.a.bf(com.kwad.sdk.core.response.b.e.eP(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, long j, long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i).setCheckDataTime(jElapsedRealtime).setBeforeLoadDataTime(j2).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.HI) ? 1L : 2L).setLoadAndCheckDataTime(adTemplate.loadDataTime + jElapsedRealtime).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.bAd)).setVisibleCheckDelayTime(e.Zc()).setPreloadId(com.kwad.sdk.core.response.b.a.bf(com.kwad.sdk.core.response.b.e.eP(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, int i, long j, long j2) {
        String strL;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bi(adInfoEP)) {
            strL = com.kwad.sdk.core.response.b.a.L(adInfoEP);
        } else {
            strL = com.kwad.sdk.core.response.b.a.aY(adInfoEP).materialUrl;
        }
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(jElapsedRealtime).setBeforeLoadDataTime(j2).setLoadAndCheckDataTime(adTemplate.loadDataTime + jElapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.bf(adInfoEP)).setUrl(strL).setAdTemplate(adTemplate));
    }

    public static void v(long j) {
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(1).setPosId(j));
    }

    public static void a(List<AdTemplate> list, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.kwad.sdk.core.response.b.a.bf(com.kwad.sdk.core.response.b.e.eP(it.next())));
        }
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(2).setIds(arrayList).setLoadDataTime(j).setCount(list.size()).setPosId(j2));
    }

    public static void b(int i, String str, long j) {
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(3).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void a(AdTemplate adTemplate, long j, int i, int i2) {
        String strL;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bi(adInfoEP)) {
            strL = com.kwad.sdk.core.response.b.a.L(adInfoEP);
        } else {
            strL = com.kwad.sdk.core.response.b.a.aY(adInfoEP).materialUrl;
        }
        File fileDw = com.kwad.sdk.core.diskcache.b.a.ZH().dw(com.kwad.sdk.core.response.b.a.bf(adInfoEP));
        com.kwad.sdk.commercial.b.g(false, new SplashMonitorInfo().setStatus(1).setPreloadId(com.kwad.sdk.core.response.b.a.bf(adInfoEP)).setCostTime(j).setCacheValidTime(adInfoEP.adPreloadInfo.validityPeriod * 1000).setSize((fileDw == null || !fileDw.exists()) ? 0L : fileDw.length()).setUrl(strL).setMaterialType(com.kwad.sdk.core.response.b.a.bi(adInfoEP) ? 1 : 2).setType(i).setRequestType(i2).setAdTemplate(adTemplate));
    }

    public static void d(AdTemplate adTemplate, int i, String str) {
        String strL;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bi(adInfoEP)) {
            strL = com.kwad.sdk.core.response.b.a.L(adInfoEP);
        } else {
            strL = com.kwad.sdk.core.response.b.a.aY(adInfoEP).materialUrl;
        }
        com.kwad.sdk.commercial.b.g(true, new SplashMonitorInfo().setStatus(2).setPreloadId(com.kwad.sdk.core.response.b.a.bf(adInfoEP)).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setUrl(strL).setErrorCode(i).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.b.a.bi(adInfoEP) ? 1 : 2).setType(1).setAdTemplate(adTemplate));
    }

    public static void k(AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        while (true) {
            int i = 1;
            if (it.hasNext()) {
                AdTemplate next = it.next();
                arrayList.add(String.valueOf(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.eP(next))));
                arrayList2.add(com.kwad.sdk.core.response.b.a.bf(com.kwad.sdk.core.response.b.e.eP(next)));
                if (com.kwad.sdk.core.response.b.a.bi(com.kwad.sdk.core.response.b.e.eP(next))) {
                    i = 2;
                }
                arrayList3.add(Integer.valueOf(i));
            } else {
                com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).setMaterialTypes(arrayList3).setStatus(1).setPosId(adResultData.getPosId()));
                return;
            }
        }
    }

    public static void a(long j, List<String> list, List<Integer> list2) {
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setTotalCount(list == null ? 0 : list.size()).setPreloadIds(list).setMaterialTypes(list2).setStatus(2).setPosId(j));
    }

    public static void a(long j, List<String> list, List<Integer> list2, int i, int i2, int i3, int i4) {
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setTotalCount(list == null ? 0 : list.size()).setPreloadIds(list).setMaterialTypes(list2).setUpdateType(i).setClearCount(i2).setClearImageCount(i3).setClearVideoCount(i4).setStatus(3).setPosId(j));
    }

    public static void f(AdTemplate adTemplate, long j) {
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(1).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.bAd)).setVisibleCheckDelayTime(e.Zc()).setType(com.kwad.sdk.core.response.b.a.bj(com.kwad.sdk.core.response.b.e.eP(adTemplate)) ? 2 : 1).setCostTime(j).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.HI) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void g(AdTemplate adTemplate, long j) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(5).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setPreloadId(com.kwad.sdk.core.response.b.a.bf(adInfoEP)).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, long j, long j2, long j3) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(2).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setCostTime(j).setAddLoadTime(j2).setRequestLoadTime(j3).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.bAd)).setVisibleCheckDelayTime(e.Zc()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setPreloadId(com.kwad.sdk.core.response.b.a.bf(adInfoEP)).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.HI) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void e(AdTemplate adTemplate, int i, String str) {
        String strL;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        boolean zBj = com.kwad.sdk.core.response.b.a.bj(adInfoEP);
        SplashMonitorInfo type = new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(3).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setPreloadId(com.kwad.sdk.core.response.b.a.bf(adInfoEP)).setType(zBj ? 2 : 1);
        if (zBj) {
            strL = com.kwad.sdk.core.response.b.a.aY(adInfoEP).materialUrl;
        } else {
            strL = com.kwad.sdk.core.response.b.a.L(adInfoEP);
        }
        com.kwad.sdk.commercial.b.m(type.setUrl(strL).setErrorCode(i).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void aj(AdTemplate adTemplate) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(4).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.bAd)).setVisibleCheckDelayTime(e.Zc()).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, long j, boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(6).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setViewSource(z ? 1 : 2).setLoadDataTime(jElapsedRealtime).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void ak(AdTemplate adTemplate) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(200).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void al(AdTemplate adTemplate) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(201).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(202).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setRootVisible(z).setParentVisible(z2).setHasUnbind(z3).setAdTemplate(adTemplate));
    }

    public static void am(AdTemplate adTemplate) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(204).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void an(AdTemplate adTemplate) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(205).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, long j, boolean z, boolean z2) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(203).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setLoadDataTime(SystemClock.elapsedRealtime() - j).setRootVisible(z).setParentVisible(z2).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void ao(AdTemplate adTemplate) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(206).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void ap(AdTemplate adTemplate) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(207).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setType(com.kwad.sdk.core.response.b.a.bj(adInfoEP) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, boolean z) {
        if (adTemplate == null) {
            com.kwad.sdk.commercial.b.n(new SplashMonitorInfo().setErrorMsg(str).setViewSource(z ? 1 : 2));
        } else {
            com.kwad.sdk.commercial.b.n(new SplashMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.eP(adTemplate))).setErrorMsg(str).setViewSource(z ? 1 : 2).setAdTemplate(adTemplate));
        }
    }

    public static void aq(AdTemplate adTemplate) {
        String str;
        boolean z;
        int i;
        AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfoDU = com.kwad.sdk.core.response.b.b.dU(adTemplate);
        boolean z2 = true;
        if (TextUtils.isEmpty(splashPlayCardTKInfoDU.templateId)) {
            str = SplashMonitorInfo.TEMPLATE_ID_EMPTY;
            z = true;
        } else {
            str = "";
            z = false;
        }
        if (splashPlayCardTKInfoDU.renderType != 1) {
            str = str + SplashMonitorInfo.TEMPLATE_RENER_TYPE_ERROR;
            i = splashPlayCardTKInfoDU.renderType;
        } else {
            i = -1;
            z2 = z;
        }
        if (z2) {
            com.kwad.sdk.commercial.b.o(new SplashMonitorInfo().setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
        }
    }

    public static void b(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.b.p(new SplashMonitorInfo().setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void c(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long jDU;
        SplashMonitorInfo tkRenderType = new SplashMonitorInfo().setStatus(101).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.dW(adTemplate));
        com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (h.ad(adTemplate)) {
            jDU = com.kwad.sdk.core.response.b.b.dV(adTemplate);
        } else {
            jDU = com.kwad.sdk.core.response.b.b.dU(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(tkRenderType.setTkDefaultTimeout(jDU).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long jDU;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(102).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.dW(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (h.ad(adTemplate)) {
            jDU = com.kwad.sdk.core.response.b.b.dV(adTemplate);
        } else {
            jDU = com.kwad.sdk.core.response.b.b.dU(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(jDU).setAdTemplate(adTemplate));
    }

    public final void c(AdTemplate adTemplate, String str) {
        long jDU;
        StyleTemplate styleTemplateD = d(adTemplate);
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(103).setTkRenderType(com.kwad.sdk.core.response.b.b.dW(adTemplate)).setTemplateId(styleTemplateD.templateId).setTemplateVersionCode(styleTemplateD.templateVersionCode);
        com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (h.ad(adTemplate)) {
            jDU = com.kwad.sdk.core.response.b.b.dV(adTemplate);
        } else {
            jDU = com.kwad.sdk.core.response.b.b.dU(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(jDU).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate, int i, long j, int i2, long j2, long j3, long j4, long j5, long j6) {
        long jDU;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(104).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.dW(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (h.ad(adTemplate)) {
            jDU = com.kwad.sdk.core.response.b.b.dV(adTemplate);
        } else {
            jDU = com.kwad.sdk.core.response.b.b.dU(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(jDU).setSoSource(i).setSoLoadTime(j).setOfflineSource(i2).setOfflineLoadTime(j2).setTkFileLoadTime(j3).setTkInitTime(j4).setTkRenderTime(j5).setTkTotalTime(j6).setAdTemplate(adTemplate));
    }

    public static void c(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long jDU;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(106).setTkRenderType(com.kwad.sdk.core.response.b.b.dW(adTemplate)).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (h.ad(adTemplate)) {
            jDU = com.kwad.sdk.core.response.b.b.dV(adTemplate);
        } else {
            jDU = com.kwad.sdk.core.response.b.b.dU(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(jDU).setAdTemplate(adTemplate));
    }

    public final void d(AdTemplate adTemplate, String str) {
        long jDU;
        StyleTemplate styleTemplateD = d(adTemplate);
        SplashMonitorInfo errorMsg = new SplashMonitorInfo().setStatus(105).setTemplateId(styleTemplateD.templateId).setTemplateVersionCode(styleTemplateD.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.dW(adTemplate)).setErrorMsg(str);
        com.kwad.sdk.core.response.b.e.eP(adTemplate);
        if (h.ad(adTemplate)) {
            jDU = com.kwad.sdk.core.response.b.b.dV(adTemplate);
        } else {
            jDU = com.kwad.sdk.core.response.b.b.dU(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(errorMsg.setTkDefaultTimeout(jDU).setAdTemplate(adTemplate));
    }

    private static StyleTemplate d(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.ej(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (matrixTemplateK != null) {
            styleTemplate.templateId = matrixTemplateK.templateId;
            styleTemplate.templateMd5 = matrixTemplateK.templateMd5;
            styleTemplate.templateUrl = matrixTemplateK.templateUrl;
            styleTemplate.templateVersionCode = (int) matrixTemplateK.templateVersionCode;
        }
        return styleTemplate;
    }

    public static void e(AdTemplate adTemplate, int i, int i2) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(3001).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.b.a.bf(adInfoEP)).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setUrl(com.kwad.sdk.core.response.b.a.aY(adInfoEP).materialUrl).setShowType(i2).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, int i2, int i3, long j, long j2) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(3002).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.b.a.bf(adInfoEP)).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setUrl(com.kwad.sdk.core.response.b.a.aY(adInfoEP).materialUrl).setShowType(i2).setLoadType(i3).setCostTime(j).setShowDurationMs(j2).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, int i, int i2, int i3, long j, long j2) {
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(3003).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.b.a.bf(adInfoEP)).setCreativeId(com.kwad.sdk.core.response.b.a.K(adInfoEP)).setUrl(com.kwad.sdk.core.response.b.a.aY(adInfoEP).materialUrl).setShowType(i2).setLoadType(i3).setCostTime(j).setShowDurationMs(j2).setAdTemplate(adTemplate));
    }
}
