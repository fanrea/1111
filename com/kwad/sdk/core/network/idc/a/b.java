package com.kwad.sdk.core.network.idc.a;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.aa;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements com.kwad.sdk.core.b {
    private final Map<String, List<String>> bDM = new ConcurrentHashMap();

    private Map<String, List<String>> aaC() {
        return this.bDM;
    }

    public final void a(b bVar) {
        this.bDM.clear();
        if (bVar != null) {
            this.bDM.putAll(bVar.aaC());
        }
    }

    public final boolean isEmpty() {
        return this.bDM.isEmpty();
    }

    public final Set<String> aaD() {
        return this.bDM.keySet();
    }

    public final List<String> fv(String str) {
        Map<String, List<String>> map = this.bDM;
        if (map == null) {
            return Collections.emptyList();
        }
        List<String> list = map.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                map.put(next, aa.h(jSONObject.optJSONArray(next)));
            }
        }
        this.bDM.clear();
        this.bDM.putAll(map);
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        Map<String, List<String>> map = this.bDM;
        JSONObject jSONObject = new JSONObject();
        for (String str : map.keySet()) {
            aa.putValue(jSONObject, str, aa.aL(map.get(str)));
        }
        return jSONObject;
    }

    public static b fw(String str) {
        b bVar = new b();
        if (str != null && !str.isEmpty()) {
            try {
                bVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                c.printStackTraceOnly(e);
            }
        }
        return bVar;
    }
}
