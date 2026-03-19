package com.bytedance.common.util;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LollipopV21Compat {
    private static BaseImpl mImpl;

    private static class BaseImpl {
        public void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        }

        public void setMixedContentMode(WebSettings webSettings, int i) {
        }

        private BaseImpl() {
        }
    }

    private static class LollipopImpl extends BaseImpl {
        private LollipopImpl() {
            super();
        }

        @Override // com.bytedance.common.util.LollipopV21Compat.BaseImpl
        public void setMixedContentMode(WebSettings webSettings, int i) {
            if (webSettings != null) {
                try {
                    webSettings.setMixedContentMode(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.bytedance.common.util.LollipopV21Compat.BaseImpl
        public void setAcceptThirdPartyCookies(WebView webView, boolean z) {
            if (webView != null) {
                try {
                    CookieManager.getInstance().setAcceptThirdPartyCookies(webView, z);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            mImpl = new LollipopImpl();
        } else {
            mImpl = new BaseImpl();
        }
    }

    public static void setMixedContentMode(WebSettings webSettings, int i) {
        mImpl.setMixedContentMode(webSettings, i);
    }

    public static void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        mImpl.setAcceptThirdPartyCookies(webView, z);
    }
}
