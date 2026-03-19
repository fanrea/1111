package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    private k XO;
    private Set<c> XP = new HashSet();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public b(k kVar) {
        this.XO = kVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity activity, Bundle bundle) {
        this.XP.add(new c(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        c cVarC = c(activity);
        if (cVarC != null) {
            cVarC.a(Lifecycle.Event.ON_CREATE);
            k kVar = this.XO;
            if (kVar != null) {
                kVar.a(cVarC);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityCreated : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        c cVarC = c(activity);
        if (cVarC != null) {
            cVarC.a(Lifecycle.Event.ON_START);
            k kVar = this.XO;
            if (kVar != null) {
                kVar.b(cVarC);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityStarted : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        c cVarC = c(activity);
        if (cVarC != null) {
            cVarC.a(Lifecycle.Event.ON_RESUME);
            k kVar = this.XO;
            if (kVar != null) {
                kVar.c(cVarC);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityResumed : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        c cVarC = c(activity);
        if (cVarC != null) {
            cVarC.a(Lifecycle.Event.ON_PAUSE);
            k kVar = this.XO;
            if (kVar != null) {
                kVar.d(cVarC);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityPaused : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        c cVarC = c(activity);
        if (cVarC != null) {
            cVarC.a(Lifecycle.Event.ON_STOP);
            k kVar = this.XO;
            if (kVar != null) {
                kVar.e(cVarC);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityStopped : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        c cVarC = c(activity);
        if (cVarC != null) {
            k kVar = this.XO;
            if (kVar != null) {
                kVar.f(cVarC);
            }
            this.XP.remove(cVarC);
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityDestroyed : " + activity);
    }

    private c c(Activity activity) {
        for (c cVar : this.XP) {
            if (cVar.d(activity)) {
                return cVar;
            }
        }
        return null;
    }
}
