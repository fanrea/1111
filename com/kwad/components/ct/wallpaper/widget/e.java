package com.kwad.components.ct.wallpaper.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e extends Dialog {
    int anQ;
    private d bar;

    public e(Context context) {
        super(context);
        setOwnerActivity(m.fb(context));
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(13);
        d dVar = new d(m.wrapContextIfNeed(getContext()));
        this.bar = dVar;
        dVar.setProgress(this.anQ);
        setContentView(this.bar);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
    }

    public final void setProgress(int i) {
        this.anQ = i;
        d dVar = this.bar;
        if (dVar != null) {
            dVar.setProgress(i);
        }
    }
}
