package com.lingku.xuanshang.core.ui.webview;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import lkxssdk.e.t;
import lkxssdk.i.a;
import lkxssdk.i.d;
import lkxssdk.i.f;
import lkxssdk.j.c;
import lkxssdk.l.g;
import lkxssdk.l.k;
import lkxssdk.l.m;
import lkxssdk.l.q;
import lkxssdk.l.v;
import lkxssdk.l0.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WebViewWrapper extends RelativeLayout implements a {
    public BaseActivity a;
    public ImageView b;
    public View c;
    public DWebView d;
    public WebLoadErrorView e;
    public boolean f;
    public boolean g;
    public lkxssdk.j.a h;
    public int i;
    public c j;
    public q k;
    public v l;
    public k m;
    public t n;
    public boolean o;
    public boolean p;
    public g q;

    public WebViewWrapper(Context context) {
        super(context);
        a(context);
    }

    public WebViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WebViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public static WebResourceResponse a(WebViewWrapper webViewWrapper, String str) {
        webViewWrapper.getClass();
        if (!TextUtils.isEmpty(str) && str.startsWith("xswafile://")) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension("mp4");
            String strReplace = str.replace("xswafile://", "");
            if (strReplace.contains("#")) {
                strReplace = strReplace.substring(0, strReplace.indexOf("#"));
            }
            lkxssdk.h0.c.b(strReplace);
            File file = new File(strReplace);
            if (file.exists()) {
                HashMap map = new HashMap();
                map.put("Access-Control-Allow-Origin", "*");
                map.put("Access-Control-Allow-Headers", "Content-Type");
                try {
                    return new WebResourceResponse(mimeTypeFromExtension, "", 200, "ok", map, new FileInputStream(file));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void a() {
        try {
            DWebView dWebView = this.d;
            if (dWebView != null) {
                dWebView.destroy();
            }
            if (this.k != null) {
                this.k = null;
            }
            if (this.m != null) {
                this.m = null;
            }
            if (this.l != null) {
                this.l = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(boolean z) {
        if (z) {
            this.p = true;
            this.c.setVisibility(0);
            this.b.setVisibility(0);
        }
        this.d.reload();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r8 = this;
            java.lang.String r0 = "onAtyRestart 0"
            lkxssdk.h0.c.b(r0)
            lkxssdk.l.g r0 = r8.q
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1a
            boolean r3 = r0.c
            if (r3 == 0) goto L16
            r0.c = r2
            r0.a()
            r0 = r1
            goto L17
        L16:
            r0 = r2
        L17:
            if (r0 == 0) goto L1a
            return
        L1a:
            java.lang.String r0 = "onAtyRestart 1"
            lkxssdk.h0.c.b(r0)
            lkxssdk.l.q r0 = r8.k
            if (r0 == 0) goto L57
            boolean r3 = r0.d
            if (r3 == 0) goto L2b
            r0.d = r2
        L29:
            r0 = r1
            goto L54
        L2b:
            boolean r3 = r0.c
            if (r3 == 0) goto L4c
            java.lang.String r3 = "android.permission.WRITE_EXTERNAL_STORAGE"
            r0.f = r3
            boolean r3 = lkxssdk.j0.d.a()
            if (r3 == 0) goto L40
            r3 = 1000(0x3e8, float:1.401E-42)
            java.lang.String r4 = "android.permission.MANAGE_EXTERNAL_STORAGE"
            r0.f = r4
            goto L41
        L40:
            r3 = r2
        L41:
            lkxssdk.l.j r4 = lkxssdk.l.j.a
            lkxssdk.l.p r5 = new lkxssdk.l.p
            r5.<init>(r0)
            long r6 = (long) r3
            r4.postDelayed(r5, r6)
        L4c:
            boolean r3 = r0.c
            if (r3 == 0) goto L53
            r0.c = r2
            goto L29
        L53:
            r0 = r2
        L54:
            if (r0 == 0) goto L57
            return
        L57:
            java.lang.String r0 = "onAtyRestart 3"
            lkxssdk.h0.c.b(r0)
            lkxssdk.l.k r0 = r8.m
            if (r0 == 0) goto L84
            boolean r3 = r0.d
            if (r3 == 0) goto L68
            r0.d = r2
        L66:
            r0 = r1
            goto L81
        L68:
            java.lang.String r3 = "reqPermission 1"
            lkxssdk.h0.c.b(r3)
            boolean r3 = r0.c
            if (r3 == 0) goto L79
            java.lang.String r3 = "reqPermission 2"
            lkxssdk.h0.c.b(r3)
            r0.a()
        L79:
            boolean r3 = r0.c
            if (r3 == 0) goto L80
            r0.c = r2
            goto L66
        L80:
            r0 = r2
        L81:
            if (r0 == 0) goto L84
            return
        L84:
            lkxssdk.e.t r0 = r8.n
            if (r0 == 0) goto L94
            boolean r3 = r0.c
            if (r3 == 0) goto L90
            r0.c = r2
            r0 = r1
            goto L91
        L90:
            r0 = r2
        L91:
            if (r0 == 0) goto L94
            return
        L94:
            lkxssdk.l.v r0 = r8.l
            if (r0 == 0) goto La3
            boolean r3 = r0.d
            if (r3 == 0) goto L9f
            r0.d = r2
            goto La0
        L9f:
            r1 = r2
        La0:
            if (r1 == 0) goto La3
            return
        La3:
            java.lang.String r0 = "onAtyRestart 10"
            lkxssdk.h0.c.b(r0)
            java.lang.String r0 = "wapAppResume"
            java.lang.String r1 = "{}"
            r8.a(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.core.ui.webview.WebViewWrapper.b():void");
    }

    public BaseActivity getAty() {
        return this.a;
    }

    public final void a(Context context) {
        this.o = true;
        this.i = context.getResources().getDisplayMetrics().widthPixels;
        e eVarA = e.a();
        View.inflate(context, eVarA.b.getResources().getIdentifier("lkxs_view_web", "layout", eVarA.c), this);
        e eVarA2 = e.a();
        ImageView imageView = (ImageView) findViewById(eVarA2.b.getResources().getIdentifier("imgProgress", "id", eVarA2.c));
        this.b = imageView;
        imageView.setVisibility(8);
        e eVarA3 = e.a();
        View viewFindViewById = findViewById(eVarA3.b.getResources().getIdentifier("whiteBgView", "id", eVarA3.c));
        this.c = viewFindViewById;
        viewFindViewById.setVisibility(4);
        e eVarA4 = e.a();
        DWebView dWebView = (DWebView) findViewById(eVarA4.b.getResources().getIdentifier("webView", "id", eVarA4.c));
        this.d = dWebView;
        dWebView.setBackgroundColor(-1);
        e eVarA5 = e.a();
        this.e = (WebLoadErrorView) findViewById(eVarA5.b.getResources().getIdentifier("noNetwork", "id", eVarA5.c));
        this.h = new lkxssdk.j.a(this);
        this.d.setVerticalScrollBarEnabled(false);
        this.d.setHorizontalScrollBarEnabled(false);
        DWebView.setWebContentsDebuggingEnabled(true);
        DWebView dWebView2 = this.d;
        lkxssdk.j.a aVar = this.h;
        dWebView2.getClass();
        if (aVar != null) {
            dWebView2.b.put("", aVar);
        }
        this.d.getSettings().setCacheMode(-1);
        this.d.getSettings().setDefaultTextEncodingName("UTF-8");
        this.d.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        this.d.getSettings().setUserAgentString(this.d.getSettings().getUserAgentString() + ";sdkInt " + Build.VERSION.SDK_INT + ";XSWAPP");
        lkxssdk.h0.c.a("UA:" + this.d.getSettings().getUserAgentString());
        this.d.setWebViewClient(new d(this));
        this.d.setWebChromeClient(new lkxssdk.i.e(this));
        this.d.setDownloadListener(new f(this));
        this.d.setOnLongClickListener(new lkxssdk.i.c(this));
        try {
            this.d.resumeTimers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(WebView.HitTestResult hitTestResult) {
        if (this.k == null) {
            this.k = new q(this.a);
        }
        q qVar = this.k;
        qVar.getClass();
        if (hitTestResult.getType() != 5) {
            return false;
        }
        qVar.a = hitTestResult.getExtra();
        qVar.e = null;
        lkxssdk.h.c cVar = new lkxssdk.h.c(qVar.b);
        cVar.a(2, new m(qVar, cVar));
        cVar.d("是否保存该图片到您的手机相册？");
        cVar.a("");
        cVar.b("否");
        cVar.c("是");
        cVar.b();
        return true;
    }

    public void a(String str, String str2) {
        lkxssdk.h0.c.b("call web handlerName:" + str + ",jsonData:" + str2);
        DWebView dWebView = this.d;
        Object[] objArr = {str2};
        synchronized (dWebView) {
            int i = dWebView.d;
            dWebView.d = i + 1;
            DWebView.e eVar = new DWebView.e(dWebView, str, i, objArr);
            ArrayList<DWebView.e> arrayList = dWebView.h;
            if (arrayList != null) {
                arrayList.add(eVar);
            } else {
                dWebView.a(String.format("window._handleMessageFromNative(%s)", eVar.toString()));
            }
        }
    }
}
