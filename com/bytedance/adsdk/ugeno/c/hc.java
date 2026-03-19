package com.bytedance.adsdk.ugeno.c;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.adsdk.ugeno.c;
import com.bytedance.adsdk.ugeno.c.d;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static String d(String str, JSONObject jSONObject) {
        d dVarB;
        d.InterfaceC0173d interfaceC0173dD;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                return (!str.startsWith("${") || !str.endsWith(i.d) || (dVarB = c.d().b()) == null || (interfaceC0173dD = dVarB.d(str.substring(2, str.length() + (-1)))) == null) ? str : (String) interfaceC0173dD.d(jSONObject);
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        return str;
    }
}
