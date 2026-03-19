package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class u implements com.style.widget.b.h {
    final /* synthetic */ NativeRewardActivity a;

    u(NativeRewardActivity nativeRewardActivity) {
        this.a = nativeRewardActivity;
    }

    @Override // com.style.widget.b.h
    public void a() {
        this.a.H = true;
        this.a.c(1);
    }

    @Override // com.style.widget.b.h
    public void b() {
        this.a.H = false;
        this.a.onResume();
    }
}
