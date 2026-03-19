package com.bytedance.sdk.component.d;

import com.bytedance.sdk.component.d.c;
import com.bytedance.sdk.component.d.de;
import com.bytedance.sdk.component.d.rf;
import com.bytedance.sdk.component.d.sy;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class h implements de.d {
    private final gb d;
    private final boolean gb;
    private final uo h;
    private final jh hc;
    private final com.bytedance.sdk.component.d.d tc;
    private final boolean tt;
    private final Map<String, hc> b = new HashMap();
    private final Map<String, c.hc> c = new HashMap();
    private final List<cb> u = new ArrayList();
    private final Set<c> an = new HashSet();

    h(tc tcVar, com.bytedance.sdk.component.d.d dVar, sy syVar) {
        this.tc = dVar;
        this.d = tcVar.c;
        jh jhVar = new jh(syVar, tcVar.mq, tcVar.uo);
        this.hc = jhVar;
        jhVar.d(this);
        jhVar.d(tcVar.cb);
        this.h = tcVar.tt;
        this.gb = tcVar.gb;
        this.tt = tcVar.e;
    }

    d d(cb cbVar, an anVar) throws Exception {
        hc hcVar = this.b.get(cbVar.c);
        if (hcVar != null) {
            try {
                v vVarHc = hc(anVar.hc, hcVar);
                anVar.c = vVarHc;
                if (vVarHc == null) {
                    tt.d("Permission denied, call: ".concat(String.valueOf(cbVar)));
                    throw new yo(-1);
                }
                if (hcVar instanceof u) {
                    tt.d("Processing stateless call: ".concat(String.valueOf(cbVar)));
                    return d(cbVar, (u) hcVar, anVar);
                }
                if (hcVar instanceof b) {
                    tt.d("Processing raw call: ".concat(String.valueOf(cbVar)));
                    return d(cbVar, (b) hcVar, vVarHc);
                }
            } catch (sy.d e) {
                tt.d("No remote permission config fetched, call pending: ".concat(String.valueOf(cbVar)), e);
                this.u.add(cbVar);
                return new d(false, np.d());
            }
        }
        c.hc hcVar2 = this.c.get(cbVar.c);
        if (hcVar2 != null) {
            c cVarD = hcVar2.d();
            cVarD.d(cbVar.c);
            v vVarHc2 = hc(anVar.hc, cVarD);
            anVar.c = vVarHc2;
            if (vVarHc2 == null) {
                tt.d("Permission denied, call: ".concat(String.valueOf(cbVar)));
                cVarD.u();
                throw new yo(-1);
            }
            tt.d("Processing stateful call: ".concat(String.valueOf(cbVar)));
            return d(cbVar, cVarD, anVar);
        }
        tt.hc("Received call: " + cbVar + ", but not registered.");
        return null;
    }

    void d(String str, u<?, ?> uVar) {
        uVar.d(str);
        this.b.put(str, uVar);
        tt.d("JsBridge stateless method registered: ".concat(String.valueOf(str)));
    }

    void d(String str, c.hc hcVar) {
        this.c.put(str, hcVar);
        tt.d("JsBridge stateful method registered: ".concat(String.valueOf(str)));
    }

    void d() {
        Iterator<c> it = this.an.iterator();
        while (it.hasNext()) {
            it.next().an();
        }
        this.an.clear();
        this.b.clear();
        this.c.clear();
        this.hc.hc(this);
    }

    private d d(cb cbVar, u uVar, an anVar) throws Exception {
        return new d(true, np.d(this.d.d((gb) uVar.d(d(cbVar.u, (hc) uVar), anVar))));
    }

    private d d(final cb cbVar, final c cVar, an anVar) throws Exception {
        this.an.add(cVar);
        cVar.d(d(cbVar.u, cVar), anVar, new c.d() { // from class: com.bytedance.sdk.component.d.h.1
            @Override // com.bytedance.sdk.component.d.c.d
            public void d(Object obj) {
                if (h.this.tc == null) {
                    return;
                }
                h.this.tc.hc(np.d(h.this.d.d((gb) obj)), cbVar);
                h.this.an.remove(cVar);
            }

            @Override // com.bytedance.sdk.component.d.c.d
            public void d(Throwable th) {
                if (h.this.tc == null) {
                    return;
                }
                h.this.tc.hc(np.d(th), cbVar);
                h.this.an.remove(cVar);
            }
        });
        return new d(false, np.d());
    }

    private d d(final cb cbVar, b bVar, v vVar) throws Exception {
        new rf(cbVar.c, vVar, new rf.d() { // from class: com.bytedance.sdk.component.d.h.2
        });
        return new d(false, np.d());
    }

    private Object d(String str, hc hcVar) throws JSONException {
        return this.d.d(str, d(hcVar)[0]);
    }

    private v hc(String str, hc hcVar) {
        if (this.tt) {
            return v.PRIVATE;
        }
        return this.hc.d(this.gb, str, hcVar);
    }

    private static Type[] d(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass == null) {
            throw new IllegalStateException("Method is not parameterized?!");
        }
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments();
    }

    static final class d {
        boolean d;
        String hc;

        private d(boolean z, String str) {
            this.d = z;
            this.hc = str;
        }
    }
}
