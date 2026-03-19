package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.b.gb;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DynamicBaseInternalScrollWidgetImp extends DynamicBaseWidgetImp implements u {
    ObjectAnimator d;
    private Runnable de;
    ObjectAnimator hc;
    private int jh;
    private boolean sy;

    public DynamicBaseInternalScrollWidgetImp(Context context, DynamicRootView dynamicRootView, gb gbVar) {
        super(context, dynamicRootView, gbVar);
        this.jh = 0;
        this.sy = false;
        this.de = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicBaseInternalScrollWidgetImp.this.tt();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt() {
        final View childAt;
        final View childAt2 = getChildAt(this.jh);
        int i = this.jh;
        if (i == 0) {
            this.sy = false;
        }
        if (i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.jh + 1)).getChildCount() <= 0) {
            this.sy = true;
            childAt = getChildAt(this.jh - 1);
            this.d = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (this.h + getChildAt(this.jh).getWidth()) / 2);
        } else {
            childAt = getChildAt(this.jh + 1);
            this.d = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(this.h + getChildAt(this.jh).getWidth())) / 2);
        }
        this.d.setInterpolator(new LinearInterpolator());
        this.d.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.2
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
                childAt2.setVisibility(8);
            }
        });
        if (this.sy) {
            this.hc = ObjectAnimator.ofFloat(childAt, "translationX", (-(this.h + childAt.getWidth())) / 2, 0.0f);
        } else {
            this.hc = ObjectAnimator.ofFloat(childAt, "translationX", (this.h + childAt.getWidth()) / 2, 0.0f);
        }
        this.hc.setInterpolator(new LinearInterpolator());
        this.hc.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseInternalScrollWidgetImp.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt.setVisibility(0);
            }
        });
        this.d.setDuration(500L);
        this.hc.setDuration(500L);
        this.d.start();
        this.hc.start();
        if (this.sy) {
            this.jh--;
        } else {
            this.jh++;
        }
        postDelayed(this.de, 2000L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.gb - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.de, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public void hc() {
        removeCallbacks(this.de);
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.d.cancel();
        }
        ObjectAnimator objectAnimator2 = this.hc;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.hc.cancel();
        }
        super.hc();
    }
}
