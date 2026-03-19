package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.mobads.container.util.animation.j;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc extends c {
    private float an;
    private d c;
    private float u;

    public tc(View view, com.bytedance.sdk.component.adexpress.dynamic.b.d dVar) {
        super(view, dVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.d.c
    List<ObjectAnimator> d() {
        int i;
        String str;
        if ((this.b instanceof ImageView) && (this.b.getParent() instanceof DynamicBaseWidget)) {
            this.b = (View) this.b.getParent();
        }
        this.b.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.b, "alpha", 0.0f, 1.0f).setDuration((int) (this.hc.tc() * 1000.0d));
        this.c = new d(this.b);
        final int i2 = this.b.getLayoutParams().height;
        this.u = i2;
        this.an = this.b.getLayoutParams().width;
        if (j.d.equals(this.hc.d()) || j.e.equals(this.hc.d())) {
            i = (int) this.an;
            str = "width";
        } else {
            str = "height";
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.c, str, 0, i).setDuration((int) (this.hc.tc() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(d(duration));
        arrayList.add(d(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.d.tc.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                tc.this.c.d(i2);
            }
        });
        return arrayList;
    }

    private class d {
        private View hc;

        public d(View view) {
            this.hc = view;
        }

        public void d(int i) {
            if (j.f.equals(tc.this.hc.d())) {
                if (tc.this.b instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) tc.this.b).getChildCount(); i2++) {
                        ((ViewGroup) tc.this.b).getChildAt(i2).setTranslationY(i - tc.this.u);
                    }
                }
                tc.this.b.setTranslationY(tc.this.u - i);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.hc.getLayoutParams();
            layoutParams.height = i;
            this.hc.setLayoutParams(layoutParams);
            this.hc.requestLayout();
        }
    }
}
