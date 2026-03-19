package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i {
    private static SimpleDateFormat bPk = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String bn(long j) {
        return j <= 0 ? "unknown" : bPk.format(new Date(j));
    }
}
