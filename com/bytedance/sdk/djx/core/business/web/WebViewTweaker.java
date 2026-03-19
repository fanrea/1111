package com.bytedance.sdk.djx.core.business.web;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.ImageView;
import com.bytedance.sdk.djx.core.util.RomUtils;
import com.bytedance.sdk.djx.utils.LG;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class WebViewTweaker {
    private static final String BLANK_URL = "about:blank";
    private static final boolean HACK_WEBCORE_HANDLER = true;
    static final String TAG = "WebViewTweaker";
    private static final HashSet<String> sDeviceSet;
    private static final HashSet<String> sDeviceSetZte;
    private static final boolean sIsBuggyMIUI;
    private static final boolean sIsNeedLoadBlank;
    private static Handler sProxyHandler;
    private static int sTweakWebviewBug;
    private static int sTweakWebviewDeviceMotion;
    private static int sTweakWebviewDrawingCache;

    static {
        sIsBuggyMIUI = Build.VERSION.SDK_INT >= 16 && RomUtils.isMiui();
        sIsNeedLoadBlank = isNeedLoadBlankWhenDestroy();
        sTweakWebviewBug = -1;
        sTweakWebviewDeviceMotion = -1;
        sTweakWebviewDrawingCache = -1;
        sProxyHandler = null;
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("HUAWEI C8812");
        hashSet.add("HUAWEI C8812E");
        hashSet.add("HUAWEI C8825D");
        hashSet.add("HUAWEI U8825D");
        hashSet.add("HUAWEI C8950D");
        hashSet.add("HUAWEI U8950D");
        sDeviceSet = hashSet;
        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("ZTE V955");
        hashSet2.add("ZTE N881E");
        hashSet2.add("ZTE N881F");
        hashSet2.add("ZTE N880G");
        hashSet2.add("ZTE N880F");
        hashSet2.add("ZTE V889F");
        sDeviceSetZte = hashSet2;
    }

    public static void tryTweakWebCoreHandler(boolean z, boolean z2, boolean z3) {
        try {
            if (sProxyHandler != null) {
                return;
            }
            boolean z4 = true;
            boolean z5 = false;
            if (Build.VERSION.SDK_INT == 15 && (z3 || ((z && sDeviceSet.contains(Build.MODEL)) || (z2 && sDeviceSetZte.contains(Build.MODEL))))) {
                z5 = true;
            }
            int i = sTweakWebviewDeviceMotion;
            if (i <= 0 && (i >= 0 || !sIsBuggyMIUI)) {
                z4 = z5;
            }
            if (z4) {
                tweakWebCoreHandle();
            }
        } catch (Throwable unused) {
        }
    }

    private static void tweakWebCoreHandle() {
        Field declaredField;
        Object obj;
        if (sProxyHandler != null) {
            return;
        }
        try {
            declaredField = Class.forName("android.webkit.WebViewCore").getDeclaredField("sWebCoreHandler");
            declaredField.setAccessible(true);
            obj = declaredField.get(null);
        } catch (Throwable unused) {
        }
        if (obj == null) {
            return;
        }
        if (!(obj instanceof Handler)) {
            sProxyHandler = new Handler();
            return;
        }
        Method declaredMethod = Handler.class.getDeclaredMethod("getIMessenger", null);
        declaredMethod.setAccessible(true);
        Object objInvoke = declaredMethod.invoke(obj, null);
        sProxyHandler = new WebCoreProxyHandler((Handler) obj);
        if (objInvoke != null) {
            Field declaredField2 = Handler.class.getDeclaredField("mMessenger");
            declaredField2.setAccessible(true);
            declaredField2.set(sProxyHandler, objInvoke);
        }
        declaredField.set(null, sProxyHandler);
        if (sProxyHandler == null) {
            sProxyHandler = new Handler();
        }
    }

    private static class WebCoreProxyHandler extends Handler {
        final Handler handler;

        public WebCoreProxyHandler(Handler handler) {
            super(handler.getLooper());
            this.handler = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                this.handler.handleMessage(message);
            } catch (Throwable th) {
                LG.w("WebCoreProxyHandler", "handleMessage exception: " + th);
            }
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Throwable th) {
                LG.w("WebCoreProxyHandler", "dispatchMessage exception: " + th);
            }
        }
    }

    public static void setTweakWebviewBug(int i) {
        sTweakWebviewBug = i;
    }

    public static void setTweakWebviewDeviceMotion(int i) {
        sTweakWebviewDeviceMotion = i;
    }

    public static void setTweakWebviewDrawingCache(int i) {
        sTweakWebviewDrawingCache = i;
    }

    public static void tweakPauseIfFinishing(Context context, WebView webView) {
        if (context == null || webView == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing()) {
            try {
                webView.loadUrl("about:blank");
                if (sTweakWebviewDrawingCache > 0) {
                    View rootView = webView.getRootView();
                    if (rootView instanceof ViewGroup) {
                        View childAt = ((ViewGroup) rootView).getChildAt(0);
                        childAt.setDrawingCacheEnabled(true);
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(childAt.getDrawingCache());
                        childAt.setDrawingCacheEnabled(false);
                        ImageView imageView = new ImageView(activity);
                        imageView.setImageBitmap(bitmapCreateBitmap);
                        imageView.setVisibility(0);
                        ((ViewGroup) rootView).addView(imageView, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private static boolean isNeedLoadBlankWhenDestroy() {
        return sIsBuggyMIUI || (Build.VERSION.SDK_INT == 16 && "ZTE N5".equals(Build.MODEL));
    }

    public static void clearWebviewOnDestroy(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.setWebChromeClient(null);
        webView.setWebViewClient(null);
        ViewParent parent = webView.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(webView);
        }
        webView.removeAllViews();
        try {
            webView.destroy();
        } catch (Throwable unused) {
        }
    }
}
