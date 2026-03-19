package com.baidu.mobads.container.adrequest;

import com.baidu.mobads.container.n.f;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.cn;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class f implements f.a {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    @Override // com.baidu.mobads.container.n.f.a
    public void a(HashMap<String, Object> map) {
        cn cnVarS = this.a.h.getAdContainerContext().s();
        if (cnVarS != null) {
            cnVarS.dispatchEvent(new cm("Update_fbReader_Setting", map));
        }
    }

    @Override // com.baidu.mobads.container.n.f.a
    public void a() {
        cn cnVarS = this.a.h.getAdContainerContext().s();
        cm cmVar = new cm("closeInterstitialAd", (HashMap<String, Object>) new HashMap());
        if (cnVarS != null) {
            cnVarS.dispatchEvent(cmVar);
        }
    }
}
