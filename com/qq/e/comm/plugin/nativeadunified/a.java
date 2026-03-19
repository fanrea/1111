package com.qq.e.comm.plugin.nativeadunified;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.comm.plugin.i3;
import com.qq.e.comm.plugin.l3;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class a {
    a() {
    }

    NativeUnifiedADAppMiitInfo a(l3 l3Var) throws JSONException {
        i3 i3VarB;
        if (l3Var == null || (i3VarB = l3Var.b()) == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", i3VarB.a());
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.AUTHOR_NAME, i3VarB.b());
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, i3VarB.f());
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.PERMISSION_URL, i3VarB.g());
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.PRIVACY_AGREEMENT, i3VarB.h());
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, i3VarB.j());
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.DESCRIPTION_URL, i3VarB.c());
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.ICP_NUMBER, i3VarB.e());
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.SUITABLE_AGE, i3VarB.i());
            jSONObject.put(NativeUnifiedADAppInfoImpl.Keys.ICP_INFO_URL, i3VarB.d());
        } catch (JSONException unused) {
        }
        return new NativeUnifiedADAppInfoImpl(jSONObject);
    }
}
