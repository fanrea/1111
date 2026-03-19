package com.style.widget;

import android.content.Intent;
import android.view.View;
import com.baidu.mobads.container.activity.PermissionDialogActivity;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class y implements View.OnClickListener {
    final /* synthetic */ v a;

    y(v vVar) {
        this.a = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.mobads.container.activity.e.a().a(new z(this));
        Intent intent = new Intent();
        intent.putExtra(PermissionDialogActivity.PERMISSION_URL, this.a.k);
        com.baidu.mobads.container.util.h.f(this.a.o, intent);
    }
}
