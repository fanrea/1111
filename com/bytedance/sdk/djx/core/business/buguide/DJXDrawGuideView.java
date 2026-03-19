package com.bytedance.sdk.djx.core.business.buguide;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXDrawGuideView extends LinearLayout {
    private GuideListener mListener;
    private float mMaxMoveY;
    private ImageView mViewHand;

    public interface GuideListener {
        void onGuideEnd();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
    }

    public DJXDrawGuideView(Context context) {
        super(context);
        this.mMaxMoveY = -UIUtil.dp2px(85.0f);
        init(context);
    }

    public DJXDrawGuideView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxMoveY = -UIUtil.dp2px(85.0f);
        init(context);
    }

    public DJXDrawGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxMoveY = -UIUtil.dp2px(85.0f);
        init(context);
    }

    public DJXDrawGuideView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mMaxMoveY = -UIUtil.dp2px(85.0f);
        init(context);
    }

    private void init(Context context) {
        setGravity(17);
        setOrientation(1);
        setClipChildren(false);
        setBackgroundColor(Color.parseColor("#80000000"));
        this.mViewHand = (ImageView) inflate(context, R.layout.djx_view_draw_guide, this).findViewById(R.id.djx_view_draw_guide_hand);
    }

    public void show(boolean z, ViewGroup viewGroup) {
        if (z) {
            setVisibility(0);
            if (getParent() == null) {
                viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
            }
            this.mViewHand.clearAnimation();
            bgAnimator();
            handAnimator();
            return;
        }
        setVisibility(8);
        this.mViewHand.clearAnimation();
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    private void bgAnimator() {
        ObjectAnimator.ofFloat(this, (Property<DJXDrawGuideView, Float>) View.ALPHA, 0.0f, 1.0f).setDuration(120L).start();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, (Property<DJXDrawGuideView, Float>) View.ALPHA, 1.0f, 0.0f).setDuration(120L);
        duration.setStartDelay(2400L);
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.djx.core.business.buguide.DJXDrawGuideView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
                onAnimationStart(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animator.removeAllListeners();
                DJXDrawGuideView.this.show(false, null);
                if (DJXDrawGuideView.this.mListener != null) {
                    DJXDrawGuideView.this.mListener.onGuideEnd();
                }
            }
        });
        duration.start();
    }

    private void handAnimator() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mViewHand, "translationY", 0.0f, this.mMaxMoveY).setDuration(1000L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mViewHand, "alpha", 1.0f, 0.0f).setDuration(120L);
        duration2.setStartDelay(880L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mViewHand, "rotation", -30.0f, 20.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.djx.core.business.buguide.DJXDrawGuideView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
                onAnimationStart(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                animator.removeAllListeners();
                DJXDrawGuideView.this.handAnimator2();
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handAnimator2() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.mViewHand, "translationY", 0.0f, this.mMaxMoveY).setDuration(1000L);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.mViewHand, "alpha", 0.0f, 1.0f).setDuration(120L);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(this.mViewHand, "rotation", -30.0f, 20.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(200L);
        animatorSet.playTogether(duration, duration2, duration3);
        animatorSet.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this.mViewHand;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void setListener(GuideListener guideListener) {
        this.mListener = guideListener;
    }
}
