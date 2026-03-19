package com.tachikoma.core;

import com.tk.core.manager.a.e;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements e {
    private final ConcurrentHashMap<String, com.tk.core.manager.a.a<?>> AI = new ConcurrentHashMap<>(2);

    @Override // com.tk.core.manager.b
    public final void ae() {
        this.AI.put("KDSFeature", new com.tk.core.f.b());
    }

    @Override // com.tk.core.manager.b
    public final ConcurrentHashMap<String, com.tk.core.manager.a.a<?>> hJ() {
        return this.AI;
    }
}
