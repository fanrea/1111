package com.qq.e.comm.plugin;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.core.location.LocationRequestCompat;
import java.lang.ref.WeakReference;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class kq extends FrameLayout {
    private c a;
    private b b;
    private boolean c;
    private boolean d;
    private f20 e;
    private String f;

    /* compiled from: A */
    public interface b {
        void dispatchTouchEvent(MotionEvent motionEvent);
    }

    /* compiled from: A */
    public interface c {
        void a(boolean z);

        void b(boolean z);
    }

    public kq(Context context, String str) {
        super(context);
        this.f = str;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        c();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        b();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            b();
        } else {
            c();
        }
    }

    private void b() {
        f20 f20Var = this.e;
        if (f20Var == null) {
            a aVar = new a(this);
            this.e = aVar;
            aVar.g();
            return;
        }
        f20Var.f();
    }

    private void c() {
        f20 f20Var = this.e;
        if (f20Var != null) {
            f20Var.e();
        }
        a(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        a(d50.a(getContext(), this, cd.a(e2.UNIFIED_INTERSTITIAL, this.f)));
    }

    /* compiled from: A */
    private static final class a extends f20 {
        private final WeakReference<kq> h;

        @Override // com.qq.e.comm.plugin.f20
        public void d() {
        }

        public a(kq kqVar) {
            super(LocationRequestCompat.PASSIVE_INTERVAL, 200L);
            this.h = new WeakReference<>(kqVar);
        }

        @Override // com.qq.e.comm.plugin.f20
        public void a(long j) {
            kq kqVar = this.h.get();
            if (kqVar != null) {
                kqVar.a();
            } else {
                h();
            }
        }
    }

    private void a(boolean z) {
        if (this.c != z) {
            this.c = z;
            c cVar = this.a;
            if (cVar != null) {
                cVar.b(z);
            }
        }
        boolean z2 = z && hasWindowFocus();
        if (this.d != z2) {
            this.d = z2;
            c cVar2 = this.a;
            if (cVar2 != null) {
                cVar2.a(z2);
            }
        }
    }

    public void a(b bVar) {
        this.b = bVar;
    }

    public void a(c cVar) {
        this.a = cVar;
    }
}
