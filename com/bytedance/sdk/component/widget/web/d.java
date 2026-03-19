package com.bytedance.sdk.component.widget.web;

import android.webkit.JavascriptInterface;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d {
    private final Object d;
    private final String hc;

    public d(Object obj, String str) {
        this.d = obj;
        this.hc = str;
    }

    public Object d() {
        return this.d;
    }

    public String hc() {
        return this.hc;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022 A[Catch: Exception -> 0x0039, TryCatch #0 {Exception -> 0x0039, blocks: (B:4:0x0003, B:6:0x0006, B:7:0x0009, B:9:0x000c, B:10:0x0017, B:12:0x002e, B:11:0x0022), top: B:17:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object d(java.lang.String r4, java.lang.Object... r5) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            r3 = this;
            r0 = 0
            if (r5 == 0) goto L22
            int r1 = r5.length     // Catch: java.lang.Exception -> L39
            if (r1 <= 0) goto L22
            int r1 = r5.length     // Catch: java.lang.Exception -> L39
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L39
        L9:
            int r2 = r5.length     // Catch: java.lang.Exception -> L39
            if (r0 >= r2) goto L17
            r2 = r5[r0]     // Catch: java.lang.Exception -> L39
            java.lang.Class r2 = r2.getClass()     // Catch: java.lang.Exception -> L39
            r1[r0] = r2     // Catch: java.lang.Exception -> L39
            int r0 = r0 + 1
            goto L9
        L17:
            java.lang.Object r0 = r3.d     // Catch: java.lang.Exception -> L39
            java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Exception -> L39
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r4, r1)     // Catch: java.lang.Exception -> L39
            goto L2e
        L22:
            java.lang.Object r1 = r3.d     // Catch: java.lang.Exception -> L39
            java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Exception -> L39
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> L39
            java.lang.reflect.Method r0 = r1.getDeclaredMethod(r4, r0)     // Catch: java.lang.Exception -> L39
        L2e:
            r1 = 1
            r0.setAccessible(r1)     // Catch: java.lang.Exception -> L39
            java.lang.Object r1 = r3.d     // Catch: java.lang.Exception -> L39
            java.lang.Object r4 = r0.invoke(r1, r5)     // Catch: java.lang.Exception -> L39
            return r4
        L39:
            r5 = move-exception
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r0 = "invokeMethod name= "
            java.lang.String r4 = r0.concat(r4)
            java.lang.String r0 = "JavascriptInterfaceProxy"
            com.bytedance.sdk.component.utils.mq.hc(r0, r4, r5)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.widget.web.d.d(java.lang.String, java.lang.Object[]):java.lang.Object");
    }

    @JavascriptInterface
    public Object invokeMethod(String str) {
        return d("invokeMethod", str);
    }

    @JavascriptInterface
    public String adInfo() throws NoSuchMethodException, SecurityException {
        Object objD = d("adInfo", new Object[0]);
        return objD != null ? objD.toString() : "";
    }

    @JavascriptInterface
    public String appInfo() throws NoSuchMethodException, SecurityException {
        Object objD = d("appInfo", new Object[0]);
        return objD != null ? objD.toString() : "";
    }

    @JavascriptInterface
    public String getTemplateInfo() throws NoSuchMethodException, SecurityException {
        Object objD = d("getTemplateInfo", new Object[0]);
        return objD != null ? objD.toString() : "";
    }

    @JavascriptInterface
    public void renderDidFinish(String str) throws NoSuchMethodException, SecurityException {
        d("renderDidFinish", str);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) throws NoSuchMethodException, SecurityException {
        d("adAnalysisData", str);
    }

    @JavascriptInterface
    public void muteVideo(String str) throws NoSuchMethodException, SecurityException {
        d("muteVideo", str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) throws NoSuchMethodException, SecurityException {
        d("dynamicTrack", str);
    }

    @JavascriptInterface
    public void changeVideoState(String str) throws NoSuchMethodException, SecurityException {
        d("changeVideoState", str);
    }

    @JavascriptInterface
    public void clickEvent(String str) throws NoSuchMethodException, SecurityException {
        d("clickEvent", str);
    }

    @JavascriptInterface
    public void skipVideo() throws NoSuchMethodException, SecurityException {
        d("skipVideo", new Object[0]);
    }

    @JavascriptInterface
    public String getCurrentVideoState() throws NoSuchMethodException, SecurityException {
        Object objD = d("getCurrentVideoState", new Object[0]);
        return objD != null ? objD.toString() : "";
    }

    @JavascriptInterface
    public void initRenderFinish() throws NoSuchMethodException, SecurityException {
        d("initRenderFinish", new Object[0]);
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) throws NoSuchMethodException, SecurityException {
        d("requestPauseVideo", str);
    }

    @JavascriptInterface
    public String getData(String str) throws NoSuchMethodException, SecurityException {
        Object objD = d("getData", str);
        return objD != null ? objD.toString() : "";
    }

    @JavascriptInterface
    public String sendNetworkSwitch(String str) throws NoSuchMethodException, SecurityException {
        Object objD = d("sendNetworkSwitch", str);
        return objD != null ? objD.toString() : "";
    }

    @JavascriptInterface
    public void readPercent(String str) throws NoSuchMethodException, SecurityException {
        d("readPercent", str);
    }

    @JavascriptInterface
    public void getUrl(String str) throws NoSuchMethodException, SecurityException {
        d("getUrl", str);
    }

    @JavascriptInterface
    public void readHtml(String str, String str2) throws NoSuchMethodException, SecurityException {
        d("readHtml", str, str2);
    }
}
