package com.bytedance.sdk.component.widget.recycler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends mk {
    private static TimeInterpolator tt;
    private ArrayList<RecyclerView.v> tc = new ArrayList<>();
    private ArrayList<RecyclerView.v> mk = new ArrayList<>();
    private ArrayList<hc> mq = new ArrayList<>();
    private ArrayList<d> uo = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.v>> d = new ArrayList<>();
    ArrayList<ArrayList<hc>> hc = new ArrayList<>();
    ArrayList<ArrayList<d>> b = new ArrayList<>();
    ArrayList<RecyclerView.v> c = new ArrayList<>();
    ArrayList<RecyclerView.v> u = new ArrayList<>();
    ArrayList<RecyclerView.v> an = new ArrayList<>();
    ArrayList<RecyclerView.v> h = new ArrayList<>();

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.an
    public void d() {
        boolean z = !this.tc.isEmpty();
        boolean z2 = !this.mq.isEmpty();
        boolean z3 = !this.uo.isEmpty();
        boolean z4 = !this.mk.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.v> it = this.tc.iterator();
            while (it.hasNext()) {
                mk(it.next());
            }
            this.tc.clear();
            if (z2) {
                final ArrayList<hc> arrayList = new ArrayList<>();
                arrayList.addAll(this.mq);
                this.hc.add(arrayList);
                this.mq.clear();
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            hc hcVar = (hc) it2.next();
                            b.this.hc(hcVar.d, hcVar.hc, hcVar.b, hcVar.c, hcVar.u);
                        }
                        arrayList.clear();
                        b.this.hc.remove(arrayList);
                    }
                };
                if (z) {
                    com.bytedance.sdk.component.widget.recycler.d.b.h.d(arrayList.get(0).d.d, runnable, h());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<d> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.uo);
                this.b.add(arrayList2);
                this.uo.clear();
                Runnable runnable2 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            b.this.d((d) it2.next());
                        }
                        arrayList2.clear();
                        b.this.b.remove(arrayList2);
                    }
                };
                if (z) {
                    com.bytedance.sdk.component.widget.recycler.d.b.h.d(arrayList2.get(0).d.d, runnable2, h());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.v> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.mk);
                this.d.add(arrayList3);
                this.mk.clear();
                Runnable runnable3 = new Runnable() { // from class: com.bytedance.sdk.component.widget.recycler.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            b.this.b((RecyclerView.v) it2.next());
                        }
                        arrayList3.clear();
                        b.this.d.remove(arrayList3);
                    }
                };
                if (!z && !z2 && !z3) {
                    runnable3.run();
                } else {
                    com.bytedance.sdk.component.widget.recycler.d.b.h.d(arrayList3.get(0).d, runnable3, (z ? h() : 0L) + Math.max(z2 ? u() : 0L, z3 ? gb() : 0L));
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.mk
    public boolean d(RecyclerView.v vVar) {
        mq(vVar);
        this.tc.add(vVar);
        return true;
    }

    private void mk(final RecyclerView.v vVar) {
        final View view = vVar.d;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.an.add(vVar);
        viewPropertyAnimatorAnimate.setDuration(h()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.b.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                b.this.gb(vVar);
                b.this.an.remove(vVar);
                b.this.b();
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.mk
    public boolean hc(RecyclerView.v vVar) {
        mq(vVar);
        vVar.d.setAlpha(0.0f);
        this.mk.add(vVar);
        return true;
    }

    void b(final RecyclerView.v vVar) {
        final View view = vVar.d;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.c.add(vVar);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(an()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.b.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                b.this.tc(vVar);
                b.this.c.remove(vVar);
                b.this.b();
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.mk
    public boolean d(RecyclerView.v vVar, int i, int i2, int i3, int i4) {
        View view = vVar.d;
        int translationX = i + ((int) vVar.d.getTranslationX());
        int translationY = i2 + ((int) vVar.d.getTranslationY());
        mq(vVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            tt(vVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.mq.add(new hc(vVar, translationX, translationY, i3, i4));
        return true;
    }

    void hc(final RecyclerView.v vVar, int i, int i2, int i3, int i4) {
        final View view = vVar.d;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.u.add(vVar);
        viewPropertyAnimatorAnimate.setDuration(u()).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.b.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                b.this.tt(vVar);
                b.this.u.remove(vVar);
                b.this.b();
            }
        }).start();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.mk
    public boolean d(RecyclerView.v vVar, RecyclerView.v vVar2, int i, int i2, int i3, int i4) {
        if (vVar == vVar2) {
            return d(vVar, i, i2, i3, i4);
        }
        float translationX = vVar.d.getTranslationX();
        float translationY = vVar.d.getTranslationY();
        float alpha = vVar.d.getAlpha();
        mq(vVar);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        vVar.d.setTranslationX(translationX);
        vVar.d.setTranslationY(translationY);
        vVar.d.setAlpha(alpha);
        if (vVar2 != null) {
            mq(vVar2);
            vVar2.d.setTranslationX(-i5);
            vVar2.d.setTranslationY(-i6);
            vVar2.d.setAlpha(0.0f);
        }
        this.uo.add(new d(vVar, vVar2, i, i2, i3, i4));
        return true;
    }

    void d(final d dVar) {
        RecyclerView.v vVar = dVar.d;
        final View view = vVar == null ? null : vVar.d;
        RecyclerView.v vVar2 = dVar.hc;
        final View view2 = vVar2 != null ? vVar2.d : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(gb());
            this.h.add(dVar.d);
            duration.translationX(dVar.u - dVar.b);
            duration.translationY(dVar.an - dVar.c);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.b.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    b.this.d(dVar.d, true);
                    b.this.h.remove(dVar.d);
                    b.this.b();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.h.add(dVar.hc);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(gb()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.widget.recycler.b.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    b.this.d(dVar.hc, false);
                    b.this.h.remove(dVar.hc);
                    b.this.b();
                }
            }).start();
        }
    }

    private void d(List<d> list, RecyclerView.v vVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            d dVar = list.get(size);
            if (d(dVar, vVar) && dVar.d == null && dVar.hc == null) {
                list.remove(dVar);
            }
        }
    }

    private void hc(d dVar) {
        if (dVar.d != null) {
            d(dVar, dVar.d);
        }
        if (dVar.hc != null) {
            d(dVar, dVar.hc);
        }
    }

    private boolean d(d dVar, RecyclerView.v vVar) {
        boolean z = false;
        if (dVar.hc == vVar) {
            dVar.hc = null;
        } else {
            if (dVar.d != vVar) {
                return false;
            }
            dVar.d = null;
            z = true;
        }
        vVar.d.setAlpha(1.0f);
        vVar.d.setTranslationX(0.0f);
        vVar.d.setTranslationY(0.0f);
        d(vVar, z);
        return true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.an
    public void c(RecyclerView.v vVar) {
        View view = vVar.d;
        view.animate().cancel();
        int size = this.mq.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.mq.get(size).d == vVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                tt(vVar);
                this.mq.remove(size);
            }
        }
        d(this.uo, vVar);
        if (this.tc.remove(vVar)) {
            view.setAlpha(1.0f);
            gb(vVar);
        }
        if (this.mk.remove(vVar)) {
            view.setAlpha(1.0f);
            tc(vVar);
        }
        for (int size2 = this.b.size() - 1; size2 >= 0; size2--) {
            ArrayList<d> arrayList = this.b.get(size2);
            d(arrayList, vVar);
            if (arrayList.isEmpty()) {
                this.b.remove(size2);
            }
        }
        for (int size3 = this.hc.size() - 1; size3 >= 0; size3--) {
            ArrayList<hc> arrayList2 = this.hc.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).d == vVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    tt(vVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.hc.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.d.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.v> arrayList3 = this.d.get(size5);
            if (arrayList3.remove(vVar)) {
                view.setAlpha(1.0f);
                tc(vVar);
                if (arrayList3.isEmpty()) {
                    this.d.remove(size5);
                }
            }
        }
        this.an.remove(vVar);
        this.c.remove(vVar);
        this.h.remove(vVar);
        this.u.remove(vVar);
        b();
    }

    private void mq(RecyclerView.v vVar) {
        if (tt == null) {
            tt = new ValueAnimator().getInterpolator();
        }
        vVar.d.animate().setInterpolator(tt);
        c(vVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.an
    public boolean hc() {
        return (this.mk.isEmpty() && this.uo.isEmpty() && this.mq.isEmpty() && this.tc.isEmpty() && this.u.isEmpty() && this.an.isEmpty() && this.c.isEmpty() && this.h.isEmpty() && this.hc.isEmpty() && this.d.isEmpty() && this.b.isEmpty()) ? false : true;
    }

    void b() {
        if (hc()) {
            return;
        }
        tt();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.an
    public void c() {
        int size = this.mq.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            hc hcVar = this.mq.get(size);
            View view = hcVar.d.d;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            tt(hcVar.d);
            this.mq.remove(size);
        }
        for (int size2 = this.tc.size() - 1; size2 >= 0; size2--) {
            gb(this.tc.get(size2));
            this.tc.remove(size2);
        }
        int size3 = this.mk.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.v vVar = this.mk.get(size3);
            vVar.d.setAlpha(1.0f);
            tc(vVar);
            this.mk.remove(size3);
        }
        for (int size4 = this.uo.size() - 1; size4 >= 0; size4--) {
            hc(this.uo.get(size4));
        }
        this.uo.clear();
        if (hc()) {
            for (int size5 = this.hc.size() - 1; size5 >= 0; size5--) {
                ArrayList<hc> arrayList = this.hc.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    hc hcVar2 = arrayList.get(size6);
                    View view2 = hcVar2.d.d;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    tt(hcVar2.d);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.hc.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.d.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.v> arrayList2 = this.d.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.v vVar2 = arrayList2.get(size8);
                    vVar2.d.setAlpha(1.0f);
                    tc(vVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.d.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.b.size() - 1; size9 >= 0; size9--) {
                ArrayList<d> arrayList3 = this.b.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    hc(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.b.remove(arrayList3);
                    }
                }
            }
            d(this.an);
            d(this.u);
            d(this.c);
            d(this.h);
            tt();
        }
    }

    void d(List<RecyclerView.v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).d.animate().cancel();
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.an
    public boolean d(RecyclerView.v vVar, List<Object> list) {
        return !list.isEmpty() || super.d(vVar, list);
    }

    private static class d {
        public int an;
        public int b;
        public int c;
        public RecyclerView.v d;
        public RecyclerView.v hc;
        public int u;

        private d(RecyclerView.v vVar, RecyclerView.v vVar2) {
            this.d = vVar;
            this.hc = vVar2;
        }

        d(RecyclerView.v vVar, RecyclerView.v vVar2, int i, int i2, int i3, int i4) {
            this(vVar, vVar2);
            this.b = i;
            this.c = i2;
            this.u = i3;
            this.an = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.d + ", newHolder=" + this.hc + ", fromX=" + this.b + ", fromY=" + this.c + ", toX=" + this.u + ", toY=" + this.an + '}';
        }
    }

    private static class hc {
        public int b;
        public int c;
        public RecyclerView.v d;
        public int hc;
        public int u;

        hc(RecyclerView.v vVar, int i, int i2, int i3, int i4) {
            this.d = vVar;
            this.hc = i;
            this.b = i2;
            this.c = i3;
            this.u = i4;
        }
    }
}
