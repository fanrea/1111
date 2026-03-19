package com.baidu.mobads.container.util;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ca extends com.baidu.mobads.container.d.a {
    final /* synthetic */ bz a;

    ca(bz bzVar) {
        this.a = bzVar;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        try {
            if (!TextUtils.isEmpty(com.baidu.mobads.container.adrequest.h.f)) {
                String strOptString = new JSONObject(bf.a(com.baidu.mobads.container.adrequest.h.f)).optString("config", "");
                if (!TextUtils.isEmpty(strOptString)) {
                    b.a().a(this.a.c, strOptString, true);
                    return null;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }
}
