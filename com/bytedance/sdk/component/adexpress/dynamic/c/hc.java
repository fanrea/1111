package com.bytedance.sdk.component.adexpress.dynamic.c;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.component.adexpress.hc.uo;
import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private int an;
    private String gb;
    private double h;
    private uo tt;
    private double u;
    public Map<String, b> d = new HashMap();
    public Map<String, b> hc = new HashMap();
    public Map<String, b> b = new HashMap();
    private double c = Math.random();

    public hc(double d2, int i, double d3, String str, uo uoVar) {
        this.u = d2;
        this.an = i;
        this.h = d3;
        this.gb = str;
        this.tt = uoVar;
    }

    public b d(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar, float f, float f2) {
        float f3;
        if (TextUtils.isEmpty(gbVar.tc().hc()) && gbVar.tc().u().ey() == null) {
            return new b(0.0f, 0.0f);
        }
        if (TextUtils.equals(gbVar.tc().getType(), "creative-playable-bait")) {
            return new b(0.0f, 0.0f);
        }
        float fGb = gbVar.gb();
        float fTt = gbVar.tt();
        com.bytedance.sdk.component.adexpress.dynamic.b.an anVarU = gbVar.tc().u();
        String strZw = anVarU.zw();
        String strVv = anVarU.vv();
        float fUo = gbVar.uo();
        float fK = gbVar.k();
        float fE = gbVar.e();
        float fCb = gbVar.cb();
        if (TextUtils.equals(strZw, "fixed")) {
            f = Math.min(fGb, f);
            if (TextUtils.equals(strVv, "auto")) {
                f3 = hc(gbVar, f - fE, f2 - fCb).hc;
                fTt = f3 + fCb;
            }
        } else if (TextUtils.equals(strZw, "auto")) {
            b bVarHc = hc(gbVar, f - fE, f2 - fCb);
            f = bVarHc.d + fE;
            if (TextUtils.equals(strVv, "auto")) {
                f3 = bVarHc.hc;
                fTt = f3 + fCb;
            }
        } else if (!TextUtils.equals(strZw, "flex")) {
            f = fGb;
        } else if (TextUtils.equals(strVv, "auto")) {
            f3 = hc(gbVar, f - fE, f2 - fCb).hc;
            fTt = f3 + fCb;
        }
        if (TextUtils.equals(strVv, "scale")) {
            float fRound = Math.round((f - fUo) / fTt) + fK;
            if (fRound > f2) {
                f = Math.round((f2 - fK) * fTt) + fUo;
            } else {
                f2 = fRound;
            }
        } else if (TextUtils.equals(strVv, "fixed")) {
            f2 = Math.min(fTt + fK, f2);
        } else if (!TextUtils.equals(strVv, "flex")) {
            f2 = fTt;
        }
        b bVar = new b();
        bVar.d = f;
        bVar.hc = f2;
        return bVar;
    }

    public b hc(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar, float f, float f2) {
        b bVar = new b();
        if (gbVar.tc().u() == null) {
            return bVar;
        }
        b bVarU = u(gbVar, f, f2);
        float f3 = bVarU.d;
        float f4 = bVarU.hc;
        bVar.d = Math.min(f3, f);
        bVar.hc = Math.min(f4, f2);
        return bVar;
    }

    private b u(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar, float f, float f2) {
        String str = gbVar.b() + Config.replace + f + Config.replace + f2;
        if (this.b.containsKey(str)) {
            return this.b.get(str);
        }
        b bVarAn = an(gbVar, f, f2);
        this.b.put(str, bVarAn);
        return bVarAn;
    }

    private b an(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar, float f, float f2) {
        com.bytedance.sdk.component.adexpress.dynamic.b.an anVarU = gbVar.tc().u();
        float fYo = anVarU.yo();
        int iFu = anVarU.fu();
        double dL = anVarU.l();
        int i = anVarU.to();
        boolean zNv = anVarU.nv();
        boolean zRa = anVarU.ra();
        int iY = anVarU.y();
        C0262hc c0262hc = new C0262hc();
        c0262hc.d = fYo;
        c0262hc.hc = iFu;
        c0262hc.b = i;
        c0262hc.c = dL;
        c0262hc.u = f;
        return d(gbVar.tc().hc(), c0262hc, zNv, zRa, iY, gbVar);
    }

    private b d(String str, C0262hc c0262hc, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) throws JSONException {
        return mk.d(str, gbVar.tc().getType(), C0262hc.d(c0262hc).toString(), z, z2, i, gbVar, this.u, this.an, this.h, this.gb, this.tt);
    }

    public b b(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar, float f, float f2) {
        if (gbVar == null) {
            return null;
        }
        b bVarD = d(gbVar);
        if (bVarD != null && (bVarD.d != 0.0f || bVarD.hc != 0.0f)) {
            return bVarD;
        }
        b bVarC = c(gbVar, f, f2);
        d(gbVar, bVarC);
        return bVarC;
    }

    public b c(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar, float f, float f2) {
        float fMin;
        b bVar = new b();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            bVar.d = 0.0f;
            bVar.hc = 0.0f;
            return bVar;
        }
        if (gbVar.yo()) {
            return d(gbVar, f, f2);
        }
        float fGb = gbVar.gb();
        float fTt = gbVar.tt();
        float fE = gbVar.e();
        float fCb = gbVar.cb();
        com.bytedance.sdk.component.adexpress.dynamic.b.an anVarU = gbVar.tc().u();
        String strZw = anVarU.zw();
        String strVv = anVarU.vv();
        float fMin2 = ((TextUtils.equals(strZw, "flex") || TextUtils.equals(strZw, "auto")) ? f : Math.min(fGb, f)) - fE;
        if (TextUtils.equals(strVv, "scale")) {
            fMin = Math.round(fMin2 / fTt) + fCb;
            if (fMin > f2) {
                fMin2 = Math.round((f2 - fCb) * fTt);
            }
        } else {
            fMin = (TextUtils.equals(strVv, "auto") || TextUtils.equals(strVv, "flex")) ? f2 : Math.min(fTt, f2);
        }
        float f4 = fMin - fCb;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> listW = gbVar.w();
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> it = listW.iterator();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> it2 = it;
            List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> next = it.next();
            b bVar2 = bVar;
            b bVarHc = hc(next, fMin2, f4);
            if (hc(next)) {
                f3 += 1.0f;
            } else {
                fMax = Math.max(fMax, bVarHc.d);
            }
            float f5 = f3;
            if (gbVar.tc().getType().equals("carousel")) {
                fMax2 = Math.max(gbVar.tt(), bVarHc.hc);
            } else {
                fMax2 += bVarHc.hc;
            }
            bVar = bVar2;
            it = it2;
            f3 = f5;
        }
        b bVar3 = bVar;
        if (TextUtils.equals(strZw, "auto")) {
            if (f3 == listW.size()) {
                fMin2 = f;
            } else {
                for (List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list : listW) {
                    b(list);
                    hc(list, fMax, f4);
                }
                fMin2 = fMax;
            }
        }
        if (TextUtils.equals(strVv, "auto")) {
            if (fMax2 <= f2) {
                f4 = fMax2;
            } else {
                d(listW, fMin2, f4);
            }
        } else if ((TextUtils.equals(strVv, "fixed") || TextUtils.equals(strVv, "flex")) && f4 < fMax2) {
            d(listW, fMin2, f4);
        }
        bVar3.d = Math.min(fMin2 + fE, f);
        bVar3.hc = Math.min(f4 + fCb, f2);
        return bVar3;
    }

    private void d(List<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (d(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list2 : list) {
            d dVar = new d();
            boolean zD = d(list2, !z);
            dVar.d = zD ? 1.0f : hc(list2, f, f2).hc;
            dVar.hc = !zD;
            arrayList.add(dVar);
        }
        List<d> listD = tc.d(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((d) arrayList.get(i)).d != listD.get(i).d) {
                List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list3 = list.get(i);
                b(list3);
                hc(list3, f, listD.get(i).d);
            }
        }
    }

    private boolean hc(List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list) {
        boolean z;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> listW;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.b.gb> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (TextUtils.equals(it.next().tc().u().zw(), "flex")) {
                z = true;
                break;
            }
        }
        if (z) {
            return true;
        }
        while (true) {
            boolean z2 = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar : list) {
                if (TextUtils.equals(gbVar.tc().u().zw(), "auto") && (listW = gbVar.w()) != null) {
                    int i = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list2 : listW) {
                        i++;
                        if (!hc(list2)) {
                            break;
                        }
                        if (i == list2.size()) {
                            z2 = true;
                        }
                    }
                }
            }
            return z2;
        }
    }

    private b hc(List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list, float f, float f2) {
        b bVarD = d(list);
        if (bVarD != null && (bVarD.d != 0.0f || bVarD.hc != 0.0f)) {
            return bVarD;
        }
        b bVarB = b(list, f, f2);
        d(list, bVarB);
        return bVarB;
    }

    private b b(List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list, float f, float f2) {
        float fMax;
        c(list);
        b bVar = new b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.b.an anVarU = gbVar.tc().u();
            if (anVarU.rw() == 1 || anVarU.rw() == 2) {
                arrayList.add(gbVar);
            }
            if (anVarU.rw() != 1 && anVarU.rw() != 2) {
                arrayList2.add(gbVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b((com.bytedance.sdk.component.adexpress.dynamic.b.gb) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return bVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.b.gb> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(b(it2.next(), f, f2).d));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar2 = arrayList2.get(i);
            String strZw = gbVar2.tc().u().zw();
            float fGb = gbVar2.gb();
            boolean zEquals = TextUtils.equals(strZw, "flex");
            if (TextUtils.equals(strZw, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> listW = gbVar2.w();
                if (listW == null || listW.size() <= 0) {
                    zEquals = false;
                } else {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> it3 = listW.iterator();
                    while (it3.hasNext()) {
                        if (hc(it3.next())) {
                            zEquals = true;
                            break;
                        }
                    }
                    zEquals = false;
                }
            }
            d dVar = new d();
            if (!zEquals) {
                fGb = ((Float) arrayList3.get(i)).floatValue();
            }
            dVar.d = fGb;
            dVar.hc = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i)).floatValue();
            }
            dVar.b = fMax;
            arrayList4.add(dVar);
            i++;
        }
        d(arrayList4, f, arrayList2);
        List<d> listD = tc.d(f, arrayList4);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f3 += listD.get(i2).d;
            if (((Float) arrayList3.get(i2)).floatValue() != listD.get(i2).d) {
                c(arrayList2.get(i2));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.b.gb> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            i3++;
            if (!hc(it4.next())) {
                z = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        fMax = z ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar3 = arrayList2.get(i4);
            b bVarB = b(gbVar3, listD.get(i4).d, f2);
            if (!hc(gbVar3)) {
                fMax = Math.max(fMax, bVarB.hc);
            }
            arrayList5.add(bVarB);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((b) it5.next()).hc));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar4 = arrayList2.get(i5);
                if (hc(gbVar4) && ((Float) arrayList6.get(i5)).floatValue() != fMax) {
                    c(gbVar4);
                    b(gbVar4, listD.get(i5).d, fMax);
                }
            }
        }
        bVar.d = f3;
        bVar.hc = fMax;
        return bVar;
    }

    private boolean hc(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) {
        if (gbVar == null) {
            return false;
        }
        if (TextUtils.equals(gbVar.tc().u().vv(), "flex")) {
            return true;
        }
        return b(gbVar);
    }

    private boolean b(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> listW;
        if (!gbVar.yo() && TextUtils.equals(gbVar.tc().u().vv(), "auto") && (listW = gbVar.w()) != null && listW.size() > 0) {
            if (listW.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.b.gb> it = listW.get(0).iterator();
                while (it.hasNext()) {
                    if (!hc(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> it2 = listW.iterator();
            while (it2.hasNext()) {
                if (d(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean d(List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list, boolean z) {
        boolean z2;
        for (com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.b.an anVarU = gbVar.tc().u();
            String strVv = anVarU.vv();
            if (TextUtils.equals(strVv, "flex") || (z && ((TextUtils.equals(anVarU.zw(), "flex") && TextUtils.equals(anVarU.vv(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.b.u.d.get(gbVar.tc().getType()).intValue() == 7) || TextUtils.equals(strVv, "flex")))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        if (z2) {
            return true;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.b.gb> it = list.iterator();
        while (it.hasNext()) {
            if (b(it.next())) {
                return true;
            }
        }
        return false;
    }

    private void d(List<d> list, float f, List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list2) {
        float f2 = 0.0f;
        for (d dVar : list) {
            if (dVar.hc) {
                f2 += dVar.d;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).hc && list2.get(i2).de()) {
                    i++;
                }
            }
            if (i > 0) {
                float fCeil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    d dVar2 = list.get(i3);
                    if (dVar2.hc && list2.get(i3).de()) {
                        dVar2.d -= fCeil;
                    }
                }
            }
        }
    }

    public void d() {
        this.b.clear();
        this.d.clear();
        this.hc.clear();
    }

    public b d(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) {
        return this.d.get(u(gbVar));
    }

    public b d(List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list) {
        return this.hc.get(c(list));
    }

    private void c(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) {
        this.d.remove(u(gbVar));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> listW = gbVar.w();
        if (listW == null || listW.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.b.gb>> it = listW.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }

    private void b(List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.hc.remove(c(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.b.gb> it = list.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
    }

    private String u(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) {
        return gbVar.b();
    }

    private String c(List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String strB = list.get(i).b();
            if (i < list.size() - 1) {
                sb.append(strB).append("-");
            } else {
                sb.append(strB);
            }
        }
        return sb.toString();
    }

    private void d(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar, b bVar) {
        this.d.put(u(gbVar), bVar);
    }

    private void d(List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> list, b bVar) {
        this.hc.put(c(list), bVar);
    }

    static class b {
        float d;
        float hc;

        public b() {
        }

        public b(float f, float f2) {
            this.d = f;
            this.hc = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.d + ", height=" + this.hc + '}';
        }
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.c.hc$hc, reason: collision with other inner class name */
    static class C0262hc {
        int b;
        double c;
        float d;
        int hc;
        float u;

        C0262hc() {
        }

        static JSONObject d(C0262hc c0262hc) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fontSize", c0262hc.d);
                jSONObject.put("letterSpacing", c0262hc.hc);
                jSONObject.put("lineHeight", c0262hc.c);
                jSONObject.put("maxWidth", c0262hc.u);
                jSONObject.put("fontWeight", c0262hc.b);
            } catch (JSONException e) {
                mq.d(e);
            }
            return jSONObject;
        }
    }

    static class d implements Cloneable {
        float b;
        float d;
        boolean hc;

        d() {
        }

        public Object clone() {
            try {
                return (d) super.clone();
            } catch (CloneNotSupportedException e) {
                mq.d(e);
                return null;
            }
        }
    }
}
