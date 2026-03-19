package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.os.Looper;
import android.webkit.WebView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk {
    private static final d d;

    private static class d {
        private d() {
        }

        public void d(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            mk.hc(new Runnable() { // from class: com.bytedance.sdk.component.utils.mk.d.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private static class hc extends d {
        private hc() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.mk.d
        public void d(final WebView webView, final String str) {
            if (webView == null) {
                return;
            }
            mk.hc(new Runnable() { // from class: com.bytedance.sdk.component.utils.mk.hc.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2 = str;
                    boolean z = false;
                    if (str2 != null && str2.startsWith("javascript:")) {
                        try {
                            webView.evaluateJavascript(str, null);
                            z = true;
                        } catch (Throwable th) {
                            boolean z2 = th instanceof IllegalStateException;
                        }
                    }
                    if (z) {
                        return;
                    }
                    try {
                        webView.loadUrl(str);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            d = new hc();
        } else {
            d = new d();
        }
    }

    @Deprecated
    public static void d(WebView webView, String str) {
        d.d(webView, str);
    }

    public static void d(com.bytedance.sdk.component.uo.b bVar, String str) {
        d.d(bVar.getWebView(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            gb.hc().post(runnable);
        }
    }
}
