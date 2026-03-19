package com.kwad.tachikoma;

import android.app.Activity;
import android.app.Application;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.tk.core.a.r;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h implements r {
    private Application mApplication;

    public h(Application application) {
        this.mApplication = application;
    }

    @Override // com.tk.core.a.r
    public final Application hS() {
        return this.mApplication;
    }

    @Override // com.tk.core.a.r
    public final boolean hT() {
        return e.log().isLoggable();
    }

    @Override // com.tk.core.a.r
    public final Activity getCurrentActivity() {
        return OfflineHostProvider.getApi().lifeCycle().getCurrentActivity();
    }
}
