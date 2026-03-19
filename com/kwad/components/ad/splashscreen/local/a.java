package com.kwad.components.ad.splashscreen.local;

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
    public long lt = 0;
    public int lu = 0;

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

    public static void V(Context context) {
        String strAoA = ag.aoA();
        a aVar = new a();
        if (TextUtils.isEmpty(strAoA)) {
            aVar.lu = 1;
            aVar.lt = System.currentTimeMillis();
            ag.au(context, aVar.toJson().toString());
            return;
        }
        try {
            aVar.parseJson(new JSONObject(strAoA));
            if (b(aVar.lt, System.currentTimeMillis())) {
                aVar.lu++;
            } else {
                aVar.lu = 1;
            }
            aVar.lt = System.currentTimeMillis();
            ag.au(context, aVar.toJson().toString());
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }
}
