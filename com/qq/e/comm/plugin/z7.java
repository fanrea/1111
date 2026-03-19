package com.qq.e.comm.plugin;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.qq.e.comm.plugin.y7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class z7 implements y7 {
    private final String a;
    private final Animator b;
    private final x7 c;
    private t2 d;
    private boolean e;
    private boolean f;

    @Override // com.qq.e.comm.plugin.y7
    public void a(float f) {
    }

    private z7(String str, List<Animator> list, x7 x7Var) {
        int size;
        this.a = str;
        this.c = x7Var;
        if (list != null && (size = list.size()) > 0) {
            Animator animator = list.get(0);
            if (size == 1) {
                this.b = animator;
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(list);
            this.b = animatorSet;
            return;
        }
        this.b = null;
    }

    @Override // com.qq.e.comm.plugin.y7, android.animation.ValueAnimator, android.animation.Animator
    public void start() {
        a((r2) null);
    }

    @Override // com.qq.e.comm.plugin.y7
    public void a(r2 r2Var) {
        if (this.b == null) {
            return;
        }
        this.e = true;
        x7 x7Var = this.c;
        if (x7Var != null) {
            if (r2Var != null) {
                if (this.d == null) {
                    t2 t2Var = new t2(x7Var);
                    this.d = t2Var;
                    this.c.b.addListener(t2Var);
                }
                this.d.a(r2Var);
            } else {
                t2 t2Var2 = this.d;
                if (t2Var2 != null) {
                    x7Var.b.removeListener(t2Var2);
                }
            }
        }
        this.b.start();
    }

    @Override // com.qq.e.comm.plugin.y7
    public void cancel() {
        ArrayList<Animator> childAnimations;
        Animator animator = this.b;
        if (animator == null || !this.e) {
            return;
        }
        this.e = false;
        if (animator.isStarted()) {
            this.b.cancel();
        }
        Animator animator2 = this.b;
        if ((animator2 instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator2).getChildAnimations()) != null && childAnimations.size() > 0) {
            Iterator<Animator> it = childAnimations.iterator();
            while (it.hasNext()) {
                Animator next = it.next();
                if (next.isStarted()) {
                    next.cancel();
                } else {
                    ArrayList<Animator.AnimatorListener> listeners = next.getListeners();
                    if (listeners != null && listeners.size() > 0) {
                        Iterator<Animator.AnimatorListener> it2 = listeners.iterator();
                        while (it2.hasNext()) {
                            it2.next().onAnimationCancel(next);
                        }
                    }
                }
            }
        }
    }

    @Override // com.qq.e.comm.plugin.y7
    public void pause() {
        if (!this.e || this.f) {
            return;
        }
        this.f = true;
        cancel();
    }

    @Override // com.qq.e.comm.plugin.y7
    public void resume() {
        if (this.f) {
            this.f = false;
            start();
        }
    }

    /* compiled from: A */
    public static class b implements y7.a {
        private final String a;
        private x7 c;
        private final List<Animator> b = new ArrayList();
        private boolean d = true;

        public b(String str) {
            this.a = str;
        }

        private boolean a(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }

        @Override // com.qq.e.comm.plugin.y7.a
        public void a(x7 x7Var) {
            if (x7Var != null) {
                String str = this.a;
                s2 s2Var = x7Var.a;
                if (a(str, s2Var.b)) {
                    if (this.d) {
                        int i = s2Var.k;
                        if (i < 0) {
                            this.d = false;
                            this.c = null;
                        } else {
                            x7 x7Var2 = this.c;
                            if (x7Var2 == null || i > x7Var2.a.k) {
                                this.c = x7Var;
                            }
                        }
                    }
                    this.b.add(x7Var.b);
                }
            }
        }

        @Override // com.qq.e.comm.plugin.y7.a
        public y7 a() {
            return new z7(this.a, this.b, this.c);
        }
    }
}
