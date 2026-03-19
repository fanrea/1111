package com.tachikoma.core;

import com.tk.core.bridge.e;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c implements com.tk.core.manager.a.d {
    private final ConcurrentHashMap<String, com.tk.core.manager.a.a<?>> AI = new ConcurrentHashMap<>(5);

    @Override // com.tk.core.manager.b
    public final void ae() {
        this.AI.put("console", new com.tk.core.o.d());
        this.AI.put("Keyboard", new com.tk.core.g.b());
        this.AI.put("Tachikoma", new e());
    }

    @Override // com.tk.core.manager.b
    public final ConcurrentHashMap<String, com.tk.core.manager.a.a<?>> hJ() {
        return this.AI;
    }
}
