package com.component.a.a;

import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.container.util.cf;
import com.component.a.f.e;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j extends cf.a {
    final /* synthetic */ e.h a;
    final /* synthetic */ f b;

    j(f fVar, e.h hVar) {
        this.b = fVar;
        this.a = hVar;
    }

    @Override // com.baidu.mobads.container.util.cf.a
    public void safeRun() {
        JSONObject jSONObject = new JSONObject(this.a.e(""));
        String strOptString = jSONObject.optString("msg");
        String strOptString2 = jSONObject.optString("obj");
        com.component.a.f.g gVarB = com.component.a.f.g.b(strOptString);
        if (TextUtils.equals(strOptString2, "self")) {
            gVarB.a(this.b);
        } else if (TextUtils.equals(strOptString2, "parent")) {
            Object parent = this.b.getParent();
            if (parent instanceof View) {
                gVarB.a((View) parent);
            }
        }
    }
}
