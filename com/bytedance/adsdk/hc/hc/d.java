package com.bytedance.adsdk.hc.hc;

import com.bytedance.adsdk.hc.hc.b.d.an;
import com.bytedance.adsdk.hc.hc.b.d.b;
import com.bytedance.adsdk.hc.hc.b.d.c;
import com.bytedance.adsdk.hc.hc.b.d.gb;
import com.bytedance.adsdk.hc.hc.b.d.h;
import com.bytedance.adsdk.hc.hc.b.d.hc;
import com.bytedance.adsdk.hc.hc.b.d.tc;
import com.bytedance.adsdk.hc.hc.b.d.tt;
import com.bytedance.adsdk.hc.hc.b.d.u;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static final com.bytedance.adsdk.hc.hc.b.d d;
    private com.bytedance.adsdk.hc.hc.hc.d b;
    private Deque<com.bytedance.adsdk.hc.hc.hc.d> c = new LinkedList();
    private final com.bytedance.adsdk.hc.hc.b.d hc;
    private String u;

    static {
        int i = 8;
        an[] anVarArr = {new tc(), new c(), new tt(), new hc(), new u(), new com.bytedance.adsdk.hc.hc.b.d.d(), new h(), new b(), new gb()};
        final com.bytedance.adsdk.hc.hc.b.d dVar = new com.bytedance.adsdk.hc.hc.b.d() { // from class: com.bytedance.adsdk.hc.hc.d.1
            @Override // com.bytedance.adsdk.hc.hc.b.d
            public int d(String str, int i2, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque) {
                return i2;
            }
        };
        while (i >= 0) {
            final an anVar = anVarArr[i];
            i--;
            dVar = new com.bytedance.adsdk.hc.hc.b.d() { // from class: com.bytedance.adsdk.hc.hc.d.2
                @Override // com.bytedance.adsdk.hc.hc.b.d
                public int d(String str, int i2, Deque<com.bytedance.adsdk.hc.hc.hc.d> deque) {
                    return anVar.d(str, i2, deque, dVar);
                }
            };
        }
        d = dVar;
    }

    private d(String str, com.bytedance.adsdk.hc.hc.b.d dVar) {
        this.hc = dVar;
        this.u = str;
        try {
            d();
        } catch (Exception e) {
            throw new com.bytedance.adsdk.hc.d.hc(str, e);
        }
    }

    public static d d(String str) {
        return new d(str, d);
    }

    private void d() {
        int length = this.u.length();
        int i = 0;
        while (i < length) {
            int iD = this.hc.d(this.u, i, this.c);
            if (iD == i) {
                throw new IllegalArgumentException("Unrecognized expression, unrecognized characters encountered during parsing:" + this.u.substring(0, i));
            }
            i = iD;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            com.bytedance.adsdk.hc.hc.hc.d dVarPollFirst = this.c.pollFirst();
            if (dVarPollFirst != null) {
                arrayList.add(0, dVarPollFirst);
            } else {
                this.b = com.bytedance.adsdk.hc.hc.u.hc.d(arrayList, this.u, i);
                this.c = null;
                return;
            }
        }
    }

    public <T> T d(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("default_key", jSONObject);
        return (T) d(map);
    }

    public <T> T d(Map<String, JSONObject> map) {
        return (T) this.b.d(map);
    }
}
