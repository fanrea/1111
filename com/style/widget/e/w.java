package com.style.widget.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.container.util.bq;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class w extends a {
    private View aa;
    private Runnable ab;
    private int ac;
    private boolean ad;
    private int ae;
    private int af;
    private AtomicInteger ag;
    private View ah;
    private View ai;
    private com.component.a.f.e aj;
    private v ak;
    private MotionEvent al;
    private MotionEvent am;

    public w(Context context) {
        super(context);
        this.ac = -1;
        this.al = null;
        this.am = null;
    }

    public void a(View view, int i, int i2, boolean z) {
        this.aa = view;
        this.ae = i2;
        this.af = i;
        this.ad = z;
        this.ac = 0;
        this.ab = new x(this);
    }

    public void a(v vVar) {
        this.ak = vVar;
    }

    public void b(View view) {
        this.ah = view;
    }

    public void c(View view) {
        this.ai = view;
        this.G = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.component.a.f.e r4) {
        /*
            r3 = this;
            r3.aj = r4
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L41
            java.lang.String r2 = ""
            java.lang.String r4 = r4.q(r2)
            java.lang.String r2 = "ad_click"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L1b
        L19:
            r4 = 0
            goto L42
        L1b:
            java.lang.String r2 = "creative_click"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L28
        L25:
            r4 = 0
            r0 = 0
            goto L42
        L28:
            java.lang.String r2 = "play"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L34
        L32:
            r4 = 1
            goto L42
        L34:
            java.lang.String r2 = "no"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L41
        L3e:
            r4 = 1
            r1 = 1
            goto L42
        L41:
            r4 = 0
        L42:
            r3.h(r0)
            r3.a()
            r3.c(r1)
            r3.k(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.style.widget.e.w.a(com.component.a.f.e):void");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.al = MotionEvent.obtainNoHistory(motionEvent);
                break;
            case 1:
                this.am = MotionEvent.obtainNoHistory(motionEvent);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.style.widget.e.a
    protected void b(View view, boolean z) {
        if (this.ak != null && this.aj != null) {
            com.component.a.f.d dVar = new com.component.a.f.d(view, "click", this.aj);
            dVar.a(this, 0, this.al, this.am);
            dVar.a(this.aj.l(""), this.aj.m(""));
            if (this.ak.a(dVar)) {
                return;
            }
        }
        super.b(view, z);
    }

    public void h(int i) {
        Drawable background;
        try {
            Drawable background2 = getBackground();
            if (background2 != null) {
                background2.setAlpha(i);
            }
            if (this.x != null && (background = this.x.getBackground()) != null) {
                background.setAlpha(0);
            }
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }

    public void i(int i) {
        if (this.ai != null) {
            this.ai.setVisibility(i);
            r();
        }
        if (this.ah != null) {
            this.ah.setVisibility(i);
        }
    }

    public void a(int i, int i2) {
        if (this.aa != null) {
            this.aa.setVisibility(i);
            this.ac = i2;
            if (this.ad) {
                a(this, i != 0);
            }
        }
    }

    @Override // com.style.widget.e.a, com.component.feed.a
    protected void d() {
        super.d();
        if (this.ab != null && this.ac == 0) {
            postDelayed(this.ab, this.ae);
        }
        if (this.ak != null) {
            this.ak.c();
        }
    }

    @Override // com.style.widget.e.a, com.component.feed.a
    protected void c() {
        super.c();
        removeCallbacks(this.ab);
        if (this.ak != null) {
            this.ak.b();
        }
    }

    @Override // com.style.widget.e.a, com.component.feed.a
    protected void b() {
        super.b();
        if (this.ab != null && this.ac == 0) {
            int iY = (int) (this.ae - y());
            if (iY < 10) {
                this.ab.run();
            } else {
                postDelayed(this.ab, iY);
            }
        } else if (this.ac == 1) {
            a(0, 1);
        }
        if (this.ak != null) {
            this.ak.a();
        }
    }

    @Override // com.style.widget.e.a, com.component.feed.a
    protected void f() {
        super.f();
        i(0);
        a(4, 2);
        if (this.ak != null) {
            this.ak.e();
        }
    }

    @Override // com.style.widget.e.a, com.component.feed.a
    protected void e() {
        super.e();
        i(0);
        a(4, 2);
        if (this.ak != null) {
            this.ak.d();
        }
    }

    @Override // com.style.widget.e.a
    public void I() {
        super.I();
        if (this.ac == 1) {
            a(4, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        if (this.aa != null) {
            View viewA = com.component.a.i.n.a(com.component.a.i.n.a(this.aa), "gesture_lottie");
            if (viewA instanceof com.component.a.a.f) {
                this.ag = new AtomicInteger(1);
                ((com.component.a.a.f) viewA).a(new y(this, viewA));
            }
            if (viewA != null && viewA.getParent() != null && (viewA.getParent() instanceof View) && ((View) viewA.getParent()).getVisibility() != 0) {
                this.ad = false;
            }
        }
    }

    public void j(int i) {
        this.ac = i;
    }
}
