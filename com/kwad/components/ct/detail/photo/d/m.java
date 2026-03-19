package com.kwad.components.ct.detail.photo.d;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class m extends Dialog {
    private k atB;
    private a atC;
    private l atx;

    public interface a {
        void dismiss();
    }

    public m(Context context, l lVar) {
        super(context);
        this.atC = new a() { // from class: com.kwad.components.ct.detail.photo.d.m.1
            @Override // com.kwad.components.ct.detail.photo.d.m.a
            public final void dismiss() {
                m.this.dismiss();
            }
        };
        setOwnerActivity(com.kwad.sdk.p.m.fb(context));
        this.atx = lVar;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        k kVar = new k(com.kwad.sdk.p.m.wrapContextIfNeed(getContext()));
        this.atB = kVar;
        kVar.a(this.atC);
        this.atB.a(this.atx);
        setContentView(this.atB);
        setCanceledOnTouchOutside(true);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.atB.b(this.atC);
        this.atB.destroy();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
    }
}
