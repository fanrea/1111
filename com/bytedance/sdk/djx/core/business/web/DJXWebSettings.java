package com.bytedance.sdk.djx.core.business.web;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.UIUtil;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXWebSettings {
    private WeakReference<Context> mContextRef;
    private boolean mEnableJavascript = true;
    private boolean mSupportZoom = true;
    private boolean mSupportViewPort = true;
    private boolean mEnableDomStorage = true;
    private boolean mEnableFileAccess = false;
    private boolean mEnableNetworkImage = true;
    private boolean mEnableHardwareAcceleration = true;
    private boolean mEnableLongClick = false;

    public static DJXWebSettings with(Context context) {
        return new DJXWebSettings(context);
    }

    private DJXWebSettings(Context context) {
        this.mContextRef = new WeakReference<>(context);
    }

    public DJXWebSettings enableHardwareAcceleration(boolean z) {
        this.mEnableHardwareAcceleration = z;
        return this;
    }

    public DJXWebSettings setSupportZoom(boolean z) {
        this.mSupportZoom = z;
        return this;
    }

    public DJXWebSettings enableLongClick(boolean z) {
        this.mEnableLongClick = z;
        return this;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0085 -> B:50:0x0088). Please report as a decompilation issue!!! */
    public void apply(WebView webView) {
        injectUserAgent(webView);
        if (webView == null || this.mContextRef.get() == null) {
            return;
        }
        removeJavascriptInterfacesSafe(webView);
        WebSettings settings = webView.getSettings();
        allowMediaPlayWithoutUserGesture(settings);
        if (settings == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
        } catch (Throwable unused) {
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Throwable unused2) {
        }
        try {
            if (this.mSupportZoom) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.mSupportViewPort);
        settings.setDomStorageEnabled(this.mEnableDomStorage);
        settings.setBlockNetworkImage(true ^ this.mEnableNetworkImage);
        settings.setAllowFileAccess(this.mEnableFileAccess);
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                settings.setAllowFileAccessFromFileURLs(this.mEnableFileAccess);
                settings.setAllowUniversalAccessFromFileURLs(this.mEnableFileAccess);
            }
        } catch (Throwable unused3) {
        }
        try {
            settings.setSavePassword(false);
        } catch (Throwable unused4) {
        }
        try {
            if (Build.VERSION.SDK_INT >= 11 && !this.mEnableHardwareAcceleration) {
                webView.setLayerType(0, null);
            } else if (Build.VERSION.SDK_INT >= 16 && this.mEnableHardwareAcceleration) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            if (this.mEnableLongClick) {
                return;
            }
            UIUtil.forbidWebViewLongClick(webView);
            UIUtil.forbidWebViewLongClick(webView);
        } catch (Throwable unused5) {
        }
    }

    private void injectUserAgent(WebView webView) {
        if (webView == null || webView.getSettings() == null) {
            return;
        }
        WebSettings settings = webView.getSettings();
        String userAgentString = settings.getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            userAgentString = "";
        }
        settings.setUserAgentString(userAgentString + " djxsdk/2.9.0.2");
    }

    private void removeJavascriptInterfacesSafe(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            LG.e(th.toString());
        }
    }

    private void allowMediaPlayWithoutUserGesture(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            LG.e(th.toString());
        }
    }
}
