package com.baidu.mobads.container.rewardvideo;

import android.webkit.DownloadListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class v implements DownloadListener {
    final /* synthetic */ NativeRewardActivity a;

    v(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (com.baidu.mobads.container.util.ab.a(str, str4, str3)) {
            com.baidu.mobads.container.f.a(this.a.mActivity, this.a.X, this.a.mAdInstanceInfo, "reward", "end_play_click", true);
        }
    }
}
