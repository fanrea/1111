package com.baidu.mobads.container.activity;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class y implements View.OnClickListener {
    final /* synthetic */ PromoteInstallActivity a;

    y(PromoteInstallActivity promoteInstallActivity) {
        this.a = promoteInstallActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.a.mActivity != null) {
            this.a.mActivity.finish();
        }
    }
}
