package com.kwad.sdk.core.videocache.d;

import com.kwad.sdk.core.videocache.n;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements c {
    private HashMap<String, n> bJR = new HashMap<>();

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n gk(String str) {
        if (this.bJR.containsKey(str)) {
            return this.bJR.get(str);
        }
        return null;
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        this.bJR.put(str, nVar);
    }
}
