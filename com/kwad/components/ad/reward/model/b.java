package com.kwad.components.ad.reward.model;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.ag;
import com.pandora.common.utils.Times;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static SimpleDateFormat ls = new SimpleDateFormat(Times.YYYY_MM_DD);
    public long nP = -1;
    public int nQ = 0;

    public static void L(Context context) {
        String strAoB = ag.aoB();
        b bVar = new b();
        if (TextUtils.isEmpty(strAoB)) {
            bVar.nQ = 1;
            bVar.nP = System.currentTimeMillis();
            ag.av(context, bVar.toJson().toString());
            return;
        }
        try {
            bVar.parseJson(new JSONObject(strAoB));
            if (b(bVar.nP, System.currentTimeMillis())) {
                bVar.nQ++;
            } else {
                bVar.nQ = 1;
                bVar.nP = System.currentTimeMillis();
            }
            ag.av(context, bVar.toJson().toString());
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public static int dV() {
        String strAoB = ag.aoB();
        if (TextUtils.isEmpty(strAoB)) {
            return 0;
        }
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(strAoB));
            if (b(bVar.nP, System.currentTimeMillis())) {
                return bVar.nQ;
            }
            return 0;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return 0;
        }
    }

    private static boolean b(long j, long j2) {
        if (j > 0 && j2 > 0) {
            try {
                return ls.format(new Date(j)).equals(ls.format(new Date(j2)));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return false;
    }
}
