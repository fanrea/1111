package com.duoyou.task.sdk.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.duoyou.task.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MyAlertDialog extends Dialog {
    private Builder builder;
    private TextView cancelTv;
    private TextView messageTv;
    private TextView rightTv;

    public MyAlertDialog(Context context, Builder builder) {
        super(context, R.style.dyDialogStyle);
        this.builder = builder;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dy_dialog_alert_layout);
        this.messageTv = (TextView) findViewById(R.id.dy_message_tv);
        this.rightTv = (TextView) findViewById(R.id.dy_confirm_tv);
        this.cancelTv = (TextView) findViewById(R.id.dy_cancel_tv);
        if (!TextUtils.isEmpty(this.builder.okStr)) {
            this.rightTv.setVisibility(0);
            this.rightTv.setText(this.builder.okStr);
        }
        if (!TextUtils.isEmpty(this.builder.positiveColor)) {
            this.rightTv.setTextColor(Color.parseColor(this.builder.positiveColor));
        }
        if (!TextUtils.isEmpty(this.builder.cancelStr)) {
            this.cancelTv.setVisibility(0);
            this.cancelTv.setText(this.builder.cancelStr);
        }
        this.messageTv.setText(this.builder.messageStr);
        this.rightTv.setOnClickListener(new View.OnClickListener() { // from class: com.duoyou.task.sdk.view.dialog.MyAlertDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyAlertDialog.this.dismiss();
                if (MyAlertDialog.this.builder.onPositiveListener != null) {
                    MyAlertDialog.this.builder.onPositiveListener.onClick(view);
                }
            }
        });
        this.cancelTv.setOnClickListener(new View.OnClickListener() { // from class: com.duoyou.task.sdk.view.dialog.MyAlertDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MyAlertDialog.this.dismiss();
                if (MyAlertDialog.this.builder.onNegativeListener != null) {
                    MyAlertDialog.this.builder.onNegativeListener.onClick(view);
                }
            }
        });
    }

    public static final class Builder {
        private String cancelStr;
        private Context context;
        private String messageStr;
        private String okStr;
        private View.OnClickListener onNegativeListener;
        private View.OnClickListener onPositiveListener;
        private String positiveColor;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setMessage(String str) {
            this.messageStr = str;
            return this;
        }

        public Builder setPositiveColor(String str) {
            this.positiveColor = str;
            return this;
        }

        public View.OnClickListener getOnPositiveListener() {
            return this.onPositiveListener;
        }

        public Builder setOnPositiveListener(String str, View.OnClickListener onClickListener) {
            this.okStr = str;
            this.onPositiveListener = onClickListener;
            return this;
        }

        public View.OnClickListener getOnNegativeListener() {
            return this.onNegativeListener;
        }

        public Builder setOnNegativeListener(String str, View.OnClickListener onClickListener) {
            this.cancelStr = str;
            this.onNegativeListener = onClickListener;
            return this;
        }

        public MyAlertDialog create() {
            return new MyAlertDialog(this.context, this);
        }

        public MyAlertDialog show() {
            MyAlertDialog myAlertDialog = new MyAlertDialog(this.context, this);
            myAlertDialog.show();
            return myAlertDialog;
        }
    }
}
