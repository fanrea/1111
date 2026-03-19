package com.alliance.ssp.ad.q0;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.R;

/* compiled from: BaseDialog.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a extends Dialog {
    public FrameLayout a;
    public TextView b;
    public TextView c;
    public String d;
    public String e;
    public View.OnClickListener f;
    public View.OnClickListener g;

    /* compiled from: BaseDialog.java */
    /* renamed from: com.alliance.ssp.ad.q0.a$a, reason: collision with other inner class name */
    public class ViewOnClickListenerC0096a implements View.OnClickListener {
        public ViewOnClickListenerC0096a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = a.this.g;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            a.this.dismiss();
        }
    }

    /* compiled from: BaseDialog.java */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = a.this.f;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            a.this.dismiss();
        }
    }

    public a(Context context) {
        this(context, R.style.nm_alliance_base_dialog);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_nmssp_base_dialog);
        this.a = (FrameLayout) findViewById(R.id.fl_dialog_content);
        this.b = (TextView) findViewById(R.id.tv_dialog_cancel);
        this.c = (TextView) findViewById(R.id.tv_dialog_ok);
        setCancelable(false);
        if (!TextUtils.isEmpty(this.e)) {
            this.b.setText(this.e);
        }
        if (!TextUtils.isEmpty(this.d)) {
            this.c.setText(this.d);
        }
        this.b.setOnClickListener(new ViewOnClickListenerC0096a());
        this.c.setOnClickListener(new b());
    }

    public a(Context context, int i) {
        super(context, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }
}
