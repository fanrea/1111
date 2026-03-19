package com.alliance.ssp.ad.o0;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.alliance.ssp.ad.o0.g;

/* compiled from: DemoApplicationLifeCycle.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f implements Application.ActivityLifecycleCallbacks {
    public final /* synthetic */ g.a a;
    public final /* synthetic */ g b;

    public f(g gVar, g.a aVar) {
        this.b = gVar;
        this.a = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        long jA;
        int iHashCode = activity.hashCode();
        Long l = this.b.d.get(Integer.valueOf(iHashCode));
        if (l == null) {
            long jA2 = g.a();
            g gVar = this.b;
            jA = jA2 - gVar.c;
            gVar.b += jA;
            gVar.c = g.a();
        } else {
            jA = g.a() - l.longValue();
            g gVar2 = this.b;
            gVar2.b += jA;
            gVar2.d.remove(Integer.valueOf(iHashCode));
        }
        this.a.a(jA);
        long j = this.b.b;
        int i = l.a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.b.d.put(Integer.valueOf(activity.hashCode()), Long.valueOf(g.a()));
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
