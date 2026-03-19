package com.duoyou.task.sdk;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.duoyou.task.openapi.OnPayInterceptorCallback;
import com.duoyou.task.pro.g.g;
import com.duoyou.task.pro.g.n;
import com.duoyou.task.sdk.entity.GameInfo;
import com.duoyou.task.sdk.view.CircleLoadingView;
import com.duoyou.task.sdk.view.dialog.ExitRecommendDialog;
import com.duoyou.task.sdk.view.dialog.GameBottomDialog;
import com.duoyou.task.sdk.view.dialog.LoadingUtils;
import com.duoyou.task.sdk.view.dialog.MyAlertDialog;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.image.ImageOptions;
import com.duoyou.task.sdk.xutils.x;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class PlayGameActivity extends Activity implements SensorEventListener {
    public static boolean B = false;
    public WebView a;
    public WebView b;
    public ProgressBar d;
    public RelativeLayout e;
    public ImageView f;
    public View g;
    public View h;
    public View i;
    public CircleLoadingView j;
    public Runnable k;
    public long l;
    public View m;
    public View n;
    public com.duoyou.task.pro.g.g o;
    public int p;
    public GameInfo q;
    public String r;
    public ImageView s;
    public com.duoyou.task.pro.g.g t;
    public SensorManager w;
    public String y;
    public Map<String, String> c = new HashMap();
    public Handler u = new Handler(Looper.getMainLooper());
    public boolean v = false;
    public boolean x = false;
    public Runnable z = new g();
    public boolean A = false;

    public int d() {
        return 0;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1152, 1152);
        setContentView(R.layout.dy_play_game_activity);
        com.duoyou.task.pro.f.d.a(getApplication());
        b();
        if (this.q == null) {
            com.duoyou.task.pro.g.m.b(getApplicationContext(), "gameInfo 为空");
            finish();
            return;
        }
        j();
        e();
        f();
        h();
        k();
        i();
        g();
        com.duoyou.task.pro.g.h.i().a(d(), this.q.gameId, getTaskId());
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        b();
        GameInfo gameInfo = this.q;
        if (gameInfo == null) {
            com.duoyou.task.pro.g.m.b(getApplicationContext(), "gameInfo 为空");
            finish();
            return;
        }
        if (TextUtils.isEmpty(gameInfo.gameId)) {
            com.duoyou.task.pro.g.m.b(getApplicationContext(), "gameId 为空");
            return;
        }
        if (this.q.gameId.equals(this.r)) {
            return;
        }
        j();
        e();
        f();
        h();
        k();
        i();
        g();
        com.duoyou.task.pro.g.h.i().a(d(), this.q.gameId, getTaskId());
    }

    public final void j() {
        this.d = (ProgressBar) findViewById(R.id.dy_progressBar);
        this.e = (RelativeLayout) findViewById(R.id.dy_web_view_layout);
        this.m = findViewById(R.id.dy_little_game_top);
        this.f = (ImageView) findViewById(R.id.dy_splash_iv);
        this.g = findViewById(R.id.dy_splash_layout);
        this.h = findViewById(R.id.dy_guide_layout);
        this.j = (CircleLoadingView) findViewById(R.id.dy_circle_loading_view);
        this.i = findViewById(R.id.dy_i_know_iv);
        this.m.setVisibility(0);
        this.d.setProgressDrawable(new ClipDrawable(new ColorDrawable(-14627342), 3, 1));
        this.j.startLoading();
    }

    public final void k() {
        String str = this.q.playUrl;
        Log.i("json", "firstUrl = " + str);
        this.a.loadUrl(str);
    }

    public final void a(boolean z) {
        try {
            if (z) {
                setRequestedOrientation(6);
            } else {
                setRequestedOrientation(1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b() {
        String stringExtra = getIntent().getStringExtra("gameInfoString");
        if (!TextUtils.isEmpty(stringExtra)) {
            GameInfo gameInfoBuilder = GameInfo.builder(stringExtra);
            this.q = gameInfoBuilder;
            if (gameInfoBuilder == null) {
                com.duoyou.task.pro.g.m.b(getApplicationContext(), "数据有误, 请删除快捷方式重新创建");
                return;
            }
            return;
        }
        this.q = (GameInfo) getIntent().getSerializableExtra("gameInfo");
    }

    public final void e() {
        this.r = this.q.gameId;
        n();
        try {
            int iD = com.duoyou.task.pro.g.b.d(Uri.parse(this.q.playUrl).getQueryParameter("is_landscape"));
            this.p = iD;
            a(iD == 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.p == 1) {
            if (com.duoyou.task.pro.g.h.i().q() > 0) {
                this.g.setVisibility(0);
                this.f.setImageResource(com.duoyou.task.pro.g.h.i().q());
            } else {
                this.g.setVisibility(8);
            }
        } else if (com.duoyou.task.pro.g.h.i().r() > 0) {
            this.g.setVisibility(0);
            this.f.setImageResource(com.duoyou.task.pro.g.h.i().r());
        } else {
            this.g.setVisibility(8);
        }
        this.e.removeAllViews();
        this.a = new WebView(this);
        this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.e.addView(this.a);
        this.c.put("Referer", c());
        a(this.a);
        if (com.duoyou.task.pro.g.h.i().j() == -1) {
            com.duoyou.task.pro.b.a.a(this, new d());
        }
        if (!com.duoyou.task.pro.g.k.a(getApplicationContext(), "is_show_guide", false)) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
    }

    public class d extends com.duoyou.task.pro.f.a {
        public void onFailure(String str, String str2) {
        }

        public d() {
        }

        public void onSuccess(String str) {
            if (com.duoyou.task.pro.g.f.c(str)) {
                JSONObject jSONObjectB = com.duoyou.task.pro.g.f.b(str);
                int iOptInt = jSONObjectB.optInt("exit_game_popup");
                int iOptInt2 = jSONObjectB.optInt("game_little_helper");
                if (PlayGameActivity.this.q.playUrl.contains("yx.duoyou.com")) {
                    com.duoyou.task.pro.g.h.i().a(0);
                } else {
                    com.duoyou.task.pro.g.h.i().a(iOptInt2);
                }
                com.duoyou.task.pro.g.h.i().b(iOptInt);
            }
        }
    }

    public final void n() {
        if (Build.VERSION.SDK_INT >= 21) {
            setTaskDescription(new ActivityManager.TaskDescription(this.q.gameName));
            x.image().loadDrawable(this.q.gameIcon, ImageOptions.DEFAULT, new e());
        }
    }

    public class e implements Callback.CommonCallback<Drawable> {
        @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
        public void onCancelled(Callback.CancelledException cancelledException) {
        }

        @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
        public void onFinished() {
        }

        public e() {
        }

        @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Drawable drawable) {
            if (drawable != null) {
                try {
                    PlayGameActivity.this.setTaskDescription(new ActivityManager.TaskDescription(PlayGameActivity.this.q.gameName, ((BitmapDrawable) drawable).getBitmap()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.duoyou.task.sdk.xutils.common.Callback.CommonCallback
        public void onError(Throwable th, boolean z) {
            Log.i("json", "ex = " + th.getLocalizedMessage());
        }
    }

    public final void g() {
        this.u.postDelayed(this.z, 90000L);
        this.s = (ImageView) findViewById(R.id.dy_helper_red_iv);
        this.n = findViewById(R.id.dy_helper_delete_at_here_layout);
        com.duoyou.task.pro.g.g gVar = new com.duoyou.task.pro.g.g(this.s, this.p);
        this.t = gVar;
        gVar.a(new f());
    }

    public class f implements g.g {
        public void a(View view) {
        }

        public f() {
        }

        public void b(View view, boolean z) {
            com.duoyou.task.pro.d.b.a(PlayGameActivity.this);
        }

        public void a(View view, boolean z) {
            if (z) {
                PlayGameActivity.this.n.setVisibility(0);
                return;
            }
            PlayGameActivity playGameActivity = PlayGameActivity.this;
            if (playGameActivity.a(playGameActivity.n, (int) view.getX(), (int) view.getY())) {
                PlayGameActivity.this.s.setVisibility(8);
                if (!com.duoyou.task.pro.g.k.a(PlayGameActivity.this.getApplicationContext(), "is_no_notice_again", false)) {
                    new MyAlertDialog.Builder(PlayGameActivity.this).setPositiveColor("#4AB3DE").setMessage("摇一摇手机，图标就会回来哦！").setOnPositiveListener("我知道了", new b(this)).setOnNegativeListener("不在提示", new a()).show();
                }
            }
            PlayGameActivity.this.n.setVisibility(8);
        }

        public class b implements View.OnClickListener {
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }

            public b(f fVar) {
            }
        }

        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.duoyou.task.pro.g.k.b(PlayGameActivity.this.getApplicationContext(), "is_no_notice_again", true);
            }
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayGameActivity.this.v = true;
            if (PlayGameActivity.this.s == null || com.duoyou.task.pro.g.h.i().h() != 1) {
                return;
            }
            PlayGameActivity.this.s.setVisibility(0);
        }
    }

    public final boolean a(View view, int i2, int i3) {
        int x = (int) view.getX();
        int y = (int) view.getY();
        int height = i3 + (view.getHeight() / 2);
        return i2 > x && i2 < x + this.n.getWidth() && height > y && height < this.n.getHeight() + height;
    }

    public class h implements g.g {
        public void a(View view) {
        }

        public void a(View view, boolean z) {
        }

        public h() {
        }

        public void b(View view, boolean z) {
            if (z) {
                PlayGameActivity.this.l();
            } else {
                PlayGameActivity.this.m();
            }
        }
    }

    public final void i() {
        com.duoyou.task.pro.g.g gVar = new com.duoyou.task.pro.g.g(this.m, this.p);
        this.o = gVar;
        gVar.a(new h());
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayGameActivity.this.h.setVisibility(8);
            com.duoyou.task.pro.g.k.b(PlayGameActivity.this.getApplicationContext(), "is_show_guide", true);
        }
    }

    public void f() {
        this.i.setOnClickListener(new i());
        this.a.setWebViewClient(new j());
        this.a.setWebChromeClient(new k());
    }

    public class j extends WebViewClient {
        public j() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Log.i("json", "xxxx = " + str);
            if (!str.contains("wx.tenpay.com") && (str.startsWith("https") || str.startsWith(com.alipay.sdk.m.l.a.r))) {
                PlayGameActivity.this.y = str;
            }
            if (str.contains("wx.tenpay.com") || str.contains("api/pay_redirect")) {
                PlayGameActivity.this.l = System.currentTimeMillis();
                PlayGameActivity.this.runOnUiThread(new a(str));
                return true;
            }
            if (str.contains("game_order/iframe") || str.contains("coin_order/iframe") || str.contains("money_card_order/iframe") || str.contains("game_order/pay")) {
                PlayGameActivity.this.runOnUiThread(new b(str));
                return true;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://")) {
                PlayGameActivity.this.runOnUiThread(new c(str));
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
                LoadingUtils.showLoading(PlayGameActivity.this, com.alipay.sdk.m.x.a.i);
                if (!TextUtils.isEmpty(PlayGameActivity.this.y)) {
                    PlayGameActivity.this.c.put("Referer", com.duoyou.task.pro.g.b.a(PlayGameActivity.this.y));
                }
                PlayGameActivity.this.b.loadUrl(this.a, PlayGameActivity.this.c);
                if (PlayGameActivity.this.k == null) {
                    PlayGameActivity.this.k = new RunnableC0355a();
                }
                PlayGameActivity.this.u.postDelayed(PlayGameActivity.this.k, 30000L);
            }

            /* renamed from: com.duoyou.task.sdk.PlayGameActivity$j$a$a, reason: collision with other inner class name */
            public class RunnableC0355a implements Runnable {
                public RunnableC0355a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    LoadingUtils.hideLoading();
                    PlayGameActivity.this.b.stopLoading();
                    PlayGameActivity.this.b.loadUrl("javascript:var text = document.getElementById('111').innerText;window.dysdk.showToast(text);");
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
                LoadingUtils.showLoading(PlayGameActivity.this, com.alipay.sdk.m.x.a.i);
                PlayGameActivity.this.b.loadUrl(this.a);
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ String a;

            public c(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    PlayGameActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.a)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (PlayGameActivity.this.g.getVisibility() == 0) {
                PlayGameActivity.this.f.setImageResource(0);
                PlayGameActivity.this.g.setVisibility(8);
            }
            if (PlayGameActivity.this.d.getVisibility() == 0) {
                PlayGameActivity.this.d.setVisibility(8);
            }
            if (PlayGameActivity.this.g.getVisibility() == 0) {
                PlayGameActivity.this.g.setVisibility(8);
                PlayGameActivity.this.j.hideLoading();
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                Log.i("json", "url xxxx = " + str);
                if ((str.contains("wap.duoyou.com/index.php/games/role") || str.contains("sdkapi.duoyou.com/games/role")) && !PlayGameActivity.this.v && com.duoyou.task.pro.g.h.i().h() == 1) {
                    PlayGameActivity.this.v = true;
                    PlayGameActivity.this.runOnUiThread(new d());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayGameActivity.this.s.setVisibility(0);
                PlayGameActivity.this.u.removeCallbacks(PlayGameActivity.this.z);
            }
        }
    }

    public class k extends WebChromeClient {
        public k() {
        }

        public class a implements Runnable {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayGameActivity.this.d.getVisibility() == 0) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        PlayGameActivity.this.d.setProgress(this.a, true);
                    } else {
                        PlayGameActivity.this.d.setProgress(this.a);
                    }
                }
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            PlayGameActivity.this.runOnUiThread(new a(i));
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            MyAlertDialog.Builder builder = new MyAlertDialog.Builder(PlayGameActivity.this);
            builder.setMessage(str2);
            builder.setOnNegativeListener("取消", new b(this, jsResult));
            builder.setOnPositiveListener("确定", new c(this, jsResult));
            builder.show();
            return true;
        }

        public class b implements View.OnClickListener {
            public final /* synthetic */ JsResult a;

            public b(k kVar, JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.cancel();
            }
        }

        public class c implements View.OnClickListener {
            public final /* synthetic */ JsResult a;

            public c(k kVar, JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.confirm();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            MyAlertDialog.Builder builder = new MyAlertDialog.Builder(PlayGameActivity.this);
            builder.setMessage(str2);
            builder.setOnNegativeListener("取消", new d(this, jsPromptResult));
            builder.setOnPositiveListener("确定", new e(this, jsPromptResult));
            builder.show();
            return true;
        }

        public class d implements View.OnClickListener {
            public final /* synthetic */ JsPromptResult a;

            public d(k kVar, JsPromptResult jsPromptResult) {
                this.a = jsPromptResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.cancel();
            }
        }

        public class e implements View.OnClickListener {
            public final /* synthetic */ JsPromptResult a;

            public e(k kVar, JsPromptResult jsPromptResult) {
                this.a = jsPromptResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.confirm();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            MyAlertDialog.Builder builder = new MyAlertDialog.Builder(PlayGameActivity.this);
            builder.setMessage(str2);
            builder.setOnNegativeListener("取消", new f(this, jsResult));
            builder.setOnPositiveListener("确定", new g(this, jsResult));
            builder.show();
            return true;
        }

        public class f implements View.OnClickListener {
            public final /* synthetic */ JsResult a;

            public f(k kVar, JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.cancel();
            }
        }

        public class g implements View.OnClickListener {
            public final /* synthetic */ JsResult a;

            public g(k kVar, JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.a.confirm();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }
    }

    public class m extends com.duoyou.task.pro.a.a {
        public m(Activity activity, Handler handler) {
            super(activity, handler);
        }

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.duoyou.task.pro.g.m.b(PlayGameActivity.this.getApplicationContext(), this.a);
            }
        }

        @JavascriptInterface
        public void showToast(String str) {
            PlayGameActivity.this.runOnUiThread(new a(str));
        }

        @JavascriptInterface
        public String getRecentAccountString() {
            return com.duoyou.task.pro.g.b.c(((com.duoyou.task.pro.a.a) this).activity);
        }

        @JavascriptInterface
        public void writeRecentAccount(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                com.duoyou.task.pro.g.b.c(((com.duoyou.task.pro.a.a) this).activity, jSONObject.optString("username"), jSONObject.optString("password"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @JavascriptInterface
        public void deleteRecentAccount(String str) {
            try {
                com.duoyou.task.pro.g.b.b(((com.duoyou.task.pro.a.a) this).activity, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.duoyou.task.pro.g.b.a(PlayGameActivity.this.getApplicationContext(), com.duoyou.task.pro.g.b.a(PlayGameActivity.this.a));
                com.duoyou.task.pro.g.m.b(PlayGameActivity.this.getApplicationContext(), "保存相册成功");
            }
        }

        @JavascriptInterface
        public void screenShot() {
            PlayGameActivity.this.runOnUiThread(new b());
        }
    }

    public final void a(WebView webView) {
        n.a(webView);
        webView.addJavascriptInterface(new m(this, this.u), "dysdk");
    }

    public final void h() {
        this.b = new WebView(this);
        this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.b.setVisibility(8);
        this.e.addView(this.b);
        a(this.b);
        this.b.setWebViewClient(new l());
    }

    public class l extends WebViewClient {
        public l() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Log.i("json", "web url = " + str);
            LoadingUtils.hideLoading();
            if (str.startsWith("weixin://wap/pay")) {
                Log.i("json", "request = " + (System.currentTimeMillis() - PlayGameActivity.this.l));
                try {
                    PlayGameActivity.this.x = true;
                    PlayGameActivity.this.b.loadUrl("");
                    if (PlayGameActivity.this.k != null) {
                        PlayGameActivity.this.u.removeCallbacks(PlayGameActivity.this.k);
                    }
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    PlayGameActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.duoyou.task.pro.g.m.b(PlayGameActivity.this.getApplicationContext(), "请先安装微信！");
                }
                return true;
            }
            OnPayInterceptorCallback onPayInterceptorCallbackM = com.duoyou.task.pro.g.h.i().m();
            if (onPayInterceptorCallbackM != null && onPayInterceptorCallbackM.payInterceptorWithUrl(PlayGameActivity.this, str)) {
                PlayGameActivity.this.b.loadUrl("");
                return true;
            }
            if (str.startsWith("alipays:") || str.startsWith("alipay:")) {
                PlayGameActivity.this.runOnUiThread(new a(str));
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
                    PlayGameActivity.this.x = true;
                    Intent intent = new Intent();
                    intent.setFlags(268435456);
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(this.a));
                    PlayGameActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.duoyou.task.pro.g.m.b(PlayGameActivity.this.getApplicationContext(), "请先安装该软件");
                }
            }
        }
    }

    public final String c() {
        try {
            URL url = new URL(this.q.playUrl);
            return url.getProtocol() + "://" + url.getHost();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        B = true;
        System.currentTimeMillis();
        if (this.x) {
            this.x = false;
            n.a(this.a, "onPayComplete()");
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Sensor defaultSensor;
        super.onStart();
        try {
            SensorManager sensorManager = (SensorManager) getSystemService("sensor");
            this.w = sensorManager;
            if (sensorManager == null || (defaultSensor = sensorManager.getDefaultSensor(1)) == null) {
                return;
            }
            this.w.registerListener(this, defaultSensor, 2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        SensorManager sensorManager = this.w;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        super.onPause();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (sensorEvent.sensor.getType() == 1 && this.v && this.s.getVisibility() == 8) {
                float[] fArr = sensorEvent.values;
                float f2 = fArr[0];
                float f3 = fArr[1];
                float f4 = fArr[2];
                if ((Math.abs(f2) > 20.0f || Math.abs(f3) > 20.0f || Math.abs(f4) > 20.0f) && !this.A) {
                    this.A = true;
                    this.s.setX(com.duoyou.task.pro.g.b.a(this, 18.0f));
                    this.s.setY(com.duoyou.task.pro.g.b.a(this, 150.0f));
                    this.s.setVisibility(0);
                    ((Vibrator) getApplication().getSystemService("vibrator")).vibrate(300L);
                    this.A = false;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public class a implements GameBottomDialog.OnGameBottomListener {
        public a() {
        }

        @Override // com.duoyou.task.sdk.view.dialog.GameBottomDialog.OnGameBottomListener
        public void onRefreshListener() {
            n.a(PlayGameActivity.this.a, "refreshGame()");
        }

        @Override // com.duoyou.task.sdk.view.dialog.GameBottomDialog.OnGameBottomListener
        public void onBindPhoneListener() {
            n.a(PlayGameActivity.this.a, "callBindMobileWindow()");
        }
    }

    public void l() {
        GameBottomDialog.show(this, this.q, this.p).setOnGameBottomListener(new a());
    }

    public void m() {
        onBackPressed();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (com.duoyou.task.pro.g.h.i().j() == 1) {
            new ExitRecommendDialog.Builder(this).setMessage("确定要退出游戏吗").setScreenOrientation(this.p).setOnPositiveListener("坚持离开", new b()).setOnNegativeListener("取消", null).show();
        } else {
            new MyAlertDialog.Builder(this).setMessage("您确定要退出游戏吗?").setPositiveColor("#4AB3DE").setOnPositiveListener("确定", new c()).setOnNegativeListener("再玩一玩", null).show();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayGameActivity.this.a();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayGameActivity.this.a();
        }
    }

    public final void a() {
        try {
            com.duoyou.task.pro.g.h.i().a(d(), this.q.gameId, getTaskId());
            if (com.duoyou.task.pro.g.h.i().v > 0) {
                a((Activity) this, com.duoyou.task.pro.g.h.i().v);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                finishAndRemoveTask();
            } else {
                finish();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            try {
                Log.i("json", "onDestroy = onDestroy");
                com.duoyou.task.pro.g.h.i().a(d(), this.q.gameId, getTaskId());
                WebView webView = this.a;
                if (webView != null) {
                    webView.stopLoading();
                    this.a.removeAllViewsInLayout();
                    this.a.removeAllViews();
                    this.a.setWebViewClient(null);
                    this.a.destroy();
                }
                WebView webView2 = this.b;
                if (webView2 != null) {
                    webView2.destroy();
                }
                Handler handler = this.u;
                if (handler != null) {
                    handler.removeCallbacks(this.z);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            super.onDestroy();
        }
    }

    public static void a(Activity activity, GameInfo gameInfo) {
        int i2;
        if (gameInfo == null) {
            com.duoyou.task.pro.g.m.b(activity, "gameInfo 为空");
            return;
        }
        com.duoyou.task.pro.g.h.i().v = activity.getTaskId();
        if (TextUtils.isEmpty(gameInfo.gameId)) {
            gameInfo.gameId = com.duoyou.task.pro.g.l.a(gameInfo.playUrl);
        }
        com.duoyou.task.pro.e.b bVarA = com.duoyou.task.pro.g.h.i().a(gameInfo.gameId);
        if (bVarA != null && (i2 = bVarA.b) > 0) {
            if (a(activity, gameInfo, i2)) {
                return;
            } else {
                bVarA.b = -1;
            }
        }
        List listK = com.duoyou.task.pro.g.h.i().k();
        int i3 = 0;
        while (true) {
            if (i3 >= listK.size()) {
                i3 = -1;
                break;
            } else if (((com.duoyou.task.pro.e.b) listK.get(i3)).b <= 0) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 == -1 && (i3 = com.duoyou.task.pro.g.h.i().u + 1) > 2) {
            i3 = 0;
        }
        Intent intent = new Intent();
        if (i3 == 0) {
            intent.setClass(activity, PlayGameActivity.class);
            com.duoyou.task.pro.g.h.i().u = 0;
        } else if (i3 == 1) {
            intent.setClass(activity, PlayGameActivity1.class);
            com.duoyou.task.pro.g.h.i().u = 1;
        } else {
            intent.setClass(activity, PlayGameActivity2.class);
            com.duoyou.task.pro.g.h.i().u = 2;
        }
        intent.addFlags(268435456);
        intent.addFlags(134217728);
        intent.putExtra("gameInfo", gameInfo);
        activity.startActivity(intent);
    }

    public static boolean a(Activity activity, int i2) {
        try {
            Log.i("json", "taskId = " + i2);
            ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
            if (Build.VERSION.SDK_INT >= 21) {
                Iterator<ActivityManager.AppTask> it = activityManager.getAppTasks().iterator();
                while (it.hasNext()) {
                    if (it.next().getTaskInfo().id == i2) {
                        activityManager.moveTaskToFront(i2, 1);
                        return true;
                    }
                }
            }
            if (com.duoyou.task.pro.g.h.i().w == null) {
                return false;
            }
            com.duoyou.task.pro.g.h.i().a(com.duoyou.task.pro.g.h.i().w);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Activity activity, GameInfo gameInfo, int i2) {
        try {
            List listK = com.duoyou.task.pro.g.h.i().k();
            for (int i3 = 0; i3 < listK.size(); i3++) {
                if (i2 == ((com.duoyou.task.pro.e.b) listK.get(i3)).b) {
                    Intent intent = new Intent();
                    if (i3 == 0) {
                        intent.setClass(activity, PlayGameActivity.class);
                        com.duoyou.task.pro.g.h.i().u = 0;
                    } else if (i3 == 1) {
                        intent.setClass(activity, PlayGameActivity1.class);
                        com.duoyou.task.pro.g.h.i().u = 1;
                    } else {
                        intent.setClass(activity, PlayGameActivity2.class);
                        com.duoyou.task.pro.g.h.i().u = 2;
                    }
                    intent.addFlags(268435456);
                    intent.addFlags(134217728);
                    intent.putExtra("gameInfo", gameInfo);
                    activity.startActivity(intent);
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
