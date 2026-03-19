package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class g {
    private static volatile g PC;
    private ConcurrentHashMap<String, WeakReference<Object>> PB = new ConcurrentHashMap<>();

    public static g ou() {
        if (PC == null) {
            synchronized (g.class) {
                if (PC == null) {
                    PC = new g();
                }
            }
        }
        return PC;
    }

    public final boolean a(h hVar) {
        String strB = b(hVar);
        com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains key: " + strB);
        boolean z = false;
        if (!this.PB.containsKey(strB)) {
            return false;
        }
        WeakReference<Object> weakReference = this.PB.get(strB);
        if (weakReference != null && weakReference.get() != null) {
            z = true;
        }
        if (z) {
            com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.PB.put(ax(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }

    public final void aw(AdTemplate adTemplate) {
        this.PB.remove(ax(adTemplate));
    }

    private static String b(h hVar) {
        return hVar.oo() + "-" + hVar.oA();
    }

    private static String ax(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.eI(adTemplate) + "-" + com.kwad.sdk.core.response.b.e.eV(adTemplate);
    }
}
