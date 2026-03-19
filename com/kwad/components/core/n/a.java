package com.kwad.components.core.n;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a extends com.kwad.sdk.mvp.a {
    public List<com.kwad.components.core.n.a.a> Th = new ArrayList();
    private final b<?> Ti;
    public final Context mContext;
    public final View mRootView;

    public a(b<?> bVar) {
        this.Ti = bVar;
        this.mContext = bVar.mContext;
        this.mRootView = bVar.mRootView;
    }

    @Override // com.kwad.sdk.mvp.a
    public void release() {
        this.Th.clear();
    }

    public final void iE() {
        this.Ti.finish();
    }

    @Deprecated
    public final Activity getActivity() {
        return this.Ti.getActivity();
    }
}
