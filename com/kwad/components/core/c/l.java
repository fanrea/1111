package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bh;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class l implements c {
    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyLocalCacheFirst";
    }

    @Override // com.kwad.components.core.c.c
    public final void d(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.ach().submit(new bh() { // from class: com.kwad.components.core.c.l.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() throws Throwable {
                AdResultData adResultDataE = l.e(aVar);
                if (adResultDataE != null && !adResultDataE.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, adResultDataE, true);
                } else {
                    n.a(aVar, new j(aVar));
                }
            }
        });
    }

    public static AdResultData e(com.kwad.components.core.request.model.a aVar) throws Throwable {
        a aVarOh = a.oh();
        if (aVarOh == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<h> listA = aVarOh.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, e.x(aVar.getPosId()).oq());
        if (com.kwad.sdk.core.config.e.YJ()) {
            n(listA);
        }
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        Collections.sort(listA);
        return h.m(listA.subList(0, Math.min(listA.size(), adNum)));
    }

    private static void n(List<h> list) {
        if (list == null) {
            return;
        }
        Iterator<h> it = list.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (g.ou().a(next)) {
                com.kwad.sdk.core.d.c.d("StrategyLocalCacheFirst", "filterByMemCached contain: " + next.oA());
                it.remove();
            }
        }
    }
}
