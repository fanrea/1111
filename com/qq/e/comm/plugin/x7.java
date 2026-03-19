package com.qq.e.comm.plugin;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Build;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class x7 {
    private static final boolean e;
    public final s2 a;
    public final ValueAnimator b;
    private float c = 0.0f;
    boolean d = false;

    static {
        e = Build.VERSION.SDK_INT < 24;
    }

    public x7(s2 s2Var, ValueAnimator valueAnimator) {
        this.a = s2Var;
        this.b = valueAnimator;
    }

    void a(float f) {
        if (this.c == f) {
            return;
        }
        this.c = f;
        if (e && f > 1.0f) {
            int i = (int) f;
            if (f == i && (this.a.c() || i % 2 == 1)) {
                f = 1.0f;
            }
        }
        this.b.setCurrentFraction(f);
    }

    /* compiled from: A */
    static abstract class a {
        String a = "DL-Animation-Builder";

        abstract PropertyValuesHolder[] a(s2 s2Var);

        a() {
        }

        x7 a(s2 s2Var, w40 w40Var) {
            PropertyValuesHolder[] propertyValuesHolderArrA;
            if (s2Var == null || w40Var == null || (propertyValuesHolderArrA = a(s2Var)) == null || propertyValuesHolderArrA.length <= 0) {
                return null;
            }
            if (w7.c) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setValues(propertyValuesHolderArrA);
                objectAnimator.setTarget(w40Var);
                objectAnimator.setDuration(s2Var.e);
                objectAnimator.setRepeatCount(s2Var.g);
                objectAnimator.setRepeatMode(s2Var.h);
                objectAnimator.setInterpolator(g20.a(s2Var));
                return new x7(s2Var, objectAnimator);
            }
            ObjectAnimator objectAnimator2 = new ObjectAnimator();
            objectAnimator2.setValues(propertyValuesHolderArrA);
            objectAnimator2.setTarget(w40Var);
            objectAnimator2.setStartDelay(s2Var.d);
            objectAnimator2.setDuration(s2Var.e);
            objectAnimator2.setInterpolator(g20.a(s2Var));
            if (s2Var.f > 0 && s2Var.g > 0) {
                objectAnimator2.addListener(new qv(s2Var));
            } else {
                int i = s2Var.g;
                if (i < 0) {
                    i = -1;
                }
                objectAnimator2.setRepeatCount(i);
                if (s2Var.d()) {
                    objectAnimator2.setRepeatMode(2);
                }
            }
            return new x7(s2Var, objectAnimator2);
        }
    }
}
