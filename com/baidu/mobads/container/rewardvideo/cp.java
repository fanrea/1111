package com.baidu.mobads.container.rewardvideo;

import android.content.Intent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class cp implements View.OnClickListener {
    final /* synthetic */ RemoteRewardActivity a;

    cp(RemoteRewardActivity remoteRewardActivity) {
        this.a = remoteRewardActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("privacy_link", com.baidu.mobads.container.adrequest.h.g);
        com.baidu.mobads.container.util.h.a(this.a.m.getApplicationContext(), intent);
        this.a.at = 4;
    }
}
