package com.bytedance.adsdk.ugeno.u;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.u.an;
import com.bytedance.adsdk.ugeno.u.b.hc;
import com.bytedance.adsdk.ugeno.u.hc.d;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt implements mk {
    private boolean an;
    private com.bytedance.adsdk.ugeno.hc.b b;
    private com.bytedance.adsdk.ugeno.b.an c;
    private d d;
    private Map<String, List<com.bytedance.adsdk.ugeno.u.b.hc>> hc;
    private boolean u;

    public tt(com.bytedance.adsdk.ugeno.hc.b bVar, d dVar) {
        this.b = bVar;
        this.d = dVar;
        if (dVar != null) {
            this.hc = dVar.d;
        }
    }

    public void d(com.bytedance.adsdk.ugeno.b.an anVar) {
        this.c = anVar;
    }

    public void d() {
        List<com.bytedance.adsdk.ugeno.u.b.hc> listD = d("shake");
        if (listD == null || listD.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.u.b.hc hcVar : listD) {
            if (hcVar != null) {
                hcVar.d(this);
                hcVar.d(new Object[0]);
            }
        }
    }

    public void hc() {
        List<com.bytedance.adsdk.ugeno.u.b.hc> listD = d("twist");
        if (listD == null || listD.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.u.b.hc hcVar : listD) {
            if (hcVar != null) {
                hcVar.d(this);
                hcVar.d(new Object[0]);
            }
        }
    }

    public void b() {
        List<com.bytedance.adsdk.ugeno.u.b.hc> value;
        d dVar = this.d;
        if (dVar == null) {
            return;
        }
        for (Map.Entry<String, List<com.bytedance.adsdk.ugeno.u.b.hc>> entry : dVar.d.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null && !value.isEmpty()) {
                for (com.bytedance.adsdk.ugeno.u.b.hc hcVar : value) {
                    if (hcVar instanceof com.bytedance.adsdk.ugeno.u.b.b) {
                        hcVar.d(this);
                        hcVar.d(new Object[0]);
                    }
                }
            }
        }
    }

    public void c() {
        List<com.bytedance.adsdk.ugeno.u.b.hc> listD = d("animateState");
        if (listD == null || listD.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.u.b.hc hcVar : listD) {
            if (hcVar != null) {
                hcVar.d(this);
                hcVar.d(new Object[0]);
            }
        }
    }

    public void u() {
        List<com.bytedance.adsdk.ugeno.u.b.hc> listD = d("timer");
        if (listD == null || listD.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.u.b.hc hcVar : listD) {
            if (hcVar != null) {
                hcVar.d(this);
                hcVar.d(new Object[0]);
            }
        }
    }

    public boolean d(MotionEvent motionEvent) {
        List<com.bytedance.adsdk.ugeno.u.b.hc> listD = d("touchStart");
        if (listD != null && !listD.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.u.b.hc hcVar : listD) {
                if (hcVar instanceof com.bytedance.adsdk.ugeno.u.b.gb) {
                    hcVar.d(this);
                    hcVar.d(motionEvent);
                }
            }
        }
        List<com.bytedance.adsdk.ugeno.u.b.hc> listD2 = d("touchEnd");
        List<com.bytedance.adsdk.ugeno.u.b.hc> listD3 = d("tap");
        List<com.bytedance.adsdk.ugeno.u.b.hc> listD4 = d(ILogConst.DRAW_ENTER_TYPE_SLIDE);
        if (listD != null && !listD.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.u.b.hc hcVar2 : listD2) {
                if (hcVar2 instanceof com.bytedance.adsdk.ugeno.u.b.h) {
                    hcVar2.d(this);
                    this.an = hcVar2.d(motionEvent);
                }
            }
        }
        if ((listD3 == null || listD3.isEmpty()) && (listD4 == null || listD4.isEmpty())) {
            return this.an;
        }
        if (this.an && motionEvent.getAction() == 1) {
            return true;
        }
        if (listD3 != null && !listD3.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.u.b.hc hcVar3 : listD3) {
                if (hcVar3 instanceof com.bytedance.adsdk.ugeno.u.b.u) {
                    hcVar3.d(this);
                    this.u = hcVar3.d(motionEvent);
                }
            }
        }
        if (this.u) {
            return true;
        }
        if (listD4 != null && !listD4.isEmpty()) {
            for (com.bytedance.adsdk.ugeno.u.b.hc hcVar4 : listD4) {
                if (hcVar4 instanceof com.bytedance.adsdk.ugeno.u.b.c) {
                    hcVar4.d(this);
                    return hcVar4.d(motionEvent);
                }
            }
        }
        return this.u;
    }

    private void d(String str, List<an.d> list) {
        com.bytedance.adsdk.ugeno.u.hc.d dVarD;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (an.d dVar : list) {
            if (dVar != null && (dVarD = d.C0177d.d(this.b, str, dVar)) != null) {
                dVarD.d();
                dVarD.hc();
            }
        }
    }

    public List<com.bytedance.adsdk.ugeno.u.b.hc> d(String str) {
        Map<String, List<com.bytedance.adsdk.ugeno.u.b.hc>> map = this.hc;
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.hc.get(str);
    }

    @Override // com.bytedance.adsdk.ugeno.u.mk
    public void d(com.bytedance.adsdk.ugeno.hc.b bVar, String str, List<an.d> list) {
        d(str, list);
    }

    public static tt d(com.bytedance.adsdk.ugeno.hc.b bVar, String str) {
        com.bytedance.adsdk.ugeno.u.b.hc hcVarD;
        if (bVar != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() <= 0) {
                    return null;
                }
                d dVar = new d(new HashMap(), new HashMap());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (hcVarD = hc.d.d(bVar.tt().getContext(), bVar, jSONObjectOptJSONObject, bVar.tc())) != null) {
                        if (dVar.d.containsKey(hcVarD.h())) {
                            List<com.bytedance.adsdk.ugeno.u.b.hc> list = dVar.d.get(hcVarD.h());
                            if (list == null) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(hcVarD);
                                dVar.d.put(hcVarD.h(), arrayList);
                            } else {
                                list.add(hcVarD);
                            }
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(hcVarD);
                            dVar.d.put(hcVarD.h(), arrayList2);
                        }
                        dVar.hc.put(hcVarD.gb(), hcVarD);
                    }
                }
                return new tt(bVar, dVar);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        return null;
    }

    public static class d {
        public Map<String, List<com.bytedance.adsdk.ugeno.u.b.hc>> d;
        public Map<String, com.bytedance.adsdk.ugeno.u.b.hc> hc;

        public d(Map<String, List<com.bytedance.adsdk.ugeno.u.b.hc>> map, Map<String, com.bytedance.adsdk.ugeno.u.b.hc> map2) {
            this.d = map;
            this.hc = map2;
        }
    }
}
