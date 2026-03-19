package com.sigmob.sdk.base.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.common.utils.TouchLocation;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.AdPrivacy;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.windad.WindAdRequest;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class q extends Dialog implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    private b a;
    private Map<String, String> b;
    private Context c;
    private Window d;
    private int e;
    private int f;
    private g g;
    private BaseAdUnit h;
    private boolean i;
    private ImageView j;
    private String k;
    private File l;
    private boolean m;
    private RelativeLayout n;
    private Handler o;
    private Activity p;
    private int q;

    static class a {
        private final Map<String, String> a;

        public a(Map<String, String> privacy) {
            this.a = privacy;
        }

        @JavascriptInterface
        public String getPrivacyInfo() {
            Map<String, String> map = this.a;
            if (map != null && !map.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, String> entry : this.a.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                    return jSONObject.toString();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return null;
        }
    }

    public interface b {
        void a();

        void a(Error error);

        void a(String url, String clickCoordinate);

        void b();
    }

    public q(Context context, BaseAdUnit adUnit) {
        super(context, com.sigmob.sdk.base.k.f());
        this.d = null;
        this.i = false;
        this.k = "";
        this.c = context.getApplicationContext();
        this.h = adUnit;
        this.g = b();
        this.j = e();
        this.e = DeviceUtils.getRealMetrics(com.sigmob.sdk.b.e()).widthPixels;
        this.f = DeviceUtils.getRealMetrics(com.sigmob.sdk.b.e()).heightPixels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebResourceResponse a(Uri uri) {
        String host;
        if (uri == null || (host = uri.getHost()) == null) {
            return null;
        }
        try {
            if (host.equalsIgnoreCase("appassets")) {
                AssetManager assets = com.sigmob.sdk.b.e().getAssets();
                String path = uri.getPath();
                if (com.sigmob.sdk.base.utils.m.a((CharSequence) path)) {
                    return null;
                }
                String[] strArrSplit = path.split("/");
                if (strArrSplit.length > 0) {
                    return new WebResourceResponse("text/html", "utf-8", assets.open(strArrSplit[strArrSplit.length - 1]));
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.a();
        }
    }

    private void d() {
        g gVar;
        String str;
        BaseAdUnit baseAdUnit = this.h;
        if (baseAdUnit != null) {
            MaterialMeta material = baseAdUnit.getMaterial();
            if (material == null || material.ad_privacy == null) {
                SigmobLog.i("ad_privacy is null");
            } else {
                AdPrivacy adPrivacy = material.ad_privacy;
                if (com.sigmob.sdk.base.utils.e.b(adPrivacy.privacy_template_info)) {
                    this.b = adPrivacy.privacy_template_info;
                }
                if (!com.sigmob.sdk.base.utils.m.a((CharSequence) adPrivacy.privacy_template_url)) {
                    this.l = com.sigmob.sdk.base.utils.i.a(com.sigmob.sdk.base.utils.i.d(com.sigmob.sdk.base.utils.i.b), Md5Util.md5(adPrivacy.privacy_template_url) + ".html");
                }
            }
        }
        File file = this.l;
        boolean zExists = file != null ? file.exists() : false;
        if (!com.sigmob.sdk.base.utils.m.a((CharSequence) this.k)) {
            gVar = this.g;
            str = this.k;
        } else if (!zExists) {
            this.g.addJavascriptInterface(new a(this.b), "sigPrivacy");
            this.g.loadUrl("https://appassets/android_asset/sig_appelements.html");
            com.sigmob.sdk.base.common.ac.a("h5_error", "download_dialog", 0, " error: htmlUrl: " + this.k + " htmlFile " + this.l + " exists " + zExists, (WindAdRequest) null, (LoadAdRequest) null, this.h, (ac.a) null);
            return;
        } else {
            this.g.addJavascriptInterface(new a(this.b), "sigPrivacy");
            gVar = this.g;
            str = UriUtils.FILE_PREFIX + this.l.getAbsolutePath();
        }
        gVar.loadUrl(str);
    }

    private ImageView e() {
        ImageView imageView = new ImageView(this.c);
        this.j = imageView;
        imageView.setImageBitmap(s.CLOSE.a());
        this.j.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j.setImageAlpha(127);
        this.j.setClickable(true);
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.sigmob.sdk.base.views.q$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        return this.j;
    }

    private void f() {
        if (this.j == null) {
            return;
        }
        int iDipsToIntPixels = Dips.dipsToIntPixels(18.0f, this.c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iDipsToIntPixels, iDipsToIntPixels);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        int i = iDipsToIntPixels / 2;
        layoutParams.setMargins(0, i, i, 0);
        this.n.addView(this.j, layoutParams);
    }

    private void g() {
        Window window = getWindow();
        this.d = window;
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        this.d.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        if (this.m) {
            return;
        }
        f();
    }

    public void a(b clickListener) {
        this.a = clickListener;
    }

    public boolean a() {
        return true;
    }

    public g b() {
        g gVar = new g(this.c);
        this.g = gVar;
        gVar.a(true);
        this.g.setAdUnit(this.h);
        this.g.a((n.a) null);
        this.g.setBackgroundColor(0);
        this.g.setWebChromeClient(new WebChromeClient() { // from class: com.sigmob.sdk.base.views.q.1
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                ConsoleMessage.MessageLevel messageLevel = consoleMessage.messageLevel();
                if (messageLevel != null && messageLevel == ConsoleMessage.MessageLevel.ERROR) {
                    SigmobLog.e("onConsoleMessage " + consoleMessage.message());
                    com.sigmob.sdk.base.common.ac.a("h5_error", "download_dialog", 0, consoleMessage.message(), (WindAdRequest) null, (LoadAdRequest) null, q.this.h, (ac.a) null);
                }
                return false;
            }
        });
        this.g.setWebViewClient(new WebViewClient() { // from class: com.sigmob.sdk.base.views.q.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                com.sigmob.sdk.base.common.ac.a("h5_error", "download_dialog", 0, failingUrl + " error:" + description, (WindAdRequest) null, (LoadAdRequest) null, q.this.h, (ac.a) null);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                SigmobLog.i("onReceivedError:" + error.toString());
                if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT >= 23) {
                    com.sigmob.sdk.base.common.ac.a("h5_error", "download_dialog", 0, request.getUrl() + " error:" + ((Object) error.getDescription()), (WindAdRequest) null, (LoadAdRequest) null, q.this.h, (ac.a) null);
                }
                super.onReceivedError(view, request, error);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                if (Build.VERSION.SDK_INT >= 21) {
                    com.sigmob.sdk.base.common.ac.a("h5_error", "download_dialog", 0, request.getUrl() + " error:" + errorResponse.getStatusCode(), (WindAdRequest) null, (LoadAdRequest) null, q.this.h, (ac.a) null);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                SigmobLog.i("onReceivedSslError:" + error.toString());
                super.onReceivedSslError(view, handler, error);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(final WebView view, final WebResourceRequest request) {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        WebResourceResponse webResourceResponseA = q.this.a(request.getUrl());
                        if (webResourceResponseA != null) {
                            return webResourceResponseA;
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        return com.sigmob.sdk.base.l.a(request.getUrl());
                    }
                    return null;
                } catch (Throwable unused) {
                    return super.shouldInterceptRequest(view, request);
                }
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(final WebView view, final String url) {
                try {
                    WebResourceResponse webResourceResponseA = q.this.a(Uri.parse(url));
                    if (webResourceResponseA != null) {
                        return webResourceResponseA;
                    }
                } catch (Throwable unused) {
                }
                try {
                    return com.sigmob.sdk.base.l.a(Uri.parse(url));
                } catch (Throwable unused2) {
                    return super.shouldInterceptRequest(view, url);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                try {
                    SigmobLog.i("shouldOverrideUrlLoading:" + url);
                    Uri uri = Uri.parse(url);
                    if (StringUtil.scheme().equalsIgnoreCase(uri.getScheme())) {
                        String host = uri.getHost();
                        if (!com.sigmob.sdk.base.utils.m.a((CharSequence) host)) {
                            char c = 65535;
                            int iHashCode = host.hashCode();
                            if (iHashCode != -1785504394) {
                                if (iHashCode != 986884693) {
                                    if (iHashCode == 1614272768 && host.equals("useCustomClose")) {
                                        c = 0;
                                    }
                                } else if (host.equals("closeFourElements")) {
                                    c = 1;
                                }
                            } else if (host.equals("buttonClick")) {
                                c = 2;
                            }
                            if (c == 0) {
                                q.this.m = true;
                                q.this.o.removeCallbacksAndMessages(null);
                            } else if (c != 1) {
                                if (c == 2) {
                                    Map queryParamMap = ClientMetadata.getQueryParamMap(uri);
                                    String str = (String) queryParamMap.get("url");
                                    String str2 = (String) queryParamMap.get("x");
                                    if (com.sigmob.sdk.base.utils.m.a((CharSequence) str2)) {
                                        str2 = "0";
                                    }
                                    String str3 = (String) queryParamMap.get("y");
                                    if (com.sigmob.sdk.base.utils.m.a((CharSequence) str3)) {
                                        str3 = "0";
                                    }
                                    String str4 = String.format("%s,%s,%s,%s", str2, str3, str2, str3);
                                    q.this.h.getMacroCommon().updateClickMarco(str2, str3, str2, str3);
                                    q.this.h.getClickCommon().sld = "0";
                                    q.this.h.getClickCommon().down = new TouchLocation(Integer.parseInt(str2), Integer.parseInt(str3));
                                    q.this.h.getClickCommon().up = new TouchLocation(Integer.parseInt(str2), Integer.parseInt(str3));
                                    if (q.this.a != null) {
                                        q.this.a.a(str, str4);
                                    }
                                }
                            } else if (q.this.a != null) {
                                q.this.a.a();
                            }
                            return true;
                        }
                    }
                } catch (Throwable th) {
                    SigmobLog.e("DownloadDialog:" + th.getMessage());
                }
                if (!com.sigmob.sdk.base.utils.m.a((CharSequence) url) && url.startsWith(com.alipay.sdk.m.l.a.r)) {
                    view.loadUrl(url);
                }
                return true;
            }
        });
        return this.g;
    }

    public void c() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.destroy();
            this.g = null;
        }
        Handler handler = this.o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.o = null;
        }
        ImageView imageView = this.j;
        if (imageView != null) {
            com.sigmob.sdk.base.utils.o.a(imageView);
            this.j = null;
        }
        if (this.c != null) {
            this.c = null;
        }
        if (this.a != null) {
            this.a = null;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.n = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        Window window = getWindow();
        this.d = window;
        com.sigmob.sdk.videoplayer.c.a(window);
        this.n.setBackgroundColor(0);
        setContentView(this.n);
        setOnShowListener(this);
        setOnDismissListener(this);
        if (this.g != null) {
            this.n.addView(this.g, new RelativeLayout.LayoutParams(-1, -1));
        }
        Handler handler = new Handler(Looper.getMainLooper());
        this.o = handler;
        handler.postDelayed(new Runnable() { // from class: com.sigmob.sdk.base.views.q$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.h();
            }
        }, 5000L);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        g();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        SigmobLog.i("DownloadDialog  onDismiss");
        Activity activity = this.p;
        if (activity != null) {
            activity.setRequestedOrientation(this.q);
            this.p = null;
        }
        b bVar = this.a;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialog) {
        SigmobLog.i("DownloadDialog  onShow");
        b bVar = this.a;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        Activity activity;
        super.show();
        Activity activityI = com.sigmob.sdk.b.i();
        this.p = activityI;
        if (activityI != null) {
            this.p = com.sigmob.sdk.b.c();
        }
        Activity activity2 = this.p;
        if (activity2 != null) {
            this.q = activity2.getRequestedOrientation();
            Integer orientationInt = ClientMetadata.getInstance().getOrientationInt();
            if (orientationInt != null) {
                int i = 1;
                if (orientationInt.intValue() == 1) {
                    activity = this.p;
                } else {
                    activity = this.p;
                    i = 0;
                }
                activity.setRequestedOrientation(i);
            }
        }
        d();
    }
}
