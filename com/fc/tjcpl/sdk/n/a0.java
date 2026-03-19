package com.fc.tjcpl.sdk.n;

import android.content.Context;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a0 implements View.OnClickListener {
    public x a;
    public Context b;

    public a0(Context context, x xVar) {
        this.b = context;
        this.a = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.fc.tjcpl.sdk.b.a.a(this.b, "id", "tj_dialog_btn")) {
            this.a.getClass();
        } else if (view.getId() == com.fc.tjcpl.sdk.b.a.a(this.b, "id", "tj_dialog_btn_left")) {
            this.a.a();
        } else if (view.getId() == com.fc.tjcpl.sdk.b.a.a(this.b, "id", "tj_dialog_btn_right")) {
            this.a.b();
        }
    }
}
