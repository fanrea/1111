package com.kwad.components.ct;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.ct.request.f;
import com.kwad.components.ct.request.k;
import com.kwad.components.ct.request.l;
import com.kwad.components.ct.request.o;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bq;
import com.kwai.video.ksvodplayerkit.prefetcher.AdaptivePrefetchModel;
import com.kwai.video.ksvodplayerkit.prefetcher.BasePrefetchModel;
import com.kwai.video.ksvodplayerkit.prefetcher.KSPrefetcher;
import com.kwai.video.ksvodplayerkit.prefetcher.NomalPrefetchModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static AtomicBoolean alK = new AtomicBoolean(false);

    public static void s(List<SceneImpl> list) {
        if (list.isEmpty() || alK.get()) {
            return;
        }
        alK.set(true);
        k.a aVar = new k.a();
        Iterator<SceneImpl> it = list.iterator();
        while (it.hasNext()) {
            aVar.anZ.add(new ImpInfo(it.next()));
        }
        aVar.aUG = new com.kwad.components.ct.request.a.a();
        aVar.aUI = new o(1);
        l.a(aVar, new f() { // from class: com.kwad.components.ct.b.1
            @Override // com.kwad.components.core.request.l
            public final void onError(int i, String str) {
                com.kwad.sdk.core.d.c.d("ContentPreloadManager", "PhotoRequestManager onError msg=" + str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.components.core.request.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(CtAdResultData ctAdResultData) {
                com.kwad.sdk.core.d.c.d("ContentPreloadManager", "PhotoRequestManager onSuccess");
                if (ctAdResultData.result != 1) {
                    onError(e.bCy.errorCode, TextUtils.isEmpty(ctAdResultData.testErrorMsg) ? e.bCy.msg : ctAdResultData.testErrorMsg);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                HashMap map = new HashMap();
                for (CtAdTemplate ctAdTemplate : ctAdResultData.getCtAdTemplateList()) {
                    if (ctAdTemplate != null) {
                        arrayList.add(ctAdTemplate);
                        if (!map.containsKey(Long.valueOf(ctAdTemplate.posId))) {
                            com.kwad.sdk.core.d.c.aa("ContentPreloadManager", "rl-posid = " + ctAdTemplate.posId);
                            com.kwad.sdk.core.d.c.d("ContentPreloadManager", "posId = " + ctAdTemplate.posId + " getAuthorName = " + com.kwad.components.ct.response.a.a.aL(ctAdTemplate));
                            map.put(Long.valueOf(ctAdTemplate.posId), ctAdTemplate);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    onError(e.bCy.errorCode, TextUtils.isEmpty(ctAdResultData.testErrorMsg) ? e.bCy.msg : ctAdResultData.testErrorMsg);
                    return;
                }
                com.kwad.sdk.core.d.c.d("ContentPreloadManager", "save");
                com.kwad.components.ct.home.b.b.Gv().clearAll();
                com.kwad.components.ct.home.b.b.Gv().E(arrayList);
                com.kwad.components.ct.e.b.JK().M(arrayList);
                b.d(map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Map<Long, CtAdTemplate> map) {
        if (wV()) {
            e(map);
        }
    }

    private static boolean wV() {
        return com.kwad.sdk.core.video.a.e.Wo() && com.kwad.sdk.core.config.e.TN() && com.kwad.sdk.core.config.e.TO() && wW() && com.kwad.sdk.core.video.a.d.acD();
    }

    private static boolean wW() {
        return com.kwad.components.ct.a.b.xl() == 1 || (com.kwad.components.ct.a.b.xl() == 2 && ao.isWifiConnected(ServiceProvider.getContext()));
    }

    private static void e(Map<Long, CtAdTemplate> map) {
        int i = 0;
        for (Long l : map.keySet()) {
            CtAdTemplate ctAdTemplate = map.get(l);
            int i2 = i + 1;
            BasePrefetchModel basePrefetchModelA = a(ctAdTemplate, 1000 - i);
            if (basePrefetchModelA != null) {
                KSPrefetcher.getInstance().addTask(basePrefetchModelA);
                com.kwad.sdk.core.d.c.d("ContentPreloadManager", "addPreloadTask " + com.kwad.components.ct.response.a.a.aL(ctAdTemplate) + " key=" + l);
            }
            i = i2;
        }
    }

    private static BasePrefetchModel a(CtAdTemplate ctAdTemplate, int i) {
        if (ctAdTemplate == null) {
            return null;
        }
        String strE = com.kwad.components.ct.response.a.c.e((PhotoInfo) com.kwad.components.ct.response.a.a.ay(ctAdTemplate));
        if (!TextUtils.isEmpty(strE) && com.kwad.components.ct.a.b.wQ()) {
            return new AdaptivePrefetchModel(strE, String.valueOf(com.kwad.components.ct.response.a.a.bg(ctAdTemplate)), i);
        }
        String strAA = com.kwad.components.ct.response.a.a.aA(ctAdTemplate);
        if (bq.isNullString(strAA)) {
            return null;
        }
        return new NomalPrefetchModel(strAA, String.valueOf(com.kwad.components.ct.response.a.a.bg(ctAdTemplate)), i);
    }
}
