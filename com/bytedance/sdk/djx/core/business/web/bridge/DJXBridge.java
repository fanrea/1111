package com.bytedance.sdk.djx.core.business.web.bridge;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.t.a;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.business.UserInfoHelper;
import com.bytedance.sdk.djx.core.log.PartnerHelper;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.utils.Encrypt;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.TimeDiff;
import com.bytedance.sdk.djx.utils.WeakHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXBridge implements IJsBridge, WeakHandler.IHandler {
    private static final String NAME_SPACE = "DJXBridgeSdk";
    private static final String TAG = "DJXBridge";
    private static final int WHAT_MSG_JS_CALL = 1024;
    private static final int WHAT_MSG_JS_SEND = 1025;
    private WeakHandler mHandler;
    private boolean mIsRelease = false;
    private final Map<String, List<Js2JavaMsg>> mJsListener = new ConcurrentHashMap();
    private IBridgeListener mListener;
    private WebView mWebView;

    @Override // com.bytedance.sdk.djx.core.business.web.bridge.IJsBridge
    @JavascriptInterface
    public String version() {
        return "2.9.0.2";
    }

    public static DJXBridge inject(WebView webView) {
        return new DJXBridge(webView);
    }

    private DJXBridge(WebView webView) {
        this.mWebView = webView;
        init();
    }

    private void init() {
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.mWebView.addJavascriptInterface(this, NAME_SPACE);
    }

    public DJXBridge setListener(IBridgeListener iBridgeListener) {
        this.mListener = iBridgeListener;
        return this;
    }

    @Override // com.bytedance.sdk.djx.core.business.web.bridge.IJsBridge
    @JavascriptInterface
    public void invoke(String str) {
        Js2JavaMsg rVar;
        LG.d(TAG, "invoke: " + str);
        if (this.mIsRelease || (rVar = Js2JavaMsg.parser(str)) == null || !rVar.isOk()) {
            return;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1024, rVar));
    }

    @Override // com.bytedance.sdk.djx.core.business.web.bridge.IJsBridge
    @JavascriptInterface
    public void on(String str) {
        Js2JavaMsg rVar;
        LG.d(TAG, "on: " + str);
        if (this.mIsRelease || (rVar = Js2JavaMsg.parser(str)) == null || !rVar.isOk()) {
            return;
        }
        List<Js2JavaMsg> copyOnWriteArrayList = this.mJsListener.get(rVar.func);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.mJsListener.put(rVar.func, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(rVar);
        IBridgeListener iBridgeListener = this.mListener;
        if (iBridgeListener != null) {
            iBridgeListener.onJsOn(rVar.func, rVar);
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.web.bridge.IJsBridge
    public void send(String str) {
        if (this.mIsRelease || TextUtils.isEmpty(str)) {
            return;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1025, str));
    }

    @Override // com.bytedance.sdk.djx.core.business.web.bridge.IJsBridge
    public void sendOn(String str, Java2jsMsg java2jsMsg) {
        List<Js2JavaMsg> list;
        if (this.mIsRelease || TextUtils.isEmpty(str) || java2jsMsg == null || (list = this.mJsListener.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator<Js2JavaMsg> it = list.iterator();
        while (it.hasNext()) {
            java2jsMsg.setCallbackId(it.next().callbackId);
            send(java2jsMsg.toJsonString());
        }
    }

    @Override // com.bytedance.sdk.djx.core.business.web.bridge.IJsBridge
    public void release() {
        this.mIsRelease = true;
        Map<String, List<Js2JavaMsg>> map = this.mJsListener;
        if (map != null) {
            map.clear();
        }
        WeakHandler weakHandler = this.mHandler;
        if (weakHandler != null) {
            weakHandler.removeCallbacksAndMessages((Object) null);
        }
        this.mWebView = null;
    }

    public void handleMsg(Message message) {
        if (this.mIsRelease || message == null) {
            return;
        }
        if (message.what == 1024) {
            if (message.obj instanceof Js2JavaMsg) {
                try {
                    handleJsMsg((Js2JavaMsg) message.obj);
                    return;
                } catch (Throwable th) {
                    LG.d(TAG, "invoke maybe error: ", th);
                    return;
                }
            }
            return;
        }
        if (message.what == 1025 && (message.obj instanceof String)) {
            try {
                handleSendJs((String) message.obj);
            } catch (Throwable th2) {
                LG.d(TAG, "send js maybe error: ", th2);
            }
        }
    }

    private void handleJsMsg(Js2JavaMsg js2JavaMsg) {
        if (js2JavaMsg == null || !js2JavaMsg.isOk()) {
            return;
        }
        if (IFunc.IVK_VERSION.equals(js2JavaMsg.func)) {
            Java2jsMsg.create().setCallbackId(js2JavaMsg.callbackId).putParam(Config.INPUT_DEF_VERSION, "2.9.0.2").send(this);
        } else if (IFunc.IVK_GET_ACCOUNT_INFO.equals(js2JavaMsg.func)) {
            Java2jsMsg.create().setCallbackId(js2JavaMsg.callbackId).putParam("a_t", TokenHelper.getInstance().getToken()).send(this);
        } else if (IFunc.IVK_COMMENT_REQUEST_PARAMS.equals(js2JavaMsg.func)) {
            String strNonce = Encrypt.nonce();
            String strValueOf = String.valueOf(TimeDiff.getInstance().getServerTime() / 1000);
            Java2jsMsg.create().setCallbackId(js2JavaMsg.callbackId).putParam("access_token", TokenHelper.getInstance().getToken()).putParam("signature", Encrypt.sign(new String[]{strNonce, DevInfo.sSecureKey, strValueOf})).putParam(a.k, strValueOf).putParam("nonce", strNonce).putParam(b.z0, PartnerHelper.getPartner(null)).putParam("siteid", PartnerHelper.getSiteId()).putParam("sdk_version", "2.9.0.2").send(this);
        } else if (IFunc.IVK_GET_USER_INFO.equals(js2JavaMsg.func)) {
            long j = JSON.getLong(js2JavaMsg.params, a.k, 0L);
            Java2jsMsg.create().setCallbackId(js2JavaMsg.callbackId).putParam("user_avatar", UserInfoHelper.getInstance().getAvatar(Long.valueOf(j))).putParam("user_name", UserInfoHelper.getInstance().getUserName(Long.valueOf(j))).send(this);
        }
        IBridgeListener iBridgeListener = this.mListener;
        if (iBridgeListener != null) {
            iBridgeListener.onJsInvoke(js2JavaMsg.func, js2JavaMsg);
        }
    }

    private void handleSendJs(String str) {
        WebView webView = this.mWebView;
        if (webView != null) {
            try {
                String str2 = "javascript:DpSdk2JSBridge._handleMessageFromApp(" + str + ")";
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript(str2, null);
                } else {
                    webView.loadUrl(str2);
                }
                LG.d(TAG, "send js msg: " + str2);
            } catch (Throwable th) {
                LG.d(TAG, "send js msg error: ", th);
            }
        }
    }
}
