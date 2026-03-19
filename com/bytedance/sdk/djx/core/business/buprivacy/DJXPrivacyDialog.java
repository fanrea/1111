package com.bytedance.sdk.djx.core.business.buprivacy;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bytedance.sdk.djx.core.business.view.DJXDialog;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXPrivacyDialog extends DJXDialog {
    private final OnPrivacyDialogListener mOnPrivacyDialogListener;

    public interface OnPrivacyDialogListener {
        void cancel();

        void settle();
    }

    public DJXPrivacyDialog(Activity activity, OnPrivacyDialogListener onPrivacyDialogListener) {
        super(activity, R.style.djx_privacy_dialog_style);
        this.mOnPrivacyDialogListener = onPrivacyDialogListener;
        initView();
    }

    private void initView() {
        setContentView(LayoutInflater.from(InnerManager.getContext()).inflate(R.layout.djx_dialog_privacy, (ViewGroup) null));
        ((Button) findViewById(R.id.djx_tv_settle)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.buprivacy.DJXPrivacyDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXPrivacyDialog.this.mOnPrivacyDialogListener != null) {
                    DJXPrivacyDialog.this.mOnPrivacyDialogListener.settle();
                }
                DJXPrivacyDialog.this.dismiss();
            }
        });
        ((Button) findViewById(R.id.djx_tv_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.buprivacy.DJXPrivacyDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXPrivacyDialog.this.mOnPrivacyDialogListener != null) {
                    DJXPrivacyDialog.this.mOnPrivacyDialogListener.cancel();
                }
                DJXPrivacyDialog.this.dismiss();
            }
        });
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.djx.core.business.buprivacy.DJXPrivacyDialog.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (DJXPrivacyDialog.this.mOnPrivacyDialogListener != null) {
                    DJXPrivacyDialog.this.mOnPrivacyDialogListener.cancel();
                }
            }
        });
    }
}
