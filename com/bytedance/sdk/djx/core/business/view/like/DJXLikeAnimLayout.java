package com.bytedance.sdk.djx.core.business.view.like;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXLikeAnimLayout extends FrameLayout {
    private static final int LIKE_HEIGHT = 79;
    private static final int LIKE_WIDTH = 72;
    private static final int QUEUE_LIMIT = 3;
    private static Drawable mSrcDrawable;
    private Context mContext;
    private boolean mIsCanShowLikeAnim;
    private int mLikeViewHeight;
    private int mLikeViewWidth;
    private final Queue<ImageView> mLikeViews;
    private LikeAnimListener mListener;
    private Random mRandom;
    private LikeAnimTouchHelper mTouchHelper;

    public interface LikeAnimListener {
        void onDoubleTab();

        void onLongClick();

        void onLongClickCancel();

        void onSingleTab();
    }

    public DJXLikeAnimLayout(Context context) {
        super(context);
        this.mLikeViews = new LinkedList();
        this.mIsCanShowLikeAnim = true;
        init(context);
    }

    public DJXLikeAnimLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLikeViews = new LinkedList();
        this.mIsCanShowLikeAnim = true;
        init(context);
    }

    public DJXLikeAnimLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLikeViews = new LinkedList();
        this.mIsCanShowLikeAnim = true;
        init(context);
    }

    public DJXLikeAnimLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mLikeViews = new LinkedList();
        this.mIsCanShowLikeAnim = true;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mRandom = new SecureRandom();
        this.mLikeViewWidth = UIUtil.dp2px(72.0f);
        this.mLikeViewHeight = UIUtil.dp2px(79.0f);
        this.mTouchHelper = new LikeAnimTouchHelper(context, this);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.djx.core.business.view.like.DJXLikeAnimLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return DJXLikeAnimLayout.this.mTouchHelper.onTouch(motionEvent);
            }
        });
    }

    public void setCanShowLikeAnim(boolean z) {
        this.mIsCanShowLikeAnim = z;
    }

    public void setListener(LikeAnimListener likeAnimListener) {
        this.mListener = likeAnimListener;
        LikeAnimTouchHelper likeAnimTouchHelper = this.mTouchHelper;
        if (likeAnimTouchHelper != null) {
            likeAnimTouchHelper.setListener(likeAnimListener);
        }
    }

    public LikeAnimListener getListener() {
        return this.mListener;
    }

    public void showLikeView(float f, float f2) {
        ImageView imageViewPoll;
        if (this.mIsCanShowLikeAnim) {
            if (this.mLikeViews.isEmpty()) {
                imageViewPoll = new ImageView(this.mContext);
                if (mSrcDrawable == null) {
                    mSrcDrawable = ContextCompat.getDrawable(this.mContext, R.drawable.djx_like_big);
                }
            } else {
                imageViewPoll = this.mLikeViews.poll();
            }
            if (imageViewPoll != null) {
                imageViewPoll.setImageDrawable(mSrcDrawable);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mLikeViewWidth, this.mLikeViewHeight);
                layoutParams.setMargins((int) (f - (this.mLikeViewWidth / 2)), (int) (f2 - this.mLikeViewHeight), 0, 0);
                imageViewPoll.setLayoutParams(layoutParams);
                if (imageViewPoll.getParent() == null) {
                    addView(imageViewPoll);
                }
                startAnimation(imageViewPoll);
            }
        }
    }

    private void startAnimation(final ImageView imageView) {
        float fNextInt = this.mRandom.nextInt(40) - 20;
        imageView.setRotation(fNextInt);
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.6f, 1.0f, 1.6f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillBefore(true);
        scaleAnimation.setDuration(300L);
        AnimationSet animationSet2 = new AnimationSet(true);
        animationSet2.setDuration(500L);
        animationSet2.setStartOffset(500L);
        animationSet2.setFillAfter(true);
        animationSet2.setInterpolator(new DecelerateInterpolator());
        float fNextInt2 = (this.mRandom.nextInt(10) + 20.0f) / 10.0f;
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.6f, fNextInt2, 1.6f, fNextInt2, 1, 0.5f, 1, 1.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        int iDp2px = UIUtil.dp2px(50.0f);
        float f = -(this.mRandom.nextInt(iDp2px) + iDp2px);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) (f * Math.tan((fNextInt * 3.141592653589793d) / 360.0d)), 0.0f, f);
        animationSet2.addAnimation(scaleAnimation2);
        animationSet2.addAnimation(alphaAnimation);
        animationSet2.addAnimation(translateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(animationSet2);
        imageView.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.djx.core.business.view.like.DJXLikeAnimLayout.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                DJXLikeAnimLayout.this.post(new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.like.DJXLikeAnimLayout.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DJXLikeAnimLayout.this.mLikeViews.size() < 3) {
                            DJXLikeAnimLayout.this.mLikeViews.add(imageView);
                        }
                        imageView.setImageDrawable(null);
                        imageView.clearAnimation();
                        DJXLikeAnimLayout.this.removeView(imageView);
                    }
                });
            }
        });
    }

    public void release() {
        clearAnimation();
        removeAllViews();
        LikeAnimTouchHelper likeAnimTouchHelper = this.mTouchHelper;
        if (likeAnimTouchHelper != null) {
            likeAnimTouchHelper.release();
        }
    }

    public void setAnimDrawable(Drawable drawable) {
        mSrcDrawable = drawable;
    }
}
