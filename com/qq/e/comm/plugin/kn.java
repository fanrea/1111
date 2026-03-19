package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.e10;
import com.qq.e.comm.plugin.rc;
import com.qq.e.comm.plugin.s2;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class kn {
    public int a;

    private int a(int i, int i2) {
        return i != 0 ? i : i2;
    }

    kn() {
    }

    private rc b(JSONObject jSONObject) {
        rc.b bVar = new rc.b();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                next.hashCode();
                next.hashCode();
                switch (next) {
                    case "22":
                        bVar.a = jSONObject.optInt(next);
                        break;
                    case "23":
                        bVar.b = jSONObject.optString(next);
                        break;
                    case "24":
                        bVar.c = jSONObject.optString(next);
                        break;
                    case "25":
                        a(jSONObject.optJSONObject(next), bVar);
                        break;
                }
            }
        }
        return bVar.a();
    }

    private void a(vl vlVar, rc rcVar) {
        int i = rcVar.a;
        if (i == 8) {
            vlVar.a |= 2;
        } else if (i == 5) {
            vlVar.a |= 1;
        }
    }

    public vl a(String str, wl wlVar) {
        if (str != null && str.length() >= 9) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.a = 101;
                if (jSONObject.length() == 0) {
                    wlVar.a(this.a, jSONObject);
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                vl vlVar = new vl();
                z10 z10VarA = a(jSONObject, 0, sb, vlVar, wlVar);
                if (z10VarA != null) {
                    z10VarA.l = sb.toString();
                }
                vlVar.c = z10VarA;
                return vlVar;
            } catch (JSONException unused) {
                this.a = 100;
                wlVar.a(100, null);
            }
        }
        return null;
    }

    private e10 c(JSONObject jSONObject) {
        e10.b bVar = new e10.b();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                next.hashCode();
                next.hashCode();
                switch (next) {
                    case "62":
                        bVar.a = jSONObject.optInt(next);
                        break;
                    case "63":
                        bVar.b = jSONObject.optString(next);
                        break;
                    case "64":
                        a(jSONObject.optJSONObject(next), bVar);
                        break;
                }
            }
        }
        return bVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0281 A[PHI: r21 r22
  0x0281: PHI (r21v1 java.lang.String) = 
  (r21v0 java.lang.String)
  (r21v0 java.lang.String)
  (r21v0 java.lang.String)
  (r21v2 java.lang.String)
  (r21v2 java.lang.String)
 binds: [B:137:0x025f, B:139:0x0263, B:141:0x026b, B:133:0x0248, B:132:0x0245] A[DONT_GENERATE, DONT_INLINE]
  0x0281: PHI (r22v1 java.lang.String) = 
  (r22v0 java.lang.String)
  (r22v0 java.lang.String)
  (r22v0 java.lang.String)
  (r22v2 java.lang.String)
  (r22v2 java.lang.String)
 binds: [B:137:0x025f, B:139:0x0263, B:141:0x026b, B:133:0x0248, B:132:0x0245] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.qq.e.comm.plugin.z10 a(org.json.JSONObject r24, int r25, java.lang.StringBuilder r26, com.qq.e.comm.plugin.vl r27, com.qq.e.comm.plugin.wl r28) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.kn.a(org.json.JSONObject, int, java.lang.StringBuilder, com.qq.e.comm.plugin.vl, com.qq.e.comm.plugin.wl):com.qq.e.comm.plugin.z10");
    }

    private s2 a(JSONObject jSONObject) {
        s2.b bVar = new s2.b();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                next.hashCode();
                next.hashCode();
                switch (next) {
                    case "28":
                        bVar.b = jSONObject.optString(next, s2.q);
                        break;
                    case "29":
                        bVar.a = jSONObject.optInt(next);
                        break;
                    case "30":
                        bVar.c = jSONObject.optJSONArray(next);
                        break;
                    case "31":
                        bVar.d = jSONObject.optInt(next);
                        break;
                    case "32":
                        bVar.e = jSONObject.optInt(next);
                        break;
                    case "33":
                        bVar.g = jSONObject.optInt(next);
                        break;
                    case "34":
                        bVar.h = jSONObject.optInt(next, 1);
                        break;
                    case "35":
                        bVar.i = jSONObject.optInt(next);
                        break;
                    case "36":
                        bVar.j = jSONObject.optJSONArray(next);
                        break;
                    case "39":
                        bVar.f = jSONObject.optInt(next);
                        break;
                }
            }
        }
        bVar.k = jSONObject;
        return bVar.a();
    }

    private void a(JSONObject jSONObject, rc.b bVar) {
        ob obVarB;
        if (ln.b(jSONObject)) {
            return;
        }
        Object objRemove = jSONObject.remove("sag");
        if (objRemove instanceof String) {
            bVar.f = (String) objRemove;
        }
        Object objRemove2 = jSONObject.remove(com.baidu.mobads.container.adrequest.g.T);
        if (objRemove2 instanceof JSONObject) {
            bVar.g = (JSONObject) objRemove2;
        }
        Object objRemove3 = jSONObject.remove("bsd");
        if (objRemove3 instanceof JSONObject) {
            bVar.h = (JSONObject) objRemove3;
        }
        Object objRemove4 = jSONObject.remove("nl");
        if (objRemove4 instanceof Integer) {
            bVar.i = ((Integer) objRemove4).intValue() == 1;
        }
        Object objRemove5 = jSONObject.remove("saf");
        if (objRemove5 instanceof String) {
            bVar.j = (String) objRemove5;
        }
        Object objRemove6 = jSONObject.remove("bpd");
        if (objRemove6 instanceof String) {
            bVar.k = (String) objRemove6;
        }
        Object objRemove7 = jSONObject.remove("mc");
        if (objRemove7 instanceof Integer) {
            bVar.l = ((Integer) objRemove7).intValue();
        }
        if (ln.b(jSONObject)) {
            return;
        }
        bVar.e = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next) && (obVarB = t30.b(jSONObject.opt(next))) != null) {
                bVar.e.put(next, obVarB);
                itKeys.remove();
            }
        }
        if (jSONObject.length() > 0) {
            bVar.d = jSONObject.toString();
        }
    }

    private void a(JSONObject jSONObject, e10.b bVar) {
        ob obVarB;
        if (ln.b(jSONObject)) {
            return;
        }
        Object objRemove = jSONObject.remove("sag");
        if (objRemove instanceof String) {
            bVar.e = (String) objRemove;
        }
        Object objRemove2 = jSONObject.remove(com.baidu.mobads.container.adrequest.g.T);
        if (objRemove2 instanceof JSONObject) {
            bVar.f = (JSONObject) objRemove2;
        }
        Object objRemove3 = jSONObject.remove("bsd");
        if (objRemove3 instanceof JSONObject) {
            bVar.g = (JSONObject) objRemove3;
        }
        if (ln.b(jSONObject)) {
            return;
        }
        bVar.d = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next) && (obVarB = t30.b(jSONObject.opt(next))) != null) {
                bVar.d.put(next, obVarB);
                itKeys.remove();
            }
        }
        if (jSONObject.length() > 0) {
            bVar.c = jSONObject.toString();
        }
    }
}
