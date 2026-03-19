package com.baidu.mobads.container.rewardvideo;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ag implements View.OnClickListener {
    final /* synthetic */ NativeRewardActivity a;

    ag(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.playClick();
        this.a.sendRVideoLog(13);
    }
}
