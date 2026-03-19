package com.baidu.mobads.container.activity;

import android.view.View;
import com.baidu.mobads.container.config.PromoteInstallConfig;
import com.baidu.mobads.container.util.by;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class z implements View.OnClickListener {
    final /* synthetic */ PromoteInstallActivity a;

    z(PromoteInstallActivity promoteInstallActivity) {
        this.a = promoteInstallActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PromoteInstallConfig.handleAdInstall(this.a.mContext, this.a.xAdInstanceInfoExt.getAppPackageName());
        by.a.a(this.a.mContext).c(this.a.adJsonObj.optString("prod", "")).b(this.a.adJsonObj.optString(com.baidu.mobads.container.components.command.j.x, "")).a(this.a.xAdInstanceInfoExt).a(811).a("pk", this.a.adJsonObj.optString("pk", "")).a("install_ts", this.a.adJsonObj.optString("install_ts", "")).a("reason", "installDialogClick").f();
        if (this.a.mActivity != null) {
            this.a.mActivity.finish();
        }
    }
}
