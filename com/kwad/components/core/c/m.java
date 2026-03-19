package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m implements c {
    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkFirst";
    }

    /* renamed from: com.kwad.components.core.c.m$1, reason: invalid class name */
    final class AnonymousClass1 extends j {
        final /* synthetic */ com.kwad.components.core.request.model.a dp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(com.kwad.components.core.request.model.a aVar, com.kwad.components.core.request.model.a aVar2) {
            super(aVar);
            this.dp = aVar2;
        }

        @Override // com.kwad.components.core.c.j
        protected final boolean a(final com.kwad.components.core.request.model.a aVar, final AdResultData adResultData) {
            AdResultData adResultDataE;
            final SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
            final int adNum = adScene.getAdNum();
            if (adResultData.isAdResultDataEmpty()) {
                GlobalThreadPools.ach().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.1
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        AnonymousClass1.this.a(adScene, adResultData, adNum, new k() { // from class: com.kwad.components.core.c.m.1.1.1
                            @Override // com.kwad.components.core.c.k
                            public final void oB() {
                                com.kwad.components.core.request.model.a.a(aVar, adResultData, false);
                            }
                        });
                    }
                });
                return true;
            }
            if (adResultData.isBidding() && (adResultDataE = l.e(aVar)) != null && !adResultDataE.isAdResultDataEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(adResultDataE.getProceedTemplateList());
                arrayList.addAll(adResultData.getProceedTemplateList());
                List<AdTemplate> listO = m.o(arrayList);
                List<AdTemplate> listSubList = listO.subList(0, Math.min(adNum, listO.size()));
                if (listSubList != null && listSubList.size() > 0) {
                    com.kwad.components.core.request.model.a.a(aVar, new AdResultData(adResultData, adScene, listSubList), true);
                    return true;
                }
            }
            return false;
        }

        @Override // com.kwad.components.core.c.j, com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public final void onError(final com.kwad.components.core.request.a aVar, final int i, final String str) {
            GlobalThreadPools.ach().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.2
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new k() { // from class: com.kwad.components.core.c.m.1.2.1
                        @Override // com.kwad.components.core.c.k
                        public final void oB() {
                            com.kwad.components.core.request.model.a.a(AnonymousClass1.this.dp, i, str, false);
                        }
                    });
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(SceneImpl sceneImpl, AdResultData adResultData, int i, k kVar) throws Throwable {
            AdResultData adResultDataE = l.e(this.dp);
            if (adResultDataE == null || adResultDataE.isAdResultDataEmpty()) {
                if (kVar != null) {
                    kVar.oB();
                    return;
                }
                return;
            }
            List<AdTemplate> listO = m.o(adResultDataE.getProceedTemplateList());
            List<AdTemplate> listSubList = listO.subList(0, Math.min(i, listO.size()));
            if (listSubList.size() > 0) {
                if (adResultData == null) {
                    adResultData = new AdResultData(sceneImpl);
                }
                com.kwad.components.core.request.model.a.a(this.dp, new AdResultData(adResultData, sceneImpl, listSubList), false);
            }
        }
    }

    @Override // com.kwad.components.core.c.c
    public final void d(com.kwad.components.core.request.model.a aVar) {
        n.a(aVar, new AnonymousClass1(aVar, aVar));
    }

    public static List<AdTemplate> o(List<AdTemplate> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new a((byte) 0));
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AdTemplate adTemplate : list) {
            long jEV = com.kwad.sdk.core.response.b.e.eV(adTemplate);
            if (!hashSet.contains(Long.valueOf(jEV))) {
                hashSet.add(Long.valueOf(jEV));
                arrayList.add(adTemplate);
            }
        }
        return arrayList;
    }

    static class a implements Comparator<AdTemplate> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }

        private static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int iEZ = com.kwad.sdk.core.response.b.e.eZ(adTemplate2) - com.kwad.sdk.core.response.b.e.eZ(adTemplate);
            if (iEZ != 0) {
                return iEZ;
            }
            if (adTemplate.fromCache && adTemplate2.fromCache) {
                return 0;
            }
            return adTemplate.fromCache ? 1 : -1;
        }
    }
}
