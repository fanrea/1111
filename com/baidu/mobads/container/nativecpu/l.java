package com.baidu.mobads.container.nativecpu;

import com.baidu.mobads.container.nativecpu.g;
import com.baidu.mobads.container.util.cm;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class l implements g.a {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    @Override // com.baidu.mobads.container.nativecpu.g.a
    public void a(String str, HashMap<String, Object> map) {
        this.a.dispatchEvent(new cm(str, map));
    }
}
