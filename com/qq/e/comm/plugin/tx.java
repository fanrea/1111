package com.qq.e.comm.plugin;

import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class tx extends x4 {
    public String toString() {
        return "GDTSDKSetting[" + this.a.toString() + "]";
    }

    tx() {
    }

    Object a(String str) {
        return this.a.opt(str);
    }

    tx(String str) {
        super(str);
    }

    void a(String str, Object obj) throws JSONException {
        try {
            this.a.putOpt(str, obj);
        } catch (JSONException unused) {
        }
    }
}
