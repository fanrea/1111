package com.duoyou.task.sdk.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.duoyou.task.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LoadingDialog extends Dialog {
    private ProgressBar contentLoadingProgressBar;
    private String message;
    private TextView messageTv;

    public LoadingDialog(Context context, String str) {
        super(context, R.style.dyDialogStyle);
        this.message = str;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dy_dialog_loading_layout);
        initView();
    }

    private void initView() {
        this.contentLoadingProgressBar = (ProgressBar) findViewById(R.id.dy_pbLarge);
        this.messageTv = (TextView) findViewById(R.id.dy_message_tv);
        try {
            this.contentLoadingProgressBar.getIndeterminateDrawable().setColorFilter(getContext().getResources().getColor(android.R.color.white), PorterDuff.Mode.MULTIPLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.message)) {
            return;
        }
        this.messageTv.setText(this.message);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }
}
