package com.just.agentweb;

import android.webkit.WebView;
import com.just.agentweb.AgentWeb;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class JsInterfaceHolderImpl extends JsBaseInterfaceHolder {
    private static final String TAG = "JsInterfaceHolderImpl";
    private AgentWeb.SecurityType mSecurityType;
    private WebCreator mWebCreator;
    private WebView mWebView;

    JsInterfaceHolderImpl(WebCreator webCreator, AgentWeb.SecurityType securityType) {
        super(webCreator, securityType);
        this.mWebCreator = webCreator;
        this.mWebView = webCreator.getWebView();
        this.mSecurityType = securityType;
    }

    private JsInterfaceHolder addJavaObjectDirect(String str, Object obj) {
        LogUtils.i(TAG, "k:" + str + "  v:" + obj);
        this.mWebView.addJavascriptInterface(obj, str);
        return this;
    }

    static JsInterfaceHolderImpl getJsInterfaceHolder(WebCreator webCreator, AgentWeb.SecurityType securityType) {
        return new JsInterfaceHolderImpl(webCreator, securityType);
    }

    @Override // com.just.agentweb.JsInterfaceHolder
    public JsInterfaceHolder addJavaObject(String str, Object obj) {
        if (!checkSecurity()) {
            return this;
        }
        if (!checkObject(obj)) {
            throw new JsInterfaceObjectException("this object has not offer method javascript to call , please check addJavascriptInterface annotation was be added");
        }
        addJavaObjectDirect(str, obj);
        return this;
    }

    @Override // com.just.agentweb.JsInterfaceHolder
    public JsInterfaceHolder addJavaObjects(Map<String, Object> map) {
        if (!checkSecurity()) {
            LogUtils.e(TAG, "The injected object is not safe, give up injection");
            return this;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (!checkObject(value)) {
                throw new JsInterfaceObjectException("This object has not offer method javascript to call ,please check addJavascriptInterface annotation was be added");
            }
            addJavaObjectDirect(entry.getKey(), value);
        }
        return this;
    }
}
