package com.baidu.mobads.container.rewardvideo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ac extends com.component.a.b.e {
    final /* synthetic */ NativeRewardActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ac(NativeRewardActivity nativeRewardActivity, String str) {
        super(str);
        this.a = nativeRewardActivity;
    }

    @Override // com.component.a.b.n
    public boolean a(String str) {
        if ("video_timer".equals(str)) {
            return this.a.F;
        }
        return false;
    }

    @Override // com.component.a.b.n
    public Object b(String str) {
        if ("video_timer".equals(str)) {
            return Long.valueOf(this.a.bi.b);
        }
        return null;
    }
}
