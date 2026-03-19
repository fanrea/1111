package com.kwad.components.core.proxy;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements a {
    private final WeakReference<Activity> XQ;
    private com.kwad.components.core.proxy.launchdialog.d XR;
    private com.kwad.components.core.proxy.launchdialog.d XS;

    public c(Activity activity) {
        this.XQ = new WeakReference<>(activity);
    }

    public final boolean d(Activity activity) {
        WeakReference<Activity> weakReference;
        if (activity == null || (weakReference = this.XQ) == null || weakReference.get() == null) {
            return false;
        }
        return this.XQ.get().equals(activity);
    }

    @Override // com.kwad.components.core.proxy.a
    public final String getPageName() {
        WeakReference<Activity> weakReference = this.XQ;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.XQ.get().toString();
    }

    public final void a(Lifecycle.Event event) {
        this.XR = this.XS;
        this.XS = new com.kwad.components.core.proxy.launchdialog.d(event);
    }

    @Override // com.kwad.components.core.proxy.a
    public final com.kwad.components.core.proxy.launchdialog.d sg() {
        return this.XR;
    }

    @Override // com.kwad.components.core.proxy.a
    public final com.kwad.components.core.proxy.launchdialog.d sh() {
        return this.XS;
    }
}
