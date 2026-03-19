package com.baidu.mobads.container.rewardvideo;

import android.text.TextUtils;
import com.component.a.b.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ap implements e.a {
    final /* synthetic */ NativeRewardActivity a;

    ap(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // com.component.a.b.e.a
    public void a(com.component.a.b.e eVar, com.component.a.b.j jVar, com.component.a.b.o oVar) {
        if (TextUtils.equals("pause_video", jVar.a())) {
            this.a.c(2);
            if (this.a.mSharedMediator != null) {
                this.a.mSharedMediator.a(this.a, 2);
                return;
            }
            return;
        }
        if (TextUtils.equals("resume_video", jVar.a())) {
            this.a.onResume();
            if (this.a.mSharedMediator != null) {
                this.a.mSharedMediator.a(this.a);
            }
        }
    }
}
