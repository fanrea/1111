package com.tk.core.component.a;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    private final com.tk.core.component.e<?> abI;
    private final String abJ;
    private final long abK;
    private final float abL;
    private final float abM;

    public b(com.tk.core.component.e<?> eVar, String str, long j, float f, float f2) {
        this.abI = eVar;
        this.abJ = str;
        this.abK = j;
        this.abL = f;
        this.abM = f2;
    }

    public final void start() {
        com.tk.core.component.e<?> eVar;
        if (TextUtils.isEmpty(this.abJ) || (eVar = this.abI) == null || eVar.pR() == null) {
            return;
        }
        if (!"height".equals(this.abJ) && !"width".equals(this.abJ)) {
            ObjectAnimator.ofFloat(this.abI.getView(), this.abJ, this.abL, this.abM).setDuration(this.abK).start();
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.abL, this.abM);
        valueAnimatorOfFloat.setDuration(this.abK);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tk.core.component.a.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (b.this.abI == null || b.this.abI.pR() == null || b.this.abI.pR().getYogaNode() == null) {
                    return;
                }
                if ("height".equals(b.this.abJ)) {
                    b.this.abI.pR().getYogaNode().setHeight(((Number) valueAnimator.getAnimatedValue()).intValue());
                } else {
                    b.this.abI.pR().getYogaNode().setWidth(((Number) valueAnimator.getAnimatedValue()).intValue());
                }
                if (b.this.abI.getView().getParent() != null) {
                    b.this.abI.getView().getParent().requestLayout();
                }
            }
        });
        valueAnimatorOfFloat.start();
    }
}
