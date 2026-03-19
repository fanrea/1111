package com.sigmob.sdk.nativead;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.czhj.sdk.logger.SigmobLog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class n extends View {
    private ab a;
    private boolean b;
    private boolean c;
    private a d;
    private int e;
    private long f;
    private int g;
    private int h;
    private boolean i;
    private int j;

    public interface a {
        void a(boolean isValid);

        void f();

        void g();

        void h();

        void i();
    }

    public n(Context context) {
        this(context, null);
    }

    public n(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public n(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.b = false;
        this.c = true;
        this.f = 0L;
        this.g = 0;
        this.h = -1;
        this.i = false;
        this.j = -1;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (a() && e()) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            int iA = a(viewGroup);
            int height = viewGroup.getHeight() * viewGroup.getWidth();
            boolean z = height > 0 && ((float) iA) >= (((float) this.e) / 100.0f) * ((float) height);
            if (iA > 0) {
                this.i = true;
                a aVar = this.d;
                if (aVar != null) {
                    aVar.i();
                }
            } else {
                this.i = false;
                this.f = 0L;
                a aVar2 = this.d;
                if (aVar2 != null) {
                    aVar2.h();
                }
            }
            if (iA <= 0) {
                a aVar3 = this.d;
                if (aVar3 == null || !this.i) {
                    return;
                }
                aVar3.h();
                return;
            }
            if (z && this.i) {
                if (this.f == 0) {
                    this.f = System.currentTimeMillis();
                }
                boolean z2 = this.f > 0 && System.currentTimeMillis() - this.f >= ((long) this.g) * 1000;
                a aVar4 = this.d;
                if (aVar4 != null) {
                    aVar4.g();
                }
                a aVar5 = this.d;
                if (aVar5 != null) {
                    aVar5.a(z2);
                    return;
                }
                return;
            }
            a aVar6 = this.d;
            if (aVar6 != null) {
                aVar6.f();
            }
            a aVar7 = this.d;
            if (aVar7 != null) {
                aVar7.a(false);
            }
        } else {
            a aVar8 = this.d;
            if (aVar8 != null && this.i) {
                aVar8.h();
            }
            this.i = false;
        }
        this.f = 0L;
    }

    private void c() {
        f();
        this.a = null;
    }

    private void d() {
        ab abVar = this.a;
        if (abVar == null || !abVar.b()) {
            return;
        }
        SigmobLog.d("-----------startTimer----------");
        this.a.removeCallbacksAndMessages(null);
        this.a.a();
        this.a.a(false);
    }

    private boolean e() {
        return this.b && this.h == 0 && this.c;
    }

    private void f() {
        b();
        ab abVar = this.a;
        if (abVar == null || abVar.b()) {
            return;
        }
        SigmobLog.d("-----------stopTimer----------");
        this.a.removeCallbacksAndMessages(null);
        this.a.a(true);
    }

    public int a(View view) {
        Rect rect = new Rect();
        if (view.isShown() && view.getGlobalVisibleRect(rect)) {
            return rect.height() * rect.width();
        }
        return 0;
    }

    public void a(int impression_percent, int impression_time) {
        this.c = true;
        if (this.a != null) {
            c();
        }
        this.c = true;
        this.e = impression_percent;
        this.g = impression_time;
        this.a = new ab(Looper.getMainLooper()) { // from class: com.sigmob.sdk.nativead.n.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                if (87108 != msg.what || n.this.d == null) {
                    return;
                }
                n.this.b();
                a();
            }
        };
        d();
    }

    public boolean a() {
        return getVisibility() == 0 && this.j == 0 && getParent() != null;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b = true;
        SigmobLog.d("---------onAttachedToWindow---------");
        d();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b = false;
        SigmobLog.d("---------onDetachedFromWindow----------");
        f();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        SigmobLog.d("---------onFinishTemporaryDetach-------------");
        d();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        SigmobLog.d("---------onStartTemporaryDetach-----------");
        f();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        SigmobLog.d("---------onVisibilityChanged---------" + visibility);
        this.j = visibility;
        if (visibility == 0) {
            d();
        } else {
            f();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        SigmobLog.d("---------onWindowFocusChanged: hasWindowFocus: " + hasWindowFocus);
        this.c = hasWindowFocus;
        if (this.i) {
            b();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        this.h = visibility;
        SigmobLog.d("---------onWindowVisibilityChanged: visibility: " + visibility);
        if (visibility == 0) {
            d();
        } else {
            f();
        }
    }

    public void setAdVisibilityStatusChangeListener(a statusChangeListener) {
        this.d = statusChangeListener;
    }
}
