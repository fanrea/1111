package com.kwad.sdk.core.request.model;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.components.h;
import com.kwad.sdk.components.p;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.s;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static boolean bGg;
    private static JSONArray bGh;
    public String NF;
    public String NG;
    public String NH;
    public String NI;
    public String NJ;
    public int Sj;
    public int Sk;
    public int afa;
    public int afc;
    public String bAx;
    public String bAy;
    public String bGA;

    @Deprecated
    public String bGC;
    public String bGD;
    public int bGE;
    public String bGi;
    public String bGj;
    public String bGk;
    public String bGl;
    public String bGm;
    public int bGn;
    public int bGo;
    public String bGp;
    public String bGq;
    public int bGr;
    public String bGs;
    public String bGt;
    public JSONArray bGu;
    public String bGv;
    public String bGw;
    public String bGy;
    public String bGz;
    public String language;
    public String uaid;
    public int bGx = 0;
    public long bGB = 0;

    public static b cx(boolean z) {
        return k(false, 0);
    }

    public static b abC() {
        b bVar = new b();
        try {
            bVar.bAy = be.getOaid();
            bVar.NJ = be.getDeviceId();
            bVar.NF = bs.apY();
            bVar.afa = 1;
            bVar.afc = bs.aql();
            bVar.NH = bs.getOsVersion();
            bVar.bGt = ag.aoE();
            if (ag.aoH()) {
                bVar.bGv = ag.aoG();
            }
            if (ag.aoI() && !TextUtils.isEmpty(ag.aoF())) {
                bVar.uaid = ag.aoF();
            }
            h hVar = (h) com.kwad.sdk.components.d.g(h.class);
            if (hVar != null) {
                bVar.bGs = hVar.qm();
            }
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
                bVar.bAx = be.eg(ServiceProvider.anu());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    public static b k(boolean z, int i) {
        b bVar = new b();
        try {
            Context contextAnu = ServiceProvider.anu();
            bVar.bAx = be.eg(contextAnu);
            bVar.bGi = be.ej(contextAnu);
            bVar.bGj = be.ek(contextAnu);
            bVar.bGk = bs.eM(contextAnu);
            bVar.bAy = be.getOaid();
            bVar.NF = bs.apY();
            bVar.NG = bs.aqa();
            bVar.afa = 1;
            bVar.afc = bs.aql();
            bVar.NH = bs.getOsVersion();
            bVar.language = m.getLanguage();
            bVar.Sj = m.getScreenHeight(contextAnu);
            bVar.Sk = m.getScreenWidth(contextAnu);
            bVar.bGn = m.dg(contextAnu);
            bVar.bGo = m.dh(contextAnu);
            bVar.bGp = be.eh(contextAnu);
            if (z) {
                bVar.bGu = bV(contextAnu);
            }
            bVar.bGE = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).UG();
            bVar.bGw = bs.aqk();
            if (ag.aoH()) {
                bVar.bGv = ag.aoG();
            }
            if (ag.aoI() && !TextUtils.isEmpty(ag.aoF())) {
                bVar.uaid = ag.aoF();
            }
            bVar.NJ = be.getDeviceId();
            bVar.bGB = bs.apZ();
            bVar.bGq = bs.aqi();
            bVar.bGt = ag.aoE();
            h hVar = (h) com.kwad.sdk.components.d.g(h.class);
            if (hVar != null) {
                bVar.bGs = hVar.qm();
            }
            bVar.bGr = bs.aqj();
            try {
                com.kwad.sdk.core.d.c.aa("DeviceInfo", a((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class), bVar, contextAnu));
            } catch (Exception unused) {
            }
            bVar.bGw = bs.aqk();
            bVar.bGx = i;
            if (Ui() && com.kwad.sdk.app.b.Wd() != null) {
                bVar.bGy = com.kwad.sdk.app.b.Wd().getVersion(contextAnu, "com.smile.gifmaker");
                bVar.bGz = com.kwad.sdk.app.b.Wd().getVersion(contextAnu, "com.kuaishou.nebula");
                bVar.bGA = com.kwad.sdk.app.b.Wd().getVersion(contextAnu, "com.tencent.mm");
            }
            bVar.NI = bs.aqg();
            bVar.bGm = am.dU(contextAnu);
            bVar.bGD = bs.iU("/data/data");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    private static boolean Ui() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Ui();
    }

    private static boolean Uj() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Uj();
    }

    private static String a(com.kwad.sdk.service.a.f fVar, b bVar, Context context) {
        StringBuilder sbAppend = new StringBuilder("i=").append(fVar.getAppId()).append(",n=").append(fVar.getAppName()).append(",external:").append(fVar.TQ()).append(",v1:").append(fVar.getApiVersion()).append(",v2:4.6.30.1").append(",d:").append(bVar.NJ).append(",dh:");
        String str = bVar.NJ;
        String string = sbAppend.append(str != null ? Integer.valueOf(str.hashCode()) : "").append(",b:215").append(",p:").append(ay.isInMainProcess(context)).append(",dy:").append(com.kwad.framework.a.a.bcG).toString();
        return !Uj() ? string + ",o:" + bVar.bAy : string;
    }

    private static synchronized JSONArray bV(Context context) {
        if (!bGg) {
            bGg = true;
            p pVar = (p) com.kwad.sdk.components.d.g(p.class);
            com.kwad.sdk.core.d.c.d("DeviceInfo", "getAppList: OptDataFetchComponent: " + pVar);
            if (pVar != null && s.aob()) {
                pVar.a(context, new com.kwad.sdk.g.a<JSONArray>() { // from class: com.kwad.sdk.core.request.model.b.1
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(JSONArray jSONArray) {
                        g(jSONArray);
                    }

                    private static void g(JSONArray jSONArray) {
                        JSONArray unused = b.bGh = jSONArray;
                    }
                });
            }
        }
        JSONArray jSONArray = bGh;
        if (jSONArray == null) {
            return null;
        }
        bGh = null;
        return jSONArray;
    }
}
