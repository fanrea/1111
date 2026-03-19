package com.bytedance.adsdk.ugeno.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.b.tt;
import com.bytedance.adsdk.ugeno.hc.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class e {
    private de an;
    private com.bytedance.adsdk.ugeno.hc.b<View> b;
    private tc c;
    private boolean cb;
    private Context d;
    private mk de;
    private com.bytedance.adsdk.ugeno.u.d.d e;
    private rf gb;
    private jh h;
    private JSONObject hc;
    private float jh;
    private k mk;
    private JSONObject mq;
    private an rf;
    private float sy;
    private String tc;
    private tt tt;
    private yo u;
    private List<String> w;
    private gb yo;
    private boolean uo = true;
    private boolean k = false;

    public e(Context context) {
        this.d = context;
    }

    public void d(String str, k kVar) {
        this.mk = kVar;
        this.tc = str;
        if (kVar != null) {
            this.hc = kVar.d();
        }
    }

    public com.bytedance.adsdk.ugeno.hc.b<View> d(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) throws JSONException {
        this.hc = jSONObject2;
        de deVar = this.an;
        if (deVar != null) {
            deVar.d();
        }
        tt ttVar = new tt(jSONObject, jSONObject2, jSONObject3);
        this.tt = ttVar;
        ttVar.d(this.jh, this.sy);
        this.e = new com.bytedance.adsdk.ugeno.u.d.d();
        yo yoVar = this.u;
        if (yoVar instanceof com.bytedance.adsdk.ugeno.b.d.hc) {
            ((com.bytedance.adsdk.ugeno.b.d.hc) yoVar).d(this.tt.hc());
        }
        this.b = d(this.tt.d(), (com.bytedance.adsdk.ugeno.hc.b<View>) null);
        mk mkVar = this.de;
        if (mkVar != null) {
            mkVar.hc();
            if (this.de.b()) {
                this.de.d(this.gb);
            }
            this.de.d(this.an);
        }
        de deVar2 = this.an;
        if (deVar2 != null) {
            deVar2.hc();
            this.b.d(this.an);
            this.an.b();
        }
        hc(this.b);
        if (this.an != null) {
            sy syVar = new sy();
            syVar.d(0);
            syVar.d(this.b);
            this.an.d(syVar);
        }
        return this.b;
    }

    public com.bytedance.adsdk.ugeno.hc.b<View> d(tt.d dVar, com.bytedance.adsdk.ugeno.hc.b<View> bVar) {
        List<tt.d> listB;
        d.C0176d c0176dGb = null;
        if (!tt.c(dVar)) {
            return null;
        }
        gb gbVar = this.yo;
        if (gbVar != null) {
            gbVar.d(dVar);
        }
        String strB = dVar.b();
        hc hcVarD = c.d(strB);
        hc hcVar = hcVarD;
        if (hcVarD == null) {
            this.cb = true;
            if (this.w == null) {
                this.w = new ArrayList();
            }
            this.w.add(strB);
            dVar.d("View");
            hc hcVarD2 = c.d("View");
            if (hcVarD2 == null) {
                return null;
            }
            strB = "View";
            hcVar = hcVarD2;
        }
        com.bytedance.adsdk.ugeno.hc.b bVarD = hcVar.d(this.d);
        if (bVarD == null) {
            return null;
        }
        JSONObject jSONObjectC = dVar.c();
        bVarD.h(com.bytedance.adsdk.ugeno.c.hc.d(dVar.d(), this.hc));
        bVarD.gb(strB);
        bVarD.b(jSONObjectC);
        bVarD.d(dVar);
        bVarD.hc(this.hc);
        tt ttVar = this.tt;
        if (ttVar == null) {
            bVarD.b(true);
        } else {
            bVarD.b(ttVar.c());
        }
        bVarD.d(this.mk);
        bVarD.d(this.e);
        Iterator<String> itKeys = jSONObjectC.keys();
        if (bVar instanceof com.bytedance.adsdk.ugeno.hc.d) {
            com.bytedance.adsdk.ugeno.hc.d dVar2 = (com.bytedance.adsdk.ugeno.hc.d) bVar;
            c0176dGb = dVar2.gb();
            bVarD.d(dVar2);
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strD = com.bytedance.adsdk.ugeno.c.hc.d(jSONObjectC.optString(next), this.hc);
            bVarD.d(next, strD);
            mk mkVar = this.de;
            if (mkVar != null) {
                mkVar.d(next, strD);
            }
            if (c0176dGb != null) {
                c0176dGb.d(this.d, next, strD);
            }
        }
        if (c0176dGb != null) {
            bVarD.d(c0176dGb.d());
        }
        if (bVarD instanceof com.bytedance.adsdk.ugeno.hc.d) {
            List<tt.d> listU = dVar.u();
            if (listU == null || listU.size() <= 0) {
                if (TextUtils.equals(bVarD.z(), "RecyclerLayout") && (listB = this.tt.b()) != null && listB.size() > 0) {
                    Iterator<tt.d> it = listB.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.hc.b<View> bVarD2 = d(it.next(), (com.bytedance.adsdk.ugeno.hc.b<View>) bVarD);
                        if (bVarD2 != null && bVarD2.r()) {
                            ((com.bytedance.adsdk.ugeno.hc.d) bVarD).d(bVarD2);
                        }
                    }
                }
                return bVarD;
            }
            if (TextUtils.equals(bVarD.z(), "Swiper") && listU.size() != 1) {
                com.bytedance.sdk.component.utils.mq.c("UGTemplateEngine", "Swiper must be only one widget");
            }
            try {
                Collections.sort(listU, new Comparator<tt.d>() { // from class: com.bytedance.adsdk.ugeno.b.e.1
                    @Override // java.util.Comparator
                    /* renamed from: d, reason: merged with bridge method [inline-methods] */
                    public int compare(tt.d dVar3, tt.d dVar4) {
                        return dVar3.c().optInt("order", 0) - dVar4.c().optInt("order", 0);
                    }
                });
            } catch (Throwable unused) {
            }
            Iterator<tt.d> it2 = listU.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.hc.b<View> bVarD3 = d(it2.next(), (com.bytedance.adsdk.ugeno.hc.b<View>) bVarD);
                if (bVarD3 != null && !bVarD3.l()) {
                    ((com.bytedance.adsdk.ugeno.hc.d) bVarD).d(bVarD3, bVarD3.vv());
                }
            }
        }
        this.b = bVarD;
        return bVarD;
    }

    public com.bytedance.adsdk.ugeno.hc.b<View> d(JSONObject jSONObject) {
        de deVar = this.an;
        if (deVar != null) {
            deVar.d();
        }
        tt ttVar = new tt(jSONObject, this.hc);
        this.tt = ttVar;
        yo yoVar = this.u;
        if (yoVar instanceof com.bytedance.adsdk.ugeno.b.d.hc) {
            ((com.bytedance.adsdk.ugeno.b.d.hc) yoVar).d(ttVar.hc());
        }
        this.b = hc(this.tt.d(), null);
        de deVar2 = this.an;
        if (deVar2 != null) {
            deVar2.hc();
            this.b.d(this.an);
        }
        return this.b;
    }

    public com.bytedance.adsdk.ugeno.hc.b<View> d(tt.d dVar) {
        com.bytedance.adsdk.ugeno.hc.b<View> bVarHc = hc(dVar, null);
        this.b = bVarHc;
        return bVarHc;
    }

    public com.bytedance.adsdk.ugeno.hc.b<View> hc(tt.d dVar, com.bytedance.adsdk.ugeno.hc.b<View> bVar) {
        List<tt.d> listB;
        d.C0176d c0176dGb = null;
        if (!tt.c(dVar)) {
            return null;
        }
        gb gbVar = this.yo;
        if (gbVar != null) {
            gbVar.hc(dVar);
        }
        String strB = dVar.b();
        hc hcVarD = c.d(strB);
        if (hcVarD == null) {
            this.cb = true;
            if (this.w == null) {
                this.w = new ArrayList();
            }
            this.w.add(strB);
            return null;
        }
        com.bytedance.adsdk.ugeno.hc.b bVarD = hcVarD.d(this.d);
        if (bVarD == null) {
            return null;
        }
        bVarD.h(com.bytedance.adsdk.ugeno.c.hc.d(dVar.d(), this.hc));
        bVarD.gb(strB);
        bVarD.b(dVar.c());
        bVarD.d(dVar);
        bVarD.d(this.mk);
        if (bVar instanceof com.bytedance.adsdk.ugeno.hc.d) {
            com.bytedance.adsdk.ugeno.hc.d dVar2 = (com.bytedance.adsdk.ugeno.hc.d) bVar;
            bVarD.d(dVar2);
            c0176dGb = dVar2.gb();
        }
        Iterator<String> itKeys = dVar.c().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strD = com.bytedance.adsdk.ugeno.c.hc.d(dVar.c().optString(next), this.hc);
            bVarD.d(next, strD);
            if (c0176dGb != null) {
                c0176dGb.d(this.d, next, strD);
            }
        }
        if (bVarD instanceof com.bytedance.adsdk.ugeno.hc.d) {
            List<tt.d> listU = dVar.u();
            if (listU == null || listU.size() <= 0) {
                if (TextUtils.equals(bVarD.z(), "RecyclerLayout") && (listB = this.tt.b()) != null && listB.size() > 0) {
                    Iterator<tt.d> it = listB.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.hc.b<View> bVarHc = hc(it.next(), bVarD);
                        if (bVarHc != null && bVarHc.r()) {
                            ((com.bytedance.adsdk.ugeno.hc.d) bVarD).d(bVarHc);
                        }
                    }
                }
                return bVarD;
            }
            if (TextUtils.equals(bVarD.z(), "Swiper") && listU.size() != 1) {
                com.bytedance.sdk.component.utils.mq.c("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<tt.d> it2 = listU.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.hc.b<View> bVarHc2 = hc(it2.next(), bVarD);
                if (bVarHc2 != null && bVarHc2.r()) {
                    ((com.bytedance.adsdk.ugeno.hc.d) bVarD).d(bVarHc2);
                }
            }
        }
        if (c0176dGb != null) {
            bVarD.d(c0176dGb.d());
        }
        this.b = bVarD;
        return bVarD;
    }

    public void d(com.bytedance.adsdk.ugeno.hc.b bVar) {
        List<com.bytedance.adsdk.ugeno.hc.b<View>> listH;
        if (bVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.hc.d dVarS = bVar.s();
        if (dVarS != null) {
            d.C0176d c0176dGb = dVarS.gb();
            Iterator<String> itKeys = bVar.np().keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strD = com.bytedance.adsdk.ugeno.c.hc.d(bVar.np().optString(next), this.hc);
                bVar.d(next, strD);
                c0176dGb.d(this.d, next, strD);
            }
            bVar.d(c0176dGb.d());
        }
        if (!(bVar instanceof com.bytedance.adsdk.ugeno.hc.d) || (listH = ((com.bytedance.adsdk.ugeno.hc.d) bVar).h()) == null || listH.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.hc.b<View>> it = listH.iterator();
        while (it.hasNext()) {
            d(it.next());
        }
    }

    public void hc(JSONObject jSONObject) throws JSONException {
        de deVar = this.an;
        if (deVar != null) {
            deVar.b();
        }
        this.hc = jSONObject;
        d(this.b, jSONObject);
        hc(this.b);
        if (this.an != null) {
            sy syVar = new sy();
            syVar.d(0);
            syVar.d(this.b);
            this.an.d(syVar);
        }
    }

    public void d(com.bytedance.adsdk.ugeno.hc.b bVar, JSONObject jSONObject) throws JSONException {
        if (bVar == null) {
            return;
        }
        if (bVar instanceof com.bytedance.adsdk.ugeno.hc.d) {
            bVar.d(jSONObject);
            List<com.bytedance.adsdk.ugeno.hc.b<View>> listH = ((com.bytedance.adsdk.ugeno.hc.d) bVar).h();
            if (listH == null || listH.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.hc.b<View>> it = listH.iterator();
            while (it.hasNext()) {
                d(it.next(), jSONObject);
            }
            return;
        }
        bVar.d(jSONObject);
    }

    private void hc(com.bytedance.adsdk.ugeno.hc.b<View> bVar) throws JSONException {
        List<com.bytedance.adsdk.ugeno.hc.b<View>> listH;
        if (bVar == null) {
            return;
        }
        JSONObject jSONObjectNp = bVar.np();
        Iterator<String> itKeys = jSONObjectNp.keys();
        com.bytedance.adsdk.ugeno.hc.d dVarS = bVar.s();
        d.C0176d c0176dGb = dVarS != null ? dVarS.gb() : null;
        b(bVar);
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strD = com.bytedance.adsdk.ugeno.c.hc.d(jSONObjectNp.optString(next), this.hc);
            bVar.d(next, strD);
            if (c0176dGb != null) {
                c0176dGb.d(this.d, next, strD);
            }
        }
        bVar.d(this.c);
        bVar.d(this.u);
        bVar.d(this.h);
        mk mkVar = this.de;
        if (mkVar != null) {
            bVar.d(mkVar);
        }
        an anVar = this.rf;
        if (anVar != null) {
            bVar.d(anVar);
        }
        if ((bVar instanceof com.bytedance.adsdk.ugeno.hc.d) && (listH = ((com.bytedance.adsdk.ugeno.hc.d) bVar).h()) != null && listH.size() > 0) {
            Iterator<com.bytedance.adsdk.ugeno.hc.b<View>> it = listH.iterator();
            while (it.hasNext()) {
                hc(it.next());
            }
        }
        if (c0176dGb != null) {
            bVar.d(c0176dGb.d());
        }
        bVar.hc();
    }

    private void b(com.bytedance.adsdk.ugeno.hc.b bVar) throws JSONException {
        try {
            if (!bVar.j() || bVar.zw() == null || bVar.zw().an() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i18n", bVar.zw().an());
            this.hc.put("xNode", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void d(tc tcVar) {
        this.c = tcVar;
    }

    public void d(yo yoVar) {
        com.bytedance.adsdk.ugeno.b.d.d dVarU = com.bytedance.adsdk.ugeno.c.d().u();
        if (dVarU == null) {
            this.u = yoVar;
            return;
        }
        com.bytedance.adsdk.ugeno.b.d.hc hcVarD = dVarU.d(yoVar);
        if (hcVarD == null) {
            this.u = yoVar;
            return;
        }
        hcVarD.d(this.mq);
        hcVarD.d(this.uo);
        hcVarD.hc(this.k);
        tt ttVar = this.tt;
        if (ttVar != null) {
            hcVarD.d(ttVar.hc());
        }
        this.u = hcVarD;
    }

    public void d(jh jhVar) {
        this.h = jhVar;
    }

    public void d(com.bytedance.adsdk.ugeno.hc.b bVar, String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.hc.b<View>> listH;
        if (bVar == null) {
            return;
        }
        bVar.d(str, objArr);
        if (!(bVar instanceof com.bytedance.adsdk.ugeno.hc.d) || (listH = ((com.bytedance.adsdk.ugeno.hc.d) bVar).h()) == null || listH.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.hc.b<View>> it = listH.iterator();
        while (it.hasNext()) {
            d(it.next(), str, objArr);
        }
    }

    public boolean d() {
        return this.cb;
    }

    public List<String> hc() {
        return this.w;
    }

    public void d(gb gbVar) {
        this.yo = gbVar;
    }
}
