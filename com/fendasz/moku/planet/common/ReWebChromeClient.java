package com.fendasz.moku.planet.common;

import android.net.Uri;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ReWebChromeClient extends WebChromeClient {
    private OpenFileChooserCallBack mOpenFileChooserCallBack;

    public interface OpenFileChooserCallBack {
        void openFileChooserCallBack(ValueCallback<Uri> valueCallback, String str);

        boolean openFileChooserCallBackAndroid5(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams);
    }

    public ReWebChromeClient(OpenFileChooserCallBack openFileChooserCallBack) {
        this.mOpenFileChooserCallBack = openFileChooserCallBack;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        this.mOpenFileChooserCallBack.openFileChooserCallBack(valueCallback, str);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        this.mOpenFileChooserCallBack.openFileChooserCallBack(valueCallback, "");
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.mOpenFileChooserCallBack.openFileChooserCallBack(valueCallback, str);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        fileChooserParams.getAcceptTypes();
        return this.mOpenFileChooserCallBack.openFileChooserCallBackAndroid5(webView, valueCallback, fileChooserParams);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.cancel();
        return true;
    }
}
