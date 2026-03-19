package com.duoyou.task.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.duoyou.task.openapi.CustomConfig;
import com.duoyou.task.openapi.OnCommonCallback;
import com.duoyou.task.pro.g.o;
import com.duoyou.task.sdk.dd.AppInstallReceiver;
import com.duoyou.task.sdk.view.MyWebView;
import com.duoyou.task.sdk.view.VerticalSwipeRefreshLayout;
import com.duoyou.task.sdk.view.dialog.LoadingUtils;
import com.duoyou.task.sdk.view.dialog.MyAlertDialog;
import com.luck.picture.lib.config.SelectMimeType;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class WebViewActivity extends Activity {
    public static final /* synthetic */ int A = 0;
    public View b;
    public MyWebView c;
    public ProgressBar d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public View i;
    public TextView j;
    public VerticalSwipeRefreshLayout k;
    public String l;
    public AppInstallReceiver n;
    public ValueCallback<Uri[]> o;
    public WebView s;
    public Runnable t;
    public String v;
    public TextView w;
    public String x;
    public String[] a = {"android.permission.READ_PHONE_STATE"};
    public boolean m = true;
    public boolean p = false;
    public boolean q = false;
    public Map<String, String> r = new HashMap();
    public boolean u = false;
    public Handler y = new Handler(Looper.getMainLooper(), new d());
    public long z = 0;

    public class d implements Handler.Callback {
        public d() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1 && WebViewActivity.this.c != null && !WebViewActivity.this.isFinishing()) {
                int i = message.arg1;
                int i2 = message.arg2;
                Object obj = message.obj;
                com.duoyou.task.pro.g.n.a(WebViewActivity.this.c, String.format("onProgress('%s',%d,%d)", obj != null ? obj.toString() : "", Integer.valueOf(i), Integer.valueOf(i2)));
            }
            return false;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dy_webview_activity);
        com.duoyou.task.pro.g.h.i().b(getApplicationContext());
        d();
        c();
        a();
        b();
        g();
        f();
        com.duoyou.task.pro.g.h.i().w = this;
    }

    public void a() {
        String stringExtra = getIntent().getStringExtra("url");
        this.l = stringExtra;
        if (com.duoyou.task.pro.g.b.b(stringExtra)) {
            this.q = false;
        } else {
            this.q = true;
        }
        this.m = getIntent().getBooleanExtra("isSign", true);
        int iW = com.duoyou.task.pro.g.h.i().w();
        int color = iW > 0 ? getResources().getColor(iW) : -22016;
        this.b.setBackgroundColor(color);
        this.d.setProgressDrawable(new ClipDrawable(new ColorDrawable(color), 3, 1));
        this.k.setEnabled(true);
        this.k.setRefreshing(true);
        int iX = com.duoyou.task.pro.g.h.i().x();
        if (iX > 0) {
            this.g.setTextColor(getResources().getColor(iX));
        }
        boolean z = com.duoyou.task.pro.g.h.i().z();
        if (z) {
            this.e.setImageResource(R.drawable.dy_back_icon_black);
            this.f.setImageResource(R.drawable.dy_close_icon_black);
        } else {
            this.e.setImageResource(R.drawable.dy_back_icon);
            this.f.setImageResource(R.drawable.dy_close_icon);
        }
        if (!TextUtils.isEmpty(com.duoyou.task.pro.g.h.i().p())) {
            this.h.setVisibility(0);
            this.h.setText(com.duoyou.task.pro.g.h.i().p());
        }
        try {
            if ("1".equals(Uri.parse(this.l.replaceAll("#", "")).getQueryParameter("isHideTitle"))) {
                this.b.setVisibility(8);
                this.i.setFitsSystemWindows(false);
                com.duoyou.task.pro.g.a.b(this);
            } else {
                this.b.setVisibility(0);
                this.i.setFitsSystemWindows(true);
                com.duoyou.task.pro.g.a.b(this, color, 0, true);
                com.duoyou.task.pro.g.b.a(this, z);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void e() {
        if (this.m) {
            this.l = o.a(this, this.l);
        }
        Log.i("json", "url new = " + this.l);
        String queryParameter = Uri.parse(this.l).getQueryParameter("task_id");
        if (!TextUtils.isEmpty(queryParameter)) {
            com.duoyou.task.pro.g.h.i().a(getApplicationContext(), queryParameter);
        }
        this.r.put("Referer", com.duoyou.task.pro.g.b.a(this.l));
        this.c.loadUrl(this.l);
        this.g.setText(TextUtils.isEmpty(com.duoyou.task.pro.g.h.i().v()) ? "游戏中心" : com.duoyou.task.pro.g.h.i().v());
    }

    public void d() {
        this.i = findViewById(R.id.dy_parent_layout);
        this.b = findViewById(R.id.dy_title_bar_layout);
        this.c = (MyWebView) findViewById(R.id.dy_web_view);
        this.d = (ProgressBar) findViewById(R.id.dy_progress_bar);
        this.e = (ImageView) findViewById(R.id.dy_back_iv);
        this.f = (ImageView) findViewById(R.id.dy_close_iv);
        this.g = (TextView) findViewById(R.id.dy_title_tv);
        this.k = (VerticalSwipeRefreshLayout) findViewById(R.id.dy_swipe_refresh_layout);
        this.h = (TextView) findViewById(R.id.dy_copy_tv);
        this.j = (TextView) findViewById(R.id.content_tv);
        this.w = (TextView) findViewById(R.id.url_tv);
        this.h.setVisibility(8);
        a(this.c);
        if (CustomConfig.isHideMainBack) {
            this.e.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public final void f() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            if (this.n == null) {
                this.n = new AppInstallReceiver();
            }
            registerReceiver(this.n, intentFilter);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public class e implements SwipeRefreshLayout.OnRefreshListener {
        public e() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public void onRefresh() {
            if (WebViewActivity.this.l.contains("#")) {
                WebViewActivity.this.c.loadUrl("javascript:window.location.reload(true)");
            } else {
                WebViewActivity.this.c.loadUrl(WebViewActivity.this.l);
            }
        }
    }

    public final void b() {
        this.k.setOnRefreshListener(new e());
        this.h.setOnClickListener(new f());
        this.w.setOnClickListener(new g());
        this.j.setOnClickListener(new h());
        this.c.setWebChromeClient(new i());
        this.c.setWebViewClient(new j());
        this.k.setOnChildScrollUpCallback(new k());
        this.e.setOnClickListener(new l());
        this.f.setOnClickListener(new a());
        com.duoyou.task.pro.g.h.i().setCommonCallback(new b());
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.duoyou.task.pro.g.h.i().l() != null) {
                view.setTag(WebViewActivity.this.l);
                com.duoyou.task.pro.g.h.i().l().onClick(view);
            }
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.duoyou.task.pro.g.b.a(WebViewActivity.this.getApplicationContext(), WebViewActivity.this.x);
            com.duoyou.task.pro.g.m.b(WebViewActivity.this.getApplicationContext(), "复制成功");
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.duoyou.task.pro.g.b.a(WebViewActivity.this.getApplicationContext(), WebViewActivity.this.j.getText().toString());
            com.duoyou.task.pro.g.m.b(WebViewActivity.this.getApplicationContext(), "复制成功");
        }
    }

    public class i extends WebChromeClient {
        public i() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            Log.i("json", "url c onProgressChanged = " + i);
            WebViewActivity.this.d.setProgress(i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (TextUtils.isEmpty(com.duoyou.task.pro.g.h.i().v())) {
                WebViewActivity.this.g.setText(str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            MyAlertDialog.Builder builder = new MyAlertDialog.Builder(WebViewActivity.this);
            builder.setMessage(str2);
            builder.setOnNegativeListener("取消", new a(this, jsResult));
            builder.setOnPositiveListener("确定", new b(this, jsResult));
            builder.show();
            return true;
        }

        public class a implements View.OnClickListener {
            public final /* synthetic */ JsResult a;

            public a(i iVar, JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.cancel();
            }
        }

        public class b implements View.OnClickListener {
            public final /* synthetic */ JsResult a;

            public b(i iVar, JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.confirm();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            MyAlertDialog.Builder builder = new MyAlertDialog.Builder(WebViewActivity.this);
            builder.setMessage(str2);
            builder.setOnNegativeListener("取消", new c(this, jsPromptResult));
            builder.setOnPositiveListener("确定", new d(this, jsPromptResult));
            builder.show();
            return true;
        }

        public class c implements View.OnClickListener {
            public final /* synthetic */ JsPromptResult a;

            public c(i iVar, JsPromptResult jsPromptResult) {
                this.a = jsPromptResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.cancel();
            }
        }

        public class d implements View.OnClickListener {
            public final /* synthetic */ JsPromptResult a;

            public d(i iVar, JsPromptResult jsPromptResult) {
                this.a = jsPromptResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.confirm();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            MyAlertDialog.Builder builder = new MyAlertDialog.Builder(WebViewActivity.this);
            builder.setMessage(str2);
            builder.setOnNegativeListener("取消", new e(this, jsResult));
            builder.setOnPositiveListener("确定", new f(this, jsResult));
            builder.show();
            return true;
        }

        public class e implements View.OnClickListener {
            public final /* synthetic */ JsResult a;

            public e(i iVar, JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.cancel();
            }
        }

        public class f implements View.OnClickListener {
            public final /* synthetic */ JsResult a;

            public f(i iVar, JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.confirm();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            permissionRequest.grant(permissionRequest.getResources());
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            WebViewActivity.this.o = valueCallback;
            a();
            return true;
        }

        public final void a() {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(SelectMimeType.SYSTEM_IMAGE);
            WebViewActivity.this.startActivityForResult(Intent.createChooser(intent, "Choose"), 36865);
        }
    }

    public class j extends WebViewClient {
        public j() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Log.i("json", "url c shouldOverrideUrlLoading2 = ");
            String string = webResourceRequest.getUrl().toString();
            Log.i("json", "url c first = " + string);
            if (!com.duoyou.task.pro.g.b.c(string) && !TextUtils.isEmpty(com.duoyou.task.pro.g.h.i().s()) && TextUtils.isEmpty(com.duoyou.task.pro.g.h.i().y())) {
                new MyAlertDialog.Builder(WebViewActivity.this).setMessage("你当前没有登录，请先登录").setOnPositiveListener("马上登录", new a()).show();
                return true;
            }
            if (com.duoyou.task.pro.g.b.b(string) && WebViewActivity.this.q) {
                WebViewActivity.this.runOnUiThread(new b(string));
                return true;
            }
            if (!string.contains("wx.tenpay.com") && (string.startsWith("https") || string.startsWith(com.alipay.sdk.m.l.a.r))) {
                WebViewActivity.this.v = string;
            }
            if (string.startsWith("https://wx.tenpay.com") || string.contains("api/pay_redirect")) {
                WebViewActivity.this.runOnUiThread(new c(string));
                return true;
            }
            if (string.contains("money_save/pay_iframe")) {
                WebViewActivity.this.runOnUiThread(new d(string));
                return true;
            }
            if (!string.startsWith("http://") && !string.startsWith("https://")) {
                WebViewActivity.this.runOnUiThread(new e(string));
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebViewActivity.this.p = true;
                if (com.duoyou.task.pro.g.h.i().x != null) {
                    com.duoyou.task.pro.g.h.i().x.onNeedLoginCallback(WebViewActivity.this);
                }
            }
        }

        public class b implements Runnable {
            public final /* synthetic */ String a;

            public b(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.a;
                int i = WebViewActivity.A;
                WebViewActivity.a(WebViewActivity.this, str, false);
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ String a;

            public c(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                LoadingUtils.showLoading(WebViewActivity.this);
                if (!TextUtils.isEmpty(WebViewActivity.this.v)) {
                    WebViewActivity.this.r.put("Referer", com.duoyou.task.pro.g.b.a(WebViewActivity.this.v));
                }
                WebViewActivity.this.s.loadUrl(this.a, WebViewActivity.this.r);
                if (WebViewActivity.this.t == null) {
                    WebViewActivity.this.t = new a();
                }
                WebViewActivity.this.y.postDelayed(WebViewActivity.this.t, 15000L);
            }

            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    LoadingUtils.hideLoading();
                    WebViewActivity.this.s.stopLoading();
                    WebViewActivity.this.s.loadUrl("javascript:var text = document.getElementById('111').innerText;window.android.showToast(text);");
                }
            }
        }

        public class d implements Runnable {
            public final /* synthetic */ String a;

            public d(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                LoadingUtils.showLoading(WebViewActivity.this);
                WebViewActivity.this.s.loadUrl(this.a);
            }
        }

        public class e implements Runnable {
            public final /* synthetic */ String a;

            public e(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.a)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Log.i("json", "url c finish = " + str);
            super.onPageFinished(webView, str);
            WebViewActivity.this.d.setVisibility(8);
            WebViewActivity.this.k.setRefreshing(false);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            WebViewActivity.this.d.setVisibility(8);
            WebViewActivity.this.k.setRefreshing(false);
            WebViewActivity.this.runOnUiThread(new f(str2, i, str));
        }

        public class f implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ int b;
            public final /* synthetic */ String c;

            public f(String str, int i, String str2) {
                this.a = str;
                this.b = i;
                this.c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                WebViewActivity.this.x = this.a;
                WebViewActivity.this.w.setVisibility(0);
                WebViewActivity.this.w.setText(this.a + "\n点击复制");
                WebViewActivity.this.j.setVisibility(0);
                WebViewActivity.this.j.setText("错误原因：\nerrCode = " + this.b + "\nerr = " + this.c + "\n" + com.duoyou.task.pro.g.h.i().H);
                com.duoyou.task.pro.g.k.b(WebViewActivity.this.getApplicationContext(), "error_domain", o.b(this.a));
                com.duoyou.task.pro.g.h.i().a(this.a, this.b, this.c);
                com.duoyou.task.pro.g.h.i().a();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            Log.i("json", "url c onPageStarted = " + str);
            WebViewActivity.this.d.setVisibility(0);
            WebViewActivity.this.j.setVisibility(8);
            WebViewActivity.this.w.setVisibility(8);
            WebViewActivity.this.k.setRefreshing(true);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(WebViewActivity.this.c, webResourceRequest);
        }
    }

    public class k implements SwipeRefreshLayout.OnChildScrollUpCallback {
        public k() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnChildScrollUpCallback
        public boolean canChildScrollUp(SwipeRefreshLayout swipeRefreshLayout, View view) {
            try {
                if (WebViewActivity.this.c != null) {
                    return WebViewActivity.this.c.getScrollY() > 0;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebViewActivity.this.onBackPressed();
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WebViewActivity.this.finish();
        }
    }

    public class b implements OnCommonCallback {
        public b() {
        }

        @Override // com.duoyou.task.openapi.OnCommonCallback
        public void onAppUninstalled(String str) {
            com.duoyou.task.pro.g.n.a(WebViewActivity.this.c, String.format("onAppUninstalled()", new Object[0]));
        }
    }

    public final void c() {
        this.s = new WebView(this);
        this.s.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.s.setVisibility(8);
        this.k.addView(this.s);
        this.s.addJavascriptInterface(new n(), "android");
        com.duoyou.task.pro.g.n.a(this.s);
        this.s.setWebViewClient(new c());
    }

    public class c extends WebViewClient {
        public c() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Log.i("json", "pay web url shouldOverrideUrlLoading = " + str);
            LoadingUtils.hideLoading();
            if (str.startsWith("weixin://wap/pay")) {
                try {
                    WebViewActivity.this.u = true;
                    WebViewActivity.this.s.loadUrl("");
                    if (WebViewActivity.this.t != null) {
                        WebViewActivity.this.y.removeCallbacks(WebViewActivity.this.t);
                    }
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    WebViewActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.duoyou.task.pro.g.m.b(WebViewActivity.this.getApplicationContext(), "请先安装对应软件！");
                }
                return true;
            }
            if (str.startsWith("alipays:") || str.startsWith("alipay:")) {
                WebViewActivity.this.runOnUiThread(new a(str));
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewActivity.this.u = true;
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(this.a));
                    WebViewActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.duoyou.task.pro.g.m.b(WebViewActivity.this.getApplicationContext(), "请先安装对应软件！");
                }
            }
        }
    }

    public class n {
        public n() {
        }

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.a)) {
                    com.duoyou.task.pro.g.m.b(WebViewActivity.this.getApplicationContext(), "请求超时，请稍后再试！");
                } else {
                    com.duoyou.task.pro.g.m.b(WebViewActivity.this.getApplicationContext(), this.a);
                }
            }
        }

        @JavascriptInterface
        public void showToast(String str) {
            WebViewActivity.this.runOnUiThread(new a(str));
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ValueCallback<Uri[]> valueCallback;
        if (i3 == -1) {
            if (i2 == 36865 && this.o != null) {
                this.o.onReceiveValue(new Uri[]{(intent == null || i3 != -1) ? null : intent.getData()});
                this.o = null;
                return;
            }
            return;
        }
        if (i3 != 0 || (valueCallback = this.o) == null) {
            return;
        }
        valueCallback.onReceiveValue(null);
        this.o = null;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            MyWebView myWebView = this.c;
            if (myWebView == null) {
                return;
            }
            if (myWebView.canGoBack()) {
                this.c.goBack();
                return;
            }
            if (!CustomConfig.isApp) {
                finish();
            } else if (System.currentTimeMillis() - this.z < 2000) {
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "再按一次返回键退出", 0).show();
                this.z = System.currentTimeMillis();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(WebView webView) {
        com.duoyou.task.pro.g.n.a(webView);
        webView.addJavascriptInterface(new m(this, this.y), "dysdk");
        if (com.duoyou.task.pro.g.h.i().y == null || TextUtils.isEmpty(com.duoyou.task.pro.g.h.i().z)) {
            return;
        }
        com.duoyou.task.pro.g.h.i().y.setWebView(webView);
        webView.addJavascriptInterface(com.duoyou.task.pro.g.h.i().y, com.duoyou.task.pro.g.h.i().z);
    }

    public class m extends com.duoyou.task.pro.a.a {
        public m(Activity activity, Handler handler) {
            super(activity, handler);
        }

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                new MyAlertDialog.Builder(WebViewActivity.this).setMessage("你当前没有登录，请先登录").setOnPositiveListener("马上登录", new ViewOnClickListenerC0356a()).show();
            }

            /* renamed from: com.duoyou.task.sdk.WebViewActivity$m$a$a, reason: collision with other inner class name */
            public class ViewOnClickListenerC0356a implements View.OnClickListener {
                public ViewOnClickListenerC0356a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WebViewActivity.this.p = true;
                    if (com.duoyou.task.pro.g.h.i().x != null) {
                        com.duoyou.task.pro.g.h.i().x.onNeedLoginCallback(WebViewActivity.this);
                    }
                }
            }
        }

        @JavascriptInterface
        public void showNeedLoginDialog() {
            WebViewActivity.this.runOnUiThread(new a());
        }
    }

    public final void g() {
        boolean z;
        int i2 = 0;
        while (true) {
            try {
                String[] strArr = this.a;
                if (i2 >= strArr.length) {
                    z = false;
                    break;
                } else {
                    if (ActivityCompat.checkSelfPermission(this, strArr[i2]) != 0) {
                        z = true;
                        break;
                    }
                    i2++;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (z) {
            ActivityCompat.requestPermissions(this, this.a, 0);
        } else {
            e();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        e();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            MyWebView myWebView = this.c;
            if (myWebView != null) {
                if (this.p) {
                    this.p = false;
                    String strA = o.a(this, this.l);
                    this.l = strA;
                    this.c.loadUrl(strA);
                    return;
                }
                String url = myWebView.getUrl();
                boolean z = !TextUtils.isEmpty(url) && com.duoyou.task.pro.g.b.b(url);
                String strS = com.duoyou.task.pro.g.h.i().s();
                if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(strS) && url.contains(com.duoyou.task.pro.g.h.i().s())) {
                    z = true;
                }
                if (z) {
                    if (TextUtils.isEmpty(Uri.parse(url.replaceAll("#", "")).getQueryParameter("media_id"))) {
                        this.c.loadUrl(this.l);
                    } else {
                        this.c.reload();
                    }
                }
                this.c.resumeTimers();
                com.duoyou.task.pro.g.n.a(this.c, String.format("onActivityResume('%s')", this.c.getUrl()));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.u) {
            this.u = false;
            com.duoyou.task.pro.g.n.a(this.c, "onPayComplete()");
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        try {
            com.duoyou.task.pro.g.h.i().v = -1;
            MyWebView myWebView = this.c;
            if (myWebView != null) {
                myWebView.stopLoading();
                this.c.removeAllViews();
                this.c.destroy();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        AppInstallReceiver appInstallReceiver = this.n;
        if (appInstallReceiver != null) {
            unregisterReceiver(appInstallReceiver);
        }
        super.onDestroy();
    }

    public static void a(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            com.duoyou.task.pro.g.m.b(context, "详情地址为空");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra("isSign", z);
        intent.setClass(context, WebViewActivity.class);
        context.startActivity(intent);
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            com.duoyou.task.pro.g.m.b(context, "url地址为空");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", str);
        if (str.contains("sign=")) {
            intent.putExtra("isSign", false);
        } else {
            intent.putExtra("isSign", true);
        }
        intent.setClass(context, WebViewActivity.class);
        context.startActivity(intent);
    }
}
