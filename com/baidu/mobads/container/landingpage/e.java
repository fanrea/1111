package com.baidu.mobads.container.landingpage;

import com.baidu.mobads.container.landingpage.bd;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements bd.a {
    final /* synthetic */ bd a;
    final /* synthetic */ App2Activity b;

    e(App2Activity app2Activity, bd bdVar) {
        this.b = app2Activity;
        this.a = bdVar;
    }

    @Override // com.baidu.mobads.container.landingpage.bd.a
    public void a() {
        try {
            this.b.mLlContainer.removeView(this.a);
        } catch (Exception e) {
        }
        this.b.showVideo(this.b.mProxyActivity, this.b.mTmpExtraInfo.b);
    }
}
