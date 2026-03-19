package com.baidu.mobads.container.e;

import android.text.TextUtils;
import com.component.a.b.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class z implements e.a {
    final /* synthetic */ l a;

    z(l lVar) {
        this.a = lVar;
    }

    @Override // com.component.a.b.e.a
    public void a(com.component.a.b.e eVar, com.component.a.b.j jVar, com.component.a.b.o oVar) {
        if (TextUtils.equals("pause_video", jVar.a())) {
            this.a.handlePause(this.a.mAdInstanceInfo);
        } else if (TextUtils.equals("resume_video", jVar.a())) {
            this.a.handleResume(this.a.mAdInstanceInfo);
        }
    }
}
