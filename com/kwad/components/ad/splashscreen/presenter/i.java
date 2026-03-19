package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class i extends e implements com.kwad.sdk.core.j.c {
    private static long ps = 400;
    private com.kwad.components.ad.splashscreen.e.a Iq;
    private Vibrator iS;

    protected abstract void fR();

    protected abstract void i(int i, String str);

    protected abstract void initView();

    protected abstract void mr();

    protected abstract void ms();

    protected abstract void mt();

    protected abstract void mu();

    protected abstract void mv();

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        if (this.HX == null) {
            return;
        }
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(this.HX.mAdTemplate);
        mt();
        mr();
        if (com.kwad.sdk.core.response.b.a.aJ(adInfoEP)) {
            mw();
        }
        ms();
        fR();
        this.HX.Hk.a(this);
    }

    private void mw() {
        if (this.HX != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.Iq;
            if (aVar == null) {
                this.Iq = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.HX.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.i.1
                    {
                        super(adTemplate);
                    }

                    @Override // com.kwad.components.ad.splashscreen.e.a
                    public final void j(int i, String str) {
                        i.this.i(i, str);
                    }
                };
            } else {
                aVar.setAdTemplate(this.HX.mAdTemplate);
            }
            com.kwad.components.core.e.d.c cVar = this.HX.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(this.Iq);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (this.HX != null && this.HX.Hk != null) {
            this.HX.Hk.b(this);
        }
        mv();
        bx.b(getContext(), this.iS);
    }

    protected final void mx() {
        Context context = getContext();
        if (context != null) {
            this.iS = (Vibrator) context.getSystemService("vibrator");
        }
        bx.a(getContext(), this.iS);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void by() {
        if (this.HX.Hn) {
            return;
        }
        mu();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        mv();
    }
}
