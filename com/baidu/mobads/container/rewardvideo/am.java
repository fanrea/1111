package com.baidu.mobads.container.rewardvideo;

import com.component.interfaces.RemoteReflectInterface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class am implements com.baidu.mobads.container.components.command.b {
    final /* synthetic */ String a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ NativeRewardActivity c;

    am(NativeRewardActivity nativeRewardActivity, String str, Runnable runnable) {
        this.c = nativeRewardActivity;
        this.a = str;
        this.b = runnable;
    }

    @Override // com.baidu.mobads.container.components.command.b
    public void a() {
        if (RemoteReflectInterface.getDownloadStatus(this.a) == 101) {
            this.c.a(this.a, this.b);
        }
    }
}
