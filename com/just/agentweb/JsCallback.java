package com.just.agentweb;

import android.util.Log;
import android.webkit.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class JsCallback {
    private static final String CALLBACK_JS_FORMAT = "javascript:%s.callback(%d, %d %s);";
    private boolean mCouldGoOn = true;
    private int mIndex;
    private String mInjectedName;
    private int mIsPermanent;
    private WeakReference<WebView> mWebViewRef;

    public static class JsCallbackException extends Exception {
        public JsCallbackException(String str) {
            super(str);
        }
    }

    public JsCallback(WebView webView, String str, int i) {
        this.mWebViewRef = new WeakReference<>(webView);
        this.mInjectedName = str;
        this.mIndex = i;
    }

    private boolean isJavaScriptObject(Object obj) {
        if ((obj instanceof JSONObject) || (obj instanceof JSONArray)) {
            return true;
        }
        String string = obj.toString();
        try {
            try {
                new JSONObject(string);
            } catch (JSONException unused) {
                return false;
            }
        } catch (JSONException unused2) {
            new JSONArray(string);
        }
        return true;
    }

    public void apply(Object... objArr) throws JsCallbackException {
        if (this.mWebViewRef.get() == null) {
            throw new JsCallbackException("the WebView related to the JsCallback has been recycled");
        }
        if (!this.mCouldGoOn) {
            throw new JsCallbackException("the JsCallback isn't permanent,cannot be called more than once");
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(",");
            boolean z = obj instanceof String;
            boolean zIsJavaScriptObject = isJavaScriptObject(obj);
            if (z && !zIsJavaScriptObject) {
                sb.append("\"");
            }
            sb.append(String.valueOf(obj));
            if (z && !zIsJavaScriptObject) {
                sb.append("\"");
            }
        }
        String str = String.format(CALLBACK_JS_FORMAT, this.mInjectedName, Integer.valueOf(this.mIndex), Integer.valueOf(this.mIsPermanent), sb.toString());
        if (LogUtils.isDebug()) {
            Log.d("JsCallBack", str);
        }
        this.mWebViewRef.get().loadUrl(str);
        this.mCouldGoOn = this.mIsPermanent > 0;
    }

    public void setPermanent(boolean z) {
        this.mIsPermanent = z ? 1 : 0;
    }
}
