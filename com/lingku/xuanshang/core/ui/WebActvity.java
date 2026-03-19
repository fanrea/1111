package com.lingku.xuanshang.core.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.lingku.xuanshang.core.ui.webview.WebViewWrapper;
import com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView;
import lkxssdk.j.c;
import lkxssdk.l0.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WebActvity extends BaseActivity {
    public WebViewWrapper d;
    public String e;
    public int f;
    public int g;
    public int h;
    public TextView i;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebActvity.this.onBackPressed();
        }
    }

    public class b extends lkxssdk.j.b {
        public b(c cVar) {
            super(cVar);
        }

        @Override // lkxssdk.j.b, lkxssdk.j.c
        public void a(String str) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.a(str);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            WebActvity.this.i.setText(str);
        }
    }

    @Override // lkxssdk.d.b
    public void a() {
        int i = this.f;
        finish();
        overridePendingTransition(0, lkxssdk.a.a.a(i, false));
    }

    @Override // lkxssdk.d.b
    public void a(Bundle bundle) {
        this.e = getIntent().getStringExtra("url");
        this.f = getIntent().getIntExtra("animType", 0);
        this.h = getIntent().getIntExtra("backAction", 0);
        this.g = getIntent().getIntExtra("showNav", 1);
    }

    @Override // lkxssdk.d.b
    public void b() {
        if (this.g == 0) {
            e eVarA = e.a();
            ((LinearLayout) findViewById(eVarA.b.getResources().getIdentifier("navLL", "id", eVarA.c))).setVisibility(8);
        }
        e eVarA2 = e.a();
        this.d = (WebViewWrapper) findViewById(eVarA2.b.getResources().getIdentifier("viewweb", "id", eVarA2.c));
        e eVarA3 = e.a();
        TextView textView = (TextView) findViewById(eVarA3.b.getResources().getIdentifier("title", "id", eVarA3.c));
        this.i = textView;
        textView.setText("加载中...");
        e eVarA4 = e.a();
        ((ImageView) findViewById(eVarA4.b.getResources().getIdentifier("backBtn", "id", eVarA4.c))).setOnClickListener(new a());
    }

    @Override // lkxssdk.d.b
    public void c() {
        WebViewWrapper webViewWrapper = this.d;
        String str = this.e;
        b bVar = new b(this);
        webViewWrapper.a = this;
        this.b = webViewWrapper;
        webViewWrapper.j = bVar;
        webViewWrapper.d.loadUrl(str);
    }

    @Override // lkxssdk.d.b
    public void d() {
        boolean z;
        WebViewWrapper webViewWrapper = this.d;
        DWebView dWebView = webViewWrapper.d;
        if (dWebView == null || !dWebView.canGoBack()) {
            z = false;
        } else {
            webViewWrapper.d.goBack();
            z = true;
        }
        if (z) {
            return;
        }
        a();
    }

    @Override // lkxssdk.d.b
    public void e() {
        this.d.a();
    }

    @Override // lkxssdk.d.b
    public int f() {
        e eVarA = e.a();
        return eVarA.b.getResources().getIdentifier("lkxs_aty_web", "layout", eVarA.c);
    }

    @Override // com.lingku.xuanshang.core.ui.base.BaseActivity, android.app.Activity
    public void onBackPressed() {
        int i = this.h;
        if (i == 0) {
            a();
        } else if (i == 1) {
            d();
        } else if (i == 2) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        WebViewWrapper webViewWrapper = this.d;
        if (webViewWrapper == null || !webViewWrapper.g) {
            return;
        }
        ((WebViewWrapper) this.b).b();
    }
}
