package com.baidu.mobads.container.activity;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class ac implements View.OnClickListener {
    final /* synthetic */ PromoteInstallActivity a;

    ac(PromoteInstallActivity promoteInstallActivity) {
        this.a = promoteInstallActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        com.style.widget.b.i iVarA = com.style.widget.b.i.a(this.a.mActivity, this.a.xAdInstanceInfoExt.getPermissionLink());
        iVarA.a(false);
        iVarA.a();
    }
}
