package com.qq.e.comm.plugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class nh extends WebChromeClient {
    private bm a;
    private sh b;

    nh() {
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        sh shVar = this.b;
        if (shVar != null) {
            shVar.a(i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        sh shVar = this.b;
        if (shVar != null) {
            shVar.b(str);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        openFileChooser(valueCallback, str, null);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        sh shVar = this.b;
        if (shVar == null || Build.VERSION.SDK_INT < 21 || fileChooserParams == null) {
            return false;
        }
        return shVar.a(valueCallback, fileChooserParams.createIntent());
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        bm bmVar = this.a;
        if (bmVar == null) {
            b10.b(100292, null, 1, new ja().a("msg", str2));
            return true;
        }
        ih<String> ihVarA = bmVar.a(str2);
        if (ihVarA.d()) {
            jsPromptResult.confirm(ihVarA.b());
            return true;
        }
        if (ihVarA.a() == 1000) {
            jsPromptResult.confirm("message:" + ihVarA.c() + ",code:" + ihVarA.a());
            String.format("failed message: %s --> (%d,%s)", str2, Integer.valueOf(ihVarA.a()), ihVarA.c());
            return true;
        }
        jsPromptResult.confirm("message:" + ihVarA.c() + ",code:" + ihVarA.a());
        String.format("failed message: %s --> (%d,%s)", str2, Integer.valueOf(ihVarA.a()), ihVarA.c());
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        callback.invoke(str, true, false);
    }

    public void a(bm bmVar) {
        this.a = bmVar;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        if (this.b == null) {
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
        } else {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (TextUtils.isEmpty(str)) {
                str = "*/*";
            }
            intent.setType(str);
            this.b.b(valueCallback, intent);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }

    public void a(sh shVar) {
        this.b = shVar;
    }
}
