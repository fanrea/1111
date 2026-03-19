package com.qq.e.comm.plugin;

import android.animation.Animator;
import android.animation.TimeAnimator;
import com.qq.e.comm.plugin.y7;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class a8 extends TimeAnimator implements y7, TimeAnimator.TimeListener, Animator.AnimatorListener {
    private final String a;
    private final int b;
    private final LinkedList<x7> c;
    private LinkedList<x7> d;
    private r2 e;
    private float f;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    private a8(String str, int i, LinkedList<x7> linkedList) {
        this.f = -1.0f;
        this.a = str;
        this.b = i;
        this.c = linkedList;
        setTimeListener(this);
    }

    @Override // android.animation.TimeAnimator, android.animation.ValueAnimator, android.animation.Animator, com.qq.e.comm.plugin.y7
    public void start() {
        a((r2) null);
    }

    @Override // android.animation.TimeAnimator.TimeListener
    public void onTimeUpdate(TimeAnimator timeAnimator, long j, long j2) {
        a(j, true, false);
    }

    private void a(long j, boolean z, boolean z2) {
        int i;
        long j2;
        float f;
        boolean z3;
        float f2;
        LinkedList<x7> linkedList = this.d;
        if (linkedList == null) {
            return;
        }
        Iterator<x7> itDescendingIterator = z2 ? linkedList.descendingIterator() : linkedList.iterator();
        while (itDescendingIterator.hasNext()) {
            x7 next = itDescendingIterator.next();
            s2 s2Var = next.a;
            if (s2Var.d >= j) {
                next.a(0.0f);
                next.d = false;
            } else {
                int i2 = s2Var.e;
                if (i2 <= 0) {
                    next.a(z2 ? 0.0f : 1.0f);
                    if (z) {
                        itDescendingIterator.remove();
                    }
                } else {
                    int i3 = s2Var.k;
                    if (i3 >= 0 && j >= i3) {
                        next.a(s2Var.g + 1.0f);
                        next.d = false;
                        if (z) {
                            itDescendingIterator.remove();
                        }
                    } else {
                        long j3 = j - s2Var.l;
                        if (j3 > 0) {
                            i = i2;
                            j2 = (j3 % s2Var.m) - s2Var.f;
                            if (j2 > 0 || next.d) {
                            }
                        } else {
                            i = i2;
                            j2 = 0;
                        }
                        if (j3 <= 0) {
                            f2 = ((j - r4) * 1.0f) / i;
                            next.d = j3 != 0;
                        } else {
                            int i4 = i;
                            if (j2 > 0) {
                                f2 = ((int) (j3 / s2Var.m)) + 1 + ((j2 * 1.0f) / i4);
                                next.d = j2 != ((long) i4);
                            } else {
                                if (z2 && s2Var.c()) {
                                    z3 = false;
                                    f = 0.0f;
                                } else {
                                    f = ((int) (j3 / s2Var.m)) + 1;
                                    z3 = false;
                                }
                                next.d = z3;
                                f2 = f;
                            }
                        }
                        next.a(f2);
                    }
                }
            }
        }
        if (z && this.d.size() == 0) {
            this.d = null;
            end();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        r2 r2Var = this.e;
        if (r2Var != null) {
            r2Var.a(this.a);
        }
    }

    /* compiled from: A */
    static class b implements y7.a {
        private final String a;
        private final LinkedList<x7> b = new LinkedList<>();
        private int c = 0;

        public b(String str) {
            this.a = str;
        }

        @Override // com.qq.e.comm.plugin.y7.a
        public void a(x7 x7Var) {
            int i = x7Var.a.k;
            int i2 = this.c;
            if (i2 >= 0) {
                if (i < 0) {
                    this.c = -1;
                } else if (i > i2) {
                    this.c = i;
                }
            }
            this.b.add(x7Var);
        }

        @Override // com.qq.e.comm.plugin.y7.a
        public y7 a() {
            return new a8(this.a, this.c, this.b);
        }
    }

    @Override // com.qq.e.comm.plugin.y7
    public void a(float f) {
        int i;
        if (this.b < 0 || f == this.f) {
            return;
        }
        if (isStarted()) {
            this.d = null;
            cancel();
        }
        if (f > 1.0f) {
            i = this.b;
        } else {
            i = f < 0.0f ? 0 : (int) (this.b * f);
        }
        if (this.d == null) {
            this.d = (LinkedList) this.c.clone();
        }
        a(i, false, f < this.f);
        this.f = f;
    }

    @Override // com.qq.e.comm.plugin.y7
    public void a(r2 r2Var) {
        this.d = (LinkedList) this.c.clone();
        if (r2Var == null) {
            if (this.e != null) {
                this.e = null;
                removeListener(this);
            }
        } else {
            if (this.e == null) {
                addListener(this);
            }
            this.e = r2Var;
        }
        super.start();
    }
}
