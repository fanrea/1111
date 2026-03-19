package com.component.feed;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.by;
import com.baidu.mobads.container.util.ci;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.component.a.a.b;
import com.component.a.f.e;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class an extends RelativeLayout implements ci.b, com.baidu.mobads.container.util.g.b, al, Runnable {
    private static final String a = an.class.getSimpleName();
    private int A;
    private volatile boolean B;
    private final ak b;
    private final AtomicBoolean c;
    private volatile boolean d;
    private boolean e;
    private boolean f;
    private a g;
    private ImageView h;
    private AnimatorSet i;
    private TextView j;
    private int k;
    private com.baidu.mobads.container.util.g.c l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private int v;
    private int w;
    private int x;
    private boolean y;
    private float z;

    public interface a {
        void a();

        void a(float f, float f2);

        void b();
    }

    public an(Context context, com.component.a.f.e eVar, boolean z) {
        super(context);
        this.c = new AtomicBoolean(false);
        this.d = false;
        this.e = true;
        this.f = false;
        this.k = 18;
        this.m = 1;
        this.n = 0;
        this.o = 1000;
        this.p = true;
        this.q = 7.0f;
        this.r = 6.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 4.0f;
        this.v = 190;
        this.w = 1;
        this.x = 10000;
        this.y = false;
        this.z = 35.0f;
        this.A = 0;
        this.B = false;
        a(context, eVar, z);
        a(context, eVar);
        this.b = ak.a(context);
        a(context);
    }

    public boolean a() {
        return this.A == 1;
    }

    public boolean b() {
        return !this.f;
    }

    public IOAdEventListener c() {
        p();
        q();
        return new ao(this);
    }

    public void d() {
        q();
    }

    public void e() {
        r();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (b()) {
            if (this.e) {
                p();
                q();
                m();
                return;
            }
            f();
            return;
        }
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (b()) {
            f();
        } else {
            n();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        super.onMeasure(i, i2);
        try {
            if (this.j != null && this.h != null) {
                int measuredWidth = this.j.getMeasuredWidth();
                if (this.j.getPaint() != null) {
                    measuredWidth = (int) this.j.getPaint().measureText(this.j.getText().toString());
                }
                int measuredHeight = this.j.getMeasuredHeight();
                boolean z2 = true;
                if (measuredWidth <= getMeasuredWidth()) {
                    z = false;
                } else {
                    i = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                    z = true;
                }
                int measuredHeight2 = this.h.getMeasuredHeight();
                int iA = bv.a(getContext(), this.k);
                int measuredHeight3 = getMeasuredHeight();
                if (measuredHeight2 + iA + measuredHeight == measuredHeight3) {
                    z2 = z;
                } else {
                    int i3 = (measuredHeight3 - iA) - measuredHeight;
                    int i4 = (int) (i3 * 0.1f);
                    this.h.setPadding(i4, i4, i4, i4);
                    ViewGroup.LayoutParams layoutParams = this.h.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = i3;
                        layoutParams.width = i3;
                    }
                    this.h.setLayoutParams(layoutParams);
                }
                if (z2) {
                    super.onMeasure(i, i2);
                }
            }
        } catch (Throwable th) {
            bq.a().a(a, th);
        }
    }

    @Override // com.baidu.mobads.container.util.ci.b
    public void a(View view, boolean z) {
        this.d = z;
        if (b()) {
            if (z && this.n < this.m) {
                if (!this.B) {
                    this.B = true;
                    h();
                    j();
                }
                if (this.i != null) {
                    r();
                    return;
                }
                return;
            }
            q();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        i();
        f();
        l();
    }

    @Override // com.baidu.mobads.container.util.g.b
    public void a(float f, float f2) {
        if (this.c.compareAndSet(false, true)) {
            if (this.d && this.b.c(this)) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.b.a() > this.o) {
                    this.b.a(jCurrentTimeMillis);
                    this.n++;
                    if (this.g != null) {
                        this.g.a(f, f2);
                    }
                    if (this.n >= this.m) {
                        f();
                        l();
                    }
                }
            }
            this.c.set(false);
        }
    }

    @Override // com.baidu.mobads.container.util.g.b
    public void a(float f) {
    }

    public void a(a aVar) {
        this.g = aVar;
    }

    @Override // com.component.feed.al
    public boolean o() {
        return this.d;
    }

    private void a(Context context, com.component.a.f.e eVar, boolean z) {
        if (context == null || eVar == null) {
            return;
        }
        try {
            if (eVar.e(-1) != 1) {
                this.e = false;
                return;
            }
            JSONObject jSONObjectC = eVar.c();
            if (jSONObjectC != null) {
                this.p = jSONObjectC.optInt("vibrate", 1) == 1;
                this.q = jSONObjectC.optInt("velocity", 7);
                this.r = jSONObjectC.optInt(b.e.a, 6);
                this.s = (float) jSONObjectC.optDouble("shake_angle", 0.0d);
                this.t = (float) jSONObjectC.optDouble("shake_optime", 0.0d);
                this.u = (float) jSONObjectC.optDouble("startup_rate", 4.0d);
                this.v = jSONObjectC.optInt("interval_time", 190);
                this.w = jSONObjectC.optInt("detection_times", 1);
                this.x = jSONObjectC.optInt(com.baidu.mobads.container.adrequest.n.m, 10000);
                this.y = jSONObjectC.optInt("twoway_switch", 0) == 1;
                this.z = (float) jSONObjectC.optDouble("twoway_angle", 35.0d);
                this.A = jSONObjectC.optInt("allow_container", 0);
            }
            if (a()) {
                this.f = z;
                if (z) {
                    this.m = 100;
                }
            }
        } catch (Throwable th) {
            bq.a().d(a, "parse params error: ", th);
        }
    }

    private void a(Context context, com.component.a.f.e eVar) {
        int iC;
        try {
            if (this.e && !this.f && context != null && eVar != null) {
                this.h = new ImageView(context);
                this.h.setId(101);
                this.h.setBackgroundDrawable(com.component.a.i.r.a(1, GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1436129689}, 1436129689, 0, null, 0.5f));
                if (!TextUtils.isEmpty("")) {
                    com.baidu.mobads.container.util.d.d.a(context).b(this.h, "");
                } else {
                    com.component.b.a.a().a(this.h, "ic_white_shake_gesture");
                }
                this.h.setClickable(false);
                this.h.setPadding(18, 18, 18, 18);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bv.a(context, 60.0f), bv.a(context, 60.0f));
                layoutParams.bottomMargin = bv.a(context, this.k);
                layoutParams.addRule(14);
                addView(this.h, layoutParams);
                com.component.a.f.e eVarA = a(eVar.o());
                String strO = "摇动手机 了解更多";
                int iD = -1;
                if (eVarA == null) {
                    iC = 14;
                } else {
                    strO = eVarA.o("摇动手机 了解更多");
                    e.i iVarG = eVarA.g();
                    iD = iVarG.d(-1);
                    iC = iVarG.c(14);
                }
                this.j = new TextView(context);
                this.j.setId(102);
                this.j.setText(strO);
                this.j.setTextColor(iD);
                this.j.setTextSize(2, iC);
                this.j.setGravity(17);
                this.j.setShadowLayer(3.5f, 1.0f, -1.0f, -13421773);
                this.j.setClickable(false);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams2.addRule(14);
                layoutParams2.addRule(12);
                addView(this.j, layoutParams2);
            }
        } catch (Throwable th) {
            f();
            bq.a().d(a, "attachToParent: ", th);
        }
    }

    private void a(Context context) {
        if (this.e && this.l == null) {
            this.l = new com.baidu.mobads.container.util.g.c(context);
            if (this.p) {
                this.l.a((View) this);
                this.l.a(this.o);
            }
            this.l.b(this.q);
            this.l.a(this.v);
            this.l.b(this.w);
            this.l.a(this.r);
            this.l.c(this.s);
            this.l.d(this.t);
            this.l.e(this.u);
            this.l.a((com.baidu.mobads.container.util.g.b) this);
            this.l.b(this.h);
            this.l.a(this.y);
            this.l.f(this.z);
        }
    }

    private com.component.a.f.e a(List<com.component.a.f.e> list) {
        if (list != null && list.size() > 0) {
            for (com.component.a.f.e eVar : list) {
                if (TextUtils.equals("native_shake_view_text", eVar.l(""))) {
                    return eVar;
                }
            }
            return null;
        }
        return null;
    }

    private void g() {
        try {
            if (this.h != null) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.h, "rotation", 0.0f, -7.5f, -15.0f, 40.0f, 10.0f, -20.0f, 15.0f, -5.0f, 0.0f, 0.0f, 0.0f, 0.0f);
                objectAnimatorOfFloat.setRepeatCount(-1);
                this.i = new AnimatorSet();
                this.i.play(objectAnimatorOfFloat);
                this.i.setDuration(1300L);
            }
        } catch (Throwable th) {
            bq.a().c(a, "animation start: ", th);
        }
    }

    private void h() {
        try {
            com.baidu.mobads.container.util.h.a(new ap(this));
        } catch (Throwable th) {
            bq.a().d(a, th);
        }
    }

    private void i() {
        try {
            com.baidu.mobads.container.util.h.a(new aq(this));
        } catch (Throwable th) {
            bq.a().d(a, th);
        }
    }

    private void j() {
        postDelayed(this, this.x);
    }

    private void k() {
        removeCallbacks(this);
    }

    public void f() {
        k();
        s();
        n();
        i();
        a(4);
    }

    private void a(int i) {
        if (this.j != null) {
            this.j.setVisibility(i);
        }
        if (this.h != null) {
            this.h.setVisibility(i);
        }
    }

    private void l() {
        if (this.g != null) {
            this.g.b();
            this.g = null;
        }
    }

    private void m() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("window_focus", true);
            jSONObject.put("visible_percent", 100);
            ci.a().a(this, this, jSONObject);
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    private void n() {
        ci.a().b(this);
    }

    private void p() {
        if (this.l != null && !this.l.e()) {
            if (this.l.c()) {
                if (this.b != null) {
                    this.b.a(this);
                }
                a(0);
                this.n = 0;
                g();
                if (this.g != null) {
                    this.g.a();
                    return;
                }
                return;
            }
            f();
        }
    }

    private void q() {
        if (this.l != null) {
            this.l.b();
            this.l.d();
        }
    }

    private void r() {
        if (this.l != null) {
            this.l.a();
            this.l.c();
        }
    }

    private void s() {
        if (this.l != null) {
            this.l.d();
        } else {
            by.a.a(getContext()).a(810).a("reason", "feed shakeView shakeManager is null").f();
        }
        if (this.b != null) {
            this.b.b(this);
        }
    }
}
