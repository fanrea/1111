package android.support.v7.widget;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class ay implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static ay wv;
    private static ay ww;
    private final CharSequence gJ;
    private final View wn;
    private final int wo;
    private int wq;
    private int wr;
    private az wt;
    private boolean wu;
    private final Runnable wp = new Runnable() { // from class: android.support.v7.widget.ay.1
        @Override // java.lang.Runnable
        public final void run() throws Resources.NotFoundException {
            ay.this.G(false);
        }
    };
    private final Runnable pg = new Runnable() { // from class: android.support.v7.widget.ay.2
        @Override // java.lang.Runnable
        public final void run() {
            ay.this.hide();
        }
    };

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    public static void a(View view, CharSequence charSequence) {
        ay ayVar = wv;
        if (ayVar != null && ayVar.wn == view) {
            a(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            ay ayVar2 = ww;
            if (ayVar2 != null && ayVar2.wn == view) {
                ayVar2.hide();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new ay(view, charSequence);
    }

    private ay(View view, CharSequence charSequence) {
        this.wn = view;
        this.gJ = charSequence;
        this.wo = android.support.v4.e.p.a(ViewConfiguration.get(this.wn.getContext()));
        fC();
        this.wn.setOnLongClickListener(this);
        this.wn.setOnHoverListener(this);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) throws Resources.NotFoundException {
        this.wq = view.getWidth() / 2;
        this.wr = view.getHeight() / 2;
        G(true);
        return true;
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.wt != null && this.wu) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.wn.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                fC();
                hide();
            }
        } else if (this.wn.isEnabled() && this.wt == null && f(motionEvent)) {
            a(this);
        }
        return false;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        hide();
    }

    final void G(boolean z) throws Resources.NotFoundException {
        long j;
        int longPressTimeout;
        long j2;
        if (android.support.v4.e.o.q(this.wn)) {
            a(null);
            ay ayVar = ww;
            if (ayVar != null) {
                ayVar.hide();
            }
            ww = this;
            this.wu = z;
            this.wt = new az(this.wn.getContext());
            this.wt.a(this.wn, this.wq, this.wr, this.wu, this.gJ);
            this.wn.addOnAttachStateChangeListener(this);
            if (this.wu) {
                j2 = 2500;
            } else {
                if ((android.support.v4.e.o.l(this.wn) & 1) == 1) {
                    j = com.alipay.sdk.m.u.b.a;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j - longPressTimeout;
            }
            this.wn.removeCallbacks(this.pg);
            this.wn.postDelayed(this.pg, j2);
        }
    }

    final void hide() {
        if (ww == this) {
            ww = null;
            az azVar = this.wt;
            if (azVar != null) {
                azVar.hide();
                this.wt = null;
                fC();
                this.wn.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (wv == this) {
            a(null);
        }
        this.wn.removeCallbacks(this.pg);
    }

    private static void a(ay ayVar) {
        ay ayVar2 = wv;
        if (ayVar2 != null) {
            ayVar2.fB();
        }
        wv = ayVar;
        if (ayVar != null) {
            wv.fA();
        }
    }

    private void fA() {
        this.wn.postDelayed(this.wp, ViewConfiguration.getLongPressTimeout());
    }

    private void fB() {
        this.wn.removeCallbacks(this.wp);
    }

    private boolean f(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.wq) <= this.wo && Math.abs(y - this.wr) <= this.wo) {
            return false;
        }
        this.wq = x;
        this.wr = y;
        return true;
    }

    private void fC() {
        this.wq = Integer.MAX_VALUE;
        this.wr = Integer.MAX_VALUE;
    }
}
