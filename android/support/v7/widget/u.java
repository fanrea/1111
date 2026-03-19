package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v7.widget.aj;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class u extends ap {
    private static TimeInterpolator nK;
    private ArrayList<aj.x> nL = new ArrayList<>();
    private ArrayList<aj.x> nM = new ArrayList<>();
    private ArrayList<b> nN = new ArrayList<>();
    private ArrayList<a> nO = new ArrayList<>();
    ArrayList<ArrayList<aj.x>> nP = new ArrayList<>();
    ArrayList<ArrayList<b>> nQ = new ArrayList<>();
    ArrayList<ArrayList<a>> nR = new ArrayList<>();
    ArrayList<aj.x> nS = new ArrayList<>();
    ArrayList<aj.x> nT = new ArrayList<>();
    ArrayList<aj.x> nU = new ArrayList<>();
    ArrayList<aj.x> nV = new ArrayList<>();

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class b {
        public int ok;
        public int ol;
        public int om;
        public int on;
        public aj.x oo;

        b(aj.x xVar, int i, int i2, int i3, int i4) {
            this.oo = xVar;
            this.ok = i;
            this.ol = i2;
            this.om = i3;
            this.on = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a {
        public aj.x oi;
        public aj.x oj;
        public int ok;
        public int ol;
        public int om;
        public int on;

        private a(aj.x xVar, aj.x xVar2) {
            this.oi = xVar;
            this.oj = xVar2;
        }

        a(aj.x xVar, aj.x xVar2, int i, int i2, int i3, int i4) {
            this(xVar, xVar2);
            this.ok = i;
            this.ol = i2;
            this.om = i3;
            this.on = i4;
        }

        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.oi + ", newHolder=" + this.oj + ", fromX=" + this.ok + ", fromY=" + this.ol + ", toX=" + this.om + ", toY=" + this.on + '}';
        }
    }

    @Override // android.support.v7.widget.aj.f
    public final void cX() {
        boolean z = !this.nL.isEmpty();
        boolean z2 = !this.nN.isEmpty();
        boolean z3 = !this.nO.isEmpty();
        boolean z4 = !this.nM.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<aj.x> it = this.nL.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            this.nL.clear();
            if (z2) {
                final ArrayList<b> arrayList = new ArrayList<>();
                arrayList.addAll(this.nN);
                this.nQ.add(arrayList);
                this.nN.clear();
                Runnable runnable = new Runnable() { // from class: android.support.v7.widget.u.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            b bVar = (b) it2.next();
                            u.this.b(bVar.oo, bVar.ok, bVar.ol, bVar.om, bVar.on);
                        }
                        arrayList.clear();
                        u.this.nQ.remove(arrayList);
                    }
                };
                if (z) {
                    android.support.v4.e.o.a(arrayList.get(0).oo.itemView, runnable, dL());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.nO);
                this.nR.add(arrayList2);
                this.nO.clear();
                Runnable runnable2 = new Runnable() { // from class: android.support.v7.widget.u.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            u.this.a((a) it2.next());
                        }
                        arrayList2.clear();
                        u.this.nR.remove(arrayList2);
                    }
                };
                if (z) {
                    android.support.v4.e.o.a(arrayList2.get(0).oi.itemView, runnable2, dL());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<aj.x> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.nM);
                this.nP.add(arrayList3);
                this.nM.clear();
                Runnable runnable3 = new Runnable() { // from class: android.support.v7.widget.u.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            u.this.d((aj.x) it2.next());
                        }
                        arrayList3.clear();
                        u.this.nP.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    android.support.v4.e.o.a(arrayList3.get(0).itemView, runnable3, (z ? dL() : 0L) + Math.max(z2 ? dJ() : 0L, z3 ? dM() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    @Override // android.support.v7.widget.ap
    public final boolean a(aj.x xVar) {
        f(xVar);
        this.nL.add(xVar);
        return true;
    }

    private void b(final aj.x xVar) {
        final View view = xVar.itemView;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.nU.add(xVar);
        viewPropertyAnimatorAnimate.setDuration(dL()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: android.support.v7.widget.u.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                u.this.v(xVar);
                u.this.nU.remove(xVar);
                u.this.cY();
            }
        }).start();
    }

    @Override // android.support.v7.widget.ap
    public final boolean c(aj.x xVar) {
        f(xVar);
        xVar.itemView.setAlpha(0.0f);
        this.nM.add(xVar);
        return true;
    }

    final void d(final aj.x xVar) {
        final View view = xVar.itemView;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.nS.add(xVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(dK()).setListener(new AnimatorListenerAdapter() { // from class: android.support.v7.widget.u.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                u.this.x(xVar);
                u.this.nS.remove(xVar);
                u.this.cY();
            }
        }).start();
    }

    @Override // android.support.v7.widget.ap
    public final boolean a(aj.x xVar, int i, int i2, int i3, int i4) {
        View view = xVar.itemView;
        int translationX = i + ((int) xVar.itemView.getTranslationX());
        int translationY = i2 + ((int) xVar.itemView.getTranslationY());
        f(xVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            w(xVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.nN.add(new b(xVar, translationX, translationY, i3, i4));
        return true;
    }

    final void b(final aj.x xVar, int i, int i2, int i3, int i4) {
        final View view = xVar.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.nT.add(xVar);
        viewPropertyAnimatorAnimate.setDuration(dJ()).setListener(new AnimatorListenerAdapter() { // from class: android.support.v7.widget.u.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                u.this.w(xVar);
                u.this.nT.remove(xVar);
                u.this.cY();
            }
        }).start();
    }

    @Override // android.support.v7.widget.ap
    public final boolean a(aj.x xVar, aj.x xVar2, int i, int i2, int i3, int i4) {
        if (xVar == xVar2) {
            return a(xVar, i, i2, i3, i4);
        }
        float translationX = xVar.itemView.getTranslationX();
        float translationY = xVar.itemView.getTranslationY();
        float alpha = xVar.itemView.getAlpha();
        f(xVar);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        xVar.itemView.setTranslationX(translationX);
        xVar.itemView.setTranslationY(translationY);
        xVar.itemView.setAlpha(alpha);
        if (xVar2 != null) {
            f(xVar2);
            xVar2.itemView.setTranslationX(-i5);
            xVar2.itemView.setTranslationY(-i6);
            xVar2.itemView.setAlpha(0.0f);
        }
        this.nO.add(new a(xVar, xVar2, i, i2, i3, i4));
        return true;
    }

    final void a(final a aVar) {
        aj.x xVar = aVar.oi;
        final View view = xVar == null ? null : xVar.itemView;
        aj.x xVar2 = aVar.oj;
        final View view2 = xVar2 != null ? xVar2.itemView : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(dM());
            this.nV.add(aVar.oi);
            duration.translationX(aVar.om - aVar.ok);
            duration.translationY(aVar.on - aVar.ol);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: android.support.v7.widget.u.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    u.this.b(aVar.oi, true);
                    u.this.nV.remove(aVar.oi);
                    u.this.cY();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.nV.add(aVar.oj);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(dM()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: android.support.v7.widget.u.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    u.this.b(aVar.oj, false);
                    u.this.nV.remove(aVar.oj);
                    u.this.cY();
                }
            }).start();
        }
    }

    private void a(List<a> list, aj.x xVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = list.get(size);
            if (a(aVar, xVar) && aVar.oi == null && aVar.oj == null) {
                list.remove(aVar);
            }
        }
    }

    private void b(a aVar) {
        if (aVar.oi != null) {
            a(aVar, aVar.oi);
        }
        if (aVar.oj != null) {
            a(aVar, aVar.oj);
        }
    }

    private boolean a(a aVar, aj.x xVar) {
        boolean z = false;
        if (aVar.oj == xVar) {
            aVar.oj = null;
        } else {
            if (aVar.oi != xVar) {
                return false;
            }
            aVar.oi = null;
            z = true;
        }
        xVar.itemView.setAlpha(1.0f);
        xVar.itemView.setTranslationX(0.0f);
        xVar.itemView.setTranslationY(0.0f);
        b(xVar, z);
        return true;
    }

    @Override // android.support.v7.widget.aj.f
    public final void e(aj.x xVar) {
        View view = xVar.itemView;
        view.animate().cancel();
        int size = this.nN.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.nN.get(size).oo == xVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                w(xVar);
                this.nN.remove(size);
            }
        }
        a(this.nO, xVar);
        if (this.nL.remove(xVar)) {
            view.setAlpha(1.0f);
            v(xVar);
        }
        if (this.nM.remove(xVar)) {
            view.setAlpha(1.0f);
            x(xVar);
        }
        for (int size2 = this.nR.size() - 1; size2 >= 0; size2--) {
            ArrayList<a> arrayList = this.nR.get(size2);
            a(arrayList, xVar);
            if (arrayList.isEmpty()) {
                this.nR.remove(size2);
            }
        }
        for (int size3 = this.nQ.size() - 1; size3 >= 0; size3--) {
            ArrayList<b> arrayList2 = this.nQ.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).oo == xVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    w(xVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.nQ.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.nP.size() - 1; size5 >= 0; size5--) {
            ArrayList<aj.x> arrayList3 = this.nP.get(size5);
            if (arrayList3.remove(xVar)) {
                view.setAlpha(1.0f);
                x(xVar);
                if (arrayList3.isEmpty()) {
                    this.nP.remove(size5);
                }
            }
        }
        this.nU.remove(xVar);
        this.nS.remove(xVar);
        this.nV.remove(xVar);
        this.nT.remove(xVar);
        cY();
    }

    private void f(aj.x xVar) {
        if (nK == null) {
            nK = new ValueAnimator().getInterpolator();
        }
        xVar.itemView.animate().setInterpolator(nK);
        e(xVar);
    }

    @Override // android.support.v7.widget.aj.f
    public final boolean isRunning() {
        return (this.nM.isEmpty() && this.nO.isEmpty() && this.nN.isEmpty() && this.nL.isEmpty() && this.nT.isEmpty() && this.nU.isEmpty() && this.nS.isEmpty() && this.nV.isEmpty() && this.nQ.isEmpty() && this.nP.isEmpty() && this.nR.isEmpty()) ? false : true;
    }

    final void cY() {
        if (isRunning()) {
            return;
        }
        dN();
    }

    @Override // android.support.v7.widget.aj.f
    public final void cZ() {
        int size = this.nN.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.nN.get(size);
            View view = bVar.oo.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            w(bVar.oo);
            this.nN.remove(size);
        }
        for (int size2 = this.nL.size() - 1; size2 >= 0; size2--) {
            v(this.nL.get(size2));
            this.nL.remove(size2);
        }
        int size3 = this.nM.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            aj.x xVar = this.nM.get(size3);
            xVar.itemView.setAlpha(1.0f);
            x(xVar);
            this.nM.remove(size3);
        }
        for (int size4 = this.nO.size() - 1; size4 >= 0; size4--) {
            b(this.nO.get(size4));
        }
        this.nO.clear();
        if (isRunning()) {
            for (int size5 = this.nQ.size() - 1; size5 >= 0; size5--) {
                ArrayList<b> arrayList = this.nQ.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.oo.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    w(bVar2.oo);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.nQ.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.nP.size() - 1; size7 >= 0; size7--) {
                ArrayList<aj.x> arrayList2 = this.nP.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    aj.x xVar2 = arrayList2.get(size8);
                    xVar2.itemView.setAlpha(1.0f);
                    x(xVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.nP.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.nR.size() - 1; size9 >= 0; size9--) {
                ArrayList<a> arrayList3 = this.nR.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.nR.remove(arrayList3);
                    }
                }
            }
            d(this.nU);
            d(this.nT);
            d(this.nS);
            d(this.nV);
            dN();
        }
    }

    private static void d(List<aj.x> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    @Override // android.support.v7.widget.aj.f
    public final boolean a(aj.x xVar, List<Object> list) {
        return !list.isEmpty() || super.a(xVar, list);
    }
}
