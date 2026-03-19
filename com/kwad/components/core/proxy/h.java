package com.kwad.components.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class h extends KsFragment implements com.kwad.sdk.m.a.b {
    protected ViewGroup XT;
    private final com.kwad.sdk.m.a.a mBackPressDelete = new com.kwad.sdk.m.a.a();
    protected Context mContext;
    public ViewGroup pQ;

    protected ViewGroup nn() {
        return null;
    }

    protected int rb() {
        return 0;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            this.mContext = com.kwad.sdk.p.m.wrapContextIfNeed(getActivity());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        this.XT = viewGroup;
        if (this.pQ == null) {
            ViewGroup viewGroupNn = nn();
            this.pQ = viewGroupNn;
            if (viewGroupNn == null && rb() != 0) {
                this.pQ = (ViewGroup) layoutInflaterFrom.inflate(rb(), viewGroup, false);
            }
        }
        return this.pQ;
    }

    public final <T extends View> T findViewById(int i) {
        ViewGroup viewGroup = this.pQ;
        if (viewGroup == null) {
            throw new IllegalArgumentException("ID does not reference a View inside this View");
        }
        return (T) viewGroup.findViewById(i);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (getHost() != null) {
            com.kwad.components.core.u.h.destroyFragment(this.mContext, getView());
        }
    }

    public final void iE() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public boolean onBackPressed() {
        return this.mBackPressDelete.onBackPressed();
    }

    public final void addBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.addBackPressable(bVar);
    }

    public final void addBackPressable(com.kwad.sdk.m.a.b bVar, int i) {
        this.mBackPressDelete.addBackPressable(bVar, 0);
    }

    public final void removeBackPressable(com.kwad.sdk.m.a.b bVar) {
        this.mBackPressDelete.removeBackPressable(bVar);
    }
}
