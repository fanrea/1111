package com.bytedance.common.util;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class HoneyCombV11Compat {
    static Method sMethodWebViewOnPause = null;
    static Method sMethodWebViewOnResume = null;
    static boolean sWebViewPauseResumeGot = false;

    static class HoneyCombImpl {
        HoneyCombImpl() {
        }

        public static Context getContext(AlertDialog.Builder builder) {
            return builder.getContext();
        }

        public static int getLargeMemoryClass(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }

        public static void setDisplayZoomControl(WebSettings webSettings, boolean z) {
            webSettings.setDisplayZoomControls(z);
        }

        public static void pauseWebView(WebView webView) {
            webView.onPause();
        }

        public static void resumeWebView(WebView webView) {
            webView.onResume();
        }
    }

    public static Context getContext(Context context, AlertDialog.Builder builder) {
        return Build.VERSION.SDK_INT >= 11 ? HoneyCombImpl.getContext(builder) : context;
    }

    public static void setDisplayZoomControl(WebSettings webSettings, boolean z) {
        if (Build.VERSION.SDK_INT >= 11) {
            HoneyCombImpl.setDisplayZoomControl(webSettings, z);
        }
    }

    public static void pauseWebView(WebView webView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (webView == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            HoneyCombImpl.pauseWebView(webView);
            return;
        }
        tryGetWebViewPauseResumeMethod();
        Method method = sMethodWebViewOnPause;
        if (method != null) {
            try {
                method.invoke(webView, null);
            } catch (Exception unused) {
            }
        }
    }

    public static void resumeWebView(WebView webView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (webView == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            HoneyCombImpl.resumeWebView(webView);
            return;
        }
        tryGetWebViewPauseResumeMethod();
        Method method = sMethodWebViewOnResume;
        if (method != null) {
            try {
                method.invoke(webView, null);
            } catch (Exception unused) {
            }
        }
    }

    private static void tryGetWebViewPauseResumeMethod() {
        if (sWebViewPauseResumeGot) {
            return;
        }
        sWebViewPauseResumeGot = true;
        try {
            sMethodWebViewOnPause = WebView.class.getMethod("onPause", null);
            sMethodWebViewOnResume = WebView.class.getMethod("onResume", null);
        } catch (Exception unused) {
        }
    }

    public static int getLargeMemoryClass(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                return HoneyCombImpl.getLargeMemoryClass(activityManager);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }
}
