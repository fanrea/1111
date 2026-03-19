package com.baidu.mobads.container;

import com.component.a.f.e;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class z extends com.baidu.mobads.container.d.a {
    final /* synthetic */ k a;

    z(k kVar) {
        this.a = kVar;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        try {
            JSONObject jSONObjectA = this.a.mAdCloudConfigs.a("slide_config");
            if (jSONObjectA != null && jSONObjectA.optInt("slide_mode", 0) == 1) {
                com.component.lottie.k.a(this.a.mAppContext, new e.h(new JSONObject(com.baidu.mobads.container.u.n.f)), new aa(this));
                return null;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
