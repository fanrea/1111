package com.bytedance.sdk.component.hc.d.d.d;

import com.bytedance.sdk.component.b.hc.jh;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.tt;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements tt.d {
    jh.d d;

    public u(jh.d dVar) {
        this.d = dVar;
    }

    @Override // com.bytedance.sdk.component.hc.d.tt.d
    public k d() {
        return new gb(this.d.d());
    }

    @Override // com.bytedance.sdk.component.hc.d.tt.d
    public cb d(k kVar) throws IOException {
        return new tt(this.d.d(this.d.d().an().d(kVar.hc().d()).d()));
    }
}
