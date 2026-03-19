package com.lingku.xuanshang.core.ui.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.alipay.sdk.m.x.d;
import lkxssdk.l0.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WebLoadErrorView extends RelativeLayout {
    public WebViewWrapper a;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebLoadErrorView.this.setVisible(8);
            WebLoadErrorView.this.a.a(true);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebLoadErrorView.this.a.getAty().a();
        }
    }

    public WebLoadErrorView(Context context) {
        super(context);
        a(context);
    }

    public WebLoadErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WebLoadErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a() {
    }

    public final void a(Context context) {
        e eVarA = e.a();
        View.inflate(context, eVarA.b.getResources().getIdentifier("lkxs_view_network_disable", "layout", eVarA.c), this);
        e eVarA2 = e.a();
        Button button = (Button) findViewById(eVarA2.b.getResources().getIdentifier("refresh", "id", eVarA2.c));
        e eVarA3 = e.a();
        button.setOnClickListener(new a());
        e eVarA4 = e.a();
        ((Button) findViewById(eVarA4.b.getResources().getIdentifier(d.z, "id", eVarA4.c))).setOnClickListener(new b());
        setVisible(8);
    }

    public void setVisible(int i) {
        if (getVisibility() != i) {
            setVisibility(i);
        }
    }
}
