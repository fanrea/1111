package com.bytedance.bdtracker;

import android.net.Uri;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.network.INetworkClient;
import com.bytedance.pangle.provider.ContentProviderManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class q {
    public d a;

    public q(d dVar) {
        Intrinsics.checkParameterIsNotNull(dVar, "appLogInstance");
        this.a = dVar;
    }

    public final m<k> a(String str, l lVar) {
        Intrinsics.checkParameterIsNotNull(str, ContentProviderManager.PROVIDER_URI);
        Intrinsics.checkParameterIsNotNull(lVar, "queryParam");
        try {
            INetworkClient netClient = this.a.getNetClient();
            o3 o3Var = this.a.k;
            Intrinsics.checkExpressionValueIsNotNull(o3Var, "appLogInstance.api");
            byte[] bArrExecute = netClient.execute((byte) 0, o3Var.c.a(a(str, lVar.a())), null, a(), (byte) 0, true, 60000);
            Intrinsics.checkExpressionValueIsNotNull(bArrExecute, "appLogInstance.netClient…TIMEOUT\n                )");
            return m.c.a(new String(bArrExecute, Charsets.UTF_8), k.class);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String a(String str, JSONObject jSONObject) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject.optString(next);
            if (!(strOptString == null || strOptString.length() == 0)) {
                builderBuildUpon.appendQueryParameter(next, jSONObject.optString(next));
            }
        }
        return builderBuildUpon.build().toString();
    }

    public final HashMap<String, String> a() {
        Map<String, String> httpHeaders;
        HashMap map = new HashMap(2);
        InitConfig initConfig = this.a.getInitConfig();
        if (initConfig != null && (httpHeaders = initConfig.getHttpHeaders()) != null && (!httpHeaders.isEmpty())) {
            map.putAll(httpHeaders);
        }
        return o4.a((HashMap<String, String>) map, this.a);
    }

    public final m<n> a(String str, o oVar, l lVar) {
        Intrinsics.checkParameterIsNotNull(str, ContentProviderManager.PROVIDER_URI);
        Intrinsics.checkParameterIsNotNull(oVar, "request");
        Intrinsics.checkParameterIsNotNull(lVar, "queryParam");
        try {
            INetworkClient netClient = this.a.getNetClient();
            o3 o3Var = this.a.k;
            Intrinsics.checkExpressionValueIsNotNull(o3Var, "appLogInstance.api");
            byte[] bArrExecute = netClient.execute((byte) 1, o3Var.c.a(a(str, lVar.a())), oVar.a(), a(), (byte) 0, true, 60000);
            Intrinsics.checkExpressionValueIsNotNull(bArrExecute, "appLogInstance.netClient…OUT\n                    )");
            return m.c.a(new String(bArrExecute, Charsets.UTF_8), n.class);
        } catch (Throwable th) {
            return m.c.a(th);
        }
    }
}
