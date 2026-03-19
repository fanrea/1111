package com.kwad.components.ct.detail;

import android.util.LruCache;
import com.kwad.components.ct.response.model.CtAdTemplate;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d {
    private static volatile d aoK;
    private LruCache<Long, CtAdTemplate> aoL;
    private int maxSize = 6;

    private d() {
    }

    public static d yk() {
        if (aoK == null) {
            synchronized (d.class) {
                if (aoK == null) {
                    aoK = new d();
                }
            }
        }
        return aoK;
    }

    public final void a(long j, CtAdTemplate ctAdTemplate) {
        if (ctAdTemplate == null) {
            return;
        }
        if (this.aoL == null) {
            this.aoL = new LruCache<>(this.maxSize);
        }
        this.aoL.put(Long.valueOf(j), ctAdTemplate);
    }

    public final CtAdTemplate U(long j) {
        LruCache<Long, CtAdTemplate> lruCache = this.aoL;
        if (lruCache != null) {
            return lruCache.get(Long.valueOf(j));
        }
        return null;
    }
}
