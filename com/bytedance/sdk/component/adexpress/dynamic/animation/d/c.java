package com.bytedance.sdk.component.adexpress.dynamic.animation.d;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class c implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u {
    public View b;
    private Set<ScheduledFuture<?>> c = new HashSet();
    public List<ObjectAnimator> d = d();
    com.bytedance.sdk.component.adexpress.dynamic.b.d hc;

    abstract List<ObjectAnimator> d();

    public c(View view, com.bytedance.sdk.component.adexpress.dynamic.b.d dVar) {
        this.b = view;
        this.hc = dVar;
    }

    public void b() {
        List<ObjectAnimator> list = this.d;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.hc.w() > 0.0d && Build.VERSION.SDK_INT >= 19) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.d.c.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        d dVar = c.this.new d(objectAnimator);
                        ScheduledFuture<?> scheduledFutureD = com.bytedance.sdk.component.adexpress.c.u.d(dVar, (long) (c.this.hc.w() * 1000.0d), TimeUnit.MILLISECONDS);
                        dVar.d(scheduledFutureD);
                        c.this.c.add(scheduledFutureD);
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u
    public void hc() {
        List<ObjectAnimator> list = this.d;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    ObjectAnimator d(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.hc.k() * 1000.0d));
        if (this.hc.e() > 0) {
            objectAnimator.setRepeatCount(this.hc.e() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!"normal".equals(this.hc.cb())) {
            if ("alternate".equals(this.hc.cb()) || "alternate-reverse".equals(this.hc.cb())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.hc.uo())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.hc.cb())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.hc.cb())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.d.c.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    c.this.b.setVisibility(0);
                    if (c.this.b.getParent() instanceof DynamicBaseWidgetImp) {
                        ((View) c.this.b.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }

    public class d implements Runnable {
        ObjectAnimator d;
        ScheduledFuture<?> hc;

        d(ObjectAnimator objectAnimator) {
            this.d = objectAnimator;
        }

        public void d(ScheduledFuture<?> scheduledFuture) {
            this.hc = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT < 19 || com.bytedance.sdk.component.adexpress.d.d.d.d().b() == null) {
                return;
            }
            com.bytedance.sdk.component.adexpress.d.d.d.d().b().hc().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.d.c.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.d.resume();
                }
            });
            if (this.hc != null) {
                c.this.c.remove(this.hc);
            }
        }
    }
}
