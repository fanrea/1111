package com.bytedance.sdk.djx.core.business.view;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXSwitchButton extends View implements Checkable {
    private final int ANIMATE_STATE_DRAGING;
    private final int ANIMATE_STATE_NONE;
    private final int ANIMATE_STATE_PENDING_DRAG;
    private final int ANIMATE_STATE_PENDING_RESET;
    private final int ANIMATE_STATE_PENDING_SETTLE;
    private final int ANIMATE_STATE_SWITCH;
    private ViewState afterState;
    private int animateState;
    private Animator.AnimatorListener animatorListener;
    private ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
    private final ArgbEvaluator argbEvaluator;
    private int background;
    private ViewState beforeState;
    private int borderWidth;
    private float bottom;
    private float buttonMaxX;
    private float buttonMinX;
    private Paint buttonPaint;
    private float buttonRadius;
    private float centerX;
    private float centerY;
    private int checkLineColor;
    private float checkLineLength;
    private int checkLineWidth;
    private int checkedColor;
    private float checkedLineOffsetX;
    private float checkedLineOffsetY;
    private boolean enableEffect;
    private float height;
    private boolean isChecked;
    private boolean isEventBroadcast;
    private boolean isTouchingDown;
    private boolean isUiInited;
    private float left;
    private OnCheckedChangeListener onCheckedChangeListener;
    private Paint paint;
    private Runnable postPendingDrag;
    private RectF rect;
    private float right;
    private int shadowColor;
    private boolean shadowEffect;
    private int shadowOffset;
    private int shadowRadius;
    private boolean showIndicator;
    private float top;
    private long touchDownTime;
    private int uncheckCircleColor;
    private float uncheckCircleOffsetX;
    private float uncheckCircleRadius;
    private int uncheckCircleWidth;
    private int uncheckColor;
    private ValueAnimator valueAnimator;
    private float viewRadius;
    private ViewState viewState;
    private float width;
    private static final int DEFAULT_WIDTH = dp2pxInt(58.0f);
    private static final int DEFAULT_HEIGHT = dp2pxInt(36.0f);

    public interface OnCheckedChangeListener {
        void onCheckedChanged(DJXSwitchButton dJXSwitchButton, boolean z);
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override // android.view.View
    public final void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
    }

    public DJXSwitchButton(Context context) {
        super(context);
        this.ANIMATE_STATE_NONE = 0;
        this.ANIMATE_STATE_PENDING_DRAG = 1;
        this.ANIMATE_STATE_DRAGING = 2;
        this.ANIMATE_STATE_PENDING_RESET = 3;
        this.ANIMATE_STATE_PENDING_SETTLE = 4;
        this.ANIMATE_STATE_SWITCH = 5;
        this.rect = new RectF();
        this.animateState = 0;
        this.argbEvaluator = new ArgbEvaluator();
        this.isTouchingDown = false;
        this.isUiInited = false;
        this.isEventBroadcast = false;
        this.postPendingDrag = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.1
            @Override // java.lang.Runnable
            public void run() {
                if (DJXSwitchButton.this.isInAnimating()) {
                    return;
                }
                DJXSwitchButton.this.pendingDragState();
            }
        };
        this.animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = DJXSwitchButton.this.animateState;
                if (i == 1 || i == 3 || i == 4) {
                    DJXSwitchButton.this.viewState.checkedLineColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(fFloatValue, Integer.valueOf(DJXSwitchButton.this.beforeState.checkedLineColor), Integer.valueOf(DJXSwitchButton.this.afterState.checkedLineColor))).intValue();
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.beforeState.radius + ((DJXSwitchButton.this.afterState.radius - DJXSwitchButton.this.beforeState.radius) * fFloatValue);
                    if (DJXSwitchButton.this.animateState != 1) {
                        DJXSwitchButton.this.viewState.buttonX = DJXSwitchButton.this.beforeState.buttonX + ((DJXSwitchButton.this.afterState.buttonX - DJXSwitchButton.this.beforeState.buttonX) * fFloatValue);
                    }
                    DJXSwitchButton.this.viewState.checkStateColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(fFloatValue, Integer.valueOf(DJXSwitchButton.this.beforeState.checkStateColor), Integer.valueOf(DJXSwitchButton.this.afterState.checkStateColor))).intValue();
                } else if (i == 5) {
                    DJXSwitchButton.this.viewState.buttonX = DJXSwitchButton.this.beforeState.buttonX + ((DJXSwitchButton.this.afterState.buttonX - DJXSwitchButton.this.beforeState.buttonX) * fFloatValue);
                    float f = (DJXSwitchButton.this.viewState.buttonX - DJXSwitchButton.this.buttonMinX) / (DJXSwitchButton.this.buttonMaxX - DJXSwitchButton.this.buttonMinX);
                    DJXSwitchButton.this.viewState.checkStateColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(f, Integer.valueOf(DJXSwitchButton.this.uncheckColor), Integer.valueOf(DJXSwitchButton.this.checkedColor))).intValue();
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.viewRadius * f;
                    DJXSwitchButton.this.viewState.checkedLineColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(f, 0, Integer.valueOf(DJXSwitchButton.this.checkLineColor))).intValue();
                }
                DJXSwitchButton.this.postInvalidate();
            }
        };
        this.animatorListener = new Animator.AnimatorListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.3
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
            public void onAnimationEnd(Animator animator) {
                int i = DJXSwitchButton.this.animateState;
                if (i == 1) {
                    DJXSwitchButton.this.animateState = 2;
                    DJXSwitchButton.this.viewState.checkedLineColor = 0;
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.viewRadius;
                    DJXSwitchButton.this.postInvalidate();
                    return;
                }
                if (i == 3) {
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    return;
                }
                if (i == 4) {
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    DJXSwitchButton.this.broadcastEvent();
                } else {
                    if (i != 5) {
                        return;
                    }
                    DJXSwitchButton dJXSwitchButton = DJXSwitchButton.this;
                    dJXSwitchButton.isChecked = true ^ dJXSwitchButton.isChecked;
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    DJXSwitchButton.this.broadcastEvent();
                }
            }
        };
        init(context, null);
    }

    public DJXSwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ANIMATE_STATE_NONE = 0;
        this.ANIMATE_STATE_PENDING_DRAG = 1;
        this.ANIMATE_STATE_DRAGING = 2;
        this.ANIMATE_STATE_PENDING_RESET = 3;
        this.ANIMATE_STATE_PENDING_SETTLE = 4;
        this.ANIMATE_STATE_SWITCH = 5;
        this.rect = new RectF();
        this.animateState = 0;
        this.argbEvaluator = new ArgbEvaluator();
        this.isTouchingDown = false;
        this.isUiInited = false;
        this.isEventBroadcast = false;
        this.postPendingDrag = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.1
            @Override // java.lang.Runnable
            public void run() {
                if (DJXSwitchButton.this.isInAnimating()) {
                    return;
                }
                DJXSwitchButton.this.pendingDragState();
            }
        };
        this.animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = DJXSwitchButton.this.animateState;
                if (i == 1 || i == 3 || i == 4) {
                    DJXSwitchButton.this.viewState.checkedLineColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(fFloatValue, Integer.valueOf(DJXSwitchButton.this.beforeState.checkedLineColor), Integer.valueOf(DJXSwitchButton.this.afterState.checkedLineColor))).intValue();
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.beforeState.radius + ((DJXSwitchButton.this.afterState.radius - DJXSwitchButton.this.beforeState.radius) * fFloatValue);
                    if (DJXSwitchButton.this.animateState != 1) {
                        DJXSwitchButton.this.viewState.buttonX = DJXSwitchButton.this.beforeState.buttonX + ((DJXSwitchButton.this.afterState.buttonX - DJXSwitchButton.this.beforeState.buttonX) * fFloatValue);
                    }
                    DJXSwitchButton.this.viewState.checkStateColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(fFloatValue, Integer.valueOf(DJXSwitchButton.this.beforeState.checkStateColor), Integer.valueOf(DJXSwitchButton.this.afterState.checkStateColor))).intValue();
                } else if (i == 5) {
                    DJXSwitchButton.this.viewState.buttonX = DJXSwitchButton.this.beforeState.buttonX + ((DJXSwitchButton.this.afterState.buttonX - DJXSwitchButton.this.beforeState.buttonX) * fFloatValue);
                    float f = (DJXSwitchButton.this.viewState.buttonX - DJXSwitchButton.this.buttonMinX) / (DJXSwitchButton.this.buttonMaxX - DJXSwitchButton.this.buttonMinX);
                    DJXSwitchButton.this.viewState.checkStateColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(f, Integer.valueOf(DJXSwitchButton.this.uncheckColor), Integer.valueOf(DJXSwitchButton.this.checkedColor))).intValue();
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.viewRadius * f;
                    DJXSwitchButton.this.viewState.checkedLineColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(f, 0, Integer.valueOf(DJXSwitchButton.this.checkLineColor))).intValue();
                }
                DJXSwitchButton.this.postInvalidate();
            }
        };
        this.animatorListener = new Animator.AnimatorListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.3
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
            public void onAnimationEnd(Animator animator) {
                int i = DJXSwitchButton.this.animateState;
                if (i == 1) {
                    DJXSwitchButton.this.animateState = 2;
                    DJXSwitchButton.this.viewState.checkedLineColor = 0;
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.viewRadius;
                    DJXSwitchButton.this.postInvalidate();
                    return;
                }
                if (i == 3) {
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    return;
                }
                if (i == 4) {
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    DJXSwitchButton.this.broadcastEvent();
                } else {
                    if (i != 5) {
                        return;
                    }
                    DJXSwitchButton dJXSwitchButton = DJXSwitchButton.this;
                    dJXSwitchButton.isChecked = true ^ dJXSwitchButton.isChecked;
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    DJXSwitchButton.this.broadcastEvent();
                }
            }
        };
        init(context, attributeSet);
    }

    public DJXSwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ANIMATE_STATE_NONE = 0;
        this.ANIMATE_STATE_PENDING_DRAG = 1;
        this.ANIMATE_STATE_DRAGING = 2;
        this.ANIMATE_STATE_PENDING_RESET = 3;
        this.ANIMATE_STATE_PENDING_SETTLE = 4;
        this.ANIMATE_STATE_SWITCH = 5;
        this.rect = new RectF();
        this.animateState = 0;
        this.argbEvaluator = new ArgbEvaluator();
        this.isTouchingDown = false;
        this.isUiInited = false;
        this.isEventBroadcast = false;
        this.postPendingDrag = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.1
            @Override // java.lang.Runnable
            public void run() {
                if (DJXSwitchButton.this.isInAnimating()) {
                    return;
                }
                DJXSwitchButton.this.pendingDragState();
            }
        };
        this.animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i2 = DJXSwitchButton.this.animateState;
                if (i2 == 1 || i2 == 3 || i2 == 4) {
                    DJXSwitchButton.this.viewState.checkedLineColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(fFloatValue, Integer.valueOf(DJXSwitchButton.this.beforeState.checkedLineColor), Integer.valueOf(DJXSwitchButton.this.afterState.checkedLineColor))).intValue();
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.beforeState.radius + ((DJXSwitchButton.this.afterState.radius - DJXSwitchButton.this.beforeState.radius) * fFloatValue);
                    if (DJXSwitchButton.this.animateState != 1) {
                        DJXSwitchButton.this.viewState.buttonX = DJXSwitchButton.this.beforeState.buttonX + ((DJXSwitchButton.this.afterState.buttonX - DJXSwitchButton.this.beforeState.buttonX) * fFloatValue);
                    }
                    DJXSwitchButton.this.viewState.checkStateColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(fFloatValue, Integer.valueOf(DJXSwitchButton.this.beforeState.checkStateColor), Integer.valueOf(DJXSwitchButton.this.afterState.checkStateColor))).intValue();
                } else if (i2 == 5) {
                    DJXSwitchButton.this.viewState.buttonX = DJXSwitchButton.this.beforeState.buttonX + ((DJXSwitchButton.this.afterState.buttonX - DJXSwitchButton.this.beforeState.buttonX) * fFloatValue);
                    float f = (DJXSwitchButton.this.viewState.buttonX - DJXSwitchButton.this.buttonMinX) / (DJXSwitchButton.this.buttonMaxX - DJXSwitchButton.this.buttonMinX);
                    DJXSwitchButton.this.viewState.checkStateColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(f, Integer.valueOf(DJXSwitchButton.this.uncheckColor), Integer.valueOf(DJXSwitchButton.this.checkedColor))).intValue();
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.viewRadius * f;
                    DJXSwitchButton.this.viewState.checkedLineColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(f, 0, Integer.valueOf(DJXSwitchButton.this.checkLineColor))).intValue();
                }
                DJXSwitchButton.this.postInvalidate();
            }
        };
        this.animatorListener = new Animator.AnimatorListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.3
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
            public void onAnimationEnd(Animator animator) {
                int i2 = DJXSwitchButton.this.animateState;
                if (i2 == 1) {
                    DJXSwitchButton.this.animateState = 2;
                    DJXSwitchButton.this.viewState.checkedLineColor = 0;
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.viewRadius;
                    DJXSwitchButton.this.postInvalidate();
                    return;
                }
                if (i2 == 3) {
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    return;
                }
                if (i2 == 4) {
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    DJXSwitchButton.this.broadcastEvent();
                } else {
                    if (i2 != 5) {
                        return;
                    }
                    DJXSwitchButton dJXSwitchButton = DJXSwitchButton.this;
                    dJXSwitchButton.isChecked = true ^ dJXSwitchButton.isChecked;
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    DJXSwitchButton.this.broadcastEvent();
                }
            }
        };
        init(context, attributeSet);
    }

    public DJXSwitchButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.ANIMATE_STATE_NONE = 0;
        this.ANIMATE_STATE_PENDING_DRAG = 1;
        this.ANIMATE_STATE_DRAGING = 2;
        this.ANIMATE_STATE_PENDING_RESET = 3;
        this.ANIMATE_STATE_PENDING_SETTLE = 4;
        this.ANIMATE_STATE_SWITCH = 5;
        this.rect = new RectF();
        this.animateState = 0;
        this.argbEvaluator = new ArgbEvaluator();
        this.isTouchingDown = false;
        this.isUiInited = false;
        this.isEventBroadcast = false;
        this.postPendingDrag = new Runnable() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.1
            @Override // java.lang.Runnable
            public void run() {
                if (DJXSwitchButton.this.isInAnimating()) {
                    return;
                }
                DJXSwitchButton.this.pendingDragState();
            }
        };
        this.animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i22 = DJXSwitchButton.this.animateState;
                if (i22 == 1 || i22 == 3 || i22 == 4) {
                    DJXSwitchButton.this.viewState.checkedLineColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(fFloatValue, Integer.valueOf(DJXSwitchButton.this.beforeState.checkedLineColor), Integer.valueOf(DJXSwitchButton.this.afterState.checkedLineColor))).intValue();
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.beforeState.radius + ((DJXSwitchButton.this.afterState.radius - DJXSwitchButton.this.beforeState.radius) * fFloatValue);
                    if (DJXSwitchButton.this.animateState != 1) {
                        DJXSwitchButton.this.viewState.buttonX = DJXSwitchButton.this.beforeState.buttonX + ((DJXSwitchButton.this.afterState.buttonX - DJXSwitchButton.this.beforeState.buttonX) * fFloatValue);
                    }
                    DJXSwitchButton.this.viewState.checkStateColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(fFloatValue, Integer.valueOf(DJXSwitchButton.this.beforeState.checkStateColor), Integer.valueOf(DJXSwitchButton.this.afterState.checkStateColor))).intValue();
                } else if (i22 == 5) {
                    DJXSwitchButton.this.viewState.buttonX = DJXSwitchButton.this.beforeState.buttonX + ((DJXSwitchButton.this.afterState.buttonX - DJXSwitchButton.this.beforeState.buttonX) * fFloatValue);
                    float f = (DJXSwitchButton.this.viewState.buttonX - DJXSwitchButton.this.buttonMinX) / (DJXSwitchButton.this.buttonMaxX - DJXSwitchButton.this.buttonMinX);
                    DJXSwitchButton.this.viewState.checkStateColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(f, Integer.valueOf(DJXSwitchButton.this.uncheckColor), Integer.valueOf(DJXSwitchButton.this.checkedColor))).intValue();
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.viewRadius * f;
                    DJXSwitchButton.this.viewState.checkedLineColor = ((Integer) DJXSwitchButton.this.argbEvaluator.evaluate(f, 0, Integer.valueOf(DJXSwitchButton.this.checkLineColor))).intValue();
                }
                DJXSwitchButton.this.postInvalidate();
            }
        };
        this.animatorListener = new Animator.AnimatorListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXSwitchButton.3
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
            public void onAnimationEnd(Animator animator) {
                int i22 = DJXSwitchButton.this.animateState;
                if (i22 == 1) {
                    DJXSwitchButton.this.animateState = 2;
                    DJXSwitchButton.this.viewState.checkedLineColor = 0;
                    DJXSwitchButton.this.viewState.radius = DJXSwitchButton.this.viewRadius;
                    DJXSwitchButton.this.postInvalidate();
                    return;
                }
                if (i22 == 3) {
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    return;
                }
                if (i22 == 4) {
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    DJXSwitchButton.this.broadcastEvent();
                } else {
                    if (i22 != 5) {
                        return;
                    }
                    DJXSwitchButton dJXSwitchButton = DJXSwitchButton.this;
                    dJXSwitchButton.isChecked = true ^ dJXSwitchButton.isChecked;
                    DJXSwitchButton.this.animateState = 0;
                    DJXSwitchButton.this.postInvalidate();
                    DJXSwitchButton.this.broadcastEvent();
                }
            }
        };
        init(context, attributeSet);
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = attributeSet != null ? context.obtainStyledAttributes(attributeSet, R.styleable.DJXSwitchButton) : null;
        this.shadowEffect = optBoolean(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_shadow_effect, true);
        this.uncheckCircleColor = optColor(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_uncheckcircle_color, -5592406);
        this.uncheckCircleWidth = optPixelSize(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_uncheckcircle_width, dp2pxInt(1.5f));
        this.uncheckCircleOffsetX = dp2px(10.0f);
        this.uncheckCircleRadius = optPixelSize(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_uncheckcircle_radius, dp2px(4.0f));
        this.checkedLineOffsetX = dp2px(4.0f);
        this.checkedLineOffsetY = dp2px(4.0f);
        this.shadowRadius = optPixelSize(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_shadow_radius, dp2pxInt(2.5f));
        this.shadowOffset = optPixelSize(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_shadow_offset, dp2pxInt(1.5f));
        this.shadowColor = optColor(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_shadow_color, 855638016);
        this.uncheckColor = optColor(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_uncheck_color, -2236963);
        this.checkedColor = optColor(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_checked_color, -11414681);
        this.borderWidth = optPixelSize(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_border_width, dp2pxInt(1.0f));
        this.checkLineColor = optColor(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_checkline_color, -1);
        this.checkLineWidth = optPixelSize(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_checkline_width, dp2pxInt(1.0f));
        this.checkLineLength = dp2px(6.0f);
        int iOptColor = optColor(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_button_color, -1);
        int iOptInt = optInt(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_effect_duration, 300);
        this.isChecked = optBoolean(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_checked, false);
        this.showIndicator = optBoolean(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_show_indicator, true);
        this.background = optColor(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_background, -1);
        this.enableEffect = optBoolean(typedArrayObtainStyledAttributes, R.styleable.DJXSwitchButton_djx_sb_enable_effect, true);
        if (typedArrayObtainStyledAttributes != null) {
            typedArrayObtainStyledAttributes.recycle();
        }
        this.paint = new Paint(1);
        Paint paint = new Paint(1);
        this.buttonPaint = paint;
        paint.setColor(iOptColor);
        if (this.shadowEffect) {
            this.buttonPaint.setShadowLayer(this.shadowRadius, 0.0f, this.shadowOffset, this.shadowColor);
        }
        this.viewState = new ViewState();
        this.beforeState = new ViewState();
        this.afterState = new ViewState();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.valueAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(iOptInt);
        this.valueAnimator.setRepeatCount(0);
        this.valueAnimator.addUpdateListener(this.animatorUpdateListener);
        this.valueAnimator.addListener(this.animatorListener);
        super.setClickable(true);
        setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode == 0 || mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(DEFAULT_WIDTH, 1073741824);
        }
        if (mode2 == 0 || mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(DEFAULT_HEIGHT, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float fMax = Math.max(this.shadowRadius + this.shadowOffset, this.borderWidth);
        float f = i2 - fMax;
        float f2 = f - fMax;
        this.height = f2;
        float f3 = i - fMax;
        this.width = f3 - fMax;
        float f4 = f2 * 0.5f;
        this.viewRadius = f4;
        this.buttonRadius = f4 - this.borderWidth;
        this.left = fMax;
        this.top = fMax;
        this.right = f3;
        this.bottom = f;
        this.centerX = (fMax + f3) * 0.5f;
        this.centerY = (f + fMax) * 0.5f;
        this.buttonMinX = fMax + f4;
        this.buttonMaxX = f3 - f4;
        if (isChecked()) {
            setCheckedViewState(this.viewState);
        } else {
            setUncheckViewState(this.viewState);
        }
        this.isUiInited = true;
        postInvalidate();
    }

    private void setUncheckViewState(ViewState viewState) {
        viewState.radius = 0.0f;
        viewState.checkStateColor = this.uncheckColor;
        viewState.checkedLineColor = 0;
        viewState.buttonX = this.buttonMinX;
    }

    private void setCheckedViewState(ViewState viewState) {
        viewState.radius = this.viewRadius;
        viewState.checkStateColor = this.checkedColor;
        viewState.checkedLineColor = this.checkLineColor;
        viewState.buttonX = this.buttonMaxX;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.paint.setStrokeWidth(this.borderWidth);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.background);
        drawRoundRect(canvas, this.left, this.top, this.right, this.bottom, this.viewRadius, this.paint);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.uncheckColor);
        drawRoundRect(canvas, this.left, this.top, this.right, this.bottom, this.viewRadius, this.paint);
        if (this.showIndicator) {
            drawUncheckIndicator(canvas);
        }
        float f = this.viewState.radius * 0.5f;
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.viewState.checkStateColor);
        this.paint.setStrokeWidth(this.borderWidth + (f * 2.0f));
        drawRoundRect(canvas, this.left + f, this.top + f, this.right - f, this.bottom - f, this.viewRadius, this.paint);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setStrokeWidth(1.0f);
        float f2 = this.left;
        float f3 = this.top;
        float f4 = this.viewRadius;
        drawArc(canvas, f2, f3, f2 + (f4 * 2.0f), f3 + (f4 * 2.0f), 90.0f, 180.0f, this.paint);
        canvas.drawRect(this.left + this.viewRadius, this.top, this.viewState.buttonX, this.top + (this.viewRadius * 2.0f), this.paint);
        if (this.showIndicator) {
            drawCheckedIndicator(canvas);
        }
        drawButton(canvas, this.viewState.buttonX, this.centerY);
    }

    protected void drawCheckedIndicator(Canvas canvas) {
        int i = this.viewState.checkedLineColor;
        float f = this.checkLineWidth;
        float f2 = this.left;
        float f3 = this.viewRadius;
        float f4 = (f2 + f3) - this.checkedLineOffsetX;
        float f5 = this.centerY;
        float f6 = this.checkLineLength;
        drawCheckedIndicator(canvas, i, f, f4, f5 - f6, (f2 + f3) - this.checkedLineOffsetY, f5 + f6, this.paint);
    }

    protected void drawCheckedIndicator(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        paint.setStrokeWidth(f);
        canvas.drawLine(f2, f3, f4, f5, paint);
    }

    private void drawUncheckIndicator(Canvas canvas) {
        drawUncheckIndicator(canvas, this.uncheckCircleColor, this.uncheckCircleWidth, this.right - this.uncheckCircleOffsetX, this.centerY, this.uncheckCircleRadius, this.paint);
    }

    protected void drawUncheckIndicator(Canvas canvas, int i, float f, float f2, float f3, float f4, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        paint.setStrokeWidth(f);
        canvas.drawCircle(f2, f3, f4, paint);
    }

    private void drawArc(Canvas canvas, float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawArc(f, f2, f3, f4, f5, f6, true, paint);
        } else {
            this.rect.set(f, f2, f3, f4);
            canvas.drawArc(this.rect, f5, f6, true, paint);
        }
    }

    private void drawRoundRect(Canvas canvas, float f, float f2, float f3, float f4, float f5, Paint paint) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(f, f2, f3, f4, f5, f5, paint);
        } else {
            this.rect.set(f, f2, f3, f4);
            canvas.drawRoundRect(this.rect, f5, f5, paint);
        }
    }

    private void drawButton(Canvas canvas, float f, float f2) {
        canvas.drawCircle(f, f2, this.buttonRadius, this.buttonPaint);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(1.0f);
        this.paint.setColor(-2236963);
        canvas.drawCircle(f, f2, this.buttonRadius, this.paint);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (z == isChecked()) {
            postInvalidate();
        } else {
            toggle(this.enableEffect, false);
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.isChecked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean z) {
        toggle(z, true);
    }

    private void toggle(boolean z, boolean z2) {
        if (isEnabled()) {
            if (this.isEventBroadcast) {
                throw new RuntimeException("should NOT switch the state in method: [onCheckedChanged]!");
            }
            if (!this.isUiInited) {
                this.isChecked = !this.isChecked;
                if (z2) {
                    broadcastEvent();
                    return;
                }
                return;
            }
            if (this.valueAnimator.isRunning()) {
                this.valueAnimator.cancel();
            }
            if (!this.enableEffect || !z) {
                this.isChecked = !this.isChecked;
                if (isChecked()) {
                    setCheckedViewState(this.viewState);
                } else {
                    setUncheckViewState(this.viewState);
                }
                postInvalidate();
                if (z2) {
                    broadcastEvent();
                    return;
                }
                return;
            }
            this.animateState = 5;
            this.beforeState.copy(this.viewState);
            if (isChecked()) {
                setUncheckViewState(this.afterState);
            } else {
                setCheckedViewState(this.afterState);
            }
            this.valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastEvent() {
        OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            this.isEventBroadcast = true;
            onCheckedChangeListener.onCheckedChanged(this, isChecked());
        }
        this.isEventBroadcast = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.isTouchingDown = true;
            this.touchDownTime = System.currentTimeMillis();
            removeCallbacks(this.postPendingDrag);
            postDelayed(this.postPendingDrag, 100L);
        } else if (actionMasked == 1) {
            this.isTouchingDown = false;
            removeCallbacks(this.postPendingDrag);
            if (System.currentTimeMillis() - this.touchDownTime <= 300) {
                toggle();
            } else if (isDragState()) {
                boolean z = Math.max(0.0f, Math.min(1.0f, motionEvent.getX() / ((float) getWidth()))) > 0.5f;
                if (z == isChecked()) {
                    pendingCancelDragState();
                } else {
                    this.isChecked = z;
                    pendingSettleState();
                }
            } else if (isPendingDragState()) {
                pendingCancelDragState();
            }
        } else if (actionMasked == 2) {
            float x = motionEvent.getX();
            if (isPendingDragState()) {
                float fMax = Math.max(0.0f, Math.min(1.0f, x / getWidth()));
                ViewState viewState = this.viewState;
                float f = this.buttonMinX;
                viewState.buttonX = f + ((this.buttonMaxX - f) * fMax);
            } else if (isDragState()) {
                float fMax2 = Math.max(0.0f, Math.min(1.0f, x / getWidth()));
                ViewState viewState2 = this.viewState;
                float f2 = this.buttonMinX;
                viewState2.buttonX = f2 + ((this.buttonMaxX - f2) * fMax2);
                this.viewState.checkStateColor = ((Integer) this.argbEvaluator.evaluate(fMax2, Integer.valueOf(this.uncheckColor), Integer.valueOf(this.checkedColor))).intValue();
                postInvalidate();
            }
        } else if (actionMasked == 3) {
            this.isTouchingDown = false;
            removeCallbacks(this.postPendingDrag);
            if (isPendingDragState() || isDragState()) {
                pendingCancelDragState();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInAnimating() {
        return this.animateState != 0;
    }

    private boolean isPendingDragState() {
        int i = this.animateState;
        return i == 1 || i == 3;
    }

    private boolean isDragState() {
        return this.animateState == 2;
    }

    public void setShadowEffect(boolean z) {
        if (this.shadowEffect == z) {
            return;
        }
        this.shadowEffect = z;
        if (z) {
            this.buttonPaint.setShadowLayer(this.shadowRadius, 0.0f, this.shadowOffset, this.shadowColor);
        } else {
            this.buttonPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    public void setEnableEffect(boolean z) {
        this.enableEffect = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pendingDragState() {
        if (!isInAnimating() && this.isTouchingDown) {
            if (this.valueAnimator.isRunning()) {
                this.valueAnimator.cancel();
            }
            this.animateState = 1;
            this.beforeState.copy(this.viewState);
            this.afterState.copy(this.viewState);
            if (isChecked()) {
                this.afterState.checkStateColor = this.checkedColor;
                this.afterState.buttonX = this.buttonMaxX;
                this.afterState.checkedLineColor = this.checkedColor;
            } else {
                this.afterState.checkStateColor = this.uncheckColor;
                this.afterState.buttonX = this.buttonMinX;
                this.afterState.radius = this.viewRadius;
            }
            this.valueAnimator.start();
        }
    }

    private void pendingCancelDragState() {
        if (isDragState() || isPendingDragState()) {
            if (this.valueAnimator.isRunning()) {
                this.valueAnimator.cancel();
            }
            this.animateState = 3;
            this.beforeState.copy(this.viewState);
            if (isChecked()) {
                setCheckedViewState(this.afterState);
            } else {
                setUncheckViewState(this.afterState);
            }
            this.valueAnimator.start();
        }
    }

    private void pendingSettleState() {
        if (this.valueAnimator.isRunning()) {
            this.valueAnimator.cancel();
        }
        this.animateState = 4;
        this.beforeState.copy(this.viewState);
        if (isChecked()) {
            setCheckedViewState(this.afterState);
        } else {
            setUncheckViewState(this.afterState);
        }
        this.valueAnimator.start();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    private static float dp2px(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    private static int dp2pxInt(float f) {
        return (int) dp2px(f);
    }

    private static int optInt(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getInt(i, i2);
    }

    private static float optPixelSize(TypedArray typedArray, int i, float f) {
        return typedArray == null ? f : typedArray.getDimension(i, f);
    }

    private static int optPixelSize(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getDimensionPixelOffset(i, i2);
    }

    private static int optColor(TypedArray typedArray, int i, int i2) {
        return typedArray == null ? i2 : typedArray.getColor(i, i2);
    }

    private static boolean optBoolean(TypedArray typedArray, int i, boolean z) {
        return typedArray == null ? z : typedArray.getBoolean(i, z);
    }

    private static class ViewState {
        float buttonX;
        int checkStateColor;
        int checkedLineColor;
        float radius;

        ViewState() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void copy(ViewState viewState) {
            this.buttonX = viewState.buttonX;
            this.checkStateColor = viewState.checkStateColor;
            this.checkedLineColor = viewState.checkedLineColor;
            this.radius = viewState.radius;
        }
    }
}
