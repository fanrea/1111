package com.bytedance.sdk.djx.core.toast;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class CompatToast implements IToast, Cloneable {
    static long Count4BadTokenException;
    private View contentView;
    boolean isShowing;
    Context mContext;
    private int priority;
    private long timestamp;
    private int xOffset;
    private int yOffset;
    private int animation = R.style.Animation.Toast;
    private int gravity = 81;
    private int width = -2;
    private int height = -2;
    private int duration = 2000;

    CompatToast(Context context) {
        this.mContext = context;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public void show() {
        assertContentViewNotNull();
        CompatTN.instance().add(this);
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public void showLong() {
        setDuration(3500).show();
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public void cancel() {
        CompatTN.instance().cancelAll();
    }

    public static void cancelAll() {
        CompatTN.instance().cancelAll();
    }

    public static void cancelActivityToast(Activity activity) {
        CompatTN.instance().cancelActivityToast(activity);
    }

    protected WindowManager.LayoutParams getWMParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = 8;
        layoutParams.format = -3;
        if (Build.VERSION.SDK_INT >= 26 && Settings.canDrawOverlays(this.mContext)) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2005;
        }
        layoutParams.height = this.height;
        layoutParams.width = this.width;
        layoutParams.windowAnimations = this.animation;
        layoutParams.gravity = this.gravity;
        layoutParams.x = this.xOffset;
        layoutParams.y = this.yOffset;
        return layoutParams;
    }

    protected WindowManager getWMManager() {
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        return (WindowManager) context.getApplicationContext().getSystemService("window");
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public CompatToast setView(View view) {
        if (view == null) {
            return this;
        }
        this.contentView = view;
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public View getView() {
        return assertContentViewNotNull();
    }

    View getViewInternal() {
        return this.contentView;
    }

    private View assertContentViewNotNull() {
        if (this.contentView == null) {
            this.contentView = View.inflate(this.mContext, com.pangle.cn.pangrowth.base.R.layout.djx_view_toast, null);
        }
        return this.contentView;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public CompatToast setDuration(int i) {
        this.duration = i;
        return this;
    }

    public int getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public CompatToast setAnimation(int i) {
        this.animation = i;
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public CompatToast setGravity(int i, int i2, int i3) {
        this.gravity = i;
        this.xOffset = i2;
        this.yOffset = i3;
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public CompatToast setGravity(int i) {
        return setGravity(i, 0, 0);
    }

    public int getGravity() {
        return this.gravity;
    }

    public int getXOffset() {
        return this.xOffset;
    }

    public int getYOffset() {
        return this.yOffset;
    }

    public int getPriority() {
        return this.priority;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public CompatToast setPriority(int i) {
        this.priority = i;
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setText(int i, String str) {
        TextView textView = (TextView) assertContentViewNotNull().findViewById(i);
        if (textView != null) {
            textView.setText(str);
        }
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.toast.IToast
    public IToast setText(int i, String str, float f) {
        TextView textView = (TextView) assertContentViewNotNull().findViewById(i);
        if (textView != null) {
            textView.setText(str);
            textView.setTextSize(0, f);
        }
        return this;
    }

    long getTimestamp() {
        return this.timestamp;
    }

    CompatToast setTimestamp(long j) {
        this.timestamp = j;
        return this;
    }

    boolean isShowing() {
        View view;
        return this.isShowing && (view = this.contentView) != null && view.isShown();
    }

    public static boolean isBadChoice() {
        return Count4BadTokenException >= 5;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CompatToast m362clone() {
        CompatToast compatToast;
        CloneNotSupportedException e;
        try {
            compatToast = (CompatToast) super.clone();
        } catch (CloneNotSupportedException e2) {
            compatToast = null;
            e = e2;
        }
        try {
            compatToast.mContext = this.mContext;
            compatToast.contentView = this.contentView;
            compatToast.duration = this.duration;
            compatToast.animation = this.animation;
            compatToast.gravity = this.gravity;
            compatToast.height = this.height;
            compatToast.width = this.width;
            compatToast.xOffset = this.xOffset;
            compatToast.yOffset = this.yOffset;
            compatToast.priority = this.priority;
        } catch (CloneNotSupportedException e3) {
            e = e3;
            e.printStackTrace();
            return compatToast;
        }
        return compatToast;
    }
}
