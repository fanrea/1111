package com.lingku.xuanshang.core.ui.webview.dsbridge;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DWebView extends WebView {
    public static boolean a = false;
    public Map<String, Object> b;
    public String c;
    public int d;
    public WebChromeClient e;
    public volatile boolean f;
    public g g;
    public ArrayList<e> h;
    public InnerJavascriptInterface i;
    public Handler j;
    public Map<Integer, lkxssdk.k.b> k;
    public WebChromeClient l;

    public class InnerJavascriptInterface {

        public class a implements lkxssdk.k.a {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // lkxssdk.k.a
            public void a(Object obj) throws JSONException {
                a(obj, false);
            }

            public final void a(Object obj, boolean z) throws JSONException {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", 0);
                    jSONObject.put("data", obj);
                    String str = this.a;
                    if (str != null) {
                        String str2 = String.format("%s(%s.data);", str, jSONObject.toString());
                        if (z) {
                            str2 = str2 + "delete window." + this.a;
                        }
                        lkxssdk.h0.c.b(str2);
                        DWebView.this.a(str2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // lkxssdk.k.a
            public void b(Object obj) throws JSONException {
                a(obj, true);
            }
        }

        public InnerJavascriptInterface() {
        }

        public final void a(String str) {
            Log.d("dsBridge", str);
            if (DWebView.a) {
                DWebView.this.a(String.format("alert('%s')", "DEBUG ERR MSG:\\n" + str.replaceAll("\\'", "\\\\'")));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String call(java.lang.String r13, java.lang.String r14) throws org.json.JSONException, java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            /*
                Method dump skipped, instructions count: 285
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView.InnerJavascriptInterface.call(java.lang.String, java.lang.String):java.lang.String");
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.c(DWebView.this, this.a);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.this.h = new ArrayList<>();
            DWebView.super.loadUrl(this.a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Map b;

        public c(String str, Map map) {
            this.a = str;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.this.h = new ArrayList<>();
            DWebView.super.loadUrl(this.a, this.b);
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DWebView.this.h = new ArrayList<>();
            DWebView.super.reload();
        }
    }

    public class e {
        public String a;
        public int b;
        public String c;

        public e(DWebView dWebView, String str, int i, Object[] objArr) {
            this.a = null;
            this.a = new JSONArray((Collection) Arrays.asList(objArr == null ? new Object[0] : objArr)).toString();
            this.b = i;
            this.c = str;
        }

        public String toString() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.alipay.sdk.m.p.e.s, this.c);
                jSONObject.put("callbackId", this.b);
                jSONObject.put("data", this.a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    @Deprecated
    public interface f {
        void a(ValueCallback valueCallback, String str);
    }

    public interface g {
        boolean onClose();
    }

    public DWebView(Context context) {
        super(context);
        this.b = new HashMap();
        this.d = 0;
        this.f = true;
        this.g = null;
        this.i = new InnerJavascriptInterface();
        this.j = new Handler(Looper.getMainLooper());
        this.k = new HashMap();
        this.l = new WebChromeClient() { // from class: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView.6

            /* renamed from: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView$6$a */
            public class a implements DialogInterface.OnClickListener {
                public final /* synthetic */ JsResult a;

                public a(JsResult jsResult) {
                    this.a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (DWebView.this.f) {
                        this.a.confirm();
                    }
                }
            }

            /* renamed from: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView$6$b */
            public class b implements DialogInterface.OnClickListener {
                public final /* synthetic */ JsResult a;

                public b(JsResult jsResult) {
                    this.a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (DWebView.this.f) {
                        if (i == -1) {
                            this.a.confirm();
                        } else {
                            this.a.cancel();
                        }
                    }
                }
            }

            /* renamed from: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView$6$c */
            public class c implements DialogInterface.OnClickListener {
                public final /* synthetic */ JsPromptResult a;
                public final /* synthetic */ EditText b;

                public c(JsPromptResult jsPromptResult, EditText editText) {
                    this.a = jsPromptResult;
                    this.b = editText;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (DWebView.this.f) {
                        if (i == -1) {
                            this.a.confirm(this.b.getText().toString());
                        } else {
                            this.a.cancel();
                        }
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.getDefaultVideoPoster() : super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.getVisitedHistory(valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView webView) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onCloseWindow(webView);
                } else {
                    super.onCloseWindow(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.f) {
                    jsResult.confirm();
                }
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null && webChromeClient.onJsAlert(webView, str, str2, jsResult)) {
                    return true;
                }
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, new a(jsResult)).create().show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.f) {
                    jsResult.confirm();
                }
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null && webChromeClient.onJsConfirm(webView, str, str2, jsResult)) {
                    return true;
                }
                b bVar = new b(jsResult);
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, bVar).setNegativeButton(R.string.cancel, bVar).show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                if (Build.VERSION.SDK_INT <= 16 && str2.startsWith("_dsbridge=")) {
                    jsPromptResult.confirm(DWebView.this.i.call(str2.substring(10), str3));
                    return true;
                }
                if (!DWebView.this.f) {
                    jsPromptResult.confirm();
                }
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null && webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                    return true;
                }
                EditText editText = new EditText(DWebView.this.getContext());
                editText.setText(str3);
                if (str3 != null) {
                    editText.setSelection(str3.length());
                }
                float f2 = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                c cVar = new c(jsPromptResult, editText);
                new AlertDialog.Builder(DWebView.this.getContext()).setTitle(str2).setView(editText).setCancelable(false).setPositiveButton(R.string.ok, cVar).setNegativeButton(R.string.cancel, cVar).show();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i = (int) (16.0f * f2);
                layoutParams.setMargins(i, 0, i, 0);
                layoutParams.gravity = 1;
                editText.setLayoutParams(layoutParams);
                int i2 = (int) (15.0f * f2);
                editText.setPadding(i2 - ((int) (f2 * 5.0f)), i2, i2, i2);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.onJsTimeout() : super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onProgressChanged(webView, i);
                } else {
                    super.onProgressChanged(webView, i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onReceivedIcon(webView, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onReceivedTitle(webView, str);
                } else {
                    super.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onReceivedTouchIconUrl(webView, str, z);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView webView) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onRequestFocus(webView);
                } else {
                    super.onRequestFocus(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onShowCustomView(view, i, customViewCallback);
                } else {
                    super.onShowCustomView(view, i, customViewCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }

            public void openFileChooser(ValueCallback valueCallback, String str) {
                Object obj = DWebView.this.e;
                if (obj instanceof f) {
                    ((f) obj).a(valueCallback, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onShowCustomView(view, customViewCallback);
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }
        };
        init();
    }

    public DWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new HashMap();
        this.d = 0;
        this.f = true;
        this.g = null;
        this.i = new InnerJavascriptInterface();
        this.j = new Handler(Looper.getMainLooper());
        this.k = new HashMap();
        this.l = new WebChromeClient() { // from class: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView.6

            /* renamed from: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView$6$a */
            public class a implements DialogInterface.OnClickListener {
                public final /* synthetic */ JsResult a;

                public a(JsResult jsResult) {
                    this.a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if (DWebView.this.f) {
                        this.a.confirm();
                    }
                }
            }

            /* renamed from: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView$6$b */
            public class b implements DialogInterface.OnClickListener {
                public final /* synthetic */ JsResult a;

                public b(JsResult jsResult) {
                    this.a = jsResult;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (DWebView.this.f) {
                        if (i == -1) {
                            this.a.confirm();
                        } else {
                            this.a.cancel();
                        }
                    }
                }
            }

            /* renamed from: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView$6$c */
            public class c implements DialogInterface.OnClickListener {
                public final /* synthetic */ JsPromptResult a;
                public final /* synthetic */ EditText b;

                public c(JsPromptResult jsPromptResult, EditText editText) {
                    this.a = jsPromptResult;
                    this.b = editText;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (DWebView.this.f) {
                        if (i == -1) {
                            this.a.confirm(this.b.getText().toString());
                        } else {
                            this.a.cancel();
                        }
                    }
                }
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.getDefaultVideoPoster() : super.getDefaultVideoPoster();
            }

            @Override // android.webkit.WebChromeClient
            public View getVideoLoadingProgressView() {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
            }

            @Override // android.webkit.WebChromeClient
            public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.getVisitedHistory(valueCallback);
                } else {
                    super.getVisitedHistory(valueCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onCloseWindow(WebView webView) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onCloseWindow(webView);
                } else {
                    super.onCloseWindow(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsHidePrompt() {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onGeolocationPermissionsShowPrompt(str, callback);
                } else {
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.f) {
                    jsResult.confirm();
                }
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null && webChromeClient.onJsAlert(webView, str, str2, jsResult)) {
                    return true;
                }
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, new a(jsResult)).create().show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                if (!DWebView.this.f) {
                    jsResult.confirm();
                }
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null && webChromeClient.onJsConfirm(webView, str, str2, jsResult)) {
                    return true;
                }
                b bVar = new b(jsResult);
                new AlertDialog.Builder(DWebView.this.getContext()).setMessage(str2).setCancelable(false).setPositiveButton(R.string.ok, bVar).setNegativeButton(R.string.cancel, bVar).show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                if (Build.VERSION.SDK_INT <= 16 && str2.startsWith("_dsbridge=")) {
                    jsPromptResult.confirm(DWebView.this.i.call(str2.substring(10), str3));
                    return true;
                }
                if (!DWebView.this.f) {
                    jsPromptResult.confirm();
                }
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null && webChromeClient.onJsPrompt(webView, str, str2, str3, jsPromptResult)) {
                    return true;
                }
                EditText editText = new EditText(DWebView.this.getContext());
                editText.setText(str3);
                if (str3 != null) {
                    editText.setSelection(str3.length());
                }
                float f2 = DWebView.this.getContext().getResources().getDisplayMetrics().density;
                c cVar = new c(jsPromptResult, editText);
                new AlertDialog.Builder(DWebView.this.getContext()).setTitle(str2).setView(editText).setCancelable(false).setPositiveButton(R.string.ok, cVar).setNegativeButton(R.string.cancel, cVar).show();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                int i = (int) (16.0f * f2);
                layoutParams.setMargins(i, 0, i, 0);
                layoutParams.gravity = 1;
                editText.setLayoutParams(layoutParams);
                int i2 = (int) (15.0f * f2);
                editText.setPadding(i2 - ((int) (f2 * 5.0f)), i2, i2, i2);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsTimeout() {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.onJsTimeout() : super.onJsTimeout();
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onProgressChanged(webView, i);
                } else {
                    super.onProgressChanged(webView, i);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedIcon(WebView webView, Bitmap bitmap) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onReceivedIcon(webView, bitmap);
                } else {
                    super.onReceivedIcon(webView, bitmap);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onReceivedTitle(webView, str);
                } else {
                    super.onReceivedTitle(webView, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onReceivedTouchIconUrl(webView, str, z);
                } else {
                    super.onReceivedTouchIconUrl(webView, str, z);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onRequestFocus(WebView webView) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onRequestFocus(webView);
                } else {
                    super.onRequestFocus(webView);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onShowCustomView(view, i, customViewCallback);
                } else {
                    super.onShowCustomView(view, i, customViewCallback);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                WebChromeClient webChromeClient = DWebView.this.e;
                return webChromeClient != null ? webChromeClient.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }

            public void openFileChooser(ValueCallback valueCallback, String str) {
                Object obj = DWebView.this.e;
                if (obj instanceof f) {
                    ((f) obj).a(valueCallback, str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                WebChromeClient webChromeClient = DWebView.this.e;
                if (webChromeClient != null) {
                    webChromeClient.onShowCustomView(view, customViewCallback);
                } else {
                    super.onShowCustomView(view, customViewCallback);
                }
            }
        };
        init();
    }

    public static String[] a(DWebView dWebView, String str) {
        String strSubstring;
        dWebView.getClass();
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = str.substring(0, iLastIndexOf);
            str = str.substring(iLastIndexOf + 1);
        } else {
            strSubstring = "";
        }
        return new String[]{strSubstring, str};
    }

    private void addInternalJavascriptObject() {
        this.b.put("_dsb", new Object() { // from class: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView.1

            /* renamed from: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView$1$a */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    g gVar = DWebView.this.g;
                    if ((gVar == null || gVar.onClose()) && (DWebView.this.getContext() instanceof Activity)) {
                        ((Activity) DWebView.this.getContext()).onBackPressed();
                    }
                }
            }

            /* renamed from: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView$1$b */
            public class b implements Runnable {
                public final /* synthetic */ Object a;

                public b(Object obj) {
                    this.a = obj;
                }

                @Override // java.lang.Runnable
                public void run() throws JSONException {
                    JSONObject jSONObject = (JSONObject) this.a;
                    try {
                        int i = jSONObject.getInt("id");
                        boolean z = jSONObject.getBoolean("complete");
                        lkxssdk.k.b bVar = DWebView.this.k.get(Integer.valueOf(i));
                        Object obj = jSONObject.has("data") ? jSONObject.get("data") : null;
                        if (bVar != null) {
                            bVar.a(obj);
                            if (z) {
                                DWebView.this.k.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @JavascriptInterface
            public String closePage(Object obj) {
                DWebView dWebView = DWebView.this;
                a aVar = new a();
                boolean z = DWebView.a;
                dWebView.a(aVar);
                return null;
            }

            @JavascriptInterface
            public void disableJavascriptDialogBlock(Object obj) {
                DWebView.this.f = !((JSONObject) obj).getBoolean("disable");
            }

            @JavascriptInterface
            public void dsinit(Object obj) {
                DWebView dWebView = DWebView.this;
                boolean z = DWebView.a;
                synchronized (dWebView) {
                    ArrayList<e> arrayList = dWebView.h;
                    if (arrayList != null) {
                        Iterator<e> it = arrayList.iterator();
                        while (it.hasNext()) {
                            dWebView.a(String.format("window._handleMessageFromNative(%s)", it.next().toString()));
                        }
                        dWebView.h = null;
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:12:0x006e  */
            @android.webkit.JavascriptInterface
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean hasNativeMethod(java.lang.Object r9) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
                /*
                    r8 = this;
                    if (r9 == 0) goto L1c
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "Dwebview hasNativeMethod:"
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r1 = r9.toString()
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    lkxssdk.h0.c.b(r0)
                L1c:
                    org.json.JSONObject r9 = (org.json.JSONObject) r9
                    java.lang.String r0 = "name"
                    java.lang.String r0 = r9.getString(r0)
                    java.lang.String r0 = r0.trim()
                    java.lang.String r1 = "type"
                    java.lang.String r9 = r9.getString(r1)
                    java.lang.String r9 = r9.trim()
                    com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView r1 = com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView.this
                    java.lang.String[] r0 = com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView.a(r1, r0)
                    com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView r1 = com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r1.b
                    r2 = 0
                    r3 = r0[r2]
                    java.lang.Object r1 = r1.get(r3)
                    if (r1 == 0) goto L96
                    java.lang.Class r1 = r1.getClass()
                    r3 = 0
                    r4 = 1
                    r5 = r0[r4]     // Catch: java.lang.Exception -> L5f
                    r6 = 2
                    java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch: java.lang.Exception -> L5f
                    java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
                    r6[r2] = r7     // Catch: java.lang.Exception -> L5f
                    java.lang.Class<lkxssdk.k.a> r7 = lkxssdk.k.a.class
                    r6[r4] = r7     // Catch: java.lang.Exception -> L5f
                    java.lang.reflect.Method r3 = r1.getMethod(r5, r6)     // Catch: java.lang.Exception -> L5f
                    r0 = r4
                    goto L6c
                L5f:
                    r0 = r0[r4]     // Catch: java.lang.Exception -> L6b
                    java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L6b
                    java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
                    r5[r2] = r6     // Catch: java.lang.Exception -> L6b
                    java.lang.reflect.Method r3 = r1.getMethod(r0, r5)     // Catch: java.lang.Exception -> L6b
                L6b:
                    r0 = r2
                L6c:
                    if (r3 == 0) goto L96
                    java.lang.Class<android.webkit.JavascriptInterface> r1 = android.webkit.JavascriptInterface.class
                    java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
                    android.webkit.JavascriptInterface r1 = (android.webkit.JavascriptInterface) r1
                    if (r1 == 0) goto L96
                    java.lang.String r1 = "all"
                    boolean r1 = r1.equals(r9)
                    if (r1 != 0) goto L95
                    if (r0 == 0) goto L8a
                    java.lang.String r1 = "asyn"
                    boolean r1 = r1.equals(r9)
                    if (r1 != 0) goto L95
                L8a:
                    if (r0 != 0) goto L96
                    java.lang.String r0 = "syn"
                    boolean r9 = r0.equals(r9)
                    if (r9 == 0) goto L96
                L95:
                    return r4
                L96:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.lingku.xuanshang.core.ui.webview.dsbridge.DWebView.AnonymousClass1.hasNativeMethod(java.lang.Object):boolean");
            }

            @JavascriptInterface
            public void returnValue(Object obj) {
                DWebView dWebView = DWebView.this;
                b bVar = new b(obj);
                boolean z = DWebView.a;
                dWebView.a(bVar);
            }
        });
    }

    public static void c(DWebView dWebView, String str) {
        dWebView.getClass();
        if (Build.VERSION.SDK_INT >= 19) {
            super.evaluateJavascript(str, null);
        } else {
            super.loadUrl("javascript:" + str);
        }
    }

    private void init() {
        this.c = getContext().getFilesDir().getAbsolutePath() + "/webcache";
        WebSettings settings = getSettings();
        settings.setDomStorageEnabled(true);
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
            settings.setMixedContentMode(0);
        }
        settings.setAllowFileAccess(false);
        settings.setCacheMode(2);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        super.setWebChromeClient(this.l);
        addInternalJavascriptObject();
        if (i > 16) {
            super.addJavascriptInterface(this.i, "_dsbridge");
        } else {
            settings.setUserAgentString(settings.getUserAgentString() + " _dsbridge");
        }
    }

    public static void setWebContentsDebuggingEnabled(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(z);
        }
        a = z;
    }

    public void a(File file) {
        if (!file.exists()) {
            Log.e("Webview", "delete file no exists " + file.getAbsolutePath());
            return;
        }
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                a(file2);
            }
        }
        file.delete();
    }

    public final void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.j.post(runnable);
        }
    }

    public void a(String str) {
        a(new a(str));
    }

    @Override // android.webkit.WebView
    public void clearCache(boolean z) {
        super.clearCache(z);
        CookieManager.getInstance().removeAllCookie();
        Context context = getContext();
        try {
            context.deleteDatabase("webview.db");
            context.deleteDatabase("webviewCache.db");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        File file = new File(this.c);
        File file2 = new File(context.getCacheDir().getAbsolutePath() + "/webviewCache");
        if (file2.exists()) {
            a(file2);
        }
        if (file.exists()) {
            a(file);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        a(new b(str));
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        a(new c(str, map));
    }

    @Override // android.webkit.WebView
    public void reload() {
        a(new d());
    }

    public void setJavascriptCloseWindowListener(g gVar) {
        this.g = gVar;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.e = webChromeClient;
    }
}
