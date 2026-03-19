package com.alliance.ssp.ad.c0;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: SlideListener.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public View a;
    public ViewTreeObserverOnScrollChangedListenerC0072b b;
    public a c;

    /* compiled from: SlideListener.java */
    public interface a {
        void a(float f);
    }

    /* compiled from: SlideListener.java */
    /* renamed from: com.alliance.ssp.ad.c0.b$b, reason: collision with other inner class name */
    public class ViewTreeObserverOnScrollChangedListenerC0072b implements ViewTreeObserver.OnScrollChangedListener {
        public ViewTreeObserverOnScrollChangedListenerC0072b() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            b bVar = b.this;
            float fA = bVar.a(bVar.a);
            if (fA == -1.0f) {
                return;
            }
            b.this.c.a(fA);
        }
    }

    public void a() {
        this.a.getViewTreeObserver().removeOnScrollChangedListener(this.b);
    }

    public float a(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return -1.0f;
        }
        int i = rect.top;
        int i2 = rect.bottom;
        int i3 = rect.left;
        int i4 = rect.right;
        Point point = new Point();
        view.getRootView().getWindowVisibleDisplayFrame(rect);
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        point.set(displayMetrics.widthPixels, displayMetrics.heightPixels);
        return ((Math.max(0, Math.min(i2, point.y) - Math.max(i, 0)) * Math.max(0, Math.min(i4, point.x) - Math.max(i3, 0))) / (width * height)) * 100.0f;
    }
}
