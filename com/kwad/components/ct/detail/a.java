package com.kwad.components.ct.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.kwad.components.ct.detail.viewpager.SlidePlayViewPager;
import com.kwad.components.ct.home.j;
import com.kwad.sdk.core.webview.KSApiWebView;
import com.kwad.sdk.l;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a extends com.kwad.components.core.n.c<c> implements com.kwad.components.core.k.a {
    protected SlidePlayViewPager aok;
    protected j aol;
    protected boolean aom;
    protected boolean aon;
    private boolean aoo;

    public final void ye() {
        if (this.aom) {
            return;
        }
        this.aom = true;
        qy();
    }

    public final void yf() {
        if (this.aom) {
            this.aom = false;
            qz();
        }
    }

    public final void yg() {
        if (this.aon) {
            return;
        }
        this.aon = true;
        qA();
    }

    public final void yh() {
        if (this.aon) {
            this.aon = false;
            qB();
        }
    }

    private void yi() {
        int i = getArguments() != null ? getArguments().getInt("KEY_INDEX_IN_VIEW_PAGER") : -1;
        SlidePlayViewPager slidePlayViewPager = this.aok;
        if (slidePlayViewPager == null || i != slidePlayViewPager.getRealPosition()) {
            return;
        }
        ye();
        yg();
    }

    public final void a(j jVar) {
        this.aol = jVar;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.XT instanceof SlidePlayViewPager) {
            this.aok = (SlidePlayViewPager) this.XT;
        }
        View view2 = getView();
        if (l.UL().getApiVersion().startsWith("3.3.8")) {
            j(view2, false);
        }
    }

    private void j(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (view instanceof WebView) {
            com.kwad.sdk.core.d.c.d("DetailBaseFragment", "webView is : " + view.getClass().getName());
            if (view instanceof KSApiWebView) {
                KSApiWebView kSApiWebView = (KSApiWebView) view;
                kSApiWebView.setEnableDestroy(false);
                if (z) {
                    kSApiWebView.release();
                    return;
                }
                return;
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                j(viewGroup.getChildAt(i), z);
            }
        }
    }

    @Override // com.kwad.components.core.n.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.aoo = true;
        yi();
        if (this.Tj == 0 || ((c) this.Tj).aor == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.c> it = ((c) this.Tj).aor.iterator();
        while (it.hasNext()) {
            it.next().qC();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.Tj == 0 || ((c) this.Tj).aor == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.c> it = ((c) this.Tj).aor.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i, i2, intent);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
        if (this.Tj == 0 || ((c) this.Tj).aor == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.c> it = ((c) this.Tj).aor.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
        if (this.Tj == 0 || ((c) this.Tj).aor == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.c> it = ((c) this.Tj).aor.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    @Override // com.kwad.components.core.n.c, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        if (this.Tj != 0) {
            ((c) this.Tj).release();
        }
        this.aoo = false;
        yf();
        yh();
        if (this.Tj == 0 || ((c) this.Tj).aor == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.c> it = ((c) this.Tj).aor.iterator();
        while (it.hasNext()) {
            it.next().onDestroyView();
        }
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (this.Tj != 0 && ((c) this.Tj).aor != null) {
            Iterator<com.kwad.components.core.k.c> it = ((c) this.Tj).aor.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
        if (l.UL().getApiVersion().startsWith("3.3.8")) {
            j(getView(), true);
        }
    }

    @Override // com.kwad.components.core.n.c
    public final void onActivityDestroy() {
        super.onActivityDestroy();
    }

    @Override // com.kwad.components.core.k.a
    public final void qy() {
        if (this.Tj == 0 || ((c) this.Tj).aoq == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.a> it = ((c) this.Tj).aoq.iterator();
        while (it.hasNext()) {
            it.next().qy();
        }
    }

    @Override // com.kwad.components.core.k.a
    public final void qz() {
        if (this.Tj == 0 || ((c) this.Tj).aoq == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.a> it = ((c) this.Tj).aoq.iterator();
        while (it.hasNext()) {
            it.next().qz();
        }
    }

    @Override // com.kwad.components.core.k.a
    public final void qA() {
        if (this.Tj == 0 || ((c) this.Tj).aoq == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.a> it = ((c) this.Tj).aoq.iterator();
        while (it.hasNext()) {
            it.next().qA();
        }
    }

    @Override // com.kwad.components.core.k.a
    public final void qB() {
        if (this.Tj == 0 || ((c) this.Tj).aoq == null) {
            return;
        }
        Iterator<com.kwad.components.core.k.a> it = ((c) this.Tj).aoq.iterator();
        while (it.hasNext()) {
            it.next().qB();
        }
    }

    public final boolean yj() {
        return this.aoo;
    }
}
