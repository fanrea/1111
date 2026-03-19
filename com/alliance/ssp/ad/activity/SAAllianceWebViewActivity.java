package com.alliance.ssp.ad.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.d0.f;
import com.alliance.ssp.ad.o0.l;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SAAllianceWebViewActivity extends Activity {
    public static final /* synthetic */ int l = 0;
    public ImageView a = null;
    public ImageView b = null;
    public SurfaceView c = null;
    public WebView d = null;
    public SAAllianceAdData e = null;
    public String f;
    public int g;
    public int h;
    public int i;
    public WebViewClient j;
    public WebChromeClient k;

    public class a extends WebViewClient {
        public a(SAAllianceWebViewActivity sAAllianceWebViewActivity) {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }
    }

    public class b extends WebChromeClient {
        public b(SAAllianceWebViewActivity sAAllianceWebViewActivity) {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SAAllianceWebViewActivity.this.d.canGoBack()) {
                SAAllianceWebViewActivity.this.d.goBack();
            } else {
                SAAllianceWebViewActivity.this.finish();
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SAAllianceWebViewActivity.this.finish();
        }
    }

    public class e extends WebViewClient {
        public e() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) throws JSONException, URISyntaxException, PackageManager.NameNotFoundException, IOException {
            Uri uri = Uri.parse(str);
            if (com.alipay.sdk.m.l.a.r.equals(uri.getScheme()) || "https".equals(uri.getScheme())) {
                if (com.alipay.sdk.m.l.a.r.equals(uri.getScheme()) && "https".equals(uri.getScheme())) {
                    webView.loadUrl(str);
                }
                return false;
            }
            new Intent();
            try {
                Intent uri2 = Intent.parseUri(str, 1);
                uri2.setFlags(268435456);
                uri2.addCategory("android.intent.category.BROWSABLE");
                uri2.setComponent(null);
                uri2.setSelector(null);
                if (uri2.resolveActivity(SAAllianceWebViewActivity.this.getPackageManager()) != null) {
                    SAAllianceWebViewActivity.this.startActivity(uri2);
                    int i = SAAllianceWebViewActivity.l;
                }
            } catch (URISyntaxException e) {
                new f().a(0, 0, "004", com.alliance.ssp.ad.a.b.a("SAAllianceWebViewActivity 001: ").append(e.getMessage()).toString(), e);
            }
            return true;
        }
    }

    public SAAllianceWebViewActivity() {
        new AtomicBoolean(false);
        new AtomicBoolean(false);
        this.f = "";
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = new a(this);
        this.k = new b(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws JSONException, PackageManager.NameNotFoundException, IOException {
        Material material;
        super.onCreate(bundle);
        setContentView(R.layout.layout_nmssp_webview);
        this.a = (ImageView) findViewById(R.id.iv_nm_land_page_back);
        this.b = (ImageView) findViewById(R.id.iv_nm_land_page_close);
        this.c = (SurfaceView) findViewById(R.id.sv_nm_land_page_video);
        this.d = (WebView) findViewById(R.id.wv_nm_land_page_web);
        if (getIntent() == null) {
            return;
        }
        SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) getIntent().getParcelableExtra("extra_name_land_page_ad_data");
        this.e = sAAllianceAdData;
        if (sAAllianceAdData == null || (material = sAAllianceAdData.getMaterial()) == null) {
            return;
        }
        String ldp = material.getLdp();
        if (TextUtils.isEmpty(ldp)) {
            return;
        }
        this.g = this.e.getWebViewReplaceTagCode();
        this.h = this.e.getWebViewCloseAccess();
        this.i = this.e.getWebViewCloseCache();
        TextUtils.isEmpty(material.getVideourl());
        this.c.setVisibility(8);
        this.a.setOnClickListener(new c());
        this.b.setOnClickListener(new d());
        WebView webView = this.d;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.setWebViewClient(this.j);
        webView.setWebChromeClient(this.k);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        com.alliance.ssp.ad.p.f.a(this.d, this.h, this.i);
        WebSettings settings = this.d.getSettings();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.densityDpi;
        if (i == 120) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        } else if (i == 160) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        } else if (i == 240) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        }
        this.f = this.e.getTagCode();
        this.d.setDownloadListener(new com.alliance.ssp.ad.a.e(this, this.e));
        this.d.setWebViewClient(new e());
        String str = this.f;
        if (str == null || str.isEmpty() || this.g != 0) {
            this.d.loadUrl(ldp);
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("X-Requested-With", URLEncoder.encode(this.f, "UTF-8"));
            this.d.loadUrl(ldp, map);
        } catch (UnsupportedEncodingException e2) {
            this.d.loadUrl(ldp);
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.b.a("SAAllianceWebViewActivity 004: ").append(e2.getMessage()).toString(), e2);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int i = l.a;
        com.alliance.ssp.ad.m0.a.a(this, "SA_TARGET_YT_WEB_ACTIVITY_FINISHED");
    }
}
