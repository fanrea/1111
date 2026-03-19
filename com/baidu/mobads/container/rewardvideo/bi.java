package com.baidu.mobads.container.rewardvideo;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bi extends com.component.a.g.b {
    final /* synthetic */ NativeRewardActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bi(NativeRewardActivity nativeRewardActivity, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        super(kVar, jVar);
        this.a = nativeRewardActivity;
    }

    @Override // com.component.a.g.b
    protected void a(View view, boolean z, String str, com.component.a.f.d dVar) {
        if (com.component.a.g.b.j.equals(str)) {
            this.a.a(view, false, dVar);
        } else if ("ad_click".equals(str)) {
            this.a.a(view, true, dVar);
        }
    }

    @Override // com.component.a.g.b
    protected void c(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.a.a(this.a.ag);
    }

    @Override // com.component.a.g.b
    protected void a(View view, com.component.a.f.d dVar, String str) {
        if ("skip".equals(str)) {
            this.a.b(view, this.a.a(dVar, "skip_type", 0));
            return;
        }
        if (com.alipay.sdk.m.x.d.z.equals(str)) {
            this.a.q();
            return;
        }
        if ("resume".equals(str)) {
            this.a.b(true);
            return;
        }
        if ("play_next".equals(str)) {
            this.a.r();
            return;
        }
        if ("dismiss".equals(str)) {
            this.a.b(true);
            return;
        }
        if ("close".equals(str)) {
            this.a.a(view, dVar);
        } else if ("volume".equals(str)) {
            this.a.z = !this.a.z;
            com.baidu.mobads.container.util.ce.a(this.a.mAdInstanceInfo, this.a.v(), this.a.C, 0, this.a.z ? 2 : 1);
            this.a.l();
        }
    }
}
