package com.kwad.components.ct.home.b;

import com.kwad.components.ct.response.model.CtAdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class g {
    private static long aJu;
    private static List<CtAdTemplate> aJv = new ArrayList();

    public static boolean Gz() {
        if (System.currentTimeMillis() - aJu <= 120000) {
            return !aJv.isEmpty();
        }
        GB();
        return false;
    }

    public static List<CtAdTemplate> GA() {
        return aJv;
    }

    public static void GB() {
        aJv.clear();
    }

    public static void F(List<CtAdTemplate> list) {
        GB();
        aJu = System.currentTimeMillis();
        aJv.addAll(list);
    }
}
