package com.baidu.mobads.container.activity;

import android.content.Intent;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ab implements View.OnClickListener {
    final /* synthetic */ PromoteInstallActivity a;

    ab(PromoteInstallActivity promoteInstallActivity) {
        this.a = promoteInstallActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("privacy_link", this.a.xAdInstanceInfoExt.getPrivacyLink());
        com.baidu.mobads.container.util.h.a(this.a.mActivity, intent);
    }
}
