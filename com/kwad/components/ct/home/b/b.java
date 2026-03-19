package com.kwad.components.ct.home.b;

import android.os.SystemClock;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static b aIV = new b();
    private Map<Long, List<CtAdTemplate>> aIW = new HashMap();

    public static b Gv() {
        return aIV;
    }

    private b() {
    }

    public final synchronized void E(List<CtAdTemplate> list) {
        com.kwad.sdk.core.d.c.d("ContentDataMemCache", "save()");
        HashMap map = new HashMap();
        for (CtAdTemplate ctAdTemplate : list) {
            List arrayList = (List) map.get(Long.valueOf(ctAdTemplate.posId));
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(Long.valueOf(ctAdTemplate.posId), arrayList);
            }
            String url = com.kwad.components.ct.response.a.a.f(ctAdTemplate, com.kwad.components.ct.a.b.xj()).getUrl();
            com.kwad.sdk.core.d.c.d("ContentDataMemCache", "save() getFirstFrameInfo url = " + url);
            com.kwad.components.ct.b.b.i(ServiceProvider.getContext(), url);
            ctAdTemplate.mPreloadData.mCacheTime = SystemClock.elapsedRealtime();
            ctAdTemplate.mPreloadData.isPreload = true;
            arrayList.add(ctAdTemplate);
            com.kwad.sdk.core.d.c.d("ContentDataMemCache", "preload save posId=" + ctAdTemplate.posId);
        }
        this.aIW = map;
    }

    public final synchronized List<CtAdTemplate> ae(long j) {
        List<CtAdTemplate> list;
        Map<Long, List<CtAdTemplate>> map = this.aIW;
        if (map != null) {
            list = map.get(Long.valueOf(j));
            if (com.kwad.components.ct.a.b.xk() && (list == null || list.isEmpty())) {
                Iterator<Long> it = this.aIW.keySet().iterator();
                while (it.hasNext()) {
                    list = this.aIW.get(it.next());
                    if (list != null && !list.isEmpty()) {
                        break;
                    }
                }
            }
        } else {
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (!q((CtAdTemplate) it2.next())) {
                it2.remove();
            }
        }
        return arrayList;
    }

    public final synchronized void af(long j) {
        com.kwad.sdk.core.d.c.d("ContentDataMemCache", "clear() posId=" + j);
        Map<Long, List<CtAdTemplate>> map = this.aIW;
        if (map != null && map.containsKey(Long.valueOf(j))) {
            List<CtAdTemplate> list = this.aIW.get(Long.valueOf(j));
            if (list != null) {
                list.clear();
            }
            this.aIW.remove(Long.valueOf(j));
        }
    }

    public final synchronized void clearAll() {
        com.kwad.sdk.core.d.c.d("ContentDataMemCache", "clearAll()");
        Map<Long, List<CtAdTemplate>> map = this.aIW;
        if (map != null) {
            map.clear();
        }
    }

    public final synchronized boolean ag(long j) {
        List<CtAdTemplate> listAe = ae(j);
        if (listAe == null) {
            return true;
        }
        return listAe.isEmpty();
    }

    private static boolean q(CtAdTemplate ctAdTemplate) {
        return com.kwad.components.ct.response.a.a.as(ctAdTemplate) && ctAdTemplate.mPreloadData.isPreload && SystemClock.elapsedRealtime() - ctAdTemplate.mPreloadData.mCacheTime < com.kwad.components.ct.response.a.c.s((PhotoInfo) com.kwad.components.ct.response.a.a.ay(ctAdTemplate)) - 120000;
    }
}
