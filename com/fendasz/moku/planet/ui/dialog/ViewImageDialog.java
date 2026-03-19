package com.fendasz.moku.planet.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.interf.functions.Action;
import com.fendasz.moku.planet.ui.customview.ZoomImageView;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.QrCodeUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;
import com.fendasz.moku.planet.utils.SharedPreferencesUtils;
import com.fendasz.moku.planet.utils.StorageUtils;
import com.fendasz.moku.planet.utils.StyleUtils;
import com.fendasz.moku.planet.utils.ThreadUtils;
import com.fendasz.moku.planet.utils.WeChatUtils;
import com.fendasz.moku.planet.utils.system.utils.SystemUtils;
import com.luck.picture.lib.config.PictureMimeType;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ViewImageDialog extends Dialog {
    private static final String TAG = "ViewImageDialog";

    private ViewImageDialog(Context context) {
        super(context, R.style.MokuDialogTheme);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
    }

    public static class Builder {
        private Bitmap mBitmap;
        private Context mContext;
        private LinearLayout mLlBrowser;
        private LinearLayout mLlOptions;
        private LinearLayout mLlWeChat;
        private PhoneScreenUtils mPhoneScreenUtils;
        private String mUrl;
        private boolean mIsMiniProgrammer = false;
        private boolean isReward = false;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setBitmap(Bitmap bitmap) {
            this.mBitmap = bitmap;
            return this;
        }

        public Builder setIsMiniProgrammer(boolean z) {
            this.mIsMiniProgrammer = z;
            return this;
        }

        public Builder isReward(boolean z) {
            this.isReward = z;
            return this;
        }

        public ViewImageDialog create() {
            this.mPhoneScreenUtils = PhoneScreenUtils.getInstance();
            ViewImageDialog viewImageDialog = new ViewImageDialog(this.mContext);
            viewImageDialog.setCancelable(true);
            initView(viewImageDialog);
            return viewImageDialog;
        }

        private void initView(ViewImageDialog viewImageDialog) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setBackgroundColor(StyleUtils.getColor(this.mContext, R.color.black));
            viewImageDialog.setContentView(frameLayout);
            ZoomImageView zoomImageView = new ZoomImageView(this.mContext);
            frameLayout.addView(zoomImageView);
            ViewGroup.LayoutParams layoutParams = zoomImageView.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -1;
            zoomImageView.setImageBitmap(this.mBitmap);
            initListener(viewImageDialog, zoomImageView);
            initLlOptionsView(frameLayout);
        }

        /* renamed from: com.fendasz.moku.planet.ui.dialog.ViewImageDialog$Builder$1, reason: invalid class name */
        class AnonymousClass1 implements View.OnLongClickListener {
            AnonymousClass1() {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                Builder.this.mLlOptions.setVisibility(0);
                Builder.this.mLlWeChat.setVisibility(4);
                Builder.this.mLlBrowser.setVisibility(4);
                if (Builder.this.mIsMiniProgrammer) {
                    Builder.this.mLlWeChat.setVisibility(0);
                    if (Builder.this.isReward) {
                        Builder.this.mLlBrowser.setVisibility(0);
                        return true;
                    }
                    Builder.this.mLlBrowser.setVisibility(4);
                    return true;
                }
                ThreadUtils.runOnChildThread(new Runnable() { // from class: com.fendasz.moku.planet.ui.dialog.ViewImageDialog.Builder.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Builder.this.mUrl = QrCodeUtils.parseQrCode(Builder.this.mBitmap);
                        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.fendasz.moku.planet.ui.dialog.ViewImageDialog.Builder.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (TextUtils.isEmpty(Builder.this.mUrl)) {
                                    Builder.this.mLlWeChat.setVisibility(4);
                                    Builder.this.mLlBrowser.setVisibility(4);
                                } else {
                                    Builder.this.mLlWeChat.setVisibility(0);
                                    Builder.this.mLlBrowser.setVisibility(0);
                                }
                            }
                        });
                    }
                });
                return true;
            }
        }

        private void initListener(final ViewImageDialog viewImageDialog, ZoomImageView zoomImageView) {
            zoomImageView.setOnLongClickListener(new AnonymousClass1());
            zoomImageView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.ViewImageDialog.Builder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (Builder.this.mLlOptions.getVisibility() == 0) {
                        Builder.this.mLlOptions.setVisibility(8);
                    } else {
                        viewImageDialog.dismiss();
                    }
                }
            });
        }

        private void initLlOptionsView(FrameLayout frameLayout) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.moku_image_options, (ViewGroup) frameLayout, false);
            this.mLlOptions = linearLayout;
            frameLayout.addView(linearLayout);
            this.mLlOptions.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) this.mLlOptions.findViewById(R.id.ll_save);
            ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, linearLayout2, 20, 20);
            LinearLayout linearLayout3 = (LinearLayout) this.mLlOptions.findViewById(R.id.ll_we_chat);
            this.mLlWeChat = linearLayout3;
            ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, linearLayout3, 20, 20);
            LinearLayout linearLayout4 = (LinearLayout) this.mLlOptions.findViewById(R.id.ll_browser);
            this.mLlBrowser = linearLayout4;
            ScreenAdaptationUtils.setPaddingTopAndBottom(this.mContext, linearLayout4, 20, 20);
            ScreenAdaptationUtils.setSize(this.mContext, (ImageView) this.mLlOptions.findViewById(R.id.iv_save), 100, 100);
            ScreenAdaptationUtils.setSize(this.mContext, (ImageView) this.mLlOptions.findViewById(R.id.iv_we_chat), 100, 100);
            ScreenAdaptationUtils.setSize(this.mContext, (ImageView) this.mLlOptions.findViewById(R.id.iv_browser), 100, 100);
            TextView textView = (TextView) this.mLlOptions.findViewById(R.id.tv_save);
            textView.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
            ScreenAdaptationUtils.setMarginTop(this.mContext, textView, 10);
            TextView textView2 = (TextView) this.mLlOptions.findViewById(R.id.tv_we_chat);
            textView2.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
            ScreenAdaptationUtils.setMarginTop(this.mContext, textView2, 10);
            TextView textView3 = (TextView) this.mLlOptions.findViewById(R.id.tv_browser);
            textView3.setTextSize(this.mPhoneScreenUtils.getMiddleTextSize(this.mContext));
            ScreenAdaptationUtils.setMarginTop(this.mContext, textView3, 10);
            TextView textView4 = (TextView) this.mLlOptions.findViewById(R.id.tv_cancel);
            ScreenAdaptationUtils.setMarginTopAndBottom(this.mContext, textView4, 20);
            textView4.setTextSize(this.mPhoneScreenUtils.getBigTextSize(this.mContext));
            initLlOptionsListener(this.mLlOptions, linearLayout2, this.mLlWeChat, this.mLlBrowser, textView4);
        }

        private void initLlOptionsListener(final LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView) {
            if (linearLayout != null) {
                linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.fendasz.moku.planet.ui.dialog.ViewImageDialog.Builder.3
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
            }
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.ViewImageDialog.Builder.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Builder.this.saveBitmap("保存成功", "保存失败");
                        LinearLayout linearLayout5 = linearLayout;
                        if (linearLayout5 != null) {
                            linearLayout5.setVisibility(8);
                        }
                    }
                });
            }
            if (linearLayout3 != null) {
                linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.ViewImageDialog.Builder.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LinearLayout linearLayout5 = linearLayout;
                        if (linearLayout5 != null) {
                            linearLayout5.setVisibility(8);
                        }
                        Builder.this.showQrCodeScanTipDialog(new Action() { // from class: com.fendasz.moku.planet.ui.dialog.ViewImageDialog.Builder.5.1
                            @Override // com.fendasz.moku.planet.interf.functions.Action
                            public void run() throws Exception {
                                Builder.this.saveBitmap("图片已保存", "图片保存失败");
                                if (WeChatUtils.openWeChatQrCode(Builder.this.mContext)) {
                                    return;
                                }
                                Toast.makeText(Builder.this.mContext, "请先安装微信", 0).show();
                            }
                        });
                    }
                });
            }
            if (linearLayout4 != null) {
                linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.ViewImageDialog.Builder.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LinearLayout linearLayout5 = linearLayout;
                        if (linearLayout5 != null) {
                            linearLayout5.setVisibility(8);
                        }
                        Builder.this.showQrCodeScanTipDialog(new Action() { // from class: com.fendasz.moku.planet.ui.dialog.ViewImageDialog.Builder.6.1
                            @Override // com.fendasz.moku.planet.interf.functions.Action
                            public void run() throws Exception {
                                Builder.this.saveBitmap("图片已保存", "图片保存失败");
                                if (TextUtils.isEmpty(Builder.this.mUrl)) {
                                    return;
                                }
                                SystemUtils.openBrowser(Builder.this.mContext, Builder.this.mUrl);
                            }
                        });
                    }
                });
            }
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.ViewImageDialog.Builder.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        LinearLayout linearLayout5 = linearLayout;
                        if (linearLayout5 != null) {
                            linearLayout5.setVisibility(8);
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showQrCodeScanTipDialog(final Action action) {
            final SharedPreferencesUtils sharedPreferencesUtils = SharedPreferencesUtils.getInstance(this.mContext);
            if (sharedPreferencesUtils.getBoolean(this.mContext.getString(R.string.moku_sp_is_show_qr_code_scan_tip), true)) {
                new CustomBuildDialog.DialogBuilder(this.mContext).setCancelable(false).setTitleImage(Integer.valueOf(R.drawable.moku_tips_icon)).setDetailText(this.mContext.getString(R.string.moku_dialog_detail_text_qr_code_scan_tip)).setRightBtn(this.mContext.getString(R.string.moku_dialog_btn_text__i_know), new CustomBuildDialog.DialogButtonOnClickListener() { // from class: com.fendasz.moku.planet.ui.dialog.ViewImageDialog.Builder.8
                    @Override // com.fendasz.moku.planet.ui.dialog.CustomBuildDialog.DialogButtonOnClickListener
                    public void onClick(TextView textView, CustomBuildDialog customBuildDialog) {
                        sharedPreferencesUtils.putBoolean(Builder.this.mContext.getString(R.string.moku_sp_is_show_qr_code_scan_tip), false);
                        customBuildDialog.dismiss();
                        try {
                            action.run();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).create().show();
                return;
            }
            try {
                action.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void saveBitmap(String str, String str2) {
            if (StorageUtils.saveBitmap(this.mContext, this.mBitmap, "screenShot_" + System.currentTimeMillis() + PictureMimeType.JPG)) {
                Toast.makeText(this.mContext, str, 0).show();
            } else {
                Toast.makeText(this.mContext, str2, 0).show();
            }
        }
    }
}
