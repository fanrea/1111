package com.fendasz.moku.planet.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.utils.ViewUtil;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class EasyTaskReachedDialog extends Dialog {
    private static final int DIALOG_HEIGHT = 200;
    private TextView cancelButton;
    private TextView detailTextView;
    private OnEasyTaskReachedDialog onEasyTaskReachedDialog;
    private TextView openAppButton;
    private Drawable openDrawable;
    private int themeColor;
    private ImageView titleImageView;

    public interface OnEasyTaskReachedDialog {
        void onCancel();

        void onOpen();
    }

    public EasyTaskReachedDialog(Context context) {
        super(context);
        init();
    }

    public EasyTaskReachedDialog(Context context, int i) {
        super(context, i);
        init();
    }

    protected EasyTaskReachedDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        init();
    }

    private void init() {
        setCanceledOnTouchOutside(false);
        this.themeColor = Color.parseColor(MokuConfigure.getInstance().getMokuOptions(getContext()).getString("tabIndicatorColor", "#AEC7B1"));
        this.openDrawable = ViewUtil.createRoundedCorner(getContext(), this.themeColor, 5.0f);
    }

    public OnEasyTaskReachedDialog getOnEasyTaskReachedDialog() {
        return this.onEasyTaskReachedDialog;
    }

    public void setOnEasyTaskReachedDialog(OnEasyTaskReachedDialog onEasyTaskReachedDialog) {
        this.onEasyTaskReachedDialog = onEasyTaskReachedDialog;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.moku_dialog_easy);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());
            int i = getContext().getResources().getDisplayMetrics().widthPixels - 100;
            int i2 = (int) (200 * getContext().getResources().getDisplayMetrics().density);
            layoutParams.width = i;
            layoutParams.height = i2;
            window.setAttributes(layoutParams);
        }
        this.titleImageView = (ImageView) findViewById(R.id.moku_iv_title_image);
        this.detailTextView = (TextView) findViewById(R.id.moku_tv_detail_text);
        this.cancelButton = (TextView) findViewById(R.id.moku_tv_easy_cancel);
        this.openAppButton = (TextView) findViewById(R.id.moku_tv_open_app);
        this.cancelButton.setTextColor(this.themeColor);
        this.openAppButton.setBackground(this.openDrawable);
        this.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.EasyTaskReachedDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EasyTaskReachedDialog.this.dismiss();
                if (EasyTaskReachedDialog.this.onEasyTaskReachedDialog != null) {
                    EasyTaskReachedDialog.this.onEasyTaskReachedDialog.onCancel();
                }
            }
        });
        this.openAppButton.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.EasyTaskReachedDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EasyTaskReachedDialog.this.onEasyTaskReachedDialog != null) {
                    EasyTaskReachedDialog.this.onEasyTaskReachedDialog.onOpen();
                }
            }
        });
    }

    public void setDetailText(String str) {
        TextView textView = this.detailTextView;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
