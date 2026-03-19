package com.style.widget;

import android.view.View;
import android.widget.Toast;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class e implements View.OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    e(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.b.c != null) {
            this.b.c.a(this.a);
        }
        this.b.dismiss();
        Toast toastMakeText = Toast.makeText(this.b.b, "将为你减少此类内容推荐", 0);
        toastMakeText.setGravity(17, 0, 0);
        toastMakeText.show();
    }
}
