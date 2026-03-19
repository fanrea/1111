package com.android.gdt.qone.ai;

import com.android.gdt.qone.ag.o;
import com.android.gdt.qone.foundation.net.protocol.CMD;
import com.android.gdt.qone.uin.U;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class f {
    public static volatile f b;
    public final d a = new d();

    public static void a(f fVar, c cVar, String str, String str2) throws JSONException {
        String strC;
        String strA;
        String string;
        fVar.getClass();
        HashMap map = cVar.a;
        if (U.e()) {
            strC = "";
            strA = strC;
        } else {
            o oVarA = o.a(str2);
            strA = oVarA.a();
            strC = oVarA.c();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("1", str);
            jSONObject.put("2", strC);
            jSONObject.put("5", strA);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            }
            string = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            string = null;
        }
        String str3 = string != null ? string : "";
        CMD cmd = CMD.APM;
        String strA2 = U.a(str2, str3, cmd.b(), cmd.a());
        com.android.gdt.qone.ao.e eVar = cVar.b;
        if (new com.android.gdt.qone.z.d(strA2).a()) {
            if (eVar != null) {
                com.android.gdt.qone.ad.b.a.a(System.currentTimeMillis());
                eVar.a.d.set(false);
                com.android.gdt.qone.af.c.b("SpreadQM", "spread data upload success.", new Object[0]);
                return;
            }
            return;
        }
        com.android.gdt.qone.af.c.b("IsolateRequest", "(appKey: %s) Report failed. type = %s", str2, str);
        if (eVar != null) {
            com.android.gdt.qone.ad.b.a.a(true);
            eVar.a.d.set(false);
        }
    }

    public static synchronized f a() {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f();
                }
            }
        }
        return b;
    }

    public final void a(c cVar, String str, String str2) {
        boolean zContains;
        if (com.android.gdt.qone.au.d.a(com.android.gdt.qone.au.a.k, com.android.gdt.qone.at.a.a(str2).a.l).booleanValue() && com.android.gdt.qone.w.a.g()) {
            d dVar = this.a;
            HashMap map = cVar.a;
            if (!dVar.a.contains(str)) {
                StringBuilder sb = new StringBuilder();
                if (!map.isEmpty()) {
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().toString());
                    }
                }
                String str3 = str2 + str + sb.toString();
                synchronized (dVar) {
                    zContains = dVar.b.contains(str3);
                    if (!zContains) {
                        dVar.b.add(str3);
                    }
                }
                if (zContains) {
                    return;
                }
            }
            com.android.gdt.qone.v.a.a().a(new e(this, cVar, str, str2));
        }
    }
}
