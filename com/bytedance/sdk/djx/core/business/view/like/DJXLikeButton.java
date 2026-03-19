package com.bytedance.sdk.djx.core.business.view.like;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.djx.core.util.SimpleAnimatorListener;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXLikeButton extends FrameLayout implements View.OnClickListener {
    private static final AccelerateInterpolator ACCELERATE_INTERPOLATOR = new AccelerateInterpolator();
    private static final LinearInterpolator BOUNCE_INTERPOLATOR = new LinearInterpolator();
    private float animationScaleFactor;
    private AnimatorSet animatorSet;
    private ImageView icon;
    private int iconSize;
    private boolean isChecked;
    private boolean isEnabled;
    private Drawable likeDrawable;
    private OnLikeListener likeListener;
    private DJXLikeLineView lineView;
    private Drawable unLikeDrawable;

    public DJXLikeButton(Context context) {
        this(context, null);
    }

    public DJXLikeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DJXLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.animationScaleFactor = 2.0f;
        if (isInEditMode()) {
            return;
        }
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        inflate(context, R.layout.djx_view_like_layout, this);
        this.icon = (ImageView) findViewById(R.id.djx_like_btn_icon);
        this.lineView = (DJXLikeLineView) findViewById(R.id.djx_like_btn_line);
        setOnClickListener(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DJXLikeButton, i, 0);
        this.iconSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DJXLikeButton_djx_icon_size, 40);
        Drawable drawableFromResource = getDrawableFromResource(typedArrayObtainStyledAttributes, R.styleable.DJXLikeButton_djx_like_drawable);
        this.likeDrawable = drawableFromResource;
        if (drawableFromResource == null) {
            this.likeDrawable = ContextCompat.getDrawable(getContext(), R.drawable.djx_like_yes);
        }
        setLikeDrawable(this.likeDrawable);
        Drawable drawableFromResource2 = getDrawableFromResource(typedArrayObtainStyledAttributes, R.styleable.DJXLikeButton_djx_unlike_drawable);
        this.unLikeDrawable = drawableFromResource2;
        if (drawableFromResource2 == null) {
            this.unLikeDrawable = ContextCompat.getDrawable(getContext(), R.drawable.djx_like);
        }
        setUnlikeDrawable(this.unLikeDrawable);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.DJXLikeButton_djx_is_enabled, true));
        setLiked(typedArrayObtainStyledAttributes.getBoolean(R.styleable.DJXLikeButton_djx_liked, false));
        setAnimationScaleFactor(typedArrayObtainStyledAttributes.getFloat(R.styleable.DJXLikeButton_djx_anim_scale_factor, 2.0f));
        typedArrayObtainStyledAttributes.recycle();
    }

    private Drawable getDrawableFromResource(TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, -1);
        if (-1 != resourceId) {
            return ContextCompat.getDrawable(getContext(), resourceId);
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        clickBtn();
    }

    public void clickBtn() {
        if (this.isEnabled) {
            OnLikeListener onLikeListener = this.likeListener;
            if (onLikeListener == null || !onLikeListener.onIntercept(this)) {
                boolean z = !this.isChecked;
                this.isChecked = z;
                OnLikeListener onLikeListener2 = this.likeListener;
                if (onLikeListener2 != null) {
                    if (z) {
                        onLikeListener2.liked(this);
                    } else {
                        onLikeListener2.unLiked(this);
                    }
                }
                release();
                if (this.isChecked) {
                    this.icon.setImageDrawable(this.likeDrawable);
                    this.icon.animate().cancel();
                    this.icon.setScaleX(0.0f);
                    this.icon.setScaleY(0.0f);
                    this.lineView.setCurrentProgress(0.0f);
                    this.lineView.setCurrentProgressMask(0.0f);
                    this.lineView.setCurrentProgressArc(0.0f);
                    this.animatorSet = new AnimatorSet();
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f, 1.1f, 0.9f, 1.05f, 0.95f, 1.0f);
                    valueAnimatorOfFloat.setDuration(200L);
                    valueAnimatorOfFloat.setStartDelay(50L);
                    valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
                    valueAnimatorOfFloat.addUpdateListener(new SimpleAnimatorListener() { // from class: com.bytedance.sdk.djx.core.business.view.like.DJXLikeButton.1
                        @Override // com.bytedance.sdk.djx.core.util.SimpleAnimatorListener, android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            float animatedFraction = valueAnimator.getAnimatedFraction();
                            DJXLikeButton.this.icon.setScaleX(animatedFraction);
                            DJXLikeButton.this.icon.setScaleY(animatedFraction);
                        }

                        @Override // com.bytedance.sdk.djx.core.util.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            animator.removeAllListeners();
                        }
                    });
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.lineView, DJXLikeLineView.DOTS_PROGRESS_ARC, 0.0f, 1.0f);
                    objectAnimatorOfFloat.setDuration(200L);
                    objectAnimatorOfFloat.setStartDelay(0L);
                    objectAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.lineView, DJXLikeLineView.DOTS_PROGRESS, 0.0f, 1.0f);
                    objectAnimatorOfFloat2.setDuration(150L);
                    AccelerateInterpolator accelerateInterpolator = ACCELERATE_INTERPOLATOR;
                    objectAnimatorOfFloat2.setInterpolator(accelerateInterpolator);
                    ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.lineView, DJXLikeLineView.DOTS_PROGRESS_MASK, 0.0f, 1.0f);
                    objectAnimatorOfFloat3.setDuration(250L);
                    objectAnimatorOfFloat3.setStartDelay(60L);
                    objectAnimatorOfFloat3.setInterpolator(accelerateInterpolator);
                    this.animatorSet.playTogether(valueAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat);
                    this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.djx.core.business.view.like.DJXLikeButton.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            DJXLikeButton.this.lineView.setCurrentProgress(0.0f);
                            DJXLikeButton.this.lineView.setCurrentProgressMask(0.0f);
                            DJXLikeButton.this.lineView.setCurrentProgressArc(0.0f);
                            DJXLikeButton.this.icon.setScaleX(1.0f);
                            DJXLikeButton.this.icon.setScaleY(1.0f);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            DJXLikeButton.this.lineView.setCurrentProgress(0.0f);
                            DJXLikeButton.this.lineView.setCurrentProgressMask(0.0f);
                            DJXLikeButton.this.lineView.setCurrentProgressArc(0.0f);
                            DJXLikeButton.this.icon.setScaleX(1.0f);
                            DJXLikeButton.this.icon.setScaleY(1.0f);
                        }
                    });
                    this.animatorSet.start();
                    return;
                }
                this.icon.animate().cancel();
                this.icon.setPivotX(r0.getMeasuredWidth() / 2.0f);
                this.icon.setPivotY(r0.getMeasuredHeight() / 2.0f);
                this.icon.setScaleX(1.0f);
                this.icon.setScaleY(1.0f);
                this.lineView.setCurrentProgress(0.0f);
                this.lineView.setCurrentProgressMask(0.0f);
                this.lineView.setCurrentProgressArc(0.0f);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(this.icon, (Property<ImageView, Float>) View.SCALE_X, 0.0f, 1.0f, 1.1f, 0.9f, 1.05f, 0.95f, 1.0f), ObjectAnimator.ofFloat(this.icon, (Property<ImageView, Float>) View.SCALE_Y, 0.0f, 1.0f, 1.1f, 0.9f, 1.05f, 0.95f, 1.0f));
                animatorSet.setDuration(200L);
                animatorSet.start();
                animatorSet.addListener(new SimpleAnimatorListener() { // from class: com.bytedance.sdk.djx.core.business.view.like.DJXLikeButton.3
                    @Override // com.bytedance.sdk.djx.core.util.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        animator.removeAllListeners();
                        DJXLikeButton.this.icon.setImageDrawable(DJXLikeButton.this.unLikeDrawable);
                    }

                    @Override // com.bytedance.sdk.djx.core.util.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        animator.removeAllListeners();
                        DJXLikeButton.this.icon.setImageDrawable(DJXLikeButton.this.unLikeDrawable);
                    }
                });
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.isEnabled) {
            return false;
        }
        int width = getWidth();
        int height = getHeight();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int i = this.iconSize;
        if (width > i) {
            float f = (width - i) / 2.0f;
            if (x < f || x > f + i) {
                return false;
            }
        }
        if (height > i) {
            float f2 = (height - i) / 2.0f;
            if (y < f2 || y > f2 + i) {
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isEnabled) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            boolean z = false;
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    if (x > 0.0f && x < getWidth() && y > 0.0f && y < getHeight()) {
                        z = true;
                    }
                    if (isPressed() != z) {
                        setPressed(z);
                    }
                } else if (action == 3) {
                    setPressed(false);
                }
            } else if (isPressed()) {
                performClick();
                setPressed(false);
            }
        } else {
            setPressed(true);
        }
        return true;
    }

    public void setLikeDrawableRes(int i) {
        this.likeDrawable = ContextCompat.getDrawable(getContext(), i);
        if (this.iconSize != 0) {
            Context context = getContext();
            Drawable drawable = this.likeDrawable;
            int i2 = this.iconSize;
            this.likeDrawable = Utils.resizeDrawable(context, drawable, i2, i2);
        }
        if (this.isChecked) {
            this.icon.setImageDrawable(this.likeDrawable);
        }
    }

    public void setLikeDrawable(Drawable drawable) {
        this.likeDrawable = drawable;
        if (this.iconSize != 0) {
            Context context = getContext();
            int i = this.iconSize;
            this.likeDrawable = Utils.resizeDrawable(context, drawable, i, i);
        }
        if (this.isChecked) {
            this.icon.setImageDrawable(this.likeDrawable);
        }
    }

    public void setUnlikeDrawableRes(int i) {
        this.unLikeDrawable = ContextCompat.getDrawable(getContext(), i);
        if (this.iconSize != 0) {
            Context context = getContext();
            Drawable drawable = this.unLikeDrawable;
            int i2 = this.iconSize;
            this.unLikeDrawable = Utils.resizeDrawable(context, drawable, i2, i2);
        }
        if (this.isChecked) {
            return;
        }
        this.icon.setImageDrawable(this.unLikeDrawable);
    }

    public void setUnlikeDrawable(Drawable drawable) {
        this.unLikeDrawable = drawable;
        if (this.iconSize != 0) {
            Context context = getContext();
            int i = this.iconSize;
            this.unLikeDrawable = Utils.resizeDrawable(context, drawable, i, i);
        }
        if (this.isChecked) {
            return;
        }
        this.icon.setImageDrawable(this.unLikeDrawable);
    }

    public void setIconSizePx(int i) {
        this.iconSize = i;
        setEffectsViewSize();
        this.unLikeDrawable = Utils.resizeDrawable(getContext(), this.unLikeDrawable, i, i);
        this.likeDrawable = Utils.resizeDrawable(getContext(), this.likeDrawable, i, i);
    }

    public void setOnLikeListener(OnLikeListener onLikeListener) {
        this.likeListener = onLikeListener;
    }

    private void setEffectsViewSize() {
        int i = this.iconSize;
        if (i != 0) {
            int i2 = (int) (i * this.animationScaleFactor);
            this.lineView.setSize(i2, i2);
        }
    }

    public void setLiked(boolean z) {
        if (z) {
            this.isChecked = true;
            this.icon.setImageDrawable(this.likeDrawable);
        } else {
            this.isChecked = false;
            this.icon.setImageDrawable(this.unLikeDrawable);
        }
    }

    public boolean isLiked() {
        return this.isChecked;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public void setAnimationScaleFactor(float f) {
        this.animationScaleFactor = f;
        setEffectsViewSize();
    }

    public void release() {
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animatorSet.setTarget(null);
            this.animatorSet.removeAllListeners();
        }
        ImageView imageView = this.icon;
        if (imageView != null) {
            imageView.clearAnimation();
            this.icon.animate().cancel();
            this.icon.setScaleX(1.0f);
            this.icon.setScaleY(1.0f);
        }
        DJXLikeLineView dJXLikeLineView = this.lineView;
        if (dJXLikeLineView != null) {
            dJXLikeLineView.clearAnimation();
            this.lineView.setCurrentProgress(0.0f);
            this.lineView.setCurrentProgressMask(0.0f);
            this.lineView.setCurrentProgressArc(0.0f);
        }
    }

    public void setAnimColor(int i) {
        this.lineView.setPaintColor(i);
    }
}
