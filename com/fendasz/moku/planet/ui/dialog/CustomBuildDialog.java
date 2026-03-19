package com.fendasz.moku.planet.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import java.util.Objects;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CustomBuildDialog extends Dialog {
    private static final String TAG = "CustomBuildDialog";

    public interface DialogButtonOnClickListener {
        void onClick(TextView textView, CustomBuildDialog customBuildDialog);
    }

    public interface DialogGuideTouchListener {
        void onClick(CustomBuildDialog customBuildDialog);
    }

    public interface OnDialogButtonCreated {
        void onLeftButton(CustomBuildDialog customBuildDialog, TextView textView);

        void onRightButton(CustomBuildDialog customBuildDialog, TextView textView);
    }

    private CustomBuildDialog(Context context, int i) {
        super(context, i);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView(final CustomDialogParams customDialogParams) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.moku_custom_dialog_layout, (ViewGroup) null);
        setContentView(relativeLayout);
        LinearLayout linearLayout = (LinearLayout) relativeLayout.findViewById(R.id.ll_parent_layout);
        int dialogWidth = 800;
        if (customDialogParams.getDialogWidth() != null) {
            dialogWidth = customDialogParams.getDialogWidth();
        }
        ScreenAdaptationUtils.setWidth(getContext(), linearLayout, dialogWidth);
        ScreenAdaptationUtils.setPadding(getContext(), linearLayout, 55, 55, 55, 55);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.iv_title_image);
        ScreenAdaptationUtils.setSize(getContext(), imageView, 110, 110);
        if (customDialogParams.getTitleImage() != null) {
            imageView.setImageResource(customDialogParams.getTitleImage().intValue());
        }
        imageView.setVisibility(customDialogParams.getTitleImage() != null ? 0 : 8);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_title_text);
        textView.setTextSize(PhoneScreenUtils.getInstance().getBigTextSize(getContext()));
        if (customDialogParams.getTitleText() != null) {
            textView.setText(customDialogParams.getTitleText());
        }
        textView.setVisibility(customDialogParams.getTitleText() != null ? 0 : 8);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_detail_text);
        textView2.setTextSize(PhoneScreenUtils.getInstance().getMiddleTextSize(getContext()));
        if (customDialogParams.getDetailText() != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                textView2.setText(Html.fromHtml(customDialogParams.getDetailText(), 63));
            } else {
                textView2.setText(Html.fromHtml(customDialogParams.getDetailText()));
            }
        }
        textView2.setVisibility(customDialogParams.getDetailText() != null ? 0 : 8);
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_custom_layout);
        if (customDialogParams.getCustomView() != null) {
            relativeLayout2.addView(customDialogParams.getCustomView());
        }
        relativeLayout2.setVisibility(customDialogParams.getCustomView() != null ? 0 : 8);
        final TextView textView3 = (TextView) relativeLayout.findViewById(R.id.tv_btn_left);
        textView3.setTextSize(PhoneScreenUtils.getInstance().getSmallTextSize(getContext()));
        ScreenAdaptationUtils.setSize(getContext(), textView3, 200, 120);
        textView3.setText(customDialogParams.getLeftBtn());
        textView3.setVisibility(customDialogParams.getLeftBtn() != null ? 0 : 8);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (customDialogParams.getLeftBtnListener() != null) {
                    customDialogParams.getLeftBtnListener().onClick(textView3, CustomBuildDialog.this);
                }
            }
        });
        TextView textView4 = (TextView) relativeLayout.findViewById(R.id.tv_btn_right);
        textView4.setTextSize(PhoneScreenUtils.getInstance().getSmallTextSize(getContext()));
        ScreenAdaptationUtils.setSize(getContext(), textView4, 200, 120);
        textView4.setText(customDialogParams.getRightBtn());
        textView4.setVisibility(customDialogParams.getRightBtn() != null ? 0 : 8);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (customDialogParams.getRightBtnListener() != null) {
                    customDialogParams.getRightBtnListener().onClick(textView3, CustomBuildDialog.this);
                }
            }
        });
        if (customDialogParams.getRightBtn() != null && customDialogParams.getLeftBtn() != null) {
            ScreenAdaptationUtils.setMarginLeft(getContext(), textView4, 30);
            ScreenAdaptationUtils.setMarginRight(getContext(), textView3, 30);
        } else {
            ScreenAdaptationUtils.setMarginLeft(getContext(), textView4, 0);
            ScreenAdaptationUtils.setMarginRight(getContext(), textView3, 0);
        }
        ImageView imageView2 = (ImageView) relativeLayout.findViewById(R.id.iv_close);
        ScreenAdaptationUtils.setSize(getContext(), imageView2, 100, 100);
        ScreenAdaptationUtils.setMarginTop(getContext(), imageView2, 50);
        if (customDialogParams.getShowClose() != null) {
            if (customDialogParams.getShowClose().booleanValue()) {
                imageView2.setVisibility(0);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CustomBuildDialog.this.dismiss();
                    }
                });
            }
        } else {
            imageView2.setVisibility(8);
        }
        if (customDialogParams.getAnimationStyleId() != null) {
            ((Window) Objects.requireNonNull(getWindow())).setWindowAnimations(customDialogParams.getAnimationStyleId().intValue());
        }
        if (customDialogParams.getCancelable() != null && customDialogParams.getCancelable().booleanValue()) {
            relativeLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    CustomBuildDialog.this.dismiss();
                    return false;
                }
            });
        }
        if (customDialogParams.getOnDialogButtonCreated() != null) {
            customDialogParams.getOnDialogButtonCreated().onLeftButton(this, textView3);
            customDialogParams.getOnDialogButtonCreated().onRightButton(this, textView4);
        }
    }

    public static class DialogBuilder {
        private final CustomDialogParams customDialogParams;

        public DialogBuilder(Context context) {
            CustomDialogParams customDialogParams = new CustomDialogParams();
            this.customDialogParams = customDialogParams;
            customDialogParams.setContext(context);
        }

        public DialogBuilder setTitleImage(Integer num) {
            this.customDialogParams.setTitleImage(num);
            return this;
        }

        public DialogBuilder setTitleText(String str) {
            this.customDialogParams.setTitleText(str);
            return this;
        }

        public DialogBuilder setDetailText(String str) {
            this.customDialogParams.setDetailText(str);
            return this;
        }

        public DialogBuilder setCustomView(View view) {
            this.customDialogParams.setCustomView(view);
            return this;
        }

        public DialogBuilder setLeftBtn(String str, DialogButtonOnClickListener dialogButtonOnClickListener) {
            this.customDialogParams.setLeftBtn(str);
            this.customDialogParams.setLeftBtnListener(dialogButtonOnClickListener);
            return this;
        }

        public DialogBuilder setRightBtn(String str, DialogButtonOnClickListener dialogButtonOnClickListener) {
            this.customDialogParams.setRightBtn(str);
            this.customDialogParams.setRightBtnListener(dialogButtonOnClickListener);
            return this;
        }

        public DialogBuilder setOnDialogButtonCreated(OnDialogButtonCreated onDialogButtonCreated) {
            this.customDialogParams.setOnDialogButtonCreated(onDialogButtonCreated);
            return this;
        }

        public DialogBuilder setShowClose(Boolean bool) {
            this.customDialogParams.setShowClose(bool);
            return this;
        }

        public DialogBuilder setCancelable(Boolean bool) {
            this.customDialogParams.setCancelable(bool);
            return this;
        }

        private DialogBuilder setAnimationStyleId(Integer num) {
            this.customDialogParams.setAnimationStyleId(num);
            return this;
        }

        public DialogBuilder setDialogWidth(Integer num) {
            this.customDialogParams.setDialogWidth(num);
            return this;
        }

        public CustomBuildDialog create() {
            CustomBuildDialog customBuildDialog = new CustomBuildDialog(this.customDialogParams.getContext(), R.style.MokuCustomProgressDialog);
            if (this.customDialogParams.getCancelable() != null) {
                customBuildDialog.setCancelable(this.customDialogParams.getCancelable().booleanValue());
            }
            customBuildDialog.initView(this.customDialogParams);
            return customBuildDialog;
        }
    }
}
