package com.kwad.components.ct.home.config;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static boolean Fw() {
        return e.b(a.aHw);
    }

    public static float Fx() {
        return a.aHU.getValue().floatValue();
    }

    public static int Fy() {
        return a.aHx.getValue().intValue();
    }

    public static int Fz() {
        return a.aHy.getValue().intValue();
    }

    public static int FA() {
        return a.aHz.getValue().intValue();
    }

    public static boolean FB() {
        return a.aHA.getValue().intValue() != 0;
    }

    public static boolean FC() {
        d.g(DevelopMangerComponents.class);
        return a.aHB.getValue().intValue() != 0;
    }

    public static boolean FD() {
        return a.aHC.getValue().intValue() != 0;
    }

    public static boolean FE() {
        return a.aHE.getValue().intValue() != 0;
    }

    public static boolean FF() {
        d.g(DevelopMangerComponents.class);
        return a.aHF.getValue().intValue() != 0;
    }

    public static boolean FG() {
        return a.aHG.getValue().intValue() == 2;
    }

    public static boolean FH() {
        d.g(DevelopMangerComponents.class);
        return a.aHH.getValue().intValue() == 1;
    }

    public static long aa(long j) {
        List<com.kwad.sdk.core.response.model.a> value = com.kwad.components.ct.a.a.amn.getValue();
        if (value != null && !value.isEmpty()) {
            Iterator<com.kwad.sdk.core.response.model.a> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.kwad.sdk.core.response.model.a next = it.next();
                if (next.posId == j) {
                    if (next.bGX > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        return next.bGX;
                    }
                }
            }
        }
        return ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
    }

    public static int ab(long j) {
        for (com.kwad.sdk.core.response.model.a aVar : com.kwad.components.ct.a.a.amn.getValue()) {
            if (aVar != null && aVar.posId == j) {
                return aVar.bGV;
            }
        }
        return 0;
    }

    public static int FI() {
        return a.aHI.getValue().intValue();
    }

    public static boolean FJ() {
        return a.aHI.getValue().intValue() > 0;
    }

    public static boolean FK() {
        return a.aHJ.getValue().intValue() == 0;
    }

    public static boolean FL() {
        return a.aHT.getValue().booleanValue();
    }

    public static long FM() {
        return a.aHS.getValue().longValue();
    }

    public static int FN() {
        return a.aHN.getValue().intValue();
    }

    public static boolean FO() {
        return FP() || FQ();
    }

    public static boolean FP() {
        return a.aHK.getValue().intValue() == 1;
    }

    public static boolean FQ() {
        return a.aHL.getValue().intValue() == 1;
    }

    public static boolean FR() {
        return a.aHM.getValue().intValue() == 1;
    }

    public static int FS() {
        return a.aHO.getValue().intValue();
    }

    public static boolean FT() {
        return e.b(a.aHP);
    }

    public static boolean FU() {
        return e.b(a.aHQ);
    }

    public static boolean FV() {
        return e.b(a.aHR);
    }

    public static boolean FW() {
        return a.aHD.getValue().intValue() == 1;
    }

    public static int ac(long j) {
        for (com.kwad.sdk.core.response.model.a aVar : com.kwad.components.ct.a.a.amn.getValue()) {
            if (aVar != null && aVar.posId == j) {
                return aVar.bGZ;
            }
        }
        return 3;
    }
}
