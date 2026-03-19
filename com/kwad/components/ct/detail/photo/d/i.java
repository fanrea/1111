package com.kwad.components.ct.detail.photo.d;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.kwad.components.ct.detail.photo.d.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class i extends Dialog {
    private h asN;
    private f ato;
    private a atp;
    private f.a atq;
    private f.a atr;

    public interface a {
        void Al();

        void d(com.kwad.components.ct.detail.photo.e.d dVar);
    }

    public i(Context context, h hVar) {
        super(context);
        this.atq = null;
        this.atr = new f.a() { // from class: com.kwad.components.ct.detail.photo.d.i.1
            @Override // com.kwad.components.ct.detail.photo.d.f.a
            public final void b(com.kwad.components.ct.detail.photo.e.d dVar) {
                if (i.this.atq != null) {
                    i.this.atq.b(dVar);
                }
                i.this.c(dVar);
            }

            @Override // com.kwad.components.ct.detail.photo.d.f.a
            public final void onCancel() {
                if (i.this.atq != null) {
                    i.this.atq.onCancel();
                }
                i.this.dismiss();
            }
        };
        setOwnerActivity(com.kwad.sdk.p.m.fb(context));
        this.asN = hVar;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (com.kwad.components.ct.detail.photo.f.a.aY(this.asN.mAdTemplate)) {
            this.ato = new d(getContext());
        } else {
            this.ato = new f(getContext());
        }
        this.ato.b(this.asN);
        setContentView(this.ato);
        this.ato.a(this.atr);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ato.b(this.atr);
        this.ato.destroy();
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        a aVar = this.atp;
        if (aVar != null) {
            aVar.Al();
        }
    }

    public final void c(com.kwad.components.ct.detail.photo.e.d dVar) {
        super.dismiss();
        a aVar = this.atp;
        if (aVar != null) {
            aVar.d(dVar);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        a aVar = this.atp;
        if (aVar != null) {
            aVar.d(null);
        }
    }

    public final void c(f.a aVar) {
        this.atq = aVar;
    }

    public final void a(a aVar) {
        this.atp = aVar;
    }
}
