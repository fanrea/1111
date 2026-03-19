package com.kwad.components.ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i {
    private Map<String, List<AdTemplate>> uP;

    /* synthetic */ i(byte b) {
        this();
    }

    private i() {
        this.uP = new ConcurrentHashMap();
    }

    static class a {
        private static final i uQ = new i(0);
    }

    public static i hw() {
        return a.uQ;
    }

    public final void J(String str) {
        this.uP.remove(str);
    }
}
