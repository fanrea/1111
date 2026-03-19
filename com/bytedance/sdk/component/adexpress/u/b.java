package com.bytedance.sdk.component.adexpress.u;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private WeakReference<hc> d;

    public b(hc hcVar) {
        this.d = new WeakReference<>(hcVar);
    }

    public void d(hc hcVar) {
        if (hcVar == null) {
            this.d = null;
        } else {
            this.d = new WeakReference<>(hcVar);
        }
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<hc> weakReference = this.d;
        return (weakReference == null || weakReference.get() == null) ? "" : this.d.get().adInfo();
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<hc> weakReference = this.d;
        return (weakReference == null || weakReference.get() == null) ? "" : this.d.get().appInfo();
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<hc> weakReference = this.d;
        return (weakReference == null || weakReference.get() == null) ? "" : this.d.get().getTemplateInfo();
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<hc> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<hc> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().adAnalysisData(str);
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<hc> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().muteVideo(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<hc> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<hc> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<hc> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().clickEvent(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<hc> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().skipVideo();
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<hc> weakReference = this.d;
        return (weakReference == null || weakReference.get() == null) ? "" : this.d.get().getCurrentVideoState();
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<hc> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().initRenderFinish();
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<hc> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().requestPauseVideo(str);
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<hc> weakReference = this.d;
        return (weakReference == null || weakReference.get() == null) ? "" : this.d.get().getData(str);
    }
}
