package com.baidu.mobads.container.util.b.a;

import com.baidu.mobads.container.util.b.a.k;
import com.component.player.s;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class h implements k {
    private final s a;

    public h(s sVar) {
        this.a = sVar;
    }

    @Override // com.baidu.mobads.container.util.b.a.k
    public com.baidu.mobads.container.util.b.f<?> a(k.b bVar, k.a aVar) {
        b bVarA = bVar.a();
        File fileD = this.a.d(bVarA.d);
        if (fileD != null && fileD.exists()) {
            return new com.baidu.mobads.container.util.b.f<>(fileD);
        }
        if (bVarA.k) {
            return null;
        }
        if (bVarA.g > 51200) {
            this.a.a(bVarA.a, bVarA.g, aVar);
        } else {
            this.a.a(bVarA.a, aVar);
        }
        return null;
    }
}
