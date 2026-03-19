package com.qq.e.comm.plugin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface sh {

    /* compiled from: A */
    public interface a extends sh {
        void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

        void a(String str);
    }

    void a(int i);

    void a(int i, String str, String str2);

    void a(String str, Bitmap bitmap);

    boolean a(ValueCallback<Uri[]> valueCallback, Intent intent);

    void b(ValueCallback<Uri> valueCallback, Intent intent);

    void b(String str);

    void c();

    void c(String str);

    void d(String str);
}
