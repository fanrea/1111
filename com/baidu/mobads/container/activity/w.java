package com.baidu.mobads.container.activity;

import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class w implements View.OnClickListener {
    final /* synthetic */ PermissionDialogActivity a;

    w(PermissionDialogActivity permissionDialogActivity) {
        this.a = permissionDialogActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finishActivity();
    }
}
