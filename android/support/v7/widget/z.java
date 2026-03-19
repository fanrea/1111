package android.support.v7.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class z implements View.OnAttachStateChangeListener, View.OnTouchListener {
    private int dT;
    private final float pj;
    private final int pk;
    private final int pl;
    final View pm;
    private Runnable pn;
    private Runnable po;
    private boolean pp;
    private final int[] pq = new int[2];

    public abstract android.support.v7.view.menu.q aY();

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    public z(View view) {
        this.pm = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.pj = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.pk = ViewConfiguration.getTapTimeout();
        this.pl = (this.pk + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.pp;
        if (z2) {
            z = e(motionEvent) || !cc();
        } else {
            z = d(motionEvent) && aZ();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.pm.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.pp = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.pp = false;
        this.dT = -1;
        Runnable runnable = this.pn;
        if (runnable != null) {
            this.pm.removeCallbacks(runnable);
        }
    }

    protected boolean aZ() {
        android.support.v7.view.menu.q qVarAY = aY();
        if (qVarAY == null || qVarAY.isShowing()) {
            return true;
        }
        qVarAY.show();
        return true;
    }

    protected boolean cc() {
        android.support.v7.view.menu.q qVarAY = aY();
        if (qVarAY == null || !qVarAY.isShowing()) {
            return true;
        }
        qVarAY.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.pm
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.dT
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.pj
            boolean r6 = a(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.dk()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.dk()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.dT = r6
            java.lang.Runnable r6 = r5.pn
            if (r6 != 0) goto L52
            android.support.v7.widget.z$a r6 = new android.support.v7.widget.z$a
            r6.<init>()
            r5.pn = r6
        L52:
            java.lang.Runnable r6 = r5.pn
            int r1 = r5.pk
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.po
            if (r6 != 0) goto L65
            android.support.v7.widget.z$b r6 = new android.support.v7.widget.z$b
            r6.<init>()
            r5.po = r6
        L65:
            java.lang.Runnable r6 = r5.po
            int r1 = r5.pl
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.z.d(android.view.MotionEvent):boolean");
    }

    private void dk() {
        Runnable runnable = this.po;
        if (runnable != null) {
            this.pm.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.pn;
        if (runnable2 != null) {
            this.pm.removeCallbacks(runnable2);
        }
    }

    final void dl() {
        dk();
        View view = this.pm;
        if (view.isEnabled() && !view.isLongClickable() && aZ()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.pp = true;
        }
    }

    private boolean e(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException {
        w wVar;
        View view = this.pm;
        android.support.v7.view.menu.q qVarAY = aY();
        if (qVarAY != null && qVarAY.isShowing() && (wVar = (w) qVarAY.getListView()) != null && wVar.isShown()) {
            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            b(view, motionEventObtainNoHistory);
            a(wVar, motionEventObtainNoHistory);
            boolean zB = wVar.b(motionEventObtainNoHistory, this.dT);
            motionEventObtainNoHistory.recycle();
            int actionMasked = motionEvent.getActionMasked();
            boolean z = (actionMasked == 1 || actionMasked == 3) ? false : true;
            if (zB && z) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.pq);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.pq);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewParent parent = z.this.pm.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            z.this.dl();
        }
    }
}
