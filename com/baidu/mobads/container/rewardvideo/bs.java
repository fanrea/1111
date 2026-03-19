package com.baidu.mobads.container.rewardvideo;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bs extends com.component.a.g.b {
    final /* synthetic */ int a;
    final /* synthetic */ RemoteRewardActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    bs(RemoteRewardActivity remoteRewardActivity, com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar, int i) {
        super(kVar, jVar);
        this.b = remoteRewardActivity;
        this.a = i;
    }

    @Override // com.component.a.g.b
    protected void a(View view, boolean z, String str, com.component.a.f.d dVar) {
        if (com.component.a.g.b.j.equals(str)) {
            this.b.a(false);
            return;
        }
        if (this.a != 3 && "ad_click".equals(str)) {
            if (this.a != 1) {
                this.b.a(true);
                return;
            }
            if (!"main_view".equals(view.getTag()) && !"content".equals(view.getTag()) && !"title".equals(view.getTag()) && !RemoteRewardActivity.JSON_BANNER_SCORE_ID.equals(view.getTag()) && view.getTag() != null) {
                this.b.a(true);
            }
        }
    }
}
