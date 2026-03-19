package com.kwad.tachikoma;

import com.kwad.components.offline.api.OfflineHostProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private static final Map<String, InterfaceC0637a> AL = new HashMap();
    private static final List<b> AM = new ArrayList();

    /* renamed from: com.kwad.tachikoma.a$a, reason: collision with other inner class name */
    public interface InterfaceC0637a {
        void a(Throwable th);
    }

    public static void a(String str, InterfaceC0637a interfaceC0637a) {
        AL.put(str, interfaceC0637a);
    }

    public static void k(String str) {
        AL.remove(str);
    }

    public static void a(String str, Throwable th) {
        InterfaceC0637a interfaceC0637a = AL.get(str);
        if (interfaceC0637a != null) {
            interfaceC0637a.a(th);
        }
    }

    public static void c(String str, int i) {
        AM.add(new b(str, i));
    }

    public static void hL() {
        AM.remove(r0.size() - 1);
    }

    public static JSONObject hM() throws JSONException {
        if (AM.size() == 0) {
            return null;
        }
        b bVar = AM.get(r0.size() - 1);
        if (bVar.templateId == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("templateId", bVar.templateId);
            jSONObject.put("versionCode", bVar.versionCode);
        } catch (JSONException e) {
            OfflineHostProvider.getApi().log().printStackTrace(e);
        }
        return jSONObject;
    }

    public static b hN() {
        if (AM.size() == 0) {
            return null;
        }
        return AM.get(r0.size() - 1);
    }
}
