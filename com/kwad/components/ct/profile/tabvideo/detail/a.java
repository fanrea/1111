package com.kwad.components.ct.profile.tabvideo.detail;

import com.kwad.components.ct.response.model.CtAdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    private static List<CtAdTemplate> aRR;
    private static volatile a aRS;

    private a() {
    }

    public static a Jn() {
        if (aRS == null) {
            synchronized (a.class) {
                if (aRS == null) {
                    aRS = new a();
                }
            }
        }
        return aRS;
    }

    public static List<CtAdTemplate> Jo() {
        return aRR;
    }

    public static void L(List<CtAdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (aRR == null) {
            aRR = new ArrayList();
        }
        aRR.clear();
        aRR.addAll(list);
    }

    public static void wZ() {
        List<CtAdTemplate> list = aRR;
        if (list != null) {
            list.clear();
        }
        aRR = null;
    }
}
