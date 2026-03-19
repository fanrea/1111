package com.bytedance.sdk.djx.core.business.view.swipe;

import android.app.Activity;
import com.bytedance.sdk.djx.core.business.view.swipe.DJXSwipeBackLayout;
import com.bytedance.sdk.djx.core.util.ToastUtil;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class SwipeBackListenerActivityAdapter implements DJXSwipeBackLayout.SwipeListenerEx {
    private final WeakReference<Activity> mActivity;

    @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXSwipeBackLayout.SwipeListener
    public void onScrollOverThreshold() {
    }

    @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXSwipeBackLayout.SwipeListener
    public void onScrollStateChange(int i, float f) {
    }

    public SwipeBackListenerActivityAdapter(Activity activity) {
        this.mActivity = new WeakReference<>(activity);
    }

    @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXSwipeBackLayout.SwipeListener
    public void onEdgeTouch(int i) {
        Activity activity = this.mActivity.get();
        if (activity != null) {
            try {
                ToastUtil.cancelAll(activity);
            } catch (Throwable unused) {
            }
            SwipeUtils.invokeConvertToTranslucent(activity);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.view.swipe.DJXSwipeBackLayout.SwipeListenerEx
    public void onContentViewSwipedBack() {
        Activity activity = this.mActivity.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
        activity.overridePendingTransition(0, 0);
    }
}
