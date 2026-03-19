package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
abstract class i0 extends LinearLayout {
    protected ImageView a;
    protected Button b;
    protected final sp c;

    abstract void a(View view);

    abstract void e();

    void f() {
    }

    public i0(Context context, sp spVar) {
        super(context);
        this.c = spVar;
    }

    View a() {
        return this.a;
    }

    View b() {
        return this.b;
    }

    void e(String str) {
        this.b.setText(str);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.c.onClick(this.a);
    }

    void a(View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
        this.b.setOnClickListener(onClickListener);
    }
}
