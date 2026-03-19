package com.luck.picture.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.luck.picture.lib.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class RemindDialog extends Dialog implements View.OnClickListener {
    private final TextView btnOk;
    private OnDialogClickListener listener;
    private final TextView tvContent;

    public interface OnDialogClickListener {
        void onClick(View view);
    }

    public RemindDialog(Context context, String str) {
        super(context, R.style.Picture_Theme_Dialog);
        setContentView(R.layout.ps_remind_dialog);
        TextView textView = (TextView) findViewById(R.id.btnOk);
        this.btnOk = textView;
        TextView textView2 = (TextView) findViewById(R.id.tv_content);
        this.tvContent = textView2;
        textView2.setText(str);
        textView.setOnClickListener(this);
        setDialogSize();
    }

    @Deprecated
    public static Dialog showTipsDialog(Context context, String str) {
        return new RemindDialog(context, str);
    }

    public static RemindDialog buildDialog(Context context, String str) {
        return new RemindDialog(context, str);
    }

    public void setButtonText(String str) {
        this.btnOk.setText(str);
    }

    public void setButtonTextColor(int i) {
        this.btnOk.setTextColor(i);
    }

    public void setContent(String str) {
        this.tvContent.setText(str);
    }

    public void setContentTextColor(int i) {
        this.tvContent.setTextColor(i);
    }

    private void setDialogSize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 17;
        getWindow().setWindowAnimations(R.style.PictureThemeDialogWindowStyle);
        getWindow().setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btnOk) {
            OnDialogClickListener onDialogClickListener = this.listener;
            if (onDialogClickListener != null) {
                onDialogClickListener.onClick(view);
            } else {
                dismiss();
            }
        }
    }

    public void setOnDialogClickListener(OnDialogClickListener onDialogClickListener) {
        this.listener = onDialogClickListener;
    }
}
