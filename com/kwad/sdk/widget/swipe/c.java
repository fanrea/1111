package com.kwad.sdk.widget.swipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c extends d {
    private static final Interpolator aAm = new AccelerateDecelerateInterpolator();
    private static final Interpolator cqo = new Interpolator() { // from class: com.kwad.sdk.widget.swipe.c.1
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private final int WI;
    private final int WJ;
    private float axW = 1.0f;
    private long cql;
    private boolean cqm;
    private boolean cqn;
    private a cqp;
    private boolean cqq;
    private float jn;
    private float jo;
    private boolean mIsBeingDragged;
    private final int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    static /* synthetic */ void b(c cVar, float f) {
    }

    public c(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.WI = (int) (context.getResources().getDisplayMetrics().density * 400.0f);
        this.WJ = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
    }

    public final void a(a aVar) {
        this.cqp = aVar;
    }

    public final a aqY() {
        return this.cqp;
    }

    public final boolean aqZ() {
        return this.axW != 1.0f;
    }

    public final void ara() {
        float f = this.axW;
        if (f != 1.0f) {
            this.cqq = false;
            a(f, 1.0f, false);
        }
    }

    @Override // com.kwad.sdk.widget.swipe.d
    protected final void b(View view, MotionEvent motionEvent) {
        c(view, motionEvent);
    }

    @Override // com.kwad.sdk.widget.swipe.d
    protected final boolean n(MotionEvent motionEvent) {
        return p(motionEvent);
    }

    @Override // com.kwad.sdk.widget.swipe.d
    protected final boolean o(MotionEvent motionEvent) {
        return q(motionEvent);
    }

    private void c(View view, MotionEvent motionEvent) {
        if (this.cqp == null) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean p(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.cqn
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r8.getAction()
            java.lang.String r2 = "SwipeToProfileListTouchDetector"
            r3 = 0
            if (r0 == 0) goto L84
            if (r0 == r1) goto L77
            r4 = 2
            if (r0 == r4) goto L19
            r1 = 3
            if (r0 == r1) goto L77
            goto Lae
        L19:
            float r0 = r8.getX()
            float r4 = r7.jn
            float r0 = r0 - r4
            float r4 = java.lang.Math.abs(r0)
            float r5 = r8.getY()
            float r6 = r7.jo
            float r5 = r5 - r6
            float r5 = java.lang.Math.abs(r5)
            com.kwad.sdk.widget.swipe.a r6 = r7.cqp
            if (r6 == 0) goto L58
            int r6 = r7.mTouchSlop
            float r6 = (float) r6
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L58
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L58
            float r4 = r7.axW
            r5 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            r5 = 0
            if (r4 >= 0) goto L50
            int r4 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r4 <= 0) goto L4c
            goto L4d
        L4c:
            r1 = r3
        L4d:
            r7.mIsBeingDragged = r1
            goto L58
        L50:
            int r4 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r4 >= 0) goto L55
            goto L56
        L55:
            r1 = r3
        L56:
            r7.mIsBeingDragged = r1
        L58:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "handlerInterceptTouchEvent ACTION_MOVE dx="
            r1.<init>(r3)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = "--mIsBeingDragged: "
            java.lang.StringBuilder r0 = r0.append(r1)
            boolean r1 = r7.mIsBeingDragged
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.kwad.sdk.core.d.c.d(r2, r0)
            goto Lae
        L77:
            r7.mIsBeingDragged = r3
            android.view.VelocityTracker r0 = r7.mVelocityTracker
            if (r0 == 0) goto Lae
            r0.recycle()
            r0 = 0
            r7.mVelocityTracker = r0
            goto Lae
        L84:
            r7.mIsBeingDragged = r3
            r7.cqm = r3
            r0 = 0
            r7.cql = r0
            r7.cqq = r3
            float r0 = r8.getX()
            r7.jn = r0
            float r0 = r8.getY()
            r7.jo = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "handlerInterceptTouchEvent ACTION_DOWN mInitialMotionX: "
            r0.<init>(r1)
            float r1 = r7.jn
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.kwad.sdk.core.d.c.d(r2, r0)
        Lae:
            android.view.VelocityTracker r0 = r7.mVelocityTracker
            if (r0 != 0) goto Lb8
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r7.mVelocityTracker = r0
        Lb8:
            android.view.VelocityTracker r0 = r7.mVelocityTracker
            r0.addMovement(r8)
            boolean r8 = r7.mIsBeingDragged
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.widget.swipe.c.p(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean q(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.widget.swipe.c.q(android.view.MotionEvent):boolean");
    }

    private void arb() {
        int iArc = arc();
        if (Math.abs(iArc) < this.WI) {
            float f = this.axW;
            if (f > 0.5f) {
                a(f, 1.0f, true);
                return;
            }
        } else if (iArc >= 0) {
            a(this.axW, 1.0f, true);
            return;
        }
        a(this.axW, 0.0f, true);
    }

    private void a(float f, final float f2, boolean z) {
        if (!this.cqq) {
            this.cqq = true;
            a aVar = this.cqp;
            if (aVar != null) {
                aVar.o(f);
            }
        }
        a aVar2 = this.cqp;
        if (aVar2 != null) {
            aVar2.n(f2);
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.setDuration(250L);
        valueAnimatorOfFloat.setInterpolator(z ? cqo : aAm);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.widget.swipe.c.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.cqp != null) {
                    c.this.axW = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c.this.cqp.j(c.this.axW);
                }
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.widget.swipe.c.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                c.this.cqn = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.cqn = false;
                if (c.this.cqp != null) {
                    c.this.cqp.p(f2);
                }
                c.b(c.this, f2);
            }
        });
        valueAnimatorOfFloat.start();
    }

    private boolean r(MotionEvent motionEvent) {
        if (this.cql == 0) {
            this.cql = SystemClock.elapsedRealtime();
        }
        if (SystemClock.elapsedRealtime() - this.cql >= 80 || Math.abs(arc()) < this.WI) {
            return false;
        }
        this.jn = motionEvent.getX();
        return true;
    }

    private int arc() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, this.WJ);
        return (int) velocityTracker.getXVelocity();
    }

    private float m(float f) {
        a aVar = this.cqp;
        if (aVar != null) {
            return aVar.m(f);
        }
        return 0.0f;
    }
}
