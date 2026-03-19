package com.kwad.components.core.p.a.e.a;

import com.kwad.sdk.core.response.model.AdResultData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private static final Map<Integer, WeakReference<AdResultData>> Tl = new HashMap();

    public static void a(int i, AdResultData adResultData) {
        if (adResultData == null) {
            return;
        }
        Tl.put(Integer.valueOf(i), new WeakReference<>(adResultData));
    }

    public static AdResultData aO(int i) {
        WeakReference<AdResultData> weakReference = Tl.get(Integer.valueOf(i));
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return weakReference.get();
    }
}
