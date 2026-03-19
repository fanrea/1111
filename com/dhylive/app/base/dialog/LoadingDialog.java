package com.dhylive.app.base.dialog;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.baidu.mobads.container.util.cm;
import com.blankj.utilcode.util.SizeUtils;
import com.dhylive.app.R;
import com.dhylive.app.databinding.DialogLoadingBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadingDialog.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/dhylive/app/base/dialog/LoadingDialog;", "Lcom/dhylive/app/base/dialog/BaseDialog;", "Lcom/dhylive/app/databinding/DialogLoadingBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "animation", "Landroid/view/animation/RotateAnimation;", "dismiss", "", "initData", "initListener", "show", "showWithMessage", cm.V, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class LoadingDialog extends BaseDialog<DialogLoadingBinding> {
    private RotateAnimation animation;

    @Override // com.dhylive.app.base.dialog.BaseDialog
    public void initListener() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingDialog(Context context) {
        super(context, 0, SizeUtils.dp2px(100.0f), SizeUtils.dp2px(100.0f), false, R.style.PublicDialogLightTheme, 18, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.dhylive.app.base.dialog.BaseDialog
    public void initData() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.animation = rotateAnimation;
        rotateAnimation.setInterpolator(new LinearInterpolator());
        RotateAnimation rotateAnimation2 = this.animation;
        if (rotateAnimation2 != null) {
            rotateAnimation2.setDuration(1800L);
        }
        RotateAnimation rotateAnimation3 = this.animation;
        if (rotateAnimation3 != null) {
            rotateAnimation3.setRepeatCount(Integer.MAX_VALUE);
        }
        RotateAnimation rotateAnimation4 = this.animation;
        if (rotateAnimation4 == null) {
            return;
        }
        rotateAnimation4.setRepeatMode(1);
    }

    public static /* synthetic */ void showWithMessage$default(LoadingDialog loadingDialog, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Loading...";
        }
        loadingDialog.showWithMessage(str);
    }

    public final void showWithMessage(String message) {
        Intrinsics.checkNotNullParameter(message, cm.V);
        if (!isShowing()) {
            show();
        }
        getDataBinding().tvLoading.setText(message);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        getDataBinding().ivLoading.startAnimation(this.animation);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDataBinding().ivLoading.clearAnimation();
    }
}
