package com.kwad.components.offline.api.core.api;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class IOfflineCompoWrapper {
    protected String mOfflinePackageName;

    @Deprecated
    public abstract Context unwrapContextIfNeed(Context context);

    public abstract Context wrapContextIfNeed(Context context);

    public abstract Application wrapGetApplication(Context context);

    public abstract LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater);

    public IOfflineCompoWrapper(String str) {
        this.mOfflinePackageName = str;
    }
}
