package com.baidu.mobads.container.landingpage;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.baidu.mobads.container.landingpage.App2Activity;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class b extends WebChromeClient {
    final /* synthetic */ App2Activity.b a;
    final /* synthetic */ App2Activity b;

    b(App2Activity app2Activity, App2Activity.b bVar) {
        this.b = app2Activity;
        this.a = bVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        int i;
        super.onReceivedTitle(webView, str);
        if (this.b.actionBar != null && this.b.mIsShowActionBarTit) {
            this.b.actionBar.a(str);
        }
        if (this.b.isNeedLpKeyboardOptimize() && this.b.mIsNeedInjectKeyboardOptimizeJS) {
            if (this.b.mKeyboardOptimizeJsUtils == null) {
                this.b.mKeyboardOptimizeJsUtils = new com.baidu.mobads.container.bridge.am();
            }
            if (this.b.mVideoHeight <= 0) {
                i = 0;
            } else {
                i = 1;
            }
            this.b.executeJavaScript(this.b.mKeyboardOptimizeJsUtils.a(i));
            this.b.executeJavaScript(this.b.mKeyboardOptimizeJsUtils.a());
            this.b.mIsNeedInjectKeyboardOptimizeJS = false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        if (this.a != null) {
            this.a.a(i);
            if (i > 50) {
                this.b.disposeAnimation();
                this.a.setVisibility(i >= 100 ? 4 : 0);
            }
        }
        if (70 < i && !this.b.isRecordLpLoad) {
            this.b.stateEvent(com.baidu.mobads.container.components.h.a.EVENT_LP_PAGE_LOADED);
            this.b.stateEvent(com.baidu.mobads.container.components.h.b.k);
            this.b.isRecordLpLoad = true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        try {
            return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        } catch (Exception e) {
            return super.getDefaultVideoPoster();
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) throws JSONException {
        if (this.b.mProxyActivity != null) {
            if (!this.b.mIsThemeTranslucent) {
                this.b.mProxyActivity.setRequestedOrientation(0);
                this.b.mIsFullScreenVideo = true;
            }
            if (this.b.mFullScreenView == null) {
                if (this.b.mRlContainer != null) {
                    this.b.mRlContainer.setVisibility(8);
                }
                if (this.b.mFullScreenViewParent == null) {
                    this.b.mFullScreenViewParent = new FrameLayout(this.b.mProxyActivity);
                    this.b.mFullScreenViewParent.setBackgroundColor(-16777216);
                    this.b.wvTool.addView(this.b.mFullScreenViewParent);
                }
                this.b.mCustomViewCallback = customViewCallback;
                this.b.mFullScreenViewParent.addView(this.b.mFullScreenView = view);
                this.b.mFullScreenView.setKeepScreenOn(true);
                this.b.addFullScreenBackButton();
                this.b.mFullScreenViewParent.setVisibility(0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("act", "voriention0");
                    com.baidu.mobads.container.activity.d.a().a(this.b.mProxyActivity, jSONObject.toString());
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            customViewCallback.onCustomViewHidden();
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() throws JSONException {
        this.b.hideCustomView();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("act", "voriention1");
            com.baidu.mobads.container.activity.d.a().a(this.b.mProxyActivity, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
