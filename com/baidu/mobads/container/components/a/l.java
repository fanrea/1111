package com.baidu.mobads.container.components.a;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.WindowManager;
import com.baidu.mobads.container.activity.APKLinkDialogActivity;
import com.baidu.mobads.container.activity.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class l {
    u a;

    public void a(Context context, int i, com.baidu.mobads.container.components.command.j jVar, k kVar) {
        if (context == null || jVar == null || kVar == null) {
            return;
        }
        if (i == 201 || i == 202) {
            Dialog dialog = new Dialog(context);
            dialog.setCancelable(false);
            dialog.requestWindowFeature(1);
            dialog.setContentView(new a(context, false, i, jVar.g(), kVar));
            if (dialog.getWindow() != null) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
                if (attributes != null) {
                    attributes.width = -1;
                    attributes.height = -2;
                    dialog.getWindow().setAttributes(attributes);
                }
            }
            dialog.setOnKeyListener(new m(this));
            dialog.show();
            return;
        }
        this.a = new n(this, kVar);
        com.baidu.mobads.container.activity.e.a().a(this.a);
        Intent intent = new Intent();
        intent.putExtra("app_name", jVar.g());
        intent.putExtra(APKLinkDialogActivity.DOWNLOAD_DIALOG_TYPE, i);
        com.baidu.mobads.container.util.h.c(context, intent);
    }
}
