package com.bytedance.sdk.djx.core.toast;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class ActivityToast extends CompatToast {
    ActivityToast(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.djx.core.toast.CompatToast
    public WindowManager.LayoutParams getWMParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = 8;
        layoutParams.format = -3;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.windowAnimations = R.style.Animation.Toast;
        layoutParams.gravity = getGravity();
        layoutParams.x = getXOffset();
        layoutParams.y = getYOffset();
        return layoutParams;
    }

    @Override // com.bytedance.sdk.djx.core.toast.CompatToast
    public WindowManager getWMManager() {
        if (this.mContext instanceof Activity) {
            return ((Activity) this.mContext).getWindowManager();
        }
        return null;
    }
}
