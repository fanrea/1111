package com.bytedance.adsdk.hc;

import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk {
    public static Object d(com.bytedance.adsdk.hc.hc.d.d dVar) {
        gb gbVarD;
        if (dVar == null || (gbVarD = d(dVar.d())) == null) {
            return null;
        }
        return gbVarD.d(null, dVar.hc());
    }

    public static gb d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "modArray":
                return new tt();
            case "find":
                return new an();
            case "chunk":
                return new d();
            case "exist":
                return new u();
            case "decodeUrl":
                return new hc();
            case "translate":
                return new tc();
            case "encodeUrl":
                return new c();
            case "isDigit":
                return new h();
            default:
                return null;
        }
    }
}
