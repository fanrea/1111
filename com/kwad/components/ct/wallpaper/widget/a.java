package com.kwad.components.ct.wallpaper.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends com.kwad.sdk.widget.d {
    private b bac;
    private c bad;
    private InterfaceC0544a bae;

    /* renamed from: com.kwad.components.ct.wallpaper.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0544a {
        void b(Dialog dialog);

        void c(Dialog dialog);
    }

    public a(Context context, b bVar, InterfaceC0544a interfaceC0544a) {
        super(context);
        setOwnerActivity(m.fb(context));
        this.bac = bVar;
        this.bae = interfaceC0544a;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            requestWindowFeature(1);
            c cVar = new c(m.wrapContextIfNeed(getContext()), this.bac, this.bae, this);
            this.bad = cVar;
            setContentView(cVar);
            setCanceledOnTouchOutside(false);
            setCancelable(false);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            reset();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void reset() {
        this.bae = null;
        this.bac = null;
        this.bad.reset();
    }
}
