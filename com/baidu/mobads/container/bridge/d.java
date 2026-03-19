package com.baidu.mobads.container.bridge;

import com.baidu.mobads.container.ax;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d implements ax.d {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.mobads.container.ax.d
    public void a(int i, int i2, boolean z, boolean z2) {
        try {
            if (this.a.aA == null) {
                this.a.aA = new JSONObject();
            }
            this.a.aA.put("act", "scroll");
            this.a.aA.put("webScroolY", i2);
            this.a.aA.put("webContentH", this.a.V.getContentHeight() * this.a.V.getScale());
            com.baidu.mobads.container.activity.d.a().a(this.a.aw, this.a.aA.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
