package com.kwad.components.core.q;

import android.content.Context;
import com.kwad.components.core.proxy.a.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    private static boolean YD = false;

    /* renamed from: com.kwad.components.core.q.a$a, reason: collision with other inner class name */
    static final class C0485a {
        private static final a YF = new a();
    }

    protected a() {
    }

    public static a ss() {
        return C0485a.YF;
    }

    public n M(long j) {
        return new n(j);
    }

    public n b(long j, AdTemplate adTemplate) {
        return new n(j, adTemplate);
    }

    public n a(long j, AdTemplate adTemplate, String str) {
        return new n(j, adTemplate, str);
    }

    public final void st() {
        if (YD) {
            return;
        }
        YD = true;
        h.execute(new bh() { // from class: com.kwad.components.core.q.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                n nVarM = a.this.M(8L);
                nVarM.bFE = f.Wp();
                g.a(nVarM);
            }
        });
    }

    public final void az(Context context) {
        n nVarM = M(11L);
        p pVar = (p) d.g(p.class);
        if (pVar != null) {
            JSONArray[] jSONArrayArrB = pVar.b(context, e.Uh());
            nVarM.bEW = jSONArrayArrB[0];
            nVarM.bEX = jSONArrayArrB[1];
            g.a(nVarM);
        }
    }

    public final void f(AdTemplate adTemplate, int i, int i2) {
        n nVarB = b(12006L, adTemplate);
        nVarB.afw = i;
        nVarB.bws = i2;
        g.a(nVarB);
    }

    public final void a(AdTemplate adTemplate, String str, String str2) {
        n nVarB = b(10003L, adTemplate);
        nVarB.bFd = str;
        nVarB.errorMsg = str2;
        g.a(nVarB);
    }

    public final void g(AdTemplate adTemplate, int i, int i2) {
        n nVarB = b(10002L, adTemplate);
        nVarB.abm();
        if (com.kwad.sdk.core.response.b.e.eH(adTemplate)) {
            nVarB.bFd = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        } else {
            nVarB.bFd = com.kwad.sdk.core.response.b.e.eR(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i);
            jSONObject.put("extra", i2);
            nVarB.errorMsg = jSONObject.toString();
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
        g.a(nVarB);
    }

    public final void b(AdTemplate adTemplate, String str, String str2) {
        n nVarB = b(10005L, adTemplate);
        if (com.kwad.sdk.core.response.b.e.eH(adTemplate)) {
            nVarB.bFd = com.kwad.sdk.core.response.b.a.L(com.kwad.sdk.core.response.b.e.eP(adTemplate));
        } else {
            nVarB.bFd = com.kwad.sdk.core.response.b.e.eR(adTemplate);
        }
        nVarB.bFd = str;
        nVarB.errorMsg = str2;
        g.a(nVarB);
    }

    public final void aJ(AdTemplate adTemplate) {
        g.a(b(10007L, adTemplate));
    }

    public final void c(JSONArray jSONArray) {
        n nVarM = M(10200L);
        nVarM.bFi = jSONArray;
        g.a(nVarM);
    }

    public final void e(JSONObject jSONObject, int i) {
        n nVarM = M(10201L);
        aa.putValue(jSONObject, "appChangeType", i);
        nVarM.bFh = jSONObject;
        g.a(nVarM);
    }

    public final void su() {
        g.a(M(10101L));
    }

    public final void aY(int i) {
        n nVarM = M(10104L);
        nVarM.bFe = i;
        g.a(nVarM);
    }

    public final void a(int i, AdTemplate adTemplate, String str) {
        g.a(a(i, adTemplate, str));
    }

    public final void sv() {
        g.a(M(10106L));
    }

    public final void aZ(int i) {
        n nVarM = M(10107L);
        nVarM.bFf = i;
        g.a(nVarM);
    }

    public final void e(AdTemplate adTemplate, int i) {
        n nVarB = b(10108L, adTemplate);
        nVarB.bFf = i;
        g.a(nVarB);
    }

    public final void f(AdTemplate adTemplate, int i, String str) {
        n nVarB = b(10109L, adTemplate);
        nVarB.bFf = 1;
        nVarB.bFg = str;
        g.a(nVarB);
    }

    public final void a(AdTemplate adTemplate, long j, long j2, int i) {
        n nVarB = b(10203L, adTemplate);
        nVarB.adZ = j;
        nVarB.blockDuration = j2;
        nVarB.bET = i;
        g.a(nVarB);
    }

    public final void h(AdTemplate adTemplate, long j) {
        n nVarB = b(10202L, adTemplate);
        nVarB.bFm = j;
        g.a(nVarB);
    }

    public final void a(boolean z, List<Integer> list) {
        n nVarM = M(10204L);
        nVarM.bFo = z;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            nVarM.bFn = jSONArray;
        }
        g.a(nVarM);
    }

    public final void a(SceneImpl sceneImpl, boolean z, String str) {
        n nVarM = M(10216L);
        nVarM.bFo = z;
        nVarM.bFp = str;
        nVarM.adScene = sceneImpl;
        g.a(nVarM);
    }

    public final void i(AdTemplate adTemplate, long j) {
        n nVarB = b(10206L, adTemplate);
        nVarB.bFC = j;
        g.a(nVarB);
    }

    public final void j(AdTemplate adTemplate, long j) {
        n nVarB = b(10207L, adTemplate);
        nVarB.bFD = j;
        g.a(nVarB);
    }

    public final void aK(AdTemplate adTemplate) {
        g.a(b(10208L, adTemplate));
    }

    public final void aL(AdTemplate adTemplate) {
        g.a(b(10209L, adTemplate));
    }

    public final void g(AdTemplate adTemplate, int i, String str) {
        n nVarB = b(107L, adTemplate);
        nVarB.errorCode = i;
        nVarB.errorMsg = str;
        g.a(nVarB);
    }

    public final void a(AdTemplate adTemplate, long j, int i) {
        n nVarB = b(104L, adTemplate);
        nVarB.clickTime = com.kwad.sdk.utils.n.fn(adTemplate);
        nVarB.bFs = j;
        nVarB.bFt = i;
        g.a(nVarB);
    }

    public final void a(b bVar) {
        n nVarM = M(10215L);
        nVarM.Yt = bVar.Yt;
        nVarM.YA = bVar.YA;
        nVarM.YB = bVar.YB;
        nVarM.YC = bVar.YC;
        g.a(nVarM);
    }

    public final void e(String str, String str2, boolean z) {
        g.a(m(str, str2), z);
    }

    public final n m(String str, String str2) {
        n nVarM = M(12200L);
        nVarM.bFL = str;
        nVarM.bFM = str2;
        return nVarM;
    }

    public final void c(long j, int i) {
        if (e.YH()) {
            n nVarM = M(20000L);
            nVarM.timestamp = System.currentTimeMillis();
            nVarM.bFN = i;
            nVarM.posId = j;
            nVarM.bFO = BuildConfig.VERSION_CODE;
            g.a(nVarM);
        }
    }

    public final void f(AdTemplate adTemplate, int i) {
        if (e.YH()) {
            AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
            n nVarM = M(20000L);
            nVarM.timestamp = System.currentTimeMillis();
            nVarM.bFN = i;
            nVarM.trace = adInfoEP.trace;
            nVarM.bFO = BuildConfig.VERSION_CODE;
            nVarM.posId = com.kwad.sdk.core.response.b.e.eI(adTemplate);
            g.a(nVarM);
        }
    }
}
