package com.bytedance.sdk.djx.core.vod.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.djx.utils.WeakHandler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class FullScreenHelper implements WeakHandler.IHandler {
    private static final int WHAT_HIDE_NAVIGATION_BAR = 100;
    private final Context mContext;
    private boolean mIsFull;
    private boolean mHasFullScreenFlag = false;
    private int mDisplayCutoutMode = 0;
    private int mSystemUIFlag = -1;
    private final WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);

    public static FullScreenHelper build(Context context) {
        return new FullScreenHelper(context);
    }

    private FullScreenHelper(Context context) {
        this.mContext = context;
    }

    public boolean isFull() {
        return this.mIsFull;
    }

    public void toggle(View view) {
        if (isFull()) {
            exitFull(view);
        } else {
            enterFull(view);
        }
    }

    public void exitFull(View view) {
        this.mIsFull = false;
        Activity activity = getActivity(view);
        if (activity != null) {
            if (activity.getWindow() != null) {
                Window window = activity.getWindow();
                if (Build.VERSION.SDK_INT >= 28) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.layoutInDisplayCutoutMode = this.mDisplayCutoutMode;
                    window.setAttributes(attributes);
                }
                window.getDecorView().setSystemUiVisibility(this.mSystemUIFlag);
            }
            if (this.mHasFullScreenFlag && activity.getWindow() != null) {
                activity.getWindow().clearFlags(1024);
                activity.getWindow().clearFlags(512);
            }
            activity.setRequestedOrientation(1);
        }
    }

    public void enterFull(View view) {
        this.mIsFull = true;
        this.mHasFullScreenFlag = false;
        Activity activity = getActivity(view);
        if (activity != null) {
            Window window = activity.getWindow();
            if (window != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    this.mDisplayCutoutMode = attributes.layoutInDisplayCutoutMode;
                    attributes.layoutInDisplayCutoutMode = 1;
                    window.setAttributes(attributes);
                }
                if (window.getDecorView() != null) {
                    this.mSystemUIFlag = window.getDecorView().getSystemUiVisibility();
                }
                window.addFlags(1024);
                window.addFlags(512);
                this.mHasFullScreenFlag = (window.getAttributes().flags & 1024) == 1024;
            }
            activity.setRequestedOrientation(0);
        }
        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(100, view), 100L);
    }

    private Activity getActivity(View view) {
        Activity activity = (view == null || !(view.getContext() instanceof Activity)) ? null : (Activity) view.getContext();
        if (activity == null) {
            Context context = this.mContext;
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
        }
        if (activity == null && view != null && (view.getContext() instanceof ContextWrapper)) {
            ContextWrapper contextWrapper = (ContextWrapper) view.getContext();
            if (contextWrapper.getBaseContext() != null && (contextWrapper.getBaseContext() instanceof Activity)) {
                activity = (Activity) contextWrapper.getBaseContext();
            }
        }
        if (activity != null) {
            return activity;
        }
        Context context2 = this.mContext;
        if (!(context2 instanceof ContextWrapper)) {
            return activity;
        }
        ContextWrapper contextWrapper2 = (ContextWrapper) context2;
        return (contextWrapper2.getBaseContext() == null || !(contextWrapper2.getBaseContext() instanceof Activity)) ? activity : (Activity) contextWrapper2.getBaseContext();
    }

    public void handleMsg(Message message) {
        if (message.what == 100) {
            try {
                VideoImmersedUtils.enterFullScreenHideNavigation(getActivity(message.obj instanceof View ? (View) message.obj : null));
            } catch (Throwable unused) {
            }
        }
    }

    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
    }
}
