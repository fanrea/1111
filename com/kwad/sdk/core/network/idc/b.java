package com.kwad.sdk.core.network.idc;

import android.content.Context;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ag;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static com.kwad.sdk.core.network.idc.a.b bN(Context context) {
        try {
            return com.kwad.sdk.core.network.idc.a.b.fw(h.Z(context, "ksad_idc.json"));
        } catch (IOException e) {
            c.printStackTraceOnly(e);
            return new com.kwad.sdk.core.network.idc.a.b();
        }
    }

    public static com.kwad.sdk.core.network.idc.a.b bO(Context context) {
        return com.kwad.sdk.core.network.idc.a.b.fw(ag.b(context, "ksadsdk_idc", "idc_data", ""));
    }

    public static void a(Context context, com.kwad.sdk.core.network.idc.a.b bVar) {
        ag.a(context, "ksadsdk_idc", "idc_data", bVar == null ? "" : bVar.toJson().toString());
    }

    public static Map<String, String> bP(Context context) {
        return aa.parseJSON2MapString(ag.b(context, "ksadsdk_idc", "idc_current", ""));
    }

    public static void a(Context context, Map<String, String> map) {
        ag.a(context, "ksadsdk_idc", "idc_current", (map == null || map.isEmpty()) ? "" : new JSONObject(map).toString());
    }
}
