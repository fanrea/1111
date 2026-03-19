package com.luck.lib.camerax.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.luck.lib.camerax.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FocusImageView extends AppCompatImageView {
    private static final long DELAY_MILLIS = 1000;
    private volatile boolean isDisappear;
    private Animation mAnimation;
    private int mFocusFailedImg;
    private int mFocusImg;
    private int mFocusSucceedImg;
    private Handler mHandler;

    public FocusImageView(Context context) {
        super(context);
        init();
    }

    public FocusImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FocusImageView);
        this.mFocusImg = typedArrayObtainStyledAttributes.getResourceId(R.styleable.FocusImageView_focus_focusing, R.drawable.focus_focusing);
        this.mFocusSucceedImg = typedArrayObtainStyledAttributes.getResourceId(R.styleable.FocusImageView_focus_success, R.drawable.focus_focused);
        this.mFocusFailedImg = typedArrayObtainStyledAttributes.getResourceId(R.styleable.FocusImageView_focus_error, R.drawable.focus_failed);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void init() {
        setVisibility(8);
        this.mAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.focusview_show);
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    public void setDisappear(boolean z) {
        this.isDisappear = z;
    }

    public void startFocus(Point point) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.topMargin = point.y - (getMeasuredHeight() / 2);
        layoutParams.leftMargin = point.x - (getMeasuredWidth() / 2);
        setLayoutParams(layoutParams);
        setVisibility(0);
        setFocusResource(this.mFocusImg);
        startAnimation(this.mAnimation);
    }

    public void onFocusSuccess() {
        if (this.isDisappear) {
            setFocusResource(this.mFocusSucceedImg);
        }
        this.mHandler.removeCallbacks(null, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.luck.lib.camerax.widget.FocusImageView.1
            @Override // java.lang.Runnable
            public void run() {
                FocusImageView.this.setFocusGone();
            }
        }, 1000L);
    }

    public void onFocusFailed() {
        if (this.isDisappear) {
            setFocusResource(this.mFocusFailedImg);
        }
        this.mHandler.removeCallbacks(null, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.luck.lib.camerax.widget.FocusImageView.2
            @Override // java.lang.Runnable
            public void run() {
                FocusImageView.this.setFocusGone();
            }
        }, 1000L);
    }

    private void setFocusResource(int i) {
        setImageResource(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFocusGone() {
        if (this.isDisappear) {
            setVisibility(8);
        }
    }

    public void destroy() {
        this.mHandler.removeCallbacks(null, null);
        setVisibility(8);
    }
}
