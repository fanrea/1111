package com.baidu.mobstat.forbes;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class BaiduStatJSInterface {

    public interface IWebviewPageLoadCallback {
        void onPageFinished(WebView webView, String str, ag agVar);

        void onPageStarted(WebView webView, String str, ag agVar);
    }

    public static class CustomWebViewClient extends WebViewClient {
        private WeakReference<Context> a;
        private WebViewClient b;
        private IWebviewPageLoadCallback c;
        private ag d;

        public CustomWebViewClient(Context context, WebViewClient webViewClient, IWebviewPageLoadCallback iWebviewPageLoadCallback, ag agVar) {
            this.a = new WeakReference<>(context);
            this.b = webViewClient;
            this.c = iWebviewPageLoadCallback;
            this.d = agVar;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) throws ClassNotFoundException, UnsupportedEncodingException {
            try {
                str = URLDecoder.decode(str, "UTF-8");
                if (!TextUtils.isEmpty(str) && str.startsWith("bmtj:")) {
                    a(str.substring(5));
                    return true;
                }
            } catch (UnsupportedEncodingException e) {
            } catch (JSONException e2) {
            }
            if (this.b != null) {
                return this.b.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (this.b != null) {
                return this.b.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        private void a(String str) throws JSONException, ClassNotFoundException {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("action");
            JSONObject jSONObject2 = jSONObject.getJSONObject("obj");
            Context context = this.a.get();
            if (context == null) {
                return;
            }
            if ("onPageStart".equals(string)) {
                String string2 = jSONObject2.getString("page");
                if (TextUtils.isEmpty(string2)) {
                    return;
                }
                BDStatCore.instance().onPageStart(context, string2);
                return;
            }
            JSONObject jSONObject3 = null;
            if ("onPageEnd".equals(string)) {
                String string3 = jSONObject2.getString("page");
                if (TextUtils.isEmpty(string3)) {
                    return;
                }
                BDStatCore.instance().onPageEnd(context, string3, null, true);
                return;
            }
            if ("onEvent".equals(string)) {
                String string4 = jSONObject2.getString("event_id");
                String string5 = jSONObject2.getString("label");
                int i = jSONObject2.getInt("acc");
                if (TextUtils.isEmpty(string4)) {
                    return;
                }
                try {
                    jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                } catch (Exception e) {
                }
                BDStatCore.instance().onEvent(context, string4, string5, i, (ExtraInfo) null, (Map<String, String>) a(jSONObject3), false, true);
                return;
            }
            if ("onEventStart".equals(string)) {
                String string6 = jSONObject2.getString("event_id");
                String string7 = jSONObject2.getString("label");
                if (TextUtils.isEmpty(string6)) {
                    return;
                }
                BDStatCore.instance().onEventStart(context, string6, string7, false);
                return;
            }
            if ("onEventEnd".equals(string)) {
                String string8 = jSONObject2.getString("event_id");
                String string9 = jSONObject2.getString("label");
                if (TextUtils.isEmpty(string8)) {
                    return;
                }
                try {
                    jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                } catch (Exception e2) {
                }
                BDStatCore.instance().onEventEnd(context, string8, string9, null, a(jSONObject3), true);
                return;
            }
            if ("onEventDuration".equals(string)) {
                String string10 = jSONObject2.getString("event_id");
                String string11 = jSONObject2.getString("label");
                long j = jSONObject2.getLong("duration");
                if (TextUtils.isEmpty(string10)) {
                    return;
                }
                try {
                    jSONObject3 = (JSONObject) jSONObject2.get("attributes");
                } catch (Exception e3) {
                }
                BDStatCore.instance().onEventDuration(context, string10, string11, j, null, a(jSONObject3), false, true);
            }
        }

        private HashMap<String, String> a(JSONObject jSONObject) throws JSONException {
            HashMap<String, String> map = null;
            if (jSONObject == null) {
                return null;
            }
            if (jSONObject.length() != 0) {
                map = new HashMap<>();
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    String next = itKeys.next();
                    String string = jSONObject.getString(next);
                    if (map != null) {
                        map.put(next, string);
                    }
                } catch (Exception e) {
                }
            }
            return map;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (this.b != null) {
                this.b.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (this.b != null) {
                this.b.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (this.b != null) {
                this.b.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        @Deprecated
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            if (this.b != null) {
                this.b.onTooManyRedirects(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            if (this.b != null) {
                this.b.onFormResubmission(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (this.b != null) {
                this.b.doUpdateVisitedHistory(webView, str, z);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (this.b != null) {
                this.b.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            if (this.b != null) {
                this.b.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (this.b != null) {
                return this.b.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (this.b != null) {
                this.b.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f, float f2) {
            if (this.b != null) {
                this.b.onScaleChanged(webView, f, f2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if (this.b != null) {
                this.b.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            if (this.b != null) {
                this.b.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (this.b != null) {
                return this.b.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (this.b != null) {
                return this.b.shouldInterceptRequest(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            if (this.b != null) {
                this.b.onPageCommitVisible(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (this.b != null) {
                this.b.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (this.b != null) {
                this.b.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (this.b != null) {
                this.b.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (this.b != null) {
                return this.b.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
    }

    public static class CustomWebChromeViewClient extends WebChromeClient {
        private WeakReference<Context> a;
        private WebChromeClient b;
        private ArrayList<IWebviewPageLoadCallback> c;
        private ag d;
        private int e = 0;

        public CustomWebChromeViewClient(Context context, WebChromeClient webChromeClient, ArrayList<IWebviewPageLoadCallback> arrayList, ag agVar) {
            this.a = new WeakReference<>(context);
            this.b = webChromeClient;
            this.c = arrayList;
            this.d = agVar;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (this.c != null) {
                if (this.e == 0) {
                    Iterator<IWebviewPageLoadCallback> it = this.c.iterator();
                    while (it.hasNext()) {
                        IWebviewPageLoadCallback next = it.next();
                        if (next != null) {
                            next.onPageStarted(webView, webView.getUrl(), this.d);
                        }
                    }
                }
                this.e = i;
                if (i == 100) {
                    Iterator<IWebviewPageLoadCallback> it2 = this.c.iterator();
                    while (it2.hasNext()) {
                        IWebviewPageLoadCallback next2 = it2.next();
                        if (next2 != null) {
                            next2.onPageFinished(webView, webView.getUrl(), this.d);
                        }
                    }
                }
            }
            if (this.b != null) {
                this.b.onProgressChanged(webView, i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            if (this.b != null) {
                return this.b.onCreateWindow(webView, z, z2, message);
            }
            return super.onCreateWindow(webView, z, z2, message);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (this.b != null) {
                return this.b.onJsAlert(webView, str, str2, jsResult);
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (this.b != null) {
                return this.b.onConsoleMessage(consoleMessage);
            }
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onConsoleMessage(String str, int i, String str2) {
            if (this.b != null) {
                this.b.onConsoleMessage(str, i, str2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            if (this.b != null) {
                this.b.onCloseWindow(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            if (this.b != null) {
                this.b.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            if (this.b != null) {
                this.b.onGeolocationPermissionsHidePrompt();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (this.b != null) {
                this.b.onGeolocationPermissionsShowPrompt(str, callback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (this.b != null) {
                this.b.onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            if (this.b != null) {
                return this.b.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return super.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            if (this.b != null) {
                return this.b.onJsConfirm(webView, str, str2, jsResult);
            }
            return super.onJsConfirm(webView, str, str2, jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (this.b != null) {
                return this.b.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public boolean onJsTimeout() {
            if (this.b != null) {
                return this.b.onJsTimeout();
            }
            return super.onJsTimeout();
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (this.b != null) {
                this.b.onPermissionRequest(permissionRequest);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
            if (this.b != null) {
                this.b.onPermissionRequestCanceled(permissionRequest);
            }
        }

        @Deprecated
        public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            if (this.b != null) {
                this.b.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            if (this.b != null) {
                this.b.onReceivedIcon(webView, bitmap);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (this.b != null) {
                this.b.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            if (this.b != null) {
                this.b.onReceivedTouchIconUrl(webView, str, z);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView webView) {
            if (this.b != null) {
                this.b.onRequestFocus(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (this.b != null) {
                this.b.onShowCustomView(view, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        @Deprecated
        public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            if (this.b != null) {
                this.b.onShowCustomView(view, i, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (this.b != null) {
                return this.b.onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }
    }
}
