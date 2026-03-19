package com.baidu.mobads.container.bridge;

import com.baidu.mobads.container.util.bh;
import com.sigmob.sdk.base.mta.PointCategory;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class h implements bh.a {
    final /* synthetic */ String a;
    final /* synthetic */ bh b;
    final /* synthetic */ String c;
    final /* synthetic */ b d;

    h(b bVar, String str, bh bhVar, String str2) {
        this.d = bVar;
        this.a = str;
        this.b = bhVar;
        this.c = str2;
    }

    @Override // com.baidu.mobads.container.util.bh.a
    public void a() {
        this.d.a(714, "wait_over_time", this.a, "", new JSONObject());
    }

    @Override // com.baidu.mobads.container.util.bh.a
    public void a(int i) {
        JSONObject jSONObjectC;
        if (!com.baidu.mobads.container.util.t.f(this.d.U, this.d.U.getPackageName())) {
            this.d.au = true;
        }
        if (!this.d.k(this.a)) {
            if (this.d.au && com.baidu.mobads.container.util.t.f(this.d.U, this.d.U.getPackageName())) {
                JSONObject jSONObjectD = this.d.d(this.c, this.a);
                if (jSONObjectD != null) {
                    jSONObjectC = jSONObjectD;
                } else {
                    jSONObjectC = this.d.c("202", PointCategory.DOWNLOAD_FAILED);
                }
                this.d.a(714, "download_app", this.a, "", jSONObjectC);
                this.b.b();
                return;
            }
            return;
        }
        this.d.a(714, "already installed", this.a, "", this.d.c("0", "success"));
        this.b.b();
    }
}
