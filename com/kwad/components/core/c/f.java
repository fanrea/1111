package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f {
    private Map<Integer, AdResultData> Py = new ConcurrentHashMap();
    private AtomicInteger Pz = new AtomicInteger(0);

    static class a {
        static f PA = new f();
    }

    public static f ot() {
        return a.PA;
    }

    public final int l(AdResultData adResultData) {
        if (adResultData == null) {
            return 0;
        }
        int iIncrementAndGet = this.Pz.incrementAndGet();
        this.Py.put(Integer.valueOf(iIncrementAndGet), adResultData);
        return iIncrementAndGet;
    }

    public final AdResultData d(int i, boolean z) {
        AdResultData adResultData = this.Py.get(Integer.valueOf(i));
        this.Py.remove(Integer.valueOf(i));
        return adResultData;
    }
}
