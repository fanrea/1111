package lkxssdk.g0;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b extends RecyclerView.OnScrollListener {
    public final boolean a;
    public final boolean b;
    public final RecyclerView.OnScrollListener c = null;

    public b(boolean z, boolean z2, RecyclerView.OnScrollListener onScrollListener) {
        this.a = z;
        this.b = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView r4, int r5) {
        /*
            r3 = this;
            super.onScrollStateChanged(r4, r5)
            if (r5 == 0) goto L3c
            r0 = 1
            if (r5 == r0) goto L1e
            r1 = 2
            if (r5 == r1) goto Lc
            goto L5f
        Lc:
            java.lang.String r1 = "PauseOnScrollListener"
            java.lang.String r2 = "RecyclerView.SCROLL_STATE_SETTLING"
            lkxssdk.h0.c.a(r1, r2)
            boolean r1 = r3.b
            if (r1 == 0) goto L5f
            boolean r1 = lkxssdk.a.a.b()
            if (r1 != 0) goto L30
            goto L5f
        L1e:
            java.lang.String r1 = "PauseOnScrollListener"
            java.lang.String r2 = "RecyclerView.SCROLL_STATE_DRAGGING"
            lkxssdk.h0.c.a(r1, r2)
            boolean r1 = r3.a
            if (r1 == 0) goto L5f
            boolean r1 = lkxssdk.a.a.b()
            if (r1 != 0) goto L30
            goto L5f
        L30:
            lkxssdk.e0.c r1 = lkxssdk.e0.c.a()
            lkxssdk.e0.f r1 = r1.c
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.g
            r1.set(r0)
            goto L5f
        L3c:
            java.lang.String r0 = "PauseOnScrollListener"
            java.lang.String r1 = "RecyclerView.SCROLL_STATE_IDLE"
            lkxssdk.h0.c.a(r0, r1)
            boolean r0 = lkxssdk.a.a.b()
            if (r0 != 0) goto L4a
            goto L5f
        L4a:
            lkxssdk.e0.c r0 = lkxssdk.e0.c.a()
            lkxssdk.e0.f r0 = r0.c
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.g
            r2 = 0
            r1.set(r2)
            java.lang.Object r1 = r0.h
            monitor-enter(r1)
            java.lang.Object r0 = r0.h     // Catch: java.lang.Throwable -> L67
            r0.notifyAll()     // Catch: java.lang.Throwable -> L67
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L67
        L5f:
            androidx.recyclerview.widget.RecyclerView$OnScrollListener r0 = r3.c
            if (r0 == 0) goto L66
            r0.onScrollStateChanged(r4, r5)
        L66:
            return
        L67:
            r4 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L67
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.g0.b.onScrollStateChanged(androidx.recyclerview.widget.RecyclerView, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        RecyclerView.OnScrollListener onScrollListener = this.c;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(recyclerView, i, i2);
        }
    }
}
