package com.component.a.i;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class s {
    public static final int a = 0;
    public static final int b = 1;

    public static boolean a(View view, int i) {
        Map<String, com.component.a.f.e> mapA;
        Map<String, JSONObject> mapB;
        JSONObject jSONObject;
        if (!(view instanceof com.component.a.c.c)) {
            return false;
        }
        f fVarA = f.a(view);
        Map<View, com.component.a.f.e> mapA2 = n.a(view);
        com.component.a.f.e eVar = mapA2.get(view);
        if (fVarA == null || eVar == null || TextUtils.isEmpty(eVar.l(""))) {
            return false;
        }
        if (i == fVarA.a) {
            return true;
        }
        com.component.a.f.e eVarB = fVarA.b();
        if (eVarB == null) {
            return false;
        }
        if (i == 0) {
            mapA = null;
            mapB = null;
        } else {
            mapA = n.a(com.component.a.f.e.a(eVarB));
            mapB = b(eVar.l(""), i);
            if (mapB.size() == 0 || mapA.isEmpty()) {
                return false;
            }
        }
        for (KeyEvent.Callback callback : mapA2.keySet()) {
            com.component.a.f.e eVar2 = mapA2.get(callback);
            if ((callback instanceof com.component.a.c.c) && eVar2 != null) {
                String strL = eVar2.l("");
                if (!TextUtils.isEmpty(strL)) {
                    if (i == 0) {
                        ((com.component.a.c.c) callback).switchViewStyle(eVar2);
                    } else if (mapA != null && mapB != null && mapA.get(strL) != null && (jSONObject = mapB.get(strL)) != null) {
                        com.component.a.f.e eVar3 = mapA.get(strL);
                        n.a(eVar3.f(), jSONObject);
                        eVar3.a();
                        ((com.component.a.c.c) callback).switchViewStyle(eVar3);
                    }
                }
            }
        }
        fVarA.a = i;
        return true;
    }

    private static Map<String, JSONObject> b(String str, int i) {
        HashMap map = new HashMap();
        JSONArray jSONArrayA = a(str, i);
        if (jSONArrayA != null && jSONArrayA.length() > 0) {
            for (int i2 = 0; i2 < jSONArrayA.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayA.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                    String strOptString = jSONObjectOptJSONObject.optString("id");
                    if (((JSONObject) map.get(strOptString)) == null) {
                        map.put(strOptString, jSONObjectOptJSONObject);
                    }
                }
            }
        }
        return map;
    }

    public static JSONArray a(String str, int i) {
        com.component.a.e.c cVar = new com.component.a.e.c();
        switch (i) {
            case 1:
                return n.d(cVar.a(str));
            default:
                return null;
        }
    }
}
