package com.kwad.framework.tachikoma.gen;

import com.kwad.tachikoma.o.f;
import com.kwad.tachikoma.r.c;
import com.tk.core.manager.a.d;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements d {
    private final ConcurrentHashMap<String, com.tk.core.manager.a.a<?>> AI = new ConcurrentHashMap<>(14);

    @Override // com.tk.core.manager.b
    public final void ae() {
        this.AI.put("KwaiAd", new com.kwad.tachikoma.d());
        this.AI.put("KSAdSensorManager", new c());
        this.AI.put("KSAdNativePendingIntent", new f());
        this.AI.put("KSAdPasteboard", new com.kwad.tachikoma.d.b());
        this.AI.put("KSAdTKApplication", new com.kwad.tachikoma.a.b());
        this.AI.put("KSAdTKNetworkManager", new com.kwad.tachikoma.network.f());
        this.AI.put("KSAdSystemUtil", new com.kwad.tachikoma.s.b());
        this.AI.put("KSAdNativeContext", new com.kwad.tachikoma.e.f());
        this.AI.put("KSAdTKBundleService", new com.kwad.tachikoma.c.c());
        this.AI.put("KSAdFileManager", new com.kwad.a.d());
    }

    @Override // com.tk.core.manager.b
    public final ConcurrentHashMap<String, com.tk.core.manager.a.a<?>> hJ() {
        return this.AI;
    }
}
