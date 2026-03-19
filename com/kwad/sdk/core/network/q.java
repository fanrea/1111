package com.kwad.sdk.core.network;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class q {
    private static volatile q bDt;
    private final Map<String, String> aVl = new ConcurrentHashMap();

    private q() {
    }

    public static q aas() {
        if (bDt == null) {
            synchronized (q.class) {
                if (bDt == null) {
                    bDt = new q();
                }
            }
        }
        return bDt;
    }

    public final void ab(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.aVl.put(str, str2);
    }

    public final String fp(String str) {
        return this.aVl.get(str);
    }
}
