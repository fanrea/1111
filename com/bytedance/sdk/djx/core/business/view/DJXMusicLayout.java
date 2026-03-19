package com.bytedance.sdk.djx.core.business.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXMusicLayout extends FrameLayout {
    private ObjectAnimator mAnimator;
    private FrameLayout mIconLayout;
    private ImageView mImageView;
    private DJXPeriscopeLayout mPeriscopeLayout;
    private float mRotation;

    public DJXMusicLayout(Context context) {
        super(context);
        this.mRotation = 0.0f;
        init(context);
    }

    public DJXMusicLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRotation = 0.0f;
        init(context);
    }

    public DJXMusicLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRotation = 0.0f;
        init(context);
    }

    public DJXMusicLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mRotation = 0.0f;
        init(context);
    }

    private void init(Context context) {
        View viewInflate = View.inflate(context, R.layout.djx_view_music_layout, this);
        this.mIconLayout = (FrameLayout) viewInflate.findViewById(R.id.djx_view_music_layout_box);
        this.mImageView = (ImageView) viewInflate.findViewById(R.id.djx_view_music_layout_icon);
        this.mPeriscopeLayout = (DJXPeriscopeLayout) viewInflate.findViewById(R.id.djx_view_music_layout_note);
    }

    public ImageView getIconView() {
        return this.mImageView;
    }

    public void start() {
        if (this.mAnimator != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.mAnimator.resume();
            } else {
                this.mAnimator.cancel();
                this.mIconLayout.setRotation(this.mRotation);
                this.mAnimator = newAnimator();
            }
        } else {
            this.mAnimator = newAnimator();
        }
        this.mPeriscopeLayout.showView(800, 3000);
    }

    private ObjectAnimator newAnimator() {
        FrameLayout frameLayout = this.mIconLayout;
        float f = this.mRotation;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(frameLayout, "Rotation", f, f + 360.0f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.setDuration(8000L);
        objectAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXMusicLayout.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DJXMusicLayout.this.mRotation = valueAnimator.getAnimatedFraction();
            }
        });
        objectAnimatorOfFloat.start();
        return objectAnimatorOfFloat;
    }

    public void stop() {
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator != null) {
            objectAnimator.setTarget(null);
            this.mAnimator.removeAllListeners();
            this.mAnimator.removeAllUpdateListeners();
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
        FrameLayout frameLayout = this.mIconLayout;
        if (frameLayout != null) {
            frameLayout.clearAnimation();
            this.mIconLayout.setRotation(0.0f);
        }
        DJXPeriscopeLayout dJXPeriscopeLayout = this.mPeriscopeLayout;
        if (dJXPeriscopeLayout != null) {
            dJXPeriscopeLayout.stop();
        }
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageDrawable(new ColorDrawable(0));
        }
        this.mRotation = 0.0f;
    }

    public void pause() {
        if (this.mAnimator != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.mAnimator.pause();
            } else {
                this.mAnimator.cancel();
                this.mIconLayout.setRotation(this.mRotation);
            }
        }
        DJXPeriscopeLayout dJXPeriscopeLayout = this.mPeriscopeLayout;
        if (dJXPeriscopeLayout != null) {
            dJXPeriscopeLayout.pause();
        }
    }
}
