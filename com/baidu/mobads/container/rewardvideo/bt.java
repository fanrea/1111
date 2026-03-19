package com.baidu.mobads.container.rewardvideo;

import android.view.View;
import com.component.a.g.d;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class bt extends d.c {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ RemoteRewardActivity b;

    bt(RemoteRewardActivity remoteRewardActivity, JSONObject jSONObject) {
        this.b = remoteRewardActivity;
        this.a = jSONObject;
    }

    @Override // com.component.a.g.d.c
    public void a(View view, String str, String str2) {
        this.b.p = true;
        this.b.a(view, str, this.a);
    }
}
