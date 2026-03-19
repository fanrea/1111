package com.kwad.sdk.i;

import com.kwad.sdk.i.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class m {
    private static final Map<String, k> cfW = new ConcurrentHashMap();
    private static long cfX;

    static synchronized void a(i iVar, boolean z) {
        Map<String, k> map = cfW;
        if (map.size() > 200) {
            j.ar("LogRequestManger", "enqueueAction fail size limit");
        } else {
            k kVarB = b(iVar, z);
            map.put(kVarB.actionId, kVarB);
        }
        alI();
    }

    static void alI() {
        long jCurrentTimeMillis = System.currentTimeMillis() - cfX;
        if (cfW.size() <= 0 || jCurrentTimeMillis <= h.alv().alB()) {
            return;
        }
        cfX = System.currentTimeMillis();
        final List<k> actionList = getActionList();
        new StringBuilder("request size ").append(actionList.size());
        j.alG();
        l.a(actionList, new l.a() { // from class: com.kwad.sdk.i.m.1
            @Override // com.kwad.sdk.i.l.a
            public final void onSuccess() {
                j.alG();
                m.ak(actionList);
            }
        });
    }

    private static synchronized List<k> getActionList() {
        ArrayList arrayList;
        Map<String, k> map = cfW;
        arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, k>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void ak(List<k> list) {
        if (list != null) {
            Iterator<k> it = list.iterator();
            while (it.hasNext()) {
                cfW.remove(it.next().actionId);
            }
        }
    }

    private static k b(i iVar, boolean z) {
        c.a aVarArz;
        if (z) {
            aVarArz = c.a.ary();
        } else {
            aVarArz = c.a.arz();
        }
        com.kwai.adclient.kscommerciallogger.model.c cVarArA = aVarArz.c(BusinessType.OTHER).b(SubBusinessType.OTHER).jj("ad_sdk_local_log").ji(iVar.cfP).t(iVar.toJson()).arA();
        return new k(cVarArA.ars(), cVarArA.toString(), iVar);
    }
}
