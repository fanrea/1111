package com.kwad.components.ct.tube.history.a;

import java.util.TimeZone;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static long Ku() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return jCurrentTimeMillis - ((TimeZone.getDefault().getRawOffset() + jCurrentTimeMillis) % 86400000);
    }
}
