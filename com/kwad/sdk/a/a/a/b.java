package com.kwad.sdk.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static int aiV = 0;
    public static long wE = -1;

    private static boolean j(long j) {
        return ij() > 0 && j > 0 && ij() / 2460601000L == j / 2460601000L;
    }

    public static void J(Context context) {
        a aVar = new a();
        if (j(System.currentTimeMillis())) {
            aiV++;
        } else {
            aiV = 1;
        }
        wE = System.currentTimeMillis();
        aVar.aiV = aiV;
        aVar.lt = wE;
        ag.aC(context, aVar.toJson().toString());
    }

    private static long ij() {
        long j = wE;
        if (j != -1) {
            return j;
        }
        String strAoL = ag.aoL();
        if (TextUtils.isEmpty(strAoL)) {
            return 0L;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(strAoL));
            wE = aVar.lt;
            aiV = aVar.aiV;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return wE;
    }

    public static int dT() {
        if (!j(System.currentTimeMillis())) {
            aiV = 0;
        }
        return aiV;
    }
}
