package com.just.agentweb;

import android.app.Activity;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AgentWebUIControllerImplBase extends AbsAgentWebUIController {
    public static AbsAgentWebUIController build() {
        return new AgentWebUIControllerImplBase();
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    protected void bindSupportWebParent(WebParentLayout webParentLayout, Activity activity) {
        getDelegate().bindSupportWebParent(webParentLayout, activity);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onCancelLoading() {
        getDelegate().onCancelLoading();
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onForceDownloadAlert(String str, Handler.Callback callback) {
        getDelegate().onForceDownloadAlert(str, callback);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsAlert(WebView webView, String str, String str2) {
        getDelegate().onJsAlert(webView, str, str2);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        getDelegate().onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        getDelegate().onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onLoading(String str) {
        getDelegate().onLoading(str);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onMainFrameError(WebView webView, int i, String str, String str2) {
        getDelegate().onMainFrameError(webView, i, str, str2);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onOpenPagePrompt(WebView webView, String str, Handler.Callback callback) {
        getDelegate().onOpenPagePrompt(webView, str, callback);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        getDelegate().onPermissionRequest(permissionRequest);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onPermissionsDeny(String[] strArr, String str, String str2) {
        getDelegate().onPermissionsDeny(strArr, str, str2);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onSelectItemsPrompt(WebView webView, String str, String[] strArr, Handler.Callback callback) {
        getDelegate().onSelectItemsPrompt(webView, str, strArr, callback);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowMainFrame() {
        getDelegate().onShowMainFrame();
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowMessage(String str, String str2) {
        getDelegate().onShowMessage(str, str2);
    }

    @Override // com.just.agentweb.AbsAgentWebUIController
    public void onShowSslCertificateErrorDialog(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        getDelegate().onShowSslCertificateErrorDialog(webView, sslErrorHandler, sslError);
    }
}
