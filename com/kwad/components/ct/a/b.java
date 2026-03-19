package com.kwad.components.ct.a;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    public static boolean xe() {
        return e.b(a.amg);
    }

    public static boolean xf() {
        return e.b(a.amh);
    }

    public static boolean xg() {
        return a.amm.getValue().booleanValue();
    }

    public static boolean wQ() {
        return a.ami.getValue().intValue() == 1;
    }

    public static boolean xh() {
        return a.amf.getValue().intValue() == 2;
    }

    public static boolean T(long j) {
        if (xi()) {
            return true;
        }
        List<com.kwad.sdk.core.response.model.a> value = a.amn.getValue();
        if (value != null && !value.isEmpty()) {
            Iterator<com.kwad.sdk.core.response.model.a> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.kwad.sdk.core.response.model.a next = it.next();
                if (next.posId == j) {
                    if (next.bGY == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean xi() {
        d.g(DevelopMangerComponents.class);
        return false;
    }

    public static boolean xj() {
        return a.amj.getValue().intValue() == 1;
    }

    public static boolean xk() {
        return a.amk.getValue().intValue() == 1;
    }

    public static int xl() {
        d.g(DevelopMangerComponents.class);
        int iIntValue = a.aml.getValue().intValue();
        c.d("CtConfigManager", "getPreloadVideoCache value=" + iIntValue);
        return iIntValue;
    }
}
