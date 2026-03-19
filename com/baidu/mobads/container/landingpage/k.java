package com.baidu.mobads.container.landingpage;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class k implements View.OnClickListener {
    final /* synthetic */ App2Activity a;

    k(App2Activity app2Activity) {
        this.a = app2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.runBottomViewExitAnimation(this.a.mBackgroundView, this.a.mBottomView);
    }
}
