package com.baidu.mobads.container.u;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.s.ab;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cf;
import com.baidu.mobads.container.util.cm;
import com.component.a.g.a;
import com.component.feed.ax;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    public static final int a = 1;
    public static final int b = 2;
    private Context c;
    private com.baidu.mobads.container.k d;
    private com.baidu.mobads.container.adrequest.j e;
    private com.component.a.g.d f;
    private com.baidu.mobads.container.s.s g;
    private boolean i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private boolean n;
    private Bitmap o;
    private com.component.a.d.c q;
    private com.component.a.d.c r;
    private com.component.a.d.c s;
    private ax t;
    private com.component.a.a.q u;
    private com.component.a.a.q v;
    private com.component.a.a.d w;
    private ab x;
    private final AtomicInteger h = new AtomicInteger(0);
    private ImageView.ScaleType p = ImageView.ScaleType.CENTER_CROP;

    public @interface a {
    }

    public b(com.baidu.mobads.container.k kVar, com.baidu.mobads.container.adrequest.j jVar) {
        this.i = false;
        this.j = 1;
        this.k = false;
        this.l = 2;
        this.m = -1;
        this.n = false;
        if (kVar != null && jVar != null) {
            this.d = kVar;
            this.e = jVar;
            this.c = kVar.getAdContainerContext().t();
            com.baidu.mobads.container.components.i.a aVar = new com.baidu.mobads.container.components.i.a(this.c, jVar.getOriginJsonObject());
            this.i = aVar.a("splash_focus", 2) == 1;
            this.j = aVar.a("splash_focus_style", 1);
            this.k = aVar.a("splash_focus_click", 2) == 4;
            this.l = aVar.a("splash_focus_button", 2);
            this.m = aVar.a("splash_focus_time", -1);
            this.n = aVar.a("splash_focus_shake", 2) == 1;
            this.f = new com.component.a.g.d(kVar, jVar);
            this.f.a(new a.C0317a().a(new c(this, kVar, jVar)));
        }
    }

    public boolean a() {
        return this.i;
    }

    public int b() {
        return this.j;
    }

    public void c() {
        if (!this.i) {
            return;
        }
        if (this.j == 1) {
            this.f.a((ViewGroup) null, com.component.a.i.n.b(n.b), new d(this));
            if (this.k) {
                this.r.setOnClickListener(null);
                this.r.setClickable(false);
                return;
            }
            return;
        }
        if (this.j == 2) {
            this.f.a((ViewGroup) null, com.component.a.i.n.b(n.c), new h(this));
        }
    }

    public void a(Bitmap bitmap) {
        this.o = bitmap;
    }

    public void a(ImageView.ScaleType scaleType) {
        this.p = scaleType;
    }

    public boolean a(Activity activity) {
        Bitmap bitmapA;
        ImageView axVar;
        if (!this.i || activity == null || this.q == null || com.baidu.mobads.container.util.x.a(null).a() < 19) {
            return false;
        }
        this.i = false;
        RelativeLayout relativeLayoutV = this.d.getAdContainerContext().v();
        if (this.o != null) {
            bitmapA = this.o;
        } else {
            bitmapA = cf.a(relativeLayoutV);
        }
        if (bitmapA == null) {
            return false;
        }
        this.h.set(1);
        this.o = null;
        try {
            if (this.j == 2) {
                axVar = new ax(this.c);
                axVar.setImageBitmap(bitmapA);
                axVar.setScaleType(this.p);
                this.q.addView(axVar, new ViewGroup.LayoutParams(-1, -1));
            } else {
                if (this.r == null) {
                    return false;
                }
                com.component.a.f.e eVarB = this.r.getLifeCycle().b();
                ImageView imageViewA = new com.component.a.a.e().a(this.c, eVarB);
                imageViewA.setImageBitmap(bitmapA);
                imageViewA.setScaleType(this.p);
                this.q.a(imageViewA, eVarB, this.f.a());
                this.q.removeView(imageViewA);
                this.q.addView(imageViewA, this.q.indexOfChild(this.r));
                axVar = imageViewA;
            }
            this.q.getViewTreeObserver().addOnPreDrawListener(new j(this, axVar));
            activity.addContentView(this.q, new ViewGroup.LayoutParams(-1, -1));
            return true;
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.h("SplashCard").e(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Transition transition, ViewGroup viewGroup, View view, View view2, int i) {
        if (transition == null || viewGroup == null || view == null || view2 == null) {
            a(view, view2);
            return;
        }
        TransitionValues transitionValues = new TransitionValues();
        transitionValues.view = view;
        transition.captureStartValues(transitionValues);
        TransitionValues transitionValues2 = new TransitionValues();
        transitionValues2.view = view2;
        transition.captureEndValues(transitionValues2);
        Animator animatorCreateAnimator = transition.createAnimator(viewGroup, transitionValues, transitionValues2);
        if (animatorCreateAnimator != null) {
            animatorCreateAnimator.setDuration(i);
            animatorCreateAnimator.addListener(new k(this, view, view2));
            animatorCreateAnimator.start();
            return;
        }
        a(view, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, View view2) {
        if (this.d != null && this.j == 1) {
            this.d.getAdContainerContext().s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.v));
            a("show");
        }
        if (this.m > 0) {
            this.q.postDelayed(new l(this), this.m * 1000);
        }
        if (this.j == 2) {
            view.setVisibility(4);
            this.g.c();
            return;
        }
        if (this.r != null) {
            com.baidu.mobads.container.util.animation.a.a(this.r).a(200).a(new JSONArray().put("alpha")).a(a.b.ENTER).i().addListener(new m(this, view2));
        }
        if (this.t != null) {
            com.baidu.mobads.container.util.animation.a.a(this.t).a(200).b("1.2").c("1.0").a(a.b.SCALE).i();
        }
        if (this.w != null) {
            com.baidu.mobads.container.util.animation.a.a(this.w).a(200).b("1.2").c("1.0").a(a.b.SCALE).i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            by.a.a(this.c).a(802).b(this.d.getAdContainerContext().l()).a(this.e).a("reason", str).a("focusType", 1L).a("materialtype", this.e.getMaterialType()).g();
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.h("SplashCard").f(th.getMessage());
        }
    }

    public void d() {
        a(true);
    }

    public void a(boolean z) {
        if (!this.h.compareAndSet(1, 2)) {
            return;
        }
        if (this.x != null) {
            this.x.m();
        }
        if (z) {
            cf.c(this.q);
        }
        if (this.d != null && this.j == 1) {
            this.d.getAdContainerContext().s().dispatchEvent(new cm(com.baidu.mobads.container.components.k.b.E));
        }
    }
}
