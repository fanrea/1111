package lkxssdk.i;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.lingku.xuanshang.core.ui.webview.WebViewWrapper;
import com.luck.picture.lib.config.SelectMimeType;
import java.util.Locale;
import lkxssdk.l.g;
import lkxssdk.l.v;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class e extends WebChromeClient {
    public final /* synthetic */ WebViewWrapper a;

    public class a implements g.b {
        public final /* synthetic */ GeolocationPermissions.Callback a;
        public final /* synthetic */ String b;

        public a(e eVar, GeolocationPermissions.Callback callback, String str) {
            this.a = callback;
            this.b = str;
        }

        public void a(int i) {
            lkxssdk.h0.c.b("tag", "onGeolocationPermissionsShowPrompt type:" + i);
            this.a.invoke(this.b, false, false);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a.b.setVisibility(8);
        }
    }

    public e(WebViewWrapper webViewWrapper) {
        this.a = webViewWrapper;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        lkxssdk.h0.c.b("onConsoleMessage:" + consoleMessage.message());
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        lkxssdk.h0.c.b("tag", "onGeolocationPermissionsShowPrompt location:" + str);
        WebViewWrapper webViewWrapper = this.a;
        if (webViewWrapper.q == null) {
            webViewWrapper.q = new g();
        }
        g gVar = webViewWrapper.q;
        BaseActivity baseActivity = webViewWrapper.a;
        a aVar = new a(this, callback, str);
        gVar.a = baseActivity;
        gVar.b = aVar;
        if (!(gVar.b() && lkxssdk.j0.d.a(lkxssdk.a.a.d(), "android.permission.ACCESS_FINE_LOCATION"))) {
            gVar.a();
        } else {
            lkxssdk.h0.c.b("tag", "onGeolocationPermissionsShowPrompt 1");
            callback.invoke(str, true, false);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        lkxssdk.h0.c.a("web progress==" + i);
        WebViewWrapper webViewWrapper = this.a;
        if (webViewWrapper.p) {
            if (webViewWrapper.b.getVisibility() != 0) {
                webViewWrapper.b.setVisibility(0);
            }
            ViewGroup.LayoutParams layoutParams = webViewWrapper.b.getLayoutParams();
            layoutParams.width = (int) (((webViewWrapper.i * i) * 1.0d) / 100.0d);
            webViewWrapper.b.setLayoutParams(layoutParams);
            if (i > 60) {
                this.a.p = false;
                this.a.d.postDelayed(new b(), 300L);
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        lkxssdk.j.c cVar = this.a.j;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
        lkxssdk.h0.c.b("web onShowCustomView");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        WebViewWrapper webViewWrapper = this.a;
        if (webViewWrapper.l == null) {
            webViewWrapper.l = new v(webViewWrapper.a);
        }
        StringBuilder sb = new StringBuilder();
        int length = fileChooserParams.getAcceptTypes().length;
        for (int i = 0; i < length; i++) {
            sb.append(fileChooserParams.getAcceptTypes()[i]).append(",");
        }
        lkxssdk.h0.c.b("acceptType:" + ((Object) sb));
        v vVar = this.a.l;
        String string = sb.toString();
        vVar.c = valueCallback;
        vVar.b = null;
        if (string.toLowerCase(Locale.getDefault()).contains("video")) {
            try {
                Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, SelectMimeType.SYSTEM_VIDEO);
                vVar.a.startActivityForResult(Intent.createChooser(intent, "选择视频"), 10000);
                vVar.d = true;
            } catch (ActivityNotFoundException unused) {
                lkxssdk.m0.b.a().a("很抱歉，无法选择视频", 0);
                vVar.a();
            }
        } else {
            try {
                Intent intent2 = new Intent("android.intent.action.PICK", (Uri) null);
                intent2.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, SelectMimeType.SYSTEM_IMAGE);
                vVar.a.startActivityForResult(Intent.createChooser(intent2, "选择图片"), 10000);
                vVar.d = true;
            } catch (ActivityNotFoundException unused2) {
                lkxssdk.m0.b.a().a("很抱歉，无法打开相册", 0);
                vVar.a();
            }
        }
        return true;
    }
}
