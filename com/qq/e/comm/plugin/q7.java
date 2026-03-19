package com.qq.e.comm.plugin;

import android.view.View;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class q7 implements View.OnTouchListener, View.OnLongClickListener {
    private final long a;
    private final boolean b;
    private b c;
    private View d;
    private Boolean e;

    public abstract boolean a();

    /* compiled from: A */
    private class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q7.this.d == null) {
                return;
            }
            q7 q7Var = q7.this;
            if (q7Var.onLongClick(q7Var.d)) {
                z30.a();
                q7.this.d = null;
            }
        }
    }

    public q7(long j, boolean z) {
        this.a = j;
        this.b = !z;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r5, android.view.MotionEvent r6) {
        /*
            r4 = this;
            java.lang.Boolean r0 = r4.e
            r1 = 0
            if (r0 == 0) goto Lc
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto Lc
            return r1
        Lc:
            int r0 = r6.getAction()
            r2 = 0
            if (r0 == 0) goto L66
            r1 = 1
            if (r0 == r1) goto L51
            r1 = 2
            if (r0 == r1) goto L1d
            r6 = 3
            if (r0 == r6) goto L58
            goto L85
        L1d:
            android.view.View r0 = r4.d
            if (r0 == 0) goto L85
            com.qq.e.comm.plugin.q7$b r0 = r4.c
            if (r0 != 0) goto L26
            goto L85
        L26:
            float r0 = r6.getX()
            r1 = 0
            int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r3 < 0) goto L49
            float r6 = r6.getY()
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 < 0) goto L49
            int r1 = r5.getWidth()
            float r1 = (float) r1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L49
            int r0 = r5.getHeight()
            float r0 = (float) r0
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 <= 0) goto L85
        L49:
            com.qq.e.comm.plugin.q7$b r6 = r4.c
            r5.removeCallbacks(r6)
            r4.c = r2
            goto L85
        L51:
            android.view.View r6 = r4.d
            if (r6 != 0) goto L58
            r4.e = r2
            return r1
        L58:
            r4.e = r2
            r4.d = r2
            com.qq.e.comm.plugin.q7$b r6 = r4.c
            if (r6 == 0) goto L85
            r5.removeCallbacks(r6)
            r4.c = r2
            goto L85
        L66:
            boolean r6 = r4.a()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r4.e = r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L77
            return r1
        L77:
            r4.d = r5
            com.qq.e.comm.plugin.q7$b r6 = new com.qq.e.comm.plugin.q7$b
            r6.<init>()
            r4.c = r6
            long r0 = r4.a
            r5.postDelayed(r6, r0)
        L85:
            boolean r5 = r4.b
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.q7.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
