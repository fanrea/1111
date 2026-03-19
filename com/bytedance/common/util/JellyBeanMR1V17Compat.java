package com.bytedance.common.util;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class JellyBeanMR1V17Compat {
    private static final long TIME_CONST = 1000000;
    static final boolean USE_REAL_LOC_TIME = false;
    private static BaseImpl mImpl;

    private static class BaseImpl {
        public String getWebViewDefaultUserAgent(Context context) {
            return null;
        }

        public void setMediaPlaybackRequiresUserGesture(WebSettings webSettings, boolean z) {
        }

        private BaseImpl() {
        }

        public long getTime(Location location) {
            return location.getTime();
        }

        public float getWebViewScale(WebView webView) {
            if (webView == null) {
                return 1.0f;
            }
            try {
                return webView.getScale();
            } catch (Exception e) {
                e.printStackTrace();
                return 1.0f;
            }
        }
    }

    private static class V17Impl extends BaseImpl {
        private V17Impl() {
            super();
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V17Compat.BaseImpl
        public long getTime(Location location) {
            return location.getTime();
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V17Compat.BaseImpl
        public void setMediaPlaybackRequiresUserGesture(WebSettings webSettings, boolean z) {
            try {
                webSettings.setMediaPlaybackRequiresUserGesture(z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V17Compat.BaseImpl
        public float getWebViewScale(WebView webView) {
            if (webView == null) {
                return 1.0f;
            }
            try {
                return webView.getScale();
            } catch (Exception e) {
                e.printStackTrace();
                return 1.0f;
            }
        }

        @Override // com.bytedance.common.util.JellyBeanMR1V17Compat.BaseImpl
        public String getWebViewDefaultUserAgent(Context context) {
            try {
                return WebSettings.getDefaultUserAgent(context);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            mImpl = new V17Impl();
        } else {
            mImpl = new BaseImpl();
        }
    }

    public static long getTime(Location location) {
        return mImpl.getTime(location);
    }

    public static void setMediaPlaybackRequiresUserGesture(WebSettings webSettings, boolean z) {
        mImpl.setMediaPlaybackRequiresUserGesture(webSettings, z);
    }

    public static float getWebViewScale(WebView webView) {
        return mImpl.getWebViewScale(webView);
    }

    public static String getWebViewDefaultUserAgent(Context context) {
        return mImpl.getWebViewDefaultUserAgent(context);
    }
}
