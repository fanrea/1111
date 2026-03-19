package com.kwad.components.ct.home.e;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import com.kwad.sdk.R;
import com.kwad.sdk.p.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.widget.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends d implements View.OnClickListener {
    private a aLh;
    private View aLi;
    private View aLj;
    private View apQ;
    private final Context mContext;

    public interface a {
        void b(Dialog dialog);

        void c(Dialog dialog);

        void d(Dialog dialog);
    }

    public b(Activity activity, a aVar) {
        super(activity);
        setOwnerActivity(activity);
        this.mContext = m.wrapContextIfNeed(activity);
        this.aLh = aVar;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            requestWindowFeature(1);
            View viewInflate = m.inflate(this.mContext, R.layout.ksad_stay_dialog_layout, null);
            setContentView(viewInflate);
            j(viewInflate);
            setCanceledOnTouchOutside(false);
            setCancelable(false);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void j(View view) {
        View viewFindViewById = view.findViewById(R.id.ksad_dialog_positive_button);
        this.aLi = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        View viewFindViewById2 = view.findViewById(R.id.ksad_dialog_negative_button);
        this.aLj = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        View viewFindViewById3 = view.findViewById(R.id.ksad_dialog_close);
        this.apQ = viewFindViewById3;
        viewFindViewById3.setOnClickListener(this);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        this.aLh = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.aLi) {
            this.aLh.b(this);
        } else if (view == this.aLj) {
            this.aLh.c(this);
        } else if (view == this.apQ) {
            this.aLh.d(this);
        }
    }
}
