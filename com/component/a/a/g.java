package com.component.a.a;

import android.animation.Animator;
import com.component.a.a.f;
import com.component.a.f.e;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class g implements Animator.AnimatorListener {
    final /* synthetic */ f a;
    private final Map<String, Boolean> b = new ConcurrentHashMap();

    g(f fVar) {
        this.a = fVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        e.h hVarA = this.a.a(animator);
        if (hVarA != null) {
            this.b.put(hVarA.g(""), false);
            Iterator it = this.a.h.iterator();
            while (it.hasNext()) {
                ((f.a) it.next()).a(hVarA);
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        e.h hVarA = this.a.a(animator);
        if (hVarA != null) {
            Boolean bool = this.b.get(hVarA.g(""));
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            if (!zBooleanValue) {
                this.a.b(hVarA);
            }
            Iterator it = this.a.h.iterator();
            while (it.hasNext()) {
                ((f.a) it.next()).a(hVarA, zBooleanValue);
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        e.h hVarA = this.a.a(animator);
        if (hVarA != null) {
            this.b.put(hVarA.g(""), true);
            Iterator it = this.a.h.iterator();
            while (it.hasNext()) {
                ((f.a) it.next()).b(hVarA);
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        e.h hVarA = this.a.a(animator);
        if (hVarA != null) {
            Iterator it = this.a.h.iterator();
            while (it.hasNext()) {
                ((f.a) it.next()).c(hVarA);
            }
        }
    }
}
