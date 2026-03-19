package com.kwad.components.ad.interstitial.d;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ag;
import com.pandora.common.utils.Times;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat ls = new SimpleDateFormat(Times.YYYY_MM_DD);
    public long nP = -1;
    public int nQ = 0;

    public static void L(Context context) {
        String strAoC = ag.aoC();
        a aVar = new a();
        if (TextUtils.isEmpty(strAoC)) {
            aVar.nQ = 1;
            aVar.nP = System.currentTimeMillis();
            ag.aw(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(strAoC));
            if (b(aVar.nP, System.currentTimeMillis())) {
                aVar.nQ++;
            } else {
                aVar.nQ = 1;
                aVar.nP = System.currentTimeMillis();
            }
            ag.aw(context, aVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTrace(e);
        }
    }

    public static int dV() {
        String strAoC = ag.aoC();
        if (TextUtils.isEmpty(strAoC)) {
            return 0;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(strAoC));
            if (b(aVar.nP, System.currentTimeMillis())) {
                return aVar.nQ;
            }
            return 0;
        } catch (Exception e) {
            c.printStackTrace(e);
            return 0;
        }
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return ls.format(new Date(j)).equals(ls.format(new Date(j2)));
            } catch (Exception e) {
                c.printStackTrace(e);
            }
        }
        return false;
    }
}
