package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.uo.hc;
import com.bytedance.sdk.component.utils.gb;
import com.bytedance.sdk.component.utils.mq;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BaseWebView extends WebView {
    protected View.OnScrollChangeListener an;
    protected WebChromeClient b;
    protected DownloadListener c;
    protected String cb;
    protected Map<String, d> d;
    protected Boolean de;
    protected Integer e;
    protected Boolean gb;
    protected Boolean h;
    protected com.bytedance.sdk.component.widget.hc hc;
    protected Boolean he;
    protected hc.d j;
    protected Boolean jh;
    protected Integer k;
    protected Boolean mk;
    protected Boolean mq;
    protected Boolean np;
    protected Boolean rf;
    protected Boolean sy;
    protected Boolean tc;
    protected Boolean tt;
    protected Integer u;
    protected Boolean uo;
    protected Boolean v;
    protected Boolean vv;
    protected Boolean w;
    protected Integer yi;
    protected WebSettings.LayoutAlgorithm yo;
    protected Boolean zw;

    public hc.d getOnTouchEventListener() {
        return this.j;
    }

    public Map<String, d> getJavascriptInterfaces() {
        return this.d;
    }

    public com.bytedance.sdk.component.widget.hc getClient() {
        return this.hc;
    }

    public WebChromeClient getChromeClient() {
        return this.b;
    }

    public View.OnScrollChangeListener getOnScrollChangeListener() {
        return this.an;
    }

    public Boolean getMediaPlaybackRequiresUserGesture() {
        return this.h;
    }

    public Boolean getSavePassword() {
        return this.gb;
    }

    public Boolean getAllowUniversalAccessFromFileURLs() {
        return this.tt;
    }

    public Boolean getAllowFileAccessFromFileURLs() {
        return this.tc;
    }

    public Boolean getBlockNetworkImage() {
        return this.mk;
    }

    public Boolean getAllowFileAccess() {
        return this.mq;
    }

    public Boolean getDatabaseEnabled() {
        return this.uo;
    }

    public Integer getMixedContentMode() {
        return this.k;
    }

    public Integer getDefaultFontSize() {
        return this.e;
    }

    public String getDefaultTextEncodingName() {
        return this.cb;
    }

    public Boolean getLoadWithOverviewMod() {
        return this.w;
    }

    public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
        return this.yo;
    }

    public Boolean getBuiltInZoomControls() {
        return this.rf;
    }

    public Boolean getDomStorageEnabled() {
        return this.jh;
    }

    public Boolean getJavaScriptCanOpenWindowsAutomatically() {
        return this.sy;
    }

    public Boolean getSupportZoom() {
        return this.de;
    }

    public Boolean getUseWideViewPort() {
        return this.v;
    }

    public Boolean getAppCacheEnabled() {
        return this.np;
    }

    public Integer getCacheMode() {
        return this.yi;
    }

    public Boolean getDisplayZoomControls() {
        return this.he;
    }

    public Boolean getJavaScriptEnabled() {
        return this.vv;
    }

    public Boolean getNetworkAvailable() {
        return this.zw;
    }

    public BaseWebView(Context context) {
        super(context);
        this.an = null;
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.an = null;
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.an = null;
    }

    protected void d(Runnable runnable) {
        if (d()) {
            runnable.run();
        } else {
            gb.hc().post(runnable);
        }
    }

    protected boolean d() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public DownloadListener getDownloadListener() {
        return this.c;
    }

    public Integer getBackgroundColor() {
        return this.u;
    }

    public void hc() {
        this.d = null;
        this.hc = null;
        this.b = null;
        this.c = null;
        this.an = null;
        this.u = null;
        this.h = null;
        this.gb = null;
        this.tt = null;
        this.tc = null;
        this.mk = null;
        this.mq = null;
        this.uo = null;
        this.k = null;
        this.e = null;
        this.cb = null;
        this.w = null;
        this.yo = null;
        this.rf = null;
        this.jh = null;
        this.sy = null;
        this.de = null;
        this.v = null;
        this.np = null;
        this.yi = null;
        this.he = null;
        this.vv = null;
        this.zw = null;
        this.j = null;
    }

    @Override // android.webkit.WebView
    public void destroy() {
        hc();
        super.destroy();
    }

    public void d(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", TextureRenderKeys.KEY_IS_CALLBACK);
            jSONObject2.putOpt("__callback_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            d(str, jSONObject2);
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    public void hc(String str, String str2, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("__msg_type", NotificationCompat.CATEGORY_EVENT);
            jSONObject2.putOpt("__event_id", str2);
            jSONObject2.putOpt("__params", jSONObject);
            d(str, jSONObject2);
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private void d(String str, JSONObject jSONObject) {
        String str2 = "javascript:" + str + "._handleMessageFromToutiao(" + jSONObject + ")";
        if (Build.VERSION.SDK_INT >= 19) {
            evaluateJavascript(str2, null);
        } else {
            loadUrl(str2);
        }
    }
}
