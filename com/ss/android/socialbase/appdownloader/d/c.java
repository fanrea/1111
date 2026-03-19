package com.ss.android.socialbase.appdownloader.d;

import android.content.Context;
import android.text.TextUtils;
import io.reactivex.annotations.SchedulerSupport;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    public static d d(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null || context == null || jSONObject == null) {
            return null;
        }
        String strMk = bVar.mk();
        if (TextUtils.isEmpty(strMk) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(strMk);
        com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(bVar);
        if (str.equals(com.alipay.sdk.m.x.c.c)) {
            return new tc(context, dVarD, bVar.k());
        }
        if (str.equals(com.alipay.sdk.m.x.c.d)) {
            return new mk(context, dVarD, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new mq(context, dVarD, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new h(context, dVarD, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new gb(context, dVarD, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String strK = bVar.k("file_content_uri");
            if (TextUtils.isEmpty(strK)) {
                return null;
            }
            return new tt(context, dVarD, file.getAbsolutePath(), strK, bVar.gb());
        }
        if (str.equals(SchedulerSupport.CUSTOM)) {
            return new b(context, dVarD, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new uo(context, dVarD, com.ss.android.socialbase.appdownloader.b.d(bVar.h(), com.ss.android.socialbase.downloader.downloader.h.hc(context).mq(bVar.h()), context, com.ss.android.socialbase.appdownloader.c.mk().u(), new File(bVar.mk() + File.separator + bVar.gb())).toString());
    }

    public static boolean d(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.uo.d dVar) {
        if (context != null && str != null) {
            d uoVar = null;
            String strHc = com.ss.android.socialbase.appdownloader.b.hc();
            if (!TextUtils.isEmpty(strHc) && !TextUtils.isEmpty(str)) {
                if (com.ss.android.socialbase.appdownloader.an.u.c() && str.equals(com.alipay.sdk.m.x.c.c)) {
                    uoVar = new tc(context, dVar, strHc);
                } else if (com.ss.android.socialbase.appdownloader.an.u.c() && str.equals(com.alipay.sdk.m.x.c.d)) {
                    uoVar = new mk(context, dVar, strHc);
                } else if (com.ss.android.socialbase.appdownloader.an.u.c() && str.equals("v3")) {
                    uoVar = new mq(context, dVar, strHc);
                } else if (com.ss.android.socialbase.appdownloader.an.u.u() && str.equals("o1")) {
                    uoVar = new h(context, dVar, strHc);
                } else if (com.ss.android.socialbase.appdownloader.an.u.u() && str.equals("o2")) {
                    uoVar = new gb(context, dVar, strHc);
                } else if (com.ss.android.socialbase.appdownloader.an.u.u() && str.equals("o3")) {
                    uoVar = new tt(context, dVar, strHc, strHc, strHc);
                } else if (com.ss.android.socialbase.appdownloader.an.u.c() && str.equals(SchedulerSupport.CUSTOM)) {
                    uoVar = new b(context, dVar, strHc, jSONObject);
                } else if (com.ss.android.socialbase.appdownloader.an.u.c() && str.equals("vbi")) {
                    uoVar = new uo(context, dVar, strHc);
                }
                if (uoVar != null && uoVar.d()) {
                    return true;
                }
            }
        }
        return false;
    }
}
