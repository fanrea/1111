package com.bytedance.sdk.component.mk.d;

import android.text.TextUtils;
import com.bytedance.sdk.component.mk.c.b;
import com.bytedance.sdk.component.mk.c.c;
import com.bytedance.sdk.component.mk.c.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements c {
    private int an;
    private Map<String, Object> b;
    private b c;
    private String d;
    private JSONObject hc;
    private com.bytedance.sdk.component.mk.d.d u;

    public static class d {
        private b an;
        private StringBuilder b;
        private JSONObject c;
        private int d = 1;
        private JSONObject h;
        private String hc;
        private Map<String, Object> u;

        public d(String str) {
            this.hc = str;
        }

        public d d(JSONObject jSONObject) {
            this.c = jSONObject;
            return this;
        }

        public d d(Map<String, Object> map) {
            this.u = map;
            return this;
        }

        public d d(b bVar) {
            this.an = bVar;
            return this;
        }

        public d hc(JSONObject jSONObject) {
            this.h = jSONObject;
            return this;
        }

        public hc d() {
            return new hc(this);
        }
    }

    private hc(d dVar) throws JSONException {
        this.an = 1;
        this.an = dVar.d;
        if (dVar.d != 2) {
            this.d = dVar.hc;
            if (dVar.h != null) {
                com.bytedance.sdk.component.mk.b.hc.INSTANCE.d(dVar.h);
            }
        } else {
            this.u = new com.bytedance.sdk.component.mk.d.d(dVar.b, dVar.c, (Map<String, Object>) dVar.u);
            this.an = 2;
        }
        this.hc = dVar.c;
        this.b = dVar.u;
        this.c = dVar.an;
    }

    public void d() {
        com.bytedance.sdk.component.mk.b.b bVarD;
        if (this.an == 2) {
            b bVar = this.c;
            if (bVar != null) {
                bVar.d(this.u);
            }
            this.u.an();
            return;
        }
        if (TextUtils.isEmpty(this.d) || (bVarD = com.bytedance.sdk.component.mk.b.hc.INSTANCE.d(this.d)) == null) {
            return;
        }
        d(bVarD.d(), this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.bytedance.sdk.component.mk.b.d dVar, Map<String, Object> map) {
        if (dVar == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        com.bytedance.sdk.component.mk.d.d dVar2 = new com.bytedance.sdk.component.mk.d.d(dVar, this.hc, map);
        dVar2.d(this.d);
        dVar2.d(this);
        b bVar = this.c;
        if (bVar != null) {
            bVar.d(dVar2);
        }
        dVar2.an();
        for (com.bytedance.sdk.component.mk.b.d dVar3 : com.bytedance.sdk.component.mk.b.hc.INSTANCE.d(this.d).b(dVar, dVar2.b(), map)) {
            if (dVar3 != null) {
                d(dVar3, map);
            }
        }
    }

    @Override // com.bytedance.sdk.component.mk.c.c
    public u hc() {
        return new u() { // from class: com.bytedance.sdk.component.mk.d.hc.1
            @Override // com.bytedance.sdk.component.mk.c.u
            public void d(com.bytedance.sdk.component.mk.d.d dVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.mk.b.d> it = com.bytedance.sdk.component.mk.b.hc.INSTANCE.d(hc.this.d).d(dVar.h(), dVar.b(), map).iterator();
                while (it.hasNext()) {
                    hc.this.d(it.next(), map);
                }
            }

            @Override // com.bytedance.sdk.component.mk.c.u
            public void hc(com.bytedance.sdk.component.mk.d.d dVar, Map<String, Object> map) {
                Iterator<com.bytedance.sdk.component.mk.b.d> it = com.bytedance.sdk.component.mk.b.hc.INSTANCE.d(hc.this.d).hc(dVar.h(), dVar.b(), map).iterator();
                while (it.hasNext()) {
                    hc.this.d(it.next(), map);
                }
            }
        };
    }
}
