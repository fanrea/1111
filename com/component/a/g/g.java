package com.component.a.g;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.n;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g {

    public interface a {
        String a(String str);

        JSONObject a();
    }

    public JSONObject a(JSONObject jSONObject, a aVar, b bVar) {
        JSONObject jSONObjectA;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("tp_json");
            if (TextUtils.isEmpty(strOptString)) {
                jSONObjectA = null;
            } else {
                jSONObjectA = a(strOptString);
            }
            String strOptString2 = jSONObject.optString(n.D);
            if (jSONObjectA == null && !TextUtils.isEmpty(strOptString2)) {
                jSONObjectA = a(aVar.a(strOptString2));
            }
            if (jSONObjectA == null) {
                jSONObjectA = aVar.a();
            }
            if (jSONObjectA != null) {
                a(jSONObjectA, jSONObject, bVar);
                return jSONObjectA;
            }
        }
        return aVar.a();
    }

    public JSONObject a(JSONObject jSONObject, a aVar) {
        JSONObject jSONObjectA;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("tp_json");
            if (TextUtils.isEmpty(strOptString)) {
                jSONObjectA = null;
            } else {
                jSONObjectA = a(strOptString);
            }
            if (jSONObjectA == null) {
                String strOptString2 = jSONObject.optString(n.D);
                if (!TextUtils.isEmpty(strOptString2)) {
                    jSONObjectA = a(aVar.a(strOptString2));
                }
            }
            if (jSONObjectA != null) {
                return jSONObjectA;
            }
        }
        return aVar.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x010a A[Catch: all -> 0x01bf, TryCatch #3 {all -> 0x01bf, blocks: (B:4:0x000c, B:7:0x001c, B:9:0x002e, B:12:0x0035, B:14:0x003b, B:16:0x0041, B:18:0x0047, B:20:0x0053, B:22:0x005d, B:23:0x0060, B:24:0x0063, B:26:0x006b, B:29:0x0072, B:31:0x0078, B:33:0x007e, B:35:0x0084, B:38:0x00a4, B:40:0x00aa, B:42:0x00b2, B:43:0x00ba, B:44:0x00bd, B:45:0x00c0, B:48:0x00c8, B:49:0x00d4, B:51:0x00da, B:61:0x010a, B:63:0x0114, B:65:0x011a, B:67:0x0120, B:69:0x0136, B:71:0x0144, B:74:0x014b, B:75:0x014f, B:77:0x0153, B:78:0x015b, B:58:0x0100, B:80:0x0164, B:82:0x016a, B:85:0x0176, B:87:0x017c, B:88:0x0180, B:90:0x0186, B:94:0x019b, B:101:0x01b6, B:98:0x01a7, B:91:0x018c, B:55:0x00f6), top: B:113:0x000c, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONObject r17, org.json.JSONObject r18, com.component.a.g.g.b r19) {
        /*
            Method dump skipped, instructions count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.a.g.g.a(org.json.JSONObject, org.json.JSONObject, com.component.a.g.g$b):void");
    }

    public JSONObject a(String str) {
        JSONObject jSONObjectB = com.component.a.i.n.b(str);
        if (a(jSONObjectB)) {
            return jSONObjectB;
        }
        return null;
    }

    public boolean a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            return true;
        }
        return false;
    }

    public static abstract class b {
        public boolean a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            return false;
        }

        public void a(String str, String str2, JSONObject jSONObject) {
        }
    }
}
