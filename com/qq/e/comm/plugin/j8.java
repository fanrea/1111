package com.qq.e.comm.plugin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class j8 implements View.OnClickListener {
    private final View a;
    private final d b;
    private final e c;
    private int h;
    private int i;
    private f j;
    private int m;
    private Point d = new Point(0, 0);
    private int n = zu.a(6.0d);
    private int f = 300;
    private int g = 300;
    private Point e = new Point(0, 0);

    /* compiled from: A */
    interface f {
        void a();

        void b();
    }

    public j8(View view) {
        this.a = view;
        this.b = new d(view);
        this.c = new e(view);
        view.post(new a());
        view.setOnClickListener(this);
    }

    /* compiled from: A */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j8.this.d = new Point((int) j8.this.a.getX(), (int) j8.this.a.getY());
            j8 j8Var = j8.this;
            j8Var.h = j8Var.a.getWidth();
            j8 j8Var2 = j8.this;
            j8Var2.i = j8Var2.a.getHeight();
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = j8.this.a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(j8.this.n, j8.this.n, j8.this.n, j8.this.n);
            }
            j8.this.a.setLayoutParams(layoutParams);
            j8.this.b.a(j8.this.e.x, j8.this.e.y, j8.this.f, j8.this.g, 300L, new a());
        }

        /* compiled from: A */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                j8.this.m = 1;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                j8.this.m = 2;
                j8.this.c.a(true);
            }
        }
    }

    public void e() {
        if (c()) {
            return;
        }
        this.a.post(new b());
    }

    /* compiled from: A */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = j8.this.a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            }
            j8.this.c.a(false);
            j8.this.a.setLayoutParams(layoutParams);
            j8.this.b.a(j8.this.d.x, j8.this.d.y, j8.this.h, j8.this.i, 300L, new a());
        }

        /* compiled from: A */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                j8.this.m = 3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                j8.this.m = 0;
            }
        }
    }

    public boolean d() {
        return b() == 0 || b() == 3;
    }

    public int b() {
        return this.m;
    }

    private void f() {
        if (d()) {
            return;
        }
        f fVar = this.j;
        if (fVar != null) {
            fVar.b();
        }
        this.a.post(new c());
    }

    public void a() {
        this.c.g = true;
        int width = -this.f;
        Object parent = this.a.getParent();
        if (parent != null) {
            View view = (View) parent;
            if (this.a.getX() + ((this.f * 1.0f) / 2.0f) > (view.getWidth() * 1.0f) / 2.0f) {
                width = view.getWidth();
            }
        }
        this.b.a(width, b() == 2 ? 300 : 0, this.j);
    }

    public boolean c() {
        return b() == 2 || b() == 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f();
    }

    /* compiled from: A */
    private static class e implements View.OnTouchListener {
        private boolean a;
        private final int b;
        private float c;
        private float d;
        private boolean e;
        private final View f;
        protected boolean g;

        public e(View view) {
            this.f = view;
            this.b = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            view.setOnTouchListener(this);
        }

        public void a(boolean z) {
            this.a = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.j8.e.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* compiled from: A */
    private static class d {
        private final View a;

        public d(View view) {
            this.a = view;
        }

        /* compiled from: A */
        class a implements ValueAnimator.AnimatorUpdateListener {
            final ViewGroup.MarginLayoutParams a;

            a() {
                this.a = (ViewGroup.MarginLayoutParams) d.this.a.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                d.this.a.setLayoutParams(this.a);
            }
        }

        /* compiled from: A */
        class b implements ValueAnimator.AnimatorUpdateListener {
            final ViewGroup.MarginLayoutParams a;

            b() {
                this.a = (ViewGroup.MarginLayoutParams) d.this.a.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                d.this.a.setLayoutParams(this.a);
            }
        }

        /* compiled from: A */
        class c extends AnimatorListenerAdapter {
            final /* synthetic */ Animator.AnimatorListener a;

            c(Animator.AnimatorListener animatorListener) {
                this.a = animatorListener;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                Animator.AnimatorListener animatorListener = this.a;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Animator.AnimatorListener animatorListener = this.a;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                Animator.AnimatorListener animatorListener = this.a;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }
        }

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.j8$d$d, reason: collision with other inner class name */
        class C0713d extends AnimatorListenerAdapter {
            final /* synthetic */ f a;

            C0713d(f fVar) {
                this.a = fVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f fVar = this.a;
                if (fVar != null) {
                    fVar.a();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, long j, f fVar) {
            ViewPropertyAnimator viewPropertyAnimatorX = this.a.animate().x(i);
            viewPropertyAnimatorX.setDuration(j);
            viewPropertyAnimatorX.setListener(new C0713d(fVar));
            viewPropertyAnimatorX.start();
        }

        public void a(int i, int i2, int i3, int i4, long j, Animator.AnimatorListener animatorListener) {
            ViewPropertyAnimator listener = this.a.animate().x(i).y(i2).setListener(null);
            if (j >= 0) {
                listener.setDuration(j);
            }
            listener.start();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.a.getWidth(), i3);
            valueAnimatorOfInt.addUpdateListener(new a());
            if (j >= 0) {
                valueAnimatorOfInt.setDuration(j);
            }
            valueAnimatorOfInt.start();
            ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(this.a.getHeight(), i4);
            valueAnimatorOfInt2.addUpdateListener(new b());
            if (j >= 0) {
                valueAnimatorOfInt2.setDuration(j);
            }
            valueAnimatorOfInt2.addListener(new c(animatorListener));
            valueAnimatorOfInt2.start();
        }
    }

    public void a(f fVar) {
        this.j = fVar;
    }

    public j8 a(Point point) {
        this.e = point;
        return this;
    }

    public j8 a(int i, int i2) {
        this.f = i;
        this.g = i2;
        return this;
    }
}
