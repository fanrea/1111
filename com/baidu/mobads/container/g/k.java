package com.baidu.mobads.container.g;

import android.text.TextUtils;
import com.baidu.mobads.container.util.by;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class k implements g {
    final /* synthetic */ i a;

    k(i iVar) {
        this.a = iVar;
    }

    @Override // com.baidu.mobads.container.g.g
    public void a(int i, String str) {
        if (i == -1) {
            by.a aVarA = by.a.a(this.a.mAppContext).a(1044).c("rsplash").a("status", i).a("reason", str);
            if (this.a.c != null) {
                aVarA.a(this.a.c).a("cached", !TextUtils.isEmpty(this.a.c.getLocalCreativeURL())).a("MaterialType", this.a.c.getMaterialType()).a("w_picurl", this.a.c.getMainPictureUrl());
            }
            aVarA.f();
            this.a.processAdError(com.baidu.mobads.container.c.a.SHOW_PROCESS_FAILED, "gif render failed");
        }
    }
}
