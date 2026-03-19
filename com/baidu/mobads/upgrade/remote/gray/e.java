package com.baidu.mobads.upgrade.remote.gray;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.h;
import com.baidu.mobads.container.j;
import com.baidu.mobads.container.util.ai;
import com.baidu.mobads.container.util.bf;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e extends com.baidu.mobads.container.d.a {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        try {
            String strA = this.a.a(h.d, (HashMap<String, String>) this.a.f());
            if (!TextUtils.isEmpty(strA)) {
                String strA2 = bf.a(strA);
                this.a.f = new DynamicUpgradeInfo(strA2);
                com.baidu.mobads.container.h.a.a().a(strA2);
                if (this.a.f != null) {
                    boolean zB = com.baidu.mobads.container.h.a.a().b(this.a.f.c());
                    this.a.l = new a(this.a.f, this.a.e());
                    if (!TextUtils.isEmpty(this.a.f.b()) && !zB && j.b() < this.a.f.c() && this.a.a(this.a.d()) < this.a.f.c()) {
                        this.a.a(this.a.f);
                    }
                    com.baidu.mobads.container.util.b.a().a(this.a.e, this.a.f.d(), false);
                    this.a.b(this.a.e);
                    if (com.baidu.mobads.container.h.a.a().t() == 1) {
                        ai.a(this.a.e).a();
                    }
                    if (com.baidu.mobads.container.h.a.a().o() == 1) {
                        this.a.b();
                    }
                } else {
                    return null;
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }
}
