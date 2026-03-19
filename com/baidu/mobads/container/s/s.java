package com.baidu.mobads.container.s;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.o.j;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.cf;
import com.baidu.mobads.container.util.cm;
import com.component.feed.ax;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class s {
    private static final String a = s.class.getSimpleName();
    private Context b;
    private int c;
    private int d;
    private float e;
    private float f;
    private com.baidu.mobads.container.adrequest.j g;
    private ax h;
    private ImageView i;
    private TextView j;
    private ViewGroup k;
    private com.baidu.mobads.container.k l;
    private AnimatorSet m;
    private com.baidu.mobads.container.d.a n;
    private com.baidu.mobads.container.activity.v q;
    private boolean o = false;
    private int p = 10;
    private final com.baidu.mobads.container.o.b r = new com.baidu.mobads.container.o.b();

    public s(Context context, com.baidu.mobads.container.k kVar, JSONObject jSONObject) {
        this.c = 0;
        this.d = 0;
        this.e = 1.0f;
        this.f = 0.0f;
        if (kVar == null) {
            return;
        }
        this.b = context;
        this.l = kVar;
        this.g = kVar.getAdContainerContext().q();
        if (jSONObject != null) {
            try {
                this.c = jSONObject.optInt("bottom_margin", 95);
                this.d = jSONObject.optInt("right_margin", 15);
                this.e = jSONObject.optInt("icon_size", 44) / 44.0f;
                this.e = Math.min(Math.max(0.8f, this.e), (bv.b(this.b, Math.min(bv.b(this.b), bv.c(this.b))) / 2.0f) / 44.0f);
                this.f = (float) jSONObject.optDouble("icon_dark_alpha", 0.0d);
                this.f = Math.min(Math.max(0.0f, this.f), 0.5f);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.q = new t(this);
        d();
    }

    private void d() {
        if (this.g == null) {
            return;
        }
        try {
            com.baidu.mobads.container.components.i.a aVar = new com.baidu.mobads.container.components.i.a(this.b.getApplicationContext(), this.g.getOriginJsonObject());
            this.o = aVar.a("focus_dl_dialog", this.o ? 1 : 0) == 1;
            JSONObject jSONObjectA = aVar.a("focus_style");
            if (jSONObjectA != null) {
                this.p = jSONObjectA.optInt("duration", this.p);
                this.p = Math.min(Math.max(2, this.p), 600);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(int i) {
        this.p = i;
    }

    public ViewGroup a(Activity activity) {
        a aVar = new a(this.b);
        aVar.setId(100);
        activity.addContentView(aVar, new RelativeLayout.LayoutParams(-1, -1));
        return aVar;
    }

    public View a() {
        return this.h;
    }

    public void a(ViewGroup viewGroup) {
        int iOptInt;
        boolean z;
        try {
            if (this.g != null && this.b != null) {
                if (this.k == null) {
                    this.k = viewGroup;
                }
                if (this.h == null) {
                    float fA = a(this.e * 10.0f);
                    this.h = new ax.a(this.b).a(ax.b.RoundRect).a(new float[]{fA, fA, fA, fA, fA, fA, fA, fA}).a();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(this.e * 44.0f), a(this.e * 44.0f));
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    layoutParams.bottomMargin = a(this.c);
                    layoutParams.rightMargin = a(this.d);
                    this.h.setColorFilter(((int) (this.f * 255.0f)) << 24, PorterDuff.Mode.SRC_ATOP);
                    this.h.setId(101);
                    this.h.setOnClickListener(new u(this));
                    this.h.setOnTouchListener(new v(this));
                    if (!TextUtils.isEmpty(this.g.getIconUrl())) {
                        com.baidu.mobads.container.util.d.d.a(this.b).b(this.h, this.g.getIconUrl());
                    } else {
                        com.component.b.a.a().a(this.h, "ic_fallback");
                    }
                    this.k.addView(this.h, layoutParams);
                }
                if (this.i == null) {
                    this.i = new ImageView(this.b);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a(this.e * 14.0f), a(this.e * 14.0f));
                    layoutParams2.addRule(2, this.h.getId());
                    layoutParams2.addRule(11);
                    layoutParams2.bottomMargin = a(this.e * 5.0f);
                    layoutParams2.rightMargin = a(this.d);
                    this.i.setId(102);
                    com.component.b.a.a().a(this.i, "ic_black_cross");
                    this.i.setColorFilter(-1);
                    int iA = a(this.e * 3.0f);
                    this.i.setPadding(iA, iA, iA, iA);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(a(this.e * 7.0f));
                    gradientDrawable.setColor(Color.parseColor("#999999"));
                    if (com.baidu.mobads.container.util.x.a(null).a() < 16) {
                        this.i.setBackgroundDrawable(gradientDrawable);
                    } else {
                        this.i.setBackground(gradientDrawable);
                    }
                    this.i.setOnClickListener(new w(this));
                    this.k.addView(this.i, layoutParams2);
                }
                boolean zB = com.baidu.mobads.container.util.j.b(this.b, this.g.getAppPackageName());
                if (TextUtils.isEmpty(this.g.getAppOpenStrs())) {
                    iOptInt = 0;
                } else {
                    iOptInt = new JSONObject(this.g.getAppOpenStrs()).optInt("fb_act", 0);
                }
                if ((zB || this.g.getActionType() != 512 || iOptInt != 2) && this.g.getActionType() != 2) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.j == null && z) {
                    this.j = new TextView(this.b);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a(this.e * 60.0f), a(this.e * 22.0f));
                    layoutParams3.topMargin = a(this.e * 50.0f);
                    layoutParams3.rightMargin = a(this.d - ((int) (this.e * 8.0f)));
                    layoutParams3.addRule(3, this.i.getId());
                    layoutParams3.addRule(11);
                    this.j.setText("立即下载");
                    this.j.setTextColor(-1);
                    this.j.setTextSize(0, a(this.e * 12.0f));
                    this.j.setGravity(17);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setCornerRadius(a(this.e * 11.0f));
                    gradientDrawable2.setColor(Color.parseColor("#999999"));
                    if (com.baidu.mobads.container.util.x.a(null).a() < 16) {
                        this.j.setBackgroundDrawable(gradientDrawable2);
                    } else {
                        this.j.setBackground(gradientDrawable2);
                    }
                    this.j.setOnClickListener(new x(this));
                    this.j.setOnTouchListener(new y(this));
                    this.k.addView(this.j, layoutParams3);
                }
                b(4);
            }
        } catch (Throwable th) {
            b();
            com.baidu.mobads.container.l.g.h(a).e("attachToParent: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.g != null) {
                a("click");
                this.r.a(j.a.SPLASH_FOCUS_ZOOM_OUT.c());
                this.r.b(j.a.SPLASH_FOCUS_ZOOM_OUT.c());
                this.l.splashAdClick("icon", this.r);
                if (!this.o) {
                    b();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void b() {
        try {
            if (this.b != null) {
                this.b = null;
                this.g = null;
                if (this.m != null) {
                    this.m.cancel();
                    this.m = null;
                }
                if (this.n != null && !this.n.h()) {
                    this.n.a_();
                }
                HashMap map = new HashMap();
                map.put("splash_close_reason", "splash_icon");
                cm cmVar = new cm(com.baidu.mobads.container.components.k.b.E, (HashMap<String, Object>) map);
                if (this.l != null) {
                    this.l.getAdContainerContext().s().dispatchEvent(cmVar);
                    this.l = null;
                }
                if (this.k != null) {
                    this.k.removeAllViews();
                    this.k.setVisibility(8);
                    cf.c(this.k);
                    this.k = null;
                }
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.h(a).e("close: ", th);
        }
    }

    public void c() {
        try {
            b(4);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.h, "scaleX", 0.1f, 1.0f);
            objectAnimatorOfFloat.setDuration(400L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.h, "scaleY", 0.1f, 1.0f);
            objectAnimatorOfFloat2.setDuration(400L);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.h, "rotation", 0.0f, -15.0f, 5.0f, 0.0f);
            objectAnimatorOfFloat3.setDuration(600L);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.i, "alpha", 0.0f, 0.8f);
            objectAnimatorOfFloat4.setDuration(300L);
            this.m = new AnimatorSet();
            this.m.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2).with(objectAnimatorOfFloat4).before(objectAnimatorOfFloat3);
            if (this.j != null) {
                ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.j, "alpha", 0.0f, 0.7f);
                objectAnimatorOfFloat5.setDuration(600L);
                this.m.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat5);
            }
            this.m.start();
            b(0);
            a("show");
            HashMap map = new HashMap();
            map.put("splash_show_reason", "splash_icon");
            cm cmVar = new cm(com.baidu.mobads.container.components.k.b.v, (HashMap<String, Object>) map);
            if (this.l != null) {
                this.l.getAdContainerContext().s().dispatchEvent(cmVar);
            }
            this.n = new z(this);
            if (this.p >= 0) {
                com.baidu.mobads.container.d.b.a().a(this.n, this.p, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.h(a).e("animation start: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            by.a.a(this.b.getApplicationContext()).a(802).b(this.l.getAdContainerContext().l()).a(this.g).a("reason", str).a("focusType", 0L).a("materialtype", this.g.getMaterialType()).g();
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.h(a).f(th.getMessage());
        }
    }

    private void b(int i) {
        if (this.h != null && this.i != null) {
            this.h.setVisibility(i);
            this.i.setVisibility(i);
        }
        if (this.j != null) {
            this.j.setVisibility(i);
        }
    }

    private int a(float f) {
        return (int) ((f * this.b.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private class a extends RelativeLayout {
        public a(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            s.this.b();
        }
    }
}
