package com.tachikoma.component;

import com.tk.core.manager.a.d;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c implements d {
    private final ConcurrentHashMap<String, com.tk.core.manager.a.a<?>> AI = new ConcurrentHashMap<>(3);

    @Override // com.tk.core.manager.b
    public final void ae() {
        this.AI.put("LocalStorage", new com.tk.component.e.b());
        this.AI.put("Toast", new com.tk.component.f.b());
    }

    @Override // com.tk.core.manager.b
    public final ConcurrentHashMap<String, com.tk.core.manager.a.a<?>> hJ() {
        return this.AI;
    }
}
