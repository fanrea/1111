package com.baidu.mobads.container;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.baidu.mobads.container.util.bo;
import com.baidu.mobads.container.util.bq;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ax extends az implements com.component.a.c.c {
    public String a;
    private boolean c;
    private boolean d;
    private boolean e;
    private d f;
    private com.baidu.mobads.container.y.c g;
    private com.baidu.mobads.container.y.b h;
    private com.component.a.i.f i;
    private b j;

    public interface b {
        boolean a(int i, KeyEvent keyEvent);
    }

    public static class c {
        public boolean a = true;
    }

    public interface d {
        void a(int i, int i2, boolean z, boolean z2);
    }

    @Override // com.component.a.c.c
    public void setLifeCycle(com.component.a.i.f fVar) {
        this.i = fVar;
    }

    @Override // com.component.a.c.c
    public com.component.a.i.f getLifeCycle() {
        return this.i;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.i != null) {
            this.i.a(this, z);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.i != null) {
            this.i.a((View) this, i);
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.i != null) {
            this.i.e(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.i != null) {
            this.i.f(this);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.i != null) {
            this.i.b(view, i);
        }
    }

    @Override // com.component.a.c.c
    public void switchViewStyle(com.component.a.f.e eVar) {
    }

    static class a {
        private static final String a = ",";
        private static String[] b = "zip,rar,7z,tar.gz,bz".split(a);
        private static String[] c = "mp4,3gp,3g2,avi,rm,rmvb,wmv,flv,mkv,mov,asf,asx".split(a);
        private static String[] d = "mp3,ra,wma,m4a,wav,aac,mmf,amr,ogg,adp".split(a);
        private static final String e = "sms,smsto,mms";
        private static String[] f = e.split(a);
        private static final String[] g = {"tel"};
        private static final String[] h = {"mailto"};
        private static final String i = "http,https";
        private static String[] j = i.split(a);
        private static String[] k = "http,https,sms,smsto,mms,tel,fax,ftp,mailto,gopher,news,telnet,file".split(a);

        a() {
        }

        private static String g(String[] strArr) {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str).append(StringUtil.COMMA);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(bq bqVar) {
            bqVar.a(g(b));
            bqVar.a(g(c));
            bqVar.a(g(d));
            bqVar.a(g(f));
            bqVar.a(g(j));
            bqVar.a(g(k));
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            String[] unused = a.b = jSONObject.getString("DOWNLOADS").split(",");
            String[] unused2 = a.c = jSONObject.getString("VIDEOS").split(",");
            String[] unused3 = a.d = jSONObject.getString("AUDIOS").split(",");
            String[] unused4 = a.j = jSONObject.getString("HTTPSCHEMES").split(",");
            String[] unused5 = a.f = jSONObject.getString("SMSSCHEMES").split(",");
            String[] unused6 = a.k = jSONObject.getString("SCHEMES").split(",");
            a.b(this.b);
        } catch (JSONException e) {
            this.b.a(e);
        }
    }

    public static ax a(Context context, bq bqVar, boolean z, boolean z2, c cVar) {
        a(context);
        return new ax(context, bqVar, z, z2, cVar);
    }

    public static ax a(Context context, bq bqVar, boolean z, boolean z2) {
        return a(context, bqVar, z, z2, new c());
    }

    public static void a(Context context) {
        String str;
        if (com.baidu.mobads.container.util.x.a(context).a() >= 28) {
            try {
                Iterator<ActivityManager.RunningAppProcessInfo> it = new com.component.c.a(context).a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == Process.myPid()) {
                        str = next.processName;
                        break;
                    }
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(context.getApplicationInfo().packageName, str)) {
                    WebView.setDataDirectorySuffix(str);
                }
            } catch (Throwable th) {
            }
        }
    }

    private ax(Context context, bq bqVar, boolean z, boolean z2, c cVar) {
        super(context, bqVar);
        this.a = "";
        this.c = false;
        this.d = true;
        this.e = true;
        setClickable(true);
        setBackgroundColor(0);
        setFocusable(z2);
        setScrollBarStyle(0);
        WebSettings settings = getSettings();
        if (com.baidu.mobads.container.util.x.a(context).a() >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        try {
            if (com.baidu.mobads.container.util.x.a(context).a() >= 26) {
                settings.setSafeBrowsingEnabled(false);
            }
        } catch (Throwable th) {
        }
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setNeedInitialFocus(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        String path = context.getApplicationContext().getDir("database", 0).getPath();
        try {
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(path);
            this.b.a("MyWebView", "setDomStorageEnabled");
        } catch (Exception e) {
            this.b.a("API 7, LocalStorage/SessionStorage");
        }
        try {
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
            this.b.a("MyWebView", "Geolocation");
        } catch (Exception e2) {
            this.b.a("API 5, Geolocation");
        }
        try {
            if (com.baidu.mobads.container.util.x.a(context).a() >= 19) {
                settings.setUserAgentString(settings.getUserAgentString() + " Mobads");
            }
        } catch (Exception e3) {
            this.b.a("API 19, open debug");
        }
        try {
            if (com.baidu.mobads.container.util.x.a(context).a() >= 21) {
                settings.setMixedContentMode(0);
            }
        } catch (Throwable th2) {
            this.b.a("API 21, setMix");
        }
        setWebViewClient(new ay());
        setWebChromeClient(new WebChromeClient());
        try {
            if (com.baidu.mobads.container.util.x.a(context).a() >= 14 && cVar.a) {
                setLayerType(1, null);
            }
        } catch (Exception e4) {
            this.b.a(e4);
        }
        try {
            if (com.baidu.mobads.container.util.x.a(context).a() >= 21 && com.baidu.mobads.container.util.t.e(context) >= 21) {
                bo.a(CookieManager.getInstance(), "setAcceptThirdPartyCookies", (Class<?>[]) new Class[]{WebView.class, Boolean.TYPE}, new Object[]{this, true});
            }
        } catch (Throwable th3) {
            this.b.c(th3);
        }
    }

    public void a(com.baidu.mobads.container.y.c cVar) {
        this.g = cVar;
        setWebViewClient(cVar);
    }

    public void a(com.baidu.mobads.container.y.b bVar) {
        this.h = bVar;
        setWebChromeClient(bVar);
    }

    public com.baidu.mobads.container.y.c a() {
        com.baidu.mobads.container.y.c cVar = this.g;
        this.g = null;
        return cVar;
    }

    public com.baidu.mobads.container.y.b b() {
        com.baidu.mobads.container.y.b bVar = this.h;
        this.h = null;
        return bVar;
    }

    private static boolean a(String[] strArr, String str) {
        if (str == null) {
            return false;
        }
        Uri uri = Uri.parse(str);
        String lowerCase = uri.getPath() == null ? "" : uri.getPath().toLowerCase(Locale.getDefault());
        for (String str2 : strArr) {
            if (lowerCase.trim().endsWith("." + str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(String[] strArr, String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        for (String str2 : strArr) {
            if (lowerCase.trim().startsWith(str2 + ":")) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(String str) {
        return c(str) || d(str) || e(str) || (j(str) && (!b(str) || f(str) || g(str) || h(str)));
    }

    private static boolean j(String str) {
        return b(a.k, str);
    }

    public static boolean b(String str) {
        return b(a.j, str);
    }

    public static boolean c(String str) {
        return b(a.f, str);
    }

    public static boolean d(String str) {
        return b(a.g, str);
    }

    public static boolean e(String str) {
        return b(a.h, str);
    }

    public static boolean f(String str) {
        return a(a.b, str);
    }

    public static boolean g(String str) {
        return a(a.c, str);
    }

    public static boolean h(String str) {
        return a(a.d, str);
    }

    public static boolean i(String str) {
        return !b(str) || f(str) || g(str) || h(str);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.j == null) {
            return false;
        }
        return this.j.a(i, keyEvent);
    }

    public void a(b bVar) {
        this.j = bVar;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            if (!this.c) {
                super.loadUrl(str);
            }
        } catch (Exception e) {
            this.b.c(e);
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!this.c) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            if (!this.c) {
                super.destroy();
                this.c = true;
            }
        } catch (Throwable th) {
            this.b.c(th);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        this.d = z2 && i2 == 0;
        this.e = z && i == 0;
        super.onOverScrolled(i, i2, z, z2);
        if (this.f != null) {
            this.f.a(i, i2, z, z2);
        }
    }

    public boolean c() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.c;
    }

    public void a(d dVar) {
        this.f = dVar;
    }
}
