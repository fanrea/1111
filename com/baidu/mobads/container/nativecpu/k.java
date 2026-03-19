package com.baidu.mobads.container.nativecpu;

import com.baidu.mobads.container.n.f;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobads.container.util.cn;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class k implements f.a {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    @Override // com.baidu.mobads.container.n.f.a
    public void a(HashMap<String, Object> map) {
        if (this.a.z == null || map == null) {
            return;
        }
        Object obj = map.get("showVideoAdAutoPlay");
        if (obj instanceof Integer) {
            this.a.F = ((Integer) obj).intValue();
        }
        cn cnVarS = this.a.z.getAdContainerContext().s();
        if (cnVarS != null) {
            cnVarS.dispatchEvent(new cm("Update_fbReader_Setting", map));
        }
    }

    @Override // com.baidu.mobads.container.n.f.a
    public void a() {
        cn cnVarS = this.a.z.getAdContainerContext().s();
        cm cmVar = new cm("closeInterstitialAd", (HashMap<String, Object>) new HashMap());
        if (cnVarS != null) {
            cnVarS.dispatchEvent(cmVar);
        }
    }
}
