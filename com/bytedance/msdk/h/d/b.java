package com.bytedance.msdk.h.d;

import android.text.TextUtils;
import com.bytedance.msdk.b.gb.c;
import com.bytedance.msdk.core.gb.mk;
import com.bytedance.msdk.core.gb.uo;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.an;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static volatile b d;
    private volatile Map<Integer, zw> hc = new ConcurrentHashMap();
    private Map<String, com.bytedance.msdk.core.tc.hc> b = new ConcurrentHashMap();

    private b() {
    }

    public static b d() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized zw d(int i) {
        zw zwVarD;
        zwVarD = this.hc.get(Integer.valueOf(i));
        if (zwVarD == null) {
            zwVarD = com.bytedance.msdk.h.d.d(i);
            this.hc.put(Integer.valueOf(i), zwVarD);
        }
        return zwVarD;
    }

    private synchronized void hc(JSONArray jSONArray) {
        if (jSONArray != null) {
            if (jSONArray.length() > 0) {
                try {
                    this.b.clear();
                    c.hc.clear();
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        com.bytedance.msdk.core.tc.hc hcVarD = com.bytedance.msdk.core.tc.hc.d(jSONObject, false);
                        if (hcVarD != null && !TextUtils.isEmpty(hcVarD.fs())) {
                            this.b.put(hcVarD.fs(), hcVarD);
                            concurrentHashMap.put(hcVarD.fs(), jSONObject.toString());
                        }
                    }
                    d(concurrentHashMap);
                    c.d();
                    com.bytedance.msdk.h.d.d().d("prime_rit_count", jSONArray.length());
                } catch (JSONException e) {
                    mq.d(e);
                }
            }
        }
    }

    public synchronized void d(JSONArray jSONArray) {
        hc(jSONArray);
        b(jSONArray);
    }

    private void b(final JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        an.c(new Runnable() { // from class: com.bytedance.msdk.h.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.h.hc.hc.d().d(jSONArray);
            }
        });
    }

    public synchronized com.bytedance.msdk.core.tc.hc d(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.msdk.core.tc.hc hcVarH = this.b.get(str);
        if (hcVarH == null && (hcVarH = com.bytedance.msdk.core.tc.hc.h(d(i, str))) != null) {
            this.b.put(str, hcVarH);
        }
        if (i2 == 102) {
            return hcVarH;
        }
        com.bytedance.msdk.core.tc.hc hcVarD = com.bytedance.msdk.core.tt.c.d(hcVarH, i2);
        return hcVarD != null ? hcVarD : hcVarH;
    }

    private String d(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (i == 0) {
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(5);
            arrayList.add(7);
            arrayList.add(8);
            arrayList.add(9);
            arrayList.add(10);
        } else {
            arrayList.add(Integer.valueOf(i));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String strHc = d(((Integer) it.next()).intValue()).hc(str);
            if (!TextUtils.isEmpty(strHc)) {
                return strHc;
            }
        }
        return null;
    }

    public synchronized void hc() {
        Map<String, com.bytedance.msdk.core.tc.hc> map = this.b;
        if (map != null) {
            map.clear();
        }
    }

    public synchronized boolean b() {
        return com.bytedance.msdk.h.d.d().hc("prime_rit_count", -1) <= 0;
    }

    private synchronized void d(final Map<String, String> map) {
        if (map != null) {
            if (map.size() != 0) {
                an.c(new Runnable() { // from class: com.bytedance.msdk.h.d.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        for (Map.Entry entry : map.entrySet()) {
                            try {
                                String str = (String) entry.getKey();
                                String str2 = (String) entry.getValue();
                                com.bytedance.msdk.core.tc.hc hcVar = (com.bytedance.msdk.core.tc.hc) b.this.b.get(str);
                                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && hcVar != null) {
                                    b.this.d(hcVar.ba()).d(str, str2);
                                    b.this.d(hcVar);
                                }
                            } catch (Throwable th) {
                                mq.d(th);
                            }
                        }
                        map.clear();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(com.bytedance.msdk.core.tc.hc hcVar) {
        if (hcVar != null) {
            if (hcVar.fs() != null) {
                if (hcVar.tc()) {
                    if (uo.d().d(hcVar.tt())) {
                        uo.d().hc(hcVar.tt());
                    }
                    if (uo.d().d(hcVar.gb())) {
                        uo.d().hc(hcVar.gb());
                    }
                } else {
                    uo.d().c(hcVar.fs());
                    uo.d().tt(hcVar.fs());
                }
                for (tc tcVar : hcVar.y()) {
                    if (tcVar.c()) {
                        if (com.bytedance.msdk.core.gb.mq.d().d(tcVar.b())) {
                            com.bytedance.msdk.core.gb.mq.d().hc(tcVar.b());
                        }
                        if (mk.d().d(tcVar.hc())) {
                            mk.d().hc(tcVar.hc());
                        }
                    } else {
                        com.bytedance.msdk.core.gb.mq.d().delete(hcVar.fs(), tcVar.yo());
                        mk.d().delete(hcVar.fs(), tcVar.yo());
                    }
                }
            }
        }
    }
}
