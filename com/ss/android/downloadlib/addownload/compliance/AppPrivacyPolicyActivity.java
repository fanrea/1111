package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.alipay.sdk.m.l.a;
import com.bytedance.gromore.R;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.mk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AppPrivacyPolicyActivity extends Activity {
    private long b;
    private long c;
    private ImageView d;
    private WebView hc;
    private String u;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
        if (d()) {
            hc();
        } else {
            com.ss.android.socialbase.appdownloader.b.d((Activity) this);
        }
    }

    public static void d(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean d() {
        this.b = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.hc.hc hcVarD = b.d().d(this.b);
        if (hcVarD == null) {
            return false;
        }
        this.c = hcVarD.hc;
        String str = hcVarD.tt;
        this.u = str;
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        this.u = mq.tt().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        return true;
    }

    private void hc() {
        this.d = (ImageView) findViewById(R.id.iv_privacy_back);
        this.hc = (WebView) findViewById(R.id.privacy_webview);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.d("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.c);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.hc.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.hc.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return d(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return d(Uri.parse(str));
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT < 26) {
                    return super.onRenderProcessGone(webView, renderProcessGoneDetail);
                }
                if (!renderProcessGoneDetail.didCrash()) {
                    mk.d("System killed the WebView rendering process to reclaim memory. Recreating...");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                    }
                    return true;
                }
                mk.d("The WebView rendering process crashed!");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }

            private boolean d(Uri uri) {
                String scheme = uri.getScheme();
                return (a.r.equals(scheme) || "https".equals(scheme)) ? false : true;
            }
        });
        d(this.hc);
        this.hc.setScrollBarStyle(0);
        this.hc.loadUrl(this.u);
    }

    private void d(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h.d("lp_app_privacy_click_close", this.c);
        super.onBackPressed();
    }
}
