package com.kwad.components.ct.c;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.ct.c.a.b;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.webview.KSApiWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends d {
    private static boolean aQP;
    private com.kwad.components.ct.c.a.a aQQ;
    private b.a aQR;
    private View aQS;
    private FrameLayout aQT;
    private KSApiWebView aoT;

    public a(Context context, b.a aVar) {
        super(context);
        this.aQR = aVar;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            setContentView(R.layout.ksad_dialog_login);
            initView();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void initView() {
        View viewFindViewById = findViewById(R.id.ksad_login_back);
        this.aQS = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ct.c.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (a.this.Jc()) {
                    return;
                }
                a.this.dismiss();
            }
        });
        this.aQT = (FrameLayout) findViewById(R.id.ksad_login_webview_container);
        if (this.aoT == null) {
            aI(getContext());
            String value = com.kwad.components.ct.a.a.amq.getValue();
            if (TextUtils.isEmpty(value)) {
                value = "https://passport.kuaishou.com/account-h5/login?smallWebview=true&sid=kuaishou.unioncontent.wallpaper";
            }
            this.aoT.loadUrl(value);
        }
        this.aQT.addView(this.aoT);
    }

    private void Jb() {
        this.aoT.setWebViewClient(new WebViewClient() { // from class: com.kwad.components.ct.c.a.2
            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return false;
            }

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (a.this.aQS != null) {
                    a.this.aQS.setVisibility(0);
                }
            }
        });
        bk();
        com.kwad.components.ct.c.a.a aVar = new com.kwad.components.ct.c.a.a(this.aoT);
        this.aQQ = aVar;
        aVar.a(new aa(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.ct.c.a.3
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                a.this.dismiss();
            }
        }));
        this.aQQ.a(new b(this.aQR));
        this.aoT.addJavascriptInterface(this.aQQ, "kwadSDK");
    }

    private void bk() {
        com.kwad.components.ct.c.a.a aVar = this.aQQ;
        if (aVar != null) {
            aVar.destroy();
            this.aQQ = null;
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && Jc()) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jc() {
        KSApiWebView kSApiWebView = this.aoT;
        if (kSApiWebView == null || !kSApiWebView.canGoBack()) {
            return false;
        }
        this.aoT.goBack();
        return true;
    }

    private void aI(Context context) {
        KSApiWebView kSApiWebView = new KSApiWebView(context);
        this.aoT = kSApiWebView;
        kSApiWebView.setBackgroundColor(0);
        Jb();
    }

    public final void aJ(Context context) {
        if (aQP) {
            return;
        }
        aQP = true;
        if (ag.dR(context) > 0) {
            return;
        }
        aI(context);
        String value = com.kwad.components.ct.a.a.amq.getValue();
        if (TextUtils.isEmpty(value)) {
            value = "https://passport.kuaishou.com/account-h5/login?smallWebview=true&sid=kuaishou.unioncontent.wallpaper";
        }
        this.aoT.loadUrl(value);
    }
}
