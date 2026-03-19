package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import com.baidu.mobstat.forbes.ac;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class af implements ac.a {
    private ac a;

    public interface b {
        void a(View view, boolean z, Activity activity);
    }

    public abstract void a();

    public static class a extends af {
        private WeakReference<Activity> a;
        private b b;
        private final WeakHashMap<View, C0147a> c = new WeakHashMap<>();

        public a(int i, WeakReference<Activity> weakReference, b bVar) {
            this.a = weakReference;
            this.b = bVar;
        }

        /* renamed from: com.baidu.mobstat.forbes.af$a$a, reason: collision with other inner class name */
        class C0147a extends View.AccessibilityDelegate {
            private View.AccessibilityDelegate b;
            private View c;
            private volatile boolean d;
            private long e;
            private long f;

            public void a(boolean z) {
                this.d = z;
            }

            public C0147a(WeakReference<Activity> weakReference, View view, String str, View.AccessibilityDelegate accessibilityDelegate, boolean z) {
                this.b = accessibilityDelegate;
                a.this.a = weakReference;
                this.c = view;
                this.d = z;
            }

            public View.AccessibilityDelegate a() {
                return this.b;
            }

            @Override // android.view.View.AccessibilityDelegate
            public void sendAccessibilityEvent(View view, int i) {
                Activity activity;
                if (Build.VERSION.SDK_INT <= 20 || !CooperService.instance().isEnabledAutoEvent()) {
                    return;
                }
                try {
                    if (CooperService.instance().isCloseTrace()) {
                        a.this.a();
                        return;
                    }
                    this.e = System.currentTimeMillis();
                    if (view == this.c && i == 1) {
                        if (w.c().b() && this.d) {
                            w.c().a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (aa.c().b()) {
                            aa.c().a("watch view  OnEvent:" + view.getClass().getName());
                        }
                        if (a.this.a != null && (activity = (Activity) a.this.a.get()) != null) {
                            a.this.b.a(view, this.d, activity);
                        }
                    }
                    if (this.e - this.f < 100) {
                        return;
                    }
                    this.f = System.currentTimeMillis();
                    if (this.b != null && !(this.b instanceof C0147a) && this.b != this) {
                        this.b.sendAccessibilityEvent(view, i);
                    } else {
                        super.sendAccessibilityEvent(view, i);
                    }
                } catch (Throwable th) {
                    a.this.a();
                    CooperService.instance().setEnableAutoEvent(false);
                }
            }
        }

        public void a(WeakReference<Activity> weakReference, View view, String str, boolean z) {
            View.AccessibilityDelegate accessibilityDelegateA = a(view);
            if (!(accessibilityDelegateA instanceof C0147a)) {
                if (CooperService.instance().useNullAccessibilityDelegate() != 1 && accessibilityDelegateA == null) {
                    return;
                }
                C0147a c0147a = new C0147a(weakReference, view, str, accessibilityDelegateA, z);
                view.setAccessibilityDelegate(c0147a);
                this.c.put(view, c0147a);
                return;
            }
            ((C0147a) accessibilityDelegateA).a(z);
        }

        private View.AccessibilityDelegate a(View view) {
            try {
                return (View.AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
            } catch (Exception e) {
                return null;
            }
        }

        @Override // com.baidu.mobstat.forbes.ac.a
        public void a(View view, boolean z) {
            a(this.a, view, ae.a(view), z);
        }

        @Override // com.baidu.mobstat.forbes.af
        public void a() {
            if (this.c == null) {
                return;
            }
            for (Map.Entry<View, C0147a> entry : this.c.entrySet()) {
                entry.getKey().setAccessibilityDelegate(entry.getValue().a());
            }
            this.c.clear();
        }
    }

    public void a(Activity activity, JSONObject jSONObject, boolean z) {
        if (Build.VERSION.SDK_INT <= 20 || !CooperService.instance().isEnabledAutoEvent()) {
            return;
        }
        if (this.a == null) {
            this.a = new ac(activity, this, z);
            this.a.a(jSONObject);
        }
        this.a.a(activity);
    }
}
