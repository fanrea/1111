package com.kwad.components.ad.reward.h;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static long wE = -1;
    public static int wF;

    private static boolean j(long j) {
        return ij() > 0 && j > 0 && ij() / 2460601000L == j / 2460601000L;
    }

    public static void J(Context context) {
        b bVar = new b();
        if (j(System.currentTimeMillis())) {
            wF++;
        } else {
            wF = 1;
        }
        wE = System.currentTimeMillis();
        bVar.wG = wF;
        bVar.lt = wE;
        ag.at(context, bVar.toJson().toString());
    }

    private static long ij() {
        long j = wE;
        if (j != -1) {
            return j;
        }
        String strAoz = ag.aoz();
        if (TextUtils.isEmpty(strAoz)) {
            return 0L;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strAoz));
            wE = bVar.lt;
            wF = bVar.wG;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return wE;
    }

    public static int dT() {
        if (!j(System.currentTimeMillis())) {
            wF = 0;
        }
        return wF;
    }
}
