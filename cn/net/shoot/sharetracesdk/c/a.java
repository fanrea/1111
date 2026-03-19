package cn.net.shoot.sharetracesdk.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import cn.net.shoot.sharetracesdk.AppData;
import cn.net.shoot.sharetracesdk.ShareTraceInstallListener;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static volatile a e;
    public b a;
    public boolean b = false;
    public final List<Activity> c = new ArrayList();
    public Application d;

    /* renamed from: cn.net.shoot.sharetracesdk.c.a$a, reason: collision with other inner class name */
    public static class C0041a implements ShareTraceInstallListener {
        @Override // cn.net.shoot.sharetracesdk.ShareTraceInstallListener
        public void onError(int i, String str) {
        }

        @Override // cn.net.shoot.sharetracesdk.ShareTraceInstallListener
        public void onInstall(AppData appData) {
        }
    }

    public class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            a.this.c.add(activity);
            if (a.this.c.size() == 1 && cn.net.shoot.sharetracesdk.f.a.c().b()) {
                a aVar = a.this;
                if (aVar.b) {
                    return;
                }
                aVar.b = true;
                d.b().a(new C0041a());
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            a.this.c.remove(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public a() {
        this.a = null;
        this.a = new b();
    }

    public static a a() {
        if (e == null) {
            synchronized (a.class) {
                if (e == null) {
                    e = new a();
                }
            }
        }
        return e;
    }
}
