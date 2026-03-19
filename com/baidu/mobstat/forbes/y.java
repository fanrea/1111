package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.baidu.mobstat.forbes.af;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class y {
    private static volatile int a = 0;
    private static final y k = new y();
    private WeakReference<Activity> b;
    private int c;
    private boolean d;
    private JSONObject e;
    private boolean f;
    private final Handler h;
    private a i;
    private final Handler g = new Handler(Looper.getMainLooper());
    private x j = new x();

    static /* synthetic */ int c() {
        int i = a + 1;
        a = i;
        return i;
    }

    public static y a() {
        return k;
    }

    private y() {
        HandlerThread handlerThread = new HandlerThread("visitorThread");
        handlerThread.start();
        this.h = new Handler(handlerThread.getLooper());
    }

    public static void b() {
        a = 0;
    }

    public void a(Activity activity, boolean z, JSONObject jSONObject, boolean z2) {
        l.a(activity, !z);
        if (!this.d) {
            this.d = z2;
        }
        if (z) {
            this.f = z;
            this.e = jSONObject;
        }
        if (a(activity, 1)) {
            return;
        }
        if (this.b != null && this.i != null) {
            this.i.a();
        }
        this.b = new WeakReference<>(activity);
        this.c = 1;
        this.i = new a(activity, ae.a(activity), new af.a(1, this.b, this.j), this.g, this.h, this.e, this.d, true, this.f);
    }

    public void a(Activity activity, boolean z) {
        l.b(activity, !z);
        if (a(activity, 2)) {
            return;
        }
        this.b = new WeakReference<>(activity);
        this.c = 2;
        if (this.i != null) {
            this.i.a();
        }
    }

    private boolean a(Activity activity, int i) {
        if (this.b != null && this.b.get() == activity && this.c == i) {
            return true;
        }
        return false;
    }

    static class a implements ViewTreeObserver.OnGlobalLayoutListener, Runnable {
        private final WeakReference<View> c;
        private final af d;
        private final Handler e;
        private final Handler f;
        private JSONObject g;
        private WeakReference<Activity> h;
        private boolean i;
        private boolean j;
        private boolean k;
        private Runnable l = null;
        private boolean b = true;
        private volatile boolean a = false;

        public a(Activity activity, View view, af afVar, Handler handler, Handler handler2, JSONObject jSONObject, boolean z, boolean z2, boolean z3) {
            this.h = new WeakReference<>(activity);
            this.g = jSONObject;
            this.d = afVar;
            this.c = new WeakReference<>(view);
            this.e = handler;
            this.f = handler2;
            this.i = z;
            this.j = z2;
            this.k = z3;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                try {
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            run();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (CooperService.instance().isCloseTrace()) {
                b();
            } else {
                run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.b) {
                return;
            }
            if (this.c.get() == null || this.a) {
                b();
                return;
            }
            if (w.c().b() && this.k) {
                w.c().a("onGlobalLayout");
            }
            if (aa.c().b()) {
                aa.c().a("onGlobalLayout");
            }
            if (b.b()) {
                if (t.c()) {
                    Activity activity = this.h.get();
                    if (activity != null) {
                        y.b(activity, this.i, this.k);
                        a(this.h, this.g, this.d, this.f, this.j);
                    }
                } else {
                    if (w.c().b() && this.k) {
                        w.c().a("no touch, skip onGlobalLayout");
                    }
                    if (aa.c().b()) {
                        aa.c().a("no touch, skip onGlobalLayout");
                    }
                }
            }
            this.e.removeCallbacks(this);
        }

        public void a() {
            if (!this.a) {
                this.a = true;
                this.e.post(this);
            }
        }

        private void b() {
            if (this.b) {
                View view = this.c.get();
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        if (Build.VERSION.SDK_INT < 16) {
                            viewTreeObserver.removeGlobalOnLayoutListener(this);
                        } else {
                            viewTreeObserver.removeOnGlobalLayoutListener(this);
                        }
                    }
                }
                a(this.d, this.f);
            }
            this.b = false;
        }

        private void a(final WeakReference<Activity> weakReference, final JSONObject jSONObject, final af afVar, Handler handler, final boolean z) {
            if (afVar == null || handler == null) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.baidu.mobstat.forbes.y.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!t.c()) {
                        if (w.c().b() && a.this.k) {
                            w.c().a("no touch, skip doViewVisit");
                        }
                        if (aa.c().b()) {
                            aa.c().a("no touch, skip doViewVisit");
                            return;
                        }
                        return;
                    }
                    if (y.c() >= 3) {
                        t.a(false);
                    }
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null) {
                        l.c(activity, z);
                        afVar.a(activity, jSONObject, z);
                    }
                }
            };
            if (this.l != null) {
                handler.removeCallbacks(this.l);
            }
            this.l = runnable;
            handler.postDelayed(runnable, 500L);
        }

        private void a(final af afVar, Handler handler) {
            if (afVar == null || handler == null) {
                return;
            }
            handler.postDelayed(new Runnable() { // from class: com.baidu.mobstat.forbes.y.a.2
                @Override // java.lang.Runnable
                public void run() {
                    afVar.a();
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Activity activity, boolean z, boolean z2) {
        if (z) {
            b(activity, z2);
        }
    }

    private static void b(Activity activity, boolean z) {
        a(activity, ae.a(activity), z);
    }

    private static void a(Activity activity, View view, boolean z) {
        if (view == null || ae.c(activity, view)) {
            return;
        }
        if (view instanceof WebView) {
            WebView webView = (WebView) view;
            if (webView.getTag(-96001) == null) {
                if (w.c().b() && z) {
                    w.c().a("webview auto set " + activity.getClass().getName());
                }
                if (aa.c().b()) {
                    aa.c().a("webview auto set " + activity.getClass().getName());
                }
                StatService.trackWebView(activity.getApplicationContext(), webView, null);
                return;
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(activity, viewGroup.getChildAt(i), z);
            }
        }
    }
}
