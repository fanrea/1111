package com.kwad.sdk.core.report;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class p extends c {
    public static int Pl = 1;
    private static String bFV = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public p(Context context, int i) {
        super(context, "ksadrep.db", i, bFV);
    }
}
