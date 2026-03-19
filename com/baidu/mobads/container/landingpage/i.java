package com.baidu.mobads.container.landingpage;

import com.baidu.mobads.container.landingpage.am;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class i implements am.c {
    final /* synthetic */ App2Activity a;

    i(App2Activity app2Activity) {
        this.a = app2Activity;
    }

    @Override // com.baidu.mobads.container.landingpage.am.c
    public void a() {
        if (this.a.curWebview == null || !this.a.curWebview.canGoBack()) {
            if (this.a.checkGoBack()) {
                return;
            }
            b();
        } else if (!this.a.checkGoBack()) {
            if (this.a.mOpenBundleForbid && this.a.curWebview.a.equals(this.a.finishUrl)) {
                b();
            }
            this.a.curWebview.goBack();
        }
    }

    @Override // com.baidu.mobads.container.landingpage.am.c
    public void b() {
        this.a.updateLpState("backBtnFinish");
        this.a.closeCause = "topLeftBtn";
        this.a.exit();
        this.a.mLandingPageTrackingInfo.R++;
    }

    @Override // com.baidu.mobads.container.landingpage.am.c
    public void c() {
        this.a.showBottomView();
        this.a.mLandingPageTrackingInfo.S++;
    }
}
