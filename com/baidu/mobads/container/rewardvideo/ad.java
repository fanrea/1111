package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ad extends com.baidu.mobads.container.d.a {
    final /* synthetic */ NativeRewardActivity a;

    ad(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        this.a.mActivity.runOnUiThread(new ae(this));
        return null;
    }
}
