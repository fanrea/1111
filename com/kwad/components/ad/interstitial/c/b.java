package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import com.pandora.common.utils.Times;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat ls = new SimpleDateFormat(Times.YYYY_MM_DD);
    public long lt = -1;
    public int nN = 0;
    public int nO = 0;

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return ls.format(new Date(j)).equals(ls.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    public static void J(Context context) {
        String strAoy = ag.aoy();
        b bVar = new b();
        if (TextUtils.isEmpty(strAoy)) {
            bVar.nN = 1;
            bVar.lt = System.currentTimeMillis();
            ag.ar(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strAoy));
            if (b(bVar.lt, System.currentTimeMillis())) {
                bVar.nN++;
            } else {
                bVar.nN = 1;
                bVar.nO = 0;
                bVar.lt = System.currentTimeMillis();
            }
            ag.ar(context, bVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    public static void K(Context context) {
        String strAoy = ag.aoy();
        b bVar = new b();
        if (TextUtils.isEmpty(strAoy)) {
            bVar.nO = 1;
            bVar.lt = System.currentTimeMillis();
            ag.ar(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strAoy));
            if (b(bVar.lt, System.currentTimeMillis())) {
                bVar.nO++;
            } else {
                bVar.nO = 1;
                bVar.nN = 0;
                bVar.lt = System.currentTimeMillis();
            }
            ag.ar(context, bVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    public static int dT() {
        String strAoy = ag.aoy();
        if (TextUtils.isEmpty(strAoy)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strAoy));
            return bVar.nN;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return 0;
        }
    }

    public static int dU() {
        String strAoy = ag.aoy();
        if (TextUtils.isEmpty(strAoy)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strAoy));
            return bVar.nO;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return 0;
        }
    }
}
