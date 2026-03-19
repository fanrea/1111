package com.sigmob.sdk.mraid2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.sigmob.sdk.mraid2.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class j extends HorizontalScrollView implements l {
    public static final float c = 1000.0f;
    private static final String d = "PageScrollView";
    private static final int e = 1000;
    public final int a;
    public final int b;
    private int f;
    private long g;
    private c.InterfaceC0744c h;
    private int i;

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public j(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        int i = getResources().getDisplayMetrics().widthPixels;
        this.a = i;
        this.b = i / 2;
        this.i = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void a(boolean r3, int r4, int r5, com.sigmob.sdk.mraid2.g r6) {
        /*
            r2 = this;
            if (r3 == 0) goto L26
            if (r4 <= 0) goto L11
            r3 = 1
            int r4 = r2.i
            int r0 = r2.a
            int r1 = r4 + r0
            if (r1 >= r5) goto L1a
            int r4 = r4 + r0
        Le:
            r2.i = r4
            goto L1a
        L11:
            r3 = 2
            int r4 = r2.i
            if (r4 <= 0) goto L1a
            int r5 = r2.a
            int r4 = r4 - r5
            goto Le
        L1a:
            com.sigmob.sdk.mraid2.c$c r4 = r2.h
            if (r4 == 0) goto L26
            int r5 = r2.i
            int r0 = r2.a
            int r5 = r5 / r0
            r4.onPageChanged(r6, r3, r5)
        L26:
            int r3 = r2.i
            r4 = 0
            r2.smoothScrollTo(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid2.j.a(boolean, int, int, com.sigmob.sdk.mraid2.g):void");
    }

    private boolean a(int d2) {
        int i = this.a;
        int i2 = d2 % i;
        Log.d(d, i2 + ":-----goPage------:" + (d2 / i));
        float fCurrentTimeMillis = (d2 * 1000) / (System.currentTimeMillis() - this.g);
        return fCurrentTimeMillis >= 1000.0f || fCurrentTimeMillis <= -1000.0f || i2 >= this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i, int i2) {
        if (i > 0) {
            int i3 = this.i;
            if (this.a + i3 < i2) {
                scrollTo(i3 + Math.abs(i), 0);
                return;
            }
            return;
        }
        int i4 = this.i;
        if (i4 > 0) {
            scrollTo(i4 - Math.abs(i), 0);
        }
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void a(int x, int y) {
        this.f = x;
        this.g = System.currentTimeMillis();
        Log.d(d, this.i + "--------onTouchStart--------" + this.f);
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void a(final g view, int x, int y) {
        final int i = this.f - x;
        Log.d(d, this.i + "-----------onTouchEnd--------:" + i);
        final boolean zA = a(i);
        final int width = getChildAt(0).getWidth();
        Log.d(d, width + "------是否翻页----" + zA);
        post(new Runnable() { // from class: com.sigmob.sdk.mraid2.j$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(zA, i, width, view);
            }
        });
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void b(int x, int y) {
        final int i = this.f - x;
        final int width = getChildAt(0).getWidth();
        post(new Runnable() { // from class: com.sigmob.sdk.mraid2.j$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(i, width);
            }
        });
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int velocityX) {
        super.fling(0);
    }

    @Override // com.sigmob.sdk.mraid2.l
    public ViewGroup getView() {
        return this;
    }

    @Override // com.sigmob.sdk.mraid2.l
    public void setPageChangedListener(c.InterfaceC0744c pageChangedListener) {
        this.h = pageChangedListener;
    }
}
