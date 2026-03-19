package com.kwad.components.ad.splashscreen.e;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.e;
import com.kwad.sdk.widget.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements e {
    private a Iq;
    private ViewStub Li;
    private ViewGroup Lj;
    private View Lk;
    private TextView Ll;
    private boolean Lm;
    private com.kwad.components.ad.splashscreen.e Ln;
    private j Lo;
    private ViewGroup lz;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    public b(ViewGroup viewGroup, ViewStub viewStub, boolean z, com.kwad.components.core.e.d.c cVar) {
        this.lz = viewGroup;
        this.Li = viewStub;
        this.mApkDownloadHelper = cVar;
        this.Lm = z;
    }

    public final void a(com.kwad.components.ad.splashscreen.e eVar) {
        this.Ln = eVar;
    }

    public final void mE() {
        com.kwad.sdk.core.d.c.d("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.Li);
        if (this.Lj == null) {
            ViewStub viewStub = this.Li;
            if (viewStub != null && viewStub.getParent() != null) {
                this.Lj = (ViewGroup) this.Li.inflate();
            } else {
                this.Lj = (ViewGroup) this.lz.findViewById(R.id.ksad_splash_actionbar_native_root);
            }
            g(this.Lj);
        }
        ViewGroup viewGroup = this.Lj;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    private void g(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        this.Lk = viewGroup.findViewById(R.id.ksad_splash_actionbar_native);
        this.Ll = (TextView) viewGroup.findViewById(R.id.ksad_splash_actionbar_text);
        this.Lo = new j(this.Lk.getContext(), this.Lk, this);
        a(com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, this.mApkDownloadHelper, 4));
    }

    private void a(com.kwad.components.ad.splashscreen.d dVar) {
        if (dVar == null) {
            return;
        }
        ad(dVar.lE());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(String str) {
        TextView textView = this.Ll;
        if (textView == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void i(boolean z, boolean z2) {
        com.kwad.components.ad.splashscreen.e eVar = this.Ln;
        if (eVar != null) {
            eVar.h(z, z2);
        }
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        i(true, view.equals(this.Lk));
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (this.Lm) {
            i(false, view.equals(this.Lk));
        }
    }

    public final void at(AdTemplate adTemplate) {
        a aVar;
        this.mAdTemplate = adTemplate;
        a aVar2 = this.Iq;
        if (aVar2 == null) {
            this.Iq = new a(this.lz.getContext(), this.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.e.b.1
                {
                    super(adTemplate);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                protected final void j(int i, String str) {
                    b.this.ad(str);
                }
            };
        } else {
            aVar2.setAdTemplate(adTemplate);
        }
        if (adTemplate != null) {
            this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        }
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.Iq) == null) {
            return;
        }
        cVar.b(aVar);
    }

    public final void onUnbind() {
        a aVar;
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || (aVar = this.Iq) == null) {
            return;
        }
        cVar.c(aVar);
    }
}
